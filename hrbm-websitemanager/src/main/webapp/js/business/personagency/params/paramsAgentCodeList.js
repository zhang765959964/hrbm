$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'fdTypeCode',label:'代码类别',align:'center'},
	                   {name:'fdTypeName',label:'类别名称',align:'center'},
	                   {name:'fdCodeName',label:'代码名称',align:'center'},
	                   {name:'fdCodeValue',label:'代码值',align:'center'},
	                   {name:'fdPinyinCode',label:'拼音码',align:'center'},
	                {name:'pkId',label:'主键',hidden:true,width:100,key:true }
      	        	];
	$("#paramsAgentCodeList").jqGrid({
		   url:CTX+'/business/personagency/params/paramsAgentCode/listJson.xf',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "json",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           multiselect:true,
           autowidth: true,
           height:'100%'
       });
})

function addParamsAgentCode(){	
		xfui.open_dialog({    
		    title: '新增劳动代理代码维护',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/params/paramsAgentCode/add.xf",
		    modal: true   
		})
}
function editParamsAgentCode(){
	//var row = $('#paramsAgentCodeList').bootstrapTable('getAllSelections');
	var rowid=$("#paramsAgentCodeList").jqGrid("getGridParam","selrow");
	if(rowid){
		var pkId=rowid;
		xfui.open_dialog({    
	  		    title: '编辑劳动代理代码维护',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/params/paramsAgentCode/edit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delParamsAgentCode(){

	var rowids=$("#paramsAgentCodeList").jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var pkId="";
		$.each(rowids,function(i,e){
			if(i==0){
				pkId+=e;
			}else{
				pkId+=","+e;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/params/paramsAgentCode/del.xf',
		    		data:{pkId:pkId},
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
	$("#paramsAgentCodeList").trigger("reloadGrid");
}
function doSearch(){
	$("#paramsAgentCodeList").jqGrid("clearGridData");
	var json=$("#searchForm").serializeJson();
	$("#paramsAgentCodeList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}