$(function (){
	
	
	retiredInitl();
	deathInitl();
	partyInitl();
	$("#retiredEdu").removeClass("in").removeClass("active");
	$("#deathEdu").removeClass("in").removeClass("active");
	$("#partyEdu").removeClass("in").removeClass("active");
	  
})


//死亡待遇信息
function deathInitl(){
	var columns= [		
                   {name:'ID',hidden:true,align:'center',frozen : true},
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
                  {name:'DEATH_NAME',label:'姓名',align:'center'},
                  {name:'DEATH_BIRTH_DATE',label:'出生日期',align:'center'},
                  {name:'DEATH_RELATION',label:'与死者关系',align:'center'},
                  {name:'DEATH_RESAON',label:'供养理由',align:'center'},
                  {name:'isFlag',label:'原吃统销粮',align:'center'},
                  {name:'ADDRESS',label:'户口所在省市（县）乡（镇）村',align:'center'},
                  {name:'DEATH_END_DATE',label:'抚恤救济终止年月',align:'center'}
              
 	        	];
	
	
	$("#deathList").jqGrid({
		  url : CTX+"/business/personagency/death/deathDeclarevListJson.xf?personId="+$("#personIds").val(),
          mtype: "GET",
		  styleUI : 'Bootstrap',
          datatype: "json",
          colModel: columns,
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
		  url : CTX+"/business/personagency/death/person/deathPersonvListJson.xf?personId="+$("#personIds").val(),
	      mtype: "GET",
		  styleUI : 'Bootstrap',
	      datatype: "json",
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
            	  {name:'AAC004',label:'性别',align:'center',
	                  formatter:function(value,row,index){
	                	   if(value=="1"){
	                		   return "男";
	                	   }
	                	   if(value=="2"){
	                		   return "女";
	                	   }
              	  }},
            	 {name:'AAE005',label:'手机号',align:'center'},
            	 {name:'createWorkDate',label:'参加工作时间'},
                 {name:'xh',label:'序号',align:'center'},
                 {name:'retiredPeopleBm',label:'退休个人编码'},
            	 {name:'retiredPeopleNo',label:'个人编号',align:'center'},
                 {name:'nationName',label:'民族',align:'center'},
                 {name:'retiredStatus',label:'是否正式退休',align:'center',
              	   formatter:function(value,row,index){
	                	   if(value=="0"){
	                		   return "否";
	                	   }
	                	   if(value=="1"){
	                		   return "是";
	                	   }
              	  }},
                 {name:'retiredDeclareStatus',label:'申报状态',align:'center',
                 formatter:function(value,row,index){
               	  if(value=="1"){
              			   return "待申报";
              	  		}
	               	   if(value=="2"){
	               		   return "申报中";
	               	   }
	               	   if(value=="3"){
	               	 	   return "申报完毕";
	               	   }
                 }},
                 {name:'isRetiredCard',label:'是否领退取证',align:'center',
               	 formatter:function(value,row,index){
               	  if(value=="0"){
              		   return "否";
              	  		}
	               	   if(value=="1"){
	               		   return "是";
	               	   }
                     }
                 },
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
		url : CTX+"/business/personagency/agent/getByvPersonId.xf?AAC001="+$("#personIds").val(),
        mtype: "GET",
        styleUI : 'Bootstrap',
        datatype: "json",
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
	                   {name:'personName',label:'姓名',align:'center',frozen : true},
	                   {name:'partyPersonId',label:'人员id',align:'center',hidden:true},
	                   {name:'partyIntoDate',label:'转入日期',align:'center'},
	                   {name:'partyOutDate',label:'转出时间',align:'center'},
	                   {name:'partyOutReason',label:'转出原因',align:'center'},
	                   {name:'partyOutWhere',label:'转出去向',align:'center'},
	                   {name:'personCard',label:'公民身份号码',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'placeName',label:'籍贯',align:'center'},
	                   {name:'personCsrq',label:'出生日期',align:'center'},
	                   {name:'whcdName',label:'文化程度',align:'center'},
	                   {name:'partyDate',label:'入党时间',align:'center'},
	                   {name:'partyPositiveDate',label:'转正时间',align:'center'},
	                   {name:'partyStatus',label:'代管组织关系',align:'center'},
	                   {name:'partyOldName',label:'曾用名',align:'center'},
	                   {name:'zhuanyeName',label:'专业',align:'center'},
	                   {name:'partySchoolName',label:'毕业学校',align:'center'},
	                   {name:'partySchoolDate',label:'毕业日期',align:'center'},
	                   {name:'partyPhone',label:'手机',align:'center'},
	                   {name:'partyQq',label:'QQ号',align:'center'},
	                   {name:'partyOtherAdd',label:'其他联系方式',align:'center'},
	                   {name:'expCardAdd',label:'家庭通讯地址',align:'center'},
	                   {name:'partyNote',label:'备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
     ];
	
	var partyPaycolumns= [		
                   {name:'personId',align:'center',hidden:true},
                   {name:'partyBeginDate',label:'交纳开始年月',align:'center'},
                   {name:'partyEndDate',label:'交纳截止年月',align:'center'},
                   {name:'partyPayMoney',label:'交纳金额',align:'center'},
                   {name:'createrName',label:'经办人名称',align:'center'},
                   {name:'createrOrgName',label:'经办机构名称',align:'center'},
                   {name:'createrDate',label:'经办日期',align:'center'}
  	        	];
	
	$("#partyList").jqGrid({
		  url:CTX+"/business/personagency/party/listJson.xf?partyPersonId="+$("#personIds").val(),
		  mtype: "GET",
		  styleUI : 'Bootstrap',
	      datatype: "json",
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
	      multiselect:true,
	      rownumbers: true,
	      autowidth: true
 
    });
	
	
	$("#partyPayList").jqGrid({
		url:CTX+'/business/personagency/party/pay/getAllListJson.xf?personId='+$("#personIds").val(),
        mtype: "GET",
	    styleUI : 'Bootstrap',
        datatype: "json",
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

