<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>缴费记录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script type="text/javascript">

$(function(){
	$("#personSearch").selectuser({callBack:function(personId){
		if(personId){
			$("#paymentList").load(CTX+"/business/personagency/agent/paymentList.xf?personId="+personId);
		}else{
			bootbox.alert('未查到记录');
		}
	  }})
	$("#paymentList").load(CTX+"/business/personagency/agent/paymentList.xf");
})
		
</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="row">
				 <div class="col-xs-12 pd0 tar" >
					<div class="col-xs-6 col-sm-6">
						<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">社保卡已配置</a>
						<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal">身份证未配置</a>
					</div>
					<div class="col-xs-6 col-sm-6">
						<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
						<div class="col-xs-6 col-sm-7 pr">
							<input class="form-control"  name="personSearch" id="personSearch" placeholder="请输入身份证号 姓名" type="text"/>
							<!-- 多条结果 -->
						</div>				
					</div>
				</div>
				
				</div>
				<div id="paymentList"></div>
			</div>
		</div>
</body>		
</html>