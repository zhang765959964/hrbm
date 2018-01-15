<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 个人社保统筹范围内转移表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript">
		function closeItem(){
			xfui.closeDialog();
		}
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleCont">
				<form:form modelAttribute="socialsecTransferForm" method="post" action="">
				  	<form:hidden path="id" ></form:hidden>
				    <div class="row">
				    	<label class="col-xs-3 col-sm-label" for="inputError" title="档案编号">档案编号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="公民身份证号码">公民身份证号码:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">性别:</label>
						<div class="col-xs-9 col-sm-input">
							<input value='<xf:out textField="name" tableName="TAB_SEX" valueField="code" value="${socialsecTransferForm.aac004}"></xf:out>' 
								class="form-control" style="padding-left:5px;" readonly="readonly">
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">民族:</label>
						<div class="col-xs-9 col-sm-input">
							<input value='<xf:out textField="name" tableName="TAB_NATION" valueField="code" value="${socialsecTransferForm.aac005}" ></xf:out>' 
								class="form-control" style="padding-left:5px;" readonly="readonly">
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="出生日期">出生日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
	                     	<form:input  class="form-control" type="text"  path="aac006" readonly="true"></form:input>
	                     	<span class="input-group-addon">
	                         	<i class="icon-calendar bigger-110"></i>
	                     	</span>
	                    </div>									
						<label class="col-xs-3 col-sm-label" for="inputError" title="个人编号">个人编号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="expPersonNumber"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="参加工作时间">参加工作时间:</label>
					    <div class="col-xs-9 input-group col-sm-input">
	                           	<form:input  class="form-control" type="text"  path="expStartJobDate" ></form:input>
	                           	<span class="input-group-addon">
	                               	<i class="icon-calendar bigger-110"></i>
	                           	</span>
	                       </div>									
						<label class="col-xs-3 col-sm-label" for="inputError" title="参加养老保险时间">参加养老保险时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
	                          	<form:input  class="form-control" type="text"  path="expPensionDate" ></form:input>
	                          	<span class="input-group-addon">
	                              	<i class="icon-calendar bigger-110"></i>
	                          	</span>
	                         </div>
		               <label class="col-xs-3 col-sm-label" for="inputError" title="用工形式">用工形式:</label>
					   <div class="col-xs-9 col-sm-input">
								<xf:select  tableName="RSDA_TAB_EMPLOYMENT_FORM" valueField="code" textField="name" name="employmentForm" selectClass="form-control" 
									value='${socialsecTransferForm.employmentForm}' hasDefault="0" ></xf:select>
					   </div>
						<label class="col-xs-3 col-sm-label" for="inputError">手机号:</label>
							 <div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="aae005" ></form:input>
							</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="联系电话">联系电话:</label>
							 <div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="expPersonPhone" ></form:input>
							</div>            
		                 <label class="col-xs-3 col-sm-label" for="inputError" title="变更内容">变更内容:</label>
						 <div class="col-xs-9 col-sm-input">
							<xf:select  tableName="RSDA_TAB_CHANGE_CONTENTTWO" valueField="code" textField="name" name="changeContenttwo" selectClass="form-control" 
								value='${socialsecTransferForm.changeContenttwo}' hasDefault="0" ></xf:select>
						 </div>        
		                 <label class="col-xs-3 col-sm-label" for="inputError" title="家庭住址">家庭住址:</label>
						<div class="col-xs-9 col-sm-two-col">
							<form:input  class="form-control" type="text"  path="aab301" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="邮政编码">邮政编码:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="aae007" ></form:input>
						</div>          
						<label class="col-xs-3 col-sm-label" for="inputError" title="原参保地缴费起始时间">原参保地缴费起始时间:</label>
						  <div class="col-xs-9 input-group col-sm-input">
	                            	<form:input  class="form-control" type="text"  path="yuanStartDate" ></form:input>
	                            	<span class="input-group-addon">
	                                	<i class="icon-calendar bigger-110"></i>
	                            	</span>
	                           </div>									
						<label class="col-xs-3 col-sm-label" for="inputError" title="原参保地缴费截止时间">原参保地缴费截止时间:</label>
						  <div class="col-xs-9 input-group col-sm-input">
	                            	<form:input  class="form-control" type="text"  path="yuanEndDate" ></form:input>
	                            	<span class="input-group-addon">
	                                	<i class="icon-calendar bigger-110"></i>
	                            	</span>
	                           </div>											
					<label class="col-xs-3 col-sm-label" for="inputError" title="养老保险月缴费基数">养老保险月缴费基数:</label>
					 <div class="col-xs-9 col-sm-input">
						<xf:select  tableName="RSDA_TAB_PENSIONBASE" valueField="code" textField="name" name="pensionBase" selectClass="form-control" 
							value='${socialsecTransferForm.pensionBase}' hasDefault="0" ></xf:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="原单位名称">原单位名称:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="yuanCorpName"></form:input>
						</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="原单位编号">原单位编号:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="yuanCorpNumber"></form:input>
						</div>
					<label class="col-xs-3 col-sm-label" for="inputError" title="原社保机构名称">原社保机构名称:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="yuanSocialName"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="现单位名称">现单位名称:</label>
							 <div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="xianCorpName"></form:input>
							</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="现单位编号">现单位编号:</label>
							 <div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="xianCorpNumber"></form:input>
							</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="现社保机构名称">现社保机构名称:</label>
							 <div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="xianSocialName"></form:input>
							</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="医疗保险参加时间">医疗保险参加时间:</label>
						  <div class="col-xs-9 input-group col-sm-input">
	                            	<form:input  class="form-control" type="text"  path="expMedicalDate" ></form:input>
	                            	<span class="input-group-addon">
	                                	<i class="icon-calendar bigger-110"></i>
	                            	</span>
	                           </div>		 
						<label class="col-xs-3 col-sm-label" for="inputError" title="医疗保险月缴费基数">医疗保险月缴费基数:</label>
							 <div class="col-xs-9 col-sm-input">
								<xf:select  tableName="RSDA_TAB_MEDICALBASE" valueField="code" textField="name" name="medicalBase" selectClass="form-control"  
									value='${socialsecTransferForm.medicalBase}' hasDefault="0" ></xf:select>
							</div>	
						</div>
						<div class="row">							
							<label class="col-xs-3 col-sm-label" for="inputError" title="备注">备注:</label>
							<div class="col-xs-9 col-sm-three-col">
								<form:textarea  class="form-control" type="text"  path="description" cols="2" rows="2"></form:textarea>
							</div>
					   </div>
					   <div class="row">   
							<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
								 <div class="col-xs-9 col-sm-input">
									<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
								</div>
							<label class="col-xs-3 col-sm-label" for="inputError" title="经办机构名称">经办机构名称:</label>
								 <div class="col-xs-9 col-sm-input">
									<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
								</div>
							<label class="col-xs-3 col-sm-label" for="inputError" title="经办日期">经办日期:</label>
						  	<div class="col-xs-9 input-group col-sm-input">
		                     	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
		                     	<span class="input-group-addon">
		                         	<i class="icon-calendar bigger-110"></i>
		                     	</span>
		                    </div>								
				    </div>											
	       		</form:form>					
	       	</div>
	    </div>
		</div>
		 <div class="h60">&nbsp;</div>
	   	 <div class="floatBtn">
	   		<a href="javascript:void(0)" role="button" class="btn btn-success"  onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</body>
</html>