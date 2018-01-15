
/**
 * 导出数据
 * wanghan
 * <ul class="dropdown-menu" role="menu">
								<li><a href="javascript:void(0)">导出选中内容</a></li>
								<li><a href="javascript:void(0)">导出当前页</a></li>
								<li><a href="javascript:void(0)">导出所有记录</a></li>
							</ul>
 */
(function($){
	
	function init(target){
		var opts = $.data(target, 'dataexp').options;
		var menuItem=opts.menuItem;
		var $menu=$("<ul class=\"dropdown-menu\" role=\"menu\"></ul>");
		$.each(menuItem,function(i,e){
			var $itemHtml=$("<li><a href=\"javascript:void(0)\">"+e.title+"</a></li>");
			$itemHtml.appendTo($menu);
		})
		$(target).after($menu);
		$menu.find("li").each(function(i,e){
			bindItem(i,$(e),opts)
		})
	}
	
	function bindItem(itemNum,target,opts){
		$(target).bind("click",function(){
			dataExp(itemNum,opts);
		})
	}
	
	function dataExp(itemNum,opts){
		var columnArray=opts.columns;
		if(!columnArray||columnArray.length<=0){
			var gridId=opts.gridId;
		    columnArray=[];
			var oldColumnArray = $("#"+gridId).jqGrid("getGridParam","colModel");
			$.each(oldColumnArray,function(i,e){
				if(e.colmenu){
					columnArray.push(e);	
				}
			})
		}
		var columns =JSON.stringify(columnArray);
		var menuItem=opts.menuItem[itemNum];
		var frm=new com.xunfeng.form.Form();
		frm.creatForm("expDataForm",CTX+"/sys/component/data/export.xf");
		frm.setMethod("post");
		frm.addFormEl("serviceId",opts.serviceId);
		frm.addFormEl("sheetName",opts.sheetName);
		frm.addFormEl("fileName",opts.fileName);
		frm.addFormEl("columns",columns);
		if($.isFunction(menuItem.paramCallBack) ){
			var param=menuItem.paramCallBack();
			if(param===false){
				return;
			}
			for(var key in param){
				frm.addFormEl(key,param[key]);
			}
		}
		frm.addFormEl("expType",opts.expType);		
		frm.submit();
		frm.clearFormEl();
		
	}
	
	$.fn.dataexp = function(options, param){
		if (typeof options == 'string'){
			return $.fn.dataexp.methods[options](this, param);
		}
		
		options = options || {};
		return this.each(function(){			
			var state = $.data(this, 'dataexp');
			if (state){
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'dataexp', {
					options: $.extend({}, $.fn.dataexp.defaults, options)
				});
				init(this);
			}
			
		});
	};
	
	$.fn.dataexp.methods = {
		options: function(jq){
			return $.data(jq[0], 'dataexp').options;
		}
	};

	
	$.fn.dataexp.defaults = {
			expType:0,
			sheetName:"工作薄",
			fileName:"数据导出文件",
			menuItem:[{name:"导出全部数据"},
                      {name:"导出选中的数据"},
	                  {name:"导出当前页数据"}
                     ]
	};
})(jQuery);
