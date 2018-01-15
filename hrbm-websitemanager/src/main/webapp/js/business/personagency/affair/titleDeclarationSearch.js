var dataJson={};
$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
		var columns= [
	                   
		                   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
		                   {name:'serialNumber',label:'序号',align:'center',frozen : true},
		                   {name:'aac003',label:'姓名',align:'center',frozen : true},
		                   {name:'aac002',label:'公民身份号码',align:'center'},
		                   {name:'genderName',label:'性别',align:'center'},
		                   {name:'educationName',label:'文化程度',align:'center'},
		                   {name:'archiveTypeName',label:'存档类型',align:'center'},
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


	function refresh(){
		$("#titleDeclarationList").trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#titleDeclarationList").jqGrid("clearGridData");	
		$("#titleDeclarationList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/affair/titleDeclaration/listJson.xf',postData:json}).trigger("reloadGrid");
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
	