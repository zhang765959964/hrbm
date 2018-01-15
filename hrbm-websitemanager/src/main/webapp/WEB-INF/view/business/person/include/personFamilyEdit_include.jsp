<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
$(function(){
	//根据身份证号自动填充年龄、性别
	  $("#faSpouseCard").bind('change blur', function(e){
		  var faSpouseCard = $("#faSpouseCard").val();
		   if(faSpouseCard){
			   $("#peifaSpouseBirth").val($(this).getBirthday());
			   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('faSpouseBirth','VALID', null).validateField('faSpouseBirth');
		   }else{
			   $("#peifaSpouseBirth").val('');
		   }
		})
})
</script>
<div class="row">
	<label class="col-xs-3 col-sm-1" for="inputError" title="婚姻状况">婚姻状况:</label>
	<div class="col-xs-9 col-sm-3 mhyNoSelect">
		<xf:select textField="name" tableName="TAB_MARRIAGE" name="faMarriage" value="${personBaseInfoForm.faMarriage }"  valueField="code" hasDefault="0"></xf:select>
	</div>	
	<label class="col-xs-3 col-sm-1" for="inputError" title="结婚时间">结婚时间:</label>
	<div class="col-xs-9 input-group col-sm-3" style="float:left">
		<div class="input-group" style="padding: 0 !important;">
			<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" formValidatorId="personBaseInfoForm" path="faMarriageDate" type="text" placeholder="请选择日期" />
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-3 col-sm-1" for="inputError" title="配偶姓名">配偶姓名:</label>
	<div class="col-xs-9 col-sm-3">
		<form:input class="form-control" type="text"  path="faName"  data-options="required:false;"></form:input>
	</div>		
</div>
<div class="row">
	<label class="col-xs-3 col-sm-1" for="inputError" title="配偶身份证号">配偶身份证号:</label>
	<div class="col-xs-9 col-sm-3">
		<form:input class="form-control" type="text"  path="faSpouseCard"  data-options="required:false;"></form:input>
	</div>	
	<label class="col-xs-3 col-sm-1" for="inputError" title="配偶出生日期">配偶出生日期:</label>
	<div class="col-xs-9 input-group col-sm-3" style="float:left">
		<div class="input-group" style="padding: 0 !important;">
			<form:input class="form-control date" format="YYYY-MM-DD" autoUpdateInput="false" formValidatorId="personBaseInfoForm" path="faSpouseBirth" type="text" placeholder="请选择日期" id="peifaSpouseBirth"/>
			<span class="input-group-addon">
				<i class="icon-calendar bigger-110"></i>
			</span>
		</div>
	</div>
	<label class="col-xs-3 col-sm-1" for="inputError" title="配偶民族">配偶民族:</label>
	<div class="col-xs-9 col-sm-3 mhyNoSelect">
		<xf:select textField="name" tableName="TAB_NATION" name="faSpouseNational" value="${personBaseInfoForm.faSpouseNational }"  valueField="code" hasDefault="0"></xf:select>
	</div>			
</div>
<div class="row">
	<label class="col-xs-3 col-sm-1" for="inputError" title="配偶单位">配偶单位:</label>
	<div class="col-xs-9 col-sm-7">
		<form:input class="form-control" type="text"  path="faSpouseCompany"  data-options="required:false;"></form:input>
	</div>	
	<label class="col-xs-3 col-sm-1" for="inputError" title="配偶电话">配偶电话:</label>
	<div class="col-xs-9 col-sm-3 ">
		<form:input class="form-control" type="text"  path="faSpousePhone"  data-options="required:false;"></form:input>
	</div>			
</div>
<div class="row">
	<label class="col-xs-3 col-sm-1" for="inputError" title="计生情况">计生情况:</label>
	<div class="col-xs-9 col-sm-3 mhyNoSelect">
		<xf:select textField="name" tableName="TAB_CONDITION" name="faBirthCondition" value="${personBaseInfoForm.faBirthCondition }"  valueField="code" hasDefault="0"></xf:select>
	</div>	
	<label class="col-xs-3 col-sm-1" for="inputError" title="节育措施">节育措施:</label>
	<div class="col-xs-9 col-sm-3 mhyNoSelect">
		<xf:select textField="name" tableName="TAB_BIRTHCONTROL" name="faBirthControl" value="${personBaseInfoForm.faBirthControl }"  valueField="code" hasDefault="0"></xf:select>
	</div>			
</div>
<div class="row">
	<label class="col-xs-3 col-sm-1" for="inputError" title="家庭情况备注">家庭情况备注:</label>
	<div class="col-xs-9 col-sm-11">
		<form:textarea row="5" col="5" style="width:100%;resize:none;" path="faFamilyBark"></form:textarea>
	</div>		
</div>
<div class="row">
	<label class="col-xs-3 col-sm-1" for="inputError" title="经办日期">经办日期:</label>
	<div class="col-xs-9 col-sm-3">
		<form:input class="form-control" type="text" path="aae036" readonly="true"  data-date-format="dd-mm-yyyy"></form:input>
	</div>	
	<label class="col-xs-3 col-sm-1" for="inputError" title="经办机构">经办机构:</label>
	<div class="col-xs-9 col-sm-3">
		<form:input class="form-control" type="text" path="aae020"  readonly="true" data-options="required:false"></form:input>
	</div>	
	<label class="col-xs-3 col-sm-1" for="inputError" title="经办人">经办人:</label>
	<div class="col-xs-9 col-sm-3">
		<form:input class="form-control" type="text"  path="aae019"  readonly="true" data-options="required:false;readonly:true"></form:input>
	</div>		
</div>
