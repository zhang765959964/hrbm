var dataJson = {};
var dataJson1 = {};
var isSave=true;
$(function(){
	xfui.initUi();
	initl();
	initOverTable();
	$("#perOverdue").removeClass("in").removeClass("active");
	initDataExp();
	initDataExp1();
})


function initl(){
	/**
	 初始化表格显示
	*/
	var columns= [	    {name:'pkId',frozen:true,align:'center',label:'缴费记录编号',key:true,formatter:function(cellvalue, options, rowObject){
							     return "<a style='curosr:pointer;color:#4876FF' href='javascript:corpPersonList("+cellvalue+")'>"+cellvalue+"</a>";
						    }
					    },
					   {name:'aab004',frozen:true,label:'缴费单位',align:'center'},
					   {name:'aab007',frozen:true,label:'工商登记执照号码',align:'center'},
					   {name:'uaNo',label:'单位协议编号',align:'center'},					   
		               {name:'fdPaymentDate',label:'缴费日期',align:'center'},
	                   {name:'fdPaymentAmount',label:'单位缴费金额',align:'center'},
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
          height:'100%'
      });
	$("#paymentCorpRecordList").jqGrid('setFrozenColumns');
	
	$(".highSearch").click(function(){
		$(".highCondition").toggle();
	});
	
	
}


function initOverTable(){
	
	var columns= [
                  {name:'id',label:'序号',align:'center',frozen : true},
                  {name:'aab004',label:'单位名称',align:'center',frozen : true},
                  {name:'aab007',label:'营业执照号',align:'center',frozen : true},                
                  {name:'overAmount',label:'欠费金额',align:'center'},
                  {name:'overUserNum',label:'欠费人数',align:'center'},
                  {name:'aaa021',label:'所在地区',align:'center'},
                  {name:'unitName',label:'单位性质',align:'center'},
                  {name:'econName',label:'经济类型',align:'center'},
                  {name:'aae006',label:'地址',align:'center'},
                  {name:'uaNo',label:'单位协议编号',align:'center'},
                  {name:'uaStatuss',label:'有效标记',align:'center'},                 
                  {name:'uaCreatetime',label:'协议签订日期',align:'center'},
                  {name:'uaName',label:'单位协议人',align:'center'},
                  {name:'uaPhone',label:'联系电话',align:'center'},
                  {name:'bab002',label:'传真',align:'center'},
                  {name:'uaCard',label:'经办人身份证号',align:'center'},
                  {name:'uaContent',label:'协议主要内容',align:'center'},
                  {name:'uaNote',label:'备注',align:'center'},
                  {name:'createrName',label:'经办人',align:'center'},
                  {name:'createrOrgName',label:'经办机构',align:'center'},
                  {name:'createrDate',label:'经办日期',align:'center'},
                  {name:'stopDatexx',label:'协议实质终止日期',align:'center'},
                  {name:'uaStopCause',label:'终止原因',align:'center'},
                  {name:'stopName',label:'终止经办人',align:'center'},
                  {name:'stopOrgName',label:'终止经办机构',align:'center'},
                  {name:'stopDate',label:'终止经办日期',align:'center'}
               	
	        	];

		$("#paymentCorpOverList").jqGrid({
				mtype : "GET",
				styleUI : 'Bootstrap',
				datatype : "local",
				colModel : columns,
				viewrecords : true,
				rowNum : 10,
				rowList : [ 10, 20, 30 ],
				pager : "#jqGridPagerOver",
				pagerpos : 'left',
				regional : 'cn',
				recordpos : 'right',
				shrinkToFit : false,
				autowidth : true,
				height : '100%'
			});
			$("#paymentCorpOverList").jqGrid('setFrozenColumns');
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
	
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#paymentCorpRecordList").jqGrid("clearGridData");	
	$("#paymentCorpRecordList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/corp/together/search/listJson.xf',postData:json}).trigger("reloadGrid");
}




function doOverSearch(){
	var json=$("#searchOverForm").serializeJson();
	dataJson1 = json;
	$("#paymentCorpOverList").jqGrid("clearGridData");	
	$("#paymentCorpOverList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/payment/corp/together/search/overListJson.xf',postData:json}).trigger("reloadGrid");
}


//单位费用查询
function initDataExp(){
	$('#exp').dataexp({
		gridId:"paymentCorpRecordList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'单位费用查询',
		sheetName:'单位费用查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson.status = 'h6';
			var id = $("#paymentCorpRecordList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			dataJson.id = id;
        			return dataJson;
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
		        			return {status:'h6',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}




//单位欠费查询
function initDataExp1(){
	$('#exp1').dataexp({
		gridId:"paymentCorpOverList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'单位欠费查询',
		sheetName:'单位欠费查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			dataJson1.status = 'h61';
			var id = $("#paymentCorpOverList").jqGrid("getDataIDs");	   
        		if(id&&id.length>0){
        			dataJson1.id = id;
        			return dataJson1;
        		}else{
        			bootbox.alert("无可导出的数据！");
        			return false;
        		}	
		           }},
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#paymentCorpOverList").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			return {status:'h61',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		  				 }
				     }
		          ]
	});
}


