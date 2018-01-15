package com.xunfeng.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 日期操作类 
* @author wanghan 
* @createDate 2015年4月23日-上午11:42:56 
* @version V1.0   
*/
public class DateUtil {
 
	 
	private static final Log logger = LogFactory.getLog(DateUtil.class);

	/**
	 * 设置当前时间为当天的最初时间（即00时00分00秒）
	 * 
	 * @param cal
	 * @return
	 */
	public static Calendar setStartDay1(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal;
	}

	public static Calendar setEndDay(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal;
	}

	/**
	 * 把源日历的年月日设置到目标日历对象中
	 * @param destCal
	 * @param sourceCal
	 */
	public static void copyYearMonthDay(Calendar destCal,Calendar sourceCal){
		destCal.set(Calendar.YEAR, sourceCal.get(Calendar.YEAR));
		destCal.set(Calendar.MONTH, sourceCal.get(Calendar.MONTH));
		destCal.set(Calendar.DAY_OF_MONTH, sourceCal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 格式化日期为
	 * 
	 * @return
	 */
	public static String formatEnDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");

		return sdf.format(date).replaceAll("上午", "AM").replaceAll("下午", "PM");
	}

	public static Date parseDate(String dateString) {
		
		dateString=dateString.replaceAll("—", "-");
		Date date = null;
		try {
			date = DateUtils.parseDate(dateString, new String[]{StringPool.DATE_FORMAT_DATETIME,StringPool.DATE_FORMAT_DATE});
		} catch (Exception ex) {
			
			logger.error("Pase the Date(" + dateString + ") occur errors:"
					+ ex.getMessage());
			throw new RuntimeException("日期格式错误");
		}
		return date;
	}
	

	/**日期加月,
	 * @param date 
	 * @param formater 格式化
	 * @param addStep 增加月数
	 * @return
	 */
	public static String addMonth(String date,String formater,int addStep){
		if(StringUtil.isEmpty(date))return null;
		DateFormat format=new SimpleDateFormat(formater);
		Calendar calendar=Calendar.getInstance();
		String tmpDate=null;
		try {
			Date dd=format.parse(date);
			calendar.setTime(dd);
			calendar.add(Calendar.MONTH,addStep);
		    tmpDate = format.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return tmpDate;
	}
	/**
	 * 日期加一天
	 * @param date
	 * @return
	 */
	public static String addOneDay(String date){
		DateFormat format=new SimpleDateFormat(StringPool.DATE_FORMAT_DATE);
		Calendar calendar=Calendar.getInstance();
		try {
			Date dd=format.parse(date);
			calendar.setTime(dd);
			calendar.add(Calendar.DAY_OF_MONTH,1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String tmpDate = format.format(calendar.getTime());
		return tmpDate.substring(5,7)+"/"+tmpDate.substring(8,10)
				+"/"+tmpDate.substring(0,4);
	}
	
	/**
	 * 加一小时
	 * @param date
	 * @return
	 */
	public static String addOneHour(String date){
		
		String amPm = date.substring(20,22);
		
		DateFormat format=new SimpleDateFormat(StringPool.DATE_FORMAT_DATETIME);
		Calendar calendar=Calendar.getInstance();

		int hour = Integer.parseInt(date.substring(11,13));
		try {
			if(amPm.equals("PM")){
				hour+=12;
			}
			date = date.substring(0,11)+(hour>=10?hour:"0"+hour)+date.substring(13,19);
			Date dd=format.parse(date);
			calendar.setTime(dd);
			calendar.add(Calendar.HOUR_OF_DAY,1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String tmpDate = format.format(calendar.getTime());
		
		hour = Integer.parseInt(tmpDate.substring(11,13));
		amPm = hour>=12&&hour!=0?"PM":"AM";
		if(amPm.equals("PM")){
			hour-=12;
		}
		tmpDate = tmpDate.substring(5,7)+"/"+tmpDate.substring(8,10)+"/"+tmpDate.substring(0,4)
			+" "+(hour>=10?hour:"0"+hour)+tmpDate.substring(13, tmpDate.length())+" "+amPm;
		
		return tmpDate;
	}
	
	/**
	 * 标准时间格式转为时间字符格式
	 * @param timeStr eg:Mon Feb 06 00:00:00 CST 2012
	 * @return
	 */
	public static String timeStrToDateStr(String timeStr){

		String dateStr=timeStr.substring(24, 28)+"-";
		
		String mon = timeStr.substring(4, 7);
		if(mon.equals("Jan")){
			dateStr+="01";
		}else if(mon.equals("Feb")){
			dateStr+="02";
		}else if(mon.equals("Mar")){
			dateStr+="03";
		}else if(mon.equals("Apr")){
			dateStr+="04";
		}else if(mon.equals("May")){
			dateStr+="05";
		}else if(mon.equals("Jun")){
			dateStr+="06";
		}else if(mon.equals("Jul")){
			dateStr+="07";
		}else if(mon.equals("Aug")){
			dateStr+="08";
		}else if(mon.equals("Sep")){
			dateStr+="09";
		}else if(mon.equals("Oct")){
			dateStr+="10";
		}else if(mon.equals("Nov")){
			dateStr+="11";
		}else if(mon.equals("Dec")){
			dateStr+="12";
		}
		
		dateStr+="-"+timeStr.substring(8, 10);
		
		return dateStr;
	}
	
	
	
	
	
	/**
	 * 根据日期得到星期多余天数
	 * @param sDate
	 * @return
	 */
	public static int getExtraDayOfWeek(String sDate){
		try{
			    SimpleDateFormat format = new SimpleDateFormat(StringPool.DATE_FORMAT_DATE);
				Date date=format.parse(sDate);
				String weekday = date.toString().substring(0,3);
				if(weekday.equals("Mon")){
					return 1;
				}else if(weekday.equals("Tue")){
					return 2;
				}else if(weekday.equals("Wed")){
					return 3;
				}else if(weekday.equals("Thu")){
					return 4;
				}else if(weekday.equals("Fri")){
					return 5;
				}else if(weekday.equals("Sat")){
					return 6;
				}else{
					return 0;
				}
		    
	    }catch(Exception ex){
		   return 0;
	    }
	}
	
	/**
	 * 根据日期得到星期多余天数
	 * @param sDate
	 * @return
	 */
	public static String getDateWeekDay(String sDate){
		try{
		    SimpleDateFormat format = new SimpleDateFormat(StringPool.DATE_FORMAT_DATE);
			Date date=format.parse(sDate);
			String weekday = date.toString().substring(0,3);
//			format.format(date)+" "+ 
			return weekday;
			
	    }catch(Exception ex){
		   return "";
	    }
	}
	
	/**
	 * 取得上下五年
	 * @param cal
	 * @return
	 */
	public static List<String> getUpDownFiveYear(Calendar cal){
		List<String> yearlist = new ArrayList<String>();
		
		int curyear = cal.get(Calendar.YEAR);
		yearlist.add(String.valueOf(curyear-2));
		yearlist.add(String.valueOf(curyear-1));
		yearlist.add(String.valueOf(curyear));
		yearlist.add(String.valueOf(curyear+1));
		yearlist.add(String.valueOf(curyear+2));
		
		return yearlist;
	}
	
	/**
	 * 取得12个月
	 * @param cal
	 * @return
	 */
	public static List<String> getTwelveMonth(){
		List<String> monthlist = new ArrayList<String>();
		
		for(int idx=1;idx<=12;idx++){
			monthlist.add(String.valueOf(idx));
		}
		
		return monthlist;
	}
	
	/**
	 * 得到两日期间所有日期
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public static String[] getDaysBetweenDate(String stime, String etime){

		String[] dateArr = null;
		try {
			
//			String stime = timeStrToDateStr(startTime);
//			String etime = timeStrToDateStr(endTime);
			
			//日期相减算出秒的算法
			Date date1 = new SimpleDateFormat(StringPool.DATE_FORMAT_DATE).parse(stime);
			Date date2 = new SimpleDateFormat(StringPool.DATE_FORMAT_DATE).parse(etime);
			
			long day = (date1.getTime()-date2.getTime())/(24*60*60*1000)>0 ? (date1.getTime()-date2.getTime())/(24*60*60*1000):
			(date2.getTime()-date1.getTime())/(24*60*60*1000);
			
			dateArr = new String[Integer.valueOf(String.valueOf(day+1))];
			for(int idx=0;idx<dateArr.length;idx++){
				if(idx==0){
					dateArr[idx] = stime;
				}else{
					stime = addOneDay(stime);
					stime = stime.substring(6,10)+"-"+stime.substring(0,2)
							+"-"+stime.substring(3,5);
					dateArr[idx] = stime;
				}
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateArr;
	}
	/**
	 * 推迟的天数
	 * String formatter 返回格式化的时间
	 * int delayDate 负数为推迟的的时间 整数为往后的时间  eg 当前时间为2016-04-05 -1 2016-04-04 1 2016-04-06
	 * @return
	 */
	public static String getDelayDate(int delayDate,String formatter){
		if(formatter == null || formatter.equals("")){
			formatter="yyyy-MM-dd";
		}
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+delayDate);
		date = calendar.getTime();
		SimpleDateFormat dateFormater=new SimpleDateFormat(formatter);
		return dateFormater.format(date);
	}
	/**
	 * 推迟的天数
	 * String formatter 返回时间类型
	 * int delayDate 负数为推迟的的时间 整数为往后的时间  eg 当前时间为2016-04-05 -1 2016-04-04 1 2016-04-06
	 * @return
	 */
	public static Date getDelayDayDateBy(int delayDate){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,calendar.get(Calendar.DATE)+delayDate);
		date = calendar.getTime();
		return date;
	}
	/**
	 * 推迟的月数
	 * String formatter 返回格式化的时间
	 *  int delayDate 负数为推迟的的时间 整数为往后的时间 eg 当前时间为2016-04-05 -1 2016-03-05 1 2016-05-05
	 * @return
	 */
	public static String getDelayMonth(int delayMonth,String formatter){
		if(formatter == null || formatter.equals("")){
			formatter="yyyy-MM-dd";
		}
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.MONTH, delayMonth); //设置为前3月
		date = calendar.getTime();
		SimpleDateFormat dateFormater=new SimpleDateFormat(formatter);
		return dateFormater.format(date);
	}
	
	/**
	 * 获得格式化后的时间
	 * @param args
	 */
	public static String getformatterDate(Date date,String formatter){
		if(formatter == null || formatter.equals("")){
			formatter="yyyy-MM-dd";
		}
		SimpleDateFormat dateFormater=new SimpleDateFormat(formatter);
		return dateFormater.format(date);
	}
	/**
	 * 获得格式化后的当前时间
	 * @param args
	 */
	public static String getformatterCurrentDate(String formatter){
		if(formatter == null || formatter.equals("")){
			formatter="yyyy-MM-dd";
		}
		SimpleDateFormat dateFormater=new SimpleDateFormat(formatter);
		return dateFormater.format(new Date());
	}
	/**
	 * 获得两个开始时间相差的年数
	 * @param start
	 * @param end
	 * @return
	 */
	public static Long getIntervalYear(Date start,Date end){
		long i= (end.getTime() - start.getTime())/(1000*60*60*24); 
		return i/365;
	}
	/**
	 * 获得两个开始时间相差的月数
	/**
     * 
     * @param date1 <String>
     * @param date2 <String>
     * @return int
     * @throws ParseException
     */
    public static int getMonthSpace(String date1, String date2)
             {

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat(StringPool.DATE_FORMAT_MONTH);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
			c1.setTime(sdf.parse(date1));	
            c2.setTime(sdf.parse(date2));
        } catch (ParseException e) {
        	e.printStackTrace();
			logger.error("Pase the Date occur errors:"
					+ e.getMessage());
		}
        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
        result=year*12+month;
        return result;

    }
    public static int compare(String s1, String s2,String formatter) {
		int flag = 0;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatter);
		try {
			Date d1 = simpleDateFormat.parse(s1);
			Date d2 = simpleDateFormat.parse(s2);
			if (d1.getTime() > d2.getTime()) {
				flag = 1;
			}else if(d1.getTime() == d2.getTime()){
				flag = 0;
			}else{
				flag = -1;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(String[] args) throws ParseException {
//		String dsd="2015-05-02";
//		String dsds=DateUtil.addMonth(dsd, "yyyy-MM", 1);
//		String ds="";
		String sartDate="2015-10-10", endDate="2016-5-10";
		
		
		int dsd=DateUtil.getMonthSpace(sartDate, endDate);
		
		String ds="";
		

	}
}
