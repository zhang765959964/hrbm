 $(function(){
		 
		 initFormSubimt();
	 })
     function initFormSubimt(){
         $('#paramsAgentCodeForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   fdTypeCode: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 10
                           }
                       }
                   },
                   fdTypeName: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 50
                           }
                       }
                   },
                   fdCodeName: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 50
                           }
                       }
                   },
                   fdCodeValue: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               max: 10
                           }
                       }
                   },
                   fdPinyinCode: {
                       validators: {
                           stringLength: {
                               max: 10
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
                            	bv.disableSubmitButtons(false)
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
		  $('#paramsAgentCodeForm').submit();
	  }