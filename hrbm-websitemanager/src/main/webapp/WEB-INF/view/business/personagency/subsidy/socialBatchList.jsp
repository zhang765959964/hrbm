<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>补贴批次管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialBatchList.js?version=2017116"></script>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="row">
				<div class="moduleWrapNob">
					<div class="moduleTit">补贴批次维护</div>
					<div class="moduleCont">
						<div class="mgy10">
							<a href="javascript:void(0)" onclick="addSocialBatch()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>添加</a>
							<a href="javascript:void(0)" onclick="editSocialBatch()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil"></i>修改</a>
							<a href="javascript:void(0)" onclick="delSocialBatch()" role="button" class="btn btn-danger" data-toggle="modal"><i class="icon-trash"></i>删除</a>
							<a href="javascript:void(0)" role="button" class="btn  btn-success"><i class="icon-edit"></i>导入</a>
							<div class="keep-open btn-group" title="Columns">
								<a href="javascript:void(0)" role="button" id="exp" class="btn btn-purple dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<i class="icon-external-link"></i>导出<i class="icon-caret-down"></i></a>
							</div>
					</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<table id="socialBatchList"  class="datagridClass"  >
								</table>
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


