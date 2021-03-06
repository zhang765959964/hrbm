$(function(){
		 initFormSubimt();
		 initDate();
	 })
	 
	 function initDate(){
		  $("#partyIntoDate").xfdaterangepicker({singleDatePicker:true,
			   autoUpdateInput:false,
			   formValidatorId : "partyForm",
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		  $("#partyDate").xfdaterangepicker({singleDatePicker:true,
			   autoUpdateInput:false,
			   formValidatorId : "partyForm",
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		  $("#createrDate").xfdaterangepicker({singleDatePicker:true,
			   autoUpdateInput:false,
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		  $("#partySchoolDate").xfdaterangepicker({singleDatePicker:true,
			   autoUpdateInput:false,
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		  $("#partyPositiveDate").xfdaterangepicker({singleDatePicker:true,
			   autoUpdateInput:false,
			   formValidatorId : "partyForm",
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
		 
	 }
	 
     function initFormSubimt(){
         $('#partyForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	  //曾用名 
            	  "partyPersonForm.personOldName" : {
            		  validators : {
            			  stringLength: {
                              max: 5
                          }
            		  }
            	   },
            	   //籍贯
                  "partyPersonForm.placeName" : {
                       validators: {
                           notEmpty: {
                           },
                           stringLength: {
                               min: 2,
                               max: 50
                           }
                       }
                   },
                   //手机号
                   "partyPersonForm.mobilePhone" : {
                       validators: {
                           notEmpty: {
                           },
                           regexp: {
                   			regexp: /^1[34578]\d{9}$/,
                   			message: '手机号码格式不正确'
                           }
                       }
                   },
                   //联系电话
                   "partyPersonForm.phone" :{
                	   validators: {
                		   stringLength: { max: 15 },
		               		regexp: {
	               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	                     			message: '电话号码或手机号码格式不正确'
		               		}
                       }
                   },
                   //入党时间
                 	partyDate : {
                       validators: {
                    	   notEmpty: {
                    			message : '入党时间不能为空'
                    		},
                    	   date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           },
                           callback: {
             					message: '入党时间不能大于转正时间',
             					callback:function(value, validator,$field,options){
         							var end = $("#partyPositiveDate").val();
         							var begin = value;
             						var flag =  jxDateBetween(begin,end);
             						if(flag){
             							return false;
             						}else{
             							validator.updateStatus("partyPositiveDate", "VALID")
             							return true;
             						}
             					}
             				}
                           
                       }
                   },
                   //转正时间
                   partyPositiveDate : {
                	   validators: {
                    	   notEmpty: {
                    			message : '转正时间不能为空'
                    		},
                    	   date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           },
                           callback: {
            					message: '转正时间不能小于入党时间',
            					callback:function(value, validator,$field,options){
        							var end = $("#partyDate").val();
        							var begin = value;
            						var flag =  jxDateBetween(end,begin);
            						if(flag){
            							return false;
            						}else{
            							validator.updateStatus("partyDate", "VALID")
            							return true;
            						}
            					}
            				}
                           
                       }
                   },
                   //转入时间
                   partyIntoDate : {
                	   validators: {
                    	   notEmpty: {
                    			message : '转入时间不能为空'
                    		},
                    	   date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           }
                       }
                   },
                   //毕业学校
                   "partyPersonForm.partySchoolName" : {
                	   validators: {
                		   stringLength: {
                               max: 15
                           }
                       }
                   },
                   //现居住地址
                   "partyPersonForm.expAddress" : {
                	   validators: {
                		   stringLength: {
                               max: 50
                           }
                       }
                   },
                   //备注
                   partyNote : {
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
                            	var parentIframe=xfui.getParentIframe();
            			    	if(parentIframe){
            			    		parentIframe.refresh();
            			    		parentIframe.resetClass();
            			    	}
                            	closeItem(); 
                            	bv.disableSubmitButtons(false);
                            }
                        })
                        
                    }, 'json');
                  

                });
       }
     
     
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	  
	