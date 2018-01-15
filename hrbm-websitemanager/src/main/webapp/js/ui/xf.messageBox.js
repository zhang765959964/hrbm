
/**
 * 日期组件
 * wanghan
 */
(function($){
	var messageDiv=$("<div id=\"messageDia\"></div>");
	var confirmDiv=$("<div id=\"confirmDia\"></div>");
    $(function(){
    	$(document.body).append(messageDiv);
    	$(document.body).append(confirmDiv);
    }) 
    var defaults={
			type: 'correct',  //three type:'normal'(default),'correct','error',
			width: 200,
			height: 150,
			hasMask: true,
			hasClose: true,
			hasBtn: true,
			confirmValue:'我知道了',
			effect: 'sign',
			title: '提示框',
			content: '保存成功'
	};
	 var messageBox = function(options){

		var options=$.extend(defaults,options);
		return $("#messageDia").dialogBox(options);
	};
	
	    var confirmDefaults={
				type: 'normal',  //three type:'normal'(default),'correct','error',
				width: 300,
				height: 150,
				hasClose: true,
				hasBtn: true,
				title: '提示'
		};
	    
	 var confirmBox = function(options){
		 if(options&&options.callback){
			 confirmDefaults.confirm=options.callback;
		 }
		 if(options&&options.msg){
			 confirmDefaults.content=options.msg;
		 }
		 
		var options=$.extend(confirmDefaults,options,{confirmValue: '确定',cancelValue: '取消'});
		return $("#confirmDia").dialogBox(options);
	};

	$.extend({
		messageBox: messageBox,confirmBox:confirmBox
	 });
})(jQuery);
