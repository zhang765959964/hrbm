<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 RSDA_BS_PAYMENT_REFUND</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentRefundConfirmEdit.js?version=2016091818179"></script>
</head>
<body>
<form:form modelAttribute="paymentRefundConfirmForm" method="post" action="${ctx}/business/personagency/payment/paymentRefund/confirm.xf">
	<form:hidden path="pkId" ></form:hidden>
	<form:hidden path="fkConfirmsId" ></form:hidden>
	<form:hidden path="fdConfirmsOrgId" ></form:hidden>
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNob change-bg-iframe">
<%-- 				<div class="moduleTit">RSDA_BS_PAYMENT_REFUND</div> --%>
				<div class="moduleCont">
	    			<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">身份证号:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">档案编号:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
						</div>	 								
						<label class="col-xs-3 col-sm-label" for="inputError">退费开始日期:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="fdRefundStartDate" readonly="true"></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">退费结束日期:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="fdRefundEndDate" readonly="true"></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">备注:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="fdRefundDesc" ></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">退费月数:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="fdRefundMonths" readonly="true"></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">退费标准:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="fdRefundStandard" readonly="true"></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">退费金额:</label>
						<div class="col-xs-9 col-sm-input ">
								<form:input  class="form-control" type="text"  path="fdRefundAmount" readonly="true"></form:input>
						</div>
							 
							 
						<label class="col-xs-3 col-sm-label" for="inputError">财务经办人:</label>
						<div class="col-xs-9 col-sm-input ">
								<form:input  class="form-control" type="text"  path="fdConfirmsName" readonly="true"></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">财务经办日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="fdConfirmsDate" readonly="true"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                        </div>									
							 
						<label class="col-xs-3 col-sm-label" for="inputError">财务经办机构:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="fdConfirmsOrgName" readonly="true"></form:input>
						</div>
							 
	    			</div>											
	        						
				</div>
			</div>
		</div>
	 <div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   	    <button type="submit" class="btn btn-primary"><i class="icon-ok"></i>确定退费</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="xfui.closeDialog()"><i class="icon-remove"></i>关闭</a>
	   		
	   	</div>
	   	
	</div>	
 </form:form>	  	  
</body>
</html>
