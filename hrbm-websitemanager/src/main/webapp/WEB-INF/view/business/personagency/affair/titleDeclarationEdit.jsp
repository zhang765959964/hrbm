<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 职称申报评定表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/affair/titleDeclarationEdit.js"></script>
</head>
<body>
<form:form modelAttribute="titleDeclarationForm" method="post" action="${ctx}/business/personagency/affair/titleDeclaration/save.xf">
	<div class="container-fluid pd-none-wrap">
		<div class="moduleCont change-bg-iframe">
			 	<form:hidden path="id" ></form:hidden>
				<form:hidden path="archivesId" ></form:hidden>
				<form:hidden path="personId" ></form:hidden>
				<form:hidden path="cczy06" ></form:hidden>
				<form:hidden path="ccpr08" ></form:hidden>
				<form:hidden path="createrId" ></form:hidden>
			 	<form:hidden path="createrOrgId" ></form:hidden>
			 	<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">档案编号:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">身份证号:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
					</div>
				</div>
			    <div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">序号:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="serialNumber"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">联系电话:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="contactNumber"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">工作年龄:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="workingAge"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="工作单位">工作单位:</label>
					<div class="col-xs-9 col-sm-three-col">
						<form:textarea  type="text"  path="workUnit" row="1" col="5"></form:textarea>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">现职称级别:</label>
					<div class="col-xs-9 col-sm-input">
						<xf:select  tableName="rsda_tab_level" valueField="code" textField="name" name="nowTitleGrade" value='${titleDeclarationForm.nowTitleGrade}' 
								hasDefault="0" valueCon="1,2,3" selectClass="form-control"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">申报级别:</label>
					<div class="col-xs-9 col-sm-input">
						<xf:select  tableName="rsda_tab_level" valueField="code" textField="name" name="declarationLevel" value='${titleDeclarationForm.declarationLevel}' 
								hasDefault="0" valueCon="1,2,3" selectClass="form-control"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">评定结果:</label>
					<div class="col-xs-9 col-sm-input">
						<form:select  class="form-control" type="text"  path="evaluationResult">
							<form:option value="" label="请选择"/>请选择
							<form:option value="0" label="成功"/>成功
							<form:option value="1" label="失败"/>失败
						</form:select>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
				    <div class="col-xs-9 input-group col-sm-input">
                     	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
                     	<span class="input-group-addon">
                         	<i class="icon-calendar bigger-110"></i>
                     	</span>
                    </div>									
			    </div>											
		</div>
		<div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</form:form>					
</body>
</html>