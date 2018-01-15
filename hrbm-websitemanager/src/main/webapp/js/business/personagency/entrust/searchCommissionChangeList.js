var dataJson={};
$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
		var columns= [
					       {name:'aac002',label:'身份证号',align:'center',frozen : true},
		                   {name:'aac003',label:'姓名',align:'center',frozen : true},
					       {name:'genderName',label:'性别',align:'center',frozen : true},
					       {name:'aac006',label:'出生日期',align:'center'},
		                   {name:'commissionTypeName',label:'变更类型',align:'center'},
		                   {name:'commissionDate',label:'变更日期',align:'center'},
		                   {name:'archiveCodeBefore',label:'变更前档案编号',align:'center'},
		                   {name:'archiveCodeAfter',label:'变更后档案编号',align:'center'},
		                   {name:'commissionCorpName',label:'变更委托单位名称',align:'center'},
		                   {name:'archiveCode',label:'档案编号',align:'center'},
		                   {name:'archiveName',label:'档案姓名',align:'center'},
		                   {name:'archiveBirthDate',label:'档案出生日期',align:'center'},
		                   {name:'receiveDate',label:'档案转入日期',align:'center'},
		                   {name:'archiveStatusName',label:'档案状态',align:'center'},
		                   {name:'archiveTypeName',label:'存档类型',align:'center'},
		                   {name:'expPersonPhone',label:'联系电话',align:'center'},
		                   {name:'aae005',label:'手机号',align:'center'},
		                   {name:'description',label:'备注',align:'center'},
		                   {name:'createrName',label:'经办人',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'}

	      	        	];
		$("#commissionChangeList").jqGrid({
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
		$("#commissionChangeList").jqGrid('setFrozenColumns');
	})

	function refresh(){
		$("#commissionChangeList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/entrust/commissionChange/searchListJson.xf'}).trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#commissionChangeList").jqGrid("clearGridData");	
		$("#commissionChangeList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/entrust/commissionChange/searchListJson.xf',postData:json}).trigger("reloadGrid");
	}
	
	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"commissionChangeList",
			serviceId:'archivesExpServiceImpl',
			fileName:'类型变更综合查询',
			sheetName:'类型变更综合查询',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#commissionChangeList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								dataJson.menuNumber='a';
								return dataJson;
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#commissionChangeList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		  return {menuNumber:'a',ids:ids};
					      	    }else{
						      		  bootbox.alert('请选择记录');
						      		  return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}