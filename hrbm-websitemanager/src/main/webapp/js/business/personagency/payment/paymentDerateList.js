$(function(){
	
	$("#addPaymentRecord").on("click",function(){
		addPaymentRecord();
	})
	$("#delPaymentRecord").on("click",function(){
		delPaymentRecord();
	})
})

function addPaymentRecord(){
	var personId=$("#personId").val();
	if(!personId||personId=="0"){
		bootbox.alert('没有档案信息不能办理此业务');
		return;
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
				xfui.open_dialog({    
				    title: '个人费用减免',    
				    width: 1100,    
				    height: 600,    
				    closed: false,    
				    cache: false,    
				    url: CTX+"/business/personagency/payment/derate/add.xf?personId="+personId,
				    modal: true   
				})
			}

		} else {
			bootbox.alert("没有档案信息不能办理此业务！");
		}
	
	
	
}
function editPaymentRecord(){
	//var row = $('#paymentRecordList').bootstrapTable('getAllSelections');
	var rowid=$("#paymentRecordList").jqGrid("getGridParam","selrow");
	if(rowid){
		var pkId=rowid;
		xfui.open_dialog({    
	  		    title: '编辑扣减记录',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/payment/derate/edit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delPaymentRecord(){

	var pkId=$("#paymentRecordList").jqGrid("getGridParam","selrow");
	if(pkId){
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/payment/paymentYearDetail/del.xf',
		    		data:{id:pkId},
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
	$("#paymentRecordList").trigger("reloadGrid");
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	$("#paymentRecordList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
