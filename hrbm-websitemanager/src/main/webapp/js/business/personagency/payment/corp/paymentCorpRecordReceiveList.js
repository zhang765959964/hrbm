

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'aab004',label:'单位名称',align:'center',formatter:function(cellvalue, options, rowObject){
	                	   return "<a style='curosr:pointer;color:#4876FF' href='javascript:editPaymentCorpRecord("+rowObject.pkId+")'>"+cellvalue+"</a>";
	                   }},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},
	                   {name:'fdDerateStatus',label:'减免标记',align:'center'},
	                   {name:'fdDesc',label:'备注',align:'center'},
	                   {name:'aae004',label:'联系人',align:'center'},
	                   {name:'aae005',label:'联系人电话',align:'center'},
	                   {name:'fdCreaterName',label:'前台经办人',align:'center'},
	                   {name:'fdConfirmsName',label:'财务经办人',align:'center'},	                   
	                   {name:'fdConfirmsOrgName',label:'财务经办机构',align:'center'},
	                   {name:'fdConfirmsDate',label:'财务经办日期',align:'center'},
	                   {name:'pkId',label:'主键',hidden:true,width:100,key:true }
      	        	];
	$("#paymentCorpRecordList").jqGrid({
		   url:CTX+'/business/personagency/payment/paymentCorpRecord/receiveListJson.xf',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "json",
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
           autowidth: true,
           height:'100%'
       });
})


function editPaymentCorpRecord(pkId){
	if(pkId){
		xfui.open_dialog({    
	  		    title: '单位费用实收',    
	  		    width: 900,    
	  		    height: 600,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/payment/paymentCorpRecord/receiveEdit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 


function refresh(){
	$("#paymentCorpRecordList").trigger("reloadGrid");
}
