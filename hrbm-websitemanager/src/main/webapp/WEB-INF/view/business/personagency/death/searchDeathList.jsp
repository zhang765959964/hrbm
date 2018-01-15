<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 死亡待遇申报</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
		<script type="text/javascript" src="${ctx}/js/business/personagency/death/searchDeathList.js?v=20161213"></script>
			<div class="moduleWrapNobg">
			<div class="moduleTit">档案信息</div>
			<div class="moduleCont">
					<input type="hidden" value="${personId}" id="personIds" />
	 				<input type="hidden"  value="${deathId }" id="deathId" />
					<form:form modelAttribute="deathPersonForm" >
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">身份号码:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input  class="form-control" type="text"  path="personCard" readonly="true"></form:input>
									<form:hidden  path="expPersonNumber"></form:hidden>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="personName" readonly="true"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="personSex" readonly="true" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" id="dabh" path="archiveCode" readonly="true" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="archiveName" readonly="true"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                          	   <form:input class="form-control" type="text" path="personCsrq" readonly="true" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                    </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                          	  <form:input class="form-control" type="text" path="archiveStorageDate" readonly="true" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                    </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">档案状态:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="archiveStatusName" readonly="true" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                       		    <form:input class="form-control" type="text" path="archiveBirthDate" readonly="true" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="archiveTypeName" readonly="true" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="corpName" readonly="true"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">接收人:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="archiveReceiveName" readonly="true" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="phone" readonly="true" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">手机号:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="mobilePhone" readonly="true" />
								</div>
						</div>
				 </form:form>
				</div>
			</div>
			<form:form modelAttribute="deathDeclareForm" method="post" action="${ctx}/business/personagency/death/save.xf" >
			<div class="moduleWrapNobg">
				<div class="moduleTit">死亡待遇审定信息</div>
				<div class="moduleCont">
					
					<form:hidden path="id" />
					<form:hidden path="deathPeopleForm.personId" />
					<form:hidden path="createrId" />
					<form:hidden path="createrOrgId" />
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="deathNo" class="form-control"  />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="deathPeopleForm.personName" class="form-control" readonly="true" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="deathPeopleForm.personSex" class="form-control" readonly="true" />
							</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="deathPeopleForm.nationName" class="form-control" readonly="true" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">离退休或退职:</label>
							<div class="col-xs-9 col-sm-2">
							    <xf:select  textField="name" selectClass="form-control" tableName="RSDA_TAB_TX_TZ" name="txTzId"  value="${deathDeclareForm.txTzId}" valueField="code" hasDefault="0"></xf:select>
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">已统筹月离退休费:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="retiredMonthMoney" class="form-control"  />
							</div>
				</div>
				<div class="row">
				
						<label class="col-xs-3 col-sm-2" for="inputError">死亡日期:</label>
						<div class="col-xs-9 input-group col-sm-2">
								<div class="input-group row">
									<form:input  class="form-control" type="text" id="deathDate" path="deathDate"></form:input>
									<span class="input-group-addon">
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
						</div>	 
						<label class="col-xs-3 col-sm-2" for="inputError">工伤死或病死:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  textField="name" selectClass="form-control" tableName="RSDA_TAB_GS_BS" name="gsBsId"  value="${deathDeclareForm.gsBsId }" valueField="code" hasDefault="0"></xf:select>
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">火葬或土葬:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  textField="name" selectClass="form-control" tableName="RSDA_TAB_HZ_TZ" name="hzTzId"  value="${deathDeclareForm.hzTzId }" valueField="code" hasDefault="0"></xf:select>
							</div>
				</div>
				<div class="row">
				
						<label class="col-xs-3 col-sm-2" for="inputError">亲属:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="relatives" class="form-control"  />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">亲属联系电话1:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="relativesPhoneOne" class="form-control"  />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">亲属联系电话2:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="relativesPhoneTwo" class="form-control"  />
							</div>
				</div>
				<div class="row">
				
				
						<label class="col-xs-3 col-sm-2" for="inputError">本企业月平均工资:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="monthAgeMoney" class="form-control"  />
							</div>

						 <div class="col-xs-12 col-sm-8">
							 <div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="备注">备注:</label>
									<div class="col-xs-9 cole -sm-9">
										<form:input type="text"  path="deathNote" class="form-control"  />
									</div>
							 </div>
						</div>
				</div>
				<hr/>
				<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">月抚恤救济金额:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="monthFjMoney" class="form-control"  onblur="sumMonthMoney()"/>
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">月付粮价补金额:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="monthFlMoney" class="form-control"  onblur="sumMonthMoney()"/>
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">以上两项月费用合计:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="monthSumMoney" class="form-control"  readonly="true" />
							</div>
				</div>
				<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">一次性抚恤救济金额:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="oneMoney" class="form-control" onblur="sumTwoMoney()"  />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">丧葬补助金额:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="sfMoney" class="form-control" onblur="sumTwoMoney()" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">以上两项一次性费用合计:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="oneSumMoney" class="form-control"   readonly="true" />
							</div>
				</div>
				<hr/>
				<div class="row">		
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
		                       		  	<form:input type="text"  path="createrDate" class="form-control" readonly="true" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                </div>	
						<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="createrOrgName" class="form-control" readonly="true" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<form:input type="text"  path="createrName" class="form-control" readonly="true" />
							</div>
				</div>
				</div>
			</div>
			<div class="moduleWrapNob">
				<div class="moduleTit">供养直系亲属情况</div>
				<div class="mgy10">
					<a href="javascript:addDeath()" role="button" class="btn btn-primary" ><i class="icon-plus"></i>添加</a>
					<a href="javascript:delDeath()" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
				</div>
				<div class="moduleCont">
					<div class="row">
						<div class="col-xs-12">
								<table id="deathDeclareList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>

			<div class="bottomBtn">
		   		<div class="h50">&nbsp;</div>
		   		<div class="floatBtn">
	   				<button id="btn" class="btn btn-primary" role="button" type="submit">
							<i class="icon-save"></i>保存
					</button>
					<a  href="javascript:delByPersonId(${personId})" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
		   		</div>
		   	</div>
	</form:form>
</body>
</html>


