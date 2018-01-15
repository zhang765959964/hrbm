var dataJson = {};
$(function(){
	initl();
	initDataExp();
})

//初始化表格操作
function initl(){
	/**
	 初始化表格显示
	*/


		var columns= [{name:'id',label:'操作',key: true,align:'center',width:80,frozen : true,	formatter:'actions',formatoptions:{
						keys: false,
						editbutton : true,
						delbutton : false
						}},
					  {name:'archiveCode',label:'档案编号',align:'center',frozen : true},					  
		              {name:'aac002',label:'身份证号',align:'center',frozen : true},
		              {name:'aac003',label:'姓名',align:'center',frozen : true},
		              {name:'subsidyNum',label:'社保补贴编号',align:'center',editable : true,
	                	   edittype:'text',editrules : {
	                		   custom:true, custom_func:function(value, colNames,f,d,d1,d2){
	                		   debugger;
	                		   var dd=$(this);
	                		   var rowId=$(this).find("tr.active").attr("id");
	                		   if(isCodeExist(value,rowId)){
	                			   if(value==""){
	                				   return [false, "社保补贴编号不能为空"];  
	                			   }else{
	                				   return [false, "社保补贴编号不能重复"];  
	                			   }
	                		   }else{
	                		    return [true,""];
	                		   } 
	                	   }
		              }},
		              {name:'createrNum',label:'登记次数',align:'center',editable : true,
	                	   edittype:'text',editrules : {number:true,required : true,maxValue:100}},
	                  {name:'oldSubsidyNum',label:'老编号',align:'center'},
	                  {name:'aac004',label:'性别',align:'center'
//	                	  formatter:checkSex
	                	  },
	                  {name:'expRegisgration',label:'再就业优惠证编号',align:'center'},
	                  {name:'acc0m1',label:'就业失业登记证号码',align:'center'},
	                  {name:'pensionMonths',label:'养老保险补贴月数',align:'center'},
	                  {name:'pensionStartDate',label:'养老补贴开始年份',align:'center'},
	                  {name:'pensionEndDate',label:'养老补贴结束年份',align:'center'},
	                  {name:'medicalMonths',label:'医疗保险补贴月数',align:'center'},
	                  {name:'medicalStartDate',label:'医疗补贴开始年份',align:'center'},
	                  {name:'medicalEndDate',label:'医疗补贴结束年份',align:'center'},
	                  {name:'contractSignDate',label:'签订劳动合同开始时间',align:'center'},
	                  {name:'contractEndDate',label:'签订劳动合同终止时间',align:'center'},
	                  {name:'contractDestoryDate',label:'劳动合同解除日期',align:'center'},
	                   {name:'isPassed',label:'是否通过',align:'center'
//	                	  formatter:isPass
	                	  },
	                   {name:'checkState',label:'审核标记',align:'center'
//	                	   ,formatter:checkBj
	                	   },
	                   {name:'isHasBusLic',label:'是否持有营业执照',align:'center'
//	                	   ,formatter:isHasBusLic
	                	   },
	                  {name:'bankName',label:'开户银行',align:'center'},
	                  {name:'bankCardNo',label:'银行帐号',align:'center'},
	                  {name:'busLicNum',label:'营业执照编号',align:'center'},
	                  {name:'outerSubsidyMonths',label:'已在外单位享受补贴月数',align:'center'},
	                  
	                  {name:'expOldCompany',label:'原工作单位',align:'center'},
	                  {name:'description',label:'备注',align:'center'},
//	                  {name:'createrId',label:'经办人',align:'center'},
	                  {name:'createrName',label:'经办人',align:'center'},
	                  {name:'createrDate',label:'经办日期',align:'center'},
//	                  {name:'batchId',label:'批次Id',align:'center'},
	                  {name:'batchName',label:'批次名称',align:'center'},
	                  {name:'createrOrgName',label:'经办机构',align:'center'},
//	                  {name:'createrOrgId',label:'经办机构Id',align:'center'},
	                  {name:'pensionStandard',label:'养老补贴标准',align:'center'},
	                  {name:'pensionAmount',label:'养老补贴金额',align:'center'},
	                  {name:'medicalStandard',label:'医疗补贴标准',align:'center'},
	                  {name:'medicalAmount',label:'医疗补贴金额',align:'center'},
	                  {name:'pensionTotalMonths',label:'养老保险补贴总月数',align:'center'},
	                  {name:'medicalTotalMonths',label:'医疗保险补贴总月数',align:'center'}
	 	        	];
	   $("#socialSubsidyList").jqGrid({
          //url: CTX+'/business/personagency/subsidy/socialSubsidy/listJson.xf',
          editurl:CTX+'/business/personagency/subsidy/socialSubsidy/numUpdateSave.xf',
          mtype: "GET",
		   styleUI : 'Bootstrap',
          datatype: "local",
          colModel: columns,
		   viewrecords: true,
          rowNum: 10,
          rowList:[10,15,20],
          pager: "#jqGridPager",
          pagerpos:'left',
          regional : 'cn',
          recordpos:'right',
          shrinkToFit: false,
          autowidth: true,
          altRow:true,
          gridComplete:function(){
       	  $(".ui-inline-edit").on("click",function(){
       		  jQuery.fn.fmatter.rowactions.call(this,'edit');
       	  })
       	  $(".ui-inline-save").on("click",function(){
       		  jQuery.fn.fmatter.rowactions.call(this,'save');
       	  })
       	  $(".ui-inline-cancel").on("click",function(){
       		  jQuery.fn.fmatter.rowactions.call(this,'cancel');
       	  })
       	  
          },
          height:"100%"
      });
	   $("#socialSubsidyList").jqGrid('setFrozenColumns');
}




function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#socialSubsidyList").jqGrid("clearGridData");
	$("#socialSubsidyList").jqGrid("setGridParam",{postData:json,url: CTX+'/business/personagency/subsidy/socialSubsidy/listJson.xf',datatype:'json'}).trigger("reloadGrid");
}


//社保导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"socialSubsidyList",
		serviceId:'socialDataExpServiceImpl',
		fileName:'社保补贴编号修改',
		sheetName:'社保补贴编号修改',
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



function refreshSubsidyList(){
	
	$("#socialSubsidyList").trigger("reloadGrid");
}

function isCodeExist(value,rowId){
	var isexist=false;
	
	$.ajax({ url: CTX+'/business/personagency/subsidy/socialSubsidy/isCodeExist.xf',
		data:{id:rowId,subsidyNum:value},
		dataType:'json',
		async:false,
		success: function(data){
			if(data.result===0){
				isexist=true;
			}
         }
	});
	return isexist;
}
