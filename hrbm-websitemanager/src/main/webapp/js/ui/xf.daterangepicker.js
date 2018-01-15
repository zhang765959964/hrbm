
/**
 * 日期组件
 * wanghan
 */
(function($){
	$.fn.xfdaterangepicker = function(options, callback){
		var thisLocale
		if(options.locale){
			var thisLocale=$.extend({},$.fn.xfdaterangepicker.defaults.locale,options.locale);
		}
		var initDate=$.extend({},$.fn.xfdaterangepicker.defaults,options);
		if(thisLocale){
			initDate.locale=thisLocale;
		}
		
		if(!options.autoUpdateInput){
			$(this).on('apply.daterangepicker', function(ev, picker) {
	            $(this).val(picker.startDate.format(options.locale.format));
	              if(options.formValidatorId){
	            	  var bootstrapValidator = $("#"+options.formValidatorId).data('bootstrapValidator'); 
	            	  var startDate=$(this).attr("name");
					  bootstrapValidator.updateStatus(startDate, 'NOT_VALIDATED').validateField(startDate);  
	              }
	             
	        });
			$(this).on('cancel.daterangepicker', function(ev, picker) {
                $(this).val('');
            });
		}
		return $(this).daterangepicker(initDate, callback);
		
	};
	
	$.fn.xfdaterangepicker.defaults = {
		autoUpdateInput:true,	
		singleDatePicker: true,
		"showDropdowns": true,
		"timePickerIncrement": 1,
		"locale": {
			"format": "YYYY-MM-DD",
			"separator": " - ",
			"applyLabel": "确定",
			"cancelLabel": "取消",
			"fromLabel": "From",
			"toLabel": "To",
			"customRangeLabel": "Custom",
			"daysOfWeek": [
				"日",
				"一",
				"二",
				"三",
				"四",
				"五",
				"六"
			],
			"monthNames": [
				"1 	",
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"11",
				"12"
			],
			"firstDay": 1
		},
		"parentEl": "body",
		"opens": "left",
		"drops": "down",
		"buttonClasses": "btn btn-sm",
		"applyClass": "btn-success",
		"cancelClass": "btn-default"
	};
})(jQuery);
