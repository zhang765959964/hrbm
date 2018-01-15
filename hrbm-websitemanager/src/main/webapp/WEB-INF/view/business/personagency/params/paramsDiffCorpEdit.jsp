<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑 困难企业</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/params/paramsDiffCorpEdit.js?v=20161226"></script>
</head>
<body>
	<form:form modelAttribute="paramsDiffCorpForm" method="post" action="${ctx}/business/personagency/params/paramsDiffCorp/save.xf">
		<div class="container-fluid">
			<div class="row pd-none-wrap">
				<div class="moduleWrapNob change-bg-iframe">
					<div class="moduleCont">
	
						<form:hidden path="pkId"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="困难企业名称"><em>*</em>困难企业名称:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdCorpName"></form:input>
							</div>

							<label class="col-xs-3 col-sm-label" for="inputError" title="困难企业代码"><em>*</em>困难企业代码:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input class="form-control" type="text" path="fdCorpCode"></form:input>
							</div>
						</div>
						<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError"  title="所属区域">所属区域:</label>
								 <div class="col-xs-9 col-sm-three-col ">
									<form:input class="form-control" type="text" path="fdCorpAddre"></form:input>
								</div>
						</div>
						<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError" title="详细信息" >详细信息:</label>
								 <div class="col-xs-9 col-sm-three-col ">
									<form:textarea row="5" col="5"  path="fdCorpDetail"></form:textarea>
								</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="备注" >备注:</label>
								 <div class="col-xs-9 col-sm-three-col ">
									<form:textarea  row="5" col="5"   type="text"  path="fdCorpNote" ></form:textarea>
							</div>
						</div>											
					</div>
				</div>
			</div>
			<div class="h60">&nbsp;</div>
			<div class="floatBtn">
				<button type="submit" class="btn btn-primary">
					<i class="icon-save"></i>保存
				</button>
				<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="closeItem()">
					<i class="icon-remove"></i>关闭
				</a>

			</div>

		</div>
	</form:form>
</body>
</html>
