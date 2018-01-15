<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>退休人员登记</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/retiredPersonList.js?v=20171106"></script>
</head>
<body>
<div class="container-fluid">
	<div class="row">
	    <div class="moduleWrapNobg">
			<div class="moduleTit">查询条件</div>
			<div class="moduleCont">
				<form id="searchForm">
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_archiveCode_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_personCard_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_personName_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
						<div class="col-xs-9 col-sm-2">
							<select name="sex" class="form-control">
								<option value="">--请选择--</option>
								<option value="1">男</option>
								<option  value="2">女</option>
							</select>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_retiredPeopleNo_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">是否正式退休:</label>
						<div class="col-xs-9 col-sm-2">
							<select name="retiredStatus" class="form-control">
								<option value="">--请选择--</option>
								<option value="0">否</option>
								<option  value="1">是</option>
							</select>
							
						</div>
					</div>
					<div class="row highCondition dnn">		
						<label class="col-xs-3 col-sm-2" for="inputError">应退休时间起:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<input class="form-control" type="text" id="beginretiredDate" name="Q_beginretiredDate_DL" data-placement="bottom" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">应退休时间止:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<input class="form-control" type="text" id="endretiredDate" name="Q_endretiredDate_DL" data-placement="bottom" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						
						
						<label class="col-xs-3 col-sm-2" for="inputError">个人拼音码:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_pinyin_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<input class="form-control" type="text" id="begincreaterDate"  name="Q_begincreaterDate_DL" data-placement="bottom" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<input class="form-control" type="text" id="endcreaterDate" name="Q_endcreaterDate_DL" data-placement="bottom" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">退休申报状态:</label>
						<div class="col-xs-9 col-sm-2">
							<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_STATUS" name="retiredDeclareStatus"  value="${retiredDeclareForm.retiredDeclareStatus}"  valueField="code" hasDefault="0"></xf:select>					
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
								<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_TYPE" name="retiredTypeId"  value="${retiredDeclareForm.retiredTypeId}"  valueField="code" hasDefault="0"></xf:select>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 mgb20 tar pdx20">
							<a href="#retiredPersonList" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
							<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
							<a href="#modal-form" role="button"  onclick="resetForm('searchForm')"  class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
						</div>
					</div>
				</form>
			</div>
		</div>		
		<div class="moduleWrapNob">
			<div class="moduleTit">退休申报信息</div>
			<div class="moduleCont">
				 <div class="mgy10">
					<div class="keep-open btn-group" title="Columns">
						<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
						<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12">
							<table id="retiredPersonList"  class="datagridClass"  ></table>
							<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>	
			
		<form:form modelAttribute="retiredPersonForm" method="post">
			<div class="moduleCont">
				<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
				<div class="col-xs-9 input-group col-sm-2">
	                  <form:input  class="form-control" type="text"  path="createrDate"  readonly="true"></form:input>
	                  <span class="input-group-addon">
	                     <i class="icon-calendar bigger-110"></i>
	                  </span>
	            </div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
				<div class="col-xs-9 col-sm-2">
			    	<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
				<div class="col-xs-9 col-sm-2">
				    <form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
				</div>
				</div>
			</div>
			<hr/>
			<div class="bottomBtn">
			   	<div class="h50">&nbsp;</div>
			 	<div class="floatBtn">
			 		<a href="javascript:void(0)" role="button" onclick="review(1,3)"  class="btn btn-info" data-toggle="modal"><i class="icon-ok"></i>确定退休</a>
					<a href="javascript:void(0)" role="button" onclick="review(0,2)" class="btn btn-info" data-toggle="modal"><i class="icon-hand-down"></i>取消退休</a>
			   	</div>
			</div>
		</form:form>
	</div>
</div>

		
</body>		
</html>


