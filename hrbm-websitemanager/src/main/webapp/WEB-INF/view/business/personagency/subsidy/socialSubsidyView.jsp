<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 社保补贴</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<style>
    .monthNum{display:inline-block;width:50px;vertical-align:top;line-height:20px;height:30px;}
    .deteWith{min-width:70px}
	</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
          <form:form modelAttribute="socialSubsidyForm" method="post" action="${ctx}/business/personagency/subsidy/socialSubsidy/save.xf">
	<form:hidden path="id" ></form:hidden>
	<form:hidden path="aac001" ></form:hidden>
	<form:hidden path="createrId" ></form:hidden>
	<form:hidden path="createrOrgId" ></form:hidden>
	<div class="moduleWrapNobg">
		<div class="moduleTit">个人基本信息</div>
		<div class="moduleCont">
			<div class="row" >
				<label class="col-xs-3 col-sm-2" for="inputError">身份证号：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-2" for="inputError">姓名：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">性别：</label>
				<div class="col-xs-9 col-sm-2 ">
					<form:select path="aac004" class="form-control" disabled="true" ><form:option value="1">男</form:option><form:option value="2">女</form:option></form:select>
				</div>
				</div>
				<div class="row" >
				<label class="col-xs-3 col-sm-2" for="inputError">年龄：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="userAge" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">出生日期：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="aac006" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案编号：</label>
				<div class="col-xs-9 col-sm-2 ">

				   <form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
				</div>
				</div>
				<div class="row" >
				<label class="col-xs-3 col-sm-2" for="inputError">联系电话：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>

				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">手机号：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="aae005" readonly="true"></form:input>

				</div>
<!-- 				<label class="col-xs-3 col-sm-2" for="inputError">社保联系电话：</label> -->
<!-- 				<div class="col-xs-9 col-sm-2 "> -->
<%-- 					 <form:input  class="form-control" type="text"  path="" ></form:input> --%>

<!-- 				</div> -->
				<label class="col-xs-3 col-sm-2" for="inputError">再就业优惠证编号：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="expRegisgration" readonly="true"></form:input>
				</div>
				</div>
				<div class="row" >
<!-- 				<label class="col-xs-3 col-sm-2" for="inputError">优惠证全省统一证号：</label> -->
<!-- 				<div class="col-xs-9 col-sm-2 "> -->
<%-- 					 <form:input  class="form-control" type="text"  path="" ></form:input> --%>
<!-- 				</div> -->
				<label class="col-xs-3 col-sm-2" for="inputError">是否就业困难人员：</label>
				<div class="col-xs-9 col-sm-2 ">

				   <form:select  class="form-control" type="text"  path="expIsDifficult"  disabled="true" >
				     <form:option value="0">否</form:option>
				     <form:option value="1">是</form:option>
				   </form:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">就业困难人员类别：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <xf:select name="expHardPerson"  selectClass="form-control" disabled="true"  hasDefault="0" textField="name" tableName="TAB_EDO" valueField="code" value="${socialSubsidyForm.expHardPerson}"></xf:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">就业失业登记证号码：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="acc0m1" readonly="true"></form:input>
				</div>
				</div>
				
<!-- 				<label class="col-xs-3 col-sm-2" for="inputError">省统一编码：</label> -->
<!-- 				<div class="col-xs-9 col-sm-2"> -->
<%-- 				   <form:input  class="form-control" type="text"  path="" ></form:input> --%>
<!-- 				</div> -->
			</div>
		</div>

	<div class="moduleWrapNobg">
		<div class="moduleTit">社保补贴信息</div>
		<div class="moduleCont pdl10">
	    	<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">编号：</label>
				<div class="col-xs-9 col-sm-12p5">
					 <form:input  class="form-control" type="text"  path="subsidyNum" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">老编号：</label>
				<div class="col-xs-9 col-sm-12p5">
					 <form:input  class="form-control" type="text"  path="oldSubsidyNum" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">补贴年度：</label>
				<div class="col-xs-9 col-sm-12p5">
				   <input class="form-control colorBlue" type="text" value="${socialSubsidyForm.annualYear} 年度" placeholder="${socialSubsidyForm.annualYear} 年度" readonly="readonly" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-9 col-sm-9 tac">
					 ${socialSubsidyForm.annualYear}  年度
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">养老保险补贴月数：</label>
				<div class="col-xs-9 col-sm-12p5 required">
					 <form:input  class="form-control" type="text"  path="pensionTotalMonths" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-12p5" for="inputError" title="上一年度养老保险缴费情况">上一年度养老保险缴费情况:</label>
				<div class="col-xs-9 col-sm-62p5">
					<div class="input-group">
						<xf:check enumName="com.xunfeng.business.personagency.subsidy.web.enumeration.MonthsEnum" name="pensionMonths" value="${socialSubsidyForm.pensionMonths}"></xf:check>
					</div>
				</div>
				<div class="col-xs-12 col-sm-25p">
