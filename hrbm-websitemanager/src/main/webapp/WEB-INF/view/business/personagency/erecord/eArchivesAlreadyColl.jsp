<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="moduleTit">信息详情</div>
<c:forEach var="eArchives" items="${eArchivesList}">
		<li class="selList" >
					   <a href="javascript:imageShow('${eArchives.imagePath}')"><img  src="${fileDirectory}/${eArchives.imageCompressPath}"/></a>
					   <input type="checkbox" name="" value="${eArchives.id}">
						<a href="javascript:void(0)"  onclick="deleteEArch(this,'${eArchives.id}')">删除</a>
		</li>	
</c:forEach>
<input type="hidden" id="totalCount" value="${totalCount}">
<input type="hidden" id="currentPage" value="${currentPage}">
<input type="hidden" id="totalPage" value="${totalPage}">
<input type="hidden" id="isHasPreviousPage" value="${isHasPreviousPage}">
<input type="hidden" id="isHasNextPage" value="${isHasNextPage}">
<script>

	function  sortImage(targetId,sourceId){
		var personId=$("#personId").val();
		$.ajax({ url: '${ctx}/business/erecord/eArchives/sortImage.xf',
			data:{"targetId":targetId,"sourceId":sourceId,"personId":personId},
			success: function(data){

			}
		});
	}
	
</script>