<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="/commons/include/commonInc.jsp" %>
	<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css" type="text/css">
	<link rel="stylesheet" href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css" type="text/css">
	<script type="text/javascript" src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

<title>编辑系统人员</title>
<script>
$(function(){
	 initFormSubimt();
})
function initFormSubimt(){
    $('#cropForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
          fields: {
          }
      }).on('success.form.bv', function(e) {
    	      var parentIframe=xfui.getParentIframe();
    	      var acb210 = parentIframe.getParentSelectValues();
    	       $("#acb210").val(acb210);
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
 <form:form modelAttribute="cropForm" method="post" action="${ctx}/business/jobfair/corpPosition/freezeCorpPosition.xf">
  <div class="modal-body overflow-visible reportWrap">
      <div class="row mhyPhotoDiv"  >
						<div style="margin: 0 auto;width: 210px;" >
						<label   style="margin-right:5px;" for="inputError" >冻结原因:</label>
						<div style="float:left;">
						<form:hidden path="acb210"/>
						  <xf:select name="acb20l" textField="name" tableName="TAB_UFREASONS" valueField="code"></xf:select>
					    </div>
     				    </div>
     				    </div>

	</div>
	     	<div class="modal-footer new-model-footer" style="text-align:center;position:fixed;bottom:0">
			<button class="btn btn-sm" data-dismiss="modal" type="button" onclick="closeItem()">
				<i class="icon-remove"></i>
				关闭
			</button>

		<button class="btn btn-sm btn-primary" type="submit">
			<i class="icon-ok"></i>
			保存
		</button></div>
      </form:form>
</body>
</html>