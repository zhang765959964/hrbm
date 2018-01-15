<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/common.jsp" %>
<title>编辑字典类型</title>
<script>
function  submit(){
	 
	 $('#form_dictionary_type').form('submit', {    
		    url:"${ctx}/sys/dic/dictionaryType/save.xf",    
		    onSubmit: function(params){    
		           
		    },    
		    success:function(data){   
		    	var data = eval('(' + data + ')');  
		    	if(data.message){
		    		$.messager.confirm('确认',"操作成功，是否关闭窗口？",function(r){
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
   			xfui.getParentIframe().refreshTypeTree();
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


		<form id="form_dictionary_type" method="post" >
					<input type="hidden" name="id" value="${dictionaryType.id }"/>
					<input type="hidden" name="parentId" id="parentId" value="${dictionaryType.parentId }"/>
					<table cellpadding="5" class="formTable">
						<tr>
						 <td class="formHead" colspan="4">字典类型</td>
						</tr>
						<tr>
							<td class="formTitle">类型名称:</td>
							<td class="formInput"><input class="easyui-textbox" type="text" required="required" name="typeName" value="${dictionaryType.typeName }" ></input></td>
						 
							<td class="formTitle">类型编码:</td>
							<td class="formInput"><input class="easyui-textbox" type="text"  required="required" name="typeCode" value="${dictionaryType.typeCode }"></input></td>
						</tr>
						<tr>
							<td class="formTitle">描述:</td>
							<td class="formInput" colspan="3"><input class="easyui-textbox" name="typeDes" value="${dictionaryType.typeDes }"
								data-options="multiline:true,fit:true"  ></input></td>
						</tr>
					</table>
	</form>
	  
</body>
</html>