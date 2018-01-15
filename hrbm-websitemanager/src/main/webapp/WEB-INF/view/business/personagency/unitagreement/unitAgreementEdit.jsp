<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位协议签订</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<script type="text/javascript" src="${ctx}/js/business/personagency/unitagreement/unitAgreementEdit.js?version=201612021432"></script>
	<form:form modelAttribute="unitAgreementForm" method="post" action="${ctx}/business/unitagreement/save.xf">
		<!-- <div class="row"> -->
		<div class="moduleWrapNobg">
			<div class="moduleTit">单位基本信息</div>
			<div class="moduleCont">
				<input type="hidden" id="uaStatus" value="${uaStatus}" />
				<form:hidden path="id" name="id"></form:hidden>
				<form:hidden path="aab001"></form:hidden>
				<form:hidden path="createrId"></form:hidden>
				<form:hidden path="createrOrgId"></form:hidden>
				<div class="row">
					<div class="col-xs-12 col-sm-8">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="单位名称">
								<em>*</em>单位名称:
							</label>
							<div class="col-xs-12 col-sm-9 required">
								<form:input class="form-control" type="text" path="aab004" title="请输入单位名称" data-placement="bottom"></form:input>
							</div>
						</div>
					</div>

					<label class="col-xs-3 col-sm-2" for="inputError" title="工商登记执照号码:">工商登记执照号码:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input class="form-control" type="text" path="aab007" title="请输入工商登记执照号码" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">
						<em>*</em>所在地区:
					</label>
					<div class="col-xs-9 col-sm-2 required">
						<form:input class="form-control" id="addre" type="text" path="aaa021" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="单位性质">
						<em>*</em>单位性质:
					</label>
					<div class="col-xs-9 col-sm-2 required">
						<xf:select textField="name" selectClass="form-control" tableName="TAB_UNITNATURE" name="aab019" value="${unitAgreementForm.aab019 }" valueField="code" hasDefault="0"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="经济类型">经济类型：</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select textField="name" selectClass="form-control" tableName="TAB_ECONOMIC" name="aab020" value="${unitAgreementForm.aab020 }" valueField="code" hasDefault="0"></xf:select>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="地址">地址:</label>
							<div class="col-xs-9 col-sm-10">
								<form:input class="form-control" type="text" path="aae006" title="请输入地址"></form:input>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="moduleWrapNobg">
			<div class="moduleTit">单位协议签订</div>
			<div class="moduleCont">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">
						<em>*</em>单位协议编号:
					</label>
					<div class="col-xs-9 col-sm-2 required">
						<form:input class="form-control" type="text" path="uaNo" title="请输入单位协议编号"></form:input>
					</div>
					
					
					
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>协议签订日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
				  		<div class="input-group row required">
	                      	<form:input  class="form-control" type="text"  path="uaCreatetime"  title="请输入协议签订日期"></form:input>
	                      	<span class="input-group-addon">
	                          	<i class="icon-calendar bigger-110"></i>
	                      	</span>
	              		</div>
                 	</div>		
					
					<label class="col-xs-3 col-sm-2" for="inputError">单位联系人:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input class="form-control" type="text" path="uaName" title="请输入单位联系人"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input class="form-control" type="text" path="uaPhone" title="请输入联系电话"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否免费:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select class="form-control" type="text" path="uaIsFree">
							<form:option value="0" label="是" />是
							<form:option value="1" label="否" />否
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">办理人身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input class="form-control" type="text" path="uaCard" title="请输入办理人身份证号"></form:input>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="协议主要内容">协议主要内容:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea type="text" path="uaContent" title="请输入协议主要内容"></form:textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="备注">备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea type="text" path="uaNote" title="请输入备注"></form:textarea>
							</div>
						</div>
					</div>
				</div>


				<hr />
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input class="form-control" type="text" path="createrName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-2">
							<form:input class="form-control" type="text" path="createrOrgName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<form:input class="form-control" type="text" path="createrDate" readonly="true"></form:input>
							<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				</div>

			</div>
		</div>
		<c:if test="${uaStatus ==1 }">
			<p style="font-size: 16px"><span style="color:red">提示:该企业已终止协议 &nbsp;&nbsp;终止日期:</span>${stopDate }&nbsp;&nbsp;<span style="color:red">终止原因:</span>${stopReason} &nbsp;&nbsp;&nbsp;<span style="color:red">重新签订请点击"单位协议签订"</span> </p>
		</c:if>
		
		
		<div class="bottomBtn">
			<div class="h50">&nbsp;</div>
			<div class="floatBtn">
				<button role="button" class="btn btn-primary" type="submit">
					<i class="icon-save"></i>单位协议签订
				</button>
			</div>
		</div>

		<!-- 		</div> -->
	</form:form>
</body>
</html>
