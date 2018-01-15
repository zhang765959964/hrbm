var dataJson = {};	
var dataJson1= {};
$(function(){
	initl();
	initOverPayTable();
	$("#perOverdue").removeClass("in").removeClass("active");
	xfui.initUi();
	initDataExp();
	initDataExp1();
})

function initl(){
	/**
	 初始化表格显示
	*/
	var columns= [	   
                 {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                 {name:'aac003',label:'姓名',align:'center',frozen : true
                 },
                 {name:'aac002',label:'身份证号',align:'center',frozen : true},
                 {name:'fdPaymentDate',label:'缴费日期',align:'center'},
                 {name:'fdStartDate',label:'缴费开始年月',align:'center'},
                 {name:'fdEndDate',label:'缴费终止年月',align:'center'},
                 {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
                 {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
                 {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	                                   
                 {name:'fdPaymentStatus',label:'缴费状态',align:'center'},
                 {name:'fdDerateStatus',label:'减免标记',align:'center'},
                 {name:'aab004',label:'单位名称',align:'center'},
                 {name:'archiveStatusName',label:'档案状态',align:'center'},
                 {name:'archiveTypeName',label:'存档类型',align:'center'},
                 {name:'fdCreaterName',label:'经办人',align:'center'},
                 {name:'expPersonPhone',label:'联系电话',align:'center'}, 
                 {name:'aae005',label:'手机号',align:'center'}, 
                 {name:'fkPersonId',label:'人员id',hidden:true},
                 {name:'pkId',label:'操作',hidden:true,width:100,key:true}
	        	];
	$("#paymentRecordList").jqGrid({
		   url:"",
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


function initOverPayTable(){
	var columns= [	   
                  {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                  {name:'aac003',label:'姓名',align:'center',frozen : true
                  },
                  {name:'aac002',label:'身份证号',align:'center'},                 
                  {name:'fdEndPaymentDate',label:'最后缴费年月',align:'center'},	 
                  {name:'overAmount',label:'欠费金额',align:'center'},	  
                  {name:'genderName',label:'性别',align:'center'},	  
                  {name:'nationName',label:'名族',align:'center'},	  
                  {name:'aac006',label:'出生日期',align:'center'},	 
                  {name:'archiveTypeName',label:'存档类型',align:'center'},	                   
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
                  {name:'lendStringReason',label:'调出原因',align:'center'},                
                  {name:'archivesLendWhere',label:'调出去向',align:'center'},
                  {name:'LendIdNumber',label:'调出人身份证号',align:'center'},
                  {name:'lendPhone',label:'调出人联系方式',align:'center'},
                  {name:'lendRemarks',label:'调出原因',align:'center'},               
                  {name:'lendConfirmName',label:'经办人',align:'center'},
                  {name:'lendConfirmDate',label:'经办日期',align:'center'},
                  {name:'lendConfirmOrgName',label:'经办机构',align:'center'},  
                  {name:'id',label:'操作',hidden:true,width:100,key:true}
 	        	];
	$("#paymentRecordList1").jqGrid({
		   url:"",
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
           multiselect:true,
           autowidth: true,
           height:'100%'
       });
	$("#paymentRecordList1").jqGrid('setFrozenColumns');
}
//function addPaymentRecord(){	
//		xfui.open_dialog({    
//		    title: '新增缴费记录',    
//		    width: 800,    
//		    height: 500,    
//		    closed: false,    
//		    cache: false,    
//		    url: CTX+"/business/personagency/payment/paymentRecord/add.xf",
//		    modal: true   
//		})
//}
//function editPaymentRecord(){
//	//var row = $('#paymentRecordList').bootstrapTable('getAllSelections');
//	var rowid=$("#paymentRecordList").jqGrid("getGridParam","selrow");
//	if(rowid){
//		var pkId=rowid;
//		xfui.open_dialog({    
//	  		    title: '编辑缴费记录',    
//	  		    width: 800,    
//	  		    height: 500,    
//	  		    closed: false,    
//	  		    cache: false,    
//	  		    url: CTX+"/business/personagency/payment/paymentRecord/edit.xf?pkId="+pkId,
//	  		    modal: true   
//	  		})
//	}else{
//		bootbox.alert('请选择记录');
//	}			
//} 
//
//function delPaymentRecord(){
//
//	var rowids=$("#paymentRecordList").jqGrid("getGridParam","selarrrow");
//	if(rowids&&rowids.length>0){
//		var pkId="";
//		$.each(rowids,function(i,e){
//			if(i==0){
//				pkId+=e;
//			}else{
//				pkId+=","+e;
//			}
//			
//		});
//		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
//		    if (r){    
//		    	$.ajax({ url: CTX+'/business/personagency/payment/paymentRecord/del.xf',
//		    		data:{pkId:pkId},
//		    		dataType:'json',
//		    		success: function(data){
//		    			if(data.message){
//		    				bootbox.alert(data.message); 	
//		    			}else{
//		    				bootbox.alert("未知错误"); 
//		    			}
//		    			
//		    			refresh();
//		             }
//		    	});
//		    }    
//		}}); 
//	  }else{
//		 bootbox.alert('请选择记录');
//	 }			
//} 

//个人费用查询
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#paymentRecordList").jqGrid("clearGridData");	
	$("#paymentRecordList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/search/listJson.xf',postData:json}).trigger("reloadGrid");
}
function doOverSearch(){
	var json=$("#overSearchForm").serializeJson();
	dataJson1 = json;
	$("#paymentRecordList1").jqGrid("clearGridData");	
	$("#paymentRecordList1").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/search/listOverJson.xf',postData:json}).trigger("reloadGrid");
}




//个人费用查询
function initDataExp(){
	$('#exp').dataexp({
		gridId:"paymentRecordList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'个人费用查询',
		sheetName:'个人费用查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson.status = 'h5';
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
		        			return {status:'h5',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}



//个人欠费查询
function initDataExp1(){
	$('#exp1').dataexp({
		gridId:"paymentRecordList1",
		serviceId:'socialDataExpServiceImpl',
		fileName:'个人欠费查询',
		sheetName:'个人欠费查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson1.status = 'h51';
			var id = $("#paymentRecordList1").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			return dataJson1;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#paymentRecordList1").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			return {status:'h51',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}







