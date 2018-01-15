<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>党费交详情</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript">
	
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleCont">
	    			<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.personCard}"  readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
							 <div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text"  value="${object.personName }"  readonly="true"></input>
							</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">性别:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.personSex}" readonly="true"></input>
                         </div>		
                         	<label class="col-xs-3 col-sm-label" for="inputError">出生日期:</label>
							 <div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.personCsrq}" readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">交纳开始年月:</label>
							 <div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text"  value="${object.partyBeginDate }" readonly="true"></input>
							</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">交纳截止年月:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.partyEndDate}" readonly="true"></input>
                         </div>		
                         	<label class="col-xs-3 col-sm-label" for="inputError">交纳金额:</label>
							 <div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.partyPayMoney}" readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
							 <div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text"  value="${object.createrName }" readonly="true" />
							</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.createrDate}" readonly="true"/>
                         </div>		
                         	<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
							 <div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.createrOrgName}" readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">代管组织关系:</label>
							 <div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text"  value="${object.partyStatus }" readonly="true"/>
							</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">转入日期:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.partyIntoDate }" readonly="true"/>
                         </div>		
                         	<label class="col-xs-3 col-sm-label" for="inputError">入党时间:</label>
							 <div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.partyDate }" readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">转正时间:</label>
							 <div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text"  value="${object.partyPositiveDate }" readonly="true"/>
							</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">转出日期:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.partyOutDate }" readonly="true"/>
                         </div>		
                         <label class="col-xs-3 col-sm-label" for="inputError">转出原因:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.partyOutReason}" readonly="true"/>
                         </div>		
                         	<label class="col-xs-3 col-sm-label" for="inputError">转出去向:</label>
							 <div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.partyOutWhere }" readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">民族:</label>
							 <div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text"  value="${object.nationName}" readonly="true"/>
							</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">文化程度:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.whcdName}" readonly="true"/>
                         </div>		
                         <label class="col-xs-3 col-sm-label" for="inputError">曾用名:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.partyOldName }" readonly="true"/>
                         </div>		
                         	<label class="col-xs-3 col-sm-label" for="inputError">专业:</label>
							 <div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.zhuanyeName}" readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">毕业学校:</label>
						<div class="col-xs-9 col-sm-input">
							<input  class="form-control" type="text"  value="${object.partySchoolName }" readonly="true"/>
						</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">毕业日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.partySchoolDate }" readonly="true"/>
                         </div>		
                         <label class="col-xs-3 col-sm-label" for="inputError">手机:</label>
						  <div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.partyPhone}" readonly="true"/>
                         </div>		
                         	<label class="col-xs-3 col-sm-label" for="inputError">QQ号:</label>
							 <div class="col-xs-9 col-sm-input">
							 	<input class="form-control" type="text"  value="${object.partyQq}" readonly="true"/>
							</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">其他联系方式:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text"  value="${object.partyOtherAdd }" readonly="true"/>
							</div>
												
						<label class="col-xs-3 col-sm-label" for="inputError">家庭通讯地址:</label>
						<div class="col-xs-9 input-group col-sm-input">
                          	<input  class="form-control" type="text"  value="${object.expCardAdd }" readonly="true" />
                        </div>		
	    			</div>											
				</div>
			</div> 
		</div>
	 <div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   	</div>
	   	
	</div>	
   	  
</body>
</html>
