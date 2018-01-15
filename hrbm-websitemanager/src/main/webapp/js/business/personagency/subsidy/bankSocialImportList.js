var columns= [
              {name:'id',label:'流水号',hidden : true},
              {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
              {name:'subsidyNum',label:'编号',align:'center',frozen : true},
              {name:'aac002',label:'身份证号',align:'center',frozen : true},
              {name:'aac003',label:'姓名',align:'center',frozen : true},             
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
              {name:'isPassed',label:'是否通过',align:'center' },
              {name:'checkState',label:'审核标记',align:'center'},
              {name:'isHasBusLic',label:'是否持有营业执照',align:'center'},
              {name:'bankName',label:'开户银行',align:'center'},
              {name:'bankCardNo',label:'银行帐号',align:'center'},
              {name:'busLicNum',label:'营业执照编号',align:'center'},
              {name:'outerSubsidyMonths',label:'已在外单位享受补贴月数',align:'center'},
              {name:'createrNum',label:'登记次数',align:'center'},
              {name:'expOldCompany',label:'原工作单位',align:'center'},
              {name:'description',label:'备注',align:'center'},
//              {name:'createrId',label:'经办人',align:'center'},
              {name:'createrName',label:'经办人',align:'center'},
              {name:'createrDate',label:'经办日期',align:'center'},
//              {name:'batchId',label:'批次Id',align:'center'},
              {name:'batchName',label:'批次名称',align:'center'},
              {name:'createrOrgName',label:'经办机构',align:'center'},
//              {name:'createrOrgId',label:'经办机构Id',align:'center'},
              {name:'pensionStandard',label:'养老补贴标准',align:'center'},
              {name:'pensionAmount',label:'养老补贴金额',align:'center'},
              {name:'medicalStandard',label:'医疗补贴标准',align:'center'},
              {name:'medicalAmount',label:'医疗补贴金额',align:'center'},
//              {name:'personId',label:'人员Id',align:'center'},
              {name:'pensionTotalMonths',label:'养老保险补贴总月数',align:'center'},
              {name:'medicalTotalMonths',label:'医疗保险补贴总月数',align:'center'}
	        	];
$(function(){
	/**
	 初始化表格显示
	*/

$("#socialSubsidyList").jqGrid({
	  url:CTX+'/business/personagency/subsidy/socialSubsidy/batchListJson.xf?batchId='+$("#batchId").val(),
      mtype: "GET",
	  styleUI : 'Bootstrap',
      datatype: "json",
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
      altRow:true,
      height:"100%"
  });
	$("#socialSubsidyList").jqGrid('setFrozenColumns');
	initDataExp();
	$('#imp').dataimp({
		gridId:"socialSubsidyList",
		serviceId:'socialDataImpServiceImpl',
		tempFileName:"档案模版.xls"
	})
})

	function doSearch(){
		var json=$("#searchForm").serializeJson();
		$("#socialSubsidyList").jqGrid("clearGridData");
		$("#socialSubsidyList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
	}





	function initDataExp(){
		$('#exp').dataexp({
			gridId:"socialSubsidyList",
			serviceId:'socialDataExpServiceImpl',
			fileName:'补贴银行卡',
			sheetName:'补贴银行卡',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
				         return {status:'h1',batchId:$("#batchId").val()}
			           }}
// 			          ,{title:"导出选中的数据",paramCallBack:function(){			        	   
// 			        	    var row = $('#dgPerson').datagrid('getChecked');
// 			        		var personIds="";			        		
// 			        		if(row.length>0){
// 			        			$.each(row,function(i,e){
// 				        			if(i==0){
// 				        				personIds+=e.id;
// 				        			}else{
// 				        				personIds+=","+e.id;
// 				        			}
// 				        		})
// 			        		}else{
// 			        			$.messager.alert("系统提示","请勾选要选中的记录！","info");
// 			        			return false;
// 			        		}			        		
// 			        	      return {personIds:personIds};
// 		  					}
// 				        },
// 				        {title:"导出当前页数据",paramCallBack:function(){
// 				        	var row = $('#dgPerson').datagrid('getRows');
// 				        	var personIds="";			        		
// 			        		if(row.length>0){
// 			        			$.each(row,function(i,e){
// 				        			if(i==0){
// 				        				personIds+=e.id;
// 				        			}else{
// 				        				personIds+=","+e.id;
// 				        			}
// 				        		})
// 			        		}else{
// 			        			$.messager.alert("系统提示","没有要导出的数据","info");
// 			        			return false;
// 			        		}			        		
// 			        	      return {personIds:personIds};
// 			  				 }
// 					     }
			          ]
			
		});
	}
