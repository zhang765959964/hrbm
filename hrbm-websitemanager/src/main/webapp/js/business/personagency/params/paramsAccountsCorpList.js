$(function() {
	/**
	 * 初始化表格显示
	 */
	var columns = [ {
		name : 'FD_USER_ACCOUNT',
		label : '用户帐号',
		align : 'center'
	}, {
		name : 'FD_USER_NAME',
		label : '用户名称',
		align : 'center'
	}, {
		name : 'FD_DEPT_NAME',
		label : '用户所在机构',
		align : 'center'
	}, {
		name : 'ACD202',
		label : '市场位置名称',
		align : 'center'
	},
	// {name:'fdOrgId',label:'市场位置ID',align:'center'},
	{
		name : 'PK_ID',
		label : '主键',
		hidden : true,
		width : 100,
		key : true
	} ];
	$("#paramsAccountsCorpList")
			.jqGrid(
					{
						url : CTX+'/business/personagency/params/paramsAccountsCorp/listJson.xf',
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

function addParamsAccountsCorp() {
	xfui.open_dialog({
		title : '新增账号与市场关联维护',
		width : 800,
		height : 500,
		closed : false,
		cache : false,
		url : CTX+"/business/personagency/params/paramsAccountsCorp/add.xf",
		modal : true
	})
}
function editParamsAccountsCorp() {
	// var row =
	// $('#paramsAccountsCorpList').bootstrapTable('getAllSelections');
	var rowid = $("#paramsAccountsCorpList").jqGrid("getGridParam", "selrow");
	if (rowid) {
		var pkId = rowid;
		xfui
				.open_dialog({
					title : '编辑账号与市场关联维护',
					width : 800,
					height : 500,
					closed : false,
					cache : false,
					url : CTX+"/business/personagency/params/paramsAccountsCorp/edit.xf?pkId="
							+ pkId,
					modal : true
				})
	} else {
		bootbox.alert('请选择记录');
	}
}

function delParamsAccountsCorp() {

	var rowids = $("#paramsAccountsCorpList").jqGrid("getGridParam",
			"selarrrow");
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
										url : CTX+'/business/personagency/params/paramsAccountsCorp/del.xf',
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
	$("#paramsAccountsCorpList").trigger("reloadGrid");
}
function doSearch() {
	$("#paramsAccountsCorpList").jqGrid("clearGridData");
	var json = $("#searchForm").serializeJson();
	$("#paramsAccountsCorpList").jqGrid("setGridParam", {
		postData : json
	}).trigger("reloadGrid");
}