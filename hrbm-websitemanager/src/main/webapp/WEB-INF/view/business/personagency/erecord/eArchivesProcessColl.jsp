<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:forEach var="eArchives" items="${eArchivesList}">			
					<li class="selList process" >
					   <a href="javascript:imageShow('${eArchives.imagePath}')"><img  src="${fileDirectory}/${eArchives.imageCompressPath}" /></a>
					    <input type="checkbox" name="" value="${eArchives.id}">
					    <a href="javascript:useEArch(this,'${eArchives.id}')" >采用</a>
						<a href="javascript:void(0)" onclick="deleteEArch(this,'${eArchives.id}')">删除</a>
					</li>		
</c:forEach>
