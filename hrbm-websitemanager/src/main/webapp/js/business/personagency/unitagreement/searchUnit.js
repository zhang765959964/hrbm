$(function (){
		 $("#unitCorp").load(CTX+"/business/unitagreement/edit.xf");
		 var columns= [
						{field:'aab004',title:'单位名称',width:100,align:'center'},
						{field:'uaNo',title:'代理单位编码',width:100,align:'center'}
	 	        	];
			 $("#aab004").selectcommon({
				 url:CTX+'/sys/component/uums/selCorp.xf',
				 columns: columns,
				 callBack:function(data){
					 if(!data){
						 bootbox.alert("未查到该企业！");
					 }else{
						 $("#unitCorp").load(CTX+"/business/unitagreement/edit.xf?aab001="+data.aab001);
					 }
				}
			 });
	});