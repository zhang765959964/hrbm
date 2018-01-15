<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>电子档案目录管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/commonInc.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [
	                   {name:'name',label:'目录名称',align:'center'},
	                   {name:'code',label:'目录代码',align:'center'},
	                   {name:'description',label:'描述',align:'center'},
	                   {name:'sortnum',label:'排序',align:'center'}
      	        	];
	$("#erecordCatalogList").jqGrid({
		   url:'${ctx}/business/personagency/erecord/erecordCatalog/listJson.xf',
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
           height : "100%"
       });
})

function addErecordCatalog(){	
		xfui.open_dialog({    
		    title: '新增电子档案目录',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/personagency/erecord/erecordCatalog/add.xf",
		    modal: true   
		})
}
function editErecordCatalog(){
	//var row = $('#erecordCatalogList').bootstrapTable('getAllSelections');
	var rowid=$("#erecordCatalogList").jqGrid("getGridParam","selrow");
	if(rowid){
		var id=rowid;
		xfui.open_dialog({    
	  		    title: '编辑电子档案目录',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/personagency/erecord/erecordCatalog/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		bootbox.alert('请选择记录');
	}			
} 

function delErecordCatalog(){

	var rowids=$("#erecordCatalogList").jqGrid("getGridParam","selarrrow");
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
		    	$.ajax({ url: '${ctx}/business/personagency/erecord/erecordCatalog/del.xf',
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
	$("#erecordCatalogList").trigger("reloadGrid");
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	$("#erecordCatalogList").jqGrid("setGridParam",{postData:json}).trigger("reloadGrid");
}
</script>
</head>
<body>
		<!-- <div class="main-container"> -->
<div class="container-fluid">
	<div class="row">
		<div class="moduleWrapNob">
			<div class="moduleTit">目录设置</div>
			<div class="moduleCont">
				<div class="mgy10">
					<a href="javascript:void(0)" onclick="addErecordCatalog()" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-plus"></i>添加</a>
					<a href="javascript:void(0)" onclick="editErecordCatalog()" role="button" class="btn btn-info" data-toggle="modal"><i class="icon-pencil"></i>修改</a>
					<a href="javascript:void(0)"  onclick="delErecordCatalog()" role="button" class="btn btn-danger" ><i class="icon-trash"></i>删除</a>
				</div>
				<div class="row">
					<div class="col-xs-12">
							<table id="erecordCatalogList"  class="datagridClass"  ></table>
							<div id="jqGridPager"></div>
					</div>
				</div>
			</div>
		</div>	
	</div>
</div>
		<!-- </div> -->
</body>		
</html>


