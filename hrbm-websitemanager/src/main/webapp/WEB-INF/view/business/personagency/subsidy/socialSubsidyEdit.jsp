<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialSubsidyEdit.js?version=20161147"></script>
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
					 <form:input  class="form-control" type="text"  path="expPersonPhone" ></form:input>

				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">手机号：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="aae005" ></form:input>

				</div>
<!-- 				<label class="col-xs-3 col-sm-2" for="inputError">社保联系电话：</label> -->
<!-- 				<div class="col-xs-9 col-sm-2 "> -->
<%-- 					 <form:input  class="form-control" type="text"  path="" ></form:input> --%>

<!-- 				</div> -->
				<label class="col-xs-3 col-sm-2" for="inputError">再就业优惠证编号：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="expRegisgration" ></form:input>
				</div>
				</div>
				<div class="row" >
<!-- 				<label class="col-xs-3 col-sm-2" for="inputError">优惠证全省统一证号：</label> -->
<!-- 				<div class="col-xs-9 col-sm-2 "> -->
<%-- 					 <form:input  class="form-control" type="text"  path="" ></form:input> --%>
<!-- 				</div> -->
				<label class="col-xs-3 col-sm-2" for="inputError">是否就业困难人员：</label>
				<div class="col-xs-9 col-sm-2 ">

				   <form:select  class="form-control" type="text"  path="expIsDifficult"   >
				     <form:option value="0">否</form:option>
				     <form:option value="1">是</form:option>
				   </form:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">就业困难人员类别：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <xf:select name="expHardPerson"  selectClass="form-control"   hasDefault="0" textField="name" tableName="TAB_EDO" valueField="code" value="${socialSubsidyForm.expHardPerson}"></xf:select>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">就业失业登记证号码：</label>
				<div class="col-xs-9 col-sm-2 ">
					 <form:input  class="form-control" type="text"  path="acc0m1" ></form:input>
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
					 <form:input  class="form-control" type="text"  path="oldSubsidyNum" ></form:input>
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
				<div class="col-xs-9 col-sm-12p5 ">
					 <form:input  class="form-control" type="text"  title="养老保险补贴月数" path="pensionTotalMonths" readonly="true"></form:input>
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
				    <div class="input-group mgauto all-button">
						<button type="button" id="pensionAllsel">全选</button>
						<button type="button" id="pensionAllNosel">全不选</button>
					</div>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-12p5" title="养老补贴标准" for="inputError">养老补贴标准：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text" title="养老补贴标准" path="pensionStandard" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="养老补贴开始年份" for="inputError">养老补贴开始年份：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<div class="input-group row   required">
						<form:input  class="form-control" type="text"  path="pensionStartDate" ></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="养老补贴结束年份" for="inputError">养老补贴结束年份：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<div class="input-group row   required">
						<form:input  class="form-control" type="text"   path="pensionEndDate" ></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="养老补贴金额" for="inputError">养老补贴金额：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text"   path="pensionAmount" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<!-- <label class="col-xs-3 col-sm-12p5" for="inputError"></label> -->
				<div class="col-xs-9 col-sm-9 tac">
					${socialSubsidyForm.annualYear}年度
				</div>
				<label class="col-xs-3 col-sm-12p5" title="医疗保险补贴月数" for="inputError">医疗保险补贴月数：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text"   path="medicalTotalMonths" readonly="true"></form:input>
				</div>
			</div>
			<div class="row">
				<label class="col-xs-3 col-sm-12p5" title="上一年度医疗保险缴费情况" for="inputError">上一年度医疗保险缴费情况：</label>
				<div class="col-xs-9 col-sm-62p5">
					<div class="input-group">
						<xf:check enumName="com.xunfeng.business.personagency.subsidy.web.enumeration.MonthsEnum" name="medicalMonths" value="${socialSubsidyForm.medicalMonths}"></xf:check>
					</div>
				</div>
				<!-- <label class="col-xs-3 col-sm-12p5" for="inputError"></label> -->
				<div class="col-xs-9 col-sm-25p">
					<div class="input-group mgauto all-button">
						<button type="button" id="medicalAllsel">全选</button>
						<button type="button" id="medicalAllNosel">全不选</button>
					</div>
				</div>
		    </div>
		    <div class="row" >
				<label class="col-xs-3 col-sm-12p5" title="医疗补贴标准"  for="inputError">医疗补贴标准：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text"  path="medicalStandard" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="医疗补贴开始年份"  for="inputError">医疗补贴开始年份：</label>
				<div class="col-xs-9 col-sm-12p5  ">
					<div class="input-group row ">
						<form:input  class="form-control" type="text"  path="medicalStartDate" ></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="医疗补贴结束年份" for="inputError">医疗补贴结束年份：</label>
				<div class="col-xs-9 col-sm-12p5  ">
					<div class="input-group row ">
						<form:input  class="form-control" type="text"  path="medicalEndDate" ></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="医疗补贴金额" for="inputError">医疗补贴金额：</label>
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

				<label class="col-xs-3 col-sm-12p5" title="合计补贴金额" for="inputError">合计补贴金额：</label>
				<div class="col-xs-9 col-sm-12p5">
					<form:input  class="form-control" type="text"  path="totalAmount" readonly="true"></form:input>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" title="签订劳动合同开始时间" for="inputError">签订劳动合同开始时间：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<div class="input-group row  ">	
						<form:input  class="form-control" type="text"  path="contractSignDate" ></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>

				<label class="col-xs-3 col-sm-12p5" title="签订劳动合同终止时间" for="inputError">签订劳动合同终止时间：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<div class="input-group row  ">
						<form:input  class="form-control" type="text"  path="contractEndDate" ></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</div>

				<label class="col-xs-3 col-sm-12p5" title="劳动合同解除日期" for="inputError">劳动合同解除日期：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<div class="input-group row  ">
						<form:input  class="form-control" type="text"  path="contractDestoryDate" ></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>	
				</div>

				<label class="col-xs-3 col-sm-12p5" for="inputError">是否通过：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:select path="isPassed" class="form-control"><form:option value="0">不通过</form:option><form:option value="1">通过</form:option></form:select>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" title="审核标记"  for="inputError">审核标记：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<c:choose>
						<c:when test="${socialSubsidyForm.checkState==0}">未审核</c:when>
						<c:otherwise>已审核</c:otherwise>
					</c:choose>
					<form:hidden path="checkState" ></form:hidden>
				</div>

				<label class="col-xs-3 col-sm-12p5" title="开户银行" for="inputError">开户银行：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="bankName" ></form:input>
				</div>

				<label class="col-xs-3 col-sm-12p5" title="银行帐号" for="inputError">银行帐号：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="bankCardNo" ></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="是否持有营业执照" for="inputError">是否持有营业执照：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:select path="isHasBusLic" class="form-control"><form:option value="0">否</form:option><form:option value="1">是</form:option></form:select>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" title="营业执照编号" for="inputError">营业执照编号：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="busLicNum" ></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="已在外单位享受补贴月数" for="inputError">已在外单位享受补贴月数：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					<form:input  class="form-control" type="text"  path="outerSubsidyMonths" ></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" title="登记次数" for="inputError">登记次数：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					 <form:input  class="form-control" type="text"  path="createrNum" readonly="true"></form:input>

				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" title="原工作单位"  for="inputError">原工作单位：</label>
				<div class="col-xs-9 col-sm-10 ">
					 <form:input  class="form-control" type="text"  path="expOldCompany" ></form:input>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">备注：</label>
				<div class="col-xs-9 col-sm-10 ">
					 <form:input  class="form-control" type="text"  path="description" ></form:input>
				</div>
			</div>
			<div class="row" >
				<label class="col-xs-3 col-sm-12p5" for="inputError">经办人名称：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					 <form:input  class="form-control " type="text"  path="createrName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">经办日期：</label>
				<div class="col-xs-9 col-sm-12p5 input-group">
				    <form:input  class="form-control " type="text"  path="createrDate" readonly="true"></form:input>
						<span class="input-group-addon">
							<i class="icon-calendar bigger-110"></i>
						</span>
				</div>
				<label class="col-xs-3 col-sm-12p5" for="inputError">经办机构名称：</label>
				<div class="col-xs-9 col-sm-12p5 ">
					 <form:input  class="form-control " type="text"  path="createrOrgName" readonly="true"></form:input>
				</div>
	     </div>
	   </div>
	</div>
	<div class="h60">&nbsp;</div>
   	<div class="floatBtn">
	    <button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
   		<a href="javascript:addItem()" role="button" class="btn btn-info" id=""><i class="icon-plus"></i>新增</a>
   	</div>
</form:form>
<input id="currentPersonId" type="hidden" value="${currentPersonId}"></input>
<input type="hidden"  value="${lzStatus }" id="lzStatus" />
<input type="hidden"  value="${jsStatus }" id="jsStatus" />
<input type="hidden"  value="${daStatus }" id="daStatus" />
