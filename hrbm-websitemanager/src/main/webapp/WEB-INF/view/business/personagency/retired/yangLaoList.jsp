<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>养老待遇申请</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/retired/yangLaoList.js?v=20170210"></script>
</head>
<body>
	<div class="main-container">
		<input type="hidden" id="personId" /> 
		<div class="container-fluid">
			<div class="row">
				<div class="tabable">
					<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
						<li class="active">
							<a data-toggle="tab" href="#perPayment" bindEvent="yangLaoPl">养老待遇批量操作</a>
						</li>
						<li>
							<a data-toggle="tab" href="#perOverdue" bindEvent="yangLao">养老待遇单项操作</a>
						</li>
					</ul>

					<div class="tab-content">
						<div id="perPayment" class="tab-pane in active">
							<div class="moduleWrapNobg">
								<div class="moduleTit">查询条件</div>
								<div class="moduleCont">
									<form id="searchForm">
										<jsp:include page="search/ylCommion.jsp"></jsp:include>
										<div class="row">
											<div class="col-sm-12 mgb20 tar pdx20">
												<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1">
													<i class="icon-search"></i>查询
												</a>
												<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)">
													<i class="icon-plus"></i>高级查询
												</a>
												<a href="javascript:resetForm('searchForm')" role="button" class="btn btn-info">
													<i class="icon-repeat"></i>重置
												</a>
											</div>
										</div>
									</form>
								</div>
							</div>
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
											<table id="yangLaoList1" class="datagridClass"></table>
											<div id="jqGridPager1"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="moduleWrapNob">
								<div class="moduleCont">
									<div id="retireedYlPl"></div>
								</div>
							</div>
						</div>

						<div id="perOverdue" class="tab-pane ">
							<div class="moduleWrapNobg">
								<div class="moduleTit">查询条件</div>
								<div class="moduleCont">
									<form id="searchYlForm">
										<jsp:include page="search/ylCommion.jsp"></jsp:include>
										<div class="row">
											<div class="col-sm-12 mgb20 tar pdx20">
												<a href="#" role="button" onclick="ylSearch()" class="btn btn-primary btn-border1">
													<i class="icon-search"></i>查询
												</a>
												<a href="javascript:void(0)" class="btn btn-success highSearch" onclick="toggleMore('highCondition',this)">
													<i class="icon-plus"></i>高级查询
												</a>
												<a href="javascript:resetForm('searchYlForm')" role="button" class="btn btn-info">
													<i class="icon-repeat"></i>重置
												</a>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="moduleWrapNob">
								<div class="moduleTit">查询结果</div>
								<div class="moduleCont">
									<div class="row">
										<div class="col-xs-12">
											<table id="yangLaoList" class="datagridClass"></table>
											<div id="jqGridPager"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="moduleWrapNob">
								<div class="moduleCont">
									<div id="retiredYl"></div>
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


