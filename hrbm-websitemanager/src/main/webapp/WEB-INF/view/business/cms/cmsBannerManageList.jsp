<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height:95%">
<head>
<title>栏目板块管理 比如快速栏目中的前十个信息名称管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-table-rows/bootstrap-table-reorder-rows.css" type="text/css">
<script type="text/javascript" src="${ctx}/js/lib/bootstrap-table-rows/bootstrap-table-reorder-rows.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/bootstrap-table-rows/jquery.tablednd.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.core-3.5.js"></script>

<style type="text/css">
.select{
	background-color: #d9edf7;
}
.select a{color:#393939;}
.right>div>div{
    border-color: #ffffff;
}
.right{
	border:1px solid #95B8E7;
	height:650px;
	float:left;
	width:25%;
}
.center{
   border-top:1px solid #95B8E7;
   border-bottom:1px solid #95B8E7;
   height:450px;
   float:left;
   width:10%;
   text-align:center;
   padding-top:200px;
}
.left{
  border:1px solid #95B8E7;
  height:650px;
  float:left;
  width:23%;
  padding-left: 31px;
}
</style>
<script>
var treeObj = null;
var indent ='fc';
$(function(){
	initTree();
	$('#rightGrid').bootstrapTable({
	    url:'${ctx}/business/cms/cmsBannerManage/listJson.xf?indent='+indent,
// 	    columns: columns,
// 	    method:"post",
// 	    contentType:"application/x-www-form-urlencoded",
// 		pagination:true,
// 		pageSize:10,
// 		pageList:[10, 15, 20],
        reorderableRows:true,
        useRowAttrFunc:true,
	    clickToSelect:true,
	    sidePagination:"server",
	    striped:true,
        columns:[
            {field:'code',title:'',width:30,checkbox:true},
            {field:'cmsname',title:'标题',width:200,align:'center'}

        ],onReorderRowsDrop	:function(){
        	var rowsArray = $("#rightGrid").bootstrapTable('getData');
    		sortrowNum(rowsArray);
		}
	});
	$("#saveSortButton").click(function(){
		var rowsArray = $("#rightGrid").bootstrapTable('getData');
		sortrowNum(rowsArray);
	});
	$("#LeftToRightButton").click(function(){
		//debugger;
		var rowsArray = $('#rightGrid').bootstrapTable('getData');
		/* if(rowsArray.length>=10){
			bootbox.alert("已经添加了十条栏目了，你可以删除以后再增加");
			return;
		} */
		if(rowsArray.length>=12){
			bootbox.alert("已经添加了12条栏目了，你可以删除以后再增加");
			return;
		}
	    var nodes = treeObj.getSelectedNodes();
		if(nodes.length<=0){
			bootbox.alert('请选中你要的行数');
			return;
		}
		var id=[];
		var cmsname=[];
		for(var i=0;i<nodes.length;i++){
			id.push(nodes[i].id);
			cmsname.push(nodes[i].name);
		}
		var url = "${ctx}/business/cms/cmsBannerManage/save.xf?indent="+indent+"&cmsid="+id.join(",")+"&cmsname="+encodeURI(encodeURI(cmsname.join(",")));
		$.post(url,function(data){
			data = eval("("+data+")");
			if(data.result == 1){
				$('#rightGrid').bootstrapTable('refresh');
				treeObj.reAsyncChildNodes(null, "refresh");
			}else{
				bootbox.alert('操作失败了');
			}
		});
	});
	$("#rightToLeftButton").click(function(){
		var rowArray = $('#rightGrid').bootstrapTable("getAllSelections");
		if(rowArray.length<=0){
			bootbox.alert('请选中你要的行数');
			return;
		}
		var id=[];
		for(var i=0;i<rowArray.length;i++){
			id.push(rowArray[i].id);
		}
		var url = "${ctx}/business/cms/cmsBannerManage/del.xf?id="+id.join(",");
		$.post(url,function(data){
			if(data.result==1){
				$('#rightGrid').bootstrapTable('refresh');
				//treeObj.refresh();
				treeObj.reAsyncChildNodes(null, "refresh");
			}else{
				bootbox.alert('操作失败了');
			}
		});
	});
	 //注册频道点击事件
	$(".channel").click(function(){
		var obj = $(this);
		$(".channel").removeClass("select");
		obj.addClass("select");
		indent = obj.attr("data-val");debugger;
		if(!indent){indent='fc';}
		$('#rightGrid').bootstrapTable("refresh",{
		    url:'${ctx}/business/cms/cmsBannerManage/listJson.xf?indent='+indent
		});
		treeObj.reAsyncChildNodes(null, "refresh");

	});
});
var setting = {
		async : {
			enable : true,
			type : "GET",
			url : function(treeId, node) {
				return "${ctx}/business/cms/articleColumn/listLeftJson.xf?indent="+indent;
			},
			dataFilter : function(treeId, parentNode, childNodes) {
				return childNodes;
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
	treeObj = $.fn.zTree.init($("#articleColumnTree"), setting);
}
function sortrowNum(rowsArray){
	if(!rowsArray || rowsArray.length<=0){
		return;
	}else{
		var id =[];
		for(var i = 0;i<rowsArray.length;i++){
			id.push(rowsArray[i].id);
		}
		if(id.length>0){
			var url = "${ctx}/business/cms/cmsBannerManage/sortOrderNum.xf";
			$.post(url,{id:id.join(",")},function(data){
				data = eval("("+data+")");
				if(data.result == 1){
					bootbox.alert('排序已保存');
				}else{
					bootbox.alert('操作失败了');
				}
			});
		}
	}
}
</script>
</head>
<body class="h100p">
	<!-- 布局 -->
<!-- 	<div class="easyui-layout" data-options="fit:true,border:false">    -->
<!-- 	    <div data-options="region:'west',title:'栏目选择',split:true" style="width:220px;"> -->
<!-- 	    	<div style="margin-top:20px;text-align:center; font-size:15px;"> -->
<!-- 		    	<div class="channel select" data-val="fc"> -->
<!-- 		    		<a  href="#" >快速通道</a> -->
<!-- 		    	</div> -->
<!-- 		    	<div class="channel" data-val="cjob"> -->
<!-- 		    		<a  href="#" >大学生择业</a> -->
<!-- 		    	</div> -->
<!-- 	    	</div> -->
<!-- 	    </div>    -->
<!-- 	    <div data-options="region:'center',title:'标题选择'" style="padding-left:40px;padding-top:50px;" > -->
<!-- 	    	<div class="left"> -->
<!-- 				<ul id="articleColumnTree" class="ztree"></ul> -->
<!-- 			</div> -->
<!-- 	    	<div class="center"> -->
<!-- 	    		<div id="LeftToRightButton"><a href="#" class="easyui-linkbutton" style="width:50px;" >>></a></div><br/>   -->
<!-- 	    		<div id="rightToLeftButton"><a href="#" class="easyui-linkbutton" style="width:50px;"><<</a></div> -->
<!-- 			</div> -->
<!-- 	    	<div class="right"> -->
<!-- 	    		<div id="rightGrid"></div> -->
<!-- 	    	</div> -->
<!-- 	    </div>    -->
<!-- 	</div> -->
	<div class="container-fluid h100p">
		<div class="row h100p">
			<div class="col-xs-5 col-sm-3 col-md-2 moduleWrap h100p">
		    	<div class="moduleTit">快速导航设置</div>
		    	<div class="channel ellipsis select" data-val="fc" title="快速通道">
		    		<a  href="#" >快速通道</a>
		    	</div>
<!-- 		    	<div class="channel ellipsis " data-val="cjob"> -->
<!-- 		    		<a  href="#" >大学生择业</a> -->
<!-- 		    	</div> -->
			</div>

			<div class=" col-xs-7 col-sm-8 col-md-8 colRight h100p">
				<div class="h100p bdblue">
					<div class="col-md-4 col-xs-4 h100p">
                        <ul id="articleColumnTree" class="ztree"></ul>
					</div>
					<div class="col-md-4 col-xs-3 h100p lrbtn">
                        <div class="mgt200">
				    		<div id="LeftToRightButton"><a href="javascript:void(0)"  role="button" class="btn btn-primary" ><i class="icon-plus align-top bigger-125"></i>添加</a></div><br/>
				    		<div id="rightToLeftButton"><a href="javascript:void(0)"  role="button" class="btn btn-danger" ><i class="icon-trash align-top bigger-125"></i>移除</a></div><br/>
						  </div>
					</div>
					<div class="col-md-4 col-xs-4 h100p">
					  <table id="rightGrid" ></table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


