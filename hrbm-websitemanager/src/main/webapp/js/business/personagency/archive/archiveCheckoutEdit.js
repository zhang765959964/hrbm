 $(function(){
	  initFormSubimt();
	  $("#checkoutDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "archiveCheckoutForm",
		  "opens":"right",
		  "drops": "down",
             "locale": {
                 "format": "YYYY-MM-DD"
             }
         });
	  $("#checkoutPeriodDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "archiveCheckoutForm",
		  "opens":"right",
		  "drops": "down",
             "locale": {
                 "format": "YYYY-MM-DD"
             }
         });
 })
 
function initFormSubimt(){
    $('#archiveCheckoutForm').bootstrapValidator({
          message: 'This value is not valid',
          feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
        	  //借阅类别
              checkoutType: {
                   validators: { notEmpty: {message: '请选择借阅类别' } }
              },/* 
             //暂扣材料
              seizureMaterial: {
                   validators: { notEmpty: {message: '请选择暂扣材料' } }
              },
              */
              //暂扣材料
              msCheckoutMortgage11: {
                   validators: { notEmpty: {message: '请选择暂扣材料' } }
              },
        	  //借阅人
              checkoutPerson: {
                   validators: { 
                	   notEmpty: {message: '借阅人不允许为空' },
                	   stringLength: {min: 0,max: 16 } 
              	   }
          	  },
          	  //借阅人电话
             checkoutPersonPhone:{
            	validators: {
            			notEmpty: {message: '借阅人电话不允许为空' },
            		 	stringLength: { max: 15 },
	               		regexp: {
	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	              			message: '电话号码或手机号码格式不正确'
	               		}
            	}
             },
             //借阅单位
             checkoutCorp: {
                  validators: { stringLength: {min: 0,max: 32 } }
         	  },
         	  //借阅内容
              checkoutContent: {
                   validators: { stringLength: {min: 0,max: 120 } }
          	  },
          	  //借阅原因
              checkoutReason: {
                   validators: { stringLength: {min: 0,max: 120 } }
          	  },
          	  //借阅日期
              checkoutDate: {
                   validators: { 
                       date: {
                           format: 'YYYY-MM-DD',
                           message: '请输入正确的时间格式'
                       },
         				callback: {
          					message: '借阅日期不能大于借阅期限日期',
          					callback:function(value, validator,$field,options){
      							var end = $("#checkoutPeriodDate").val();
      							var begin = value;
          						var flag =  jxDateBetween(begin,end);
          						if(flag){
          							return false;
          						}else{
          							validator.updateStatus("checkoutPeriodDate", "VALID");
          							return true;
          						}
          					}
          				}
          	  	   }
          	  },
          	  //借阅期限日期
              checkoutPeriodDate: {
                  validators: { 
                      date: {
                          format: 'YYYY-MM-DD',
                          message: '请输入正确的时间格式'
                      },
        			  callback: {
          					message: '借阅期限日期不能小于借阅日期',
          					callback:function(value, validator,$field){
          						var begin = $("#checkoutDate").val();		//开始时间
          						var flag = jxDateBetween(begin,value);
          						if(flag){
          							return false;
          						}else{
          							validator.updateStatus("checkoutDate", "VALID");
          							return true;
          						}
          						
          					}
          				}
         	  	   }
         	  },
          	  //备注
              checkoutDesc: {
                   validators: { stringLength: {min: 0,max: 120 } }
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