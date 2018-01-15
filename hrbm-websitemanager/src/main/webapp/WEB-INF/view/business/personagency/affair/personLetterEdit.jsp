<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 人事档案联系函表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <script type="text/javascript" src="${ctx}/js/business/personagency/affair/personLetterEdit.js"></script>
</head>
<body>
<form:form modelAttribute="personLetterForm" method="post" action="${ctx}/business/personagency/affair/personLetter/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleCont change-bg-iframe">
				 <form:hidden path="id" ></form:hidden>
				 <form:hidden path="archivesId" ></form:hidden>
				 <form:hidden path="personId" ></form:hidden>
				 <form:hidden path="cczy06" ></form:hidden>
				 <form:hidden path="ccpr08" ></form:hidden>
				 <form:hidden path="createrId" ></form:hidden>
				 <form:hidden path="createrOrgId" ></form:hidden>
				    <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="aac003" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">文件号:</label>
						 <div class="col-xs-9 col-sm-two-col">
							<form:input  class="form-control" type="text"  path="fileNumber" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">代管内容:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="escrowContent" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">工作单位:</label>
						 <div class="col-xs-9 col-sm-two-col">
							<form:input  class="form-control" type="text"  path="workUnit" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">事由:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="reason" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">办理事项:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text"  path="handlingMatters" >
								<form:option value="" label="请选择"/>请选择
								<form:option value="1" label="1"/>1
								<form:option value="2" label="2"/>2
								<form:option value="3" label="3"/>3
								<form:option value="4" label="4"/>4
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">开具日期:</label>
					    <div class="col-xs-9 input-group col-sm-input">
					    	<div class="input-group row">
	                           	<form:input  class="form-control" type="text"  path="dateOfIssue" ></form:input>
	                           	<span class="input-group-addon">
	                               	<i class="icon-calendar bigger-110"></i>
	                           	</span>
	                         </div>
                        </div>									
						<!-- <div class="col-xs-12 col-sm-12">
							<div class="row"> -->
						<label class="col-xs-3 col-sm-label" for="inputError" title="第4项内容">第4项内容:</label>
						<div class="col-xs-9 col-sm-three-col">
							<form:textarea  type="text"  path="fourthItems" row="1" col="5" ></form:textarea>
						</div>
							<!-- </div>
						</div> -->
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
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</form:form>					
</body>
</html>