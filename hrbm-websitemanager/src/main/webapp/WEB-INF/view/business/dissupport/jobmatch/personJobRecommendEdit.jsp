<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>职业介绍推荐信</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<style type="text/css">
.letterBody {
	font-size: 16px;
	font-family: 微软雅黑;
	/*max-width: 600px;*/
	margin: 0px auto;
	border: 1px solid #bcbcbc;
	line-height: 25px;
	color: #323232;
	margin: 20px;
}

.letterTop, .letterConter {
	border-bottom: 1px dashed #bcbcbc;
	padding: 5px;
	padding-bottom: 10px;
}
.letterMinFont{
	font-size:12px;
}
.letterBody h3{margin-top:10px !important;}
.letterBody h3, .letterBody h4, .letterBottom h6 {
	text-align: center;
}

.letterTopMain {
	
}

.letterTopMain>div {
	letter-spacing: 1.5px;
	text-indent: 20px;
	margin-bottom: 5px;
}

.letterInput {
	border: 0 !important;
	border-bottom: 1px solid #bcbcbc !important;
	padding-left: 5px;
	text-align: center;
}
.letterInput1{
	font-weight: 600;
}
.letterTopMain>p, .letterCTheme>p {
	text-indent: 20px;
	margin: 0px;
	color: #555555;
}

.letterCTheme>p {
	color: #323232;
}

.letterCTheme {
	text-align: right;
	padding-right: 100px;
}

.letterBottom table {
	width: 95%;
	margin-bottom: 10px;
}

.letterBottom table td {
	text-align: right;
	white-space: nowrap;
	padding-left: 5px;
}

.letterBottom table input {
	width: 100%;
}

