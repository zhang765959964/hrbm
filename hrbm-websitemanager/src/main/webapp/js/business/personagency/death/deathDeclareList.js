var dataJson = {};
var dataJson1 = {};
$(function(){
	deathDeclareInil();
	initDate();
	initDataExp();
	initDataExp1();
})

//死亡待遇审定信息
function deathDeclareInil(){
		var columns= [		
	                   {name:'id',hidden:true,label:'主键',align:'center',frozen : true},
	                   {name:'createrDate',label:'经办日期',align:'center',frozen : true},
	                   {name:'personName',label:'姓名',align:'center',frozen : true},
	                   {name:'deathNo',label:'个人编号',align:'center',frozen : true},
	                   {name:'personCard',label:'身份证号',align:'center',frozen : true},
	                   {name:'personSex',label:'性别',align:'center'},
	                   {name:'deathDate',label:'死亡日期',align:'center'},
	                   {name:'archiveCode',label:'档案编号',align:'center'},
	                   {name:'relatives',label:'亲属',align:'center'},
	                   {name:'phoneOne',label:'亲属联系电话1',align:'center'},
	                   {name:'phoneTwo',label:'亲属联系电话2',align:'center'},
	                   {name:'deathNote',label:'备注',align:'center'},
	                   {name:'txName',label:'离退休或退职',align:'center'},
	                   {name:'gbName',label:'工伤或病死',align:'center'},
	                   {name:'hzName',label:'火葬或土葬',align:'center'},
	                   {name:'monthMoney',label:'已统筹月离退休费',align:'center'},
	                   {name:'monthAgeMoney',label:'本企业月平均工资',align:'center'},
	                   {name:'monthFjMoney',label:'月抚恤救济金额',align:'center'},
	                   {name:'monthFlMoney',label:'月付粮价补金额',align:'center'},
	                   {name:'monthSumMoney',label:'以上两项月费用合计',align:'center'},
	                   {name:'oneMoney',label:'一次性抚恤救济金额',align:'center'},
	                   {name:'sfMoney',label:'丧葬补助金额',align:'center'},
	                   {name:'oneSumMoney',label:'以上两项一次性费用合计',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'}
	             
     	        	];

		var personColumns= [
	                  {name:'deathName',label:'姓名',align:'center'},
	                  {name:'deathBirthDate',label:'出生日期',align:'center'},
	                  {name:'deathRelation',label:'与死者关系',align:'center'},
	                  {name:'deathResaon',label:'供养理由',align:'center'},
	                  {name:'isflag',label:'原吃统销粮',align:'center'},
	                  {name:'address',label:'户口所在省市（县）乡（镇）村',align:'center'},
	                  {name:'deathEndDate',label:'抚恤救济终止年月',align:'center'}
	              
	 	        	];
     	
	$("#deathDeclareList").jqGrid({
		
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
          shrinkToFit: false,
          multiselect:true,
          multiboxonly: true,
          rownumbers: true,
          autowidth: true,
          altRows:true,
          onSelectRow:function(rowid,status){
        	  $("#deathPersonList").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/death/person/getByvDeathPersonJson.xf?personId='+rowid}).trigger("reloadGrid");
          }
      });

	  $("#deathPersonList").jqGrid({
	
	      mtype: "GET",
		  styleUI : 'Bootstrap',
	      datatype: "local",
	      colModel: personColumns,
		  viewrecords: true,
	      rowNum: 10,
	      rowList:[10,20,30],
	      pager: "#jqGridPager1",
	      pagerpos:'left',
	      regional : 'cn',
	      recordpos:'right',
	      height:'100%',
	      shrinkToFit: false,
	      multiselect:true,
	      rownumbers: true,
	      altRows:true,
	      autowidth: true
  });
	 $("#deathDeclareList").jqGrid('setFrozenColumns');

}

//打印死亡列表数据
function printDeathList(){
	  var ids=$("#deathDeclareList").jqGrid("getGridParam","selarrrow");
      if(ids&&ids.length>0){
			  var id="";
			  $.each(ids,function(i,e){
					if(i==0){
						id+=e;
					}else{
						id+=","+e;
					}
				});
			  var params = {"personIds" :ids};
			  templatePrint("death",params);
      }else{
        	  bootbox.alert('请选择记录');	
      }
}






function refresh(){
	$("#deathDeclareList").trigger("reloadGrid");
}

function initDate(){

	 $("#begindeathDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
          "locale": {
              "format": "YYYY-MM-DD"
          }
      });
	 
	 $("#enddeathDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
          "locale": {
             "format": "YYYY-MM-DD"
         }
     });
	 
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



function searchCardOrCode(){

		var personCard = $("#personCard").val();
		var archiveCode = $("#archiveCode").val();	
		if(personCard==''&&archiveCode==''){
			bootbox.alert("请填写查询条件！");
		}else{
			$.ajax({
				type: "post",
				url:CTX+"/business/personagency/death/searchListJson.xf",
				data:{personCard:personCard,archiveCode:archiveCode},
				cache:false,  
				success :function(data){
					if(data.length>0){
							$.each(data,function(i,e){
								var flag =  verifyExist("deathDeclareList","id",e.id);
										if(flag){
											bootbox.alert("表格中已经存在！");
										}else{
											 $("#deathDeclareList").jqGrid("addRowData",e.id,e, "first");  
								}
							})
					}else{
						bootbox.alert("没有查询到记录！");
					}
				}
			});
		}
}







function doSearch(){
	$("#deathDeclareList").jqGrid("clearGridData");	
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#deathDeclareList").jqGrid("setGridParam",{datatype:"json",url:CTX+"/business/personagency/death/listJson.xf",postData:json}).trigger("reloadGrid");

}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"deathDeclareList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'死亡待遇审定信息',
		sheetName:'死亡待遇审定信息',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#deathDeclareList").jqGrid("getDataIDs");	   
			 dataJson.level = 'a';
			 if(id&&id.length>0){
				 return dataJson;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
        	  	var ids=$("#retiredBhList").jqGrid("getGridParam","selarrrow");
        		if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        			});
        			 return {level:'6',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#deathDeclareList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'a',ids:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}


//导出
function initDataExp1(){
	$('#exp1').dataexp({
		gridId:"deathPersonList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'供养直系亲属信息',
		sheetName:'供养直系亲属信息',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#deathPersonList").jqGrid("getDataIDs");	   
			 dataJson1.level = 'a1';
			 if(id&&id.length>0){
				 return dataJson1;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
        	  	var ids=$("#retiredBhList").jqGrid("getGridParam","selarrrow");
        		if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        			});
        			 return {level:'6',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#deathPersonList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'a1',ids:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}


