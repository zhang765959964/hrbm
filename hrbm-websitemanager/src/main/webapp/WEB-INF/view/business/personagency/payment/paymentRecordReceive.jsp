<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<%@include file="/commons/include/commonInc.jsp" %>
   	 <script type="text/javascript" src="${ctx}/js/business/personagency/payment/paymentRecordReceive.js?version=2016091818173"></script>
   	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	
	<style>
		#corpList1{height:300px;overflow: hidden;}
	</style>
</head>
<body>
	<div class="container-fluid">
	<div class="row">
		<div class="mgy10">
			<a href="javascript:refresh()" role="button" class="btn btn-yellow"><i class="icon-refresh"></i>刷新</a>			
<!-- 			<a href="#modal-form1" onclick="" role="button" class="btn btn-info" >统计人数和金额</a> -->

		</div>
	</div>
		<div class="row">
			<div class="col-sm-5 pd0 moduleWrapNobg">
<!-- 				<div class="moduleTit">未缴费记录</div> -->
				<div class="moduleTit dbToggle"><span class="fl">未缴费记录</span><span class="mBtn fr mgr15" style="color: black;"><select id="fitlerSel" ><option value="0" selected="selected">当天</option> <option  value="1">全部</option></select></span></div>
				
				<!-- 查询条件 -->
				<hr/>

				<!-- 结果列表1 -->
				<div class="moduleCont resultWrap">
					<table id="paymentRecordList"  class="datagridClass"  ></table>
					<div id="jqGridPager"></div>
				</div>
			</div>
			<div class="col-sm-7 colRight">
				<!-- 查询条件 -->
				<div class="moduleWrapNobg">
					<div class="moduleTit">当天已缴费记录</div>
					
					<hr/>
					<!-- 结果列表2 带检索条件 -->
					<div class="moduleCont resultWrap">													
								<table id="paymentRecordList1"  class="datagridClass"  ></table>
								<div id="jqGridPager1"></div>						
					</div>
				</div>
			</div>
		</div><!-- row end -->
<!-- 	<div class="row"> -->
<!-- 		<div class="moduleWrapNobg"> -->
<!-- 			<div class="moduleTit">统计结果</div>					 -->
<!-- 			<hr/> -->
<!-- 		</div> -->
<!-- 	</div> -->
	</div>

</body>
</html>
