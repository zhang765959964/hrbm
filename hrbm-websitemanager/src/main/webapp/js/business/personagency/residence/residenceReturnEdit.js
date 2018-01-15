 $(function(){
		 initFormSubimt();
			  $("#borrowerDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId : "residenceReturnForm",
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#maturityDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId : "residenceReturnForm",
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  
	 })
     function initFormSubimt(){
         $('#residenceReturnForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
		          	 //借用人姓名
		             borrowerName : {
		                     validators: {
		                         notEmpty: {
		                        	 
		                         }, stringLength: {
		                               min: 2,
		                               max: 25
		                           }
		                     }
		               },//借用日期
		               borrowerDate : {
		                     validators: {
		                         notEmpty: {message: '借用日期不予许为空'},
		                         date: {
		                                format: 'YYYY-MM-DD',
		                                message: '请输入正确的时间格式'
		                         },
	              				 callback: {
	              					message: '借用日期不能大于到期日期',
	              					callback:function(value, validator,$field){
	          							var end = $("#maturityDate").val();
	          							var begin = value;
	              						var flag =  dateBetween(begin,end);
	              						if(flag){
	              							return false;
	              						}else{
	              							validator.updateStatus("maturityDate", "VALID");
	              							return true;
	              						}
	              					}
	              				}
		                     }
		               },//到期日期
		               maturityDate : {
		                   validators: {
		                       notEmpty: {message: '到期日期不予许为空'},
		                       date: {
	                                format: 'YYYY-MM-DD',
	                                message: '请输入正确的时间格式'
	                           },
	              			   callback: {
	              					message: '到期日期不能小于借用日期',
	              					callback:function(value, validator,$field){
	              						var begin = $("#borrowerDate").val();		
	              						var flag = dateBetween(begin,value);
	              						if(flag){
	              							return false;
	              						}else{
	              							validator.updateStatus("borrowerDate", "VALID");
	              							return true;
	              						}
	              						
	              					}
	              			 }
		                   }
		               }, //身份证号
		               borrowerCard : {
	                       validators: {
	                    	   callback: {
	            					message: '身份证号格式不正确',
	            					callback:function(value, validator,$field){
	            						if(!value){
	            							return true;
	            						}
	            						return validateIdCard(value);
	            					}
	            			   }
	                       }
	                   },//联系电话
		               borrowerPhone : {
		                     validators: {
		                    	 notEmpty: {
		                         },
		                         stringLength: { max: 15 },
				               		regexp: {
			               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
			                     			message: '电话号码或手机号码格式不正确'
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
            			    		parentIframe.refresh3();
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