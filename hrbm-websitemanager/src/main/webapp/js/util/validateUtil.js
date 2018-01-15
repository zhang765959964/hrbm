/*$(function(){
	//验证身份证
	$.extend($.fn.validatebox.defaults.rules, {
	    unId: {
	    	 validator: function(value,param){
	    		var flag = validateIdCard(value);
		         if(flag){
		        	 return true;
		         }
		        },
		        message: '身份证号码有误'
	    }
	});
	//验证是否存在
	  $.extend($.fn.validatebox.defaults.rules, {
			    isExist: {
			    	 validator: function(value,param){
			    		 
				        	var url = param[0];
				        	var data ={};
				        	data[param[1]]=value;
				        	var flag = false;
				        	$.ajax({  
				                url : url,  
				                async : false, // 注意此处需要同步   
				                type : "POST", 
				                data:data,
				                dataType : "json",  
				                success : function(data) {
				                	data.result==0?flag=true:"";
				                	 
				                }  
				            });
				        	if(flag) return true;
				        },
				        message: '已经存在'
			    }
		});  
	  //邮编
	  $.extend($.fn.validatebox.defaults.rules, {
		    postCode: {
		        validator: function(value,param){
		            if(isZipCode(value)) return true;
		        },
		        message: '邮政编码有误！必须是6位数字！'
		    }
		});
	  //扩展easyui表单的验证  
	   $.extend($.fn.validatebox.defaults.rules, {  
		   // 验证姓名，可以是中文或英文  
		   name : {
               validator : function(value) {  
                   return /^[\u0391-\uFFE5]+$/i.test(value) | /^\w+[\w\s]+\w+$/i.test(value);  
               },  
               message : '请输入中文或英文'  
           },  
	       // 电话号码或手机号码
	       phoneAndMobile : {  
              validator : function(value) {  
                  return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value) || /^(13|15|18)\d{9}$/i.test(value);  
              },  
              message : '电话号码或手机号码格式不正确'  
          },
          //银行卡号
          account : {
        	  validator : function(bankno){
        			if (bankno.length < 16 || bankno.length > 19) {
        				return false;
        			}
        			var num = /^\d*$/;  //全数字
        			if (!num.exec(bankno)) {
        				return false;
        			}
        			var strBin="10,18,30,35,37,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,58,60,62,65,68,69,84,87,88,94,95,98,99";    
        			if (strBin.indexOf(bankno.substring(0, 2))== -1) {
        				return false;
        			}
        	        var lastNum=bankno.substr(bankno.length-1,1);//取出最后一位（与luhm进行比较）
        	        var first15Num=bankno.substr(0,bankno.length-1);//前15或18位
        	        var newArr=new Array();
        	        for(var i=first15Num.length-1;i>-1;i--){    //前15或18位倒序存进数组
        	            newArr.push(first15Num.substr(i,1));
        	        }
        	        var arrJiShu=new Array();  //奇数位*2的积 <9
        	        var arrJiShu2=new Array(); //奇数位*2的积 >9
        	        
        	        var arrOuShu=new Array();  //偶数位数组
        	        for(var j=0;j<newArr.length;j++){
        	            if((j+1)%2==1){//奇数位
        	                if(parseInt(newArr[j])*2<9)
        	                arrJiShu.push(parseInt(newArr[j])*2);
        	                else
        	                arrJiShu2.push(parseInt(newArr[j])*2);
        	            }
        	            else //偶数位
        	            arrOuShu.push(newArr[j]);
        	        }
        	        
        	        var jishu_child1=new Array();//奇数位*2 >9 的分割之后的数组个位数
        	        var jishu_child2=new Array();//奇数位*2 >9 的分割之后的数组十位数
        	        for(var h=0;h<arrJiShu2.length;h++){
        	            jishu_child1.push(parseInt(arrJiShu2[h])%10);
        	            jishu_child2.push(parseInt(arrJiShu2[h])/10);
        	        }        
        	        
        	        var sumJiShu=0; //奇数位*2 < 9 的数组之和
        	        var sumOuShu=0; //偶数位数组之和
        	        var sumJiShuChild1=0; //奇数位*2 >9 的分割之后的数组个位数之和
        	        var sumJiShuChild2=0; //奇数位*2 >9 的分割之后的数组十位数之和
        	        var sumTotal=0;
        	        for(var m=0;m<arrJiShu.length;m++){
        	            sumJiShu=sumJiShu+parseInt(arrJiShu[m]);
        	        }
        	        
        	        for(var n=0;n<arrOuShu.length;n++){
        	            sumOuShu=sumOuShu+parseInt(arrOuShu[n]);
        	        }
        	        
        	        for(var p=0;p<jishu_child1.length;p++){
        	            sumJiShuChild1=sumJiShuChild1+parseInt(jishu_child1[p]);
        	            sumJiShuChild2=sumJiShuChild2+parseInt(jishu_child2[p]);
        	        }      
        	        //计算总和
        	        sumTotal=parseInt(sumJiShu)+parseInt(sumOuShu)+parseInt(sumJiShuChild1)+parseInt(sumJiShuChild2);
        	        
        	        //计算Luhm值
        	        var k= parseInt(sumTotal)%10==0?10:parseInt(sumTotal)%10;        
        	        var luhm= 10-k;
        	        
        	        if(lastNum==luhm){
        	        	return true;
        	        }else{
        	        	return false;
        	        }        
        	    },
        	    message : '银行卡号格式不正确'
          }
         
	   });
})*/


