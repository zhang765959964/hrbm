
   	  $(function(){
   		initFormSubimt();
		  $("#fdEndDate").xfdaterangepicker({autoUpdateInput:false,singleDatePicker:true,formValidatorId:'paymentRecordForm',
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM"
              }
          });
		  $("#fdEndDate").on('apply.daterangepicker', function(ev, picker) {
	            	  var bootstrapValidator = $("#paymentRecordForm").data('bootstrapValidator'); 
					  bootstrapValidator.updateStatus("fdEndDate", 'NOT_VALIDATED').validateField("fdEndDate");  	          	             
	        });
		  $("#fdPaymentDate").xfdaterangepicker({autoUpdateInput:true,singleDatePicker:true,
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		$("#paymentType").on("change",function(){
			$("small[data-bv-for='fdEndDate']").hide();
			$("small[data-bv-for='fdPaymentMonths']").hide();
		   			var paymentType=$("#paymentType").val();
		   			if(paymentType=="0"){
		   				$("#fdEndDate").show();
		   				$("#fdPaymentMonths").hide();
		   			}else{
		   				$("#fdPaymentMonths").show();
		   				$("#fdEndDate").hide();
		   			}
		   			
		   			
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
             	   //发布名称
                    fdPaymentMonths: {
                        validators: {
                            notEmpty: {
                            },regexp: {
                            	 message: '请输入正整数',
	                             regexp: /^[1-9]\d*$/
	                         }
                        }
                    },
                    fdEndDate: {
                        validators: {
                            notEmpty: {
                            },regexp: {
                           	 message: '请输入正确日期格式(yyyy-dd)',
                             regexp: /^\d{4}(\-)\d{1,2}$/
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
	             			    		parentIframe.refreshCorpRecord();
	             			    	}
                            	 xfui.closeDialog();
                             }
                         })
                         
                     }, 'json');

                 });
        }
   	  



