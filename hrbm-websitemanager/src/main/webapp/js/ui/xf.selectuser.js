/**
 * 通用人员基本信息选择组件 wanghan
 */
(function($) {
	function init(target) {



		var searchbutton=$("<a href=\"javascript:void(0)\"  class=\"btn btn-primary singleSearchBtn\"><i class=\"icon-search \"></i>查询</a>");
		//var resetbutton=$("<a href=\"#modal-form\" role=\"button\" class=\"btn btn-primary btn-border1\" >重置</a>");
		var buttonDiv=$("<div class=\"fl\"></div>");

		buttonDiv.append(searchbutton);
		//buttonDiv.append(resetbutton);
		$(target).parent().after(buttonDiv);
		var personData=$("<div class=\"pa bd moreResult\" style=\"display:none\"><table class=\"srtable\"><thead><tr><th class=\"sid\">身份证号</th><th class=\"sname\">姓名</th><th class=\"ssex\">性别</th></tr></thead><tbody></tbody></table></div>");
		$(target).after(personData);
		$(searchbutton).on("click",function(){
			searchData(target,personData);

		})
		
		$(target).on("keypress",function(event){
			
			if(event.keyCode == "13")    
            {
				searchData(target,personData);
            }
		});

        $(document).on('click.selectuser' , function(){
        	
        	personData.hide();
        })
         $(window.parent.document).on('click.selectuser' , function(){
        	
        	personData.hide();
        })
	}

	function searchData(target,personData){

		var searchValue=$(target).val().trim();
//		searchValue=encodeURIComponent(encodeURIComponent(searchValue));
		if(!searchValue){
			bootbox.alert("请输入查询条件");
			return;
		}
		var opts = $.data(target, 'selectuser').options;
		$.ajax({
			type:"post",
			url:CTX+"/sys/component/uums/selUser.xf",
			data: {searchValue:searchValue,hasArch:opts.hasArch},
            dataType: "json",
            success: function(data){
                $(personData).find("tbody").empty();   //清空resText里面的所有内容
            	if(data.length==0){
            		 if ($.isFunction(opts.callBack)) {
           				opts.callBack("");
           			   }
            	}else if(data.length==1){
            		 if ($.isFunction(opts.callBack)) {
           				opts.callBack(data[0].aac001);
           			   }
            	}else{
                    $.each(data, function(commentIndex, comment){
//
                          var liEle = $("<tr><td class=\"sid\">"+comment.aac002+"</td><td class=\"sname\">"+comment.aac003+"</td><td class=\"ssex\">"+comment.aac004+"</td></tr>");
                          $(liEle).on("click",function(){
                        	  if ($.isFunction(opts.callBack)) {
                  				opts.callBack(comment.aac001);
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



	$.fn.selectuser = function(options, param) {
		if (typeof options == 'string') {
			return $.fn.dataexp.methods[options](this, param);
		}
		options = options || {};
		return this.each(function() {
			var state = $.data(this, 'selectuser');
			if (state) {
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'selectuser', {
					options : $.extend({}, $.fn.selectuser.defaults, options)
				});
				init(this);
			}

		});
		// return this;
	};

	$.fn.selectuser.methods = {
		options : function(jq) {
			return $.data(jq[0], 'menu').options;
		}
	};
	$.fn.selectuser.defaults = {
		autoOpen : false,
		width : 865,
		height:950
	};
})(jQuery);
