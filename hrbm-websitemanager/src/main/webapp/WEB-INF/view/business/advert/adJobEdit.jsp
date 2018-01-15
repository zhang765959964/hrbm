<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 广告位放置表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
	<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
	<script type="text/javascript">
	  function closeItem(){
		  xfui.closeDialog();
	  }
	  $(function(){
		  $("#caae08").xfdaterangepicker({singleDatePicker:true,
			  "opens":"right",
			  "drops": "up",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		  $("#caae09").xfdaterangepicker({singleDatePicker:true,
			  "opens":"right",
			  "drops": "up",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		  $('#adCompanyForm').bootstrapValidator({
		         message: 'This value is not valid',
		         feedbackIcons: {
		             valid: 'glyphicon glyphicon-ok',
		             invalid: 'glyphicon glyphicon-remove',
		             validating: 'glyphicon glyphicon-refresh'
		         },
		         fields: {
		      	   //发布名称
		             caae02: {
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
//		              var filePath = $("#caad03").val();
//						if(!filePath){
//							bootbox.alert( "请先上传文件");
//							$(".btn-primary").removeAttr("disabled");
//							return;
//						}
		              $.post($form.attr('action'), $form.serialize(), function(data) {
		                  $(".btn-primary").removeAttr("disabled");
		                  bootbox.alert({ 
		                      size: 'small',
		                      width:"100px",
		                      message: data.message, 
		                      callback: function(){ 
		                      	var parentIframe=xfui.getParentIframe();
		                      	if(parentIframe){
		                      		parentIframe.refresh();
								}
								xfui.closeDialog();                     	                     	
		                      }
		                  })
		                  
		              }, 'json');

		          });
		  //隐藏 分类编号 公司id
// 		  $("#caac01").next().hide();
// 		  $("#aab001").next().hide();
// 		  $("#jobid").next().hide();
		  //上传图片
	   });
	  function isValidateFile(obj){
		  var fileValue= $("#file").val();
		  if(!fileValue){
			  $.messager.alert('系统提示',"请选择图片") ;
			  return false;
		  }
		   var extend = fileValue.substring(fileValue.lastIndexOf(".")+1);    
		   if(extend==""){  
			   $.messager.alert('系统提示',"请选择图片") ;
			return false;
		   }else{    
		    if(!(extend=="jpg"||extend=="gif"||extend=="bmp"||extend=="png")){    
		       $.messager.alert('系统提示',"请上传后缀名为jpg/gif/bmp/png的文件!") ;
		       return false;    
		    }    
		   }    
		   return true;    
		 }
	  
	   function ajaxFileUpload() {
		
		  if(!isValidateFile()){
			  return;
		  }
	       // 开始上传文件时显示一个图片
	       $("#wait_loading").ajaxStart(function() {
	           $(this).show();
	       // 文件上传完成将图片隐藏起来
	       }).ajaxComplete(function() {
	           $(this).hide();
	       });
	       var elementIds=["flag"]; //flag为id、name属性名
	       $.ajaxFileUpload({
	           url: 'fileUpload.xf', 
	           type: 'post',
	           secureuri: false, //一般设置为false
	           fileElementId: 'file', // 上传文件的id、name属性名
	           dataType: 'text', //返回值类型，一般设置为json、application/json
	           elementIds: elementIds, //传递参数到服务器
	           success: function(data, status){  
	        	 $("#imgContext").empty() ;   		 
	      		 $("#imgContext").append("<img onclick=\"clickImg(this)\" class=\"mhyUpImg\"  src=\"${fileDirectory}/"+data+"\"  />")
	      		 $("#caae03").val(data);

	           },
	           error: function(data, status, e){ 
	        	   $.messager.alert('系统提示',e) ;
	           }
	       });
	       //return false;
	   } 
	</script>
</head>

<body>
<form:form modelAttribute="adCompanyForm" method="post" action="${ctx}/business/advert/adCompany/save.xf">
     <form:hidden path="caae01" ></form:hidden>
     <form:hidden path="caac01" ></form:hidden>
     <form:hidden path="aab001" ></form:hidden>
     <form:hidden path="jobid" ></form:hidden>
     <div class="modal-body overflow-visible reportWrap">
				<div class="row" style="padding:0 30px;">
					<div class="col-xs-12 ">
						<label class="col-xs-2" for="inputError">所属类别：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="caac02"  readonly="true" ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">公司名称：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="aab004"  readonly="true" ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">职位名称：</label>
						<div class="col-xs-8 ">
								<form:input  class="form-control" type="text"  path="cca113" readonly="true" ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">广告描述：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="caae02"  data-options="required:false"></form:input>
						</div>
					</div>
					
					<div class="col-xs-12 " style="display:none;" >
						<label class="col-xs-2" for="inputError">上传图片</label>
						<div class="col-xs-8 ">
							<form:hidden  path="caae03" ></form:hidden>
							 <input type="file" id="file" name="file" onchange="ajaxFileUpload()"><br/>
							       <div id="imgContext">
								       <c:if test="${!empty adCompanyForm.caae03}">
		            						<img  onclick="clickImg(this)"  id="" src="${fileDirectory}/${adCompanyForm.caae03}"  class="mhyUpImg"/>
										</c:if>
									</div>
							
								       
					
						</div>
					</div>
				</div>
		 
	</div>
	<div class="modal-footer mhyFooter">
		<button class="btn btn-info mhyBtnLeft" type="button" onclick="closeItem()">
			<i class="icon-remove"></i>
			关闭
		</button>

		<button class="btn btn-primary" type="submit">
			<i class="icon-save"></i>
			保存
		</button>
	</div>
	</form:form>
	
		<script type="text/javascript">
		function clickImg(_this){
			var _thisImg = $(_this).attr("src");
		    $(".imgbig_div img", window.parent.document).attr("src",_thisImg);
		    $(".bigImg", window.parent.document).show();
		}
	</script>
</body>	

</html>
