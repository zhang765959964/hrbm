function isPass(cellvalue, options, rowObject) {
	if (cellvalue == "0") {
		return "否";
	} else {
		return "是";
	}
}
function checkState(cellvalue, options, rowObject) {
	alert(cellvalue)
	if(cellvalue=="0"){
		   return "未审核";
	   }else if(cellvalue=="1"){
		   return "通过";
	  }else{
		  return "未通过";
	  }
  }
function isHasBusLic(cellvalue, options, rowObject) {
	if (cellvalue == "0") {
		return "否";
	} else {
		return "是";
	}
}

//审核标记
function checkBj(cellvalue, options, rowObject){
	 if(cellvalue=="0"){
		   return "未审核";
	   }else if(cellvalue=="1"){
		   return "通过";
	   }else if(cellvalue=="2"){
		   return "未通过";
	   }else if(cellvalue=="3"){
		   return "注销";
	   }else{
		   return "提交";
	   }
	
}

function checkSex(cellvalue, options, rowObject){
	if(cellvalue=="1"){
		return "男";
	}else{
		return "女";
	}
	
}