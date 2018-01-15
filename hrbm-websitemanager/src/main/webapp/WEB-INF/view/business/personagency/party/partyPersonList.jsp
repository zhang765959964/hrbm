<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>党组织关系查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/party/partyPersonList.js?v=20170210"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
		    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">身份证号码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_personCard_SL"  />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_personName_SL"  />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">姓名拼音码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_pinyin_SL"  />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="sex" class="form-control"> 
									<option value="">--请选择--</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="TAB_NATION" name="minzu"   valueField="code" hasDefault="0"></xf:select>					
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="TAB_EDUCATION" name="whcd"   valueField="code" hasDefault="0"></xf:select>				
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL"  />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_ARCHIVETYPE" name="archiveType"   valueField="code" hasDefault="0"></xf:select>		
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">曾用名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_expUserName_SL"  />
							</div>
						</div>
						<div class="row highCondition dnn">
							
							<label class="col-xs-3 col-sm-2" for="inputError">转入日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
		                        <input class="form-control" type="text" id="beginpartyIntoDate" name="Q_beginpartyIntoDate_DL"  />
		                        <span class="input-group-addon">
		                            <i class="icon-calendar bigger-110"></i>
		                        </span>
		                    </div>
							<label class="col-xs-3 col-sm-2" for="inputError">转入日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
	                            <input class="form-control" type="text" id="endpartyIntoDate" name="Q_endpartyIntoDate_DL"  />
                             	<span class="input-group-addon">
		                            <i class="icon-calendar bigger-110"></i>
		                        </span>
	                     	</div>	
							<label class="col-xs-3 col-sm-2" for="inputError">代管组织关系:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="partyStatus" class="form-control"> 
									<option value="">--请选择--</option>
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
						
							<label class="col-xs-3 col-sm-2" for="inputError">转出日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
	                           <input class="form-control" type="text" id="beginpartyOutDate" name="Q_beginpartyOutDate_DL"  />
	                           <span class="input-group-addon">
		                            <i class="icon-calendar bigger-110"></i>
		                        </span>
		                     </div>	
							<label class="col-xs-3 col-sm-2" for="inputError">转出日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                             	<input class="form-control" type="text" id="endpartyOutDate" name="Q_endpartyOutDate_DL"  />
                              	<span class="input-group-addon">
		                            <i class="icon-calendar bigger-110"></i>
		                        </span>
		                    </div>
		                    <label class="col-xs-3 col-sm-2" for="inputError">转出原因:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_PARTY_REASON" name="partyOutReason"   valueField="code" hasDefault="0"></xf:select>		
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_createrName_SL"  />
							</div>
							 <label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
		                         		<input class="form-control" type="text" id="begincreaterDate" name="Q_begincreaterDate_DL"  />
		                             	<span class="input-group-addon">
		                                 	<i class="icon-calendar bigger-110"></i>
		                             	</span>
		                     </div>	
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
		                          		<input class="form-control" type="text" id="endcreaterDate" name="Q_endcreaterDate_DL" />
		                             	<span class="input-group-addon">
		                                 	<i class="icon-calendar bigger-110"></i>
		                             	</span>
		                     </div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_createrOrgName_SL"  />
							</div> 
							 <label class="col-xs-3 col-sm-2" for="inputError">转出经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
		                         		<input class="form-control" type="text" id="begincreaterOutDate" name="Q_begincreaterOutDate_DL"  />
		                             	<span class="input-group-addon">
		                                 	<i class="icon-calendar bigger-110"></i>
		                             	</span>
		                     </div>	
							<label class="col-xs-3 col-sm-2" for="inputError">转出经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
		                          		<input class="form-control" type="text" id="endcreaterOutDate" name="Q_endcreaterOutDate_DL" />
		                             	<span class="input-group-addon">
		                                 	<i class="icon-calendar bigger-110"></i>
		                             	</span>
		                     </div>
		                     <label class="col-xs-3 col-sm-2" for="inputError">转出经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_outCreaterName_SL"  />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转出经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_outCreaterOrgName_SL"  />
							</div> 
							
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a href="#modal-form" role="button"  onclick="resetForm('searchForm')"  class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
			<div class="tabable">
				<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
					<li class="active"><a data-toggle="tab" href="#perBase">党组织关系转入转出</a></li>
<!-- 					<li><a data-toggle="tab" href="#perEdu">党费交纳</a></li> -->
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
										<table id="partyPersonList"  class="datagridClass"  ></table>
										<div id="jqGridPager"></div>
									</div>
								</div>
							</div>
						</div>	
					</div>
					
				<!-- 	<div id="perEdu" class="tab-pane">
						结果列表1
						<div class="moduleWrapNob">
							<div class="moduleCont">
								<div class="mgy10"></div>
								<div class="row">
									<div class="col-xs-12">
										<table id="partyPersonList1"  class="datagridClass"  ></table>
										<div id="jqGridPager1"></div>
									</div>
								</div>
								<div class="h60">&nbsp;</div>
							</div>
						</div>
				   </div> -->
				</div>
			</div>
		</div>
	</div>
</body>		
</html>


