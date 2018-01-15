var dataJson={};
$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
	var columns= [
	                   {name:'specialNumber',label:'编号',align:'center',frozen : true},
	                   {name:'aac003',label:'姓名',align:'center',frozen : true},
	                   {name:'aac002',label:'身份证号',align:'center',frozen : true},
	                   {name:'genderName',label:'性别',align:'center'},
	                   {name:'specialTypeName',label:'特殊档案类别',align:'center'},
	                   {name:'corpName',label:'单位名称',align:'center'},
	                   {name:'veteransNumber',label:'退伍编号',align:'center'},
	                   {name:'schoolName',label:'学校名称',align:'center'},
	                   {name:'schoolClass',label:'班级',align:'center'},
	                   {name:'major',label:'专业',align:'center'},
	                   {name:'specialStatusName',label:'特殊档案情况',align:'center'},
	                   {name:'zcName',label:'转出办理人',align:'center'},
	                   {name:'zcPhone',label:'办理人电话',align:'center'},
	                   {name:'zcWhere',label:'转出去向(单位)',align:'center'},
	                   {name:'zcReason',label:'转出原因',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'lrCreaterName',label:'经办人',align:'center'},
	                   {name:'lrCreaterDate',label:'经办日期',align:'center'},
	                   {name:'lrCreaterOrgName',label:'经办机构',align:'center'},
	                   {name:'id',label:'',hidden:true,key:true}
	                   
	                   
      	        	];
	$("#specialArchivesList").jqGrid({
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
           height : '100%'
       });
	$("#specialArchivesList").jqGrid('setFrozenColumns');
	
})


function refresh(){
	$("#specialArchivesList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/storage/specialArchives/listJson.xf'}).trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#specialArchivesList").jqGrid("clearGridData");	
	$("#specialArchivesList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/storage/specialArchives/listJson.xf',postData:json}).trigger("reloadGrid");
}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"specialArchivesList",
		serviceId:'archivesExpServiceImpl',
		fileName:'特殊类档案查询',
		sheetName:'特殊类档案查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
						var ids=$("#specialArchivesList").jqGrid("getDataIDs");
						if(ids&&ids.length>0){
							dataJson.menuNumber='5';
							return dataJson;
						}else{
							bootbox.alert('无可导出的数据！');
							return false;
						}
		           }},
		         /* {title:"导出选中的数据",paramCallBack:function(){
			        	  var ids=$("#specialArchivesList").jqGrid("getGridParam","selarrrow");
			      		  if(ids&&ids.length>0){
				      		  return {menuNumber:'5',ids:ids};
				      	  }else{
				      		  bootbox.alert('请选择记录');
				      		  return false;
				      	  }			        		
	  					}
			        },*/
			        {title:"导出当前页数据",paramCallBack:function(){
			        		var ids=$("#specialArchivesList").jqGrid("getDataIDs");
			      		    if(ids&&ids.length>0){
			      		    	return {menuNumber:'5',ids:ids};
				      	    }else{
					      	    bootbox.alert('请选择记录');
					      		return false;
				      	    }	
		  				}
				    }
		     ]
		
	});
}