$(function(){
	xfui.initUi();
	initDataExpMoveOut();
	initDataExpReturn();
})
function initTransferTable() {
	var columns2 = [
	                   {name:'id',label:'档案id',align:'center',hidden:true},
	                   {name:'archiveCode',label:'档案编号',align:'center',frozen : true},
                 	   {name:'aac003',label:'姓名',align:'center',frozen : true},
                 	   {name:'aac002',label:'身份证号',align:'center',frozen : true},
	                   {name:'residenceNumber',label:'户口编号',align:'center'},
	                   {name:'residenceStatusName',label:'户口状态',align:'center'},
	                   {name:'moveDate',label:'迁入日期',align:'center'},
	                   {name:'outDate',label:'迁出日期',align:'center'},
	                   {name:'settleDepartment',label:'落户地户籍部门',align:'center'},
	                   {name:'originalDomicile',label:'原户籍所在地',align:'center'},
	                   {name:'settleAddress',label:'落户地址',align:'center'},
	                   {name:'openDate',label:'开具日期',align:'center'},
	                   {name:'thoseGraduates',label:'毕业生届期',align:'center'},
	                   {name:'moveToAddress',label:'迁往地址',align:'center'},
	                   {name:'description',label:'备注',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	                   
 	        	];
		$("#residenceMoveOutList").jqGrid({
          mtype: "GET",
		  styleUI : 'Bootstrap',
          datatype: "local",
          colModel: columns2,
		  viewrecords: true,
          rowNum: 10,
          rowList:[10,20,30],
          pager: "#jqGridPager2",
          pagerpos:'left',
          regional : 'cn',
          recordpos:'right',
          shrinkToFit: false,
          multiselect:true,
          autowidth: true,
          height:'100%',
          onSelectRow:function(rowId){
	    	  var rowData=$(this).jqGrid("getRowData",rowId);
	    	  $('#residenceReturnList').jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/residence/residenceReturn/listJson.xf?moId='+rowData.id}).trigger("reloadGrid");
	      }
      });
		$("#residenceMoveOutList").jqGrid('setFrozenColumns');
	}

	function initResidenceReturnTable() {
		var columns3= [
	                 
	                   {name:'borrowerName',label:'借用人姓名',align:'center',frozen : true},
	                   {name:'borrowerCard',label:'借用人身份证号',align:'center',frozen : true},
	                   {name:'borrowerPhone',label:'借用人联系电话',align:'center',frozen : true},
	                   {name:'borrowerDate',label:'借用日期',align:'center'},
	                   {name:'maturityDate',label:'到期日期',align:'center'},
	                   {name:'returnDate',label:'归还日期',align:'center'},
	                   {name:'createrName',label:'经办人',align:'center'},
	                   {name:'createrOrgName',label:'经办机构',align:'center'},
	                   {name:'createrDate',label:'经办日期',align:'center'}
	 	        	];
		$("#residenceReturnList").jqGrid({
	          mtype: "GET",
			  styleUI : 'Bootstrap',
	          datatype: "local",
	          colModel: columns3,
			  viewrecords: true,
	          rowNum: 10,
	          rowList:[10,20,30],
	          pager: "#jqGridPager3",
	          pagerpos:'left',
	          regional : 'cn',
	          recordpos:'right',
	          shrinkToFit: false,
	          multiselect:true,
	          autowidth: true,
	          height:'100%'
	      });
	}
	
	function doSearch(){
		var json=$("#searchForm").serializeJson();
		$("#residenceMoveOutList").jqGrid("clearGridData");	
		$("#residenceMoveOutList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/residence/residenceMoveOut/listJson.xf',postData:json}).trigger("reloadGrid");
		$("#residenceReturnList").jqGrid("clearGridData");	
		$("#residenceReturnList").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/residence/residenceReturn/listJson.xf',postData:json}).trigger("reloadGrid");
		$("#searchTotal").load(CTX+"/business/personagency/residence/total/searchResidenceCount.xf");
	}
	//户口迁入迁移导出
	function initDataExpMoveOut(){
		$('#expMoveOut').dataexp({
			gridId:"residenceMoveOutList",
			serviceId:'archivesExpServiceImpl',
			fileName:'户口迁入迁移信息',
			sheetName:'户口迁入迁移信息',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#residenceMoveOutList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								return {menuNumber:'moveOut',ids:ids};
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#residenceMoveOutList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'moveOut',ids:ids};
					      	    }else{
						      		bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}
	//户口借用归还导出
	function initDataExpReturn(){
		$('#expReturn').dataexp({
			gridId:"residenceReturnList",
			serviceId:'archivesExpServiceImpl',
			fileName:'户口借用归还信息',
			sheetName:'户口借用归还信息',
			menuItem:[{title:"导出全部数据",paramCallBack:function(){
							var ids=$("#residenceReturnList").jqGrid("getDataIDs");
							if(ids&&ids.length>0){
								return {menuNumber:'return',ids:ids};
							}else{
								bootbox.alert('无可导出的数据！');
								return false;
							}
			           }},
				        {title:"导出当前页数据",paramCallBack:function(){
				        		var ids=$("#residenceReturnList").jqGrid("getDataIDs");
				      		    if(ids&&ids.length>0){
						      		return {menuNumber:'return',ids:ids};
					      	    }else{
						      		bootbox.alert('请选择记录');
						      		return false;
					      	    }	
			  				}
					    }
			     ]
			
		});
	}