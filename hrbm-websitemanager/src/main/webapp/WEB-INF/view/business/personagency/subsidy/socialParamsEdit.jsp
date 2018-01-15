<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 社保补贴参数</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialParamsEdit.js?version=20161124"></script>
</head>
<body>
<form:form modelAttribute="socialParamsForm" method="post" action="${ctx}/business/personagency/subsidy/socialParams/save.xf">
<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobd">
				<div class="moduleCont">
					<form:hidden path="id" ></form:hidden>
					<form:hidden path="createrId" ></form:hidden>
				 	<form:hidden path="createrOrgId" ></form:hidden>
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">参数类型:</label>
						<div class="col-xs-9 col-sm-4 ">
							<xf:select tableName="RSDA_TAB_SOCIAL_STANDARD" valueField="code" textField="name" name="paramsCode" value="${socialParamsForm.paramsCode}"></xf:select>
						</div>
								
								
						<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>开始日期:</label>
							<div class="col-xs-9 input-group col-sm-4">
								<div class="input-group row required">
									<form:input  class="form-control" type="text"  path="startDate" ></form:input>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							 </div>					
					</div>
					<div class="row">		
						<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>结束日期:</label>
							<div class="col-xs-9 input-group col-sm-4">
								<div class="input-group row required">
									<form:input  class="form-control" type="text"  path="endDate" ></form:input>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							 </div>					
						<label class="col-xs-3 col-sm-2" for="inputError">参数值:</label>
						 <div class="col-xs-9 col-sm-4 required">
							<form:input  class="form-control" type="text"  path="paramsValue" ></form:input>
						</div>
					</div>
					<div class="row">					 
						<label class="col-xs-3 col-sm-2" for="inputError">描述:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="description" ></form:input>
						</div>
											 
						<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
						</div>
					</div>
					<div class="row">				 
						<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
						</div>
											 
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
						<div class="col-xs-9 input-group col-sm-4">
		                    <form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
		                </div>									
				    </div>											
				</div>
			</div>
		</div>
	 <div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	   		<a href="javascript:closeItem()" role="button" class="btn btn-info"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</form:form>	
</body>
</html>
