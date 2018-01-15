<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>特殊类档案转出</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
<form:form modelAttribute="specialArchivesForm" method="post" action="${ctx}/business/personagency/storage/specialArchives/save.xf">
	<div class="container-fluid">
		<div class="row">
			<div class="moduleCont">
					 <form:hidden path="id" ></form:hidden>
					 <form:hidden path="lrCreaterId" ></form:hidden>
					 <form:hidden path="lrCreaterOrgId" ></form:hidden>
					 <form:hidden path="cczy06" ></form:hidden>
					 <form:hidden path="ccpr08" ></form:hidden>
					 <form:hidden path="printNumber" ></form:hidden>
					 <form:hidden path="aac004" ></form:hidden>
					 <form:hidden path="specialType" ></form:hidden>
					    <div class="row">
					    	<label class="col-xs-3 col-sm-label" for="inputError">编号:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="specialNumber" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">特殊档案类别:</label>
							<div class="col-xs-9 col-sm-input">
								<input value='<xf:out textField="name" tableName="RSDA_TAB_SPECIAL_TYPE" valueField="code" value="${specialArchivesForm.specialType}"></xf:out>' 
									class="form-control" style="padding-left:5px;" readonly="readonly">
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">特殊档案情况:</label>
							<div class="col-xs-9 col-sm-input">
								<form:select  class="form-control" type="text" path="specialStatus" disabled="true">
									<form:option value="0" label="入档"/>入档
									<form:option value="1" label="已转出"/>已转出
								</form:select>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">身份证号:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">性别:</label>
							<div class="col-xs-9 col-sm-input">
								<input value='<xf:out textField="name" tableName="TAB_SEX" valueField="code" value="${specialArchivesForm.aac004}"></xf:out>' 
									class="form-control" style="padding-left:5px;" readonly="readonly">		
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">学校名称:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="schoolName" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">班级:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="schoolClass" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">专业:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="major" readonly="true"></form:input>
							</div>	 
						</div>	
						<div class="row">	
							<label class="col-xs-3 col-sm-label" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-two-col">
								<form:input  class="form-control" type="text"  path="corpName" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">退伍编号:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="veteransNumber" readonly="true"></form:input>
							</div>
						</div>	
						
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="备注">备注:</label>
							<div class="col-xs-9 col-sm-three-col">
								<form:textarea  type="text"  path="description" row="5" col="5" readonly="true"></form:textarea>
							</div>
						</div>
						<div class="row">		
							<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-input">
                             	<form:input  class="form-control" type="text"  path="lrCreaterDate" readonly="true"></form:input>
                             	<span class="input-group-addon">
                                 	<i class="icon-calendar bigger-110"></i>
                             	</span>
	                        </div>	
							<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="lrCreaterOrgName" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="lrCreaterName" readonly="true"></form:input>
							</div>
					    </div>	
					    <hr/>
					    <div class="row">
						    <label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>转出办理人:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input  class="form-control" type="text"  path="zcName"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>转出办理人电话:</label>
							<div class="col-xs-9 col-sm-input required">
								<form:input  class="form-control" type="text"  path="zcPhone"></form:input>
							</div>
							<label class="col-xs-3 col-sm-label" for="inputError">转出去向:</label>
							<div class="col-xs-9 col-sm-input">
								<form:input  class="form-control" type="text"  path="zcWhere"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-label" for="inputError" title="转出原因">转出原因:</label>
							<div class="col-xs-9 col-sm-three-col">
								<form:textarea  type="text"  path="zcReason" row="5" col="5"></form:textarea>
							</div>
						</div>								
				</div>
		</div>
	 <div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>转出</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-success"  onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</form:form>
<script type="text/javascript">
	 $(function(){
		  initFormSubimt();
	 })
     function initFormSubimt(){
         $('#specialArchivesForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
	                //转出办理人
	                zcName : {
	                       validators: {
	                           notEmpty: {
	                        	   
	                           },stringLength: {
			                        min: 2,
			                        max: 10
			                    }
	                       }
	                }, //转出办理电话
	                zcPhone : {
	                       validators: {
	                           notEmpty: {
	                        	   message:'办理电话不允许为空'
	                           },
	                            stringLength: { max: 15 },
		   	               		regexp: {
		   	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
		   	              			message: '电话号码或手机号码格式不正确'
		   	               		}
	                       }
	                }, //转出去向
	                zcWhere : {
	                       validators: {
	                           stringLength: {
			                        min: 0,
			                        max: 50
			                    }
	                       }
	                }, //转出原因
	                zcReason : {
	                       validators: {
	                           stringLength: {
			                        min: 0,
			                        max: 100
			                    }
	                       }
	                }
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    bv.disableSubmitButtons(true);
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: data.message, 
                            callback: function(){ 
                            	bv.disableSubmitButtons(false);
                            	var parentIframe=xfui.getParentIframe();
            			    	if(parentIframe){
            			    		parentIframe.refresh();
            			    	}
                            	closeItem(); 
                            }
                        })
                    }, 'json');
                });
       }
	 
	  function closeItem(){
		  xfui.closeDialog();
	  }
	  function submitForm(){
		  $('#specialArchivesForm').submit();
	  }
</script>
</body>
</html>