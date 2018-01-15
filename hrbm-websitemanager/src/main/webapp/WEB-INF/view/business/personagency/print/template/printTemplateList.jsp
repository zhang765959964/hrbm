<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>打印模版管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@include file="/commons/include/commonInc.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'fdModelName',label:'模版名称',align:'center'},
	                   {name:'fdModelAlias',label:'模版别名',align:'center'},                   
	                   {name:'fdModelService',label:'模版服务',align:'center'},
	                   {name:'fdCreaterName',label:'经办人',align:'center'},
	                   {name:'fdCreaterDate',label:'经办时间',align:'center'},
	                   {name:'fdCreaterOrgName',label:'经办机构',align:'center'},
	                {name:'pkId',label:'主键',hidden:true,width:100,key:true }
      	        	];
	$("#printTemplateList").jqGrid({
		   url:'${ctx}/business/personagency/print/printTemplate/listJson.xf?fkModelType=1',
           mtype: "GET",
		   styleUI : 'Bootstrap',
           datatype: "json",
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
	xfui.initUi();
})

function addPrintTemplate(){	
// 		xfui.open_dialog({    
// 		    title: '新增打印模版',    
// 		    width: 800,    
// 		    height: 500,    
// 		    closed: false,    
// 		    cache: false,    
// 		    url: "${ctx}/business/personagency/print/printTemplate/add.xf",
// 		    modal: true   
// 		})
		
		xfui.open_tabs("新增打印模版","${ctx}/business/personagency/print/printTemplate/add.xf");
}
function editPrintTemplate(){
	//var row = $('#printTemplateList').bootstrapTable('getAllSelections');
	var rowid=$("#printTemplateList").jqGrid("getGridParam","selrow");
	if(rowid){
		var pkId=rowid;
// 		xfui.open_dialog({    
// 	  		    title: '编辑打印模版',    
// 	  		    width: 800,    
// 	  		    height: 500,    
// 	  		    closed: false,    
// 	  		    cache: false,    
// 	  		    url: "${ctx}/business/personagency/print/printTemplate/edit.xf?pkId="+pkId,
// 	  		    modal: true   
// 	  		})
		xfui.open_tabs("编辑打印模版","${ctx}/business/personagency/print/printTemplate/edit.xf?pkId="+pkId);
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delPrintTemplate(){

	var rowids=$("#printTemplateList").jqGrid("getGridParam","selarrrow");
	if(rowids&&rowids.length>0){
		var pkId="";
		$.each(rowids,function(i,e){
			if(i==0){
				pkId+=e;
			}else{
				pkId+=","+e;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/personagency/print/printTemplate/del.xf',
		    		data:{pkId:pkId},
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
	$("#printTemplateList").trigger("reloadGrid");
}
function doSearch(){
	$("#printTemplateList").jqGrid("clearGridData");
	var json=$("#searchForm").serializeJson();
	$("#printTemplateList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
function testPrint(){
	var rowId=$("#printTemplateList").jqGrid("getGridParam","selrow");
	
	if(!rowId){
		bootbox.alert("请选择一条证明模版");
		return;
	}
	var rowData=$("#printTemplateList").jqGrid("getRowData",rowId);
	
	templatePrint(rowData.fdModelAlias,{name:11,code:22,cc:44});
}
</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="row">
			    <div class="moduleWrapNobg">
				<div class="moduleTit">查询条件</div>
				<div class="moduleCont">
					<form id="searchForm">
						<div class="row">
								    	<label class="col-xs-3 col-sm-2" for="inputError">模版名称:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_fdModelName_SL" data-placement="bottom" />
										</div>
								    	
								    	<label class="col-xs-3 col-sm-2" for="inputError">模版类型:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_fkModelType_SL" data-placement="bottom" />
										</div>

								    	<label class="col-xs-3 col-sm-2" for="inputError">经办人名称:</label>
										<div class="col-xs-9 col-sm-2">
										    	<input class="form-control" type="text" name="Q_fdCreaterName_SL" data-placement="bottom" />
										</div>
								    	
						</div>
						<div class="row">
							<div class="col-sm-12 mgb20 tar pdx20">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1" ><i class="icon-zoom-in"></i>查询</a>
								<a href="javascript:void(0)" class="btn btn-primary highSearch" ><i class="icon-plus"></i>高级查询</a>
								<a href="#modal-form" role="button" class="btn btn-info" ><i class="icon-repeat"></i>重置</a>
							</div>
						</div>
					</form>
				</div>
			</div>		
				<div class="moduleWrapNob">
				<div class="moduleTit">查询结果</div>
				<div class="moduleCont">
					<div class="mgy10">
						<a href="javascript:void(0)" onclick="addPrintTemplate()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a>
						<a href="javascript:void(0)" onclick="editPrintTemplate()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a>
						<a href="javascript:void(0)"  onclick="delPrintTemplate()" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>删除</a>
<!-- 						<a href="javascript:testPrint()"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>打印</a> -->
					</div>
					<div class="row">
						<div class="col-xs-12">
								<table id="printTemplateList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
						</div>
					</div>
				</div>
			</div>	
				</div>
			</div>
		</div>
</body>		
</html>


