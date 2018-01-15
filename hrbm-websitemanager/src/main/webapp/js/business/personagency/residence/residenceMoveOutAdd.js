$(function(){
		 initFormSubimt();
			  $("#moveDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId : "residenceMoveOutForm",
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#outDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId:"residenceMoveOutForm",
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#openDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId : "residenceMoveOutForm",
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  
	 })
     function initFormSubimt(){
         $('#residenceMoveOutForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //户口编号
            	   residenceNumber : {
            		   validators: {
                    	   stringLength: {
                               min: 0,
                               max: 32
                           }
                       }
	                },//户口状态
	               	residenceStatus : {
	                       validators: {
	                           notEmpty: {}
	                       }
	                },//落户地户籍部门
	                settleDepartment : {
	                       validators: {
	                           notEmpty: {
	                        	   
	                           },
		                       stringLength: {
	                               min: 2,
	                               max: 50
	                           }
	                       }
	                },//落户地址
	                settleAddress : {
	                       validators: {
	                           notEmpty: {
	                        	   
	                           },
		                       stringLength: {
	                               min: 2,
	                               max: 50
	                           }
	                       }
	                },//原户籍所在地
	                originalDomicile : {
	                       validators: {
		                       stringLength: {
	                               min: 2,
	                               max: 50
	                           }
	                       }
	                },
	                //备注
	                description : {
	                       validators: {
		                       stringLength: {
	                               min: 2,
	                               max: 200
	                           }
	                       }
	                },
	               //迁入日期
	                moveDate: {
                        validators: { 
                            date: {
                                format: 'YYYY-MM-DD',
                                message: '请输入正确的时间格式'
                            }
               	  	   }
	               },
	               //开具日期
	               openDate: {
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
		  $('#residenceMoveOutForm').submit();
	  }