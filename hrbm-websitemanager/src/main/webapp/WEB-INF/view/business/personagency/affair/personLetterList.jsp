<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>人事档案联系函表管理</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/affair/personLetterList.js?verson=201705103002"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
		    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_aac003_SL" data-placement="bottom"/>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">开具日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                     	<input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="begindateOfIssue" name="Q_begindateOfIssue_DL" type="text" placeholder="请选择日期"/>
			                     	<span class="input-group-addon">
			                         	<i class="icon-calendar bigger-110"></i>
			                     	</span>
			                    </div>
								<label class="col-xs-3 col-sm-2" for="inputError">开具日期止:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                     	<input class="form-control date"  format="YYYY-MM-DD" autoUpdateInput="false" id="enddateOfIssue" name="Q_enddateOfIssue_DG" type="text" placeholder="请选择日期"/>
			                     	<span class="input-group-addon">
			                         	<i class="icon-calendar bigger-110"></i>
			                     	</span>
			                    </div>
								<label class="col-xs-3 col-sm-2" for="inputError">文件号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_fileNumber_SL" data-placement="bottom"/>
								</div>
								<div class="col-xs-12 col-sm-8 mgb0">
									<div class="row mgb0">
										<label class="col-xs-3 col-sm-3" for="inputError" title="工作单位">工作单位:</label>
										<div class="col-xs-12 col-sm-9">
											<input class="form-control" type="text" name="Q_workUnit_SL" data-placement="bottom"/>
										</div>
									</div>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                         	<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincreaterDate" name="Q_begincreaterDate_DL" type="text" placeholder="请选择日期"/>
			                         	<span class="input-group-addon">
			                             	<i class="icon-calendar bigger-110"></i>
			                         	</span>
			                       </div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                         	<input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcreaterDate" name="Q_endcreaterDate_DL" type="text" placeholder="请选择日期"/>
		                         	<span class="input-group-addon">
		                             	<i class="icon-calendar bigger-110"></i>
		                         	</span>
		                       </div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_createrOrgName_SL" data-placement="bottom" />
								</div>
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary"><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" role="button" onclick="$('#reset').click()" class="btn btn-info"><i class="icon-repeat"></i>重置</a>
								<input id="reset" hidden="hidden" type="reset">
							</div>
						</div>
					</form>
				</div>
			</div>		
			<div class="moduleWrapNob">
				<div class="moduleTit">查询结果</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addPersonLetter()" role="button" class="btn btn-primary"><i class="icon-plus"></i>添加</a>
						<a href="javascript:void(0)" onclick="editPersonLetter()" role="button" class="btn btn-info"><i class="icon-pencil"></i>修改</a>
						<a href="javascript:void(0)" onclick="delPersonLetter()" role="button" class="btn btn-danger"><i class="icon-trash"></i>删除</a>
						<div class="keep-open  btn-group vat" title="">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
							</a>
						</div>
						<a role="button" class="btn btn-light" href="javascript:printPersonLetter()"><i class="icon-print"></i>打印</a>
					</div>
					<div class="dataTableWrap">
						<table id="personLetterList" class="datagridClass"></table>
						<div id="jqGridPager"></div>
					</div>
				</div>
			</div>	
		</div>
	</div>
</body>		
</html>