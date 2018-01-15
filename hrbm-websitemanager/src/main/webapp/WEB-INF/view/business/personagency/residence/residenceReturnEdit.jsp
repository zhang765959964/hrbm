<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 户口借用归还表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/residence/residenceReturnEdit.js?verson=20161227000"></script>
</head>
<body>
	<form:form modelAttribute="residenceReturnForm" method="post" action="${ctx}/business/personagency/residence/residenceReturn/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleCont change-bg-iframe">
				  <form:hidden path="id" ></form:hidden>
				  <form:hidden path="archivesId" ></form:hidden>
				  <form:hidden path="personId" ></form:hidden>
				  <form:hidden path="moId" ></form:hidden>
				  <form:hidden path="createrId" ></form:hidden>
				  <form:hidden path="createrOrgId" ></form:hidden>
				  <form:hidden path="cczy06" ></form:hidden>
				  <form:hidden path="ccpr08" ></form:hidden>
				  <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>借用人姓名:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input  class="form-control" type="text"  path="borrowerName"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">借用人身份证号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="borrowerCard"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>借用人联系电话:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input  class="form-control" type="text"  path="borrowerPhone"></form:input>
						</div>
				 </div>
				 <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>借用日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row required">
                             	<form:input  class="form-control" type="text"  path="borrowerDate" placeholder="请选择日期"></form:input>
                             	<span class="input-group-addon">
                                 	<i class="icon-calendar bigger-110"></i>
                             	</span>
                            </div>
                        </div>	
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>到期日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row required">
                          	<form:input  class="form-control" type="text"  path="maturityDate"></form:input>
                          	<span class="input-group-addon">
                              	<i class="icon-calendar bigger-110"></i>
                          	</span>
                          	</div>	
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
		</div>
	 	<div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-success" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
	</form:form>				
</body>
</html>