<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网站友情链接表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                   
	                   {field:'ccmw02',title:'网站名称',width:100,align:'center'},
	                   
	                   {field:'ccmw03',title:'链接地址',width:100,align:'center'},
	                   
	                   {field:'ccmw04',title:'添加日期',width:100,align:'center'},
	                   
	                   {field:'ccmw05',title:'链接分类',width:100,align:'center'},
	                   
	                   {field:'ccmw06',title:'排序',width:100,align:'center'}
      	        	]];
	$('#linkList').datagrid({
	    url:'${ctx}/business/link/link/listJson.xf',
	    columns:columns,
	    fitColumns:true,
		rownumbers: true,
        singleSelect: true,
        checkOnSelect:false,
        selectOnCheck:false,
		pagination: true, 
        rownumbers: true,
        multiSort:true,
		onLoadSuccess:function(data){
			if(data.total>0){
				$(this).datagrid("selectRow",0);
			}
			
		},
        pageList:[1,5,10]
	});
	
})

function addlink(){
	
		xfui.open_dialog({    
		    title: '新增网站友情链接表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/link/link/add.xf",
		    modal: true   
		})
}
function editlink(){
	var row = $('#linkList').datagrid('getSelected');
	if(row){
		var ccmw01=row.ccmw01;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑网站友情链接表',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/link/link/edit.xf?ccmw01="+ccmw01,
	  		    modal: true   
	  		})
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 

function dellink(){
	var row = $('#linkList').datagrid('getSelections');
	if(row&&row.length>0){
		var ccmw01="";
		$.each(row,function(i,e){
			if(i==0){
				ccmw01+=e.ccmw01;
			}else{
				ccmw01+=","+e.ccmw01;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/link/link/del.xf',
		    		data:{ccmw01:ccmw01},
		    		dataType:'json',
		    		success: function(data){
		    			if(data.message){
		    				$.messager.alert('提示',data.message); 	
		    			}else{
		    				$.messager.alert('提示',"未知错误"); 
		    			}
		    			
		    			refresh();
		             }
		    	});
		    }    
		}); 
	  }else{
		 $.messager.alert('提示','请选择记录');
	 }			
} 
function refresh(){
	$('#linkList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#linkList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addlink()" data-options="iconCls:'icon-add'">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editlink()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="dellink()" iconCls="icon-remove">删除</a>
	</div>
	<div class="div-line"></div>		
	<table id="linkList" class="datagridClass"></table>
</body>
</html>


