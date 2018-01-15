
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [	   
	                   {name:'fdStartDate',label:'开始缴费日期',align:'center'},
	                   {name:'fdEndDate',label:'终止缴费日期',align:'center'},
	                   {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
	                   {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'}
      	        	];
	var recordId=$("#recordId").val();
	$("#paymentRecordList").jqGrid({
           mtype: "GET",
		   url:CTX+"/business/personagency/payment/paymentYearDetail/listJson.xf?recordId="+recordId,
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
          // multiselect:true,
           autowidth: true,
           height:'100%'
       });
	
	$("#payment").on("click",function(){
		payment();
	})
	$("#closeDialog").on("click",function(){
		xfui.closeDialog();
	})
	
})

function payment(){
	var recordId=$("#recordId").val();


		$.ajax({ url: CTX+'/business/personagency/payment/paymentReceive/payment.xf',
    		data:{recordId:recordId},
    		dataType:'json',
    		success: function(data){
    			if(data.message){
    				bootbox.alert({message:data.message,callback:function(){
    					var parentIframe=xfui.getParentIframe();
    			    	if(parentIframe){
    			    		parentIframe.refresh();
    			    	}
    					 xfui.closeDialog();
    				  }
    				}); 	
    			}else{
    				bootbox.alert("未知错误"); 
    			}
    			
    			refresh();
             }
    	});
		
} 


