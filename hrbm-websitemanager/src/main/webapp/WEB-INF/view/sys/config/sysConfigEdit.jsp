<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/common.jsp" %>
<script>
	function saveConfig(){
		   $('#fm_config').form('submit',{
	        url: CTX+'/sys/config/sysConfig/save.xf',
	        onSubmit: function(data){
	           return $(this).form('validate');
	        },
	        success: function(result){
	            var result = eval('('+result+')');
	            
	            if(result.result==1){
		    		$.messager.confirm('确认',result.message+"系统配置成功！ 是否关闭窗口？",function(r){
		    			if(r){
		    				closeDialog();
		    			}
		    		}) 	
    			}else{
    				$.messager.confirm('确认',"出现未知错误，是否关闭窗口？",function(r){
		    			if(r){
		    				closeDialog(); 
		    			}
		    		}) 
    			} 
	            
	        }
	    });
	
	}
	
	function closeDialog(){
		var parentIframe=xfui.getParentIframe();
		if(parentIframe){
			parentIframe.refresh();
		}
		 xfui.closeDialog();
	}
	 
</script>
<title>编辑配置</title>
</head>
<body>
<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="saveConfig()" data-options="iconCls:'icon-save'">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="closeDialog()" iconCls="icon-clear">关闭</a>
	</div>
<div class="div-line"></div>
			<form id="fm_config" method="post" >
            	<input type="hidden" name="id" value="${sysConfig.id }"/> 
            	<input type="hidden" name="createBy" value="${sysConfig.createBy }"/> 
				<input type="hidden" name="updateBy" value="${sysConfig.updateBy }"/> 
				<table cellpadding="5" class="formTable">
					<tr>
					 <td class="formHead" colspan="4">系统配置信息</td>
					<tr>
					 
					<tr >
						<td class="formTitle">标题:</td>
						<td class="formInput"><input class="easyui-textbox" required="required"  type="text" name="title"  value="${sysConfig.title }" ></input></td>
						<td class="formTitle">配置项:</td>
						<td class="formInput">
						<input class="easyui-textbox"  required="required"  
							<c:if test="${not empty sysConfig.id }">
								readonly="readonly"
							</c:if>
						type="text" name="code" value="${sysConfig.code }"></input>
						</td>
					</tr>
					<tr >
						<td class="formTitle">内容:</td>
						<td class="formInput"><input class="easyui-textbox"   type="text" name="content"  value="${sysConfig.content }" ></input></td>
						<td class="formTitle">URL:</td>
						<td class="formInput"><input class="easyui-textbox"   type="text" name="url" value="${sysConfig.url }"></input></td>
					</tr>
					<tr >
						<td class="formTitle">描述:</td>
						<td class="formInput" colspan="3">
						<input class="easyui-textbox" type="text"  data-options="multiline:true,height:50,width:640"  name="description" 
						value="${sysConfig.description }"></input></td>
						 

					</tr>
					<c:choose>
						<c:when test="${empty sysConfig.id }">
							<tr >
								<td class="formTitle">创建者:</td>
								<td class="formInput"><input class="easyui-textbox" readonly="readonly"  type="text" name="createUserName"  value="${sysConfig.createUserName }" ></input></td>
								<td class="formTitle">创建时间:</td>
								<td class="formInput">
								<input class="easyui-textbox"   type="text" readonly="readonly" name="createTime"
								value="<fmt:formatDate value="${sysConfig.createTime }" pattern="yyyy-MM-dd" />"
								></input></td>
							 
	
							</tr>
						</c:when>
						<c:otherwise>
						<tr >
								<td class="formTitle">修改者:</td>
								<td class="formInput"><input class="easyui-textbox"  readonly="readonly" type="text" name="createUserName"  value="${sysConfig.updateUserName }" ></input></td>
								<td class="formTitle">修改时间:</td>
								<td class="formInput">
								<input class="easyui-textbox"   type="text" readonly="readonly" name="updateTime"
								value="<fmt:formatDate value="${sysConfig.updateTime }" pattern="yyyy-MM-dd" />"
								></input></td>
							 
	
							</tr>
						</c:otherwise>
					</c:choose>
					
				 
					
				</table>
        </form>
</body>
</html>