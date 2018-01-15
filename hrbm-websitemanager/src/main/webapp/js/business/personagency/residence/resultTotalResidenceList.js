//删除户口材料信息
	function delResidence(){
		var ids=$("#residenceList").jqGrid("getGridParam","selarrrow");
		if(ids&&ids.length>0){
			var id="";
			$.each(ids,function(i,e){
				if(i==0){
					id+=e;
				}else{
					id+=","+e;
				}
			});
			bootbox.confirm({message:'您确认要删除户口材料信息吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/residence/residence/del.xf',
			    		data:{id:id},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message); 	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			    			refresh();
			             }
			    	});
			    }    
			}}); 
		  }else{
			 bootbox.alert('请选择记录');
		 }			
	} 
	
	//办理户口迁移
	function editResidenceMoveOut(){
		var id=$("#residenceMoveOutList").jqGrid("getGridParam","selrow");
		if(id){
			var id=id;
			xfui.open_dialog({    
		  		    title: '办理户口迁移信息',    
		  		    width: 950,    
		  		    height: 500,    
		  		    closed: false,    
		  		    cache: false,    
		  		    url: CTX+"/business/personagency/residence/residenceMoveOut/edit.xf?id="+id,
		  		    modal: true   
		  		})
		}else{
			bootbox.alert('请选择记录');
		}			
	} 
	//删除办理户口的迁入迁移数据
	function delResidenceMoveOut(){
		var ids=$("#residenceMoveOutList").jqGrid("getGridParam","selarrrow");
		if(ids&&ids.length>0){
			var id="";
			$.each(ids,function(i,e){
				if(i==0){
					id+=e;
				}else{
					id+=","+e;
				}
			});
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/residence/residenceMoveOut/del.xf',
			    		data:{id:id},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message); 	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			    			refresh();
			             }
			    	});
			    }    
			}}); 
		  }else{
			 bootbox.alert('请选择记录');
		 }			
	} 
	
	//归还户口
	function editResidenceReturn(){
		var id=$("#residenceReturnList").jqGrid("getGridParam","selrow");
		if(id){
			var id=id;
			bootbox.confirm({message:'您确认要归还当前户口信息吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/residence/residenceReturn/backResidence.xf',
			    		data:{id:id},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message);
			    			}else{
			    				bootbox.alert("未知错误");
			    			}
			    			refresh();
			             }
			    	});
			    }    
			}}); 
		}else{
			bootbox.alert('请选择记录');
		}			
	} 
	
	//删除户口借用归还信息
	function delResidenceReturn(){
		var ids=$("#residenceReturnList").jqGrid("getGridParam","selarrrow");
		if(ids&&ids.length>0){
			var id="";
			$.each(ids,function(i,e){
				if(i==0){
					id+=e;
				}else{
					id+=","+e;
				}
			});
			bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/residence/residenceReturn/del.xf',
			    		data:{id:id},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message); 	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			    			refresh();
			             }
			    	});
			    }    
			}}); 
		  }else{
			 bootbox.alert('请选择记录');
		 }			
	} 