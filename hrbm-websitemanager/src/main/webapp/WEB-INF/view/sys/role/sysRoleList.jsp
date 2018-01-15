<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<title>部门管理</title>
<script>
//左侧树结构展示
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
				onClick : nodeClick,
				onAsyncSuccess: zTreeOnAsyncSuccess,
				onRightClick:function(event, treeId, treeNode){					
					rightClickTreeNode=treeNode;
					
				}
				
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
	$.fn.zTree.init($("#orgTree"), setting);
}
function zTreeOnAsyncSuccess(){
	var treeObj = $.fn.zTree.getZTreeObj("orgTree");
	treeObj.expandAll(true);
}
//节点点击事件
function  nodeClick(event, treeId, treeNode){
	var nodeType=treeNode.nodeType;
	var acd200=treeNode.acd200;
	//节点选择 清空关键字检索
	$("#searchText").val('');
	//根目录选择
	if(acd200==0){
		acd200='';
	}
	leftClickTreeNode=treeNode;
	$('#fruRoleList').bootstrapTable('refresh', {	
		query: {aae017: acd200 }
	}); 
	
}
function initTable(){
	/**
	 初始化表格显示
	*/
	var columns= [ 
	                {field:'roleid',title:'操作',align:'center',width:'30%',formatter: function(value,row,index){	 
				           return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editRole('"+value+"')\" ><i class='icon-pencil' title='编辑'></i></a>"
								  +"<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editRoleSec('"+value+"')\" ><i class='icon-legal' title='权限分配'></i></a>"
				           +"<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"sysRoleUserManagerView('"+value+"')\" ><i class='icon-user' title='人员分配'></i></i></a>";
							}
					 },    {field:'rolename',title:'角色名称',width:'20%',align:'center'},
	                   {field:'roledesc',title:'角色描述',width:'20%',align:'center'},
// 	                   {field:'aae011',title:'经办人代码',width:100,align:'center'},
// 	                   {field:'aae017',title:'经办机构代码',width:100,align:'center'},
	                   {field:'aae036',title:'经办日期',width:'10%',align:'center',formatter:function(value,row,index){
	                	   if(value){
	                		   return formateDate(value);  
	                	   }else{
	                		   return '-';
	                	   }
	                	   }},
	                   {field:'aae019',title:'经办人',width:'10%',align:'center'},
	                   {field:'aae020',title:'所属机构',width:'10%',align:'center'}
      	        	];
	$('#fruRoleList').bootstrapTable({
	    url:'${ctx}/sys/role/sysRole/listJson.xf',
	    columns:columns,
	    method:"post",
	    contentType:"application/x-www-form-urlencoded",
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:false,
	    singleSelect: true,
	    sidePagination:"server",
	    striped:true
	});
	
}

function addFruRole(){	
	    var aae017 = '';
	    if(leftClickTreeNode){
	    	aae017 = leftClickTreeNode.acd200;
	    }
		xfui.open_dialog({    
		    title: '添加角色',    
		    width: 800,    
		    height: 350,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/sys/role/sysRole/add.xf?aae017="+aae017,
		    modal: true   
		})
}
//编辑角色
function editRole(value){
	xfui.open_dialog({    
		    title: '编辑角色',    
		    width: 800,    
		    height: 350,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/sys/role/sysRole/edit.xf?roleid="+value,
		    modal: true   
		})
}

