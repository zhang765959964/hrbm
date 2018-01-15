<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/common.jsp" %>
<title>编辑字典项</title>
<script>
function  submit(){
	 
	 $('#fm_item').form('submit', {    
		    url:"${ctx}/sys/dic/dictionaryItem/save.xf",    
		    onSubmit: function(params){    
		           
		    },    
		    success:function(data){  
		    	var data = eval('(' + data + ')');  
		    	if(data.message){
		    		$.messager.confirm('确认',data.message+"成功！ 是否关闭窗口？",function(r){
		    			if(r){
		    				xfui.closeDialog();
		    			}
		    		}) 	
   			}else{
   				$.messager.confirm('确认',"出现未知错误，是否关闭窗口？",function(r){
		    			if(r){
		    				xfui.closeDialog();
		    			}
		    		}) 
   			}
		    	
		    	xfui.getParentIframe().refreash_dg_data();
		    }    
		}); 
}
 function closeItem(){
	  
	  xfui.closeDialog();
 }
 </script>
</head>
<body>
<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="submit()" data-options="iconCls:'icon-save'">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="closeItem()" iconCls="icon-clear">关闭</a>
	</div>
<hr/>

			<form id="fm_item" method="post" novalidate>
       			 <input type="hidden" name="id" value="${dictionaryItem.id }"/>
       			 <input type="hidden" name="typeId" id="itemTypeId" value="${dictionaryItem.typeId }"/>
				<table cellpadding="5" class="formTable">
					<tr>
						 <td class="formHead" colspan="4">字典项</td>
						</tr>
					<tr>
						<td class="formTitle">名称:</td>
						<td class="formInput"><input class="easyui-textbox" type="text" required="required" name="itemText" value="${dictionaryItem.itemText }"></input></td>
					 
						<td class="formTitle">值:</td>
						<td class="formInput"><input class="easyui-textbox" type="text"  required="required" name="itemValue" value="${dictionaryItem.itemValue }" ></input></td>
					</tr>
					<tr>
						<td class="formTitle">描述:</td>
						<td class="formInput" colspan="3"><input class="easyui-textbox" name="itemDesc" value="${dictionaryItem.itemDesc }"
							data-options="multiline:true,fit:true"></input></td>
					</tr>
				</table>
        </form>
</body>
</html>