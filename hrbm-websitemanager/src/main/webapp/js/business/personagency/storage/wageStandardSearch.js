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
						{name:'nationName',label:'民族',align:'center'},
						{name:'aac011Name',label:'文化程度',align:'center'},
						{name:'aac006',label:'出生日期',align:'center'},
						{name:'expStartJobDate',label:'参加工作时间',align:'center'},
						{name:'adjustDate',label:'调整日期',align:'center'},
						{name:'positionType',label:'现岗位职位工种',align:'center'},
						{name:'ja01',label:'调整前执行何工资制度',align:'center'},
						{name:'jb01',label:'调整后执行何工资制度',align:'center'},
						{name:'ja02',label:'调整前技能或等级工资级别',align:'center'},
						{name:'jb02',label:'调整后技能或等级工资级别',align:'center'},
						{name:'ja03',label:'调整前技能或等级工资额（元）',align:'center'},
						{name:'jb03',label:'调整后技能或等级工资额（元）',align:'center'},
						{name:'ja04',label:'调整前岗位级工资级别',align:'center'},
						{name:'jb04',label:'调整后岗位级工资级别',align:'center'},
						{name:'ja05',label:'调整前岗位级工资额（元）',align:'center'},
						{name:'jb05',label:'调整后岗位级工资额（元）',align:'center'},
						{name:'ja06',label:'调整前连动工资额',align:'center'},
						{name:'jb06',label:'调整后连动工资额',align:'center'},
						{name:'ja07',label:'调整前工龄工资额',align:'center'},
						{name:'jb07',label:'调整后工龄工资额',align:'center'},
						{name:'ja08',label:'调整前合计',align:'center'},
						{name:'jb08',label:'调整后合计',align:'center'},
						{name:'ja09',label:'升级前等级',align:'center'},
						{name:'jb09',label:'升级后等级',align:'center'},
						{name:'ja10',label:'升级前月工资标准',align:'center'},
						{name:'jb10',label:'升级后月工资标准',align:'center'},
						{name:'createrName',label:'经办人',align:'center'},
						{name:'createrOrgName',label:'经办机构',align:'center'},
						{name:'createrDate',label:'经办日期',align:'center'}
						
	      	        	];
		$("#wageStandardList").jqGrid({
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
		$("#wageStandardList").jqGrid('setFrozenColumns');
	})

	function refresh(){
		$("#wageStandardList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/storage/wageStandard/listJson.xf'}).trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#wageStandardList").jqGrid("clearGridData");	
		$("#wageStandardList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/storage/wageStandard/listJson.xf',postData:json}).trigger("reloadGrid");
	}
	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"wageStandardList",
			serviceId:'archivesExpServiceImpl',
			fileName:'工资标准调整查询',
			sheetName:'工资标准调整查询',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#wageStandardList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								dataJson.menuNumber='6';
								return dataJson;
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
			         /* {title:"导出选中的数据",paramCallBack:function(){
				        	  var ids=$("#wageStandardList").jqGrid("getGridParam","selarrrow");
				      		  if(ids&&ids.length>0){
					      		  return {menuNumber:'6',ids:ids};
					      	  }else{
					      		  bootbox.alert('请选择记录');
					      		  return false;
					      	  }			        		
		  					}
				        },*/
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#wageStandardList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
				      		    	return {menuNumber:'6',ids:ids};
					      	    }else{
						      	    bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}