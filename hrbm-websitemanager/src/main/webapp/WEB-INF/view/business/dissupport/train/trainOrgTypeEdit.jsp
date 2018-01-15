<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>编辑培训类别信息</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@include file="/commons/include/bootstrapInc.jsp" %>
	<script type="text/javascript">
	 $(function(){
		 initFormSubimt();
	 })
	 
     function initFormSubimt(){
         $('#trainOrgTypeForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //机构类别名称
            	    name:{validators: {notEmpty: {
		            	message: '请填写机构类别名称'
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
                       var editTypeName=$('#editOrgTypeName').val().trim();	
                       if(!(editTypeName==typeName)){
                    	   //验证类别名称是否重复
                    	   var flag= checkOrgTypeName(typeName);
                           if(flag){return false;}
                       }
                    }else{
                         //直接验证类别名称是否重复
                    	  var flag= checkOrgTypeName(typeName);
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
            			    		xfui.open_tabs("培训类别管理","${ctx}/business/dissupport/train/trainOrgType/list.xf","培训机构类别信息管理"); 
            			    	}
                            	closeItem2(); 
                            }
                        })
                        
                    }, 'json');

                });
       }
	 
	 /**
	  * 验证机构类别名称是否重复
	  */
	 function checkOrgTypeName(obj){
		   var  isRepeat=false;//不重复
		   var otName=encodeURI(obj);
		    $.ajax({ url: '${ctx}/business/dissupport/train/trainOrgType/checkTypeName.xf',
		    		data:{orgTypeName:otName},
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
		   		<div class="mhyTitle">培训类别信息</div>
                <form:form modelAttribute="trainOrgTypeForm" method="post" action="${ctx}/business/dissupport/train/trainOrgType/save.xf">
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
				     <input type="hidden" id="editOrgTypeName" name="editOrgTypeName" value="${editOrgTypeName}"/>
				     <div class="mhySearchInput mhyInputDiv">
				   				<div class="row">
										<label class="col-xs-3 col-sm-2" for="inputError">上级类别：</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
											<select id="orgType" name="pid" >
											    <option value="">--请选择--</option>
												<c:forEach items="${orgTypeList}" var="item">
													 <option value="${item.typeId}" <c:if test="${trainOrgTypeForm.pid==item.typeId}"> selected='selected' </c:if>> ${item.name} </option>
												</c:forEach>	
										    </select>
										</div>
				
										<label class="col-xs-3 col-sm-2" for="inputError"><i style="color: red;margin-right: 5px;">*</i>机构类别名称：</label>
										<div class="col-xs-9 col-sm-2">
											<form:input class="form-control" type="text" path="name" value="${trainOrgTypeForm.name}" placeholder="机构类别名称长度不能超出100字" maxlength="100"></form:input>
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
				          
				      <!-- <div class="modal-footer">
									<button class="btn btn-sm" data-dismiss="modal" onclick="closeItem()">
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
