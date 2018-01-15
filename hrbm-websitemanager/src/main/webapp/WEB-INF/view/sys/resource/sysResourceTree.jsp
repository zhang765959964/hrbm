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
	<script type="text/javascript" src="${ctx}/js/lib/ztree/jquery.ztree.excheck-3.5.js"></script>
	<script>
	$(function(){
		initTree();
	})
    var setting = {
			async : {
				enable : true,
				type : "GET",
				url : function(treeId, node) {
					return "${ctx}/sys/resource/sysResource/resTreeJson.xf?roleId=${roleId}";
				}
			},
			callback: {
				onAsyncSuccess: function (event, treeId, treeNode, msg) {
				    var treeObj = $.fn.zTree.getZTreeObj(treeId);
				    treeObj.expandAll(true);
// 				    var node = treeObj.getNodeByParam("resAlias", 'ROOTRES', null);
// 				    if(node){
// 				    	treeObj.expandNode(node, true, true, true);
// 				    }
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
				chkboxType : {"Y":"ps","N":"ps"},
				chkStyle : "checkbox",
				radioType : "all"
			}
		}

function initTree(){

	$.fn.zTree.init($("#resTree"), setting);

}
function  setSelResource(){
	var treeObj = $.fn.zTree.getZTreeObj("resTree");
	var nodes = treeObj.getCheckedNodes(true);
	var roleId=$("#roleId").val();
	var resIds="";
	$.each(nodes,function(i,e){

		if(i==0){
			resIds+=e.id;
		}else{
			resIds+=","+e.id;
		}
	})
    $.post("${ctx}/sys/resource/sysResource/saveTree.xf", {roleId:roleId,resIds:resIds}, function(data) {
        $(".btn-submit").removeAttr("disabled");
        bootbox.alert({
            size: 'small',
            width:"100px",
            message: data.message,
            callback: function(){
            	var parentIframe=xfui.getParentIframe();
		    	if(parentIframe){
		    		parentIframe.refresh();
		    	}
		    	closeResWindow();
            }
        })

    }, 'json');


 }
	function closeResWindow(){
		xfui.closeDialog();
	}
</script>
</head>
<body>
<div class="container-fluid">
	<div class="row" style="height: 100%">
		<div class="col-md-12"  style="border: 0px solid #8C8C8C;height:100%;width:100%; background-color: #f2f2f2;">
			<ul id="resTree" class="ztree" data-toggle="context" ></ul>
		</div></div></div>
	<input type="hidden" id="roleId" value='${roleId}'/>
		<div class="bottomBtn">
	        <div class="h60">&nbsp;</div>
	        <div class="floatBtn">
	          <a href="javascript:void(0)" role="button" class="btn btn-primary mhyBtnLeft"     onclick="setSelResource()">
	   <i class="icon-save"></i>       
	          保存</a>
	          <a href="javascript:void(0)" role="button" class="btn btn-info"  onclick="closeResWindow()">
	   <i class="icon-remove"></i>         
	          关闭</a>
	        </div>
	    </div>
</body>
</html>
