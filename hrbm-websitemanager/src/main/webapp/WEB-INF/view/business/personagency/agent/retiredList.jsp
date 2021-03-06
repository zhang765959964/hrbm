<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>死亡待遇申报管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/agent/retiredList.js?v=2017011312"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<input type="hidden" id="personId" value="0" />
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
							<label class="col-xs-3 col-sm-2">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="sex" class="form-control">
									<option value="">请选择</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_retiredPeopleNo_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">个人拼音码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_pinyin_SL" data-placement="bottom" />
							</div>
						</div>
						<div class="row highCondition dnn">
							<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="begincreateWorkDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="endcreateWorkDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休申报状态:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_STATUS" name="retiredDeclareStatus" valueField="code" hasDefault="0"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休后安置地点:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_retiredSite_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休类别:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_TYPE" name="retiredTypeId" valueField="code" hasDefault="0"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否转社会化:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="isRetiredSocial" class="form-control">
									<option value="">请选择</option>
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">应退休时间起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="beginretiredDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">应退休时间止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="endretiredDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否正式退休:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="retiredStatus" class="form-control">
									<option value="">请选择</option>
									<option value="0">否</option>
									<option value="1">是</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">缴费年月起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="beginpayDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">缴费年月止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="endpayDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">原单位名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_unitName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="begincreaterDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control date" format="YYYY-MM-DD" defalutValue="false" autoUpdateInput="false" type="text" name="endcreaterDate" data-placement="bottom" />
								<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">符合离退休条款:</label>
							<div class="col-xs-9 col-sm-2">
								<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_RETIRED_GIST" name="retiredYjId" valueField="code" hasDefault="0"></xf:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="" data-placement="bottom" />
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
				<div class="moduleTit">退休人员信息</div>
				<div class="moduleCont">
					<div class="mgy10">
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
						<div class="keep-open btn-group" >
								<a href="javascript:delByPersonId()" role="button" class="btn btn-danger">
							<i class="icon-trash"></i>删除
						</a>
						</div>
					
					</div>
					<div class="row">
						<div class="col-xs-12">
							<table id="retiredList" class="datagridClass">
							</table>
							<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>


