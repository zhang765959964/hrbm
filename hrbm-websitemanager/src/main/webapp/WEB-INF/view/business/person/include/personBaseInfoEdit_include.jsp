<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
$(function(){
	//根据身份证号自动填充年龄、性别
	  $("#aac002").bind('change blur', function(e){
		  var aac002 = $("#aac002").val();
		   if(aac002){
			   $("#aac006").val($(this).getBirthday());
			   var gender = $(this).getGender();
			   var genderCode =9;
			   gender=="男"?genderCode=1:genderCode=2;  
			   $("#aac004").val(genderCode);
			   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('aac006','VALID', null).validateField('aac006');
			   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('aac004','VALID', null).validateField('aac004');
		   }else{
			   $("#aac006").val('');
			   $("#aac004").val('');
		   }
		})
	  
})
</script>
  		<form:hidden path="aac001" ></form:hidden>					   		
  		<form:hidden path="aae011"></form:hidden>
  		<form:hidden path="aae017"></form:hidden>
  		<form:hidden path="ccmu61"></form:hidden>							   		
		<div class="row">
			<label class="col-xs-3 col-sm-1" for="inputError" title="身份证号码"><i style="color: red;margin-right: 5px;">*</i>身份证号码:</label>
			<div class="col-xs-9 col-sm-3 required">
				<form:input class="form-control" type="text"  path="aac002"  placeholder="必须填写"></form:input>
			</div>
			<label class="col-xs-3 col-sm-1" for="inputError" title="姓名"><i style="color: red;margin-right: 5px;">*</i>姓名:</label>
			<div class="col-xs-9 col-sm-3 required">
				<form:input class="form-control"  type="text" path="aac003" placeholder="必须填写"></form:input>
			</div>
			<label class="col-xs-3 col-sm-1" for="inputError" title="性别"><i style="color: red;margin-right: 5px;">*</i>性别:</label>
			<div class="col-xs-9 col-sm-3 required mhyNoSelect">
				<xf:select textField="name" id="aac004" valueCon="1,2" tableName="TAB_SEX" isNoStyle="true" name="aac004" valueField="code" hasDefault="0" value="${personBaseInfoForm.aac004 }"></xf:select>
			</div>
		</div>
		<div class="row">
			<label class="col-xs-3 col-sm-1" for="inputError" title="个人状态"><i style="color: red;margin-right: 5px;">*</i>个人状态:</label>
			<div class="col-xs-9 col-sm-3 required mhyNoSelect">
			<form:hidden path="expPersonId"></form:hidden>
				<xf:select textField="name"   tableName="TAB_PSTATUS" isNoStyle="true" name="expPersonStatus" valueField="code" hasDefault="0" value="${personBaseInfoForm.expPersonStatus }"></xf:select>
			</div>	
			<label class="col-xs-3 col-sm-1" for="inputError" title="出生日期"><i style="color: red;margin-right: 5px;">*</i>出生日期:</label>
			<div class="col-xs-9 col-sm-3 " style="float:left" >
				<div class="input-group required" style="padding: 0 !important;">
					<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" formValidatorId="personBaseInfoForm" path="aac006" type="text" placeholder="请选择日期"/>
					<span class="input-group-addon">
						<i class="icon-calendar bigger-110"></i>
					</span>
				</div>
			</div>
			<label class="col-xs-3 col-sm-1" for="inputError" title="民族"><i style="color: red;margin-right: 5px;">*</i>民族:</label>
			<div class="col-xs-9 col-sm-3 required mhyNoSelect"> 
				<xf:select textField="name" tableName="TAB_NATION" id="aac005" name="aac005" value="${personBaseInfoForm.aac005 }"  valueField="code" hasDefault="0"></xf:select>
			</div>	
	   </div>
		<div class="row">
	       <label class="col-xs-3 col-sm-1" for="inputError" title="户口性质"><i style="color: red;margin-right: 5px;">*</i>户口性质:</label>
			<div class="col-xs-9 col-sm-3 required mhyNoSelect">
				<xf:select textField="name" tableName="TAB_CATEGORY" name="aac009" value="${personBaseInfoForm.aac009 }" valueField="code" hasDefault="0"></xf:select>
			</div>
			<label class="col-xs-3 col-sm-1" for="inputError" title="户口所在地"><i style="color: red;margin-right: 5px;">*</i>户口所在地:</label>
			<div class="col-xs-9 col-sm-7 required">
				<form:input class="form-control"  id="cityInput" readonly="true" path="bab305"></form:input>
			</div>	
	  </div>
 	  <div class="row">
 			<label class="col-xs-3 col-sm-1" for="inputError" title="手机号"><i style="color: red;margin-right: 5px;">*</i>手机号:</label>
			<div class="col-xs-9 col-sm-3 required">
				<form:input class="form-control" type="text" path="aae005"></form:input>
			</div>
			<label class="col-xs-3 col-sm-1" for="inputError" title="居住所在地"><i style="color: red;margin-right: 5px;">*</i>居住所在地:</label>
				<div class="col-xs-9 col-sm-7 required">
					<form:input class="form-control" type="text" path="aab301"></form:input>
			</div>	
 	 </div>
  	 <div class="row">
  		 <label class="col-xs-3 col-sm-1" for="inputError" title="身份证地址">身份证地址:</label>
		 <div class="col-xs-9 col-sm-3 ">
			<form:input class="form-control" type="text" path="expCardNumber"></form:input>
		</div>
		<label class="col-xs-3 col-sm-1" for="inputError" title="详细地址">详细地址:</label>
		<div class="col-xs-9 col-sm-7">
			<form:input class="form-control" type="text" path="expAddress"></form:input>
		</div>		
   	 </div>
	<div class="row">
		<label class="col-xs-3 col-sm-1" for="inputError" title="联系电话">联系电话:</label>
		<div class="col-xs-9 col-sm-3">
			<form:input class="form-control" type="text" path="expPersonPhone"></form:input>
		</div>	
 			    <label class="col-xs-3 col-sm-1" for="inputError" title="军人证号">军人证号:</label>
		<div class="col-xs-9 col-sm-3 ">
			<form:input class="form-control" type="text" path="aac00a"></form:input>
		</div>
					<label class="col-xs-3 col-sm-1" for="inputError" title="籍贯">籍贯:</label>
		<div class="col-xs-9 col-sm-3">
			<form:input class="form-control" id="cityLive" path="aac025"></form:input>
		</div>
	</div>
  	<div class="row">
		<label class="col-xs-3 col-sm-1" for="inputError" title="政治面貌">政治面貌:</label>
		<div class="col-xs-9 col-sm-3 mhyNoSelect">
			<xf:select textField="name" tableName="TAB_AFFIL" name="aac024"  value="${personBaseInfoForm.aac024 }"  valueField="code" hasDefault="0"></xf:select> 
		</div>
		<label class="col-xs-3 col-sm-1" for="inputError" title="文化程度">文化程度:</label>
		<div class="col-xs-9 col-sm-3 mhyNoSelect">
			<xf:select textField="name" tableName="TAB_EDUCATION" name="aac011" value="${personBaseInfoForm.aac011 }" valueField="code" hasDefault="0"></xf:select>
		</div>
		<label class="col-xs-3 col-sm-1" for="inputError" title="健康状况">健康状况:</label>
		<div class="col-xs-9 col-sm-3 mhyNoSelect">
				<xf:select textField="name" tableName="TAB_HEALTH" name="aac033"  value="${personBaseInfoForm.aac033 }" valueField="code" hasDefault="0"></xf:select>
		</div>		
	</div>
	<div class="row">
		<label class="col-xs-3 col-sm-1" for="inputError" title="毕业学校">毕业学校:</label>
		<div class="col-xs-9 col-sm-3 ">
			<form:input class="form-control" type="text" path="aac180"></form:input>
		</div>
		<label class="col-xs-3 col-sm-1" for="inputError" title="所学专业">所学专业:</label>
		<div class="col-xs-9 col-sm-3 mhyNoSelect">
			<xf:select textField="name" tableName="TAB_PROFESSION" name="acc01g" value="${personBaseInfoForm.acc01g }"  valueField="code" hasDefault="0"></xf:select>
		</div>
		<label class="col-xs-3 col-sm-1" for="inputError" title="毕业时间">毕业时间:</label>
		<div class="col-xs-9 input-group col-sm-3" style="float:left;z-index: 0;">
			<div class="input-group" style="padding: 0 !important;">
				<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" path="aac181" type="text" placeholder="请选择日期" />
				<span class="input-group-addon">
					<i class="icon-calendar bigger-110"></i>
				</span>
			</div>
		</div>	
	</div>
	<div class="row">
  				<label class="col-xs-3 col-sm-1" for="inputError" title="电子信箱">电子信箱:</label>
				<div class="col-xs-9 col-sm-3">
					<form:input class="form-control" type="text" path="aae015"></form:input>
				</div>		
			<label class="col-xs-3 col-sm-1" for="inputError" title="邮  编">邮  编:</label>
				<div class="col-xs-9 col-sm-3">
					<form:input class="form-control" type="text" path="aae007"></form:input>
			</div>
			<label class="col-xs-3 col-sm-1" for="inputError" title="户口登记日期">户口登记日期:</label>
			<div class="col-xs-9 input-group col-sm-3" style="float:left">
				<div class="input-group" style="padding: 0 !important;">
					<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" path="expHourseDate" type="text" placeholder="请选择日期" />
					<span class="input-group-addon">
						<i class="icon-calendar bigger-110"></i>
					</span>
				</div>
			</div>	
