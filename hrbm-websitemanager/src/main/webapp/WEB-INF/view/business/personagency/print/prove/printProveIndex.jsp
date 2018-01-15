<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>RSDA_BS_PRINT_MODEL管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@include file="/commons/include/commonInc.jsp" %>
<script>

$(function(){
	$("#printProve").load("${ctx}/business/personagency/print/printProve/list.xf");
	var columns= [
					{field:'AAC002',title:'身份证号',width:100,align:'center'},
					{field:'AAC003',title:'姓名',width:100,align:'center'},
                    {field:'ARCHIVECODE',title:'档案编号',width:100,align:'center'}
	        	];
	$("#personSearch").selectcommon({
			 url:CTX+'/business/personagency/archive/archives/searchArchives.xf',
			 columns: columns,
			 callBack:function(data){
				 personData=data;
				 if(data){
					 loadPage(data.PERSONID);
				 }else{
					 bootbox.alert("未查到相关记录");
				 }
				
				
			}
		 })
			/**
		 初始化表格显示
		*/
		var columns= [
		                   {name:'fdModelName',label:'模版名称',align:'center'},
		                   {name:'fdModelHtml',label:'模版html',align:'center',hidden:true,},
		                   {name:'fdCreaterName',label:'经办人名称',align:'center'},
		                   {name:'pkId',label:'主键',hidden:true,width:100,key:true }
	      	        	];
		$("#printTemplateList").jqGrid({
			   url:'${ctx}/business/personagency/print/printProveTemplate/listJson.xf?fkModelType=0',
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
	           multiselect:false,
	           autowidth: true,
	           height:'100%',
	           onSelectRow:function(rowId,dd,dd2){
	        	   debugger;
	        	   var rowData=$("#printTemplateList").jqGrid("getRowData",rowId);
	        	   $("#fdModelHtmlContent").empty();
	         	  $("#fdModelHtmlContent").append($(rowData.fdModelHtml));
	           },
	       });
})

function loadPage(personId){
	
	$("#printProve").load("${ctx}/business/personagency/print/printProve/list.xf?personId="+personId);
}

function printProve(){
	var pkId=$("#printTemplateList").jqGrid("getGridParam","selrow");
	var personId=$("#personId").val();
	if(!pkId){
		bootbox.alert("请选择一条证明模版");
		return;
	}
	if(!personId||personId=="0"){
		bootbox.alert("请选择代理人员信息");
		return;
	}
	window.open("${ctx}/business/personagency/print/printProve/print.xf?personId="+personId+"&pkId="+pkId);
	
}
</script>
</head>
<body>

			<div class="container-fluid">
					<div class="row">
						<!-- 单条查询 -->
						<div class="col-xs-12 pd0 tar">
							<div class="col-xs-6 col-sm-6">
								<a href="javascript:void(0)" role="button" class="btn btn-info" data-toggle="modal" id="seccard">社保卡已配置</a>
								<a href="javascript:void(0)" role="button" class="btn" data-toggle="modal" id="idcard">身份证未配置</a>
							</div>
							<div class="col-xs-6 col-sm-6">
								<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
								<div class="col-xs-6 col-sm-7 pr">
									<input class="form-control"  name="personSearch" id="personSearch" placeholder="请输入身份证号 姓名 档案编号" type="text"/>
									<!-- 多条结果 -->
								</div>				
							</div>
						</div>			
					</div>
				<div  id="printProve"></div>
				<div class="row mg0">
					<div class="col-sm-5 pd0 ">
					    <div class="moduleWrapNobg">
						<div class="moduleTit">证明模版列表</div>
						<div class="moduleCont resultWrap h335">
						   
							<div class="row">
								<div class="col-xs-12">
									<table id="printTemplateList"  class="datagridClass"  ></table>
								<div id="jqGridPager"></div>
								</div>
							</div>
						</div>
						</div>
					</div>
					<div class="col-sm-7 colRight">
						<div class="moduleWrapNobg">
							<div class="moduleTit">模版详情</div>
							<div class="moduleCont resultWrap h335">
								<div class="row">
									<div class="col-xs-12" id="fdModelHtmlContent">					
									</div>
								</div>						
							</div>
						</div>
					</div>
			</div><!-- row end -->	
			<div class="h60">&nbsp;</div>
					<div class="floatBtn">
					<a href="javascript:void(0)" role="button" id="closeItem" class="btn btn-info" onclick="printProve()"><i class="icon-print"></i>打印</a>	
			</div> 
	</div>

</body>		
</html>


