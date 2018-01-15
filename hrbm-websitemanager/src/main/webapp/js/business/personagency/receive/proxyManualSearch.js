var dataJson={};
$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
	var columns= [
	              		   {name:'PMID',label:'',align:'center',hidden:true,key:true,frozen : true},
		                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
		                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
		                   {name:'GENDERNAME',label:'性别',align:'center',frozen : true},
		                   {name:'AAC006',label:'出生日期',align:'center',frozen : true},
		                   {name:'LSSUINGDATE',label:'发放时间',align:'center'},
		                   {name:'PROXYISSUER',label:'发放人',align:'center'},
		                   {name:'PROXYTYPENAME',label:'发放原因',align:'center'},
		                   /*{name:'EFFECTIVEMARK',label:'有效标记',align:'center'},*/
		                   {name:'DESCRIPTION',label:'备注',align:'center'},
		                   {name:'CREATERNAME',label:'经办人',align:'center'},
		                   {name:'CREATERORGNAME',label:'经办机构',align:'center'},
		                   {name:'CREATERDATE',label:'经办日期',align:'center'},
		                   {name:'ARCHIVECODE',label:'档案编号',align:'center'},
		                   {name:'ARCHIVENAME',label:'档案姓名',align:'center'},
		                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
		                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
		                   {name:'RECEIVEDATE',label:'档案转入日期',align:'center'},
		                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
		                   {name:'EXPPERSONPHONE',label:'联系电话',align:'center'},
		                   {name:'AAE005',label:'手机号',align:'center'},
		                   {name:'ARCHIVESOURCE',label:'档案来源',align:'center'}
		                   

      	        	];

		$("#proxyManualList").jqGrid({
			//url:CTX+'/business/personagency/receive/proxyManual/searchListJson.xf',
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
		$("#proxyManualList").jqGrid('setFrozenColumns');
	})

	function refresh(){
		$("#proxyManualList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/receive/proxyManual/searchListJson.xf'}).trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#proxyManualList").jqGrid("clearGridData");	
		$("#proxyManualList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/receive/proxyManual/searchListJson.xf',postData:json}).trigger("reloadGrid");
	}

	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"proxyManualList",
			serviceId:'archivesExpServiceImpl',
			fileName:'代理手册合同书查询',
			sheetName:'代理手册合同书查询',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
				            var ids=$("#proxyManualList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								dataJson.menuNumber='4';
								return dataJson;
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
			          /*{title:"导出选中的数据",paramCallBack:function(){
				        	  var ids=$("#proxyManualList").jqGrid("getGridParam","selarrrow");
				      		  if(ids&&ids.length>0){
					      			return {menuNumber:'4',pmIds:ids};
					      	  }else{
					      		  bootbox.alert('请选择记录');
					      		  return false;
					      	  }			        		
		  					}
				        },*/
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#proxyManualList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'4',pmIds:ids};
					      	    }else{
						      		  bootbox.alert('当前页没有记录');
						      		  return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}
