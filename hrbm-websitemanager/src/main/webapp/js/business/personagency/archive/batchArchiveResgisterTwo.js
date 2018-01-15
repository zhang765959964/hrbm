	$(function() {
		initTable3();
	});
	function initTable3() {
		var columns= [
					   {name:'BATCHNAME',label:'批次名',align:'center',frozen : true},
	                   {name:'AAC002',label:'身份证号',align:'center',frozen : true},
	                   {name:'AAC003',label:'姓名',align:'center',frozen : true},
	                   {name:'GENDERNAME',label:'性别',align:'center'},
	                   {name:'ARCHIVECODE',label:'档案编号',align:'center'},
	                   {name:'RECEIVEDATE',label:'档案接收日期',align:'center'},
	                   {name:'MARKETPOSITIONNAME',label:'市场位置',align:'center'},
	                   {name:'CABINETSLIBRARY',label:'区',align:'center'},
	                   {name:'CABINETSCODE',label:'柜',align:'center'},
	                   {name:'CABINETSLAYER',label:'排',align:'center'},
	                   {name:'CABINETSLATTICE',label:'列',align:'center'},
	                   {name:'EXPENTRUSTCOMPANY',label:'所属单位名称',align:'center'},
	                   {name:'ARCHIVENAME',label:'档案姓名',align:'center'},
	                   {name:'ARCHIVEBIRTHDATE',label:'档案出生日期',align:'center'},
	                   {name:'ARCHIVESTATUSNAME',label:'档案状态',align:'center'},
	                   {name:'ARCHIVETYPENAME',label:'存档类型',align:'center'},
	                   {name:'ARCHIVERECEIVENAME',label:'窗口经办人',align:'center'},
	                   {name:'ARCHIVERECEIVEDATE',label:'窗口经办日期',align:'center'},
	                   {name:'ARCHIVERECEIVEORGNAME',label:'窗口经办机构',align:'center'},
	                   {name:'CHECKID',label:'',hidden:true,key:true}

      	        	];

		$("#archiveResgisterTwo").jqGrid({
	        mtype: "GET",
			styleUI : 'Bootstrap',
	        datatype: "local",
	        colModel: columns,
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
	        altRows:true,
	        height:'100%'
	    });
		$("#archiveResgisterTwo").jqGrid('setFrozenColumns');
	}
	
	function addSearch2(){
		var archiveCode = $("#archiveCodeTwo").val();
		var aac002 = $("#aac002Two").val();
		if(archiveCode==''&&aac002==''){
			bootbox.alert("请填写查询条件！");
		}else{
			$.ajax({
				type: "post",
				url:CTX+'/business/personagency/batch/archiveCheckout/searchListJson.xf',
				data:{taac002:aac002,tarchiveCode:archiveCode,archiveFlowStatusValue:2},
				cache:false,  
				success :function (data){
					if(data.length>0){
						$.each(data,function(i,e){
							 if(e.ARCHIVEFLOWSTATUS==2){
								 var flag =  verifyExist("archiveResgisterTwo","CHECKID",e.CHECKID);
								 if(flag){
									 bootbox.alert("表格中已经存在！");
								 }else{
									 var arr = $("#archiveResgisterTwo").jqGrid("getRowData");
									 $("#archiveResgisterTwo").jqGrid("addRowData",e.CHECKID,e, "first");  
									 var arrs =  $("#archiveResgisterTwo").jqGrid("getRowData");
								 }
							 }else{
								 bootbox.alert("当前档案状态是"+e.ARCHIVEFLOWSTATUSNAME+"，不可操作!");
							 }
						})
					}else{
						bootbox.alert("没有查询到记录！");
					}
				}
			})
		}
	}
//清空列表	
function clearJqGrid2(){
	 bootbox.confirm({message:'是否清空列表？',callback:function(r){
	    if(r){
	    	$("#archiveResgisterTwo").jqGrid("clearGridData");
	    }
	}});
}
//去除查询
function subtractSearch2(){
	var ids=$("#archiveResgisterTwo").jqGrid("getGridParam","selarrrow");
	var str = new Array();
	if(ids&&ids.length>0){
		$.each(ids,function(i,e){
			str.push(e)
		});
		for(var i=0;i<str.length;i++){
			$("#archiveResgisterTwo").jqGrid("delRowData",str[i]);
		}
	  }else{
		 bootbox.alert('请选择记录');
	 }			
} 
//批量归还登记
function batchReturnResgister(){
	var ids=$("#archiveResgisterTwo").jqGrid("getGridParam","selarrrow");
	if(ids&&ids.length>0){
		var id="";
		$.each(ids,function(i,e){
			if(i==0){
				id+=e;
			}else{
				id+=","+e;
			}
		});
		bootbox.confirm({message:'您确认选中的数据要批量归还登记吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: CTX+'/business/personagency/batch/archiveCheckout/batchReturnResgister.xf',
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

	function refresh2(){
		var batchNameId = $("#batchNameId").val();
		var json = { "batchName": batchNameId};
		$("#archiveResgisterTwo").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/batch/archiveCheckout/searchListJson.xf?archiveFlowStatusValue=2',postData:json}).trigger("reloadGrid");
	}
	//批次查询
	function batchSearch(){
		var batchNameId = $("#batchNameId").val();
		if(batchNameId==''){
			bootbox.alert("请选择批次！");
		}else{
			var json = { "batchName": batchNameId};
			$("#archiveResgisterTwo").jqGrid("setGridParam",{datatype: "json",url:CTX+'/business/personagency/batch/archiveCheckout/searchListJson.xf?archiveFlowStatusValue=2',postData:json}).trigger("reloadGrid");
		}
	}