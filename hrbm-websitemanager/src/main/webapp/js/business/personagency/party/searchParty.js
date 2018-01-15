var personData=null;
$(function() {
	
	 var columns= [
					{field:'AAC002',title:'身份证号',width:100,align:'center'},
					{field:'AAC003',title:'姓名',width:100,align:'center'},
                   {field:'ARCHIVECODE',title:'档案编号',width:100,align:'center'}
 	        	];
		 $("#personId").selectcommon({
			 url:CTX+'/business/personagency/archive/archives/searchArchives.xf?dataSources=1',
			 columns: columns,
			 callBack:function(data){
				 personData = data;
				 if(!data){
					 bootbox.alert("没有找到可操作的数据");
				 }else{
					 if(data.ARCHIVESTATUS==2){
						 bootbox.alert("当前档案已经调出！不能操作！");
					 }else{
						 $("#partySel").load(CTX+"/business/personagency/party/searchList.xf?personId="+ data.PERSONID);
					 }
				 }
			}
		 })
		 $("#partySel").load(CTX+"/business/personagency/party/searchList.xf");
	
		/*	$("#personId").selectuser({hasArch:true,callBack:function(personId){
				loadPage(personId);
			}})
			
			$("#idcard").idcard({callBack:function(personId){
			    loadPage(personId);
		    }})
		    
		    $("#seccard").seccard({callBack:function(personId){
		    	loadPage(personId);
		    }})
		
		    $("#partySel").load(CTX+"/business/personagency/party/searchList.xf");*/
		})
		
//		//初始化 回调函数
//		function doSearch() {
//			 var personId = $("#personId").val();
//			 $("#partySel").load(CTX+"/business/personagency/party/searchList.xf?personId="+ personId);
//		}
//		
//		//初始化回调函数
		function loadPage(personId){
			if(personId){
				$("#partySel").load(CTX+"/business/personagency/party/searchList.xf?personId="+ personId);
			}else{
				bootbox.alert("没有找到可操作的数据");
			}
		}