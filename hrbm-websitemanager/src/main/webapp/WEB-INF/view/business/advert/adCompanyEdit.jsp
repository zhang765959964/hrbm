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
// 		              var filePath = $("#caad03").val();
// 						if(!filePath){
// 							bootbox.alert( "请先上传文件");
// 							$(".btn-primary").removeAttr("disabled");
// 							return;
// 						}
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
		  //上传图片
	   });
	  function isValidateFile(obj){
		  var fileValue= $("#file").val();
		  if(!fileValue){
			  bootBoxAlert("请选择图片") ;
			  return false;
		  }
		   var extend = fileValue.substring(fileValue.lastIndexOf(".")+1);    
		   if(extend==""){  
			   bootBoxAlert("请选择图片") ;
			return false;
		   }else{    
		    if(!(extend=="jpg"||extend=="gif"||extend=="png")){    
		    	bootBoxAlert("请上传后缀名为jpg/gif/png的文件!") ;
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
	           data:{uploadType:'jpg|gif|png',fileSize:"1"},//图片的大小以M为单位
	           secureuri: false, //一般设置为false
	           fileElementId: 'file', // 上传文件的id、name属性名
	           dataType: 'text', //返回值类型，一般设置为json、application/json
	          // elementIds: elementIds, //传递参数到服务器
	           success: function(data, status){  debugger;
	        	 if(data && ((data.indexOf("png")!=-1)||(data.indexOf("gif")!=-1)||(data.indexOf("jpg")!=-1))){
		        	 $("#imgContext").empty() ;   		 
		      		 $("#imgContext").append("<img class='mhyUpImg' onclick=\"clickImg(this)\"  src=\"${fileDirectory}/"+data+"\"/>")
		      		 $("#caae03").val(data);
	        	 }else{
	        		 bootBoxAlert(data) ;
	        	 }
	           },
	           error: function(data, status, e){ 
	        	   bootBoxAlert('上传图片出错了') ;
	           }
	       });
	       //return false;
	   } 
	   function bootBoxAlert(message,callbackFun){
		   bootbox.alert({ 
               size: 'small',
               width:"100px",
               message: message,
               callback: function(){ 
            	   if(callbackFun){callbackFun();}
               }
	  	});
	  }
	</script>
</head>
<body>
<form:form modelAttribute="adCompanyForm" method="post" action="${ctx}/business/advert/adCompany/save.xf">
     <form:hidden path="caae01" ></form:hidden>
     <form:hidden path="caac01" ></form:hidden>
     <form:hidden path="aab001" ></form:hidden>
     <div class="modal-body overflow-visible reportWrap">
		<div class="row" style="padding:0 30px;">
			<div class="col-xs-12 " >
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
				<label class="col-xs-2" for="inputError">广告描述：</label>
				<div class="col-xs-8 ">
					<form:input  class="form-control" type="text"  path="caae02"  data-options="required:false"></form:input>
				</div>
			</div>
			<div class="col-xs-12 " >
				<label class="col-xs-2" for="inputError">指向地址：</label>
				<div class="col-xs-8 ">
					<form:input  class="form-control" type="text"  path="caae04"  ></form:input>
					<div style="color:#428BCA">如果留空,点击将指向网站中的企业详情页面</div>
				</div>
			</div>
			<div class="col-xs-12 " >
				<label class="col-xs-2" for="inputError">上传图片：</label>
				<div class="col-xs-8 ">
					<div style="color:#428BCA">允许上传的图片格式为:jpg|gif|png，大小不能超过1024KB</div>
					<form:hidden  path="caae03" ></form:hidden>
					    <input type="file" id="file" name="file" onchange="ajaxFileUpload()"  accept="image/*">
					       <div id="imgContext">
						       <c:if test="${!empty adCompanyForm.caae03}">
	           						<img onclick="clickImg(this)" id="" src="${fileDirectory}/${adCompanyForm.caae03}"  class="mhyUpImg"/>
								</c:if>
							</div>
					      
						      
	
					 
				</div>
			</div>
		</div>
	</div>
	<div class="bottomBtn">
<div class="h50"> </div>
<div class="floatBtn">
		<button class="btn btn-info mhyBtnLeft" type="button" onclick="closeItem()">
			<i class="icon-remove"></i>
			关闭
		</button>
		<button class="btn btn-primary" type="submit">
			<i class="icon-save"></i>
			保存
		</button>
	</div>
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
