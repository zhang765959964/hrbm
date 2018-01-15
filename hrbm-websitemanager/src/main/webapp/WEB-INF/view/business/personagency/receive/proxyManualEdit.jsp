<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 代理手册表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/receive/proxyManualEdit.js"></script>
</head>
<body>
<form:form modelAttribute="proxyManualForm" method="post" action="${ctx}/business/personagency/receive/proxyManual/save.xf">
   <div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleCont change-bg-iframe">
				 <form:hidden path="pmId" ></form:hidden>
				 <form:hidden path="personId" ></form:hidden>
				 <form:hidden path="createrId" ></form:hidden>
				 <form:hidden path="createrOrgId" ></form:hidden>
			    <div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="身份证号码">身份证号码:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="AAC002" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="AAC003" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">性别:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">档案编号:</label>
					<div class="col-xs-9 col-sm-input">
						 <form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">档案状态:</label>
					<div class="col-xs-9 col-sm-input">
						 <form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">存档类型:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">发放人:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="proxyIssuer"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">发放时间:</label>
					<div class="col-xs-9 input-group col-sm-input">
						<div class="input-group row">
                        	<form:input  class="form-control" type="text"  path="lssuingDate"></form:input>
                        	<span class="input-group-addon">
                            	<i class="icon-calendar bigger-110"></i>
                        	</span>
                        </div>
                    </div>		
                    <%-- <label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>有效标记:</label>
					 <div class="col-xs-9 col-sm-input required">
						<form:select  class="form-control" type="text" path="effectiveMark" >
							<form:option value="1" label="有效"/>有效
							<form:option value="0" label="无效"/>无效
						</form:select>
					</div> 
				</div>
				<div class="row">--%>
					<label class="col-xs-3 col-sm-label" for="inputError" title="发放原因">发放原因:</label>
					<%-- <div class="col-xs-9 col-sm-three-col">
						<form:textarea  type="text"  path="proxyReaseon" row="1" col="1" ></form:textarea>
					</div> --%>
					<div class="col-xs-9 col-sm-input">
						<xf:select  tableName="Rsda_Tab_Proxy_Type" valueField="code" textField="name" name="proxyType" 
							 value='${proxyManualForm.proxyType}' hasDefault="0" selectClass="form-control"></xf:select>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="备注">备注:</label>
					<div class="col-xs-9 col-sm-three-col">
						<form:textarea  type="text"  path="description" row="5" col="5" ></form:textarea>
					</div>
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
                        	<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                    </div>									
			    </div>											
			</div>
		</div>
	   	<div class="bottomBtn">
	   		<div class="h50">&nbsp;</div>
	   		<div class="floatBtn">
	   			<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	   			<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   		</div>
	   	</div>
	</div>	
</form:form>
</body>
</html>