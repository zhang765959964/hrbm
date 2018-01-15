<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>招聘会信息管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>
$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                   {field:'acb331',title:'招聘会名称',width:200,align:'center'},
	                   {field:'acb332',title:'招聘会主题',width:100,align:'center'},
	                   {field:'acb337',title:'招聘会介绍',width:100,align:'center'},
	                   {field:'aab045',title:'主办单位',width:100,align:'center'},
	                   /* {field:'acb338',title:'承办单位代码',width:100,align:'center'},
	                      {field:'aab301',title:'举办城市代码',width:100,align:'center'},
	                      {field:'acb336',title:'举办城市',width:100,align:'center'}, */
	                   {field:'acb333',title:'开始日期',width:120,align:'center',formatter:function(value,row,index){return formateHouse(value);}},
	                   {field:'acb334',title:'结束日期',width:120,align:'center',formatter:function(value,row,index){return formateHouse(value);}},
	                   {field:'aae004',title:'联系人',width:80,align:'center'},
	                   {field:'aae005',title:'联系人电话',width:100,align:'center'},
	                   {field:'acb335',title:'大会类型',width:100,align:'center',
	                	   formatter:function(value,row,index){if(value==01)return '综合类';if(value==02)return '下刚失业人员专场';if(value==03) return'大中专毕业生专场'; if(value==04) return '残疾人专场';if(value==05) return '技校毕业生专场';
	                	   if(value==06) return '农民工专场';if(value==07) return '失业农民专场';if(value==08) return '高级人才专场'; return '其他';}},
	                   {field:'cb33_status',title:'大会状态',width:80,align:'center'},
	                {field:'acb330',title:'操作',width:100,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"editJobFairInfo('"+value+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"delJobFairInfo('"+value+"')\" >删除</a>";
							}
					 }
      	        	]];
	$('#jobFairInfoList').datagrid({
	    url:'${ctx}/business/jobfair/jobFairInfo/listJson.xf',
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

function addJobFairInfo(){	
		xfui.open_dialog({    
		    title: '新增招聘会信息',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/jobfair/jobFairInfo/add.xf",
		    modal: true   
		})
}
function editJobFairInfo(){
	var row = $('#jobFairInfoList').datagrid('getSelected');
	if(row){
		var acb330=row.acb330;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑招聘会信息',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/jobfair/jobFairInfo/edit.xf?acb330="+acb330,
	  		    modal: true   
	  		})
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 

function delJobFairInfo(){
	var row = $('#jobFairInfoList').datagrid('getSelections');
	if(row&&row.length>0){
		var acb330="";
		$.each(row,function(i,e){
			if(i==0){
				acb330+=e.acb330;
			}else{
				acb330+=","+e.acb330;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/jobfair/jobFairInfo/del.xf',
		    		data:{acb330:acb330},
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
	$('#jobFairInfoList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#jobFairInfoList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addJobFairInfo()" data-options="iconCls:'icon-add'">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editJobFairInfo()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delJobFairInfo()" iconCls="icon-remove">删除</a>
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
							招聘会名称:</td>
						<td class="formInput" ><input class="easyui-textbox"  type="text" name="acb331"/></td>
						<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							招聘会主题:</td>
						<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;" >
						<input class="easyui-textbox"  type="text" name="acb332" /></td>
						<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							大会类型:</td>
						<td class="formInput" ><xf:select textField="name" tableName="TAB_JFTYPE" hasDefault="0" name="acb335" valueField="code" value="${jobFairInfoForm.acb335}">
								<option value="0">请选择</option>	
						</xf:select></td>
						<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							大会状态:</td>
						<td class="formInput" ><select  name="cb33_status" class="easyui-combobox">
							<option value="">--请选择--</option>
							<option value="未开始">未开始</option>
							<option value="进行中">进行中</option>
							<option value="已结束">已结束</option>
						</select></td>
					</tr>	
					<tr>
						<td class="formTitle" >开始时间:</td>
						<td class="formInput" ><input class="easyui-datebox"  type="text" name="beginacb333" style="width:95px"/>-
						<input class="easyui-datebox"  type="text" name="endacb333" style="width:95px"/></td>
						<td class="formTitle" >结束时间:</td>
						<td class="formInput" ><input class="easyui-datebox"  type="text" name="beginacb334" style="width:95px"/>-
						<input class="easyui-datebox"  type="text" name="endacb334" style="width:95px"/></td>
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
	<table id="jobFairInfoList" class="datagridClass"></table>
</body>
</html>


