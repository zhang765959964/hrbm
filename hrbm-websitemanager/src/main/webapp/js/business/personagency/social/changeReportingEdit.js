 $(function(){
	  initFormSubimt();
	  $("#expStartJobDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "changeReportingForm",
		  "opens":"right",
		  "drops": "down",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#expPensionDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "changeReportingForm",
		  "opens":"right",
		  "drops": "down",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#expMedicalDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "changeReportingForm",
		  "opens":"right",
		  "drops": "down",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#paymentStartDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  "opens":"right",
		  "drops": "down",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#paymentEndDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "changeReportingForm",
		  "opens":"right",
		  "drops": "down",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#fieldStartDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "changeReportingForm",
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#fieldEndDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "changeReportingForm",
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#stopSocialDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "changeReportingForm",
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
 })
 
 
 function initFormSubimt(){
     $('#changeReportingForm').bootstrapValidator({
           message: 'This value is not valid',
           feedbackIcons: {
               valid: 'glyphicon glyphicon-ok',
               invalid: 'glyphicon glyphicon-remove',
               validating: 'glyphicon glyphicon-refresh'
           },
           fields: {
        	   //变更内容
               changeContent: {
                   validators: {
                       notEmpty: {}
                   }
               },
        	 	//个人编号
               expPersonNumber: {
                    validators: {
                        stringLength: {min: 0,max: 32 } } 
           	   },
               //手机号
               aae005: {
                   validators: {
                	   notEmpty: { message: '手机号不允许为空' },
                	   regexp: {
                          regexp: /^1[3|4|5|7|8]\d{9}$/,
                          message: '手机号格式不正确'
                        }
           	   	   } 
           	   },
               //联系电话
               expPersonPhone: {
                   validators: {
                	   stringLength: { max: 15 },
	               		regexp: {
              					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
                    			message: '电话号码或手机号码格式不正确'
	               		}
           	   	   }
               },
              //家庭住址
               aab301: {
                   validators: {
                       stringLength: { min: 0, max: 50 }  } 
           	   },
              //邮政编码
               aae007: {
                   validators: {
                	   regexp: {
                		        regexp: /^[1-9][0-9]{5}$/,
                		        message: '邮政编码不正确'
                	   }
                   } 
           	   },
              //转出社保机构名称
               checkoutSocialOrgName: {
                   validators: {
                       stringLength: { min: 0, max: 50 }  } 
           	   },
              //备注
               description: {
                   validators: {
                       stringLength: { min: 0, max: 200 }  } 
           	   },
           	   //参加工作时间
           	  expStartJobDate: {
                    validators: { 
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
           	  	   }
           	  },
           	  //参加养老保险时间
           	  expPensionDate: {
                    validators: { 
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
           	  	   }
           	  },
           	  //缴费开始年月
             paymentStartDate: {
                    validators: { 
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
           	  	   }
           	  },
           	//缴费终止年月
           	paymentEndDate: {
                    validators: { 
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
           	  	   }
           	  },
           	//医疗保险参加时间
           	expMedicalDate: {
                    validators: { 
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
           	  	   }
           	  },
           	//外地缴费开始时间
           	fieldStartDate: {
                  validators: { 
                      date: {
                          format: 'YYYY-MM-DD',
                          message: '请输入正确的时间格式'
                      }
         	  	   }
         	  },
         	//外地缴费终止时间
         	 fieldEndDate: {
                      validators: { 
                          date: {
                              format: 'YYYY-MM-DD',
                              message: '请输入正确的时间格式'
                          }
             	  	   }
             	  },
         	//停保时间
         	 stopSocialDate: {
                       validators: { 
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
                bv.disableSubmitButtons(true);
                $.post($form.attr('action'), $form.serialize(), function(data) {
                    bootbox.alert({ 
                        size: 'small',
                        width:"100px",
                        message: data.message, 
                        callback: function(){ 
                        	bv.disableSubmitButtons(false);
                        	var parentIframe=xfui.getParentIframe();
        			    	if(parentIframe){
        			    		parentIframe.refresh();
        			    	}
                        	closeItem(); 
                        }
                    })
                    
                }, 'json');

            });
   }
  function closeItem(){
	  xfui.closeDialog();
  }
  function submitForm(){
	  $('#changeReportingForm').submit();
  }