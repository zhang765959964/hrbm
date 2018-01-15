

$(function(){
	initPaymentTable();
})
function initPaymentTable(){
	var fkCorpRecordId=$("#pkId").val();
	var columns= [	   {name:'archiveCode',label:'档案编号',align:'center'},
	              	   {name:'contractCode',label:'合同编号',align:'center'},	              	 
	              	   {name:'aac003',label:'姓名',align:'center'},
	              	   {name:'aac002',label:'身份证号',align:'center'},
	              	   {name:'genderName',label:'性别',align:'center'},
	              	   {name:'archiveStatusName',label:'档案状态',align:'center'},              	 
	              	   {name:'archiveTypeName',label:'存档类型',align:'center'},	 	              	 
	              	   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
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
	$("#paymentRecordList").jqGrid({
		   url:CTX+'/business/personagency/payment/paymentRecord/listCorpJson.xf?fkCorpRecordId='+fkCorpRecordId,
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
           shrinkToFit: false,
           //multiselect:true,
           autowidth: true,
           height:'100%'
       });
	
}
//可以去掉，不再使用了!
function receiveMutiPayment(){
   var  pkId=$("#pkId").val();
   var rowids=$("#paymentRecordList").jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var personPkIds="";
		$.each(rowids,function(i,e){
			if(i==0){
				personPkIds+=e;
			}else{
				personPkIds+=","+e;
			}
			
		});
		bootbox.confirm({message:'您确认想要实收记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/payment/paymentCorpRecord/receiveMutiPayment.xf?personPkIds='+personPkIds+'&pkId='+pkId,
		    		data:{pkId:pkId},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message); 	
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		    			
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }	
	
}
function receiveAllPayment(){
	var  pkId=$("#pkId").val();
	$.ajax({ url: CTX+'/business/personagency/payment/paymentCorpRecord/receiveAllPayment.xf?pkId='+pkId,
		data:{pkId:pkId},
		dataType:'json',
		success: function(data){
			if(data.message){
				bootbox.alert({message:data.message,callback:function(){
					var parentIframe=xfui.getParentIframe();
			    	if(parentIframe){
			    		parentIframe.refresh();
			    	}
                	xfui.closeDialog(); 
				}}); 	
			}else{
				bootbox.alert("未知错误"); 
			}
			
         }
	});
}
