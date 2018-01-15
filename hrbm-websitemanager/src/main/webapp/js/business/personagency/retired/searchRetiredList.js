 $(function(){
	 			 initForm();	
	 			 gsBeginDate();
	 			 gsEndDate();
	 			 declareType();
		 		 selType();
				 initFormSubimt();
				 initlWorkKj();
				  $("#createWorkDate").xfdaterangepicker({singleDatePicker:true,
					  autoUpdateInput:false,	
					  "opens":"right",
					  "drops": "up",
		              "locale": {
		                  "format": "YYYY-MM-DD"
		              }
		          });
				  $("#gsBDate").xfdaterangepicker({singleDatePicker:true,
					formValidatorId : "retiredDeclareForm",
				    autoUpdateInput:false,	
					  "opens":"right",
					  "drops": "up",
		              "locale": {
		                  "format": "YYYY-MM-DD"
		              }
		          });
				  
				  $("#gsStopDate").xfdaterangepicker({singleDatePicker:true,
					formValidatorId : "retiredDeclareForm",
				    autoUpdateInput:false,	
					  "opens":"right",
					  "drops": "up",
		              "locale": {
		                  "format": "YYYY-MM-DD"
		              }
		          });
				  
				  $("#createWorkDate").val($("#expStartJobDate").val());
				  $("#retiredPeopleNo").val($("#expPersonNumber").val());
		 })
		 
	
	//验证form提交
	function initForm(){
	  $("#retiredDeclareForm").on("submit", function(e) {
	      	var bootstrapValidator = $("#retiredDeclareForm").data('bootstrapValidator');
	      	 if(personData){
	 			  if(personData.ARCHIVESTATUS==2){
	 				  bootbox.alert("调出人员不能申报补贴");
	 				  bootstrapValidator.setAllowSubmit(false);
	 			  }else if(personData.ARCHIVESTATUS==3){
	 				  bootbox.alert("死亡人员不能申报补贴");
	 				  bootstrapValidator.setAllowSubmit(false);
	 			  }else{
	 				  if(personData.ARCHIVEFLOWSTATUS==1){
	 	    				 bootbox.alert("借阅登记不能办理此业务！"); 
	 	    				 bootstrapValidator.setAllowSubmit(false);
	 	    			 }else if(personData.ARCHIVEFLOWSTATUS==2){
	 	    				 bootbox.alert("借阅确认不能办理此业务！"); 
	 	    				 bootstrapValidator.SETALLOWSUBMIT(false);
	 	    			 }else if(personData.archiveFlowStatus==3){
	 	    				 bootbox.alert("返还登记不能办理此业务！"); 
	 	    				 bootstrapValidator.setAllowSubmit(false);
	 	    			 }else if(personData.ARCHIVEFLOWSTATUS==5){
	 	    				 bootbox.alert("调出登记不能办理此业务！");
	 	    				 bootstrapValidator.setAllowSubmit(false);
	 	    			 }else if(personData.ARCHIVERECEIVESTATUS!=2){
	 	        			 bootbox.alert("档案未入库不能办理此业务！"); 
	 	        			 bootstrapValidator.setAllowSubmit(false);
	 	        		 }else{
	 	        			 
	 	        		 }
	 			  }
	      	 }else{
	      		bootbox.alert("没有档案信息不能办理此业务！");
 				bootstrapValidator.setAllowSubmit(false);
	      	 }
	 	 })
	 
 }
 
		 
		 
	//公式开始时间	 
	function gsBeginDate(){
	 	
		var gsBsj = $("#gsBsj").val();
		
		if(gsBsj==""){
			  var a =  $("#gsBDate").val();
			   if(a==""){
				   var myDate = new Date();
				 	var year =	myDate.getFullYear();	  //获取完整的年份(4位,1970-????)
				 	var month = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
					if(month==11){	
				 		month = -1;
				 		year+=1;
				 	}
				 	var months = month+2;	//取得下个月的月份
				 	var years;
				 	if(months<10){
				 		months = "0"+months;
				 	}
				 	var day = "01";		//获取当前日(1-31)
				 	var newDate = year +"-" + months+"-"+day;
				 	$("#gsBDate").val(newDate);
			   }else{
				   $("#gsBDate").val(a);
			   }
			
		}else{
			 $("#gsBDate").val(gsBsj);
		}
	 
 	}	 
 
 	//公式结束时间
 	function gsEndDate(){
 		
 		var gsEsj = $("#gsEsj").val();
 		if(gsEsj==""){
 			 var a =  $("#gsStopDate").val();
 	 		 if(a==""){
 	 			var myDate = new Date();
 	 		 	var year =	myDate.getFullYear();	  //获取完整的年份(4位,1970-????)
 	 		 	var month = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
 	 		 	if(month==11){
 	 		 		month = -1;
 	 		 		year+=1;
 	 		 	}
 	 		 	var months = month+2;
 	 		 	if(months<10){
 	 		 		months = "0"+months;
 	 		 	}
 	 		 	var day = "07";		//获取当前日(1-31)
 	 		 	var newDate = year +"-" + months+"-"+day;
 	 		 	$("#gsStopDate").val(newDate);
 	 			 
 	 		 }else{
 	 			$("#gsStopDate").val(a);
 	 		 }
 		}else{
 				$("#gsStopDate").val(gsEsj);
 		}
 	
 		
 		
 		
 		
 	}
		 
		 
	function pickDate( cellvalue, options, cell ) {
		setTimeout(function(){
			$(cell) .find('input[type=text]')
					.xfdaterangepicker({singleDatePicker:true,
					  autoUpdateInput:false,	
					  "opens":"right",
					  "drops": "up",
			          "locale": {
			          "format": "YYYY-MM-DD"
			         }
			     });
		}, 0);
		 
	}
	function selType(){
			$("#retiredYj").change(function (){
				//获取一级菜单长度
				var ty = $("#retiredType").children('option:selected').val();
				var p=$(this).children('option:selected').val();
					switch (p){
						case "01":
							  $("#retiredType ").get(0).options[01].selected = true;   
							break;
						case "02":
							  $("#retiredType ").get(0).options[02].selected = true; 
							break;
						case "03":
							  $("#retiredType ").get(0).options[05].selected = true; 
							break;
						case "04":
							  $("#retiredType ").get(0).options[03].selected = true; 
							break;
						case "05":
							  $("#retiredType ").get(0).options[04].selected = true; 
							break;
						case "06":
							  $("#retiredType ").get(0).options[01].selected = true; 
							break;
						case "07":
							  $("#retiredType ").get(0).options[07].selected = true; 
							break;
					}
		
			});
		
	}	
	
	
	function declareType(){
		$("#declareType").change(function (){
			var p=$(this).children('option:selected').val();
			
			if(p==1){	//追加申报 
				var myDate = new Date();
			 	var year =	myDate.getFullYear();	  //获取完整的年份(4位,1970-????)
			 	var month = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
			 	var months = month+1;	//取得下个月的月份
			 	if(months<10){
			 		months = "0"+months;
			 	}
			 	var day = "01";		//获取当前日(1-31)
			 	var newDate = year +"-" + months+"-"+day;
			 	$("#gsBDate").val(newDate);
			 	var day1 = "07";
			 	var newDate1 = year +"-" + months+"-"+day1;
			 	$("#gsStopDate").val(newDate1);
			 	
			}else{	//正常申报
				
				var myDate = new Date();
			 	var year =	myDate.getFullYear();	  //获取完整的年份(4位,1970-????)
			 	var month = myDate.getMonth();       //获取当前月份(0-11,0代表1月)
				if(month==11){	
			 		month = -1;
			 		year+=1;
			 	}
			 	var months = month+2;	//取得下个月的月份
			 	if(months<10){
			 		months = "0"+months;
			 	}
			 	var day = "01";		//获取当前日(1-31)
			 	var newDate = year +"-" + months+"-"+day;
			 	$("#gsBDate").val(newDate);
			 	var day1 = "07";
			 	var newDate1 = year +"-" + months+"-"+day1;
			 	$("#gsStopDate").val(newDate1);
			}
			
		})
		
	}
		 
	
	
	//退休新增按钮
	function retiredClear(){
		
		var personId =  $("#personIds").val();
		if(personId>0){
			$("#retiredSel").load(CTX+"/business/personagency/retired/declare/searchList.xf");
		}
	}

	 //工作扣减
	 function initlWorkKj(){
	
			var columns= [
			              {name:'id',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
								keys: false,
								editbutton : true,
								delbutton : false,
								onSuccess:function(){
									$("#kjNum").val($("#kjNum1").val());
									kjrefresh();
								}
					  	 }},
					  	   {name:'personId',label:'人员id',align:'center',editable : true,hidden:true},
		                   {name:'createTime',label:'起始时间',align:'center',date:true, editable : true,unformat: pickDate,editrules : {
		                	   required : true,
		                	   date:true,
		                	   custom:true, 
		                	   custom_func:function(value, colNames){    
		                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
		                			   return [false,"请输入YYYY-MM-DD日期格式！"];
		                			   
		                		   }else{
		                			   $("#workJlBeginDate").val(value);
			                		   return [true,""];
		                		   }
		                   	}}
		                   
		                   },
		                   {name:'endTime',label:'终止时间',align:'center',editable : true,unformat: pickDate,editrules : {
		                	   required : true,
		                	   date:true,
		                	   custom:true, 
		                	   custom_func:function(value, colNames){    
		                		  if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
		                			   return [false,"请输入YYYY-MM-DD日期格式！"];
		                			   
		                		  }else{
		                			  $("#workJlEndDate").val(value);
			                		  var bb = $("#workJlBeginDate").val();
			                		  var ee = $("#workJlEndDate").val();
			                		  if(bb>ee){
			                			   return [false,"起始时间不能大于终止时间"];
			                		   }else{
			                			   return [true,""];
			                		   }
		                		  }  
		                	   }}
		                   },
		                   {name:'reason',label:'事由',align:'center',editable : true,editoptions:{size:10,maxlength:15}},
		                   {name:'kjNum',label:'扣减时间',align:'center'},
		                   {name:'createrName',label:'经办人',align:'center',edittype:'text'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center',edittype:'text'}
	      	        	];
			var personIds = $("#personIds").val();
			if(personIds==""){
				personIds=0;
			}
	    $("#workKjList").jqGrid({
	    		
	    	   url:CTX+'/business/personagency/workkj/listJson.xf?personId='+personIds,
	    	   editurl:CTX+'/business/personagency/workkj/save.xf',
	           mtype: "GET",
			   styleUI : 'Bootstrap',
	           datatype: "json",
	           colModel: columns,
			   viewrecords: true,
	           rowNum: 10,
	           rowList:[10,20,30],
	           pager: "#jqGridPager1",
	           pagerpos:'left',
	           regional : 'cn',
	           recordpos:'right',
	           height:'100%',
	           altRows:true,
	           multiboxonly : true,
	           shrinkToFit: false,
	           multiselect:true,
	           autowidth: true,
	           gridComplete:function(){
	            	  $(".ui-inline-edit").removeAttr("onclick").on("click",function(){
	            		  jQuery.fn.fmatter.rowactions.call(this,'edit');
	            	  })
	            	  $(".ui-inline-save").removeAttr("onclick").on("click",function(){
	            		  jQuery.fn.fmatter.rowactions.call(this,'save');
	            	  })
	            	  $(".ui-inline-cancel").removeAttr("onclick").on("click",function(){
	            		  jQuery.fn.fmatter.rowactions.call(this,'cancel');
	            	  })
	            	  
	             }
	       });  
	}

	    //增加工作经历扣减
		function addWorkKj(){
				if($("#personIds").val()>0){	
					 $.ajax({
					        type: "post",
					        url: CTX+"/business/personagency/receive/receive/getPrimaryKey.xf",
					        data: {name:"WorkKj"},
					        dataType: "json",
					        success: function(data){
					        	id= data.message + "";
					        	var selectedId = $("#gridTable").jqGrid("getGridParam", "selrow");  
					        	var dataRow = {   
					            	id : id,
					            	personId : $("#personIds").val(),
					            	createrName :$("#createrName1").val(),
					            	createrOrgName : $("#createrOrgName1").val(),
					            	createrDate : $("#createrDate1").val()
					            	
					            	
					            };  
					            if (selectedId) {  
					                $("#workKjList").jqGrid("addRowData", id, dataRow, "before", selectedId);  
					            } else {  
					                $("#workKjList").jqGrid("addRowData", id, dataRow, "first");  
					            } 
					        }
					    });
				}else{
					bootbox.alert("没有档案信息不能办理此业务！");
				}
			
		}

		 //增加工作经历维护
		function addWorkWh(){
				if($("#personIds").val()>0){		
				 $.ajax({
				        type: "post",
				        url: CTX+"/business/personagency/receive/receive/getPrimaryKey.xf",
				        data: {name:"WorkExperience"},
				        dataType: "json",
				        success: function(data){
				        	id= data.message + "";
				        	var selectedId = $("#gridTable").jqGrid("getGridParam", "selrow");  
				        	var dataRow = {   
				            	id : id,
				            	personId : $("#personIds").val(),
				            	createrId : $("#createrId1").val(),
				            	createrName :$("#createrName1").val(),
				            	createrOrgName : $("#createrOrgName1").val(),
				            	createrOrgId : $("#createrOrgId1").val(),
				            	createrDate : $("#createrDate1").val()
				            	
				            	
				            };  
				            if (selectedId) {  
				                $("#workExList").jqGrid("addRowData", id, dataRow, "before", selectedId);  
				            } else {  
				                $("#workExList").jqGrid("addRowData", id, dataRow, "first");  
				            } 
				        }
				    });
				}else{
					bootbox.alert("没有档案信息不能办理此业务！");
				}
			
		}
	 
		 
     function initFormSubimt(){
    	 $("#retiredDeclareForm").bootstrapValidator({
             message: 'This value is not valid',
             feedbackIcons: {
                 valid: 'glyphicon glyphicon-ok',
                 invalid: 'glyphicon glyphicon-remove',
                 validating: 'glyphicon glyphicon-refresh'
             },
             fields: {
          	   	//退休人员所属区域
                 	retiredArea : {
                      validators: {
                          notEmpty: {
                          	message: '退休人员所属区域不能为空！',
                          },
                          stringLength: {
                              min: 2,
                              max: 50
                          }
                      }
                  },
                  //退休依据
                  retiredYjId	 : {
                      validators: {
                          notEmpty: {
                          	message: '退休（退职）依据不能为空！',
                          }
                      }
                  },
                  //工种
                  craft: {
                      validators: {
                    	  stringLength: {
                              max: 25
                          }
                      }
                  },
                  
                  //参加工作日期
                  createWorkDate :{
                	    validators: {
                            date: {
                                format: 'YYYY-MM-DD',
                                message: '请输入正确的时间格式'
                            	}
                        	}
                  },
                /*  //公示开始时间
                  gsCreateDate :{
                	   validators: {
                           date: {
                               format: 'YYYY-MM-DD',
                               message: '请输入正确的时间格式'
                           	}
                       	}
                  },                 
                  //公示结束时间
                  gsStopDate : {
                	  validators: {
                          date: {
                              format: 'YYYY-MM-DD',
                              message: '请输入正确的时间格式'
                          	}
                      	}
                	  
                  },*/
                  //公示开始时间
                  gsCreateDate: {
              			validators: {
              				 date: {
                                 format: 'YYYY-MM-DD',
                                 message: '请输入正确的时间格式'
                             },
              				callback: {
              					message: '开始日期不能大于结束日期',
              					callback:function(value, validator,$field,options){
          							var end = $("#gsStopDate").val();
          							var begin = value;
              						var flag =  dateBetween(begin,end);
              						if(flag){
              							return false;
              						}else{
              							validator.updateStatus("gsStopDate", "VALID")
              							return true;
              						}
              					}
              				}
              			}
              		},
              	   //公示结束时间
              		gsStopDate: {
              			validators: {
              				 date: {
                                 format: 'YYYY-MM-DD',
                                 message: '请输入正确的时间格式'
                             },
              				callback: {
              					message: '结束日期不能小于开始日期',
              					callback:function(value, validator,$field){
              						var begin = $("#gsBDate").val();		//开始时间
              						var flag = dateBetween(begin,value);
              						if(flag){
              							return false;
              						}else{
              							validator.updateStatus("gsBDate", "VALID")
              							return true;
              						}
              						
              					}
              				}
              			}
              		},
                  "retiredDto.shbzh" : { validators: {   stringLength: { min: 2,max: 20 }  } },
                  "retiredDto.oldCompany" : { validators: {   stringLength: { min: 2,max: 25 }  } },
                  "retiredDto.addre" : { validators: {   stringLength: { min: 2,max: 50 }  } },
                  "retiredDto.phone" : { 
                	  validators: { 
                		  stringLength: { max: 15 },
		               		regexp: {
	               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	                     			message: '电话号码或手机号码格式不正确'
		               		}
                	  } 
                  },
                  "retiredDto.cardAddre" : { validators: {   stringLength: { min: 2,max: 50 }  } },
                  "retiredDto.mobilePhone" : {
                	  validators: {  
                		   regexp: {
                   			regexp: /^1[34578]\d{9}$/,
                   			message: '手机号码格式不正确'
                           }
                	  } 
                  
                  },
                  "zltzh" : { validators: {   stringLength: { min: 2,max: 25 }  } },
                  "retiredPeopleNo" : { validators: {   stringLength: { min: 2,max: 25 }  } },
                  "declareNote" : { validators: {   stringLength: { min: 2,max: 100 }  } }
                  
                  
             }
         }).on('success.form.bv', function(e) {
      	   e.preventDefault();
             var $form = $(e.target);
             var bv = $form.data('bootstrapValidator');
             bv.disableSubmitButtons(true);
             var dabh = $("#dabh").val();
        	 var personIds = $("#personIds").val();
             if(personIds>0){
        		 if(dabh!=null){
        				 $.post($form.attr('action'), $form.serialize(), function(data) {
        				 //  bv.disableSubmitButtons(false);
  		                   bootbox.alert({ 
  		                       size: 'small',
  		                       width:"100px",
  		                       message: data.message,
  		                       callback:function(){
  		                    	    bv.disableSubmitButtons(false);
  		                    	  	$("#retiredSel").load(CTX+"/business/personagency/retired/declare/searchList.xf?personId="+ $("#personIds").val());	
  		                       }
  		                   })
  		               }, 'json');
            	 }else{
            		 bootbox.alert("没有档案编号不能办理此业务！"); 
            	 }
        	 }else{
        		 bootbox.alert("没有档案信息不能办理此业务！"); 
        	 }
             
         });
    	 
       }
       
       
       
     function delByPersonId(){
    	 var personId = $("#personIds").val();
    	 var id = $("#id").val();
    	 if(id!=""){
    		 if(personId>0){
    			 bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
    				 if (r){    
    				 	$.ajax({ url:CTX+'/business/personagency/retired/declare/delByPersonId.xf',
    					    		data:{personId:personId},
    					    		dataType:'json',
    					    		success: function(data){
    					    			if(data.message){
    					    				bootbox.alert(data.message); 	
    										$("#retiredSel").load(CTX+"/business/personagency/retired/declare/searchList.xf?personId="+ personId);				    				
    					    				
    					    			}else{
    					    				bootbox.alert("未知错误"); 
    					    			}
    					             }
    					    	});
    				 }
    			}});
    		 }else{
    			bootbox.alert("请查询之后再删除！"); 
    		}
    		 
    	 }else{
    		 bootbox.alert("请进行申报之后再删除！"); 
    	 }
    	 
		
	}
       
       
       
        //删除工作维护信息
        function delWorkWh(){
			var ids=$("#workExList").jqGrid("getGridParam","selrow");
			if(ids&&ids.length>0){
				bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
				    if (r){    
				    	$.ajax({ url: CTX+'/business/personagency/experience/del.xf',
				    		data:{id:ids},
				    		dataType:'json',
				    		success: function(data){
				    			if(data.message){
				    				bootbox.alert(data.message); 	
				    			}else{
				    				bootbox.alert("未知错误"); 
				    			}
				    			whrefresh();
				             }
				    	});
				    }    
				}}); 
			  }else{
				 bootbox.alert('请选择记录');
			 }			
		} 	 
       
       
       
       
       //删除工作扣减
       function delWorkKj(){
			var ids=$("#workKjList").jqGrid("getGridParam","selrow");
			if(ids&&ids.length>0){
				bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
				    if (r){    
				    	$.ajax({ url: CTX+'/business/personagency/workkj/del.xf',
				    		data:{id:id},
				    		dataType:'json',
				    		success: function(data){
				    			if(data.message){
				    				bootbox.alert(data.message); 	
				    			}else{
				    				bootbox.alert("未知错误"); 
				    			}
				    			kjrefresh();
				             }
				    	});
				    }    
				}}); 
			  }else{
				 bootbox.alert('请选择记录');
			 }			
		} 	 
     
       
       
       function kjrefresh(){
			$("#workKjList").trigger("reloadGrid");
		}
		
	   function whrefresh(){
			$("#workExList").trigger("reloadGrid");
		}
	   
	   //打印退休审批表
	   function printRetired(){
		   var personId = $("#personIds").val();
			if(personId==0){
				bootbox.alert("请选择一记录");
				return;
			}else{
				var params = {"personId" :personId };
				templatePrint("retiredDeclare",params);
			}
	}
	   
	   
       
       