<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>设备配置表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script src="${ctx}/js/lib/bootstrap-select/bootstrap-select.js"></script>
<link type="text/css"
	href="${ctx}/js/lib/bootstrap-select/bootstrap-select.css"
	rel="stylesheet" />
<script>

$(function(){
	$('.selectpicker').selectpicker({
		selectAllText : '全选',//全选的checkbox名称  
		deselectAllText : '取消',
		selectAllNumber : true,
		actionsBox : false,
		noneResultsText : "没有相关信息",liveSearchPlaceholder:"请输入搜索.."
	});
	$('#div014').selectpicker('val','3');
	/**
	 初始化表格显示
	*/
	var columns= [ {field:'',title:'序号',width:'10%',align:'center',formatter:function(value, row, index){
		   return index+1;  
	   }},
       {field:'CON001',title:'操作',width:'10%',align:'center',formatter: function(value,row,index){	
           return "<a href=\"javascript:void(0)\" class='mhyNoA' onclick=\"editDivi('"+(row.CON001?row.CON001:'')+"')\" ><i class='icon-cog' title='管理'></i></a>"
			}
	 },
	                   {field:'DIV012',title:'设备编号',width:'20%',align:'center'},
	                   {field:'DIV002',title:'设备名称',width:'30%',align:'center'},
	                   {field:'DIV003',title:'设备管理员',width:'20%',align:'center'},
	                   {field:'DIV004',title:'管理员电话',width:'10%',align:'center'}
      	        	];
	$('#diviConfigList').bootstrapTable({
	    url:'${ctx}/business/dissupport/divice/diviConfig/listJson.xf?div014=4',
	    columns: columns,
		method : "get",
		pagination:true,
		pageSize:10,
		pageList:[10, 15, 20],
	    clickToSelect:true,
	    sidePagination:"server",
	    striped:true
	});
	
})
function  getSeachJson(){
	var json=$("#searchForm").serializeJson();
	return json;
}
function addDiviConfig(){	
		xfui.open_dialog({    
		    title: '新增设备配置表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/dissupport/divice/diviConfig/add.xf",
		    modal: true   
		})
}
function editDivi(obj){
	xfui.open_tabs("发布信息管理","${ctx}/business/dissupport/divice/diviConfig/diviConfigQueryList.xf?con001="+obj,"发布信息管理");
// 	xfui.open_dialog({    
//   		    title: '编辑设备配置表',    
//   		    width: 800,    
//   		    height: 500,    
//   		    closed: false,    
//   		    cache: false,    
//   		    url: "${ctx}/business/dissupport/divice/diviConfig/edit.xf?con001="+obj,
//   		    modal: true   
//   		})
}
function editDiviConfig(){
	var row = $('#diviConfigList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var con001=row[0].con001;
		editDivi(con001);
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delDiviConfig(){
	var row = $('#diviConfigList').bootstrapTable('getAllSelections');
	if(row&&row.length>0){
		var con001="";
		$.each(row,function(i,e){
			if(i==0){
				con001+=e.con001;
			}else{
				con001+=","+e.con001;
			}
			
		});
		bootbox.confirm({message:'您确认想要删除记录吗？',callback:function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/dissupport/divice/diviConfig/del.xf',
		    		data:{con001:con001},
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
	$('#diviConfigList').bootstrapTable('refresh');
}
function doSearch(){
	var params=$("#searchForm").serialize();
	$("#diviConfigList").bootstrapTable('refresh', {url:"${ctx}/business/dissupport/divice/diviConfig/listJson.xf?"+params});
}
function doClear(){
	$('.selectpicker').selectpicker('val','');
	$('.form-control').each(function(){
		if(!$(this).hasClass("selectpicker")){
			$(this).val('');
		}
	});
}
</script>
</head>
<body>
		<div class="main-container">
			<div class="container-fluid">
				<div class="mhyBody">
				<div class="mhySearch">
				<div class="mhyTitle">查询条件</div>
					<form id="searchForm" class="mhySearchInput">
						<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">设备编号:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="div012" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">设备名称:</label>
								<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="div002" data-placement="bottom" />
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError">所属型号:</label>
							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv">
								<select id="mod001" name="mod001"
									class="form-control selectpicker" 
									data-live-search="true" data-live-search-placeholder="Search"
									data-actions-box="true">
									<optgroup>
										<option value="">全部</option>
										<c:forEach items="${models}" begin="0" var="objOrg">
											<option value="${objOrg.mod001}">${objOrg.mod002}</option>
										</c:forEach>
									</optgroup>
								</select>
							</div>
						</div>
						<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError">设备类型:</label>
						<div class="col-xs-9 col-sm-2">
									<input class="form-control" type="text" name="" value="发布屏" data-placement="bottom" readonly="readonly"/>
									<input  type="hidden" name="div014" id="div014" value="4"/>
						</div>
<!-- 							<div class="col-xs-9 col-sm-2 mhyOrgId " id="selectDxdiv"> -->
							
<!-- 								<select id="div014" name="div014" -->
<!-- 									class="form-control selectpicker" data-live-search="true" -->
<!-- 									data-live-search-placeholder="Search" data-actions-box="true"> -->
<!-- 									<option value="">全部</option> -->
<%-- 									<xf:select name="div014" isNoStyle="true" isOnlyOptions="true" --%>
<%-- 										textField="TYPE_NAME" tableName="DEV_TYPE" --%>
<%-- 										valueField="TYPE_ID"></xf:select> --%>
<!-- 								</select> -->
<!-- 							</div> -->
								<label class="col-xs-3 col-sm-2" for="inputError"></label>
							<div class="col-xs-9 col-sm-2"></div>
						
							<div class="col-xs-9 col-sm-4 mhyBtn">
								<a href="#" role="button" onclick="doSearch()" class="btn btn-primary btn-border1 mhyBtnLeft" >
								<i class="icon-search"></i>
								查询</a>
								<button href="#modal-form" role="button" class="btn btn-border1" type="button" onclick="doClear()" >
								<i class="icon-repeat"></i>
								重置</button>
							</div>
						</div>
					</form></div>
				 
		 	
				<div class="mhyMain">
				<div class="mhyTitle">查询结果</div>
				<div class="mhyInfo">
					<div class="mgy10">
<!-- 						<a href="javascript:void(0)" onclick="addDiviConfig()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus align-top"></i>添加</a> -->
<!-- 						<a href="javascript:void(0)" onclick="editDiviConfig()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil align-top"></i>修改</a> -->
<!-- 						<a href="javascript:void(0)"  onclick="delDiviConfig()" role="button" class="btn btn-danger" ><i class="icon-trash align-top"></i>移除</a> -->
<!-- 						<a href="javascript:void(0)"  role="button" class="btn  btn-light" ><i class="icon-edit align-top"></i>导入</a> -->
<!-- 						<a href="javascript:void(0)"  role="button" class="btn btn-grey" ><i class="icon-external-link align-top"></i>导出</a> -->
						<!-- <a href="javascript:void(0)" role="button" onclick="delCorp()" class="btn btn-danger" data-toggle="modal"><i class="icon-trash align-top"></i>删除</a> -->
					</div>
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="diviConfigList"  class="datagridClass"  >
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>	
				</div>
			</div>
		</div>
</body>		
</html>


