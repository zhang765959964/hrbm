<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>社保补贴参数管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>

<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialParamsList.js?v=2017116"></script>
</head>
<body>
<div class="container-fluid">
		<div class="row">
			<!-- 结果列表 -->
			<div class="col-xs-12 pd0">
				<div class="moduleWrapNob">
					<div class="moduleTit">补贴参数维护</div>
					<div class="moduleCont">
						<div class="mgy10">
							<a href="javascript:addSocialParams()"  role="button" class="btn btn-primary"><i class="icon-plus align-top bigger-125"></i>添加</a>
							<a href="javascript:editSocialParams()"  role="button" class="btn btn-info" ><i class="icon-pencil align-top bigger-125"></i>修改</a>
							<a href="javascript:delSocialParams()"  role="button" class="btn btn-danger"><i class="icon-trash align-top bigger-125"></i>删除</a>
							<div class="keep-open btn-group" title="Columns">
								<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="socialParamsList"></table>
								<div id="jqGridPager"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>		
</html>


