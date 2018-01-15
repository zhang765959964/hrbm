$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	   {name:'batchName',label:'批次名称',align:'center'},
	            	   {name:'aab004',label:'单位名称',align:'center'},
	                   {name:'totalSubsidyNum',label:'批次人数',align:'center'},
	                   {name:'totalSubsidyAmount',label:'合计补贴金额',align:'center',width:75},
	                   {name:'approvalDesc',label:'审批情况',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'batchId',label:'批次名称',align:'center',hidden:true}

      	        	];
	$("#socialCorpDeclareList").jqGrid({
		  url:CTX+'/business/personagency/subsidy/socialCorpDeclare/listJson.xf',
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
	      autowidth: true,
	      height:"100%",
	      onSelectRow:function(rowId){
	    	  var rowData=$(this).jqGrid("getRowData",rowId);
	    	  $("#batchList").jqGrid("clearGridData");
	    	  $('#batchList').jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/subsidy/socialSubsidy/batchAppListJson.xf?batchId='+rowData.batchId}).trigger("reloadGrid");

	      }
	  });
	initTable();

	
})
	function initTable(){
		
		var columns= [
		               {name:'batchName',label:'批次名称',align:'center',frozen : true},
		               {name:'aac002',label:'身份证号',align:'center',frozen : true},
		               {name:'aac003',label:'姓名',align:'center',frozen : true},
	                   {name:'subsidyNum',label:'编号',align:'center'},
	                   {name:'oldSubsidyNum',label:'老编号',align:'center'},
	                   {name:'pensionMonths',label:'养老保险补贴月数',align:'center'},
	                   {name:'pensionStartDate',label:'养老补贴开始年份',align:'center'},
	                   {name:'pensionEndDate',label:'养老补贴结束年份',align:'center'},
	                   {name:'medicalMonths',label:'医疗保险补贴月数',align:'center'},
	                   {name:'medicalStartDate',label:'医疗补贴开始年份',align:'center'},
	                   {name:'medicalEndDate',label:'医疗补贴结束年份',align:'center'},
	                   {name:'contractSignDate',label:'签订劳动合同开始时间',align:'center'},
	                   {name:'contractEndDate',label:'签订劳动合同终止时间',align:'center'},
	                   {name:'contractDestoryDate',label:'劳动合同解除日期',align:'center'},
	                   {name:'isPassed',label:'是否通过',align:'center'},
	                   {name:'checkState',label:'审核标记',align:'center'},
	                   {name:'isHasBusLic',label:'是否持有营业执照',align:'center'},
	                   {name:'bankName',label:'开户银行',align:'center'},
	                   {name:'bankCardNo',label:'银行帐号',align:'center'},	                   
	                   {name:'busLicNum',label:'营业执照编号',align:'center'},
	                   {name:'outerSubsidyMonths',label:'已在外单位享受补贴月数',align:'center'},
	                   {name:'createrNum',label:'登记次数',align:'center'},
	                   {name:'expOldCompany',label:'原工作单位',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',width:200,align:'center'},	                
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
     	        	];
	$("#batchList").jqGrid({
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
	      multiselect:true,
	      height:"100%",
	      altRow:true,
	      autowidth: true
	  });
	$("#batchList").jqGrid('setFrozenColumns');
	}
 

function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	$("#socialCorpDeclareList").jqGrid("clearGridData");
	$("#socialCorpDeclareList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
function doPersonSearch(){
	
	var json=$("#personSearchForm").serializeJson();
	$("#batchList").jqGrid("clearGridData");
	$("#batchList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}

function review (checkState){
	var rowids=$("#batchList").jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var id="";
		$.each(rowids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
			
		});
		$.ajax({ url: CTX+'/business/personagency/subsidy/socialSubsidy/review.xf',
    		data:{id:id,checkState:checkState},
    		dataType:'json',
    		success: function(data){
    			if(data.message){
    				bootbox.alert(data.message);
    				refresh();
    			}else{
    				bootbox.alert("未知错误"); 
    			}
             }
    	});
	  }else{
		 bootbox.alert('请选择记录');
	 }			

}


function refresh(){
	$("#batchList").trigger("reloadGrid");
}
