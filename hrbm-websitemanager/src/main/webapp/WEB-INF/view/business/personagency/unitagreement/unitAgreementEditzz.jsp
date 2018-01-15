<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>单位协议终止</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

</head>
<body>
<%-- 	<form:form modelAttribute="unitAgreementForm" method="post" action="${ctx}/business/unitagreement/save.xf"> --%>
	<form:form modelAttribute="unitAgreementForm" method="post" action="${ctx}/business/unitagreement/save.xf">
					<input type="hidden" id="uaStatus" value="${uaStatus}" />
	 				<form:hidden path="id" ></form:hidden> 
	 				<form:hidden path="aab001"></form:hidden>
	 				<form:hidden path="createrId" ></form:hidden>
				 	<form:hidden path="createrOrgId" ></form:hidden>
				 	<form:hidden path="uaStatus" ></form:hidden>
				 			<div class="moduleWrapNobg">
								<div class="moduleTit">单位基本信息</div>
								<div class="moduleCont">
								
					 				 <div class="row" >
					 				 		<div class="col-xs-12 col-sm-8">
												<div class="row">
													<label class="col-xs-3 col-sm-3" for="inputError" title="单位名称">单位名称:</label>
													<div class="col-xs-12 col-sm-9">
														<form:input  class="form-control" type="text"  path="aab004" readonly="true"></form:input>  
													</div>
												</div>
											</div>
											<label class="col-xs-3 col-sm-2" for="inputError" title="工商登记执照号码">工商登记执照号码:</label>
											<div class="col-xs-9 col-sm-2">
												<form:input  class="form-control" type="text"  path="aab007" readonly="true"></form:input>  
											</div>
					       				
									</div>
									<div class="row" >
												<label class="col-xs-3 col-sm-2" for="inputError">所在地区:</label>
												<div class="col-xs-9 col-sm-2 ">
												 	<form:input  class="form-control" type="text"  path="aaa021" readonly="true" ></form:input>
												</div>
												<label class="col-xs-3 col-sm-2" for="inputError" title="单位性质">单位性质:</label>
												<div class="col-xs-9 col-sm-2">
													 <xf:select textField="name" selectClass="form-control" tableName="TAB_UNITNATURE" name="aab019" value="${unitAgreementForm.aab019 }"  valueField="code" hasDefault="0" ></xf:select>
												</div>
												<label class="col-xs-3 col-sm-2" for="inputError" title="经济类型">经济类型:</label>
												<div class="col-xs-9 col-sm-2">
													 <xf:select textField="name" selectClass="form-control" tableName="TAB_ECONOMIC" name="aab020" value="${unitAgreementForm.aab020 }"  valueField="code" hasDefault="0" ></xf:select>
												</div>
									</div>
									<div class="row" >
										<div class="col-xs-12 col-sm-12">
											<div class="row">
												<label class="col-xs-3 col-sm-2" for="inputError" title="地址">地址:</label>
												<div class="col-xs-9 col-sm-10">
													<form:input  class="form-control" type="text"  path="aae006" readonly="true"></form:input>
												</div>
											</div>
										</div>
									</div>
									
								</div>
							</div>
							<div class="moduleWrapNobg">
								<div class="moduleTit" title="单位协议签订">单位协议签订</div>
								<div class="moduleCont">
								<div class="row" >
												<label class="col-xs-3 col-sm-2" for="inputError" title="单位协议编号">单位协议编号:</label>
												<div class="col-xs-9 col-sm-2">
												 	<form:input  class="form-control" type="text"  path="uaNo" ></form:input>
												</div>
												<label class="col-xs-3 col-sm-2" for="inputError" title="协议签订日期">协议签订日期:</label>
												<div class="col-xs-9 input-group col-sm-2">
													<div class="input-group row">
														<form:input  class="form-control" type="text"  path="uaCreatetime"  title="请输入协议签订日期"></form:input>
														<span class="input-group-addon">
															<i class="icon-calendar bigger-110"></i>
														</span>
													</div>
												</div>	 
												<label class="col-xs-3 col-sm-2" for="inputError" title="单位联系人">单位联系人:</label>
												<div class="col-xs-9 col-sm-2">
													<form:input  class="form-control" type="text"  path="uaName"></form:input>
												</div>
								</div>
								<div class="row" >
												<label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
												<div class="col-xs-9 col-sm-2">
												    <form:input  class="form-control" type="text"  path="uaPhone"></form:input>
												</div>
												<label class="col-xs-3 col-sm-2" for="inputError" title="是否免费">是否免费:</label>
												<div class="col-xs-9 col-sm-2">
													<form:select  class="form-control" type="text"  path="uaIsFree">
														<form:option value="0" label="是"/>是
														<form:option value="1" label="否"/>否
													</form:select>
												</div>
												<label class="col-xs-3 col-sm-2" for="inputError" title="办理人身份证号">办理人身份证号:</label>
												<div class="col-xs-9 col-sm-2">
													<form:input  class="form-control" type="text"  path="uaCard"></form:input>
												</div>
								</div>
								<div class="row" >
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<label class="col-xs-3 col-sm-2" for="inputError" title="协议主要内容">协议主要内容:</label>
											<div class="col-xs-9 col-sm-10">
												<form:textarea   type="text"  path="uaContent"></form:textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row" >
									<div class="col-xs-12 col-sm-12">
										<div class="row">
											<label class="col-xs-3 col-sm-2" for="inputError" title="备注">备注:</label>
											<div class="col-xs-9 col-sm-10">
												<form:textarea  class="form-control" type="text"  path="uaNote"></form:textarea>
											</div>
										</div>
									</div>
								</div>
								<div class="row" >
										<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
										<div class="col-xs-9 col-sm-2">
										    <form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
										<div class="col-xs-9 col-sm-2">
									    	<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
										<div class="col-xs-9 input-group col-sm-2">
					                          <form:input  class="form-control" type="text"  path="createrDate"  readonly="true"></form:input>
					                          <span class="input-group-addon">
					                             <i class="icon-calendar bigger-110"></i>
					                          </span>
					                    </div>
								</div>					
							</div>
							</div>
					<div class="moduleWrapNobg">
								<div class="moduleTit">单位协议终止</div>
								<div class="moduleCont">
									<div class="row" >
													<label class="col-xs-3 col-sm-2" for="inputError" title="终止日期"><em>*</em>终止日期:</label>
													<div class="col-xs-9 input-group col-sm-2">
														<div class="input-group row required">
															<form:input  class="form-control" type="text"  path="stopDate"  title="请输入协议签订日期"></form:input>
															<span class="input-group-addon">
																<i class="icon-calendar bigger-110"></i>
															</span>
														</div>
													</div>	 
													<label class="col-xs-3 col-sm-2" for="inputError" title="终止原因"><em>*</em>终止原因:</label>
													<div class="col-xs-9 col-sm-2 required">
														<form:input  class="form-control" type="text"  path="uaStopCause" ></form:input>
													</div>
									</div>
									<div class="row" >
										<label class="col-xs-3 col-sm-2" for="inputError">终止经办人:</label>
										<div class="col-xs-9 col-sm-2">
										    <form:input  class="form-control" type="text"  path="stopName" readonly="true"></form:input>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">终止经办机构:</label>
										<div class="col-xs-9 col-sm-2">
									    	<form:input  class="form-control" type="text"  path="stopOrgName" readonly="true"></form:input>
										</div>
										<label class="col-xs-3 col-sm-2" for="inputError">终止经办日期:</label>
										<div class="ccol-xs-9 input-group col-sm-2">
					                          <form:input  class="form-control" type="text"  path="stopDatexx"  readonly="true"></form:input>
					                          <span class="input-group-addon">
					                             <i class="icon-calendar bigger-110"></i>
					                          </span>
					                    </div>
								</div>			
						   		</div>
						 </div>
				 	</div>
				
        	<div class="bottomBtn">
		   		<div class="h50">&nbsp;</div>
		   		<div class="floatBtn">
		   			<button role="button" class="btn btn-primary" type="submit"><i class="icon-save"></i>单位协议终止</button>
		   			<a  role="button" href="javascript:unitClear()" class="btn btn-primary"><i class="icon-plus"></i>新增</a>
			   		<a  id="btn2" href="javascript:updateUnit()" role="button" class="btn btn-info" ><i class="icon-pencil"></i>修改单位协议</a> 
			   		<a  role="button" href="javascript:del()" class="btn btn-danger"><i class="icon-trash"></i>删除</a>
		   		</div>
		   	</div>
		   
		</div>
	      	 </form:form>  
	        
<script type="text/javascript" src="${ctx}/js/business/personagency/unitagreement/unitAgreementEditzz.js?version=201612021432"></script>
</body>
</html>
