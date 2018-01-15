<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>场地管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**   
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                  /*  {field:'acd200',title:'职介机构编号',width:100,align:'center'},
	                   {field:'acd251',title:'场地权属',width:100,align:'center'}, 
	                   {field:'acd252',title:'场地代码',width:100,align:'center'}, */
	                   {field:'acd253',title:'场地名称',width:180,align:'center'},
	                   {field:'cczc003',title:'场地性质',width:100,align:'center',
	                	   formatter:function(value,row,index){if(value==0)return '临时';else if(value==1)return '固定';}},
	                   {field:'cczc004',title:'场地地址',width:210,align:'center'},
	                   {field:'cczc005',title:'乘车路线',width:100,align:'center'},
	                   {field:'cczc006',title:'联系电话',width:100,align:'center'},
	                   /* {field:'cczc007',title:'使用状态',width:80,align:'center',
	                	   formatter:function(value,row,index){if(value==0)return '正常使用';else if(value==1)return '已注销';}}, */
	                   {field:'acd250',title:'操作',width:100,formatter: function(value,row,index){
				           return "<a href=\"javascript:void(0)\" onclick=\"editSite('"+value+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"deleteSite('"+value+"')\" >删除</a>";
							}
					   }
      	        	]];
	$('#jobFairSiteList').datagrid({
	    url:'${ctx}/business/jobfair/jobFairSite/listJson.xf',
	    columns:columns,
	    fitColumns:true,
		rownumbers: true,
        singleSelect: true,
        checkOnSelect:false,
        selectOnCheck:false,
		pagination: true,
        multiSort:true,
		onLoadSuccess:function(data){
			if(data.total>0){
				$(this).datagrid("selectRow",0);
			}
		},
        pageList:[1,5,10]
	});
})

function addJobFairSite(){	
		xfui.open_dialog({    
		    title: '新增场地',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/jobfair/jobFairSite/add.xf",
		    modal: true   
		})
}
function editJobFairSite(){
	var row = $('#jobFairSiteList').datagrid('getSelected');
	if(row){
		var acd250=row.acd250;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		editSite(acd250);
	}else{
		$.messager.alert('提示','请选择记录');
	}			
}

function editSite(acd250){
	xfui.open_dialog({
		title: '编辑场地',
		width: 800,
		height: 500,
		closed: false,
		cache: false,
		url: "${ctx}/business/jobfair/jobFairSite/edit.xf?acd250="+acd250,
		modal: true
	})
}

function deleteSite(acd250){
	$.ajax({ url: '${ctx}/business/jobfair/jobFairSite/del.xf',
		data:{acd250:acd250},
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

function delJobFairSite(){
	var row = $('#jobFairSiteList').datagrid('getSelections');
	if(row&&row.length>0){
		var acd250="";
		$.each(row,function(i,e){
			if(i==0){
				acd250+=e.acd250;
			}else{
				acd250+=","+e.acd250;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){
				deleteSite(acd250);
		    }    
		}); 
	  }else{
		 $.messager.alert('提示','请选择记录');
	 }			
} 
function refresh(){
	$('#jobFairSiteList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#jobFairSiteList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addJobFairSite()" data-options="iconCls:'icon-add'">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editJobFairSite()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delJobFairSite()" iconCls="icon-remove">删除</a>
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
							场地名称:</td>
						<td class="formInput" ><input class="easyui-textbox"  type="text" name="acd253"/></td>
						<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							场地地址:</td>
						<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;" >
						<input class="easyui-textbox"  type="text" name="cczc004" /></td>
						<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							场地性质:</td>
						<td class="formInput" ><select  name="cczc003" class="">
							<option value="">--请选择--</option>
							<option value="0">临时</option>
							<option value="1">固定</option>
						</select></td>
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
	<table id="jobFairSiteList" class="datagridClass"></table>
</body>
</html>


