

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	    
	              	   {name:'aac003',label:'姓名',align:'center',frozen:true},
	              	   {name:'aac002',label:'身份证号',align:'center',frozen:true},
	              	   {name:'archiveCode',label:'档案编号',align:'center',frozen:true},
	                   {name:'fdRefundStartDate',label:'退费开始日期',align:'center'},
	                   {name:'fdRefundEndDate',label:'退费结束日期',align:'center'},	                  
	                   {name:'fdRefundMonths',label:'退费月数',align:'center'},
	                   {name:'fdRefundStandard',label:'退费标准',align:'center'},
	                   {name:'fdRefundAmount',label:'退费金额',align:'center'},
	                   {name:'fdRefundDate',label:'退费日期',align:'center'},
	                   {name:'fdRefundIsRefund',label:'是否返还',align:'center'},
	                   {name:'fdRefundLendDate',label:'调出日期',align:'center'},
	                   {name:'fdRefundReason',label:'退费原因',align:'center'},
	                   {name:'fdRefundDesc',label:'备注',align:'center'},
	                   {name:'pkId',label:'主键',hidden:true,width:100,key:true }
      	        	];
	$("#paymentRefundList").jqGrid({
		   url:CTX+'/business/personagency/payment/paymentRefund/regListJson.xf',
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
           autowidth: true,
           height:'100%',
           onSelectRow:function(rowid,status){
        	   editPaymentRefund(rowid)
           }
           
       });
	$("#paymentRefundList").jqGrid('setFrozenColumns');
})

function editPaymentRefund(rowid){
	//var row = $('#paymentRefundList').bootstrapTable('getAllSelections');
// 	var rowid=$("#paymentRefundList").jqGrid("getGridParam","selrow");
	if(rowid){
		var pkId=rowid;
		xfui.open_dialog({    
	  		    title: '确认退费',    
	  		    width: 800,    
	  		    height: 350,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/payment/paymentRefund/confirmEdit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 


function refresh(){
	$("#paymentRefundList").trigger("reloadGrid");
}




