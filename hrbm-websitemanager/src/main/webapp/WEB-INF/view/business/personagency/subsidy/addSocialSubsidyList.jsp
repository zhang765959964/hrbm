<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>社保补贴管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/addSocialSubsidyList.js?version=20161131"></script>
</head>
<body>

<div class="container-fluid">
		<div class="row pd-none-wrap">
			<!-- 查询条件 -->
			<div class="col-xs-12 pd0">
				<input type="hidden" id="batchId" value="${batchId}" />
				<div class="moduleWrapNobg change-bg-iframe">
					<div class="moduleTit">查询条件</div>
					<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								<label class="col-xs-12 col-sm-label" for="inputError">身份证号码:</label>
								<div class="col-xs-12 col-sm-input">
									<input class="form-control" type="text" name="Q_aac002_SUPL" data-placement="bottom" />
								</div>
								<label class="col-xs-12 col-sm-label" for="inputError">姓名:</label>
								<div class="col-xs-12 col-sm-input">
								 <input class="form-control" type="text" name="Q_aac003_SL" data-placement="bottom" />
									
								</div>
								<label class="col-xs-12 col-sm-label" for="inputError">性别:</label>
								<div class="col-xs-12 col-sm-input">
									<select class="form-control"  name="Q_aac004_S" >
										<option value="">--请选择--</option>
										<option value="1">男</option>
										<option value="2">女</option>
									</select>
								</div>
						</div>
						<div class="row">
								<label class="col-xs-12 col-sm-label" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
								<div class="col-xs-12 col-sm-input">
									<input class="form-control" type="text" name="Q_expRegisgration_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-12 col-sm-label" for="inputError" title="就业失业登记证号码">就业失业登记证号码:</label>
								<div class="col-xs-12 col-sm-input">
									<input class="form-control" type="text" name="Q_acc0m1_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-12 col-sm-label" for="inputError" title="档案编号">档案编号:</label>
								<div class="col-xs-12 col-sm-input">
									<input class="form-control" type="text" name="Q_archiveCode_SL" data-placement="bottom" />
								</div>
						</div>
						<div class="row">
								<label class="col-xs-12 col-sm-label" for="inputError" title="">编号:</label>
								<div class="col-xs-12 col-sm-input">
									<input class="form-control" type="text" name="Q_subsidyNum_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-12 col-sm-label" for="inputError" title="单位名称">原单位名称:</label>
								<div class="col-xs-12 input-group col-sm-input"  style="padding-left:15px">
	                              <input class="form-control" type="text" name="Q_expOldCompany_SL" data-placement="bottom" />
	                           </div>
								<label class="col-xs-12 col-sm-label" for="inputError" title="审批通过标记">审批通过标记:</label>
								<div class="col-xs-12 col-sm-input">
									<select class="form-control"  name="Q_checkState_S" >
									    <option value="">--请选择--</option>
										<option value="0">未审核</option>
										<option value="1">通过</option>
										<option value="2">未通过</option>
										<option value="3">注销</option>
										<option value="4">提交</option>
									</select>
								</div>
						</div>
						<div class="row">
						<div class="col-sm-12 mgb20 tac" style="text-align: right ;">

								<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-zoom-in bigger-130"></i>查询</a>
								<a href="#modal-form" role="button" onclick="resetForm('searchForm')" class="btn btn-info" ><i class="icon-repeat bigger-130"></i>重置</a>
							</div>
						</div>
					</form>
					</div>
				</div> 
			</div>
			<!-- 结果列表 -->
			<div class="col-xs-12 pd0">
				<div class="moduleWrapNob change-bg-iframe">
					<div class="moduleTit">补贴人员列表</div>
					<div class="moduleCont">
						<div class="row">
							<div class="col-xs-12">
								<table id="socialSubsidyList"  >
								</table>
								<div id="jqGridPager"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="h60">&nbsp;</div>
	   		<div class="floatBtn">
		   		<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="addBatchPerson()"><i class="icon-plus"></i>添加</a>
		   		<a href="javascript:void(0)" role="button" class="btn btn-success" onclick="xfui.closeDialog()"><i class="icon-remove"></i>关闭</a> 
	   		</div>
	   		<input id="batchId" value="${batchId}" type="hidden"/>
		</div>
	</div>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/subsidyCommon.js"></script>		
</body>		
</html>


