<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/commons/include/commonInc.jsp"%>
<link rel="stylesheet" href="${ctx}/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${ctx}/js/lib/ztree/css/metroStyle/metroStyle.css"
	type="text/css">
<link rel="stylesheet"
	href="${ctx}/js/lib/bootstrap-validator/css/bootstrapValidator.css"
	type="text/css">
<script type="text/javascript"
	src="${ctx}/js/lib/jquery/bootstrap-contextmenu.js"></script>
<link rel="stylesheet"
	href="${ctx}/assets/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${ctx}/assets/css/daterangepicker.css" />
<script src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
<script
	src="${ctx}/assets/js/date-time/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${ctx}/js/lib/bootstrap-validator/js/bootstrapValidator.js"></script>

<link rel="stylesheet" href="${ctx}/assets/styleNew/mhy_style.css" />

<title>编辑系统人员</title>
<script>
	var cczh01_reg = /^[0-9A-Za-z_]{6,15}$/;
	var aac002_reg = /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/;
	function checkFieldBootstrap(url, data, message, checktype, fieldname,
			bthObj) {
		var res = false;
		$.ajax({
			url : url,
			data : data,
			async : false,
			dataType : 'json',
			success : function(data) {
				res = (data.result == '0');
			},
			error : function() {
				res = false
			}
		});
		//判断用户名是否已存在
		if (!res) {
			$(
					"small[data-bv-validator$='" + checktype
							+ "'][data-bv-for$='" + fieldname + "']").html(
					message);
			$(
					"small[data-bv-validator$='" + checktype
							+ "'][data-bv-for$='" + fieldname + "']").show();
			bthObj.attr("disabled", true);
			return false;
		} else {
			$(
					"small[data-bv-validator$='" + checktype
							+ "'][data-bv-for$='" + fieldname + "']").hide();
			bthObj.removeAttr("disabled");
			return true;
		}
	}
	function checkCczh01() {
		var res = false;
		if ($("#acd230").val() == '') {
			var cczh01 = $("#cczh01_id").val();
			//基本数据校验
			if (cczh01 == '' || !cczh01.match(cczh01_reg)) {
				return false;
			}
			//异步调用url
			var url = '${ctx}/sys/uums/sysUser/isExist.xf';
			//查询参数
			var data = {
				'cczh01' : cczh01
			};
			//提示信息类型
			var message = "用户名已存在";
			//检索bootstrap错误提示类型
			var checktype = "callback";
			//fieldname
			var fieldname = "cczh01";
			//按钮
			var bthObj = $("#button_submit");
			res = checkFieldBootstrap(url, data, message, checktype, fieldname,
					bthObj);
		} else {
			res = true;
		}
		return res;
	}
	function checkAac002() {
		var res = false;
		if ($("#acd230").val() == '') {
			var aac002 = $("#aac002_id").val();
			//基本数据校验
			if (aac002 == '' || !aac002.match(aac002_reg)) {
				return false;
			}
			//异步调用url
			var url = '${ctx}/sys/uums/sysUser/isExist.xf';
			//查询参数
			var data = {
				'aac002' : aac002
			};
			//提示信息类型
			var message = "该身份证号已注册";
			//检索bootstrap错误提示类型
			var checktype = "callback";
			//fieldname
			var fieldname = "aac002";
			//按钮
			var bthObj = $("#button_submit");
			res = checkFieldBootstrap(url, data, message, checktype, fieldname,
					bthObj);
		} else {
			res = true;
		}
		return res;
	}
	$(function() {
		initFormSubimt();
		$('#cczh01_id').on('blur', function(e) {
			checkCczh01();
		});
// 		$('#aac002_id').on('blur', function(e) {
// 			checkAac002();
// 		});
	})
	function initFormSubimt() {
		$('#sysUserForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				cczh01 : {
					validators : {
						notEmpty : {
							message : '用户名不能为空'
						},
						regexp : {
							regexp : cczh01_reg,
							message : '6~15位字母数字'
						},
						callback : {
							message : '用户名已存在',
							callback : function(value, validator) {
								return true;
							}
						}
					}
				},
				cczh02 : {
					validators : {
						notEmpty : {
							message : '账户密码不能为空'
						},
						stringLength : {
							message : '6~20字母或数字',
							min : 6,
							max : 20
						}
					}
				},
				aae005 : {
					validators : {
						phone : {
							message : '联系电话格式不正确',
							country : 'CN'
						}
					}
				},
				dep001 : {
					validators : {
						notEmpty : {
							message : '部门不能为空'
						}
					}
				},
				aac003 : {
					validators : {
						notEmpty : {
							message : '姓名不能为空'
						},
						stringLength : {
							message : '最大长度为10',
							min : 0,
							max : 10
						}
					}
				},
				aac026 : {
					validators : {
						stringLength : {
							message : '最大长度为40',
							min : 1,
							max : 40
						}
					}
				},
				acc02i : {
					validators : {
						stringLength : {
							message : '最大长度为20',
							min : 1,
							max : 20
						}
					}
				},
				acd231 : {
					validators : {
						stringLength : {
							message : '最大长度为10',
							min : 1,
							max : 10
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
			if (checkCczh01())
				bv.disableSubmitButtons(true);
				$.post($form.attr('action'), $form.serialize(), function(data) {
					
					bootbox.alert({
						size : 'small',
						width : "100px",
						message : data.message,
						callback : function() {
							bv.disableSubmitButtons(false);
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

	function resetForm() {
		$("#sys_user_form").form("clear");
		$('.easyui-combobox').combobox("setValue", "");
	}
	function changeDept() {
		$.ajax({
			url : '${ctx}/sys/uums/sysUser/queryDepts.xf',
			data : {
				'acd200' : $("#acd200_select").val()
			},
			dataType : 'json',
			success : function(data) {
				$("#dep001").empty();
				if (data) {
					if (data.length > 0) {
						$('#sysUserForm').data('bootstrapValidator')
								.updateStatus('dep001', 'VALID', null)
								.validateField('dep001');
					} else {
						$('#sysUserForm').data('bootstrapValidator')
								.updateStatus('dep001', 'NOT_VALIDATED')
								.validateField('dep001');
					}
					$.each(data, function(i, value) {
						var option = $("<option>").val(value.dep001).text(
								value.dep002);
						$("#dep001").append(option);
					});
				}
			},
			error : function() {
				bootbox.alert('加载部门信息失败');
			}
		});
	}
</script>
</head>
<body>
	<%-- ${ctx}/sys/uums/sysUser/isExist.xf?noacd230=${sysUser.acd230} --%>
	<form:form modelAttribute="sysUserForm" method="post"
		action="${ctx}/sys/uums/sysUser/save.xf">
		<div class="modal-body overflow-visible reportWrap">
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<form:hidden path="acd230" id="acd230"></form:hidden>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6 col-sm-6" for="inputError"><i
						style="color: red; margin-right: 5px;">*</i>账户名称：</label>
					<div class="col-xs-6 col-sm-6">
						<c:if test="${sysUserForm.acd230!=null}">
							<div class="form-control">${sysUserForm.cczh01}</div>
							<form:hidden path="cczh01" />
						</c:if>
						<c:if test="${sysUserForm.acd230==null}">
							<form:input class="form-control" type="text" id="cczh01_id"
								path="cczh01"></form:input>
						</c:if>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError"><i
						style="color: red; margin-right: 5px;">*</i>账户密码：</label>
					<div class="col-xs-6 col-sm-6">
						<form:input class="form-control" path="cczh02"
							data-options="required:true" type="text"></form:input>
					</div>
				</div>
			</div>
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError"><i
						style="color: red; margin-right: 5px;">*</i>所属机构：</label>
					<div class="col-xs-6 col-sm-6">
						<form:select path="acd200" id="acd200_select" itemLabel="acd202"
							onchange="changeDept()" itemValue="acd200" items="${sysorgs}"></form:select>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError"><i
						style="color: red; margin-right: 5px;">*</i>所属部门：</label>
					<div class="col-xs-6 col-sm-6">
						<form:select data-options="required:true" path="dep001"
							itemLabel="dep002" itemValue="dep001" items="${sysdepts}" ></form:select>
					</div>
				</div>
			</div>
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">身份证号码：</label>
					<div class="col-xs-6 col-sm-6">
						<c:if test="${sysUserForm.acd230!=null}">
							<span class="form-control">${sysUserForm.aac002}</span>
							<form:hidden path="aac002" />
						</c:if>
						<c:if test="${sysUserForm.acd230==null}">
							<form:input class="form-control" path="aac002" id="aac002_id"
								data-options="required:true" type="text"></form:input>
						</c:if>

					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError"><i
						style="color: red; margin-right: 5px;">*</i>姓名：</label>
					<div class="col-xs-6 col-sm-6">
						<form:input class="form-control" path="aac003" type="text"></form:input>
					</div>
				</div>
			</div>
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">出生日期：</label>
					<div class="col-xs-6 col-sm-6">
						<%-- 	 <form:input   class="form-control"    data-options="required:true" type="text"  ></form:input> --%>
						<form:input class="form-control date-picker dp" id="datepicker01"
							path="aac006" readonly="true" type="text" placeholder="请选择日期"></form:input>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">性别：</label>
					<div class="col-xs-6 col-sm-6">
						<xf:select isNoStyle="true" tableName="TAB_SEX" name="aac004"
							valueField="code" hasDefault="0" textField="name"
							value="${sysUserForm.aac004}"></xf:select>
					</div>
				</div>
			</div>
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">联系电话：</label>
					<div class="col-xs-6 col-sm-6">
						<form:input class="form-control" path="aae005"
							data-options="required:true" type="text"></form:input>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">文化程度：</label>
					<div class="col-xs-6 col-sm-6">
						<xf:select isNoStyle="true" tableName="TAB_EDUCATION"
							name="aac011" valueField="code" hasDefault="0" textField="name"
							value="${sysUserForm.aac011}"></xf:select>
					</div>
				</div>
			</div>
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">职业资格等级：</label>
					<div class="col-xs-6 col-sm-6">
						<xf:select isNoStyle="true" tableName="TAB_COQ" name="aac015"
							valueField="code" hasDefault="0" textField="name"
							value="${sysUserForm.aac015}"></xf:select>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">职务：</label>
					<div class="col-xs-6 col-sm-6">
						<form:input class="form-control" path="acd231" type="text"></form:input>
					</div>
				</div>
			</div>
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">资格证书类别：</label>
					<div class="col-xs-6 col-sm-6">
						<xf:select isNoStyle="true" tableName="TAB_QUATYPE" name="acd232"
							valueField="code" textField="name" value="${sysUserForm.acd232}"
							hasDefault="0"></xf:select>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">资格证书号码：</label>
					<div class="col-xs-6 col-sm-6">
						<form:input class="form-control" path="acc02i" type="text"></form:input>
					</div>
				</div>
			</div>
			<div class="row mhyPhotoDiv" style="padding: 0 70px 0 0;">
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">人员身份：</label>
					<div class="col-xs-6 col-sm-6">
						<xf:select isNoStyle="true" tableName="TAB_STAFFID" name="acd233"
							valueField="code" textField="name" hasDefault="0"
							value="${sysUserForm.acd233}"></xf:select>
					</div>
				</div>
				<div class="col-xs-12 col-sm-6">
					<label class="col-xs-6" for="inputError">家庭住址：</label>
					<div class="col-xs-6 col-sm-6">
						<form:input class="form-control" path="aac026" type="text"></form:input>
					</div>
				</div>
			</div>

		</div>
		<div class="modal-footer new-model-footer mhyPopBtn"
			style="position: fixed; bottom: 0">
			<button class="btn btn-info mhyBtnLeft" data-dismiss="modal" type="button"
				onclick="closeItem()">
				<i class="icon-remove"></i> 关闭
			</button>

			<button class="btn btn-primary" id="button_submit"
				type="submit">
				<i class="icon-save"></i> 保存
			</button>
		</div>
	</form:form>
</body>
<script type="text/javascript">
	jQuery(function($) {
		// 日期选择
		$("#datepicker01").datetimepicker({
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
		$(".dp").datetimepicker({
			todayBtn : true,
			format : "yyyy-mm-dd",
			startView : 2,
			minView : 2,
			maxView : "decade",
			viewSelect : 2,
			language : 'cn',
			autocomplete : true,
			autoclose : true
		});
		$(".dpMonth").datetimepicker({
			todayBtn : true,
			format : "yyyy-mm",
			startView : 3,
			minView : 3,
			maxView : "decade",
			language : 'cn',
			viewSelect : 3,
			autocomplete : true,
			autoclose : true
		});
	});
</script>
</html>