<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>编辑 个人基本信息表</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="/commons/include/commonInc.jsp" %>
    <script type="text/javascript" src="${ctx}/js/ui/xf.idcard.js?v=201702010"></script>
	<script type="text/javascript" src="${ctx}/js/ui/xf.seccard.js?v=201609191644"></script>
	<script>
	$(function(){
		$("#personBaseEdit").xfload("${ctx}/business/personagency/person/personBaseInfo/add.xf");
		 $("#personSearch").selectuser({callBack:function(personId){
				if(personId){
					loadPage(personId);
				}else{
					bootbox.alert('未查到记录');
				}
			  }})
			  
		$("#idcard").idcard({callBack:function(personId,idcardObject){						 
			   if(personId){
				   loadPage(personId);
			   }else{
				   var aac002 = idcardObject.aac002;
				   $("#personSearch").val(aac002);
				   var gender = idcardObject.aac004;
				   var genderCode =9;
				   gender=="男"?genderCode=1:genderCode=2;  
				   $("#aac003").val(idcardObject.aac003);
				   $("#aac004").val(genderCode);
				   $("#aac005 ").get(0).options[idcardObject.aac005].selected = true; 
				   $("#aac006").val(idcardObject.aac006);
				   $("#aac002").val(idcardObject.aac002);
				   $("#ccmu61").val(idcardObject.base64img);
				   $("#expCardNumber").val(idcardObject.expCardNumber);
				   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('aac002','VALID', null).validateField('aac002');
				   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('aac003','VALID', null).validateField('aac003');
				   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('aac004','VALID', null).validateField('aac004');
				   $('#personBaseInfoForm').data('bootstrapValidator').updateStatus('aac006','VALID', null).validateField('aac006');
			   }
		   }})
		    $("#seccard").seccard({callBack:function(personId,idcardObject){
		    	if(personId){
					   loadPage(personId);
				   }else{
					   $("#aac003").val(idcardObject.aac003);
					   $("#aac004").val(idcardObject.aac004);
					   $("#aac005").val(idcardObject.aac005);
					   $("#aac006").val(idcardObject.aac006);
					   $("#aac002").val(idcardObject.aac002);
					   $("#expCardNumber").val(idcardObject.expCardNumber);
				   }
		   }})
	})
	   function loadPage(personId){
		$("#personBaseEdit").xfload("${ctx}/business/personagency/person/personBaseInfo/edit.xf?cczy06=${personBaseInfoForm.cczy06}&aac001="+personId);
	}
	</script>
</head>
<body>
	<div class="container-fluid">
	<div class="row">
		 <div class="col-xs-12 pd0 tar" >
			<div class="col-xs-6 col-sm-6">
				<a href="javascript:void(0)" role="button" class="btn"  id="seccard">社保卡已配置</a>
				<a href="javascript:void(0)" role="button" class="btn"  id="idcard">身份证未配置</a>
			</div>
			<div class="col-xs-6 col-sm-6">
				<label class="col-xs-3 col-sm-2" for="inputError">查询:</label>
				<div class="col-xs-6 col-sm-7 pr">
					<input class="form-control"  name="personSearch" id="personSearch" placeholder="请输入身份证号 /姓名" type="text"/>
					<!-- 多条结果 -->
				</div>				
			</div>
		</div>
	</div>
	<div id="personBaseEdit"></div>
</div>
</body>
</html>