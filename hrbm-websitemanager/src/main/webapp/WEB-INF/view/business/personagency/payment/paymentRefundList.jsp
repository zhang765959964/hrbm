<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>退费记录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">

</head>
<body>
				<div class="moduleWrapNobg">
				<div class="moduleTit">存档信息</div>
				<div class="moduleCont">
					<form:form modelAttribute="archivesPersonForm" method="post" action="">
					   <input type="hidden" id="personId"  value="${personId}"/>
					   <input type="hidden"  value="${lzStatus }" id="lzStatus" />
					   <input type="hidden"  value="${jsStatus }" id="jsStatus" />
					   <input type="hidden"  value="${daStatus }" id="daStatus" />
						<div class="row">

							<label class="col-xs-12 col-sm-2" for="inputError">身份证号码:</label>
							<div class="col-xs-12 col-sm-2">
								 <form:input  class="form-control" type="text"  path="AAC002" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="AAC003" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">联系电话:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">出生日期:</label>
							<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                             	  <form:input  class="form-control" type="text"  path="AAC006" readonly="true"></form:input>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
                           </div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案出生日期:</label>
							<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                              <form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">档案姓名:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">档案接收人:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">档案转入日期:</label>
							<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                             	 <form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                             	 <span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                           </div>

							<label class="col-xs-12 col-sm-2" for="inputError">档案状态:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">手机号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="AAE005" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">存档类型:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">所属单位名称:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">费用缴至日期:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="paymentEndDate" readonly="true"></form:input>
							</div>
							
						</div>
					</form:form>
				</div>
			</div>
		<div class="moduleWrapNob">
				<div class="moduleTit">缴费历史记录</div>
				<div class="moduleCont">
					<div class="row">
						<div class="col-xs-12">
								<table id="paymentRecordList"  class="datagridClass"  ></table>
								<div id="jqGridPager1"></div>
						</div>
					</div>
				</div>
			</div>		
				<div class="moduleWrapNob">
				<div class="moduleTit">退费记录</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" id="addPaymentRefund" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
						<a href="javascript:void(0)" id="editPaymentRefund" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
						<a href="javascript:void(0)" id="delPaymentRefund" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>删除</a>
						<!-- <a href="javascript:void(0)" role="button" onclick="delCorp()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash align-top"></i>删除</a> -->
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="paymentRefundList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentRefundList.js?version=2016091818178"></script>
<script type="text/javascript" src="${ctx}/js/util/date.js"></script>		
<input type="hidden" id="paymentStatus" value="0" />			
</body>		
</html>


