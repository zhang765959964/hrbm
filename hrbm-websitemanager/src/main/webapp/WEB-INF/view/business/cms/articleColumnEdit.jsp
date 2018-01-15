<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />

<title>栏目管理</title>
<script>

  function closeItem(){
	  
	  xfui.closeDialog();
  }
 $(function(){
     $('#articleColumnForm').bootstrapValidator({
         message: 'This value is not valid',
         feedbackIcons: {
             valid: 'glyphicon glyphicon-ok',
             invalid: 'glyphicon glyphicon-remove',
             validating: 'glyphicon glyphicon-refresh'
         },
         fields: {
      	   //发布名称
             canc03: {
                 validators: {
                     notEmpty: {
                     },
                     stringLength: {
                         min: 2,
                         max: 50
                     }
                 }
             }
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
        		    		parentIframe.refreshTree();
        		    	}
                      	closeItem(); 
                      	
                      }
                  })
                  
              }, 'json');

          });
	 $("#canc03").pinyinAleph(function(data){
		 $("#canc11").val(data);
		 //$("#canc11").textbox("setValue",data);
	 });
 })
</script>
</head>
<body>
<form:form modelAttribute="articleColumnForm" method="post" action="${ctx}/business/cms/articleColumn/save.xf">
<form:hidden path="canc01" ></form:hidden> 
     <div class="modal-body overflow-visible reportWrap">

				<div class="row" style="padding:0 30px;">
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">栏目名称：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="canc03"  data-options="required:true"></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">栏目标题：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="canc06"  data-options="required:true"></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">父级栏目：</label>
						<div class="col-xs-8 col-sm-6">
							${articleColumnForm.parentColName}<form:hidden path="canc02" ></form:hidden>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">栏目关键字：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="canc07"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">栏目别名：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input  class="form-control" type="text"  path="canc11"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">排序号：</label>
						<div class="col-xs-8 col-sm-6">
							<form:input class="form-control" type="text"  path="canc13"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6" >
						<label class="col-xs-2" for="inputError">栏目描述：</label>
						<div class="col-xs-8 col-sm-6">
							<form:textarea  class="form-control" type="text"  path="canc08" ></form:textarea>
						</div>
					</div>
				</div>
		 
	</div>
	<div class="modal-footer">
		<button class="btn btn-sm" data-dismiss="modal" onclick="closeItem()">
			<i class="icon-remove"></i>
			关闭
		</button>

		<button class="btn btn-sm btn-primary" type="submit">
			<i class="icon-ok"></i>
			保存
		</button>
	</div>
	</form:form>
</body>

</html>