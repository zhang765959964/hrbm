<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 

 				<table cellpadding="5" class="formTable">
					<tr>
						<td class="formTitle"  >个人编号:</td>
						<td class="formInput"  >
						
							<c:choose>
							<c:when test="${not empty param.personNumberEdit and param.personNumberEdit}">
								<input  type="text" class="easyui-textbox"  data-options="
								validType:['isExist[&quot;${ctx }/business/person/expand/isExist.xf?noPersonId=${personInfo.personId }&quot;,&quot;expPersonNumber&quot;]','intAndZiMu','length[1,32]']" name="personNumber" value="${personInfo.personNumber }"/>
							</c:when>
							
							<c:otherwise>
								${personInfo.personNumber }
							</c:otherwise>
						</c:choose>
							 
						
						</td>
						<td class="formTitle"  >姓名:</td>
						<td class="formInput"  >
							${personInfo.personName }
						</td>
					</tr>
					<tr>
						
						<td class="formTitle" >身份证号:</td>
						<td class="formInput">${personInfo.unId }</td> 
						<td class="formTitle">性别:</td>
						<td class="formInput">${personInfo.gender }</td>
					</tr>
					<tr>
						 <td class="formTitle">参加工作时间:</td>
						<td class="formInput"><fmt:formatDate value="${personInfo.startJobTime }" pattern="yyyy-MM-dd" /></td>
						 
					
						<td class="formTitle">出生日期:</td>
						<td class="formInput"><fmt:formatDate value="${personInfo.birthday }" pattern="yyyy-MM-dd" /></td>
					</tr>
					 
				</table>