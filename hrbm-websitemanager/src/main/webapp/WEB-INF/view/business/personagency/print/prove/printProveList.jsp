<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<title>RSDA_BS_PRINT_MODEL管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<script>

$(function(){

	xfui.initUi();
})
	function preview(){
		if($("#pkId").val()){
			xfui.open_dialog({    
	  		    title: '打印预览',    
	  		    width: 900,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/personagency/print/printProveTemplate/preview.xf?pkId="+$("#pkId").val(),
	  		    modal: true   
	  		})
		}else{
			bootbox.alert("请选择模版");
		}
		
	}
</script>
</head>
			    <div class="moduleWrapNobg">
				<div class="moduleTit">个人基本信息</div>
				<div class="moduleCont">
					<form:form modelAttribute="archivesPersonForm" method="post" action="">
					   <input type="hidden" id="personId"  value="${personId}"/>
						<div class="row">

							<label class="col-xs-12 col-sm-2" for="inputError">身份证号码:</label>
							<div class="col-xs-12 col-sm-2">
								 <form:input  class="form-control" type="text"  path="AAC002" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="AAC003" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">联系电话:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">出生日期:</label>
							<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                             	  <form:input  class="form-control" type="text"  path="AAC006" readonly="true"></form:input>
	                              <span class="input-group-addon">
	                                  <i class="icon-calendar bigger-110"></i>
	                              </span>
                           </div>
							<label class="col-xs-12 col-sm-2" for="inputError">档案出生日期:</label>
							<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                              <form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                              <span class="input-group-addon">
                                  <i class="icon-calendar bigger-110"></i>
                              </span>
                           </div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">档案编号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">档案姓名:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">档案接收人:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveReceiveName" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">档案转入日期:</label>
							<div class="col-xs-12 input-group col-sm-2"  style="padding-left:15px">
                             	 <form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                             	 <span class="input-group-addon">
                                  	<i class="icon-calendar bigger-110"></i>
                              	</span>
                           </div>

							<label class="col-xs-12 col-sm-2" for="inputError">档案状态:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">手机号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="AAE005" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-12 col-sm-2" for="inputError">存档类型:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
							</div>

							<label class="col-xs-12 col-sm-2" for="inputError">所属单位名称:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
							</div>
							<label class="col-xs-12 col-sm-2" for="inputError">合同编号:</label>
							<div class="col-xs-12 col-sm-2">
								<form:input  class="form-control" type="text"  path="contractCode" readonly="true"></form:input>
							</div>
						</div>
					</form:form>
				</div>
			</div>	




