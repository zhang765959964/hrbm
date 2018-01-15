	 $(function(){
		 
		 initFormSubimt();
			  $("#fdPaymentDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#fdPaymentMonths").on("change",function(){
				  var fdStartDate=$("#fdStartDate").val();
				  var fdPaymentMonths=$(this).val();
				  if(fdPaymentMonths){
					  var fdEndDate=addmulMonth(fdStartDate,parseInt(fdPaymentMonths)-1);
					  $("#fdEndDate").val(fdEndDate);
					  var bootstrapValidator = $('#paymentRecordForm').data('bootstrapValidator');
					  bootstrapValidator.updateStatus('fdEndDate', 'NOT_VALIDATED').validateField('fdEndDate');  
				  }
				 
			  })
			  $("#closeItem").on("click",function(){
				  closeItem();
			  })
	 })
     function initFormSubimt(){
		 
         $('#paymentRecordForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	  
            	   fdPaymentMonths: {
                       validators: {
                           notEmpty: {
                           },
	                         regexp: {
	                        	 message:"只能输入正整数",
	                             regexp: /^[1-9]\d*$/
	                         }
                       }
                   },
                   //联系电话
                   "archivesPersonBaseForm.expPersonPhone" :{
                	   validators: {
                		   stringLength: { max: 15 },
		               		regexp: {
	               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	                     			message: '电话号码或手机号码格式不正确'
		               		}
                       }
                	   
                   },
                   //手机号
                   "archivesPersonBaseForm.AAE005": {
                       validators: {
                    	   notEmpty: {
                           },
                    	   regexp: {
                      			regexp: /^1[34578]\d{9}$/,
                      			message: '手机号码格式不正确'
                              }
                           
                       }
                   },
                   fdStartDate: {
                       validators: {
                           notEmpty: {
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
                        //$(".btn-submit").removeAttr("disabled");
                        
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
		  $('#paymentRecordForm').submit();
	  }

