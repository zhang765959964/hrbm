$(function (){
		 initFormSubimt();
		 $("#addre").selcity({callBack:function(data){
				$("#addre").val(data.allname);
				var bootstrapValidator = $("#unitAgreementForm").data('bootstrapValidator');  
				bootstrapValidator.updateStatus('aaa021', 'NOT_VALIDATED').validateField('aaa021'); 
			}
		 });
		 $("#uaCreatetime").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :true,
			  "opens":"right",
			  "drops": "down",
              "locale": {
                 "format": "YYYY-MM-DD"
             }
         });
		 
	
	 })
	 
     function initFormSubimt(){
         $("#unitAgreementForm").bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   aab004 : {
                        validators: {
                            notEmpty: {
                         	   message : "单位名称不能为空！"
                            },
                            stringLength: {
                                min: 2,
                                max: 25
                            }
                        }
                    },
                    aab019 : {
                        validators: {
                            notEmpty: {
                         	   message : "单位性质不能为空！"
                            }
                           
                        }
                    },
                    uaNo : {
                    	validators: { 
                    		notEmpty: {  message : "单位协议编号不能为空！"  }, stringLength: {max: 20 },
                    		  remote: {
                                  type: 'POST',
                                  url: CTX+'/business/unitagreement/getByUnitNo.xf?id='+$("#id").val(),
                                  message: '已有此编号！',
                                  delay: 500
                              },
                    		
                    		}
                    	},
                    aaa021 : { validators: {  notEmpty: { message : "所在地区不能为空！"  } ,stringLength: { min: 2,max: 20 } } },
                    aae006: {validators: { stringLength: {  min: 0,  max: 50  } } },
                    uaPhone:{
                    	validators: { 
                    		stringLength: { max: 15 },
                    		regexp: {
                    		regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
                          			message: '电话号码或手机号码格式不正确'
                            }
                    	}
                    
                    },
                    uaCard: {
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
                    uaContent: {validators: { stringLength: {  min: 0,  max: 200  } } },
                    uaNote: {validators: { stringLength: {  min: 0,  max: 100  } } },
                    uaName: {validators: { stringLength: {  min: 0,  max: 10  } } }	
                   
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    bv.disableSubmitButtons(true);
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                    	//bv.disableSubmitButtons(false);
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: data.message,
                            callback :function (e){
                            	$("#unitCorp").load(CTX+"/business/unitagreement/edit.xf?aab001="+$("#aab001").val());
                            }
                        })
                        
                    }, 'json');

                });
       }


