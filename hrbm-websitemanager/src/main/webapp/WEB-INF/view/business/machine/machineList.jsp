<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查询机管理表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                   {field:'machineName',title:'查询机名称',width:100,align:'center'},
	                   {field:'machineAddress',title:'查询机位置',width:100,align:'center'},
	                   {field:'machineIp',title:'查询机Ip地址',width:100,align:'center'},
	                   {field:'machineCode',title:'查询机编号',width:100,align:'center'},
	                {field:'id',title:'操作',width:100,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"editMachine('"+value+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"delMachine('"+value+"')\" >删除</a>";
							}
					 }
      	        	]];
	$('#machineList').datagrid({
	    url:'${ctx}/business/machine/machine/listJson.xf',
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

function addMachine(){	
		xfui.open_dialog({    
		    title: '新增查询机管理表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/machine/machine/add.xf",
		    modal: true   
		})
}
function editMachine(){
	var row = $('#machineList').datagrid('getSelected');
	if(row){
		var id=row.id;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑查询机管理表',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/machine/machine/edit.xf?id="+id,
	  		    modal: true   
	  		})
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 

function delMachine(){
	var row = $('#machineList').datagrid('getSelections');
	if(row&&row.length>0){
		var id="";
		$.each(row,function(i,e){
			if(i==0){
				id+=e.id;
			}else{
				id+=","+e.id;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/machine/machine/del.xf',
		    		data:{id:id},
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
	$('#machineList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#machineList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addMachine()" data-options="iconCls:'icon-add'">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editMachine()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delMachine()" iconCls="icon-remove">删除</a>
	</div>
	<div class="div-line"></div>	
	<hr/>
	<div class="panel-search" style="padding-bottom:5px">
				<form id="searchForm" >
					<fieldset>
			    		<legend>查询条件</legend>
			    		<table cellpadding="5" class="formTable">
			    	<tr>
						<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							查询机编码:</td>
						<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;" >
						<input class="easyui-textbox"  type="text" name="Q_machineCode_SL" /></td>
						<td class="formTitle" >查询机名称:</td>
						<td class="formInput" ><input class="easyui-textbox"  type="text" name="Q_machineName_SL"/></td>
						<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							查询机位置:</td>
						<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;" >
						<input class="easyui-textbox"  type="text" name="Q_machineAddress_SL" /></td>
					</tr>	
					</table>
					<div style="border:0px red solid;position:relative;margin-top:5px;">
							<div style="float:right; border:0px red solid;">
								<a href="javascript:void(0)" class="easyui-linkbutton " onclick="doSearch()" iconCls="icon-search" >查询</a>
								<a href="javascript:void(0)" class="easyui-linkbutton " onclick="resetSearchForm()" iconCls="icon-clear" >重置</a>
							</div>
						    <div style="clear:both;"></div>
						</div>			   
			    </fieldset>	
				</form>
			</div>
			<hr/>	
	<table id="machineList" class="datagridClass"></table>
</body>
</html>


