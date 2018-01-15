<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>死亡待遇申报管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/death/deathDeclareList.js?v=20170211231"></script>
</head>
<body>
			<div class="container-fluid">
				<div class="row">
			    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">身份号码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" id="personCard" name="Q_personCard_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_personName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">离退休或退职:</label>
								<div class="col-xs-9 col-sm-2">
									<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_TX_TZ" name="txTzId"   valueField="code" hasDefault="0"></xf:select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" id="archiveCode" name="Q_archiveCode_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_deathNo_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">姓名拼音码:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_pinyin_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">死亡日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                           	    <input class="form-control" type="text" id="begindeathDate" name="Q_begindeathDate_DL" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                     </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">死亡日期止:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                           	    <input class="form-control" type="text" id="enddeathDate" name="Q_enddeathDate_DL" data-placement="bottom" />
		                              	<span class="input-group-addon">
		                                  	<i class="icon-calendar bigger-110"></i>
		                              	</span>
			                     </div>		
								<label class="col-xs-3 col-sm-2" for="inputError">工伤死或病死:</label>
								<div class="col-xs-9 col-sm-2">
									<xf:select textField="name" selectClass="form-control" tableName="RSDA_TAB_GS_BS" name="gsBsId"   valueField="code" hasDefault="0"></xf:select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
		                           	  	<input class="form-control" type="text" id="begincreaterDate" name="Q_begincreaterDate_DL" data-placement="bottom" />
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
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)"  onclick="searchCardOrCode()"  class="btn btn-success highSearch" ><i class="icon-plus"></i>加入列表</a>
								<a href="#modal-form" role="button"  onclick="resetForm('searchForm')"  class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			
				<div class="moduleWrapNob">
					<div class="moduleTit"><span class="fl">死亡待遇审定信息</span>
						<span class="fr mgr15">
							<a role="button" class="btn btn-success" onclick="printDeathList()"><i class="icon-barcode"></i>打印死亡人员名册</a>
						</span>
					</div>
				<div class="moduleCont">
					<div class="row">
						<div class="mgy10">
							<div class="keep-open btn-group" title="Columns">
								<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
								</a>
							</div>
						</div>
						<div class="col-xs-12">
								<table id="deathDeclareList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
			
			
			
			<div class="moduleWrapNob">
				<div class="moduleTit">供养直系亲属信息</div>
				<div class="moduleCont">
					<div class="row">
						<div class="mgy10">
							<div class="keep-open btn-group" title="Columns">
								<a href="javascript:void(0)" role="button" id="exp1" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
									<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i>
								</a>
							</div>
						</div>
						<div class="col-xs-12">
								<table id="deathPersonList"  class="datagridClass"  ></table>
								<div id="jqGridPager1"></div>
						</div>
					</div>
				</div>
			</div>
	</div>
</div>
	
</body>
</html>


