<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑单位基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <%@include file="/commons/include/commonInc.jsp" %>  
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
		<div class="row">
			<!-- 单条查询 -->
			<div class="col-xs-12 pd0 tar">
				<div class="col-xs-6 col-sm-6">
				</div>
				<div class="col-xs-6 col-sm-6">
					<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
					<div class="col-xs-6 col-sm-7 pr">
						<input class="form-control" type="text" name="aab001" id="aab004"  data-placement="bottom"  placeholder="根据单位名称查询" title="根据单位名称查询"/>
					</div>
				
				</div>
			</div>
		</div>	
			<div class="moduleWrapNobg">
			   <div class="moduleTit">单位基本信息</div>
			   <div class="moduleCont">
			      <c:import url="/WEB-INF/view/business/corp/include/corpEdit_include.jsp">
						<c:param name="corpForm" value="corpForm"/>
						<c:param name="cczy06n" value="${cczy06n}"/>						
				  </c:import>	
			   </div>
			</div>

	</div>
</div>  

</body>
</html>
