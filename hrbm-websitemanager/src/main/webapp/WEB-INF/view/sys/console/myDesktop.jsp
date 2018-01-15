<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="/commons/include/common.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style>
 .cls{
  padding-top:4px;
  padding-left:4px;
  padding-right:4px;
 }
 .menuLi{
 float:left; 
 margin-left:20px; 
  } 
.modelLi{
margin-top:10px;
padding-top:4px;
}
.modelUl{
padding-top:3px;
}
.menuUl{
padding-top:5px;
}
 
</style>
<script>
	/*
	 * @wang 
	 * 初始化工作
	 * */

	$(function() {
// 		$('#pp').portal({width: "auto" ,
// 			height: "auto" ,
// 			border: true ,
// 			fit :true});
		
// 		var p = $("#shortcut"); 
// 		p.panel({    
// 		    title: '快捷办公',    
// 		    height:460,  
// 		    closable: true,    
// 		    collapsible: true,
// 		    cls:'cls'
// 		});  
// 		$('#pp').portal('add', {    
// 		    panel: p,    
// 		    columnIndex: 0    
// 		}); 
	});
	function opShortcutTab(title,href){
		xfui.open_tabs(title,href);
	}
</script>
</head>
<body>

</body>
</html>