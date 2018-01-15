var dataJson = {};
$(function(){
	
	initDate();
	/**
	 初始化表格显示
	*/
	var columns= [{name:'id',label:'ID',key: true,hidden:true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
					keys: false,
					editbutton : true,
					delbutton : false
				  }},
				  {name:'personName',label:'姓名',align:'center',frozen : true},
             	  {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                  {name:'xh',label:'序号',align:'center',editable : true},
                  {name:'retiredPeopleBm',label:'退休个人编码',align:'center',editable : true},
                  {name:'personCard',label:'身份证号',align:'center',frozen : true},
                  {name:'retiredPeopleNo',label:'个人编号',align:'center'},
                  {name:'sex',label:'性别',align:'center' },
                  {name:'personCsrq',label:'出生日期',align:'center'},
                  {name:'nationName',label:'民族',align:'center'},
                  {name:'retiredStatus',label:'是否正式退休',align:'center'},
                  {name:'stName',label:'申报状态',align:'center'},
                  {name:'isRetiredCard',label:'是否领退取证',align:'center' },
                  {name:'retiredArea',label:'退休人员所属区域',align:'center'},
                  {name:'phone',label:'联系电话',align:'center'},
                  {name:'mobilePhone',label:'手机号',align:'center'},
                  {name:'workJobDate',label:'参加工作时间',align:'center'},
                  {name:'rgName',label:'符合离退休规定条款',align:'center'},
                  {name:'payDate',label:'缴费年月',align:'center'},
                  {name:'retiredDate',label:'应退休时间',align:'center'},
                  {name:'declareNote',label:'申报备注',align:'center',editable : true},
                  {name:'createrName',label:'经办人',align:'center'},
                  {name:'createrDate',label:'经办日期',align:'center'},
                  {name:'createrOgnName',label:'经办机构',align:'center'}
      	        	];
	$("#retiredBhList").jqGrid({
		   //editurl:CTX+'/business/personagency/retired/declare/updateRetiredBh.xf',
//           mtype: "GET",
//		   styleUI : 'Bootstrap',
//           datatype: "local",
//           colModel: columns,
//		   viewrecords: true,
//           rowNum: 10,
//           rowList:[10,20,30],
//           pager: "#jqGridPager",
//           pagerpos:'left',
//           regional : 'cn',
//           recordpos:'right',
//           shrinkToFit: false,
//           height:'100%',
//           altRows:true,
//           multiselect:false,
//           autowidth: true,
//           multiboxonly : true,
//           rownumbers : true
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
	  $("#retiredBhList").jqGrid('setFrozenColumns');

	initDataExp();
//	$(".highSearch").click(function(){
//		$(".highCondition").toggle();
//	});
})

function initDate(){
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


//编号
function editBh(){
	var id=$("#retiredBhList").jqGrid("getGridParam","selrow");
	if(id){
		var id=id;
		xfui.open_dialog({
	  		    title: '退休编号修改',
	  		    width: 850,
	  		    height: 400,
	  		    closed: false,
	  		    cache: false,
	  		    url: CTX+"/business/personagency/retired/declare/edit.xf?id="+id,
	  		    modal: true
	  		})
	}else{
		bootbox.alert('请选择记录');
	}
}



function refresh(){
	$("#retiredBhList").trigger("reloadGrid");
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	dataJson=json;
	$("#retiredBhList").jqGrid("clearGridData");	
	$("#retiredBhList").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/retired/declare/retiredBhListJson.xf',postData:json}).trigger("reloadGrid");
}



//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredBhList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'退休编号修改',
		sheetName:'退休编号修改',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#retiredBhList").jqGrid("getDataIDs");	   
			 dataJson.level = '6';
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
	        	var ids = $("#retiredBhList").jqGrid("getDataIDs");	        		
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
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}



