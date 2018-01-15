var dataJson = {};
$(function(){
	initl();
	xfui.initUi();
	initDataExp();
})


function initl(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'careDeclareName',label:'是否可申报大病医保',align:'center'},
	                   {name:'AAC003',label:'姓名',align:'center',formatter:function(cellvalue, options, rowObject){
	                	     return "<a style=\"color:#337ab7;\" href='javascript:editRetiredCare("+rowObject.AAC001+")' >"+cellvalue+"</a>";
	                      }
						},
	                   {name:'SEX',label:'性别',align:'center'},
	                   {name:'AAC006',label:'出生日期',align:'center'},
	                   {name:'nationName',label:'民族',align:'center'},
	                   {name:'AAC002',label:'身份证号',align:'center'},
	                   {name:'createWorkDate',label:'参加工作时间',align:'center'},
	                   {name:'AAE005',label:'手机号',align:'center'},
	                   {name:'expPersonPhone',label:'联系电话',align:'center'},
	                   {name:'retiredDate',label:'退休时间',align:'center'},
	                   {name:'retiredPeopleNo',label:'个人编号',align:'center'},
	                   {name:'retiredPeopleBm',label:'退休个人编码',align:'center'},
	                   {name:'archiveCode',label:'档案编号',align:'center'},
	                   {name:'workResume',label:'工作简历',align:'center'},
	                   {name:'ADDRE',label:'大病医保所在区域',align:'center'},
	                   {name:'firstFillDate',label:'初次填报日期',align:'center'},
	                   {name:'fillDate',label:'填报日期',align:'center'},
	                   {name:'declareName',label:'是否已申报',align:'center'},
	                   {name:'flagName',label:'是否通过',align:'center'},
	                   {name:'REASON',label:'原因',align:'center'},
	                   {name:'NOTE',label:'备注',align:'center'},
	                   {name:'retiredCreaterName',label:'退休经办人',align:'center'},
	                   {name:'retiredCreaterDate',label:'退休经办日期',align:'center'},
	                   {name:'retiredCreaterOrgName',label:'退休经办机构',align:'center'},
	                   {name:'careCreaterName',label:'大病医保经办人',align:'center'},
	                   {name:'careCreaterDate',label:'大病医保经办日期',align:'center'},
	                   {name:'careCreaterOrgName',label:'大病医保经办机构',align:'center'},    
	                   {name:'AAC001',label:'人员id',hidden:true,width:100 },
	                   {name:'id',label:'主键',hidden:true,width:100,key:true }
     	        	];
	$("#retiredCareList").jqGrid({
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
	
	
}


function addRetiredCare(){	
		xfui.open_dialog({    
		    title: '新增退休人员大病医保表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/business/personagency/retired/care/add.xf",
		    modal: true   
		})
}

function editRetiredCare(id){
		xfui.open_dialog({    
	  		    title: '大病医保信息',    
	  		    width: 1000,    
	  		    height: 600,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: CTX+"/business/personagency/retired/care/edit.xf?personId="+id,
	  		    modal: true   
	  		})
} 

function delRetiredCare(){
	var rowids=$("#retiredCareList").jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var id="";
		$.each(rowids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/retired/care/del.xf',
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
	$("#retiredCareList").trigger("reloadGrid");
}


//清除记录
function clearForm(){
	bootbox.confirm({message:'是否清空列表?',callback:function(r){    
		if(r){
			$("#retiredCareList").jqGrid("clearGridData");
		}
		
	}}); 
	
}

//删除列表
function delSearch(){
	var ids=$("#retiredCareList").jqGrid("getGridParam","selarrrow");
	var str = new Array();
	if(ids&&ids.length>0){
		$.each(ids,function(i,e){
			str.push(e)
		});
		for(var i=0;i<str.length;i++){
			$("#retiredCareList").jqGrid("delRowData",str[i]);
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }	
}


//添加列表
function addSearch(){
	var archiveCode = $("#archiveCode").val();
	var personCard = $("#personCard").val();
	if(archiveCode==''&&personCard==''){
		bootbox.alert("请填写查询条件！");
	}else{
		$.ajax({
			type: "post",
			url:CTX+'/business/personagency/retired/care/listJson.xf',
			data:{personCard:personCard,archiveCode:archiveCode},
			cache:false,  
			success :function (data){
				if(data.rows.length>0){
					$.each(data.rows,function(i,e){
						var flag =  verifyExist("retiredCareList","id",e.id);
								if(flag){
									bootbox.alert("表格中已经存在！");
								}else{
									 $("#retiredCareList").jqGrid("addRowData",e.id,e, "first");  
						}
					})
				}else{
					bootbox.alert("没有查询到记录！");
				}
			}
		})
	}
}

function doSearch(){
	$("#retiredCareList").jqGrid("clearGridData");
	var json=$("#searchForm").serializeJson();
	dataJson = json;
	$("#retiredCareList").jqGrid("setGridParam",{url:CTX+'/business/personagency/retired/care/listJson.xf',datatype:'json',postData:json}).trigger("reloadGrid");
}


//导出
function initDataExp(){
	$('#exp').dataexp({
		gridId:"retiredCareList",
		serviceId:'retiredDeclareExpServiceImpl',
		fileName:'退休人员大病医保',
		sheetName:'退休人员大病医保',
		menuItem:[{title:"导出全部数据",paramCallBack:function(){
			 var id = $("#retiredCareList").jqGrid("getDataIDs");	   
			 dataJson.level = '7';
			 if(id&&id.length>0){
				 return dataJson;
			 }else{
				 bootbox.alert("无可导出的数据！");
    			 return false;
			 }
			 
           }},
          /* {title:"导出选中的数据",paramCallBack:function(){			        	   
        	  	var ids=$("#retiredCareList").jqGrid("getGridParam","selarrrow");
        		if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        			});
        			 return {level:'7',id:id};
        		}else{
        			bootbox.alert("请勾选要选中的记录！");
        			return false;
        		}			        		
        		
					}
	        },*/
	        {title:"导出当前页数据",paramCallBack:function(){
	        	var ids = $("#retiredCareList").jqGrid("getDataIDs");	        		
	        	if(ids&&ids.length>0){
        			var id="";
        			$.each(ids,function(i,e){
        				if(i==0){
        					id+="'"+e+"'";
        				}else{
        					id+=","+"'"+e+"'";
        				}
        				
        			});
        			return {level:'7',id:id};
        		}else{
        			bootbox.alert("请选择记录！");
        			return false;
        		}			        		
        	      
  				 }
		     }
          ]
		
	});
}

