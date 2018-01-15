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
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<title>部门管理</title>
<script>
	//左侧树结构展示
	var rightClickTreeNode = null;
	var leftClickTreeNode = null;
	$(function() {
		initTree()
		initTable();
	})
	var setting = {
		async : {
			enable : true,
			type : "GET",
			url : function(treeId, node) {
				return "${ctx}/sys/uums/sysOrg/treeJson.xf";
			},
			dataFilter : function(treeId, parentNode, childNodes) {
				return childNodes;
			}
		},
		callback : {
			onClick : nodeClick,
			onAsyncSuccess : zTreeOnAsyncSuccess,
			onRightClick : function(event, treeId, treeNode) {
				rightClickTreeNode = treeNode;

			}

		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : 0
			}
		},
		check : {
			enable : true,
			chkStyle : "radio",
			radioType : "all"
		}

	};
	function initTree() {
		$.fn.zTree.init($("#orgTree"), setting);
	}
	function zTreeOnAsyncSuccess() {
		var treeObj = $.fn.zTree.getZTreeObj("orgTree");
		treeObj.expandAll(true);

	}
	//节点点击事件
	function nodeClick(event, treeId, treeNode) {
		var nodeType = treeNode.nodeType;
		var acd200 = treeNode.acd200;
		//节点选择 清空关键字检索
		$("#searchText").val('');
		//根目录选择
		if (acd200 == 0) {
			acd200 = '';
		}
		leftClickTreeNode = treeNode;
		$('#sysDeptList').bootstrapTable('refresh', {
			query : {
				acd200 : acd200
			}
		});

	}

	/**
	初始化表格显示
	 */
	function initTable() {
		/**
		 初始化表格显示
		 */
		var columns = [
				// 		               {field:'',title:'选择',checkbox:'true',width:100,align:'center'},
				{
					field : 'dep001',
					title : '操作',
					align : 'center',
					width : '15%',
					formatter : function(value, row, index) {
						return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editsysDeptObj('"
								+ value
								+ "')\" ><i class='icon-pencil' title='编辑'></i></a>"
								+ "<a  class='mhyNoA' href=\"javascript:void(0)\" onclick=\"delsysDept('"
								+ value + "')\" ><i class='icon-trash' title='删除'></i></a>";
// 								+ "<a  class='mhyNoA' href=\"javascript:void(0)\" onclick=\"addDeptUsers('"
// 								+ value + "','" + row.acd200 + "')\" ><i class='icon-user' title='人员分配'></i></a>";
					}
				},{
					field : 'dep002',
					title : '部门名称',
					width : '15%',
					align : 'center'
				},
				{
					field : 'dep003',
					title : '部门描述',
					width : '20%',
					align : 'center'
				},
				// 	                   {field:'dep004',title:'部门排序序号',width:'5%',align:'center'},
				{
					field : 'acd202',
					title : '所属机构',
					width : '20%',
					align : 'center'
				},
				// 	                   {field:'aae011',title:'经办人代码',width:100,align:'center'},
				// 	                   {field:'aae017',title:'经办机构代码',width:100,align:'center'},
				{
					field : 'aae036Format',
					title : '经办日期',
					width : '8%',
					align : 'center'
				},
				{
					field : 'aae019',
					title : '经办人',
					width : '10%',
					align : 'center'
				},
				{
					field : 'aae020',
					title : '经办机构',
					width : '12%',
					align : 'center'
				}
				 ];
		$('#sysDeptList').bootstrapTable({
			url : '${ctx}/sys/uums/sysDept/listJson.xf',
			columns : columns,
			method : "post",
			contentType : "application/x-www-form-urlencoded",
			pagination : true,
			pageSize : 10,
			pageList : [ 10, 15, 20 ],
			clickToSelect : false,
			singleSelect : true,
			sidePagination : "server",
			striped : true
		});

	}

	function addsysDept() {
		var url = "${ctx}/sys/uums/sysDept/add.xf";
		if (leftClickTreeNode) {
			url = url + '?acd200=' + leftClickTreeNode.acd200
		}
		xfui.open_dialog({
			title : '添加部门信息',
			width : 800,
			height : 300,
			closed : false,
			cache : false,
			url : url,
			modal : true
		})
	}
	function editsysDeptObj(obj) {
		xfui.open_dialog({
			title : '编辑部门信息',
			width : 800,
			height : 300,
			closed : false,
			cache : false,
			url : "${ctx}/sys/uums/sysDept/edit.xf?dep001=" + obj,
			modal : true
		})
	}
	function editsysDept() {
		var row = $('#sysDeptList').bootstrapTable('getAllSelections');
		if (row && row.length > 0) {
			var dep001 = row[0].dep001;
			//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
			xfui.open_dialog({
				title : '编辑部门信息',
				width : 800,
				height : 350,
				closed : false,
				cache : false,
				url : "${ctx}/sys/uums/sysDept/edit.xf?dep001=" + dep001,
				modal : true
			})
		} else {
			bootbox.alert('请选择一条信息');
		}
	}

	function delsysDept(dep001) {
		bootbox.confirm({message:'您确认想要删除记录吗？',callback: function(r) {
				if (r) {
					$.ajax({
						url : '${ctx}/sys/uums/sysDept/del.xf',
						data : {
							dep001 : dep001
						},
						dataType : 'json',
						success : function(data) {
							if (data.message) {
								bootbox.alert('提示', data.message);
							} else {
								bootbox.alert('提示', "未知错误");
							}

							refresh();
						}
					});
				}
			}});

	}
	function refresh() {
		$('#sysDeptList').bootstrapTable('refresh');
	}
	function doSearch() {
		$('#searchText').val($.trim($('#searchText').val()));
		var json = $("#searchForm").serializeJson();
		$("#sysDeptList").bootstrapTable('refresh', {
			query : json
		})
	}
	function doClear() {
		$("#searchText").val('');
	}
	function addDeptUsers(dep001, acd200) {
		xfui.open_tabs("部门人员分配",
				"${ctx}/sys/uums/sysDept/getDeptUsers.xf?dep001=" + dep001
						+ "&acd200=" + acd200, "部门人员分配");
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="mhyBody">
			<div class="col-md-2 mhyTree">
				<div class="mhyTitle">部门目录</div>
				<ul id="orgTree" class="ztree" data-toggle="context"></ul>
			</div>
			<div class="col-md-10 col-xs-12" style="height: 100%">
				<div>
					<div class="mhySearch">
						<div class="mhyTitle">查询条件</div>
						<form id="searchForm" class="mhySearchInput">
							<div class="form-group">
								<div class="row">
									<div class="col-xs-12 col-sm-2"></div>
									<div class="col-xs-12 col-sm-6 marginbottom20">
									<label class="col-xs-2 col-sm-4">查询：</label>
									<div class="col-xs-10 col-sm-8">
									
										<input class="form-control" id="searchText" type="text"
											name="Q_findKeyword_SL" placeholder="部门名称/所属机构/经办人"
											title="部门名称/所属机构/经办人" data-placement="bottom" />
									</div></div>
									<div class="col-xs-12 col-sm-4 marginbottom60 mhySearchRight">
										<a href="#modal-form" role="button" onclick="doSearch()"
											class="btn btn-primary mhyBtnLeft">
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
						<div class="mhyTitle">查询结果</div>
						<div class="mhyInfo">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addsysDept()" role="button"
								class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i> 添加部门</a>
							<!-- 						<a href="javascript:void(0)" onclick="editsysDept()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>修改</a> -->
							<!-- 					    <a href="javascript:void(0)" onclick="addDeptUsers()"  role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>人员管理</a> -->
							</div><div class="mhyConter">
								<table id="sysDeptList" class="datagridClass tableClassNoworks"></table>
							</div>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>