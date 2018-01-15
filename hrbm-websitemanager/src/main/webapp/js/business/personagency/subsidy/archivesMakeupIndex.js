var personData=null;
$(function() {
		
//		$("#personId").selectuser({hasArch:false,callBack:function(personId){
//			loadPage(personId);
//		}})
		
		var columns= [
						{field:'AAC002',title:'身份证号',width:100,align:'center'},
						{field:'AAC003',title:'姓名',width:100,align:'center'},
	                    {field:'ARCHIVECODE',title:'档案编号',width:100,align:'center'}
      	        	];
			 $("#personId").selectcommon({
				 url:CTX+'/business/personagency/archive/archives/searchArchives.xf?dataSources=1',
				 columns: columns,
				 callBack:function(data){
					 personData=data;
					 if(!data){
						 bootbox.alert("没有找到可操作的数据");
					 }else{
						 if(data.ARCHIVESTATUS==2){
						 }else if(data.ARCHIVESTATUS==3){
							 bootbox.alert("死亡人员不能办理补录");
						 }else{
							 bootbox.alert("在档人员不能办理补录");
						 }
						 loadPage(data.PERSONID);
					 }
				}
			 })
			 
		 $("#idcard").idcard({callBack:function(personId){
		   loadPage(personId)
		   
	   }})
	    $("#seccard").seccard({callBack:function(personId){
	    	loadPage(personId)
	   }})
		$("#socialEdit").load(CTX+"/business/personagency/subsidy/makeup/edit.xf");
	})
	function loadPage(personId){
		if(personId){
			$("#socialEdit").load(CTX+"/business/personagency/subsidy/makeup/edit.xf?personId="+ personId);
	
		}else{
			bootbox.alert('未查到记录');
		}
	}
	function doSearch() {
	 var personId = $("#personId").val();
	 $("#socialEdit").load(CTX+"/business/personagency/subsidy/makeup/edit.xf?personId="+ personId);
	}