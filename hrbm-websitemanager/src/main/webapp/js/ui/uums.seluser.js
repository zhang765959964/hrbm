
/**
 * wanghan
 */

(function($,win){
	
	function init(target){
		
		var opts = $.data(target, 'seluser').options;
		win.selUserCallBack=opts.callback;
		bindItem(target,opts)
		
		
	}
	
	function bindItem(target,opts){
		$(target).bind("click",function(){
			seluser(opts);
		})
		
	}
	
	function seluser(opts){	
		xfui.open_dialog({    
		    title: "引入人员",    
		    width: 600,    
		    height: 300,    
		    closed: false,    
		    cache: false,    
		    url: CTX+"/sys/component/uums/selDeptUser.xf",
		    modal: true   
		})
	}

	
	$.fn.seluser = function(options, param){
		if (typeof options == 'string'){
			return $.fn.seluser.methods[options](this, param);
		}
		
		options = options || {};
		return this.each(function(){			
			var state = $.data(this, 'seluser');
			if (state){
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'seluser', {
					options: $.extend({}, $.fn.seluser.defaults, $.fn.seluser.parseOptions(this), options)
				});
				init(this);
			}
			
		});
	};
	
	$.fn.seluser.methods = {
		options: function(jq){
			return $.data(jq[0], 'menu').options;
		}
	};
	
	$.fn.seluser.parseOptions = function(target){
		return $.extend({}, $.parser.parseOptions(target, [
		     {minWidth:'number',itemHeight:'number',duration:'number',hideOnUnhover:'boolean'},
		     {fit:'boolean',inline:'boolean',noline:'boolean'}
		]));
	};
	
	$.fn.seluser.defaults = {
	};
})(jQuery,window);
