<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>缴费记录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentRecordSearchList.js?v=20170119"></script>

</head>
<body>
<div class="main-container">
	<div class="container-fluid">
			
		<div class="row">
				
		<div class="tabable">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
				<li class="active"><a data-toggle="tab" href="#perPayment">个人费用查询</a></li>
				<li ><a data-toggle="tab" href="#perOverdue">个人欠费查询</a></li>
			</ul>

			<div class="tab-content">
				<div id="perPayment" class="tab-pane in active">
			    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
								<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
								<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
								<div class="col-xs-9 col-sm-2">
									<xf:select  tableName="TAB_SEX" selectClass="form-control" valueField="code" textField="name" name="Q_aac004_S"  hasDefault="0" valueCon="1,2"></xf:select>
								</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom" />
								</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期起:</label>
								<div class="col-xs-9 input-group col-sm-2" >
		                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginreceiveDate" name="Q_beginreceiveDate_DL" type="text" placeholder="请选择日期"/>
		                              <span class="input-group-addon">
		                                  <i class="icon-calendar bigger-110"></i>
		                              </span>
		                         </div>

								<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期止:</label>
									<div class="col-xs-9 input-group col-sm-2">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endreceiveDate" name="Q_endreceiveDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                         </div>
							    <label class="col-xs-3 col-sm-2" for="inputError">缴费标记:</label>
								<div class="col-xs-9 col-sm-2">
									<select  class="form-control" editable="false" id="null" name="Q_fdPaymentStatus_S"> 
										<option value="">--请选择--</option>
										<option value="0"> 未缴</option>
										<option value="1"> 已缴</option>
									</select>
								</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError">缴费日期起:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_beginfdPaymentDate_DL" data-placement="bottom" />
									<span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">缴费日期止:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endfdPaymentDate_DG" data-placement="bottom" />
									<span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
								</div>
								</div>
								<div class="row highCondition dnn">
								<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_beginfdCreaterDate_DL" data-placement="bottom" />
									<span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                         </span>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endfdCreaterDate_DG" data-placement="bottom" />
									<span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                        </span>
								</div>

								<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_fdCreaterName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_fdCreaterOrgName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">财务经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_fdConfirmsName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">财务经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_fdConfirmsOrgName_SL" data-placement="bottom" />
								</div>
							
								
								<label class="col-xs-3 col-sm-2" for="inputError">财务经办日期起:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_beginfdConfirmsDate_DL" data-placement="bottom" />
								    <span class="input-group-addon">
		                                  <i class="icon-calendar bigger-110"></i>
		                              </span>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">财务经办日期止:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endfdConfirmsDate_DG" data-placement="bottom" />
								    <span class="input-group-addon">
		                                  <i class="icon-calendar bigger-110"></i>
		                              </span>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">委托单位名称:</label>
										<div class="col-xs-9 col-sm-2">
											<input class="form-control" type="text" name="Q_aab004_SL" placeholder="" title="" data-placement="bottom" />
										</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
										<div class="col-xs-9 col-sm-2">
											<xf:select  selectClass="form-control" tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" ></xf:select>
										</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
										<div class="col-xs-9 col-sm-2">
											<xf:select  selectClass="form-control" tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S"  hasDefault="0" ></xf:select>
										</div>
								<label class="col-xs-3 col-sm-2" for="inputError">缴费类型:</label>
								<div class="col-xs-9 col-sm-2">
									<select  class="form-control" editable="false" id="null" name="Q_fdPaymentType_S"> 
										<option value="">--请选择--</option>
										<option value="0"> 个人缴费</option>
										<option value="1"> 单位缴费</option>
									</select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">合同编号：</label>
								<div class="col-xs-9 col-sm-2">
									 <input  class="form-control" type="text"  name="Q_contractCode_SL" ></input>
	
								</div>
												
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#paymentRecordList" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a href="javascript:resetForm('searchForm')" role="button" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
				<div class="moduleWrapNob">
				<div class="moduleTit">查询结果</div>
				<div class="moduleCont">
					<div class="mgy10">
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
						</div>
				 	</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="paymentRecordList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	

		</div>
				<div id="perOverdue" class="tab-pane in active">
                     			    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="overSearchForm">
					<div class="row">
																	
								
																	
								<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
								<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
								<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
								<div class="col-xs-9 col-sm-2">
											<xf:select selectClass="form-control" tableName="TAB_SEX" valueField="code" textField="name" name="aac004"  hasDefault="0" valueCon="1,2"></xf:select>
								</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom" />
								</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期起:</label>
									<div class="col-xs-9 input-group col-sm-2" >
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginreceiveDate" name="Q_beginreceiveDate_DL" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                         </div>

								<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期止:</label>
									<div class="col-xs-9 input-group col-sm-2">
			                              <input class="form-control date-picker dp date" format="YYYY-MM-DD" autoUpdateInput="false" id="endreceiveDate" name="Q_endreceiveDate_DG" type="text" placeholder="请选择日期"/>
			                              <span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                              </span>
			                         </div>
								</div>
								<div class="row overhighCondition dnn">

								<label class="col-xs-3 col-sm-2" for="inputError">窗口经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_archiveReceiveName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">窗口经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_archiveReceiveOrgName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">窗口经办日期起:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_beginarchiveReceiveDate_DL" data-placement="bottom" />
									<span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                         </span>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">窗口经办日期止:</label>
								<div class="col-xs-9 col-sm-2 input-group">
									<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endarchiveReceiveDate_DG" data-placement="bottom" />
									<span class="input-group-addon">
			                                  <i class="icon-calendar bigger-110"></i>
			                        </span>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
										<div class="col-xs-9 col-sm-2">
											<xf:select  selectClass="form-control" tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" ></xf:select>
										</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
										<div class="col-xs-9 col-sm-2">
											<xf:select  selectClass="form-control" tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S"  hasDefault="0" ></xf:select>
										</div>
												
						</div>
						
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doOverSearch()" class="btn btn-primary btn-border1" ><i class="icon-zoom-in"></i>查询</a>
								<a href="javascript:void(0)" onclick="toggleMore('overhighCondition',this)" class="btn btn-success highSearch" ><i class="icon-plus"></i>高级查询</a>
								<a href="javascript:resetForm('overSearchForm')" role="button" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
				<div class="moduleWrapNob">
					<div class="moduleTit">查询结果</div>
					<div class="moduleCont">
						<div class="mgy10">
							<div class="keep-open btn-group" title="Columns">
								<a href="javascript:void(0)" role="button" id="exp1" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							</div>
					 	</div>
						<div class="row">
							<div class="col-xs-12">
									<table id="paymentRecordList1"  class="datagridClass"  ></table>
									<div id="jqGridPager1"></div>
							</div>
						</div>
					</div>
			      </div>	
				</div>
			</div>
		</div>
	</div>
 </div>
</div>
</body>		
		
</html>


