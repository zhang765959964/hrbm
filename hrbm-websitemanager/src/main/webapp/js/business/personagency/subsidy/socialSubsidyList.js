var dataJson = {};
$(function() {
	initDate();
	initl();
	initDataExp();
})

function initl(){
	/**
	 * 初始化表格显示
	 */
	var columns = [ {
		name : 'archiveCode',
		label : '档案编号',
		align : 'center',
		frozen : true
	}, {
		name : 'subsidyNum',
		label : '社保补贴编号',
		align : 'center',
		frozen : true
	}, {
		name : 'aac002',
		label : '身份证号',
		align : 'center',
		frozen : true
	}, {
		name : 'aac003',
		label : '姓名',
		align : 'center',
		frozen : true
	}, {
		name : 'oldSubsidyNum',
		label : '老编号',
		align : 'center'
	}, {
		name : 'pensionMonths',
		label : '养老保险补贴月数',
		align : 'center'
	}, {
		name : 'pensionStartDate',
		label : '养老补贴开始年份',
		align : 'center'
	}, {
		name : 'pensionEndDate',
		label : '养老补贴结束年份',
		align : 'center'
	}, {
		name : 'medicalMonths',
		label : '医疗保险补贴月数',
		align : 'center'
	}, {
		name : 'medicalStartDate',
		label : '医疗补贴开始年份',
		align : 'center'
	}, {
		name : 'medicalEndDate',
		label : '医疗补贴结束年份',
		align : 'center'
	}, {
		name : 'contractSignDate',
		label : '签订劳动合同开始时间',
		align : 'center'
	}, {
		name : 'contractEndDate',
		label : '签订劳动合同终止时间',
		align : 'center'
	}, {
		name : 'contractDestoryDate',
		label : '劳动合同解除日期',
		align : 'center'
	}, {
		name : 'isPassed',
		label : '是否通过',
		align : 'center'
//		formatter : isPass
	}, {
		name : 'checkState',
		label : '审核标记',
		align : 'center'
//		formatter : checkState
	}, {
		name : 'isHasBusLic',
		label : '是否持有营业执照',
		align : 'center'
//		formatter : isHasBusLic
	}, {
		name : 'bankName',
		label : '开户银行',
		align : 'center'
	}, {
		name : 'bankCardNo',
		label : '银行帐号',
		align : 'center'
	}, {
		name : 'busLicNum',
		label : '营业执照编号',
		align : 'center'
	}, {
		name : 'outerSubsidyMonths',
		label : '已在外单位享受补贴月数',
		align : 'center'
	}, {
		name : 'createrNum',
		label : '登记次数',
		align : 'center'
	}, {
		name : 'expOldCompany',
		label : '原工作单位',
		align : 'center'
	}, {
		name : 'description',
		label : '备注',
		align : 'center'
	}, {
		name : 'createrName',
		label : '经办人',
		align : 'center'
	}, {
		name : 'createrDate',
		label : '经办日期',
		align : 'center'
	}, {
		name : 'batchName',
		label : '批次名称',
		align : 'center'
	}, {
		name : 'createrOrgName',
		label : '经办机构',
		align : 'center'
	}, {
		name : 'pensionStandard',
		label : '养老补贴标准',
		align : 'center'
	}, {
		name : 'pensionAmount',
		label : '养老补贴金额',
		align : 'center'
	}, {
		name : 'medicalStandard',
		label : '医疗补贴标准',
		align : 'center'
	}, {
		name : 'medicalAmount',
		label : '医疗补贴金额',
		align : 'center'
	}, {
		name : 'pensionTotalMonths',
		label : '养老保险补贴总月数',
		align : 'center'
	}, {
		name : 'medicalTotalMonths',
		label : '医疗保险补贴总月数',
		align : 'center'
	} ];
	$("#socialSubsidyList").jqGrid({
		// url:'${ctx}/business/personagency/subsidy/socialSubsidy/listJson.xf',
		mtype : "GET",
		styleUI : 'Bootstrap',
		datatype : "local",
		colModel : columns,
		viewrecords : true,
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : "#jqGridPager",
		pagerpos : 'left',
		regional : 'cn',
		recordpos : 'right',
		shrinkToFit : false,
		multiselect : true,
		autowidth : true,
		altRow : true,
		height : "100%"
	});
	$("#socialSubsidyList").jqGrid('setFrozenColumns');
	
}



function initDate(){
	 $("#begincreaterDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
          "locale": {
             "format": "YYYY-MM-DD"
         }
     });
	 
	 
	 $("#endcreaterDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
         "locale": {
             "format": "YYYY-MM-DD"
         }
     });
	
}



function doSearch() {
	var json = $("#searchForm").serializeJson();
	dataJson = json;
	$("#socialSubsidyList").jqGrid("clearGridData");
	$("#socialSubsidyList").jqGrid("setGridParam", {datatype : "json",url : CTX+'/business/personagency/subsidy/socialSubsidy/listJson.xf',postData : json}).trigger("reloadGrid");
}

//导出退休人员查询数据
function initDataExp(){
	$('#exp').dataexp({
		gridId:"socialSubsidyList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'补贴花名册信息',
		sheetName:'补贴花名册信息',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson.status = 'h2';
			var id = $("#socialSubsidyList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			return dataJson;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#socialSubsidyList").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			return {status:'h2',ids:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}




