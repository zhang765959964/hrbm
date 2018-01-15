<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>特殊档案表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/storage/specialArchivesList.js?verson=201612281520"></script>
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
								<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S" hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">学校名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_schoolName_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">班级:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_schoolClass_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">专业:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_major_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_corpName_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">特殊档案类别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select  tableName="RSDA_TAB_SPECIAL_TYPE" valueField="code" textField="name" name="Q_specialType_S"  hasDefault="0" selectClass="form-control"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">特殊档案情况:</label>
							<div class="col-xs-9 col-sm-2">
								<select style='width: 205px' class='easyui-combobox' editable='false' name='Q_specialStatus_N'>
									<option value="" selected="selected">--请选择--</option>
									<option value="0">入档</option>
									<option value="1">已转出</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								  <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginlrCreaterDate" name="Q_beginlrCreaterDate_DL" type="text" placeholder="请选择日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								  <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endlrCreaterDate" name="Q_endlrCreaterDate_DL" type="text" placeholder="请选择日期"/>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_lrCreaterName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_lrCreaterOrgName_SL" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">编号起:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_beginSpecialNumber_S" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">编号止:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_endSpecialNumber_S" data-placement="bottom"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转出办理人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_zcName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转出办理人电话:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_zcPhone_SL" data-placement="bottom" />
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
				<div class="moduleTit">特殊类档案信息列表</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addSpecialArchives()"  role="button" class="btn btn-primary" data-toggle="modal"><i class=" icon-plus-sign"></i>录入</a>
						<a href="javascript:void(0)" onclick="editSpecialArchives()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-minus-sign"></i>转出</a>
						<a href="javascript:void(0)" onclick="delSpecialArchives()"  role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>删除</a>
						<a href="${ctx}/sys/component/data/tempDown.xf?tempFileName=特殊类档案管理导入模板.xls" role="button" class="btn btn-yellow"><i class="icon-download"></i>模板下载</a>
						<a href="javascript:void(0)" id="imp" role="button" class="btn btn-success"><i class="icon-edit"></i>导入</a>
						<div class="keep-open  btn-group vat" title="">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="specialArchivesList"  class="datagridClass"></table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</body>		
</html>