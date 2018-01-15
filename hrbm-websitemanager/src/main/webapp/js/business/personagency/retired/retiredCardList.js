var dataJson = {};
$(function(){
	
	initDate();
	/**
	 初始化表格显示
	*/
	$("#retiredCard").load(CTX+"/business/personagency/retired/card/getRetiredById.xf");
	var columns= [
	          		   {name:'id',label:'ID',hidden:true,frozen : true},
	                   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	                   {name:'personName',label:'姓名',align:'center',frozen : true},
	                   {name:'personCard',label:'身份证号',align:'center',frozen : true},
	                   {name:'retiredPeopleNo',label:'个人编号',align:'center'},
	                   {name:'xh',label:'序号',align:'center'},
	                   {name:'retiredPeopleBm',label:'退休个人编码',align:'center'},
	                   {name:'sex',label:'性别',align:'center' },
	                   {name:'personCsrq',label:'出生日期',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'phone',label:'联系电话',align:'center'},
	                   {name:'mobilePhone',label:'手机号',align:'center'},
	                   {name:'isRetiredCard',label:'是否领取退休证',align:'center'},
	                   {name:'retiredCardDate',label:'退休证领取时间',align:'center'},
	                   {name:'retiredCardCode',label:'退休证号',align:'center'},
	                   {name:'retiredCardName',label:'退休证领取人',align:'center'},
	                   {name:'retiredCreaterName',label:'退休证经办人',align:'center'},
	                   {name:'retiredStatus',label:'是否正式退休',align:'center'},
		               {name:'isRetiredSocial',label:'是否转社会化',align:'center'},
	                   {name:'statusName',label:'退休申报状态',align:'center'},
	                   {name:'retiredArea',label:'退休人员所属区域',align:'center'},
	                   {name:'oldCompany',label:'原单位名称',align:'center'},
	                   {name:'workJobDate',label:'参加工作时间',align:'center'},
	                   {name:'rgName',label:'符合离退休规定条款',align:'center'},
	                   {name:'payDate',label:'缴费年月',align:'center'},
	                   {name:'retiredDate',label:'应退休时间',align:'center'},
	                   {name:'rtName',label:'退休类别',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'createrOgnName',label:'经办机构',align:'center'}
      	        	];
	$("#retiredCardList").jqGrid({
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "local",
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
   		   	var rowData = $("#retiredCardList").jqGrid('getRowData',row);	
   		   	$("#retiredId").val(rowData.id);
   		   	$("#retiredCard").load(CTX+"/business/personagency/retired/card/getRetiredById.xf?id="+rowData.id);
   		   }
       });
	initDataExp();
    $("#retiredCardList").jqGrid('setFrozenColumns');
	
    
})


function initDate(){

	 $("#begincreateWorkDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  "opens":"right",
			  "drops": "down",
              "locale": {
              "format": "YYYY-MM-DD"
              }
	 });
	 $("#endcreateWorkDate").xfdaterangepicker({singleDatePicker:true,
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



function editRetiredCard(){
	//var row = $('#retiredCardList').bootstrapTable('getAllSelections');
	var id=$("#retiredCardList").jqGrid("getGridParam","selrow");
	if(id){
		var id=id;
		xfui.open_dialog({    
	  		    title: '编辑退休人员领取退休证',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/retired/card/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 


function refresh(){
	$("#retiredCardList").trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retiredCardList").jqGrid("clearGridData");
	$("#retiredCard").load(CTX+"/business/personagency/retired/card/getRetiredById.xf");
	$("#retiredCardList").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/retired/card/retiredPersonJson.xf',postData:json}).trigger("reloadGrid");
}

//导出退休人员查询数据
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredCardList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'退休人员查询',
		sheetName:'退休人员查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson.level = '1';
			debugger;
			var id = $("#retiredCardList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			return dataJson;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#retiredCardList").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			return {level:'1',ids:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}
