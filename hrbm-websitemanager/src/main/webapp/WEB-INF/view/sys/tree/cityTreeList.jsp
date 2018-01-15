<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/commons/include/common.jsp" %>
<script>
	$(function(){
		var setting = {
    			view: {
    				dblClickExpand: false
    			},
    			data: {
    				simpleData: {
    					enable: true
    				}
    			},
    			callback: {
    				beforeClick: beforeClick,
    				onClick: onClick
    			},
    			async: {
    				enable: true,
    				url: CTX+"/sys/tree/cityTree.xf",
    				type: "get"
    			},
    		};

    		

    		function beforeClick(treeId, treeNode) {
    			var check = (treeNode && !treeNode.isParent);
    			if (!check) alert("只能选择城市...");
    			return check;
    		}
    		
    		function onClick(e, treeId, treeNode) {
    			console.info(e);
    			console.info(treeId);
    			console.info(treeNode);
    			/*var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
    			nodes = zTree.getSelectedNodes(),
    			v = "";
    			nodes.sort(function compare(a,b){return a.id-b.id;});
    			for (var i=0, l=nodes.length; i<l; i++) {
    				v += nodes[i].name + ",";
    			}
    			if (v.length > 0 ) v = v.subst	ring(0, v.length-1);
    			var cityObj = $("#citySel");
    			cityObj.attr("value", v);*/
    		}

    		 
    		
    		$.fn.zTree.init($("#treeCity"),setting);
	})
</script>
</head>
<body style="height:200px;">
<ul id="treeCity" class="ztree"></ul>


</body>
</html>