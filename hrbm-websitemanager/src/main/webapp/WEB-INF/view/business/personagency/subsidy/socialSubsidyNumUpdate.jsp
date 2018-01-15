<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>社保补贴管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/subsidyCommon.js"></script>	
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialSubsidyNumUpdate.js?version=201702141"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<!-- 查询条件 -->
			<div class="col-xs-12 pd0">
				<div class="moduleWrapNobg">
					<div class="moduleTit">查询条件</div>
					<div class="moduleCont">
					  <form id="searchForm">
						<div class="row">
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError">身份证号码:</label>
								<div class="col-xs-12 col-sm-7">
									<input class="form-control" type="text" name="Q_aac002_SUPL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError">姓名:</label>
								<div class="col-xs-12 col-sm-7">
								 <input class="form-control" type="text" name="Q_aac003_SL" data-placement="bottom" />
									
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError">性别:</label>
								<div class="col-xs-12 col-sm-7">
									<select class="form-control"  name="Q_aac004_S" >
										<option value="">--请选择--</option>
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError">再就业优惠证编号:</label>
								<div class="col-xs-12 col-sm-7">
									<input class="form-control" type="text" name="Q_expRegisgration_SL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError" title="就业失业登记证号码">就业失业登记证号码:</label>
								<div class="col-xs-12 col-sm-7">
									<input class="form-control" type="text" name="Q_acc0m1_SL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError" title="档案编号">档案编号:</label>
								<div class="col-xs-12 col-sm-7">
									<input class="form-control" type="text" name="Q_archiveCode_SL" data-placement="bottom" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError" title="">社保补贴编号:</label>
								<div class="col-xs-12 col-sm-7">
									<input class="form-control" type="text" name="Q_subsidyNum_SL" data-placement="bottom" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-4" style="height:32px;">
								<label class="col-xs-12 col-sm-5" for="inputError">单位名称:</label>
								<div class="col-xs-12 input-group col-sm-7"  style="padding-left:15px">
	                              <input class="form-control" type="text" name="Q_expOldCompany_SL" data-placement="bottom" />
	                           </div>
							</div>
							<div class="col-xs-12 col-sm-4" >
								<label class="col-xs-12 col-sm-5" for="inputError" title="审批通过标记">审批通过标记:</label>
								<div class="col-xs-12 col-sm-7">
									<select class="form-control"  name="Q_checkState_S" >
									    <option value="">--请选择--</option>
										<option value="未审核">未审核</option>
										<option value="通过">通过</option>
										<option value="未通过">未通过</option>
										<option value="注销">注销</option>
										<option value="提交">提交</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
						<div class="col-sm-12 mgb20 tac" style="text-align: right ;">

								<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="#modal-form" role="button" onclick="resetForm('searchForm')" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
					</div>
				</div>
			</div>
			<!-- 结果列表 -->
			<div class="col-xs-12 pd0">
				<div class="moduleWrapNob">
					<div class="moduleTit">查询结果</div>
					<div class="moduleCont">
						<div class="mgy10">
							<div class="keep-open btn-group" title="Columns">
								<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							</div>
					 	</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="socialSubsidyList"></table>
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


