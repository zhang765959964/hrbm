<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/common.jsp" %>
<title>数据字典</title>
<script>
	$(document).ready(function(){
		initTypeTree();
		
	});
	var zTree;
	function initTypeTree(){
			 var setting = {
					async: {
							enable: true,
							url:"${ctx}/sys/dic/dictionaryType/tree.xf" 
					},
					data: {
						simpleData: {
							enable: true,
							idKey:'id',
							pIdKey:'pId',
							rootPId:0
						} 
						
					},
					callback: {
						onRightClick: onRightClick,
						onClick: onClick,
						onAsyncSuccess:onAsyncSuccess
					}
				};
			$.fn.zTree.init($("#dicTypeTree"), setting); 
			zTree = $.fn.zTree.getZTreeObj("dicTypeTree");
	}
	
	 
	function onRightClick(event, treeId, treeNode) {
		if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
			zTree.cancelSelectedNode();
			showRMenu("root", event.clientX, event.clientY);
		} else if (treeNode && !treeNode.noR) {
			zTree.selectNode(treeNode);
			showRMenu("node", event.clientX, event.clientY);
		}
	}
	function onClick(e,treeId, treeNode){
		zTree.expandNode(treeNode);
		refreash_dg_data();
	}
	function showRMenu(type, x, y) {
		$('#menu_tree_right_click').menu('show', {
		    left: x,
		    top: y
		});
	}
	function onAsyncSuccess(event, treeId, treeNode, msg,otherNode){
		    if(!otherNode){
				var node = zTree.getNodeByParam("id", 1, null);
				zTree.selectNode(node);
				console.info(node);
				zTree.expandNode(node, true, true, true);
				refreash_dg_data();
		    }
			
		 
		
	}
	 
</script>
	 
</head>
<body>
	
	<script type="text/javascript" src='${ctx }/js/sys/sys-dic.js'></script>
<!-- 	<div class="easyui-panel" data-options="border:false" -->
<!-- 		style="width: 100%; height: 100%;"> -->
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'west',split:true,border:false,title:'数据字典'" 
				style="width: 150px; padding: 3px">
				<div class="" style="width: 100%; border:false">
					<ul id="dicTypeTree" class="ztree"></ul>
				</div>
			</div>
			<!-- datagrid 工具栏 -->
			
			<div data-options="region:'center',border:false" style="padding:5px;">
				<div id="dg_toolbar" style="padding: 5px 5px;">
					<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addItem()"  data-options="iconCls:'icon-add'">添加</a>
					<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editItem()" data-options="iconCls:'icon-edit'">修改</a>
					<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delItem()" iconCls="icon-remove" >删除</a>
				</div>
			<hr/>
				 
				<div class="" id="panel_dictionary_item" title="数据项"
					style="width: 100%;overflow:auto;">
					<table id="dg_dic_item" >
					    <thead>
					        <tr>
								<th field="id"  width=10 checkbox="true"></th>
					            <th field="itemText" width="50" >名称</th>
					            <th field="itemValue" width="50" >值</th>
					            <th field="itemDesc" width="50" >描述</th>
					        </tr>
					    </thead>
				</table>
				</div>
			</div>
		</div>
<!-- 	</div> -->
	<!-- 右键单击属性菜单 -->
	<div id="menu_tree_right_click" class="easyui-menu" data-options="onClick:menuHandler"
		style="width: 120px;">
		<div id="add_menu" data-options="iconCls:'icon-add',name:'new'">添加</div>
		<div id="edit_menu" data-options="iconCls:'icon-edit',name:'edit'">修改</div>
		<div id="del_menu" data-options="iconCls:'icon-remove',name:'destroy'">删除</div>
	</div>
	
</body>
</html>