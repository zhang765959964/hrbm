<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/common.jsp" %>
<title>部门管理</title>
<script>

var rightClickTreeNode=null;
var leftClickTreeNode=null;
$(function(){
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
				onClick : nodeClick
				
			},
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "pId",
					rootPId: 0
				}
			},
			check : {
				enable : true,
				chkStyle : "radio",
				radioType : "all"
			}

		};
		
function initTree(){

	$.fn.zTree.init($("#deptTree"), setting);

}

function  nodeClick(event, treeId, treeNode){
	var nodeType=treeNode.nodeType;
	var acd200="",dep001=""    
		if(nodeType=="org"){
			var acd200=treeNode.acd200

		}if(nodeType=="dept"){
			var dep001=treeNode.dep001

		}else{

		}
		leftClickTreeNode=treeNode;
	$('#userList').datagrid('load', {    
		acd200: acd200,    
		dep001: dep001   
	}); 
}
/**
初始化表格显示
*/
function initTable(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'acd230',title:'Id号',checkbox:'true',width:100,align:'center'},
	                {field:'cczh01',title:'账户名',width:100,align:'center'},
     	        	{field:'aac003',title:'姓名',width:150,align:'center'},
     	        	{field:'aae005',title:'联系电话',width:150,align:'center'},    
	              	{field:'aac002',title:'身份证号',width:150,align:'center'},
	        	    {field:'aac001',title:'个人编号',width:150,align:'center'}	        	        
	        	    ]];
	$('#userList').datagrid({
	    url:'${ctx}/sys/uums/sysUser/listJson.xf',
	    columns:columns,
	    fitColumns:true,
		rownumbers: true,
		singleSelect: false,
		selectOnCheck: true,
		checkOnSelect: true,
		pagination: true, 
       	rownumbers: true,
       	multiSort:true,
       	pageList:[1,5,10]
	});
	
}

function introUser(){
	
	var row = $('#userList').datagrid('getSelections');
	if(row.length>0){
		var userArray=new Array();
		
		$.each(row,function(i,e){
			
			userArray.push({id:e.acd230,name:e.aac003})
		})
		xfui.closeDialog();
		var parentIframe=xfui.getParentIframe();
    	if(parentIframe&&$.isFunction(parentIframe.selUserCallBack) ){
    		parentIframe.selUserCallBack(userArray);
    	}
	}else{
		$.messager.alert('提示',"请选择记录"); 
	}
	
}

</script>
</head>
<body>
  
		<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'north',border:false">
				<div id="dg_toolbar" style="padding: 5px 5px;">
					<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  onclick="introUser()" data-options="iconCls:'icon-add'">确定</a> 
					<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="removeUser()" data-options="iconCls:'icon-remove'">关闭</a>
				</div>
			</div>
			<div data-options="region:'west',split:true,border:false,title:'组织机构'" 
				style="width: 200px;">
				<div class=""
					style="width: 100%; border:false">
					<ul id="deptTree" class="ztree"></ul>					
				</div>
			</div>
			<!-- datagrid 工具栏 -->
			
			<div data-options="region:'center',border:false" style="">

				<table id="userList" class="datagridClass"></table>
					
			</div>
		</div>
    <div id="mm" class="easyui-menu" style="width:120px;">
		<div id="add_menu" data-options="iconCls:'icon-add',name:'new'">添加部门</div>
		<div id="edit_menu" data-options="iconCls:'icon-edit',name:'edit'">修改部门</div>
		<div id="del_menu" data-options="iconCls:'icon-remove',name:'destroy'">删除部门</div>
  </div>
</body>
</html>