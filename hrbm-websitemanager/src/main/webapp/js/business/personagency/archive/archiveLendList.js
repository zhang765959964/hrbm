$(function(){
	xfui.initUi();
	initDataExp();
})
$(function(){
		var columns= [
						   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
						   {name:'aac003',label:'姓名',align:'center',frozen : true},
						   {name:'aac002',label:'身份证号',align:'center',frozen : true},
						   {name:'genderName',label:'性别',align:'center'},
						   {name:'lendFlowStatusName',label:'调出状态',align:'center'},
						   {name:'archiveTypeName',label:'存档类型',align:'center'},
						   {name:'receiveDate',label:'档案转入日期',align:'center'},
						   {name:'archiveReceiveStatusName',label:'接收状态',align:'center'},
		                   {name:'marketPosition',label:'市场位置',align:'center'},
		                   {name:'cabinetsLibrary',label:'区',align:'center'},
		                   {name:'cabinetsCode',label:'柜',align:'center'},
		                   {name:'cabinetsLayer',label:'排',align:'center'},
		                   {name:'cabinetsLattice',label:'列',align:'center'},
		                   {name:'lendDate',label:'调出时间',align:'center'},
		                   {name:'lendName',label:'调出办理人',align:'center'},
		                   {name:'archivesLendWhere',label:'档案去向(单位)',align:'center'},
		                   {name:'lendReasonName',label:'调出原因',align:'center'},
		                   {name:'lendIdNumber',label:'调出办理人身份证号',align:'center'},
		                   {name:'lendPhone',label:'调出办理人联系电话',align:'center'},
		                   {name:'lendCreaterName',label:'调出登记经办人',align:'center'},
		                   {name:'lendCreaterDate',label:'调出登记经办时间',align:'center'},
		                   {name:'lendCreaterOrgName',label:'调出登记经办机构',align:'center'},
		                   {name:'lendConfirmName',label:'调出确认经办人',align:'center'},
		                   {name:'lendConfirmDate',label:'调出确认经办时间',align:'center'},
		                   {name:'lendConfirmOrgName',label:'调出确认经办机构',align:'center'},
		                   {name:'lendId',label:'',width:100,align:'center',hidden:true,key:true},
		                   {name:'lendFlowStatus',label:'',width:100,align:'center',hidden:true}
		                   
	      	        	];
		$("#archiveLendList").jqGrid({
			   //url:CTX+'/business/personagency/archive/archiveLend/listJson.xf?lendFlowStatus=4',
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
	           altRows:true,
	           height:'100%'
	       });
		
		$("#archiveLendList").jqGrid('setFrozenColumns');
	})

	function refresh(){
		$("#archiveLendList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archiveLend/listJson.xf?lendFlowStatus=4'}).trigger("reloadGrid");
	}
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		$("#archiveLendList").jqGrid("clearGridData");	
		$("#archiveLendList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/archive/archiveLend/listJson.xf?lendFlowStatus=4',postData:json}).trigger("reloadGrid");
	}
	
	//调出确认
	function lendComfirm(){
		var ids=$("#archiveLendList").jqGrid("getGridParam","selarrrow");
		if(ids&&ids.length>0){
			var lendId="";
			$.each(ids,function(i,e){
				if(i==0){
					lendId+=e;
				}else{
					lendId+=","+e;
				}
			});
			bootbox.confirm({message:'您确认想要调出确认吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/archive/archiveLend/lendComfirm.xf',
			    		data:{lendId:lendId},
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
	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"archiveLendList",
			serviceId:'archivesExpServiceImpl',
			fileName:'档案调出确认',
			sheetName:'档案调出确认',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#archiveLendList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								return {menuNumber:'d',lendIds:ids};
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#archiveLendList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'d',lendIds:ids};
					      	    }else{
						      		bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}