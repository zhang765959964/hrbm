<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<title>编辑 RSDA_BS_PRINT_MODEL</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/myplugin/inputplugin.js?version=2016178"></script>
	<script type="text/javascript">
	 $(function(){
		 
		 initFormSubimt();
		 xfui.initUi();
		   um = UE.getEditor('myEditor',{autoHeightEnabled: false,
				 toolbars: [[
					 'fullscreen', 'source', '|', 'undo', 'redo', '|',
					 'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
					 'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
					 'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|', 'indent', '|',
					 'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
					 'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
					 'simpleupload', 'insertimage', 'emotion', 'insertvideo', 'music','attachment', 'map', 'insertframe', 'insertcode', 'pagebreak', 'template',  '|',
					 'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
					 'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
					 'print', 'searchreplace', 'help'
				 ]]
			 });
	 })
     function initFormSubimt(){
         $('#printTemplateForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   fdModelName: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 50
                           }
                       }
                   },
                   fdModelAlias: {
                       validators: {
                           notEmpty: {
                           }
                       }
                   },
                   fdModelService: {
                       validators: {
                           notEmpty: {
                           }
                       }
                   }
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    var content=UE.getEditor('myEditor').getContent();
                    $("#fdModelHtml").val(content);
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                    	bv.disableSubmitButtons(false);
         				bootbox.alert({
         					size : 'small',
         					width : "100px",
         					message : data.message
         				})
                        
                    }, 'json');

                });
       }
	</script>
</head>
<body>
<form:form modelAttribute="printTemplateForm" method="post" action="${ctx}/business/personagency/print/printTemplate/save.xf">
  <form:hidden path="pkId" ></form:hidden>
  <form:hidden path="fkModelType"  value="1"></form:hidden>
  <form:hidden path="fdModelHtml" ></form:hidden>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNob">
				<div class="moduleCont">					
					     <div class="row">
										<label class="col-xs-3 col-sm-2" for="inputError" title="模版名称">模版名称:</label>
											 <div class="col-xs-9 col-sm-10 required">
												<form:input  class="form-control" type="text"  path="fdModelName" ></form:input>
											</div>											 
						  </div>
						  <div class="row">
										<label class="col-xs-3 col-sm-2" for="inputError" title="模版别名">模版别名:</label>
											 <div class="col-xs-9 col-sm-10 required">
												<form:input  class="form-control" type="text"  path="fdModelAlias" ></form:input>
											</div>
											 
							 </div>																																			
					     <div class="row">
										<label class="col-xs-3 col-sm-2" for="inputError" title="模版服务">模版服务:</label>
											 <div class="col-xs-9 col-sm-10 required">
												<form:input  class="form-control" type="text"  path="fdModelService" ></form:input>
											</div>											 
					     </div>																		
					     <div class="row">
										<label class="col-xs-3 col-sm-2" for="inputError" title="模版类型">模版类型:</label>
											 <div class="col-xs-9 col-sm-10 required">
												<script type="text/plain" id="myEditor" style="height:600px;width:100%" >${printTemplateForm.fdModelHtml}</script>
											</div>											 
						 </div>			
				</div>
			</div>
		</div>
	 <div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"  >保存</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-primary" onclick="xfui.closeDialog()">关闭</a>
<!-- 	   		<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal">登记新户</a> -->
<!-- 	   		<a href="javascript:void(0)" role="button" class="btn btn-success">打印条码标签</a> -->
	   		
	   	</div>
	   	
	</div>	
 </form:form>  	  
</body>
</html>
