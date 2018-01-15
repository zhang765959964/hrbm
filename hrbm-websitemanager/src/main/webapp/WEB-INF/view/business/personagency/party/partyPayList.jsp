<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>党费交纳管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>

<script type="text/javascript" src="${ctx}/js/business/personagency/party/partyPayList.js"></script>

</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="row">
			    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">身份证号码:</label>
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
										<option value="2">女</option>
									</select>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">交纳开始年月:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="partyBeginDate" name="Q_partyBeginDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">交费截止年月:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="partyEndDate" name="Q_partyEndDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">代管组织关系:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="partyStatus" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="Q_createrName_SL" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">经办日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="begincreaterDate" name="Q_begincreaterDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">到:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="endcreaterDate" name="Q_endcreaterDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="createrOrgName" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">转入日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="beginpartyIntoDate" name="Q_beginpartyIntoDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">到:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="endpartyIntoDate" name="Q_endpartyIntoDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">转出原因:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="partyOutReason" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">转出日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="beginpartyOutDate" name="Q_beginpartyOutDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">到:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="endpartyOutDate" name="Q_endpartyOutDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">入党日期起:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="beginpartyDate" name="Q_beginpartyDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
								<label class="col-xs-3 col-sm-2" for="inputError">到:</label>
								<div class="col-xs-9 input-group col-sm-2">
			                              	<input class="form-control" type="text" id="endpartyDate" name="Q_endpartyDate_DL" data-placement="bottom" />
			                              	<span class="input-group-addon">
			                                  	<i class="icon-calendar bigger-110"></i>
			                              	</span>
			                    </div>	
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-search"></i>查询</a>
								<a href="#modal-form" role="button"  onclick="resetForm('searchForm')"  class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
				<div class="moduleWrapNob">
				<div class="moduleTit">党费交纳列表</div>
				<div class="moduleCont">
					<div class="mgy10">
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="partyPayList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
				</div>	
				<span>交费人数:<span id="sumCount"></span></span>&nbsp;&nbsp;<span>交费金额:<span id="payMoney"></span></span>
				</div>
			</div>
		</div>
</body>		
</html>


