<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">RSDA_BS_DEMO</div>
				<div class="moduleCont">
					<form:form modelAttribute="demotestForm" method="post" action="${ctx}/business/personagency/demo/demotest/save.xf">
					<form:hidden path="id" ></form:hidden>
					    <div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">NAME:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input  class="form-control" type="text"  path="name" ></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">ADDRESS:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input  class="form-control" type="text"  path="address" ></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">PHONE:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input  class="form-control" type="text"  path="phone" ></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">SEX:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input  class="form-control" type="text"  path="sex" ></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">AGE:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input  class="form-control" type="text"  path="age" ></form:input>
							</div>
					    </div>
	        		</form:form>
				</div>
			</div>
		</div>

		<div class="bottomBtn">
	   		<div class="h50">&nbsp;</div>
	   		<div class="floatBtn">
		   		<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="submitForm()">保存</a>
		   		<a href="javascript:void(0)" role="button" class="btn btn-success" data-toggle="modal">登记新户</a>
		   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()">关闭</a>
	   		</div>
	   	</div>
	</div>


