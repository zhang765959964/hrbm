<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统配置</title>
<%@include file="/commons/include/common.jsp" %>
<%@include file="/commons/include/message.jsp" %>

 <script type="text/javascript">
  
 	function saveBaseConfig(){
 		var isValid = $("#fm_base_config").form('validate');
 	
        if(isValid){
  
        	$("#fm_base_config").submit();
        }           
 	}
 	$(function(){
		//初始化树
		initCityTree(selectDefault);
		//拼音码
	 	
		var width= $("#citySel").css("width");
		$("#menuContent").width(width);
		
	});
	 
	function selectDefault(){
	 
	  <c:if test="${not empty districtConfig }">
			var treeObj = $.fn.zTree.getZTreeObj("treeCity");
			var node = treeObj.getNodeByParam("code", "${districtConfig.value }");
			treeObj.selectNode(node,false)
			$("#citySel").val(node.name);
		</c:if>  
	}
 </script>
</head>
<body>
 <div style="padding:5px 5px;">
		<a href="javascript:void(0)" class="easyui-linkbutton " onclick="saveBaseConfig()" data-options="iconCls:'icon-save'">保存</a>
	</div>
<hr>
  <form id="fm_base_config" method="post" action=" ${ctx}/sys/config/sysConfig/saveBaseConfig.xf" >
			<table cellpadding="5" class="formTable">
						<tr>
						 <td class="formHead" colspan="4">基础配置信息</td>
						<tr>
						<c:forEach items="${baseConfigs }" var="config" varStatus="index" >
							
							<c:set var="flag" value="true" ></c:set>
							<c:if test="${(index.count%2==1 )}">
								<tr> 
								<c:set var="flag" value="false"/>
							</c:if>
							
	    				 
							<td class="formTitle">${config.label }:<input type="hidden" name="id" value="${config.id}"></td>
							<td class="formInput">
							<c:choose>
								<c:when test="${config.name eq 'districtCode'}">
									 
									<input type="text"  class="textbox"  style="height:20px;cursor:pointer;"
										 onclick="showMenu()" id="citySel"  readonly="readonly"  required="required"></input>
									    <input type="hidden"   name="name"   id="districtCode"  value="${config.value }"></input>
										 <div id="menuContent" class="menuContent" style="display:none; position: absolute;z-index:10000;">
											<ul id="treeCity" class="ztree" style="margin-top:0; height:200px;overflow-y:scroll;"></ul>
									</div>
								</c:when>
								<c:otherwise>
								<input class="easyui-textbox" type="text"  name="name" value="${config.value }" required="required"></input>
								</c:otherwise>
							</c:choose>
							
							</td>
							
							
							 
							<c:if test="${flag}">
								</tr>
							</c:if>
							
						
						</c:forEach>
						
						
						</table>
</form>
</body>
</html>