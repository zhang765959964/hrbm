<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>存档信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
		<div class="moduleTit">存档信息</div>
		<div class="moduleCont">
			<form:form modelAttribute="storageArchivesPersonForm" method="post" action="">
				<div class="row">
					<label class="col-xs-3 col-sm-2" for="inputError">身份证号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aac002" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aac003" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案姓名">档案姓名:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案编号">档案编号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveCode" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="genderName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="nationName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control" type="text"  path="aac006" readonly="true"></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError">档案出生日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control" type="text"  path="archiveBirthDate" readonly="true"></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">档案状态:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveStatusName" readonly="true"></form:input>
					</div>
                       <label class="col-xs-3 col-sm-2" for="inputError" title="联系电话">联系电话:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expPersonPhone" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="手机号">手机号:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="aae005" readonly="true"></form:input>
					</div>
                       <label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">存档类型:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveTypeName" readonly="true"></form:input>
					</div>
                       <label class="col-xs-3 col-sm-2" for="inputError">档案转入日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control" type="text"  path="receiveDate" readonly="true"></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError">退休参考日期:</label>
					<div class="col-xs-9 input-group col-sm-2">
                         	<form:input  class="form-control" type="text"  path="planRetiredDate" readonly="true"></form:input>
                         	<span class="input-group-addon">
                             	<i class="icon-calendar bigger-110"></i>
                         	</span>
                       </div>
                       <label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">委托单位名称:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="expEntrustCompany" readonly="true"></form:input>
					</div>
                       <div class="col-xs-12 col-sm-8 mgb0">
						<div class="row mgb0">
							<label class="col-xs-3 col-sm-3" for="inputError" title="现居住地址">现居住地址:</label>
							<div class="col-xs-12 col-sm-9">
								<form:input  class="form-control" type="text"  path="aab301" readonly="true"></form:input>
							</div>
						</div>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="档案状态">市场位置:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="marketPositionName" readonly="true"></form:input>
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
                       <label class="col-xs-3 col-sm-2" for="inputError" title="档案来源">档案来源:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveSource" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-2" for="inputError" title="接收状态">接收状态:</label>
					<div class="col-xs-9 col-sm-2">
						<form:input  class="form-control" type="text"  path="archiveReceiveStatusName" readonly="true"></form:input>
					</div>
					<div class="col-xs-12 col-sm-12 threeCol">
						<div class="row rowTextarea">
							<label class="col-xs-3 col-sm-2" for="inputError" title="档案存放位置备注">档案存放位置备注:</label>
							<div class="col-xs-9 col-sm-10">
								<form:textarea  type="text"  path="archiveReceiveDesc" row="2" col="5" readonly="true"></form:textarea>
							</div>
						</div>
					</div>
				</div>
			</form:form>
		</div>
</html>	