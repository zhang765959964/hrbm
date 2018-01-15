 	var dataFalg = false;
	$(function(){
		  initFormSubimt();
	 })
     function initFormSubimt(){
         $('#specialArchivesForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            		//特殊类档案类别
	               	specialType : {
	                       validators: {
	                           notEmpty: {message: '特殊类档案类别不允许为空'  }
	                       }
	                },//姓名
	                aac003 : {
	                       validators: {
	                           notEmpty: {
	                        	   message: '姓名不允许为空'
	                           },stringLength: {
			                        min: 2,
			                        max: 10
			                    }
	                       }
	                },//身份证号
	                aac002 : {
	                   validators: {
	                	   callback: {
	           					message: '身份证号格式不正确',
	           					callback:function(value, validator,$field){
	           						if(!value){
	           							return true;
	           						}
	           						return validateIdCard(value);
	           					}
	           			   },
		           		   remote: {
	                            type: 'POST',
	                            url: CTX+'/business/personagency/storage/specialArchives/checkUnid.xf?id='+$("#id").val(),
	                            message: '身份证号已经存在！',
	                            delay: 500
	                        }
	                    }
	                },//学校名称
	                schoolName : {
	                       validators: {
	                           stringLength: {
	                               min: 0,
	                               max: 100,
	                               message:'最多输入100个字符'
	                           }
	                       }
	                },//班级
	                schoolClass : {
	                       validators: {
	                           stringLength: {
	                               min: 0,
	                               max: 50,
	                               message:'最多输入50个字符'
	                           }
	                       }
	                },//专业
	                major : {
	                       validators: {
	                           stringLength: {
	                               min: 0,
	                               max: 50,
	                               message:'最多输入50个字符'
	                           }
	                       }
	                },//单位名称
	                corpName : {
	                       validators: {
	                           stringLength: {
	                               min: 0,
	                               max: 50,
	                               message:'最多输入50个字符'
	                           }
	                       }
	                },//退伍编号
	                veteransNumber : {
	                       validators: {
	                           stringLength: {
	                               min: 0,
	                               max: 50,
	                               message:'最多输入50个字符'
	                           }
	                       }
	                },//备注
	                description : {
	                       validators: {
	                           stringLength: {
	                               min: 0,
	                               max: 500,
	                               message:'最多输入580个字符'
	                           }
	                       }
	                }
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    bv.disableSubmitButtons(true);
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: data.message, 
                            callback: function(){ 
                            	bv.disableSubmitButtons(false);
                            	if(dataFalg){
                            		var parentIframe=xfui.getParentIframe();
                            		if(parentIframe){
                            			parentIframe.refresh();
                            		}
                            		resetForm('specialArchivesForm');
                            		$('#specialArchivesForm').data('bootstrapValidator').updateStatus('specialType', 'NOT_VALIDATED').validateField('specialType');
                            		$('#specialArchivesForm').data('bootstrapValidator').updateStatus('aac003', 'NOT_VALIDATED').validateField('aac003');
                            	}else{
                            		var parentIframe=xfui.getParentIframe();
                            		if(parentIframe){
                            			parentIframe.refresh();
                            		}
                            		closeItem(); 
                            	}
                            }
                        })
                    }, 'json');
                });
       }
	 
	  function closeItem(){
		  xfui.closeDialog();
	  }
	  function submitForm(data){
		  if(data){
			  dataFalg = true;
		  }
		  //$('#specialArchivesForm').submit();
	  }