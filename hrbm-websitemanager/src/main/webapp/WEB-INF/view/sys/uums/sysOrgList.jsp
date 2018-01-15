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
<title>机构管理</title>
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
// 	    	var nodeType=node.nodeType;
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
    	   var nodeType=node.nodeType;
    	   if(nodeType=='root'){
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
	var aab034=treeNode.acd200;
	//节点选择 清空关键字检索
	$("#searchText").val('');
	//根目录选择
	if(aab034==0){
		aab034='';
	}
		leftClickTreeNode=treeNode;
	$('#sysOrgList').bootstrapTable('refresh', {	
		query: {aab034: aab034 }
	}); 
	
}
//启用菜单
function enableOpMenu(){
	$.each($("a",$("#dg_toolbar")),function(i,e){
// 		$(e).linkbutton('enable');
	})
	
}
//禁用菜单
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
// 			{
// 				field : '',
// 				title : '选择',
// 				checkbox : 'true',
// 				width : 100,
// 				align : 'center'
// 			},
{
				field : 'acd200',
				title : '操作',
				width : '10%',
				align : 'center',
				formatter : function(value, row, index) {
					return  "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"addOrg('"
					+ value + "')\" ><i class='icon-plus' title='添加'></i></a>"
					+"<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"editOrgmessage('"
							+ value
							+ "')\" ><i class='icon-pencil' title='编辑'></i></a>"
							;
				}
			},
			{
				field : 'acd201',
				title : '许可证编号',
				width : '10%',
				align : 'center'
			},
			{
				field : 'acd202',
				title : '职介机构名称',
				width : '10%',
				align : 'center'
			},
// 			{
// 				field : 'aae007',
// 				title : '邮政编码',
// 				width : 100,
// 				align : 'center'
// 			},
			{
				field : 'acd203Name',
				title : '机构类别',
				width : '10%',
				align : 'center'
			},
			{
				field : 'acd204Name',
				title : '机构性质',
				width : '10%',
				align : 'center'
			},
			{
				field : 'acd20a',
				title : '公开服务电话',
				width : '10%',
				align : 'center'
			},
			{
				field : 'aae004',
				title : '联系人',
				width : '10%',
				align : 'center'
			},
			{
				field : 'aae005',
				title : '联系电话',
				width : '10%',
				align : 'center'
			},
			{
				field : 'ccmu04',
				title : '乘车路线',
				width : '10%',
				align : 'center'
			}
			 ] ;
	$('#sysOrgList').bootstrapTable({
		url : '${ctx}/sys/uums/sysOrg/listJson.xf',
	    columns: columns,
	    method:"post",
	    contentType:"application/x-www-form-urlencoded",
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    singleSelect: true,
	    sidePagination:"server",
	    striped:true
	});
	
}
function addOrg(value){
	xfui.open_tabs("添加机构","${ctx}/sys/uums/sysOrg/add.xf?acd200="+value,"添加机构");
}
function addArticle(){
	var row = $('#sysOrgList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var acd200=row[0].acd200;
		xfui.open_tabs("添加机构","${ctx}/sys/uums/sysOrg/add.xf?acd200="+acd200,"添加机构");
	}else{
		xfui.open_tabs("添加机构","${ctx}/sys/uums/sysOrg/add.xf","添加机构");
	}	
	
}

