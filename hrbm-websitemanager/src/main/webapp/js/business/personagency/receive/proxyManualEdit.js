$(function(){
	 initFormSubimt();
	 $("#lssuingDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "proxyManualForm",
		  "opens":"right",
		  "drops": "down",
          "locale": {
              "format": "YYYY-MM-DD"
          }
     });
})
     function initFormSubimt(){
         $('#proxyManualForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //有效标记
            	  /* effectiveMark: {
                       validators: {
                           notEmpty: {
                           }
                       }
                   },*/
	               //发放人
                   proxyIssuer: {
	                   validators: {
	                       stringLength: {
	                           min: 2,
	                           max: 15
	                       }
	                   }
	               },//发放原因
	               proxyReaseon: {
	                   validators: {
	                       stringLength: {
	                           min: 2,
	                           max: 100
	                       }
	                   }
	               },//备注
	               description: {
	                   validators: {
	                       stringLength: {
	                           min: 2,
	                           max: 200
	                       }
	                   }
	               },
	               //发放时间
	               lssuingDate: {
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
                        $(".btn-submit").removeAttr("disabled");
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
		  $('#proxyManualForm').submit();
	  }