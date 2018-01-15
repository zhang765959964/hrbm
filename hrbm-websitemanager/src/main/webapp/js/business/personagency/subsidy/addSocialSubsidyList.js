$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [{name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                  {name:'subsidyNum',label:'编号',align:'center',frozen : true},
                  {name:'aac002',label:'身份证号',align:'center',frozen : true},
                  {name:'aac003',label:'姓名',align:'center'},
                  {name:'oldSubsidyNum',label:'老编号',align:'center'},
                  {name:'pensionMonths',label:'养老保险补贴月数',align:'center'},
                  {name:'pensionStartDate',label:'养老补贴开始年份',align:'center'},
                  {name:'pensionEndDate',label:'养老补贴结束年份',align:'center'},
                  {name:'medicalMonths',label:'医疗保险补贴月数',align:'center'},
                  {name:'medicalStartDate',label:'医疗补贴开始年份',align:'center'},
                  {name:'medicalEndDate',label:'医疗补贴结束年份',align:'center'},
                  {name:'contractSignDate',label:'签订劳动合同开始时间',align:'center'},
                  {name:'contractEndDate',label:'签订劳动合同终止时间',align:'center'},
                  {name:'contractDestoryDate',label:'劳动合同解除日期',align:'center'},
                  {name:'isPassed',label:'是否通过',align:'center'},
                  {name:'checkState',label:'审核标记',align:'center'},
                  {name:'bankName',label:'开户银行',align:'center'},
                  {name:'bankCardNo',label:'银行帐号',align:'center'},
                  {name:'isHasBusLic',label:'是否持有营业执照',align:'center'},
                  {name:'busLicNum',label:'营业执照编号',align:'center'},
                  {name:'outerSubsidyMonths',label:'已在外单位享受补贴月数',align:'center'},
                  {name:'createrNum',label:'登记次数',align:'center'},
                  {name:'expOldCompany',label:'原工作单位',align:'center'},
                  {name:'description',label:'备注',align:'center'},
                 // {name:'createrId',label:'经办人',align:'center'},
                  {name:'createrName',label:'经办人',align:'center'},
                  {name:'createrDate',label:'经办日期',align:'center'},
                  //{name:'batchId',label:'批次Id',align:'center'},
                  {name:'batchName',label:'批次名称',align:'center'},
                  {name:'createrOrgName',label:'经办机构',align:'center'},
                  //{name:'createrOrgId',label:'经办机构Id',align:'center'},
                  {name:'pensionStandard',label:'养老补贴标准',align:'center'},
                  {name:'pensionAmount',label:'养老补贴金额',align:'center'},
                  {name:'medicalStandard',label:'医疗补贴标准',align:'center'},
                  {name:'medicalAmount',label:'医疗补贴金额',align:'center'},
                 // {name:'personId',label:'人员Id',align:'center'},
                  {name:'pensionTotalMonths',label:'养老保险补贴总月数',align:'center'},
                  {name:'medicalTotalMonths',label:'医疗保险补贴总月数',align:'center'},
                  {name:'expRegisgration',label:'再就业优惠证编号',align:'center'},
                  {name:'acc0m1',label:'就业失业登记证号码',align:'center'},
                  
 	        	];
$("#socialSubsidyList").jqGrid({
	 // url:CTX+'/business/personagency/subsidy/socialSubsidy/listJson.xf?notBatchId='+$("#batchId").val(),
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
//      multiselect:true,
      height:"100%",
      autowidth: true
  });
$("#socialSubsidyList").jqGrid('setFrozenColumns');
})


	function doSearch(){
		
		var json=$("#searchForm").serializeJson();
		$("#socialSubsidyList").jqGrid("clearGridData");
		$("#socialSubsidyList").jqGrid("setGridParam",{datatype:'json',postData:json,url:CTX+'/business/personagency/subsidy/socialSubsidy/listJson.xf?notBatchId='+$("#batchId").val()}).trigger("reloadGrid");
	}

	function formatter(cellvalue, options, rowObject){
		if(cellvalue==0){
			return "未审核";
		}else{
			return "已审核";
		}
	}
	
	function isPassed(cellvalue, options, rowObject){
		if(cellvalue==0){
			return "否";
		}else{
			return "是";
		}
	}
	function addBatchPerson(){
		var id=$("#socialSubsidyList").jqGrid("getGridParam","selrow");
		if(id){
			bootbox.confirm({message:'您确认想要添加人员吗？',callback:function(r){    
			    if (r){  
			    	var batchId=$("#batchId").val();
			    	$.ajax({ url: CTX+'/business/personagency/subsidy/socialBatch/addBatchPerson.xf',
			    		data:{subsidyId:id,batchId:batchId},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.result===1){
			    				bootbox.alert({message:data.message,callback:function(){			    					
			    					var parentIframe=xfui.getParentIframe();
	            			    	if(parentIframe){
	            			    		parentIframe.refresh();
	            			    	}
	            			    	xfui.closeDialog();
			    				}}); 	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			             }
			    	});
			    }    
			}}); 
		  }else{
			 bootbox.alert('请选择记录');
		 }			
	} 