<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 查询机管理表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  submit(){
		 $('#machineForm').form('submit', {    
			    url:"${ctx}/business/machine/machine/save.xf",    
			    onSubmit: function(params){    
			    	var isValid = $(this).form('validate');
	                return isValid;
			    },    
			    success:function(data){   
			    	var data = eval('(' + data + ')');  
			    	if(data.result==1){

						window.location.href = "${ctx}/business/machine/machine/edit.xf?id="+data.message;
	    			}else{
	    				$.messager.alert('系统提示',"出现未知错误") ;
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
   	  <form:form modelAttribute="machineForm" method="post" >
				<table class="formTable">
				 <form:hidden path="id" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="2">查询机管理表基本信息</td>
					</tr>
						<tr>
							<td class="formTitle">查询机名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineName"  data-options="required:true"></form:input>
						</tr>
						<tr>
							<td class="formTitle">查询机位置: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineAddress"  data-options="required:true"></form:input>
						</tr>
						<tr>
							<td class="formTitle">查询机Ip地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineIp"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">查询机编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="machineCode"  data-options="required:false"></form:input>
						</tr>
				</table>
        </form:form>
</body>
</html>
