$(function(){
	initFormSubimt();
	$("#dateOfIssue").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "personLetterForm",
		  "opens":"right",
		  "drops": "down",
       "locale": {
           "format": "YYYY-MM-DD"
       }
   });
})
 function initFormSubimt(){
     $('#personLetterForm').bootstrapValidator({
           message: 'This value is not valid',
           feedbackIcons: {
               valid: 'glyphicon glyphicon-ok',
               invalid: 'glyphicon glyphicon-remove',
               validating: 'glyphicon glyphicon-refresh'
           },
           fields: {
        	   //姓名
        	   aac003: {
                   validators: {
                       stringLength: {
                           min: 2,
                           max: 10
                       }
                   }
               },//文件号
               fileNumber: {
                   validators: {
                       stringLength: {
                           min: 2,
                           max: 32
                       }
                   }
               },//代管内容
               escrowContent: {
                   validators: {
                       stringLength: {
                           min: 2,
                           max: 50
                       }
                   }
               },//工作单位
               workUnit: {
                   validators: {
                       stringLength: {
                           min: 2,
                           max: 50
                       }
                   }
               },//事由
               reason: {
                   validators: {
                       stringLength: {
                           min: 2,
                           max: 50
                       }
                   }
               },//第4项内容
               fourthItems: {
                   validators: {
                       stringLength: {
                           min: 2,
                           max: 50
                       }
                   }
               },
               //开具日期
               dateOfIssue: {
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
	  $('#personLetterForm').submit();
  }