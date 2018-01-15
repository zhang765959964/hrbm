$(function(){
	initForm();
	initDate();
	initl();
	initFormSubimt();
	$("#deathNo").val($("#expPersonNumber").val());
});

	
	function initForm(){
		$("#deathDeclareForm").on("submit", function(e) {
	      	var bootstrapValidator = $("#deathDeclareForm").data('bootstrapValidator');  
	 		 if(personData){
	 			  if(personData.ARCHIVESTATUS==2){
	 				  bootbox.alert("调出人员不能申报补贴")
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
	 	    			 }else{
	 	        			 
	 	        		 }
	 			  }
	     			  
	 			}else{
	 				bootbox.alert("没有档案信息不能办理此业务！");
	 				bootstrapValidator.setAllowSubmit(false);
	 			}
	 	 })
		
	}



	function initDate(){
		 $("#deathDate").xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput :false,
				  formValidatorId : 'deathDeclareForm',
				  "opens":"right",
				  "drops": "down",
	              "locale": {
	                  "format": "YYYY-MM-DD"
	              }
	          });
	}
	
	
	//格式化select下拉值
    function fortgz(cellvalue, options, rowObject){
	       if(value==0){
	  		   return "否";
	       }
	  	   if(value==1){
	  		   return "是";
	  	   }
	  	   if(value==undefined){
	  		   return "";
	  	   }
	}
	

	function initl(){
		/**
		 初始化表格显示
		*/
		var columns= [
		           {name:'id',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
							keys: false,
							editbutton : true,
							delbutton : false,
							onSuccess :function(){
								refresh();
							}
				   }},
				   {name:'personId',label:'人员外键',align:'center',editable : true,hidden:true},
				   {name:'deathDeclareId',label:'外键',align:'center',editable : true,hidden:true},
                   {name:'deathName',label:'姓名',align:'center',editable : true,editoptions:{size:10,maxlength:10}},
                   {name:'deathBirthDate',label:'出生日期',align:'center',editable : true,unformat: pickDate,editrules : {
                	   required : false,
                	   date:true,
                	   custom:true, 
                	   custom_func:function(value, colNames){    
                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
                			   return [false,"请输入YYYY-MM-DD日期格式！"];
                			   
                		   }else{
	                		   return [true,""];
                		   }
                	   }}
                	   
                   },
                   {name:'deathRelation',label:'与死者关系',align:'center',editable : true,editoptions:{size:10,maxlength:20}},
                   {name:'deathResaon',label:'供养理由',align:'center',editable : true,editoptions:{size:10,maxlength:50}},
                   {name:'isflag',index:"isflag",label:'原吃统销粮否',align:'center',editable : true, edittype : "select",
                       editoptions : {value : ":--请选择--;0:否;1:是"}
                   },
                   {name:'address',label:'户口所在省市（县）乡（镇）村',align:'center',editable : true,editoptions:{size:10,maxlength:50}},
                   {name:'deathEndDate',label:'抚恤救济终止年月',align:'center',editable : true,unformat: pickDate,editrules : {
                	   required : false,
                	   custom:true, 
                	   custom_func:function(value, colNames){    
                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
                			   return [false,"请输入YYYY-MM-DD日期格式！"];
                			   
                		   }else{
	                		   return [true,""];
                		   }
                	   }}
                   
                   
					}
	      	];

      	
		$("#deathDeclareList").jqGrid({
			   url:CTX+'/business/personagency/death/person/getByvDeathPersonJson.xf?personId='+$("#personIds").val(),
			   editurl:CTX+'/business/personagency/death/person/save.xf',
	           mtype: "GET",
			   styleUI : 'Bootstrap',
	           datatype: "json",
	           colModel: columns,
			   viewrecords: true,
	           rowNum: 10,
	           rowList:[10,20,30],
	           pager: "#jqGridPager",
	           pagerpos:'left',
	           regional : 'cn',
	           recordpos:'right',
	           height:'100%',
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

	   function initFormSubimt(){
		   var dabh = $("#dabh").val();
		   var personIds = $("#personIds").val();
	         $('#deathDeclareForm').bootstrapValidator({
	               message: 'This value is not valid',
	               feedbackIcons: {
	                   valid: 'glyphicon glyphicon-ok',
	                   invalid: 'glyphicon glyphicon-remove',
	                   validating: 'glyphicon glyphicon-refresh'
	               },
	               fields: {
	            	   //个人编号
	            	   deathNo: {
	                       validators: {
	                           stringLength: {
	                               max: 25
	                           }
	                       }
	                   },
	               		//亲属
	               		 relatives: {
	                       validators: {
	                           stringLength: {
	                               max: 25
	                           }
	                       }
	                   },
	                   //亲属联系电话1
	                   relativesPhoneOne: {
	                       validators: {
	                    	   stringLength: { max: 15 },
			               		regexp: {
		               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
		                     			message: '电话号码或手机号码格式不正确'
			               		}
	                       }
	                   },
	                   //亲属联系电话2 
	                   relativesPhoneTwo: {
	                       validators: {
	                    	   stringLength: { max: 15 },
			               		regexp: {
		               					regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
		                     			message: '电话号码或手机号码格式不正确'
			               		}
	                       }
	                	  
	                   },
	                   //备注
	                   deathNote: {
	                       validators: {
	                           stringLength: {
	                               max: 25
	                           }
	                       }
	                   },
	                   
	                   deathDate :{
	                	   validators: {
	                		   date: {
	                               format: 'YYYY-MM-DD',
	                               message: '请输入正确的时间格式'
	                           }
	                       }
	                   },
	                   //已统筹月离退休费
	                   retiredMonthMoney : {
	                	   validators: {
	                		   stringLength: {
	                               max: 9
	                           },
	                		   regexp: {
	                              regexp: "\[0-9]$",
	                              message: '请输入正确的退休费!'
	                		   }
	                       }
	                   },
	                   //本企业月平均工资
	                   monthAgeMoney : {
	                	   validators: {
	                		   stringLength: {
	                               max: 9
	                           },
	                		   regexp: {
	                              regexp: "\[0-9]$",
	                              message: '请输入正确的工资！'
	                		   }
	                       }
	                   },
	                   //月抚恤救济金额
	                   monthFjMoney: {
	                	   validators: {
	                		   stringLength: {
	                               max: 9
	                           },
	                		   regexp: {
	                              regexp: "\[0-9]$",
	                              message: '请输入正确的金额！'
	                		   }
	                       }
	                   },
	                   //月付粮价补金额
	                   monthFlMoney: {
	                	   validators: {
	                		   stringLength: {
	                               max: 9
	                           },
	                		   regexp: {
	                              regexp: "\[0-9]$",
	                              message: '请输入正确的金额！'
	                		   }
	                       }
	                   },
	                   //一次性抚恤救济金额
	                   oneMoney: {
	                	   validators: {
	                		   stringLength: {
	                               max: 9
	                           },
	                		   regexp: {
	                              regexp: "\[0-9]$",
	                              message: '请输入正确的金额！'
	                		   }
	                       }
	                   },
	                   //丧葬补助金额
	                   sfMoney: {
	                	   validators: {
	                		   stringLength: {
	                               max: 9
	                           },
	                		   regexp: {
	                              regexp: "\[0-9]$",
	                              message: '请输入正确的金额！'
	                		   }
	                       }
	                   }
	               }
	           }).on('success.form.bv', function(e) {
                     e.preventDefault();
                     var $form = $(e.target);
                     var bv = $form.data('bootstrapValidator');
                     bv.disableSubmitButtons(true);
	               	 if(personIds>0){
	               		 if(dabh!=null){
                				  $.post($form.attr('action'), $form.serialize(), function(data) {
                					 //   bv.disableSubmitButtons(false);
				                        bootbox.alert({ 
				                            size: 'small',
				                            width:"100px",
				                            message: data.message,
				                            callback :function(){
				                            	$("#deathSel").load(CTX+"/business/personagency/death/searchList.xf?personId="+$("#personIds").val());
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
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	

	//增加供养直系亲属情况
	function addDeath(){
			var personId =  $("#personIds").val();
			if(personId>0){
			 $.ajax({
			        type: "post",
			        url:CTX+"/business/personagency/receive/receive/getPrimaryKey.xf",
			        data: {name:"DeathPerson"},
			        dataType: "json",
			        success: function(data){
			        	id= data.message + "";
			        	var selectedId = $("#gridTable").jqGrid("getGridParam", "selrow");  
			        	var dataRow = {   
			            	id : id,
			            	personId :personId
			            };  
			            if (selectedId) {  
			                $("#deathDeclareList").jqGrid("addRowData", id, dataRow, "before", selectedId);  
			            } else {  
			                $("#deathDeclareList").jqGrid("addRowData", id, dataRow, "first");  
			            } 
			        }
			    });
		}else{
			 bootbox.alert("请先选择档案信息才能进行添加操作！");
		}
	
	}

	
	//以上两项月费用合计
	function sumMonthMoney(){
		var monthFjMoney = $("#monthFjMoney").val();
		var monthFlMoney = $("#monthFlMoney").val();
		var sum = 0;
		sum=monthFjMoney*1+monthFlMoney*1;
		$("#monthSumMoney").val(sum);
	}
	
	
	//以上两项一次性费用合计
	function sumTwoMoney(){
		var oneMoney = $("#oneMoney").val();
		var sfMoney = $("#sfMoney").val();
		var sum = 0;
		sum=oneMoney*1+sfMoney*1;
		$("#oneSumMoney").val(sum);
	}
	
	
	function delByPersonId(){
		var personId  = $("#personIds").val();
		var deathId  = $("#deathId").val();
		if(personId>0){
			if(deathId>0){
				bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
					 if (r){    
					 	$.ajax({ url: CTX+'/business/personagency/death/delByPersonId.xf',
						    		data:{personId:personId},
						    		dataType:'json',
						    		success: function(data){
						    			if(data.message){
						    				bootbox.alert(data.message); 	
						    				$("#deathSel").load(CTX+"/business/personagency/death/searchList.xf?personId="+ personId);
						    			}else{
						    				bootbox.alert("未知错误"); 
						    			}
						    			refresh();
						             }
						    	});
					 }
				
				}});
			}else{
				bootbox.alert("无待遇申报不能删除此信息！"); 
			}
	}else{
			bootbox.alert("请查询之后再删除！"); 
		}
	}



	 function delDeath(){
			var ids=$("#deathDeclareList").jqGrid("getGridParam","selarrrow");
			if(ids&&ids.length>0){
				var id="";
				$.each(ids,function(i,e){
					if(i==0){
						id+=e;
					}else{
						id+=","+e;
					}
				});
				bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
				    if (r){    
				    	$.ajax({ url: CTX+'/business/personagency/death/person/del.xf',
				    		data:{id:id},
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
	
	function refresh(){
		$("#deathDeclareList").trigger("reloadGrid");
	}
	function doSearch(){
		
		var json=$("#searchForm").serializeJson();
		$("#deathDeclareList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
	}