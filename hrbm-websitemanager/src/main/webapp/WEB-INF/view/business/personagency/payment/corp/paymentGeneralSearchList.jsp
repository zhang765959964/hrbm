<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位缴费管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentGeneralSearchList.js?version=20170122"></script>

</head>
<body>
<div class="main-container">
	<div class="container-fluid">
			
		<div class="row">
				
		<div class="tabable">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
				<li class="active"><a data-toggle="tab" href="#perPayment">单位费用查询</a></li>
				<li ><a data-toggle="tab" href="#perOverdue">单位欠费查询</a></li>
			</ul>

			<div class="tab-content">
				<div id="perPayment" class="tab-pane in active">
				   <div class="moduleWrapNobg">
						<div class="moduleTit">查询条件</div>
						<div class="moduleCont">
							<form id="searchForm">
							<div class="row">
								    	<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
										<div class="col-xs-9 col-sm-6">
										    	<input class="form-control" type="text" name="Q_aab004_SL" id="aab004" placeholder="单位名称" title="单位名称" data-placement="bottom" />
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">单位协议编码:</label>
										<div class="col-xs-9 col-sm-2">
											<input class="form-control" type="text" name="Q_uaNo_SL" placeholder="单位协议编码" title="单位协议编码" data-placement="bottom"/>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">工商登记执照号:</label>
										<div class="col-xs-9 col-sm-2">
											<input class="form-control" type="text" name="Q_aab007_SL" placeholder="工商登记执照号" title="工商登记执照号" data-placement="bottom"/>
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_fdCreaterName_SL" data-placement="bottom" />
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_beginfdCreaterDate_DL" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endfdCreaterDate_DG" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_fdCreaterOrgName_SL" data-placement="bottom" />
										</div>
								    	
								    	<label class="col-xs-3 col-sm-2" for="inputError">缴费状态:</label>
										<div class="col-xs-9 col-sm-2">
										<select  class="form-control" editable="false" name="Q_fdPaymentStatus_S"> 
											<option value="">--请选择--</option>
											<option value="0"> 未缴</option>
											<option value="1"> 已缴</option>
										</select>
										</div>
								    	
								    	<label class="col-xs-3 col-sm-2" for="inputError">缴费日期起:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_beginfdPaymentDate_DL" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">缴费日期止:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endfdPaymentDate_DG" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
	
								    	<label class="col-xs-3 col-sm-2" for="inputError">财务经办人:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_fdConfirmsName_SL" data-placement="bottom" />
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">财务经办日期起:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_beginfdConfirmsDate_DL" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">财务经办日期止:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endfdConfirmsDate_DG" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">财务经办机构:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_fdConfirmsOrgName_SL" data-placement="bottom" />
										</div>
								</div>
								<div class="row">
									<div class="col-sm-12 mgb20 tar pdx20">
										<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
										<!-- <a href="javascript:void(0)" class="btn btn-success highSearch" ><i class="icon-plus"></i>高级查询</a> -->
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
										<table id="paymentCorpRecordList"  class="datagridClass"  ></table>
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
							<form id="searchOverForm">
								<div class="row">
								    	<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
										<div class="col-xs-9 col-sm-6">
										    	<input class="form-control" type="text" name="Q_aab004_SL" id="aab004" placeholder="单位名称" title="单位名称" data-placement="bottom" />
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">单位协议编码:</label>
										<div class="col-xs-9 col-sm-2">
											<input class="form-control" type="text" name="Q_uaNo_SL" placeholder="单位协议编码" title="单位协议编码" data-placement="bottom"/>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">工商登记执照号:</label>
										<div class="col-xs-9 col-sm-2">
											<input class="form-control" type="text" name="Q_aab007_SL" placeholder="工商登记执照号" title="工商登记执照号" data-placement="bottom"/>
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_begincreaterDate_DL" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
										<div class="col-xs-9 input-group col-sm-2">
										    	<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" type="text" name="Q_endcreaterDate_DG" data-placement="bottom" />
										    	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
										</div>
								    	<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_createrOrgName_SL" data-placement="bottom" />
										</div>
								</div>
								<div class="row">
									<div class="col-sm-12 mgb20 tar pdx20">
										<a href="#" role="button" onclick="doOverSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
										<!-- <a href="javascript:void(0)" class="btn btn-success highSearch" ><i class="icon-plus"></i>高级查询</a> -->
										<a href="javascript:resetForm('searchOverForm')" role="button" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
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
										<table id="paymentCorpOverList"  class="datagridClass"  ></table>
										<div id="jqGridPagerOver"></div>
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


