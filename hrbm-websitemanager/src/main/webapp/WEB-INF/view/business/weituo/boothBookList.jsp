<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>委托招聘管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'acb210',title:'',checkbox:'true',align:'center'},
		{field:'aab004',title:'企业名称',width:100,align:'center'},
		{field:'cca113',title:'职位名称',width:80,align:'center'},
		{field:'acb21r',title:'招聘人数',width:60,align:'center'},
		{field:'acc217',title:'工作年限(年)',width:100,align:'center'},
		{field:'acc034',title:'工资水平(元)',width:100,align:'center'},
		{field:'bcb202',title:'面试地点',width:100,align:'center'},
		{field:'ccpr05',title:'修改时间',width:80,align:'center',formatter:function(value,row,index){if(value==null)return '';else return formateDate(value);}},
		{field:'abb773',title:'审核状态',width:80,align:'center',
			formatter:function(value,row,index){if(value==0)return '未审核';else return '已审核';}}
	]];
	$('#boothBookList').datagrid({
	    url:'${ctx}/business/jobfair/boothBook/listJsonweituo.xf',
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
		xfui.open_tabs("招聘信息审核","${ctx}/business/jobfair/boothBook/editweituo.xf?acb210="+acb210,"招聘审核");
	}else{
		$.messager.alert('提示','请选择记录');
	}		
} 

/**
 * 批量审核 
 */
function appall(){
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
		    	$.ajax({ url: '${ctx}/business/jobfair/boothBook/approveallcb21.xf',
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
	} */
	function refresh() {
		$('#boothBookList').datagrid('load');
	}
	function doSearch() {
		var json = $("#searchForm").serializeJson();
		$("#boothBookList").datagrid("load", json);
	}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editBoothBook()" data-options="iconCls:'icon-edit'">审核</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="appall()"  data-options="iconCls:'icon-edit'">批量审核</a>
	</div>
	<div class="div-line"></div>	
	<hr/>
	<div class="panel-search" style="padding-bottom:5px">
				<form id="searchForm" >
					<fieldset>
			    		<legend>查询条件</legend>
			    		<table cellpadding="5" class="formTable">
				    	<tr>
							<td style="padding: 2px;min-width: 60px;width: 60px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							企业名称:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_aab004_SL"/></td>
							<td style="padding: 2px;min-width: 60px;width: 60px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							职位名称:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_cca113_SL"/></td>
							<td  style="padding: 2px;min-width: 100px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >修改日期:</td>
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
</body>
</html>


