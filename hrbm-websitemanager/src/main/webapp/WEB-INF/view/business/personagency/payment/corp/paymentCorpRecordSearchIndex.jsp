<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 单位协议表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpRecordSearchIndex.js?version=201609181813"></script>
	
</head>
<body>


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
		<div id="unitCorp"></div>	
	</div>
       
</body>
</html>
