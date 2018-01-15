<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>编辑 退休人员大病医保表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/business/personagency/retired/retiredCareEdit.js?v=20161223"></script>
</head>
<body>
	<form:form modelAttribute="retiredCareForm" method="post" action="${ctx}/business/personagency/retired/care/save.xf">
		<form:hidden path="id"></form:hidden>
		<form:hidden path="personId"></form:hidden>
		<div class="container-fluid">
			<div class="row pd-none-wrap">
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="身份号码">身份号码:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="personCard" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="姓名">姓名:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="personName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="档案编号">档案编号:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="archiveCode" readonly="true"></form:input>
					</div>

				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="性别">性别:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="sex" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="存档类型">存档类型:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="archiveTypeName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="档案状态">档案状态:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="archiveStatusName" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="退休时间">退休时间:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="retiredDate" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="个人编号">个人编号:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="retiredPeopleNo" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="原单位名称">原单位名称:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="expOldCompany" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="退休个人编码">退休个人编码:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="retiredPeopleBm" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="手机号"><em>*</em>手机号:</label>
					<div class="col-xs-9 col-sm-input required">
						<form:input class="form-control" type="text" path="mobilePhone"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="联系电话">联系电话:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input class="form-control" type="text" path="phone"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="是否可申报大病医保">是否可申报大病医保:</label>
					<div class="col-xs-9 col-sm-input ">
							<form:select  path="isCareDeclare" class="form-control">
								<form:option value="" label="--请选择--"/>
								<form:option value="0" label="否"/>
								<form:option value="1" label="是"/>
							</form:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="初次填报日期"><em>*</em>初次填报日期:</label>
					  <div class="col-xs-9 input-group col-sm-input">
					  		<div class="input-group row required">
					  			<c:if test="${retiredCareForm.firstFillDate !=null }">
					  				<form:input  class="form-control" type="text"   path="firstFillDate" readonly="true"></form:input>
					  			</c:if>
					  			
					  			<c:if test="${retiredCareForm.firstFillDate ==null }">
					  				<form:input  class="form-control" type="text" id="firstDate"  path="firstFillDate" ></form:input>
					  			</c:if>
                            	<span class="input-group-addon">
                                	<i class="icon-calendar bigger-110"></i>
                            	</span>
                            </div>
                      </div>			
					<label class="col-xs-3 col-sm-label" for="inputError" title="填报日期">填报日期:</label>
					  <div class="col-xs-9 input-group col-sm-input">
					 	 	<div class="input-group row">
                            	<form:input  class="form-control  date" format="YYYY-MM-DD"  autoUpdateInput="false"  formValidatorId="retiredCareForm"  type="text"  path="fillDate" ></form:input>
                            	<span class="input-group-addon">
                                	<i class="icon-calendar bigger-110"></i>
                            	</span>
                           </div>
                      </div>						
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="是否已申报">是否已申报:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:select  path="isDeclare" class="form-control">
								<form:option value="" label="--请选择--"/>
								<form:option value="0" label="否"/>
								<form:option value="1" label="是"/>
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="是否通过">是否通过:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:select  path="isFlag" class="form-control">
								<form:option value="" label="--请选择--"/>
								<form:option value="0" label="否"/>
								<form:option value="1" label="是"/>
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="大病医保所在区域">大病医保所在区域:</label>
					<div class="col-xs-9 col-sm-input ">
						<form:input class="form-control" type="text" path="addre"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="原因">原因:</label>
					<div class="col-xs-9 col-sm-two-col ">
						<form:input class="form-control" type="text" path="reason"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="工作简历">工作简历:<br/>
					<a href="javascript:openWork()" style="color:#337ab7;font-size: 16px">点击维护</a></label>
					<div class="col-xs-9 col-sm-three-col ">
						<textarea  class="form-control hauto" rows="5" cols="30" readonly="true">
							${sb }
						</textarea>
					</div>
				</div>
				<style>textarea.form-control{height:auto !important;}</style>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="备注">备注:</label>
					<div class="col-xs-9 col-sm-three-col ">
						<form:textarea class="form-control" type="text" path="note"></form:textarea>
					</div>
				</div>
			</div>
			<div class="h60">&nbsp;</div>
			<div class="floatBtn">
				<button class="btn btn-primary" role="button" type="submit">
					<i class="icon-save"></i>保存
				</button>
				<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()" data-toggle="modal"><i class="icon-remove"></i>关闭</a>
			</div>
		</div>
	</form:form>
</body>
</html>
