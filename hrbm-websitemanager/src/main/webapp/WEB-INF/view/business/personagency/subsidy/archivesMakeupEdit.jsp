<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript" src="${ctx}/js/business/personagency/subsidy/archivesMakeupEdit.js?version=20161132"></script>
   	  <form:form modelAttribute="archivesMakeupForm" method="post" action="${ctx}//business/personagency/subsidy/makeup/save.xf">
				 <form:hidden path="aac001" ></form:hidden>
				 <form:hidden path="lendCreaterId" ></form:hidden>
				 <form:hidden path="lendCreaterOrgId" ></form:hidden>
				 <form:hidden path="lendConfirmId" ></form:hidden>
				 <form:hidden path="lendConfirmOrgId" ></form:hidden>
				<div class="moduleWrapNobg">
					<div class="moduleTit">个人基本信息</div>
					<div class="moduleCont">
				  <div class="row" >
									<label class="col-xs-3 col-sm-2" for="inputError">身份证号：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">姓名：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">姓名拼音码：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="aac022" readonly="true"></form:input>									   
									</div>
									
									<label class="col-xs-3 col-sm-2" for="inputError">出生日期：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="aac006" readonly="true"></form:input>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">性别：</label> 
									<div class="col-xs-9 col-sm-2 ">
										 <xf:select textField="name"  selectClass="form-control"  id="aac004"  tableName="TAB_SEX" isNoStyle="true" name="aac004" valueField="code" hasDefault="0" value="${archivesMakeupForm.aac004 }"></xf:select>
										 									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">民族：</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect"> 
											<xf:select textField="name" selectClass="form-control"  tableName="TAB_NATION" id="nationCode" name="aac005" value="${archivesMakeupForm.aac005 }"  valueField="code" hasDefault="0"></xf:select>
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">曾用名：</label> 
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="expUserName" ></form:input>									   
									</div>	
									<label class="col-xs-3 col-sm-2" for="inputError">政治面貌：</label>
										<div class="col-xs-9 col-sm-2 mhyNoSelect">
												<xf:select textField="name"  selectClass="form-control" tableName="TAB_AFFIL" name="aac024"  value="${archivesMakeupForm.aac024 }"  valueField="code" hasDefault="0"></xf:select> 
										</div>
									<label class="col-xs-3 col-sm-2" for="inputError">文化程度：</label>
									<div class="col-xs-9 col-sm-2 mhyNoSelect">
												<xf:select textField="name"  selectClass="form-control"  tableName="TAB_EDUCATION" name="aac011" value="${archivesMakeupForm.aac011 }" valueField="code" hasDefault="0"></xf:select>
									</div>		
									<label class="col-xs-3 col-sm-2" for="inputError">联系电话：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="expPersonPhone" ></form:input>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">手机号：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="aae005" ></form:input>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">是否军转干部：</label>
									<div class="col-xs-9 col-sm-2 ">
										<form:select path="expIsCadre" class="form-control">
											<form:option value="" label="--请选择--"/>
											<form:option value="0" label="否"/> 
											<form:option value="1" label="是"/> 
										</form:select>
<%-- 									<form:input  class="form-control" type="text"  path="expIsCadre" ></form:input> --%>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">是否再就业优惠证：</label>
									<div class="col-xs-9 col-sm-2 ">
										<form:select path="expIsDiscount" class="form-control">
											<form:option value="" label="--请选择--"/>
											<form:option value="0" label="否"/> 
											<form:option value="1" label="是"/> 
										</form:select>
<%-- 									<form:input  class="form-control" type="text"  path="expIsDiscount" ></form:input> --%>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">再就业优惠证编号：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="expRegisgration" ></form:input>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">身份证地址：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="expCardNumber" ></form:input>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">是否持有就业失业登记证：</label>
									<div class="col-xs-9 col-sm-2 ">
										<form:select path="expIsRegisgration" class="form-control">
											<form:option value="" label="--请选择--"/>
											<form:option value="0" label="否"/> 
											<form:option value="1" label="是"/> 
										</form:select>
<%-- 									<form:input  class="form-control" type="text"  path="expIsRegisgration" ></form:input> --%>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">就业失业登记证号码：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="acc0m1" ></form:input>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">现居住地址：</label>
									<div class="col-xs-9 col-sm-2 ">
										 <form:input  class="form-control" type="text"  path="aab301" ></form:input>
									   
									</div>
									<label class="col-xs-3 col-sm-2" for="inputError">基本情况备注：</label>
									<div class="col-xs-9 col-sm-10 ">
										 <form:input  class="form-control" type="text"  path="aae013" ></form:input>
									</div>
				     </div>
				    </div>
				</div>
				<div class="moduleWrapNobg">
					<div class="moduleTit">档案信息</div>
					<div class="moduleCont">
				    	 <div class="row" >
							<label class="col-xs-3 col-sm-2" for="inputError">档案编号：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="archiveCode" value="社保补贴补录" readonly="true"></form:input>									   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">档案转入日期：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="storageDate" readonly="true"></form:input>								   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">存档类型：</label>
							<div class="col-xs-9 col-sm-2 ">
								
								<xf:select  tableName="RSDA_TAB_ARCHIVETYPE" valueField="code" textField="name" name="archiveType"  disabled="true"
								value='${archivesMakeupForm.archiveType}'  selectClass="form-control"></xf:select>
							</div>
				     </div>
				   </div>
				 </div>	
				 <div class="moduleWrapNobg">
					<div class="moduleTit">经办信息</div>
					<div class="moduleCont">
				    <div class="row" >
							<label class="col-xs-3 col-sm-2" for="inputError">档案状态：</label>
							<div class="col-xs-9 col-sm-2 ">
								<input  class="form-control" type="text"  value="<xf:out  tableName='rsda_tab_archivestatus' valueField='code' textField='name' 
						 		value='${archivesMakeupForm.archiveStatus}' ></xf:out>"  readonly="true"></input>							   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出时间：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="lendDate" readonly="true"></form:input>								   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出原因：</label>
							<div class="col-xs-9 col-sm-2 ">
								<input  class="form-control" type="text"  value="<xf:out  tableName='RSDA_TAB_LEND_REASON' valueField='code' textField='name' 
						 		value='${archivesMakeupForm.lendReason}' ></xf:out>"  readonly="true"></input>
								
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">窗口经办人：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="lendCreaterName" readonly="true"></form:input>									   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">窗口经办机构：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="lendCreaterOrgName" readonly="true"></form:input>								   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">窗口经办日期：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="lendCreaterDate" readonly="true"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办人：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="lendConfirmName" readonly="true"></form:input>									   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办机构：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="lendConfirmOrgName" readonly="true"></form:input>								   
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">调出经办日期：</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input  class="form-control" type="text"  path="lendConfirmDate" readonly="true"></form:input>
							</div>
				     </div>
				   </div>
				 </div>												
				<div class="h60">&nbsp;</div>
				   	<div class="floatBtn">
				   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
			   		    <a href="javascript:addItem()" role="button" class="btn btn-primary" ><i class="icon-plus"></i>新增</a>
				   		
				   	</div>
        </form:form>
