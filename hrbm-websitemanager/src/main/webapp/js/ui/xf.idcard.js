/**
 * 通用人员基本信息选择组件 wanghan
 */
(function($) {
    
	function initOcx(target){
    	    var opts = $.data(target, 'idcard').options;
    	    var cardType=opts.cardType||0;//0:精伦;1:德卡
    	    if(cardType==0){
    	    	var Ctl_Object=$("#IdrControl1");
        		if(!Ctl_Object.get(0)){
        			$(document.body).append($("<object classid=\"clsid:5EB842AE-5C49-4FD8-8CE9-77D4AF9FD4FF\" id=\"IdrControl1\" width=\"0\" height=\"0\" codebase=\"idr.cab\"></object>"));
        			
        		}
    	    }else if(cardType==1){
    	    	var Ctl_Object=$("#Ctl");
        		if(!Ctl_Object.get(0)){
        			$(document.body).append($("<OBJECT ID=\"Ctl\" WIDTH=\"0\" HEIGHT=\"0\" CLASSID=\"CLSID:2B44A159-C1D6-4ED2-A3E6-0FD1708ADE09\"></OBJECT>"));
        			
        		}
    	    }
    		
    	
    }
    function readCard( cardType){

    	 cardType=cardType||0;
    	 var idcardObject={};
    	 var nationCode ;
    	if(cardType==0){
    		result=IdrControl1.ReadCard("1001","d:\\test\\test.jpg");
    		idcardObject.aac003=IdrControl1.GetName();	//获得身份证信息个人姓名
    		idcardObject.aac004=IdrControl1.GetSex();	//获得身份证个人性别信息 1 男 2 女
    		if(IdrControl1.GetFolkN()<=9){				//获得身份证信息个人民族 数字
    			idcardObject.aac005 = showNation(IdrControl1.GetFolkN());
    		}else{
    			idcardObject.aac005 = IdrControl1.GetFolkN();
    		}
    		idcardObject.aac006=IdrControl1.GetBirthYear()+"-"+IdrControl1.GetBirthMonth()+"-"+IdrControl1.GetBirthDay();
    		idcardObject.aac002=IdrControl1.GetCode();	//获得身份证个人身份证号信息
    		idcardObject.expCardNumber =IdrControl1.GetAddress();	//获得身份证个人地址信息
    		idcardObject.base64img=IdrControl1.GetJPGPhotobuf();
    		
    	}else if(cardType==1){
			SS_AX_IDR_Open();
			var idcardStr=SS_AX_IDR_Read();
			//SS_AX_IDR_Close();
			var idcardArry=idcardStr.split("|");
			var idcardObject={};
			idcardObject.aac003=idcardArry[0];
			idcardObject.aac004=idcardArry[1];
			idcardObject.aac005=idcardArry[2];
			idcardObject.aac006=getBirthdayFromIdCard(idcardArry[5]);
			idcardObject.aac002=idcardArry[5];
			idcardObject.expCardNumber = idcardArry[6];
    	}
    	console.info(idcardObject);
		return idcardObject;
    }
	function init(target) {
		initOcx(target) 
		$(target).on("click",function(event){
			var opts = $.data(target, 'idcard').options;
			var idcardObject=readCard( opts.cardType)
			$.ajax({
				type:"post",
				url:CTX+"/sys/component/uums/selUser.xf",
				data: {searchValue:idcardObject.aac002},
	            dataType: "json",
	            success: function(data){
	            	console.info(data);
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
	
	$.fn.idcard = function(options, param) {
		if (typeof options == 'string') {
			return $.fn.idcard.methods[options](this, param);
		}
		options = options || {};
		return this.each(function() {
			var state = $.data(this, 'idcard');
			if (state) {
				$.extend(state.options, options);
			} else {
				state = $.data(this, 'idcard', {
					options : $.extend({}, $.fn.idcard.defaults, options)
				});
				init(this);
			}

		});
		// return this;
	};

	$.fn.idcard.methods = {
		options : function(jq) {
			return $.data(jq[0], 'menu').options;
		}
	};
	$.fn.idcard.defaults = {
		autoOpen : false,
		width : 865,
		height:950
	};
	function SS_AX_IDR_Open()
	{
		var pVal;
		pVal = Ctl.SS_AX_IDR_Open();
		showMsg('ret：'+pVal);
		showError(pVal);
	}

	function SS_AX_IDR_Read()
	{
		var pVal;
		pVal = Ctl.SS_AX_IDR_Read();
		showMsg('ret：'+pVal);
		showError(pVal);
		showMsg('IDR_IDInfo:' + Ctl.IDR_IDInfo)
		return Ctl.IDR_IDInfo;
	}
	
	function SS_AX_IDR_CancelRead()
	{
		var pVal;
		pVal = Ctl.SS_AX_IDR_CancelRead();
		showMsg('ret：'+pVal);
		showError(pVal);
	}

	function SS_AX_IDR_Close()
	{
		var pVal;
		pVal = Ctl.SS_AX_IDR_Close();
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
	//返回民族编号  读卡器返回1 字典表存01 
	function showNation(code){
		switch (code){
			case 1:
				return "01"
				break;
			case 2:
				return "02";
				break;
			case 3:
				return "03";
				break;
			case 4:
				return "04";
				break;
			case 5:
				return "05";
				break;
			case 6:
				return "06";
				break;
			case 7:
				return "07";
				break;
			case 8:
				return "08";
				break;
			case 9:
				return "09";
				break;
		}
		
	}
	
})(jQuery);
