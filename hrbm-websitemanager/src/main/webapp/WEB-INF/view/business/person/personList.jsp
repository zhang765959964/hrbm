<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>个人基本信息表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                   {field:'aac003',title:'姓名',width:80,align:'center'},
	                   {field:'aac002',title:'公民身份证号码',width:120,align:'center'},
	                   {field:'aac004',title:'性别',width:60,align:'center',formatter:function(value,row,index){if(value==1)return '男性';else return '女性';}},
	                   {field:'aac006',title:'出生日期',width:100,align:'center',formatter:function(value,row,index){return formateDate(value);}},
	                   {field:'aac024',title:'政治面貌',width:60,align:'center',formatter:function(value,row,index){if(value==01)return '中共党员';if(value==02)return '中共预备党员';
		                   if(value==03)return '中青团员';if(value==04)return '民革会员';if(value==05)return '民盟会员';if(value==06)return '民建会员';if(value==07)return '民进会员';
		                   if(value==08)return '农工党党员';if(value==09)return '致公党党员';if(value==10)return '九三学社社员';if(value==11)return '台盟盟员';if(value==12)return '无党派人士';if(value==13)return '群众';}},
	                   {field:'aab301',title:'居住所在地',width:160,align:'center'},
	                   {field:'aae005',title:'联系电话',width:100,align:'center'},
	                {field:'aac001',title:'操作',width:80,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"selectPerson('"+value+"')\" >查看</a>";
							}
					 }
      	        	]];
	$('#personList').datagrid({
	    url:'${ctx}/business/person/person/listJson.xf',
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

/* function addPerson(){	
		xfui.open_dialog({    
		    title: '新增个人基本信息表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/person/person/add.xf",
		    modal: true   
		})
} */
function selectPerson(){
	var row = $('#personList').datagrid('getSelected');
	if(row){
		var aac001=row.aac001;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑个人基本信息表',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/person/person/getselect.xf?aac001="+aac001,
	  		    modal: true   
	  		})
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 

/* function delPerson(){
	var row = $('#personList').datagrid('getSelections');
	if(row&&row.length>0){
		var aac001="";
		$.each(row,function(i,e){
			if(i==0){
				aac001+=e.aac001;
			}else{
				aac001+=","+e.aac001;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/person/person/del.xf',
		    		data:{aac001:aac001},
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
}  */
function refresh(){
	$('#personList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#personList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="selectPerson()" data-options="iconCls:'icon-search'">查看</a> 
		<!-- <a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editPerson()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delPerson()" iconCls="icon-remove">删除</a> -->
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
							姓名:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_aac003_SL"/></td>
							<td style="padding: 2px;min-width: 60px;width: 60px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
							身份证号:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_aac002_SUPL"/></td>
							<td style="padding: 2px;min-width: 60px;width: 60px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
								性别:</td>
							<td class="formInput" ><xf:select textField="name" tableName="TAB_SEX" hasDefault="0" name="aac004" valueField="code">
							</xf:select></td>
							</tr>
							<tr>
							<td class="formTitle" style="weight:160px;" >出生日期:</td>
							<td class="formInput" ><input class="easyui-datebox"  type="text" name="Q_beginaac006_DL" style="width:100px"/>-
							<input class="easyui-datebox"  type="text" name="Q_endaac006_DL" style="width:100px"/></td>
							<td style="padding: 2px;min-width: 60px;width: 100px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;" >
								政治面貌:</td>
							<td class="formInput" ><xf:select textField="name" tableName="TAB_AFFIL"  hasDefault="0" name="aac024" valueField="code">
							</xf:select></td>
							<td style="padding: 2px;min-width: 60px;width: 60px;border: 1px solid #A0BDBB;background-color: #e8ffff;text-align: right;height: 23px;">
								居住所在地:</td>
							<td style="padding: 2px;border: 1px solid #A0BDBB;background-color: white;text-align: left;width: 80px;"  ><input class="easyui-textbox"  type="text" name="Q_aab301_SL"/></td>
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
	<table id="personList" class="datagridClass"></table>
</body>
</html>


