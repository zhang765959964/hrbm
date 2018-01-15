<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/common.jsp" %>
<title></title>
<script>
 function  modifySubmit(){
	 var pw = "${sysUser.cczh02}";  				//正确密码
	 var passWord = $("#1cczh02").val();  			//输入的正确密码
	 var newCczh02 = $("#newCczh02").val();  		//输入的新密码
	 var okNewCczh02 = $("#okNewCczh02").val();  	//确认输入的新密码
	 
	 if(pw==passWord){
		 if(newCczh02==okNewCczh02){
			 $('#sys_user_form').form('submit', {    
				    url:"${ctx}/sys/uums/sysUser/modifySave.xf",    
				    onSubmit: function(params){    
				    	var isValid = $(this).form('validate');
		                return isValid;
				    },    
				    success:function(data){    
				    	var data = eval('(' + data + ')');  
				    	if(data.message){
				    		$.messager.confirm('确认',data.message+" 是否关闭窗口？",function(r){
				    			if(r){
				    				xfui.closeDialog();
				    			}else{
				    			}
				    		}) 	
		    			}else{
		    				$.messager.confirm('确认',"出现未知错误，是否关闭窗口？",function(r){
				    			if(r){
				    				xfui.closeDialog();
				    			}
				    		}) 
		    			} 
				    	var parentIframe=xfui.getParentIframe();
				    	if(parentIframe){
				    		parentIframe.refresh();
				    	}
				    }    
			}); 
		 }else{
			 $.messager.alert("提示","新密码和确认新密码不一致");
		 }
	 }else{
		 $.messager.alert("提示","密码输入错误");
	 }
 }
 
   function closeItem(){
	   xfui.closeDialog();
   }
   
   function resetForm(){
	   $("#sys_user_form").form("clear");
   }
</script>
</head>
<body>
	<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="modifySubmit()" data-options="iconCls:'icon-save'">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="closeItem()" iconCls="icon-clear">关闭</a>
	</div>
<div class="div-line"></div>
	  <form id="sys_user_form" method="post" >
            	<input type="hidden" name="acd230" value="${sysUser.acd230}"/>
            	<input type="hidden" name="cczh02" value="${sysUser.cczh02}">
				<table class="formTable">
					<tr>
					 <td class="formHead" colspan="2">系统人员修改密码</td>
					</tr>
					<tr>
						<td class="formTitle">密码:</td>
						<td class="formInput">
							<input class="easyui-textbox" data-options="required:true" type="password" id="1cczh02" name="1cczh02"></input>
						</td>
					</tr>
					<tr>
						<td class="formTitle">新密码:</td>
						<td class="formInput">
							<input class="easyui-textbox" data-options="required:true" type="password" id="newCczh02" name="newCczh02" value="${sysUser.newCczh02}"></input>
						</td>
					</tr>
					<tr>
						<td class="formTitle">确认新密码:</td>
						<td class="formInput">
							<input class="easyui-textbox" data-options="required:true" type="password" id="okNewCczh02" name="okNewCczh02"></input>
						</td>
					</tr>
				</table>
        </form>
</body>
</html>