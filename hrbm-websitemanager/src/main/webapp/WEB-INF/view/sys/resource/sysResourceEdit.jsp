<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>编辑资源信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="/commons/include/commonInc.jsp" %>
	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css" type="text/css">
	<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
	<script type="text/javascript">
	 $(function(){
		 initFormSubimt();
		 var parName='${parName}';
		 if(parName) {
			 $("#select_read").attr("disabled","true");
			 $("#funplat_id").attr("name",'funplat');
		 }else{
			 parName="根目录";
			 $("#par_id").html(parName);
		 }
		 if('${isEdit}'){
			 $("#select_read").attr("disabled","true");
			 $("#funplat_id").attr("name",'funplat');
		 }
	 })
	 
	 function initFormSubimt(){
	        $('#sysResourceForm').bootstrapValidator({
	            message: 'This value is not valid',
	            feedbackIcons: {
	                valid: 'glyphicon glyphicon-ok',
	                invalid: 'glyphicon glyphicon-remove',
	                validating: 'glyphicon glyphicon-refresh'
	            },
	              fields: {
	            	  funname: {
	                      validators: {
	                          notEmpty: {
	                        	  message:"资源名称不能为空"
	                          },
	                          stringLength: {
	                              min: 2,
	                              max: 20
	                          }
	                      }
	                  },
	                  funmapping: {
	                      validators: {
	                          stringLength: {
	                              min: 0,
	                              max: 300
	                          }
	                      }
	                  },
	                  fundemo: {
	                      validators: {
	                          stringLength: {
	                              min: 0,
	                              max: 100
	                          }
	                      }
	                  },
	                  funmenu: {
	                      validators: {
	                          stringLength: {
	                              min: 0,
	                              max: 30
	                          }
	                      }
	                  }
	              }
	          }).on('success.form.bv', function(e) {
	        	       $("#aae020_id").val($("#aae017_select  option:selected").text());
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
	</script>
</head>
<body>
	  <form:form modelAttribute="sysResourceForm" method="post" action="${ctx}/sys/resource/sysResource/save.xf">
  <div class="modal-body overflow-visible reportWrap">
      <div class="row" >
       <form:hidden path="funid" ></form:hidden>
       <form:hidden path="funpid" ></form:hidden>
                    <div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">父级名称：</label>
						<div class="col-xs-10">
							 <span id="par_id">${parName}</span>
							</div>
					</div>
       				<div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">所属平台：</label>
						<div class="col-xs-10">
							 <xf:select id="select_read" name="funplat" textField="name" value="${sysResourceForm.funplat}" tableName="TAB_DATASOURCES" valueField="code" isNoStyle="true"></xf:select>
							 <input id="funplat_id" type="hidden" value="${sysResourceForm.funplat}">
							</div>
					</div>
					<div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">资源名称：</label>
						<div class="col-xs-10">
							 <form:input   class="form-control" type="text"  path="funname"  data-options="required:false"></form:input>
							</div>
					</div>
					<div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">资源路径：</label>
						<div class="col-xs-10">
							 <form:input   class="form-control" type="text"  path="funmapping"  data-options="required:false"></form:input>
							</div>
					</div>
					<div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">图标样式：</label>
						<div class="col-xs-10">
							 <form:input   class="form-control" type="text"  path="funmenu"  data-options="required:false"></form:input>
							</div>
					</div>
					<div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">备注：</label>
						<div class="col-xs-10" >
						<form:input path="fundemo"  class="form-control" type="text"  />
						</div>
					</div>
					<div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">排序：</label>
						<div class="col-xs-10">
							 <form:input   class="form-control" type="text" path="funsort"  data-options="required:false"></form:input>
						</div>
					</div>
       </div></div>
       			 	<div class="modal-footer mhyPopBtn">
		<button class="btn btn-info" type="button" data-dismiss="modal" onclick="closeItem()">
			<i class="icon-remove"></i>
			关闭
		</button>

		<button class="btn btn-primary" type="submit">
			<i class="icon-save"></i>
			保存
		</button>
	</div>
        </form:form>
</body>
</html>