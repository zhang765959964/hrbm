//增加工作经历维护
function addWorkWh(){
	
	var  zhi = 0;
	if($("#personId").val()>0){		
		var personId = $("#personId").val();
	 $.ajax({
	        type: "post",
	        url: CTX+"/business/personagency/receive/receive/getPrimaryKey.xf",
	        data: {name:"WorkExperience"},
	        dataType: "json",
	        success: function(data){
	        	zhi= data.message + "";
	        	var selectedId = $("#gridTable").jqGrid("getGridParam", "selrow");  
	        	var dataRow = {   
	            	id : zhi,
	            	personId : personId,
	            	createrId : $("#createrId").val(),
	            	createrName :$("#createrName").val(),
	            	createrOrgName : $("#createrOrgName").val(),
	            	createrOrgId : $("#createrOrgId").val(),
	            	createrDate : $("#createrDate").val()
	            };  
	            if (selectedId) {  
	            	$("#workExList").jqGrid("addRowData", zhi, dataRow, "before", selectedId);  
	            } else {  
	                $("#workExList").jqGrid("addRowData", zhi, dataRow, "first");  
	            } 
	        }
	    });
	}else{
		bootbox.alert("没有档案信息不能办理此业务！");
	}
}


function pickDate( cellvalue, options, cell ) {
	setTimeout(function(){
		$(cell) .find('input[type=text]')
				.xfdaterangepicker({singleDatePicker:true,
				  autoUpdateInput:false,	
				  "opens":"right",
				  "drops": "down",
		          "locale": {
		          "format": "YYYY-MM-DD"
		         }
		     });
	}, 0);
	 
}

//删除工作维护信息
 function delWorkWh(){
	var ids=$("#workExList").jqGrid("getGridParam","selarrrow");
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
		    	$.ajax({ url: CTX+'/business/personagency/experience/del.xf',
		    		cache :false,
		    		data:{id:id},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.result==1){
		    				bootbox.alert(data.message); 
		    				whrefresh();
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		    			var parentIframe=xfui.getParentIframe();
		    			parentIframe.careReload();
		    			
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }			
}   

function whrefresh(){
	$("#workExList").trigger("reloadGrid");
}
