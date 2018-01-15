function refresh(){
	$("#corpArchiveResultList").trigger("reloadGrid");
}

function doSearch(){
	var json=$("#searchForm").serializeJson();
	$("#corpArchiveResultList").jqGrid("clearGridData");
	$("#corpArchiveResultList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}

function searchChildReceive(){
	 var jxResultRecive = $("#jxResultRecive").val();
	 var json = { "searchValue": "%"+jxResultRecive+"%"};
	 $("#corpArchiveResultList").jqGrid("clearGridData");
	 $("#corpArchiveResultList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
//修改企业下档案信息
function editCorpArchives(){
	var row=$("#corpArchiveResultList").jqGrid("getGridParam","selrow");
	var rowData = $("#corpArchiveResultList").jqGrid('getRowData',row);	
	var aac001= rowData.aac001;
	if(row&&row.length>0){
		xfui.open_dialog({    
		    title: '单位下个人档案接收修改',    
		    width: 950,    
		    height: 550,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/corp/receive/edit.xf?personId="+aac001,
		    modal: true   
		})
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 
//打印条形码
function printCodeLabel(){
	var row=$("#corpArchiveResultList").jqGrid("getGridParam","selrow");
	var rowData = $("#corpArchiveResultList").jqGrid('getRowData',row);	
	var id = rowData.ID;
	if(row&&row.length>0){
		var param = {"id":id,"type":3};
		templatePrint("archiveLabel",param);
	}else{
		 bootbox.alert('请选择记录');
	}		
}
