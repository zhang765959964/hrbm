<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>网上认证提交信息表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                   {field:'ccmu01',title:'用户编号',width:100,align:'center'},
	                   {field:'caoa02',title:'提交营业执照扫描件的地址',width:100,align:'center'},
	                   {field:'caoa03',title:'说明文字',width:100,align:'center'},
	                   {field:'caoa04',title:'证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频)',width:100,align:'center'},
	                   {field:'caoa05',title:'提交时间',width:100,align:'center'},
	                   {field:'acd230',title:'从业人员编号',width:100,align:'center'},
	                   {field:'caoa06',title:'处理认证日期',width:100,align:'center'},
	                   {field:'caoa07',title:'是否通过认证(0-未审核1-审核已通过2-审核失败3-退回资料4-自动审核)',width:100,align:'center'},
	                   {field:'caoa08',title:'认证意见备注',width:100,align:'center'},
	                   {field:'ccpr08',title:'是否删除状态（0-否1-是）',width:100,align:'center'},
	                   {field:'cczy06',title:'数据来源1网站3民营职介4-公办职介',width:100,align:'center'},
	                   {field:'caoa09',title:'是否已经上传(0-未上传1-已上传)',width:100,align:'center'},
	                   {field:'caoa10',title:'提交法人身份证扫描件的地址',width:100,align:'center'},
	                   {field:'aab001',title:'单位编号',width:100,align:'center'},
	                {field:'caoa01',title:'操作',width:100,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"stickTop('"+value+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"previewArticle('"+value+"')\" >删除</a>";
							}
					 }
      	        	]];
	$('#authenticationList').datagrid({
	    url:'${ctx}/business/cation/authentication/listJson.xf',
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

function addauthentication(){	
		xfui.open_dialog({    
		    title: '新增网上认证提交信息表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/cation/authentication/add.xf",
		    modal: true   
		})
}
function editauthentication(){
	var row = $('#authenticationList').datagrid('getSelected');
	if(row){
		var caoa01=row.caoa01;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑网上认证提交信息表',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/cation/authentication/edit.xf?caoa01="+caoa01,
	  		    modal: true   
	  		})
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 

function delauthentication(){
	var row = $('#authenticationList').datagrid('getSelections');
	if(row&&row.length>0){
		var caoa01="";
		$.each(row,function(i,e){
			if(i==0){
				caoa01+=e.caoa01;
			}else{
				caoa01+=","+e.caoa01;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/cation/authentication/del.xf',
		    		data:{caoa01:caoa01},
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
	$('#authenticationList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#authenticationList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addauthentication()" data-options="iconCls:'icon-add'">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editauthentication()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delauthentication()" iconCls="icon-remove">删除</a>
	</div>
	<div class="div-line"></div>		
	<table id="authenticationList" class="datagridClass"></table>
</body>
</html>