function editArticle(){
	var row = $('#sysOrgList').bootstrapTable('getAllSelections');
	//优先左边树选中节点 其次默认checked选中节点
	if(row&&row.length>0){
		var acd200=row[0].acd200;
		xfui.open_tabs("修改机构信息","${ctx}/sys/uums/sysOrg/edit.xf?acd200="+acd200,"修改机构信息");

	}else{
		bootbox.alert('请选择机构信息');
	}
}
function editOrgmessage(acd200){
	if(acd200){
		xfui.open_tabs("修改机构信息","${ctx}/sys/uums/sysOrg/edit.xf?acd200="+acd200,"修改机构信息");
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
function stickTop(cand01){
		$.ajax({ url: '${ctx}/business/cms/article/stickTop.xf',
    		data:{cand01:cand01},
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

function cancelStickTop(cand01){
	$.ajax({ url: '${ctx}/business/cms/article/cancelStickTop.xf',
		data:{cand01:cand01},
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
		var acd200=treeNode.acd200;
		xfui.open_tabs("添加机构信息","${ctx}/sys/uums/sysOrg/add.xf?acd200="+acd200,"添加机构信息"); 
// 		xfui.open_dialog({    
// 		    title: '添加机构',    
// 		    width: 800,    
// 		    height: 550,    
// 		    closed: false,    
// 		    cache: false,    
// 		    url: '${ctx}/sys/uums/sysOrg/add.xf',
// 		    modal: true   
// 		})
	}else{
		bootbox.alert('请选择记录');
	}		
}

function editArticleColumn(treeNode){
	if(treeNode){
		var acd200=treeNode.acd200;
		xfui.open_tabs("编辑机构信息","${ctx}/sys/uums/sysOrg/edit.xf?opType=edit&acd200="+acd200,"编辑机构信息"); 
// 		xfui.open_dialog({    
// 		    title: '编辑机构',    
// 		    width: 800,    
// 		    height: 550,    
// 		    closed: false,    
// 		    cache: false,    
// 		    url: '${ctx}/sys/uums/sysOrg/edit.xf?opType=edit&acd200='+acd200,
// 		    modal: true   
// 		})
	}else{
		bootbox.alert('请选择记录');
	}		
}

function delArticleColumn(treeNode){
	if(treeNode){
		var acd200=treeNode.acd200;
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/sys/uums/sysOrg/del.xf',
		    		data:{acd200:acd200},
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message);
		    				refreshTree(treeNode.getParentNode());
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		             }
		    	});
		    }    
		  }
		}); 
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
			<div class="col-md-2 mhyTree">
				<div class="mhyTitle">机构目录</div>
			<ul id="articleColumnTree" class="ztree" data-toggle="context" ></ul>
		</div>
		<div class="col-md-10 col-xs-9"  >
		 <div >
				<div class="mhySearch">
				<div class="mhyTitle"> 查询条件 </div>
						<form id="searchForm" class="mhySearchInput">
							<div class="form-group">
								<div class="row">
									<div class="col-xs-12 col-sm-2"></div>
									<div class="col-xs-12 col-sm-6 marginbottom20">
									<label class="col-xs-2 col-sm-4">查询：</label>
									<div  class="col-xs-10 col-sm-8">
										<input class="form-control" id="searchText" type="text" name="Q_findKeyword_SL" placeholder="机构名称/许可证编号/联系电话" title="机构名称/许可证编号/联系电话" data-placement="bottom" />
									</div></div>
									<div class="col-xs-12 col-sm-4 mhySearchRight">
										<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary mhyBtnLeft" ><i class="icon-search"></i>查询</a>
										<a href="#modal-form" role="button" onclick="doClear()" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
									</div>
								</div>
							</div>
						</form>
					</div>
<!-- 					<div class="col-xs-12"> -->
<!-- 						<a href="javascript:void(0)" onclick="addArticle()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top bigger-125"></i>添加</a> -->
<!-- 						<a href="javascript:void(0)" onclick="editArticle()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-pencil align-top bigger-125"></i>修改</a> -->
<!-- 					</div> -->
					<div class="mhyMain">
						<div class="mhyTitle"> 查询结果 </div>
						<div class="mhyInfo">
					  <table id="sysOrgList" class="datagridClass tableClassNoworks"></table></div>
					</div>
				</div>
		
		</div>
	</div>
</div>
  <div id="mm">
          <ul class="dropdown-menu" role="menu">
              <li id="add_menu"><a tabindex="-1" menuname="new">添加机构</a></li>
              <li id="edit_menu"><a tabindex="-1" menuname="edit">修改机构</a></li>
              <li id="destroy_menu"><a tabindex="-1" menuname="destroy">删除机构</a></li>
          </ul>
        </div>
</body>
</html>