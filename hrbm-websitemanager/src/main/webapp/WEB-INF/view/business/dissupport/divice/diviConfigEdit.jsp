<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>编辑 设备配置表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<script type="text/javascript">
	$(function() {

		initFormSubimt();
		$("#aae036").xfdaterangepicker({
			singleDatePicker : true,
			"opens" : "right",
			"drops" : "up",
			"locale" : {
				"format" : "YYYY-MM-DD"
			}
		});
		$("#bae036").xfdaterangepicker({
			singleDatePicker : true,
			"opens" : "right",
			"drops" : "up",
			"locale" : {
				"format" : "YYYY-MM-DD"
			}
		});
		$("#con228").xfdaterangepicker({
			singleDatePicker : true,
			"opens" : "right",
			"drops" : "up",
			"locale" : {
				"format" : "YYYY-MM-DD"
			}
		});
		$("#con230").xfdaterangepicker({
			singleDatePicker : true,
			"opens" : "right",
			"drops" : "up",
			"locale" : {
				"format" : "YYYY-MM-DD"
			}
		});
	})
	function initFormSubimt() {
		$('#diviConfigForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				//发布名称
				demoField : {
					validators : {
						notEmpty : {},
						stringLength : {
							min : 2,
							max : 50
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
		$('#diviConfigForm').submit();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="moduleWrapNobg">
				<div class="moduleTit">设备配置表</div>
				<div class="moduleCont">
					<form:form modelAttribute="diviConfigForm" method="post"
						action="${ctx}/business/dissupport/divice/diviConfig/save.xf">
						<form:hidden path="con001"></form:hidden>
						<div class="row">
							<label class="col-xs-3 col-sm-2" for="inputError">所属机构:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="acd200"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">设备编号:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="div001"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">岗位名称(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con002"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">单位名称(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con003"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">单位类型(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con004"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经济类型(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con005"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">行业类型(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con006"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">工作性质(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con007"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">食宿要求(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con008"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">学历要求(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con009"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">单位地址(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con010"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">月薪范围(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con011"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">工作地点(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con012"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">联系人(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con013"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">信息公开范围(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con014"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">最后修改人(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con015"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">信息来源(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con016"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">总过滤条件:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con999"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">备注(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aae013"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办人代码(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aae011"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办机构代码(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aae017"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办时间(CS):</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="aae036"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aae019"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办机构(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="aae020"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">岗位名称(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con202"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">单位名称(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con203"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">单位类型(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con204"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经济类型(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con205"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">行业类型(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con206"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">工作性质(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con207"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">食宿要求(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con208"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">学历要求(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con209"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">单位地址(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con210"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">月薪范围(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con211"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">工作地点(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con212"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">联系人(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con213"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">公开范围(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con214"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">最后修改人(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con215"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">信息来源（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con216"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">过滤条件(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con099"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">过滤条件(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con299"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">是否应用过滤条件(CS)T-应用F-不应用:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con017"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">备注(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bae013"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办人代码(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bae011"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办机构代码(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bae017"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办时间(BS):</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="bae036"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">经办人(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bae019"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">经办机构(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="bae020"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">岗位编号(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con018"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">职位名称（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con019"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">职位说明（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con020"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">人数（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con021"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">性别(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con022"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">年龄要求（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con024"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">工作经验（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con025"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">是否适合应届（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con026"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">招聘开始日期（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con027"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">招聘结束日期（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con028"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">备用（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con031"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">备用（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con032"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">备用（CS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con033"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">岗位编号（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con217"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">职位名称（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con218"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">职位说明（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con219"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">性别（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con220"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">人数（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con221"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">年龄要求（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con222"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">工作经验（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con223"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">是否适合应届（BS）:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con224"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">招聘开始日期(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con225"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">招聘结束日期(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con226"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">添加人(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con227"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">添加时间(BS):</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="con228"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">修改人(BS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con229"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">修改时间(BS):</label>
							<div class="col-xs-9 input-group col-sm-2">
								<form:input class="form-control" type="text" path="con230"></form:input>
								<span class="input-group-addon"> <i
									class="icon-calendar bigger-110"></i>
								</span>
							</div>
							<label class="col-xs-3 col-sm-2" for="inputError">修改时间(CS):</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con034"></form:input>
							</div>

							<label class="col-xs-3 col-sm-2" for="inputError">CON232:</label>
							<div class="col-xs-9 col-sm-2 required">
								<form:input class="form-control" type="text" path="con232"></form:input>
							</div>

						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="h60">&nbsp;</div>
		<div class="floatBtn">
			<a href="javascript:void(0)" role="button" class="btn btn-primary"
				onclick="submitForm()">保存</a> <a href="javascript:void(0)"
				role="button" class="btn btn-success" onclick="closeItem()">打印条码标签</a>
			<a href="javascript:void(0)" role="button" class="btn btn-info"
				data-toggle="modal">登记新户</a> <a href="javascript:void(0)"
				role="button" class="btn btn-success">打印条码标签</a>

		</div>

	</div>

</body>
</html>
