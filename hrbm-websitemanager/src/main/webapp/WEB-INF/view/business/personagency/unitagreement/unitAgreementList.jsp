<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位协议查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/unitagreement/unitAgreementList.js?v=20170101811"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<div class="col-xs-12 col-sm-8">
								<div class="row">
									<label class="col-xs-3 col-sm-3" for="inputError" title="单位名称">单位名称:</label>
									<div class="col-xs-12 col-sm-9">
										<input class="form-control" type="text" name="Q_aab004_SL" id="aab004" title="单位名称" data-placement="bottom" />
									</div>
								</div>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="单位性质:">单位性质:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="TAB_UNITNATURE" hasDefault="0" name="aab019" valueField="code"></xf:select>
							</div>
						</div>
						<div class="row">

							<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="TAB_ECONOMIC" hasDefault="0" name="aab020" valueField="code"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">所在地区:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="aaa021" id="addre" title="所在地区" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">工商登记执照号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aab007_SL" title="工商登记执照号" data-placement="bottom" />
							</div>
						</div>
						<div class="row highCondition dnn">
							<label class="col-xs-3 col-sm-2" for="inputError" title="联系人">联系人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_uaName_SL" title="联系人" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_uaPhone_SL" title="联系电话" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="办理人身份证号">办理人身份证号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_uaCard_SL" title="办理人身份证号" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="经办日期起">经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="beginuaCreatetime" name="Q_begincreaterDate_DL" title="经办日期起" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="经办日期止">经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="enduaCreatetime" name="Q_endcreaterDate_DL" title="经办日期起" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="有效标记">有效标记:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="uaStatus" class="">
									<option value="">请选择</option>
									<option value="0">签订协议</option>
									<option value="1">协议终止</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1">
									<i class="icon-search"></i>查询
								</a>
								<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)">
									<i class="icon-plus"></i>高级查询
								</a>
								<a href="#modal-form" role="button" onclick="resetForm('searchForm')" class="btn btn-info">
									<i class="icon-repeat"></i>重置
								</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="moduleWrapNob">
				<div class="moduleTit">查询结果</div>
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
							<table id="unitAgreementList"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

