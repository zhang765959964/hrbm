 $(function(){
		 
		 initFormSubimt();
			  $("#startDate").xfdaterangepicker({autoUpdateInput:false,
				  singleDatePicker:true,
				  formValidatorId:"socialParamsForm",
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM"
	              }
	          });
              
			  $("#endDate").xfdaterangepicker({autoUpdateInput:false,
				  singleDatePicker:true,
				  formValidatorId:"socialParamsForm",
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM"
	              }
	          });
	 })
     function initFormSubimt(){
         $('#socialParamsForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //开始日期
                   startDate: {
                       validators: {
                    	   notEmpty: {
                    		   message : '开始日期不能为空'
                           },
                    	   regexp: {
                        	   regexp: /^\d{4}(\-)\d{1,2}$/,
                        	   message : '请输入正确的月份'
                           }
                       }
                   },
                   //结束日期
                   endDate: {
                       validators: {
                    	   notEmpty: {
                    		   message : '结束日期不能为空'
                           },
                    	   regexp: {
                        	   regexp: /^\d{4}(\-)\d{1,2}$/,
                        	   message : '请输入正确的月份'
                           }
                       }
                   },
                   //参数值
                   paramsValue: {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               max: 10
                           },
                           regexp: {
                        	   regexp: /^([+-]?)\d*\.?\d+$/,
                        	   message : '请输入字符'
                           }
                           
                       }
                   },
                   //描述
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