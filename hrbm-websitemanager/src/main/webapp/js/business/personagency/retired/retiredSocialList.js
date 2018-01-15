var dataJson = {};
$(function(){
	$("#retiredSocial").load(CTX+"/business/personagency/retired/social/getRetiredById.xf");
	/**
	  * 初始化表格显示
	  *
	 **/
	var columns= [
	              {name:'id',lable:'id',hidden:true,frozen : true},
	              {name:'personName',label:'姓名',align:'center',frozen : true},
             	  {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
             	  {name:'retiredPeopleNo',label:'个人编号',align:'center',frozen : true},
                  {name:'xh',label:'序号',align:'center'},
                  {name:'retiredPeopleBm',label:'退休个人编码',align:'center'},
                  {name:'personCard',label:'身份证号',align:'center'},
                  {name:'sex',label:'性别',align:'center'},
                  {name:'personCsrq',label:'出生日期',align:'center'},
                  {name:'retiredStatus',label:'是否正式退休',align:'center' },
               	 {name:'isRetiredSocial',label:'是否转社会化',align:'center'  },
                  {name:'statusName',label:'退休申报状态',align:'center'},
                  {name:'retiredArea',label:'退休人员所属区域',align:'center'},
                  {name:'phone',label:'联系电话',align:'center'},
                  {name:'mobilePhone',label:'手机号',align:'center'},
                  {name:'nationName',label:'民族',align:'center'},
                  {name:'workJobDate',label:'参加工作时间',align:'center'},
                  {name:'retiredDate',label:'应退休时间',align:'center'},
                  {name:'retiredSocialNo',label:'转社会化协议编号 ',align:'center'},
                  {name:'retiredSocialDate',label:'转社会化协议日期 ',align:'center'},
                  {name:'retiredSocialName',label:'对方经办人',align:'center'},
                  {name:'retiredSocialUnit',label:'转入单位',align:'center'},
                  {name:'oldUnitName',label:'原单位名称',align:'center'},
                  {name:'createrName',label:'经办人',align:'center'},
                  {name:'createrDate',label:'经办日期',align:'center'},
                  {name:'createrOgnName',label:'经办机构',align:'center'}
      	        	];
	$("#retiredSocialList").jqGrid({
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
           autowidth: true
       });
	
    $("#retiredSocialList").jqGrid('setFrozenColumns');
    initDate();
    initDataExp();
    
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
	
	$("#endretiredDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
          "locale": {
          "format": "YYYY-MM-DD"
      }
 });

	
}



//重置表单
function clearForm(){
	resetForm("searchForm");
	$("#retiredStatus").val(1);
}


function editRetiredSocial(){
	//var row = $('#retiredSocialList').bootstrapTable('getAllSelections');
	var id=$("#retiredSocialList").jqGrid("getGridParam","selrow");
	if(id){
		var id=id;
		xfui.open_dialog({    
	  		    title: '编辑退休人员转社会化',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/retired/social/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delRetiredSocial(){

	var ids=$("#retiredSocialList").jqGrid("getGridParam","selarrrow");
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
		    	$.ajax({ url: CTX+'/business/personagency/retired/social/del.xf',
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
	$("#retiredSocialList").trigger("reloadGrid");
}
function doSearch(){
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retiredSocialList").jqGrid("clearGridData");
	$("#retiredSocial").load(CTX+"/business/personagency/retired/social/getRetiredById.xf");
	$("#retiredSocialList").jqGrid("setGridParam",{datatype:"json",url:CTX+'/business/personagency/retired/social/retiredSocialList.xf',postData:json}).trigger("reloadGrid");
}



//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredSocialList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'退休人员转社会化',
		sheetName:'退休人员转社会化',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#retiredSocialList").jqGrid("getDataIDs");	   
			 dataJson.level = '4';
			 if(id&&id.length>0){
				 return dataJson;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
         /*  {title:"导出选中的数据",paramCallBack:function(){			        	   
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
        			 return {level:'4',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#retiredSocialList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'4',id:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}

