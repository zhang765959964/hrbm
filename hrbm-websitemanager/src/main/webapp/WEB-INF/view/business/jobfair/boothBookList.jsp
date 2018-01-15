<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>摊位预定管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	var columns= [[{field:'acb210',title:'',checkbox:'true',align:'center'},
	                {field:'aab004',title:'企业名称',width:100,align:'center'},
	       			{field:'acb331',title:'招聘会名称',width:80,align:'center'},
	       			{field:'acb333',title:'招聘会开始时间',width:100,align:'center',formatter:function(value,row,index){return formateDate(value);}},
	       			{field:'acb334',title:'招聘会结束时间',width:100,align:'center',formatter:function(value,row,index){return formateDate(value);}},
	       			{field:'acd253',title:'招聘会地址',width:100,align:'center'},
	       			{field:'ccpr05',title:'修改时间',width:100,align:'center',
	       				formatter:function(value,row,index){if(value==null)return '';else return formateDate(value);}
	       			},
	       			{field:'abb773',title:'审核状态',width:80,align:'center',
	       			 formatter:function(value,row,index){if(value==0)return '未审核';else return '已审核';}}
	]];
	$('#boothBookList').datagrid({
	    url:'${ctx}/business/jobfair/boothBook/listJson.xf',
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
$(function(){
	var columns= [[{field:'acb210',title:'',checkbox:'true',align:'center'},
		{field:'aab004',title:'单位名称',width:100,align:'center'},
		{field:'cca113',title:'职位名称',width:80,align:'center'},
		{field:'aae030',title:'招聘会开始时间',width:100,align:'center'},
		{field:'aae031',title:'招聘会结束时间',width:100,align:'center'},
		{field:'ccpr05',title:'修改时间',width:80,align:'center',formatter:function(value,row,index){if(value==null)return '';else return formateDate(value);}},
		{field:'cca114',title:'岗位描述',width:100,align:'center'},
		{field:'abb773',title:'审核状态',width:80,align:'center',
			formatter:function(value,row,index){if(value==0)return '未审核';else return '已审核';}}
	]];
	$('#boothBookList1').datagrid({
	    url:'${ctx}/business/jobfair/boothBook/listJson1.xf',
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

function editBoothBook(){
	var row = $('#boothBookList').datagrid('getSelected');
	if(row){
		var acb210=row.acb210;
		xfui.open_tabs("招聘会审核","${ctx}/business/jobfair/boothBook/edit.xf?acb210="+acb210,"预定审核");		
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 
function editBoothBook1(){
	var row = $('#boothBookList1').datagrid('getSelected');
	if(row){
		var acb210=row.acb210;
		xfui.open_tabs("岗位审核","${ctx}/business/jobfair/boothBook/edit1.xf?acb210="+acb210,"预定审核");		
	}else{
		$.messager.alert('提示','请选择记录');
	}	
} 

/**
 * 批量审核招聘会
 */
function appallcb20(){
	var row = $('#boothBookList').datagrid('getChecked');
	if(row&&row.length>0){
		var acb="";
		var approveFlag="0";
		$.each(row,function(i,e){
			if(i==0){
				acb+=e.acb210;
			}else{
				acb+=","+e.acb210;
			}			
		});
		$.messager.confirm('确认','您确认要审核吗？',function(r){    
		    if (r){	
		    	$.ajax({ url: '${ctx}/business/jobfair/boothBook/approveall.xf',
		    		data:{acb:acb,approveFlag:approveFlag},
		    		dataType:'json',success: function(data){
		    			if(data.message){
		    				$.messager.alert('提示',data.message); 	
		    			}else{
		    				$.messager.alert('提示',"未知错误"); 
		    			}	
		    				refresh();
		    	     }}
		    	);}  
		}); 
	  }else{
		 $.messager.alert('提示','请选择记录');
	 }		
} 
function refresh() {
	$('#boothBookList').datagrid('load');
}
function doSearch() {
	var json = $("#searchForm").serializeJson();
	$("#boothBookList").datagrid("load", json);
}
/**
 * 批量审核岗位
 */
function appallcb21(){
	var row = $('#boothBookList1').datagrid('getChecked');
	if(row&&row.length>0){
		var acb="";
		var approveFlag="0";
		$.each(row,function(i,e){
			if(i==0){
				acb+=e.acb210;
			}else{
				acb+=","+e.acb210;
			}			
		});
		$.messager.confirm('确认','您确认要审核吗？',function(r){    
		    if (r){	
		    	$.ajax({ url: '${ctx}/business/jobfair/boothBook/approveallcb21.xf',
		    		data:{acb:acb,approveFlag:approveFlag},
		    		dataType:'json',success: function(data){
		    			if(data.message){
		    				$.messager.alert('提示',data.message); 	
		    			}else{
		    				$.messager.alert('提示',"未知错误"); 
		    			}	
		    				refresh1();
		    	     }}
		    	);}  
		}); 
	  }else{
		 $.messager.alert('提示','请选择记录');
	 }		
} 
function refresh1() {
	$('#boothBookList1').datagrid('load');
}
function doSearch1() {
	var json = $("#searchForm1").serializeJson();
	$("#boothBookList1").datagrid("load", json);
}
/* 	function delBoothBook() {
		request.getParameters
		var row = $('#boothBookList').datagrid('getSelections');
		if (row && row.length > 0) {
			var cczy01 = "";
			$.each(row, function(i, e) {
				if (i == 0) {
					cczy01 += e.cczy01;
				} else {
					cczy01 += "," + e.cczy01;
				}});
			$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
				if (r) {
					$.ajax({
						url : '${ctx}/business/jobfair/boothBook/del.xf',
						data : {cczy01 : cczy01},
						dataType : 'json',
						success : function(data) {
							if (data.message) {
								$.messager.alert('提示', data.message);
							} else {
								$.messager.alert('提示', "未知错误");
							}
							refresh();
						}
					});
				}
			});
		} else {
			$.messager.alert('提示', '请选择记录');
		}
	}
	 */
	
</script>
</head>
<body>
	<div id="tt" class="easyui-tabs" style="width:100%;height:550px;">
	<div title="招聘信息审核" style="overflow-x: hidden">
	   <div id="dg_toolbar" style="padding: 5px 5px;">
			<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editBoothBook()" data-options="iconCls:'icon-edit'">招聘信息审核</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="appallcb20()"  data-options="iconCls:'icon-edit'">批量审核</a>
		</div>
		<div class="div-line"></div>	
		<hr/>
	<div class="panel-search" style="padding-bottom:5px">
				<form id="searchForm" >
					<fieldset>
			    		<legend>查询条件</legend>
			    		<table cellpadding="5" class="formTable">
				    	<tr>
							<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							企业名称:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_aab004_SL"/></td>
							<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							招聘会名称:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_acb331_SL"/></td>
							<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							修改时间:</td>
							<td class="formInput" ><input class="easyui-datebox"  type="text" name="Q_beginccpr05_DL" style="width:100px"/>-
							<input class="easyui-datebox"  type="text" name="Q_endccpr05_DL" style="width:100px"/></td>
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
		<table id="boothBookList" class="datagridClass"></table>
	</div>
	<div title="岗位信息审核"  style="overflow-x: hidden" >
	   <div id="dg_toolbar" style="padding: 5px 5px;">
			<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editBoothBook1()" data-options="iconCls:'icon-edit'">岗位信息审核</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="appallcb21()"  data-options="iconCls:'icon-edit'">批量审核</a>
		</div>
		<div class="div-line"></div>	
		<hr/>
	<div class="panel-search" style="padding-bottom:5px">
				<form id="searchForm1" >
					<fieldset>
			    		<legend>查询条件</legend>
			    		<table cellpadding="5" class="formTable">
				    	<tr>
							<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							企业名称:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_aab004_SL"/></td>
							<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							职位名称:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_cca113_SL"/></td>
							<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
							修改时间:</td>
							<td class="formInput" ><input class="easyui-datebox"  type="text" name="Q_beginccpr05_DL" style="width:100px"/>-
							<input class="easyui-datebox"  type="text" name="Q_endccpr05_DL" style="width:100px"/></td>
						</tr>	
						</table>
						<div style="border:0px red solid;position:relative;margin-top:5px;">
								<div style="float:right; border:0px red solid;">
									<a href="javascript:void(0)" class="easyui-linkbutton " onclick="doSearch1()" iconCls="icon-search" >查询</a>
									<a href="javascript:void(0)" class="easyui-linkbutton " onclick="resetSearchForm1()" iconCls="icon-clear" >重置</a>
								</div>
							    <div style="clear:both;"></div>
							</div>			   
				    </fieldset>	
				</form>
			</div>
			<hr/>	
		<table id="boothBookList1" class="datagridClass"></table>
	</div>
	</div>
</body>
</html>


