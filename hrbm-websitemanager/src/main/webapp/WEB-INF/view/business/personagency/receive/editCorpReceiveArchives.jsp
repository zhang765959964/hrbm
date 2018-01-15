<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>企业下个人档案接收编辑页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/receive/resultReceiveArchives.js"></script>
	<style>
		form .row>label,form .row>div{padding:0;}
	</style>
</head>
<body>
	<form:form modelAttribute="receiveArchivesPersonForm" method="post" action="${ctx}/business/personagency/receive/receive/save.xf">
	<form:hidden path="personBaseForm.aac001" ></form:hidden>
	<form:hidden path="personBaseForm.id" ></form:hidden>
	<form:hidden path="personBaseForm.expandId" ></form:hidden>
	<form:hidden path="archiveReceiveUserid" ></form:hidden>
	<form:hidden path="archiveReceiveOrgId" ></form:hidden>
	<form:hidden path="gongZuoForm.aac0b0" ></form:hidden>
	<form:hidden path="jiaTingForm.id" ></form:hidden>
	<form:hidden path="jiaoYuForm.aac0d0" ></form:hidden>
	<form:hidden path="id" ></form:hidden>
	<form:hidden path="aab001" ></form:hidden>
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<!-- 个人信息带身份证图片 -->
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit dbToggle">存档信息</div>
				<div class="moduleCont">
					<div class="row">
						<div class="col-xs-12 col-sm-10 hauto leftContWrap mgb0">
							<div class="row">
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="身份证号"><em>*</em>身份证号:</label>
								<div class="col-xs-9 col-sm-left-input required">
									<form:input  class="form-control" type="text" path="personBaseForm.aac002" data-container="body" data-toggle="popover"></form:input>
								</div>
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="姓名">姓名:</label>
								<div class="col-xs-9 col-sm-left-input">
									<form:input  class="form-control" type="text" path="personBaseForm.aac003" readonly="true"></form:input>
								</div>
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="出生日期">出生日期:</label>
								<div class="col-xs-9 col-sm-left-input">
									<form:input  class="form-control" type="text" path="personBaseForm.aac006" readonly="true"></form:input>
								</div>
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="曾用名">曾用名:</label>
								<div class="col-xs-9 col-sm-left-input">
									<form:input  class="form-control" type="text" path="personBaseForm.expUserName" ></form:input>
								</div>
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="性别">性别:</label>
								<div class="col-xs-9 col-sm-left-input">
									<form:input  class="form-control" type="text" path="personBaseForm.genderName" readonly="true"></form:input>
								</div>
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="档案姓名">档案姓名:</label>
								<div class="col-xs-9 col-sm-left-input">
									<form:input  class="form-control" type="text" path="personBaseForm.archiveName" id="archiveNameOne" onkeyup="SyncContentUp()"></form:input>
								</div>
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="民族">民族:</label>
								<div class="col-xs-9 col-sm-left-input">
									<xf:select  tableName="TAB_NATION" valueField="code" textField="name" name="personBaseForm.aac005" 
											value='${receiveArchivesPersonForm.personBaseForm.aac005}' hasDefault="0" selectClass="form-control"></xf:select>
								</div>
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="政治面貌">政治面貌:</label>
								<div class="col-xs-9 col-sm-left-input">
									<xf:select  tableName="TAB_AFFIL" valueField="code" textField="name" name="personBaseForm.aac024" 
										value='${receiveArchivesPersonForm.personBaseForm.aac024}' hasDefault="0" selectClass="form-control"></xf:select>
								</div>
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="文化程度">文化程度:</label>
								<div class="col-xs-9 col-sm-left-input">
									<xf:select  tableName="TAB_EDUCATION" valueField="code" textField="name" name="personBaseForm.aac011"  
										value='${receiveArchivesPersonForm.personBaseForm.aac011}' hasDefault="0" selectClass="form-control"></xf:select>
								</div>
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="联系电话">联系电话:</label>
								<div class="col-xs-9 col-sm-left-input">
									<form:input  class="form-control" type="text"  path="personBaseForm.expPersonPhone" ></form:input>
								</div>
							</div>
							<div class="row">
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="手机号"><em>*</em>手机号:</label>
								<div class="col-xs-9 col-sm-left-input required">
									<form:input  class="form-control" type="text"  path="personBaseForm.aae005" data-container="body" data-toggle="popover"></form:input>
								</div>
								<label class="col-xs-3 col-sm-left-label" for="inputError" title="是否军转干部">是否军转干部:</label>
								<div class="col-xs-9 col-sm-left-input">
									<form:select  class="form-control" type="text"  path="personBaseForm.expIsCadre" >
										<form:option value="0" label="否"/>否
										<form:option value="1" label="是"/>是
									</form:select>
								</div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-2 hauto rightImgWrap tar">
							<img class="bd idcard" src="${fileDirectory}/${receiveArchivesPersonForm.personBaseForm.ccmu61}" 
								<c:if test="${receiveArchivesPersonForm.personBaseForm.aac004==1}">
							 		onerror='this.src="${ctx}/styles/default/images/man.jpg"'
								</c:if>
								<c:if test="${receiveArchivesPersonForm.personBaseForm.aac004!=1}">
									onerror='this.src="${ctx}/styles/default/images/woman.jpg"'
								</c:if>
								alt="个人身份证图片" width="140" height="196" id="jxcard">
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text"  path="personBaseForm.expIsDiscount" >
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text"  path="personBaseForm.expIsRegisgration" >
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="personBaseForm.expRegisgration" ></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="身份证住址">身份证住址:</label>
						<div class="col-xs-9 col-sm-two-col">
							<form:input  class="form-control" type="text"  path="personBaseForm.expCardNumber" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="就业失业登记证号">就业失业登记证号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="personBaseForm.acc0m1" ></form:input>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="现居住地址">现居住地址:</label>
						<div class="col-xs-9 col-sm-two-col">
							<form:input  class="form-control" type="text"  path="personBaseForm.aab301" ></form:input>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError" title="基本情况备注">基本情况备注:</label>
								<div class="col-xs-9 col-sm-three-col">
									<form:textarea  type="text"  path="personBaseForm.aae013" row="5" col="5" ></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 工作情况-带点击按钮 -->
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit dbToggle">
					<span class="fl">工作情况</span>
					<span class="fr mgr15">
						<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('collapseWrap',this)">
							<i class="icon-double-angle-up collapseBtn"></i>
							<!-- <span class="collapse-tip">展开</span>
							<span class="collapse-tip fwhite dn">收起</span> -->
						</a>
					</span>
				</div>
				<div class="moduleCont" id="collapseWrap">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="参加工作时间">参加工作时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
			                   	<form:input  class="form-control date" type="text"  path="gongZuoForm.expStartJobDate" id="expStartJobDate" placeholder="请选择日期"></form:input>
			                   	<span class="input-group-addon">
			                       	<i class="icon-calendar bigger-110"></i>
			                   	</span>
			                </div>
		                </div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="原单位名称">原单位名称:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="gongZuoForm.expOldCompany" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="职务">职务:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="gongZuoForm.expPost" ></form:input>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError" title="主要工作简历">主要工作简历:</label>
								<div class="col-xs-9 col-sm-three-col">
									<form:textarea  type="text"  path="gongZuoForm.mainWork" row="5" col="5" readonly="true"></form:textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="现单位名称">现单位名称:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="gongZuoForm.aac045" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="专业工种">专业工种:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="gongZuoForm.expZhuanye" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="职业资格等级">职业资格等级:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select  tableName="TAB_COQ" valueField="code" textField="name" name="gongZuoForm.aac015" 
								 value='${receiveArchivesPersonForm.gongZuoForm.aac015}' hasDefault="0" selectClass="form-control"></xf:select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError" title="工作备注">工作备注:</label>
								<div class="col-xs-9 col-sm-three-col">
									<form:textarea  type="text"  path="gongZuoForm.aae013" row="5" col="5" ></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 家庭情况-可折叠展开 -->
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit dbToggle">
					<span class="fl">家庭情况</span>
					<span class="fr mgr15">
						<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('familyWrap',this)">
							<i class="icon-double-angle-down collapseBtn"></i>
						</a>
					</span>
				</div>
				<div class="moduleCont dnn" id="familyWrap">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="婚姻状况">婚姻状况:</label>
                           <div class="col-xs-9 col-sm-input">
							<xf:select tableName="TAB_MARRIAGE" valueField="code" textField="name" name="jiaTingForm.faMarriage"  value='${receiveArchivesPersonForm.jiaTingForm.faMarriage}' 
									hasDefault="0" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="结婚时间">结婚时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
		                     	<form:input  class="form-control date" type="text" path="jiaTingForm.faMarriageDate" id="faMarriageDate" placeholder="请选择日期"></form:input>
		                     	<span class="input-group-addon">
		                         	<i class="icon-calendar bigger-110"></i>
		                     	</span>
		                    </div>
		                </div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="配偶姓名">配偶姓名:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="jiaTingForm.faName" ></form:input>
						</div>
					</div>
				<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="配偶身份证号">配偶身份证号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="jiaTingForm.faSpouseCard" id="faSpouseCard"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="配偶出生日期">配偶出生日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
		                     	<form:input  class="form-control date" type="text" path="jiaTingForm.faSpouseBirth" id="faSpouseBirth" placeholder="请选择日期"></form:input>
		                     	<span class="input-group-addon">
		                         	<i class="icon-calendar bigger-110"></i>
		                     	</span>
		                     </div>
		                </div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="配偶民族">配偶民族:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select  tableName="TAB_NATION" valueField="code" textField="name" name="jiaTingForm.faSpouseNational" 
								value='${receiveArchivesPersonForm.jiaTingForm.faSpouseNational}' hasDefault="0" selectClass="form-control"></xf:select>
						</div>
				</div>
				<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="配偶单位">配偶单位:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="jiaTingForm.faSpouseCompany" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="配偶电话">配偶电话:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="jiaTingForm.faSpousePhone" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="计生情况">计生情况:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select  tableName="TAB_CONDITION" valueField="code" textField="name" name="jiaTingForm.faBirthCondition" 
								value='${receiveArchivesPersonForm.jiaTingForm.faBirthCondition}' hasDefault="0" selectClass="form-control"></xf:select>
						</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="节育措施">节育措施:</label>
					<div class="col-xs-9 col-sm-input">
						<xf:select  tableName="TAB_BIRTHCONTROL" valueField="code" textField="name" name="jiaTingForm.faBirthControl" 
							value='${receiveArchivesPersonForm.jiaTingForm.faBirthControl}' hasDefault="0" selectClass="form-control"></xf:select>
					</div>
				</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError" title="家庭情况备注">家庭情况备注:</label>
								<div class="col-xs-9 col-sm-three-col">
									<form:textarea  type="text"  path="jiaTingForm.faFamilyBark" row="5" col="5" ></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--学校情况-->
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit dbToggle">
					<span class="fl">学校情况</span>
					<span class="fr mgr15">
						<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('studyWrap',this)">
							<i class="icon-double-angle-down collapseBtn"></i>
						</a>
					</span>
				</div>
				<div class="moduleCont dnn" id="studyWrap">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="毕业时间">毕业时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
		                     	<form:input  class="form-control date" type="text"  path="jiaoYuForm.aac046" id="aac046" placeholder="请选择日期"></form:input>
		                     	<span class="input-group-addon">
		                         	<i class="icon-calendar bigger-110"></i>
		                     	</span>
		                     </div>
		                </div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="学校名称">学校名称:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="jiaoYuForm.aac045" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="毕业生类别">毕业生类别:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select  tableName="TAB_EDUCATION" valueField="code" textField="name" name="jiaoYuForm.atc011" 
								 value='${receiveArchivesPersonForm.jiaoYuForm.atc011}' hasDefault="0" selectClass="form-control"></xf:select>
						</div>
					</div>
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="学位">学位:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select  tableName="TAB_DEGREE" valueField="code" textField="name" name="jiaoYuForm.aac037"  
									value='${receiveArchivesPersonForm.jiaoYuForm.aac037}' hasDefault="0" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="所在专业">所在专业:</label>
						<div class="col-xs-9 col-sm-input">
							<xf:select  tableName="TAB_PROFESSION" valueField="code" textField="name" name="jiaoYuForm.acc01g"  
								value='${receiveArchivesPersonForm.jiaoYuForm.acc01g}' hasDefault="0" selectClass="form-control"></xf:select>
						</div>
					</div>
				</div>
			</div>
			<!--参加保险情况-->
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit dbToggle">
					<span class="fl">参加保险情况</span>
					<span class="fr mgr15">
						<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('insureWrap',this)">
							<i class="icon-double-angle-down collapseBtn"></i>
						</a>
					</span>
				</div>
				<div class="moduleCont dnn" id="insureWrap">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="社会保障号">社会保障号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="personBaseForm.expSoctalNumber" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="参加养老保险时间">参加养老保险时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
		                     	<form:input  class="form-control date" type="text"  path="personBaseForm.expPensionDate" id="expPensionDate" placeholder="请选择日期"></form:input>
		                     	<span class="input-group-addon">
		                         	<i class="icon-calendar bigger-110"></i>
		                     	</span>
		                     </div>
		                </div>
                        <label class="col-xs-3 col-sm-label" for="inputError" title="参加医疗保险时间">参加医疗保险时间:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
			                   	<form:input  class="form-control date" type="text" path="personBaseForm.expMedicalDate" id="expMedicalDate" placeholder="请选择日期"></form:input>
			                   	<span class="input-group-addon">
			                       	<i class="icon-calendar bigger-110"></i>
			                   	</span>
			                </div> 
		                </div>
		          </div>   
		          <div class="row">
                         <div class="col-xs-12 col-sm-12 threeCol">
							<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError" title="参加保险情况备注">参加保险情况备注:</label>
								<div class="col-xs-9 col-sm-three-col">
									<form:textarea  type="text"  path="personBaseForm.expInsurance" row="5" col="5" ></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--档案存放情况-->
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit dbToggle">
					<span class="fl">档案存放情况</span>
					<span class="fr mgr15">
						<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('archiveWrap',this)">
							<i class="icon-double-angle-down collapseBtn"></i>
						</a>
					</span>
				</div>
				<div class="moduleCont " id="archiveWrap">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="档案编号">档案编号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="archiveCode" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="存档类型"><em>*</em>存档类型:</label>
						<div class="col-xs-9 col-sm-input required">
							<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" textField="name" name="archiveType"  
								value='${receiveArchivesPersonForm.archiveType}' valueCon="1" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="档案转入日期">档案转入日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
			                  	<form:input  class="form-control date" type="text" path="receiveDate" placeholder="请选择日期"></form:input>
			                  	<span class="input-group-addon">
			                      	<i class="icon-calendar bigger-110"></i>
			                  	</span>
			                 </div>
		                </div>
			     </div>
	             <div class="row">
                        <label class="col-xs-3 col-sm-label" for="inputError" title="档案姓名">档案姓名:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="archiveName" id="archiveNameTwo" onkeyup="SyncContentDown()"></form:input>
						</div>
                        <label class="col-xs-3 col-sm-label" for="inputError" title="档案出生日期">档案出生日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
		                     	<form:input  class="form-control date" type="text" path="archiveBirthDate" placeholder="请选择日期"></form:input>
		                     	<span class="input-group-addon">
		                         	<i class="icon-calendar bigger-110"></i>
		                     	</span>
		                     </div>
		                </div>
                        <label class="col-xs-3 col-sm-label" for="inputError" title="退休参考日期">退休参考日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
		                     	<form:input  class="form-control date" type="text" path="planRetiredDate" placeholder="请选择日期"></form:input>
		                     	<span class="input-group-addon">
		                         	<i class="icon-calendar bigger-110"></i>
		                     	</span>
		                     </div>
		                </div>
			     </div>
	             <div class="row">
                        <label class="col-xs-3 col-sm-label" for="inputError" title="退休年数">退休年数:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="retiredAge" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="档案来源">档案来源:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="archiveSource" ></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="合同编号">合同编号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="contractCode" ></form:input>
						</div>
				 </div>
	             <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="市场位置">市场位置:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="marketPosition" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">区:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="cabinetsLibrary" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">柜:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="cabinetsCode" readonly="true"></form:input>
						</div>
				 </div>
	             <div class="row">	
						<label class="col-xs-3 col-sm-label" for="inputError">排:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="cabinetsLayer" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError">列:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="cabinetsLattice" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="个人编号">个人编号:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="expPersonNumber" ></form:input>
						</div>
				 </div>
	             	<div class="row">	
                           <div class="col-xs-12 col-sm-12 threeCol">
							<div class="row">
								<label class="col-xs-3 col-sm-label" for="inputError" title="档案存放位置备注">档案存放位置备注:</label>
								<div class="col-xs-9 col-sm-three-col">
									<form:textarea  type="text"  path="archiveReceiveDesc" row="5" col="5" readonly="true"></form:textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--状态信息-->
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleTit dbToggle">
					<span class="fl">状态信息</span>
					<span class="fr mgr15">
						<a href="javascript:void(0)" class="btnToggle" onclick="collapseWrap('statusWrap',this)">
							<i class="icon-double-angle-down collapseBtn"></i>
						</a>
					</span>
				</div>
				<div class="moduleCont " id="statusWrap">
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否欠费">是否欠费:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expArrears" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="借阅状态">借阅状态:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expBorrowingStatus" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
                           <label class="col-xs-3 col-sm-label" for="inputError" title="是否正式退休">是否正式退休:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expRetire" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
                           <label class="col-xs-3 col-sm-label" for="inputError" title="是否转社会化">是否转社会化:</label>
						<div class="col-xs-9 input-group col-sm-input">
                             	<form:select  class="form-control" type="text" path="personBaseForm.expSocialization" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
                           </div>
                           <label class="col-xs-3 col-sm-label" for="inputError" title="是否代管组织关系">是否代管组织关系:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text"  path="personBaseForm.expOrganize" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管户口">是否代管户口:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expResidence" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管养老保险">是否代管养老保险:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expPension" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管医疗保险">是否代管医疗保险:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expMedical" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管工伤保险">是否代管工伤保险:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expInjury" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管生育保险">是否代管生育保险:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expBirth" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管大病医保">是否代管大病医保:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expSerious" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管失业保险">是否代管失业保险:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expUnemployment" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否代管住房公积金">是否代管住房公积金:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text" path="personBaseForm.expAccumulation" disabled="true">
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
					</div>
				</div>
			</div>
			<hr />
			<div class="col-xs-12 col-sm-12">
				<label class="col-xs-3 col-sm-label" for="inputError" title="经办日期">经办日期:</label>
				<div class="col-xs-9 col-sm-input">
                       <form:input  class="form-control" type="text" path="archiveReceiveDate" readonly="true"></form:input>
                   </div>
				<label class="col-xs-3 col-sm-label" for="inputError" title="经办机构">经办机构:</label>
				<div class="col-xs-9 col-sm-input">
					<form:input  class="form-control" type="text" path="archiveReceiveOrgName" readonly="true"></form:input>
				</div>
				<label class="col-xs-3 col-sm-label" for="inputError" title="经办人">经办人:</label>
				<div class="col-xs-9 col-sm-input">
					<form:input  class="form-control" type="text" path="archiveReceiveName" readonly="true"></form:input>
				</div>
			</div>
	   	</div>
	   	<div class="bottomBtn">
	   		<div class="h50">&nbsp;</div>
	   		<div class="floatBtn">
	   			<a href="javascript:void(0)" role="button" class="btn btn-primary" data-toggle="modal"><i class="icon-camera"></i>拍照</a>
				<a href="javascript:void(0)" role="button" class="btn btn-info"><i class="icon-upload-alt"></i>照片上传</a>
				<a href="javascript:void(0)" role="button" class="btn btn-danger"><i class="icon-trash"></i>照片删除</a>
	   			<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
		   		<a role="button" class="btn btn-success" href="javascript:printCodeLabel('${personId}','${archiveId}')"><i class="icon-barcode"></i>打印条码标签</a>
		   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   		</div>
	   	</div>
	</div>
 </form:form>
 <script type="text/javascript">
	 function closeItem(){
		xfui.closeDialog();
	 }
	$(function() {
		initFormSubimt();
	});
		
	$(".dbToggle").dblclick(function(){
		$(this).siblings(".moduleCont").slideToggle(400);
		$(this).find("i").toggleClass("icon-double-angle-down");
		$(this).find("i").toggleClass("icon-double-angle-up");
		if($(this).parents(".moduleWrapNobg")){
			$(this).parents(".moduleWrapNobg").toggleClass("change-bg");	
		}
		else if($(this).parents(".moduleWrap")){
			$(this).parents(".moduleWrap").toggleClass("change-bg");	
		}
		else if($(this).parents(".moduleWrapNob")){
			$(this).parents(".moduleWrapNob").toggleClass("change-bg");	
		}
	});
	//档案接收保存
	function initFormSubimt(){
         $('#receiveArchivesPersonForm').bootstrapValidator({
               message: 'This value is not valid',
               feedbackIcons: {
                   valid: 'glyphicon glyphicon-ok',
                   invalid: 'glyphicon glyphicon-remove',
                   validating: 'glyphicon glyphicon-refresh'
               },
               fields: {
            	 //身份证号
            	   "personBaseForm.aac002" : {
                       validators: {
                           notEmpty: {
                        	   message: '身份证号不允许为空'
                           },
                           callback: {
	           					message: '身份证号格式不正确',
	           					callback:function(value, validator,$field){
	           						if(!value){
	           							return true;
	           						}
	           						return validateIdCard(value);
	           					}
	           			   }
                           
                       }
                   },
                   //个人编号
	                expPersonNumber : {
	                    validators: {
	                		   stringLength: {min: 2,max: 25, message:'长度在2-25位之间' } 
	                    }
	                },
                   //曾用名
                   "personBaseForm.expUserName" : {
                       validators: {
                   		   stringLength: {min: 1,max: 20, message:'长度在1-20位之间' } 
                       }
                   },
                   //档案姓名
                   "personBaseForm.archiveName" : {
                       validators: {
                   		   stringLength: {min: 1,max: 10, message:'字数在1到10个汉字之间' } 
                       }
                   },
                  //联系电话
                   "personBaseForm.expPersonPhone" : {
                       validators: {
                    	    stringLength: { max: 15 },
	   	               		regexp: {
	   	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	   	              			message: '电话号码或手机号码格式不正确'
	   	               		}
                       }
                   },
                   //档案姓名
                  archiveName : {
                       validators: {
                   		   stringLength: {min: 1,max: 10, message:'字数在1到10个汉字之间' } 
                       }
                   },
                   //再就业优惠证编号
                   "personBaseForm.expRegisgration" : {
                       validators: {
                    	   stringLength: {min: 1,max: 20, message:'长度在1-20位之间' }, 
		                   regexp: {
		                       regexp: /^[a-zA-Z0-9]+$/,
		                       message: '只能包含字母和数字'
		                   } 
                       }
                   },
                   //身份证住址
                   "personBaseForm.expCardNumber" : {
                       validators: {
                   		   stringLength: {min: 1,max: 50, message:'长度在1-50位之间' } 
                       }
                   },
                   //就业失业登记证号
                   "personBaseForm.acc0m1" : {
                       validators: {
                    	   stringLength: {min: 1,max: 20, message:'长度在1-20位之间' }, 
		                   regexp: {
		                       regexp: /^[a-zA-Z0-9]+$/,
		                       message: '只能包含字母和数字'
		                   }
                       }
                   },
                   //现居住地址
                   "personBaseForm.aab301" : {
                       validators: {
                   		   stringLength: {min: 1,max: 50, message:'长度在1-50位之间' } 
                       }
                   },
                   //基本情况备注
                   "personBaseForm.aae013" : {
                       validators: {
                   		   stringLength: {min: 1,max: 50, message:'长度在1-50位之间' } 
                       }
                   },
                  //原单位名称
                   "gongZuoForm.expOldCompany" : {
                       validators: {
                   		   stringLength: {min: 1,max: 25, message:'长度在1-25位之间' } 
                       }
                   },
                  //职务
                   "gongZuoForm.expPost" : {
                       validators: {
                   		   stringLength: {min: 1,max: 25, message:'长度在1-25位之间' } 
                       }
                   },
                  //现单位名称
                   "gongZuoForm.aac045" : {
                       validators: {
                   		   stringLength: {min: 1,max: 25, message:'长度在1-25位之间' } 
                       }
                   },
                   //专业工种
                   "gongZuoForm.expZhuanye" : {
                       validators: {
                   		   stringLength: {min: 1,max: 25, message:'长度在1-25位之间' } 
                       }
                   },
                  //工作备注
                   "gongZuoForm.aae013" : {
                       validators: {
                   		   stringLength: {min: 1,max: 50, message:'长度在1-50位之间' } 
                       }
                   },
                 //配偶姓名
                   "jiaTingForm.faName" : {
                       validators: {
                   		   stringLength: {min: 1,max: 10, message:'长度在1-10位之间' } 
                       }
                   },
                   //配偶身份证号
                   "jiaTingForm.faSpouseCard" : {
                       validators: {
                    	   callback: {
	           					message: '身份证号格式不正确',
	           					callback:function(value, validator,$field){
	           						if(!value){
	           							return true;
	           						}
	           						return validateIdCard(value);
	           					}
	           			   }
                       }
                   },
                   //配偶单位
                   "jiaTingForm.faSpouseCompany" : {
                	   validators: {  stringLength: { min: 0, max: 50,message:'最多输入50个汉字'  } } 
                   },
                  //配偶电话
                   "jiaTingForm.faSpousePhone" : {
                       validators: {
                    	    stringLength: { max: 15 },
	   	               		regexp: {
	   	        				regexp :/^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})|[1-9]\d{6,7}(\d{1,4})?$|(^1[3|4|5|7|8]\d{9}$)/,
	   	              			message: '电话号码或手机号码格式不正确'
	   	               		}
                       }
                   },
                  //家庭情况备注
                   "jiaTingForm.faFamilyBark" : {
                       validators: {
                   		   stringLength: {min: 1,max: 100, message:'长度在1-100位之间' } 
                       }
                   },
                  //学校名称
                   "jiaoYuForm.aac045" : {
                       validators: {
                   		   stringLength: {min: 1,max: 25, message:'长度在1-25位之间' } 
                       }
                   },
                 //学校名称
                   "jiaoYuForm.aac045" : {
                       validators: {
                   		   stringLength: {min: 1,max: 25, message:'长度在1-25位之间' } 
                       }
                   },
                  //社会保障号
                   "personBaseForm.expSoctalNumber" : {
                       validators: {
                   		   stringLength: {min: 1,max: 15, message:'长度在1-15位之间' } 
                       }
                   },
                   //参加保险情况备注
                   "personBaseForm.expInsurance" : {
                       validators: {
                   		   stringLength: {min: 1,max: 100, message:'长度在1-100位之间' } 
                       }
                   },
                  //退休年数
                   retiredAge : {
                       validators: {
                    	   numeric : {
		                        message: '请输入正整数'
		                   },
                   		   stringLength: {min: 1,max: 3, message:'长度在1-3位之间' } 
                       }
                   },
                  //档案来源
                   archiveSource : {
                       validators: {
                   		   stringLength: {min: 1,max: 25, message:'长度在1-25位之间' } 
                       }
                   },
                  //合同编号
                   contractCode : {
                       validators: {
                   		   stringLength: {min: 1,max: 15, message:'长度在1-15位之间' } 
                       }
                   },
                   //存档类型
                   archiveType : {
                       validators: {
                           notEmpty: {
                        	   message: '存档类型不允许为空'
                           }
                       }
                   },
                   //手机号
                   "personBaseForm.aae005":{
	                  	validators: {
	                  			notEmpty: {
	                  				message: '手机号不允许为空'
	                           	},
		                  		regexp: {
		                              regexp: /^1[3|4|5|7|8]\d{9}$/,
		                              message: '手机号格式不正确'
		                            }
	                  	}
                   },
                   //参加工作时间
 	           	  "gongZuoForm.expStartJobDate": {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	  //结婚时间
 	           	  "jiaTingForm.faMarriageDate": {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	//配偶出生日期
 	           	  "jiaTingForm.faSpouseBirth": {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	//毕业时间
 	           	  "jiaoYuForm.aac046": {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	 //参加养老保险时间
 	           	  "personBaseForm.expPensionDate": {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	 //参加医疗保险时间
 	           	  "personBaseForm.expMedicalDate": {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	 //档案转入日期
 	           	  receiveDate: {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	 //档案出生日期
 	           	  archiveBirthDate: {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  },
 	           	 //退休参考日期
 	           	  planRetiredDate: {
 	                    validators: { 
 	                        date: {
 	                            format: 'YYYY-MM-DD',
 	                            message: '请输入正确的时间格式'
 	                        }
 	           	  	   }
 	           	  }
               }
		     }).on('success.form.bv', function(e) {
                    e.preventDefault();
                    var $form = $(e.target);
                    var bv = $form.data('bootstrapValidator');
                    bv.disableSubmitButtons(true);
                    $.post($form.attr('action'), $form.serialize(), function(data) {
                    	console.info(data);
                        bootbox.alert({ 
                            size: 'small',
                            width:"100px",
                            message: data.message, 
                            callback: function(){ 
                            	bv.disableSubmitButtons(false);
                            	var parentIframe=xfui.getParentIframe();
            			    	if(parentIframe){
            			    		parentIframe.refresh();
            			    	}
                            	closeItem(); 
                            }
                        })
                    }, 'json');

                });
       }
	//打印条形码
	function printCodeLabel(personId,archiveId){
		if(personId>0){
			if(archiveId>0){
				var param = {"id":archiveId,"type":3};
				templatePrint("archiveLabel",param);
			}else{
				bootbox.alert('请先保存接收档案信息，再打印条码标签！');
			}
		}else{
			bootbox.alert('请先选择要打印的个人档案信息！');
		}
	}
</script>
</body>		
</html>