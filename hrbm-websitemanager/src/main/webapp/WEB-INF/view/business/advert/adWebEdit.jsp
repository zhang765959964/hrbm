<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 广告位内容表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="/commons/include/commonInc.jsp" %>
	<%@include file="/commons/include/bootstrapInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
	<script type="text/javascript">
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	  $(function(){
		  $('#adWebForm').bootstrapValidator({
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
		             caad02:{
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
		              var filePath = $("#caad03").val();
						if(!filePath){
							 bootBoxAlert( "请先上传文件");
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
		                      		parentIframe.refresh();
								}
								xfui.closeDialog();                     	                     	
		                      }
		                  })
		                  
		              }, 'json');

		          });
	   });
	  function isValidateFile(obj){
		  var fileValue= $("#file").val();
		  if(!fileValue){
			  bootBoxAlert('系统提示',"请选择图片");
			  return false;
		  }
		   var extend = fileValue.substring(fileValue.lastIndexOf(".")+1);    
		   if(extend==""){  
			   bootBoxAlert('系统提示',"请选择图片");
			return false;
		   }else{    
		    if(!(extend=="jpg"||extend=="gif"||extend=="png")){    
		    	 //bootbox.alert('系统提示',"请上传后缀名为jpg/gif/bmp/png的文件!") ;
		    	  bootbox.alert({ 
		                      size: 'small',
		                      width:"100px",
		                      message: "请上传后缀名为jpg/gif/png的文件!",
		                      callback: function(){ 
		                    	  $("#file").val("");
		                      }
		    	  });
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
	           url: '${ctx}/business/advert/adWeb/fileUpload.xf', 
	           type: 'post',
	           data:{uploadType:'jpg|gif|png',fileSize:"1"},//图片的大小以M为单位
	           secureuri: false, //一般设置为false
	           fileElementId: 'file', // 上传文件的id、name属性名
	           dataType: 'text', //返回值类型，一般设置为json、application/json
	           elementIds: elementIds, //传递参数到服务器
	           success: function(data, status){
	        	   if(data && ((data.indexOf("png")!=-1)||(data.indexOf("gif")!=-1)||(data.indexOf("jpg")!=-1))){
			        	 $("#imgContext").empty() ;   		 
			      		 $("#imgContext").append("<img onclick=\"clickImg(this)\" src=\"${fileDirectory}/"+data+"\" class='mhyUpImg'   />")
			      		 $("#caad03").val(data);
		        	 }else{
		        		 bootBoxAlert(data) ;
		        	 }
	           },
	           error: function(data, status, e){ 
	        	   bootBoxAlert(e) ;
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
<form:form modelAttribute="adWebForm" method="post" action="${ctx}/business/advert/adWeb/save.xf">
     <form:hidden path="caad01" ></form:hidden>
     <div class="modal-body overflow-visible reportWrap">
				<div class="row" style="padding:0 30px;">
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">所属类别：</label>
						<div class="col-xs-8 ">
						    <form:hidden path="caac01" ></form:hidden>
							<form:input  class="form-control" type="text"  path="caac02"  readonly="true" ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">广告描述：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="caad02"  data-options="required:false"></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">广告代码：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="caad13"  readonly="true" ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">指向地址：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="caad12"  ></form:input>
							<div style="color:#428BCA">如果留空,点击将无任何反应</div>
						</div>
					</div>
					<div class="col-xs-12 ">
						<label class="col-xs-2" for="inputError">广告位显示状态：</label>
						<div class="col-xs-8 ">
						     <form:radiobutton path="caad06" value="1" checked="true"/>显示  
							 <form:radiobutton path="caad06" value="0"/>隐藏
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">上传图片：</label>
						<div class="col-xs-8 ">
						     <div style="color:#428BCA">允许上传的图片格式为:jpg|gif|png，大小不能超过1024KB</div>
							 <form:hidden  path="caad03" ></form:hidden>
							  
								        <input type="file" id="file" name="file"  onchange="ajaxFileUpload()"  accept="image/*" >
							   
							 							       <div id="imgContext">
								       <c:if test="${!empty adWebForm.caad03}">
		            						<img onclick="clickImg(this)" id="" src="${fileDirectory}/${adWebForm.caad03}" class="mhyUpImg"/>
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
