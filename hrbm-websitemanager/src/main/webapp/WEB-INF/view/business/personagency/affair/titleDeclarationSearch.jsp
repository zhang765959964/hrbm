<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>职称申报评定表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/affair/titleDeclarationSearch.js"></script>
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
							<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="姓名拼音码">姓名拼音码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac022_SLOL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S"  hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="文化程度">文化程度:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_EDUCATION" valueField="code" textField="name" name="Q_aac011_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom" />
							</div>
						</div>
						<div class="row highCondition dnn">
							<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="现职称级别">现职称级别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_LEVEL" valueField="code" textField="name" name="Q_nowTitleGrade_S" hasDefault="0" valueCon="1,2,3" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="申报级别">申报级别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_LEVEL" valueField="code" textField="name" name="Q_declarationLevel_S" hasDefault="0" valueCon="1,2,3" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">评定结果:</label>
							<div class="col-xs-9 col-sm-2">
								<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_evaluationResult_N'>
										<option value="" selected="selected">--请选择--</option>
										<option value="0">成功</option>
										<option value="1">失败</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="工作年龄起">工作年龄起:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_beginworkingAge_S" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError" title="工作年龄止">工作年龄止:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_endworkingAge_S" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">工作单位:</label>
							<div class="col-xs-9 col-sm-6">
								<input class="form-control" type="text" name="Q_workUnit_SL" placeholder="" title="" data-placement="bottom" />
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
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_createrName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_createrOrgName_SL" placeholder="" title="" data-placement="bottom" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success highSearch"  onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a href="javascript:void(0)" onclick="resetForm('searchForm')" role="button" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>    
			<div class="moduleWrapNob">
				<div class="moduleTit">职称申报信息</div>
				<div class="moduleCont">
					<div class="mgy10">
						<div class="keep-open  btn-group vat" title="">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="titleDeclarationList" class="datagridClass"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>
</body>		
</html>