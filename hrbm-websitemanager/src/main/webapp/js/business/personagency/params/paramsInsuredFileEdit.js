$(function() {

	initFormSubimt();
})
function initFormSubimt() {
	$('#paramsInsuredFileForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			// 发布名称
			fdFileName : {
				validators : {
					notEmpty : {},
					stringLength : {
						min : 2,
						max : 50
					}
				}
			},
			fdFileNumber : {
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
