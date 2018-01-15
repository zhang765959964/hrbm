var personData=null;
$(function() {
	
		var columns= [
	                   {field:'aac002',title:'身份证号',width:80,align:'center'},
	                   {field:'aac003',title:'姓名',width:80,align:'center'},
	                   {field:'archiveCode',title:'档案编号',width:80,align:'center'}
      	        	];
		 $("#personId").selectcommon({
			 url:CTX+'/business/personagency/subsidy/makeup/selArcUser.xf',
			 columns: columns,
			 callBack:function(data){	
				 
				 personData=data;
				 var lzStatus = $("#lzStatus").val();	//流转状态  5调出登记   6调出确认	
				 var jsStatus = $("#jsStatus").val();	//档案接收状态 2 已入库	success : 2
				 var daStatus = $("#daStatus").val();	//档案状态1在档 2.调出3. 死亡   success : 1  	
				 var dabh = $("#archiveCode").val();
				 var personIds  = $("#currentPersonId").val();	//人员id
				 if(data){
					  if(data.makeup==1){
						  loadPage(data.aac001);
					  }else if(data.archiveStatus==2){
						  bootbox.alert("调出人员不能办理此业务")
					  }else if(data.archiveStatus==3){
						  bootbox.alert("死亡人员不能办理此业务")
					  }else{
						  if(data.archiveFlowStatus==1){
			    				 bootbox.alert("借阅登记不能办理此业务！"); 
			    			 }else if(data.archiveFlowStatus==2){
			    				 bootbox.alert("借阅确认不能办理此业务！"); 
			    			 }else if(data.archiveFlowStatus==3){
			    				 bootbox.alert("返还登记不能办理此业务！"); 
			    			 }else if(data.archiveFlowStatus==5){
			    				 bootbox.alert("调出登记不能办理此业务！");
			    			 }else if(data.archiveReceiveStatus!=2){
			        			 bootbox.alert("档案未入库不能办理此业务！"); 
			        		 }
					  }

		        		loadPage(data.aac001);
		    			  
					}else{
						bootbox.alert("没有档案编号不能办理此业务！");
					}
				
			}
		 })
		$("#idcard").idcard({callBack:function(personId){
		   loadPage(personId);
		   
	   }})
	    $("#seccard").seccard({callBack:function(personId){
	    	loadPage(personId);
	   }})
		$("#socialEdit").load(CTX+"/business/personagency/subsidy/socialSubsidy/edit.xf");
		
	})
	function doSearch() {
	 var personId = $("#personId").val();
	 $("#socialEdit").load(CTX+"/business/personagency/subsidy/socialSubsidy/edit.xf?personId="+ personId);
	}
	function loadPage(personId){
		if(personId){
			$("#socialEdit").load(CTX+"/business/personagency/subsidy/socialSubsidy/edit.xf?personId="+ personId);
	
		}else{
			bootbox.alert('未查到记录');
		}
	}