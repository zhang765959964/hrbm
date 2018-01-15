<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 个人教育背景表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@include file="/commons/include/bootstrapInc.jsp" %>
	<script type="text/javascript">
	 $(function(){
		 initFormSubimt();
		 $("#aac046").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "personEducationForm",
			  "opens":"right",
			  "drops": "down",
	          "locale": {
	              "format": "YYYY-MM-DD"
	          }
	     });
	 })
	function initFormSubimt(){
		  $('#personEducationForm').bootstrapValidator({
		         message: 'This value is not valid',
		         feedbackIcons: {
		             valid: 'glyphicon glyphicon-ok',
		             invalid: 'glyphicon glyphicon-remove',
		             validating: 'glyphicon glyphicon-refresh'
		         },
		         fields: {
		      	     //毕业院校
		             aac045: {validators: {notEmpty: {message: '请填写毕业院校'},
		                     stringLength: {min: 2,max: 25}
		                 }
		             },
		      	     //所学专业
		             acc01g: {validators: {stringLength: {min: 0,max: 20,message: '最多输入20个汉字'}
		                 }
		             },
		      	     //毕业证书（认证）编号
		             aac0d5: {validators: {stringLength: {min: 0,max: 30,message: '最多输入30个字符'}
		                 }
		             },
		      	     //专业描述
		             aac0d4: {validators: {stringLength: {min: 0,max: 50,message: '最多输入50个汉字'}
		                 }
		             },
		      	     //第二专业
		             atc01g: {validators: {stringLength: {min: 0,max: 20,message: '最多输入20个汉字'}
		                 }
		             },
		      	     //备注
		             aac0d1: {validators: {stringLength: {min: 0,max: 50,message: '最多输入50个汉字'}
		                 }
		             },
		      	     //学习经历
		             aae013: {validators: {stringLength: {min: 0,max: 50,message: '最多输入50个汉字'}
		                 }
		             },
		             //毕业时间
                     aac046: {
                	   validators: {  
                		     notEmpty: { message: '请填写毕业时间' },
				             date: {
		                         format: 'YYYY-MM-DD',
		                         message: '请输入正确的时间格式'
		                     }
                	   } 
                     }
	               }
		     }).on('success.form.bv', function(e) {
		              e.preventDefault();
		              var $form = $(e.target);
		              var bv = $form.data('bootstrapValidator');
		              $.post($form.attr('action'), $form.serialize(), function(data) {
		            	  console.info(data);
		            	  var arry = data.message;
		                  var messages=arry.substring(0,10);
		                  var aac0d0 = arry.substring(10);
		                  $(".btn-submit").removeAttr("disabled");
		                  bootbox.alert({ 
		                      size: 'small',
		                      width:"100px",
		                      message: messages, 
		                      callback: function(){ 
		                      	var parentIframe=xfui.getParentIframe();
		                      	if(parentIframe){
		        		    		parentIframe.refreshEducationList();
		        		    		window.location.href = "${ctx}/business/person/personEducation/edit.xf?aac0d0="+aac0d0;
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
				url : '${ctx}/business/person/personEducation/isExistAac045.xf',
				data : {
					'aac001exists':$("#aac001").val(),
					'aac0d0exists':$("#aac0d0").val(),
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
	  function addEducation(){
		  window.location.href = "${ctx}/business/person/personEducation/add.xf?aac001=${personEducationForm.aac001}";
		 }
	</script>
</head>
<body>
<form:form  modelAttribute="personEducationForm" method="post" action="${ctx}/business/person/personEducation/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleCont change-bg-iframe">
				<form:hidden id="aac001" path="aac001" ></form:hidden>
				<form:hidden id="aac0d0" path="aac0d0" ></form:hidden>
				<form:hidden path="ccpr08" value="0"></form:hidden>
				<div id="mhyPopdiv">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>毕业院校:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input class="form-control" id="aac045" type="text" path="aac045"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" ><em>*</em>毕业时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row required">
								<form:input class="form-control" formValidatorId="personEducationForm" path="aac046" type="text" placeholder="请选择日期"/>
								<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
							</div>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">学校性质:</label>
						<div class="col-xs-9 col-sm-input ">
							<xf:select textField="name" tableName="TAB_SCHOOLNATURE" isNoStyle="true" name="aac0d2" valueField="code" hasDefault="0" value="${personEducationForm.aac0d2 }"></xf:select>
						</div>
				   </div>
				    <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">培养方式:</label>
						<div class="col-xs-9 col-sm-input ">
							<xf:select textField="name"  tableName="TAB_CULTURETYPE" isNoStyle="true" name="aac0d3" valueField="code" hasDefault="0" value="${personEducationForm.aac0d3 }"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="毕业证书（认证）编号">毕业证书（认证）编号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="aac0d5"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">学制:</label>
						<div class="col-xs-9 col-sm-input"> 
							<xf:select textField="name" tableName="TAB_SCHOOLYEARS" name="aac0d6" value="${personEducationForm.aac0d6 }"  valueField="code" hasDefault="0"></xf:select>
						</div>	
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">学历:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_EDUCATION" name="atc011" valueField="code" hasDefault="0" value="${personEducationForm.atc011 }"></xf:select>
						</div>		
						<label class="col-xs-3 col-sm-label" for="inputError">学位:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_DEGREE" name="aac037" value="${personEducationForm.aac037 }"  valueField="code" hasDefault="0"></xf:select>
						</div>	
						<label class="col-xs-3 col-sm-label" for="inputError">所学专业:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_PROFESSION" name="acc01g" value="${personEducationForm.acc01g }" valueField="code" hasDefault="0"></xf:select>
						</div>					
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">专业描述:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="aac0d4"></form:input>
						</div>	
						<label class="col-xs-3 col-sm-label" for="inputError">第二专业:</label>
						<div class="col-xs-9 col-sm-input" >
							<xf:select textField="name"  tableName="TAB_PROFESSION" name="atc01g" value="${personEducationForm.atc01g }"  valueField="code" hasDefault="0"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">所学外语:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_LANGUAGES" name="aac038" value="${personEducationForm.aac038 }"  valueField="code" hasDefault="0"></xf:select>
						</div>	
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">外语水平:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_FLEVEL" name="aac039" valueField="code" hasDefault="0" value="${personEducationForm.aac039 }"></xf:select>
						</div>		
						<label class="col-xs-3 col-sm-label" for="inputError">第二外语:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_LANGUAGES" name="aac041" value="${personEducationForm.aac041 }"  valueField="code" hasDefault="0"></xf:select>
						</div>	
						<label class="col-xs-3 col-sm-label" for="inputError">二外水平:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_FLEVEL" name="aac042" value="${personEducationForm.aac042 }"  valueField="code" hasDefault="0"></xf:select>
						</div>						
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">其他外语:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_LANGUAGES" name="aac0d7" value="${personEducationForm.aac0d7 }"  valueField="code" hasDefault="0"></xf:select> 
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">计算机水平:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select textField="name" tableName="TAB_CLEVEL" name="aac043" value="${personEducationForm.aac043 }" valueField="code" hasDefault="0"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">学习经历:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="aac0d1"></form:input>
						</div>		
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">备注:</label>
						<div class="col-xs-9 col-sm-three-col">
							<form:input class="form-control" type="text" path="aae013" row="5" col="5" ></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input class="form-control" type="text" path="aae036" readonly="true"  data-date-format="dd-mm-yyyy"></form:input>
						</div>	
						<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
						<div class="col-xs-9 col-sm-input">
							<form:hidden path="aae017" ></form:hidden>
							<form:input class="form-control" type="text" path="aae020" readonly="true" data-options="required:false"></form:input>
						</div>	
						<label class="col-xs-3 col-sm-label" for="inputError">经办人:</label>
						<div class="col-xs-9 col-sm-input">
							<form:hidden path="aae011" ></form:hidden>
							<form:input class="form-control" type="text" path="aae019"  readonly="true" data-options="required:false;readonly:true"></form:input>
						</div>		
					</div>
				</div>
			</div>
		</div>
 		<div class="bottomBtn">
			<div class="h50">&nbsp;</div>
				<div class="floatBtn">
				<button class="btn btn-primary mhyBtnLeft" type="submit"><i class="icon-save"></i>保存</button>
				<button class="btn btn-primary mhyBtnLeft" type="button" onclick="addEducation()"><i class="icon-plus"></i>新增 </button>
				<button class="btn btn-info" type="button" onclick="closeItem()"><i class="icon-remove"></i>关闭</button>
			</div>
		</div>
	</div>	
</form:form>
</body>
</html>