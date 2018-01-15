<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 招聘会信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
    <script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8" src="${ctx}/js/lib/ueditor1.4.3.1/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript" src="${ctx}/js/lib/ajaxfileupload/ajaxfileupload.js"></script>
	<script type="text/javascript">
	$(function(){
	     var um = UE.getEditor('myEditor',{
			 toolbars: [[
				 'fullscreen', 'source', '|', 'undo', 'redo', '|',
				 'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
				 'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
				 'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|', 'indent', '|',
				 'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
				 'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
				 'simpleupload', 'insertimage', 'emotion', 'insertvideo', 'music',  'map', 'insertframe', 'insertcode', 'pagebreak', 'template',  '|',
				 'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
				 'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
				 'print', 'searchreplace', 'help'
			 ]]
		 });
	})
	 function  submit(){
		 $('#jobFairInfoForm').form('submit', {    
			    url:"${ctx}/business/jobfair/jobFairInfo/save.xf",    
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
   	  <form:form modelAttribute="jobFairInfoForm" method="post" >
				<table class="formTable">
				 <form:hidden path="acb330" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="4">招聘会基本信息</td>
					</tr>
						<tr>
							<td class="formTitle">招聘会名称: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acb331"  data-options="required:true"></form:input></td>
							<td class="formTitle">招聘会主题: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acb332"  data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle" width="200px">开始日期: </td>
							<td class="formInput">
							<input class="easyui-datetimebox" type="text" name="acb333"  data-options="required:true,showSeconds: false" value="<fmt:formatDate value="${jobFairInfoForm.acb333 }" pattern="yyyy-MM-dd HH:mm " />" ></input>
							</td>
							<td class="formTitle" width="200px">结束日期: </td>
							<td class="formInput">
							<input class="easyui-datetimebox" type="text" name="acb334"  data-options="required:true,showSeconds: false" value="<fmt:formatDate value="${jobFairInfoForm.acb334 }" pattern="yyyy-MM-dd HH:mm " />" ></input>
							</td>
						</tr>
						<tr>
							<td class="formTitle">招聘会介绍: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acb337"  data-options="required:false"></form:input></td>
							<td class="formTitle">主办单位: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aab045"  data-options="required:false,readonly:true" ></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">承办单位: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="acb338"  data-options="required:false,readonly:true"></form:input></td>
							<td class="formTitle">联系人: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae004"  data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">联系人电话: </td>
							<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae005"  data-options="required:false"></form:input></td>
							<td class="formTitle">电子信箱: </td>
							<td class="formInput">
							<form:input  class="easyui-textbox" type="text"  path="aae159"  data-options="required:false"></form:input></td>
						</tr>
						<tr>
							<td class="formTitle">大会类型: </td>
							<td class="formInput">
								<xf:select tableName="TAB_JFTYPE" name="acb335" valueField="code" textField="name" hasDefault="1" value="${jobFairInfoForm.acb335}"></xf:select></td>
							<td class="formTitle">场地: </td>
							<td class="formInput" >
							   <xf:select tableName="CD25" name="acd200" valueField="acd250" textField="acd253" hasDefault="1" value="${jobFairInfoForm.acd200}"></xf:select></td>
					</tr>
					<tr>
						<td class="formTitle">经办人: </td>
						<td class="formInput"><form:input  class="easyui-textbox" type="text"  path="aae019"  data-options="required:false,readonly:true"></form:input></td>
						<td class="formTitle">经办机构: </td>
						<td class="formInput">
						<form:input  class="easyui-textbox" type="text"  path="aae020"  data-options="required:false,readonly:true"></form:input></td>
					</tr>
					<tr>
						<td class="formTitle" width="200px">经办日期: </td>
						<td class="formInput"  colspan="3" style="width:100%"><form:input class="easyui-datebox" type="text" path="aae036" data-options="required:false,readonly:true"></form:input></td>
					</tr>
					<tr>
						<td class="formTitle">招聘会说明: </td>
							<td class="formInput"  colspan="3">								
									 <form:textarea  id="myEditor" type="text"  path="aae013" data-options="required:false"  style="width:100%;height:50%;"></form:textarea>
							 </td>
					</tr>
				</table>
        </form:form>
</body>
</html>
