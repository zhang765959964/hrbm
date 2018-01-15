var personData=null;
$(function(){
	var columns= [
					{field:'AAC002',title:'身份证号',width:100,align:'center'},
					{field:'AAC003',title:'姓名',width:100,align:'center'},
					{field:'ARCHIVECODE',title:'档案编号',width:100,align:'center'}
	        	];
	$("#personSearch").selectcommon({
			 url:CTX+'/business/personagency/archive/archives/searchArchives.xf',
			 columns: columns,
			 callBack:function(data){
				 personData=data;
				 if(data){
					 loadPage(data.PERSONID);
				 }else{
					 bootbox.alert("未查到相关记录");
				 }
			}
		 })
	   $("#idcard").idcard({callBack:function(personId){
		   loadPage(personId)
		   
	   }})
	    $("#seccard").seccard({callBack:function(personId){
	    	loadPage(personId)
	   }})
	  
	$("#paymentList").load(CTX+"/business/personagency/payment/paymentRefund/list.xf?");
})

function loadPage(personId){
	
		$("#paymentList").load(CTX+"/business/personagency/payment/paymentRefund/list.xf?personId="+personId);
		
}
