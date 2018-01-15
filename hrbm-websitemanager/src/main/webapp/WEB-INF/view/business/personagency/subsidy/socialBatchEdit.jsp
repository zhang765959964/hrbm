<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 补贴批次</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/socialBatchEdit.js?version=20161207"></script>
</head>
<body>
<form:form modelAttribute="socialBatchForm" method="post" action="${ctx}/business/personagency/subsidy/socialBatch/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<!-- <div class="moduleWrapNob">
				<div class="moduleCont"> -->
			<form:hidden path="id" ></form:hidden>
			<form:hidden path="createrId" ></form:hidden>
		    <div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>批次名称:</label>
				<div class="col-xs-9 col-sm-4 required">
					<form:input  class="form-control" type="text"  path="batchName" ></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>批次开始时间:</label>
				<div class="col-xs-9 input-group col-sm-4">
				  	<div class="input-group row required">
                      	<form:input  class="form-control" type="text"  path="batchStartdate" ></form:input>
                      	<span class="input-group-addon">
                          	<i class="icon-calendar bigger-110"></i>
                      	</span>
              		</div>
                 </div>					

          	</div>
            <div class="row">       									
				<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>批次结束时间:</label>
				<div class="col-xs-9 input-group col-sm-4">
				  	<div class="input-group row required">
                      	<form:input  class="form-control" type="text"  path="batchEnddate" ></form:input>
                      	<span class="input-group-addon">
                          	<i class="icon-calendar bigger-110"></i>
                      	</span>
              		</div>
                 </div>		
				<label class="col-xs-3 col-sm-2" for="inputError">经办人名称:</label>
				 <div class="col-xs-9 col-sm-4 ">
					<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
				</div>
			</div>
          	<div class="row">    	 
				<label class="col-xs-3 col-sm-2" for="inputError">经办时间:</label>
				  <div class="col-xs-9 input-group col-sm-4">
                  	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
                  	<span class="input-group-addon">
                      	<i class="icon-calendar bigger-110"></i>
                  	</span>
                 </div>									
					 
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构名称:</label>
					 <div class="col-xs-9 col-sm-4 ">
						<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
					</div>
		 	</div>
          	<div class="row">    		
				<label class="col-xs-3 col-sm-2" for="inputError">描述:</label>
				 <div class="col-xs-9 col-sm-10 ">
					<form:textarea  class="form-control"  path="description" cols="5" rows="11"></form:textarea>
				</div>	
			</div>			
				<!-- </div>										
				</div> -->
		</div>
	</div>
	<div class="h60">&nbsp;</div>
   	<div class="floatBtn">
   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
   	
   	</div>
	   	
</form:form> 
</body>
</html>
