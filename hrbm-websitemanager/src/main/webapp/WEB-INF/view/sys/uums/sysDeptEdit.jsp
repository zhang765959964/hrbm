<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>编辑部门信息</title>
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
<script type="text/javascript">
    function checkdep002(){
    	var res = false;
		$.ajax({
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			url : '${ctx}/sys/uums/sysDept/isExist.xf',
			data : {
				'acd200' : getAcd200Value(),
				'dep002e' : $("#dep002").val(),
				'currdep001' :$("#dep001").val()
			},
			async : false,
			type: "post", 
			dataType : 'json',
			success : function(data) {
				res = (data.result == '0');
			},
			error : function() {
				res = false
			}
		});
		//部门是否已存在
		if (!res) {
			$("small[data-bv-validator$='stringLength'][data-bv-for$='dep002']")
					.html("部门名称已存在");
			$("small[data-bv-validator$='stringLength'][data-bv-for$='dep002']")
					.show();
			  $(".btn-submit").Attr("disabled")
			  return false;
		}else{
			return true;
		}
    }
	$(function() {
		initFormSubimt();
		$('#dep002').on('blur',
						function(e) {
							var value = $(this).val();
							if (value != "" && value.length >= 2
									&& value.length <= 50) {
								checkdep002();
							}
						});
	})
	function initFormSubimt() {
		$('#sysDeptForm').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				dep002 : {
					validators : {
						notEmpty : {},
						stringLength : {
							min : 2,
							max : 50
						}
					}

				},
				dep003 : {
					validators : {
						stringLength : {
							min : 0,
							max : 100
						}
					}
				},
				dep004 : {
					validators : {
						notEmpty : {},
						regexp : {
							regexp : /^[0-9]*$/,
							message : "请输入正确的排序序号"
						},
						stringLength : {
							min : 0,
							max : 6
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			e.preventDefault();
			var $form = $(e.target);
			var bv = $form.data('bootstrapValidator');
			if(checkdep002()){
				bv.disableSubmitButtons(true);	
			$.post($form.attr('action'), $form.serialize(), function(data) {
				$(".btn-submit").removeAttr("disabled");
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

			}, 'json');}

		});
	}

	function closeItem() {
		xfui.closeDialog();
	}
	function getAcd200Value() {
		var isEdit = '${isEdit}';
		if (isEdit) {

		}
		return $("#acd200").val();
	}
	// 	function closeItem(){
	// 		  xfui.closeTab();
	// 	  }
</script>
</head>
<body>
	<form:form modelAttribute="sysDeptForm" method="post"
		action="${ctx}/sys/uums/sysDept/save.xf">
		<div class="modal-body overflow-visible reportWrap">
			<div class="row" style="padding: 0 30px;">
				<form:hidden path="dep001"></form:hidden>
				<div class="col-xs-12">
					<label class="col-xs-2" for="inputError">所属机构：</label>
					<div class="col-xs-8 col-sm-6">
						<c:choose>
							<c:when test="${isEdit}">
								<form:hidden path="acd200" />
								<div>${orgName}</div>
							</c:when>
							<c:otherwise>
								<form:select path="acd200" items="${sysOrgs}" itemLabel="acd202"
									dir="1" itemValue="acd200">
								</form:select>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-xs-12">
					<label class="col-xs-2" for="inputError">部门名称：</label>
					<div class="col-xs-8">
						<form:input class="form-control" type="text" path="dep002"
							data-options="required:true"></form:input>
					</div>
				</div>
				<div class="col-xs-12">
					<label class="col-xs-2" for="inputError">部门描述：</label>
					<div class="col-xs-8">
						<form:input class="form-control" type="text" path="dep003"
							data-options="required:false"></form:input>
					</div>
				</div>
				<div class="col-xs-12" style="display: none;">
					<label class="col-xs-2" for="inputError">部门排序序号：</label>
					<div class="col-xs-8">
						<form:input class="form-control" type="text" path="dep004"
							data-options="required:false"></form:input>
					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer mhyPopBtn">
			<button class="btn btn-info mhyBtnLeft" data-dismiss="modal" type="button"
				onclick="closeItem()">
				<i class="icon-remove"></i> 关闭
			</button>

			<button class="btn btn-primary" type="submit">
				<i class="icon-save"></i> 保存
			</button>
		</div>
	</form:form>
</body>
</html>