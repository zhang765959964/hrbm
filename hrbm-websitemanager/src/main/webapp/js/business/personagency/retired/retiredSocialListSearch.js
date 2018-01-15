var dataJson = {};
$(function(){
	
	initDate();
	/**
	 * 初始化表格显示
	 **/
	var columns= [
	              {name:'ID',lable:'id',hidden:true,frozen : true,key:true},
	              {name:'PERSONNAME',label:'姓名',align:'center',frozen : true},
             	  {name:'ARCHIVECODE',label:'档案编号',align:'center',frozen : true},
                  {name:'XH',label:'序号',align:'center',frozen : true},
                  {name:'RETIREDPEOPLEBM',label:'退休个人编码',align:'center'},
                  {name:'sexName',label:'性别',align:'center' },
               	  {name:'PERSONCARD',label:'身份证号',align:'center'},
                  {name:'RETIREDPEOPLENO',label:'个人编号',align:'center'},
                  {name:'PERSONCSRQ',label:'出生日期',align:'center'},
                  {name:'NATIONNAME',label:'民族',align:'center'},
                  {name:'RETIREDAREA',label:'退休人员所属区域',align:'center'},
                  {name:'WORKJOBDATE',label:'参加工作时间',align:'center'},
                  {name:'PHONE',label:'联系电话',align:'center'},
                  {name:'MOBILEPHONE',label:'手机号',align:'center'},
                  {name:'RETIREDSTATUSNAME',label:'是否正式退休',align:'center' },
             	 {name:'ISRETIREDSOCIALNAME',label:'是否转社会化',align:'center'},
               	 {name:'RETIREDDATE',label:'应退休时间',align:'center'},
               	 {name:'RETIREDSOCIALNO',label:'转社会化协议编号',align:'center'},
               	 {name:'RETIREDSOCIALDATE',label:'转社会化协议日期',align:'center'},
               	 {name:'RETIREDSOCIALNAME',label:'对方经办人',align:'center'},
               	 {name:'RETIREDSOCIALUNIT',label:'转入单位',align:'center'},
               	 {name:'OLDUNITNAME',label:'原单位名称',align:'center'},
               	 {name:'RETIREDCREATERNAME',label:'经办人',align:'center'},
               	 {name:'RETIREDCREATERDATE',label:'经办日期',align:'center'},
               	 {name:'RETIREDCREATEROGNNAME',label:'经办机构',align:'center'},
               	 {name:'SOCIALCREATERNAME',label:'转社会化经办人',align:'center'},
               	 {name:'SOCIALCREATERDATE',label:'转社会化经办日期',align:'center'},
               	 {name:'SOCIALCREATEROGNNAME',label:'转社会化经办机构',align:'center'},
               	 {name:'RGNAME',label:'符合离退休规定条款',align:'center'}
                  
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
	initDataExp();
//	$(".highSearch").click(function(){
//		$(".highCondition").toggle();
//	});
    

    
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
	 
	 $("#beginretiredSocialDate").xfdaterangepicker({singleDatePicker:true,
		  autoUpdateInput :false,
		  "opens":"right",
		  "drops": "down",
		  "locale": {
            "format": "YYYY-MM-DD"
          }
    });
	 
	 $("#endretiredSocialDate").xfdaterangepicker({singleDatePicker:true,
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

//清除form表单
function clearForm(){
	resetForm("searchForm");
	$("#retiredStatus").val(1);	
	
}


function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retiredSocialList").jqGrid("clearGridData");
	$("#retiredSocialList").jqGrid("setGridParam",{ datatype:"json",url:CTX+'/business/personagency/retired/social/retiredSocialListJson.xf',postData:json}).trigger("reloadGrid");
}


//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredSocialList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'退休转社会化查询',
		sheetName:'退休转社会化查询',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#retiredSocialList").jqGrid("getDataIDs");	   
			 dataJson.level = '5';
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
        			return {level:'5',id:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}

