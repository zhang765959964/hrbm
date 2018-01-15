	//新增社保变更信息
	function addChangeReporting(id,archiveFlowStatus){
		if(id>0){
			if(archiveFlowStatus==1){
				bootbox.alert('当前档案状态【借阅登记】！不能操作！');
			}else if(archiveFlowStatus==2){
				bootbox.alert('当前档案状态【借阅确认】！不能操作！');
			}else if(archiveFlowStatus==5){
				bootbox.alert('当前档案状态【调出登记】！不能操作！');
			}else{
				xfui.open_dialog({    
					title: '灵活就业人员基本养老保险变更申报',    
					width: 1000,    
					height: 650,    
					closed: false,    
					cache: false,    
					url: CTX+"/business/personagency/social/changeReporting/add.xf?archivesId="+id,
					modal: true   
				})
			}
		}else{
			bootbox.alert('请先选择档案信息！');
		}
	}	
	
	//编辑社保变更信息
	function editChangeReporting(){
		var id=$("#changeReportingList").jqGrid("getGridParam","selrow");
		var rowData = $("#changeReportingList").jqGrid('getRowData',id);
		var isEffective = rowData.isEffective;
		if(id){
			if(isEffective==0){
				var id=id;
				xfui.open_dialog({    
			  		    title: '修改灵活就业人员基本养老保险变更申报',    
			  		    width: 1000,    
			  		    height: 650,    
			  		    closed: false,    
			  		    cache: false,    
			  		    url: CTX+"/business/personagency/social/changeReporting/edit.xf?id="+id,
			  		    modal: true   
			  	})
			}else{
				bootbox.alert('当前数据为无效数据，不能修改！');
			}
		}else{
			bootbox.alert('请先选择档案信息！');
		}			
	} 
	
	//查看社保变更信息
	function lookChangeReporting(){
		var id=$("#changeReportingList").jqGrid("getGridParam","selrow");
		if(id){
			var id=id;
			xfui.open_dialog({    
		  		    title: '查看灵活就业人员基本养老保险变更申报',    
		  		    width: 950,    
		  		    height: 650,    
		  		    closed: false,    
		  		    cache: false,    
		  		    url: CTX+"/business/personagency/social/changeReporting/look.xf?id="+id,
		  		    modal: true   
		  		})
		}else{
			bootbox.alert('请先选择档案信息！');
		}			
	} 
	
	//新增统筹范围内转移
	function addSocialsecTransfer(id,archiveFlowStatus){	
		if(id>0){
			if(archiveFlowStatus==1){
				bootbox.alert('当前档案状态【借阅登记】！不能操作！');
			}else if(archiveFlowStatus==2){
				bootbox.alert('当前档案状态【借阅确认】！不能操作！');
			}else if(archiveFlowStatus==5){
				bootbox.alert('当前档案状态【调出登记】！不能操作！');
			}else{
				xfui.open_dialog({    
				    title: '灵活就业参保人员统筹范围内转移',    
				    width: 1000,    
				    height: 650,    
				    closed: false,    
				    cache: false,    
				    url: CTX+"/business/personagency/social/socialsecTransfer/add.xf?archivesId="+id,
				    modal: true   
				})
			}
		}else{
			bootbox.alert('请先选择档案信息！');
		}
	}
	//修改统筹范围内转移
	function editSocialsecTransfer(){
		var id=$("#socialsecTransferList").jqGrid("getGridParam","selrow");
		var rowData = $("#socialsecTransferList").jqGrid('getRowData',id);
		var isEffective = rowData.isEffective;
		if(id){
			if(isEffective==0){
				var id=id;
				xfui.open_dialog({    
			  		    title: '修改灵活就业参保人员统筹范围内转移',    
			  		    width: 1000,    
			  		    height: 650,    
			  		    closed: false,    
			  		    cache: false,    
			  		    url: CTX+"/business/personagency/social/socialsecTransfer/edit.xf?id="+id,
			  		    modal: true   
			  	})
			}else{
				bootbox.alert('当前数据为无效数据，不能修改！');
			}
		}else{
			bootbox.alert('请先选择档案信息！');
		}			
	} 
	//查看统筹范围内转移
	function lookSocialsecTransfer(){
		var id=$("#socialsecTransferList").jqGrid("getGridParam","selrow");
		if(id){
			var id=id;
			xfui.open_dialog({    
		  		    title: '查看灵活就业人员基本养老保险变更申报',    
		  		    width: 950,    
		  		    height: 650,    
		  		    closed: false,    
		  		    cache: false,    
		  		    url: CTX+"/business/personagency/social/socialsecTransfer/look.xf?id="+id,
		  		    modal: true   
		  		})
		}else{
			bootbox.alert('请先选择档案信息！');
		}			
	} 
	
	function refresh(){
		$("#changeReportingList").trigger("reloadGrid");
	}
	function refresh2(){
		$("#socialsecTransferList").trigger("reloadGrid");
	}
	function printChangeReporting(){
		var ids=$("#changeReportingList").jqGrid("getGridParam","selrow");
		if(ids&&ids.length>0){
			var param = {"id":ids,"type":1};
			templatePrint("changeReporting",param);
		}else{
			bootbox.alert('请选择记录');
		}
	}