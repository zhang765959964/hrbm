 $(function(){
	   $('#archivesMakeupForm').on('submit', function(e) {
		  	  
	      	var bootstrapValidator = $("#archivesMakeupForm").data('bootstrapValidator');  
	      	
	      	if(!personData){
				 bootbox.alert("没有找到可操作的数据");
				 bootstrapValidator.setAllowSubmit(false);
			 }else{
				 if(personData.ARCHIVESTATUS==2){
				 }else if(personData.ARCHIVESTATUS==3){
					 bootbox.alert("死亡人员不能办理补录");
					 bootstrapValidator.setAllowSubmit(false);
				 }else{
					 bootbox.alert("在档人员不能办理补录");
					 bootstrapValidator.setAllowSubmit(false);
				 }
			 }
	        
	 	 })
		 initFormSubimt(); 
})
     function initFormSubimt(){
         $('#archivesMakeupForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   //曾用名
            	   expUserName: {
                       validators: {
                           stringLength: {
                               max: 25
                           }
                       }
                   },
                   //联系电话
                   expPersonPhone  : {
                       validators: {
                    	   stringLength: { max: 15 },
		               		regexp: {
	               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	                     			message: '电话号码或手机号码格式不正确'
		               		}
                       }
                   },
                   //手机号
                   aae005 : {
                	   validators: {
		                   regexp: {
		              			regexp: /^1[34578]\d{9}$/,
		              			message: '手机号码格式不正确'
		                      }
                       }
                   },
                   //再就业优惠证编号
                   expRegisgration : {
                       validators: {
                    	   stringLength: {min: 1,max: 20, message:'长度在1-20位之间' },
                   		   regexp: {
		                       regexp: /^[a-zA-Z0-9]+$/,
		                       message: '只能包含字母和数字'
		                   }
                       }
                   },
                   //身份证地址
                   expCardNumber : {
                	   validators: {
                           stringLength: {
                               max: 50
                           }
                       }
                   },
                   //就业失业登记证号码
                   acc0m1 : {
                	   validators: {
                		   stringLength: {min: 1,max: 20, message:'长度在1-20位之间' }, 
		                   regexp: {
		                       regexp: /^[a-zA-Z0-9]+$/,
		                       message: '只能包含字母和数字'
		                   }
                       }
                   },
                   //现居住地地址
                   aab301 : {
                	   validators: {
                           stringLength: {
                               max: 50
                           }
                       }
                	   
                   },
                   //基本情况备注 
                   aae013 : {
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
                            callback:function(){
                            	bv.disableSubmitButtons(false);
                            }
                        })
                        
                    }, 'json');

                });
       }
	  function submitForm(){
		  $('#archivesMakeupForm').submit();
	  }
	  
	  function addItem(){
		  $("#socialEdit").load(CTX+"/business/personagency/subsidy/makeup/edit.xf");
	  }