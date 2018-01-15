var dataJson = {};
var dataJson1= {};
$(function(){
	initDate();
	initl();
	initDataExp();
	initDataExp1();
})

function initl(){
	var partyColums= [
		              {name:'id',label:'id',hidden:true},
	                  {name:'partyBeginDate',label:'交纳开始年月',align:'center'},
	                  {name:'partyEndDate',label:'交纳截止年月',align:'center'},
	                  {name:'partyPayMoney',label:'交费金额',align:'center'},
	                  {name:'createrName',label:'经办人名称',align:'center'},
	                  {name:'createrOrgName',label:'经办机构名称',align:'center'},
	                  {name:'createrDate',label:'经办日期',align:'center'}
	 	        	];
	
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'partyId',label:'党员id',align:'center',key:true,hidden:true},
	                   {name:'personId',hidden:true,frozen : true,label:'人员id'},
	                   {name:'personCard',label:'身份证号',align:'center',frozen : true},
	                   {name:'personName',label:'姓名',align:'center',frozen : true},
	                   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	                   {name:'partyStatus',label:'代管组织关系',align:'center'},
	                   {name:'isflags',label:'是否欠费',align:'center'},
	                   {name:'isParty',label:'提醒状态',align:'center'},
	                   {name:'partyBeginDate',label:'交纳开始年月',align:'center'},
	                   {name:'partyEndDate',label:'交纳截止年月',align:'center'},
	                   {name:'partyMoney',label:'交纳金额',align:'center'},
	                   {name:'mobilePhone',label:'手机号',align:'center'},
	                   {name:'phone',label:'联系电话',align:'center'},
	                   {name:'personSex',label:'性别',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'placeName',label:'籍贯',align:'center'},
	                   {name:'whcdName',label:'学历',align:'center'},
	                   {name:'personCsrq',label:'出生年月',align:'center'},
	                   {name:'age',label:'年龄',align:'center'},
	                   {name:'partyDate',label:'入党时间',align:'center'},
	                   {name:'partyAge',label:'党龄',align:'center'},
	                   {name:'WorkJobDate',label:'参加工作时间',align:'center'},
	                   {name:'workUnit',label:'工作单位',align:'center'},
	                   {name:'expCardAdd',label:'现居住地址',align:'center'},
	                   {name:'partyInfoDate',label:'转入时间',align:'center'},
	                   {name:'partyOutDate',label:'转出时间',align:'center'},
	                   {name:'reasonName',label:'转出原因',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办时间',align:'center'},
	                   {name:'OUT_CREATER_NAME',label:'转出经办人',align:'center'},
	                   {name:'OUT_CREATER_ORG_NAME',label:'转出经办机构',align:'center'},
	                   {name:'outCreaterDate',label:'转出经办时间',align:'center'}
      	        	];
	$("#partyResultList").jqGrid({
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
           autowidth: true,
           loadComplete : function(xhr){
               $("#payMoney").text(xhr.payMoney);
           },
           multiselect:true,
           multiboxonly: true,
           onSelectRow :function(row,e){
        	   	var rowData = $("#partyResultList").jqGrid('getRowData',row);	
        	   $("#partyResultList1").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/party/pay/getAllListJson.xf?personId='+rowData.personId}).trigger("reloadGrid");
		   }
       });
       $("#partyResultList").jqGrid('setFrozenColumns');
       $("#partyResultList1").jqGrid({
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: partyColums,
		    viewrecords: true,
	        rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager1",
	        pagerpos:'left',
	        regional : 'cn',
	        recordpos:'right',
	        height:'100%',
	        altRows:true,
	        shrinkToFit: false,
	        multiselect:true,
	        autowidth: true
	 	  });
	
	
}


function initDate(){
	 $("#partyBeginDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
	 });
	 $("#partyEndDate").xfdaterangepicker({singleDatePicker:true,
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
	 $("#beginpartyIntoDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
             "format": "YYYY-MM-DD"
         }
	});
	$("#endpartyIntoDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
	        "format": "YYYY-MM-DD"
	    }
	});
	
	$("#beginpartyOutDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
	        "format": "YYYY-MM-DD"
	    }
	});
	$("#endpartyOutDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
	       "format": "YYYY-MM-DD"
	   }
	});

	$("#beginpartyDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
	        "format": "YYYY-MM-DD"
	    }
	});
	$("#endpartyDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
	       "format": "YYYY-MM-DD"
	   }
	});
	
	$("#begincreaterOutDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
	        "format": "YYYY-MM-DD"
	    }
	});
	$("#endcreaterOutDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
	       "format": "YYYY-MM-DD"
	   }
	});

	

	
}

function refresh(){
	$("#partyResultList").trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#partyResultList").jqGrid("clearGridData");	
	$("#partyResultList").jqGrid("setGridParam",{ datatype:"json",url:CTX+'/business/personagency/party/pay/partyPayResultJson.xf',postData:json}).trigger("reloadGrid");
}


function printPartyList(){
	 var ids=$("#partyResultList").jqGrid("getGridParam","selarrrow");
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
			  templatePrint("party",params);
     }else{
       	  bootbox.alert('请选择记录');	
     }
	
}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"partyResultList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'党费缴纳统计',
		sheetName:'党费缴纳统计',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#partyResultList").jqGrid("getDataIDs");	   
			 dataJson.level = 'c';
			 if(id&&id.length>0){
				 return dataJson;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
        	  	var ids=$("#retiredBhList").jqGrid("getGridParam","selarrrow");
        		if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        			});
        			 return {level:'6',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#partyResultList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'c',ids:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}


//导出1
function initDataExp1(){
	$('#exp1').dataexp({
		gridId:"partyResultList1",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'党费信息',
		sheetName:'党费信息',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#partyResultList1").jqGrid("getDataIDs");	   
			 dataJson1.level = 'c1';
			 if(id&&id.length>0){
				 return dataJson1;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
        	  	var ids=$("#retiredBhList").jqGrid("getGridParam","selarrrow");
        		if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        			});
        			 return {level:'6',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#partyResultList1").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'c1',id:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}


