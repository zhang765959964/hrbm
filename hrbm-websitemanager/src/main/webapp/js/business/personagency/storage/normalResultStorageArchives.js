function refresh(){
	$("#storageArchivesList").jqGrid("setGridParam",{datatype: "json",url: CTX+'/business/personagency/storage/storage/listJson.xf'}).trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	$("#storageArchivesList").jqGrid("clearGridData");
	$("#storageArchivesList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}

//入库确认
function storeConfirm(){
	var row =$("#storageArchivesList").jqGrid("getGridParam","selarrrow");
	if(row&&row.length>0){
		var Ids="";
		$.each(row,function(i,e){
			if(i==0){
				Ids+=e;
			}else{
				Ids+=","+e;
			}
		});
		bootbox.confirm({message:'您确定要入库确认吗？',callback:function(r){
		    if (r){
		    	$.ajax({ url: CTX+'/business/personagency/storage/storage/storeConfirm.xf',
		    		data:{Ids:Ids},
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