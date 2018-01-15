<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>委托类型变更管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/entrust/searchCommissionChangeList.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
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
							<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S"  hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_archiveCodehb_SL" placeholder="" title="档案编号" data-placement="bottom" />
						</div>
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
						<label class="col-xs-3 col-sm-2" for="inputError">变更类型:</label>
						<div class="col-xs-9 col-sm-2">
							<xf:select  tableName="RSDA_TAB_TYPE_CHANGE" valueField="code" textField="name" name="Q_commissionType_S"  hasDefault="0" selectClass="form-control"></xf:select>			
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">变更日期起:</label>
						<div class="col-xs-9 input-group col-sm-2" >
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincommissionDate" name="Q_begincommissionDate_DL" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                          </div>
						<label class="col-xs-3 col-sm-2" for="inputError">变更日期止:</label>
						<div class="col-xs-9 input-group col-sm-2">
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcommissionDate" name="Q_endcommissionDate_DG" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                           </div>
						<label class="col-xs-3 col-sm-2" for="inputError">变更委托单位名称:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_commissionCorpName_SL" placeholder="" title="变更类型" data-placement="bottom"/>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
						<div class="col-xs-9 col-sm-2">
							<xf:select  tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S"  hasDefault="0" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
						<div class="col-xs-9 col-sm-2">
							<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_createrName_SL" placeholder="" title="" data-placement="bottom"/>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
						<div class="col-xs-9 input-group col-sm-2" >
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincreaterDate" name="Q_begincreaterDate_DL" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                          </div>
					   <label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
					   <div class="col-xs-9 input-group col-sm-2">
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcreaterDate" name="Q_endcreaterDate_DG" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                           </div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_createrOrgName_SL" placeholder="" title="" data-placement="bottom"/>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 mgb20 tar pdx20">
							<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
							<a class="btn btn-info" href="javascript:void(0)" onclick="$('#reset').click()" role="button" ><i class="icon-repeat"></i>重置</a>
							<input id="reset" class="dn" type="reset">
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="moduleWrapNob">
			<div class="moduleTit">类型变更列表</div>
			<div class="moduleCont">
				<div class="row">
					<div class="mgy10">
						<div class="keep-open  btn-group vat" title="">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
					</div>
					<div class="col-xs-12">
						<table id="commissionChangeList" class="datagridClass"></table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>