<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>缴费记录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentRecordIndex.js?v=201608180932"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.idcard.js?v=201609191640"></script>
<script type="text/javascript" src="${ctx}/js/ui/xf.seccard.js?v=201609191639"></script>
<script>

</script>
</head>
<body>
<!-- <OBJECT ID="Ctl" WIDTH="0" HEIGHT="0" CLASSID="CLSID:2B44A159-C1D6-4ED2-A3E6-0FD1708ADE09"></OBJECT> -->
		<div class="main-container">
			<div class="container-fluid">
				<div class="row">
				 <div class="col-xs-12 pd0 tar" >
					<div class="col-xs-6 col-sm-6">
						<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal" id="seccard">社保卡已配置</a>
						<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal" id="idcard">身份证未配置</a>
					</div>
					<div class="col-xs-6 col-sm-6">
						<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
						<div class="col-xs-6 col-sm-7 pr">
							<input class="form-control"  name="personSearch" id="personSearch" placeholder="请输入身份证号 姓名 档案编号" type="text"/>
							<!-- 多条结果 -->
						</div>				
					</div>
				</div>
				
				</div>
				<div id="paymentList"></div>
				<input type="hidden" id="type" value="${type}" />
			</div>
		</div>
</body>		
</html>