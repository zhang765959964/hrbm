/**
 * 通用地区选择组件
 * wanghan
 */
(function($){
	window.treeorg={
			callBack:function(targetId,data){
				var opts = $("#"+targetId).treeorg('getOptions');
				orgDiv=opts.orgDiv;
				$(orgDiv).hide();
				if ($.isFunction(opts.callBack)) {
					opts.callBack(data);
				}
	    	  }
	}

	function init(target){
		 var setting = {
					async : {
						enable : true,
						type : "GET",
						url : function(treeId, node) {
							return CTX+"/sys/uums/sysOrg/treeJson.xf";
						},
						dataFilter : function(treeId, parentNode, childNodes) {
							return childNodes;
						}
					},
					data: {
						simpleData: {
							enable: true,
							idKey: "id",
							pIdKey: "pId",
							rootPId: 0
						}
					},
					check : {
						enable : true,
						chkboxType : {"Y":"s","N":"s"},
						chkStyle : "checkbox",
						radioType : "all"
					}

				}
		var opts = $.data(target, 'treeorg').options;
		var defaultCode=opts.defaultCode;
		var targetId=$(target).attr("id")
        
        var orgDiv=$("<div class=\"ztreeWrap dnn ztree\" ></div>");
		var treeUi=$("<ul class=\"ztreeUl\" id=\"articleColumnTree\" data-toggle=\"context\" ></ul>");
		var buttonDiv=$("<div class=\"ztree-check-btn\"></div>")
		var confirmA=$("<a href=\"javascript:void(0)\" role=\"button\"  class=\"btn btn-primary btn-border1 \">确定</a>");
		var cancelA=$("<a href=\"javascript:void(0)\" role=\"button\"  class=\"btn btn-info\">取消</a>");	
		opts.orgDiv=orgDiv;
		$(target).after(orgDiv);
		$(target).after("<i class=\"icon-sort-down arrowDown\"></i>"); 

		$(target).on("click",function(){
			orgDiv.toggle();
		});
		$(confirmA).on("click",function(){
			setOrgNode(opts);
			orgDiv.toggle();
		});
		$(cancelA).on("click",function(){
			orgDiv.toggle();
		});
		buttonDiv.append(confirmA);
		buttonDiv.append(cancelA);
		orgDiv.append(treeUi);
		orgDiv.append(buttonDiv);
		$.fn.zTree.init($(treeUi), setting);
	}
	function  setOrgNode(opts){
		var treeObj = $.fn.zTree.getZTreeObj("articleColumnTree");
		var nodes = treeObj.getCheckedNodes(true);
		var orgId="";
		var orgName="";
		var j=0;
		$.each(nodes,function(i,e){
            if(e.id==0){
            	
            }else if(j==0){
				orgId+=e.id;
				orgName+=e.name;
				j++;
			}else{
				orgId+=","+e.id;
				orgName+=","+e.name;
				j++;
			}
		})
		if ($.isFunction(opts.callBack)) {
					opts.callBack({orgId:orgId,orgName:orgName});
		}
	 }
	$.fn.treeorg= function(options, param){
		if (typeof options == 'string'){
			return $.fn.treeorg.methods[options](this, param);
		}
		options = options || {};
		return this.each(function(){
			var state = $.data(this, 'treeorg');
			if (state){
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'treeorg', {
					options: $.extend({}, $.fn.treeorg.defaults, options)
				});
				init(this);
			}

		});
		//return this;
	};

	$.fn.treeorg.methods = {
			getOptions: function(jq){
			return $.data(jq[0], 'treeorg').options;
		}
	};
	$.fn.treeorg.defaults = {

	};
})(jQuery);