.letterTop img {
	width: 25px;
	float: left;
	margin-left: 20px;
}
.letterMsg{
	font-weight: 100;text-align:center;padding-left:100px;
}
</style>
<script type="text/javascript">
	$(function() {
		initFormSubimt();
		$("#ace014").xfdaterangepicker({
			singleDatePicker : true,
			"opens" : "right",
			"drops" : "up",
			"locale" : {
				"format" : "YYYY-MM-DD"
			}
		});
	});
	var accId = "";
	function initFormSubimt() {
		getParentRowDetail();
		$('#personJobRecommendForm')
				.bootstrapValidator(
						{
							message : 'This value is not valid',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								//联系人
								aae004 : {
									validators : {
										stringLength : {
											min : 0,
											max : 50
										}
									}
								},
								aae005 : {
									validators : {
										regexp : {
											regexp : /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
											message : '联系电话格式不正确'
										}
									}
								},
								aab390 : {
									validators : {
										regexp : {
											regexp : /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
											message : '推荐机构电话格式不正确'
										}
									}
								},
								aae139 : {
									validators : {
										regexp : {
											regexp : /^1[3|5|7|8|6|9][0-9]\d{4,8}$/,
											message : '联系手机格式不正确'
										}
									}
								},
								// 				ace139
								ace139 : {
									validators : {
										regexp : {
											regexp : /^1[3|5|7|8|6|9][0-9]\d{4,8}$/,
											message : '联系手机格式不正确'
										}
									}
								}
							}
						})
				.on(
						'success.form.bv',
						function(e) {
							e.preventDefault();
							var $form = $(e.target);
							var bv = $form.data('bootstrapValidator');
							$("#save_butprint").attr("disabled",true);
							$("#save_but").attr("disabled",true);
							//设置只读
						    $("#aae004").attr("readonly",true);
						    $("#aae005").attr("readonly",true);
						    $("#aae139").attr("readonly",true);
						    $("#ace139").attr("readonly",true);
						    $("#ace006").attr("readonly",true);
						    $("#aab390").attr("readonly",true);
						    $("#aae013").attr("readonly",true);
						    $("#acb20c").attr("readonly",true);
							$.post(
											$form.attr('action'),
											$form.serialize(),
											function(data) {
											// $("#save_butprint").attr("disabled",true);
											// $("#save_but").attr("disabled",true);
											accId = data.accId;
											//设置打印职介号
											$("#accId_print1").html("市职介字["+accId+"]号");
											$("#accId_print2").html("市职介字["+accId+"]号");
											$("#accId_print3").html("市职介字["+accId+"]号");
											$("#print_id").removeAttr("disabled");
											isSave=true;
												bootbox
														.alert({
															size : 'small',
															width : "100px",
															message : data.message,
															callback : function() {

																var parentIframe = xfui
																		.getParentIframe();
																if (parentIframe) {
																	parentIframe
																			.refresh();
																}
																if (savePrintFlag) {
																	savePrintFlag = false;
																	printBody();
																} else {
// 																	closeItem();
																}
															}
														})

											}, 'json');

						});
	}
	function closeItem() {
		xfui.closeDialog();
	}
	var savePrintFlag = false;
	function savePrint() {
		savePrintFlag = true;
		submitForm();
	}
	function submitForm() {
		if ($("#checkmessage").is(':checked')) {
			$("#message_value").val("1");
		} else {
			$("#message_value").val("");
		}
		$('#personJobRecommendForm').submit();
	}
	function getParentRowDetail() {
// 		var parentIframe = xfui.getParentIframe();
// 		var row = parentIframe.getCheckRowDetail();
		// 		alert(JSON.stringify(row));
// 		$("#acb200").val(row.ACB200);
// 		$("#aab004").val(row.AAB004);
// 		$("#aae006").val(row.AAE006);
// 		$("#aab001").val(row.AAB001);
// 		if (row.AAD004 == '男性') {
// 			$("#aac004").val('1');
// 		} else if (row.AAD004 == '女性') {
// 			$("#aac004").val('2');
// 		} else {
// 			$("#aac004").val('9');
// 		}
// 		$("#acc034").val(row.ACC034N);
// 		$("#acc214").val(row.ACC214N);
// 		$("#aae004").val(row.AAE004);
// 		$("#aae005").val(row.AAE005);
// 		$("#aae139").val(row.AAE139);

// 		$("#acb210").val(row.ACB210);
// 		$("#aca112").val(row.ACA112);
// 		$("#aca111").val(row.ACA111);
// 		$("#acb202").val(row.ACB202);
// 		$("#bcb202").val(row.BCB202);
		$("#bcb202").attr("title", $("#bcb202").val());

// 		$("#cca111").val(row.CCA111);
// 		$("#bca112").val(row.BCA112);
		$("#bca112").attr("title", $("#bca112").val());
// 		$("#cca112").val(row.CCA112);
		$("#cca114").attr("title", $("#cca114").val());
// 		$("#cca114").val(row.CCA114);
// 		$("#aae030").val(row.AAE030);
// 		$("#aae031").val(row.AAE031);

// 		$("#acb20c").val(row.ACB20C);
		// aae011,aae017,aae022,aae019,aae020,aae036
// 		$("#aaeb11").val(row.AAE011);
// 		$("#aaeb17").val(row.AAE017);
// 		$("#aaeb22").val(row.AAE022);
// 		$("#aaeb19").val(row.AAE019);
// 		$("#aaeb20").val(row.AAE020);
// 		$("#aaeb36").val(row.AAE036);
		//个人信息
// 		var data = parentIframe.getPersonData();
// 		$("#aac002").val(data.AAC002);
// 		$("#aac003").val(data.AAC003);
// 		$("#ace139").val(data.AAE005);
// 		$("#ace006").val(data.AAB301);
		//个人经办信息相关
// 		$("#aaec22").val(data.AAE022);
// 		$("#aaec11").val(data.AAE011);
// 		$("#aaec17").val(data.AAE017);
// 		$("#aaec36").val(data.AAE036);
// 		$("#aaec19").val(data.AAE019);
// 		$("#aaec20").val(data.AAE020);
		//求职信息
// 		var matchdata = parentIframe.getPersonMatchData();
// 		$("#aac001").val(matchdata.aac001);
		//求职登记号
// 		$("#acc200").val(matchdata.acc200);
		//户口性质
// 		$("#aac009").val(matchdata.aac009n);
		//文化程度
// 		$("#aac011").val(matchdata.aac011n);
// 		$("#acc20t").val(matchdata.acc20t);
		//设置打印数据 
		$("#aac003_print").html($("#aac003").val()+"("+$("#aac002").val()+")");
		$("#aac003_print2").html($("#aac003").val()+"("+$("#aac002").val()+")");
		$("#bca112_print").html($("#bca112").val());
		$("#bca112_print2").html($("#bca112").val());
		$("#aac002_print").attr('value', $("#aac002").val());
		$("#aac003_print3").attr('value',$("#aac003").val());
		var aac004_val = $("#aac004").val();
		if(aac004_val=='1'){
			$("#aad004_print").attr('value', '男');
		}else if(aac004_val=='2'){
			$("#aad004_print").attr('value', '女');
		}
		$("#aac011_print").attr('value','${aac011_print}');
		$("#acc20tname_print").attr('value', '${acc20tname_print}');
		$("#aab004_print").attr('value', $("#aab004").val());
		$("#aab004_print2").html($("#aab004").val());
	}
