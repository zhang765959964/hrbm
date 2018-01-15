<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>编辑部门信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="/commons/include/commonInc.jsp" %>
	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css" type="text/css">
	<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
	<script type="text/javascript">
	$(function(){
		 initFormSubimt();
	 })
    function initFormSubimt(){
        $('#sysRoleForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
              fields: {
            	  rolename : {
    					validators : {
    						notEmpty: {
    	                    	  message:'角色名称不能为空'
    	                    },
    						stringLength : {
    							message : '最大长度为20',
    							min : 1,
    							max : 20
    						}
    					}
    				},
    				roledesc : {
      					validators : {
      						stringLength : {
      							message : '最大长度为40',
      							min : 1,
      							max : 40
      						}
      					}
      				}
              }
          }).on('success.form.bv', function(e) {
                   e.preventDefault();
                   var $form = $(e.target);
                   var bv = $form.data('bootstrapValidator');
                   bv.disableSubmitButtons(true);
                   $("#hidden_name").val($("#aae017_select option:selected").text());
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
	  <form:form modelAttribute="sysRoleForm" method="post" action="${ctx}/sys/role/sysRole/save.xf">
  <div class="modal-body overflow-visible reportWrap">
      <div class="row" style="padding:0 30px;">
       <form:hidden path="roleid" ></form:hidden>
       				<div class="col-xs-12" >
						<label class="col-xs-2" for="inputError">所属机构：</label>
						<div class="col-xs-8">
							  <form:select path="aae017" items="${sysOrgs}" itemLabel="acd202" dir="1" itemValue="acd200" id="aae017_select">
							 </form:select>
							 <input type="hidden" id="hidden_name" name="aae020" >
							</div>
					</div>
      				<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">角色名称：</label>
						<div class="col-xs-8">
							 <form:input   class="form-control" type="text"  path="rolename"  data-options="required:false"></form:input>
							</div>
					</div>
							<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError"  >角色描述：</label>
						<div class="col-xs-8">
						<form:textarea path="roledesc" style="width: 510px;height: 80px;" maxlength="40" />
<%-- 							 <form:input   class="form-control" type="text"    data-options="required:false"></form:input> --%>
							</div>
					</div>

       </div>
      </div>
<!-- 		 	<div class="modal-footer" style="text-align:center">
    		<button class="btn btn-info mhyBtnLeft" data-dismiss="modal" type="button" onclick="closeItem()">
    			<i class="icon-remove"></i>
    			关闭222
    		</button> -->

       <div class="modal-footer">
      		<button class="btn btn-info mhyBtnLeft" data-dismiss="modal" type="button" onclick="closeItem()">
      			<i class="icon-remove"></i>
      			关闭
      		</button>

      		<button class="btn btn-primary" type="submit">
      			<i class="icon-save"></i>
      			保存
      		</button>
    	</div>

<!--     	</div> -->

    </form:form>
</body>
</html>