<!-- 		<label class="col-xs-3 col-sm-1" for="inputError" title="">婚姻状况:</label> -->
<!-- 		<div class="col-xs-9 col-sm-3 mhyNoSelect"> -->
<%-- 		<xf:select textField="name" tableName="TAB_MARRIAGE" name="aac017" value="${personBaseInfoForm.aac017 }"  valueField="code" hasDefault="0"></xf:select> --%>
<!-- 		</div>	 -->
  	    </div>
   		<div class="row">
   				<label class="col-xs-3 col-sm-1" for="inputError" title="备  注">备  注:</label>
				<div class="col-xs-9 col-sm-11">
					<form:textarea row="5" col="5" style="width:100%;resize:none;" path="aae013"></form:textarea>
				</div>		
   		</div>
			<div class="row">
   				<label class="col-xs-3 col-sm-1" for="inputError" title="原工作单位">原工作单位:</label>
					<div class="col-xs-9 col-sm-3">
						<form:input class="form-control" type="text" path="expOldCompany"></form:input>
					</div>	
   				<label class="col-xs-3 col-sm-1" for="inputError" title="参加工作时间">参加工作时间:</label>
				<div class="col-xs-9 input-group col-sm-3" style="float:left;z-index: 0;">
						<div class="input-group" style="padding: 0 !important;">
							<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" path="expStartJobDate" type="text" placeholder="请选择日期" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
				</div>		
   				<label class="col-xs-3 col-sm-1" for="inputError" title="职务">职务:</label>
					<div class="col-xs-9 col-sm-3">
						<form:input class="form-control" type="text" path="expPost"></form:input>
					</div>		
			</div>
   			<div class="row">
   				<label class="col-xs-3 col-sm-1" for="inputError" title="国家职业资格等级">国家职业资格等级:</label>
					<div class="col-xs-9 col-sm-3 mhyNoSelect">
						<xf:select textField="name" tableName="TAB_COQ" name="expLevel" value="${personBaseInfoForm.expLevel }"  valueField="code" hasDefault="0"></xf:select>
					</div>
				<label class="col-xs-3 col-sm-1" for="inputError" title="取得职业资格等级日期">取得职业资格等级日期:</label>
					<div class="col-xs-9 input-group col-sm-3" style="float:left;z-index: 0;">
						<div class="input-group" style="padding: 0 !important;">
							<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" path="expLevelDate" type="text" placeholder="请选择日期" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
				<label class="col-xs-3 col-sm-1" for="inputError" title="职业（工种）资格名称">职业（工种）资格名称:</label>
					<div class="col-xs-9 col-sm-3 mhyNoSelect"> 
						<xf:select textField="name" tableName="TAB_CRAFT" name="expPositionName" value="${personBaseInfoForm.expPositionName }"  valueField="code" hasDefault="0"></xf:select>
					</div>	
			</div>
   			<div class="row">
   				<label class="col-xs-3 col-sm-1" for="inputError" title="专业技术职务">专业技术职务:</label>
					<div class="col-xs-9 col-sm-3 mhyNoSelect">
						<xf:select textField="name" tableName="TAB_TITLE" name="expTechnical" value="${personBaseInfoForm.expTechnical }"  valueField="code" hasDefault="0"></xf:select>
					</div>	
   				<label class="col-xs-3 col-sm-1" for="inputError" title="取得专技资格日期">取得专技资格日期:</label>
					<div class="col-xs-9 input-group col-sm-3" style="float:left">
						<div class="input-group" style="padding: 0 !important;">
							<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" path="expTechnicalDate" type="text" placeholder="请选择日期" />
							<span class="input-group-addon">
								<i class="icon-calendar bigger-110"></i>
							</span>
						</div>
					</div>
   				<label class="col-xs-3 col-sm-1" for="inputError" title="就业失业登记证号码">就业失业登记证号码:</label>
					<div class="col-xs-9 col-sm-3">
						<form:input class="form-control" type="text" path="acc0m1"></form:input>
					</div>		
			</div>
   			<div class="row">
   				<label class="col-xs-3 col-sm-1" for="inputError" title="是否零就业家庭">是否零就业家庭:</label>
					<div class="col-xs-9 col-sm-3">
						<form:select class="combobox" path="expIsFamily" style="width: 100%;">
						   <form:option value="" label="--请选择--"/>
						   <form:option value="0" label="否"/>
						   <form:option value="1" label="是"/>
					    </form:select>
					</div>	
   				<label class="col-xs-3 col-sm-1" for="inputError" title="是否就业困难人员" >是否就业困难人员:</label>
					<div class="col-xs-9 col-sm-3">
					<form:select class="combobox" path="expIsDifficult" style="width: 100%;">
						   <form:option value="" label="--请选择--"/>
						   <form:option value="0" label="否"/>
						   <form:option value="1" label="是"/>
					    </form:select> 
					</div>	
   				<label class="col-xs-3 col-sm-1" for="inputError" title="就业困难人员类别">就业困难人员类别:</label>
					<div class="col-xs-9 col-sm-3 mhyNoSelect">
						<xf:select textField="name" tableName="TAB_EDO" name="expHardPerson" value="${personBaseInfoForm.expHardPerson }"  valueField="code" hasDefault="0"></xf:select>
					</div>	
			</div>
							   		
