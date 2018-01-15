$(function(){
	
	initDate();
	/**
	 初始化表格显示
	*/
	var columns= [		

	              {name:'payId',label:'操作',width:100,frozen : true,formatter: function(cellvalue, options, rowObject){	 
			           return "<a href=\"javascript:getById('"+cellvalue+"')\"  >查看详情</a>"}
					},
	                   {name:'personCard',label:'公民身份号码',align:'center',frozen : true},
	                   {name:'personName',label:'姓名',align:'center',frozen : true},
	                   {name:'personSex',label:'性别',align:'center'},
	                   {name:'personCsrq',label:'出生日期',align:'center'},
	                   {name:'partyBeginDate',label:'交纳开始年月',align:'center'},
	                   {name:'partyEndDate',label:'交纳截止年月',align:'center'},
	                   {name:'partyPayMoney',label:'交纳金额',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'partyStatus',label:'代理组织关系',align:'center'},
	                   {name:'partyIntoDate',label:'转入日期',align:'center'},
	                   {name:'partyDate',label:'入党日期',align:'center'},
	                   {name:'partyPositiveDate',label:'转正时间',align:'center'},
	                   {name:'partyOutDate',label:'转出日期',align:'center'},
	                   {name:'partyOutReason',label:'转出原因',align:'center'},
	                   {name:'partyOutWhere',label:'转出去向',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'whcdName',label:'文化程度',align:'center'},
	                   {name:'partyOldName',label:'曾用名',align:'center'},
	                   {name:'zhuanyeName',label:'专业',align:'center'},
	                   {name:'partySchoolName',label:'毕业学校',align:'center'},
	                   {name:'partySchoolDate',label:'毕业日期',align:'center'},
	                   {name:'partyPhone',label:'手机',align:'center'},
	                   {name:'partyQq',label:'QQ号',align:'center'},
	                   {name:'partyOtherAdd',label:'其他联系方式',align:'center'},
	                   {name:'expCardAdd',label:'家庭通讯地址',align:'center'}
	               
      	        	];
	$("#partyPayList").jqGrid({
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
           multiselect:true,
           autowidth: true,
           loadComplete : function(xhr){
               $("#payMoney").text(xhr.payMoney);
               $("#sumCount").text(xhr.sumCount);
        		
           }
           
       });


	 $("#partyPayList").jqGrid('setFrozenColumns');
});


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
	
	
}

function getById(id){
	if(id){
		var id=id;
		xfui.open_dialog({    
	  		    title: '党费交纳详情',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/party/pay/getPartyPayById.xf?payId="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function refresh(){
	$("#partyPayList").trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	$("#partyPayList").jqGrid("clearGridData");	
	$("#partyPayList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/party/pay/listJson.xf',postData:json}).trigger("reloadGrid");
}