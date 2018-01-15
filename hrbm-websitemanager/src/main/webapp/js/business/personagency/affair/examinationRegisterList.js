var dataJson={};
$(function(){
	initDataExp();
})
$(function(){
		var columns= [
		                   {name:'aac003',label:'姓名',align:'center',frozen : true},
					       {name:'aac002',label:'公民身份号码',align:'center',frozen : true},
					       {name:'genderName',label:'性别',align:'center',frozen : true},
		                   {name:'contactNumber',label:'联系电话',align:'center'},
		                   {name:'workUnit',label:'工作单位',align:'center'},
		                   {name:'workingAge',label:'工作年龄',align:'center'},
		                   {name:'examinationTypeName',label:'考试类别',align:'center'},
		                   {name:'examinationMxTypeName',label:'考试明细',align:'center'},
		                   {name:'examinationLevelName',label:'考试级别',align:'center'},
		                   {name:'examinationChengji',label:'考试成绩',align:'center'},
		                   {name:'evaluationResultName',label:'评定结果',align:'center'},
		                   {name:'isLingExaminationName',label:'是否领取成绩单',align:'center'},
		                   {name:'isLingZhengshuName',label:'是否领取证书',align:'center'},
		                   {name:'createrName',label:'经办人姓名',align:'center'},
		                   {name:'createrOrgName',label:'经办机构',align:'center'},
		                   {name:'createrDate',label:'经办日期',align:'center'}
		                
	      	        	];
		$("#examinationRegisterList").jqGrid({
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
		$("#examinationRegisterList").jqGrid('setFrozenColumns'); 
	})

	function addExaminationRegister(){	
		var rowId=$("#examinationArchivesList").jqGrid("getGridParam","selrow");
		var rowData=$("#examinationArchivesList").jqGrid("getRowData",rowId);
		var id = rowData.ID;
		if(rowId){
			xfui.open_dialog({    
			    title: '添加考试报名登记信息',    
			    width: 950,    
			    height: 500,    
			    closed: false,    
			    cache: false,    
			    url: CTX+"/business/personagency/affair/examinationRegister/add.xf?archivesId="+id,
			    modal: true   
			})
		}else{
			bootbox.alert('请选择档案信息记录');
		}	
	}
	function editExaminationRegister(){
		var id=$("#examinationRegisterList").jqGrid("getGridParam","selrow");
		if(id){
			var id=id;
			xfui.open_dialog({    
		  		    title: '修改考试报名登记信息',    
		  		    width: 950,    
		  		    height: 500,    
		  		    closed: false,    
		  		    cache: false,    
		  		    url: CTX+"/business/personagency/affair/examinationRegister/edit.xf?id="+id,
		  		    modal: true   
		  		})
		}else{
			bootbox.alert('请选择要修改的考试报名信息记录');
		}			
	} 

	function delExaminationRegister(){
		var ids=$("#examinationRegisterList").jqGrid("getGridParam","selarrrow");
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
			    	$.ajax({ url: CTX+'/business/personagency/affair/examinationRegister/del.xf',
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
			 bootbox.alert('请选择要删除的考试报名信息记录');
		 }			
	} 
	function refresh(){
		$("#examinationRegisterList").trigger("reloadGrid");
	}
	
	//导出
	function initDataExp(){
		$('#exp').dataexp({
			gridId:"examinationRegisterList",
			serviceId:'archivesExpServiceImpl',
			fileName:'考试报名登记',
			sheetName:'考试报名登记',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#examinationRegisterList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								dataJson.menuNumber='9';
								return dataJson;
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#examinationRegisterList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'9',ids:ids};
					      	    }else{
						      		bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}