<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet"
	href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css"
	type="text/css">
<script type="text/javascript"
	src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<title>角色人员管理</title>
<script>
	$(function() {
		/**
		 初始化表格显示
		 */
		var columns = [ [ {
			field : '',
			title : '序号',
			formatter : function(value, row, index) {
				return index + 1;
			}
		}, {
			field : 'acd230',
			title : 'Id号',
			width : 100,
			align : 'center',
			visible : false
		}, {
			field : 'status',
			title : 'Id号',
			radio : 'true',
			width : '5%',
			align : 'center'
		}, {
			field : 'cczh01',
			title : '账户名',
			width : '15%',
			align : 'center'
		}, {
			field : 'aac003',
			title : '姓名',
			width : '15%',
			align : 'center'
		}, {
			field : 'aae005',
			title : '联系电话',
			width : '10%',
			align : 'center'
		}, {
			field : 'aac002',
			title : '身份证号',
			width : '15%',
			align : 'center'
		}, {
			field : 'acd202',
			title : '所属机构',
			width : '30%',
			align : 'center'
		}, {
			field : 'dep002',
			title : '所属部门',
			width : '10%',
			align : 'center'
		} ] ];
		$('#userList').bootstrapTable({
			url : '${ctx}/business/component/component/listUserJson.xf',
			columns : columns,
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 15, 20 ],
			clickToSelect : true,
			singleSelect : false,
			sidePagination : "server",
			striped : true,
			 onDblClickRow :function(rowIndex, rowData){
				 var utype = '${utype}';
					var userId = '';
					var nickname = '';
					userId = rowIndex.acd230;
					nickname = rowIndex.aac003;
					var parentIframe = xfui.getParentIframe();
					if (utype == '1') {
						parentIframe.setUserMessageUpdate(userId, nickname);
					} else {
						parentIframe.setUserMessageAdd(userId, nickname);
					}
					closeItem();
				}
		});
	})
	function saveSubmit() {
		var utype = '${utype}';
		var row = $('#userList').bootstrapTable('getAllSelections');
		var userId = '';
		var nickname = '';
		if (row) {
			userId = row[0].acd230;
			nickname = row[0].aac003;
		} else {
			bootbox.alert('请选择一条信息');
			return;
		}
		$(".btn-submit").attr("disabled");
		var parentIframe = xfui.getParentIframe();
		if (utype == '1') {
			parentIframe.setUserMessageUpdate(userId, nickname);
		} else {
			parentIframe.setUserMessageAdd(userId, nickname);
		}
		//设置父类数据
		// 		 	var parentIframe=xfui.getParentIframe();
		// 		    	if(parentIframe){
		// 		    		parentIframe.refresh();
		// 		    	}
		closeItem();
	}

	function addUser(row) {
		handerUser(row, '${ctx}/sys/role/sysRoleUser/addRoleUser.xf', 'id')
	}
	function removeUser() {
		var row = $('#userList').datagrid('getSelections');
		if (row && row.length > 0) {
			handerUser(row, '${ctx}/sys/role/sysRoleUser/removeRoleUser.xf',
					'acd230')
		} else {
			$.messager.alert('提示', "请选择记录");
		}
	}

	function handerUser(row, url, pId) {
		var roleId = $("#roleId").val();
		var userIds = "";
		$.each(row, function(i, e) {
			if (i == 0) {
				userIds += e[pId];
			} else {
				userIds += "," + e[pId];
			}

		});
		$.ajax({
			url : url,
			data : {
				roleId : roleId,
				userIds : userIds
			},
			dataType : 'json',
			success : function(data) {
				if (data.message) {
					$.messager.alert('提示', data.message);
				} else {
					$.messager.alert('提示', "未知错误");
				}

				refresh();
			}
		});

	}

	function refresh() {
		$('#userList').bootstrapTable('refresh');
	}
	function doSearch() {
		$('#searchText').val($.trim($('#searchText').val()));
		var json = $("#searchForm").serializeJson();
		$("#userList").bootstrapTable('refresh', {
			query : json
		})
	}
	function doClear() {
		$("#searchText").val('');
	}
	function closeItem() {
		xfui.closeDialog();
	}
	function doClearParent() {
		var utype = '${utype}';
		var parentIframe = xfui.getParentIframe();
		if (utype == '1') {
			parentIframe.clearUserMessageUpdate();
		} else {
			parentIframe.clearUserMessageAdd();
		}
		xfui.closeDialog();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 100%">
			<div class="col-xs-12 marginbottom20">
				<form id="searchForm">
					<div class="form-group">
						<div class="col-sm-12">
							<div class="col-sm-3 marginbottom20">
								<input class="form-control" id="searchText" type="text"
									name="Q_findKeyword_SL" placeholder="姓名/账户名/联系电话"
									title="姓名/账户名/联系电话" data-placement="bottom" />
							</div>
							<div class="col-sm-3 marginbottom20">
								<a href="#modal-form" role="button" onclick="doSearch()"
									class="btn btn-primary btn-border1">查询</a> <a
									href="#modal-form" role="button" onclick="doClear()"
									class="btn btn-primary btn-border1">重置</a> <a
									href="#modal-form" role="button" onclick="doClearParent()"
									class="btn btn-primary btn-border1">清空选择用户</a>
							</div>
						</div>
					</div>
				</form>
			</div>
			<form id="userForm" method="post">
				<div class="col-xs-12">
					<table id="userList"></table>
				</div>
				<input type="hidden" id="roleId" value='${roleId}' />
			</form>
		</div>
	</div>
</body>
</html>