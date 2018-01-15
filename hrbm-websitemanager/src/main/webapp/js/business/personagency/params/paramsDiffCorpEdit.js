$(function() {

	initFormSubimt();
})
function initFormSubimt() {
	$('#paramsDiffCorpForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			// 困难企业名称
			fdCorpName : {
				validators : {
					notEmpty : {},
					stringLength : {
						min : 2,
						max : 50
					}
				}
			},
			//困难企业代码
			fdCorpCode : {
				validators : {
					notEmpty : {},
					stringLength : {
						max : 10
					}
				}
			},
			
			//所属区域 
			fdCorpAddre : {
				validators : {
					stringLength : {
						max : 50
					}
				}
			},
			//详细信息
			fdCorpDetail : {
				validators : {
					stringLength : {
						max : 300
					}
				}
			},
			//备注
			fdCorpNote : {
				validators : {
					stringLength : {
						max : 300
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
