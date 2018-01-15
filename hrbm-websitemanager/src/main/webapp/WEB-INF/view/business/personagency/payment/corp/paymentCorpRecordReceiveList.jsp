<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>存档费缴费管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpRecordReceiveList.js?version=201609181815"></script>

</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="row">
				<div class="moduleWrapNob">
				<div class="moduleTit">单位费用实收</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:refresh()"  role="button" class="btn btn-yellow" ><i class="icon-refresh"></i>刷新</a>
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="paymentCorpRecordList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
				</div>
			</div>
		</div>
</body>		
</html>


