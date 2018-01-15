<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑培训机构基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@include file="/commons/include/bootstrapInc.jsp" %>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
</head>
<script type="text/javascript">
 $(function(){
		 initFormSubimt();
	 })
	 
     function initFormSubimt(){
	 	 //格式化注册日期
	 	 var orgEstablishDate= $("#orgEstablishDate").val();
	 	 if(orgEstablishDate){
	 		$("#orgEstablishDate").val(formateDate(orgEstablishDate));
	 	 }
	 	 
         $('#trainOrgForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   	//机构名称
		            orgName:{validators: {
		            	notEmpty: {message: '请填写机构名称'},
		            	stringLength: {min: 2,max: 100}
		            	}
               },
		           	//机构发布名称
			         orgPublishName:{validators: {
			            	notEmpty: {message: '请填写发布名称'},
			            	stringLength: {min: 1,max: 100}
			            	}
		          },
            	   	//机构账号
		            orgAccount:{
		            	validators: {
		            		notEmpty: {message: '请填写机构账号'},
		            		stringLength: {min: 2,max: 25},
		            		regexp: {
		                        regexp:/[a-zA-Z0-9_]*/,
		                        message: '账号只能包括英文字母、数字和下划线'
		                      }
		            		}
		            },
		         	//机构密码
		            orgPwd:{validators: {
		            	notEmpty: {message: '请填写机构密码'},
		            	stringLength: {min: 6,max: 18,message: '密码长度必须在6到18位之间'},
		            	regexp: {
	                        regexp:/\w{5,17}$/,
	                        message: '密码只能包含字符、数字和下划线'
	                      }
		            	}
		            },
		            //联系人
		            contactsName:{
		            	validators: { 
		            	  notEmpty: {message: '请填写联系人'},
		            	  stringLength: {min: 2,max: 25}
		            	}
		            },
		            //手机号
		            contactsTel:{
		            	validators: {
		            		notEmpty: {message: '请填写手机号'},
		            		regexp: {
		                        regexp: /^1[3|4|5|7|8]\d{9}$/,
		                        message: '手机号格式不正确'
		                      }
		            		}
		            },
		           //邮箱格式验证
		            orgEmail:{
		            	validators: {
		            		regexp: {
		                        regexp: /[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}/,
		                        message: '邮箱格式不正确'
		                      }
		            		}
		            },
		            //机构证件号验证
		            orgCertificateId:{
		            	validators: {
		            		notEmpty: {message: '请填写机构证件号'},
		            		regexp: {
		                        regexp: /^[0-9]+$/ ,
		                        message: '机构证件号格式不正确'
		                      }
		            	}
		            },
		            //法人身份证号验证
		            orgLegalPersonId:{
		            	validators: {
		            		notEmpty: {message: '请填写法人身份证号'},
		            		regexp: {
		                        regexp: /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/,
		                        message: '身份证号格式不正确'
		                      }
		            		}
		            },
		            //机构地址验证
		            orgAddr:{
		            	validators: { 
		            	  stringLength: {min: 1,max: 100}
		            	}
		            },
		            //经营范围验证
		            orgManageRange:{
		            	validators: { 
		            	  stringLength: {min: 1,max: 1000}
		            	}
		            },
		            
		          /*   //行政区划验证
		            orgAdminDivision:{
		            	validators: {
		            		regexp: {
		                        regexp:/^[0-9]{6}$/ ,
		                        message: '邮政编码格式不正确'
		                      }
		            		}
		            }, */
		          //机构简码验证
		            aac022:{
		            	validators: {
		            		regexp: {
		                        regexp: /^[a-zA-Z0-9]+$/,
		                        message: '机构简码格式不正确'
		                      }
		            		}
		            },
		           //机构证件图验证
		            orgCertificate:{
		            	validators: { 
		            	  notEmpty: {message: '请上传机构证件'}
		            	}
		            },
		           //身份证正面照验证
		            orgLegalPersonZphoto:{
		            	validators: { 
		            	  notEmpty: {message: '请上传法人身份证正面照'}
		            	}
		            },
			       //身份证反面照验证
		            orgLegalPersonFphoto:{
		            	validators: { 
		            	  notEmpty: {message: '请上传法人身份证反面照'}
		            	}
		            },
		            //机构类别验证
		            orgType:{validators: {notEmpty: {message: '请选择机构类别'}}}
		         }
		     }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
             /*        var orgAccount=$('#orgAccount').val().trim();
                    var orgName=$('#orgName').val().trim();
                    //先判断是否是编辑，如果是在判断有没有修改账号，如果修改就验证账号是否重复
                    var isflag=$('#isFlag').val();
                    if(isflag=="edit"){
                       var editAccount=$('#editAccount').val();	
                       var editName=$('#editOrgName').val();	
                       if(!(editAccount==orgAccount)){
                    	   //验证培训机构账号是否重复
                    	   var flag= checkAccount(orgAccount);
                           if(flag){return false;}
                       }
                       
                       if(!(editName==orgName)){
                    	   //验证机构名称是否重复
                    	   var flag2= checkOrgName(orgName);
                           if(flag2){return false;}
                       }
                       
                    }else{
                    	 //验证培训机构账号是否重复
                    	 var flag= checkAccount(orgAccount);
                         if(flag){return false;}
                         //验证机构名称是否重复
                  	     var flag2= checkOrgName(orgName);
                         if(flag2){return false;}
                    } */
                  
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                          $(".btn-submit").removeAttr("disabled");
                        //  bootbox.alert(data.message);
                           
                          bootbox.alert({ 
                              size: 'small',
                              width:"100px",
                              message: data.message, 
                              callback: function(){ 
                              xfui.open_tabs("培训机构信息管理","${ctx}/business/dissupport/train/trainOrg/per/edit.xf?orgId=${orgId}","培训机构信息管理");
  	                           /* 	var parentIframe=xfui.getParentIframe();
  	           			    	if(parentIframe){
  	           			    		parentIframe.refresh();
  	           			    	   // xfui.open_tabs("培训机构信息管理","${ctx}/business/dissupport/train/trainOrg/per/list.xf","培训机构信息管理"); 
  	           			    	} */
  	                           //	closeItem2(); 
                              }
                          }) 
                          
                      }, 'json'); 
                });
         //自动生成简拼
         $("#orgPublishName").pinyinAleph(function(data){
    		 $("#aac022").val(data);
    	 });
       }
 /**
  * 验证机构账号是否重复
  */
 function checkAccount(obj){
	   var  isRepeat=false;//不重复
	    $.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/per/check.xf',
	    		data:{orgAccount:obj},
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
 
 /**
  * 验证机构名称是否重复
  */
 function checkOrgName(obj){
	   var  isRepeat=false;//不重复
	   var orgName=encodeURI(obj);
	    $.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/per/checkName.xf',
	    		data:{orgName:orgName},
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
	 
      var fileValue= $("#file"+obj).val();
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
          fileElementId: 'file'+obj, // 上传文件的id、name属性名
          dataType: 'text', //返回值类型，一般设置为json、application/json
          elementIds: elementIds, //传递参数到服务器
          success: function(data, status){  
        	  
        	  $("#imgContext"+obj).empty() ;   		 
		      $("#imgContext"+obj).append("<img  src=\"${fileDirectory}/"+data+"\"  width=\"200\"  height=\"145\"/>")
	       	  if(obj=="1"){
	     		 $("#orgLogoDir").val(data);
	       	  }
	       	  if(obj=="2"){
	     		 $("#orgCertificate").val(data);
	       	  }
	          if(obj=="3"){
	     		 $("#orgLegalPersonZphoto").val(data);
	       	  }
	       	  if(obj=="4"){
	     		 $("#orgLegalPersonFphoto").val(data);
	       	  }
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
		   		<div class="mhyTitle">培训机构基本信息</div>
		   		<form:form modelAttribute="trainOrgForm" method="post" action="${ctx}/business/dissupport/train/trainOrg/per/save.xf">
			   		<form:hidden path="pxOrgId"></form:hidden>
			   		<form:hidden path="isDel"></form:hidden>
			   		<form:hidden path="isAudit"></form:hidden>
			   		<form:hidden path="isDisable"></form:hidden>
				    <form:hidden path="aae011"></form:hidden>
				    <form:hidden path="aae017"></form:hidden>
				    <form:hidden path="aae019"></form:hidden>
				    <form:hidden path="aae020"></form:hidden>
				    <form:hidden path="aae036"></form:hidden>
				    <form:hidden path="abb767"></form:hidden>
				    <form:hidden path="abb768"></form:hidden>
				    <form:hidden path="abb769"></form:hidden>
				    <form:hidden path="abb770"></form:hidden>
				    <form:hidden path="abb771"></form:hidden>
				    <form:hidden path="abb772"></form:hidden>
				    <form:hidden path="cczy06"></form:hidden>
				    <!--区分是新增还是编辑 -->
				    <input type="hidden" id="isFlag" name="isFlag" value="${isFlag}"/>
				    <input type="hidden" id="editAccount" name="editAccount" value="${editAccount}"/>
				    <input type="hidden" id="editOrgName" name="editOrgName" value="${editOrgName}"/>
		   			<div class="mhySearchInput mhyInputDiv" >
		   					<div class="row">
		   					
								<label class="col-xs-3 col-sm-2" for="inputError">机构名称:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgName" value="${trainOrgForm.orgName}" maxlength="100" readonly="true"></form:input>
								</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError">发布名称:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgPublishName" value="${trainOrgForm.orgPublishName}" maxlength="100" readonly="true"></form:input>
								</div>

								<label class="col-xs-3 col-sm-2" for="inputError">机构类别:</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
								    <select class="" id="orgType" name="orgType">
										<c:forEach items="${orgTypeList}" var="item">
											<c:if test="${trainOrgForm.orgType==item.typeId}">
												<option value="${item.typeId}"  <c:if test="${trainOrgForm.orgType==item.typeId}"> selected='selected' </c:if>> ${item.name} </option>
											</c:if>
										</c:forEach>	
									 </select>
								</div>
							</div>
														
		   					<div class="row">	
		   					
		   					    <label class="col-xs-3 col-sm-2" for="inputError">机构账号:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgAccount" value="${trainOrgForm.orgAccount}" maxlength="25" readonly="true"></form:input>
								</div>
		   					
		   					    <label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构密码:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgPwd" value="${trainOrgForm.orgPwd}" maxlength="25" ></form:input>
								</div>	
		   					
								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>联系人:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="contactsName" value="${trainOrgForm.contactsName}" maxlength="50" ></form:input>
								</div>
		   			    	</div>
		   			    	
		   			    	<div class="row">
		   			    	
		   			    	    <label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>手机号:</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="contactsTel" value="${trainOrgForm.contactsTel}" maxlength="11" ></form:input>
								</div>
								
				   				<label class="col-xs-3 col-sm-2" for="inputError">机构邮箱:</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
									<form:input class="form-control" type="text" path="orgEmail" value="${trainOrgForm.orgEmail}"></form:input>
								</div>	
								
								<label class="col-xs-3 col-sm-2" for="inputError">机构证件号:</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
									<form:input class="form-control" type="text" path="orgCertificateId" value="${trainOrgForm.orgCertificateId}" placeholder="机构证件长度不能超出100字" maxlength="100" readonly="true"></form:input>
								</div>	
							</div>
		   			      
			   			<div class="row">
			   			    <label class="col-xs-3 col-sm-2" for="inputError">法人身份证:</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<form:input class="form-control" type="text" path="orgLegalPersonId" value="${trainOrgForm.orgLegalPersonId}" maxlength="18" readonly="true"></form:input>
							</div>	
							
			   				<label class="col-xs-3 col-sm-2" for="inputError">机构简码:</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<form:input class="form-control" type="text" path="aac022" value="${trainOrgForm.aac022}" maxlength="20"></form:input>
							</div>	
							
							<label class="col-xs-3 col-sm-2" for="inputError">注册日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control date-picker dp" path="orgEstablishDate" type="text" value="${trainOrgForm.orgEstablishDate}" placeholder="请选择日期" readonly="true"/>
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
			   			</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError">行政区划:</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<%-- <form:input class="form-control" type="text" path="orgAdminDivision" value="${trainOrgForm.orgAdminDivision}" readonly="true"></form:input> --%>
							    <form:hidden path="orgAdminDivision"></form:hidden>
								<form:input class="form-control" type="text" path="orgAdminDivisionn" value="${trainOrgForm.orgAdminDivisionn}" readonly="true"></form:input>
							</div>
						</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError">机构LOGO:</label>
							<div class="col-xs-2 ">
							  <form:hidden  path="orgLogoDir" ></form:hidden>
							   <table>
							     <tr>
							       <td>
							        <div id="imgContext1">
								       <c:if test="${!empty trainOrgForm.orgLogoDir}">
		            						<img  id=""  src="${fileDirectory}/${trainOrgForm.orgLogoDir}"  width="200"  height="145"/>
										</c:if>
									</div>
							       </td>
							       <td>
								       <!--  <input type="file" id="file1" name="file1" onchange="ajaxFileUpload('1')"><br/> -->
							       </td>
							     </tr>
							   </table>
							</div> 
							
							<label class="col-xs-3 col-sm-2" for="inputError">机构证件:</label>
							<div class="col-xs-2 ">
							  <form:hidden  path="orgCertificate" ></form:hidden>
							   <table>
							     <tr>
							       <td>
							        <div id="imgContext2">
								       <c:if test="${!empty trainOrgForm.orgCertificate}">
		            						<img  id="" src="${fileDirectory}/${trainOrgForm.orgCertificate}"  width="200"  height="145"/>
										</c:if>
									</div>
							       </td>
							       <td>
								        <!-- <input type="file" id="file2" name="file2" onchange="ajaxFileUpload('2')"><br/> -->
							       </td>
							     </tr>
							   </table>
							</div>
							
			   			</div>
			   			
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError">身份证正面照:</label>
							<div class="col-xs-2 ">
							  <form:hidden  path="orgLegalPersonZphoto" ></form:hidden>
							   <table>
							     <tr>
							       <td>
							        <div id="imgContext3">
								       <c:if test="${!empty trainOrgForm.orgLegalPersonZphoto}">
		            						<img  id="" src="${fileDirectory}/${trainOrgForm.orgLegalPersonZphoto}"  width="200"  height="145"/>
										</c:if>
									</div>
							       </td>
							       <td>
								        <!-- <input type="file" id="file3" name="file3" onchange="ajaxFileUpload('3')"><br/> -->
							       </td>
							     </tr>
							   </table>
							</div> 
							
							<label class="col-xs-3 col-sm-2" for="inputError">身份证反面照:</label>
							<div class="col-xs-2 ">
							  <form:hidden  path="orgLegalPersonFphoto" ></form:hidden>
							   <table>
							     <tr>
							       <td>
							        <div id="imgContext4">
								       <c:if test="${!empty trainOrgForm.orgLegalPersonFphoto}">
		            						<img  id="" src="${fileDirectory}/${trainOrgForm.orgLegalPersonFphoto}"  width="200"  height="145"/>
										</c:if>
									</div>
							       </td>
							       <td>
								       <!--  <input type="file" id="file4" name="file4" onchange="ajaxFileUpload('4')"><br/> -->
							       </td>
							     </tr>
							   </table>
							</div>
							
			   			</div>
			   			
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">机构地址:</label>
		   					<div class="col-xs-10 col-sm-10">
		   					    <form:input class="form-control" type="text" path="orgAddr" value="${trainOrgForm.orgAddr}" placeholder="地址长度不能超出100字" maxlength="100" ></form:input>
						    </div>
		   				</div>
		   				
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">机构介绍:</label>
		   					<div class="col-xs-9 col-sm-10">
									<script type="text/plain" id="myEditor" name="orgManageRange">${trainOrgForm.orgManageRange}</script>
								</div>
		   				</div>
		   				
		   				<div style="text-align:center;margin-top:20px;">
		   					<button class="btn btn-primary" type="submit">
								<i class="icon-save"></i>
								保存
					        </button>
		   				</div>
		   		</div>
		   			
<!-- 		   		<div class="modal-footer">
					<button class="btn btn-sm" type="button" onclick="closeItem()">
						<i class="icon-remove"></i>
						关闭
					</button>
					<button class="btn btn-sm btn-primary" type="submit">
						<i class="icon-ok"></i>
						保存
					</button>
			   </div>	 -->   		
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
		 'simpleupload', 'insertimage', 'emotion', 'insertvideo', 'music','attachment', 'map', 'insertframe', 'insertcode', 'pagebreak', 'template',  '|',
		 'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
		 'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
		 'print', 'searchreplace', 'help'
	 ]]
});

  jQuery(function($) {
 		// 日期选择
      $(".mhydatepicker").datetimepicker({
          todayBtn: true,
          format: "yyyy-mm-dd",
          startView: 2,
          minView: 2,
          language: 'cn',
          maxView: "decade",
          viewSelect: 2,
          autocomplete:true,
          autoclose:true
      });

    });
</script> 

</body>
</html>
