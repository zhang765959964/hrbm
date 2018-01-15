<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位减免管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpDerateList.js?version=201609181814"></script>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

</head>
<body>

			    <div class="moduleWrapNobg">
				<div class="moduleTit">基本信息</div>
				<div class="moduleCont">
					<form:form modelAttribute="corpForm" >
					     <form:hidden path="aab001" ></form:hidden>
					      
						<div class="row">

							<label class="col-xs-12 col-sm-2" for="inputError">单位名称:</label>
							<div class="col-xs-12 col-sm-6">
								 <form:input  class="form-control" type="text"  path="aab004" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">工商登记执照号码:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="aab007" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">单位协议编号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="uaNo" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">单位协议签订日期:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="uaCreatetime" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">单位联系人:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="uaName" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">联系人电话:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="uaPhone" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">传真:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="bab002" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">经办人身份证号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="uaCard" readonly="true"></form:input>
							</div>
						</div>
						</form:form>
				</div>
			</div>		
				<div class="moduleWrapNob">
				<div class="moduleTit">减免记录</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" id="addPaymentCorpRecord" role="button" class="btn btn-primary" ><i class="icon-plus"></i>添加</a>
						<a href="javascript:void(0)"  id="delPaymentCorpRecord" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
						<a href="javascript:void(0)" id="viewCorpPersonList" role="button" class="btn btn-info" ><i class="icon-search"></i>查看缴费明细</a>
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="paymentCorpRecordList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>				
			<div class="moduleWrapNob">
				<div class="moduleTit">个人减免</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" id="addAllPaymentDerate" role="button" class="btn btn-primary" ><i class="icon-plus"></i>全选批量减免</a>
						<a href="javascript:void(0)"  id="mutiAddPaymentDerate" role="button" class="btn btn-yellow" ><i class="icon-list-ol"></i>多选批量减免</a>
					</div>
					<div class="row">
						<!-- <div class="pd0 moduleWrapNobg"> -->
							<!-- <div class="moduleTit">存档信息</div> -->
							<!-- 查询条件 -->
							<!-- <hr/> -->					
							<!-- 结果列表1 -->
							<!-- <div class="resultWrap">
								<table id="paymentRecordList1"  class="datagridClass"  ></table>
								<div id="jqGridPager1"></div>
							</div> -->
						<!-- </div> -->
						<div class="col-xs-12">
							<table id="paymentRecordList1"  class="datagridClass"  ></table>
							<div id="jqGridPager1"></div>
						</div>
					</div><!-- row end -->
				</div>
			</div>
						
</body>		
</html>