function editFruRole(){
	var row = $('#fruRoleList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var roleid=row[0].roleid;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑角色',    
	  		    width: 800,    
	  		    height: 350,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/sys/role/sysRole/edit.xf?roleid="+roleid,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择一条信息');
	}			
} 
function sysRoleUserManager(){
	var row = $('#fruRoleList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var roleid=row[0].roleid;
		xfui.open_tabs("人员管理","${ctx}/sys/role/sysRoleUser/list.xf?roleId="+roleid,"人员管理");
	 
	}else{
		bootbox.alert('请选择一条信息');
	}
}
function sysRoleUserManagerView(value){
	xfui.open_tabs("角色人员分配","${ctx}/sys/role/sysRoleUser/list.xf?roleId="+value,"角色人员查看");
}
function editRoleSec(value){
	xfui.open_dialog({    
		    title: '权限管理',    
		    width: 800,    
		    height: 550,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/sys/resource/sysResource/resourceTree.xf?roleId="+value,
		    modal: true   
		})
}
function editUserSec(){
	var row = $('#fruRoleList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var roleid=row[0].roleid;
		xfui.open_dialog({    
  		    title: '权限管理',    
  		    width: 800,    
  		    height: 550,    
  		    closed: false,    
  		    cache: false,    
  		    url: "${ctx}/sys/resource/sysResource/resourceTree.xf?roleId="+roleid,
  		    modal: true   
  		})
	}else{
		bootbox.alert('请选择一条信息');
	}
}
function delFruRole(){
	var row = $('#fruRoleList').datagrid('getSelections');
	if(row&&row.length>0){
		var roleid="";
		$.each(row,function(i,e){
			if(i==0){
				roleid+=e.roleid;
			}else{
				roleid+=","+e.roleid;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/sys/role/sysRole/del.xf',
		    		data:{roleid:roleid},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				$.messager.alert('提示',data.message); 	
		    			}else{
		    				$.messager.alert('提示',"未知错误"); 
		    			}
		    			
		    			refresh();
		             }
		    	});
		    }    
		}); 
	  }else{
		 $.messager.alert('提示','请选择记录');
	 }			
} 
function refresh(){
	$('#fruRoleList').bootstrapTable('refresh');
}
function doSearch(){
	$('#searchText').val($.trim($('#searchText').val()));
	var json=$("#searchForm").serializeJson();
	$("#fruRoleList").bootstrapTable('refresh', {	
		query: json
	})
}
function doClear(){
	$("#searchText").val('');
}
</script>
</head>
<body>
<!--    <div id="dg_toolbar" style="padding: 5px 5px;"> -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addFruRole()" data-options="iconCls:'icon-add'">添加</a>  -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editFruRole()" data-options="iconCls:'icon-edit'">修改</a>  -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delFruRole()" iconCls="icon-remove">删除</a> -->
<!-- 	</div> -->
<!-- 	<div class="div-line"></div>		 -->
<!-- 	<table id="fruRoleList" class="datagridClass"></table> -->
<div class="container-fluid">
	<div class="mhyBody">
		<div class="col-md-2 col-xs-3 mhyTree">
			<div class="mhyTitle">机构目录 </div>
			<ul id="orgTree" class="ztree" data-toggle="context" ></ul>
		</div>
		<div class="col-md-10 col-xs-9"  >
		 <div>
				<div class="mhySearch">
				<div class="mhyTitle"> 查询条件 </div>
						<form id="searchForm" class="mhySearchInput">
							<div class="form-group">
								<div class="row">
									<div class="col-xs-12 col-sm-2"></div>
									<div class="col-xs-12 col-sm-6 marginbottom20">
									<label class="col-xs-2 col-sm-4">查询：</label>
										<div  class="col-xs-10 col-sm-8">
										
										<input class="form-control" id="searchText" type="text" name="Q_findKeyword_SL" placeholder="角色名称/经办人/所属机构" title="角色名称/经办人/所属机构" data-placement="bottom" />
									</div></div>
									<div class="col-xs-12 col-sm-4 mhySearchRight">
										<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" ><i class="icon-search"></i>查询</a>
										<a href="#modal-form" role="button" onclick="doClear()" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="mhyMain">
						<div class="mhyTitle"> 查询结果 </div>
						<div class="mhyInfo">
							<div class="mgy10">			
						<a href="javascript:void(0)" onclick="addFruRole()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus "></i> 添加角色</a>
<!-- 						<a href="javascript:void(0)" onclick="editFruRole()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>修改角色</a> -->
<!-- 						<a href="javascript:void(0)" onclick="sysRoleUserManager()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>人员管理</a> -->
<!-- 					    <a href="javascript:void(0)" onclick="editUserSec()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>权限分配</a> -->
						</div>	<div class="mhyConter">
					  <table id="fruRoleList" class="datagridClass tableClassNoworks"></table>
					</div>
						</div>
					</div>
			

				</div>
		
		</div>
	</div>
</div>
</body>
</html>