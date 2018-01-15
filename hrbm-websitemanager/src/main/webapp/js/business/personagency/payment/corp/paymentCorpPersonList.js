
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	   {name:'aac003',label:'姓名',align:'center'},
	              	   {name:'aac002',label:'身份证号',align:'center'},
	              	   {name:'genderName',label:'性别',align:'center'},
	              	   {name:'archiveCode',label:'档案编号',align:'center'},
	              	   {name:'expSoctalNumber',label:'社会保障号',align:'center'},	 
	              	   {name:'archiveTypeName',label:'存档类型',align:'center'},	 	              	 
	              	   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'fdStartDate',label:'开始缴费日期',align:'center'},
	                   {name:'fdEndDate',label:'终止缴费日期',align:'center'},
	                   {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
	                   {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},
	                   {name:'fdPaymentStatus',label:'缴费标记',align:'center'},
	                   {name:'fdPaymentType',label:'缴费类型',align:'center'},	                  	                   
	                   {name:'fdDerateStatus',label:'减免标记',align:'center'},
	                   {name:'fdDesc',label:'备注',align:'center'},
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},		                   
	                   {name:'fdConfirmsName',label:'财务经办人',align:'center'},
	                   {name:'fdConfirmsOrgName',label:'财务经办机构',align:'center'},
	                   {name:'fdConfirmsDate',label:'财务经办日期',align:'center'},	   
	                   {name:'pkId',label:'操作',hidden:true,width:100,key:true}
      	        	];
	var fkCorpRecordId=$("#fkCorpRecordId").val();
	var fdDerateStatus=$("#fdDerateStatus").val();
	$("#paymentRecordList").jqGrid({
           mtype: "GET",
		   url:CTX+'/business/personagency/payment/paymentRecord/listCorpJson.xf?fkCorpRecordId='+fkCorpRecordId+"&fdDerateStatus="+fdDerateStatus,
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



