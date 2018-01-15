var dataJson={};
$(function(){
	initDataExp();
})
$(function(){
	 var columns= [		
					   {name:'aac003',label:'姓名',align:'center',frozen : true},
					   {name:'aac002',label:'公民身份号码',align:'center',frozen : true},
					   {name:'genderName',label:'性别',align:'center',frozen : true},
	                   {name:'serialNumber',label:'序号',align:'center'},
	                   {name:'contactNumber',label:'联系电话',align:'center'},
	                   {name:'workUnit',label:'工作单位',align:'center'},
	                   {name:'workingAge',label:'工作年龄',align:'center'},
	                   {name:'nowTitleGradeName',label:'现职称级别',align:'center'},
	                   {name:'declarationLevelName',label:'申报级别',align:'center'},
	                   {name:'evaluationResultName',label:'评定结果',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                
      	        	];
	$("#titleDeclarationList").jqGrid({
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
           multiselect:true,
           autowidth: true,
           altRows:true,
           height:'100%'
       });
	$("#titleDeclarationList").jqGrid('setFrozenColumns'); 
})

function addTitleDeclaration(){	
	var rowId=$("#titleArchivesList").jqGrid("getGridParam","selrow");
	var rowData=$("#titleArchivesList").jqGrid("getRowData",rowId);
	var id = rowData.ID;
	if(rowId){
		xfui.open_dialog({    
		    title: '添加职称申报评定信息',    
		    width: 950,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/affair/titleDeclaration/add.xf?archivesId="+id,
		    modal: true   
		})
	}else{
		bootbox.alert('请选择档案信息记录');
	}	
}
function editTitleDeclaration(){
	var id=$("#titleDeclarationList").jqGrid("getGridParam","selrow");
	if(id){
		var id=id;
		xfui.open_dialog({    
	  		    title: '修改职称申报评定信息',    
	  		    width: 950,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/affair/titleDeclaration/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择要修改的职称申报信息记录');
	}			
} 

function delTitleDeclaration(){
	var ids=$("#titleDeclarationList").jqGrid("getGridParam","selarrrow");
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
		    	$.ajax({ url: CTX+'/business/personagency/affair/titleDeclaration/del.xf',
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
		 bootbox.alert('请选择要删除的职称申报信息记录');
	 }			
} 
function refresh(){
	$("#titleDeclarationList").trigger("reloadGrid");
}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"titleDeclarationList",
		serviceId:'archivesExpServiceImpl',
		fileName:'职称申报评定',
		sheetName:'职称申报评定',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
						var ids=$("#titleDeclarationList").jqGrid("getDataIDs");
						if(ids&&ids.length>0){
							dataJson.menuNumber='8';
							return dataJson;
						}else{
							bootbox.alert('无可导出的数据！');
							return false;
						}
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        		var ids=$("#titleDeclarationList").jqGrid("getDataIDs");
			      		    if(ids&&ids.length>0){
					      		return {menuNumber:'8',ids:ids};
				      	    }else{
					      		bootbox.alert('请选择记录');
					      		return false;
				      	    }	
		  				}
				    }
		     ]
		
	});
}
