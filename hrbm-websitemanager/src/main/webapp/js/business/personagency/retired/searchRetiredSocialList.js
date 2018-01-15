 $(function(){
		 initFormSubimt();
		  $("#retiredSocialDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  formValidatorId : "retiredSocialForm",
			  "opens":"right",
			  "drops": "up",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });


		 
	 })
     function initFormSubimt(){
         $('#retiredSocialForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //
                  retiredSocialNo : {
                       validators: {
                           notEmpty: {
                        	   message:'转社会化协议编号不能为空！'
                           },
                           stringLength: {
                               min: 2,
                               max: 10
                           }
                       }
                   },
                   retiredSocialName: {
                       validators: {
                           notEmpty: {
                        	   message:'对方经办人不能为空！'
                           },
                           stringLength: {
                               min: 2,
                               max: 25
                           }
                       }
                   },
                   retiredSocialUnit: {
                       validators: {
                           stringLength: {
                               min: 2,
                               max: 25
                           }
                       }
                   },
                   retiredSocialDate : {
                       validators: {
                           notEmpty: {
                        	   message:'转社会化协议日期不能为空！',
                           },
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
                  var ids=$("#retiredSocialList").jqGrid("getGridParam","selarrrow");
                  if(ids&&ids.length>0){
	      			  var id="";
	      			  $.each(ids,function(i,e){
	      					if(i==0){
	      						id+=e;
	      					}else{
	      						id+=","+e;
	      					}
	      				});
	      		  var toJson=$("#retiredSocialForm").serializeJson();
	      		  toJson.pk_id=id;
	      		  $.post($form.attr('action'), toJson, function(data) {
	                   bootbox.alert({ 
	                       size: 'small',
	                       width:"100px",
	                       message: data.message,
	                       callback :function (){
	                    	   bv.disableSubmitButtons(false);
	                    	   $("#retiredSocialList").trigger("reloadGrid");
	                       }
	                   })
	                  }, 'json'); 
                  }else{
                	  bootbox.alert('请选择记录');			
                	  bv.disableSubmitButtons(false);
                  }
	           });
       }
 
 	  //退休人员转社会化打印
 	  function printRetiredSocial(){
 		 var ids=$("#retiredSocialList").jqGrid("getGridParam","selarrrow");
 	     if(ids&&ids.length>0){
 				  var id="";
 				  $.each(ids,function(i,e){
 						if(i==0){
 							id+=e;
 						}else{
 							id+=","+e;
 						}
 					});
 				  var params = {"personIds" :ids};
 				  templatePrint("retiredSocial",params);
 	      }else{
 	        	  bootbox.alert('请选择记录');	
 	      }
 		  
 		  
 	  }
 
 
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	  function submitForm(){
		  $('#retiredSocialForm').submit();
	  }

	  function refresh(){
		  $("#retiredSocialList").trigger("reloadGrid");
	  }