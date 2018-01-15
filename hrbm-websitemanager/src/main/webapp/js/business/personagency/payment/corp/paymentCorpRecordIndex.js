
		$(function (){
			var type=$("#type").val();
			$("#unitCorp").load(CTX+"/business/personagency/payment/paymentCorpRecord/list.xf?type="+type);
			 var columns= [
							{field:'aab004',title:'单位名称',width:100,align:'center'},
							{field:'uaNo',title:'代理单位编码',width:100,align:'center'}
						  ];
				 $("#aab004").selectcommon({
					 url:CTX+'/sys/component/uums/selCorp.xf',
					 columns: columns,
					 callBack:function(data){
						 if(data.uaNo){
							 $("#unitCorp").load(CTX+"/business/personagency/payment/paymentCorpRecord/list.xf?type="+type+"&aab001="+data.aab001);	
						 }else{
							 bootbox.alert("单位未签订协议，请先签订协议");
						 }
					 }
				 });
		/*	
			$("#aab004").selectcorp({callBack:function(aab001,corpObject){

				if(corpObject.uaNo){
					$("#unitCorp").load(CTX+"/business/personagency/payment/paymentCorpRecord/list.xf?type="+type+"&aab001="+aab001);
				}else{
					bootbox.alert("单位未签订协议，请先签订协议");
				}
				
				
			}})*/
		});
