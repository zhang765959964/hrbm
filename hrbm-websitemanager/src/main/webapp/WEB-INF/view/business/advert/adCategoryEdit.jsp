<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>编辑 广告类别</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.min.css" type="text/css">
	<script src="${ctx}/js/lib/bootstrap-validator/js/bootstrapValidator.js"></script>
    <script src="${ctx}/js/lib/bootstrap-validator/js/language/zh_CN.js"></script>	
	<script type="text/javascript">
	 $(function(){
		 initFormSubimt();
	 })
     function initFormSubimt(){
         $('#adCategoryForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   caac02: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 50
                           }
                       }
                   },
            	   //发布名称
                   indent: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 50
                           }
                       }
                   },
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                        $(".btn-submit").removeAttr("disabled");
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: data.message, 
                            callback: function(){ 
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
<form:form modelAttribute="adCategoryForm" method="post" action="${ctx}/business/advert/adCategory/save.xf">
<form:hidden path="caac01" ></form:hidden> 
     <div class="modal-body overflow-visible reportWrap">

				<div class="row" style="padding:0 30px;">
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">分类名称：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="caac02"  data-options="required:true"></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">分类标识：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="indent"  data-options="required:true"></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">使用范围：</label>
						<div class="col-xs-8 col-sm-6">
							 <form:radiobutton path="caac06" value="1" checked="true"/>网站广告
							 <form:radiobutton path="caac06" value="2" />企业广告
							 <form:radiobutton path="caac06" value="3" />职位广告
						</div>
					</div>
				</div>
		
	</div>
	<div class="modal-footer">
		<button class="btn btn-info mhyBtnLeft" data-dismiss="modal" onclick="closeItem()">
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
