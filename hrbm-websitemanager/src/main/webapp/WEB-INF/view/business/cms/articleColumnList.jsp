<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="h100p">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

<title>信息发布</title>
<script>

var rightClickTreeNode=null;
var leftClickTreeNode=null;
var canc01 = 0;
$(function(){
	initTree()
	initTable();
})
 var setting = {
			async : {
				enable : true,
				type : "GET",
				url : function(treeId, node) {
					return "${ctx}/business/cms/articleColumn/treeJson.xf";
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
        	rightClickTreeNode=node
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
        }
 });
}
function  nodeClick(event, treeId, treeNode){debugger;

	var nodeType=treeNode.nodeType;
	if(nodeType=="root"){
		disableOpMenu();
	}else{
		enableOpMenu();
	}
	    canc01=treeNode.canc01;
		leftClickTreeNode=treeNode;
// 	$('#articleList').bootstrapTable('refresh', {
// 		query: {offset:0,canc01: canc01}
// 	});
	$("#articleList").bootstrapTable('refresh', {url:"${ctx}/business/cms/article/listJson.xf?cand09=1&canc01="+canc01});


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
/**
初始化表格显示
*/
function initTable(){
	/**
	 初始化表格显示
	*/
	var columns= [{field:'',title:'Id号',checkbox:'true',align:'center'},{field:'cand01',title:'操作',align:'center',width:50,
   	 formatter: function(value,row,index){
         if (row.cand17==1){
			 return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"cancelStickTop('"+value+"')\" style=\"color: red \"><i class='icon-resize-horizontal' title='取消置顶'></i></a>"+
					 "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"previewArticle('"+value+"')\" ><i class='icon-eye-open' title='浏览'></i></a>";
		 }else{
			 return "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"stickTop('"+value+"')\" ><i class='icon-arrow-up' title='置顶'></i></a>"+
					 "<a class='mhyNoA' href=\"javascript:void(0)\" onclick=\"previewArticle('"+value+"')\" ><i class='icon-eye-open' title='浏览'></i></a>";
		 }

	}
},
	                {field:'cand03',title:'标题',width:250,align:'center'},
	                {field:'ccmu01n',title:'发布人',width:50,align:'center'},
     	        	{field:'cand07',title:'发布时间',width:50,align:'center'},
     	        	{field:'eand05',title:'新闻模式',width:50,align:'center'}
	              	
	        	    ];

	$('#articleList').bootstrapTable({
		url:"${ctx}/business/cms/article/listJson.xf?cand09=1",
	    columns: columns,
	    method:"get",
// 	    contentType:"application/x-www-form-urlencoded",
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    sidePagination:"server",
	    striped:true
	    //queryParams:getSeachJson
	});

}
function getSeachJson(params){
	debugger;
	var json=$("#searchForm").serializeJson();
	json.canc01=canc01;
	json.limit=params.limit;
	json.offset=params.offset;
	json.order=params.order;
	return json;//{'limit':params.limit,'offset':params.offset,'order':params.order,'canc01':canc01};
}

function addArticle(){
	if(leftClickTreeNode&&leftClickTreeNode.nodeType!="root"){
		xfui.open_tabs("添加新闻","${ctx}/business/cms/article/edit.xf?canc01="+leftClickTreeNode.canc01,"信息发布");
	}else{
		bootbox.alert('请先选择非根栏目');
	}

}

function editArticle(){
	var row = $('#articleList').bootstrapTable('getAllSelections');
	if(row&&row.length==1){
		var cand01=row[0].cand01;
		xfui.open_tabs("添加新闻","${ctx}/business/cms/article/edit.xf?cand01="+cand01,"信息发布");

	}else if(row&&row.length>1){
		bootbox.alert('请选择一条记录进行编辑');
	}else{
		bootbox.alert('请选择记录');
	}
}

function delArticle(){
	var row = $('#articleList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var cand01="";
		var delFlag=true;
		$.each(row,function(i,e){
			if(i==0){
				cand01+=e.cand01;
			}else{
				cand01+=","+e.cand01;
			}

		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
		    if (r){
		    	$.ajax({ url: '${ctx}/business/cms/article/del.xf',
		    		data:{cand01:cand01},
		    		dataType:'json',
		    		success: function(data){
		    			debugger;
		    			if(data.message){
		    				bootbox.alert(data.message);
		    			}else{
		    				bootbox.alert("未知错误");
		    			}

		    			refreshTable();

		             }
		    	});
		    }
		}
	});
	  }else{
		  bootbox.alert('请选择记录');
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


function previewArticle(cand01){

	xfui.open_tabs("预览新闻","${ctx}/business/cms/article/preview.xf?cand01="+cand01,"信息发布");

}

function addArticleColumn(treeNode){
	if(treeNode){
		var canc01=treeNode.canc01;
		xfui.open_dialog({
		    title: '新增栏目',
		    width: 800,
		    height: 550,
		    closed: false,
		    cache: false,
		    url: '${ctx}/business/cms/articleColumn/edit.xf?opType=add&canc01='+canc01,
		    modal: true
		})
	}else{
		bootbox.alert('请选择记录');
	}
}

function editArticleColumn(treeNode){
	if(treeNode){
		var canc01=treeNode.canc01;
		xfui.open_dialog({
		    title: '编辑栏目',
		    width: 800,
		    height: 550,
		    closed: false,
		    cache: false,
		    url: '${ctx}/business/cms/articleColumn/edit.xf?opType=edit&canc01='+canc01,
		    modal: true
		})
	}else{
		bootbox.alert('请选择记录');
	}
}

function delArticleColumn(treeNode){
	if(treeNode){
		var canc01=treeNode.canc01;
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
		    if (r){
		    	$.ajax({ url: '${ctx}/business/cms/articleColumn/del.xf',
		    		data:{canc01:canc01},
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
		var canc01=leftClickTreeNode.canc01;
		$('#articleList').bootstrapTable('refresh', {
			query: {canc01: canc01 }
		});
	}else{
		$('#articleList').bootstrapTable('refresh');
	}


}

function refresh(){
	$('#articleList').bootstrapTable('refresh');
}

function doSearch(){

	var params=$("#searchForm").serialize();


	$("#articleList").bootstrapTable('refresh', {url:"${ctx}/business/cms/article/listJson.xf?cand09=1&canc01="+canc01+"&"+params});
}

</script>
</head>
<body class="h100p">
	<div class="container-fluid h100p">
		<div class="row h100p">
			<!-- 左侧树目录 -->
			<div class="col-md-2 col-xs-3 moduleWrap pd0 h100p">
				<div class="moduleTit">信息发布</div>
				<ul id="articleColumnTree" class="moduleCont ztree" data-toggle="context" ></ul>
			</div>
			<!-- 右侧详细内容 -->
			<div class="col-md-10 col-xs-9 h100p colRight">
			 	<div class="moduleWrapNobg">
			 		<div class="moduleTit">查询条件</div>
			 		<div class="moduleCont">
						<form id="searchForm">
							<div class="row">
								<div class="col-xs-1 col-sm-4"></div>
								<div class="col-sm-6 col-xs-6">
									
									<label class="col-xs-2 col-sm-4"> 新闻标题: </label>
									
									<div class="col-sm-8 col-xs-10 marginbottom20">
										<input class="form-control" type="text" name="Q_cand03_SL" placeholder="新闻标题" title="新闻标题" data-placement="bottom" />
									</div>
						
								</div>
												<div class="col-sm-2 col-xs-2">
											<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
											<!-- <a href="#modal-form" role="button" class="btn btn-info" ><i class="icon-repeat"></i>重置</a> -->
										</div>
							</div>
						</form>
					</div>
				</div>
				<!-- 结果列表 -->
				<div class="moduleWrapNob">
					<div class="moduleTit"> 查询结果 </div>
					<div class="moduleCont">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addArticle()" role="button" class="btn btn-primary mhyBtnLeft" data-toggle="modal"><i class="icon-plus"></i>新增</a>
							<a href="javascript:void(0)" onclick="editArticle()" role="button" class="btn btn-info mhyBtnLeft" data-toggle="modal"><i class="icon-pencil"></i>编辑</a>
							<a href="javascript:void(0)" role="button" onclick="delArticle()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash"></i>删除</a>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="articleList" ></table>
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
