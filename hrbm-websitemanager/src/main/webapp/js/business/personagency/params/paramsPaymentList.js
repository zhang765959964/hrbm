$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'fdStartdate',label:'标准执行开始年月',align:'center'},
	                   {name:'fdEnddate',label:'标准执行结束年月',align:'center'},
	                   {name:'fdStandard',label:'缴费标准',align:'center'},
	                   {name:'fdDiscountStandard',label:'持优惠证标准',align:'center'},
// 	                   {name:'fkCreaterId',label:'经办人ID',align:'center'},
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
// 	                   {name:'fkCreaterOrgId',label:'经办机构ID',align:'center'},
	                   {name:'pkId',label:'主键',hidden:true,width:100,key:true }
      	        	];
	$("#paramsPaymentList").jqGrid({
		   url:CTX+'/business/personagency/params/paramsPayment/listJson.xf',
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
           altRows:true,
           multiselect:true,
           autowidth: true,
           height:'100%'
       });
})

function addParamsPayment(){	
		xfui.open_dialog({    
		    title: '新增缴费标准',    
		    width: 800,    
		    height: 350,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/params/paramsPayment/add.xf",
		    modal: true   
		})
}
function editParamsPayment(){
	//var row = $('#paramsPaymentList').bootstrapTable('getAllSelections');
	var rowid=$("#paramsPaymentList").jqGrid("getGridParam","selrow");
	if(rowid){
		var pkId=rowid;
		xfui.open_dialog({    
	  		    title: '编辑缴费标准',    
	  		    width: 800,    
	  		    height: 350,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/params/paramsPayment/edit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delParamsPayment(){

	var rowids=$("#paramsPaymentList").jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var pkId="";
		$.each(rowids,function(i,e){
			if(i==0){
				pkId+=e;
			}else{
				pkId+=","+e;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/params/paramsPayment/del.xf',
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
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 
function refresh(){
	$("#paramsPaymentList").trigger("reloadGrid");
}
function doSearch(){
	$("#paramsPaymentList").jqGrid("clearGridData");
	var json=$("#searchForm").serializeJson();
	$("#paramsPaymentList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}