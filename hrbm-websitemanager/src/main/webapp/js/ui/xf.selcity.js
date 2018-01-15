/**
 * 通用地区选择组件
 * wanghan
 */
(function($){
	window.selcity={
			callBack:function(targetId,data){
				var opts = $("#"+targetId).selcity('getOptions');
				cityDiv=opts.cityDiv;
				$(cityDiv).hide();
				if ($.isFunction(opts.callBack)) {
					opts.callBack(data);
				}
	    	  }
	}
	function init(target){
		var opts = $.data(target, 'selcity').options;
		var defaultCode=opts.defaultCode;
		var targetId=$(target).attr("id")
        
        var cityDiv=$("<div class=\"areaWrap tabbable dnn\" ></div>");
		opts.cityDiv=cityDiv;
		$(target).after(cityDiv);
		$(target).after("<i class=\"icon-sort-down arrowDown\"></i>"); 
		$(cityDiv).load(CTX+"/city/index.xf?defaultCode="+defaultCode+"&targetId="+targetId)	;	
		$(target).on("click",function(){
			cityDiv.toggle();
		});
		
	}
	
	$.fn.selcity= function(options, param){
		if (typeof options == 'string'){
			return $.fn.selcity.methods[options](this, param);
		}
		options = options || {};
		return this.each(function(){
			var state = $.data(this, 'selcity');
			if (state){
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'selcity', {
					options: $.extend({}, $.fn.selcity.defaults, options)
				});
				init(this);
			}

		});
		//return this;
	};

	$.fn.selcity.methods = {
			getOptions: function(jq){
			return $.data(jq[0], 'selcity').options;
		}
	};
	$.fn.selcity.defaults = {

	};
})(jQuery);
