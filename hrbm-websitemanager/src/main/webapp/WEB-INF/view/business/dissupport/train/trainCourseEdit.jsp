<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑开班信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <%@include file="/commons/include/commonInc.jsp" %>
     <%@include file="/commons/include/bootstrapInc.jsp" %>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
</head>
<script type="text/javascript">
 $(function(){
		 initFormSubimt();
		 //开班logo 验证
		 var file=$('#courseLogo').val();
		 if (file!=""){
            $('#trainCourseForm')
            .data('bootstrapValidator')
            .updateStatus('file','VALID', null)
            .validateField('file');
          }
	 })
     function initFormSubimt(){
         $('#trainCourseForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   	//开班名称
		            courseName:{
		            	validators: {
		            		notEmpty: {message: '请填写开班名称'},
		            		stringLength: {min: 1,max: 25}
		            		}
               },
            	   	//开班类型
		            courseType:{
		            	validators: {
		            		notEmpty: {message: '请选择开班类型'}
                           }
               },
		            //联系人
		            contactsName:{
		            	validators: { 
		            	  notEmpty: {message: '请填写联系人'},
		            	  stringLength: {min: 1,max: 25}
		            	}
		            },
		            //手机号
		            contactsTel:{
		            	validators: {
		            		notEmpty: {message: '请填写联系电话'},
		            		regexp: {
		            			/* regexp: /(^[0-9]{3,4}\-[0-9]{3,8}$)|(^[0-9]{3,8}$)|(^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}1[3|4|5|7|8][0-9]{9}$)/, */
		                        regexp:/^(1[3,4,5,8,7]{1}[\d]{9})|(((400)-(\d{3})-(\d{4}))|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{3,7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)$/,
		            			message: '联系电话格式不正确'
		                      }
		            		}
		            },
		          /*  //名称简码
		            aac022:{
		            	validators: {
		            		regexp: {
		                        regexp: /^[a-zA-Z]+$/,
		                        message: '机构简码格式不正确'
		                      }
		            		}
		            }, */
		         
		            //培训费用验证
		            cost:{
		            	validators: {
		            		notEmpty: {message: '请填写培训费用'},
		            		regexp: {
		                        regexp: /^\d+(\.\d+)?$/,
		                        message: '费用格式不正确'
		                      }
		            		}
		            },
		        	//开班时间
		            courseStartTime:{
		            	validators: {
		            		notEmpty: {message: '请填写开班时间'},
		            		stringLength: {min: 1,max: 100}
		            		}
                   },
           	       //学习周期
		           coursePeriod:{
		            	validators: {
		            		notEmpty: {message: '请填写学习周期'},
		            		stringLength: {min: 1,max: 100}
		            		}
	                   },
	                //开班LOGO验证
		            file:{
		            	validators: {
		            		notEmpty: {message: '请上传开班LOGO'}
		            		}
                   }, 
            	   	//所属机构
		            pxOrgId:{validators: {notEmpty: {message: '请选择所属机构'}}}
		         }
		     }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                   
                    var courseName=$('#courseName').val().trim();
                    //先判断是否是编辑，如果是,在判断有没有修改开班名称，如果修改就验证名称是否重复
                    var isflag=$('#isFlag').val();
                    if(isflag=="edit"){
                       var editCourseName=$('#editCourseName').val();	
                       if(!(editCourseName==courseName)){
                    	   //验证开班名称是否重复
                    	   var flag= checkCourseName(courseName);
                           if(flag){return false;}
                       }
                    }else{
                         //验证开班名称是否重复
                    	  var flag= checkCourseName(courseName);
                          if(flag){return false;}
                    }
                    
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
	           			    		xfui.open_tabs("开班信息管理","${ctx}/business/dissupport/train/trainCourse/list.xf","开班信息管理"); 
	           			    	}
	                           	closeItem2(); 
                            }
                        })
                        
                    }, 'json');

                });
         //自动生成简拼
         $("#courseName").pinyinAleph(function(data){
    		 $("#aac022").val(data);
    	 });
       }
 
 /**
  * 验证开班名称是否重复
  */
 function checkCourseName(obj){
	   var  isRepeat=false;//不重复
	   var courseName=encodeURI(obj);
	    $.ajax({ url: '${ctx}/business/dissupport/train/trainCourse/checkName.xf',
	    		data:{courseName:courseName},
	    		dataType:'json',
	    		async: false,
	    		success: function(data){
	    			if(data.result==1){
	    				bootbox.alert(data.message);
	    				isRepeat=true;
	    			}
	             }
	    	});
	   return isRepeat;
   }
 
 function isValidateFile(obj){
	 
     var fileValue= $("#file").val();
	  if(!fileValue){
		  bootbox.alert("请选择图片") ;
		  return false;
	  }
	   var extend = fileValue.substring(fileValue.lastIndexOf(".")+1);    
	   if(extend==""){  
		  bootbox.alert("请选择图片") ;
		return false;
	   }else{    
	    if(!(extend=="jpg"||extend=="gif"||extend=="bmp"||extend=="png")){    
	       bootbox.alert("请上传后缀名为jpg/gif/bmp/png的文件!") ;
	       $("#file").val("");
	       return false;    
	    }    
	   }    
	   return true;    
	 }

