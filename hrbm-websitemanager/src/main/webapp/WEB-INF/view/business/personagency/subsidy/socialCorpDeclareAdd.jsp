<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 单位补贴申报</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialCorpDeclareAdd.js?version=20161124"></script>
</head>
<body>
	<div class="container-fluid">
<!-- 		<div class="row"> -->
			<!-- 单条查询 --> 
<!-- 			<div class="col-xs-12 pd0 tar"> -->
<!-- 			    <div class="col-xs-6 col-sm-6"></div> -->
<!-- 				<div class="col-xs-6 col-sm-6"> -->
<!-- 					<label class="col-xs-3 col-sm-2" for="inputError">查询:</label> -->
<!-- 					<div class="col-xs-6 col-sm-7 pr"> -->
<!-- 						<input class="form-control"  name="corpId" id="corpId" placeholder="请输入批次名称 单位名称" type="text"/> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->

<!-- 		</div> -->
		<div class="tabable" id="tabcontext" ></div>	
		<input type="hidden" id="batchUpdate" value="${batchUpdate}"/>
	</div>	
</body>
</html>
