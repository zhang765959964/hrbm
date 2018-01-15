<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>借阅归还综合查询</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/archive/archiveCheckoutList.js?verson=201612280"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">身份证号:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">借阅种类:</label>
							<div class="col-xs-12 col-sm-2">
								<xf:select  tableName="RSDA_TAB_CHECKOUKINDS" valueField="code" hasDefault="0" textField="name" name="Q_checkoutKinds_S" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案转入日期起:</label>
							<div class="col-xs-12 input-group col-sm-2" >
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginreceiveDate" name="Q_beginreceiveDate_DL" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案转入日期止:</label>
							<div class="col-xs-12 input-group col-sm-2">
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endreceiveDate" name="Q_endreceiveDate_DG" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
						</div>
						<div class="row highCondition dnn">
							<label class="col-xs-12 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案出生日期起:</label>
							<div class="col-xs-12 input-group col-sm-2" >
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginarchiveBirthDate" name="Q_beginarchiveBirthDate_DL" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案出生日期止:</label>
							<div class="col-xs-12 input-group col-sm-2">
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endarchiveBirthDate" name="Q_endarchiveBirthDate_DG" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">借阅状态:</label>
							<div class="col-xs-12 col-sm-2">
								<xf:select  tableName="RSDA_TAB_CHECKOUTSTATUS" valueField="code" hasDefault="0" textField="name" name="Q_checkoutStatus_S" selectClass="form-control" valueCon="1,2,3,4"></xf:select>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">借阅日期起:</label>
							<div class="col-xs-12 input-group col-sm-2" >
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincheckoutDate" name="Q_begincheckoutDate_DL" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">借阅日期至:</label>
							<div class="col-xs-12 input-group col-sm-2">
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcheckoutDate" name="Q_endcheckoutDate_DG" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="借阅单位">借阅单位:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkoutCorp_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="借阅人">借阅人:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkoutPerson_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">借阅时间至:</label>
							<div class="col-xs-12 input-group col-sm-2">
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcheckoutPeriodDate" name="Q_endcheckoutPeriodDate_DG" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-12 col-sm-2">
								<xf:select tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S" hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">返还日期起:</label>
							<div class="col-xs-12 input-group col-sm-2" >
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincheckinDate" name="Q_begincheckinDate_DL" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">返还日期至:</label>
							<div class="col-xs-12 input-group col-sm-2">
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcheckinDate" name="Q_endcheckinDate_DG" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">借阅类别:</label>
							<div class="col-xs-12 col-sm-2">
								<xf:select  tableName="RSDA_TAB_CHECKOUTTYPE" valueField="code" textField="name" name="Q_checkoutType_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案室借阅日期起:</label>
							<div class="col-xs-12 input-group col-sm-2" >
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincheckoutConfirmDate" name="Q_begincheckoutConfirmDate_DL" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案室借阅日期至:</label>
							<div class="col-xs-12 input-group col-sm-2">
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcheckoutConfirmDate" name="Q_endcheckoutConfirmDate_DG" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
							<div class="col-xs-12 col-sm-2">
								<xf:select  tableName="RSDA_TAB_ARCHIVESTATUS" valueField="code" textField="name" name="Q_archiveStatus_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案室返还日期起:</label>
							<div class="col-xs-12 input-group col-sm-2" >
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincheckinConfirmDate" name="Q_begincheckinConfirmDate_DL" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案室返还日期至:</label>
							<div class="col-xs-12 input-group col-sm-2">
	                          <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcheckinConfirmDate" name="Q_endcheckinConfirmDate_DG" type="text" placeholder="请选择日期"/>
	                          <span class="input-group-addon">
	                              <i class="icon-calendar bigger-110"></i>
	                          </span>
	                        </div>
							<label class="col-xs-12 col-sm-2" for="inputError">存档类型:</label>
							<div class="col-xs-12 col-sm-2">
								<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="档案借阅经办人">档案室借阅经办人:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkoutConfirmName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="窗口借阅经办人">窗口借阅经办人:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkoutRegisterName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="档案室归还经办人">档案室返还经办人:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkinConfirmName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="窗口归还经办人">窗口返还经办人:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkinName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="档案室借阅经办机构">档案室借阅经办机构:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkoutConfirmOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="窗口借阅经办机构">窗口借阅经办机构:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkoutRegisterOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="档案室借阅经办机构">档案室返还经办机构:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkinConfirmOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError" title="窗口借阅经办机构">窗口返还经办机构:</label>
							<div class="col-xs-12 col-sm-2">
								<input class="form-control" type="text" name="Q_checkinOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a href="#modal-form" onclick="resetForm('searchForm')" role="button" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="moduleWrapNob">
				<div class="moduleTit"><span class="fl">查询结果</span>
					<span class="fr mgr15">
						<a role="button" class="btn btn-danger " href="javascript:searchMaturityNotReturned()"><i class="icon-search"></i>到期未返还名单</a>
						<!-- <a role="button" class="btn btn-danger " href="javascript:searchChildReceive()"><i class="icon-edit"></i>短信通知</a> -->
					</span>
				</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" role="button" class="btn btn-success"><i class="icon-edit"></i>导入</a>
						<div class="keep-open  btn-group vat" title="">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="archiveCheckoutList" class="datagridClass"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>