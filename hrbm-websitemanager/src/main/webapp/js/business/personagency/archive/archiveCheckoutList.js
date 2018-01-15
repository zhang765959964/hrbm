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
	                   {name:'genderName',label:'性别',align:'center',frozen : true},
	                   {name:'aac006',label:'出生日期',align:'center'},
	                   {name:'checkoutDate',label:'借阅日期',align:'center'},
	                   {name:'checkoutPeriodDate',label:'到期时间',align:'center',cellattr: addCellAttr},
	                   {name:'checkoutStatusName',label:'借阅状态',align:'center'},
	                   {name:'checkoutTypeName',label:'借阅类别',align:'center'},
	                   {name:'checkoutContent',label:'借阅内容',align:'center'},
	                   {name:'checkoutPerson',label:'借阅人',align:'center'},
	                   {name:'checkoutPersonPhone',label:'借阅人电话',align:'center'},
	                   {name:'checkoutCorp',label:'借阅单位',align:'center'},
	                   {name:'checkoutKindsName',label:'借阅种类',align:'center'},
	                   {name:'batchName',label:'借阅批次',align:'center'},
	                   //{name:'seizureMaterialName',label:'暂扣材料',align:'center'},
	                   {name:'checkoutMortgage',label:'暂扣材料',align:'center'},
	                   {name:'checkoutRegisterName',label:'窗口借阅经办人',align:'center'},
	                   {name:'checkoutRegisterDate',label:'窗口经办日期',align:'center'},
	                   {name:'checkoutRegisterOrgName',label:'窗口经办机构',align:'center'},
	                   {name:'checkoutConfirmDate',label:'档案室借阅日期',align:'center'},
	                   {name:'checkoutConfirmName',label:'档案室借阅经办人',align:'center'},
	                   {name:'checkoutConfirmDate',label:'档案室借阅经办日期',align:'center'},
	                   {name:'checkoutConfirmOrgName',label:'档案室借阅经办机构',align:'center'},
	                   {name:'checkinDate',label:'返还日期',align:'center'},
	                   {name:'checkinName',label:'窗口返还经办人',align:'center'},
	                   {name:'checkinDate',label:'窗口返还经办日期',align:'center'},
	                   {name:'checkinOrgName',label:'窗口返还经办机构',align:'center'},
	                   {name:'checkinConfirmDate',label:'档案室返还经办日期',align:'center'},
	                   {name:'checkinConfirmName',label:'档案室返还经办人',align:'center'},
	                   {name:'checkinConfirmOrgName',label:'档案室返还经办机构',align:'center'},
	                   {name:'archiveName',label:'档案姓名',align:'center'},
	                   {name:'archiveBirthDate',label:'档案出生日期',align:'center'},
	                   {name:'receiveDate',label:'档案转入日期',align:'center'},
	                   {name:'archiveStatusName',label:'档案状态',align:'center'},
	                   {name:'archiveTypeName',label:'存档类型',align:'center'},
	                   {name:'expPersonPhone',label:'联系电话',align:'center'},
	                   {name:'aae005',label:'手机号',align:'center'},
	                   {name:'archiveSource',label:'档案来源',align:'center'}

      	        	];

		$("#archiveCheckoutList").jqGrid({
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
	
		$("#archiveCheckoutList").jqGrid('setFrozenColumns');
})

	function refresh(){
		$("#archiveCheckoutList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archiveCheckout/listJson.xf'}).trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		$("#archiveCheckoutList").jqGrid("clearGridData");	
		$("#archiveCheckoutList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archiveCheckout/listJson.xf',postData:json}).trigger("reloadGrid");
	}
	
	//到期未返还名单
	function searchMaturityNotReturned(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#archiveCheckoutList").jqGrid("clearGridData");	
		$("#archiveCheckoutList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archiveCheckout/maturityNotReturned.xf',postData:json}).trigger("reloadGrid");
	}
	
	function addCellAttr(rowId, val, rawObject, cm, rdata) {
		var date = new Date();
	    var seperator1 = "-";
	    var month = date.getMonth() + 1;
	    var strDate = date.getDate();
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
	    var d1 = currentdate.replace(/\-/g, "\/");  
	    var d2 = val.replace(/\-/g, "\/");  
	    var checkoutStatus = rawObject.checkoutStatus;
	    if(currentdate!=""&&val!=""&&d1 >=d2){
	    	if(checkoutStatus==2)
	    		return "style='color:red'";
	    }
    }
	
	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"archiveCheckoutList",
			serviceId:'archivesExpServiceImpl',
			fileName:'借阅归还综合查询',
			sheetName:'借阅归还综合查询',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#archiveCheckoutList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								dataJson.menuNumber='3';
								return dataJson;
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#archiveCheckoutList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		 return {menuNumber:'3',ids:ids};
					      	    }else{
						      		 bootbox.alert('请选择记录');
						      		 return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}