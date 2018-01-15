<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>户口迁入迁出和户口借用调出查询</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/residence/totalResidenceSearch.js?verson=20170110"></script>
<script>
	$(function(){
		initTransferTable();
		initResidenceReturnTable();
		$("#residenceBorrowReturn").removeClass("in").removeClass("active");
		loadData();
	})
	
	function loadData(){
		$("#residenceMoveOutList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/residence/residenceMoveOut/listJson.xf'}).trigger("reloadGrid");
		$("#residenceReturnList").jqGrid("setGridParam",{datatype: "json",url:'${ctx}/business/personagency/residence/residenceReturn/listJson.xf'}).trigger("reloadGrid");
	}
</script>
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
							<input class="form-control" type="text" name="Q_aac002_SUPL" placeholder="" title="身份证号" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_aac003_SL" placeholder="" title="" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="姓名拼音码">姓名拼音码:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_aac022_SLOL" placeholder="" title="" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="" title="档案编号" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
						<div class="col-xs-9 col-sm-2">
							<xf:select  tableName="TAB_SEX" valueField="code" textField="name" name="Q_aac004_S" hasDefault="0" selectClass="form-control" valueCon="1,2"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
						<div class="col-xs-9 col-sm-2">
							<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" hasDefault="0" textField="name" name="Q_archiveType_S" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">迁入日期起:</label>
						<div class="col-xs-9 input-group col-sm-2" >
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginmoveDate" name="Q_beginmoveDate_DL" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                          </div>
						<label class="col-xs-3 col-sm-2" for="inputError">迁入日期止:</label>
						<div class="col-xs-9 input-group col-sm-2">
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endmoveDate" name="Q_endmoveDate_DG" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                           </div>
						<label class="col-xs-3 col-sm-2" for="inputError">落户地户籍部门:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_settleDepartment_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">迁移日期起:</label>
						<div class="col-xs-9 input-group col-sm-2" >
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="beginoutDate" name="Q_beginoutDate_DL" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                          </div>
						<label class="col-xs-3 col-sm-2" for="inputError">迁移日期止:</label>
						<div class="col-xs-9 input-group col-sm-2">
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endoutDate" name="Q_endoutDate_DG" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                           </div>
						<label class="col-xs-3 col-sm-2" for="inputError">迁往地址:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_moveToAddress_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">户口状态:</label>
						<div class="col-xs-9 col-sm-2">
							<xf:select  tableName="RSDA_TAB_RESIDENCE_STATUS" valueField="code" textField="name" name="Q_residenceStatus_S"  hasDefault="0" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-2">
							<input class="form-control" type="text" name="Q_createrOrgName_SL" data-placement="bottom"/>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
						<div class="col-xs-9 input-group col-sm-2" >
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="begincreaterDate" name="Q_begincreaterDate_DL" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                          </div>
						<label class="col-xs-3 col-sm-2" for="inputError">经办日期止:</label>
						<div class="col-xs-9 input-group col-sm-2">
                             <input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" id="endcreaterDate" name="Q_endcreaterDate_DG" type="text" placeholder="请选择日期"/>
                             <span class="input-group-addon">
                                 <i class="icon-calendar bigger-110"></i>
                             </span>
                           </div>
					</div>
					<div class="row">
						<div class="col-sm-12 mgb20 tar pdx20">
							<a href="javascript:void(0)" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
							<a href="javascript:void(0)" class="btn btn-info"   role="button" onclick="$('#reset').click()"><i class="icon-repeat"></i>重置</a>
							<input id="reset" class="dn" type="reset">
						</div>
					</div>
				</form>
			</div>
		</div>		
		<!-- tab选项卡 -->
		<div class="tabable">
			<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
				<li class="active"><a data-toggle="tab" href="#residenceMoveOut">户口迁入迁移信息</a></li>
				<li><a data-toggle="tab" href="#residenceBorrowReturn">户口借用归还信息</a></li>
			</ul>
			<div class="tab-content">
				<div id="residenceMoveOut" class="tab-pane in active">
					<div class="moduleWrapNob">
						<div class="moduleCont">
							<div class="mgy10">
								<div class="keep-open  btn-group vat" title="">
									<a href="javascript:void(0)" role="button" id="expMoveOut" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
										<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
									</a>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<table id="residenceMoveOutList"  class="datagridClass"></table>
									<div id="jqGridPager2"></div>
								</div>
							</div>
						</div>
					</div>
					<div id="searchTotal">集体户口总数：<span style="color: blue"> ${tatalCount } </span>  ；迁入户口总数： <span style="color: blue">${moveCount }</span>；
							迁移户口总数：<span style="color: blue">${ontCount }</span></div>
				</div>
				<div id="residenceBorrowReturn" class="tab-pane in active">
					<div class="moduleWrapNob">
						<div class="moduleCont">
							<div class="mgy10">
								<div class="keep-open  btn-group vat" title="">
									<a href="javascript:void(0)" role="button" id="expReturn" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
										<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
									</a>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<table id="residenceReturnList"  class="datagridClass"></table>
									<div id="jqGridPager3"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>		
</html>