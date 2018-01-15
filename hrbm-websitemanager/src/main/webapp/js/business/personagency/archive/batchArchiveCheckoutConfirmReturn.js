	$(function() {
		initTable2();
	});
	function initTable2() {
		var columns= [
		               {name:'batchName',label:'批次名',align:'center',frozen : true},
	                   {name:'aac002',label:'身份证号',align:'center',frozen : true},
	                   {name:'aac003',label:'姓名',align:'center',frozen : true},
	                   {name:'genderName',label:'性别',align:'center'},
	                   {name:'archiveCode',label:'档案编号',align:'center'},
	                   {name:'checkoutStatusName',label:'借阅状态',align:'center'},
	                   {name:'checkoutPerson',label:'借阅人',align:'center'},
	                   {name:'checkoutPersonPhone',label:'借阅人电话',align:'center'},
	                   {name:'checkoutDate',label:'借阅日期',align:'center'},
	                   {name:'checkoutPeriodDate',label:'到期时间',align:'center'},
	                   {name:'checkoutCorp',label:'借阅单位',align:'center'},
	                   {name:'receiveDate',label:'档案转入日期',align:'center'},
	                   {name:'marketPositionName',label:'市场位置',align:'center'},
	                   {name:'cabinetsLibrary',label:'区',align:'center'},
	                   {name:'cabinetsCode',label:'柜',align:'center'},
	                   {name:'cabinetsLayer',label:'排',align:'center'},
	                   {name:'cabinetsLattice',label:'列',align:'center'},
	                   {name:'expEntrustCompany',label:'所属单位名称',align:'center'},
	                   {name:'archiveName',label:'档案姓名',align:'center'},
	                   {name:'archiveBirthDate',label:'档案出生日期',align:'center'},
	                   {name:'archiveStatusName',label:'档案状态',align:'center'},
	                   {name:'archiveTypeName',label:'存档类型',align:'center'},
	                   {name:'archiveReceiveName',label:'窗口经办人',align:'center'},
	                   {name:'archiveReceiveDate',label:'窗口经办日期',align:'center'},
	                   {name:'archiveReceiveOrgName',label:'窗口经办机构',align:'center'},
	                   {name:'id',label:'',hidden:true,key:true}

      	        	];

		$("#archiveConfirmTwo").jqGrid({
			url:CTX+'/business/personagency/archive/archiveCheckout/listJson.xf?checkoutStatus=3',
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "json",
	        colModel: columns,
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
	        altRows:true,
	        height:'100%'
	    });
		$("#archiveConfirmTwo").jqGrid('setFrozenColumns');
	}
	//刷新
	function refresh2(){
		//$("#archiveConfirmTwo").trigger("reloadGrid");
		$("#batchArchivesReturnEdu").load(CTX+"/business/personagency/batch/archiveCheckout/confirmTwo.xf");
	}
	//查询
	function doSearch2(){
		var json=$("#searchForm2").serializeJson();
		$("#archiveConfirmTwo").jqGrid("clearGridData");
		$("#archiveConfirmTwo").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
	}
	//批量归还确认
	function batchReturnComfirm(){
		var ids=$("#archiveConfirmTwo").jqGrid("getGridParam","selarrrow");
		if(ids&&ids.length>0){
			var id="";
			$.each(ids,function(i,e){
				if(i==0){
					id+=e;
				}else{
					id+=","+e;
				}
			});
			bootbox.confirm({message:'您确认选中的数据要批量借阅确认吗？',callback:function(r){    
			    if (r){    
			    	$.ajax({ url: CTX+'/business/personagency/batch/archiveCheckout/batchReturnComfirm.xf',
			    		data:{id:id},
			    		dataType:'json',
			    		success: function(data){
			    			if(data.message){
			    				bootbox.alert(data.message); 	
			    			}else{
			    				bootbox.alert("未知错误"); 
			    			}
			    			refresh2();
			             }
			    	});
			    }    
			}}); 
		  }else{
			 bootbox.alert('请选择记录');
		 }	
	}
	//置顶
	function returnTop(){
		var rarchiveCode = $("#returnArchiveCode").val();
		var raac002 = $("#returnAac002").val();
		if(rarchiveCode==''&&raac002==''){
			bootbox.alert("请填写查询条件！");
		}else{
			$.ajax({
				type: "post",
				url:CTX+'/business/personagency/batch/archiveCheckout/operationTop.xf?checkoutStatus=3',
				data:{aac002:raac002,archiveCode:rarchiveCode},
				cache:false,  
				success :function (data){
					if(data.length>0){
						$.each(data,function(i,e){
							 $("#archiveConfirmTwo").jqGrid("delRowData",e.id);
							 $("#archiveConfirmTwo").jqGrid("addRowData",e.id,e, "first");  
							 $("#archiveConfirmTwo").jqGrid('setFrozenColumns'); 
							 $("#"+e.id).find("td").addClass("highBg");  
						})
					}else{
						bootbox.alert("没有查询到记录！");
					}
				}
			})
		}
	}
