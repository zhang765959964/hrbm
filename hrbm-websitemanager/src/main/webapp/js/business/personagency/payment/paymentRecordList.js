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
		bootbox.alert('没有档案编号不能办理此业务！');
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
			    title: '新增缴费记录',    
			    width: 960,    
			    height: 570,    
			    closed: false,    
			    cache: false,    
			    url: CTX+"/business/personagency/payment/paymentRecord/add.xf?personId="+personId,
			    modal: true   
			})
		}

	} else {
		bootbox.alert("没有档案编号不能办理此业务！");
	}
		
}
function editPaymentRecord(){
	// var row = $('#paymentRecordList').bootstrapTable('getAllSelections');
	var rowid=$("#paymentRecordList").jqGrid("getGridParam","selrow");
	if(rowid){
		var pkId=rowid;
		xfui.open_dialog({    
	  		    title: '编辑缴费记录',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/payment/paymentRecord/edit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delPaymentRecord(){

	var pkId=$("#paymentRecordList").jqGrid("getGridParam","selrow");
	if(pkId){
//		var pkId="";
		var flag=false;
//		$.each(rowids,function(i,e){
//			if(i==0){
//				pkId+=e;
//			}else{
//				pkId+=","+e;
//			}
//			
//			var fdPaymentStatus=$("#paymentRecordList").jqGrid("getCell",e,"fdPaymentStatus");
//			if(fdPaymentStatus=="已缴"){
//				flag=true;
//			}
//		});
		var fdPaymentStatus=$("#paymentRecordList").jqGrid("getCell",pkId,"fdPaymentStatus");
//		if(fdPaymentStatus=="已缴"){
//			flag=true;
//		}
//		if(flag){
//			bootbox.alert("不能删除已缴费记录");
//			return;
//		}
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
