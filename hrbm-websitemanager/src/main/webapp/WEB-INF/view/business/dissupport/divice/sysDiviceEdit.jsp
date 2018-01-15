<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑设备信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script
	src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript">
	$(function() {

		initFormSubimt();
		changeMod001();
		changeSty001();
		$(".mydate").datetimepicker({
			todayBtn : true,
			format : "yyyy-mm-dd",
			startView : 2,
			minView : 2,
			language : 'cn',
			maxView : "decade",
			viewSelect : 2,
			autocomplete : true,
			autoclose : true
		});
	})
	function initFormSubimt() {
		$('#sysDiviceForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//发布名称
				div002 : {
					validators : {
						notEmpty : {
							message : "设备名称不能为空"
						},
						stringLength : {
							min : 1,
							max : 150,
							message : "最大长度150"
						}
					}
				},
				div007 : {
					validators : {
						stringLength : {
							min : 0,
							max : 150,
							message : "最大长度150"
						}
					}
				},
				div003 : {
					validators : {
						stringLength : {
							min : 0,
							max : 50,
							message : "最大长度50"
						}
					}
				},
				div018: {
					validators : {
						stringLength : {
							min : 0,
							max : 10,
							message : "最大长度10"
						}
					}
				},
				div004 :{
					validators : {
						regexp : {
							regexp : /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
							message : '电话格式不正确'
						}
					}
				},
				div019: {
					validators : {
						stringLength : {
							min : 0,
							max : 10,
							message : "最大长度10"
						}
					}
				},
				aae013: {
					validators : {
						stringLength : {
							min : 0,
							max : 100,
							message : "最大长度100"
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
			$.post($form.attr('action'), $form.serialize(), function(data) {
				$(".btn-submit").removeAttr("disabled");
				bootbox.alert({
					size : 'small',
					width : "100px",
					message : data.message,
					callback : function() {
						var parentIframe = xfui.getParentIframe();
						if (parentIframe) {
							parentIframe.refresh();
						}
						closeItem();

					}
				})

			}, 'json');

		});
	}
	function closeItem() {
		xfui.closeDialog();
	}
	function submitForm() {
		$('#sysDiviceForm').submit();
	}
	//默认样式编号
	var defulatmod001 = "${sysDiviceForm.sty001}";
	function changeSty001() {
		$
				.ajax({
					url : '${ctx}/business/dissupport/divice/diviceStyle/listStyleJson.xf',
					data : {
						'mod001' : $("#mod001").val()
					},
					dataType : 'json',
					success : function(data) {
						$("#sty001").empty();
						var option = $("<option>").val('')
						.text('--请选择--');
						$("#sty001").append(option);
						if (data) {
							$.each(data, function(i, value) {
								var option = $("<option>").val(value.sty001)
										.text(value.sty003);
								$("#sty001").append(option);
							});
						}
					},
					error : function() {
						bootbox.alert('加载设备型号信息失败');
					}
				});
	}

	var defulatmod001 = "${sysDiviceForm.mod001}";
	function changeMod001() {
		$.ajax({
			url : '${ctx}/business/dissupport/divice/sysDivice/modelJson.xf',
			data : {
			// 					'acd200' : $("#acd200").val()
			},
			dataType : 'json',
			async : false,
			success : function(data) {
				$("#mod001").empty();
				if (data) {
					// 						if (data.length > 0) {
					// 							$('#sysDiviceForm').data('bootstrapValidator')
					// 									.updateStatus('mod001', 'VALID', null)
					// 									.validateField('mod001');
					// 						} else {
					// 							$('#sysDiviceForm').data('bootstrapValidator')
					// 									.updateStatus('mod001', 'NOT_VALIDATED')
					// 									.validateField('mod001');
					// 						}
					$.each(data, function(i, value) {
						var option = $("<option>").val(value.mod001).text(
								value.mod002);
						$("#mod001").append(option);
					});
				}
			},
			error : function() {
				bootbox.alert('加载设备型号信息失败');
			}
		});
	}
</script>
<style type="text/css">
.mydate {
	
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg" style="border: none;">
				<div class="moduleCont" style="padding: 0 56px 8px 0px">
					<form:form modelAttribute="sysDiviceForm" method="post"
						action="${ctx}/business/dissupport/divice/sysDivice/save.xf">
						<form:hidden path="div001"></form:hidden>
						<!-- 					 机构样式编码 -->
						<form:hidden path="sty002"></form:hidden>
						<form:hidden path="aae017"></form:hidden>
						<form:hidden path="aae011"></form:hidden>
						<!-- 						摊位编号 -->
						<form:hidden path="div013"></form:hidden>

						<form:hidden path="div010"></form:hidden>
						<form:hidden path="div011"></form:hidden>
						<form:hidden path="div015"></form:hidden>
						<form:hidden path="div017"></form:hidden>
						<form:hidden path="div020"></form:hidden>
						<form:hidden path="div022"></form:hidden>
						<form:hidden path="div008"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>所属机构:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:select cssClass="form-control" path="acd200"
									items="${orgs}" itemLabel="acd202" itemValue="acd200">
								</form:select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>设备名称:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div002"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">摆放位置:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div007"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError"><i
								style="color: red; margin-right: 5px;">*</i>所属型号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<select class="form-control" onchange="changeSty001()"
									name="mod001" id="mod001"></select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">运行模式:</label>
							<div class="col-xs-9 col-sm-2 required">
								<select class="form-control" id="div021" name="div021">
								    <option value="">--请选择--</option>
									<option value="0">无</option>
									<option value="1">招聘会模式</option>
									<option value="2">户外模式</option>
									<option value="3">面试模式</option>
								</select>
								<script type="text/javascript">
									$("#div021").val('${sysDiviceForm.div021}');
								</script>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">设备管理员:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div003"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">中心样式:</label>
							<div class="col-xs-9 col-sm-2 required">
								<select class="form-control" name="sty001" id="sty001"></select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">机器码:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div018"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">管理员电话:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div004"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">设备类型:</label>
							<div class="col-xs-9 col-sm-2 required">
								<xf:select name="div014" selectClass="form-control"
									isNoStyle="true" value="${sysDiviceForm.div014}"
									textField="TYPE_NAME" tableName="DEV_TYPE"  valueField="TYPE_ID"></xf:select>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">授权码:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div019"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">运行时间:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control " readonly="true" type="text"
									path="div006"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">显示机制:</label>
							<div class="col-xs-9 col-sm-2 required">
								<%-- 								<form:input class="form-control" type="text" path="div016" ></form:input> --%>
								<input class="form-control" name="div016" type="hidden"
									value="1" /> <select class="form-control" disabled="disabled">
									<option value="1">显示图片</option>
									<option value="2">显示视频</option>
								</select>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">设备编号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" readonly="true" type="text"
									path="div012"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">最后读取时间:</label>
							<div class="col-xs-9 input-group col-sm-2  ">
								<!-- 							//style="padding: 0 !important;" -->
								<form:input class="form-control" readonly="true" type="text"
									path="div005"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">经办时间:</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" readonly="true" type="text"
									path="aae036"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" readonly="true" type="text"
									path="aae019"></form:input>
							</div>
							<label class="col-xs-3 col-sm-2" readonly="true" for="inputError">经办机构:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" readonly="true" type="text"
									path="aae020"></form:input>
							</div>
						</div>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">备注:</label>
							<div class="col-xs-9 col-sm-10 required">
								<form:input class="form-control" type="text" path="aae013"></form:input>
							</div>
						</div>
						<div class="bottomBtn">
<div class="h50"> </div>
<div class="floatBtn">
							<button href="javascript:void(0)" role="button"
								class="btn btn-primary mhyBtnLeft" type="submit">
								<i class="icon-save"></i>
								保存</button>
							<button href="javascript:void(0)" role="button" type="button" class="btn btn-info"
								onclick="closeItem()">
								<i class="icon-remove"></i>
								关闭</button>
						</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="h60">&nbsp;</div>
	</div>
</body>
</html>
