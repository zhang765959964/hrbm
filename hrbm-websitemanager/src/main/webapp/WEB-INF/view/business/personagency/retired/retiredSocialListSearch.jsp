<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>退休转社会化查询</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/retiredSocialListSearch.js?v=2017010611"></script>
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
							<label class="col-xs-3 col-sm-2" >性别:</label>
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
								<input class="form-control" type="text" value="是" readonly="true" data-placement="bottom" />
								<input class="form-control" type="hidden"  id="retiredStatus" name="retiredStatus" value="1" data-placement="bottom" />
							</div>
						</div>

						<div class="row highCondition dnn">				
							<label class="col-xs-3 col-sm-2" for="inputError">应退休时间起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="beginretiredDate" name="beginretiredDate" data-placement="bottom" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							
							
							<label class="col-xs-3 col-sm-2" for="inputError">应退休时间止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="endretiredDate" name="endretiredDate" data-placement="bottom" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">个人拼音码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_pinyin_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转社会化协议日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="beginretiredSocialDate" name="beginretiredSocialDate" data-placement="bottom" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转社会化协议日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="endretiredSocialDate" name="endretiredSocialDate" data-placement="bottom" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转社会化协议编号:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_retiredSocialNo_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转社会化经办日期起:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="begincreaterDate" name="beginSocialCreaterDate" data-placement="bottom" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转社会化经办日期止:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<input class="form-control" type="text" id="endcreaterDate" name="endSocialCreaterDate" data-placement="bottom" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">对方经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_retiredSocialName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转社会化经办人:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_socialCreaterName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">转社会化经办机构:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_socailCreaterOrgName_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否转社会化:</label>
							<div class="col-xs-9 col-sm-2">
								<select name="isRetiredSocial" class="form-control">
									<option value="">--请选择--</option>
									<option value="0">否</option>
									<option  value="1" selected="selected">是</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休人员所属区域:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_retiredArea_SL" data-placement="bottom" />
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">退休个人编码:</label>
							<div class="col-xs-9 col-sm-2">
								<input class="form-control" type="text" name="Q_retiredPeopleBm_SL" data-placement="bottom" />
							</div>
						</div>
						
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#retiredSocialList" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)"><i class="icon-plus"></i>高级查询</a>
								<a href="#modal-form" role="button"  onclick="clearForm()"  class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
				<div class="moduleWrapNob">
				<div class="moduleTit">退休登记信息</div>
				<div class="moduleCont">
					 <div class="mgy10">
						<div class="keep-open btn-group" title="Columns">
							<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
							<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="retiredSocialList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
		</div>
	</div>
			
</body>		
</html>