<!-- 				    <div class="input-group mgauto all-button"> -->
<!-- 						<button type="button" id="pensionAllsel">全选</button> -->
<!-- 						<button type="button" id="pensionAllNosel">全不选</button> -->
<!-- 					</div> -->
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-12p5" for="inputError">养老补贴标准：</label>
				<div class="col-xs-9 col-sm-12p5 required">
					<form:input  class="form-control" type="text"  path="pensionStandard" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">养老补贴开始年份：</label>
				<div class="col-xs-9 col-sm-12p5">
				   <div class="input-group required">
					<form:input  class="form-control deteWith" type="text"  path="pensionStartDate" readonly="true" ></form:input>
					</div>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">养老补贴结束年份：</label>
				<div class="col-xs-9 col-sm-12p5">
				   <div class="input-group required">
					<form:input  class="form-control deteWith" type="text"  path="pensionEndDate" readonly="true"></form:input>
				  </div>	
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">养老补贴金额：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text"  path="pensionAmount" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<!-- <label class="col-xs-3 col-sm-12p5" for="inputError"></label> -->
				<div class="col-xs-9 col-sm-9 tac">
					${socialSubsidyForm.annualYear}年度
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">医疗保险补贴月数：</label>
				<div class="col-xs-9 col-sm-12p5 required">
					<form:input  class="form-control" type="text"  path="medicalTotalMonths" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-12p5" for="inputError">上一年度医疗保险缴费情况：</label>
				<div class="col-xs-9 col-sm-62p5">
					<div class="input-group">
						<xf:check enumName="com.xunfeng.business.personagency.subsidy.web.enumeration.MonthsEnum" name="medicalMonths" value="${socialSubsidyForm.medicalMonths}"></xf:check>
					</div>
				</div>
				<!-- <label class="col-xs-3 col-sm-12p5" for="inputError"></label> -->
				<div class="col-xs-9 col-sm-25p">
<!-- 					<div class="input-group mgauto all-button"> -->
<!-- 						<button type="button" id="medicalAllsel">全选</button> -->
<!-- 						<button type="button" id="medicalAllNosel">全不选</button> -->
<!-- 					</div> -->
				</div>
		    </div>
		    <div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">医疗补贴标准：</label>
				<div class="col-xs-9 col-sm-12p5 required">
					<form:input  class="form-control" type="text"  path="medicalStandard" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">医疗补贴开始年份：</label>
				<div class="col-xs-9 col-sm-12p5">
				   <div class="input-group required">
					<form:input  class="form-control deteWith" type="text"  path="medicalStartDate" readonly="true"></form:input>
				  </div>	
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">医疗补贴结束年份：</label>
				<div class="col-xs-9 col-sm-12p5">
				   <div class="input-group required">
					<form:input  class="form-control deteWith" type="text"  path="medicalEndDate" readonly="true"></form:input>
					</div>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">医疗补贴金额：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text"  path="medicalAmount" readonly="true"></form:input>
				</div>
			</div>
			 <div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError"></label>
				<div class="col-xs-9 col-sm-12p5 required">
					
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError"></label>
				<div class="col-xs-9 col-sm-12p5 input-group required">
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError"></label>
				<div class="col-xs-9 col-sm-12p5 input-group required">

				</div>

				<label class="col-xs-3 col-sm-12p5" for="inputError">合计补贴金额：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text"  path="totalAmount" readonly="true"></form:input>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">签订劳动合同开始时间：</label>
				<div class="col-xs-9 col-sm-12p5 input-group">
					<form:input  class="form-control deteWith" type="text"  path="contractSignDate" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-12p5" for="inputError">签订劳动合同终止时间：</label>
				<div class="col-xs-9 col-sm-12p5 input-group">
					<form:input  class="form-control deteWith" type="text"  path="contractEndDate" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-12p5" for="inputError">劳动合同解除日期：</label>
				<div class="col-xs-9 col-sm-12p5 input-group">
						<form:input  class="form-control deteWith" type="text"  path="contractDestoryDate" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-12p5" for="inputError">是否通过：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:select path="isPassed" class="form-control"><form:option value="0">不通过</form:option><form:option value="1">通过</form:option></form:select>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">审核标记：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<c:choose>
						<c:when test="${socialSubsidyForm.checkState==0}">未审核</c:when>
						<c:otherwise>已审核</c:otherwise>
					</c:choose>
					<form:hidden path="checkState" ></form:hidden>
				</div>

				<label class="col-xs-3 col-sm-12p5" for="inputError">开户银行：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="bankName" readonly="true"></form:input>
				</div>

				<label class="col-xs-3 col-sm-12p5" for="inputError">银行帐号：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="bankCardNo" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">是否持有营业执照：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:select path="isHasBusLic" class="form-control"><form:option value="0">否</form:option><form:option value="1">是</form:option></form:select>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">营业执照编号：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="busLicNum" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">已在外单位享受补贴月数：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="outerSubsidyMonths" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">登记次数：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					 <form:input  class="form-control" type="text"  path="createrNum" readonly="true"></form:input>

				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">原工作单位：</label>
				<div class="col-xs-9 col-sm-10 ">
					 <form:input  class="form-control" type="text"  path="expOldCompany" readonly="true"></form:input>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">备注：</label>
				<div class="col-xs-9 col-sm-10 ">
					 <form:input  class="form-control" type="text"  path="description" readonly="true"></form:input>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">经办人名称：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					 <form:input  class="form-control " type="text"  path="createrName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">经办日期：</label>
				<div class="col-xs-9 col-sm-12p5 input-group">
				    <form:input  class="form-control deteWith" type="text"  path="createrDate" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">经办机构名称：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					 <form:input  class="form-control " type="text"  path="createrOrgName" readonly="true"></form:input>
				</div>
	     </div>
	   </div>
	</div>
</form:form>
          
			
		</div>

	</div>			
		
</body>
</html>

