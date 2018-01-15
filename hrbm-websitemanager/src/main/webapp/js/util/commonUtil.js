//内容过长时，截取内容，后边加上省略号
function cutValue(value,length){
	var length=length||20
	if(value.length<length){
		return value;
	}
	return value.substr(0,length)+"...";
}

function  resetForm(fromId){
	$("#"+fromId)[0].reset();
	$("#"+fromId+" input:hidden").val("");
}
//保留隐藏域
function  resetFormNotHide(fromId){
	//$("input:text,textarea,select ",$("#"+fromId)).val("");
	$("#"+fromId)[0].reset();
}

// 高级查询 更多查询内容切换
function toggleMore(ope,obj){
	$("." + ope).toggle();
	$(obj).children("i").toggleClass("icon-plus");
	$(obj).children("i").toggleClass("icon-minus");
}

function collapseWrap(elemId,obj){
	$("#" + elemId).slideToggle(300);
	$(obj).children("i").toggleClass("icon-double-angle-down");
	$(obj).children("i").toggleClass("icon-double-angle-up");
	$(obj).children("span.collapse-tip").toggleClass("dn");
	if($(obj).parents(".moduleWrapNobg")){
		$(obj).parents(".moduleWrapNobg").toggleClass("change-bg");	
	}
	else if($(obj).parents(".moduleWrap")){
		$(obj).parents(".moduleWrap").toggleClass("change-bg");	
	}
	else if($(obj).parents(".moduleWrapNob")){
		$(obj).parents(".moduleWrapNob").toggleClass("change-bg");	
	}
}
//js验证表格是不是已经存在
function verifyExist(jqGridId,key,value){
	var flag = false;
	var ids = $("#" + jqGridId).jqGrid("getDataIDs");
	for(i=0;i<ids.length;i++){
		 var rowData = $("#" + jqGridId).jqGrid("getRowData", ids[i]);
		 if(rowData[key]==value){
			 flag = true;
			 break;
		 }
	}
	return flag;
}
function hasEditPermi(judgeId,type){
	var flag=false;
	$.ajax({ url: CTX+'/business/dissupport/common/permission/hasEditPermi.xf',
		data:{judgeId:judgeId,type:type},
		async: false,
		dataType:'json',
		success: function(data){
			if(data.hasPermi){
				flag=true;
			}else{
				flag=false;
			}		    			
         }
	});
	return flag;
}
 function getBirthdayFromIdCard(idCard) {  
    var birthday = "";  
    if(idCard != null && idCard != ""){  
        if(idCard.length == 15){  
            birthday = "19"+idCard.substr(6,6);  
        } else if(idCard.length == 18){  
            birthday = idCard.substr(6,8);  
        }  
      
        birthday = birthday.replace(/(.{4})(.{2})/,"$1-$2-");  
    }  
      
    return birthday;  
  }
 
 function templatePrint(alias,param){
	 var serializeparam="";
	 debugger;
	 $.each(param,function(key,value){
		 serializeparam+="&"+key+"="+value;
		 
	 })
	 window.open(CTX+"/business/personagency/print/printTemplate/preview.xf?alias="+alias+serializeparam);

 }
