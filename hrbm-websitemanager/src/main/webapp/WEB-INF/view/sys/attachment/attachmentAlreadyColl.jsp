<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:forEach var="eArchives" items="${attachmentList}">
	<div  class="imgContent" archivesid="${eArchives.caoa01}" style="border: solid 1px darkgray;width: auto;height: auto;float: left;text-align: center ;margin: 2px">
		<a>
			<img onclick="imageShow('${eArchives.caoa01}')" src="${ctx}/sys/attachment/attachment/getImageById.xf?filePath=${eArchives.caoa02}&type=compress" 
				alt="拖动可以排序" style="width: 150px;height: 150px;margin: 5px"/>
		</a>
		<div style="padding: 5px 5px;">
			<input type="checkbox" value="${eArchives.caoa01}">
			<a href="javascript:void(0)" class="easyui-linkbutton tb_add"  
				onclick="deleteEArch(this,'${eArchives.caoa01}')" data-options="iconCls:'icon-no'">删除
			</a>
			${eArchives.caoa03}
		</div>
	</div>
</c:forEach>
<input type="hidden" id="totalCount" value="${totalCount}">
<input type="hidden" id="currentPage" value="${currentPage}">
<input type="hidden" id="totalPage" value="${totalPage}">
<input type="hidden" id="isHasPreviousPage" value="${isHasPreviousPage}">
<input type="hidden" id="isHasNextPage" value="${isHasNextPage}">

<script>
	$(function(){
		$.parser.parse($('#alreadyCollect'));
	})
	$(function(){
		var indicator = $('<div class="indicator">>></div>').appendTo('body');
		$('.imgContent').draggable({
			revert:true,
			deltaX:0,
			deltaY:0,
			onBeforeDrag:function(e){
				e.preventDefault();
				e.stopPropagation();
				return true;
			}
		}).droppable({
			onDragOver:function(e,source){
				indicator.css({
					display:'block',
					left:$(this).offset().left-10,
					top:$(this).offset().top+$(this).outerHeight()-5
				});
			},
			onDragLeave:function(e,source){
				indicator.hide();
			},
			onDrop:function(e,source){
				$(source).insertBefore(this);
				indicator.hide();
				var targetId=$(this).attr("archivesid");
				var sourceId=$(source).attr("archivesid");
				/* sortImage(targetId,sourceId) */

			}
		});
	});

	/* function  sortImage(targetId,sourceId){
		var personId=$("#personId").val();
		$.ajax({ url: '${ctx}/business/erecord/eArchives/sortImage.xf',
			data:{"targetId":targetId,"sourceId":sourceId,"personId":personId},
			success: function(data){

			}
		});
	} */
</script>