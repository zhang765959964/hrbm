
/**
 * wanghan
 */
(function($){
	function init(target){
		var model=$("<div class=\"modal-box\"  >"
			+"<div class=\"inner\"  >"
			+"	<button class=\"close\">×</button>"
			+"   <div class=\"embed-responsive embed-responsive-16by9\"  >"
			+"   </div>"
			+" </div>"
			+"</div>");
		var opts = $.data(target, 'xfdialog').options;
		var url=opts.url;
		$(document.body).append(model);
		$(target).on("click focus",function(){
			$(model).find(".embed-responsive").load(url,function(){
				$(model).modalBox("open", {
					openAnimationEffect: 'rollIn',
					closeAnimationEffect: 'rollOut'
				});
			})

		});
	}
	$.fn.xfdialog= function(options, param){
		if (typeof options == 'string'){
			return $.fn.dataexp.methods[options](this, param);
		}
		options = options || {};
		return this.each(function(){
			var state = $.data(this, 'xfdialog');
			if (state){
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'xfdialog', {
					options: $.extend({}, $.fn.xfdialog.defaults, options)
				});
				init(this);
			}

		});
		//return this;
	};

	$.fn.xfdialog.methods = {
		options: function(jq){
			return $.data(jq[0], 'menu').options;
		}
	};
	$.fn.xfdialog.defaults = {

	};
})(jQuery);
