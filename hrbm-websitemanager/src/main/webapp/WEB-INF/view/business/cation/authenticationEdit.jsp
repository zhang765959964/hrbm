<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 网上认证提交信息表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  submit(){
		 $('#authenticationForm').form('submit', {    
			    url:"${ctx}/business/cation/authentication/save.xf",    
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
   	  <form:form modelAttribute="authenticationForm" method="post" >

				<table class="formTable">
				 <form:hidden path="caoa01" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="2">网上认证提交信息表基本信息</td>
					</tr>
						<tr>
							<td class="formTitle">用户编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccmu01"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">提交营业执照扫描件的地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="caoa02"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">说明文字: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="caoa03"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频): </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="caoa04"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">提交时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="caoa05" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">从业人员编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acd230"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">处理认证日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="caoa06" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">是否通过认证(0-未审核1-审核已通过2-审核失败3-退回资料4-自动审核): </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="caoa07"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">认证意见备注: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="caoa08"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否删除状态（0-否1-是）: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr08"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">数据来源1网站3民营职介4-公办职介: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cczy06"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否已经上传(0-未上传1-已上传): </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="caoa09"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">提交法人身份证扫描件的地址: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="caoa10"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">单位编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab001"  data-options="required:false"></form:input>
						</tr>
				</table>
        </form:form>
</body>
</html>
