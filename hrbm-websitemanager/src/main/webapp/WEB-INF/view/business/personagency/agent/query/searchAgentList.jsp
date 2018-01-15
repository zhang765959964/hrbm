<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>代理详细查询</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<script type="text/javascript" src="${ctx}/js/business/personagency/agent/query/searchAgentList.js?version=20170213"></script>
	<input type="hidden" value="${personId}" id="personIds" />
<!-- <div class=""> -->
	<div class="tabable tabMore row">
		<ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
			<li class="active"><a data-toggle="tab" href="#cdEdu" bindEvent="archiveInitl" title="存档信息">存档信息</a></li>
			<li><a data-toggle="tab" href="#archiveYjEdu" bindEvent="archiveJyInitl" title="档案借阅信息">档案借阅信息</a></li>
			<li><a data-toggle="tab" href="#commissionEdu" bindEvent="commissionInitl" title="委托类型变更信息">委托类型变更信息</a></li>
			<li><a data-toggle="tab" href="#paymentEdu" bindEvent="paymentInitl" title="费用信息">费用信息</a></li>
			<li><a data-toggle="tab" href="#wageEdu" bindEvent="wageInitl" title="工资标准调整信息">工资标准调整信息</a></li>
			<li><a data-toggle="tab" href="#zcpdEdu" bindEvent="zcpdInitl" title="职称评定信息">职称评定信息</a></li>
			<li><a data-toggle="tab" href="#ksbmEdu" bindEvent="ksbmInitl" title="考试报名信息">考试报名信息</a></li>
			<li><a data-toggle="tab" href="#hkclEdu" bindEvent="hkclInitl" title="户口材料信息">户口材料信息</a></li>
			<li><a data-toggle="tab" href="#hkxxEdu" bindEvent="hkxxInitl" title="户口信息">户口信息</a></li>
			<li><a data-toggle="tab" href="#partyEdu" bindEvent="partyInitl" title="党组织关系信息">党组织关系信息</a></li>
			<li><a data-toggle="tab" href="#retiredEdu" bindEvent="retiredInitl" title="退休相关信息">退休相关信息</a></li>
			<li><a data-toggle="tab" href="#deathEdu" bindEvent="deathInitl" title="死亡待遇信息">死亡待遇信息</a></li>
		</ul>
		<div class="tab-content">
			<div id="cdEdu" class="tab-pane in active">
				<jsp:include page="archives.jsp"></jsp:include>	
			</div>
			<div id="archiveYjEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">档案借阅信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
									<table id="archiveJyList" class="datagridClass" ></table>
									<div id="jqGridPager2"></div>
								</div>
						</div>
					</div>
				</div>
			</div>
			<div id="commissionEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">委托类型变更信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="commissionList" class="datagridClass" ></table>
										<div id="jqGridPager3"></div>
								</div>
						</div>
					</div>
				</div>
				
			</div>
			<div id="paymentEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">费用信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="paymentList" class="datagridClass"></table>
										<div id="jqGridPager4"></div>
								</div>
						</div>
					</div>
				</div>			
			</div>
			<div id="wageEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">工资标准调准信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="wageList" class="datagridClass"></table>
										<div id="jqGridPager5"></div>
								</div>
						</div>
					</div>
				</div>		
			</div>
			
			<div id="zcpdEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">职称评定信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="zcpdList" class="datagridClass"></table>
										<div id="zcpdPager"></div>
								</div>
						</div>
					</div>
				</div>		
			</div>
			<div id="ksbmEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">考试报名信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="ksbmList" class="datagridClass"></table>
										<div id="jqGridPager6"></div>
								</div>
						</div>
					</div>
				</div>		
			</div>
			<div id="hkclEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">户口材料信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="hkclList" class="datagridClass"></table>
										<div id="jqGridPager7"></div>
								</div>
						</div>
					</div>
				</div>		
			</div>
			<div id="hkxxEdu" class="tab-pane " >
				<div class="moduleWrapNob">
					<div class="moduleTit">户口迁入迁出信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="residenceMoveOutList" class="datagridClass"></table>
										<div id="jqGridPager8"></div>
								</div>
						</div>
					</div>
				</div>		
				<div class="moduleWrapNob">
					<div class="moduleTit">户口借用归还信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="residenceReturnList" class="datagridClass"></table>
										<div id="jqGridPager82"></div>
								</div>
						</div>
					</div>
				</div>		
				
				
			</div>
			<div id="partyEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">党组织关系转入转出信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="partyList" class="datagridClass" ></table>
										<div id="jqGridPager9"></div>
								</div>
						</div>
					</div>
				</div>
				<div class="moduleWrapNob">
					<div class="moduleTit">党费交纳信息</div>
					<div class="moduleCont">
						<div class="row">
							<div class="col-xs-12">
								<table id="partyPayList"  class="datagridClass"  ></table>
								<div id="jqGridPager91"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="retiredEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">退休相关信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="retiredList" class="datagridClass" ></table>
										<div id="jqGridPager10"></div>
								</div>
						</div>
					</div>
				</div>
			</div>
			<div id="deathEdu" class="tab-pane ">
				<div class="moduleWrapNob">
					<div class="moduleTit">死亡待遇审定信息</div>
					<div class="moduleCont">
						<div class="row">
								<div class="col-xs-12">
										<table id="deathList" class="datagridClass" ></table>
										<div id="jqGridPager11"></div>
								</div>
						</div>
					</div>
				</div>
				<div class="moduleWrapNob">
					<div class="moduleTit">供养直系亲属信息</div>
					<div class="moduleCont">
						<div class="row">
							<div class="col-xs-12">
								<table id="deathPersonList"  class="datagridClass"  ></table>
								<div id="jqGridPager111"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>		
<!-- </div> -->



</body>
</html>


