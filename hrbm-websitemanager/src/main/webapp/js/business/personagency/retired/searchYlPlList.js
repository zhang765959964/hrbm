	$(function(){
 			 initFormSubimt1();
			 $("#payDate1").xfdaterangepicker({singleDatePicker:true,
				  formValidatorId : "yangLaoForm1",
				  autoUpdateInput:false,
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
			  $("#retiredDate1").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,
				  formValidatorId : "yangLaoForm1",
				  "opens":"right",
				  "drops": "up",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
	 }) 
	 
	 function initFormSubimt1(){
	    $('#yangLaoForm1').bootstrapValidator({
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
                                message: '请输入正确的时间格式!'
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
                                message: '请输入正确的时间格式!'
                            }
                        }
                    }
               }
           }).on('success.form.bv', function(e) {
               e.preventDefault();
               var $form = $(e.target);
               var bv = $form.data('bootstrapValidator');
               bv.disableSubmitButtons(true);
                 var ids=$("#yangLaoList1").jqGrid("getGridParam","selarrrow");
                 if(ids&&ids.length>0){
	      			  var id="";
	      			  $.each(ids,function(i,e){
	      					if(i==0){
	      						id+=e;
	      					}else{
	      						id+=","+e;
	      					}
	      				});
	      		  var toJson=$("#yangLaoForm1").serializeJson();
	      		  toJson.pk_id=id;
	      		  $.post($form.attr('action'), toJson, function(data) {
	      			//bv.disableSubmitButtons(false);
	                   bootbox.alert({ 
	                       size: 'small',
	                       width:"100px",
	                       message: data.message,
	                       callback :function (){
	                          	$("#yangLaoList1").trigger("reloadGrid");
	                        	$("#yangLaoList").trigger("reloadGrid");
	                        	bv.disableSubmitButtons(false);
	                        }
	                   })
	                  }, 'json'); 
                  }else{
                	  bootbox.alert('请选择记录');	
                	  bv.disableSubmitButtons(false);
                  }
	           });
       }
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	  
	  
	  function printRetiredYl(){
			 var ids=$("#yangLaoList1").jqGrid("getGridParam","selarrrow");
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
					  templatePrint("retiredYl",params);
		      }else{
		        	  bootbox.alert('请选择记录');	
		      }
			  
			  
		  }