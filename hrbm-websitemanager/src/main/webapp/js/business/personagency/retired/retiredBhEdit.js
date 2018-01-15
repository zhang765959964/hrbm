$(function() {
	initFormSubimt();
})

function initFormSubimt() {
	$('#retiredDeclareForm')
			.bootstrapValidator(
					{
						message : 'This value is not valid',
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							retiredPeopleBm : {
								validators : {
									notEmpty : {},
									remote : {
										type : 'POST',
										url : CTX+'/business/personagency/retired/declare/getByRetiredBm.xf?id='+$("#id").val(),
										message : '已有此个人编码,不能重复添加！',
										delay : 1000
									},
									regexp : {
										regexp : /^[0-9]*$/,
										message : '请输入合法的数据！'
									},
									stringLength : {
										min : 8,
										max : 8
									}
								}
							},
							declareNote : {
								validators : {
									notEmpty : {},
									stringLength : {
										min : 2,
										max : 100
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