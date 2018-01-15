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
					 debugger;
					 personData = data;
					  if(data.ARCHIVESTATUS==2){
						  bootbox.alert("调出人员不能办理此业务");
					  }else if(data.ARCHIVESTATUS==3){
						  bootbox.alert("死亡人员不能办理此业务");
					  }else{
						  if(data.ARCHIVEFLOWSTATUS==1){
			    				 bootbox.alert("借阅登记不能办理此业务！"); 
			    			 }else if(data.ARCHIVEFLOWSTATUS==2){
			    				 bootbox.alert("借阅确认不能办理此业务！"); 
			    			 }else if(data.ARCHIVEFLOWSTATUS==3){
			    				 bootbox.alert("返还登记不能办理此业务！"); 
			    			 }else if(data.ARCHIVEFLOWSTATUS==5){
			    				 bootbox.alert("调出登记不能办理此业务！");
			    			 }else if(data.ARCHIVERECEIVESTATUS==1){
			        			 bootbox.alert("档案未入库不能办理此业务！"); 
			        		 }else{
			        			 
			        		 }
					  }
		        	loadPage(data.PERSONID);
				}
			 })
			
			$("#idcard").idcard({callBack:function(personId){
			    loadPage(personId);
		    }})
		    
		    $("#seccard").seccard({callBack:function(personId){
		    	loadPage(personId);
		    }})
		
		   $("#retiredSel").load(CTX+"/business/personagency/retired/declare/searchList.xf");
		})
		
		
		//初始化 回调函数
		function doSearch() {
			 var personId = $("#personId").val();
			 $("#retiredSel").load(CTX+"/business/personagency/retired/declare/searchList.xf?personId="+ personId);
		}
		
		
		function loadPage(personId){
			if(personId){
				$("#retiredSel").load(CTX+"/business/personagency/retired/declare/searchList.xf?personId="+personId);
			}else{
				bootbox.alert('未查到记录');
			}
		}
		
		
		
		