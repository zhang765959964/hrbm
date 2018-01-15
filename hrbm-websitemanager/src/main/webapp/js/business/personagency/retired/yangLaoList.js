var dataJson = {};
$(function(){
	dateInil();
	yangLaoPl();
	 $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
		  var target =e.target;
		  var bindEvent=$(target).attr("bindEvent");
		  eval(bindEvent+'()'); 
	});
	 initDataExp();
})


function yangLao(){
	$("#retiredYl").load(CTX+"/business/personagency/retired/declare/getRetiredByYlId.xf");
	var columns= [		
					   {name:'id',label:'id',hidden:true,frozen : true},
					   {name:'retiredId',label:'退休人员id',hidden:true},
	              	   {name:'personName',label:'姓名',align:'center',frozen : true},
	              	   {name:'personCard',label:'身份证号',align:'center',frozen:true},
	              	   {name:'XH',label:'序号',align:'center',frozen:true},
	              	   {name:'RETIRED_PEOPLE_NO',label:'个人编号',align:'center'},
	              	   {name:'RETIRED_PEOPLE_BM',label:'退休个人编码',align:'center'},
	              	   {name:'statusName',label:'退休申报状态',align:'center'},
	              	   {name:'RETIRED_AREA',label:'退休人员所属区域',align:'center'},
	              	   {name:'shbzh',label:'社会保障号',align:'center'},
	              	   {name:'sex',label:'性别',align:'center'},
	              	   {name:'nationName',label:'民族',align:'center'},
	              	   {name:'birthDate',label:'档案出生日期',align:'center'},
	              	   {name:'personCsrq',label:'出生日期',align:'center'},
	              	   {name:'createrWorkDate',label:'参加工作时间',align:'center'},
	              	   {name:'dabh',label:'档案编号',align:'center'},
	              	   {name:'phone',label:'联系电话',align:'center'},
	                   {name:'mobilePhone',label:'手机号',align:'center'},
	                   {name:'oldCompany',label:'原单位名称',align:'center'},
	                   {name:'UNIT_NAME',label:'单位名称',align:'center'},
	                   {name:'UNIT_NO',label:'单位编号',align:'center'},
	                   {name:'ZLTZH',label:'郑劳退字（）年（）号',align:'center'},
	                   {name:'workJob',label:'主要工作简历',align:'center'},
	                   {name:'rtName',label:'退休类别',align:'center'},
	                   {name:'RETIRED_SITE',label:'退休后安置点',align:'center'},
	                   {name:'DECLARE_NOTE',label:'申报备注',align:'center'},
	                   {name:'rgName',label:'符合离退休规定条款',align:'center'},
	                   {name:'payDate',label:'缴费年月',align:'center'},
	                   {name:'retiredDate',label:'应退休时间',align:'center'},
	                   {name:'CREATER_NAME',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'CREATER_ORG_NAME',label:'经办机构',align:'center'}
      	        	];
     
     $("#yangLaoList").jqGrid({
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
           height:'100%',
           altRows:true,
           shrinkToFit: false,
           multiselect:true,
           autowidth: true,
           multiboxonly : true,
           multiselect : false,
           onSelectRow :function(row,e){
		   	var rowData = $("#yangLaoList").jqGrid('getRowData',row);	
		   	console.info(rowData);
		   	$("#personId").val(row);
		   	$("#retiredYl").load(CTX+"/business/personagency/retired/declare/getRetiredByYlId.xf?id="+rowData.id);
		   }
       }); 	   
       
     $("#yangLaoList").jqGrid('setFrozenColumns');
	
}



