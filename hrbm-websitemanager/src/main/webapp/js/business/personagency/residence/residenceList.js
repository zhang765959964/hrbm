var dataJson={};
$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
		var columns= [
		              	   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	                 	   {name:'aac003',label:'姓名',align:'center',frozen : true},
	                 	   {name:'aac002',label:'身份证号',align:'center',frozen : true},
	                 	   {name:'genderName',label:'性别',align:'center'},
	                 	   {name:'educationName',label:'文化程度',align:'center'},
						   {name:'archiveTypeName',label:'存档类型',align:'center'},
		                   {name:'applicationDate',label:'申请日期',align:'center'},
		                   {name:'materialCategoryName',label:'材料类别',align:'center'},
		                   {name:'materialName',label:'提交材料名称',align:'center'},
		                   {name:'aae005',label:'联系方式',align:'center'},
		                   {name:'isBackName',label:'是否退回',align:'center'},
		                   {name:'backReason',label:'退回原因',align:'center'},
		                   {name:'applicationOneselfDate',label:'材料退回本人日期',align:'center'},
		                   {name:'isNoticeName',label:'是否通知',align:'center'},
		                   {name:'noticeDate',label:'通知日期',align:'center'},
		                   {name:'createrName',label:'经办人',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'}
		                
	      	        	];
		  $("#residenceList").jqGrid({
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
		  $("#residenceList").jqGrid('setFrozenColumns');
	})


	function refresh(){
		$("#residenceList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/residence/residence/listJson.xf'}).trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#residenceList").jqGrid("clearGridData");	
		$("#residenceList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/residence/residence/listJson.xf',postData:json}).trigger("reloadGrid");
	}
	
	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"residenceList",
			serviceId:'archivesExpServiceImpl',
			fileName:'户口材料查询',
			sheetName:'户口材料查询',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#residenceList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								dataJson.menuNumber='b';
								return dataJson;
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#residenceList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		  return {menuNumber:'b',ids:ids};
					      	    }else{
						      		  bootbox.alert('请选择记录');
						      		  return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}