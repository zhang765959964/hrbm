<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 培训经历表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  submit(){
		 $('#personTrainForm').form('submit', {    
			    url:"${ctx}/business/person/personTrain/save.xf",    
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
   	  <form:form modelAttribute="personTrainForm" method="post" >

				<table class="formTable">
				 <form:hidden path="acc0b0" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="2">培训经历表基本信息</td>
					</tr>
						<tr>
							<td class="formTitle">个人编号: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aac001"  data-options="required:true"></form:input>
						</tr>
						<tr>
							<td class="formTitle">备注: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae013"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经办人代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae011"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经办机构代码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae017"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">经办日期: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aae036" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">经办人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae019"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">经办机构名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae020"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">机构行政区划: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae022"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">培训机构名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acc0b1"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">培训课程: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acc0b2"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">培训内容: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acc0b3"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">开始时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aae030" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">结束时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="aae031" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">资格证书号码: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acc02i"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">数据来源0未知1网站2窗口: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="cczy06"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle" width="200px">最后修改时间: </td>
							<td class="formInput"><form:input class="easyui-datebox" type="text" path="ccpr05" data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">修改人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr06"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">修改来源: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr07"  data-options="required:false"></form:input>
						</tr>
						<tr>
							<td class="formTitle">是否删除状态（0-否1-是）: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="ccpr08"  data-options="required:false"></form:input>
						</tr>
				</table>
        </form:form>
</body>
</html>
