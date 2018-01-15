$(function() {

	initFormSubimt();
})
function initFormSubimt() {
	$('#paramsAccountsCorpForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			// 发布名称
			fdUserAccount : {
				validators : {
					notEmpty : {},
					stringLength : {
						min : 2,
						max : 20
					}
				}
			},
			fdUserName : {
				validators : {
					notEmpty : {},
					stringLength : {
						min : 2,
						max : 20
					}
				}
			},
			fdDeptName : {
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
function submitForm() {
	$('#paramsAccountsCorpForm').submit();
}