<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h100p">
<head>
<title>工具箱模板栏目管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

<script>
var rightClickTreeNode=null;
var leftClickTreeNode=null;
	$(function() {
		/**
		 初始化表格显示
		 */
		initTree();
		initTable();

	})
	var setting = {
		async : {
			enable : true,
			type : "GET",
			url : function(treeId, node) {
				return "${ctx}/business/hrtool/hRToolModelCol/treeJson.xf";
			},
			dataFilter : function(treeId, parentNode, childNodes) {
				return childNodes;
			}
		},
		callback : {
			onClick : nodeClick,
			onAsyncSuccess: zTreeOnAsyncSuccess,
			onRightClick : function(event, treeId, treeNode) {
				rightClickTreeNode = treeNode;
				$('#mm').menu('show', {
					left : event.pageX,
					top : event.pageY
				});
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

		$.fn.zTree.init($("#articleColumnTree"), setting);

	}
	function zTreeOnAsyncSuccess(){
		var treeObj = $.fn.zTree.getZTreeObj("articleColumnTree");
		treeObj.expandAll(true);
		$('#articleColumnTree li a').contextmenu({
	        target: '#mm',
	        onItem: function (context, e) {
	        	nodeId=$(context).parent("li").attr("id");
	        	var node = treeObj.getNodeByTId(nodeId);
	        	rightClickTreeNode=node
		    	var name = $(e.target).attr("menuname");
		    	switch(name){
			    	case 'new':
						addHRToolModelCol(rightClickTreeNode);
						break;
					case 'edit':
						editHRToolModelCol(rightClickTreeNode);
						break;
					case 'destroy':
						delHRToolModelCol(rightClickTreeNode);
						break;
					default:
						alert("error");

		    	}
	        }
	 });
	}
	function  nodeClick(event, treeId, treeNode){

		var nodeType=treeNode.nodeType;
		if(nodeType=="root"){
			disableOpMenu();
		}else{
			enableOpMenu();
		}
			leftClickTreeNode=treeNode;
			refreshTable();
	}

	function refreshTree(treeNode){
		var treeObj = $.fn.zTree.getZTreeObj("articleColumnTree");
		treeObj.reAsyncChildNodes(null, "refresh");

	}

	function initTable() {
		var columns = [
				{
					field : '',
					title : 'Id号',
					checkbox : 'true',
					width : 30,
					align : 'center'
				},
				{
					field : 'id',
					align:'center',
					title : '操作',
					width : 100,
					formatter : function(value, row, index) {
						return "<a class='mhyNoA' href=\"${fileDirectory}/"+row.filePath+"\" ><i class='icon-cloud-download' title='下载'></i></a>";
					}
				},
				{
					field : 'name',
					title : '名称',
					width : 100,
					align : 'center'
				},
				{
					field : 'code',
					title : '代码',
					width : 100,
					align : 'center'
				},
				{
					field : 'colId',
					title : '模版栏目Id',
					width : 100,
					align : 'center'
				},
				{
					field : 'sortNum',
					title : '排序',
					width : 100,
					align : 'center'
				},
				{
					field : 'filePath',
					title : '模板路径',
					width : 100,
					align : 'center'
				} ] ;
		$('#hRToolModelList').bootstrapTable({
			url : '${ctx}/business/hrtool/hRToolModel/listJson.xf',
			columns: columns,
		    method:"post",
		    contentType:"application/x-www-form-urlencoded",
			pagination:true,
			pageSize:10,
			pageList:[10, 15, 20],
		    clickToSelect:true,
		    sidePagination:"server",
		    striped:true
		});
	}

	function addHRToolModel() {
		if(leftClickTreeNode){
			xfui.open_dialog({
				title : '新增hr工具箱模板',
				width : 800,
				height : 550,
				closed : false,
				cache : false,
				url : "${ctx}/business/hrtool/hRToolModel/add.xf?colId="+leftClickTreeNode.id,
				modal : true
			})
		}else {
			bootbox.alert( '请选择栏目');
		}
	}
	function editHRToolModel() {
		var row = $('#hRToolModelList').bootstrapTable('getAllSelections');
		if (row&&row.length>0) {
			var id = row[0].id;
			//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
			xfui.open_dialog({
				title : '编辑hr工具箱模板',
				width : 800,
				height : 550,
				closed : false,
				cache : false,
				url : "${ctx}/business/hrtool/hRToolModel/edit.xf?id=" + id,
				modal : true
			})
		} else {
			bootbox.alert( '请选择记录');
		}
	}

	function delHRToolModel() {
		var row = $('#hRToolModelList').bootstrapTable('getSelections');
		if (row && row.length > 0) {
			var id = "";
			$.each(row, function(i, e) {
				if (i == 0) {
					id += e.id;
				} else {
					id += "," + e.id;
				}

			});
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r) {
				if (r) {
					$.ajax({
						url : '${ctx}/business/hrtool/hRToolModel/del.xf',
						data : {
							id : id
						},
						dataType : 'json',
						success : function(data) {
							if (data.message) {
								bootbox.alert( data.message);
								refreshTable();
							} else {
								bootbox.alert( "未知错误");
							}

							refresh();
						}
					});
				}
			 }
			});
		} else {
			bootbox.alert( '请选择记录');
		}
	}
	function refreshTable(){

		if(leftClickTreeNode){
			var id=leftClickTreeNode.id;
			$('#hRToolModelList').bootstrapTable('refresh', {query:{
				colId: id
			  }
			});
		}else{
			$('#hRToolModelList').bootstrapTable('refresh');
		}
	}
	function doSearch() {

		var json = $("#searchForm").serializeJson();

		$("#hRToolModelList").bootstrapTable('refresh', {
			query: json
		})
	}
	function addHRToolModelCol(treeNode) {
		if(treeNode){
			id=treeNode.id;
			xfui.open_dialog({
			title : '新增工具箱模板栏目',
			width : 800,
			height : 500,
			closed : false,
			cache : false,
			url : "${ctx}/business/hrtool/hRToolModelCol/add.xf?parentId=" + id,
			modal : true
		    })
		}else{
			bootbox.alert('请选择记录');
		}
	}
	function editHRToolModelCol(treeNode) {

		if(treeNode){
			id=treeNode.id;
			//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
			xfui.open_dialog({
				title : '编辑工具箱模板栏目',
				width : 800,
				height : 500,
				closed : false,
				cache : false,
				url : "${ctx}/business/hrtool/hRToolModelCol/edit.xf?id=" + id,
				modal : true
			})
		} else {
			bootbox.alert( '请选择记录');
		}
	}

	function delHRToolModelCol(treeNode) {
		if (treeNode) {
			id=treeNode.id;
			bootbox.confirm({message:'您确认想要删除记录 【 '+treeNode.name+'】 吗？',callback: function(r) {
				if (r) {
					$.ajax({
						url : '${ctx}/business/hrtool/hRToolModelCol/del.xf',
						data : {
							id : id
						},
						dataType : 'json',
						success : function(data) {
							if (data.message) {
								bootbox.alert( data.message);
								refreshTree(treeNode.getParentNode());
							} else {
								bootbox.alert( "未知错误");
							}
						}
					});
				}
			}
		});
		} else {
			bootbox.alert( '请选择记录');
		}
	}
	//启用菜单
	function enableOpMenu(){

		$.each($("a",$("#dg_toolbar")),function(i,e){
			$(e).linkbutton('enable');
		})

	}
	//禁用菜单
	function disableOpMenu(){
		$.each($("a",$("#dg_toolbar")),function(i,e){
			$(e).linkbutton('disable');
		})
	}
