 $(function (){
		 initFormSubimt();
		 $("#uaCreatetime").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :true,
			  formValidatorId : "unitAgreementForm",
			 "opens":"right",
			 "drops": "down",
             "locale": {
                 "format": "YYYY-MM-DD"
             }
         });
		 
		 $("#stopDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  formValidatorId : "unitAgreementForm",
			  "opens":"right",
			  "drops": "up",
              "locale": {
                 "format": "YYYY-MM-DD"
             }
         });
		  
	 })
	 
	 
     function initFormSubimt(){
         $('#unitAgreementForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	   uaNo : {
                   	validators: { 
                   		notEmpty: {  message : "单位协议编号不能为空！"  }, stringLength: { max: 20 },
                   		  remote: {
                                 type: 'POST',
                                 url: CTX+'/business/unitagreement/getByUnitNo.xf?id='+$("#id").val(),
                                 message: '已有此编号！',
                                 delay: 500
                             },
                   		
                   		}
                   	},
            	   stopDate: {
                       validators: {
                           notEmpty: {
                        	   message : "终止日期不能为空！"
                           },
                           date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           }
                       }
                   },
                   uaStopCause: {
                       validators: {
                           notEmpty: {
                        	   message : "终止原因不能为空！"
                           },
                           stringLength: {
                               min: 2,
                               max: 100
                           }
                       }
                   },
                  aae006: {validators: { stringLength: {  min: 0,  max: 200  } } },
                  uaPhone:{
                  	validators: { 
                  		 stringLength: { max: 15 },
		               		regexp: {
	               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	                     			message: '电话号码或手机号码格式不正确'
		               		}
                  	}
                  
                  },
                  uaCard: {
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
                    },
                   uaContent: {validators: { stringLength: {  min: 0,  max: 200  } } },
                   uaNote: {validators: { stringLength: {  min: 0,  max: 100  } } },
                   uaName: {validators: { stringLength: {  min: 0,  max: 10  } } },
                   uaCreatetime : {
                	   validators : {
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
                    	//bv.disableSubmitButtons(false);
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: data.message,
                            callback :function (){
                            	$("#unitCorp").load(CTX+"/business/unitagreement/edit.xf?aab001="+$("#aab001").val());                          	
                            }
                           
                        })
                        
                    }, 'json');

                });
       }
 
	function submitForm(){
			 $('#unitAgreementForm').submit();	
	}
 
 
	//单位协议新增按钮
	function unitClear(){
		$("#unitCorp").load(CTX+"/business/unitagreement/edit.xf");
	}
	
	
 
 
 function updateUnit(){
	 var uaNo =  $("#uaNo").val();
	 var id = $("#id").val();
	 if(uaNo!=""){
		 $.ajax({
			 url : CTX+'/business/unitagreement/getByUnitNo.xf',
			 data : {uaNo:uaNo,id:id },
			 dataType:'json',
			 success: function(data){
				if(data.valid==false){
					bootbox.alert("已有此编号!不能进行修改操作！");
				}else{
					 $.ajax({ url: CTX+'/business/unitagreement/update.xf',
					 		data:$("#unitAgreementForm").serialize(),
					 		dataType:'json',
					 		success: function(data){
					 			if(data.message){
					 				bootbox.alert(data.message); 	
					 			}else{
					 				bootbox.alert("未知错误"); 
					 			}
					          }
					 	});
				}
			 }
			 
		 })
	 }else{
		 bootbox.alert("单位协议编号不能为空!");
	 }
	 
		
	 
	
 }

 function del(){
	 var id = $("#id").val();
	 bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){
		    if (r){
		    	$.ajax({ url: CTX+'/business/unitagreement/del.xf',
		    		data:{id:id},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message);
		    				$("#unitCorp").load(CTX+"/business/unitagreement/edit.xf?aab001="+$("#aab001").val());   
		    			}else{
		    				bootbox.alert("未知错误");
		    			}
		    			
		             }
		    	});
		    }
		}});
	
	 
 }
 
 
 