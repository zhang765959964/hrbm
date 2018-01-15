$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	                   
	                   {name:'fdRefundStartDate',label:'退费开始日期',align:'center'},
	                   {name:'fdRefundEndDate',label:'退费结束日期',align:'center'},	                  
	                   {name:'fdRefundMonths',label:'退费月数',align:'center'},
	                   {name:'fdRefundStandard',label:'退费标准',align:'center'},
	                   {name:'fdRefundAmount',label:'退费金额',align:'center'},
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},
	                   {name:'fdRefundIsRefund',label:'退费标记',align:'center'},
	                   {name:'fdConfirmsName',label:'退费人',align:'center'},
	                   {name:'fdConfirmsDate',label:'退费日期',align:'center'},
	                {name:'pkId',label:'主键',hidden:true,width:100,key:true }
      	        	];
	var personId=$("#personId").val();
	$("#paymentRefundList").jqGrid({
		   url:CTX+'/business/personagency/payment/paymentRefund/listJson.xf?pkPersonId='+personId,
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "json",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           altRows:true,
           multiselect:false,
           autowidth: true,
           multiboxonly : true,
           rownumbers : true,
           height:'100%',
           onSelectRow :function(row,e){
      		   	var rowData = $("#paymentRefundList").jqGrid('getRowData',row);	
      		   	$("#paymentStatus").val(rowData.fdRefundIsRefund);
           }
           
	});
	$("#addPaymentRefund").on("click",function(){
		addPaymentRefund();
	})
	$("#editPaymentRefund").on("click",function(){
		editPaymentRefund();
	})
	$("#delPaymentRefund").on("click",function(){
		delPaymentRefund();
	})
})

function addPaymentRefund(){

	var personId=$("#personId").val();
	if(!personId||personId=='0'){
		bootbox.alert("没有档案信息不能办理此业务！");
		return ;
	}	 
	 if (personData) {
		if (personData.ARCHIVESTATUS == 2) {
			bootbox.alert("调出人员不能办理此业务")
		} else if (personData.ARCHIVESTATUS == 3) {
			bootbox.alert("死亡人员不能办理此业务")
		} else if (personData.ARCHIVEFLOWSTATUS == 1) {
			bootbox.alert("借阅登记不能办理此业务！");
		} else if (personData.ARCHIVEFLOWSTATUS == 2) {
			bootbox.alert("借阅确认不能办理此业务！");
		} else if (personData.ARCHIVEFLOWSTATUS == 3) {
			bootbox.alert("返还登记不能办理此业务！");
		} else if (personData.ARCHIVEFLOWSTATUS == 5) {
			bootbox.alert("调出登记不能办理此业务！");
		} else if (personData.ARCHIVERECEIVESTATUS != 2) {
			bootbox.alert("档案未入库不能办理此业务！");
		}else{
  			 $.ajax({
   		         type: "GET",
   		         url: CTX+"/business/personagency/payment/paymentRefund/isAllowAdd.xf",
   		         async: false,
   		         data: {personId:personId},
   		         dataType: "json" ,
   		         success:function(data){
   		        	if(data.result===1){
   		        		xfui.open_dialog({    
   		        		    title: '新增退费记录',    
   		        		    width: 970,    
   		        		    height: 400,    
   		        		    closed: false,    
   		        		    cache: false,    
   		        		    url: CTX+"/business/personagency/payment/paymentRefund/add.xf?personId="+personId,
   		        		    modal: true   
   		        		})
   		        	}else{
   		        		bootbox.alert(data.message);
   		        	}
   		        	 
   		         }
   		     });
		}

	} else {
		bootbox.alert("没有档案信息不能办理此业务！");
	}
		
}
function editPaymentRefund(){
	// var row = $('#paymentRefundList').bootstrapTable('getAllSelections');
	var rowid=$("#paymentRefundList").jqGrid("getGridParam","selrow");
	if(rowid){
		var paymentStatus = $("#paymentStatus").val();
		var pkId=rowid;
		
		if(paymentStatus=="已确认退费"){
			bootbox.alert('已确定退费不能修改此记录');
		}else{
			xfui.open_dialog({    
	  		    title: '登记退费',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/payment/paymentRefund/edit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
		}
		
	
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delPaymentRefund(){
	var rowid=$("#paymentRefundList").jqGrid("getGridParam","selrow");
	if(rowid){
		var paymentStatus = $("#paymentStatus").val();
		var pkId=rowid;
		
		if(paymentStatus=="已确认退费"){
			bootbox.alert('已确定退费不能删除此记录');
		}else{
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/payment/paymentRefund/del.xf',
			    		data:{pkId:pkId},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message); 	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			    			refresh();
			             }
			    	});
			    }    
			}}); 
		}
	}else{
		bootbox.alert('请选择记录');
	}			
}


function delPaymentRefundOld(){
	
	
	

	var rowids=$("#paymentRefundList").jqGrid("getGridParam","selarrrow");
	var paymentStatus = $("#paymentStatus").val();
	var pkId="";
	if(rowids&&rowids.length>0){
		$.each(rowids,function(i,e){
			if(i==0){
				pkId+=e;
			}else{
				pkId+=","+e;
			}
		});
		if(paymentStatus=="已确认退费"){
			bootbox.alert('已确定退费不能删除此记录');
		}else{
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/payment/paymentRefund/del.xf',
			    		data:{pkId:pkId},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message); 	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			    			refresh();
			             }
			    	});
			    }    
			}}); 
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 
function refresh(){
	$("#paymentRefundList").trigger("reloadGrid");
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	$("#paymentRefundList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'fdStartDate',label:'开始缴费日期',align:'center'},
	                   {name:'fdEndDate',label:'终止缴费日期',align:'center'},
	                   {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
	                   {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	                   
	                   {name:'fdPaymentType',label:'缴费类型',align:'center'},	                  
	                   {name:'fdPaymentStatus',label:'缴费状态',align:'center'},	                  
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},	                   
	                   {name:'pkId',label:'操作',hidden:true,width:100,key:true}
      	        	];
	var personId=$("#personId").val();
	$("#paymentRecordList").jqGrid({
           mtype: "GET",
		   url:CTX+'/business/personagency/payment/paymentRecord/listJson.xf?fkPersonId='+personId,
		   styleUI : 'Bootstrap',
           datatype: "json",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager1",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           multiselect:true,
           autowidth: true,
           autowidth: true,
           height:'100%'
       });
	
})




