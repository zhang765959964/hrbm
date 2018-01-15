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
	padding-bottom: 20px;
}
.letterMinFont{
	font-size:12px;
}
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
	margin-bottom: 20px;
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
		// 		$("#aae030").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#aae031").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#aaeb36").xfdatera
		// 	ngepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#aac006").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#aaec36").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#acc22c").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});

		// 		$("#aae036").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#aaea36").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#acc22k").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#acc201").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#acc22n").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});
		// 		$("#ccpr05").xfdaterangepicker({
		// 			singleDatePicker : true,
		// 			"opens" : "right",
		// 			"drops" : "up",
		// 			"locale" : {
		// 				"format" : "YYYY-MM-DD"
		// 			}
		// 		});

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
				<div class="moduleTit">招聘信息详情</div>
				<div class="moduleCont">
						<div class="row bgBr ">招聘信息</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">单位名称:</label>
							<div class="col-xs-9 col-sm-10 ">
							<input type="text" readonly="readonly" id="AAB004" class="form-control"  value="${AAB004}"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">工商执照号码:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="AAB007" class="form-control"  value="${AAB007}"/>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">组织机构代码:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="AAB003N" class="form-control"  value="${AAB003N}"/>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">登记日期:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="AAE043" class="form-control"  value="${AAE043}"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">招聘方式:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="AAE043" class="form-control"  value="${AAE043}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">招聘起始日期:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="EAAE030" class="form-control"  value="${EAAE030}"/>
							</div>
							 
							<label class="col-xs-3 col-sm-2" for="inputError">招聘终止日期:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="EAAE031" class="form-control"  value="${EAAE031}"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">招聘联系人:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="AAE004" class="form-control"  value="${AAE004}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">联系人电话:</label>
							<div class="col-xs-9 col-sm-2 ">
								<input type="text" readonly="readonly" id="AAE005" class="form-control"  value="${AAE005}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">联系人手机:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="AAE139" class="form-control"  value="${AAE139}"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">联系人地址:</label>
							<div class="col-xs-9 col-sm-10">
							<input type="text" readonly="readonly" id="ACB204" class="form-control"  value="${ACB204}"/>
							</div>
						</div>
						<div class="row bgBr ">岗位信息</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">职位名称:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="ACA112" class="form-control"  value="${ACA112}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">职位说明:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="BCA112" class="form-control"  value="${BCA112}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">招聘人数:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="ACB21R" class="form-control"  value="${ACB21R}"/>
							</div>
						</div>

						<div class="row">
						 
							<label class="col-xs-3 col-sm-2" for="inputError">岗位描述:</label>
							<div class="col-xs-9 col-sm-10 " >
							 <textarea  readonly="readonly" rows="3" style="background-color: #f5f5f5!important;"   >${CCA114}</textarea>
							</div>
 
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">工作职责:</label>
							<div class="col-xs-9 col-sm-10">
							 <input type="text" readonly="readonly" id="BCB21A" class="form-control"  value="${BCB21A}"/>
							</div>
						</div>
							<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">工作地点:</label>
							<div class="col-xs-9 col-sm-10">
							 <input type="text" readonly="readonly" id="BCB202" class="form-control"  value="${BCB202}"/>
							</div>
						</div>
						<div class="row">
							<!--    经办机构行政区划 -->

							<label class="col-xs-3 col-sm-2" for="inputError">性别:</label>
							<div class="col-xs-9  col-sm-2">
							 <input type="text" readonly="readonly" id="AAD004" class="form-control"  value="${AAD004}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">最低年龄:</label>
							<div class="col-xs-9 col-sm-2 ">
						   <input type="text" readonly="readonly" id="ACB221" class="form-control"  value="${ACB221}"/>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">最高年龄:</label>
							<div class="col-xs-9 col-sm-2 ">
						  	<input type="text" readonly="readonly" id="ACB222" class="form-control"  value="${ACB222}"/>
							</div>
						</div>
							<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">文化程度:</label>
							<div class="col-xs-9  col-sm-2">
							<input type="text" readonly="readonly" id="AAC011" class="form-control"  value="${AAC011}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">招聘对象:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="ACC20T" class="form-control"  value="${ACC20T}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">工作年限:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="ACC217" class="form-control"  value="${ACC217}"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">月工资:</label>
							<div class="col-xs-9  col-sm-2">
							 <input type="text" readonly="readonly" id="ACC034" class="form-control"  value="${ACC034}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">福利待遇:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="ACC214" class="form-control"  value="${ACC214}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">食宿要求:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="ACB228" class="form-control"  value="${ACB228}"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9  col-sm-2">
							 <input type="text" readonly="readonly" id="AAE019" class="form-control"  value="${AAE019}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="AAE020" class="form-control"  value="${AAE020}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办日期:</label>
							<div class="col-xs-9 col-sm-2 ">
							<input type="text" readonly="readonly" id="AAE036" class="form-control"  value="${AAE036}"/>
							</div>
						</div>
						<div class="row bgBr ">更多信息</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">户口性质:</label>
							<div class="col-xs-9  col-sm-6">
							<input type="text" readonly="readonly" id="AAC005" class="form-control"  value="${AAC005}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">民族:</label>
							<div class="col-xs-9 col-sm-2">
							<input type="text" readonly="readonly" id="AAC009" class="form-control"  value="${AAC009}"/>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">外语语种:</label>
							<div class="col-xs-9  col-sm-2">
							 <input type="text" readonly="readonly" id="AAC038" class="form-control"  value="${AAC038}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">普通话水平:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="BCC20X" class="form-control"  value="${BCC20X}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">推荐比例:</label>
							<div class="col-xs-9 col-sm-2 ">
								 <input type="text" readonly="readonly" id="ACB21P" class="form-control"  value="${ACB21P}"/>
							</div>
						</div>
							<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">政治面貌:</label>
							<div class="col-xs-9  col-sm-2">
							 <input type="text" readonly="readonly" id="AAC024" class="form-control"  value="${AAC024}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">婚姻状况:</label>
							<div class="col-xs-9 col-sm-2 ">
							  <input type="text" readonly="readonly" id="AAC017" class="form-control"  value="${AAC017}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">健康状况:</label>
							<div class="col-xs-9 col-sm-2 ">
								  <input type="text" readonly="readonly" id="AAC033" class="form-control"  value="${AAC033}"/>
							</div>
						</div>
							<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">身高:</label>
							<div class="col-xs-9  col-sm-2">
							  <input type="text" readonly="readonly" id="AAC034" class="form-control"  value="${AAC034}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">体重:</label>
							<div class="col-xs-9 col-sm-2 ">
							  <input type="text" readonly="readonly" id="AAC035" class="form-control"  value="${AAC035}"/>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">视力:</label>
							<div class="col-xs-9 col-sm-2 ">
							 <input type="text" readonly="readonly" id="AAC036" class="form-control"  value="${AAC036}"/>
							</div>
						</div>
						<div class="row"><label class="col-xs-3 col-sm-2" for="inputError">备注:</label>
						<div class="col-xs-9 col-sm-10 ">
						<input type="text" readonly="readonly" id="AAE013" class="form-control"  value="${AAE013}"/>
						</div></div>
			 
				</div>
			</div>
		</div>
		<div class="h60">&nbsp;</div>
		<div class="floatBtn">
<!-- 			<input type="checkbox" id="checkmessage" /> 发送短信&nbsp;&nbsp;&nbsp; <a -->
<!-- 				href="javascript:void(0)" role="button" class="btn btn-primary" -->
<!-- 				onclick="submitForm()" id="save_but"> <i class="icon-save"></i> 保存 -->
<!-- 			</a> <button href="javascript:void(0)" id="print_id" disabled="disabled" title="保存后才能打印" role="button" class="btn btn-primary" -->
<!-- 				onclick="javascrīpt:printBody()"  ><i class="icon-print"></i>打印介绍信</button> -->
<!-- 			<a href="javascript:void(0)" role="button" class="btn btn-primary" -->
<!-- 				onclick="savePrint()" id="save_butprint"><i class="icon-print"></i>保存并打印</a> -->
			<button class="btn btn-info mhyBtnLeft" data-dismiss="modal"
				type="button" onclick="closeItem()">
				<i class="icon-remove"></i> 关闭
			</button>
		</div>
	</div>
</body>

</html>
