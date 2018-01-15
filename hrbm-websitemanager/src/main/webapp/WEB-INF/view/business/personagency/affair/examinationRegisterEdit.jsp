<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 考试报名登记表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <script type="text/javascript" src="${ctx}/js/business/personagency/affair/examinationRegisterEdit.js"></script>
    <script type="text/javascript">
	    $(function(){
			 selType();
			 setLeval();
		 })
	  
		 function selType(){
			$("#examinationType").change(function (){
				var ty = $("#examinationType").children('option:selected').val();
				$.ajax({
			        type: "post",
			        url: "${ctx }/business/personagency/affair/examinationRegister/getExamByPid.xf",
			        data: {pid:ty},
			        dataType: "json",
			        success: function(data){
			        	$("#examinationOneDiv").hide();  
			        	$("#examinationOneDiv").html("");
			        	$("#examinationTwoDiv").show();
			        	$("#examinationMxTypeTwo").empty();
			        	var option = "<option value='' label='--请选择' />";
			        	for(var i = 0;i < data.length; i++ ){ 
			                option += "<option value=\"" +data[i].CODE+" \" label=\" "+data[i].NAME+"\" />";
			            } 
			        	$("#examinationMxTypeTwo").append(option);
			        }
			    });
			});
		} 
	    function setLeval(){
		    $("#examinationType").change(function (){
				var ty = $("#examinationType").children('option:selected').val();
				$.ajax({
			        type: "post",
			        url: "${ctx }/business/personagency/affair/examinationRegister/getLevelByPid.xf",
			        data: {pid:ty},
			        dataType: "json",
			        success: function(data){
			        	$("#examinationLevelOneDiv").hide();  
			        	$("#examinationLevelOneDiv").html("");
			        	$("#examinationLevelTwoDiv").show();
			        	$("#examinationLevelTwo").empty();
			        	var option = "<option value='' label='--请选择' />";
			        	for(var i = 0;i < data.length; i++ ){ 
			                option += "<option value=\"" +data[i].CODE+" \" label=\" "+data[i].NAME+"\" />";
			            } 
			        	$("#examinationLevelTwo").append(option);
			        }
			    });
			});
	    } 
    </script>
</head>
<body>
<form:form modelAttribute="examinationRegisterForm" method="post" action="${ctx}/business/personagency/affair/examinationRegister/save.xf">
	<div class="container-fluid pd-none-wrap">
		<div class="moduleCont change-bg-iframe">
			 	<form:hidden path="id" ></form:hidden>
			 	<form:hidden path="archivesId" ></form:hidden>
				<form:hidden path="personId" ></form:hidden>
				<form:hidden path="cczy06" ></form:hidden>
				<form:hidden path="ccpr08" ></form:hidden>
				<form:hidden path="createrId" ></form:hidden>
			 	<form:hidden path="createrOrgId" ></form:hidden>
			    <div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">工作单位:</label>
					<div class="col-xs-9 col-sm-two-col">
						<form:input  class="form-control" type="text"  path="workUnit" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">联系电话:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="contactNumber" ></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">工作年龄:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="workingAge" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">考试类别:</label>
					<div class="col-xs-9 col-sm-input">
						<xf:select  tableName="RSDA_TAB_EXAMINATION_TYPE" valueField="code" textField="name" name="examinationType" id="examinationType"
							 value='${examinationRegisterForm.examinationType}' hasDefault="0" valueCon="1,2,3,4" selectClass="form-control"></xf:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">考试明细:</label>
					<div class="col-xs-9 col-sm-input" id="examinationOneDiv">
						<xf:select  tableName="RSDA_TAB_EXAMINATION_TYPE" valueField="code" textField="name" name="examinationMxType" id="examinationMxType"
							value='${examinationRegisterForm.examinationMxType}' hasDefault="0" pidName="pid" pidValue="1,2,3,4" selectClass="form-control"></xf:select>
					</div>
					<div class="col-xs-9 col-sm-input" id="examinationTwoDiv" style="display: none">
						<form:select  class="form-control" type="text" path="examinationMxType" id="examinationMxTypeTwo">
							
						</form:select>
					</div>	
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">考试级别:</label>
					<div class="col-xs-9 col-sm-input" id="examinationLevelOneDiv">
						<xf:select  tableName="rsda_tab_level" valueField="code" textField="name" name="examinationLevel"  id="examinationLevel"
								value='${examinationRegisterForm.examinationLevel}' hasDefault="0" selectClass="form-control"></xf:select>
					</div>
					<div class="col-xs-9 col-sm-input" id="examinationLevelTwoDiv" style="display: none">
						<form:select  class="form-control" type="text" path="examinationLevel" id="examinationLevelTwo">
						</form:select>
					</div>	
					<label class="col-xs-3 col-sm-label" for="inputError">考试成绩:</label>
					<div class="col-xs-9 col-sm-two-col">
						<form:input  class="form-control" type="text"  path="examinationChengji" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">评定结果:</label>
					<div class="col-xs-9 col-sm-input">
						<form:select  class="form-control" type="text"  path="evaluationResult">
							<form:option value="" label="请选择"/>请选择
							<form:option value="0" label="成功"/>成功
							<form:option value="1" label="失败"/>失败
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">是否领取成绩单:</label>
					<div class="col-xs-9 col-sm-input">
						<form:select  class="form-control" type="text"  path="isLingExamination" >
							<form:option value="" label="请选择"/>请选择
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">是否领取证书:</label>
					<div class="col-xs-9 col-sm-input">
						<form:select  class="form-control" type="text"  path="isLingZhengshu">
							<form:option value="" label="请选择"/>请选择
							<form:option value="0" label="否"/>否
							<form:option value="1" label="是"/>是
						</form:select>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">经办人姓名:</label>
						 <div class="col-xs-9 col-sm-input">
							<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
						</div>
					<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
					<div class="col-xs-9 input-group col-sm-input">
                     	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
                     	<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
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