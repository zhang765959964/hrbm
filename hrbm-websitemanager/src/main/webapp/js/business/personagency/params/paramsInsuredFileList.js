$(function() {
	/**
	 * 初始化表格显示
	 */
	var columns = [ {
		name : 'fdFileName',
		label : '文件名称',
		align : 'center'
	}, {
		name : 'fdFileNumber',
		label : '文件编号',
		align : 'center'
	}, {
		name : 'pkId',
		label : '主键',
		hidden : true,
		width : 100,
		key : true
	} ];
	$("#paramsInsuredFileList")
			.jqGrid(
					{
						url : CTX+'/business/personagency/params/paramsInsuredFile/listJson.xf',
						mtype : "GET",
						styleUI : 'Bootstrap',
						datatype : "json",
						colModel : columns,
						viewrecords : true,
						rowNum : 10,
						rowList : [ 10, 20, 30 ],
						pager : "#jqGridPager",
						pagerpos : 'left',
						regional : 'cn',
						recordpos : 'right',
						shrinkToFit : false,
						multiselect : true,
						autowidth : true,
						height : '100%'
					});
})

function addParamsInsuredFile() {
	xfui.open_dialog({
		title : '新增参保文件',
		width : 800,
		height : 500,
		closed : false,
		cache : false,
		url : CTX+"/business/personagency/params/paramsInsuredFile/add.xf",
		modal : true
	})
}
function editParamsInsuredFile() {
	// var row = $('#paramsInsuredFileList').bootstrapTable('getAllSelections');
	var rowid = $("#paramsInsuredFileList").jqGrid("getGridParam", "selrow");
	if (rowid) {
		var pkId = rowid;
		xfui
				.open_dialog({
					title : '编辑参保文件',
					width : 800,
					height : 500,
					closed : false,
					cache : false,
					url : CTX+"/business/personagency/params/paramsInsuredFile/edit.xf?pkId="
							+ pkId,
					modal : true
				})
	} else {
		bootbox.alert('请选择记录');
	}
}

function delParamsInsuredFile() {

	var rowids = $("#paramsInsuredFileList")
			.jqGrid("getGridParam", "selarrrow");
	if (rowids && rowids.length > 0) {
		var pkId = "";
		$.each(rowids, function(i, e) {
			if (i == 0) {
				pkId += e;
			} else {
				pkId += "," + e;
			}

		});
		bootbox
				.confirm({
					message : '您确认想要删除记录吗？',
					callback : function(r) {
						if (r) {
							$
									.ajax({
										url : CTX+'/business/personagency/params/paramsInsuredFile/del.xf',
										data : {
											pkId : pkId
										},
										dataType : 'json',
										success : function(data) {
											if (data.message) {
												bootbox.alert(data.message);
											} else {
												bootbox.alert("未知错误");
											}

											refresh();
										}
									});
						}
					}
				});
	} else {
		bootbox.alert('请选择记录');
	}
}
function refresh() {
	$("#paramsInsuredFileList").trigger("reloadGrid");
}
function doSearch() {
	$("#paramsInsuredFileList").jqGrid("clearGridData");
	var json = $("#searchForm").serializeJson();
	$("#paramsInsuredFileList").jqGrid("setGridParam", {
		postData : json
	}).trigger("reloadGrid");
}