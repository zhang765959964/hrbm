
var isSave=true;
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	    {name:'pkId',label:'缴费记录编号',align:'center',key:true,formatter:function(cellvalue, options, rowObject){
							     return "<a href='javascript:corpPersonList("+cellvalue+")'>"+cellvalue+"</a>";
						    }
					    },
		               {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'fdPaymentAmount',label:'单位缴费金额',align:'center'},
	                   {name:'fdPaymentStatus',label:'缴费标记',align:'center'},
	                   {name:'fdDerateStatus',label:'减免标记',align:'center'},
	                   {name:'fdDesc',label:'备注',align:'center'},
					   {name:'fdCreaterName',label:'经办人',align:'center'},
					   {name:'fdCreaterDate',label:'经办日期',align:'center'},
					   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},	                  
	                   {name:'fdConfirmsName',label:'财务经办人',align:'center'},
	                   {name:'fdConfirmsDate',label:'财务经办日期',align:'center'},
	                   {name:'fdConfirmsOrgName',label:'财务经办机构',align:'center'},
	                   {name:'fkCorpId',label:'主键',hidden:true },
	                   {name:'mvcMethod',label:'更新标记',hidden:true }                   
	                  
      	        	];
	 var lastsel;
	 var corpId=$("#aab001").val();
	$("#paymentCorpRecordList").jqGrid({
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
           autowidth: true,
           height:'100%'
       });

	initData();
})
function initData(){
	var corpId=$("#aab001").val();
	if(corpId){
		$("#paymentCorpRecordList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/paymentCorpRecord/listJson.xf?fkCorpId='+corpId,}).trigger("reloadGrid");
	}
}

function corpPersonList(fkCorpRecordId){
	xfui.open_dialog({    
	    title: '人员缴费明细',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    url: CTX+"/business/personagency/payment/paymentCorpRecord/corpPersonList.xf?fkCorpRecordId="+fkCorpRecordId,
	    modal: true   
	})
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	$("#paymentRecordList").jqGrid("clearGridData");	
	$("#paymentRecordList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/search/listJson.xf',postData:json}).trigger("reloadGrid");
}
