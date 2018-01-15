<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>查询列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/social/changeAndTransferSearch.js?verson=20170110"></script>
	<script type="text/javascript">
		$(function() {
			xfui.initUi();
			initTable();
			initTransferTable();
			$("#socialsecTransferListid2").removeClass("in").removeClass("active");
			loadData();
		});
		function loadData(){
			$("#changeReportingList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/social/changeReporting/listJson.xf',postData:json}).trigger("reloadGrid");
			$("#socialsecTransferList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/social/socialsecTransfer/listJson.xf',postData:json}).trigger("reloadGrid");
		}
	</script>
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
								<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S" hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">有效标记:</label>
							<div class="col-xs-9 col-sm-2">
								<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_isEffective_N'>
										<option value="" selected="selected">--请选择--</option>
										<option value="0">有效</option>
										<option value="1">无效</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_createrName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_createrOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2" >
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="begincreaterDate" name="Q_begincreaterDate_DL" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
                              <input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="endcreaterDate" name="Q_endcreaterDate_DG" type="text" placeholder="请选择日期"/>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
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
			<!-- tab选项卡 -->
			<div class="tabable">
				<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
					<li class="active"><a data-toggle="tab" href="#changeReportingListid1">变更申报信息</a></li>
					<li><a data-toggle="tab" href="#socialsecTransferListid2">统筹范围内转移信息</a></li>
				</ul>
				<div class="tab-content">
					<div id="changeReportingListid1" class="tab-pane in active">
						<div class="moduleWrapNob">
							<div class="moduleCont">
								<div class="mgy10">
									<div class="keep-open  btn-group vat" title="">
										<a href="javascript:void(0)" role="button" id="expReporting" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
										</a>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<table id="changeReportingList" class="datagridClass"></table>
										<div id="jqGridPager1"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="socialsecTransferListid2" class="tab-pane in active">
						<div class="moduleWrapNob">
							<div class="moduleCont">
								<div class="mgy10">
									<div class="keep-open  btn-group vat" title="">
										<a href="javascript:void(0)" role="button" id="expTransfer" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
											<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
										</a>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<table id="socialsecTransferList" class="datagridClass"></table>
										<div id="jqGridPager2"></div>
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