<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑培训机构信息</title>
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
	     var cpX ='${trainOrgForm.cabq02}';
         var cpY ='${trainOrgForm.cabq03}';
		 initFormSubimt();
		 //行政区划绑定组件
		 $("#orgAdminDivisionn").selcity({callBack:function(data){
			    $("#orgAdminDivisionn").val(data.allname);
				$("#orgAdminDivision").val(data.code);
					if (data.allname!= ""){
		                $('#trainOrgForm')
		               .data('bootstrapValidator')
		               .updateStatus('orgAdminDivisionn','VALID', null)
		               .validateField('orgAdminDivisionn');
		             }
			   }
			});
		 //机构logo 验证
		 var file1=$('#orgLogoDir').val();
		 if (file1!= ""){
             $('#trainOrgForm')
            .data('bootstrapValidator')
            .updateStatus('file1','VALID', null)
            .validateField('file1');
          }
		 //机构证件
		 var file2=$('#orgCertificate').val();
		 if (file2!= ""){
             $('#trainOrgForm')
            .data('bootstrapValidator')
            .updateStatus('file2','VALID', null)
            .validateField('file2');
          }
		 //身份证正面照
		 var file3=$('#orgLegalPersonZphoto').val();
		 if (file3!= ""){
             $('#trainOrgForm')
            .data('bootstrapValidator')
            .updateStatus('file3','VALID', null)
            .validateField('file3');
          }
		 //身份证反面照
		 var file4=$('#orgLegalPersonFphoto').val();
		 if (file4!= ""){
             $('#trainOrgForm')
            .data('bootstrapValidator')
            .updateStatus('file4','VALID', null)
            .validateField('file4');
          }
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
		            
		           //行政区划验证
		            orgAdminDivisionn:{
		            	validators: {
		            		notEmpty: {message: '请选择行政区划'}
		            		}
		            },  
		          //机构简码验证
		            aac022:{
		            	validators: {
		            		regexp: {
		                        regexp: /^[a-zA-Z0-9]+$/,
		                        message: '机构简码格式不正确'
		                      }
		            		}
		            },
		            //机构LOGO验证
		            file1:{
		            	validators: { 
		            	  notEmpty: {message: '请上传机构LOGO图'}
		            	}
		            },
		           //机构证件图验证
		            file2:{
		            	validators: { 
		            	  notEmpty: {message: '请上传机构证件'}
		            	}
		            },
		           //身份证正面照验证
		            file3:{
		            	validators: { 
		            	  notEmpty: {message: '请上传法人身份证正面照'}
		            	}
		            },
			       //身份证反面照验证
		            file4:{
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
                    
                    var orgAccount=$('#orgAccount').val().trim();
                    var orgName=$('#orgName').val().trim();
                    var orgPublishName=$('#orgPublishName').val().trim();
                    //先判断是否是编辑，如果是在判断有没有修改账号，如果修改就验证账号是否重复
                    var isflag=$('#isFlag').val();
                    if(isflag=="edit"){
                       var editAccount=$('#editAccount').val();	
                       var editName=$('#editOrgName').val();
                       var editOrgPublishName=$('#editOrgPublishName').val();
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
                       
                       if(!(editOrgPublishName==orgPublishName)){
                    	   //验证机构发布名称是否重复
                    	   var flag3= checkOrgPublishName(orgPublishName);
                           if(flag3){return false;}
                       }
                       
                    }else{
                    	 //验证培训机构账号是否重复
                    	 var flag= checkAccount(orgAccount);
                         if(flag){return false;}
                         //验证机构名称是否重复
                  	     var flag2= checkOrgName(orgName);
                         if(flag2){return false;}
                         //验证机构发布名称是否重复
                         var flag3= checkOrgPublishName(orgPublishName);
                         if(flag3){return false;}
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
  	           			    	    xfui.open_tabs("培训机构维护","${ctx}/business/dissupport/train/trainOrg/list.xf","培训机构信息管理"); 
  	           			    	}
  	                           	closeItem2(); 
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
	    $.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/check.xf',
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
	    $.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/checkName.xf',
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
 
 /**
  * 验证机构发布名称是否重复
  */
 function checkOrgPublishName(obj){
	   var  isRepeat=false;//不重复
	   var orgPublishName=encodeURI(obj);
	    $.ajax({ url: '${ctx}/business/dissupport/train/trainOrg/checkPublishName.xf',
	    		data:{orgPublishName:orgPublishName},
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
	       $("#file"+obj).val("");
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
 
//地图显示隐藏
 function selectClick(){
 	var corpName=$("#orgPublishName").val();
 	var corpAddress=$("#orgAddr").val();
 	if(corpName==""){
 		bootbox.alert("请先填写机构发布名称");
 	}else{
 		if(corpAddress==""){
 			bootbox.alert("请填写机构地址");
 		}else{
 			$(".mapContent").toggle();
 			if($(".mapContent").attr("display")=="none")
 			{
 				$("body").css({"overflow-y":"hidden"});
 			}
 			else{
 				$("body").css({"overflow-y":"auto"});
 			}
 		}
 	}
 }
 //关闭地图
 function closeClick(){
 	$(".mapContent").hide();
 	$("body").css({"overflow-y":"auto"});
 	$("#corpX").val(cpX);
 	$("#corpY").val(cpY);	
 }
</script>

<style type="text/css">
.mhyCorpSearchValue{display:none;}
.mhycorp:hover .mhyCorpSearchValue{display:block;}
.mapContent{display:none;}
.mapDiv{ bottom: 20px;height: 90%;left: 6%;position: fixed;top: 30px;width: 90%;z-index: 1000;}
.mapDiv .alert-success{margin-bottom:0;padding-bottom:0px !important;}
.mapDivBg{background:rgba(0,0,0,0.8);position: fixed;top:0;left:0;right:0;bottom:0;z-index:10;}
.mapDiv .close{margin-right:20px;}}
</style>

<body>
	<div class="main-container mhyBody">
		<div class="container-fluid">
			<div class="mhySearch">
		   		<div class="mhyTitle">培训机构信息</div>
		   		<form:form modelAttribute="trainOrgForm" method="post" action="${ctx}/business/dissupport/train/trainOrg/save.xf">
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
				     <input type="hidden" id="editOrgPublishName" name="editOrgPublishName" value="${editOrgPublishName}"/>
		   			<div class="mhySearchInput mhyInputDiv" >
		   					<div class="row">
		   					
								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构名称：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgName" value="${trainOrgForm.orgName}" maxlength="100"></form:input>
								</div>
								
								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>发布名称：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgPublishName" value="${trainOrgForm.orgPublishName}" maxlength="100"></form:input>
								</div>

								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构类别：</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
								    <select class="" id="" name="orgType" >
									    <option value="">--请选择--</option>
										<c:forEach items="${orgTypeList}" var="item">
											 <option value="${item.typeId}"  <c:if test="${trainOrgForm.orgType==item.typeId}"> selected='selected' </c:if>> ${item.name} </option>
										</c:forEach>	
									 </select>
								</div>
							</div>
														
		   					<div class="row">	
		   					
		   					    <label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构账号：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgAccount" value="${trainOrgForm.orgAccount}" maxlength="25" ></form:input>
								</div>
		   					
		   					    <label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构密码：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="orgPwd" value="${trainOrgForm.orgPwd}" maxlength="25" ></form:input>
								</div>	
		   					
								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>联系人：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="contactsName" value="${trainOrgForm.contactsName}" maxlength="50" ></form:input>
								</div>
		   			    	</div>
		   			    	
		   			    	<div class="row">
		   			    	
		   			    	    <label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>手机号：</label>
								<div class="col-xs-9 col-sm-2">
									<form:input class="form-control" type="text" path="contactsTel" value="${trainOrgForm.contactsTel}" maxlength="11" ></form:input>
								</div>
								
				   				<label class="col-xs-3 col-sm-2" for="inputError">机构邮箱：</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
									<form:input class="form-control" type="text" path="orgEmail" value="${trainOrgForm.orgEmail}"></form:input>
								</div>	
								
								<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构证件号：</label>
								<div class="col-xs-9 col-sm-2 mhyNoSelect">
									<form:input class="form-control" type="text" path="orgCertificateId" value="${trainOrgForm.orgCertificateId}" placeholder="机构证件长度不能超出100字" maxlength="100"></form:input>
								</div>	
							</div>
		   			      
			   			<div class="row">
			   			    <label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>法人身份证：</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<form:input class="form-control" type="text" path="orgLegalPersonId" value="${trainOrgForm.orgLegalPersonId}" maxlength="18" ></form:input>
							</div>	
							
			   				<label class="col-xs-3 col-sm-2" for="inputError">机构简码：</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
								<form:input class="form-control" type="text" path="aac022" value="${trainOrgForm.aac022}" maxlength="20"></form:input>
							</div>	
							
							<label class="col-xs-3 col-sm-2" for="inputError">注册日期：</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control date-picker dp mhydatepicker" path="orgEstablishDate" type="text" value="${trainOrgForm.orgEstablishDate}" placeholder="请选择日期" />
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
							</div>
			   			</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>行政区划：</label>
							<div class="col-xs-9 col-sm-2 mhyNoSelect">
							    <form:hidden path="orgAdminDivision"></form:hidden>
								<form:input class="form-control" type="text" path="orgAdminDivisionn" value="${trainOrgForm.orgAdminDivisionn}"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">地图：</label>
							<div class="col-xs-9 col-sm-2">
							    <form:hidden id="corpX" path="cabq02" ></form:hidden>
							    <form:hidden id="corpY" path="cabq03" ></form:hidden>
							    <a href="javascript:void(0)" id="mySelect" onclick="selectClick()">地图标记</a>
							</div>
						</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构LOGO：</label>
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
								        <input type="file" id="file1" name="file1" onchange="ajaxFileUpload('1')"><br/>
							       </td>
							     </tr>
							   </table>
							</div> 
							
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构证件：</label>
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
								        <input type="file" id="file2" name="file2" onchange="ajaxFileUpload('2')"><br/>
							       </td>
							     </tr>
							   </table>
							</div>
							
			   			</div>
			   			
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>身份证正面照：</label>
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
								        <input type="file" id="file3" name="file3" onchange="ajaxFileUpload('3')"><br/>
							       </td>
							     </tr>
							   </table>
							</div> 
							
							<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>身份证反面照：</label>
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
								        <input type="file" id="file4" name="file4" onchange="ajaxFileUpload('4')"><br/>
							       </td>
							     </tr>
							   </table>
							</div>
							
			   			</div>
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">机构地址：</label>
		   					<div class="col-xs-10 col-sm-10">
		   					    <form:input class="form-control" type="text" path="orgAddr" value="${trainOrgForm.orgAddr}" placeholder="地址长度不能超出100字" maxlength="100" ></form:input>
						    </div>
		   				</div>
		   				
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">机构介绍：</label>
		   					<div class="col-xs-9 col-sm-10">
									<script type="text/plain" id="myEditor" name="orgManageRange">${trainOrgForm.orgManageRange}</script>
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
			   </div>	
		   		</div>
		   			
   		
		   	</form:form>
		  </div> 
	</div>
</div>  

<div class="h50">&nbsp;</div>
<div class="mapContent">
	<div class="mapDivBg"  onclick="selectClick()"></div>
<div class="mapDiv">

	<div class="alert alert-success" role="alert">
		<form id="fmmachine" method="post" class="form-horizontal">
			<div class="form-group">
				<div class="col-sm-6">
					<span class="btn btn-success" onclick="selectClick()">确认选择</span>
				</div>
				<span class="close"  onclick="closeClick()">关闭</span>
			</div>
		</form>
	</div>
<div class="container-fluid" id="map" style="height:90%;"></div>	
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

<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=l5kCK1PnCuM4Tavr03T6aZx9"></script>
<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
<script type="text/javascript">
	
	$(function(){
			add_control();
			mySelect();
		});
		 // 百度地图API功能
		function G(id) {
			return document.getElementById(id);
		}
		var opts = {
				width : 200,     // 信息窗口宽度
				height: 100,     // 信息窗口高度
				title : '${trainOrgForm.orgPublishName}' , //信息窗口标题
				enableMessage:true,//设置允许信息窗发送短息
				message:'联系地址'
			}
		var infoWindow = new BMap.InfoWindow("地址："+"${trainOrgForm.orgAddr}", opts);  // 创建信息窗口对象
		var map = new BMap.Map("map");          // 创建地图实例
		var point = new BMap.Point(115.02595,35.772036);  // 创建点坐标
		var marker = new BMap.Marker(point);
		marker.addEventListener("click", function(){
			
			map.openInfoWindow(infoWindow, point); //开启信息窗口
		});
		var zoom=15;
		<c:if test="${!empty trainOrgForm.cabq02}">
		point = new  BMap.Point(${trainOrgForm.cabq02}, ${trainOrgForm.cabq03});
		newMarker(point);
		map.openInfoWindow(infoWindow, point); //开启信息窗口
		</c:if>  
		map.centerAndZoom(point, zoom);
		map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

		var top_left_control = new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT});// 左上角，添加比例尺
		var top_left_navigation = new BMap.NavigationControl();  //左上角，添加默认缩放平移控件
		function add_control(){
			map.addControl(top_left_control);
			map.addControl(top_left_navigation);
		}
		var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
				{"input" : "suggestId"
					,"location" : map
				});
		ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
			var str = "";
			var _value = e.fromitem.value;
			var value = "";
			if (e.fromitem.index > -1) {
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}
			str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;

			value = "";
			if (e.toitem.index > -1) {
				_value = e.toitem.value;
				value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			}
			str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
			G("searchResultPanel").innerHTML = str;
		});

		var myValue;
		ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
			var _value = e.item.value;
			myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
			G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

			setPlace();
		});
		function setPlace(){
			map.clearOverlays();    //清除地图上所有覆盖物
			function myFun(){debugger;
				point = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
				map.centerAndZoom(point, 18);
				marker = new BMap.Marker(point);
				map.addOverlay(marker);    //添加标注
				//
				
				map.openInfoWindow(infoWindow, point); //开启信息窗口
			}
			var local = new BMap.LocalSearch(map, { //智能搜索
				onSearchComplete: myFun
			});
			local.search(myValue);
		}
		//自己选择位置
		var myPushpin;
		function mySelect(){ 
				$("#mySelect").on("click",function(e){ 
					var mapTitle= $("#orgPublishName").val();
					var mapMessage= $("#orgAddr").val(); 
					if(mapTitle){
						opts.title=mapTitle;
					}
					mapMessage= mapMessage?mapMessage:"${trainOrgForm.orgPublishName}";
					infoWindow = new BMap.InfoWindow("地址："+mapMessage, opts);  // 创建信息窗口对象
					e.preventDefault();
					myPushpin = new BMapLib.MarkerTool(map,{autoClose: false, followText: ""})         // 创建标注工具实例
					myPushpin.addEventListener("markend", function(ee){  // 监听事件，提示标注点坐标信息
						map.removeOverlay(marker);    //清除地图上所有覆盖物
						point = ee.marker.point;
						marker = ee.marker;
						map.openInfoWindow(infoWindow, point); //开启信息窗口.
						ee.marker.addEventListener("click", function(){
							map.openInfoWindow(infoWindow, point); //开启信息窗口
						});
						var markerPosition = marker.getPosition();
						x=markerPosition["lng"];
						y=markerPosition["lat"];
						$("#corpX").val(x);
						$("#corpY").val(y);
					});
					myPushpin.open();
				});
		};
		function newMarker(point){
			map.clearOverlays();    //清除地图上所有覆盖物
			map.openInfoWindow(infoWindow, point);
			marker = new BMap.Marker(point);
			map.addOverlay(marker);
			marker.addEventListener("click", function(){
				map.openInfoWindow(infoWindow, point); //开启信息窗口
			});
		}
		
	</script>
	<script src="${ctx}/js/lib/map/MarkerTool_min.js"></script>

</body>
</html>
