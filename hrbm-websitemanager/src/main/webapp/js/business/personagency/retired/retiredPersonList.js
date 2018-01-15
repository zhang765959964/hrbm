var dataJson = {};
$(function(){
	
	initDate();
	/**
	 初始化表格显示
	*/
	var columns= [		
		          	   {name:'id',lable:'id',hidden:true,frozen : true,label:'id'},
	              	   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
	              	   {name:'retiredPeopleNo',label:'个人编号',align:'center',frozen : true},
	                   {name:'xh',label:'序号',align:'center',frozen : true},
	                   {name:'personName',label:'姓名',align:'center',frozen : true},
	                   {name:'retiredPeopleBm',label:'退休个人编码',align:'center'},
	                   {name:'sex',label:'性别',align:'center'},
	                   {name:'personCsrq',label:'出生日期',align:'center'},
	                   {name:'retiredStatus',label:'是否正式退休',align:'center' },
	                   {name:'statusName',label:'退休申报状态',align:'center'},
	                   {name:'retiredArea',label:'退休人员所属区域',align:'center'},
	                   {name:'phone',label:'联系电话',align:'center'},
	                   {name:'mobilePhone',label:'手机号',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'workJobDate',label:'参加工作时间',align:'center'},
	                   {name:'rgName',label:'符合离退休规定条款',align:'center'},
	                   {name:'payDate',label:'缴费年月',align:'center'},
	                   {name:'retiredDate',label:'应退休时间',align:'center'},
	                   {name:'declareNote',label:'申报备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'},
	                   {name:'createrOgnName',label:'经办机构',align:'center'}
	              
      	        	];
	$("#retiredPersonList").jqGrid({
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
           rownumbers : true,
           shrinkToFit: false,
           multiselect:true,
           autowidth: true
        
       });
		initDataExp();
		
//	$(".highSearch").click(function(){
//		$(".highCondition").toggle();
//	});
	
	 $("#retiredPersonList").jqGrid('setFrozenColumns');
})


function initDate(){
	
		 $("#beginretiredDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput :false,
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
	      });
		 
		 
		 $("#endretiredDate").xfdaterangepicker({singleDatePicker:true,
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


function addRetiredPerson(){	
		xfui.open_dialog({    
		    title: '新增RSDA_BS_RETIRED_PERSON',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/retired/person/add.xf",
		    modal: true   
		})
}
function editRetiredPerson(){
	//var row = $('#retiredPersonList').bootstrapTable('getAllSelections');
	var id=$("#retiredPersonList").jqGrid("getGridParam","selrow");
	if(id){
		var id=id;
		xfui.open_dialog({    
	  		    title: '编辑RSDA_BS_RETIRED_PERSON',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/retired/person/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delRetiredPerson(){

	var ids=$("#retiredPersonList").jqGrid("getGridParam","selarrrow");
	if(ids&&ids.length>0){
		var id="";
		$.each(ids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/retired/person/del.xf',
		    		data:{id:id},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				bootbox.alert(data.message); 	
		    			}else{
		    				bootbox.alert("未知错误"); 
		    			}
		    			
		    			refresh();
		             }
		    	});
		    }    
		}}); 
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 
function refresh(){
	$("#retiredPersonList").trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retiredPersonList").jqGrid("clearGridData");	
	$("#retiredPersonList").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/retired/person/listJson.xf',postData:json}).trigger("reloadGrid");
}


//批量确定退休
function review (retiredStatus,retiredDeclareStatus){
	var rowids=$("#retiredPersonList").jqGrid("getGridParam","selarrrow");
	 if(rowids&&rowids.length>0){
		var id="";
		$.each(rowids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
			
		});
		$.ajax({ url: CTX+'/business/personagency/retired/declare/review.xf',
    		data:{id:id,retiredStatus:retiredStatus,retiredDeclareStatus:retiredDeclareStatus},
    		dataType:'json',
    		success: function(data){
    			if(data.message){
    				bootbox.alert(data.message); 	
    				refresh();
    			}else{
    				bootbox.alert("未知错误"); 
    			}
             }
    	});
	  }else{
		 bootbox.alert('请选择记录');
	 }			

}

//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredPersonList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'退休人员登记',
		sheetName:'退休人员登记',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
					 dataJson.level  = 0;
					 var id = $("#retiredPersonList").jqGrid("getDataIDs");	  
					 if(id&&id.length>0){
						 return dataJson;
					 }else{
						 bootbox.alert("无可导出的数据！");
		        		 return false;
					 }
			         
		           }},
		         /* {title:"导出选中的数据",paramCallBack:function(){			        	   
		        	  	var ids=$("#retiredPersonList").jqGrid("getGridParam","selarrrow");
		        		if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        			});
		        			 return {level:'0',id:id};
		        		}else{
		        			bootbox.alert("请勾选要选中的记录！");
		        			return false;
		        		}			        		
		        		
	  					}
			        },*/
			        {title:"导出当前页数据",paramCallBack:function(){
			        	var ids = $("#retiredPersonList").jqGrid("getDataIDs");	        		
			        	if(ids&&ids.length>0){
		        			var id="";
		        			$.each(ids,function(i,e){
		        				if(i==0){
		        					id+="'"+e+"'";
		        				}else{
		        					id+=","+"'"+e+"'";
		        				}
		        				
		        			});
		        			return {level:'0',id:id};
		        		}else{
		        			bootbox.alert("请选择记录！");
		        			return false;
		        		}			        		
		        	      
		  				 }
				     }
		          ]
		
	});
}


function retiredStatus(cellvalue, options, rowObject){
	if(cellvalue==0){
		return "否";
	}else{
		return "是";
	}
}