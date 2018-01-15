var dataJson = {};
var dataJson1 = {};
$(function(){
	xfui.initUi();
	initl();
	initCorpRecordTable();
	$(".highSearch").click(function(){
		$(".highCondition").toggle();
	});
	$("#perEdu").removeClass("in").removeClass("active");
	initDataExp();
	initDataExp1();
})




function initl(){
	/**
	 初始化表格显示
	*/
	var columns= [	   {name:'aac002',label:'身份证号',align:'center',frozen:true},
	              	   {name:'aac003',label:'姓名',align:'center',frozen:true},  
	                   {name:'fdDerateStatus',label:'减免标记',align:'center'},	                                 
	                   {name:'fdEndPaymentDate',label:'最后缴费年月',align:'center'},	 
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	  
	                   {name:'genderName',label:'性别',align:'center'},	  
	                   {name:'nationName',label:'名族',align:'center'},	  
	                   {name:'aac006',label:'出生日期',align:'center'},	 
	                   {name:'archiveTypeName',label:'存档类型',align:'center'},
	                   {name:'archiveCode',label:'档案编号',align:'center'},	                   
	                   {name:'contractCode',label:'合同编号',align:'center'},
	                   {name:'fdStartDate',label:'开始缴费日期',align:'center'},
	                   {name:'fdEndDate',label:'终止缴费日期',align:'center'},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},
	                   {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
	                   {name:'fdPaymentType',label:'缴费类型',align:'center'},
	                   {name:'fdPaymentStatus',label:'缴费状态',align:'center'},
	                   {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
	                   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
	                   {name:'fdConfirmsName',label:'财务经办人',align:'center'},
	                   {name:'fdConfirmsDate',label:'财务经办日期',align:'center'},
	                   {name:'fdConfirmsOrgName',label:'财务经办机构',align:'center'},
	                   {name:'expOldCompany',label:'原工作单位',align:'center'},	
	                   {name:'expPost',label:'职务',align:'center'},	
	                   {name:'expStartJobDate',label:'存档类型',align:'center'},	 
	                   {name:'educationName',label:'文化程度',align:'center'},	                   
	                   {name:'maritalStatusName',label:'婚姻状况',align:'center'},	
	                   {name:'politicalLandscape',label:'政治面貌',align:'center'},	
	                   {name:'',label:'是否军转干部',align:'center'},
	                   {name:'expIsDiscount',label:'是否享有再就业优惠证标准',align:'center'},                  
	                   {name:'expPersonPhone',label:'联系电话',align:'center'},
	                   {name:'aab301',label:'现住地址',align:'center'},
	                   {name:'faName',label:'配偶姓名',align:'center'},
	                   {name:'archiveBirthDate',label:'档案出生日期',align:'center'},
	                   {name:'planRetiredDate',label:'退休参考日期',align:'center'},
	                   {name:'receiveDate',label:'档案接收日期',align:'center'},                  
	                   {name:'archiveStatusName',label:'档案状态',align:'center'},
	                   {name:'archivePrintLabel',label:'打印标签次数',align:'center'},
	                   {name:'receiveDesc',label:'档案存放备注',align:'center'},               
	                   {name:'archiveReceiveName',label:'档案接收经办人',align:'center'},
	                   {name:'archiveReceiveOrgName',label:'档案接收经办机构',align:'center'},
	                   {name:'archiveReceiveDate',label:'档案接收经办日期',align:'center'},                 
	                   {name:'archiveReceiveStatusName',label:'接收状态',align:'center'},
	                   {name:'receiveDesc',label:'档案存放位置备注',align:'center'},                
	                   {name:'cabinetsLibrary',label:'区',align:'center'},
	                   {name:'cabinetsCode',label:'柜',align:'center'},
	                   {name:'cabinetsLayer',label:'排',align:'center'},
	                   {name:'cabinetsLattice',label:'列',align:'center'},               
	                   {name:'archiveStorageName',label:'档案入库经办人',align:'center'},
	                   {name:'archiveStorageOrgName',label:'档案入库经办机构',align:'center'},
	                   {name:'archiveStorageDate',label:'档案入库经办日期',align:'center'}, 
	                   {name:'pkId',label:'主键',hidden:true,width:100,key:true}
     	        	];
	$("#paymentRecordList").jqGrid({
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
          height:'100%'
      });
	$("#paymentRecordList").jqGrid('setFrozenColumns');
	
	
	
}

function initCorpRecordTable(){
	var columns= [	    {name:'pkId',frozen:true,label:'缴费记录编号',align:'center',key:true,formatter:function(cellvalue, options, rowObject){
	     return "<a style='curosr:pointer;color:#4876FF' href='javascript:corpPersonList("+cellvalue+")'>"+cellvalue+"</a>";
				   }
				},
				{name:'aab004',frozen:true,label:'缴费单位',align:'center'},
				{name:'uaNo',label:'单位协议编号',align:'center'},					   
				{name:'fdPaymentDate',label:'缴费日期',align:'center'},
				{name:'fdPaymentAmount',label:'单位缴费金额',align:'center'},
				{name:'fdPaymentMonths',label:'缴费月数',align:'center'},
				{name:'fdPaymentStatus',label:'缴费标记',align:'center'},
				{name:'fdDerateStatus',label:'减免标记',align:'center'},	                   
				{name:'fdCreaterName',label:'经办人',align:'center'},
				{name:'fdCreaterDate',label:'经办日期',align:'center'},
				{name:'fdCreaterOrgName',label:'经办机构',align:'center'},	                  
				{name:'fdConfirmsName',label:'财务经办人',align:'center'},
				{name:'fdConfirmsDate',label:'财务经办日期',align:'center'},
				{name:'fdConfirmsOrgName',label:'财务经办机构',align:'center'},
				{name:'aae004',frozen:true,label:'单位联系人',align:'center'},
				{name:'aae005',frozen:true,label:'单位联系电话',align:'center'},
				{name:'fkCorpId',label:'主键',hidden:true },
				{name:'mvcMethod',label:'更新标记',hidden:true }                   
				
				];
	$("#paymentCorpRecordList").jqGrid({
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "local",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridCorpPager",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           multiselect:true,
           autowidth: true,
           height:'100%'
       });
	$("#paymentCorpRecordList").jqGrid('setFrozenColumns');
} 
function corpPersonList(fkCorpRecordId){
	xfui.open_dialog({    
	    title: '人员缴费明细',    
	    width: 800,    
	    height: 500,    
	    closed: false,    
	    cache: false,    
	    url: CTX+"/business/personagency/payment/paymentCorpRecord/corpPersonList.xf?fkCorpRecordId="+fkCorpRecordId,
	    modal: true   
	})
}

function doSearch(){
	$("#paymentRecordList").jqGrid("clearGridData");
	var json=$("#searchForm").serializeJson();
	jsonData = json;
	$("#paymentRecordList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/search/listPerDerateJson.xf',postData:json}).trigger("reloadGrid");
}
function doCorpSearch(){
	$("#paymentCorpRecordList").jqGrid("clearGridData");
	var json=$("#searchCorpForm").serializeJson();
	jsonData1 = json;
	$("#paymentCorpRecordList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/search/listCorpDerateJson.xf',postData:json}).trigger("reloadGrid");
}

//个人减免查询
function initDataExp(){
	$('#exp').dataexp({
		gridId:"paymentRecordList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'个人减免查询',
		sheetName:'个人减免查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson.status = 'h7';
			var id = $("#paymentRecordList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			return dataJson;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#paymentRecordList").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			return {status:'h7',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}


//单位查询
function initDataExp1(){
	$('#exp1').dataexp({
		gridId:"paymentCorpRecordList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'个人减免查询',
		sheetName:'个人减免查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson1.status = 'h71';
			var id = $("#paymentCorpRecordList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			return dataJson1;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#paymentCorpRecordList").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			return {status:'h71',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}





