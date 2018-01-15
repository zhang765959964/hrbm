<%@page language="java" pageEncoding="UTF-8"%>
<%@page import="com.xunfeng.core.web.controller.BaseController"%>
<%@page import="com.xunfeng.core.web.ResultMessage"%>

<%
ResultMessage _obj_=(ResultMessage)session.getAttribute(BaseController.Message);
if(_obj_!=null){
	session.removeAttribute(BaseController.Message);
%>
<script type="text/javascript">
$(function(){
	bootbox.alert('<%=_obj_.getMessage()%>');
	
});
</script>
<%
} %>



