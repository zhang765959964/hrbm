<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>个人档案接收查询结果显示页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script type="text/javascript" src='${ctx}/js/util/commonUtil.js'></script>
</head>



<body>
	<form:form modelAttribute="receiveArchivesPersonForm" method="post" >
	<form:hidden path="personBaseForm.aac001" ></form:hidden>
	<form:hidden path="personBaseForm.id" ></form:hidden>
	<form:hidden path="personBaseForm.expandId" ></form:hidden>
	<form:hidden path="archiveReceiveUserid" ></form:hidden>
	<form:hidden path="archiveReceiveOrgId" ></form:hidden>
	<form:hidden path="gongZuoForm.aac0b0" ></form:hidden>
	<form:hidden path="jiaTingForm.id" ></form:hidden>
	<form:hidden path="jiaoYuForm.aac0d0" ></form:hidden>
	<form:hidden path="id" ></form:hidden>
	<div>
		<!-- 个人信息带身份证图片 -->
		<div class="moduleWrapNobg">
			<div class="moduleTit" id="cdXx">存档信息</div>
			<div class="moduleCont">
				<div class="row">
					<div class="col-xs-12 col-sm-10 hauto">
						<div class="row">
							<label class="col-xs-3 w1995" for="inputError">身份证号:</label>
							<div class="col-xs-9 w2009">
								<form:input  class="form-control" type="text" path="personBaseForm.aac002" data-container="body" readonly="true" data-toggle="popover"></form:input>
							</div>
							<label class="col-xs-3 w199" for="inputError">姓名:</label>
							<div class="col-xs-9 w361">
								<form:input  class="form-control" type="text" path="personBaseForm.aac003" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 w1995" for="inputError">出生日期:</label>
							<div class="col-xs-9 w2009">
								<form:input  class="form-control" type="text" path="personBaseForm.aac006" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 w199" for="inputError">曾用名:</label>
							<div class="col-xs-9 w361">
								<form:input  class="form-control" type="text" path="personBaseForm.expUserName" readonly="true" ></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 w1995" for="inputError">性别:</label>
							<div class="col-xs-9 w2009">
								<form:input  class="form-control" type="text" path="personBaseForm.genderName" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 w199" for="inputError">档案姓名:</label>
							<div class="col-xs-9 w361">
								<form:input  class="form-control" type="text" path="personBaseForm.archiveName" readonly="true" id="archiveNameOne" onkeyup="SyncContent()"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 w1995" for="inputError">民族:</label>
							<div class="col-xs-9 w2009">
								<xf:select  tableName="TAB_NATION" selectClass="form-control" valueField="code" textField="name" name="personBaseForm.aac005"
										value='${receiveArchivesPersonForm.personBaseForm.aac005}' hasDefault="0"></xf:select>
							</div>
							<label class="col-xs-3 w199" for="inputError" title="政治面貌">政治面貌:</label>
							<div class="col-xs-9 w361">
								<xf:select  tableName="TAB_AFFIL" selectClass="form-control" valueField="code" textField="name" name="personBaseForm.aac024" value='${receiveArchivesPersonForm.personBaseForm.aac024}' hasDefault="0"></xf:select>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 w1995" for="inputError" title="文化程度">文化程度:</label>
							<div class="col-xs-9 w2009">
								<xf:select  tableName="TAB_EDUCATION" selectClass="form-control" valueField="code" textField="name" name="personBaseForm.aac011"  value='${receiveArchivesPersonForm.personBaseForm.aac011}' hasDefault="0" ></xf:select>
							</div>
							<label class="col-xs-3 w199" for="inputError" title="联系电话">联系电话:</label>
							<div class="col-xs-9 w361">
								<form:input  class="form-control" type="text"  path="personBaseForm.expPersonPhone" readonly="true"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 w1995" for="inputError" title="手机号">手机号:</label>
							<div class="col-xs-9 w2009">
								<form:input  class="form-control" type="text"  path="personBaseForm.aae005" readonly="true" data-container="body" data-toggle="popover"></form:input>
							</div>
							<label class="col-xs-3 w199" for="inputError" title="是否军转干部">是否军转干部:</label>
							<div class="col-xs-9 w361">
								<form:select  class="form-control" type="text"  path="personBaseForm.expIsCadre" >
									<form:option value="0" label="否"/>否
									<form:option value="1" label="是"/>是
								</form:select>
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-2 hauto">
						<img class="bd idcard" src="${ctx}/styles/default/images/idcard.jpg" alt="个人身份证图片" width="140" height="196">
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError" title="是否享有再就业优惠证标准">是否享有再就业优惠证标准:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text"  path="personBaseForm.expIsDiscount" >
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="是否持有就业失业登记证">是否持有就业失业登记证:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text"  path="personBaseForm.expIsRegisgration" >
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="再就业优惠证编号">再就业优惠证编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="personBaseForm.expRegisgration" readonly="true"></form:input>
					</div>
					<div class="col-xs-12 col-sm-8">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="身份证住址">身份证住址:</label>
							<div class="col-xs-12 col-sm-9">
								<form:input  class="form-control" type="text"  path="personBaseForm.expCardNumber" readonly="true"></form:input>
							</div>
						</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="就业失业登记证号">就业失业登记证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="personBaseForm.acc0m1" readonly="true"></form:input>
					</div>
					<div class="col-xs-12 col-sm-8">
						<div class="row">
							<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
							<div class="col-xs-9 col-sm-9">
								<form:input  class="form-control" type="text"  path="personBaseForm.aab301" readonly="true" ></form:input>
							</div>
						</div>
					</div>
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="基本情况备注">基本情况备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="personBaseForm.aae013" row="5" col="5" readonly="true"></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 工作情况-带点击按钮 -->
		<div class="moduleWrapNobg">
			<div class="moduleTit dbToggle">
				<span class="fl"><i class="icon-minus icon-rotate-90"></i>工作情况</span>
				<span class="fr mgr15">
					<a href="javascript:collapseWrap('workQk',this)" class="btnToggle" >
						<i class="icon-double-angle-down"></i>
					</a>
				</span>
			</div>
			<div class="moduleCont" id="workQk">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">参加工作时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
                       	<form:input  class="form-control date-picker dp" type="text"  path="gongZuoForm.expStartJobDate" readonly="true"></form:input>
                       	<span class="input-group-addon">
                           	<i class="icon-calendar bigger-110"></i>
                       	</span>
                    </div>
					<label class="col-xs-3 col-sm-2" for="inputError">原单位名称:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="gongZuoForm.expOldCompany" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">职务:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="gongZuoForm.expPost" readonly="true"></form:input>
					</div>
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="主要工作简历">主要工作简历:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="gongZuoForm.mainWork" row="5" col="5" readonly="true" ></form:textarea>
							</div>
						</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">现单位名称:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="gongZuoForm.aac045" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">专业工种:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="gongZuoForm.expZhuanye" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">职业资格等级:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select  tableName="TAB_COQ" selectClass="form-control" valueField="code" textField="name" name="gongZuoForm.aac015"  value='${receiveArchivesPersonForm.gongZuoForm.aac015}' hasDefault="0" ></xf:select>
					</div>
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="工作备注">工作备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="gongZuoForm.aae013" row="5" col="5" readonly="true"></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 家庭情况-可折叠展开 -->
		<div class="moduleWrapNobg">
			<div class="moduleTit dbToggle">
				<span class="fl"><i class="icon-minus icon-rotate-90"></i>家庭情况</span>
				<span class="fr mgr15">
					<a  class="btnToggle" href="javascript:collapseWrap('familyWrap',this)">
						<i class="icon-double-angle-down"></i>
					</a>
				</span>
			</div>
			<div class="moduleCont dnn" id="familyWrap">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">婚姻状况:</label>
                       <div class="col-xs-9 col-sm-2">
						<xf:select tableName="TAB_MARRIAGE" selectClass="form-control" valueField="code" textField="name" name="jiaTingForm.faMarriage"  value='${receiveArchivesPersonForm.jiaTingForm.faMarriage}'
								hasDefault="0" ></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">结婚时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" type="text"  path="jiaTingForm.faMarriageDate" readonly="true" ></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
					<label class="col-xs-3 col-sm-2" for="inputError">配偶姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="jiaTingForm.faName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">配偶身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="jiaTingForm.faSpouseCard" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">配偶出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" type="text" readonly="true"  path="jiaTingForm.faSpouseBirth" ></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
					<label class="col-xs-3 col-sm-2" for="inputError">配偶民族:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select  tableName="TAB_NATION" selectClass="form-control" valueField="code" textField="name" name="jiaTingForm.faSpouseNational"
							value='${receiveArchivesPersonForm.jiaTingForm.faSpouseNational}' hasDefault="0"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">配偶单位:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="jiaTingForm.faSpouseCompany" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">配偶电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="jiaTingForm.faSpousePhone" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">计生情况:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select  tableName="TAB_CONDITION" selectClass="form-control" valueField="code" textField="name" name="jiaTingForm.faBirthCondition"
							value='${receiveArchivesPersonForm.jiaTingForm.faBirthCondition}' hasDefault="0"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">节育措施:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select  tableName="TAB_BIRTHCONTROL" selectClass="form-control" valueField="code" textField="name" name="jiaTingForm.faBirthControl"
							value='${receiveArchivesPersonForm.jiaTingForm.faBirthControl}' hasDefault="0"></xf:select>
					</div>
					<div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="家庭情况备注">家庭情况备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="jiaTingForm.faFamilyBark" readonly="true"  row="5" col="5" ></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--学校情况-->
		<div class="moduleWrapNobg">
			<div class="moduleTit dbToggle">
				<span class="fl"><i class="icon-minus icon-rotate-90"></i>学校情况</span>
				<span class="fr mgr15">
					<a href="javascript:collapseWrap('schoolQk',this)" class="btnToggle" >
						<i class="icon-double-angle-down"></i>
					</a>
				</span>
			</div>
			<div class="moduleCont dnn" id=schoolQk>
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">毕业时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" readonly="true" type="text"  path="jiaoYuForm.aac046" ></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
					<label class="col-xs-3 col-sm-2" for="inputError">学校名称:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="jiaoYuForm.aac045" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">毕业生类别:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select  tableName="TAB_EDUCATION" selectClass="form-control" valueField="code" textField="name" name="jiaoYuForm.atc011"
							 value='${receiveArchivesPersonForm.jiaoYuForm.atc011}' hasDefault="0" ></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">学位:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select  tableName="TAB_DEGREE" selectClass="form-control" valueField="code" textField="name" name="jiaoYuForm.aac037"
								value='${receiveArchivesPersonForm.jiaoYuForm.aac037}' hasDefault="0" ></xf:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">所在专业:</label>
					<div class="col-xs-9 col-sm-2">
						<xf:select  tableName="TAB_PROFESSION" selectClass="form-control" valueField="code" textField="name" name="jiaoYuForm.acc01g"
							value='${receiveArchivesPersonForm.jiaoYuForm.acc01g}' hasDefault="0" ></xf:select>
					</div>
				</div>
			</div>
		</div>
	
		<!--参加保险情况-->
		<div class="moduleWrapNobg">
			<div class="moduleTit dbToggle">
				<span class="fl"><i class="icon-minus icon-rotate-90"></i>参加保险情况</span>
				<span class="fr mgr15">
					<a href="javascript:collapseWrap('insuranceWrap',this)" class="btnToggle" >
						<i class="icon-double-angle-down "></i>
					</a>
				</span>
			</div>
			<div class="moduleCont dnn" id="insuranceWrap">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">社会保障号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="personBaseForm.expSoctalNumber" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">参加养老保险时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" type="text" readonly="true"  path="personBaseForm.expPensionDate" ></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError">参加医疗保险时间:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" type="text"  readonly="true" path="personBaseForm.expMedicalDate"></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="参加保险情况备注">参加保险情况备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="personBaseForm.expInsurance" readonly="true" row="5" col="5" ></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--档案存放情况-->
		<div class="moduleWrapNobg">
			<div class="moduleTit dbToggle">
				<span class="fl"><i class="icon-minus icon-rotate-90"></i>档案存放情况</span>
				<span class="fr mgr15">
					<a href="javascript:collapseWrap('archiveWrap',this)" class="btnToggle" >
						<i class="icon-double-angle-down"></i>
					</a>
				</span>
			</div>
			<div class="moduleCont dnn" id="archiveWrap">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">档案编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="archiveCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">存档类型:</label>
					<div class="col-xs-9 col-sm-2 required">
						<c:choose>
							<c:when test="${receiveArchivesPersonForm.archiveType==null}">
								<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" selectClass="form-control" valueField="code" textField="name" name="archiveType"
									value='${receiveArchivesPersonForm.archiveType}' hasDefault="0" valueCon="2,3,4" ></xf:select>
							</c:when>
							<c:otherwise>
								<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" selectClass="form-control" valueField="code" textField="name" name="archiveType"
									value='${receiveArchivesPersonForm.archiveType}' valueCon="${receiveArchivesPersonForm.archiveType}" ></xf:select>
							</c:otherwise>
						</c:choose>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" type="text" readonly="true" path="receiveDate" ></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError">档案姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="archiveName" readonly="true" id="archiveNameTwo" ></form:input>
					</div>
                       <label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" type="text" readonly="true" path="archiveBirthDate" ></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError">退休参考日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control date-picker dp" type="text" readonly="true" path="planRetiredDate"></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError">退休年数:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="retiredAge" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">档案来源:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="archiveSource" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">合同编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="contractCode" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">市场位置:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" readonly="true" path="marketPosition" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">区:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsLibrary" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">柜:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">排:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsLayer" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">列:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="cabinetsLattice" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">个人编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text" path="expPersonNumber" ></form:input>
					</div>
                       <div class="col-xs-12 col-sm-12">
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError" title="档案存放位置备注">档案存放位置备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="archiveReceiveDesc" row="5" col="5" readonly="true"></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--状态信息-->
		<div class="moduleWrapNobg">
			<div class="moduleTit dbToggle">
				<span class="fl"><i class="icon-minus icon-rotate-90"></i>状态信息</span>
				<span class="fr mgr15">
					<a href="javascript:collapseWrap('statusWrap',this)" class="btnToggle" >
						<i class="icon-double-angle-down"></i>
					</a>
				</span>
			</div>
			<div class="moduleCont dnn" id="statusWrap">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">是否欠费:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expArrears" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">借阅状态:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expBorrowingStatus" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
                       <label class="col-xs-3 col-sm-2" for="inputError">是否正式退休:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expRetire" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
                       <label class="col-xs-3 col-sm-2" for="inputError">是否转社会化:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:select  class="form-control" type="text" path="personBaseForm.expSocialization" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError">是否代管组织关系:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text"  path="personBaseForm.expOrganize" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管户口:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expResidence" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管养老保险:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expPension" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管医疗保险:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expMedical" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管工伤保险:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expInjury" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管生育保险:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expBirth" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管大病医保:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expSerious" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管失业保险:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expUnemployment" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">是否代管住房公积金:</label>
					<div class="col-xs-9 col-sm-2">
						<form:select  class="form-control" type="text" path="personBaseForm.expAccumulation" onfocus="this.defOpt=this.selectedIndex" onchange="this.selectedIndex=this.defOpt;">
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
				</div>
			</div>
		</div>
   	</div>
 </form:form>
