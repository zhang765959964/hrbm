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
<div class="container-fluid pd-none-wrap">
	<div class="mhyMain">
   		<div class="mhyTitle">个人基本信息详情</div>
	   	<div class="mhyPersonTabs">
		   	<form:form class="mhyform" modelAttribute="personBaseInfoForm" method="post" >
				<div class="mhySearchInput mhyInputDiv">
	   				<div class="row">
							<label class="col-xs-3 col-sm-label" title="身份证号码">身份证号码:</label>
							<div class="col-xs-9 col-sm-input">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aac002 }" readonly="readonly"/>
							</div>
							<label class="col-xs-3 col-sm-label" title="姓名">姓名:</label>
							<div class="col-xs-9 col-sm-input">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aac003 }" readonly="readonly"/></div>
							<label class="col-xs-3 col-sm-label" title="性别">性别:</label>
							<div class="col-xs-9 col-sm-input ">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aac004 }" readonly="readonly"/></div>
	   				</div>
	   				<div class="row">
						<label class="col-xs-3 col-sm-label" title="军人证号">军人证号:</label>
						<div class="col-xs-9 col-sm-input "><input  class="form-control" type="text" value="${personBaseInfoForm.aac00a }" readonly="readonly"/></div>
						<label class="col-xs-3 col-sm-label" title="出生日期">出生日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
			                   	<input  class="form-control" type="text" value="<fmt:formatDate value="${personBaseInfoForm.aac006 }" pattern="yyyy-MM-dd " />" 
			                   		readonly="readonly"/>
			                   	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
			                </div>
		                </div>
						<label class="col-xs-3 col-sm-label" title="民族">民族:</label>
						<div class="col-xs-9 col-sm-input mhyNoSelect"><input  class="form-control" type="text" value="${personBaseInfoForm.aac005 }" readonly="readonly"/> </div>	
	   				</div>
	   				<div class="row">
   						<label class="col-xs-3 col-sm-label" title="个人状态">个人状态:</label>
						<div class="col-xs-9 col-sm-input mhyNoSelect"><input  class="form-control" type="text" value="${personExpand.expPersonStatus }" readonly="readonly"/></div>	
						<label class="col-xs-3 col-sm-label" title="婚姻状况">婚姻状况:</label>
						<div class="col-xs-9 col-sm-input mhyNoSelect"><input  class="form-control" type="text" value="${personBaseInfoForm.aac017 }" readonly="readonly"/></div>	
						<label class="col-xs-3 col-sm-label" title="电话">电话:</label>
						<div class="col-xs-9 col-sm-input"><input  class="form-control" type="text" value="${personBaseInfoForm.aae005 }" readonly="readonly"/></div>	
	   				</div>
		   			<div class="row">
		   				<label class="col-xs-3 col-sm-label" title="户口性质">户口性质:</label>
						<div class="col-xs-9 col-sm-two-col"><input  class="form-control" type="text" value="${personBaseInfoForm.aac009 }" readonly="readonly"/></div>	
	   					<label class="col-xs-3 col-sm-label" title="户口登记日期">户口登记日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
			                   	<input class="form-control" type="text" 
									value="<fmt:formatDate value="${personExpand.expHourseDate }" pattern="yyyy-MM-dd "/>" readonly="readonly"/>
			                   	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
			                </div>
		                </div>
		   			</div>
	   				<div class="row">
	   					<label class="col-xs-3 col-sm-label" title="户口所在地">户口所在地:</label>
						<div class="col-xs-9 col-sm-three-col">
						<input class="form-control" type="text" value="${personBaseInfoForm.bab305 }" readonly="readonly"/></div>
		   			</div>
	   				<div class="row">
	   					<label class="col-xs-3 col-sm-label" title="居住所在地">居住所在地:</label>
						<div class="col-xs-9 col-sm-three-col">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aab301 }" readonly="readonly"/>
						</div>
	   				</div>
	   				<div class="row">
	   					<label class="col-xs-3 col-sm-label" title="籍贯">籍贯:</label>
						<div class="col-xs-9 col-sm-three-col">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aac025 }" readonly="readonly"/>
						</div>
	   				</div>
	   				<div class="row">
	   					<label class="col-xs-3 col-sm-label" title="详细地址">详细地址:</label>
						<div class="col-xs-9 col-sm-three-col">
						<input  class="form-control" type="text" value="${personExpand.expAddress }" readonly="readonly"/></div>
	   				</div>
	   				<div class="row">
						<label class="col-xs-3 col-sm-label" title="政治面貌">政治面貌:</label>
						<div class="col-xs-9 col-sm-input ">
						<input  class="form-control" type="text" value="${personBaseInfoForm.aac024 }" readonly="readonly"/>
						</div>
						<label class="col-xs-3 col-sm-label" title="文化程度">文化程度:</label>
							<div class="col-xs-9 col-sm-input mhyNoSelect">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aac011 }" readonly="readonly"/></div>
						<label class="col-xs-3 col-sm-label" title="健康状况">健康状况:</label>
							<div class="col-xs-9 col-sm-input mhyNoSelect"><input  class="form-control" type="text" value="${personBaseInfoForm.aac033 }" readonly="readonly"/></div>		
					</div>
	   				<div class="row">
						<label class="col-xs-3 col-sm-label" title="毕业学校">毕业学校:</label>
							<div class="col-xs-9 col-sm-two-col "><input  class="form-control" type="text" value="${personBaseInfoForm.aac180 }" readonly="readonly"/></div>
						<label class="col-xs-3 col-sm-label" title="毕业时间">毕业时间:</label>
						<div class="col-xs-9 input-group col-sm-input" >
							<div class="input-group row">
			                   	<input  class="form-control" type="text" value="<fmt:formatDate value="${personBaseInfoForm.aac181 }" pattern="yyyy-MM-dd " />" 
			                   		readonly="readonly"/>
			                   	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
			                </div>
						</div>	
					</div>
	   				<div class="row">
						<label class="col-xs-3 col-sm-label" title="所学专业">所学专业:</label>
							<div class="col-xs-9 col-sm-three-col ">
							<input  class="form-control" type="text" value="${personBaseInfoForm.acc01g }" readonly="readonly"/></div>	
					</div>
					<div class="row">
		   				<label class="col-xs-3 col-sm-label" title="电子信箱">电子信箱:</label>
							<div class="col-xs-9 col-sm-input"><input  class="form-control" type="text" value="${personBaseInfoForm.aae015 }" readonly="readonly"/>
							</div>		
						<label class="col-xs-3 col-sm-label" title="邮  编">邮  编:</label>
							<div class="col-xs-9 col-sm-input"><input  class="form-control" type="text" value="${personBaseInfoForm.aae007 }" readonly="readonly"/>
						</div>
		   			</div>
		   			<div class="row">
		   				<label class="col-xs-3 col-sm-label" title="备  注">备  注:</label>
						<div class="col-xs-9 col-sm-three-col"><input  class="form-control" type="text" value="${personBaseInfoForm.aae013 }" readonly="readonly"/>
						</div>		
		   			</div>
		   			<c:if test="${cczy06!='18' }">
		   				<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="原工作单位">原工作单位:</label>
							<div class="col-xs-9 col-sm-input"><input  class="form-control" type="text" value="${personExpand.expOldCompany }" readonly="readonly"/></div>	
			   				<label class="col-xs-3 col-sm-label" title="参加工作时间">参加工作时间:</label>
							<div class="col-xs-9 input-group col-sm-input" >
								<div class="input-group row">
				                    <input  class="form-control" type="text" value="<fmt:formatDate value="${personExpand.expStartJobDate }" pattern="yyyy-MM-dd " />" 
				                    	readonly="readonly"/>
				                   	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
				                </div>
							</div>	
			   				<label class="col-xs-3 col-sm-label" >职务:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text" value="${personExpand.expPost }" readonly="readonly"/>
							</div>		
						</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="国家职业资格等级">国家职业资格等级:</label>
								<div class="col-xs-9 col-sm-input mhyNoSelect"><input  class="form-control" type="text" value="${personExpand.expLevel }" readonly="readonly"/>
								</div>
							<label class="col-xs-3 col-sm-label" title="取得职业资格等级日期">取得职业资格等级日期:</label>
								<div class="col-xs-9 input-group col-sm-input">
									<input  class="form-control" type="text" value="<fmt:formatDate value="${personExpand.expLevelDate }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
								</div>
							<label class="col-xs-3 col-sm-label" title="职业（工种）资格名称">职业（工种）资格名称:</label>
								<div class="col-xs-9 col-sm-input mhyNoSelect"> <input  class="form-control" type="text" value="${personExpand.expPositionName }" readonly="readonly"/>
								</div>	
						</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="专业技术职务">专业技术职务:</label>
							<div class="col-xs-9 col-sm-input mhyNoSelect">
								<input  class="form-control" type="text" value="${personExpand.expTechnical }" readonly="readonly"/>
							</div>	
			   				<label class="col-xs-3 col-sm-label" title="取得专技资格日期">取得专技资格日期:</label>
							<div class="col-xs-9 input-group col-sm-input" style="float:left">
								<input  class="form-control" type="text" value="<fmt:formatDate value="${personExpand.expTechnicalDate }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
							</div>
			   				<label class="col-xs-3 col-sm-label" title="就业失业登记证号码">就业失业登记证号码:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text" value="${personBaseInfoForm.acc0m1 }" readonly="readonly"/>
							</div>		
						</div>
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="是否零就业家庭">是否零就业家庭:</label>
							<div class="col-xs-9 col-sm-input">
								<c:choose >
									<c:when test="${personExpand.expIsFamily==1 }"><input  class="form-control" type="text" value="是" readonly="readonly"/></c:when>
									<c:otherwise><input class="form-control" type="text" value="否" readonly="readonly"/></c:otherwise>
								</c:choose>
							</div>	
			   				<label class="col-xs-3 col-sm-label"  title="是否就业困难人员">是否就业困难人员:</label>
							<div class="col-xs-9 col-sm-input">
								<c:choose >
									<c:when test="${personExpand.expIsDifficult==1 }">
										<input  class="form-control" type="text" value="是" readonly="readonly"/>
									</c:when>
									<c:otherwise><input class="form-control" type="text" value="否" readonly="readonly"/></c:otherwise>
								</c:choose>
							</div>	
			   				<label class="col-xs-3 col-sm-label" title="就业困难人员类别">就业困难人员类别:</label>
							<div class="col-xs-9 col-sm-input mhyNoSelect">
								<input  class="form-control" type="text" value="${personExpand.expHardPerson }" readonly="readonly"/>
							</div>		
						</div>
			   			</div>
			   		</div>
		   			<div class="mhyTitle">家庭情况 </div>
					<div class="mhyPersonTabs">
					<div class="mhySearchInput mhyInputDiv">
			   			<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="婚姻状况">婚姻状况:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text" value="${personFamily.faMarriage }" readonly="readonly"/>
							</div>	
			   				<label class="col-xs-3 col-sm-label" title="结婚时间">结婚时间:</label>
			   				<div class="col-xs-9 input-group col-sm-input" >
								<div class="input-group row">
				                   	<input  class="form-control" type="text" value="<fmt:formatDate value="${personFamily.faMarriageDate }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
				                   	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
				                </div>
							</div>
			   				<label class="col-xs-3 col-sm-label" title="配偶姓名">配偶姓名:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text" value="${personFamily.faName }" readonly="readonly"/>
							</div>		
						</div>
						<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="配偶身份证号">配偶身份证号:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text" value="${personFamily.faSpouseCard }" readonly="readonly"/>
							</div>	
			   				<label class="col-xs-3 col-sm-label" title="配偶民族">配偶民族:</label>
							<div class="col-xs-9 col-sm-input ">
								<input  class="form-control" type="text" value="${personFamily.faSpouseNational }" readonly="readonly"/>
							</div>			
			   				<label class="col-xs-3 col-sm-label" title="配偶出生日期">配偶出生日期:</label>
							<div class="col-xs-9 input-group col-sm-input" >
								<div class="input-group row">
				                   	<input  class="form-control" type="text" value="<fmt:formatDate value="${personFamily.faSpouseBirth }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
				                   	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
				                </div>
							</div>
						</div>
						<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="配偶单位">配偶单位:</label>
							<div class="col-xs-9 col-sm-two-col">
								<input  class="form-control" type="text" value="${personFamily.faSpouseCompany }" readonly="readonly"/>
							</div>	
			   				<label class="col-xs-3 col-sm-label" title="配偶电话">配偶电话:</label>
							<div class="col-xs-9 col-sm-input ">
								<input  class="form-control" type="text" value="${personFamily.faSpousePhone }" readonly="readonly"/>
							</div>			
						</div>
						<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="计生情况">计生情况:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text" value="${personFamily.faBirthCondition }" readonly="readonly"/>
							</div>	
			   				<label class="col-xs-3 col-sm-label" title="节育措施">节育措施:</label>
							<div class="col-xs-9 col-sm-input">
								<input  class="form-control" type="text" value="${personFamily.faBirthControl }" readonly="readonly"/>
							</div>			
						</div>
						<div class="row">
			   				<label class="col-xs-3 col-sm-label" title="家庭情况备注">家庭情况备注:</label>
							<div class="col-xs-9 col-sm-three-col">
								<input  class="form-control" type="text" value="${personFamily.faFamilyBark }" readonly="readonly"/>
							</div>		
			   			</div>
			   		</c:if>
			   		<div class="row">
		   				<label class="col-xs-3 col-sm-label" title="经办日期">经办日期:</label>
						<div class="col-xs-9 col-sm-input">
							<input  class="form-control" type="text" value="<fmt:formatDate value="${personBaseInfoForm.aae036 }" pattern="yyyy-MM-dd " />" readonly="readonly"/>
						</div>	
		   				<label class="col-xs-3 col-sm-label" title="经办机构">经办机构:</label>
						<div class="col-xs-9 col-sm-input">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aae020 }" readonly="readonly"/>
						</div>	
		   				<label class="col-xs-3 col-sm-label" title="经办人">经办人:</label>
						<div class="col-xs-9 col-sm-input">
							<input  class="form-control" type="text" value="${personBaseInfoForm.aae019 }" readonly="readonly"/>
						</div>		
					</div>
			</div>
		</form:form>			
   		</div>
    </div>
 </div>	
</body>
</html>