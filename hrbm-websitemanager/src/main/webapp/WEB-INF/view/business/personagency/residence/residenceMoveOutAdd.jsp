<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 户口迁入迁出表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/residence/residenceMoveOutAdd.js?verson=201612124"></script>
</head>
<body>
<form:form modelAttribute="residenceMoveOutForm" method="post" action="${ctx}/business/personagency/residence/residenceMoveOut/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
		<div class="moduleCont change-bg-iframe">			
				 <form:hidden path="id" ></form:hidden>
				 <form:hidden path="archivesId" ></form:hidden>
				 <form:hidden path="personId" ></form:hidden>
				 <form:hidden path="createrId" ></form:hidden>
				 <form:hidden path="createrOrgId" ></form:hidden>
				 <form:hidden path="cczy06" ></form:hidden>
				 <form:hidden path="ccpr08" ></form:hidden>
			    <div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">户口编号:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="residenceNumber"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>户口状态:</label>
					<div class="col-xs-9 col-sm-input required">
						<xf:select  tableName="RSDA_TAB_RESIDENCE_STATUS" valueField="code" textField="name" name="residenceStatus"  
									value='${residenceMoveOutForm.residenceStatus}' valueCon="1" selectClass="form-control"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">迁入日期:</label>
					<div class="col-xs-9 input-group col-sm-input">
						<div class="input-group row">
	                     	<form:input  class="form-control" type="text"  path="moveDate" ></form:input>
	                     	<span class="input-group-addon">
	                         	<i class="icon-calendar bigger-110"></i>
	                     	</span>
	                     </div>
                    </div>				
                </div>     
                <div class="row">   					
					<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>落户地户籍部门:</label>
					<div class="col-xs-9 col-sm-input required">
						<form:input  class="form-control" type="text"  path="settleDepartment" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>落户地址:</label>
					<div class="col-xs-12 col-sm-two-col required">
						<form:input  class="form-control" type="text"  path="settleAddress"></form:input>
					</div>
				</div>     
                <div class="row"> 		
					<label class="col-xs-3 col-sm-label" for="inputError">原户籍所在地:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="originalDomicile" ></form:input>
					</div>	 
					<label class="col-xs-3 col-sm-label" for="inputError">开具日期:</label>
				  	<div class="col-xs-9 input-group col-sm-input">
	                    <div class="input-group row">
	                     	<form:input  class="form-control" type="text"  path="openDate" ></form:input>
	                     	<span class="input-group-addon">
	                         	<i class="icon-calendar bigger-110"></i>
	                     	</span>
                     	</div>
                    </div>									
					<label class="col-xs-3 col-sm-label" for="inputError">毕业生届期:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="thoseGraduates" ></form:input>
					</div>
				</div>     
                <%-- <div class="row"> 		
					<label class="col-xs-3 col-sm-2" for="inputError">迁移日期:</label>
					  <div class="col-xs-9 input-group col-sm-2">
                            	<form:input  class="form-control" type="text"  path="outDate" ></form:input>
                            	<span class="input-group-addon">
                                	<i class="icon-calendar bigger-110"></i>
                            	</span>
                           </div>	
					<label class="col-xs-3 col-sm-2" for="inputError">迁移地址:</label>
						 <div class="col-xs-12 col-sm-6">
							<form:input  class="form-control" type="text"  path="moveToAddress" ></form:input>
						</div>
				</div>      --%>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="备注">备注:</label>
					<div class="col-xs-9 col-sm-three-col">
						<form:textarea  type="text"  path="description" row="1" col="1" ></form:textarea>
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