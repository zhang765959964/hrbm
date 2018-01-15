$(function(){
	initFormSubimt();
	$("#applicationDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "residenceForm",
		  "opens":"right",
		  "drops": "down",
       "locale": {
           "format": "YYYY-MM-DD"
       }
   });
	$("#applicationOneselfDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "residenceForm",
		  "opens":"right",
		  "drops": "down",
       "locale": {
           "format": "YYYY-MM-DD"
       }
   });
	$("#noticeDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput:false,
		  formValidatorId : "residenceForm",
		  "opens":"right",
		  "drops": "down",
       "locale": {
           "format": "YYYY-MM-DD"
       }
   });
})
 function initFormSubimt(){
     $('#residenceForm').bootstrapValidator({
           message: 'This value is not valid',
           feedbackIcons: {
               valid: 'glyphicon glyphicon-ok',
               invalid: 'glyphicon glyphicon-remove',
               validating: 'glyphicon glyphicon-refresh'
           },
           fields: {
        	   //材料类别
               materialCategory: {
                   validators: {
                       notEmpty: {}
                   }
               },
               materialName: {
                   validators: {
                	   stringLength: {
                           min: 0,
                           max: 50
                       }
                   }
               },
               //手机号
               aae005:{
                  	validators: {
                  		 stringLength: { max: 15 },
		               		regexp: {
	               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	                     			message: '电话号码或手机号码格式不正确'
		               		}
                  	}
               },
               backReason: {
                   validators: {
                	   stringLength: {
                           min: 0,
                           max: 100
                       }
                   }
               },
               //申请日期
               applicationDate: {
                        validators: { 
                            date: {
                                format: 'YYYY-MM-DD',
                                message: '请输入正确的时间格式'
                            },
              				callback: {
              					message: '申请日期不能大于材料退回本人日期',
              					callback:function(value, validator,$field,options){
          							var end = $("#applicationOneselfDate").val();
          							var begin = value;
              						var flag =  jxDateBetween(begin,end);
              						if(flag){
              							return false;
              						}else{
              							validator.updateStatus("applicationOneselfDate", "VALID");
              							return true;
              						}
              					}
              				}
               	  	   }
               },
               //材料退回本人日期
               applicationOneselfDate: {
                        validators: { 
                            date: {
                                format: 'YYYY-MM-DD',
                                message: '请输入正确的时间格式'
                            },
              				callback: {
              					message: '材料退回本人日期不能小于申请日期',
              					callback:function(value, validator,$field){
              						var begin = $("#applicationDate").val();		//开始时间
              						var flag = jxDateBetween(begin,value);
              						if(flag){
              							return false;
              						}else{
              							validator.updateStatus("applicationDate", "VALID");
              							return true;
              						}
              						
              					}
              				}
               	  	   }
               },
               //通知日期
               noticeDate: {
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
	  $('#residenceForm').submit();
  }