</script>
</head>
<body class="h100p">
<div class="container-fluid h100p">
	<div class="row h100p">
		<div class="col-md-2 col-xs-3 moduleWrap pd0 h100p">
			<div class="moduleTit">资源目录 </div>
			<ul id="articleColumnTree" class="ztree moduleCont" data-toggle="context" ></ul>
		</div>
		<div class="col-md-10 col-xs-9 h100p colRight">
		 	<div class="moduleWrapNobg">
		 		<div class="moduleTit"> 查询条件 </div>
		 		<div class="moduleCont">
					<form id="searchForm" >
						<div class="row">
							<div class="col-xs-1 col-sm-4"></div>
							<div class="col-sm-6 col-xs-6">
								<label class="col-xs-2 col-sm-4" for="inputError">模版标题: </label>
								<div class="col-sm-8 col-xs-10 mgb20">
									<input class="form-control" type="text" name="Q_name_SL" placeholder="模版标题" title="模版标题" data-placement="bottom" />
								</div>

							</div>
																<div class="col-sm-2 col-xs-2">
										<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
										<!-- <a href="#modal-form" role="button" class="btn btn-border1" ><i class="icon-repeat"></i>重置</a> -->
									</div>
						</div>
					</form>
				</div>
			</div>
			<div class="moduleWrapNob">
				<div class="moduleTit"> 查询结果 </div>
				<div class="moduleCont">
					<div class="row">
						<div class="col-xs-12">
							<table id="hRToolModelList" ></table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 <div id="mm">
    <ul class="dropdown-menu" role="menu">
         <li id="add_menu"><a tabindex="-1" menuname="new">添加栏目</a></li>
         <li id="edit_menu"><a tabindex="-1" menuname="edit">修改栏目</a></li>
         <li id="del_menu"><a tabindex="-1" menuname="destroy">删除栏目</a></li>
     </ul>
  </div>
</body>
</html>


