<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 个人工作经历表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<%@include file="/commons/include/bootstrapInc.jsp" %>
	<script type="text/javascript">
	 $(function(){
		 initFormSubimt();
		 $("#aae030").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "personWorkExpceForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	     });
		 $("#aae031").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "personWorkExpceForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	     });
		 $("#aac0ba").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "personWorkExpceForm",
			  "opens":"right",
			  "drops": "up",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	     });
	 })
     function initFormSubimt(){
         $('#personWorkExpceForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //工作单位
                   aac045: {
                       validators: { notEmpty: { message: '请填写工作单位' },
                           stringLength: { min: 2, max: 50 }
                       }
                   },
                   //执业资格情况
                   aac0b2: {
                       validators: {stringLength: { min: 0, max: 25 ,message: '最多输入25个汉字'}
                       }
                   },
                  //岗位
                   aac0b3: {
                       validators: {stringLength: { min: 0, max: 25 ,message: '最多输入25个汉字'}
                       }
                   },
                   //主要工作内容
                   aac0b4: {
                       validators: {stringLength: { min: 0, max: 250 ,message: '最多输入250个汉字'}
                       }
                   },
                  //成绩及奖惩
                   aac0b5: {
                       validators: {stringLength: { min: 0, max: 50 ,message: '最多输入50个汉字'}
                       }
                   },
                  //在职培训情况
                   aac0b7: {
                       validators: {stringLength: { min: 0, max: 50 ,message: '最多输入50个汉字'}
                       }
                   },
                   //工作年月起
                   aae030: {
                	   validators: {  
                		     notEmpty: { message: '请填写工作年月起' },
				             date: {
		                         format: 'YYYY-MM-DD',
		                         message: '请输入正确的时间格式'
		                     },
	              			 callback: {
	              					message: '工作年月起不能大于工作年月止',
	              					callback:function(value, validator,$field,options){
	          							var end = $("#aae031").val();
	          							var begin = value;
	              						var flag =  jxDateBetween(begin,end);
	              						if(flag){
	              							return false;
	              						}else{
	              							validator.updateStatus("aae031", "VALID");
	              							return true;
	              						}
	              					}
	              			}
                	   } 
                   },
                   //工作年月止
                   aae031: {
                	   validators: {  
				             date: {
		                         format: 'YYYY-MM-DD',
		                         message: '请输入正确的时间格式'
		                     },
              				 callback: {
              					message: '工作年月止不能小于工作年月起',
              					callback:function(value, validator,$field){
              						var begin = $("#aae030").val();		//开始时间
              						var flag = jxDateBetween(begin,value);
              						if(flag){
              							return false;
              						}else{
              							validator.updateStatus("aae030", "VALID");
              							return true;
              						}
              						
              					}
              				}
                	   } 
                   },
                   //离职日期
                   aac0ba: {
                	   validators: {  
				             date: {
		                         format: 'YYYY-MM-DD',
		                         message: '请输入正确的时间格式'
		                     }
                	   } 
                   },
                   //备注
                   aae013: {
                	   validators: {  
                		   stringLength: { min: 0, max: 50 ,message: '最多输入50个汉字'} 
                	   } 
                   },
                   //劳动合同期限
                   aac217 : {
                	   validators: {  
                  		   stringLength: {min: 1,max: 3, message:'长度在1-3位之间' }, 
                		   numeric : {
		                        message: '请输入正整数'
		                   }
                	   } 
                   }
                   
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                        $(".btn-submit").removeAttr("disabled");
                        var arry = data.message;
		                var messages=arry.substring(0,10);
		                var aac0b0 = arry.substring(10);
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: messages, 
                            callback: function(){ 
                            	var parentIframe=xfui.getParentIframe();
            			    	if(parentIframe){
            			    		parentIframe.refreshWorkExpceList();
            			    		window.location.href = "${ctx}/business/person/personWorkExpce/edit.xf?aac0b0="+aac0b0;
            			    		parentIframe.loadPage($("#aac001").val());
            			    	}
                            }
                        })
                        
                    }, 'json');

                });
       }
	 function checkAac045(){
			var res = false;
			$.ajax({
				contentType: "application/x-www-form-urlencoded; charset=utf-8",
				url : '${ctx}/business/person/personWorkExpce/isExist.xf',
				data : {
					'aac001exists':$("#aac001").val(),
					'aac0b0exists':$("#aac0b0").val(),
					'aac045exists':$("#aac045").val()
				},
				async : false,
				type: "post", 
				dataType : 'json',
				success : function(data) {
					res = (data.result == '0');
				},
				error : function() {
					res = false
				}
			});
			//工商登记执照号码是否已存在
			if (!res) {
				$("small[data-bv-validator$='stringLength'][data-bv-for$='aac045']")
						.html("已填过该教育经历");
				$("small[data-bv-validator$='stringLength'][data-bv-for$='aac045']")
						.show();
				  $(".btn-submit").Attr("disabled")
				  return false;
			}else{
				return true;
			}
		}
	  function closeItem(){
		  xfui.closeDialog();
	  }
	  function submitForm(){
		  window.location.href = "${ctx}/business/person/personWorkExpce/add.xf?aac001=${personWorkExpceForm.aac001}";
	  }
	</script>
