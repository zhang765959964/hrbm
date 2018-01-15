
var isSave=true;
$(function(){
	/**
	 初始化表格显示
	*/
		  var columns= [{name:'pkId',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
						keys: false,
						editbutton : true,
						delbutton : false,
						onSuccess:function(){
							isSave=true;
							var corpId=$("#aab001").val();
							if(corpId){
								refreshCorpRecord();
							}
						}
						}},
		               {name:'fdPaymentDate',label:'缴费日期',align:'center',editable:true,unformat: pickDate},
	                   {name:'fdPaymentAmount',label:'单位缴费金额',align:'center'},
	                   {name:'fdPaymentStatus',label:'缴费标记',align:'center'},	                                      
	                   {name:'fdDerateStatus',label:'减免标记',align:'center'},
	                   {name:'fdDesc',label:'备注',align:'center'},
					   {name:'fdCreaterName',label:'经办人',align:'center'},
					   {name:'fdCreaterDate',label:'经办日期',align:'center'},
					   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},	                  
	                   {name:'fdConfirmsName',label:'财务经办人',align:'center'},
	                   {name:'fdConfirmsDate',label:'财务经办日期',align:'center'},
	                   {name:'fdConfirmsOrgName',label:'财务经办机构',align:'center'},
	                   {name:'fkCorpId',label:'主键',hidden:true },
	                   {name:'mvcMethod',label:'更新标记',hidden:true }
      	        	];
	 var lastsel;
	 var corpId=$("#aab001").val();
	$("#paymentCorpRecordList").jqGrid({
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
           autowidth: true,
           height:200,
           editurl:CTX+"/business/personagency/payment/paymentCorpRecord/save.xf?fkCorpId="+corpId,
           onSelectRow : function(id) {       	   
               if (id && id !== lastsel) {
                 jQuery('#paymentCorpRecordList').jqGrid('restoreRow', lastsel);
                 jQuery('#paymentCorpRecordList').jqGrid('editRow', id, true);
                 lastsel = id;
               }
             },
           gridComplete:function(){
        	   
           	  $(".ui-inline-edit").removeAttr("onclick").on("click",function(){
           		  jQuery.fn.fmatter.rowactions.call(this,'edit');
           	  })
           	  $(".ui-inline-save").removeAttr("onclick").on("click",function(){
           		  jQuery.fn.fmatter.rowactions.call(this,'save');
           	  })
           	  $(".ui-inline-cancel").removeAttr("onclick").on("click",function(){
           		  jQuery.fn.fmatter.rowactions.call(this,'cancel');
           	  })
           	  
            }
       });
	initArchivesTable();
	initPaymentTable();
	initData();
	bindEvent()
})
function bindEvent(){
	$("#addPaymentCorpRecord").on("click",function(){
		addPaymentCorpRecord();
	})
	$("#savePaymentCorpRecord").on("click",function(){
		savePaymentCorpRecord();
	})
	$("#delPaymentCorpRecord").on("click",function(){
		delPaymentCorpRecord();
	})
	$("#addPaymentRecord").on("click",function(){
		addPaymentRecord();
	})
	$("#delPaymentRecord").on("click",function(){
		delPaymentRecord();
	})
	$("#allAddPaymentRecord").on("click",function(){
		allAddPaymentRecord();
	})
	$("#mutiAddPaymentRecord").on("click",function(){
		mutiAddPaymentRecord('paymentRecordList1');
	})

	$("#viewCorpPersonList").on("click",function(){
		viewCorpPersonList();
	})
	 $('a[href="#selperson"]').on('shown.bs.tab', function (e) {

		  var target =e.target;
		  initSelectArchivesTable();
		  
		  
		})
	
}

function viewCorpPersonList(){
	var fkCorpRecordId=$("#paymentCorpRecordList").jqGrid("getGridParam","selrow");
	if(fkCorpRecordId){
		fkCorpRecordId=fkCorpRecordId==0?-1:fkCorpRecordId;
		xfui.open_dialog({    
		    title: '人员缴费明细',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/payment/paymentCorpRecord/corpPersonList.xf?fkCorpRecordId="+fkCorpRecordId,
		    modal: true   
		})
	}else{
		bootbox.alert("请选择缴费记录");
	}
	
}

