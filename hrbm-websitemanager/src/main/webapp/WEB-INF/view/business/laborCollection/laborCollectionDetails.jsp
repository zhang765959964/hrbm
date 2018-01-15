<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>编辑 个人基本信息表</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <%@include file="/commons/include/bootstrapInc.jsp" %>
</head>
<body>
<div class="main-container">
	<div class="container-fluid">
		<div class="mhyMain">
	   		<div class="mhyTitle">个人基本信息详情</div>
		   			<div class="mhyPersonTabs">
								<div class="row">
									<label class="col-xs-3 col-sm-2" >身份证号码:</label>
									<div class="col-xs-9 col-sm-2">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac002 }" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" >姓名:</label>
									<div class="col-xs-9 col-sm-2">
									    <input  class="form-control" type="text" value="${personBaseInfoForm.aac003 }" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" >性别:</label>
									<div class="col-xs-9 col-sm-2">
									    <input  class="form-control" type="text" value="${personBaseInfoForm.aac004 }" readonly="readonly"/>
									</div>
									</div>
						 		<div class="row">
									<label class="col-xs-3 col-sm-2" >出生日期:</label>
										<div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="<fmt:formatDate value="${personBaseInfoForm.aac006 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
										</div>
									<label class="col-xs-3 col-sm-2" >民族:</label>
									<div class="col-xs-9 col-sm-2 "> 
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac005 }" readonly="readonly"/>
									</div>	
									<label class="col-xs-3 col-sm-2" >身高(cm):</label>
									<div class="col-xs-9 col-sm-2 "> 
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac034 }" readonly="readonly"/>
									</div>
								</div>
						 		<div class="row">
									<label class="col-xs-3 col-sm-2" >婚姻状况:</label>
									<div class="col-xs-9 col-sm-2">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac017 }" readonly="readonly"/>
									</div>	
									<label class="col-xs-3 col-sm-2" >电话:</label>
									<div class="col-xs-9 col-sm-2">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aae005 }" readonly="readonly"/>
									</div>	
									<label class="col-xs-3 col-sm-2" >体重(kg):</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac035 }" readonly="readonly"/>
									</div>
						 		</div>
						  		<div class="row">
						  			<label class="col-xs-3 col-sm-2" >户口性质:</label>
									<div class="col-xs-9 col-sm-6">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac009 }" readonly="readonly"/>
									</div>	
						  		</div>
						 		<div class="row">
						 			<label class="col-xs-3 col-sm-2" >户口所在地:</label>
									<div class="col-xs-9 col-sm-10">
										<input  class="form-control" type="text" value="${personBaseInfoForm.bab305 }" readonly="readonly"/>
									</div>
						  		</div>
						 		<div class="row">
									<label class="col-xs-3 col-sm-2" >籍贯:</label>
									<div class="col-xs-9 col-sm-10">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac025 }" readonly="readonly"/>
									</div>
						 		</div>
						 		<div class="row">
						 			<label class="col-xs-3 col-sm-2" >居住所在地:</label>
									<div class="col-xs-9 col-sm-10">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aab301 }" readonly="readonly"/>
									</div>
						 		</div>
						 		<div class="row">
									<label class="col-xs-3 col-sm-2" >政治面貌:</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac024 }" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" >文化程度:</label>
									<div class="col-xs-9 col-sm-2">
										<input  class="form-control" type="text" value="${personBaseInfoForm.aac011 }" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" >健康状况:</label>
										<div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="${personBaseInfoForm.aac033 }" readonly="readonly"/>
										</div>		
								</div>
						 		<div class="row">
									<label class="col-xs-3 col-sm-2" >毕业学校:</label>
										<div class="col-xs-9 col-sm-2 ">
											<input  class="form-control" type="text" value="${personBaseInfoForm.aac180 }" readonly="readonly"/>
										</div>
									<label class="col-xs-3 col-sm-2" >毕业时间:</label>
									<div class="col-xs-9 col-sm-2" >
										<input  class="form-control" type="text" value="<fmt:formatDate value="${personBaseInfoForm.aac181 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
									</div>	
									<label class="col-xs-3 col-sm-2" >所学专业:</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="${personBaseInfoForm.acc01g }" readonly="readonly"/>
									</div>	
								</div>
								<div class="row">
					   				<label class="col-xs-3 col-sm-2" >经办日期:</label>
										<div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="<fmt:formatDate value="${personBaseInfoForm.aae036 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
										</div>	
					   				<label class="col-xs-3 col-sm-2" >经办机构:</label>
										<div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="${personBaseInfoForm.aae020 }" readonly="readonly"/>
										</div>	
					   				<label class="col-xs-3 col-sm-2" >经办人:</label>
										<div class="col-xs-9 col-sm-2">
											<input  class="form-control" type="text" value="${personBaseInfoForm.aae019 }" readonly="readonly"/>
										</div>		
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" >就业失业情况:</label>
									<div class="col-xs-9 col-sm-4" >
									<c:choose >
										<c:when test="${laborAccomForm.acc0m==1 }"><input  class="form-control" type="text" value="就业" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.acc0m==2 }"><input  class="form-control" type="text" value="不在岗" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.acc0m==3 }"><input  class="form-control" type="text" value="未就业及失业" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.acc0m==4 }"><input  class="form-control" type="text" value="服刑" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.acc0m==5 }"><input  class="form-control" type="text" value="出国定居" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.acc0m==6 }"><input  class="form-control" type="text" value="在学" readonly="readonly"/></c:when>
									</c:choose>
									</div>	
								</div>
							</div>
	   					</div>
	   					<c:if test="${laborAccomForm.acc0m==1 }"><div class="mhyTitle">就业情况详情</div></c:if>
	   					<c:if test="${laborAccomForm.acc0m==2 }"><div class="mhyTitle">不在岗情况详情</div></c:if>
	   					<c:if test="${laborAccomForm.acc0m==3 }"><div class="mhyTitle">失业及未就业情况详情</div></c:if>
						<div class="mhyPersonTabs">
						<c:if test="${laborAccomForm.acc0m==1 }">
							<div class="row">
								<label class="col-xs-3 col-sm-2" >工作单位:</label>
								<div class="col-xs-9 col-sm-6 ">
									<input  class="form-control" type="text" value="${laborAccomForm.aab004 }" readonly="readonly"/>
								</div>
								<label class="col-xs-3 col-sm-2" >单位性质:</label>
								<div class="col-xs-9 col-sm-2" >
									<input  class="form-control" type="text" value="${laborAccomForm.aab019 }" readonly="readonly"/>
								</div>	
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" >产业类别:</label>
								<div class="col-xs-9 col-sm-2 ">
									<input  class="form-control" type="text" value="${personBaseInfoForm.aab054 }" readonly="readonly"/>
								</div>	
								<label class="col-xs-3 col-sm-2" >经济类型:</label>
								<div class="col-xs-9 col-sm-2 ">
									<input  class="form-control" type="text" value="${laborAccomForm.aab020 }" readonly="readonly"/>
								</div>
								<label class="col-xs-3 col-sm-2" >就业时间:</label>
								<div class="col-xs-9 col-sm-2 ">
									<input  class="form-control" type="text" value="<fmt:formatDate value="${laborAccomForm.accm03 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
								</div>	
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" >签订劳动合同情况:</label>
								<div class="col-xs-9 col-sm-2" >
								<c:choose >
										<c:when test="${laborAccomForm.accm04==1 }">
										 <input  class="form-control" type="text" value="是" readonly="readonly"/>
										</c:when>
										<c:when test="${laborAccomForm.accm04==2 }">
										<input  class="form-control" type="text" value="否" readonly="readonly"/>
										</c:when>
								</c:choose>
								</div>	
								<label class="col-xs-3 col-sm-2" >合同期限:</label>
								<div class="col-xs-9 col-sm-4" >
								<input  class="form-control" style="width:110px;" type="text" value="<fmt:formatDate value="${laborAccomForm.accm05 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>至
								<input  class="form-control" style="width:110px;" type="text" value="<fmt:formatDate value="${laborAccomForm.accm06 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
								</div>	
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" >合同情况:</label>
								<div class="col-xs-9 col-sm-6" >
								<c:choose >
										<c:when test="${laborAccomForm.accm07==1 }"><input  class="form-control" type="text" value="本县内" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.accm07==2 }"><input  class="form-control" type="text" value="本镇内" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.accm07==3 }"><input  class="form-control" type="text" value="本镇外" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.accm07==4 }"><input  class="form-control" type="text" value="本市外区" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.accm07==5 }"><input  class="form-control" type="text" value="出国务工（外出时间:
										<fmt:formatDate value="${laborAccomForm.accm08 }" pattern="yyyy-MM-dd " />
										）" readonly="readonly"/></c:when>
										<c:when test="${laborAccomForm.accm07==6 }"><input  class="form-control" type="text" value="外省市（外出时间:
										<fmt:formatDate value="${laborAccomForm.accm09 }" pattern="yyyy-MM-dd " />
										）" readonly="readonly"/></c:when>
								</c:choose>
								</div>	
								<label class="col-xs-3 col-sm-2" >就业形势:</label>
								<div class="col-xs-9 col-sm-2" >
									<input  class="form-control" type="text" value="${laborAccomForm.accm02 }" readonly="readonly"/>
								</div>	
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" title="灵活就业登记类别">灵活就业登记类别:</label>
								<div class="col-xs-9 col-sm-6" >
								<c:choose >
									<c:when test="${laborAccomForm.accm13==1 }"><input  class="form-control" type="text" value="企业零散用工" readonly="readonly"/></c:when>
									<c:when test="${laborAccomForm.accm13==2 }"><input  class="form-control" type="text" value="弹性就业" readonly="readonly"/></c:when> 
									<c:when test="${laborAccomForm.accm13==3 }"><input  class="form-control" type="text" value="家政服务" readonly="readonly"/></c:when>
									<c:when test="${laborAccomForm.accm13==4 }"><input  class="form-control" type="text" value="自由职业" readonly="readonly"/></c:when> 
									<c:when test="${laborAccomForm.accm13==5 }"><input  class="form-control" type="text" value="街头自营" readonly="readonly"/></c:when>
									<c:when test="${laborAccomForm.accm13==6 }"><input  class="form-control" type="text" value="打零工" readonly="readonly"/></c:when> 
									<c:when test="${laborAccomForm.accm13==7 }"><input  class="form-control" type="text" value="其他" readonly="readonly"/></c:when>
								</c:choose>
								</div>	
								<label class="col-xs-3 col-sm-2" >人员类别:</label>
								<div class="col-xs-9 col-sm-2" >
									<input  class="form-control" type="text" value="${laborAccomForm.acc20t }" readonly="readonly"/>
								</div>	
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-2" title="对目前工作状况是否满意？">对目前工作状况是否满意？:</label>
								<div class="col-xs-9 col-sm-10" >
								<c:choose >
									<c:when test="${laborAccomForm.accm11==1 }"><input  class="form-control" type="text" value="是" readonly="readonly"/></c:when>
									<c:when test="${laborAccomForm.accm11==2 }"><input  class="form-control" type="text" value="否（原因:${laborAccomForm.accm12 }）" readonly="readonly"/></c:when> 
								</c:choose>
								</div>	
							</div>
						</c:if>
						<c:if test="${laborAccomForm.acc0m==2 }">
								<div class="row">
									<label class="col-xs-3 col-sm-2" >工作单位:</label>
									<div class="col-xs-9 col-sm-10 ">
										<input  class="form-control" type="text" value="${laborAcpostForm.aab004t }" readonly="readonly"/>
									</div>
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" >单位性质:</label>
									<div class="col-xs-9 col-sm-2" >
										<input  class="form-control" type="text" value="${laborAcpostForm.aab019t }" readonly="readonly"/>
									</div>	
									<label class="col-xs-3 col-sm-2" >经济类型:</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="${laborAcpostForm.aab020t }" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-2" >不在岗原因:</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="${laborAcpostForm.accm14 }" readonly="readonly"/>
									</div>	
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-2" >不在岗时间:</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="<fmt:formatDate value="${laborAcpostForm.accm16 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
									</div>	
									<label class="col-xs-3 col-sm-2" >是否发放生活费:</label>
									<div class="col-xs-9 col-sm-2" >
										<c:choose >
											<c:when test="${laborAcpostForm.accm17==1 }"><input  class="form-control" type="text" value="是" readonly="readonly"/></c:when>
											<c:when test="${laborAcpostForm.accm17==2 }"><input  class="form-control" type="text" value="否" readonly="readonly"/></c:when> 
										</c:choose>
									</div>	
									<label class="col-xs-3 col-sm-2" >生活费标准(元):</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="${laborAcpostForm.accm18 }" readonly="readonly"/>
									</div>	
								</div>
						</c:if>
						<c:if test="${laborAccomForm.acc0m==3 }">
								<div class="row">
									<label class="col-xs-3 col-sm-3" >原工作单位:</label>
									<div class="col-xs-9 col-sm-8 ">
										<input  class="form-control" type="text" value="${laborAcemployedForm.aab004m }" readonly="readonly"/>
									</div>	
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-3" >未就业及失业人员类别:</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="${laborAcemployedForm.acc20m }" readonly="readonly"/>
									</div>
									<label class="col-xs-3 col-sm-3" >失业主要原因(失业人员填写):</label>
										<div class="col-xs-9 col-sm-2" ><input  class="form-control" type="text" value="${laborAcemployedForm.accm20 }" readonly="readonly"/>
									</div>	
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-3" >失业登记时间:</label>
									<div class="col-xs-9 col-sm-2 ">
									  <div class="col-xs-9 col-sm-2" >
										  <input  class="form-control" type="text" value="<fmt:formatDate value="${laborAcemployedForm.accm21 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
									  </div>
									<label class="col-xs-3 col-sm-3" >未就业原因(未就业人员填写):</label>
									<div class="col-xs-9 col-sm-2" >
										<c:choose >
											<c:when test="${laborAcemployedForm.accm19==1 }"><input  class="form-control" type="text" value="无就业愿望" readonly="readonly"/></c:when>
											<c:when test="${laborAcemployedForm.accm19==2 }"><input  class="form-control" type="text" value="家庭原因" readonly="readonly"/></c:when> 
											<c:when test="${laborAcemployedForm.accm19==3 }"><input  class="form-control" type="text" value="无就业能力" readonly="readonly"/></c:when>
											<c:when test="${laborAcemployedForm.accm19==4 }"><input  class="form-control" type="text" value="正在培训" readonly="readonly"/></c:when> 
											<c:when test="${laborAcemployedForm.accm19==5 }"><input  class="form-control" type="text" value="没有合适的工作" readonly="readonly"/></c:when>
											<c:when test="${laborAcemployedForm.accm19==6 }"><input  class="form-control" type="text" value="年龄偏大" readonly="readonly"/></c:when> 
											<c:when test="${laborAcemployedForm.accm19==7 }"><input  class="form-control" type="text" value="对找工作丧失信心" readonly="readonly"/></c:when>
											<c:when test="${laborAcemployedForm.accm19==8 }"><input  class="form-control" type="text" value="其他原因" readonly="readonly"/></c:when> 
										</c:choose>
									</div>		
								</div>
								<div class="row">
									<label class="col-xs-3 col-sm-3" >上一次劳动合同终止或解除时间:</label>
									<div class="col-xs-9 col-sm-2 ">
										<input  class="form-control" type="text" value="<fmt:formatDate value="${laborAcemployedForm.accm22 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
									</div>	
									<label class="col-xs-3 col-sm-3" >经劳动部门认定的困难群体:</label>
									<div class="col-xs-9 col-sm-3" >
										<input  class="form-control" type="text" value="<fmt:formatDate value="${laborAcemployedForm.accm23 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
									</div>	
								</div>
								
						</c:if>
	   			</div>
</div> 	
</body>

</html>
