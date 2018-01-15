var dataJson={};
$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
		var columns= [
			              
			               {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
		                   {name:'aac003',label:'姓名',align:'center',frozen : true},
		                   {name:'aac002',label:'公民身份号码',align:'center',frozen : true},
		                   {name:'genderName',label:'性别',align:'center'},
		                   {name:'educationName',label:'文化程度',align:'center'},
		                   {name:'archiveTypeName',label:'存档类型',align:'center'},
		                   {name:'contactNumber',label:'联系电话',align:'center'},
		                   {name:'workUnit',label:'工作单位',align:'center'},
		                   {name:'workingAge',label:'工作年龄',align:'center'},
		                   {name:'examinationTypeName',label:'考试类别',align:'center'},
		                   {name:'examinationMxTypeName',label:'考试明细',align:'center'},
		                   {name:'examinationLevelName',label:'考试级别',align:'center'},
		                   {name:'examinationChengji',label:'考试成绩',align:'center'},
		                   {name:'evaluationResultName',label:'评定结果',align:'center'},
		                   {name:'isLingExaminationName',label:'是否领取成绩单',align:'center'},
		                   {name:'isLingZhengshuName',label:'是否领取证书',align:'center'},
		                   {name:'createrName',label:'经办人',align:'center'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'}
		                
	      	        	];
		$("#examinationRegisterList").jqGrid({
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
		$("#examinationRegisterList").jqGrid('setFrozenColumns'); 
	})
	function refresh(){
		$("#examinationRegisterList").trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#examinationRegisterList").jqGrid("clearGridData");	
		$("#examinationRegisterList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/affair/examinationRegister/listJson.xf',postData:json}).trigger("reloadGrid");
	}
	
	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"examinationRegisterList",
			serviceId:'archivesExpServiceImpl',
			fileName:'考试报名登记',
			sheetName:'考试报名登记',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#examinationRegisterList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								dataJson.menuNumber='9';
								return dataJson;
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#examinationRegisterList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'9',ids:ids};
					      	    }else{
						      		bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}