/**
 * 验证身份证的正确性
 * @param idCard
 * @returns {Boolean}
 */

function validateIdCard(idCard) {
	//15位和18位身份证号码的正则表达式
	var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
	//如果通过该验证，说明身份证格式正确，但准确性还需计算
	if (regIdCard.test(idCard)) {
		if (idCard.length == 18) {
			var idCardWi = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10,
					5, 8, 4, 2); //将前17位加权因子保存在数组里
			var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2); //这是除以11后，可能产生的11位余数、验证码，也保存成数组
			var idCardWiSum = 0; //用来保存前17位各自乖以加权因子后的总和
			for (var i = 0; i < 17; i++) {
				idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i];
			}
			var idCardMod = idCardWiSum % 11;//计算出校验码所在数组的位置
			var idCardLast = idCard.substring(17);//得到最后一位身份证号码
			//如果等于2，则说明校验码是10，身份证号码最后一位应该是X
			if (idCardMod == 2) {
				if (idCardLast == "X" || idCardLast == "x") {
					return true;
				} else {
					return false;
				}
			} else {
				//用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
				if (idCardLast == idCardY[idCardMod]) {
					return true;
				} else {
					return false;
				}
			}
		}
	} else {
		return false;
	}
}

function isZipCode(zipCode){
		var re= /^[1-9][0-9]{5}$/
		if(re.test(zipCode)) return true;
		return false;
		  
}

/**
 * 验证搜索条件
 */
function validateSearch(){
 
	//开始年龄--结束年龄
	if($("#beginAge").length >0 && $("#endAge").length>0){
		var beginAge = $("#beginAge").numberbox("getValue");
		var endAge = $("#endAge").numberbox("getValue");
		if(beginAge&&endAge&&(beginAge>endAge)){
			$.messager.alert('系统提示','开始年龄不能大于结束年龄！','warning');
			return false;
		}
	}
	//申报日期 
	if($("#beginApplyTime").length >0 && $("#endApplyTime").length>0){
		var beginApplyTime = $("#beginApplyTime").datebox("getValue");
		var endApplyTime = $("#endApplyTime").datebox("getValue")
		
		if(beginApplyTime&&endApplyTime&&(beginApplyTime>endApplyTime)){
			$.messager.alert('系统提示','开始申报时间不能大于结束申报时间！','warning');
			return false;
		}
	}
	
	//退休日期
	if($("#beginProcessTime").length >0 && $("#endProcessTime").length>0){
		var beginProcessTime = $("#beginProcessTime").datebox("getValue");
		var endProcessTime = $("#endProcessTime").datebox("getValue")
		
		if(beginProcessTime&&endProcessTime&&(beginProcessTime>endProcessTime)){
			$.messager.alert('系统提示','开始退休时间不能大于结束开始退休！','warning');
			return false;
		}
	}
	//档案接收
	if($("#beginReceive").length>0 && $("#endReceive").length>0 ){
		 
		var beginReceiveTime = $("#beginReceive").datebox("getValue");
		var endReceiveTime = $("#endReceive").datebox("getValue")
		
		if(beginReceiveTime&&endReceiveTime&&(beginReceiveTime>endReceiveTime)){
			$.messager.alert('系统提示','开始档案接收时间不能大于结束档案接收时间！','warning');
			return false;
		}
	}
	//档案入库
	if($("#beginStorage").length >0&& $("#endStorage").length>0 ){
		 
		var beginStorage = $("#beginStorage").datebox("getValue");
		var endStorage = $("#endStorage").datebox("getValue")
		
		if(beginStorage&&endStorage&&(beginStorage>endStorage)){
			$.messager.alert('系统提示','开始入库时间不能大于结束入库时间！','warning');
			return false;
		}
	}
	//开始年龄--结束年龄
	if($("#beginBirthDate").length >0 && $("#endBirthDate").length>0){
		var beginAge = $("#beginBirthDate").numberbox("getValue");
		var endAge = $("#endBirthDate").numberbox("getValue");
		if(beginAge&&endAge&&(beginAge>endAge)){
			$.messager.alert('系统提示','开始出生日期不能大于结束出生日期！','warning');
			return false;
		}
	}
	return true;
}

