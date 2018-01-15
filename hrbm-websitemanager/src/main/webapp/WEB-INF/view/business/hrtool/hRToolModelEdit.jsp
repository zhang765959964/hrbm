<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑 hr工具箱模板表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
<script type="text/javascript">
	function closeItem() {

		xfui.closeDialog();
	}
	$(function() {
	    $('#hRToolModelForm').bootstrapValidator({
	         message: 'This value is not valid',
	         feedbackIcons: {
	             valid: 'glyphicon glyphicon-ok',
	             invalid: 'glyphicon glyphicon-remove',
	             validating: 'glyphicon glyphicon-refresh'
	         },
	         fields: {
	      	   //发布名称
	             cand19: {
	                 validators: {
	                     notEmpty: {
	                     },
	                     stringLength: {
	                         min: 2,
	                         max: 50
	                     }
	                 }
	             },
	             cand03: {
	                 validators: {
	                     notEmpty: {
	                     },
	                     stringLength: {
	                         min: 2,
	                         max: 50
	                     }
	                 }
	             } ,cand04: {
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
	              var filePath = $("#filePath").val();
					if(!filePath){
						bootbox.alert( "请先上传文件");
						$(".btn-primary").removeAttr("disabled");
						return;
					}
	              $.post($form.attr('action'), $form.serialize(), function(data) {
	                  $(".btn-primary").removeAttr("disabled");
	                  bootbox.alert({ 
	                      size: 'small',
	                      width:"100px",
	                      message: data.message, 
	                      callback: function(){ 
	                      	var parentIframe=xfui.getParentIframe();
	                      	if(parentIframe){
	                      		parentIframe.refreshTable();
							}
							xfui.closeDialog();                     	                     	
	                      }
	                  })
	                  
	              }, 'json');

	          });
		 $("#name").pinyinAleph(function(data){
			 if(!$("#code").val()){
				 $("#code").val(data);
			 }
			 
		 });
	});
	function isValidateFile(obj) {
		var fileValue = $("#file").val();
		if (!fileValue) {
			bootbox.alert( "请选择模板文件");
			return false;
		}
		var extend = fileValue.substring(fileValue.lastIndexOf(".") + 1);
		if (extend == "") {
			bootbox.alert( "请选择模板文件");
			return false;
		} else {
			if (!(extend == "doc" || extend == "docx"|| extend == "xls"|| extend == "xlsx")) {
				bootbox.alert( "请上传word或者excel文件!");
				return false;
			}
		}
		return true;
	}
	function ajaxFileUpload() {

		if (!isValidateFile()) {
			return;
		}
		// 开始上传文件时显示一个图片
		$("#wait_loading").ajaxStart(function() {
			$(this).show();
			// 文件上传完成将图片隐藏起来
		}).ajaxComplete(function() {
			$(this).hide();
		});
// 		var elementIds = [ "flag" ]; //flag为id、name属性名
		$.ajaxFileUpload({
			url : 'upload.xf',
			type : 'post',
			secureuri : false, //一般设置为false
			fileElementId : 'file', // 上传文件的id、name属性名
			dataType : 'text', //返回值类型，一般设置为json、application/json
// 			elementIds : elementIds, //传递参数到服务器
			success : function(data, status) {
				
				$("#modelPath").empty() ;   		 
	      		$("#modelPath").append("<a href=\"${fileDirectory}/"+data+"\">"+data+"</a>");
	      		
	      		$("#filePath").val(data);
				

			},
			error : function(data, status, e) {
				bootbox.alert('系统提示');
			}
		});
		//return false;
	}
</script>
</head>
<body>
<form:form modelAttribute="hRToolModelForm" method="post" action="${ctx}/business/hrtool/hRToolModel/save.xf">
            	<form:hidden path="id"></form:hidden>
			<form:hidden path="colId"></form:hidden>
						<form:hidden path="filePath" data-options="required:true"></form:hidden>
     <div class="modal-body overflow-visible reportWrap">

				<div class="row" style="padding:0 30px;">
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">名称：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="name"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">代码：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="code"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">模版栏目：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="colName"  readonly="true" ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">排序号：</label>
						<div class="col-xs-8 ">
							<form:input class="form-control" type="text"  path="sortNum"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">模版路径：</label>
						<div class="col-xs-8 ">
							<div id="modelPath">
							  <c:if test="${!empty hRToolModelForm.filePath}">
							    <a href="${fileDirectory}/${hRToolModelForm.filePath}">${hRToolModelForm.filePath}</a>
							  </c:if>  
					     	</div>
				        </div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">模版上传：</label>
						<div class="col-xs-8 ">
						<span>
						    <input type="file" id="file" name="file"  data-options="required:true" onchange="ajaxFileUpload()">
<!-- 							<input type="hidden" id="flag" name="flag" value="ajax文件上传"/> -->
							
						
						</span>
							
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">描述：</label>
						<div class="col-xs-8 ">
							<form:textarea  class="form-control"  path="description" ></form:textarea>
						</div>
					</div>
				</div>
		 
	</div>
	<div class="modal-footer">
		<button class="btn btn-sm" type="button" onclick="closeItem()">
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
