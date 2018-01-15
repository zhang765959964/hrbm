<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>委托类型变更页面</title>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.xunfeng.com/core" prefix="xf"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<script type="text/javascript">
	 $(function(){
		  initFormSubimt();
		  $("#commissionDate").xfdaterangepicker({singleDatePicker:true,
			  autoUpdateInput:false,
			  formValidatorId : "commissionChangeForm",
			  "opens":"right",
			  "drops": "down",
              "locale": {
                  "format": "YYYY-MM-DD"
              }
          });
	 })
	 
     $("#commissionCorpName").on("keyup",function(){
    	 $("#aab001not").val('');
    	 var commissionCorpName = $("#commissionCorpName").val();
 		 $.ajax({
              type: "GET",
              url: "${ctx}/business/personagency/entrust/commissionChange/searchUnitCorp.xf",
              data: {aab004:commissionCorpName, uaStatus:0 },
              dataType: "json",
              success: function(data){
 	            	$('#resText').empty();   //清空resText里面的所有内容
 	            	var table = $('<table class="srtable"> <thead> <tr>'+
 		            			   '<th class="sid">单位名称</th>'+
 		            			   '<th class="sname">营业执照号码</th>'+
 	            			   '</tr> </thead> <tbody></tbody></table>');
 	            			   
 		            	$.each(data, function(commentIndex, comment){
 	                        var tr=$('<tr> <td class="sid" >'+comment['AAB004']+'</td> <td class="sname" >'+ comment['AAB007'] + '</td></tr>');     
 		                    tr.on("click",function(){
 			                	confirmCorp(comment['AAB001'],comment['AAB004']);
 			                })
 			                $(table).find("tbody").append(tr);
 	                    });		   
 					$('#resText').html(table);
 	            	$(".resultUnitCorp").show(); 
              }
          });
     }).on("keypress",function(event){
		if(event.keyCode == "13"){
			event.preventDefault();
        }
	});
	 
	 function confirmCorp(aab001,data){
		 $("#commissionCorpName").val(data);
		 $("#aab001not").val(aab001);
		 $('#resText').empty();
		 $(".resultUnitCorp").hide(); 
		 var bootstrapValidator = $("#commissionChangeForm").data('bootstrapValidator');
		 bootstrapValidator.disableSubmitButtons(false);
	 }
	 
	 $("#commissionType").change(function () {
			 $("#commissionCorpName").val('');
			 $("#aab001not").val('');
			 $('#resText').html('');
	         var str = "";  
	         $("select option:selected").each(function () {  
	               str = $(this).val() + " ";  
	         });  
	         
	         if(str==1||str==3||str==5||str==6||str==8){
	        	 $("#corpNameDiv2").show();
	        	 $("#corpNameDiv1").hide();
	        	 var bootstrapValidator = $("#commissionChangeForm").data('bootstrapValidator');
	        	 bootstrapValidator.disableSubmitButtons(false);
	         }else if(str==2||str==4||str==7||str==9){
	        	 $("#corpNameDiv2").hide();
	        	 $("#corpNameDiv1").show();
	        	 $('#commissionChangeForm').data('bootstrapValidator').updateStatus('commissionCorpName', 'NOT_VALIDATED').validateField('commissionCorpName');
	         }else {
	         }
        	
      })  
      
      
    
	 function submitForm(id){
		 var aab001not = $("#aab001not").val();
		 var name = $("#commissionCorpName").val();
		 var type = $("#commissionType").val();
		 var bootstrapValidator = $("#commissionChangeForm").data('bootstrapValidator');  
		 if(id>0){
			 if(flag){
				 if(type!='' && (name!='' && aab001not=='')){
					 bootbox.alert("请选择下拉框里面的单位");
				     bootstrapValidator.setAllowSubmit(false);
				 }else{
				     bootstrapValidator.setAllowSubmit(true);
				 }
			 }else{
				 bootbox.alert("请先点击新增");
				 return false;
			 }
		 }else{
			 bootbox.alert("请先选择档案数据");
			 return false;
		 }
	  }
