<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位补贴申报管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
</head>
<body >
	<div class="main-container" >
		<div class="container-fluid">
			<div class="row" >
				<div class="col-sm-5 pd0" >
					<div class="moduleWrapNob" style="height:900px">
						<div class="moduleTit">单位批次申报</div>
						<div class="moduleCont">
						   <form id="searchForm">
								<div class="row">
									<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
									<div class="col-xs-9 col-sm-3">
										<input class="form-control" type="text" name="Q_aab004_SL" data-placement="bottom" />
									</div>
	
									<label class="col-xs-3 col-sm-2" for="inputError">批次名称:</label>
									<div class="col-xs-9 col-sm-3">
										<input class="form-control" type="text" name="Q_batchName_SL" data-placement="bottom" />
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12 mgb20 tar pdx20">
										<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
										<a href="#modal-form" onclick="resetForm('searchForm')" role="button" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
									</div>
								</div>
							</form>
							<div class="row">
								<div class="col-xs-12">
									<table id="socialCorpDeclareList"  class="datagridClass"  >							
									</table>
									<div id="jqGridPager1"></div>
								</div>
							</div>
						</div>
					</div>	
				</div>
				<div class="col-sm-7 colRight">
					<div class="moduleWrapNob" style="height:900px">
						<div class="moduleTit"><span class="fl">批次人员花名册</span><span class="fr mgr15">
						<a href="javascript:void(0)" role="button" class="btn btn-success" onclick="review(1)" data-toggle="modal"><i class="icon-check"></i>审批通过</a>&nbsp;
						<a href="javascript:void(0)" role="button" onclick="review(2)" class="btn btn-default" data-toggle="modal"><i class="icon-remove"></i>审批不通过</a></span></div>
						<div class="moduleCont">
				  <form id="personSearchForm">
					<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">身份证号码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac002_SUPL" data-placement="bottom" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_aac003_SL" data-placement="bottom" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="aac004" class="form-control">
									<option value="">--请选择--</option>
									<option value="1">男</option>
									<option value="2">女</option>
								</select>
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">再就业优惠证编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_expRegisgration_SL" data-placement="bottom" />
							</div>
						<label class="col-xs-3 col-sm-2" for="inputError">就业失业登记证号码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_acc0m1_SL" data-placement="bottom" />
							</div>						
						<label class="col-xs-3 col-sm-2" for="inputError">审批通过标记:</label>
							<div class="col-xs-9 col-sm-2">
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
							<a href="#modal-form" role="button" onclick="doPersonSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
							<a href="#modal-form" role="button" onclick="resetForm('personSearchForm')" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
						</div>
					</div>
				</form>
							<div class="row">
								<div class="col-xs-12">
									<table id="batchList" class="datagridClass" ></table>
								    <div id="jqGridPager"></div>
								</div>
							</div>
						</div>
					</div>	
				</div>
	
			</div>
		</div>
	</div>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/subsidyCommon.js?version=2016"></script>		
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialCorpDeclareList.js?version=20121224"></script>	
</body>		
</html>


