<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>摊位初始化表管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@include file="/commons/include/common.jsp" %>
<script>

$(function(){
	/**
	 初始化表格显示
	*/
	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
	                   {field:'ace201',title:'摊位编码',width:100,align:'center'},
	                   {field:'aae100',title:'有效标记',width:100,align:'center'},
	                   {field:'ace203',title:'摊位面积',width:100,align:'center'},
	                   {field:'ace204',title:'座位数',width:100,align:'center'},
	                   {field:'ace205',title:'大厅',width:100,align:'center'},
	                   {field:'acd250',title:'场地编号',width:100,align:'center'},
	                   {field:'ace206',title:'X坐标',width:100,align:'center'},
	                   {field:'ace207',title:'Y坐标',width:100,align:'center'},
	                   {field:'ace208',title:'摊位说明',width:100,align:'center'},
	                   {field:'ace209',title:'摊位屏幕IP地址',width:100,align:'center'},
	                   {field:'aae013',title:'备注',width:100,align:'center'},
	                   {field:'aae011',title:'经办人代码',width:100,align:'center'},
	                   {field:'aae019',title:'经办人',width:100,align:'center'},
	                   {field:'aae020',title:'经办机构',width:100,align:'center'},
	                   {field:'aae017',title:'经办机构代码',width:100,align:'center'},
	                   {field:'aae036',title:'经办日期',width:100,align:'center'},
	                   {field:'aae022',title:'机构行政区划代码',width:100,align:'center'},
	                   {field:'cczy02',title:'基数',width:100,align:'center'},
	                   {field:'cczy03',title:'摊位状态(1-临时2-固定)',width:100,align:'center'},
	                   {field:'cczy04',title:'是否贵宾摊位(0-否1-是)',width:100,align:'center'},
	                   {field:'ccpr05',title:'最后修改时间',width:100,align:'center'},
	                   {field:'ccpr06',title:'修改人',width:100,align:'center'},
	                   {field:'ccpr07',title:'修改来源',width:100,align:'center'},
	                   {field:'ccpr08',title:'是否删除状态（0-否1-是）',width:100,align:'center'},
	                {field:'ace200',title:'操作',width:100,formatter: function(value,row,index){	 
				           return "<a href=\"javascript:void(0)\" onclick=\"stickTop('"+value+"')\" >编辑</a>|"+
								"<a href=\"javascript:void(0)\" onclick=\"previewArticle('"+value+"')\" >删除</a>";
							}
					 }
      	        	]];
	$('#jobFairBoothList').datagrid({
	    url:'${ctx}/business/jobfair/jobFairBooth/listJson.xf',
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

function addJobFairBooth(){	
		xfui.open_dialog({    
		    title: '新增摊位初始化表',    
		    width: 800,    
		    height: 500,    
		    closed: false,    
		    cache: false,    
		    url: "${ctx}/business/jobfair/jobFairBooth/add.xf",
		    modal: true   
		})
}
function editJobFairBooth(){
	var row = $('#jobFairBoothList').datagrid('getSelected');
	if(row){
		var ace200=row.ace200;
		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
		xfui.open_dialog({    
	  		    title: '编辑摊位初始化表',    
	  		    width: 800,    
	  		    height: 500,    
	  		    closed: false,    
	  		    cache: false,    
	  		    url: "${ctx}/business/jobfair/jobFairBooth/edit.xf?ace200="+ace200,
	  		    modal: true   
	  		})
	}else{
		$.messager.alert('提示','请选择记录');
	}			
} 

function delJobFairBooth(){
	var row = $('#jobFairBoothList').datagrid('getSelections');
	if(row&&row.length>0){
		var ace200="";
		$.each(row,function(i,e){
			if(i==0){
				ace200+=e.ace200;
			}else{
				ace200+=","+e.ace200;
			}
			
		});
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.ajax({ url: '${ctx}/business/jobfair/jobFairBooth/del.xf',
		    		data:{ace200:ace200},
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
	$('#jobFairBoothList').datagrid('load');
}
function doSearch(){
	
	var json=$("#searchForm").serializeJson();
	
	$("#jobFairBoothList").datagrid("load",json);
}
</script>
</head>
<body>
   <div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addJobFairBooth()" data-options="iconCls:'icon-add'">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editJobFairBooth()" data-options="iconCls:'icon-edit'">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delJobFairBooth()" iconCls="icon-remove">删除</a>
	</div>
	<div class="div-line"></div>		
	<table id="jobFairBoothList" class="datagridClass"></table>
</body>
</html>


