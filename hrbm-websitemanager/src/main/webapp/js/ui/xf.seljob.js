/**
 * 通用岗位选择组件 wanghan
 */
window['seljob'] || (window['seljob'] = {});
(function($) {
	window.seljob = {
		modalDialog : {},
		modalOpts : {},
		callBack : function(obj, data) {
			var diaId = this.getFrameId(obj);
			var opts = this.modalOpts[diaId];
			if ($.isFunction(opts.callBack)) {
				opts.callBack(data);
			}
		},
		closeDialog : function(obj) {
			var diaId = this.getFrameId(obj);
			var modal = this.modalDialog[diaId];
			$(modal).dialog("close");
		},
		addModalDialog : function(modal, opts) {
			var id = this.autoFrameId();
			$(modal).attr("id", id);
			this.modalDialog[id] = modal;
			this.modalOpts[id] = opts;
		},
		autoFrameId : function() {
			this.frameIndex = this.frameIndex || 0;
			this.frameIndex++;
			return "_xf_modal_id_" + this.frameIndex;
		},
		getFrameId : function(obj) {
			var xfseljob = $(window.document).find("[seljob]");
			for (var i = 0; i < xfseljob.length; i++) {
				if ($(xfseljob[i]).find("iframe").get(0).contentWindow == obj) {
					return xfseljob[i].id;
				}
			}
			return null;
		}
	}
	function init(target) {
		var model = $("<div seljob ><iframe frameborder=0 style=\"width:100%;height:99%\"></iframe></div>");
		var options = $.data(target, 'seljob').options;
		var defaultCode = options.defaultCode;
		$(document.body).append(model);
		model.dialog(options);
		var totalSelect = options.totalSelect;
//		model.load(CTX + "/job/index?defaultCode=" + defaultCode);
		model.find("iframe").attr("src",CTX + "/sys/component/job/index/"+totalSelect+".xf");
		seljob.addModalDialog(model, options);
		$(target).on("click", function() {
			model.dialog("open");

		});
	}
	
	$.fn.seljob = function(options, param) {
		if (typeof options == 'string') {
			return $.fn.dataexp.methods[options](this, param);
		}
		options = options || {};
		return this.each(function() {
			var state = $.data(this, 'seljob');
			if (state) {
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'seljob', {
					options : $.extend({}, $.fn.seljob.defaults, options)
				});
				init(this);
			}

		});
		// return this;
	};

	$.fn.seljob.methods = {
		options : function(jq) {
			return $.data(jq[0], 'menu').options;
		}
	};
	$.fn.seljob.defaults = {
		autoOpen : false,
		width : 865,
		height:950,
		totalSelect:3
	};
})(jQuery);
