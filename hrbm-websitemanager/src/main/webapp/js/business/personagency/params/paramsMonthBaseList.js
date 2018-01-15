$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'fdMonthBase',label:'月缴费基数',align:'center'},
	                   {name:'fdParmsDesc',label:'参数描述',align:'center'},
	                   {name:'fdDesc',label:'备注',align:'center'},
// 	                   {name:'fkCreaterId',label:'经办人ID',align:'center'},
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},
// 	                   {name:'fkCreaterOrgId',label:'经办机构ID',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
	                {name:'pkId',label:'主键',hidden:true,width:100,key:true }
      	        	];
	$("#paramsMonthBaseList").jqGrid({
		   url:CTX+'/business/personagency/params/paramsMonthBase/listJson.xf',
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

function addParamsMonthBase(){	
		xfui.open_dialog({    
		    title: '新增月缴费基数',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/params/paramsMonthBase/add.xf",
		    modal: true   
		})
}
function editParamsMonthBase(){
	//var row = $('#paramsMonthBaseList').bootstrapTable('getAllSelections');
	var rowid=$("#paramsMonthBaseList").jqGrid("getGridParam","selrow");
	if(rowid){
		var pkId=rowid;
		xfui.open_dialog({    
	  		    title: '编辑月缴费基数',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/params/paramsMonthBase/edit.xf?pkId="+pkId,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delParamsMonthBase(){

	var rowids=$("#paramsMonthBaseList").jqGrid("getGridParam","selarrrow");
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
		    	$.ajax({ url: CTX+'/business/personagency/params/paramsMonthBase/del.xf',
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
	$("#paramsMonthBaseList").trigger("reloadGrid");
}
function doSearch(){
	$("#paramsMonthBaseList").jqGrid("clearGridData");
	var json=$("#searchForm").serializeJson();
	$("#paramsMonthBaseList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}