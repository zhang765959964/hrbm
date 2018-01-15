$(function(){
	initDataExp();
})
//借阅确认
function registerComfirmCheckout(){
	var row=$("#archiveConfirmCheckout").jqGrid("getGridParam","selrow");
	var rowData = $("#archiveConfirmCheckout").jqGrid('getRowData',row);
	var aa= rowData.checkoutStatus;
	if(row&&row.length>0){
		var id= row + "";
		if(aa==1){
			bootbox.confirm({message:'您确认想要借阅确认吗？',callback:function(r){
			    if (r){
			    	$.ajax({ url: CTX+'/business/personagency/archive/archiveCheckout/registerComfirmCheckout.xf',
			    		data:{id:id},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message);
			    			}else{
			    				bootbox.alert("未知错误");
			    			}
			    			searchArchiveCheckout();
			             }
			    	});
			    }
			}});
		}else{
			bootbox.alert('当前人员档案是在“返还登记”状态，不能借阅确认');
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }
}

//返还确认
function returnConfirmCheckout(){
	var row=$("#archiveConfirmCheckout").jqGrid("getGridParam","selrow");
	var rowData = $("#archiveConfirmCheckout").jqGrid('getRowData',row);
	var aa= rowData.checkoutStatus;
	if(row&&row.length>0){
		var id= row + "";
		if(aa==3){
			bootbox.confirm({message:'您确认想要返还确认吗？',callback:function(r){
			    if (r){
			    	$.ajax({ url: CTX+'/business/personagency/archive/archiveCheckout/returnConfirmCheckout.xf',
			    		data:{id:id},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message);
			    			}else{
			    				bootbox.alert("未知错误");
			    			}
			    			searchArchiveCheckout();
			             }
			    	});
			    }
			}});
		}else{
			bootbox.alert('当前人员档案是在“借阅登记”状态，不能返还确认');
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }
}
function searchArchiveCheckout(){
	var checkoutStatusValue = $('#checkoutStatusValue option:selected') .val();
	$("#archiveConfirmCheckout").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archiveCheckout/listJson.xf?checkoutStatusValue='+checkoutStatusValue}).trigger("reloadGrid");
	queryResetForm();
}
function queryResetForm(){
	$("#AAC002").val('');
	$("#AAC003").val('');
	$("#expPersonPhone").val('');
	$("#genderName").val('');
	$("#AAC006").val('');
	$("#archiveBirthDate").val('');
	$("#archiveCode").val('');
	$("#archiveName").val('');
	$("#archiveReceiveName").val('');
	$("#receiveDate").val('');
	$("#archiveStatusName").val('');
	$("#AAE005").val('');
	$("#archiveTypeName").val('');
	$("#expEntrustCompany").val('');
}
//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"archiveConfirmCheckout",
		serviceId:'archivesExpServiceImpl',
		fileName:'档案借阅返还确认',
		sheetName:'档案借阅返还确认',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
						var ids=$("#archiveConfirmCheckout").jqGrid("getDataIDs");
						if(ids&&ids.length>0){
							return {menuNumber:'3',ids:ids};
						}else{
							bootbox.alert('无可导出的数据！');
							return false;
						}
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        		var ids=$("#archiveConfirmCheckout").jqGrid("getDataIDs");
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