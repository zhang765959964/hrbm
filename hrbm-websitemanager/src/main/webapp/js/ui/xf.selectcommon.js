/**
 * 通用人员基本信息选择组件 wanghan
 */
(function($) {
	function init(target) {



		var searchbutton=$("<a href=\"javascript:void(0)\"  class=\"btn btn-primary singleSearchBtn\"><i class=\"icon-search\"></i>查询</a>");
		//var resetbutton=$("<a href=\"#modal-form\" role=\"button\" class=\"btn btn-primary btn-border1\" >重置</a>");
		var buttonDiv=$("<div class=\"fl\"></div>");

		buttonDiv.append(searchbutton);
		var opts = $.data(target, 'selectcommon').options;
		var columns=opts.columns;
		var th="";
		$.each(columns,function(i,e){
			th=th+"<th class=\"sid\">"+e.title+"</th>";
		})
		//buttonDiv.append(resetbutton);
		$(target).parent().after(buttonDiv);
		var personData=$("<div class=\"pa bd moreResult\" style=\"display:none\"><table class=\"srtable\"><thead><tr>"+th+"</tr></thead><tbody></tbody></table></div>");
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
		 $(document).on('click.selectcommon' , function(){
        	
        	personData.hide();
        })
         $(window.parent.document).on('click.selectcommon' , function(){
        	
        	personData.hide();
        	
        })
	}

	function searchData(target,personData){

		var searchValue=$(target).val().trim();
		if(!searchValue){
			bootbox.alert("请输入查询条件");
			return;
		}
		var opts = $.data(target, 'selectcommon').options;
		var columns=opts.columns;
		$.ajax({
			type:"get",
			url:opts.url,
			data: {searchValue:searchValue},
            dataType: "json",
            success: function(data){
                        $(personData).find("tbody").empty();   //清空resText里面的所有内容
                        if(data.length==0){
                   		 	if ($.isFunction(opts.callBack)) {
                  				opts.callBack("");
                  			 }
	                   	}else if(data.length==1){
	                   		 if ($.isFunction(opts.callBack)) {
	                  				opts.callBack(data[0]);
	                  		 }
	                   	}else{
	                   		$.each(data, function(commentIndex, comment){
	                        	var td="";
	                    		$.each(columns,function(i,e){
	                    			var valu = "";
	                    			if(!comment[e.field] || comment[e.field]=="undefined"){
                						valu = "无";
                					}else{
                						valu = comment[e.field] ;
                					}
	                    			td = td+"<td class=\"sid\">" + valu +"</td>";
	                    		})
	                              var liEle = $("<tr>"+td+"</tr>");
	                              $(liEle).on("click",function(){
	                            	  if ($.isFunction(opts.callBack)) {
		                      				opts.callBack(comment);
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



	$.fn.selectcommon = function(options, param) {
		if (typeof options == 'string') {
			return $.fn.dataexp.methods[options](this, param);
		}
		options = options || {};
		return this.each(function() {
			var state = $.data(this, 'selectcommon');
			if (state) {
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'selectcommon', {
					options : $.extend({}, $.fn.selectcommon.defaults, options)
				});
				init(this);
			}

		});
		// return this;
	};

	$.fn.selectcommon.methods = {
		options : function(jq) {
			return $.data(jq[0], 'menu').options;
		}
	};
	$.fn.selectcommon.defaults = {
		autoOpen : false,
		width : 865,
		height:950
	};
})(jQuery);
