 $(function(){
		 
		 initFormSubimt();
	})
	
	
     function initFormSubimt(){
         $('#paramsMonthBaseForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   fdMonthBase: {
	                   validators: {
	                	   notEmpty: {
		                	   	message : "月缴费基数不能为空！"
	                         },
	                         regexp: {
	                             regexp: /^([+-]?)\d*\.?\d+$/
	                         },
	                         stringLength: {
	                              max:10 
	                          }
	                   }
	               },fdParmsDesc :{
	            	    validators: {
		                	   notEmpty: {
			                	   message : "参数描述不能为空！"
		                         },
		                         stringLength: {
		                              max:50 
		                          }
		                   }
			       }, fdDesc : {
			    	   validators: {
	                	   notEmpty: {
	                         },
	                         stringLength: {
	                              max:50 
	                          }
	                   }
					}
               }
           }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
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