function initData(){
	var corpId=$("#aab001").val();
	if(corpId){
		$("#paymentCorpRecordList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/paymentCorpRecord/listJson.xf?fkCorpId='+corpId,}).trigger("reloadGrid");
	
// 		$("#paymentRecordList1").jqGrid({multiselect:true})
		$("#paymentRecordList1").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/paymentCorpRecord/corpArchiveslistJson.xf?corpId='+corpId,}).trigger("reloadGrid");

	}
}
function pickDate( cellvalue, options, cell ) {
	setTimeout(function(){
		$(cell) .find('input[type=text]')
				.xfdaterangepicker({singleDatePicker:true,
				  "opens":"right",
				  "drops": "down",
		          "locale": {
		             "format": "YYYY-MM-DD"
		         }
		     });
	}, 0);
	 
}
function addPaymentCorpRecord(){
	var aab001=$("#aab001").val();
	if(!aab001){
		 bootbox.alert("请选择一条单位信息")
		 return;
	}
//	if(!isSave){
//		bootbox.alert("数据尚未保存,不能新增操作");
//		 return;
//	}
    $.ajax({
        type: "post",
        url: CTX+"/business/personagency/payment/paymentCorpRecord/getAddData.xf?corpId="+aab001,
        dataType: "json",
        success: function(data){
        	 
        	if(data.result===1){
        		var rowData=data.rowData;
        		$("#paymentCorpRecordList").jqGrid("addRowData", rowData.pkId, rowData, "first");
                
                isSave=false;
                jQuery('#paymentCorpRecordList').jqGrid('setSelection', rowData.pkId, true);
                $("#"+rowData.pkId).find(".ui-inline-edit").removeAttr("onclick").on("click",function(){
             		  jQuery.fn.fmatter.rowactions.call(this,'edit');
             	  })
                $("#"+rowData.pkId).find(".ui-inline-edit").click();
        	}else{
        		bootbox.alert(data.message);
        	}
            
        }
    });
	
}
function savePaymentCorpRecord(){
	//var row = $('#paymentCorpRecordList').bootstrapTable('getAllSelections');
	var aab001=$("#aab001").val();
	var rowid=$("#paymentCorpRecordList").jqGrid("getGridParam","selrow");
	if(!rowid){
		 bootbox.alert("请选择一条缴费记录");
		 return;
	}
	jQuery('#paymentCorpRecordList').jqGrid('saveRow', rowid,{successfunc: function( response ) {
		isSave=true;
		var data=response.responseText;
		json=JSON.parse(data); 
        if(json.result=="1"){
        	//$("#paymentCorpRecordList").jqGrid('setCell',rowid,"mvcMethod","edit"); 
        	$("#paymentCorpRecordList").trigger("reloadGrid");
        	return true; 
        } 
    }});
	isSave=true;
} 
function initArchivesTable(){
	
	var columns= [
                 	{name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                  {name:'aac003',label:'姓名',align:'center',frozen : true},
                  {name:'aac002',label:'身份证号',align:'center',frozen : true},
                  {name:'genderName',label:'性别',align:'center'},
                  {name:'aac006',label:'出生日期',align:'center'},
                  {name:'ExpSoctalNumber',label:'社会保障号',align:'center'},
                  {name:'ContractCode',label:'合同编号',align:'center'},
                  {name:'archiveTypeName',label:'存档类型',align:'center'},
                  {name:'archiveName',label:'档案姓名',align:'center'},
                  {name:'archiveBirthDate',label:'档案出生日期',align:'center'},
                  {name:'aab301',label:'现居住地址',align:'center'},
                  {name:'FAName',label:'配偶姓名',align:'center'},
                  {name:'planRetiredDate',label:'退休参考日期',align:'center'},
                  {name:'receiveDate',label:'档案转入日期',align:'center'},
                  {name:'archiveStatusName',label:'档案状态',align:'center'},
                  {name:'archiveReceiveDesc',label:'档案存放位置备注',align:'center'},
                  {name:'ArchiveReceiveName',label:'接收人',align:'center'},
                  {name:'aac001',label:'',align:'center',hidden:true,key:true}
	                
    	        ];
	var type=$("#type").val();
	var multiselect=type=="0"?false:true;
	
$("#paymentRecordList1").jqGrid({
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
      multiselect:multiselect,
      onSelectRow:function(rowId){
    	  loadPaymentRecord(rowId);
      },
      autowidth: true,
      height:200
  });
$("#paymentRecordList1").jqGrid('setFrozenColumns');

}
function initSelectArchivesTable(){
	
	var columns= [
                  {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                  {name:'aac003',label:'姓名',align:'center',frozen : true},
                  {name:'aac002',label:'身份证号',align:'center',frozen : true},
                  {name:'genderName',label:'性别',align:'center'},
                  {name:'aac006',label:'出生日期',align:'center'},
                  {name:'ExpSoctalNumber',label:'社会保障号',align:'center'},
                  {name:'ContractCode',label:'合同编号',align:'center'},
                  {name:'archiveTypeName',label:'存档类型',align:'center'},
                  {name:'archiveName',label:'档案姓名',align:'center'},
                  {name:'archiveBirthDate',label:'档案出生日期',align:'center'},
                  {name:'aab301',label:'现居住地址',align:'center'},
                  {name:'FAName',label:'配偶姓名',align:'center'},
                  {name:'planRetiredDate',label:'退休参考日期',align:'center'},
                  {name:'receiveDate',label:'档案转入日期',align:'center'},
                  {name:'archiveStatusName',label:'档案状态',align:'center'},
                  {name:'archiveReceiveDesc',label:'档案存放位置备注',align:'center'},
                  {name:'ArchiveReceiveName',label:'接收人',align:'center'},
                  {name:'aac001',label:'',align:'center',hidden:true,key:true}
	                
    	        ];
$("#selpersonList").jqGrid({
      mtype: "GET",
	   styleUI : 'Bootstrap',
      datatype: "local",
      colModel: columns,
	   viewrecords: true,
      rowNum: 10,
      rowList:[10,20,30],
      pager: "#jqGridPager2",
      pagerpos:'left',
      regional : 'cn',
      recordpos:'right',
      shrinkToFit: false,
      multiselect:true,
      autowidth: true,
      height:200
  });
$("#selpersonList").jqGrid('setFrozenColumns');

}

function initPaymentTable(){
	var columns= [	   {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'fdStartDate',label:'开始缴费日期',align:'center'},
	                   {name:'fdEndDate',label:'终止缴费日期',align:'center'},
	                   {name:'fdPaymentMonths',label:'缴费月数',align:'center'},
	                   {name:'fdPaymentStandard',label:'缴费标准',align:'center'},
	                   {name:'fdPaymentAmount',label:'缴费金额',align:'center'},	                   
	                   {name:'fdPaymentType',label:'缴费类型',align:'center'},	
	                   {name:'fdDerateStatus',label:'减免标记',align:'center'},
	                   {name:'fdPaymentStatus',label:'缴费状态',align:'center'},	                  
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
	                   {name:'fdCreaterDate',label:'经办日期',align:'center'},	                   
	                   {name:'pkId',label:'操作',hidden:true,width:100,key:true}
      	        	];
	$("#paymentRecordList2").jqGrid({
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "local",
           colModel: columns,
		   viewrecords: true,
           rowNum: 10,
           rowList:[10,20,30],
           pager: "#jqGridPager2",
           pagerpos:'left',
           regional : 'cn',
           recordpos:'right',
           shrinkToFit: false,
           autowidth: true,
           altRows:true, 
           height:170
       });
	
}

function delPaymentCorpRecord(){

	var pkId=$("#paymentCorpRecordList").jqGrid("getGridParam","selrow");
	if(pkId){
		
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/payment/paymentCorpRecord/del.xf',
		    		data:{pkId:pkId},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message); 	
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		    			
		    			$("#paymentCorpRecordList").trigger("reloadGrid");
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }			
}

function delPaymentRecord (){
	
	var pkId=$("#paymentRecordList2").jqGrid("getGridParam","selrow");
	if(pkId){
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/payment/paymentYearDetail/del.xf',
		    		data:{id:pkId},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message); 	
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		    			
		    			refresh();
		    			refreshCorpRecord();
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }	
}

function addPaymentRecord(){

	var personId=$("#paymentRecordList1").jqGrid("getGridParam","selrow");
	if(!personId||personId=="0"){
		bootbox.alert('请选择一条人员档案信息');
		return;
	}
	var personId=$("#paymentRecordList1").jqGrid("getGridParam","selrow");
	if(!personId||personId=="0"){
		bootbox.alert('请选择一条人员档案信息');
		return;
	}
	var aab001=$("#aab001").val();
	var corpRecordId=$("#paymentCorpRecordList").jqGrid("getGridParam","selrow");
	if(!corpRecordId){
		 bootbox.alert("请选择一条缴费记录");
		 return;
	}
 	var rowData=$("#paymentCorpRecordList").jqGrid("getRowData",corpRecordId);
 	if(rowData.fdPaymentStatus!="未缴"){
 		bootbox.alert("请选择一条未缴费记录");
		 return;
 	}
 	if(corpRecordId=="0"){
 		bootbox.alert("请选保存缴费记录");
		 return;
 	}
	var fdPaymentType=$("#fdPaymentType").val();
		xfui.open_dialog({    
		    title: '新增缴费记录',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/payment/paymentRecord/add.xf?corpRecordId="+corpRecordId+"&fdPaymentType="+fdPaymentType+"&personId="+personId,
		    modal: true   
		})
}

function loadPaymentRecord(rowId){
	$("#paymentRecordList2").jqGrid("setGridParam",
						 {datatype:'json',url:CTX+'/business/personagency/payment/paymentRecord/listJson.xf?fkPersonId='+rowId}
						).trigger("reloadGrid");
}

function refresh(){
	
	$("#paymentRecordList2").trigger("reloadGrid");
	
}

function refreshCorpRecord(){
	
	$("#paymentCorpRecordList").trigger("reloadGrid");
	
}

function  allAddPaymentRecord(){
	
	var aab001=$("#aab001").val();
	var corpRecordId=$("#paymentCorpRecordList").jqGrid("getGridParam","selrow");
	if(!corpRecordId){
		 bootbox.alert("请选择一条缴费记录");
		 return;
	}
 	var rowData=$("#paymentCorpRecordList").jqGrid("getRowData",corpRecordId);
 	if(rowData.fdPaymentStatus!="未缴"){
 		bootbox.alert("请选择一条未缴费记录");
		 return;
 	}
 	if(corpRecordId=="0"){
 		bootbox.alert("请选保存缴费记录");
		 return;
 	}

		xfui.open_dialog({    
		    title: '全选批量缴费',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/payment/paymentCorpRecord/batchAdd.xf?selType=all&corpRecordId="+corpRecordId,
		    modal: true   
		})
	
}

function  mutiAddPaymentRecord(targetId){
	var corpRecordId=$("#paymentCorpRecordList").jqGrid("getGridParam","selrow");
	if(!corpRecordId){
		 bootbox.alert("请选择一条缴费记录");
		 return;
	}
 	var rowData=$("#paymentCorpRecordList").jqGrid("getRowData",corpRecordId);
 	if(rowData.fdPaymentStatus!="未缴"){
 		bootbox.alert("请选择一条未缴费记录");
		 return;
 	}
 	if(corpRecordId=="0"){
 		bootbox.alert("请选保存缴费记录");
		 return;
 	}
	var rowids=$("#"+targetId).jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var personIds="";
		$.each(rowids,function(i,e){
			if(i==0){
				personIds+=e;
			}else{
				personIds+=","+e;
			}
			
		});
		
		var corpId=$("#aab001").val();
		xfui.open_dialog({    
		    title: '多选批量缴费',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/payment/paymentCorpRecord/batchAdd.xf?selType=muti&corpRecordId="+corpRecordId+"&personIds="+personIds,
		    modal: true   
		}) 
	  }else{
		 bootbox.alert('请选择记录');
	 }
	
}

