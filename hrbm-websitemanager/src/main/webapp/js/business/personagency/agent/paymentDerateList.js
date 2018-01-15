


function delPaymentRecord(){

	var rowids=$("#paymentRecordList").jqGrid("getGridParam","selarrrow");
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
		    	$.ajax({ url: CTX+'/business/personagency/payment/derate/del.xf',
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
	$("#paymentRecordList").trigger("reloadGrid");
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	$("#paymentRecordList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
