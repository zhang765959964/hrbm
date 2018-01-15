$(function(){
	xfui.initUi();
})
$(function(){
		var columns= [
		                   {name:'ARCHIVECODE',label:'档案编号',align:'center',frozen : true},
		                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
		                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
		                   {name:'ARCHIVEFLOWSTATUSNAME',label:'借调状态',align:'center',frozen : true},
		                   {name:'ARCHIVENAME',label:'档案姓名',align:'center'},
		                   {name:'CHECKOUTDATE',label:'借阅日期',align:'center'},
		                   {name:'CHECKOUTPERIODDATE',label:'到期时间',align:'center'},
		                   {name:'AAE005',label:'手机号',align:'center'},
		                   {name:'EXPPERSONPHONE',label:'联系电话',align:'center'},
		                   {name:'GENDERNAME',label:'性别',align:'center'},
		                   {name:'AAC006',label:'出生日期',align:'center'},
		                   {name:'EXPSOCTALNUMBER',label:'社会保障号',align:'center'},
		                   {name:'CONTRACTCODE',label:'合同编号',align:'center'},
		                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
		                   {name:'NATIONNAME',label:'民族',align:'center'},
		                   {name:'EXPPERSONNUMBER',label:'个人编号',align:'center'},
		                   {name:'EXPOLDCOMPANY',label:'原单位名称',align:'center'},
		                   {name:'EXPENTRUSTCOMPANY',label:'委托单位名称',align:'center'},
		                   {name:'EXPPOST',label:'职务',align:'center'},
		                   {name:'EXPSTARTJOBDATE',label:'参加工作时间',align:'center'},
		                   {name:'EDUCATIONNAME',label:'文化程度',align:'center'},
		                   {name:'MARITALSTATUSNAME',label:'婚姻状况',align:'center'},
		                   {name:'POLITICALLANDSCAPE',label:'政治面貌',align:'center'},
		                   {name:'EXPISDISCOUNTNAME',label:'是否享有再就业优惠证标准',align:'center',width:180},
		                   {name:'AAB301',label:'现居住地址',align:'center'},
		                   {name:'FANAME',label:'配偶姓名',align:'center'},
		                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
		                   {name:'PLANRETIREDDATE',label:'退休参考日期',align:'center'},
		                   {name:'RECEIVEDATE',label:'档案接收日期',align:'center'},
		                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
		                   {name:'ARCHIVEPRINTLABEL',label:'打印档案标签',align:'center'},
		                   {name:'ARCHIVERECEIVEDESC',label:'备注',align:'center'},
		                   {name:'ARCHIVERECEIVENAME',label:'窗口经办人',align:'center'},
		                   {name:'ARCHIVERECEIVEORGNAME',label:'窗口经办机构',align:'center'},
		                   {name:'ARCHIVERECEIVEDATE',label:'窗口经办日期',align:'center'},
		                   {name:'RECEIVEDESC',label:'档案存放备注',align:'center'},
		                   {name:'ARCHIVERECEIVESTATUSNAME',label:'接收状态',align:'center'},
		                   {name:'MARKETPOSITION',label:'市场位置',align:'center'},
		                   {name:'CABINETSLIBRARY',label:'区',align:'center'},
		                   {name:'CABINETSCODE',label:'柜',align:'center'},
		                   {name:'CABINETSLAYER',label:'排',align:'center'},
		                   {name:'CABINETSLATTICE',label:'列',align:'center'},
		                   {name:'ARCHIVESTORAGENAME',label:'入库经办人',align:'center'},
		                   {name:'ARCHIVESTORAGEORGNAME',label:'入库经办机构',align:'center'},
		                   {name:'ARCHIVESTORAGEDATE',label:'入库经办日期',align:'center'},
		                   {name:'LENDDATE',label:'调出时间',align:'center'},
		                   {name:'ARCHIVESLENDWHERE',label:'档案去向',align:'center'},
		                   {name:'LENDNAME',label:'提档人',align:'center'},
		                   {name:'LENDIDNUMBER',label:'调出人身份证号',align:'center'},
		                   {name:'LENDREASONNAME',label:'调出原因',align:'center'},
		                   {name:'LENDPHONE',label:'调出人联系方式',align:'center'},
		                   {name:'LENDREMARKS',label:'调出备注',align:'center'},
		                   {name:'LENDCREATERNAME',label:'调出登记经办人',align:'center'},
		                   {name:'LENDCREATERORGNAME',label:'调出登记经办机构',align:'center'},
		                   {name:'LENDCREATERDATE',label:'调出登记经办时间',align:'center'},
		                   {name:'LENDCONFIRMNAME',label:'调出确认经办人',align:'center'},
		                   {name:'LENDCONFIRMORGNAME',label:'调出确认经办机构',align:'center'},
		                   {name:'LENDCONFIRMDATE',label:'调出确认经办时间',align:'center'}
	
	      	        	];
	
			$("#archivesList").jqGrid({
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
			
		$("#archivesList").jqGrid('setFrozenColumns');
	})

	function refresh(){
		$("#archivesList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archives/listJson.xf'}).trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		$("#archivesList").jqGrid("clearGridData");	
		$("#archivesList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archives/listJson.xf',postData:json}).trigger("reloadGrid");
		$(window).scrollTop(800)
	}