function ajaxFileUpload(obj) {
	  if(!isValidateFile(obj)){
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
		      $("#imgContext").append("<img  src=\"${fileDirectory}/"+data+"\"  width=\"200\"  height=\"145\"/>")
	     	  $("#courseLogo").val(data);
         },
         error: function(data, status, e){ 
      	   bootbox.alert(e) ;
         }
     });
 } 
 
 function closeItem(){
		var obj=$("#navrightTop>.active>a>i",window.parent.document);
		xfui.closePrivateTab(obj);
	 }
 
 function closeItem2(){
	  xfui.closeTab();
}
 
</script>

<body>
	<div class="main-container mhyBody">
		<div class="container-fluid">
			<div class="mhySearch">
		   		<div class="mhyTitle">开班基本信息</div>
		   		   		
		   		<form:form modelAttribute="trainCourseForm" method="post" action="${ctx}/business/dissupport/train/trainCourse/save.xf">
			   		<form:hidden path="pxCourseId" ></form:hidden>
			   		<form:hidden path="clickTimes" ></form:hidden>
			   		<form:hidden path="isDel"></form:hidden>
			   		<form:hidden path="isAudit"></form:hidden>
			   		<form:hidden path="isDisable"></form:hidden>
			   		<form:hidden path="acb208"></form:hidden>
				    <form:hidden path="aae011"></form:hidden>
				    <form:hidden path="aae017"></form:hidden>
				    <form:hidden path="aae019"></form:hidden>
				    <form:hidden path="aae020"></form:hidden>
				    <form:hidden path="abb767"></form:hidden>
				    <form:hidden path="abb768"></form:hidden>
				    <form:hidden path="abb769"></form:hidden>
				    <form:hidden path="abb770"></form:hidden>
				    <form:hidden path="abb771"></form:hidden>
				    <form:hidden path="abb772"></form:hidden>
				    <form:hidden path="cczy06"></form:hidden>
				    <form:hidden path="aae036"></form:hidden>
				      <!--区分是新增还是编辑 -->
				    <input type="hidden" id="isFlag" name="isFlag" value="${isFlag}"/>
				    <input type="hidden" id="editCourseName" name="editCourseName" value="${editCourseName}"/>
		   			<div class="mhySearchInput mhyInputDiv">
		   				<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>所属机构：</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
									<select class="" id="" name="pxOrgId" >
									    <option value="">--请选择--</option>
										<c:forEach items="${orgList}" var="item">
											 <option value="${item.pxOrgId}" <c:if test="${trainCourseForm.pxOrgId==item.pxOrgId}"> selected='selected' </c:if>> ${item.orgName} </option> 
										</c:forEach>	
									</select>
									<%-- <xf:select textField="org_name" tableName="PX_ORG" name="pxOrgId" value="${trainCourseForm.pxOrgId}" valueField="px_org_id" hasDefault="0"></xf:select> --%>
								</div>

								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>开班名称：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="courseName" value="${trainCourseForm.courseName}" maxlength="25"></form:input>
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">名称简码：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="aac022" value="${trainCourseForm.aac022}" maxlength="20"></form:input>
								</div>	
		   				</div>
		   		
		   				<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>开班类型：</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
									<select class="" id="" name="courseType" >
										    <option value="">--请选择--</option>
											<c:forEach items="${courseTypeList}" var="item">
												 <option value="${item.typeId}" <c:if test="${trainCourseForm.courseType==item.typeId}"> selected='selected' </c:if>> ${item.name} </option> 
											</c:forEach>	
										</select>
								</div>	
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>联系人：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="contactsName" value="${trainCourseForm.contactsName}" maxlength="25"></form:input>
							</div>	
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>联系电话：</label>
							<div class="col-xs-9 col-sm-2">
								<form:input class="form-control" type="text" path="contactsTel" value="${trainCourseForm.contactsTel}"></form:input>
							</div>					
		   			    </div>
		   				
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>培训费用（元）：</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<form:input class="form-control" type="text" path="cost" value="${trainCourseForm.cost}"></form:input>
							</div>	
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>开班时间（例：每月10号开班）：</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<form:input class="form-control" type="text" path="courseStartTime" value="${trainCourseForm.courseStartTime}"></form:input>
							</div>	
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>学习周期（例：三个月）：</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<form:input class="form-control" type="text" path="coursePeriod" value="${trainCourseForm.coursePeriod}" placeholder="学习周期长度不能超出100字" maxlength="100"></form:input>
							</div>	
			   			</div>
			   			
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>开班LOGO：</label>
							<div class="col-xs-2 ">
							  <form:hidden  path="courseLogo" ></form:hidden>
							   <table>
							     <tr>
							       <td>
							        <div id="imgContext">
								       <c:if test="${!empty trainCourseForm.courseLogo}">
		            						<img  id=""  src="${fileDirectory}/${trainCourseForm.courseLogo}"  width="200"  height="145"/>
										</c:if>
									</div>
							       </td>
							       <td>
								        <input type="file" id="file" name="file" onchange="ajaxFileUpload()"><br/>
							       </td>
							     </tr>
							   </table>
							</div> 
						</div>
			   			
		   				<%-- <div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">培训地点:</label>
		   					<div class="col-xs-9 col-sm-10">
									<form:textarea row="5" col="5" style="width:100%;resize:none;" path="courseAddr" placeholder="培训地点长度不能超出100字" value="${trainCourseForm.courseAddr}" maxlength="100"></form:textarea>
								</div>
		   				</div>
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">培训特色:</label>
		   					<div class="col-xs-9 col-sm-10">
									<form:textarea row="5" col="5" style="width:100%;resize:none;" path="courseFeature" placeholder="培训特色长度不能超出100字" value="${trainCourseForm.courseFeature}" maxlength="100"></form:textarea>
								</div>
		   				</div>
		   				 <div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">培训内容:</label>
		   					<div class="col-xs-9 col-sm-10">
									<form:textarea row="5" col="5" style="width:100%;resize:none;" path="courseContent" placeholder="培训内容长度不能超出1000字" value="${trainCourseForm.courseContent}" maxlength="1000"></form:textarea>
								</div>
		   				</div>  --%>
		   				
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">培训地点：</label>
		   					<div class="col-xs-10 col-sm-10">
		   					    <form:input class="form-control" type="text" path="courseAddr" value="${trainCourseForm.courseAddr}" placeholder="培训地点长度不能超出100字" maxlength="100" ></form:input>
						    </div>
		   				</div>
		   				
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">培训特色：</label>
		   					<div class="col-xs-10 col-sm-10">
		   					    <form:input class="form-control" type="text" path="courseFeature" value="${trainCourseForm.courseFeature}" placeholder="培训特色长度不能超出100字" maxlength="100" ></form:input>
						    </div>
		   				</div>
		   				
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">培训介绍：</label>
		   					<div class="col-xs-9 col-sm-10">
									<script type="text/plain" id="myEditor" name="courseContent">${trainCourseForm.courseContent}</script>
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
			   </div>	 </div>  		
		   	</form:form>
		  </div> 
	</div>
</div>  
  
<script type="text/javascript">
		var um = UE.getEditor('myEditor',{
			 toolbars: [[
				 'fullscreen', 'source', '|', 'undo', 'redo', '|',
				 'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
				 'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
				 'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|', 'indent', '|',
				 'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
				 'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
				 'insertframe', 'insertcode', 'pagebreak', 'template',  '|',
				 'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
				 'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
				 'print', 'searchreplace', 'help'
			 ]]
		});
</script> 
  
</body>
</html>
