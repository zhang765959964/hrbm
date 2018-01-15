var dataJson = {};
$(function (){
	xfui.initUi();
	cdxxInitl();
	 $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		  var target =e.target;
		  var bindEvent=$(target).attr("bindEvent");
		  eval(bindEvent+'()'); 
		  
		})
		
		initDataExpCdxx();
	/*	initDataExpRetired();
	 	initDataExpParty();
	 	initDataExpPartyPay();
	 	initDataExpDeath();
	 	initDataExpDeathPerson();*/
})



	//存档信息
	function cdxxInitl(){
		var cdxxcolumns= [
		               {name:'PERSONID',label:'人员id',align:'center',frozen : true,hidden:true},
	                   {name:'ARCHIVECODE',label:'档案编号',align:'center',frozen : true},
	                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
	                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
	                   {name:'ARCHIVEFLOWSTATUSNAME',label:'借调状态',align:'center',frozen : true},
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
	                   {name:'EXPISDISCOUNT',label:'是否享有再就业优惠证标准',align:'center'},
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
	                   {name:'LENDPEOPLEMENTION',label:'提档人',align:'center'},
	                   {name:'LENDIDNUMBER',label:'调出人身份证号',align:'center'},
	                   {name:'LENDSTRINGREASON',label:'调出原因',align:'center'},
	                   {name:'LENDPHONE',label:'调出人联系方式',align:'center'},
	                   {name:'LENDREMARKS',label:'调出备注',align:'center'},
	                   {name:'LENDCREATERNAME',label:'调出经办人',align:'center'},
	                   {name:'LENDCREATERORGNAME',label:'调出经办机构',align:'center'},
	                   {name:'LENDCREATERDATE',label:'调出经办时间',align:'center'}

     	        	];
		$("#cdxxList").jqGrid({
		//	url:CTX+'/business/personagency/archive/archives/listJson.xf?dataSources=1',
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: cdxxcolumns,
			viewrecords: true,
	        rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager1",
	        pagerpos:'left',
	        regional : 'cn',
	        recordpos:'right',
	        shrinkToFit: false,
	        multiselect:true,
	        autowidth: true,
	        height:'100%',
	        multiboxonly : true,
	        multiselect : true,
	        onSelectRow :function(rowid,e){
	         	var rowData = $("#cdxxList").jqGrid('getRowData',rowid);
	        	var personIds = rowData.PERSONID;
	        	$("#personIds").val(personIds);
			}
	    });
		//$("#zhcxList").jqGrid('setFrozenColumns');
		
	}
	
	
	
	
	
	
	
	//档案借阅信息
	function archiveJyInitl(){
		var archivecolumns= [
		              	   {name:'checkoutTypeName',label:'借阅类别',align:'center',frozen : true},
		              	   {name:'checkoutDate',label:'借阅日期',align:'center',frozen : true},
		              	   {name:'checkoutStatusName',label:'借阅状态',align:'center',frozen : true},
		              	   {name:'checkoutCorp',label:'借阅单位',align:'center'},
		              	   {name:'checkoutPerson',label:'借阅人',align:'center'},
		              	   {name:'checkoutPersonPhone',label:'借阅人电话',align:'center'},
		              	   {name:'seizureMaterialName',label:'暂扣材料',align:'center'},
		                   {name:'checkoutReason',label:'借阅原因',align:'center'},
		                   {name:'checkoutContent',label:'借阅内容',align:'center'},
		                   {name:'checkoutPeriodDate',label:'到期时间',align:'center'},
		                   {name:'checkoutRegisterName',label:'借阅登记经办人姓名',align:'center'},
		                   {name:'checkoutRegisterDate',label:'借阅登记经办日期',align:'center'},
		                   {name:'checkoutRegisterOrgName',label:'借阅登记经办机构名称',align:'center'},
		                   {name:'checkoutConfirmName',label:'借阅确认经办人姓名',align:'center'},
		                   {name:'checkoutConfirmDate',label:'借阅确认经办日期',align:'center'},
		                   {name:'checkoutConfirmOrgName',label:'借阅确认经办人机构名称',align:'center'},
		                   {name:'checkinName',label:'借阅返还登记人姓名',align:'center'},
		                   {name:'checkinDate',label:'借阅返还登记经办日期',align:'center'},
		                   {name:'checkinOrgName',label:'借阅返还登记机构名称',align:'center'},
		                   {name:'checkinConfirmDate',label:'借阅返还确认经办日期',align:'center'},
		                   {name:'checkinConfirmName',label:'借阅返还确认人姓名',align:'center'},
		                   {name:'checkinConfirmOrgName',label:'借阅返还确认机构名称',align:'center'},
		                   {name:'checkoutStatus',label:'',align:'center',hidden:true}
	     	        	];

		$("#archiveJyList").jqGrid({
		   //url:CTX+'/business/personagency/archive/archiveCheckout/listJson.xf?personId='+$("#personIds").val(),
	       mtype: "GET",
	       styleUI : 'Bootstrap',
	       datatype: "local",
	       colModel: archivecolumns,
		   viewrecords: true,
	       rowNum: 10,
	       rowList:[10,20,30],
	       pager: "#jqGridPager2",
	       pagerpos:'left',
	       regional : 'cn',
	       recordpos:'right',
	       shrinkToFit: false,
	       multiselect:false,
	       autowidth: true,
	       height:'100%'
	   });
		
	}


	
	//委托类型变更
	function commissionInitl(){
		var commissioncolumns= [
	                  {name:'commissionTypeName',label:'变更类型',align:'center',frozen : true},
	                  {name:'commissionDate',label:'变更日期',align:'center',frozen : true},
	                  {name:'archiveCodeBefore',label:'变更前档案编号',align:'center'},
	                  {name:'archiveCodeAfter',label:'变更后档案编号',align:'center'},
	                  {name:'description',label:'备注',align:'center'},
	                  {name:'createrName',label:'经办人',align:'center'},
	                  {name:'createrDate',label:'经办日期',align:'center'},
	                  {name:'createrOrgName',label:'经办机构',align:'center'}
		        	];
		
		
		$("#commissionList").jqGrid({
	          mtype: "GET",
			 // url:CTX+'/business/personagency/entrust/commissionChange/searchListJson.xf?personId='+$("#personIds").val(),
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: commissioncolumns,
			  viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager3",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          shrinkToFit: false,
	          multiselect:true,
	          autowidth: true,
	          height:'100%'
	      });
		
		
	}


	//费用信息
	function  paymentInitl(){
		
		var paymentcolumns= [	  
		                   {name:'fdPaymentDate',label:'缴费日期',align:'center',frozen : true},
		                   {name:'fdStartDate',label:'开始缴费日期',align:'center'},
		                   {name:'fdEndDate',label:'终止缴费日期',align:'center'},
		                   {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
		                   {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
		                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	                   
		                   {name:'fdPaymentType',label:'缴费类型',align:'center'},	                  
		                   {name:'fdPaymentStatus',label:'缴费状态',align:'center'},	                  
		                   {name:'fdCreaterName',label:'经办人',align:'center'},
		                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
		                   {name:'fdCreaterDate',label:'经办时间',align:'center'}	                  
		                
	      	        	];
		$("#paymentList").jqGrid({
	          mtype: "GET",
			  //url:CTX+'/business/personagency/payment/paymentRecord/listJson.xf?fkPersonId='+$("#personIds").val(),
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: paymentcolumns,
			  viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager4",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          shrinkToFit: false,
	          multiselect:true,
	          autowidth: true,
	          height:'100%'
	       });
		
		
		
	}

	//工资标准调整信息
	function  wageInitl(){
		/**
		 初始化表格显示
		*/
		var columns= [
		                   {name:'aac003',label:'姓名',align:'center',frozen : true},
		                   {name:'genderName',label:'性别',align:'center',frozen : true},
		                   {name:'nationName',label:'民族',align:'center',frozen : true},
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
		$("#wageList").jqGrid({
			 // url:CTX+'/business/personagency/storage/wageStandard/listJson.xf?ccpr08=0&personId='+$("#personIds").val(),
	          mtype: "GET",
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: columns,
			  viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager5",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          shrinkToFit: false,
	          multiselect:true,
	          autowidth: true,
	          height:'100%'
	      });
		
		
		
	}

	//职务评定信息
	function zcpdInitl(){
		 var zcpdcolumns= [		
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
	                   {name:'createrName',label:'经办人姓名',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                
	  	        	];
		 $("#zcpdList").jqGrid({
		  // url:CTX+'/business/personagency/affair/titleDeclaration/listJson.xf?personId='+$("#personIds").val(),
	       mtype: "GET",
		   styleUI : 'Bootstrap',
	       datatype: "local",
	       colModel: zcpdcolumns,
		   viewrecords: true,
	       rowNum: 5,
	       rowList:[5,10,15],
	       pager: "#zcpdPager",
	       pagerpos:'left',
	       regional : 'cn',
	       recordpos:'right',
	       shrinkToFit: false,
	       multiselect:true,
	       autowidth: true,
	       height:'100%'
	   });
		
	}

	//考试报名信息
	function ksbmInitl(){
			var ksbmcolumns= [
		                  {name:'aac003',label:'姓名',align:'center',frozen : true},
					       {name:'aac002',label:'公民身份号码',align:'center',frozen : true},
					       {name:'genderName',label:'性别',align:'center',frozen : true},
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
		                  {name:'createrName',label:'经办人姓名',align:'center'},
		                  {name:'createrOrgName',label:'经办机构',align:'center'},
		                  {name:'createrDate',label:'经办日期',align:'center'}
		               
		 	        	];
		$("#ksbmList").jqGrid({
			//  url:CTX+'/business/personagency/affair/examinationRegister/listJson.xf?personId='+$("#personIds").val(),
		      mtype: "GET",
			  styleUI : 'Bootstrap',
		      datatype: "local",
		      colModel: ksbmcolumns,
			  viewrecords: true,
		      rowNum: 10,
		      rowList:[10,20,30],
		      pager: "#jqGridPager6",
		      pagerpos:'left',
		      regional : 'cn',
		      recordpos:'right',
		      shrinkToFit: false,
		      multiselect:true,
		      autowidth: true,
		      height:'100%'
		  });
		
		
		
	}


	//户口材料信息
	function hkclInitl(){
		var hkclcolumns= [
	                  {name:'applicationDate',label:'申请日期',align:'center',frozen : true},
	                  {name:'materialCategoryName',label:'材料类别 ',align:'center',frozen : true},
	                  {name:'materialName',label:'提交材料名称',align:'center',frozen : true},
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
		$("#hkclList").jqGrid({
			//  url:CTX+'/business/personagency/residence/residence/listJson.xf?personId='+$("#personIds").val(),
		      mtype: "GET",
			  styleUI : 'Bootstrap',
		      datatype: "local",
		      colModel: hkclcolumns,
			  viewrecords: true,
		      rowNum: 10,
		      rowList:[10,20,30],
		      pager: "#jqGridPager7",
		      pagerpos:'left',
		      regional : 'cn',
		      recordpos:'right',
		      shrinkToFit: false,
		      multiselect:true,
		      autowidth: true,
		      height:'100%'
		  });
		
	}

	//户口信息
	function hkxxInitl(){
		
		var columns2 = [
		                   {name:'residenceNumber',label:'户口编号',align:'center',frozen : true},
		                   {name:'residenceStatusName',label:'户口状态',align:'center',frozen : true},
		                   {name:'moveDate',label:'迁入日期',align:'center',frozen : true},
		                   {name:'outDate',label:'迁出日期',align:'center'},
		                   {name:'settleDepartment',label:'落户地户籍部门',align:'center'},
		                   {name:'originalDomicile',label:'原户籍所在地',align:'center'},
		                   {name:'settleAddress',label:'落户地址',align:'center'},
		                   {name:'openDate',label:'开具日期',align:'center'},
		                   {name:'thoseGraduates',label:'毕业生届期',align:'center'},
		                   {name:'moveToAddress',label:'迁往地址',align:'center'},
		                   {name:'description',label:'备注',align:'center'},
		                   {name:'createrName',label:'经办人',align:'center'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'}
	             
		        	];
		$("#residenceMoveOutList").jqGrid({
		  // url:CTX+'/business/personagency/residence/residenceMoveOut/listJson.xf?personId='+$("#personIds").val(),
		   mtype: "GET",
		   styleUI : 'Bootstrap',
		   datatype: "local",
		   colModel: columns2,
		   viewrecords: true,
		   rowNum: 10,
		   rowList:[10,20,30],
		   pager: "#jqGridPager8",
		   pagerpos:'left',
		   regional : 'cn',
		   recordpos:'right',
		   shrinkToFit: false,
		   multiselect:true,
		   autowidth: true,
		   height:'100%'
	});
		
		var columns3= [
		                 
	                   {name:'borrowerName',label:'借用人姓名',align:'center',frozen : true},
	                   {name:'borrowerCard',label:'借用人身份证号',align:'center',frozen : true},
	                   {name:'borrowerPhone',label:'借用人联系电话',align:'center',frozen : true},
	                   {name:'borrowerDate',label:'借用日期',align:'center'},
	                   {name:'maturityDate',label:'到期日期',align:'center'},
	                   {name:'returnDate',label:'归还日期',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                
	 	        	];
		$("#residenceReturnList").jqGrid({
			  url:CTX+'/business/personagency/residence/residenceReturn/listJson.xf?personId='+$("#personIds").val(),
	          mtype: "GET",
			  styleUI : 'Bootstrap',
	          datatype: "json",
	          colModel: columns3,
			  viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager81",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          shrinkToFit: false,
	          multiselect:true,
	          autowidth: true,
	          height:'100%'
	      });
		
		
		
	}


	
	//死亡
	function deathInitl(){
		var deathcolumns= [		
	                   {name:'ID',hidden:true,key:true,align:'center',frozen : true},
	                   {name:'CREATER_DATE',label:'经办日期',align:'center',frozen : true},
	                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
	                   {name:'DEATH_NO',label:'个人编号',align:'center',frozen : true},
	                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
	                   {name:'personSex',label:'性别',align:'center'},
	                   {name:'DEATH_DATE',label:'死亡日期',align:'center'},
	                   {name:'ARCHIVE_CODE',label:'档案编号',align:'center'},
	                   {name:'RELATIVES',label:'亲属',align:'center'},
	                   {name:'RELATIVES_PHONE_ONE',label:'亲属联系电话1',align:'center'},
	                   {name:'RELATIVES_PHONE_TWO',label:'亲属联系电话2',align:'center'},
	                   {name:'DEATH_NOTE',label:'备注',align:'center'},
	                   {name:'txtzName',label:'离退休或退职',align:'center'},
	                   {name:'gsbsName',label:'工伤或病死',align:'center'},
	                   {name:'hztzName',label:'火葬或土葬',align:'center'},
	                   {name:'RETIRED_MONTH_MONEY',label:'已统筹月离退休费',align:'center'},
	                   {name:'MONTH_AGE_MONEY',label:'本企业月平均工资',align:'center'},
	                   {name:'MONTH_FJ_MONEY',label:'月抚恤救济金额',align:'center'},
	                   {name:'MONTH_FL_MONEY',label:'月付粮价补金额',align:'center'},
	                   {name:'MONTH_SUM_MONEY',label:'以上两项月费用合计',align:'center'},
	                   {name:'ONE_MONEY',label:'一次性抚恤救济金额',align:'center'},
	                   {name:'SF_MONEY',label:'丧葬补助金额',align:'center'},
	                   {name:'ONE_SUM_MONEY',label:'以上两项一次性费用合计',align:'center'},
	                   {name:'CREATER_NAME',label:'经办人',align:'center'},
	                   {name:'CREATER_ORG_NAME',label:'经办机构',align:'center'}
	             
	 	        	];
			
			var personColumns= [
			          {name:'ID',label:'主键',key:true,hidden:true},          
	                  {name:'DEATH_NAME',label:'姓名',align:'center'},
	                  {name:'DEATH_BIRTH_DATE',label:'出生日期',align:'center'},
	                  {name:'DEATH_RELATION',label:'与死者关系',align:'center'},
	                  {name:'DEATH_RESAON',label:'供养理由',align:'center'},
	                  {name:'isFlag',label:'原吃统销粮',align:'center'},
	                  {name:'ADDRESS',label:'户口所在省市（县）乡（镇）村',align:'center'},
	                  {name:'DEATH_END_DATE',label:'抚恤救济终止年月',align:'center'}
	              
	 	        	];
		
		
		$("#deathList").jqGrid({
			//  url : CTX+"/business/personagency/death/deathDeclarevListJson.xf?personId="+$("#personIds").val(),
	          mtype: "GET",
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: deathcolumns,
			  viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager11",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          height:'100%',
	          shrinkToFit: false,
	          multiselect:true,
	          autowidth: true,
	          
	      });
		
		  $("#deathPersonList").jqGrid({
			//  url : CTX+"/business/personagency/death/person/deathPersonvListJson.xf?personId="+$("#personIds").val(),
		      mtype: "GET",
			  styleUI : 'Bootstrap',
		      datatype: "local",
		      colModel: personColumns,
			  viewrecords: true,
		      rowNum: 10,
		      rowList:[10,20,30],
		      pager: "#jqGridPager111",
		      pagerpos:'left',
		      regional : 'cn',
		      recordpos:'right',
		      height:'100%',
		      shrinkToFit: false,
		      multiselect:true,
		      rownumbers: true,
		      autowidth: true
		  });
				  
		
	}

	//退休人员查询
	function retiredInitl(){
		var retiredcolumns= [
					  {name:'AAC001',label:'人员id',hidden:true,frozen : true},
					  {name:'AAC003',label:'姓名',align:'center',frozen : true},
					  {name:'AAC002',label:'身份证号',align:'center',frozen : true},
	            	  {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	            	  {name:'AAC006',label:'出生日期',align:'center'},
	            	  {name:'AAC004',label:'性别',align:'center'},
	            	 {name:'AAE005',label:'手机号',align:'center'},
	            	 {name:'createWorkDate',label:'参加工作时间'},
	                 {name:'xh',label:'序号',align:'center'},
	                 {name:'retiredPeopleBm',label:'退休个人编码'},
	            	 {name:'retiredPeopleNo',label:'个人编号',align:'center'},
	                 {name:'nationName',label:'民族',align:'center'},
	                 {name:'retiredStatus',label:'是否正式退休',align:'center'},
	                 {name:'retiredDeclareStatus',label:'申报状态',align:'center'},
	                 {name:'isRetiredCard',label:'是否领退取证',align:'center'},
	                 {name:'retiredArea',label:'退休人员所属区域',align:'center'},
	                 {name:'expPersonPhone',label:'联系电话',align:'center'},
	                 {name:'ylName',label:'符合离退休规定条款',align:'center'},
	                 {name:'payDate',label:'缴费年月',align:'center'},
	                 {name:'retiredDate',label:'应退休时间',align:'center'},
	                 {name:'declareNote',label:'申报备注',align:'center'},
	                 {name:'createrName',label:'经办人',align:'center'},
	                 {name:'createrDate',label:'经办日期',align:'center'},
	                 {name:'createrOrgName',label:'经办机构',align:'center'}
	     	        	];
		
		$("#retiredList").jqGrid({
			//url : CTX+"/business/personagency/admin/getByvPersonId.xf?AAC001="+$("#personIds").val(),
	        mtype: "GET",
	        styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: retiredcolumns,
			viewrecords: true,
	        rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager10",
	        pagerpos:'left',
	        regional : 'cn',
	        recordpos:'right',
	        height:'100%',
	        shrinkToFit: false,
	        multiselect:true,
	        autowidth: true
		});
		
	}


	//党组织关系查询
	function partyInitl(){
		var partycolumns= [
		               {name:'id',label:'主键',hidden:true},
		               {name:'personId',label:'人员主键',align:'center',hidden:true,key:true},
				   	   {name:'personCard',label:'身份号',align:'center'},
				   	   {name:'personName',label:'姓名',align:'center',frozen : true},
				   	   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
				   	   {name:'partyStatus',label:'代管组织关系',align:'center'},
	                   {name:'partyIntoDate',label:'转入时间',align:'center'},
	                   {name:'partyDate',label:'入党时间',align:'center'},
	                   {name:'partyPositiveDate',label:'转正时间',align:'center'},
	                   {name:'sex',label:'性别',align:'center'},
	                   {name:'expUserName',label:'曾用名',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'placeName',label:'籍贯',align:'center'},
	                   {name:'personCsrq',label:'出生年月',align:'center'},
	                   {name:'whcdName',label:'文化程度',align:'center'},
	                   {name:'shoolName',label:'毕业学校',align:'center'},
	                   {name:'expAddress',label:'现居住地址',align:'center'},
	                   {name:'partyOutDate',label:'转出时间',align:'center'},
	                   {name:'partyOutReason',label:'转出原因',align:'center'},
	                   {name:'partyOutWhere',label:'转出去向',align:'center'},
	                   {name:'partyNote',label:'备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'outCreaterName',label:'转出经办人',align:'center'},
	                   {name:'outCreaterOrgName',label:'转出经办机构',align:'center'},
	                   {name:'outCreaterDate',label:'转出日期',align:'center'}
	     ];
		
		var partyPaycolumns= [		
		               {name:'id',label:'主键',hidden:true,key:true},
	                   {name:'personId',label:'人员主键',align:'center',hidden:true},
	                   {name:'partyBeginDate',label:'交纳开始年月',align:'center'},
	                   {name:'partyEndDate',label:'交纳截止年月',align:'center'},
	                   {name:'partyPayMoney',label:'交纳金额',align:'center'},
	                   {name:'createrName',label:'经办人名称',align:'center'},
	                   {name:'createrOrgName',label:'经办机构名称',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	  	        	];
		
		$("#partyList").jqGrid({
			//  url:CTX+"/business/personagency/party/listJson.xf?partyPersonId="+$("#personIds").val(),
			  mtype: "GET",
			  styleUI : 'Bootstrap',
		      datatype: "local",
		      colModel: partycolumns,
			  viewrecords: true,
		      rowNum: 10,
		      rowList:[10,20,30],
		      pager: "#jqGridPager9",
		      pagerpos:'left',
		      regional : 'cn',
		      recordpos:'right',
		      height:'100%',
		      shrinkToFit: false,
		      multiselect:false,
		      rownumbers: true,
		      autowidth: true
	    });
		
		$("#partyPayList").jqGrid({
		//	url:CTX+'/business/personagency/party/pay/getAllListJson.xf?personId='+$("#personIds").val(),
	        mtype: "GET",
		    styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: partyPaycolumns,
		    viewrecords: true,
	        rowNum: 10,
	        rowList:[10,20,30],
	        pager: "#jqGridPager91",
	        pagerpos:'left',
	        regional : 'cn',
	        recordpos:'right',
	        shrinkToFit: false,
	        multiselect:true,
	        height:'100%',
	        autowidth: true
	    });
		
	}
	
	//查询
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		dataJson = json;
		$("#cdxxList").jqGrid("clearGridData");
		$("#cdxxList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/archive/archives/listJson.xf?dataSources=1',postData:json}).trigger("reloadGrid");
	}
	
	
	//党员
	function party1(){
		partyInitl();
		$("#partyList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/party/partylistJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
        $("#partyPayList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/party/pay/getAllListJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//档案借阅
	function archiveJy1(){
		archiveJyInitl();
		$("#archiveJyList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/archive/archiveCheckout/listJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//死亡
	function death1(){
		deathInitl();
		$("#deathList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/death/deathDeclarevListJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
		$("#deathPersonList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/death/person/deathPersonvListJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//退休相关信息
	function retired1(){
		retiredInitl();
		$("#retiredList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/agent/getByvPersonId.xf?AAC001='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//委托变更
	function commission1(){
		commissionInitl();
		$("#commissionList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/entrust/commissionChange/searchListJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//费用信息
	function payment1(){
		paymentInitl();
		$("#paymentList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/payment/paymentRecord/listJson.xf?fkPersonId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//工资调整
	function wage1(){
		wageInitl();
		$("#wageList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/storage/wageStandard/listJson.xf?ccpr08=0&personId='+$("#personIds").val()}).trigger("reloadGrid");
		
	}
	
	//职务评定
	function zcpd1(){
		zcpdInitl();
		$("#zcpdList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/affair/titleDeclaration/listJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//考试报名
	function ksbm1(){
		ksbmInitl();
		$("#ksbmList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/affair/examinationRegister/listJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//户口材料
	function hkcl1(){
		hkclInitl();
		$("#hkclList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/residence/residence/listJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
	}
	
	//户口信息
	function hkxx1(){
		hkxxInitl();
		$("#residenceMoveOutList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/residence/residenceMoveOut/listJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
		$("#residenceReturnList").jqGrid("setGridParam",{datatype:'json',url:CTX+'/business/personagency/residence/residenceReturn/listJson.xf?personId='+$("#personIds").val()}).trigger("reloadGrid");
		
	}
	
	
	
	//导出
	function initDataExpCdxx(){
		$('#expCdxx').dataexp({
			gridId:"cdxxList",
			serviceId:'archivesExpServiceImpl',
			fileName:'档案信息查询',
			sheetName:'档案信息查询',
			menuItem:[
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#cdxxList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      			var archiveCodes="";
						      			$.each(ids,function(i,e){
						      				var rowData=$("#cdxxList").jqGrid("getRowData",e);
						      				var archiveCode = rowData.ARCHIVECODE;
						      				if(i==0){
						      					archiveCodes+= "'"+archiveCode+"'";
						      				}else{
						      					archiveCodes+=","+"'"+archiveCode+"'";	
						      				}
						      			});
						      			return {menuNumber:'1',archiveCodes:archiveCodes};
					      	    }else{
						      		  bootbox.alert('请选择记录');
						      		  return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}
	
	

	//导出退休
	function initDataExpRetired(){
		$('#expRetired').dataexp({
			gridId:"retiredList",
			serviceId:'agrentExpServiceImpl',
			fileName:'退休人员信息',
			sheetName:'退休人员信息',
			menuItem:[
		        {title:"导出当前页数据",paramCallBack:function(){
		        	var ids = $("#retiredList").jqGrid("getDataIDs");	        		
		        	if(ids&&ids.length>0){
	        			var id="";
	        			$.each(ids,function(i,e){
	        				if(i==0){
	        					id+="'"+e+"'";
	        				}else{
	        					id+=","+"'"+e+"'";
	        				}
	        				
	        			});
	        			return {status:'z1',id:id};
	        		}else{
	        			bootbox.alert("请选择记录！");
	        			return false;
	        		}			        		
		        	}
			     }]
		});
	}
	
	//党组织关系转入转出信息
	function initDataExpParty(){
		$('#expParty').dataexp({
			gridId:"partyList",
			serviceId:'agrentExpServiceImpl',
			fileName:'党组织关系信息',
			sheetName:'党组织关系信息',
			menuItem:[
		        {title:"导出当前页数据",paramCallBack:function(){
		        	var ids = $("#partyList").jqGrid("getDataIDs");	        		
		        	if(ids&&ids.length>0){
	        			var id="";
	        			$.each(ids,function(i,e){
	        				if(i==0){
	        					id+="'"+e+"'";
	        				}else{
	        					id+=","+"'"+e+"'";
	        				}
	        				
	        			});
	        			return {status:'z2',id:id};
	        		}else{
	        			bootbox.alert("请选择记录！");
	        			return false;
	        		}			        		
		        	}
			     }]
		});
	}
	
	//党费交纳信息
	function initDataExpPartyPay(){
		$('#expPartyPay').dataexp({
			gridId:"partyPayList",
			serviceId:'agrentExpServiceImpl',
			fileName:'党费缴纳信息',
			sheetName:'党费缴纳信息',
			menuItem:[
		        {title:"导出当前页数据",paramCallBack:function(){
		        	var ids = $("#partyPayList").jqGrid("getDataIDs");	        		
		        	if(ids&&ids.length>0){
	        			var id="";
	        			$.each(ids,function(i,e){
	        				if(i==0){
	    						id+=e;
	    					}else{
	    						id+=","+e;
	    					}
	        				
	        			});
	        			return {status:'z21',id:id};
	        		}else{
	        			bootbox.alert("请选择记录！");
	        			return false;
	        		}			        		
		        	}
			     }]
		});
	}
	
	//死亡待遇申报
	function initDataExpDeath(){
		$('#expDeath').dataexp({
			gridId:"deathList",
			serviceId:'agrentExpServiceImpl',
			fileName:'死亡待遇申报信息',
			sheetName:'死亡待遇申报信息',
			menuItem:[
		        {title:"导出当前页数据",paramCallBack:function(){
		        	var ids = $("#deathList").jqGrid("getDataIDs");	        		
		        	if(ids&&ids.length>0){
	        			var id="";
	        			$.each(ids,function(i,e){
	        				if(i==0){
	    						id+=e;
	    					}else{
	    						id+=","+e;
	    					}
	        				
	        			});
	        			return {status:'z3',id:id};
	        		}else{
	        			bootbox.alert("请选择记录！");
	        			return false;
	        		}			        		
		        	}
			     }]
		});
	}
	
	//死亡供养直系亲属
	function initDataExpDeathPerson(){
		$('#expDeathPerson').dataexp({
			gridId:"deathPersonList",
			serviceId:'agrentExpServiceImpl',
			fileName:'供养直系亲属信息',
			sheetName:'供养直系亲属信息',
			menuItem:[
		        {title:"导出当前页数据",paramCallBack:function(){
		        	var ids = $("#deathPersonList").jqGrid("getDataIDs");	        		
		        	if(ids&&ids.length>0){
	        			var id="";
	        			$.each(ids,function(i,e){
	        				if(i==0){
	    						id+=e;
	    					}else{
	    						id+=","+e;
	    					}
	        				
	        			});
	        			return {status:'z31',id:id};
	        		}else{
	        			bootbox.alert("请选择记录！");
	        			return false;
	        		}			        		
		        	}
			     }]
		});
	}
	
	