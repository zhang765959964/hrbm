function delWageStandard(){
	//var ids=$("#wageStandardList").jqGrid("getGridParam","selarrrow");
	var ids=$("#wageStandardList").jqGrid("getGridParam","selrow");
	if(ids&&ids.length>0){
		/*var id="";
		$.each(ids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
		});*/
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/storage/wageStandard/del.xf',
		    		data:{id:ids},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message); 	
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		    			refresh();
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 

function refresh(){
	$("#wageStandardList").trigger("reloadGrid");
}

function initFormSubimt(){
    $('#wageStandardForm').bootstrapValidator({
          message: 'This value is not valid',
          feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
          },
          fields: {
       	   //调整日期
              adjustDate: {
                  validators: {
               	   notEmpty: {
                    	   message: '调整日期不允许为空'
                      },
                      date: {
                           format: 'YYYY-MM-DD',
                           message: '请输入正确的时间格式'
                      }
                  }
              },
              //出生年月
           	  aac006: {
                    validators: { 
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
           	  	   }
           	  },
              //参加工作时间
           	  expStartJobDate: {
                    validators: { 
                        date: {
                            format: 'YYYY-MM-DD',
                            message: '请输入正确的时间格式'
                        }
           	  	   }
           	  },
              //现岗位工种
              positionType: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //执行何种工资制度
              ja01: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              ja02: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              ja03: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
                       regexp: /^\d*\.{0,1}\d{0,2}$/,
                       message: '数字不合法'
                     }
                  }
              },
              //
              ja04: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              ja05: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              //
              ja06: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              //
              ja07: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              //执行何种工资制度
              jb01: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              jb02: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              jb03: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              //
              jb04: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              jb05: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              //
              jb06: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              //
              jb07: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              ja09: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              ja10: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
	                      }
                  }
              },
              //
              jb09: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 50
                      }
                  }
              },
              //
              jb10: {
                  validators: {
               	   stringLength: {
                          min: 0,
                          max: 6
                      },
                      regexp: {
	                        regexp: /^\d*\.{0,1}\d{0,2}$/,
	                        message: '数字不合法'
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
                       	refresh();
                       }
                   })
               }, 'json');
           });
  }