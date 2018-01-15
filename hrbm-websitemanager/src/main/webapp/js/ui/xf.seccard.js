/**
 * 通用人员基本信息选择组件 wanghan
 */
(function($) {
	$(function(){
		var Ctl_Object=$("#Ctl");
		if(!Ctl_Object.get(0)){
			$(document.body).append($("<OBJECT ID=\"Ctl\" WIDTH=\"0\" HEIGHT=\"0\" CLASSID=\"CLSID:2B44A159-C1D6-4ED2-A3E6-0FD1708ADE09\"></OBJECT>"));
		}
	})
	function init(target) {

		$(target).on("click",function(event){
			var opts = $.data(target, 'seccard').options;
			SS_AX_CRD_Open();
			var seccardStr=SS_AX_CRD_CHIPIO();
			//SS_AX_IDR_Close();
			//alert(seccardStr)
			var seccardArry=seccardStr.split("|");
			var idcardObject={};
			idcardObject.aac003=seccardArry[4];
			idcardObject.aac004=seccardArry[5];
			idcardObject.aac005=seccardArry[6];
			idcardObject.aac006=getBirthdayFromIdCard(seccardArry[3]);
			idcardObject.aac002=seccardArry[3];
			$.ajax({
				type:"post",
				url:CTX+"/sys/component/uums/selUser.xf",
				data: {searchValue:seccardArry[3]},
	            dataType: "json",
	            success: function(data){
	                //$(personData).find("tbody").empty();   //清空resText里面的所有内容
	            	if(data.length==0){
	            		 if ($.isFunction(opts.callBack)) {
	           				opts.callBack("",idcardObject);
	           			   }
	            	}else if(data.length==1){
	            		 if ($.isFunction(opts.callBack)) {
	           				opts.callBack(data[0].aac001,idcardObject);
	           			   }
	            	}else{
	            	 }
	            	

	            }
			})
		})
		$(target).addClass("btn-info");
	}
	
	$.fn.seccard = function(options, param) {
		if (typeof options == 'string') {
			return $.fn.seccard.methods[options](this, param);
		}
		options = options || {};
		return this.each(function() {
			var state = $.data(this, 'seccard');
			if (state) {
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'seccard', {
					options : $.extend({}, $.fn.seccard.defaults, options)
				});
				init(this);
			}

		});
		// return this;
	};

	$.fn.seccard.methods = {
		options : function(jq) {
			return $.data(jq[0], 'menu').options;
		}
	};
	$.fn.seccard.defaults = {
		autoOpen : false,
		width : 865,
		height:950
	};
	function SS_AX_CRD_Open()
	{
		var pVal;
		pVal = Ctl.SS_AX_CRD_Open();
		showMsg('ret：'+pVal);
		showError(pVal);
	}

	function SS_AX_CRD_Reset()
	{
		var pVal;
		pVal = Ctl.SS_AX_CRD_Reset();
		showMsg('ret：'+pVal);
		showError(pVal);
		showMsg('CRD_ATR:' + Ctl.CRD_ATR)
	}
	
	function SS_AX_CRD_CHIPIO()
	{
		var pVal;
		pVal = Ctl.SS_AX_SSSE_CRD_ReadBaseInfo();
		showMsg('ret：'+pVal);
		showError(pVal);
		showMsg('CRD_CHIPIO:' + Ctl.SSSE_INFO)
		return Ctl.SSSE_INFO;
	}

	function SS_AX_CRD_Close()
	{
		var pVal;
		pVal = Ctl.SS_AX_CRD_Close();
		showMsg('ret：'+pVal);
		showError(pVal);
	}
	function showMsg(msg) {
		console.log(msg);
	}
	function showError(errorcode) {
		switch(errorcode)
		{
			case 0:
				showMsg(errorcode+':'+'操作成功');
				break;
			case -2:
				showMsg(errorcode+':'+'操作超时');
				break;
			case -3:
				showMsg(errorcode+':'+'硬件故障');
				break;
			case -4:
				showMsg(errorcode+':'+'给出的要保存到的图片路径无效');
				break;
			case -6:
				showMsg(errorcode+':'+'设备已关闭');
				break;
			case -7:
				showMsg(errorcode+':'+'操作被取消');
				break;
			case -10001:
				showMsg(errorcode+':'+'读取到的IC卡数据有问题');
				break;
			case -20002:
				showMsg(errorcode+':'+'给出的特征码无效');
				break;
			case -20003:
				showMsg(errorcode+':'+'给出的模板值无效');
				break;
			case -40021:
				showMsg(errorcode+':'+'无卡可读');
				break;
			case -60021:
				showMsg(errorcode+':'+'无卡可读');
				break;
			case -60023:
				showMsg(errorcode+':'+'读写失败');
				break;
			case -99999:
				showMsg(errorcode+':'+'其他错误');
				break;
		}
	}
})(jQuery);
