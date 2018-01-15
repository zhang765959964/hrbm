 $(function(){
		 initFormSubimt();
			  $("#retiredCardDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput :false,
				  formValidatorId : "retiredCardForm",
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
	 })
     function initFormSubimt(){
         $('#retiredCardForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //
                  retiredCardDate : {
                       validators: {
                           notEmpty: {
                        	   message:'领取退休时间不能为空！'
                           },
                           date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           }
                          
                       }
                   },
                   retiredCardName : {
                       validators: {
                           notEmpty: {
                        	   message:'退休证领取人不能为空！'
                           },
                           stringLength: {
                               min: 2,
                               max: 25
                           }
                       }
                   },
                   retiredCardCode : {
                       validators: {
                           notEmpty: {
                        	   message:'退休证号不能为空！'
                           },
                           remote: {
                               type: 'POST',
                               url: CTX+'/business/personagency/retired/card/isExitCode.xf?noid='+$("#id").val(),
                               message: '已有此退休证号,不能重复添加！',
                               delay: 1000
                           },
                           stringLength: {
                               min: 2,
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
               var retiredId = $("#retiredId").val();
         	   var retiredCardCode =  $("#retiredCardCode").val();
               if(retiredId>0){
				  $.post($form.attr('action'), $form.serialize(), function(data) {
                   bootbox.alert({ 
                       size: 'small',
                       width:"100px",
                       message: data.message,
                       callback :function (){
                    	   bv.disableSubmitButtons(false);
                           $("#retiredCardList").trigger("reloadGrid");
                      }
                   })
                        
                  }, 'json');
               }else{
            	   bootbox.alert('请选择记录');
               }
               });
       }
 		
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	  function submitForm(){
		  $('#retiredCardForm').submit();
		
	  }