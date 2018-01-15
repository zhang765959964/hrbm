<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>社保补贴管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/subsidyCommon.js"></script>	
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialSubsidyList.js?v=201711611"></script>
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
									<option value="男">男</option>
									<option value="女">女</option>
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
						<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_archiveCode_SL" data-placement="bottom" />
							</div>
							
						<label class="col-xs-3 col-sm-2" for="inputError">编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_subsidyNum_SL" data-placement="bottom" />
							</div>
							
						<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_expOldCompany_SL" data-placement="bottom" />
							</div>
							
						<label class="col-xs-3 col-sm-2" for="inputError">审批通过标记:</label>
							<div class="col-xs-9 col-sm-2">
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
					
					<div class="row highCondition dnn">		
						<label class="col-xs-3 col-sm-2" for="inputError">登记次数起:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<input class="form-control" type="text"  name="begincreaterNum" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">登记次数止:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<input class="form-control" type="text"  name="endncreaterNum" data-placement="bottom" />
						</div>
						
<!-- 						<label class="col-xs-3 col-sm-2">有效标记:</label> -->
<!-- 						<div class="col-xs-9 col-sm-2"> -->
<!-- 								<select class="form-control"  name="" > -->
<!-- 								   	<option value="">--请选择--</option> -->
<!-- 									<option value="0">无效</option> -->
<!-- 									<option value="1">有效</option> -->
<!-- 								</select> -->
<!-- 							</div>	 -->
						
<!-- 						<label class="col-xs-3 col-sm-2">是否登记养老:</label> -->
<!-- 						<div class="col-xs-9 col-sm-2"> -->
<!-- 							<select name="" class="form-control"> -->
<!-- 								<option value="">--请选择--</option> -->
<!-- 								<option value="0">否</option> -->
<!-- 								<option value="1">是</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 						<label class="col-xs-3 col-sm-2" for="inputError">提交批次:</label> -->
<!-- 						<div class="col-xs-9 col-sm-2"> -->
<!-- 							<input class="form-control" type="text" name="" data-placement="bottom" /> -->
<!-- 						</div> -->
<!-- 						<label class="col-xs-3 col-sm-2" for="inputError">是否登记医疗:</label> -->
<!-- 						<div class="col-xs-9 col-sm-2"> -->
<!-- 							<select name="" class="form-control"> -->
<!-- 								<option value="">--请选择--</option> -->
<!-- 								<option value="0">否</option> -->
<!-- 								<option value="1">是</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
					
						<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
						<div class="col-xs-9 input-group col-sm-2">
							<input class="form-control" type="text" id="begincreaterDate" name="begincreaterDate" data-placement="bottom" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
						
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
								<div class="col-xs-9 input-group col-sm-2">
									<input class="form-control" type="text" id="endcreaterDate" name="endcreaterDate" data-placement="bottom" />
										<span class="input-group-addon">
											<i class="icon-calendar bigger-110"></i>
										</span>
								</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_createrOrgName_SL" data-placement="bottom" />
						</div>
<!-- 						<label class="col-xs-3 col-sm-2" for="inputError">市审批经办日期起:</label> -->
<!-- 						<div class="col-xs-9 input-group col-sm-2"> -->
<!-- 							<input class="form-control" type="text" id="" name="" data-placement="bottom" /> -->
<!-- 								<span class="input-group-addon"> -->
<!-- 									<i class="icon-calendar bigger-110"></i> -->
<!-- 								</span> -->
<!-- 							</div> -->
<!-- 						<label class="col-xs-3 col-sm-2" for="inputError">市审批经办日期止:</label> -->
<!-- 						<div class="col-xs-9 input-group col-sm-2"> -->
<!-- 						<input class="form-control" type="text" id="" name="" data-placement="bottom" /> -->
<!-- 							<span class="input-group-addon"> -->
<!-- 								<i class="icon-calendar bigger-110"></i> -->
<!-- 							</span> -->
<!-- 						</div> -->
						
<!-- 						<label class="col-xs-3 col-sm-2" for="inputError">市审批经办人:</label> -->
<!-- 							<div class="col-xs-9 col-sm-2"> -->
<!-- 								<input class="form-control" type="text" name="" data-placement="bottom" /> -->
<!-- 							</div> -->
<!-- 						<label class="col-xs-3 col-sm-2" for="inputError">市审批经办机构:</label> -->
<!-- 							<div class="col-xs-9 col-sm-2"> -->
<!-- 								<input class="form-control" type="text" name="" data-placement="bottom" /> -->
<!-- 							</div> -->
						<label class="col-xs-3 col-sm-2" for="inputError">老编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_oldSubsidyNum_SL" data-placement="bottom" />
							</div>
							
						<label class="col-xs-3 col-sm-2" for="inputError">是否通过:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="isPassed" class="form-control">
									<option value="">--请选择--</option>
									<option value="不通过">不通过</option>
									<option value="通过">通过</option>
								</select>
							</div>
					</div>
					<div class="row">
						<div class="col-sm-12 mgb20 tac" style="text-align: right ;">
							<a href="#modal-form" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
							<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
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
					<div class="row">
						<div class="mgy10">
							<div class="keep-open btn-group" title="Columns">
								<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							</div>
					 	</div>
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


