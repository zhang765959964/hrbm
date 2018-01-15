<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案调出表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/archiveLendSearch.js?verson=2016122036"></script>
</head>
<body>
<div class="main-container">
	<div class="container-fluid">
		<div class="row">
		    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S"  hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom" />
							</div>
							<%-- <label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
							</div> --%>
							<label class="col-xs-3 col-sm-2" for="inputError" title="调出状态">调出状态:</label>
							<div class="col-xs-9 col-sm-2">
								<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_lendFlowStatus_N'>
										<option value="" selected="selected">--请选择--</option>
										<option value="4">调出登记</option>
										<option value="5">调出确认</option>
								</select>
							</div>
							<!-- <label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveName_SL" placeholder="" title="" data-placement="bottom" />
							</div> -->
							<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginreceiveDate" name="Q_beginreceiveDate_DL" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endreceiveDate" name="Q_endreceiveDate_DG" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                            </div>
                            <label class="col-xs-3 col-sm-2" for="inputError">调出日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginlendDate" name="Q_beginlendDate_DL" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
						  <label class="col-xs-3 col-sm-2" for="inputError">调出日期止:</label>
						  <div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endlendDate" name="Q_endlendDate_DG" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
						  <label class="col-xs-3 col-sm-2" for="inputError">档案去向(单位):</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archivesLendWhere_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出原因:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_LEND_REASON" valueField="code" hasDefault="0" textField="name" name="Q_lendReason_S" 
										selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_lendCreaterName_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_lendCreaterOrgName_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginlendCreaterDate" name="Q_beginlendCreaterDate_DL" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
						  <label class="col-xs-3 col-sm-2" for="inputError">调出经办日期止:</label>
						  <div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endlendCreaterDate" name="Q_endlendCreaterDate_DG" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-zoom-in"></i>查询</a>
								<a href="javascript:void(0)" role="button" onclick="resetForm('searchForm')" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
			<div class="moduleWrapNob">
				<div class="moduleTit">调出信息列表</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" role="button" class="btn btn-success"><i class="icon-edit"></i>导入</a>
						<div class="keep-open  btn-group vat" title="">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
					</div>
					<div class="dataTableWrap">
						<table id="archiveLendListSearch"  class="datagridClass"></table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>
</body>		
</html>