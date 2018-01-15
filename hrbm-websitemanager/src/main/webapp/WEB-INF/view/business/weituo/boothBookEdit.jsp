<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>审核 委托招聘信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/common.jsp" %>
	<script type="text/javascript">
	 function  approve(approveFlag){
		 var cczy01=$("#cczy01").val();
		 var acb210=$("#acb210").val();
		 var acb200=$("#acb200").val();
			 $.ajax({ url: '${ctx}/business/jobfair/boothBook/approveweituo.xf',
				 data:{approveFlag:approveFlag,cczy01:cczy01,acb210:acb210,acb200:acb200},
				 dataType:'json',
				 success: function(data){
					 if(data.message){
						 $.messager.alert('提示',data.message,'',function(){
							 var parentIframe=xfui.getParentIframe();
							 if(parentIframe){
								 parentIframe.refresh();
							 } 	
							 closeItem();
						 });
					 }else{
						 $.messager.alert('提示',"未知错误");
					 }
					 
				 }
			 });
		 }
		function closeItem(){
		   	xfui.closeTab();
	  }
	</script>
</head>
<body >
	<div id="dg_toolbar" style="padding: 5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="approve(0)" data-options="iconCls:'icon-save'">通过</a>
		<a href="javascript:void(0)" class="easyui-linkbutton tb_add" onclick="approve(1)" data-options="iconCls:'icon-save'">不通过</a>
		<a href="javascript:void(0)" class="easyui-linkbutton tb_destory" onclick="closeItem()" iconCls="icon-clear">关闭</a>
	</div>
				    <input id="cczy01" type="hidden" name="cczy01" value="${boothBook.cczy01}"/>
					<table class="formTable">
						<tr>
						 <td class="formHead" colspan="2">委托招聘基本信息</td>
						</tr>
					</table>
					<c:if test="${! empty jobFairInfo}">
					<fieldset>
						<legend>招聘会信息</legend>
						<form:form modelAttribute="jobFairInfo" method="post" >
						<table class="formTable">
							<tr>
								<td class="formTitle">招聘会名称：</td>
								<td class="formInput">${jobFairInfo.acb331 }</td>
								<td class="formTitle">招聘会主题：</td>
								<td class="formInput">${jobFairInfo.acb332 }</td>
							</tr>
							<tr>
								<td class="formTitle">开始日期： </td>
								<td class="formInput"><form:input  class="easyui-datebox" readonly="true" path="acb333"  data-options="required:false"></form:input></td>
								<td class="formTitle">结束日期： </td>
								<td class="formInput"><form:input  class="easyui-datebox" readonly="true" path="acb334"  data-options="required:false"></form:input></td>
							</tr>
						</table>
						</form:form>
					</fieldset>
					</c:if>
					<c:if test="${! empty corpPositionPublish}">
						<fieldset>
							<legend>企业信息</legend>
							<table class="formTable">
								<tr>
									<td class="formTitle">企业名称： <input id="acb200" type="hidden" name="acb200" value="${corpPositionPublish.acb200}"/></td>
									<td class="formInput" >${corpPositionPublish.aab004}</td>
									<td class="formTitle">企业证书： </td>
									<td class="formInput">${corpPositionPublish.name5}</td>
								</tr>
								<tr>
									<td class="formTitle">证书号码： </td>
									<td class="formInput">${corpPositionPublish.aab007}</td>
									<td class="formTitle">人员规模： </td>
									<td class="formInput">${corpPositionPublish.name4}</td>
								
								</tr>
								<tr>
									<td class="formTitle">所属行业： </td>
									<td class="formInput">${corpPositionPublish.name3}</td>
									<td class="formTitle">经济类型： </td>
									<td class="formInput">${corpPositionPublish.name2}</td>
								</tr>
								<tr>
									<td class="formTitle">联系人： </td>
									<td class="formInput">${corpPositionPublish.aae004}</td>
									<td class="formTitle">联系人电话： </td>
									<td class="formInput">${corpPositionPublish.aae005}</td>
								</tr>
								<tr>
									<td class="formTitle">联系人手机号： </td>
									<td class="formInput">${corpPositionPublish.aae139}</td>
									<td class="formTitle">地址： </td>
									<td class="formInput">${corpPositionPublish.acb204}</td>
								</tr>
								<tr>
									<td class="formTitle">企业简介： </td>
									<td class="formInput" colspan="3"><table class="formTable"><tr><td style="text-align: left;width:500px">${corpPositionPublish.acb206}</td></tr></table></td>
								</tr>
							</table>
						</fieldset>					
					</c:if>
					<c:if test="${! empty corpPositionForm}">
					<fieldset>
						<legend>招聘职位信息</legend>
						<form:form modelAttribute="corpPositionForm" method="post" readonly="true">
							<table class="formTable">
								<form:hidden path="acb210" ></form:hidden>
								<tr>
									<td class="formTitle">企业名称： </td>
									<td class="formInput" >${corpPositionForm.aab004}</td>
									<td class="formTitle">职位名称： </td>
									<td class="formInput">${corpPositionForm.aca112}</td>
								</tr>
								<tr>
									<td class="formTitle">详细职位名称： </td>
									<td class="formInput">${corpPositionForm.bca112}</td>
									<td class="formTitle">性别： </td>
									<td class="formInput">
											<c:choose >
												<c:when test="${corpPositionForm.aad004==1 }">
													男性
												</c:when>
												<c:when test="${corpPositionForm.aad004==2 }">
													女性
												</c:when>
												<c:otherwise>
													无要求
												</c:otherwise>
											</c:choose>
									</td>
								</tr>
								<tr>
									<td class="formTitle">招聘人数： </td>
									<td class="formInput">${corpPositionForm.acb21r}</td>
									<td class="formTitle" width="200px">终止日期： </td>
									<td class="formInput"><input class="easyui-textbox" data-options="readonly:true" type="text" name="aae031" value='<fmt:formatDate value="${corpPositionForm.aae031 }" pattern="yyyy-MM-dd" />'/></td>
								</tr>
								<tr>
									<td class="formTitle">学历要求： </td>
									<td class="formInput" >
									<c:forEach items="${education}" var="acc">
												${acc.education}
									</c:forEach>
									</td>
									<td class="formTitle">月工资： </td>
									<td class="formInput" >
									<c:forEach items="${salary}" var="acc">
												${acc.salary}
									</c:forEach>
									</td>
								</tr>
								<tr>
									<td class="formTitle">工作性质： </td>
									<td class="formInput" >
										 <c:forEach items="${nature}" var="acc">
												${acc.nature}
										 </c:forEach>
									</td>
									<td class="formTitle">工作经验： </td>
									<td class="formInput" >
										 <c:forEach items="${workyear}" var="acc">
												${acc.workyears}
										 </c:forEach>
									</td>
								</tr>
								<tr>
									<td class="formTitle">福利待遇： </td>
									<td class="formInput" >
										 <c:forEach items="${welfare}" var="acc">
												${acc.welfare}|
										 </c:forEach>
									</td>
									<td class="formTitle">食宿提供： </td>
									<td class="formInput">
										<c:choose >
										<c:when test="${corpPositionForm.acb228==0 }">
										否
										</c:when>
										<c:when test="${corpPositionForm.acb228==1 }">
										提供住宿
										</c:when>
										<c:when test="${corpPositionForm.acb228==2 }">
										提供工作餐
										</c:when>
										<c:otherwise>
										提供住宿和工作餐
										</c:otherwise>
										</c:choose>
									</td>
								</tr>
								<tr>
									<td class="formTitle">工作地点： </td>
									<td class="formInput" colspan="3">${corpPositionForm.aab040}</td>
								</tr>
								<tr>
									<td class="formTitle">职位说明： </td>
									<td class="formInput" colspan="3">
									<table class="formTable"><tr><td style="text-align: left;width:500px">${corpPositionForm.cca114}</td></tr></table>
									</td>
								</tr>
							</table>
						</form:form>
					</fieldset></c:if>
</body>
</html>
