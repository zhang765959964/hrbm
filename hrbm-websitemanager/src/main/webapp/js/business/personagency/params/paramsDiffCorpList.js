$(function() {
	/**
	 * 初始化表格显示
	 */
	var columns = [ {
		name : 'fdCorpName',
		label : '困难企业名称',
		align : 'center'
	}, {
		name : 'fdCorpCode',
		label : '困难企业代码',
		align : 'center'
	}, {
		name : 'fdCorpAddre',
		label : '所属区域',
		align : 'center'
	}, {
		name : 'fdCorpDetail',
		label : '详细信息',
		align : 'center'
	}, {
		name : 'fdCorpNote',
		label : '备注',
		align : 'center'
	}, {
		name : 'pkId',
		label : '主键',
		hidden : true,
		width : 100,
		key : true
	} ];
	$("#paramsDiffCorpList").jqGrid({
		url : CTX + '/business/personagency/params/paramsDiffCorp/listJson.xf',
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

function addParamsDiffCorp() {
	xfui.open_dialog({
		title : '新增困难企业',
		width : 800,
		height : 500,
		closed : false,
		cache : false,
		url : CTX + "/business/personagency/params/paramsDiffCorp/add.xf",
		modal : true
	})
}
function editParamsDiffCorp() {
	// var row = $('#paramsDiffCorpList').bootstrapTable('getAllSelections');
	var rowid = $("#paramsDiffCorpList").jqGrid("getGridParam", "selrow");
	if (rowid) {
		var pkId = rowid;
		xfui
				.open_dialog({
					title : '编辑困难企业',
					width : 800,
					height : 500,
					closed : false,
					cache : false,
					url : CTX
							+ "/business/personagency/params/paramsDiffCorp/edit.xf?pkId="
							+ pkId,
					modal : true
				})
	} else {
		bootbox.alert('请选择记录');
	}
}

function delParamsDiffCorp() {

	var rowids = $("#paramsDiffCorpList").jqGrid("getGridParam", "selarrrow");
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
										url : CTX
												+ '/business/personagency/params/paramsDiffCorp/del.xf',
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
	$("#paramsDiffCorpList").trigger("reloadGrid");
}
function doSearch() {
	$("#paramsDiffCorpList").jqGrid("clearGridData");
	var json = $("#searchForm").serializeJson();
	$("#paramsDiffCorpList").jqGrid("setGridParam", {
		postData : json
	}).trigger("reloadGrid");
}