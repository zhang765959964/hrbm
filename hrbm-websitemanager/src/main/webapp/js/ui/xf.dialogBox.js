/**
 * 日期组件 wanghan
 */
(function($) {
	var dialogBoxDiv = $("<div style=\"display:none\"> <iframe frameborder=0 style=\"width:100%;height:95%\"></iframe> </div>");
	     
    window.dialogBoxDiv={
    		closePage:function(){
    			dialogBoxDiv.dialog("close");
    		}
    }
	$(function() {
		$(document.body).append(dialogBoxDiv);
		// dialogBoxDiv.dialog(defaults);
	})
	var defaults = {
		autoOpen : false,
		width : 400,
		modal: true,
		buttons : [ {
			text : "确定",
			click : function() {
				$(this).dialog("close");
			}
		}, {
			text : "取消",
			click : function() {
				$(this).dialog("close");
			}
		} ]
	};

	var dialogBox = function(options) {
		var options = $.extend(defaults, options);
		dialogBoxDiv.dialog(options);
		if (options && options.url) {
			dialogBoxDiv.find("iframe").attr("src",options.url);
			
			dialogBoxDiv.dialog("open");
		} else {
			dialogBoxDiv.dialog("open");
		}
	};

	$.extend({
		dialogBox : dialogBox
	});
})(jQuery);
