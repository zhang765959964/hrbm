<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 特殊档案表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <script type="text/javascript" src="${ctx}/js/business/personagency/storage/specialArchivesEdit.js"></script>
</head>
<body>
<form:form modelAttribute="specialArchivesForm" method="post" action="${ctx}/business/personagency/storage/specialArchives/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleCont change-bg-iframe">
				 <form:hidden path="id" ></form:hidden>
				 <form:hidden path="lrCreaterId" ></form:hidden>
				 <form:hidden path="lrCreaterOrgId" ></form:hidden>
					    <div class="row">
					    	<label class="col-xs-3 col-sm-label" for="inputError">编号:</label>
							 	<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="specialNumber" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>特殊档案类别:</label>
							<div class="col-xs-9 col-sm-input required">
								<xf:select  tableName="RSDA_TAB_SPECIAL_TYPE" valueField="code" textField="name" name="specialType"  
										value='${specialArchivesForm.specialType}' hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">特殊档案情况:</label>
							<div class="col-xs-9 col-sm-input">
								<form:select  class="form-control" type="text" path="specialStatus">
									<form:option value="0" label="入档"/>入档
									<%-- <form:option value="1" label="已转出"/>已转出 --%>
								</form:select>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>姓名:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input  class="form-control" type="text"  path="aac003"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="aac002" ></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-input">
								<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="aac004"  
										value='${specialArchivesForm.aac004}' hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError">学校名称:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="schoolName" ></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">班级:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="schoolClass" ></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">专业:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="major" ></form:input>
							</div>	 
						</div>	
						<div class="row">	
							<label class="col-xs-3 col-sm-label" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-two-col">
								<form:input  class="form-control" type="text"  path="corpName" ></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">退伍编号:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="veteransNumber" ></form:input>
							</div>
						</div>	
						
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="备注">备注:</label>
							<div class="col-xs-9 col-sm-three-col">
								<form:textarea  type="text"  path="description" row="5" col="5" ></form:textarea>
							</div>
						</div>
						<div class="row">	
							<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-input">
                             	<form:input  class="form-control" type="text"  path="lrCreaterDate" readonly="true"></form:input>
                             	<span class="input-group-addon">
                                 	<i class="icon-calendar bigger-110"></i>
                             	</span>
	                        </div>	
							<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="lrCreaterOrgName" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="lrCreaterName" readonly="true"></form:input>
							</div>
					    </div>											
				</div>
		</div>
	 	<div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary" onclick="submitForm(false)"><i class="icon-save"></i>保存</button>
	   		<button type="submit" class="btn btn-success" onclick="submitForm(true)"><i class="icon-plus"></i>保存并新增</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</form:form>
</body>
</html>