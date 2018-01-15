<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 电子档案目录</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript">
	 $(function(){
		 
		 initFormSubimt();
	 })
     function initFormSubimt(){
         $('#erecordCatalogForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   name: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               max: 10
                           }
                       }
                   },
                   code: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               max: 10
                           },
                           regexp: {
	                             regexp:  /^[A-Za-z]+$/
	                         }
                          
                       }
                   },
                   description: {
                       validators: {
                           stringLength: {
                               max: 100
                           }
                       }
                   },
                   sortnum: {
                       validators: {                   	   
                    	    regexp: {
	                             regexp: /^[1-9]\d*$/
	                         }
                       }
                   },
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
		  $('#erecordCatalogForm').submit();
	  }
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNob change-bg-iframe">
				<div class="moduleCont">
					<form:form modelAttribute="erecordCatalogForm" method="post" action="${ctx}/business/personagency/erecord/erecordCatalog/save.xf">
					<form:hidden path="id" ></form:hidden>
	    			<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>目录名称:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input  class="form-control" type="text"  path="name" ></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>目录代码:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input  class="form-control" type="text"  path="code" ></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">描述:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="description" ></form:input>
						</div>
							 
						<label class="col-xs-3 col-sm-label" for="inputError">排序:</label>
						<div class="col-xs-9 col-sm-input ">
							<form:input  class="form-control" type="text"  path="sortnum" ></form:input>
						</div>
							 
	    			</div>											
	        		</form:form>					
				</div>
			</div>
		</div>
	<div class="h60">&nbsp;</div>
   	<div class="floatBtn">
   		<a href="javascript:void(0)" role="button" class="btn btn-primary"  onclick="submitForm()"><i class="icon-save"></i>保存</a>
   		<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
   		
   	</div>
	   	
	</div>	
   	  
</body>
</html>
