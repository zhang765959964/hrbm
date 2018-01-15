<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>退休手续申报</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
</head>

<div class="row">
	<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_dabh_SL" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_personCard_SL" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_personName_SL" />
	</div>
	<label class="col-xs-3 col-sm-2">性别:</label>
	<div class="col-xs-9 col-sm-2">
		<select name="sex" class="form-control">
			<option value="">--请选择--</option>
			<option value="1">男</option>
			<option value="2">女</option>
		</select>
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_retiredPeopleNo_SL" data-placement="bottom" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">退休申报状态:</label>
	<div class="col-xs-9 col-sm-2">
		<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_STATUS" name="retiredDeclareStatus" value="${retiredDeclareForm.retiredDeclareStatus}" valueField="code" hasDefault="0"></xf:select>
	</div>
</div>
<div class="row highCondition dnn">
	<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
	<div class="col-xs-9 input-group col-sm-2">
		<input class="form-control" type="text" id="begincreaterDate" name="Q_begincreaterDate_DL" data-placement="bottom" />
		<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
		</span>
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
	<div class="col-xs-9 input-group col-sm-2">
		<input class="form-control" type="text" id="endcreaterDate" name="Q_endcreaterDate_DL" data-placement="bottom" />
		<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
		</span>
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">个人拼音码:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_pinyin_SL" data-placement="bottom" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_createrOrgName_SL" data-placement="bottom" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">退休人员所属区域:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="Q_retiredArea_SL" data-placement="bottom" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">退休个人编码起:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="retiredPeopleBmStart" data-placement="bottom" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">退休个人编码止:</label>
	<div class="col-xs-9 col-sm-2">
		<input class="form-control" type="text" name="retiredPeopleBmEnd" data-placement="bottom" />
	</div>
	<label class="col-xs-3 col-sm-2" for="inputError">退休类别:</label>
	<div class="col-xs-9 col-sm-2">
		<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_TYPE" name="retiredTypeId" value="${retiredDeclareForm.retiredTypeId}" valueField="code" hasDefault="0"></xf:select>
	</div>
</div>


</html>