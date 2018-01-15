var dataJson ={};
$(function(){
	initl();
	initDate();
	initDataExp();
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
		              	   {name:'id',label:'主键',hidden:true,key:true},
					   	   {name:'personCard',label:'身份号',align:'center'},
					   	   {name:'personName',label:'姓名',align:'center',frozen : true},
					   	   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
					   	   {name:'partyStatus',label:'代管组织关系',align:'center'},
		                   {name:'partyIntoDate',label:'转入时间',align:'center'},
		                   {name:'partyDate',label:'入党时间',align:'center'},
		                   {name:'partyPositiveDate',label:'转正时间',align:'center'},
		                   {name:'sex',label:'性别',align:'center'},
		                   {name:'expUserName',label:'曾用名',align:'center'},
		                   {name:'nationName',label:'民族',align:'center'},
		                   {name:'placeName',label:'籍贯',align:'center'},
		                   {name:'personCsrq',label:'出生年月',align:'center'},
		                   {name:'whcdName',label:'文化程度',align:'center'},
		                   {name:'shoolName',label:'毕业学校',align:'center'},
		                   {name:'expAddress',label:'现居住地址',align:'center'},
		                   {name:'partyOutDate',label:'转出时间',align:'center'},
		                   {name:'partyOutReason',label:'转出原因',align:'center'},
		                   {name:'partyOutWhere',label:'转出去向',align:'center'},
		                   {name:'partyNote',label:'备注',align:'center'},
		                   {name:'createrName',label:'经办人',align:'center'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'},
		                   {name:'outCreaterName',label:'转出经办人',align:'center'},
		                   {name:'outCreaterOrgName',label:'转出经办机构',align:'center'},
		                   {name:'outCreaterDate',label:'转出日期',align:'center'}
	      	        	];
		$("#partyPersonList").jqGrid({
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
	           shrinkToFit: false,
	           height:'100%',
	           altRows:true,
	           autowidth: true,
	           shrinkToFit: false,
	           multiboxonly : true,
	           multiselect : true
	          
	       });

		  $("#partyPersonList1").jqGrid({
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
	$("#partyList").trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#partyPersonList").jqGrid("clearGridData");	
	$("#partyPersonList").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/party/partylistJson.xf',postData:json}).trigger("reloadGrid");
}


//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"partyPersonList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'党组织关系查询',
		sheetName:'党组织关系查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#partyPersonList").jqGrid("getDataIDs");	   
			 dataJson.level = 'b';
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
	        	var ids = $("#partyPersonList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'b',ids:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}

