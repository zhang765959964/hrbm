$(function(){
	initDataExpReporting();
	initDataExpTransfer();
})
function initTable() {
		var columns= [
	                   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	                   {name:'expPersonNumber',label:'个人编号',align:'center',frozen : true},
	                   {name:'aac003',label:'姓名',align:'center',frozen : true},
	                   {name:'isEffectiveName',label:'有效标识',align:'center'},
	                   {name:'aac002',label:'公民身份证号码',align:'center'},
	                   {name:'genderName',label:'性别',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'aac006',label:'出生日期',align:'center'},
	                   {name:'expStartJobDate',label:'参加工作时间',align:'center'},
	                   {name:'employmentFormName',label:'用工形式',align:'center'},
	                   {name:'expPersonPhone',label:'固定电话',align:'center'},
	                   {name:'aae005',label:'手机号码',align:'center'},
	                   {name:'expPensionDate',label:'参加养老保险时间',align:'center'},
	                   {name:'changeContentName',label:'变更内容',align:'center'},
	                   {name:'paymentStartDate',label:'缴费开始年月',align:'center'},
	                   {name:'paymentEndDate',label:'缴费终止年月',align:'center'},
	                   {name:'reasonsForStoppingName',label:'停保原因',align:'center'},
	                   {name:'addIsInsuranceName',label:'是否在外地参加过保险',align:'center'},
	                   {name:'checkoutSocialOrgName',label:'转出社保机构名称',align:'center'},
	                   {name:'fieldStartDate',label:'外地缴费开始时间',align:'center'},
	                   {name:'fieldEndDate',label:'外地缴费终止时间',align:'center'},
	                   {name:'pensionBaseName',label:'养老保险月缴费基数',align:'center'},
	                   {name:'stopSocialDate',label:'停保时间',align:'center'},
	                   {name:'expMedicalDate',label:'参加医疗保险时间',align:'center'}, 
	                   {name:'medicalBaseName',label:'医疗保险月缴费基数',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'aab301',label:'家庭住址',align:'center'},
	                   {name:'aae007',label:'邮政编码',align:'center'},
	                   {name:'createrName',label:'经办人名称',align:'center'},
	                   {name:'createrOrgName',label:'经办机构名称',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                  
     	        	];
		
		$("#changeReportingList").jqGrid({
		   //url:CTX+'/business/personagency/social/changeReporting/listJson.xf',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "local",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager1",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           multiselect:false,
           autowidth: true,
           altRows:true,
           height:'100%'
       });
		
		$("#changeReportingList").jqGrid('setFrozenColumns');
	}
	
	function initTransferTable() {
		var columns2 = [
		                
						{name:'archiveCode',label:'档案编号',align:'center',frozen : true},
						{name:'expPersonNumber',label:'个人编号',align:'center',frozen : true},
						{name:'aac003',label:'姓名',align:'center',frozen : true},
						{name:'isEffectiveName',label:'有效标识',align:'center'},
						{name:'aac002',label:'公民身份证号码',align:'center'},
						{name:'genderName',label:'性别',align:'center'},
						{name:'nationName',label:'民族',align:'center'},
						{name:'aac006',label:'出生日期',align:'center'},
						{name:'expStartJobDate',label:'参加工作时间',align:'center'},
						{name:'employmentFormName',label:'用工形式',align:'center'},
						{name:'expPersonPhone',label:'固定电话',align:'center'},
						{name:'aae005',label:'手机号码',align:'center'},
						{name:'expPensionDate',label:'参加养老保险时间',align:'center'},
						{name:'aab301',label:'家庭住址',align:'center'},
		                {name:'aae007',label:'邮政编码',align:'center'},
	                    {name:'changeContenttwoName',label:'变更内容',align:'center'},
	                    {name:'yuanStartDate',label:'原参保地缴费起始时间',align:'center'},
	                    {name:'yuanEndDate',label:'原参保地缴费截止时间',align:'center'},
	                    {name:'yuanCorpNumber',label:'原单位编号',align:'center'},
	                    {name:'yuanCorpName',label:'原单位名称',align:'center'},
	                    {name:'yuanSocialName',label:'原社保机构名称',align:'center'},
	                    {name:'xianCorpNumber',label:'现单位编号',align:'center'},
	                    {name:'xianCorpName',label:'现单位名称',align:'center'},
	                    {name:'xianSocialName',label:'现社保机构名称',align:'center'},
	                    {name:'pensionBase',label:'养老保险月缴费基数',align:'center'},
	                    {name:'expMedicalDate',label:'参加医疗保险时间',align:'center'}, 
	                    {name:'medicalBaseName',label:'医疗保险月缴费基数',align:'center'},
	                    {name:'description',label:'备注',align:'center'},
	                    {name:'createrName',label:'经办人名称',align:'center'},
	                    {name:'createrOrgName',label:'经办机构名称',align:'center'},
	                    {name:'createrDate',label:'经办日期',align:'center'}
     	        	];
			$("#socialsecTransferList").jqGrid({
			  //url:CTX+'/business/personagency/social/socialsecTransfer/listJson.xf',
	          mtype: "GET",
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: columns2,
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
	
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		$("#changeReportingList").jqGrid("clearGridData");	
		$("#changeReportingList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/social/changeReporting/listJson.xf',postData:json}).trigger("reloadGrid");
		$("#socialsecTransferList").jqGrid("clearGridData");	
		$("#socialsecTransferList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/social/socialsecTransfer/listJson.xf',postData:json}).trigger("reloadGrid");
	}
	//变更申报导出
	function initDataExpReporting(){
		$('#expReporting').dataexp({
			gridId:"changeReportingList",
			serviceId:'archivesExpServiceImpl',
			fileName:'变更申报信息',
			sheetName:'变更申报信息',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#changeReportingList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								return {menuNumber:'reporting',ids:ids};
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#changeReportingList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'reporting',ids:ids};
					      	    }else{
						      		bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}
	//统筹范围内转移导出
	function initDataExpTransfer(){
		$('#expTransfer').dataexp({
			gridId:"socialsecTransferList",
			serviceId:'archivesExpServiceImpl',
			fileName:'统筹范围内转移信息',
			sheetName:'统筹范围内转移信息',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#socialsecTransferList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								return {menuNumber:'transfer',ids:ids};
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#socialsecTransferList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'transfer',ids:ids};
					      	    }else{
						      		bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}