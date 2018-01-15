<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统配置</title>
<%@include file="/commons/include/common.jsp" %>
<script type="text/javascript"  src='${ctx}/js/sys/config/sysConfig.js'></script>
<script>
	function doSearch(){
		
		var json=$("#searchForm").serializeJson();
		
		$("#dgConfig").datagrid("load",json);
	}
 	
	 
</script>
</head>
<body>
 <!-- 工具栏 -->
	<div style="padding:5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="doSearch()" iconCls="icon-search" >查询</a>
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="addConfig()"  data-options="iconCls:'icon-add'">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="editConfig()" data-options="iconCls:'icon-edit'">修改</a>
		 <a href="javascript:void(0)" class="easyui-linkbutton " onclick="delConfig()" iconCls="icon-remove" >删除</a> 
		
		
	</div>
	<div class="div-line"></div>
			<div class="panel-search" style="padding-bottom:5px">
				<form id="searchForm" >
					<fieldset>
			    		<legend>查询条件</legend>
			    		<table cellpadding="5" class="formTable">
					    	<tr>
								<td class="formTitle" >标题:</td>
								<td class="formInput" ><input class="easyui-textbox"  type="text" name="Q_title_SL" ></input></td>
								<td class="formTitle" >配置项:</td>
								<td class="formInput" ><input class="easyui-textbox"  type="text" name="Q_code_SL" ></input></td>
								 <td class="formTitle" >内容:</td>
								<td class="formInput" ><input class="easyui-textbox"  type="text" name="Q_content_SL" ></input></td>
								<td class="formTitle" >URL:</td>
								<td class="formInput" ><input class="easyui-textbox"  type="text" name="Q_url_SL" ></input></td>
								
							</tr>	
					</table>
			    </fieldset>	
				</form>
			</div>
			<div class="div-line"></div>
	  
		<table id="dgConfig" class="datagridClass" >
	       
	    </table>
      
 
 
 
</body>
</html>