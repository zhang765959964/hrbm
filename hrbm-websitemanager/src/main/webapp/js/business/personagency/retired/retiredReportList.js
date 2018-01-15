var dataJson = {};
$(function(){
	initDate();
	/**
	 初始化表格显示
	*/
	var columns= [
	              		
	              	   {name:'personId',hidden:true},
	                   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	                   {name:'retiredPeopleNo',label:'个人编号',align:'center',frozen : true},
	                   {name:'xh',label:'序号',align:'center',frozen : true},
	                   {name:'retiredPeopleBm',label:'退休个人编码',align:'center'},
	                   {name:'personName',label:'姓名',align:'center'},
	                   {name:'personCard',label:'身份证号',align:'center'},
	                   {name:'sex',label:'性别',align:'center'},
	                   {name:'personCsrq',label:'出生日期',align:'center'},
	                   {name:'retiredStatus',label:'是否正式退休',align:'center'},
	                   {name:'statusName',label:'退休申报状态',align:'center'},
	                   {name:'retiredArea',label:'退休人员所属区域',align:'center'},
	                   {name:'phone',label:'联系电话',align:'center'},
	                   {name:'mobilePhone',label:'手机号',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'workJobDate',label:'参加工作时间',align:'center'},
	                   {name:'rgName',label:'符合离退休规定条款',align:'center'},
	                   {name:'payDate',label:'缴费年月',align:'center'},
	                   {name:'retiredDate',label:'应退休时间',align:'center'},
	                   {name:'gzName',label:'工种',align:'center'},
	                   {name:'declareNote',label:'申报备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'createrOgnName',label:'经办机构',align:'center'}
      	        	];
	$("#retiredReportList").jqGrid({
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "local",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           height:'100%',
           altRows:true,
           shrinkToFit: false,
           rownumbers : true,
           multiselect:false,
           autowidth: true
           
       });
	
	initDataExp();
	 $("#retiredReportList").jqGrid('setFrozenColumns');
	
//	$(".highSearch").click(function(){
//		$(".highCondition").toggle();
//	});
    
})


function initDate(){
	 $("#beginWorkJobDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
          "locale": {
             "format": "YYYY-MM-DD"
           }
     });
     
	 $("#endWorkJobDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
          }
    });
	 
	 $("#beginretiredDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
          }
    });
	 
	 $("#endretiredDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
          }
    });
	 
	 $("#beginpayDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
          }
    });
	 
	 $("#endpayDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
          }
    });
	 
	 $("#begincreaterDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
          }
    });
	 
	 $("#endcreaterDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
          }
    });

	
}

//打印退休
function printRetired(){
		var rowId=$("#retiredReportList").jqGrid("getGridParam","selrow");
		var rowData = $("#retiredReportList").jqGrid('getRowData',rowId);
		if(!rowId){
			bootbox.alert("请选择一记录");
			return;
		}else{
			var params = {"personId" :rowData.personId };
			templatePrint("retiredDeclare",params);
		}
}






function refresh(){
	$("#retiredReportList").trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retiredReportList").jqGrid("clearGridData");
	$("#retiredReportList").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/retired/card/retiredReportJson.xf',postData:json}).trigger("reloadGrid");
}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredReportList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'退休人员审批表打印',
		sheetName:'退休人员审批表打印',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
					 var id = $("#retiredReportList").jqGrid("getDataIDs");	   
					 dataJson.level = '2';
					 if(id&&id.length>0){
						 return dataJson;
					 }else{
						 bootbox.alert("无可导出的数据！");
	        			 return false;
					 }
					 
		           }},
		          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
		        	  	var ids=$("#retiredReportList").jqGrid("getGridParam","selarrrow");
		        		if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			 return {level:'2',id:id};
		        		}else{
		        			bootbox.alert("请勾选要选中的记录！");
		        			return false;
		        		}			        		
		        		
	  					}
			        },*/
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#retiredReportList").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        				
		        			});
		        			return {level:'2',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		        	      
		  				 }
				     }
		          ]
		
	});
}








