<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>编辑 档案借阅记录表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
    <%@include file="/commons/include/commonInc.jsp" %>
    <script type="text/javascript" src="${ctx}/js/business/personagency/archive/archiveCheckoutEdit.js?verson=2017121702012006005"></script>
	<script type="text/javascript">
		$(function(){
			$("select.filter").multipleSelect({
		      	selectAll: false,
		      	filter: true,
		      	single: true,
		      	maxHeight:100
		      });
			 $('#msCheckoutMortgage').multipleSelect({
		          width: '100%',
		          placeholder: '--请选择--',
		          ellipsis:true,
		          selectAll: false,
		          onClick: function () {
		              var selectsLength = $('#msCheckoutMortgage').multipleSelect("getSelects").length;
		              var sv = $('#msCheckoutMortgage').multipleSelect("getSelects");
		              $('#checkoutMortgage').val(sv);
		              //超过3个不可选
		              if(selectsLength >=3){
		                 
		              }else{
		                  $(".ms-drop ul li label").removeClass('disabled')
		                  $(".ms-drop ul li label").children("input[type='checkbox']").removeProp('disabled');
		              }
		              return false;
		          }
		      });
		})
	</script>
</head>
<body>
<form:form modelAttribute="archiveCheckoutForm" method="post" action="${ctx}/business/personagency/archive/archiveCheckout/save.xf">
	<div class="container-fluid">
		<div class="row pd-none-wrap">
			<div class="moduleCont">
				  <form:hidden path="id" ></form:hidden>
				  <form:hidden path="archiveId" ></form:hidden>
				  <form:hidden path="checkoutRegisterId" ></form:hidden>
				  <form:hidden path="checkoutRegisterOrgId" ></form:hidden>
				  <div class="row">
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>借阅类别:</label>
						 <div class="col-xs-9 col-sm-input required">
							<xf:select textField="name" tableName="RSDA_TAB_CHECKOUTTYPE"  name="checkoutType" value="${archiveCheckoutForm.checkoutType }"  
									valueField="code" hasDefault="0" selectClass="form-control"></xf:select>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>暂扣材料:</label>
						<div class="col-xs-9 col-sm-input required">
							<%--<xf:select textField="name" tableName="rsda_tab_SEIZUREMATERIAL"  name="seizureMaterial" value="${archiveCheckoutForm.seizureMaterial }" 
								valueField="code" hasDefault="0" selectClass="form-control"></xf:select> --%>
							<select class="form-control" id="msCheckoutMortgage" multiple="multiple" name="msCheckoutMortgage">
								<xf:select isOnlyOptions="true" name="checkoutMortgage_value"
											textField="name" tableName="rsda_tab_SEIZUREMATERIAL"
											valueField="code" isNoStyle="true" 
											hasDefaultName="全部" selectClass="form-control"></xf:select>
							</select>
							<form:hidden path="checkoutMortgage"></form:hidden>
						</div>
						<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>借阅人:</label>
						<div class="col-xs-9 col-sm-input required">
							<form:input  class="form-control" type="text"  path="checkoutPerson"></form:input>
						</div>
				</div>
				<script>
				$(function(){
					$("#msCheckoutMortgage").siblings(".ms-parent").find("button>span").attr("name","msCheckoutMortgage11");
				})
				</script>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">借阅日期:</label>
					<div class="col-xs-9 input-group col-sm-input">
						<div class="input-group row">
			             	<form:input  class="form-control" type="text"  path="checkoutDate"></form:input>
			             	<span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
		             	</div>
		            </div>
					<label class="col-xs-3 col-sm-label" for="inputError">借阅期限日期:</label>
					<div class="col-xs-9 input-group col-sm-input">
						<div class="input-group row">
				              <form:input  class="form-control" type="text"  path="checkoutPeriodDate"></form:input>
				              <span class="input-group-addon"><i class="icon-calendar bigger-110"></i></span>
			            </div>
		            </div>
					<label class="col-xs-3 col-sm-label" for="inputError"><em>*</em>借阅人电话:</label>
					<div class="col-xs-9 col-sm-input required">
						<form:input  class="form-control" type="text"  path="checkoutPersonPhone"></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">借阅单位:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="checkoutCorp" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">借阅内容:</label>
					<div class="col-xs-9 col-sm-two-col">
						<form:input  class="form-control" type="text"  path="checkoutContent" ></form:input>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">借阅原因:</label>
					<div class="col-xs-9 col-sm-two-col">
						<form:input  class="form-control" type="text"  path="checkoutReason" ></form:input>
					</div>
					<label class="col-xs-3 col-sm-label" for="inputError">借阅状态:</label>
					<div class="col-xs-9 col-sm-input">
						<xf:select textField="name" tableName="RSDA_TAB_CHECKOUTSTATUS"  name="checkoutStatus" value="${archiveCheckoutForm.checkoutStatus }"
								valueField="code" selectClass="form-control" valueCon="1"></xf:select>
					</div>
				</div>
				<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError" title="备注">备注:</label>
					<div class="col-xs-9 col-sm-three-col">
						<form:textarea  type="text"  path="checkoutDesc" row="5" col="5"></form:textarea>
					</div>
				</div>
           		<hr/>
           		<div class="row">
					<label class="col-xs-3 col-sm-label" for="inputError">经办日期:</label>
					<div class="col-xs-9 input-group col-sm-input">
		              	<form:input  class="form-control" type="text"  path="checkoutRegisterDate" readonly="true"></form:input>
		            </div>
					<label class="col-xs-3 col-sm-label" for="inputError">经办机构:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="checkoutRegisterOrgName" readonly="true"></form:input>
				    </div>
					<label class="col-xs-3 col-sm-label" for="inputError">经办人姓名:</label>
					<div class="col-xs-9 col-sm-input">
						<form:input  class="form-control" type="text"  path="checkoutRegisterName" readonly="true"></form:input>
					</div>
				</div>
		</div>
	</div>
	    <div class="bottomBtn">
	        <div class="h50">&nbsp;</div>
	        <div class="floatBtn">
	          <button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
	          <a href="javascript:void(0)" role="button" class="btn btn-info"  onclick="closeItem()"><i class="icon-remove"></i>关闭</a>
	        </div>
	    </div>
	</div> 
</form:form>
</body>
</html>