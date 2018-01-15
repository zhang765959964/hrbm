<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpRecordList.js?version=201609181843"></script>

	<div class="moduleWrapNobg">
		<div class="moduleTit">基本信息</div>
		<div class="moduleCont">
			<form:form modelAttribute="corpForm" >
			    <form:hidden path="aab001" ></form:hidden>
			    <input type="hidden" id="fdPaymentType" value=${fdPaymentType} ></input>
			      
				<div class="row">

					<label class="col-xs-12 col-sm-2" for="inputError">单位名称:</label>
					<div class="col-xs-12 col-sm-6">
						 <form:input  class="form-control" type="text"  path="aab004" readonly="true"></form:input>
					</div>

					<label class="col-xs-12 col-sm-2" for="inputError">工商登记执照号码:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="aab007" readonly="true"></form:input>
					</div>

					<label class="col-xs-12 col-sm-2" for="inputError">单位协议编号:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaNo" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">单位协议签订日期:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaCreatetime" readonly="true"></form:input>
					</div>

					<label class="col-xs-12 col-sm-2" for="inputError">单位联系人:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaName" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">联系人电话:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaPhone" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">传真:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="bab002" readonly="true"></form:input>
					</div>
					<label class="col-xs-12 col-sm-2" for="inputError">经办人身份证号:</label>
					<div class="col-xs-12 col-sm-2">
						<form:input  class="form-control" type="text"  path="uaCard" readonly="true"></form:input>
					</div>
				</div>
			</form:form>
		</div>
	</div>

	<div class="moduleWrapNob">
		<div class="moduleTit">缴费记录</div>
		<div class="moduleCont">
			<div class="mgy10">
				<a href="javascript:void(0)" id="addPaymentCorpRecord" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
<!-- 				<a href="javascript:void(0)" id="savePaymentCorpRecord" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>保存</a> -->
				<a href="javascript:void(0)"  id="delPaymentCorpRecord" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>删除</a>
				<c:if test="${type==1}">
				<a href="javascript:void(0)"  id="viewCorpPersonList" role="button" class="btn btn-info" ><i class="icon-search"></i>查看缴费明细</a>
				</c:if>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<table id="paymentCorpRecordList"  class="datagridClass"  ></table>
					<div id="jqGridPager"></div>
				</div>
			</div>
		</div>
	</div>				
			<c:if test="${type==0}">
			  	<div class="row mg0">
					<div class="col-sm-5 pd0 moduleWrapNobg">
						<div class="moduleTit">存档信息</div>
						<div class="moduleCont resultWrap h335">
						   
							<div class="row">
								<div class="col-xs-12">
									<table id="paymentRecordList1"  class="datagridClass"  ></table>
									<div id="jqGridPager1"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-7 colRight">
						<div class="moduleWrapNobg">
							<div class="moduleTit">单位存档人员费用记录</div>
							<div class="moduleCont resultWrap h335">
							    <div class="mgy10">								
										<a href="javascript:void(0)" id="addPaymentRecord" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>增加</a>
										<a href="javascript:void(0)"  id="delPaymentRecord" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>删除</a>									
								</div>
								<div class="row">
									<div class="col-xs-12">					
										<table id="paymentRecordList2"  class="datagridClass"  ></table>
										<div id="jqGridPager2"></div>
									</div>
								</div>						
							</div>
						</div>
					</div>
				</div><!-- row end -->
			</c:if>
         
			<c:if test="${type==1}">
			    <div class="tabable">
				    <ul class="nav nav-tabs padding-12 tab-color-blue background-blue">
						<li class="active"><a data-toggle="tab"   href="#allperson">全部存档人员</a></li>
						<li><a data-toggle="tab"  href="#selperson">筛选存档人员</a></li>
					</ul>
					<div class="tab-content">
						   <div id="allperson" class="tab-pane in active">
						        	<div class="mgy10">				
												<a href="javascript:void(0)" id="allAddPaymentRecord" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>全选批量缴费</a>
												<a href="javascript:void(0)"  id="mutiAddPaymentRecord" role="button" class="btn btn-yellow" ><i class="icon-list-ol"></i>多选批量缴费</a>					
									</div>
										<div class="row">
											<!-- <div class="resultWrap"> -->
											
											<div class="col-xs-12">
												<table id="paymentRecordList1"  class="datagridClass"  ></table>
												<div id="jqGridPager1"></div>
											</div>
										</div><!-- row end -->	
						   </div>
						     <div id="selperson" class="tab-pane">
						       <form id="searchForm">
						          <div class="row">
												<!-- 单条查询 -->
												<div class="col-xs-12 pd0 tar">
													
														<label class="col-xs-12 col-sm-2" for="inputError">公民身份号码:</label>
														<div class="col-xs-12 col-sm-2">
															<input class="form-control" type="text"  name="Q_aac002_SUPL" placeholder="公民身份号码" >
														</div>
														<label class="col-xs-12 col-sm-2" for="inputError">档案编号:</label>
														<div class="col-xs-12 col-sm-2">
															<input class="form-control" type="text" name="Q_archiveCode_SL" placeholder="请输入档案编号" >
														</div>
														<div class="fl">
														<a href="javascript:addSearchData()" class="btn btn-primary"><i class="icon-plus-sign"></i>加入查询</a>
														<a href="javascript:resetForm('searchForm')" class="btn btn-info "><i class="icon-repeat"></i>重置</a>
														<a href="javascript:delRowData()" class="btn btn-success"><i class="icon-minus-sign"></i>单条去除</a>
														<a href="javascript:clearGridData()" class="btn btn-danger"><i class="icon-trash"></i>清空列表</a>
														</div>
													
													
												</div>
									</div>
									</form>
						           <div class="mgy10">				
												<a href="javascript:mutiAddPaymentRecord('selpersonList')"   role="button" class="btn btn-primary" ><i class="icon-plus align-top"></i>多选批量缴费</a>					
									</div>
										<div class="row">
											<!-- <div class="resultWrap"> -->
											
											<div class="col-xs-12">
												<table id="selpersonList"  class="datagridClass"  ></table>
												<div id="jqGridPager2"></div>
											</div>
										</div><!-- row end -->	
						   </div>
					</div>
				</div>
</c:if>