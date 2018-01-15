<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="/commons/include/commonInc.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
	<link rel="stylesheet" href="${ctx}/styles/erecold/css/navstyle.css" type="text/css">
	<style type="text/css">
		.activeLi a{
			background-color: #F1D031;
		}
	</style>
	<Script language="javascript">
		function loadCataLog(obj){
			var catalogId=$(obj).attr("catalogId");
			$("#catalogId").val(catalogId);
			var personId=$("#personId").val();
			$("#alreadyCollect").load("${ctx}/business/erecord/eArchives/imageView.xf?personId="+personId+"&catalogId="+catalogId);
			$(obj).addClass("selected");
			$(obj).siblings().removeClass("selected");
		}
		
		
		$(function(){
			//loadCataLog(obj);
			$("#rootCat").click();
		})
		
    </script>
<style>

.colLeft{height:900px;}
#alreadyCollect{margin:0 auto 20px;overflow-x:scroll;}
@media (min-width: 992px){
#alreadyCollect{width:900px;}
}
@media (min-width: 1200px){
#alreadyCollect{width:1200px;}
}
@media (max-width: 992px){
#alreadyCollect{width:730px;}
}
@media (max-width:776px){
#alreadyCollect{width:630px;}
}
</style>
</head>
<body class="h100p">
	<div class="container-fluid h100p">
		<div class="row h100p" style="overflow:auto;">
			<div class="col-xs-12 col-sm-2 colLeft">
				<div class="">
					<div class="moduleTit">目录信息</div>
					<ul >
						<li  id="rootCat" onclick="loadCataLog(this)" catalogid=""><a href="#" >全部</a></li>
						<c:forEach var="erecordCatalog" items="${erecordCatalogList}">
							<li onclick="loadCataLog(this)" catalogid="${erecordCatalog.id}">
								<a href="javascript:void(0)" >${erecordCatalog.name}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="col-xs-12 col-sm-10 colRight rgWrap">
				<div class="moduleWrapNobg">
					<div class="moduleTit">档案信息</div>
					<div class="">
						<div id="alreadyCollect"></div>
					</div>
				</div>
			</div>
		</div>
		</div>
<input type="hidden" name="personId" id="personId" value="${eArchivesForm.personId}"/>
</body>
</html>