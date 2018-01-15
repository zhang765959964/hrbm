<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
					<li class="active"><a data-toggle="tab"   href="#perBase">单位申报</a></li>
					<li><a data-toggle="tab"  href="#perEdu">补贴花名册</a></li>
</ul>
<div class="tab-content">
				   <div id="perBase" class="tab-pane in active">
				        		<div class="row">
									<!-- 单条查询 --> 
									<div class="col-xs-12 pd0 tar">
									    <div class="col-xs-6 col-sm-6"></div>
										<div class="col-xs-6 col-sm-6">
											<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
											<div class="col-xs-6 col-sm-7 pr">
												<input class="form-control"  name="corpId" id="corpId" placeholder="请输入批次名称 单位名称" type="text"/>
											</div>
										</div>
									</div>
						
								</div>
				   		<form:form modelAttribute="socialCorpDeclareForm" method="post"
										action="${ctx}/business/personagency/subsidy/socialCorpDeclare/save.xf">
										
										<input id="isOverBatch" value="${isOverBatch}" type="hidden"></input>
										<form:hidden path="id"></form:hidden>
										<form:hidden path="aab001"></form:hidden>
										<form:hidden path="createrId"></form:hidden>
										<form:hidden path="createrOrgId"></form:hidden>	
										<form:hidden path="mvcMethod"></form:hidden>	
												
										<div class="moduleWrapNobg">
											<div class="moduleTit">单位基本信息</div>				
											<div class="moduleCont">
								
												<div class="row">
														<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
														<div class="col-xs-9 col-sm-2  ">
															<form:input class="form-control" type="text" path="aab004" readonly="true"></form:input>
														</div>
														<label class="col-xs-3 col-sm-2" for="inputError">单位性质:</label>
														<div class="col-xs-9 col-sm-2  ">
															<xf:select textField="name" tableName="TAB_UNITNATURE" selectClass="form-control"
																name="aab019" value="${socialCorpDeclareForm.aab019}"
																valueField="code" hasDefault="0"></xf:select>
														</div>
														<label class="col-xs-3 col-sm-2" for="inputError">填报时间:</label>
														<div class="col-xs-9 col-sm-2">
														    <div class="input-group row required">
															<form:input  class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text"  path="fillDate" placeholder="请选择日期"></form:input>
								                         	<span class="input-group-addon">
								                             	<i class="icon-calendar bigger-110"></i>
								                         	</span>
								                         	</div>
														</div>
												</div>	
												<div class="row">	
														<label class="col-xs-3 col-sm-2" for="inputError">提交批次：</label>
														<div class="col-xs-9 col-sm-2  required">
															<xf:select textField="BATCH_NAME" selectClass="form-control" tableName="RSDA_BS_SOCIAL_BATCH"
																name="batchId" value="${socialBatch.id}"
																valueField="id" hasDefault="0" id="batchId"></xf:select>
														</div>
														<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
														<div class="col-xs-9 col-sm-2  ">
															<form:input class="form-control" type="text" path="aae005"></form:input>
														</div>
														<label class="col-xs-3 col-sm-2" for="inputError">法人代表:</label>
														<div class="col-xs-9 col-sm-2  ">
															<form:input class="form-control" type="text" path="aab013"></form:input>
														</div>
												</div>	
												<div class="row">	
														<label class="col-xs-3 col-sm-2" for="inputError">负责人：</label>
														<div class="col-xs-9 col-sm-2  ">
															<form:input class="form-control" type="text" path="aae004"></form:input>
														</div>
														<label class="col-xs-3 col-sm-2" for="inputError">详细地址:</label>
														<div class="col-xs-9 col-sm-6  ">
															<form:input class="form-control" type="text" path="aae006"></form:input>
														</div>
														</div>	
												<div class="row">	
														<label class="col-xs-3 col-sm-2" for="inputError">开户银行:</label>
														<div class="col-xs-9 col-sm-2 required">
															<form:input class="form-control" type="text" path="bankName"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">银行卡号:</label>
														<div class="col-xs-9 col-sm-2 required">
															<form:input class="form-control" type="text" path="bankCardNo"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">银行账户名:</label>
														<div class="col-xs-9 col-sm-2 required">
															<form:input class="form-control" type="text" path="bankOwnerName"></form:input>
														</div>
											 	</div>
											</div>
										</div>
										<div class="moduleWrapNobg">
											<div class="moduleTit">单位补贴申报</div>
											<div class="moduleCont">
													<div class="row">
														<label class="col-xs-3 col-sm-2" for="inputError">养老保险补贴人数:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text" readonly="true" 
																path="pensionSubsidyNum"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">养老金补贴金额:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text" readonly="true" 
																path="pensionSubsidyAmount"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">医疗保险补贴人数:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text" readonly="true" 
																path="medicalSubsidyNum"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">医疗保险费补贴金额:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text" readonly="true" 
																path="medicalSubsidyAmount"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">批次人数:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text" readonly="true" 
																path="totalSubsidyNum"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">合计补贴金额:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text" readonly="true" 
																path="totalSubsidyAmount"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">审批情况:</label>
														<div class="col-xs-9 col-sm-10 ">
															<form:input class="form-control" type="text" path="approvalDesc" readonly="true" ></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">备注:</label>
														<div class="col-xs-9 col-sm-10 ">
															<form:input class="form-control" type="text" path="description"></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">经办人名称:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text" path="createrName" readonly="true" ></form:input>
														</div>
														<label class="col-xs-3 col-sm-2" for="inputError">经办机构名称:</label>
														<div class="col-xs-9 col-sm-2 ">
															<form:input class="form-control" type="text"
																path="createrOrgName" readonly="true" ></form:input>
														</div>
								
														<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
														<div class="col-xs-9 input-group col-sm-2">
															<form:input class="form-control" type="text" path="createrDate" readonly="true" ></form:input>
															<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
															</span>
														</div>
													</div>
								
											</div>
										</div>
										
								<div class="h60">&nbsp;</div>
								<div class="floatBtn">
									<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
									<a href="javascript:addItem()"  role="button" class="btn btn-primary" ><i class="icon-plus"></i>新增</a>
							
								</div>
					</form:form>
				   </div>
				   	<div id="perEdu" class="tab-pane">
						<div class="moduleWrapNob">
							<div class="moduleCont">
							    <div class="row">
							      	<div class="col-xs-12 pd0 ">
									    <div class="col-xs-6 col-sm-6">
									      <a href="javascript:refreshBatchPerson()"  role="button" class="btn btn-yellow" ><i class="icon-refresh"></i>刷新</a> 
									      <a href="javascript:addBatchPerson()"  role="button" class="btn btn-primary"><i class="icon-plus"></i>添加人员</a>
									      <a href="javascript:delBatchPerson()"  role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除人员</a> 
									    </div>
										<div class="col-xs-6 col-sm-6">
											<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
											<div class="col-xs-6 col-sm-7 pr">
												<input class="form-control"  name="personSearch" id="personSearch" placeholder="请输入身份证号 姓名" type="text"/>
											</div>
										</div>
									</div>
							    </div> 
								<div class="row">
									<div class="col-xs-12">
									   	<table id="batchList"></table>
						               	<div id="jqGridPager"></div>
					               	</div>	
					            </div>
			            	</div>
			            </div>				
					</div>
				   
</div>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/subsidyCommon.js"></script>						
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialCorpDeclareEdit.js?version=201611241648"></script>
