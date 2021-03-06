$(function(){
	 initFormSubimt();
})
function initFormSubimt(){
     $('#examinationRegisterForm').bootstrapValidator({
           message: 'This value is not valid',
           feedbackIcons: {
               valid: 'glyphicon glyphicon-ok',
               invalid: 'glyphicon glyphicon-remove',
               validating: 'glyphicon glyphicon-refresh'
           },
           fields: {
        	   //工作单位
        	   workUnit: {
                   validators: {
                       stringLength: {
                           min: 2,
                           max: 50
                       }
                   }
               },//联系电话
               contactNumber: {
                   validators: {
                	   stringLength: { max: 15 },
		               		regexp: {
		               		regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
		                     			message: '电话号码或手机号码格式不正确'
                       }
                   }
               },//工作年龄
               workingAge: {
                   validators: {
                       stringLength: {
                           min: 0,
                           max: 3
                       }
                   }
               },//考试成绩
               examinationChengji: {
                   validators: {
                       stringLength: {
                           min: 0,
                           max: 25
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
	  $('#examinationRegisterForm').submit();
  }