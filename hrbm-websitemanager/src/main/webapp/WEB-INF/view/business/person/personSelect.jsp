<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 个人基本信息表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 
	  function closeItem(){
		  
		  xfui.closeDialog();
	  }
	</script>
</head>
<body>
	<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="closeItem()" iconCls="icon-clear">关闭</a>
	</div>
   <div class="div-line"></div>
   	  <form:form modelAttribute="person" method="post" >

				<table class="formTable">
				 <form:hidden path="aac001" ></form:hidden>
					<tr>
					 <td class="formHead" colspan="4">个人基本信息表基本信息</td>
					</tr>
						<tr>
							<td class="formTitle">姓名: </td>
							<td class="formInput">${person.aac003}</td>
							<td class="formTitle">公民身份证号码: </td>
							<td class="formInput">${person.aac002}</td>
						</tr>
						<tr>
							<td class="formTitle">性别: </td>
							<td class="formInput">
								<c:choose >
									<c:when test="${person.aac004==1 }">
									男性
									</c:when>
									<c:when test="${person.aac004==2 }">
									女性
									</c:when>
								</c:choose>
							</td>
							<td class="formTitle" >出生日期: </td>
							<td class="formInput"><input class="easyui-textbox"data-options="readonly:true" type="text" value="<fmt:formatDate value="${person.aac006 }" pattern="yyyy-MM-dd " />" /></td>
						</tr>
						<tr>
							<td class="formTitle">户口所在地: </td>
							<td class="formInput" >${person.bab305 }</td>
							<td class="formTitle">联系电话: </td>
							<td class="formInput">${person.aae005 }</td>
						</tr>
						<tr>
							<td class="formTitle">文化程度: </td>
							<td class="formInput"></td>
							<td class="formTitle">居住所在地: </td>
							<td class="formInput" >${person.aab301 }</td>
						</tr>
						<tr>
							<td class="formTitle">专业类别名称: </td>
							<td class="formInput" >${person.aac039}</td>
							<td class="formTitle">专业名称: </td>
							<td class="formInput" >${person.aac040}</td>
						</tr>
						<tr>
						</tr>
						<tr>
							<td class="formTitle">毕业学校: </td>
							<td class="formInput">${person.aac180 }</td>
							<td class="formTitle" >毕业时间: </td>
							<td class="formInput"><input class="easyui-textbox"data-options="readonly:true" type="text" value="<fmt:formatDate value="${person.aac181 }" pattern="yyyy-MM-dd " />" /></td>
						</tr>
						<tr>
							<td class="formTitle">政治面貌: </td>
							<td class="formInput"></td>
							<td class="formTitle">电子信箱: </td>
							<td class="formInput">${person.aae015 }</td>
						</tr>
						<tr>
							<td class="formTitle">修改人: </td>
							<td class="formInput" >${person.ccpr06}</td>
							<td class="formTitle" >最后修改时间: </td>
							<td class="formInput">
								<input class="easyui-textbox"data-options="readonly:true" type="text" value="<fmt:formatDate value="${person.ccpr05 }" pattern="yyyy-MM-dd " />" />
							</td>
						</tr>
						<tr>
							<td class="formTitle">个人简介: </td>
							<td class="formInput" colspan="3" style="min-width: 80px;width: 200px;">${person.aac041}</td>
						</tr>
						<tr>
							<td class="formTitle">技能简介: </td>
							<td class="formInput" colspan="3" style="min-width: 80px;width: 200px;">${person.aac042}</td>
						</tr>
						
				</table>
        </form:form>
</body>
</html>
