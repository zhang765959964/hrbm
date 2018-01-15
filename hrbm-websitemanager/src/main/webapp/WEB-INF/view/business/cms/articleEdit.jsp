<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
<title></title>
<script>
$(function(){
     var um = UE.getEditor('myEditor',{
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
    // xfui.setTabHeight(1250);
     $('#articleForm').bootstrapValidator({
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
                         max: 200
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
             }
         }
     }).on('success.form.bv', function(e) {
              e.preventDefault();
              var $form = $(e.target);
              var bv = $form.data('bootstrapValidator');
              var content=UE.getEditor('myEditor').getContent();
              $("#cand04").val(content);
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
                      	closeItem();                     	                     	
                      }
                  })
                  
              }, 'json');

          });
})

function closeItem(){
	xfui.closeTab();  
}

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
      		 $("#imgContext").append("<img  src=\"${fileDirectory}/"+data+"\"  width=\"200px\"  height=\"200px\"/>")
      		 $("#cand11").val(data);

           },
           error: function(data, status, e){ 
        	   $.messager.alert('系统提示',e) ;
           }
       });
       //return false;
   }
</script>
<style>
  .opfixed{padding: 5px 5px;background:#fff;position:fixed;top:8px;width:100%;}
  .opnofixed{padding: 5px 5px;background:#fff;}
  .mhyModelFooter{position:fixed !important;bottom:0;z-index:1000}
  .mhyBodyBottom{padding-bottom:80px;}
</style>
</head>
<body>
<form:form modelAttribute="articleForm" class="bv-form" method="post" action="${ctx}/business/cms/article/save.xf">
            	<form:hidden path="cand01" ></form:hidden>
            	<form:hidden path="cand04" ></form:hidden>
     <div class="modal-body overflow-visible reportWrap mhyBodyBottom">

				<div class="row" style="padding:0 30px;">
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">新闻标题：</label>
						<div class="col-xs-8 ">
							<form:input  class="form-control" type="text"  path="cand03"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">新闻分类：</label>
						<div class="col-xs-8 ">
							${articleForm.colName}
						<form:hidden path="canc01" ></form:hidden>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">摘要：</label>
						<div class="col-xs-8 ">
							<form:textarea  class="form-control"  path="cand19" ></form:textarea>
						</div>
					</div>
										<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">发布人：</label>
						<div class="col-xs-8 ">
							<form:hidden path="ccmu01" ></form:hidden>${articleForm.publishUserName}
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">排序号：</label>
						<div class="col-xs-8 ">
							<form:input class="form-control" type="text"  path="cand10"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">图片新闻：</label>
						<div class="col-xs-8 ">
							<form:hidden    path="cand11"  ></form:hidden>
						   <table>
						     <tr>
						       <td>
						       <div id="imgContext">
							       <c:if test="${!empty articleForm.cand11}">
	            						<img  id="" src="${fileDirectory}/${articleForm.cand11}"  width="200px"  height="200px"/>
		
									</c:if>
								</div>
						      </td>
						       <td>						       
						       </td>
						     </tr>
						     <tr></tr>
						     <tr>
						      <td>
							       <input type="file" id="file" name="file" onchange="ajaxFileUpload()" >
								  
						       </td>
						     </tr>
						   </table>
						</div>
					</div>
<!-- 					<div class="col-xs-12 " > -->
<!-- 						<label class="col-xs-2" for="inputError">是否显示标题图片：</label> -->
<!-- 						<div class="col-xs-8 "> -->
<%-- 							<form:select class="combobox" path="cand12"> --%>
<%-- 							   <form:option value="0" label="不显示"/> --%>
<%-- 							   <form:option value="1" label="显示"/> --%>
<%-- 						   </form:select> --%>
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">关键字：</label>
						<div class="col-xs-8 ">
							<form:input class="form-control" type="text"  path="cand15"  ></form:input>
						</div>
					</div>
					<div class="col-xs-12 " >
						<label class="col-xs-2" for="inputError">新闻内容：</label>
						<div class="col-xs-8 ">
							<script type="text/plain" id="myEditor" >${articleForm.cand04}</script>
						</div>
					</div>
				</div>
		 
	</div>
	<div class="modal-footer mhyModelFooter">
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
</body>
</html>