</head>
<body>
<form:form modelAttribute="personWorkExpceForm" method="post" action="${ctx}/business/person/personWorkExpce/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleCont change-bg-iframe">	
				<form:hidden id="aac001" path="aac001" ></form:hidden>
				<form:hidden id="aac0b0" path="aac0b0" ></form:hidden>
				<form:hidden path="ccpr08" value="0"></form:hidden>
				<div id="mhyPopdiv">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="工作单位"><em>*</em>工作单位:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input class="form-control" type="text" id="aac045" path="aac045"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="工作年月起"><em>*</em>工作年月起:</label>
						<div class="col-xs-9 input-group col-sm-input" >
							<div class="input-group row required">
								<form:input class="form-control" formValidatorId="personWorkExpceForm" path="aae030" type="text" placeholder="请选择日期"  />
								<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="工作年月止">工作年月止:</label>
						<div class="col-xs-9 input-group col-sm-input" >
							<div class="input-group row">
								<form:input class="form-control" formValidatorId="personWorkExpceForm" path="aae031" type="text" placeholder="请选择日期" />
								<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
		 		    </div>
		 		    <div class="row">
		   				<label class="col-xs-3 col-sm-label" for="inputError" title="主要工作内容">主要工作内容:</label>
						<div class="col-xs-9 col-sm-three-col">
							<form:textarea class="form-control" type="text" row="5" col="5" path="aac0b4"></form:textarea>
						</div>		
		   			</div>
		 		    <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="劳动合同期限(年)">劳动合同期限(年):</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" path="aac217"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="专业技术职务">专业技术职务:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_TITLE" name="aac014" value="${personWorkExpceForm.aac014 }" valueField="code" hasDefault="0"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">职称:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_JOBTITLE" name="aac0b1"  value="${personWorkExpceForm.aac0b1 }" valueField="code" hasDefault="0"></xf:select>
						</div>		
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="职业资格等级">职业资格等级:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_COQ" name="aac015" value="${personWorkExpceForm.aac015 }" valueField="code" hasDefault="0"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="执业资格情况">执业资格情况:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control " type="text" path="aac0b2"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="岗位">岗位:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="aac0b3"></form:input>
						</div>
					</div>
		 		    <div class="row">
		   				<label class="col-xs-3 col-sm-label" for="inputError" title="成绩及奖惩">成绩及奖惩:</label>
						<div class="col-xs-9 col-sm-three-col">
							<form:textarea class="form-control" type="text" row="5" col="5" path="aac0b5"></form:textarea>
						</div>		
		   			</div>
		 		    <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="见习标志">见习标志:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select class="combobox" path="aac0b6" >
							   <form:option value="" label="--请选择--"/>
							   <form:option value="0" label="非见习"/>
							   <form:option value="1" label="见习"/>
						    </form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="在职培训情况">在职培训情况:</label>
						<div class="col-xs-9 col-sm-two-col">
							<form:input class="form-control" type="text" path="aac0b7"></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">备注:</label>
						<div class="col-xs-9 col-sm-three-col">
							<form:input class="form-control" type="text" path="aae013" row="5" col="5"></form:input>
						</div>
					</div>
		 		    <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="离职原因">离职原因:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_LEAVEREASONS " name="aac0b8" value="${personWorkExpceForm.aac0b8 }" valueField="code" hasDefault="0"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="离职日期">离职日期:</label>
						<div class="col-xs-9 col-sm-input" >
						<div class="input-group row">
							<form:input class="form-control" formValidatorId="personWorkExpceForm" path="aac0ba" type="text" placeholder="请选择日期" />
							<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
						</div>
						</div>
					</div>
					<div class="row">
		   				<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="aae036" readonly="true"  data-date-format="dd-mm-yyyy"></form:input>
						</div>	
		   				<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="aae020"  readonly="true" data-options="required:false"></form:input>
						</div>	
		   				<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text"  path="aae019"  readonly="true" data-options="required:false;readonly:true"></form:input>
						</div>		
					</div>
				</div>	
			</div>
		</div>
	  	<div class="bottomBtn">
	  		<div class="h50">&nbsp;</div>
	  		<div class="floatBtn">
				<button class="btn btn-primary mhyBtnLeft" type="submit"><i class="icon-save"></i>保存	</button>
				<button class="btn btn-primary mhyBtnLeft" type="button" onclick="submitForm()"><i class="icon-plus"></i>新增</button>
				<button class="btn btn-info" type="button" onclick="closeItem()"><i class="icon-remove"></i>关闭</button>
			</div>	
		</div> 
	</div>  		
</form:form>
</body>
</html>