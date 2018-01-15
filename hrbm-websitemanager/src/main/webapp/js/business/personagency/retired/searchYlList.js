$(function(){
			 initFormSubimt();
			  $("#payDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput :false,
				  formValidatorId : "yangLaoForm",
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#retiredDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput :false,
				  formValidatorId : "yangLaoForm",
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
	 })
     function initFormSubimt(){
         $('#yangLaoForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	  //发布名称
                  payDate : {
                       validators: {
                           notEmpty: {
                        	   message : "缴费年月不能为空！"
                           },
                           date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           }
                       }
                   },
                   retiredDate: {
                       validators: {
                           notEmpty: {
                        	   message : "应退休时间不能为空！"
                           },
                           date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           }
                       }
                   },
                   declareNote: {
                       validators: {
                           stringLength: {
                               min: 2,
                               max: 200
                           }
                       }
                   }
               }
           }).on('success.form.bv', function(e) {
               e.preventDefault();
               var $form = $(e.target);
               var bv = $form.data('bootstrapValidator');
               bv.disableSubmitButtons(true);
               var id = $("#personId").val();
               if(id>0){
               $.post($form.attr('action'), $form.serialize(), function(data) {
                   bootbox.alert({ 
                       size: 'small',
                       width:"100px",
                       message: data.message,
                       callback :function (){
                    	 bv.disableSubmitButtons(false);
                       	$("#yangLaoList").trigger("reloadGrid");
                    	$("#yangLaoList1").trigger("reloadGrid");
                    	$("#personId").val("");
                    	$("#retiredYl").load("${ctx}/business/personagency/retired/declare/getRetiredByYlId.xf?id="+$("#retiredId").val());  
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
		  $('#yangLaoForm').submit();
	  }