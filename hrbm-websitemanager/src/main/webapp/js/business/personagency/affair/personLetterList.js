var dataJson={};
$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
	var columns= [
	                   {name:'aac003',label:'姓名',align:'center'},
	                   {name:'fileNumber',label:'文件号',align:'center'},
	                   {name:'workUnit',label:'工作单位',align:'center'},
	                   {name:'escrowContent',label:'代管内容',align:'center'},
	                   {name:'reason',label:'事由',align:'center'},
	                   {name:'handlingMatters',label:'办理事项',align:'center'},
	                   {name:'dateOfIssue',label:'开具日期',align:'center'},
	                   {name:'fourthItems',label:'第4项内容',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                
      	        	];
	$("#personLetterList").jqGrid({
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "local",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           //multiselect:true,
           autowidth: true,
           altRows:true,
           multiboxonly: true,
           rownumbers : true,
           height:'100%'
       });
})

function addPersonLetter(){	
		xfui.open_dialog({    
		    title: '添加人事档案联系函信息',    
		    width: 950,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/affair/personLetter/add.xf",
		    modal: true   
		})
}
function editPersonLetter(){
	var id=$("#personLetterList").jqGrid("getGridParam","selrow");
	if(id){
		var id=id;
		xfui.open_dialog({    
	  		    title: '修改人事档案联系函信息',    
	  		    width: 950,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/affair/personLetter/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delPersonLetter(){
	//var ids=$("#personLetterList").jqGrid("getGridParam","selarrrow");
	var ids=$("#personLetterList").jqGrid("getGridParam","selrow");
	if(ids&&ids.length>0){
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/affair/personLetter/del.xf',
		    		data:{id:ids},
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
	$("#personLetterList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/affair/personLetter/listJson.xf'}).trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#personLetterList").jqGrid("clearGridData");	
	$("#personLetterList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/affair/personLetter/listJson.xf',postData:json}).trigger("reloadGrid");
}
//打印
function printPersonLetter(){
	var ids=$("#personLetterList").jqGrid("getGridParam","selrow");
	if(ids&&ids.length>0){
		var param = {"id":ids,"type":2};
		templatePrint("personLetter",param);
	}else{
		 bootbox.alert('请选择记录');
	}	
}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"personLetterList",
		serviceId:'archivesExpServiceImpl',
		fileName:'人事档案联系函',
		sheetName:'人事档案联系函',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
						var ids=$("#personLetterList").jqGrid("getDataIDs");
						if(ids&&ids.length>0){
							dataJson.menuNumber='7';
							return dataJson;
						}else{
							bootbox.alert('无可导出的数据！');
							return false;
						}
		           }},
		         /* {title:"导出选中的数据",paramCallBack:function(){
			        	  //var ids=$("#personLetterList").jqGrid("getGridParam","selarrrow");
			        	  var ids=$("#personLetterList").jqGrid("getGridParam","selrow");
			      		  if(ids&&ids.length>0){
				      		  return {menuNumber:'7',ids:ids};
				      	  }else{
				      		  bootbox.alert('请选择记录');
				      		  return false;
				      	  }			        		
	  					}
			        },*/
			        {title:"导出当前页数据",paramCallBack:function(){
			        		var ids=$("#personLetterList").jqGrid("getDataIDs");
			      		    if(ids&&ids.length>0){
			      		    	return {menuNumber:'7',ids:ids};
				      	    }else{
					      	    bootbox.alert('请选择记录');
					      		return false;
				      	    }	
		  				}
				    }
		     ]
		
	});
}