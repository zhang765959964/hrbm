function delProxyManual(){
		var row =$("#proxyManualList").jqGrid("getGridParam","selarrrow");
		if(row&&row.length>0){
			var pmId="";
			$.each(row,function(i,e){
				if(i==0){
					pmId+=e;
				}else{
					pmId+=","+e;
				}
			});
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
			    if (r){
			    	$.ajax({ url: CTX+'/business/personagency/receive/proxyManual/del.xf',
			    		data:{pmId:pmId},
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
	
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		$("#proxyManualList").jqGrid("clearGridData");	
		$("#proxyManualList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
	}
	
	