
	 $(function(){
		 calculateAmount();
		 initFormSubimt();
			  $("#fdRefundStartDate").xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM"
	              }
	          });
			  
			  $("#fdRefundStartDate").on("change",function(){
				  
				  calculateAmount();
			  })
			  $("#fdRefundEndDate").on("change",function(){
				  calculateAmount();
				  
			  })
	 })
	 function calculateAmount(){
		 var beginTime=$("#fdRefundStartDate").val();
		  var endTime=$("#fdRefundEndDate").val();
		  totalMonth= getMct(beginTime,endTime,"-");
		  totalMonth++;
		  $("#fdRefundMonths").val(totalMonth);
		  var fdRefundStandard=$("#fdRefundStandard").val();				  
		  var fdRefundAmount=parseFloat(fdRefundStandard)*totalMonth;
		  $("#fdRefundAmount").val(fdRefundAmount);
	 }
     function initFormSubimt(){
         $('#paymentRefundForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //发布名称
                   fdRefundStartDate: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               max: 50
                           }
                       }
                   },
                   fdRefundEndDate: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               max: 50
                           }
                       }
                   },
                   fdRefundDesc:{
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
		  $('#paymentRefundForm').submit();
	  }
