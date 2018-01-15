<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑培训设置信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <%@include file="/commons/include/commonInc.jsp" %>
     <link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
     <link rel="stylesheet" href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
     <link rel="stylesheet" href="${ctx}/assets/css/normal.css" />
     <link rel="stylesheet" href="${ctx}/css/index.css" />
     <link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
     <script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
     <script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
</head>
	<script type="text/javascript">
	 $(function(){
		 initFormSubimt();
	 })
	 
     function initFormSubimt(){
         $('#trainSysSetForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	    //配置名称
            	    caos02:{validators: {notEmpty: {
		            	message: '请填写配置名称'
		            },stringLength: {min: 1,max: 50}}},
		            
		            //配置值
            	    caos04:{validators: {notEmpty: {
		            	message: '请填写配置值'
		            },stringLength: {min: 1,max: 50}}},
		            
		            //配置说明
            	    caos03:{validators: {notEmpty: {
		            	message: '请填写配置说明'
		            },stringLength: {min: 2,max: 50}}}
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
            			    		xfui.open_tabs("培训信息设置","${ctx}/business/dissupport/train/trainSysSet/list.xf","培训系统信息管理"); 
            			    	}
                            	closeItem(); 
                            }
                        })
                    }, 'json');
                });
       }
	
	function closeItem(){
		  xfui.closeTab();
	  }
	  
</script>
</head>
<body>
<div class="container-fluid">
<div class="mhyMain mhySearch">
<div class="mhyTitle">培训设置信息</div>
<form:form modelAttribute="trainSysSetForm" method="post" action="${ctx}/business/dissupport/train/trainSysSet/save.xf">
     <form:hidden path="caos01"></form:hidden> 
     <form:hidden path="caos05"></form:hidden> 
     <form:hidden path="caos06"></form:hidden> 
     <form:hidden path="aae011"></form:hidden>
     <form:hidden path="aae017"></form:hidden>
     <form:hidden path="aae019"></form:hidden>
     <form:hidden path="aae020"></form:hidden>
     <form:hidden path="cczy06"></form:hidden>
     <form:hidden path="aae036"></form:hidden>
     <div class="mhySearchInput mhyInputDiv">
   				<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>配置名称：</label>
						<div class="col-xs-9 col-sm-2">
							<form:input class="form-control" type="text" path="caos02" value="${trainSysSetForm.caos02}"></form:input>
						</div>
						
						<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>配置值：</label>
						<div class="col-xs-9 col-sm-1">
							<form:input class="form-control" type="text" path="caos04" value="${trainSysSetForm.caos04}"></form:input>
						</div>
						
						<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>配置说明：</label>
						<div class="col-xs-9 col-sm-3">
							<form:input class="form-control" type="text" path="caos03" value="${trainSysSetForm.caos03}"></form:input>
						</div>
   				</div>
   	 
      <div class="mhyUnitBtn">
				<button class="btn btn-info mhyBtnLeft" type="button" onclick="closeItem()">
					<i class="icon-remove"></i>
					关闭
				</button>
				<button class="btn btn-primary" type="submit">
					<i class="icon-save"></i>
					保存
				</button>
      </div> </div></div></div>
          
 </form:form>
</body>
</html>