</script>
<style type="text/css">
.bgBr {
	background: #f4f9ff;
	color: #317ecc;
	border: 1px solid #d4e9ff;
	padding: 5px 15px;
	margin: 5px 1px;
	height: 36px;
	text-align: left;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">推荐信息</div>
				<div class="moduleCont">
					<form:form modelAttribute="personJobRecommendForm" method="post"
						action="${ctx}/business/dissupport/jobmatch/personJobRecommend/save.xf">
						<form:hidden path="acc220"></form:hidden>
						<!-- 性别 -->
						<form:hidden path="aac004"></form:hidden>
						<!--  福利待遇 -->
						<form:hidden class="form-control" path="acc214"></form:hidden>
						<!--月工资 -->
						<form:hidden class="form-control" path="acc034"></form:hidden>
						<!-- 个人求职户口性质 -->
						<form:hidden class="form-control" path="aac009"></form:hidden>
						<!-- 文化程度代码 -->
						<form:hidden class="form-control" path="aac011"></form:hidden>
						<!--  人员类别 -->
						<form:hidden class="form-control" path="acc20t"></form:hidden>
						<div class="row bgBr ">招聘信息</div>
						<div class="row">
							<form:hidden class="form-control" path="aab001"></form:hidden>
							<label class="col-xs-3 col-sm-2" for="inputError">招聘登记号:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input class="form-control" readonly="true" type="text"
									path="acb200"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input class="form-control" readonly="true" type="text"
									path="aab004"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">单位地址:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="aae006"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">联系人:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" maxlength="20"
									path="aae004"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">联系电话:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" maxlength="20"
									path="aae005"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">联系手机号(短信):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" maxlength="20"
									path="aae139"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">岗位编号:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="acb210"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">工种名称:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:hidden class="form-control" path="aca111"></form:hidden>
								<form:input readonly="true" class="form-control" type="text"
									path="aca112"></form:input>
							</div>
							<form:hidden class="form-control" path="acb202"></form:hidden>
							<label class="col-xs-3 col-sm-2" for="inputError">工作地点:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="bcb202"></form:input>
							</div>
						</div>
						<div class="row">
							<form:hidden class="form-control" path="cca111"></form:hidden>
							<label class="col-xs-3 col-sm-2" for="inputError">工种描述:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="cca112"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">工种说明:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="bca112"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">岗位描述:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="cca114"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">招聘起始日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input readonly="true" class="form-control" type="text"
									path="aae030"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">招聘终止日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input readonly="true" class="form-control" type="text"
									path="aae031"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">面试地点:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" maxlength="200"
									path="acb20c"></form:input>
							</div>
						</div>

						<div class="row">
							<form:hidden path="aaeb11"></form:hidden>
							<form:hidden path="aaeb17"></form:hidden>
							<form:hidden path="aaeb22"></form:hidden>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="aaeb19"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="aaeb20"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input readonly="true" class="form-control" type="text"
									path="aaeb36"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
						</div>
						<div class="row bgBr ">求职信息</div>
						<div class="row">
							<form:hidden class="form-control" path="aac001"></form:hidden>
							<label class="col-xs-3 col-sm-2" for="inputError">求职登记号:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="acc200"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">身份证号码:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="aac002"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">姓名:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="aac003"></form:input>
							</div>
						</div>

						<div class="row">
							<label style="display: none;" class="col-xs-3 col-sm-2"
								for="inputError">联系电话:</label>
							<div style="display: none;" class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ace005"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">联系手机:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" maxlength="20"
									path="ace139"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">联系地址:</label>
							<div class="col-xs-9 col-sm-6 required">
								<form:input class="form-control" maxlength="70" type="text"
									path="ace006"></form:input>
							</div>
						</div>
						<div class="row">
							<!--    经办机构行政区划 -->
							<form:hidden class="form-control" path="aaec22"></form:hidden>
							<form:hidden class="form-control" path="aaec11"></form:hidden>
							<form:hidden class="form-control" path="aaec17"></form:hidden>

							<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" readonly="true" type="text"
									path="aaec36"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input class="form-control" readonly="true" type="text"
									path="aaec19"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input class="form-control" readonly="true" type="text"
									path="aaec20"></form:input>
							</div>
						</div>
						<div class="row bgBr ">推荐信息</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">推荐有效期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="ace014"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">推荐机构电话:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" maxlength="20" type="text"
									path="aab390"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">备注:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" maxlength="70"
									path="aae013"></form:input>
							</div>
						</div>
						<div class="row">
							<!--  经办人代码 -->
							<form:hidden class="form-control" path="aae011"></form:hidden>
							<!--  经办机构代码 -->
							<form:hidden class="form-control" path="aae017"></form:hidden>
							<!-- 机构行政区划 -->
							<form:hidden class="form-control" path="aae022"></form:hidden>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input readonly="true" class="form-control" type="text"
									path="aae036"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="aae019"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2 ">
								<form:input readonly="true" class="form-control" type="text"
									path="aae020"></form:input>
							</div>
						</div>
						<div class="row" style="display: none;">
							<label class="col-xs-3 col-sm-2" for="inputError">介绍信编号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acc221"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">大会编号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acb330"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">大会招聘编号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acb350"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">招聘方式:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acb201"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">组织机构代码:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aab003"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">行业类型:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aab022"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">单位类型:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aab019"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经济类型:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aab020"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">出生日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="aac006"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">年龄:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bac006"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">职业资格等级:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aac015"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">工种2代码:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bca111"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">到岗日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="acc22c"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否签订劳动合同:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acc22b"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">合同期限:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acb214"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">报酬福利要求:</label>
							<div class="col-xs-9 col-sm-2 required"></div>
							<label class="col-xs-3 col-sm-2" for="inputError">推荐状态详见TAB_RECTYPE:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acc223"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">数据来源:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bcc229"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">数据分类:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bcb207"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">推荐失败原因详见TAB_RECFR:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acc22e"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">反馈机构经办意见:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aaea13"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">反馈机构经办人代码:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aaea11"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">反馈机构代码:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aaea17"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">反馈机构经办日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="aaea36"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">反馈机构经办人:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aaea19"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">反馈机构经办名称:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aaea20"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">反馈经办机构行政区划:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aaea22"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">是否转就业:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acc22h"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">转就业日期:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="acc22k"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否转输出:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acc22i"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">转输出时间:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="acc201"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">是否转补贴:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acc22m"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">转补贴时间:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="acc22n"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">证件号码:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aab007"></form:input>
							</div>


							<label class="col-xs-3 col-sm-2" for="inputError">工种备注:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="cca113"></form:input>
							</div>



							<label class="col-xs-3 col-sm-2" for="inputError">最后修改时间:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="ccpr05"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">修改人:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ccpr06"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">修改来源:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ccpr07"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">是否删除状态（0-否1-是）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ccpr08"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">推荐方式详见TAB_RECDATA:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ccpr09"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">是否查看（0-未查看1-已查看）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ccpr10"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">反馈数据来源（1-网站2-客户端3-民营职介4-公办职介）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ccpr11"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">设备编号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div001"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">是否发送邀请面试[0:未邀请
								1:已邀请]:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="ccps01"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">面试评语编号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acp001"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">面试评语内容:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acp002"></form:input>
							</div>

						</div>
						<input type="hidden" name="ismessage" id="message_value" />
					</form:form>
				</div>
			</div>
		</div>
		<div class="h60">&nbsp;</div>
		<div class="floatBtn">
			<input type="checkbox" id="checkmessage" /> 发送短信&nbsp;&nbsp;&nbsp; <button
				href="javascript:void(0)" role="button" class="btn btn-primary"
				onclick="submitForm()" id="save_but"> <i class="icon-save"></i> 保存
			</button> <button href="javascript:void(0)" id="print_id" disabled="disabled" title="保存后才能打印" role="button" class="btn btn-primary"
				onclick="javascrīpt:printBody()"  ><i class="icon-print"></i>打印介绍信</button>
			<button href="javascript:void(0)" role="button" class="btn btn-primary"
				onclick="savePrint()" id="save_butprint"><i class="icon-print"></i>保存并打印</button>
			<button class="btn btn-info mhyBtnLeft" data-dismiss="modal"
				type="button" onclick="closeItem()">
				<i class="icon-remove"></i> 关闭
			</button>
		</div>
	</div>
	<div id="printdiv"  style="display: none;">
		<div class="letterBody">
			<div class="letterTop">

				<h3>
					<img alt="" src="${ctx}/styles/login/images/logo1.png">职业介绍推荐信
				</h3>
				<h6 class="letterMsg" id="accId_print1"></h6>
				<div class="letterTopMain">
				<div><span id="aab004_print2"></span>:</div>
					<div>
						兹推荐<span id="aac003_print" class="letterInput letterInput1"></span> 同志前往您单位应聘<span
							id="bca112_print" class="letterInput letterInput1"></span>
						职位，请将洽谈结果写入《回执》由应聘者返回我单位。
					</div>
					<p class="letterMinFont">
						乘车路线：<span>${ccmu04_print}</span>
					</p>
					<p class="letterMinFont">
						中心地址：<span>${aab201_print}</span>
					</p>
					<p class="letterMinFont">
						联系人：<span>${aae004_print}</span>
					</p>
					<p class="letterMinFont">
						联系电话：<span id="aab390_print">${aab390_print}</span>
					</p>
				 <div class="letterCTheme" style="padding:0">
					<span class="letterMinFont" style="margin-right:150px;">${orgName}</span>
					<span class="letterMinFont">${currDate}</span>
				</div>
				</div>

			</div>

			<div class="letterConter">
				<h3>回 执</h3>
				<h6 class="letterMsg" id="accId_print2"></h6>
				 
				<div class="letterTopMain">
					<div>${orgName}:</div>
					<div>
						经与<span class="letterInput letterInput1" id="aac003_print2"></span> 同志面谈： <br />1.同意招用。<br />
						2.由于<input type="text" class="letterInput letterInput1" /> 原因，未达成协议，请另行安排。<br />

						其它：
					</div>
					<p class="letterMinFont">
						单位地址：<span id="aae006_print"></span>
					</p>
					<p class="letterMinFont">
						联系人：<span id="aae004_print"></span>
					</p>
					<p class="letterMinFont">
						联系电话：<span id="aae005_print"></span>
					</p>
				</div>
				<div class="letterCTheme">
					<p>用人单位签字盖章</p>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日</p>
				</div>
				<div class="letterMinFont" style="text-align:center">请注意:请求职者务必在${otherDate}前将回执交回职介机构.避免给您再次求职带来不必要的麻烦.</div>
			</div>

			<div class="letterBottom">
				<h6>职业推荐介绍信存根</h6>
				<h6 class="letterMsg" id="accId_print3"></h6>
				<div class="letterTopMain">
					<table class="letterMinFont">
						<tr>
							<td>身份证：</td>
							<td width="28%"><input type="text" id="aac002_print" value="1234"
								class="letterInput" /></td>
							<td>姓名：</td>
							<td><input type="text" id="aac003_print3"
								class="letterInput" /></td>
							<td>性别：</td>
							<td><input type="text" id="aad004_print" class="letterInput" /></td>
						</tr>

						<tr>
							<td>文化程度：</td>
							<td><input type="text" id="aac011_print" class="letterInput" /></td>
							<td>人员类别：</td>
							<td><input type="text" id="acc20tname_print"
								class="letterInput" /></td>
							<td>联系方式：</td>
							<td><input type="text" id="ace139_print" class="letterInput" /></td>
						</tr>

						<tr>
							<td>现住址：</td>
							<td colspan="5"><input id="ace006_print"
								style="text-align: left;" type="text" class="letterInput" /></td>
						</tr>

						<tr>
							<td>单位名称：</td>
							<td colspan="2"><input style="text-align: left;" type="text"
								id="aab004_print" class="letterInput" /></td>
							<td>岗位：</td>
							<td colspan="2"><span style="text-align: left;" 
								id="bca112_print2" class="letterInput" ></span></td>
						</tr>

						<tr>
							<td>备注：</td>
							<td colspan="5"><input style="text-align: left;" type="text"
								id="mark_print" class="letterInput" /></td>
						</tr>

					</table>
				 <div class="letterCTheme">
					<p class="letterMinFont">推荐人:${userName}</p>
					<p class="letterMinFont">${currDate}</p>
				</div>
				</div>
			</div>

		</div>
	</div>
</body>
<script type="text/javascript">
    var isSave = false;
	function printBody() {
		if(isSave){
			//$("#mark_print").attr('value', $("#aae013").val()? $("#aae013").val():"无");
			$("#aae004_print").html($("#aae004").val());
			$("#aae006_print").html($("#aae006").val());
// 			$("#aab390_print").html($("#aab390").val());
			$("#aae005_print").html($("#aae005").val());
			$("#ace139_print").attr('value', $("#ace139").val());
			$("#ace006_print").attr('value', $("#ace006").val());
			var bdhtml = window.document.body.innerHTML;
			var sprnstr = "<!--begin-->";//设置打印开始区域    
			var eprnstr = "<!--end-->";//设置打印结束区域   
			var prnhtml = bdhtml.substring(bdhtml.indexOf(sprnstr) + 18); //从开始代码向后取html    
			var prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));//从结束代码向前取html    
			window.document.body.innerHTML = $("#printdiv").html();
			window.print();
			window.document.body.innerHTML = bdhtml;
			closeItem();
		}
	}
</script>
</html>
