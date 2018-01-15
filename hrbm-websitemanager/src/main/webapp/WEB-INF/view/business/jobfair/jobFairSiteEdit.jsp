<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 场地</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  submit(){
		 $('#jobFairSiteForm').form('submit', {    
			    url:"${ctx}/business/jobfair/jobFairSite/save.xf",    
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
   	  <form:form modelAttribute="jobFairSiteForm" method="post" >
				<table class="formTable">
				 <form:hidden path="acd250" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="4">场地基本信息</td>
					</tr>
					<%-- <tr>
						<td class="formTitle">场地代码: </td>
						<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acd252"  data-options="required:false"></form:input></td>
						<td class="formTitle">场地权属: </td>
						<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acd251"  data-options="required:false"></form:input></td> 
						
					</tr> --%>
					<tr>
						<td class="formTitle">场地名称: </td>
						<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acd253"  data-options="required:true"></form:input></td>
						<td class="formTitle">摊位面积: </td>
						<td class="formInput"><form:input  class="easyui-numberbox" type="text"  path="acd257" style="width:125px;" data-options="required:false"></form:input>&nbsp;(单位:平方)</td>
						</tr>
						<tr>
							<td class="formTitle">经办人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae019"  data-options="required:false,readonly:true"></form:input></td>
							<td class="formTitle">经办机构: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae020"  data-options="required:false,readonly:true"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">经办日期: </td>
							<td class="formInput">
							<input class="easyui-textbox" data-options="readonly:true" type="text" name="aae036" value='<fmt:formatDate value="${jobFairSiteForm.aae036}" pattern="yyyy-MM-dd" />'/>
							<%-- <form:input class="easyui-datebox" type="text" path="aae036" data-options="required:false,readonly:true"></form:input> --%></td>
							<td class="formTitle">摊位数: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cczc001"  data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">联系电话: </td>
							<td class="formInput"><form:input  class="easyui-numberbox" type="text"  path="cczc006"  data-options="required:false"></form:input></td>
							<td class="formTitle">场地性质: </td>
							<td class="formInput">
								<form:select class="combobox" path="cczc003">
								   <form:option value="0" label="临时"/>
								   <form:option value="1" label="固定"/>
							    </form:select>
						</tr>
						<tr>
							<td class="formTitle">场地地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cczc004"  data-options="required:false"></form:input></td>
							<td class="formTitle">乘车路线: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cczc005"  data-options="required:false"></form:input></td>
						</tr>
						<tr>
						<td class="formTitle">备注: </td>
						<td class="formInput" colspan="3"><form:textarea   type="text" style="width:300px;height:80px;" path="aae013"  data-options="required:false"></form:textarea></td>
					</tr>
				</table>
        </form:form>
</body>
</html>
