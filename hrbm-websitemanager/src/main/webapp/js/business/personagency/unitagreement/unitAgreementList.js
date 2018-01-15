var dataJson = {};
$(function() {
		initl();
		initDate();
		initDataExp();
    }); 	


function initl(){
	/**
	初始化表格显示
	*/
	var columns= [
                  {name:'ID',label:'ID',align:'center',hidden:true,frozen : true,key:true},
                  {name:'AAB004',label:'单位名称',align:'center',frozen : true},
                  {name:'AAB007',label:'营业执照号',align:'center',frozen : true},
                  {name:'UNITNAME',label:'单位性质',align:'center',frozen : true},
                  {name:'AAA021',label:'所在地区',align:'center'},
                  {name:'ECONNAME',label:'经济类型',align:'center'},
                  {name:'AAE006',label:'地址',align:'center'},
                  {name:'UA_NO',label:'单位协议编号',align:'center'},
                  {name:'FREENAME',label:'是否免费',align:'center'},
                  {name:'STATUSNAME',label:'有效标记',align:'center' },
                  {name:'UA_CREATETIME',label:'协议签订日期',align:'center'},
                  {name:'UA_NAME',label:'联系人',align:'center'},
                  {name:'UA_PHONE',label:'联系电话',align:'center'},
                  {name:'BAB002',label:'传真',align:'center'},
                  {name:'UA_CARD',label:'办理人身份证号',align:'center'},
                  {name:'UA_CONTENT',label:'协议主要内容',align:'center'},
                  {name:'UA_NOTE',label:'备注',align:'center'},
                  {name:'CREATER_NAME',label:'经办人',align:'center'},
                  {name:'CREATER_ORG_NAME',label:'经办机构',align:'center'},
                  {name:'CREATER_DATE',label:'经办日期',align:'center'},
                  {name:'STOP_DATE',label:'协议实质终止日期',align:'center'},
                  {name:'UA_STOP_CAUSE',label:'终止原因',align:'center'},
                  {name:'STOP_NAME',label:'终止经办人',align:'center'},
                  {name:'STOP_ORG_NAME',label:'终止经办机构',align:'center'},
                  {name:'STOP_DATEXX',label:'终止经办日期',align:'center'}
               	
	        	];

$("#unitAgreementList").jqGrid({
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
   altRows:true,
   shrinkToFit: false,
   multiselect:true,
   autowidth: true,
   height:'100%'
});	   
$("#unitAgreementList").jqGrid('setFrozenColumns');

$("#addre").selcity({callBack:function(data){
		$("#addre").val(data.allname);
		}
	});
	
}



function refresh(){
	$("#unitAgreementList").trigger("reloadGrid");
}

function initDate(){
	 $("#beginuaCreatetime").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
          "locale": {
             "format": "YYYY-MM-DD"
         }
     });
	 
	 $("#enduaCreatetime").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
            "format": "YYYY-MM-DD"
        }
    });

	
}



function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#unitAgreementList").jqGrid("clearGridData");	
	$("#unitAgreementList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/unitagreement/unitListJson.xf',postData:json}).trigger("reloadGrid");
}


//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"unitAgreementList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'单位协议查询',
		sheetName:'单位协议查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#unitAgreementList").jqGrid("getDataIDs");	   
			 dataJson.level = '8';
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
	        	var ids = $("#unitAgreementList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'8',ids:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}






