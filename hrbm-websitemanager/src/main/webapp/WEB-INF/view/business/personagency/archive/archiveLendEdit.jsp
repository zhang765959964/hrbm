<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 档案调出表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
</head>
<body>
   	<form:form modelAttribute="archiveLendForm" method="post" action="${ctx}/business/personagency/archive/archiveLend/save.xf">
		<form:hidden path="lendId" ></form:hidden>
		<div class="modal-body overflow-visible reportWrap">
		    <div class="row" style="padding:0 30px;">
				<label class="col-xs-3 col-sm-2" for="inputError">档案id：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="archivesId" ></form:input> 
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">档案去向(单位)：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="archivesLendWhere" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出时间：</label>
				<div class="col-xs-9 col-sm-2">
				    <div class="input-group">
					    <form:input  class="form-control" type="text"  path="lendDate"></form:input>
						<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
					</div>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出原因：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendReason" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出备注：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendRemarks" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出流转状态    4 调出登记 5 调出确认 6 调出完成：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendFlowStatus" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出人姓名：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendName" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出人身份证号：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendIdNumber" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">调出人联系方式：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendPhone" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">提档人：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendPeopleMention" ></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">提档人联系方式：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendPeoplePhone"></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">提档人身份证号：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendPeopleCard"></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办人id：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendCreaterId"></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办人姓名：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendCreaterName"></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构id：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendCreaterOrgId"></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构名称：</label>
				<div class="col-xs-9 col-sm-2">
					 <form:input  class="form-control" type="text"  path="lendCreaterOrgName"></form:input>				   
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办日期：</label>
				<div class="col-xs-9 col-sm-2">
				    <div class="input-group">
					    <form:input  class="form-control" type="text"  path="lendCreaterDate" ></form:input>
						<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
					</div>	
				</div>
			</div>
		</div>											
		<div class="modal-footer">
			<button class="btn btn-sm btn-primary" type="submit"><i class="icon-ok"></i>保存</button>
			<a href="javascript:void(0)" class="btn btn-sm" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
		</div>
    </form:form>
</body>
</html>