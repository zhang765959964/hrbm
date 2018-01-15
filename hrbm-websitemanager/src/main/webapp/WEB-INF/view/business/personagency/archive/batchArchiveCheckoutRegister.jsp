<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案借阅归还登记</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/batchArchiveCheckoutRegister.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#checkoutPeriodDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId : "archiveCheckoutForm",
				  "opens":"right",
				  "drops": "down",
		             "locale": {
		                 "format": "YYYY-MM-DD"
		             }
	         });
		});
		//重置
		function resetFormDate(){
			resetForm('archiveCheckoutForm');
			$('#archiveCheckoutForm').data('bootstrapValidator').updateStatus('checkoutType', 'NOT_VALIDATED').validateField('checkoutType');
			$('#archiveCheckoutForm').data('bootstrapValidator').updateStatus('batchName', 'NOT_VALIDATED').validateField('batchName');
		}
	</script>
</head>
<body>
<div class="container-fluid">
	<div class="tabable row">
		<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
			<li class="active"><a data-toggle="tab" href="#searchArchivesEdu">档案查找借阅登记</a></li>
			<li><a data-toggle="tab" href="#resgisterOne" onclick="resgisterOneDiv()">档案批量借阅登记</a></li>
			<li><a data-toggle="tab" href="#resgisterTwo" onclick="resgisterTwoDiv()">档案批量归还登记</a></li>
		</ul>
		<div class="tab-content">
			<div id="searchArchivesEdu" class="tab-pane in active">
				<form id="searchForm">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">档案编号:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="archiveCode" id="archiveCode" placeholder="请输入完整的档案编号" data-placement="bottom"/>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">身份证号:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="aac002" id="aac002" placeholder="请输入完整的身份证号" data-placement="bottom"/>
						</div>
						<div class="col-xs-9 col-sm-4">
							<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="addSearch()"><i class=" icon-plus-sign"></i>加入查询</a>
							<a href="javascript:void(0)" role="button" class="btn btn-info"    onclick="subtractSearch()"><i class="icon-minus-sign"></i>去除查询</a>
							<a href="javascript:void(0)" role="button" class="btn btn-danger"  onclick="clearJqGrid()"><i class="icon-trash"></i>清空列表</a>
						</div>
					</div>
					<div class="moduleWrapNob">
						<div class="moduleTit">结果列表</div>
						<div class="moduleCont">
							<div class="row">
								<div class="col-xs-12">
									<table id="archivesList" class="datagridClass"></table>
									<div id="jqGridPager"></div>
								</div>
							</div>
						</div>
					</div>
				</form>
				<form:form modelAttribute="archiveCheckoutForm" method="post" action="${ctx}/business/personagency/batch/archiveCheckout/resgisterSave.xf">
				<div class="moduleWrapNobg">
					<div class="moduleTit">借阅登记信息</div>
					<div class="moduleCont">
						<form:hidden path="id" ></form:hidden>
						<form:hidden path="archiveId" ></form:hidden>
						<form:hidden path="checkoutRegisterId" ></form:hidden>
						<form:hidden path="checkoutRegisterOrgId" ></form:hidden>
						<form:hidden path="archiveIds" id="archiveIds"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>借阅类别:</label>
							 <div class="col-xs-9 col-sm-2 required">
								<xf:select textField="name" tableName="RSDA_TAB_CHECKOUTTYPE"  name="checkoutType" value="${archiveCheckoutForm.checkoutType }"  
									valueField="code" hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">借阅人:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="checkoutPerson"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">借阅人电话:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="checkoutPersonPhone"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">借阅单位:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="checkoutCorp"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>生成批次名:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input  class="form-control" type="text"  path="batchName"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">借阅期限日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<div class="input-group row">
					              <form:input  class="form-control" type="text"  path="checkoutPeriodDate"></form:input>
					              <span class="input-group-addon">
					                <i class="icon-calendar bigger-110"></i>
					              </span>
					            </div>
				            </div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
				              	<form:input  class="form-control" type="text"  path="checkoutRegisterDate" readonly="true"></form:input>
				            </div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2">
									<form:input  class="form-control" type="text"  path="checkoutRegisterOrgName" readonly="true"></form:input>
						  	</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input  class="form-control" type="text"  path="checkoutRegisterName" readonly="true"></form:input>
							</div>
						</div>
					</div>
				</div>
				<div class="bottomBtn">
			   		<div class="h50">&nbsp;</div>
			   		<div class="floatBtn">
				   		<button type="submit" class="btn btn-success"><i class="icon-edit"></i>批量借阅登记</button>
				   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="resetFormDate()"><i class="icon-repeat"></i>重置</a>
			   		</div>
			   	</div>
			   	</form:form>
			</div>
			<div id="resgisterOne" class="tab-pane"></div>
			<div id="resgisterTwo" class="tab-pane"></div>
		</div>
	</div>
</div>
</body>
</html>