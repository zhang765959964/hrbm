<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑单位基本信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <%@include file="/commons/include/commonInc.jsp" %>
     <%@include file="/commons/include/bootstrapInc.jsp" %>
</head>
<body>
	<div class="main-container">
		<div class="container-fluid">
			<div class="mhyMain">
		   		<div class="mhyTitle">单位基本信息</div>
		   		<form:form modelAttribute="corpForm" method="post" action="">
		   			<div class="mhySearchInput1 mhyInputDiv">
		   				<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
								<div class="col-xs-9 col-sm-4">
								<input  class="form-control" type="text" value="${corpForm.aab004 }" readonly="readonly"/>
									
								</div>
								<label class="col-xs-3 col-sm-2" for="inputError" title="工商登记执照号码">工商登记执照号码:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab007}" readonly="readonly"/></div>
		   				</div>
		   				<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">单位性质:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab019}" readonly="readonly"/></div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位状态:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="登记在册" readonly="readonly"/></div>		
		   				</div>
		   				<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="工商执照起始日期">工商执照起始日期:</label>
								<div class="col-xs-9 col-sm-4">
									<input  class="form-control" type="text" value="<fmt:formatDate value="${corpForm.aab010}" pattern="yyyy-MM-dd " />" readonly="readonly"/>
									
								</div>	
							<label class="col-xs-3 col-sm-2" for="inputError" title="工商执照终止日期">工商执照终止日期:</label>
							<div class="col-xs-9 col-sm-4">
								<input  class="form-control" type="text" value="<fmt:formatDate value="${corpForm.aab011}" pattern="yyyy-MM-dd " />" readonly="readonly"/>
								
							</div>
		   				</div>
		   				<div class="row">
		   					<label class="col-xs-3 col-sm-2" for="inputError">法定代表人:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab013}" readonly="readonly"/></div>	
							<label class="col-xs-3 col-sm-2" for="inputError" title="法人公民身份号码">法人公民身份号码:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab014}" readonly="readonly"/></div>	
		   				</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError">组织机构代码:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab003}" readonly="readonly"/></div>	
			   				<label class="col-xs-3 col-sm-2" for="inputError">所在地区:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aaa021}" readonly="readonly"/></div>
			   			</div>
			   			<c:if test="${cczy!='18'}">
				   			<div class="row">
								<label class="col-xs-3 col-sm-2" for="inputError">地址:</label>
								<div class="col-xs-9 col-sm-10"><input  class="form-control" type="text" value="${corpForm.aae006}" readonly="readonly"/></div>
				   			</div>
			   			</c:if>
			   			<c:if test="${cczy=='18'}">
			   				<div class="row">
					   			<label class="col-xs-3 col-sm-2" for="inputError">证件图片:</label>
									<div class="col-xs-9 col-sm-4">
									<table>
									     <tr>
									       <td>
									        <div id="imgContext2">
										       <c:if test="${!empty corpf.caoa02}">
				            						<img  id="" src="getImageById.xf?filePath=${corpf.caoa02}"  width="200"  height="145"/>
												</c:if>
											</div>
									       </td>
									     </tr>
									   </table>
									</div>
					   				<label class="col-xs-3 col-sm-2" for="inputError">代办人身份证:</label>
									<div class="col-xs-9 col-sm-4">
											<table>
									     <tr>
									       <td>
									        <div id="imgContext2">
										       <c:if test="${!empty corpf.caoa10}">
				            						<img  id="" src="getImageById.xf?filePath=${corpf.caoa10}"  width="200"  height="145"/>
												</c:if>
											</div>
									       </td>
									     </tr>
									   </table>
										</div>
								</div>
				   			<div class="row">
						 		<label class="col-xs-3 col-sm-2" for="inputError">注册资金（万元）:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab049}" readonly="readonly"/></div>
				   				<label class="col-xs-3 col-sm-2" for="inputError">注册地址:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae006}" readonly="readonly"/></div>
				   			</div>
			   				<div class="row">
			   					<label class="col-xs-3 col-sm-2" for="inputError">单位简介:</label>
			   					<div class="col-xs-9 col-sm-10"><input  class="form-control" type="text" value="${corpForm.acb206}" readonly="readonly"/></div>
			   				</div>
				   			<div class="row">
						 		<label class="col-xs-3 col-sm-2" for="inputError">招聘联系人:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae004}" readonly="readonly"/></div>
				   				<label class="col-xs-3 col-sm-2" for="inputError">招聘联系电话:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae005}" readonly="readonly"/></div>
				   			</div>
				   			<div class="row">
				   				<label class="col-xs-3 col-sm-2" for="inputError">代办人:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab113}" readonly="readonly"/></div>
				   				<label class="col-xs-3 col-sm-2" for="inputError">代办人手机（短信）:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae139}" readonly="readonly"/></div>
				   			</div>
				   			<div class="row">
					   			<label class="col-xs-3 col-sm-2" for="inputError">代办人电话:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab115}" readonly="readonly"/></div>
					   				<label class="col-xs-3 col-sm-2" for="inputError">代办人身份证:</label>
									<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab114}" readonly="readonly"/></div>
								</div>
			   			</c:if>
			   			<c:if test="${cczy!='18'}">
			   				<div class="row">
			   					<label class="col-xs-3 col-sm-2" for="inputError">主营范围:</label>
			   					<div class="col-xs-9 col-sm-10"><input  class="form-control" type="text" value="${corpForm.aab052}" readonly="readonly"/></div>
			   				</div>
			   				<div class="row">
			   					<label class="col-xs-3 col-sm-2" for="inputError">兼营范围:</label>
			   					<div class="col-xs-9 col-sm-10"><input  class="form-control" type="text" value="${corpForm.aab053}" readonly="readonly"/></div>
			   				</div>
			   			</c:if>
		   				<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">行业代码:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab022}" readonly="readonly"/></div> 
							<%-- <div class="col-xs-9 col-sm-2 mhyNoSelect">
								<xf:select textField="name"  tableName="TAB_INDUSTRY" name="aab022" value="${corpForm.aab022 }"  valueField="code" hasDefault="0"></xf:select> 
							</div> --%>
							<label class="col-xs-3 col-sm-2" for="inputError">行业细类:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab025}" readonly="readonly"/></div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">细类说明:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab026}" readonly="readonly"/></div>
							<label class="col-xs-3 col-sm-2" for="inputError">经营方式:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab048}" readonly="readonly"/></div>
						</div>
		   				<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab020}" readonly="readonly"/></div>
							<label class="col-xs-3 col-sm-2" for="inputError">产业类别:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab054}" readonly="readonly"/></div>
						</div>
		   				<div class="row">
		   				<c:if test="${cczy!='18'}">
		   					<label class="col-xs-3 col-sm-2" for="inputError">劳动保障联系人:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae004}" readonly="readonly"/></div>
		   					<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae005}" readonly="readonly"/></div>
		   				</c:if>
					</div>
		   			<div class="row">
		   				<label class="col-xs-3 col-sm-2" for="inputError">主管部门:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab023}" readonly="readonly"/></div>
						<label class="col-xs-3 col-sm-2" for="inputError">隶属关系:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab021}" readonly="readonly"/></div>
					</div>
		   			<div class="row">
		   				<label class="col-xs-3 col-sm-2" for="inputError">传真:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.bab002}" readonly="readonly"/></div>
		   				<label class="col-xs-3 col-sm-2" for="inputError">网址:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae016}" readonly="readonly"/></div>
					</div>
		   			<div class="row">
	   					<label class="col-xs-3 col-sm-2" for="inputError">电子信箱:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae015}" readonly="readonly"/></div>
		   				<label class="col-xs-3 col-sm-2" for="inputError">邮政编码:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae007}" readonly="readonly"/></div>
					</div>
		   			<div class="row">
		   				<label class="col-xs-3 col-sm-2" for="inputError">从业人员总数:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab01e}" readonly="readonly"/></div>
		   				<label class="col-xs-3 col-sm-2" for="inputError">其中本市人员:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab01f}" readonly="readonly"/></div>
					</div>
					<div class="row">
		   				<label class="col-xs-3 col-sm-2" for="inputError">其中外来人员:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aab01g}" readonly="readonly"/></div>
					    <label class="col-xs-3 col-sm-2" for="inputError">传真:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.bab002}" readonly="readonly"/></div>
					</div>
		   			<div class="row">
		   				<label class="col-xs-3 col-sm-2" for="inputError">备注:</label>
							<div class="col-xs-9 col-sm-10"><input  class="form-control" type="text" value="${corpForm.aae013}" readonly="readonly"/></div>
		   			</div>
		   			<c:if test="${cczy!='18'}">
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError" title="享受优惠政策单位类型">享受优惠政策单位类型:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.acb101}" readonly="readonly"/></div>
			   				<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae019}" readonly="readonly"/></div>
			   			</div>
		   			</c:if>
		   			<c:if test="${cczy=='18'}">
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-2" for="inputError" title="享受优惠政策单位类型">单位类型:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.acb101}" readonly="readonly"/></div>
			   				<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
								<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae019}" readonly="readonly"/></div>
			   			</div>
		   			</c:if>
		   			<div class="row">
		   				<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="<fmt:formatDate value="${corpForm.aae036}" pattern="yyyy-MM-dd " />" readonly="readonly"/></div>
		   				<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-4"><input  class="form-control" type="text" value="${corpForm.aae020}" readonly="readonly"/></div>
					</div>
		   		</div>		   		
		   	</form:form>
		  </div> 
	</div>
</div>    	  
</body>
</html>