function  addSearchData(){
	var aab001=$("#aab001").val();
	if(!aab001){
		 bootbox.alert("请选择一条单位信息")
		 return;
	}
	var json=$("#searchForm").serializeJson();
	json.Q_aab001_S=aab001;
    $.ajax({
        type: "post",
        url: CTX+"/business/personagency/payment/paymentCorpRecord/getSelPersonData.xf?",
        data:json,
        dataType: "json",
        success: function(data){
        	 
        	if(data.result===1){
        		var rowData=data.rowData;
        		debugger;
        		$.each(rowData,function(i,e){
        			debugger;
        			var oldRowData=$("#selpersonList").jqGrid("getRowData", e.aac001);
        			var flag =  verifyExist("selpersonList","aac001",e.aac001);
            		if(flag){
            			bootbox.alert("表格中已经存在！");
            			return;
            		}
            		$("#selpersonList").jqGrid("addRowData", e.aac001, e);
        		})
        		
        	}else{
        		bootbox.alert(data.message);
        	}
            
        }
    });
}
function clearGridData(){
	
	
	bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
	    if (r){    
	    	$("#selpersonList").jqGrid("clearGridData");	
	    }    
	}}); 
}
function delRowData(){
	var personId=$("#selpersonList").jqGrid("getGridParam","selrow");
	if(!personId){
		 bootbox.alert("请选择一条人员记录");
		 return;
	}
	$("#selpersonList").jqGrid("delRowData",personId);	
}

