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
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<script type="text/javascript"
	src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<title>用户管理</title>
<script>
	$(function() {
		/**
		 初始化表格显示
		 */
		var columns = [
				// 	               {field:'status',title:'选择',checkbox:'true',width:'5%',align:'center'},
				
				{
					field : 'acd230',
					title : '操作',
					width : '10%',
					align : 'center',
					formatter : function(value, row, index) {
						return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editItemValue('"
								+ value + "')\" ><i class='icon-pencil' title='编辑'></i></a>";
						//      	 							+ "|<a href=\"javascript:void(0)\" onclick=\"previewArticle('"
						//      	 							+ value + "')\" >删除</a>";
					}
				},
				{
					field : 'cczh01',
					title : '账户名',
					align : 'center',
					width : '10%'
				},
				{
					field : 'aac003',
					title : '姓名',
					align : 'center',
					width : '10%'
				},
				{
					field : 'aae005',
					title : '联系电话',
					align : 'center',
					width : '15%'
				},
				{
					field : 'aac002',
					title : '身份证号',
					align : 'center',
					width : '15%'
				},
				{
					field : 'acd202',
					title : '所属机构',
					align : 'center',
					width : '25%'
				},
				{
					field : 'dep002',
					title : '所属部门',
					align : 'center',
					width : '10%'
				} ];
		$('#userList').bootstrapTable({
			url : '${ctx}/sys/uums/sysUser/listJson.xf?dep001=${dep001}',
			columns : columns,
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 15, 20 ],
			clickToSelect : true,
			singleSelect : true,
			sidePagination : "server",
			striped : true
		});

	})

	function editItemValue(value) {
		xfui.open_dialog({
			title : '编辑人员',
			width : 920,
			height : 580,
			closed : false,
			cache : false,
			url : "${ctx}/sys/uums/sysUser/edit.xf?acd230=" + value,
			modal : true
		})
	}

	function addItem() {
		xfui.open_dialog({
			title : '添加人员',
			width : 920,
			height : 580,
			closed : false,
			cache : false,
			url : "${ctx}/sys/uums/sysUser/edit.xf",
			modal : true
		})
	}

	function editItem() {
		var row = $('#userList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var acd230 = row[0].acd230;
			editItemValue(acd230)
		} else {
			bootbox.alert('请选择一条记录');
		}
	}

	function delItem() {
		var row = $('#userList').datagrid('getSelections');
		if (row && row.length > 0) {
			var acd230 = "";
			var adminAccount = $("#adminAccount").val();
			var delFlag = true;
			$.each(row, function(i, e) {
				var cczh01 = e.cczh01;
				if (cczh01 == adminAccount) {
					delFlag = false;
					return false;
				}
				if (i == 0) {
					acd230 += e.acd230;
				} else {
					acd230 += "," + e.acd230;
				}

			});

			if (!delFlag) {
				bootbox.alert('不能删除超级管理员');
				return;
			}
			$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
				if (r) {
					$.ajax({
						url : '${ctx}/sys/uums/sysUser/del.xf',
						data : {
							acd230 : acd230
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
			});
		} else {
			bootbox.alert('请选择一条记录');
		}
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
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="mhyBody">
			<div class="mhySearch">
				<div class="mhyTitle"> 查询条件 </div>
				<form id="searchForm" class="mhySearchInput">
					<div class="form-group">
						<div class="row">
						<div class="col-xs-12 col-sm-2"></div>
							<div class="col-xs-12 col-sm-6 marginbottom20">
							<label class="col-xs-2 col-sm-4" >查询：</label>
							<div class="col-xs-10 col-sm-8" >
								<input class="form-control" id="searchText" type="text"
									name="Q_findKeyword_SL" placeholder="姓名/账户名/联系电话/所属机构/部门"
									title="姓名/账户名/联系电话/所属机构/部门" data-placement="bottom" /></div>
							</div>
							<div class="col-xs-12 col-sm-4 mhySearchRight">
								<a href="#modal-form" role="button" onclick="doSearch()"
									class="btn btn-primary btn-border1 mhyBtnLeft">
									<i class="icon-search"></i>
									查询</a> <a
									href="#modal-form" role="button" onclick="doClear()"
									class="btn btn-info">
									<i class="icon-repeat"></i>
									重置</a>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class="mhyMain">
				<div class="mhyTitle"> 查询结果 </div>
				<div class="mhyInfo">
				<div class="mgy10">
					<a href="javascript:void(0)" onclick="addItem()" role="button"
						class="btn btn-primary" data-toggle="modal">
						<i class="icon-plus"></i>
						<!-- <i class="icon-plus align-top bigger-125"></i> -->添加</a></div>
					<!-- 						<a href="javascript:void(0)" onclick="editItem()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>修改</a> -->
					
					<div class="mhyConter">
						<table id="userList" class="datagridClass tableClassNoworks"></table>
					</div>
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>