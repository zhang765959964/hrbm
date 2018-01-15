<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>缴费记录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript" src="${ctx}/js/business/personagency/payment/corp/paymentCorpPersonBatchAdd.js?version=201609181817"></script>
</head>
<body>
<form id="paymentRecordForm" method="post" action="${ctx}/business/personagency/payment/paymentCorpRecord/corpBatchsave.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit">多选批量缴费</div>
				<div class="moduleCont">
				    <input type="hidden" name="personIds" value=${personIds}></input>
				    <input type="hidden" name="fkCorpRecordId" value=${fkCorpRecordId}></input>
				    <input type="hidden" name="selType" value=${selType}></input>
				    <div class="row">	 
						<label class="col-xs-3 col-sm-label" for="inputError">缴费日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
	                      	<input  class="form-control" type="text"  name="fdPaymentDate" id="fdPaymentDate"/>
	                      	<span class="input-group-addon">
	                          	<i class="icon-calendar bigger-110"></i>
	                      	</span>
	                    </div>									
						<label class="col-xs-3 col-sm-label" for="inputError">缴费方式:</label>
						<div class="col-xs-9 col-sm-input required">
							<select name="paymentType" id="paymentType">
							    <option value="0">按截至年月</option>
						    	<option value="1" selected="selected">按延长月数</option>
						    </select>
						</div>											 
						<label class="col-xs-3 col-sm-label" for="inputError">缴费截至年月或月数:</label>
						<div class="col-xs-9 col-sm-input required">
							<input  class="form-control" type="text" name="fdPaymentMonths" id="fdPaymentMonths" />
							<input  class="form-control" type="text" style="display:none" name="fdEndDate"  id="fdEndDate" />
						</div>			 
					</div>											
				</div>
			</div>
<!-- 		 	<div class="moduleWrapNobg change-bg-iframe"> -->
<!-- 				<div class="moduleTit">计算结果</div> -->
<!-- 				<div class="moduleCont">				 -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
	 	<div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
			<button type="submit" class="btn btn-primary"><i class="icon-ok"></i>确定</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="xfui.closeDialog()"><i class="icon-remove"></i>关闭</a>		
	   	</div>
	   	
	</div>
</form>			   	 
</body>	
</html>


