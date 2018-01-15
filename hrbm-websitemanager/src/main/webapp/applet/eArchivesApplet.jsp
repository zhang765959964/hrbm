<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>拍照图片预览</title>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<script>
		function closeItem(){
// 			xfui.closeDialog();
			window.close();
		}
        function reLoad(catalogId){
			//var parentIframe=xfui.getParentIframe();
			var parentIframe=window.dialogArguments
			if(parentIframe){
				parentIframe.loadProcessCataLog(catalogId);
				closeItem();
			}
		}
	</script>
	<style>
    	body{margin: 0;padding: 0}
    </style>
</head>

<body style="text-align: center">
<div style="margin-right: auto;margin-left: auto">
<applet code="com.xunfeng.business.erecord.applet.ImageJApplet.class" ARCHIVE ="applet.jar"  width=550px height=600px codebase="." MAYSCRIPT>
	<param name=filePath value='<%=request.getParameter("filePath")%>'>
	<param name=fileName value='<%=request.getParameter("fileName")%>'>
	<param name=personId value="<%=request.getParameter("personId")%>">
	<param name=catalogId value="<%=request.getParameter("catalogId")%>">
	<param name=uploadUrl value="${sysUrl}/websitem/business/erecord/eArchives/fileUpload.xf">
</applet>
</div>
</body>
</html> 