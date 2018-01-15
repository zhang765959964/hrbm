<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑开班类别基本信息</title>
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
         $('#trainCourseTypeForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //机构类别名称
            	    name:{validators: {notEmpty: {
		            	message: '请填写开班类别名称'
		            },stringLength: {min: 1,max: 100}}}
              }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    
                    var typeName=$('#name').val().trim();
                    //先判断是否是编辑，如果是,在判断有没有修改类别名称，如果修改就验证名称是否重复
                    var isflag=$('#isFlag').val();
                    if(isflag=="edit"){
                       var editTypeName=$('#editCourseTypeName').val().trim();	
                       if(!(editTypeName==typeName)){
                    	   //验证类别名称是否重复
                    	   var flag= checkCourseTypeName(typeName);
                           if(flag){return false;}
                       }
                    }else{
                         //直接验证类别名称是否重复
                    	  var flag= checkCourseTypeName(typeName);
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
            			    		xfui.open_tabs("开班类别管理","${ctx}/business/dissupport/train/trainCourseType/list.xf","开班类别信息管理"); 
            			    	}
                            	closeItem2(); 
                            }
                        })
                        
                    }, 'json');

                });
       }
	 
	 
	 /**
	  * 验证开班类别名称是否重复
	  */
	 function checkCourseTypeName(obj){
		   var  isRepeat=false;//不重复
		   var ctName=encodeURI(obj);
		    $.ajax({ url: '${ctx}/business/dissupport/train/trainCourseType/checkTypeName.xf',
		    		data:{courseTypeName:ctName},
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
	
	 function closeItem(){
			var obj=$("#navrightTop>.active>a>i",window.parent.document);
			xfui.closePrivateTab(obj);
		 }
	 
	 function closeItem2(){
		  xfui.closeTab();
	 }
</script>
</head>
<body>
<div class="main-container">
		<div class="container-fluid">
			<div class="mhySearch">
		   		<div class="mhyTitle">开班类别信息</div>
				<form:form modelAttribute="trainCourseTypeForm" method="post" action="${ctx}/business/dissupport/train/trainCourseType/save.xf">
				     <form:hidden path="typeId"></form:hidden> 
				     <form:hidden path="isDel"></form:hidden>
				     <form:hidden path="aae011"></form:hidden>
				     <form:hidden path="aae017"></form:hidden>
				     <form:hidden path="aae019"></form:hidden>
				     <form:hidden path="aae020"></form:hidden>
				     <form:hidden path="cczy06"></form:hidden>
				     <form:hidden path="aae036"></form:hidden>
				      <!--区分是新增还是编辑 -->
				     <input type="hidden" id="isFlag" name="isFlag" value="${isFlag}"/>
				     <input type="hidden" id="editCourseTypeName" name="editCourseTypeName" value="${editCourseTypeName}"/>
				     <div class="mhySearchInput mhyInputDiv" style="padding: 15px 80px 60px 15px;">
				   				<div class="row">
										<label class="col-xs-3 col-sm-2" for="inputError">上级类别：</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
									        <select class="" id="pid" name="pid" >
											    <option value="">--请选择--</option>
												<c:forEach items="${courseTypeList}" var="item">
													 <option value="${item.typeId}" <c:if test="${trainCourseTypeForm.pid==item.typeId}"> selected='selected' </c:if>> ${item.name} </option> 
												</c:forEach>	
											</select>
											<%-- <xf:select textField="name" tableName="PX_COURSE_TYPE" name="pid" value="${trainCourseTypeForm.pid }" valueField="type_id"  hasDefault="0" id="courseType"></xf:select> --%>
										</div>
				
										<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>开班类别名称：</label>
										<div class="col-xs-9 col-sm-2">
											<form:input class="form-control" type="text" path="name" value="${trainCourseTypeForm.name}" placeholder="开班类别名称长度不能超出100字" maxlength="100"></form:input>
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
				    <!--  <div class="modal-footer">
								<button class="btn btn-sm" type="button" onclick="closeItem()">
									<i class="icon-remove"></i>
									关闭
								</button>
								<button class="btn btn-sm btn-primary" type="submit">
									<i class="icon-ok"></i>
									保存
								</button>
					</div> -->
				          
				 </form:form>
		   </div>
		</div>
    </div>
</body>
</html>
