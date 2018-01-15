$(function(){
	 partyInial();
	 payInial();	
	});

	function partyInial(){
		var columns= [
              	   {name:'id',label:'操作',key: true,hidden:true,align:'center',width:80},
			   	   {name:'personCard',label:'身份号',align:'center',frozen : true},
			   	   {name:'personName',label:'姓名',align:'center',frozen : true},
			   	   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
			   	   {name:'partyStatus',label:'代管组织关系',align:'center', formatter:function(value,row,index){
			   		   return "<span class='red'>"+value+"</span>";
			   		   
			   	   }},
                   {name:'partyIntoDate',label:'转入时间',align:'center'},
                   {name:'partyDate',label:'入党时间',align:'center'},
                   {name:'partyPositiveDate',label:'转正时间',align:'center'},
                   {name:'sex',label:'性别',align:'center'},
                   {name:'nationName',label:'民族',align:'center'},
                   {name:'placeName',label:'籍贯',align:'center'},
                   {name:'personCsrq',label:'出生年月',align:'center'},
                   {name:'whcdName',label:'文化程度',align:'center'},
                   {name:'shoolName',label:'毕业学校',align:'center'},
                   {name:'expAddress',label:'现居住地址',align:'center'},
                   {name:'partyOutDate',label:'转出时间',align:'center',formatter:function(value,row,index){
                	   if(value==undefined){
                		   return "";
                	   }else{
                		   return "<span class='red'>"+value+"</span>";
                	   };
			   	   }},
                   {name:'partyOutReason',label:'转出原因',align:'center',formatter:function(value,row,index){
                	   if(value==undefined){
                		   return "";
                	   }else{
                		   return "<span class='red'>"+value+"</span>";
                	   };
			   	   }},
                   {name:'partyOutWhere',label:'转出去向',align:'center',formatter:function(value,row,index){
                	   if(value==undefined){
                		   return "";
                	   }else{
                		   return "<span class='red'>"+value+"</span>";
                	   };
			   	   }},
                   {name:'partyNote',label:'备注',align:'center'},
                   {name:'createrName',label:'经办人',align:'center'},
                   {name:'createrOrgName',label:'经办机构',align:'center'},
                   {name:'createrDate',label:'经办日期',align:'center'},
                   {name:'outCreaterName',label:'转出经办人',align:'center'},
                   {name:'outCreaterDate',label:'转出经办日期',align:'center'},
                   {name:'outCreaterOrgName',label:'转出经办机构 ',align:'center'}
	      	      ];
			$("#partyList").jqGrid({
				   url:CTX+'/business/personagency/party/listJson.xf?partyPersonId='+$("#personIds").val(),
		           mtype: "GET",
				   styleUI : 'Bootstrap',
		           datatype: "json",
		           colModel: columns,
				   viewrecords: true,
				   height:400,
		           rowNum: 10,
		           rowList:[10,20,30],
		           pager: "#jqGridPager",
		           pagerpos:'left',
		           regional : 'cn',
		           recordpos:'right',
		           shrinkToFit: false,
		           height:'100%',
		           altRows:true,
		           multiselect:false,
		           autowidth: true,
		           multiboxonly : true,
		           rownumbers : true,
		           onSelectRow :function(row,e){
		        	 	var rowData = $("#partyList").jqGrid('getRowData',row);
		        	 	$.ajax({
		        	 		type : 'post',
		        	 		url : CTX+"/business/personagency/party/getPartyById.xf",
		        	 		data : {
		        	 			id : rowData.id
		        	 		},
		        	 		dataType : "json",
		        	 		async : false,
		        	 		success :function (data){
		        	 			if(data.result=="1"){	//有缴费记录
		        	 				$("#delStatus").val("1");
		        	 			}else{
		        	 				$("#delStatus").val("2");
		        	 			}
		        	 		}
		        	 	})
		           }
		       });
			
		 $("#partyList").jqGrid('setFrozenColumns');
	}
	 

	 function resetClass(){
		 $("#partySel").load(CTX+"/business/personagency/party/searchList.xf?personId="+ $("#personIds").val());
	 }
	
	
	function payInial(){
		/**
		 初始化表格显示
		*/
		var columns= [		
			              {name:'id',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
								keys: false,
								editbutton : true,
								delbutton : false,
								onSuccess:function(){
									refreshPay();
								}

						   }},
		                   {name:'partyId',label:'外键',align:'center',editable : true,hidden:true},
		                   {name:'personId',align:'center',editable : true,hidden:true},
		                   {name:'partyBeginDate',label:'交纳开始年月',align:'center',editable : true,edittype:'text',unformat: pickDate,editrules : {
		                	   required : true,
		                	   date:true,
		                	   custom:true, 
		                	   custom_func:function(value, colNames){   
		                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
		                			   return [false,"请输入YYYY-MM-DD日期格式！"];
		                			   
		                		   }else{
		                			   $("#beginDate").val(value);
			                		   return [true,""];
		                		   }
		                		 
		                	   }}
		                   },
		                   {name:'partyEndDate',label:'交纳截止年月',align:'center',editable : true,edittype:'text',unformat: pickDate,editrules :{
		                	   required : true,
		                	   date:true,
		                	   custom:true, 
		                	   custom_func:function(value, colNames){  
		                		   if(!(/^[0-9]{4}-(0?[0-9]|1[0-2])-(0?[1-9]|[12]?[0-9]|3[01])$/.test(value))){
		                			   return [false,"请输入YYYY-MM-DD日期格式！"];
		                			   
		                		   }else{
		                			   $("#endDate").val(value);
				                		  var bb = $("#beginDate").val();
				                		  var ee = $("#endDate").val();
				                		  if(bb>ee){
				                			   return [false,"缴费开始年月不能大于截止年月"];
				                		   }else{
				                			   return [true,""];
				                		   }
		                		   }
		                   		}}
		                   },
		                   {name:'partyPayMoney',label:'交纳金额',align:'center',editable : true,editoptions:{size:10,maxlength:10},
		                	   edittype:'text',editrules : {number:true,required : true}},
		                   {name:'createrName',label:'经办人名称',align:'center'},
		                   {name:'createrOrgName',label:'经办机构名称',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'}
	      	        	];
		$("#partyPayList").jqGrid({
			   url:CTX+'/business/personagency/party/pay/getAllListJson.xf?personId='+$("#personIds").val(),
			   editurl:CTX+'/business/personagency/party/pay/save.xf',
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
	           shrinkToFit: false,
	           multiselect:true,
	           height:'100%',
	           altRows:true,
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
	
	//转入
	function addParty(){
    	 var dabh = $("#dabh").val();
    	 var flag = $("#flag").val();
		 var personIds = $("#personIds").val();
		if(personIds>0){
			 if(dabh!=null)
				 if(personData.ARCHIVESTATUS==2){
					  bootbox.alert("调出人员不能办理此业务!");
				 }else if(personData.ARCHIVESTATUS==3) {
					  bootbox.alert("死亡人员不能办理此业务!")
				 }else{
					  if(personData.ARCHIVEFLOWSTATUS==1){
		    				 bootbox.alert("借阅登记不能办理此业务！"); 
		    			 }else if(personData.ARCHIVEFLOWSTATUS==2){
		    				 bootbox.alert("借阅确认不能办理此业务！"); 
		    			 }else if(personData.ARCHIVEFLOWSTATUS==5){
		    				 bootbox.alert("调出登记不能办理此业务！");
		    			 }else{
		    				 if(flag=="true"){
	        					 xfui.open_dialog({    
	         					    title: '党组织关系转入',    
	         					    width: 900,    
	         					    height: 600,    
	         					    closed: false,    
	         					    cache: false,    
	         					    url: CTX+"/business/personagency/party/add.xf?personId="+personIds,
	         					    modal: true   
	         					})
	        		    	 }else{
	        		    		 bootbox.alert("还有未转出记录！"); 
	        		    	 }
		        		 }
        	 }else{
        		 bootbox.alert("没有档案编号不能办理此业务！"); 
        	 }
		}else{
			bootbox.alert("没有档案信息不能办理此业务！");
		}
		
		
	}
	
	//转出
	function addOutParty(){
    	 var dabh = $("#dabh").val();
    	 var flag = $("#flag").val();	
		 var personIds = $("#personIds").val();
		if(personIds>0){
			 if(dabh!=null){
				 if(personData.ARCHIVESTATUS==2){
					  bootbox.alert("调出人员不能办理此业务!");
				 }else if(personData.ARCHIVESTATUS==3) {
					  bootbox.alert("死亡人员不能办理此业务!")
				 }else{
					  if(personData.ARCHIVEFLOWSTATUS==1){
		    				 bootbox.alert("借阅登记不能办理此业务！"); 
		    			 }else if(personData.ARCHIVEFLOWSTATUS==2){
		    				 bootbox.alert("借阅确认不能办理此业务！"); 
		    			 }else if(personData.ARCHIVEFLOWSTATUS==5){
		    				 bootbox.alert("调出登记不能办理此业务！");
		    			 }else{
        				 if(flag=="true"){
        					 bootbox.alert("还有未转入记录！"); 
        				 }else{
        					 xfui.open_dialog({    
          					    title: '党组织关系转出',    
          					    width: 900,    
          					    height: 600,    
          					    closed: false,    
          					    cache: false,    
          					    url: CTX+"/business/personagency/party/addOut.xf?personId="+personIds,
          					    modal: true   
          					})
        				 }
        				
        			 }
        		 }
        	 }else{
        		 bootbox.alert("没有档案编号不能办理此业务！"); 
        	 }
		}else{
			bootbox.alert("没有档案信息不能办理此业务！");
		}
			
			
	}
	
	
	
	
	
	//党费交纳
	function addPartyPay(){
		var  payId = 0;
		var partyIds = $("#partyIds").val();
		if(partyIds>0){
			 $.ajax({
			        type: "post",
			        url: CTX+"/business/personagency/receive/receive/getPrimaryKey.xf",
			        data: {name:"PartyPay"},
			        dataType: "json",
			        success: function(data){
			        	payId= data.message + "";
			        	var selectedId = $("#gridTable").jqGrid("getGridParam", "selrow");  
			        	var dataRow = {   
			            	id : payId,  
			            	personId : $("#personIds").val(),
			            	partyId : $("#partyIds").val(),
			            	personId : $("#personIds").val(),
			            	createrName : $("#createrName").val(),
			            	createrOrgName : $("#createrOrgName").val(),
			            	createrDate : $("#createrDate").val()
			            
			            };  
			            if (selectedId) {  
			                $("#partyPayList").jqGrid("addRowData", payId, dataRow, "before", selectedId);  
			            } else {  
			                $("#partyPayList").jqGrid("addRowData", payId, dataRow, "first");  
			            } 
			        }
			    });
		}else{
			bootbox.alert("请先进行转入操作！");
		}
	}
	 
	 
	
	 /**
	  * 删除党组织关系记录
	  */
	 function delParty(){
		    var personId =  $("#personIds").val();
		    var delStatus = $("#delStatus").val();
		    if(personId>0){
		    	 var id=$('#partyList').jqGrid('getGridParam','selrow');
				if(id!=null){	
			    	if(delStatus=="1"){
			    		 bootbox.alert('已有缴费记录,不能删除此记录');
			    	}else{
			    		bootbox.confirm({message:'您确认要删除此记录吗？',callback:function(r){    
						   if (r){    
						    	$.ajax({ url: CTX+'/business/personagency/party/del.xf',
						    		data:{id:id},
						    		dataType:'json',
						    		success: function(data){
						    			if(data.message){
						    				bootbox.alert(data.message); 	
						    			}else{
						    				bootbox.alert("未知错误"); 
						    			}
						    			$("#partySel").load(CTX+"/business/personagency/party/searchList.xf?personId="+ $("#personIds").val());
						             }
						    	});
						    }    
						}}); 
			    	}
			  }else{
				 bootbox.alert('请选择记录');
			 }			
		}else{
			bootbox.alert('请选择记录');
		} 	 
	 }
 

	 function delPartyPay(){
			var ids=$("#partyPayList").jqGrid("getGridParam","selarrrow");
			if(ids&&ids.length>0){
				var id="";
				$.each(ids,function(i,e){
					if(i==0){
						id+=e;
					}else{
						id+=","+e;
					}
				});
				bootbox.confirm({message:'您确认要删除此记录吗？',callback:function(r){    
				    if (r){    
				    	$.ajax({ url: CTX+'/business/personagency/party/pay/del.xf',
				    		data:{id:id},
				    		dataType:'json',
				    		success: function(data){
				    			if(data.message){
				    				bootbox.alert(data.message); 	
				    				refreshPay();
				    			}else{
				    				bootbox.alert("未知错误"); 
				    			}
				    			
				    		
				             }
				    	});
				    }    
				}}); 
			  }else{
				 bootbox.alert('请选择记录');
			 }			
		} 	 
		
	function refresh(){
		$("#partyList").trigger("reloadGrid");
	}


	function refreshPay(){
		$("#partyPayList").trigger("reloadGrid");
	}

	function pickDate( cellvalue, options, cell ) {
		setTimeout(function(){
			$(cell) .find('input[type=text]')
					.xfdaterangepicker({singleDatePicker:true,
					   autoUpdateInput:false,
					  "opens":"right",
					  "drops": "down",
			          "locale": {
			             "format": "YYYY-MM-DD"
			         }
			     });
		}, 0);
		 

	}
