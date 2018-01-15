var dataJson ={};
$(function(){
	initl();
	initDataExp();
})


function initl(){
	/**
	 初始化表格显示
	*/
	var columns= [{name:'paramsName',label:'参数类型',align:'center'},
				      {name:'startDate',label:'开始日期',align:'center',editable : true},
	                   {name:'endDate',label:'结束日期',align:'center',editable : true},
	                   {name:'paramsValue',label:'参数值',align:'center',editable : true},
	                   {name:'description',label:'描述',align:'center',editable : true},
	                   {name:'createrName',label:'经办人',align:'center',editable : true},
	                   {name:'createrOrgName',label:'经办机构',align:'center',editable : true},
	                   {name:'createrDate',label:'经办日期',align:'center',editable : true}
     	        	];
	 $("#socialParamsList").jqGrid({
		 url:CTX+'/business/personagency/subsidy/socialParams/listJson.xf',
		 editurl:CTX+'/business/personagency/subsidy/socialParams/save.xf',
        mtype: "GET",
		 styleUI : 'Bootstrap',
        datatype: "json",
        colModel: columns,
		 viewrecords: true,
        rowNum: 10,
        rowList:[10,15,20],
        pager: "#jqGridPager",
        pagerpos:'left',
        regional : 'cn',
        recordpos:'right',
        shrinkToFit: false,
        multiselect:true,
        height:"100%",
        altRows:true,
        autowidth: true
    });
	
}




function addSocialParams(){
		 xfui.open_dialog({    
		    title: '新增社保补贴参数',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/subsidy/socialParams/add.xf",
		    modal: true   
		}) 
}
function editSocialParams(){
	var rowId=$("#socialParamsList").jqGrid("getGridParam","selrow");
	if(rowId){
		xfui.open_dialog({    
	  		    title: '编辑社保补贴参数',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/subsidy/socialParams/edit.xf?id="+rowId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delSocialParams(){
	var rowIds=$("#socialParamsList").jqGrid("getGridParam","selarrrow");
	if(rowIds&&rowIds.length>0){
		var id="";
		$.each(rowIds,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/subsidy/socialParams/del.xf',
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
function refresh(){
	$('#socialParamsList').trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#socialParamsList").jqGrid({postData:json}).trigger("reloadGrid");
}


//导出退休人员查询数据
function initDataExp(){
	$('#exp').dataexp({
		gridId:"socialParamsList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'补贴参数维护',
		sheetName:'补贴参数维护',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson.status = 'h4';
			debugger;
			var id = $("#socialParamsList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			return dataJson;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		     }}]
	});
}