</script>
<form:form modelAttribute="commissionChangeForm" method="post" action="${ctx}/business/personagency/entrust/commissionChange/save.xf" onsubmit="return submitForm('${id}')">
<div class="col-sm-7 colRight">
	<div class="moduleWrapNobg">
		<div class="moduleTit">委托类型变更</div>
		<br/>
		<div class="moduleCont resultWrap h335">													
		 		<form:hidden path="id" ></form:hidden>
		 		<form:hidden path="archivesId" ></form:hidden>
		 		<form:hidden path="personId" ></form:hidden>
		 		<form:hidden path="createrId" ></form:hidden>
		 		<form:hidden path="createrOrgId" ></form:hidden>
		 		<form:hidden path="archiveType" ></form:hidden>
		 		<form:hidden path="aab001not" id="aab001not"></form:hidden>
		   			<div class="row">
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更类型"><em>*</em>变更类型:</label>
						<div class="col-xs-9 col-sm-4 required"> 
							<c:if test="${archiveType==1 }">
								<xf:select  tableName="RSDA_TAB_TYPE_CHANGE" valueField="code" textField="name" name="commissionType"  id="commissionType" 
										value='${commissionChangeForm.commissionType}' hasDefault="0" valueCon="1,2,3" selectClass="form-control"></xf:select>
							</c:if>
							<c:if test="${archiveType==2 }">
								<xf:select  tableName="RSDA_TAB_TYPE_CHANGE" valueField="code" textField="name" name="commissionType"  id="commissionType" 
										value='${commissionChangeForm.commissionType}' hasDefault="0" valueCon="4,5" selectClass="form-control"></xf:select>
							</c:if>
							<c:if test="${archiveType==3 }">
								<xf:select  tableName="RSDA_TAB_TYPE_CHANGE" valueField="code" textField="name" name="commissionType"  id="commissionType" 
										value='${commissionChangeForm.commissionType}' hasDefault="0" valueCon="6,7" selectClass="form-control"></xf:select>
							</c:if>
							<c:if test="${archiveType==4 }">
								<xf:select  tableName="RSDA_TAB_TYPE_CHANGE" valueField="code" textField="name" name="commissionType"  id="commissionType" 
										value='${commissionChangeForm.commissionType}' hasDefault="0" valueCon="8,9" selectClass="form-control"></xf:select>
							</c:if>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更日期">变更日期:</label>
						<div class="col-xs-9 input-group col-sm-4">
							<div class="input-group row">
                             	<form:input  class="form-control" type="text"  path="commissionDate"></form:input>
                             	<span class="input-group-addon">
                                 	<i class="icon-calendar bigger-110"></i>
                             	</span>
                             </div>
                        </div>	
                     </div>	     
                     <div class="row">								
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更前档案编号">变更前档案编号:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="archiveCodeBefore" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="变更后档案编号">变更后档案编号:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="archiveCodeAfter" readonly="true"></form:input>
						</div>
					</div>	     
                    <div class="row" id="corpNameDiv1">				 
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="变更委托单位名称"><em>*</em>变更委托单位名称:</label>
								<div class="col-xs-9 col-sm-10 pr required">
									<form:input  class="form-control" type="text" path="commissionCorpName"></form:input>
									<!-- 多条结果 -->
									<div class="resultUnitCorp pa moreResult dnn w80p" id="resText">
									</div>
								</div>
							</div>
						</div>	
					</div>	
					<div class="row dnn" id="corpNameDiv2">				 
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="变更委托单位名称">变更委托单位名称:</label>
								<div class="col-xs-9 col-sm-10">
									<form:input  class="form-control" type="text" path="commissionCorpNameNot" readonly="true"></form:input>
								</div>
							</div>
						</div>	
					</div>     
                    <div class="row">				 
						<div class="col-xs-12 col-sm-12 threeCol">
							<div class="row rowTextarea">
								<label class="col-xs-3 col-sm-2" for="inputError" title="备注">备注:</label>
								<div class="col-xs-9 col-sm-10">
									<form:input  class="form-control" type="text" path="description"></form:input>
								</div>
							</div>
						</div>	
				   </div>	     
                   <div class="row">					 
						<label class="col-xs-3 col-sm-2" for="inputError" title="经办人">经办人:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="createrName" readonly="true"></form:input>
						</div>
						<label class="col-xs-3 col-sm-2" for="inputError" title="经办机构">经办机构:</label>
						<div class="col-xs-9 col-sm-4">
							<form:input  class="form-control" type="text"  path="createrOrgName" readonly="true"></form:input>
						</div>
				  </div>	     
                  <div class="row">			 
						<label class="col-xs-3 col-sm-2" for="inputError" title="经办日期">经办日期:</label>
						<div class="col-xs-9 input-group col-sm-4">
                           	<form:input  class="form-control" type="text"  path="createrDate" readonly="true"></form:input>
                           	<span class="input-group-addon"> <i class="icon-calendar bigger-110"></i></span>
                         </div>									
				  </div>											
		</div>
	</div>
</div>
<div class="bottomBtn">
	<div class="h50">&nbsp;</div>
	<div class="floatBtn">
		<button type="submit" class="btn btn-primary"><i class="icon-save"></i>保存</button>
		<a role="button" class="btn btn-primary" href="javascript:addCommissionChange('${id}','${archiveFlowStatus }')"><i class="icon-plus"></i>新增</a>
		<a href="javascript:printCodeLabel('${id}')" role="button" class="btn btn-success"><i class="icon-barcode"></i>打印条码标签</a>
	</div>
</div>
</form:form>					
</html>