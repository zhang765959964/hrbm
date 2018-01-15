$(function(){
	initDataExp();
})
function doSearch(){
	var json=$("#searchForm").serializeJson();
	$("#archiveRegisterCheckout").jqGrid("clearGridData");	
	$("#archiveRegisterCheckout").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}

//删除借阅记录
function delRegisterCheckout(){
	var row=$("#archiveRegisterCheckout").jqGrid("getGridParam","selrow");
	var rowData = $("#archiveRegisterCheckout").jqGrid('getRowData',row);
	var aa= rowData.checkoutStatus;
	if(row&&row.length>0){
		var id= row + "";
		if(aa==1){
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
			    if (r){
			    	$.ajax({ url: CTX+'/business/personagency/archive/archiveCheckout/del.xf',
			    		data:{id:id},
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
			bootbox.alert('当前记录不是借阅登记状态，不能删除！');
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }
}

//返还登记
function addReturnRegisterCheckout(){
	var row=$("#archiveRegisterCheckout").jqGrid("getGridParam","selrow");
	var rowData = $("#archiveRegisterCheckout").jqGrid('getRowData',row);
	var aa= rowData.checkoutStatus;
	if(row&&row.length>0){
		var id= row + "";
		if(aa==2){
			bootbox.confirm({message:'您确认想要返还登记吗？',callback:function(r){
			    if (r){
			    	$.ajax({ url: CTX+'/business/personagency/archive/archiveCheckout/returnRegisterCheckout.xf',
			    		data:{id:id},
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
			if(aa==1){
				bootbox.alert('当前人员档案是在“借阅登记”状态，不能返还登记');
			}else if(aa==3){
				bootbox.alert('当前人员档案是在“返还登记”状态，不能重复返还登记');
			}else if(aa==4){
				bootbox.alert('当前人员档案是在“返还确认”状态，不能返还登记');
			}
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }
}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"archiveRegisterCheckout",
		serviceId:'archivesExpServiceImpl',
		fileName:'档案借阅返还登记',
		sheetName:'档案借阅返还登记',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
						var ids=$("#archiveRegisterCheckout").jqGrid("getDataIDs");
						if(ids&&ids.length>0){
							return {menuNumber:'3',ids:ids};
						}else{
							bootbox.alert('无可导出的数据！');
							return false;
						}
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        		var ids=$("#archiveRegisterCheckout").jqGrid("getDataIDs");
			      		    if(ids&&ids.length>0){
					      		return {menuNumber:'3',ids:ids};
				      	    }else{
					      		bootbox.alert('请选择记录');
					      		return false;
				      	    }	
		  				}
				    }
		     ]
		
	});
}