function dateInil(){
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

//养老批量操作
function yangLaoPl(){
	$("#retireedYlPl").load(CTX+"/business/personagency/retired/declare/getRetiredYlPlList.xf");
	var columns= [		
	          		
				   {name:'ID',label:'id',hidden:true,frozen:true},
             	   {name:'personName',label:'姓名',align:'center',frozen:true},
             	   {name:'personCard',label:'身份证号',align:'center',frozen:true},
             	   {name:'XH',label:'序号',align:'center',frozen:true},
             	   {name:'RETIRED_PEOPLE_NO',label:'个人编号',align:'center'},
             	   {name:'RETIRED_PEOPLE_BM',label:'退休个人编号',align:'center'},
             	   {name:'statusName',label:'退休申报状态',align:'center'},
             	   {name:'RETIRED_AREA',label:'退休人员所属区域',align:'center'},
             	   {name:'shbzh',label:'社会保障号',align:'center'},
             	   {name:'sex',label:'性别',align:'center'},
             	   {name:'nationName',label:'民族',align:'center'},
             	   {name:'birthDate',label:'档案出生日期',align:'center'},
             	   {name:'personCsrq',label:'出生日期',align:'center'},
             	   {name:'createrWorkDate',label:'参加工作时间',align:'center'},
             	   {name:'dabh',label:'档案编号',align:'center'},
             	   {name:'phone',label:'联系电话',align:'center'},
                  {name:'mobilePhone',label:'手机号',align:'center'},
                  {name:'oldCompany',label:'原单位名称',align:'center'},
                  {name:'UNIT_NAME',label:'单位名称',align:'center'},
                  {name:'UNIT_NO',label:'单位编号',align:'center'},
                  {name:'ZLTZH',label:'郑劳退字（）年（）号',align:'center'},
                  {name:'workJob',label:'主要工作简历',align:'center'},
                  {name:'rtName',label:'退休类别',align:'center'},
                  {name:'RETIRED_SITE',label:'退休后安置点',align:'center'},
                  {name:'DECLARE_NOTE',label:'申报备注',align:'center'},
                  {name:'rgName',label:'符合离退休规定条款',align:'center'},
                  {name:'payDate',label:'缴费年月',align:'center'},
                  {name:'retiredDate',label:'应退休时间',align:'center'},
                  {name:'CREATER_NAME',label:'经办人',align:'center'},
                  {name:'createrDate',label:'经办日期',align:'center'},
                  {name:'CREATER_ORG_NAME',label:'经办机构',align:'center'}
	              
 	        	];
$("#yangLaoList1").jqGrid({
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
       height:'100%',
       altRows:true,
       shrinkToFit: false,
       multiselect:true,
       autowidth: true
	  
  }); 	     
	
	$("#yangLaoList1").jqGrid('setFrozenColumns');
}







function addYangLao(){	
		xfui.open_dialog({    
		    title: '新增养老待遇申请',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/yanglao/add.xf",
		    modal: true   
		})
}
function editYangLao(){
	var row = $('#yangLaoList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var id=row[0].id;
		xfui.open_dialog({    
	  		    title: '编辑养老待遇申请',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/yanglao/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 


function refresh(){
	$("#yangLaoList").trigger("reloadGrid");
}


function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retireedYlPl").load(CTX+"/business/personagency/retired/declare/getRetiredYlPlList.xf");
	$("#yangLaoList1").jqGrid("clearGridData");	
	$("#yangLaoList1").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/retired/declare/retiredListJson.xf',postData:json}).trigger("reloadGrid");
}

//养老单项查询
function  ylSearch(){
	var json=$("#searchYlForm").serializeJson();
	dataJson = json;
	$("#retiredYl").load(CTX+"/business/personagency/retired/declare/getRetiredByYlId.xf");
	$("#personId").val("");
	$("#yangLaoList").jqGrid("clearGridData");	
	$("#yangLaoList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/retired/declare/retiredListJson.xf',postData:json}).trigger("reloadGrid");
}


//导出批量
function initDataExp(){
	$('#exp').dataexp({
		gridId:"yangLaoList1",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'养老待遇申请',
		sheetName:'养老待遇申请',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#yangLaoList1").jqGrid("getDataIDs");	   
			 dataJson.level = '3';
			 if(id&&id.length>0){
				 return dataJson;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
        	  	var ids=$("#retiredSocialList").jqGrid("getGridParam","selarrrow");
        		if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        			});
        			 return {level:'5',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#yangLaoList1").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'3',ids:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}




