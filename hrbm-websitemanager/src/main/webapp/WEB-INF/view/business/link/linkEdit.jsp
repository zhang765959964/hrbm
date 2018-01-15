<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 网站友情链接表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  submit(){
		 $('#linkForm').form('submit', {    
			    url:"${ctx}/business/link/link/save.xf",    
			    onSubmit: function(params){    
			    	var isValid = $(this).form('validate');
	                return isValid;
			    },    
			    success:function(data){   
			    	var data = eval('(' + data + ')');  
			    	if(data.message){
			    		$.messager.alert('系统提示',data.message,'',function(r){		    			
			    				xfui.closeDialog();
			    		}) 	
	    			}else{
	    				$.messager.alert('系统提示',"出现未知错误") ;
	    			}
			    	var parentIframe=xfui.getParentIframe();
			    	if(parentIframe){
			    		parentIframe.refresh();
			    	}
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
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="submit()" data-options="iconCls:'icon-save'">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="closeItem()" iconCls="icon-clear">关闭</a>
	</div>
   <div class="div-line"></div>
   	  <form:form modelAttribute="linkForm" method="post" >

				<table class="formTable">
				 <form:hidden path="ccmw01" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="2">网站友情链接表基本信息</td>
					</tr>
						<tr>
							<td class="formTitle" width="200px">网站名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccmw02"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">链接地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccmw03"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">添加日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="ccmw04" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">链接分类: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccmw05"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">排序: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccmw06"  data-options="required:false"></form:input>
						</tr>
				</table>
        </form:form>
</body>
</html>
