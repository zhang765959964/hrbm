/**
 * 通用人员基本信息选择组件 wanghan
 */
(function($) {
	function init(target) {



		var searchbutton=$("<a href=\"javascript:void(0)\"  class=\"btn btn-primary singleSearchBtn\"><i class=\"icon-search\"></i>查询</a>");
		//var resetbutton=$("<a href=\"#modal-form\" role=\"button\" class=\"btn btn-primary btn-border1\" >重置</a>");
		var buttonDiv=$("<div class=\"fl\"></div>");

		buttonDiv.append(searchbutton);
		//buttonDiv.append(resetbutton);
		$(target).parent().after(buttonDiv);
		var personData=$("<div class=\"pa bd moreResult\" style=\"display:none\"><table class=\"srtable\"><thead><tr><th class=\"sname\">单位名称</th><th class=\"sid\">区域</th></tr></thead><tbody></tbody></table></div>");
		$(target).after(personData);
		$(searchbutton).on("click",function(){
			searchData(target,personData);

		})
		$(target).on("keypress",function(event){
			if(event.keyCode == "13")    
            {
				searchData(target,personData);
            }
		})
	}

	function searchData(target,personData){

		var searchValue=$(target).val();
		if(!searchValue){
			bootbox.alert("请输入查询条件");
			return;
		}
		var opts = $.data(target, 'selectcorp').options;
		$.ajax({
			type:"post",
			url:CTX+"/sys/component/uums/selCorp.xf",
			data: {searchValue:searchValue},
            dataType: "json",
            success: function(data){
                        $(personData).find("tbody").empty();   //清空resText里面的所有内容
                        if(data.length==0){
                   		 if ($.isFunction(opts.callBack)) {
                  				opts.callBack("",{});
                  			   }
		                   	}else if(data.length==1){
		                   		 if ($.isFunction(opts.callBack)) {
		                  				opts.callBack(data[0].aab001,{uaNo:data[0].uaNo||""});
		                  			   }
		                   	}else{
		                        $.each(data, function(commentIndex, comment){
		                        	//
		                        	    var liEle = $("<tr><td class=\"sname\">"+comment.aab004+"</td><td class=\"sid\">"+comment.aae006+"</td></tr>");
		                        	          $(liEle).on("click",function(){
		                        	              if ($.isFunction(opts.callBack)) {
		                        	                opts.callBack(comment.aab001,{uaNo:comment.uaNo||""});
		                        	                personData.hide();
		                        	               }
		                        	           })
		                        	     $(personData).find("tbody").append(liEle);

		                        	 });
		                         personData.show();		                   		
		                   	}

                     }
		})
	}

	$.fn.selectcorp = function(options, param) {
		if (typeof options == 'string') {
			return $.fn.dataexp.methods[options](this, param);
		}
		options = options || {};
		return this.each(function() {
			var state = $.data(this, 'selectcorp');
			if (state) {
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'selectcorp', {
					options : $.extend({}, $.fn.selectcorp.defaults, options)
				});
				init(this);
			}

		});
		// return this;
	};

	$.fn.selectcorp.methods = {
		options : function(jq) {
			return $.data(jq[0], 'menu').options;
		}
	};
	$.fn.selectcorp.defaults = {
		autoOpen : false,
		width : 865,
		height:950
	};
})(jQuery);
