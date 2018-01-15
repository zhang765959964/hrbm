<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>党费交纳统计</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/party/partyPayResultList.js?v=2017021511"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleCont">
				<p class="tac colorRed">统计信息：党员信息共计&nbsp;${sumParty }&nbsp;人，其中代管关系&nbsp;${partyStatus }&nbsp;人，欠费人数${partyOweSum }&nbsp;人</p>
			</div>
	
			<div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">身份证号码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_personCard_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_archiveCode_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_personName_SL" data-placement="bottom" />
								</div>
						</div>
						<div class="row">
						
								<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
								<div class="col-xs-9 col-sm-2">
									<select name="sex" class="form-control"> 
										<option value="">--请选择--</option>
										<option value="1">男</option>
										<option value="2">女</option>
									</select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">入党时间起:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                              	<input class="form-control" type="text" id="partyBeginDate" name="Q_beginpartyDate_DL" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">入党时间止:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                                <input class="form-control" type="text" id="partyEndDate" name="Q_endpartyDate_DL" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                     </div>	
			           </div>
			           <div class="row">
			           
								<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">转入时间起:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                            	<input class="form-control" type="text" id="beginpartyIntoDate" name="Q_beginpartyIntoDate_DL" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                     </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">转入时间止:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                            	<input class="form-control" type="text" id="endpartyIntoDate" name="Q_endpartyIntoDate_DL" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                     </div>
			            </div>
			            <div class="row">		
								<label class="col-xs-3 col-sm-2" for="inputError">转出原因:</label>
								<div class="col-xs-9 col-sm-2">
									<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_PARTY_REASON" name="partyOutReason"   valueField="code" hasDefault="0"></xf:select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">转出时间起:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                            	<input class="form-control" type="text" id="beginpartyOutDate" name="Q_beginpartyOutDate_DL" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                     </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">转出时间止:</label>
								<div class="col-xs-9 input-group col-sm-2">
	                            	<input class="form-control" type="text" id="endpartyOutDate" name="Q_endpartyOutDate_DL" />
	                              	<span class="input-group-addon">
	                                  	<i class="icon-calendar bigger-110"></i>
	                              	</span>
			                    </div>		
						</div>
						<div class="row">		
								
								<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">代管组织关系:</label>
								<div class="col-xs-9 col-sm-2">
									<select name="partyStatus" class="form-control"> 
										<option value="">--请选择--</option>
										<option value="0">否</option>
										<option value="1">是</option>
									</select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">是否欠费:</label>
								<div class="col-xs-9 col-sm-2">
									<select name="isflag" class="form-control"> 
										<option value="">--请选择--</option>
										<option value="0">是</option>
										<option value="1">否</option>
									</select>
								</div>
						</div>
						
						<div class="row">		
								<label class="col-xs-3 col-sm-2" for="inputError">转出时间起:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                            	<input class="form-control" type="text" id="begincreaterOutDate" name="begincreaterOutDate" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                     </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">转出时间止:</label>
								<div class="col-xs-9 input-group col-sm-2">
	                            	<input class="form-control" type="text" id="endcreaterOutDate" name="endcreaterOutDate" />
	                              	<span class="input-group-addon">
	                                  	<i class="icon-calendar bigger-110"></i>
	                              	</span>
			                    </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">转出经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_outCreaterName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">转出经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="" data-placement="bottom" />
								</div>
								
								
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="#modal-form" role="button"  onclick="resetForm('searchForm')"  class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
			<div class="tabable">
				<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
					<li class="active"><a data-toggle="tab" href="#perBase">党员信息</a></li>
					<li><a data-toggle="tab" href="#perEdu">党费信息</a></li>
				</ul>
				<div class="tab-content">
						<div id="perBase" class="tab-pane in active">
									<div class="moduleWrapNob">
										<div class="moduleCont">
											<div class="row">
												<div class="mgy10">
													<div class="keep-open btn-group" title="Columns">
														<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
															<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
														</a>
													</div>
												</div>
												<div class="col-xs-12">
														<table id="partyResultList"  class="datagridClass"  ></table>
														<div id="jqGridPager"></div>
												</div>
											</div>
											<span><span>交费金额:<span id="payMoney"></span></span>
										</div>
									</div>	
						</div>
							<div id="perEdu" class="tab-pane">
								<!-- 结果列表1 -->
								<div class="moduleWrapNob">
									<div class="moduleCont">
										
										<div class="row">
											<div class="mgy10">
												<div class="keep-open btn-group" title="Columns">
													<a href="javascript:void(0)" role="button" id="exp1" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
														<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
													</a>
												</div>
											</div>
											<div class="col-xs-12">
												<div class="table-responsive">
													<table id="partyResultList1"  class="datagridClass"  ></table>
													<div id="jqGridPager1"></div>
												</div>
											</div>
										</div>
										<div class="h60">&nbsp;</div>
									</div>
								</div>
						  </div>
				</div>
			</div>
			<div class="bottomBtn">
			 <div class="floatBtn clearfix">
				<a  role="button" class="btn btn-success" onclick="printPartyList()"><i class="icon-barcode"></i>打印报表</a>
			</div> 
		</div>
		</div>	
	</div>
</body>		
</html>


