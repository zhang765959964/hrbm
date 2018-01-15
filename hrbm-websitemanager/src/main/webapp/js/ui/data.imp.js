
/**
 * 导出数据
 * wanghan
 */
(function($){
	
	window.dataimp={
			getColumnArray:function(targetId){
				var opts = $("#"+targetId).dataimp('getOptions');
				var columnArray=opts.columns;
				if(!columnArray||columnArray.length<=0){
					var gridId=opts.gridId;
					var columnArray = $("#"+gridId).jqGrid("getGridParam","colModel"); 
				}
				var columns =JSON.stringify(columnArray);
				return columns;
	    	  }
	}
	function init(target){
		var opts = $.data(target, 'dataimp').options;
		bindItem(target,opts)
		
	}
	
	function bindItem(target,opts){
		
		$(target).bind("click",function(){
			dataimp(opts,$(this).attr("id"));
		})
		
	}
	
	function dataimp(opts,targetId){	
		xfui.open_dialog({    
  		    title: '数据导入',    
  		    width: 450,    
  		    height: 250,    
  		    closed: false,    
  		    cache: false,    
  		    url: CTX+"/sys/component/data/import.xf?serviceId="+opts.serviceId+"&targetId="+targetId,
  		    modal: true   
  		})
		
		
	}
	function datadown(opts){
		var frm=new com.xunfeng.form.Form();
		frm.creatForm("impDataForm",CTX+"/sys/component/data/tempDown.xf");
		frm.setMethod("post");
		frm.addFormEl("tempFileName",opts.tempFileName);		
		frm.submit();
		frm.clearFormEl();
		
	}
	
	$.fn.dataimp = function(options, param){
		if (typeof options == 'string'){
			return $.fn.dataimp.methods[options](this, param);
		}
		
		options = options || {};
		return this.each(function(){	
			var state = $.data(this, 'dataimp');
			if (state){
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'dataimp', {
					options: $.extend({}, $.fn.dataimp.defaults,  options)
				});
				init(this);
			}
			
		});
	};
	
	$.fn.dataimp.methods = {
		getOptions: function(jq){
			return $.data(jq[0], 'dataimp').options;
		}
	};
	
	
	$.fn.dataimp.defaults = {
			expType:0,
			tempFileName:"test.xls"
	};
})(jQuery);
