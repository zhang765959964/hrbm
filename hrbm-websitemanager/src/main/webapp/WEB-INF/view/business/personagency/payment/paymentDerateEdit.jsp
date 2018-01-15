<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 缴费记录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
</head>
<body>
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<form:form modelAttribute="paymentRecordForm" method="post" action="${ctx}/business/personagency/payment/derate/save.xf">
				<form:hidden path="pkId" ></form:hidden>
				<form:hidden path="fkPersonId" ></form:hidden>	
				<form:hidden path="fkCorpRecordId" ></form:hidden>	
				<input type="hidden" id="fdPaymentType" name="fdPaymentType" value="${fdPaymentType}" ></input>	
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit">存档信息</div>
				<div class="moduleCont">
					   	<input type="hidden" id="personId"  value="${personId}"/>
						<div class="row">
							<label class="col-xs-12 col-sm-label" for="inputError">身份证号码:</label>
							<div class="col-xs-12 col-sm-input">
								 <form:input  class="form-control" type="text"  path="archivesPersonBaseForm.AAC002" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-label" for="inputError">姓名:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.AAC003" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-label" for="inputError">联系电话:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.expPersonPhone" ></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-label" for="inputError">性别:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.genderName" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-label" for="inputError">出生日期:</label>
							<div class="col-xs-12 input-group col-sm-input"  style="padding-left:15px">
                             	  <form:input  class="form-control" type="text"  path="archivesPersonBaseForm.AAC006" readonly="true"></form:input>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
                           </div>
							<label class="col-xs-12 col-sm-label" for="inputError">档案出生日期:</label>
							<div class="col-xs-12 input-group col-sm-input"  style="padding-left:15px">
                              <form:input  class="form-control" type="text"  path="archivesPersonBaseForm.archiveBirthDate" readonly="true"></form:input>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-label" for="inputError">档案编号:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.archiveCode" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-label" for="inputError">档案姓名:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.archiveName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-label" for="inputError">档案接收人:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.archiveReceiveName" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-label" for="inputError">档案转入日期:</label>
							<div class="col-xs-12 input-group col-sm-input"  style="padding-left:15px">
                             	 <form:input  class="form-control" type="text"  path="archivesPersonBaseForm.receiveDate" readonly="true"></form:input>
                             	 <span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                           </div>

							<label class="col-xs-12 col-sm-label" for="inputError">档案状态:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.archiveStatusName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-label" for="inputError">手机号:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.AAE005" ></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-label" for="inputError">存档类型:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.archiveTypeName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-label" for="inputError">所属单位名称:</label>
							<div class="col-xs-12 col-sm-input">
								<form:input  class="form-control" type="text"  path="archivesPersonBaseForm.expEntrustCompany" readonly="true"></form:input>
							</div>
						</div>
					
				</div>
			</div>
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit">缴费信息</div>
				<div class="moduleCont">

					   			 
		    			<div class="row">
                            <label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>缴费日期:</label>
							<div class="col-xs-9 input-group col-sm-input required">
                              	<form:input  class="form-control" type="text"  path="fdPaymentDate" ></form:input>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>		
                             								 
							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>缴费月数:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input  class="form-control" type="text"  path="fdPaymentMonths" ></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>缴费标准:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input  class="form-control" type="text"  path="fdPaymentStandard" value="0" ></form:input>
							</div>
							</div>
							<div class="row">	 				 
							<label class="col-xs-3 col-sm-label" for="inputError">开始缴费日期:</label>
							<div class="col-xs-9 input-group col-sm-input ">
                              	<form:input  class="form-control" type="text"  path="fdStartDate" readonly="true"></form:input>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>									
							<label class="col-xs-3 col-sm-label" for="inputError">终止缴费日期:</label>
							<div class="col-xs-9 input-group col-sm-input ">
                              	<form:input  class="form-control" type="text"  path="fdEndDate" readonly="true" ></form:input>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>
                           
		    			</div>
		    			<div class="row">
		    			 <label class="col-xs-3 col-sm-label" for="inputError">备注:</label>
							<div class="col-xs-9  col-sm-three-col ">
                              	<form:textarea  class="form-control" type="text"  path="fdDesc"  ></form:textarea>
                            </div>	
		    			</div>
					  	<div class="h60">&nbsp;</div>
					   	<div class="floatBtn">
				<!-- 	   		<a href="javascript:void(0)" role="button" class="btn btn-primary"  onclick="submitForm()">保存电话号码</a> -->
					   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
					   		<a href="javascript:void(0)" role="button" id="closeItem" class="btn btn-info" ><i class="icon-remove"></i>关闭</a>	
					   	</div>  											
	        						
				</div>
			</div>
			</form:form>	
		</div>

	   	
	</div>	
   	  <script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentDerateEdit.js?version=201609181816"></script>
	  <script type="text/javascript" src="${ctx}/js/util/date.js"></script>
</body>
</html>
