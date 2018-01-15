 $(function(){
	 	 initDate();
		 initFormSubimt();
  })
	 
	 function initDate(){
		 $("#batchStartdate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  formValidatorId : "socialBatchForm",
			  "opens":"right",
			  "drops": "down",
             "locale": {
                 "format": "YYYY-MM-DD"
             }
         });
		 
		 $("#batchEnddate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  formValidatorId : "socialBatchForm",
			  "opens":"right",
			  "drops": "down",
              "locale": {
                 "format": "YYYY-MM-DD"
             }
         });
	 
 	}
	 
	 
	 
     function initFormSubimt(){
         $('#socialBatchForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   batchStartdate: {
                       validators: {
                    	   notEmpty: {
                    		   message : '批次开始时间不能为空'
                           },
                    	   date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           }
                       }
                   },
                   batchEnddate: {
                       validators: {
                    	   notEmpty: {
                    		   message : '批次结束时间不能为空'
                           },
                    	   date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           }
                       }
                   },
                   batchName: {
                       validators: {
                           notEmpty: {
                           },stringLength: {
                               max: 15
                           },
                           remote: {
	                             type: 'POST',
	                             url: CTX+'/business/personagency/subsidy/socialBatch/isBatchExist.xf?id='+$("#id").val(),
	                             message: '批次名称重复',
	                             delay: 1000
	                      }
                       }
                   } ,
                   description: {
                       validators: {
                           stringLength: {
                               max: 50
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
            			    	if(data.result===1){
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
	  function submitForm(){
		  $('#socialBatchForm').submit();
	  }