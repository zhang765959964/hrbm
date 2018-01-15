$(function(){

    $('#socialSubsidyForm').on('submit', function(e) {
  	  
      	var bootstrapValidator = $("#socialSubsidyForm").data('bootstrapValidator');  
      	
 		 if(personData){
 			  if(personData.makeup==1){
 				  
 			  }else if(personData.archiveStatus==2){
 				  bootbox.alert("调出人员不能申报补贴")
 				  bootstrapValidator.setAllowSubmit(false);
 			  }else if(personData.archiveStatus==3){
 				  bootbox.alert("死亡人员不能申报补贴")
 				  bootstrapValidator.setAllowSubmit(false);
 			  }else{
 				  if(personData.archiveFlowStatus==1){
 	    				 bootbox.alert("借阅登记不能办理此业务！"); 
 	    				 bootstrapValidator.setAllowSubmit(false);
 	    			 }else if(personData.archiveFlowStatus==2){
 	    				 bootbox.alert("借阅确认不能办理此业务！"); 
 	    				 bootstrapValidator.setAllowSubmit(false);
 	    			 }else if(personData.archiveFlowStatus==3){
 	    				 bootbox.alert("返还登记不能办理此业务！"); 
 	    				 bootstrapValidator.setAllowSubmit(false);
 	    			 }else if(personData.archiveFlowStatus==5){
 	    				 bootbox.alert("调出登记不能办理此业务！");
 	    				 bootstrapValidator.setAllowSubmit(false);
 	    			 }else if(personData.archiveReceiveStatus!=2){
 	        			 bootbox.alert("档案未入库不能办理此业务！"); 
 	        			 bootstrapValidator.setAllowSubmit(false);
 	        		 }
 			  }
     			  
 			}else{
 				bootbox.alert("没有档案信息不能办理此业务！");
 				 bootstrapValidator.setAllowSubmit(false);
 			}
        
 	 })
	 initFormSubimt();
	 initDate();
	 bindEvent();

			
 })
 function bindEvent(){
	  $("input[name=pensionMonths]").on("click",function(){
		  var pensionStandard=$("#pensionStandard").val();
		  var months= $("input[name=pensionMonths]:checked").length;
		  var pensionAmount=accMul(pensionStandard,months);//parseFloat(pensionStandard)*parseInt(months);
		  $("#pensionAmount").val(pensionAmount);
		  $("#pensionTotalMonths").val(months);
		  setTotalAmount();
		  var bootstrapValidator = $("#socialSubsidyForm").data('bootstrapValidator');  
		  bootstrapValidator.updateStatus('pensionTotalMonths', 'NOT_VALIDATED').validateField('pensionTotalMonths'); 

	  })
	  $("input[name=medicalMonths]").on("click",function(){
		  var medicalStandard=$("#medicalStandard").val();
		  var months= $("input[name=medicalMonths]:checked").length;
		  var medicalAmount=accMul(medicalStandard,months);//parseFloat(medicalStandard)*parseInt(months);
		  $("#medicalAmount").val(medicalAmount);
		  $("#medicalTotalMonths").val(months);
		  setTotalAmount();
		  var bootstrapValidator = $("#socialSubsidyForm").data('bootstrapValidator');  
		  bootstrapValidator.updateStatus('medicalTotalMonths', 'NOT_VALIDATED').validateField('medicalTotalMonths'); 
	  })
		$("#pensionAllsel").on("click",function(){
			var pensionStandard=$("#pensionStandard").val();
		     $("input[name=pensionMonths]").prop("checked",true);
			var pensionAmount=accMul(pensionStandard,12);
			$("#pensionAmount").val(pensionAmount);
			$("#pensionTotalMonths").val(12);
			setTotalAmount();
			  var bootstrapValidator = $("#socialSubsidyForm").data('bootstrapValidator');  
			  bootstrapValidator.updateStatus('pensionTotalMonths', 'NOT_VALIDATED').validateField('pensionTotalMonths'); 
		  });
		$("#pensionAllNosel").on("click",function(){

		    $("input[name=pensionMonths]").prop("checked",false);
			$("#pensionAmount").val(0);
			$("#pensionTotalMonths").val(0);
			setTotalAmount();
			  var bootstrapValidator = $("#socialSubsidyForm").data('bootstrapValidator');  
			  bootstrapValidator.updateStatus('pensionTotalMonths', 'NOT_VALIDATED').validateField('pensionTotalMonths'); 
		});
		$("#medicalAllsel").on("click",function(){
			 var medicalStandard=$("#medicalStandard").val();
			  $("input[name=medicalMonths]").prop("checked",true);
			 var medicalAmount=accMul(medicalStandard,12);//medicalStandard*12;
			 $("#medicalAmount").val(medicalAmount);
			 $("#medicalTotalMonths").val(12);
			 setTotalAmount();
			  var bootstrapValidator = $("#socialSubsidyForm").data('bootstrapValidator');  
			  bootstrapValidator.updateStatus('medicalTotalMonths', 'NOT_VALIDATED').validateField('medicalTotalMonths'); 
		});
		$("#medicalAllNosel").on("click",function(){
			$("input[name=medicalMonths]").prop("checked",false);
			 $("#medicalAmount").val(0);
			 $("#medicalTotalMonths").val(0);
			 setTotalAmount();
			  var bootstrapValidator = $("#socialSubsidyForm").data('bootstrapValidator');  
			  bootstrapValidator.updateStatus('medicalTotalMonths', 'NOT_VALIDATED').validateField('medicalTotalMonths'); 
		});
}
 function initDate(){
	  $("#pensionStartDate").xfdaterangepicker({singleDatePicker:true,autoUpdateInput:false,formValidatorId:'socialSubsidyForm',
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM"
          }
      });
	  $("#pensionEndDate").xfdaterangepicker({singleDatePicker:true,autoUpdateInput:false,formValidatorId:'socialSubsidyForm',
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM"
          }
      });
	  $("#medicalStartDate").xfdaterangepicker({singleDatePicker:true,autoUpdateInput:false,formValidatorId:'socialSubsidyForm',
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM"
          }
      });
	  $("#medicalEndDate").xfdaterangepicker({singleDatePicker:true,autoUpdateInput:false,formValidatorId:'socialSubsidyForm',
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM"
          }
      });
	  $("#contractSignDate").xfdaterangepicker({singleDatePicker:true,autoUpdateInput:false,
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#contractEndDate").xfdaterangepicker({singleDatePicker:true,autoUpdateInput:false,
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	  $("#contractDestoryDate").xfdaterangepicker({singleDatePicker:true,autoUpdateInput:false,
		  "opens":"right",
		  "drops": "up",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
}
  function setTotalAmount(){
	var pensionAmount=$("#pensionAmount").val();
	var medicalAmount=$("#medicalAmount").val();
	var totalAmount=accAdd(pensionAmount, medicalAmount);
	$("#totalAmount").val(totalAmount);
  }
	function accMul(arg1,arg2)
	{
	  var m=0,s1=arg1.toString(),s2=arg2.toString();
	  try{m+=s1.split(".")[1].length}catch(e){}
	  try{m+=s2.split(".")[1].length}catch(e){}
	  return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
	}
	function accAdd(arg1,arg2){
		  var r1,r2,m;
		  try{r1=arg1.toString().split(".")[1].length}catch(e){r1=0}
		  try{r2=arg2.toString().split(".")[1].length}catch(e){r2=0}
		  m=Math.pow(10,Math.max(r1,r2))
		  return (arg1*m+arg2*m)/m
	}
	function accDiv(arg1,arg2){
		  var t1=0,t2=0,r1,r2;
		  try{t1=arg1.toString().split(".")[1].length}catch(e){}
		  try{t2=arg2.toString().split(".")[1].length}catch(e){}
		  with(Math){
		  r1=Number(arg1.toString().replace(".",""))
		  r2=Number(arg2.toString().replace(".",""))
		  return (r1/r2)*pow(10,t2-t1);
		  }
	}
 function initFormSubimt(){
	 

	 var personIds  = $("#currentPersonId").val();	//人员id
	

     $('#socialSubsidyForm').bootstrapValidator({
           message: 'This value is not valid',
           feedbackIcons: {
               valid: 'glyphicon glyphicon-ok',
               invalid: 'glyphicon glyphicon-remove',
               validating: 'glyphicon glyphicon-refresh'
           },
           fields: {
        	   //联系电话
        	   expPersonPhone:{
        		   validators: {
        			   stringLength: { max: 15 },
	               		regexp: {
              					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
                    			message: '电话号码或手机号码格式不正确'
	               		}
                   }  
        	   },
        	   //手机号
        	   aae005:{
        		   validators: {
        			   notEmpty: {
                       },
                       regexp: {
                    	    regexp: /^1[34578]\d{9}$/,
                  			message: '手机号码格式不正确'
                       }
                   }  
        	   },
        	   //再就业优惠证编号
        	   expRegisgration:{
        		   validators: {
        			   stringLength: {min: 1,max: 20, message:'长度在1-20位之间' },
               		   regexp: {
	                       regexp: /^[a-zA-Z0-9]+$/,
	                       message: '只能包含字母和数字'
	                   }
                   }  
        	   },
        	   //发布名称
        	   oldSubsidyNum:{
        		   validators: {
                       stringLength: {
                           max: 20
                       }, 
                       regexp: {
                           regexp: /[a-zA-Z0-9]+/
                       }
                   }  
        	   },
        	   subsidyNum:{
        		   validators: {
                       stringLength: {
                           max: 20
                       },regexp: {
                           regexp: /[a-zA-Z0-9]+/
                       }
                   }  
        	   },
               pensionTotalMonths: {
                   validators: {
                       notEmpty: {
                       }
                   }
               },
               pensionStandard: {
                   validators: {
                       notEmpty: {
                       }
                   }
               },
               pensionStartDate: {
                   validators: {
                	   notEmpty: {
                       },
                       regexp: {
                        	 message: '请输入正确日期格式(yyyy-dd)',
                             regexp: /^\d{4}(\-)\d{1,2}$/
                         }
                   }
               },
               pensionEndDate: {
                   validators: {
                	   notEmpty: {
                       },
                       regexp: {
                        	 message: '请输入正确日期格式(yyyy-dd)',
                             regexp: /^\d{4}(\-)\d{1,2}$/
                         }
                   }
               },
               medicalStandard: {
                   validators: {
                       notEmpty: {
                       }
                   }
               },
               medicalStartDate: {
                   validators: {
                       regexp: {
                        	 message: '请输入正确日期格式(yyyy-dd)',
                             regexp: /^\d{4}(\-)\d{1,2}$/
                         }
                   }
               },
               medicalEndDate: {
                   validators: {
                       regexp: {
                        	 message: '请输入正确日期格式(yyyy-dd)',
                             regexp: /^\d{4}(\-)\d{1,2}$/
                         }
                   }
               },
               bankName: {
                   validators: {
                       stringLength: {
                           max: 15
                       }
                   }
               },
               bankCardNo: {
                   validators: {
                       stringLength: {
                           max: 20
                       },
                       regexp: {
                           regexp: /^([+-]?)\d*\.?\d+$/
                       }
                   }
               },
               busLicNum:{
            	   validators: {
                       stringLength: {
                           max: 20
                       },
                       regexp: {
                    	   regexp: /[a-zA-Z0-9]+/
                       }
                   }
               },
               //签订劳动合同开始时间
               contractSignDate : {
            	   validators: {
            		   date: {
                           format: 'YYYY-MM-DD',
                           message: '请输入正确的时间格式'
                       }
                   }
               },
               //签订劳动合同终止时间
               contractEndDate : {
            	   validators: {
            		   date: {
                           format: 'YYYY-MM-DD',
                           message: '请输入正确的时间格式'
                       }
                   }
               },
               //劳动合同解除日期
               contractDestoryDate : {
            	   validators: {
            		   date: {
                           format: 'YYYY-MM-DD',
                           message: '请输入正确的时间格式'
                       }
                   }
               },
               //已在外单位享受补贴月数
               outerSubsidyMonths : {
                	 validators: {
                		 regexp: {
                			 regexp : /^[0-9]*$/,
                			 message : '请输入正确的月数'
                		 },
                		 stringLength: {
                             max: 3
                         }
                         
                     }
                },
               //原工作单位
               expOldCompany : {
            	   validators: {
            		   stringLength: {
                           max: 25
                       }
                   }
               },
               //备注
               description :{
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
            	//bv.disableSubmitButtons(true);
              if(personIds>0){
            	  $.post($form.attr('action'), $form.serialize(), function(data) {
                        bootbox.alert({
                            size: 'small',
                            width:"100px",
                            message: data.message,
                            callback:function(){
                            	bv.disableSubmitButtons(false);
                            	var currentPersonId=$("#currentPersonId").val();
                            	$("#socialEdit").load(CTX+"/business/personagency/subsidy/socialSubsidy/edit.xf?personId="+ currentPersonId);
                            }
                        })

                    }, 'json');
           	 }else{
           		 bootbox.alert("请先选择人员信息"); 
           	 }
                
                
              

            });
   }
  function addItem(){
	  $("#socialEdit").load(CTX+"/business/personagency/subsidy/socialSubsidy/edit.xf");
  }