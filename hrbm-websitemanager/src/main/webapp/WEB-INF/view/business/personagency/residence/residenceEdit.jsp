<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 户口材料表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
	<script type="text/javascript" src="${ctx}/js/business/personagency/residence/residenceEdit.js?v=201612230102"></script>
</head>
<body>
	<form:form modelAttribute="residenceForm" method="post" action="${ctx}/business/personagency/residence/residence/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleWrapNobg change-bg-iframe">
				<div class="moduleCont">
					<form:hidden path="id" ></form:hidden>
					<form:hidden path="archivesId" ></form:hidden>
					<form:hidden path="personId"></form:hidden>
					<form:hidden path="createrId"></form:hidden>
					<form:hidden path="createrOrgId" ></form:hidden>
					<form:hidden path="cczy06"></form:hidden>
					<form:hidden path="ccpr08"></form:hidden>
				    <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="申请日期">申请日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
	                         	<form:input  class="form-control" type="text"  path="applicationDate"></form:input>
	                         	<span class="input-group-addon">
	                             	<i class="icon-calendar bigger-110"></i>
	                         	</span>
	                         </div>	
	                     </div>									
						 <label class="col-xs-3 col-sm-label" for="inputError" title="材料类别"><em>*</em>材料类别 :</label>
						 <div class="col-xs-9 col-sm-input required">
							<xf:select  tableName="RSDA_TAB_MATERIAL_CATEGORY" valueField="code" textField="name" name="materialCategory"  
									value='${residenceForm.materialCategory}' hasDefault="0" selectClass="form-control"></xf:select>
						 </div>
						 <label class="col-xs-3 col-sm-label" for="inputError" title="是否退回">是否退回:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text"  path="isBack" >
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						 </div>
					 </div>
					<div class="row">	
						<label class="col-xs-3 col-sm-label" for="inputError" title="材料退回本人日期">材料退回本人日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
	                         	<form:input  class="form-control" type="text"  path="applicationOneselfDate"></form:input>
	                         	<span class="input-group-addon">
	                             	<i class="icon-calendar bigger-110"></i>
	                         	</span>
	                         </div>	
	                    </div>					
						<label class="col-xs-3 col-sm-label" for="inputError" title="是否通知">是否通知:</label>
						<div class="col-xs-9 col-sm-input">
							<form:select  class="form-control" type="text"  path="isNotice" >
								<form:option value="0" label="否"/>否
								<form:option value="1" label="是"/>是
							</form:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="通知日期">通知日期:</label>
						<div class="col-xs-9 input-group col-sm-input">
							<div class="input-group row">
		                       	<form:input  class="form-control" type="text"  path="noticeDate"></form:input>
		                       	<span class="input-group-addon">
		                           	<i class="icon-calendar bigger-110"></i>
		                       	</span>
	                       </div>	
	                    </div>	
	                 </div>	
					 <div class="row">					
						<label class="col-xs-3 col-sm-label" for="inputError" title="提交材料名称">提交材料名称:</label>
						<div class="col-xs-12 col-sm-two-col">
							<form:input  class="form-control" type="text"  path="materialName"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="联系方式">联系方式:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text" path="aae005"></form:input>
						</div>
					</div>	
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="退回原因">退回原因:</label>
						<div class="col-xs-9 col-sm-three-col">
							<form:textarea  type="text"  path="backReason" row="5" col="5" ></form:textarea>
						</div>
					</div>	
					<div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError" title="经办人姓名">经办人姓名:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="经办机构名称">经办机构名称:</label>
						<div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError" title="经办日期">经办日期:</label>
					    <div class="col-xs-9 input-group col-sm-input">
	                       	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
	                       	<span class="input-group-addon">
	                           	<i class="icon-calendar bigger-110"></i>
	                       	</span>
	                    </div>									
				    </div>											
				</div>
			</div>
	</div>
	<div class="h60">&nbsp;</div>
	   	<div class="floatBtn">
	   		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	   		<a href="javascript:void(0)" role="button" class="btn btn-info" onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	   	</div>
	</div>	
</form:form>	
</body>
</html>