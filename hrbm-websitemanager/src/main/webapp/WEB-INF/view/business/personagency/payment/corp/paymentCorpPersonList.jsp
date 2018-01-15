<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>缴费记录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpPersonList.js?version=201609181816"></script>

</head>
<body>
<div class="main-container">
			<div class="container-fluid">
				<div class="row">
				<div class="">
				<div class="moduleCont">
					<div class="row">
						<div class="col-xs-12">
								<table id="paymentRecordList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>
<input id="fkCorpRecordId" type="hidden" value="${fkCorpRecordId}"></input>
<input id="fdDerateStatus" type="hidden" value="${fdDerateStatus}"></input>		
		
</body>		
</html>


