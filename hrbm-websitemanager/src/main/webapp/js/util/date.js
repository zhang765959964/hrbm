function addmulMonth(dtstr, n) { // n个月后
	var s = dtstr.split("-");
	var yy = parseInt(s[0]);
	var mm = parseInt(s[1] - 1);
//	var dd = parseInt(s[2]);
	var dt = new Date(yy, mm, 1);
	dt.setMonth(dt.getMonth() + parseInt(n));
	if ((dt.getYear() * 12 + dt.getMonth()) > (yy * 12 + mm + n)) {
		dt = new Date(dt.getYear(), dt.getMonth(), 0);
	}
	var year = dt.getFullYear();
	var month = dt.getMonth() + 1;
//	var days = dt.getDate();
	var dd = year + "-" + month 
	return dd;
}

function getMct(beginTime,endTime,sign){
	var beginDate = beginTime.split(sign);//拆分开始日期的年月日
	var endDate = endTime.split(sign);//拆分开始日期的年月日
	var bMonth = parseInt(beginDate[0]) * 12 + parseInt(beginDate[1]);//得到开始日期的月数
	var eMonth = parseInt(endDate[0]) * 12 + parseInt(endDate[1]);//得到结束日期的月数
	var totalMonth = Math.abs(eMonth - bMonth);//获取月数
	return totalMonth;
}

function compare(date1,date2){
    var oDate1 = new Date(date1);
    var oDate2 = new Date(date2);
    if(oDate1.getTime() > oDate2.getTime()){
        return 1;
    } else if(oDate1.getTime() == oDate2.getTime()) {
    	  return 0;
    }else{
    	return -1;
    }
}