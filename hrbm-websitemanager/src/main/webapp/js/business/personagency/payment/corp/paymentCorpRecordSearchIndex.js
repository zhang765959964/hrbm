
		$(function (){
			$("#unitCorp").load(CTX+"/business/personagency/payment/paymentCorpRecord/searchList.xf");
			 var columns= [
							{field:'aab004',title:'单位名称',width:100,align:'center'},
							{field:'uaNo',title:'代理单位编码',width:100,align:'center'}
						  ];
				 $("#aab004").selectcommon({
					 url:CTX+'/sys/component/uums/selCorp.xf',
					 columns: columns,
					 callBack:function(data){
						 if(data){
							 $("#unitCorp").load(CTX+"/business/personagency/payment/paymentCorpRecord/searchList.xf?aab001="+data.aab001);
						 }else{
							 bootbox.alert("未查到相关记录");
						 }
						
					}
				 });
			
			
		/*	$("#aab004").selectcorp({callBack:function(aab001){
				
				$("#unitCorp").load(CTX+"/business/personagency/payment/paymentCorpRecord/searchList.xf?aab001="+aab001);
				
			}})*/
		});
