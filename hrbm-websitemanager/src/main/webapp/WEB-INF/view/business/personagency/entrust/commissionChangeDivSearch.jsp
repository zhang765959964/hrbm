<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>工资标准调整</title>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<form:form modelAttribute="commissionChangeForm2" method="post" >
<div class="col-sm-7 colRight">
	<div class="moduleWrapNobg">
		<div class="moduleTit">委托类型变更</div>
		<br/>
		<div class="moduleCont resultWrap h335">													
		 		<form:hidden path="id" ></form:hidden>
		 		<form:hidden path="archivesId" ></form:hidden>
		 		<form:hidden path="personId" ></form:hidden>
		 		<form:hidden path="archiveType" ></form:hidden>
		 		<form:hidden path="aab001not" id="aab001not"></form:hidden>
		   			<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更类型">变更类型:</label>
						<div class="col-xs-9 col-sm-4"> 
							<c:if test="${commissionType==0}">
								<form:input  class="form-control" type="text"  path="" readonly="true"></form:input>
							</c:if>
							<c:if test="${commissionType!=0}">
								<xf:select  tableName="RSDA_TAB_TYPE_CHANGE" valueField="code" textField="name" name="commissionType" 
												value='${commissionChangeForm2.commissionType}'  selectClass="form-control" disabled="true"></xf:select>
							</c:if>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更日期">变更日期:</label>
						<div class="col-xs-9 input-group col-sm-4">
							<div class="input-group row">
                             	<form:input  class="form-control" type="text" path="commissionDate" readonly="true"></form:input>
                             	<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
                             </div>
                        </div>	
                     </div>	     
                     <div class="row">								
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更前档案编号">变更前档案编号:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="archiveCodeBefore" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更后档案编号">变更后档案编号:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="archiveCodeAfter" readonly="true"></form:input>
						</div>
					</div>	     
					<div class="row">				 
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="变更委托单位名称">变更委托单位名称:</label>
								<div class="col-xs-9 col-sm-10">
									<form:input  class="form-control" type="text" path="commissionCorpName" readonly="true"></form:input>
								</div>
							</div>
						</div>	
					</div>     
                    <div class="row">				 
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="备注">备注:</label>
								<div class="col-xs-9 col-sm-10">
									<form:input  class="form-control" type="text" path="description" readonly="true"></form:input>
								</div>
							</div>
						</div>	
				   </div>	     
                   <div class="row">					 
						<label class="col-xs-3 col-sm-2" for="inputError" title="经办人">经办人:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="经办机构">经办机构:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
						</div>
				  </div>	     
                  <div class="row">			 
						<label class="col-xs-3 col-sm-2" for="inputError" title="经办日期">经办日期:</label>
						<div class="col-xs-9 input-group col-sm-4">
                           	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
                           	<span class="input-group-addon">
                               	<i class="icon-calendar bigger-110"></i>
                           	</span>
                         </div>									
				 </div>											
		</div>
	</div>
</div>
<div class="bottomBtn">
	<div class="h50">&nbsp;</div>
	<div class="floatBtn">
		<button type="button" class="btn btn-primary"><i class="icon-save"></i>保存</button>
		<a role="button" class="btn btn-primary" href="javascript:addCommissionChange('${id}','${archiveFlowStatus }')"><i class="icon-plus"></i>新增</a>
		<a href="javascript:printCodeLabel('${id}')" role="button" class="btn btn-success"><i class="icon-barcode"></i>打印条码标签</a>
	</div>
</div>
</form:form>					
</html>