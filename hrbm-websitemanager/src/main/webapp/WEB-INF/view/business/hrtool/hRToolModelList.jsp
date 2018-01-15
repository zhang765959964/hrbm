<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!-- <html> -->
<!-- <head> -->
<!-- <title>hr工具箱模板表管理</title> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"> -->
<%-- <%@include file="/commons/include/common.jsp" %> --%>
<!-- <script> -->

// $(function(){
// 	/**
// 	 初始化表格显示
// 	*/
// 	var columns= [[{field:'',title:'Id号',checkbox:'true',width:100,align:'center'},
// 	                   {field:'name',title:'名称',width:100,align:'center'},
// 	                   {field:'code',title:'代码',width:100,align:'center'},
// 	                   {field:'colId',title:'模版栏目Id',width:100,align:'center'},
// 	                   {field:'sortNum',title:'排序',width:100,align:'center'},
// 	                   {field:'description',title:'描述',width:100,align:'center'},
// 	                   {field:'createDate',title:'创建时间',width:100,align:'center'},
// 	                   {field:'createUserId',title:'创建人',width:100,align:'center'},
// 	                   {field:'updateDate',title:'最后修改时间',width:100,align:'center'},
// 	                   {field:'updateUserId',title:'最后修改人',width:100,align:'center'},
// 	                {field:'id',title:'操作',width:100,formatter: function(value,row,index){	 
// 				           return "<a href=\"javascript:void(0)\" onclick=\"stickTop('"+value+"')\" >编辑</a>|"+
// 								"<a href=\"javascript:void(0)\" onclick=\"previewArticle('"+value+"')\" >删除</a>";
// 							}
// 					 }
//       	        	]];
// 	$('#hRToolModelList').datagrid({
// 	    url:'${ctx}/business/hrtool/hRToolModel/listJson.xf',
// 	    columns:columns,
// 	    fitColumns:true,
// 		rownumbers: true,
//         singleSelect: true,
//         checkOnSelect:false,
//         selectOnCheck:false,
// 		pagination: true, 
//         rownumbers: true,
//         multiSort:true,
// 		onLoadSuccess:function(data){
// 			if(data.total>0){
// 				$(this).datagrid("selectRow",0);
// 			}
			
// 		},
//         pageList:[1,5,10]
// 	});
	
// })

// function addHRToolModel(){	
// 		xfui.open_dialog({    
// 		    title: '新增hr工具箱模板表',    
// 		    width: 800,    
// 		    height: 500,    
// 		    closed: false,    
// 		    cache: false,    
// 		    url: "${ctx}/business/hrtool/hRToolModel/add.xf",
// 		    modal: true   
// 		})
// }
// function editHRToolModel(){
// 	var row = $('#hRToolModelList').datagrid('getSelected');
// 	if(row){
// 		var id=row.id;
// 		//xfui.open_tabs("编辑人员","${ctx}/sys/uums/sysUser/edit.xf?acd230="+acd230,"人员管理");
// 		xfui.open_dialog({    
// 	  		    title: '编辑hr工具箱模板表',    
// 	  		    width: 800,    
// 	  		    height: 500,    
// 	  		    closed: false,    
// 	  		    cache: false,    
// 	  		    url: "${ctx}/business/hrtool/hRToolModel/edit.xf?id="+id,
// 	  		    modal: true   
// 	  		})
// 	}else{
// 		$.messager.alert('提示','请选择记录');
// 	}			
// } 

// function delHRToolModel(){
// 	var row = $('#hRToolModelList').datagrid('getSelections');
// 	if(row&&row.length>0){
// 		var id="";
// 		$.each(row,function(i,e){
// 			if(i==0){
// 				id+=e.id;
// 			}else{
// 				id+=","+e.id;
// 			}
			
// 		});
// 		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
// 		    if (r){    
// 		    	$.ajax({ url: '${ctx}/business/hrtool/hRToolModel/del.xf',
// 		    		data:{id:id},
// 		    		dataType:'json',
// 		    		success: function(data){
// 		    			if(data.message){
// 		    				$.messager.alert('提示',data.message); 	
// 		    			}else{
// 		    				$.messager.alert('提示',"未知错误"); 
// 		    			}
		    			
// 		    			refresh();
// 		             }
// 		    	});
// 		    }    
// 		}); 
// 	  }else{
// 		 $.messager.alert('提示','请选择记录');
// 	 }			
// } 
// function refresh(){
// 	$('#hRToolModelList').datagrid('load');
// }
// function doSearch(){
	
// 	var json=$("#searchForm").serializeJson();
	
// 	$("#hRToolModelList").datagrid("load",json);
// }
<!-- </script> -->
<!-- </head> -->
<!-- <body> -->
<!--    <div id="dg_toolbar" style="padding: 5px 5px;"> -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="addHRToolModel()" data-options="iconCls:'icon-add'">添加</a>  -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_edit" onclick="editHRToolModel()" data-options="iconCls:'icon-edit'">修改</a>  -->
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="delHRToolModel()" iconCls="icon-remove">删除</a> -->
<!-- 	</div> -->
<!-- 	<div class="div-line"></div>		 -->
<!-- 	<table id="hRToolModelList" class="datagridClass"></table> -->
<!-- </body> -->
<!-- </html> -->


