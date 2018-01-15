<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<title>资源管理</title>
<script>
var rightClickTreeNode=null;
var leftClickTreeNode=null;
var oldNodeId = null;
$(function(){
	initTree()
	initTable();
})
 var setting = {
			async : {
				enable : true,
				type : "GET",
				url : function(treeId, node) {
					return "${ctx}/sys/resource/sysResource/resTreeJson.xf";
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
        	rightClickTreeNode=node;
	    	var name = $(e.target).attr("menuname");
	    	switch(name){
	    		case 'new':
	    			addArticleColumn(rightClickTreeNode);
	    		     break;
	    		case 'edit':
	    			editArticleColumn(rightClickTreeNode);
	    			break;
	    		case 'destroy':
	    			delArticleColumn(rightClickTreeNode);
	    			break;
	    		default:
	    			alert("error");
	    	}
        },  before: function(e,context) {
 		   var nodeId=$(context).parent("li").attr("id");
    	   var node = treeObj.getNodeByTId(nodeId);
    	   var nodeType=node.id;
    	   if(nodeType=='0'){
    		   $('#edit_menu').hide();
    	   }else{
    		   $('#edit_menu').show();
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
	var funpid=treeNode.funid;
	//节点选择 清空关键字检索
	doClear();
	//根目录选择
	if(funpid==0){
		funpid='';
	}
	leftClickTreeNode=treeNode;
	oldNodeId = treeNode.funid;
// 	 $('#sysOrgList').bootstrapTable({pageNumber:1,pageSize:10});
	$('#sysOrgList').bootstrapTable('refresh', {
		query: {offset:0,funpid: funpid}
	}); 
	
}
//启用资源
function enableOpMenu(){
	$.each($("a",$("#dg_toolbar")),function(i,e){
// 		$(e).linkbutton('enable');
	})
	
}
//禁用资源
function disableOpMenu(){
	$.each($("a",$("#dg_toolbar")),function(i,e){
// 		$(e).linkbutton('disable');
	})
}
/**
初始化表格显示
*/
function initTable(){
	/**
	 初始化表格显示
	 */
	var columns = [ 
// 	               {field:'',checkbox:'true',width:10},        
			        {field:'funid',title:'资源ID',width:'10%',align:'center'},
			        {field:'funid',title:'操作',width:'20%',align:'center',formatter: function(value,row,index){
			        	return "<a class='mhyNoA' href=\"javascript:void(0)\"  onclick=\"openAddMenu('"+value+"','"+row.funname+"')\"  ><i class='icon-plus' title='添加'></i></a>"+
			        	"<a class='mhyNoA' href=\"javascript:void(0)\"   onclick=\"openEditMenu('"+value+"','"+row.funname+"')\"   ><i class='icon-pencil' title='编辑'></i></a>"
			          
			        }
	                },    
			        {field:'funname',title:'资源名称',width:'30%',align:'center'},    
			        {field:'funmapping',title:'资源路径',width:'40%',align:'center'} ] ;
	$('#sysOrgList').bootstrapTable({
		url : '${ctx}/sys/resource/sysResource/listJson.xf',
	    columns: columns,
	    method:"post",
	    contentType:"application/x-www-form-urlencoded",
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    singleSelect: true,
	    sidePagination:"server",
	    striped:true,
	    queryParams:getSeachJson
	});
	
}
function getSeachJson(params){
	return {'limit':params.limit,'offset':params.offset,'order':params.order,'Q_findKeyword_SL':$("#searchText").val()};
}
function addResource(){
	var row = $('#sysOrgList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var funid=row[0].funid;
		var name =row[0].funname;
		openAddMenu(funid,name);
	}else{
		bootbox.alert('请选择一条记录');
	}	
	
}
function openAddMenu(funpid,name){
	curr_name = name;
	xfui.open_dialog({    
	    title: '添加资源',    
	    width: 800,    
	    height: 400,    
	    closed: false,    
	    cache: false,    
	    url: "${ctx}/sys/resource/sysResource/add.xf?funpid="+funpid,
	    modal: true   
	});
}
function editArticle(){
	var row = $('#sysOrgList').bootstrapTable('getAllSelections');
	//优先左边树选中节点 其次默认checked选中节点
	if(row&&row.length>0){
		var funid=row[0].funid;
		var name = row[0].funname;
// 		xfui.open_tabs("修改机构信息","${ctx}/sys/resource/sysResource/edit.xf?funid="+funid,"修改机构信息");
		openEditMenu(funid,name);
	}else{
		bootbox.alert('请选择一条记录');
	}
}
function getCurrName(){
	return curr_name;
}
var curr_name = '';
function openEditMenu(funid,name){
	curr_name = name;
	xfui.open_dialog({    
	    title: '编辑资源',    
	    width: 800,    
	    height: 400,    
	    closed: false,    
	    cache: false,    
	    url: "${ctx}/sys/resource/sysResource/edit.xf?funid="+funid,
	    modal: true   
	});
}

function editOrgmessage(acd200){
	if(acd200){
		xfui.open_tabs("修改机构信息","${ctx}/sys/resource/sysResource/edit.xf?acd200="+acd200,"修改机构信息");
	}else{
		bootbox.alert('请选择机构信息');
	}
}
function initArticle(){
	$.ajax({ url: '${ctx}/business/cms/article/init.xf',
		dataType:'json',
		success: function(data){
			if(data.message){
				bootbox.alert(data.message);
			}else{
				bootbox.alert("未知错误");
			}

			refreshTable();

		}
	});
}
 
function addArticleColumn(treeNode){
	if(treeNode){
		var funid=treeNode.funid;
		var name = treeNode.funname
// 		xfui.open_tabs("添加资源","${ctx}/sys/resource/sysResource/add.xf?acd200="+acd200,"添加资源"); 
		openAddMenu(funid,name);
	}else{
		bootbox.alert('请选择记录');
	}		
}

function editArticleColumn(treeNode){
	if(treeNode){
		var acd200=treeNode.acd200;
// 		xfui.open_tabs("编辑资源","${ctx}/sys/resource/sysResource/edit.xf?opType=edit&acd200="+acd200,"编辑资源"); 
		var funid=treeNode.funid;
		var name =treeNode.funname;
		openEditMenu(funid,name);
	}else{
		bootbox.alert('请选择记录');
	}		
}

function refreshTree(treeNode){
	var treeObj = $.fn.zTree.getZTreeObj("articleColumnTree");
	treeObj.reAsyncChildNodes(null, "refresh");

}

function refreshTable(){
	if(leftClickTreeNode){
		var acd200=leftClickTreeNode.acd200;
		$('#sysOrgList').bootstrapTable('refresh', {	
			query: {acd200: acd200 }
		});
	}else{
		$('#sysOrgList').bootstrapTable('refresh');
	}
	
	
} 

function refresh(){
	$('#sysOrgList').bootstrapTable('refresh');
	var treeObj = $.fn.zTree.getZTreeObj("articleColumnTree");
	treeObj.reAsyncChildNodes(null, "refresh");
}

function doSearch(){
	$('#searchText').val($.trim($('#searchText').val()));
	var json=$("#searchForm").serializeJson();
	$("#sysOrgList").bootstrapTable('refresh', {	
		query: json
	})
}
function doClear(){
	$("#searchText").val('');
}
</script>
</head>
<body>

<div class="container-fluid">
	<div class="mhyBody">
		<div class="col-md-2 col-xs-3 mhyTree">
			<div class="mhyTitle">资源目录 </div>
			<ul id="articleColumnTree" class="ztree" data-toggle="context" ></ul>
		</div>
		<div class="col-md-10 col-xs-9"  >

				<div class="mhySearch">
				<div class="mhyTitle"> 查询条件 </div>
						<form id="searchForm" class="mhySearchInput">
							<div class="form-group">
								<div class="row">
								<div class="col-xs-12 col-sm-2"></div>
						
								<div class="col-xs-12 col-sm-6 marginbottom20">
									<label class="col-xs-2 col-sm-4" for="inputError">资源名称：</label>
									<div class="col-xs-10 col-sm-8" >
									<input class="form-control" id="searchText" type="text" name="Q_funname_SL" placeholder="资源名称" title="资源名称" data-placement="bottom" />
								</div></div>
								<div class="col-xs-12 col-sm-4 mhySearchRight">
									<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" >
									<i class="icon-search"></i>
									查询</a>
									<a href="#modal-form" role="button" onclick="doClear()" class="btn btn-info" >
									<i class="icon-repeat"></i>
									重置</a>
								</div>
							
							</div>
							</div>
						</form>
			    </div>
<!-- 					<div class="col-xs-12"> -->
<!-- 						<a href="javascript:void(0)" onclick="addResource()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top bigger-125"></i>添加</a> -->
<!-- 						<a href="javascript:void(0)" onclick="editArticle()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>修改</a> -->
<!-- 					</div> -->
				<div class="mhyMain">
						<div class="mhyTitle"> 查询结果 </div>
						<div class="mhyInfo">
<!-- 						<a href="javascript:void(0)" onclick="editFruRole()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>修改角色</a> -->
<!-- 						<a href="javascript:void(0)" onclick="sysRoleUserManager()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>人员管理</a> -->
<!-- 					    <a href="javascript:void(0)" onclick="editUserSec()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>权限分配</a> -->
						<div class="mhyConter">
					  <table id="sysOrgList" class="datagridClass tableClassNoworks"></table>
					</div>
						</div>
				</div>
	</div>
		
	
	</div>
</div>
  <div id="mm">
          <ul class="dropdown-menu" role="menu">
              <li id="add_menu"><a tabindex="-1" menuname="new">添加资源</a></li>
              <li id="edit_menu"><a tabindex="-1" menuname="edit">修改资源</a></li>
          </ul>
        </div>
</body>
</html>