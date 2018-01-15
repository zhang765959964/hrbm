$(function() {
	xfui.initUi();
	$("#fdStartdate").on(
			'apply.daterangepicker',
			function(ev, picker) {
				var bootstrapValidator = $("#paramsPaymentForm").data(
						'bootstrapValidator');
				bootstrapValidator.updateStatus('fdStartdate', 'NOT_VALIDATED')
						.validateField('fdStartdate');
			});
	$("#fdEnddate").on(
			'apply.daterangepicker',
			function(ev, picker) {
				var bootstrapValidator = $("#paramsPaymentForm").data(
						'bootstrapValidator');
				bootstrapValidator.updateStatus('fdEnddate', 'NOT_VALIDATED')
						.validateField('fdEnddate');
			});
	initFormSubimt();

})
function initFormSubimt() {
	$('#paramsPaymentForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			// 标准执行开始年月
			fdStartdate : {
				validators : {
					notEmpty : {
						message : "标准执行开始年月不能为空！"
					},
					stringLength : {
						min : 2,
						max : 50
					}
				}
			},
			// 标准执行结束年月
			fdEnddate : {
				validators : {
					notEmpty : {
						message : '标准执行结束年月不能为空！'
					}

				}
			},
			// 优惠标准
			fdStandard : {
				validators : {
					notEmpty : {
						message : '优惠标准不能为空！'
					},
					regexp : {
						regexp : /^([+-]?)\d*\.?\d+$/,
						message : '只能输入数值！'
					},
					stringLength : {
						max : 10
					}

				}
			},
			// 持优惠证标准
			fdDiscountStandard : {
				validators : {
					notEmpty : {
						message : '持优惠证标准不能为空！'
					},
					regexp : {
						regexp : /^([+-]?)\d*\.?\d+$/,
						message : '只能输入数值！'
					},
					stringLength : {
						max : 10
					}
				}
			}

		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		var $form = $(e.target);
		var bv = $form.data('bootstrapValidator');
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