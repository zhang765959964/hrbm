<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>档案调出登记结果显示页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<script type="text/javascript">
		$(function(){
			$("#lendDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId:"archiveLendForm",
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
		})
	</script>
</head>
<body>
	<div class="moduleWrapNobg">
		<div class="moduleTit">存档信息</div>
		<div class="moduleCont">
			<form:form modelAttribute="archivesLendPersonForm" method="post" action="">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">姓名拼音码:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aac022" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                      	<form:input  class="form-control" type="text"  path="aac006" readonly="true"></form:input>
                      	<span class="input-group-addon">
                          	<i class="icon-calendar bigger-110"></i>
                      	</span>
                    </div>
					<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="nationName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">婚姻状况:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="MaritalStatusName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">配偶姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="faName" readonly="true"></form:input>
					</div>
                          <label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="educationName" readonly="true"></form:input>
					</div>
                          <label class="col-xs-3 col-sm-2" for="inputError">政治面貌:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="politicalLandScape" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
                      	<form:input  class="form-control" type="text"  path="expStartJobDate" readonly="true"></form:input>
                      	<span class="input-group-addon">
                          	<i class="icon-calendar bigger-110"></i>
                      	</span>
                    </div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="是否军转干部">是否军转干部:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expIsCadreName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aae005" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expISDiscount" readonly="true"></form:input>
					</div>
					<div class="col-xs-12 col-sm-8 mgb0">
						<div class="row mgb0">
							<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
							<div class="col-xs-12 col-sm-9">
								<form:input  class="form-control" type="text"  path="aab301" readonly="true"></form:input>
							</div>
						</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案编号">档案编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                            	<form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                            	<span class="input-group-addon">
                                	<i class="icon-calendar bigger-110"></i>
                            	</span>
                          </div>
                          <label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                            	<form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                            	<span class="input-group-addon">
                                	<i class="icon-calendar bigger-110"></i>
                            	</span>
                          </div>
                          <label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
					</div>
                          <label class="col-xs-3 col-sm-2" for="inputError" title="退休年数">退休年数:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="retiredAge" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">退休参考日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                            	<form:input  class="form-control" type="text"  path="planRetiredDate" readonly="true"></form:input>
                            	<span class="input-group-addon">
                                	<i class="icon-calendar bigger-110"></i>
                            	</span>
                          </div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">社会保障号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expSoctalNumber" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">原工作单位:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expOldCompany" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">个人编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expPersonNumber" readonly="true"></form:input>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12">
						<div class="row rowTextarea">
							<label class="col-xs-3 col-sm-2" for="inputError" title="备注">备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="aae013" row="2" col="5" readonly="true"></form:textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">存档类型:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">接收状态:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveReceiveStatusName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">市场位置:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="marketPositionName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">区:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsLibrary" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">柜:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">排:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsLayer" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">列:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsLattice" readonly="true"></form:input>
					</div>
					<div class="col-xs-12 col-sm-8 mgb0">
						<div class="row mgb0">
							<label class="col-xs-3 col-sm-3" for="inputError" title="委托单位名称">委托单位名称:</label>
							<div class="col-xs-12 col-sm-9">
								<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12 threeCol">
						<div class="row rowTextarea">
							<label class="col-xs-3 col-sm-2" for="inputError" title="档案存放备注">档案存放备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="archiveReceiveDesc" row="2" col="5" readonly="true"></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- 档案调出-带点击按钮 -->
	<form:form modelAttribute="archiveLendForm" method="post" action="${ctx}/business/personagency/archive/archiveLend/save.xf" onsubmit="return submitForm('${archiveId}','${archiveReceiveStatus}')">
		<div class="moduleWrapNobg">
			<div class="moduleTit">档案调出信息</div>
			<div class="moduleCont">
				<form:hidden path="lendId" ></form:hidden>
				<form:hidden path="archivesId" ></form:hidden>
				<form:hidden path="lendCreaterId" ></form:hidden>
				<form:hidden path="lendCreaterOrgId" ></form:hidden>
				<form:hidden path="lendFlowStatus" ></form:hidden>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>调出时间:</label>
                       <div class="col-xs-9 input-group col-sm-2 required">
						<div class="input-group row required">
							<form:input  class="form-control date" type="text" path="lendDate" placeholder="请选择日期"></form:input>
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>调出办理人:</label>
					<div class="col-xs-9 col-sm-2 required">
						<form:input  class="form-control" type="text" path="lendName"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>档案去向（单位）:</label>
					<div class="col-xs-9 col-sm-2 required">
						<form:input  class="form-control" type="text" path="archivesLendWhere"></form:input>
					</div>
			</div>
			<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError"><em>*</em>调出原因:</label>
					<div class="col-xs-9 col-sm-2 required">
						<xf:select  tableName="RSDA_TAB_LEND_REASON" valueField="code" textField="name" name="lendReason"
					 		value='${archiveLendForm.lendReason}' hasDefault="0" selectClass="form-control"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">调出办理人身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="lendIdNumber"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">调出办理人联系电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="lendPhone"></form:input>
					</div>
			</div>
			<div class="row">
					<div class="col-xs-12 col-sm-12 threeCol">
						<div class="row rowTextarea">
							<label class="col-xs-3 col-sm-2" for="inputError" title="调出备注">调出备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="lendRemarks" row="2" col="5"></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<div class="col-xs-12 col-sm-12">
			<div class="row">
				<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
				<div class="col-xs-9 col-sm-2">
                       <form:input  class="form-control" type="text" path="lendCreaterDate" readonly="true"></form:input>
                   </div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text" path="lendCreaterOrgName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
				<div class="col-xs-9 col-sm-2">
					<form:input  class="form-control" type="text" path="lendCreaterName" readonly="true"></form:input>
				</div>
			</div>
		</div>
   	<div class="h60">&nbsp;</div>
   	<div class="floatBtn">
   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
   		<a href="javascript:addResetArchiveLend('${archiveId}')" role="button" class="btn btn-success" ><i class="icon-plus"></i>新增</a>
   		<a href="javascript:delResetArchiveLend('${lendId}','${archiveReceiveStatus }')" role="button" class="btn btn-purple dropdown-toggle" ><i class="icon-remove"></i>调出取消</a>
		<a href="javascript:resetButton()" role="button" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
   	</div>
 </form:form>
 <script type="text/javascript">
 	var flag = false;
 	$(function() {
		initFormSubimt();
		$("#archiveLendForm").change(function(){
			flag = true;
		});
	});

 	//新增
	function addResetArchiveLend(archiveId){
		if(archiveId>0){
			if(flag){
				// bootbox.alert('档案调出信息值有改变，请先保存！');
				bootbox.confirm({  
			        buttons: {  
			            confirm: {  
			                label: '否',  
			                className: 'btn-myStyle'  
			            },  
			            cancel: {  
			                label: '是',  
			                className: 'btn btn-primary'  
			            }  
			        },  
			        message: '档案调出信息值有改变，是否保存？',  
			        callback: function(result) {  
			            if(result) {  
			            	$("#archiveLendRegisterResultList").load("${ctx}/business/personagency/archive/archiveLend/resultList.xf");
			            } else {  
			            	$('#archiveLendForm').submit();
			            }  
			        }
				}) 
			}else{
				$("#archiveLendRegisterResultList").load("${ctx}/business/personagency/archive/archiveLend/resultList.xf");
			}
		}
	}

	//保存
	function submitForm(archiveId,archiveReceiveStatus){
	  	var bootstrapValidator = $("#archiveLendForm").data('bootstrapValidator');  
		if(archiveId>0){
			if(archiveReceiveStatus==1){
				bootbox.alert('当前档案还没有入库，不能办理档案调出！');
				bootstrapValidator.setAllowSubmit(false);
			}else{
				bootstrapValidator.setAllowSubmit(true);
			}
		}else{
			bootbox.alert('请先选择档案信息！');
			bootstrapValidator.setAllowSubmit(false);
		}
	}
	//调出取消
	function delResetArchiveLend(lendId,archiveReceiveStatus){
		if(lendId>0){
			if(archiveReceiveStatus==1){
				bootbox.alert('当前档案已经调出确认，不能调出取消！');
			}else{
				$.ajax({ url: '${ctx}/business/personagency/archive/archiveLend/del.xf',
		    		data:{lendId:lendId},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message);
		    			}else{
		    				bootbox.alert("未知错误");
		    			}
		    			$("#archiveLendRegisterResultList").load("${ctx}/business/personagency/archive/archiveLend/resultList.xf?personId=${personId}");
		             }
		    	});
			}
		}else{
			bootbox.alert('没有调出登记信息，不能调出取消！');
		}
	}

	//档案接收保存
	function initFormSubimt(){
      $('#archiveLendForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
            	//调出时间
            	lendDate : {
                    validators: {
                        notEmpty: {
                     	   message: '调出时间不允许为空'
                        },
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
                    }
                },
                //调出办理人
               lendName :{
               	validators: {
               			notEmpty: {
               				message: '调出办理人不允许为空'
                        },stringLength: {
                            min: 2,
                            max: 15
                        }
               		}
               },
                //档案去向
               archivesLendWhere :{
               	validators: {
               			notEmpty: {
               				message: '档案去向不允许为空'
                        },stringLength: {
                            min: 2,
                            max: 50
                        }
               		}
               },
                //调出原因
               lendReason :{
               	validators: {
               			notEmpty: {
               				message: '调出原因不允许为空'
                        }
               		}
               },
               //调出办理人身份证号
        	   lendIdNumber : {
                   validators: {
                	   callback: {
	       					message: '身份证号格式不正确',
	       					callback:function(value, validator,$field){
	       						if(!value){
	       							return true;
	       						}
	       						return validateIdCard(value);
	       					}
	       			   }
                   }
               },
              //调出办理人联系电话
               lendPhone : {
                   validators: {
                	    stringLength: { max: 15 },
	               		regexp: {
	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	              			message: '电话号码或手机号码格式不正确'
	               		}
                   }
               },
              //调出备注
               lendRemarks : {
                   validators: {
               		   stringLength: {min: 1,max: 50, message:'长度在1-50位之间' } 
                   }
               }
            }
		     }).on('success.form.bv', function(e) {
                 e.preventDefault();
                 var $form = $(e.target);
                 var bv = $form.data('bootstrapValidator');
                 bv.disableSubmitButtons(true);
                 $.post($form.attr('action'), $form.serialize(), function(data) {
                 	console.info(data);
                     bootbox.alert({
                         size: 'small',
                         width:"100px",
                         message: data.message,
                         callback: function(){
                        	 bv.disableSubmitButtons(false);
                         	 $("#archiveLendRegisterResultList").load("${ctx}/business/personagency/archive/archiveLend/resultList.xf?personId=${personId}");
                         }
                     })
                 }, 'json');

             });
    }
	//重置
	function resetButton(){debugger;
		resetFormNotHide('archiveLendForm');
		$('#archiveLendForm').data('bootstrapValidator').updateStatus('lendIdNumber', 'NOT_VALIDATED').validateField('lendIdNumber');
		$('#archiveLendForm').data('bootstrapValidator').updateStatus('lendPhone', 'NOT_VALIDATED').validateField('lendPhone');
		$('#archiveLendForm').data('bootstrapValidator').updateStatus('lendRemarks', 'NOT_VALIDATED').validateField('lendRemarks');
		$('#archiveLendForm').data('bootstrapValidator').updateStatus('archivesLendWhere', 'NOT_VALIDATED').validateField('archivesLendWhere');
		$('#archiveLendForm').data('bootstrapValidator').updateStatus('lendReason', 'NOT_VALIDATED').validateField('lendReason');
	}
</script>
</body>
</html>