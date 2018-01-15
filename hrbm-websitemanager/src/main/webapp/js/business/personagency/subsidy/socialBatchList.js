var dataJson ={};
$(function(){
	initl();
	initDataExp();
	
})

function initl(){
	/**
	 初始化表格显示
	*/
	var columns= [	   {name:'batchName',label:'批次名称',align:'center'},
	                   {name:'batchStartdate',label:'批次开始时间',align:'center'},
	                   {name:'batchEnddate',label:'批次结束时间',align:'center'},
	                   {name:'description',label:'描述',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'}
     	        	] ;
	   $("#socialBatchList").jqGrid({
		   url:CTX+'/business/personagency/subsidy/socialBatch/listJson.xf',
          editurl:CTX+'/business/personagency/subsidy/socialSubsidy/numUpdateSave.xf',
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
//          multiselect:true,
          height:"100%",
          altRows:true,
          autowidth: true
      });
	
	
}



function addSocialBatch(){	
		xfui.open_dialog({    
		    title: '新增补贴批次',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/subsidy/socialBatch/add.xf",
		    modal: true   
		})
}
function editSocialBatch(){
	var id=$("#socialBatchList").jqGrid("getGridParam","selrow");
	if(id){
		xfui.open_dialog({    
	  		    title: '编辑补贴批次',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/subsidy/socialBatch/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delSocialBatch(){
	var id=$("#socialBatchList").jqGrid("getGridParam","selrow");
	if(id){
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/subsidy/socialBatch/del.xf',
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
	$('#socialBatchList').trigger("reloadGrid");
}

function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#socialBatchList").jqGrid({postData:json}).trigger("reloadGrid");
}


//导出退休人员查询数据
function initDataExp(){
	$('#exp').dataexp({
		gridId:"socialBatchList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'补贴批次维护',
		sheetName:'补贴批次维护',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson.status = 'h3';
			debugger;
			var id = $("#socialBatchList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			return dataJson;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		           }}
		          ]
	});
}

