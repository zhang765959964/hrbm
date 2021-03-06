<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>党组织关系转出</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/party/partyOutEdit.js?v=20161212"></script>
</head>
<body>
<form:form modelAttribute="partyForm"  method="post" action="${ctx}/business/personagency/party/partyOut.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
					<input type="hidden" name="flag" id="flag" value="0" />
					<input type="hidden" value="${personId}" name="personId" >
					<form:hidden   path="outCreaterId" ></form:hidden>
					<form:hidden   path="outCreaterOrgId" ></form:hidden>
					<form:hidden path="createrId" />
					<form:hidden path="createrName" />
					<form:hidden path="createrOrgName" />
					<form:hidden path="createrOrgId" />
					<form:hidden path="createrDate" />
					
					<form:hidden path="id" ></form:hidden>
				 	<div class="row">
			 			<label class="col-xs-3 col-sm-label" for="inputError">身份证号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="partyPersonForm.personCard" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.personName" readonly="true"></form:input>
                         </div>		
                        <label class="col-xs-3 col-sm-label" for="inputError">档案编号:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.archiveCode" readonly="true"></form:input>
                        </div>		
				 	</div>
					<div class="row">
			 			<label class="col-xs-3 col-sm-label" for="inputError">性别:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="partyPersonForm.personSex" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">存档类型:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.archiveTypeName" readonly="true"></form:input>
                         </div>		
                        <label class="col-xs-3 col-sm-label" for="inputError">档案状态:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.archiveStatusName" readonly="true"></form:input>
                        </div>		
					</div>
				    <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">文化程度:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select  textField="name" selectClass="form-control" tableName="TAB_EDUCATION" name="whcdId" value="${partyForm.partyPersonForm.whcdId }"  valueField="code" hasDefault="0"></xf:select>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">曾用名:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.personOldName" ></form:input>
                        </div>									
						<label class="col-xs-3 col-sm-label" for="inputError">民族:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<xf:select  textField="name" selectClass="form-control" tableName="TAB_NATION" name="nationId" value="${partyForm.partyPersonForm.nationId }"  valueField="code" hasDefault="0"></xf:select>
                        </div>				
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">籍贯:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="partyPersonForm.placeName" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">手机号:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.mobilePhone" ></form:input>
                        </div>									
						<label class="col-xs-3 col-sm-label" for="inputError">联系电话:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.phone" ></form:input>
                        </div>				
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">入党时间:</label>
						 <div class="col-xs-9 input-group col-sm-input">
						  	<div class="input-group row">
                              	<form:input  class="form-control" type="text"  path="partyDate" ></form:input>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>
                        </div>				
                         	 
						<label class="col-xs-3 col-sm-label" for="inputError">转正时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
						  	<div class="input-group row">
                              	<form:input  class="form-control" type="text"  path="partyPositiveDate" ></form:input>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>
                        </div>										
						<label class="col-xs-3 col-sm-label" for="inputError">转入时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
						  	<div class="input-group row">
                              	<form:input  class="form-control" type="text"  path="partyIntoDate" ></form:input>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                            </div>
                        </div>				
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">毕业学校:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="partyPersonForm.partySchoolName" ></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">现居住地址:</label>
						<div class="col-xs-9 col-sm-two-col">
                          	<form:input  class="form-control" type="text"  path="partyPersonForm.expAddress" ></form:input>
                        </div>									
						
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>转出原因:</label>
						<div class="col-xs-9 col-sm-input required">
							<xf:select  textField="name" selectClass="form-control" tableName="RSDA_TAB_PARTY_REASON" name="partyOutReason" value="${partyForm.partyOutReason}"  valueField="code" hasDefault="0"></xf:select> 	
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>转出时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
						  	<div class="input-group row required">
	                            <form:input  class="form-control" type="text"  path="partyOutDate" ></form:input>
                              	<span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
	                        </div>
                        </div>							
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>转出去向:</label>
						<div class="col-xs-9 input-group col-sm-input required">
						 	<form:input  class="form-control" type="text"  path="partyOutWhere" ></form:input>
                        </div>				
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">备注:</label>
						<div class="col-xs-9 col-sm-three-col">
							<form:input  class="form-control" type="text"  path="partyNote" ></form:input>
						</div>
					</div>
       				<div class="row" >
									<label class="col-xs-3 col-sm-label" for="inputError">转出经办人:</label>
									<div class="col-xs-9 col-sm-input">
									    <form:input  class="form-control" type="text"  path="outCreaterName" readonly="true"></form:input>
									</div>
									<label class="col-xs-3 col-sm-label" for="inputError">转出经办机构:</label>
									<div class="col-xs-9 col-sm-input">
								    	<form:input  class="form-control" type="text"  path="outCreaterOrgName" readonly="true"></form:input>
									</div>
		                            <label class="col-xs-3 col-sm-label" for="inputError">转出经办日期:</label>
									<div class="col-xs-9 input-group col-sm-input">
									  	<div class="input-group row ">
				                            <form:input  class="form-control" type="text"  path="outCreaterDate" readonly="true"></form:input>
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
				                        </div>
			                        </div>				
					</div>			
        			
		</div>
	 <div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button role="button" class="btn btn-success" type="submit"><i class="icon-external-link"></i>转出</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()" data-toggle="modal"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</form:form>
</body>
</html>
