package com.xunfeng.core.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zf
 * @date 2016年9月29日
 * @time 下午15:56:59
 */
public class ZJ_DateUtils {
/*	private static String DateTime_Format_Str = "yyyy-MM-dd HH:mm:ss";
	private static String Time_Format_Str = "HH:mm:ss";
	private static String Hour_Minute_Format_Str = "HH:mm";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// 日期字符串转Date
	public static Date str2date(String dateStr) {
		if (null == dateStr || "".equals(dateStr)) {
			return null;
		}
		dateStr = dateStr.replaceAll("-", " ").replaceAll(":", " ").replaceAll("[.]", " ");
		String newTimeStr = "";
		String[] dateStrArray = dateStr.split(" ");
		int[] timeArray = { 1, 1, 1, 0, 0, 0 };
		for (int i = 0; i < dateStrArray.length; i++) {
			if (i < 6) {
				timeArray[i] = Integer.valueOf(dateStrArray[i]);
			}
		}
		newTimeStr = String.format("%s-%s-%s %s:%s:%s", timeArray[0], timeArray[1], timeArray[2], timeArray[3], timeArray[4], timeArray[5]);
		SimpleDateFormat sdf = new SimpleDateFormat(DateTime_Format_Str);
		Date d = null;
		try {
			d = sdf.parse(newTimeStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	// Date转字符串
	public static String date2datetimeStr(Date date) {
		return new SimpleDateFormat(DateTime_Format_Str).format(date);
	}

	public static String date2timeStr(Date date) {
		return new SimpleDateFormat(Time_Format_Str).format(date);
	}

	*//**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @return 日期字符串
	 *//*
	public static String format(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}

	*//**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @param pattern
	 *            字符串格式
	 * @return 日期字符串
	 *//*
	public static String format(Date date, String pattern) {
		if (date == null) {
			return "null";
		}
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		return new java.text.SimpleDateFormat(pattern).format(date);
	}

	*//**
	 * 将字符串转换为Date类型
	 * 
	 * @param date
	 *            字符串类型
	 * @return 日期类型
	 *//*
	public static Date format(String date) {
		return format(date, null);
	}

	*//**
	 * 将字符串转换为Date类型
	 * 
	 * @param date
	 *            字符串类型
	 * @param pattern
	 *            格式
	 * @return 日期类型
	 *//*
	public static Date format(String date, String pattern) {
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
			pattern = "yyyy-MM-dd HH:mm:ss";
		}
		if (date == null || date.equals("") || date.equals("null")) {
			return new Date();
		}
		Date d = null;
		try {
			d = new java.text.SimpleDateFormat(pattern).parse(date);
		} catch (ParseException pe) {
		}
		return d;
	}

	*//**
	 * 计算两个时间差
	 * 
	 * @param startDate
	 *            ,endDate
	 * 
	 * @param type
	 *            格式
	 * @return 时间差
	 *//*
	public static int datediff(Date startDate, Date endDate, String type) {
		Map<String, Integer> map = new HashMap<>();
		map.put("ss", 1000);// 秒
		map.put("mm", 1000 * 60);// 分
		map.put("hh", 1000 * 60 * 60);// 时
		map.put("dd", 1000 * 60 * 60 * 24);// 天
		int lag = (int) ((endDate.getTime() - startDate.getTime()) / map.get(type));

		return lag > 0 ? lag : Math.abs(lag);
	}

	*//**
	 * Date转字符串
	 * 
	 * @param date
	 * @return
	 *//*
	public static String date2dateTimeStr(Date date) {
		return dateTimeFormat.format(date);
	}

	*//**
	 * Date转字符串
	 * 
	 * @param date
	 * @return
	 *//*
	public static String date2dateStr(Date date) {
		return dateFormat.format(date);
	}

	*//**
	 * 获取两个日期间的所有日期
	 * 
	 * @return
	 *//*
	public static Set<String> getDateSetByBegin2End(String beginStr, String endStr) {
		Long begin = str2date(beginStr).getTime();
		Long end = str2date(endStr).getTime();
		Long temp = begin;
		Set<String> set = new TreeSet<>();
		while (temp <= end) {
			set.add(dateFormat.format(temp));
			temp += 3600 * 24 * 1000;
		}
		return set;
	}

	*//**
	 * 获取datatime中的date
	 * 
	 * @param datetime
	 * @return
	 *//*
	public static Date getDate(Date datetime) {
		try {
			return dateFormat.parse(dateFormat.format(datetime));
		} catch (ParseException e) {
			e.printStackTrace();
			return datetime;
		}
	}

	*//**
	 * 获取某月的起始的日期
	 * 
	 * @param datetime
	 * @return
	 *//*
	public static Date getMonthBeginDate(Date datetime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	*//**
	 * 获取某月的结束日期
	 * 
	 * @param datetime
	 * @return
	 *//*
	public static Date getMonthEndDate(Date datetime) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(datetime);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}

	*//**
	 * 获取下一天
	 * 
	 * @param date
	 * @return
	 *//*
	public static Date getNextDay(Date date) {
		date = str2date(date2dateStr(date));
		Long theDate = date.getTime();
		theDate += 3600 * 24 * 1000;
		return str2date(dateFormat.format(theDate));
	}

	*//**
	 * 获取本天的开始
	 * 
	 * @param date
	 * @return
	 *//*
	public static Date getDayBegin(Date date) {
		try {
			date = dateFormat.parse(dateFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	*//**
	 * 获取本天的最后
	 * 
	 * @param date
	 * @return
	 *//*
	public static Date getDayLast(Date date) {
		try {
			date = dateFormat.parse(dateFormat.format(date));
			Long theDate = date.getTime();
			theDate += 3600 * 24 * 1000 - 1;
			return new Date(theDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;

	}

	*//**
	 * 判断是否同一天
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 *//*
	public static boolean isSameDay(Date date1, Date date2) {
		if (date2dateStr(date1).equals(date2dateStr(date2))) {
			return true;
		} else {
			return false;
		}
	}

	*//**
	 * 根据一个日期，返回是星期几的字符串
	 * 
	 * @param sdate
	 * @return
	 *//*
	public static String getWeek(String sdate) {
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return new SimpleDateFormat("EEEE").format(c.getTime());
	}

	*//**
	 * 获取下一天的日期
	 * 
	 * @param sdate
	 * @return
	 *//*
	public static String getNextDay(String sdate) {
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}

	*//**
	 * 获取上一天的日期
	 * 
	 * @param sdate
	 * @return
	 *//*
	public static String getLastDay(String sdate) {
		Date date = strToDate(sdate);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}

	*//**
	 * 获取下一个工作日
	 * 
	 * @param date
	 * @return
	 *//*
	public static String getNextWorkday(String date) {
		date = getNextDay(date);
		while (!isWorkday(date)) {
			date = getNextDay(date);
		}
		return date;
	}

	*//**
	 * 判断闰年
	 * 
	 * @param year
	 * @return
	 *//*
	public static boolean isLeap(int year) {
		if (((year % 100 == 0) && year % 400 == 0) || ((year % 100 != 0) && year % 4 == 0))
			return true;
		else
			return false;
	}

	*//**
	 * 判断两个日期是否相同（只判断date部分）
	 * 
	 * @param DateTime1
	 * @param DateTime2
	 * @return
	 *//*
	public static boolean isSameByDate(String DateTime1, String DateTime2) {
		DateTime1 = formatShortDate(DateTime1);
		DateTime2 = formatShortDate(DateTime2);
		boolean b = false;
		if (DateTime1.equals(DateTime2)) {
			b = true;
		}
		return b;
	}

	*//**
	 * 日期一是否早于日期二
	 * 
	 * @param DateStr1
	 * @param DateStr2
	 * @return 1:早于 0：等于 -1：晚于
	 *//*
	public static int isBeforeDate(String DateStr1, String DateStr2) {
		DateStr1 = formatShortDate(DateStr1);
		DateStr2 = formatShortDate(DateStr2);
		Date date1 = strToDate(DateStr1);
		Date date2 = strToDate(DateStr2);
		if (date1.before(date2)) {
			return 1;
		} else if (date1.equals(date2)) {
			return 0;
		} else {
			return -1;
		}
	}

	*//**
	 * 得到指定年月的天数
	 *//*
	public static int getLastDayOfMonth(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	*//**
	 * 返回当前年月日
	 * 
	 * @return
	 *//*
	public static String getNowDate() {
		Date date = new Date();
		String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
		return nowDate;
	}

	*//**
	 * 返回当前年月日时分秒
	 * 
	 * @return
	 *//*
	public static String getNowDateTime() {
		Date date = new Date();
		String nowDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		return nowDateTime;
	}

	*//**
	 * 返回当前年月
	 * 
	 * @return
	 *//*
	public static String getNowYearAndMonth() {
		Date date = new Date();
		String nowDateTime = new SimpleDateFormat("yyyy-MM").format(date);
		return nowDateTime;
	}

	*//**
	 * 返回当前年份
	 * 
	 * @return
	 *//*
	public static int getNowYear() {
		Date date = new Date();
		String year = new SimpleDateFormat("yyyy").format(date);
		return Integer.parseInt(year);
	}

	*//**
	 * 返回当前月份
	 * 
	 * @return
	 *//*
	public static int getNowMonth() {
		Date date = new Date();
		String month = new SimpleDateFormat("MM").format(date);
		return Integer.parseInt(month);
	}

	*//**
	 * 获取日期中的年
	 * 
	 * @param strDate
	 * @return
	 *//*
	public static int getYearOfDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		String year = new SimpleDateFormat("yyyy").format(date);
		return Integer.parseInt(year);
	}

	*//**
	 * 获取日期中的月
	 * 
	 * @param strDate
	 * @return
	 *//*
	public static int getMonthOfDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		String month = new SimpleDateFormat("MM").format(date);
		return Integer.parseInt(month);
	}

	*//**
	 * 获取日期中的日
	 * 
	 * @param strDate
	 * @return
	 *//*
	public static int getDayOfDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		String day = new SimpleDateFormat("dd").format(date);
		return Integer.parseInt(day);
	}

	*//**
	 * 获取日期中的日
	 * 
	 * @param date
	 * @return
	 *//*
	public static int getDayOfDate(Date date) {
		String day = new SimpleDateFormat("dd").format(date);
		return Integer.parseInt(day);
	}

	*//**
	 * 获取日期中的时间
	 * 
	 * @param date
	 * @return
	 *//*
	public static String getTimeStrOfDate(Date date) {
		String time = new SimpleDateFormat(Time_Format_Str).format(date);
		return time;
	}

	*//**
	 * 获取日期中的时分
	 * 
	 * @param date
	 * @return
	 *//*
	public static String getHourAndMinuteStrOfDate(Date date) {
		String time = new SimpleDateFormat(Hour_Minute_Format_Str).format(date);
		return time;
	}

	*//**
	 * 获取日期中的时间
	 * 
	 * @param date
	 * @return
	 *//*
	public static Date getTimeOfDate(Date date) {
		try {
			return timeFormat.parse(timeFormat.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	*//**
	 * 返回当月星期天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 *//*
	public static int getSundays(int year, int month) {
		int sundays = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		Calendar setDate = Calendar.getInstance();
		// 从第一天开始
		int day;
		for (day = 1; day <= getLastDayOfMonth(year, month); day++) {
			setDate.set(Calendar.DATE, day);
			String str = sdf.format(setDate.getTime());
			if (str.equals("星期日")) {
				sundays++;
			}
		}
		return sundays;
	}

	*//**
	 * 判断一天是否为工作日
	 * 
	 * @param sdate
	 * @return
	 *//*
	public static boolean isWorkday(String sdate) {
		String week = getWeek(sdate);
		if (week.equals("星期六") || week.equals("星期日")) {
			return false;
		} else {
			return true;
		}
	}

	*//**
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd
	 * 
	 * @param strDate
	 * @return
	 *//*
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	*//**
	 * date转字符串
	 * 
	 * @param date
	 * @return
	 *//*
	public static String dateToStr(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	*//**
	 * 把短日期格式化
	 * 
	 * @param strDate
	 * @return
	 *//*
	public static String formatShortDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	*//**
	 * 把长日期格式化
	 * 
	 * @param strDate
	 * @return
	 *//*
	public static String formatLongDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date date = formatter.parse(strDate, pos);
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}

	*//**
	 * 两个时间之间的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 *//*
	public static long getDays(String date1, String date2) {
		if (date1 == null || date1.equals(""))
			return 0;
		if (date2 == null || date2.equals(""))
			return 0;
		// 转换为标准时间
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		java.util.Date mydate = null;
		try {
			date = myFormatter.parse(date1);
			mydate = myFormatter.parse(date2);
		} catch (Exception e) {
		}
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		day = Math.abs(day);
		return day;
	}

	*//**
	 * 获取当月第一天
	 * 
	 * @return
	 *//*
	public static String getFirstDayOfMonth() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	*//**
	 * 计算当月最后一天
	 * 
	 * @return
	 *//*
	public static String getDefaultDay() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	*//**
	 * 上月第一天
	 * 
	 * @return
	 *//*
	public static String getPreviousMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, -1);// 减一个月，变为下月的1号
		str = sdf.format(lastDate.getTime());
		return str;
	}

	*//**
	 * 获得当前日期与本周日相差的天数
	 * 
	 * @return
	 *//*
	public static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		} else {
			return 1 - dayOfWeek;
		}
	}

	*//**
	 * 获得本周一的日期
	 * 
	 * @return
	 *//*
	public static String getNowMonday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String monday = df.format(cal.getTime());
		return monday;
	}

	*//**
	 * 获得本周日的日期
	 * 
	 * @return
	 *//*
	public static String getNowSunday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, 6);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String sunday = df.format(cal.getTime());
		return sunday;
	}

	*//**
	 * 获得上周星期一的日期
	 * 
	 * @return
	 *//*
	public static String getLastMonday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -7);
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String monday = df.format(cal.getTime());
		return monday;
	}

	*//**
	 * 获得上周星期日的日期
	 * 
	 * @return
	 *//*
	public static String getLastSunday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -7);
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, 6);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String sunday = df.format(cal.getTime());
		return sunday;
	}

	*//**
	 * 获得下周星期一的日期
	 * 
	 * @return
	 *//*
	public static String getNextMonday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 7);
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String monday = df.format(cal.getTime());
		return monday;
	}

	*//**
	 * 获得下周星期日的日期
	 * 
	 * @return
	 *//*
	public static String getNextSunday() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 7);
		cal.add(Calendar.DAY_OF_MONTH, -1); // 解决周日会出现 并到下一周的情况
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.add(Calendar.DATE, 6);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String sunday = df.format(cal.getTime());
		return sunday;
	}

	*//**
	 * 获得上月最后一天的日期
	 * 
	 * @return
	 *//*
	public static String getPreviousMonthEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	*//**
	 * 获得下个月第一天的日期
	 * 
	 * @return
	 *//*
	public static String getNextMonthFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		str = sdf.format(lastDate.getTime());
		return str;
	}

	*//**
	 * 获得下个月最后一天的日期
	 * 
	 * @return
	 *//*
	public static String getNextMonthEnd() {
		String str = "";
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, 1);// 加一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		str = sdf.format(lastDate.getTime());
		return str;
	}

	*//**
	 * 获得明年最后一天的日期
	 * 
	 * @return
	 *//*
	public static String getNextYearEnd() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		lastDate.roll(Calendar.DAY_OF_YEAR, -1);
		str = sdf.format(lastDate.getTime());
		return str;
	}

	*//**
	 * 获得明年第一天的日期
	 * 
	 * @return
	 *//*
	public static String getNextYearFirst() {
		String str = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.YEAR, 1);// 加一个年
		lastDate.set(Calendar.DAY_OF_YEAR, 1);
		str = sdf.format(lastDate.getTime());
		return str;

	}

	*//**
	 * 获得本年有多少天
	 * 
	 * @return
	 *//*
	public static int getMaxYear() {
		Calendar cd = Calendar.getInstance();
		cd.set(Calendar.DAY_OF_YEAR, 1);// 把日期设为当年第一天
		cd.roll(Calendar.DAY_OF_YEAR, -1);// 把日期回滚一天。
		int MaxYear = cd.get(Calendar.DAY_OF_YEAR);
		return MaxYear;
	}

	*//**
	 * 获得某月所在季度 如：(2014-10-1;2014-12-31)
	 * 
	 * @param month
	 * @return
	 *//*
	public static String getSeasonOfMonth(int month) {
		int array[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		int season = 1;
		if (month >= 1 && month <= 3) {
			season = 1;
		}
		if (month >= 4 && month <= 6) {
			season = 2;
		}
		if (month >= 7 && month <= 9) {
			season = 3;
		}
		if (month >= 10 && month <= 12) {
			season = 4;
		}
		int start_month = array[season - 1][0];
		int end_month = array[season - 1][2];

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");// 可以方便地修改日期格式
		String years = dateFormat.format(date);
		int years_value = Integer.parseInt(years);

		int start_days = 1;
		int end_days = getLastDayOfMonth(years_value, end_month);
		String seasonDate = years_value + "-" + start_month + "-" + start_days + ";" + years_value + "-" + end_month + "-" + end_days;
		return seasonDate;

	}

	*//**
	 * 获取当前的时间
	 * 
	 * @return
	 *//*
	public static String getNowTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	*//**
	 * 获取现在的小时
	 * 
	 * @return
	 *//*
	public static Integer getNowHour() {
		return Integer.valueOf(new SimpleDateFormat("HH").format(new Date()));
	}

	*//**
	 * 获取现在的分钟
	 * 
	 * @return
	 *//*
	public static Integer getNowMinute() {
		return Integer.valueOf(new SimpleDateFormat("mm").format(new Date()));
	}

	*//**
	 * 获取时间字符串中的小时
	 * 
	 * @param time
	 * @return
	 *//*
	public static Integer getHourByStr(String time) {
		Integer hour = null;
		String[] str = time.split(":");
		hour = Integer.valueOf(str[0]);
		return hour;
	}

	*//**
	 * 获取时间字符串中的分钟
	 * 
	 * @param time
	 * @return
	 *//*
	public static Integer getMinuteByStr(String time) {
		Integer minute = null;
		String[] str = time.split(":");
		minute = Integer.valueOf(str[1]);
		return minute;
	}

	*//**
	 * 时间1是否早于时间2
	 * 
	 * @param time1
	 * @param time2
	 * @return
	 *//*
	public static boolean isBefore(String time1, String time2) {
		boolean b = false;
		int[] time1Array = new int[4];
		int[] time2Array = new int[4];
		String[] inputTime1Array = time1.split(":");
		String[] inputTime2Array = time2.split(":");
		for (int i = 0; i < inputTime1Array.length; i++) {
			time1Array[i] = Integer.valueOf(inputTime1Array[i]);
		}
		for (int i = 0; i < inputTime2Array.length; i++) {
			time2Array[i] = Integer.valueOf(inputTime2Array[i]);
		}
		for (int i = 0; i < 4; i++) {
			if (time1Array[i] < time2Array[i]) {
				b = true;
				break;
			}
		}
		return b;
	}

	*//**
	 * 获取几分后的日期
	 * 
	 * @param d
	 * @param addHour
	 * @return
	 *//*
	public static Date getAddMinuteDate(Date d, int minute) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}

	*//**
	 * 获取几小时后的日期
	 * 
	 * @param d
	 * @param addHour
	 * @return
	 *//*
	public static Date getAddHourDate(Date d, int addHour) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.HOUR, addHour);
		return c.getTime();
	}

	*//**
	 * 获取几天后的日期
	 * 
	 * @param d
	 * @param addHour
	 * @return
	 *//*
	public static Date getAddDayDate(Date d, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, day);
		return c.getTime();
	}

	*//**
	 * 现在是否在两个时间之间
	 * 
	 * @param beginStr
	 * @param endStr
	 * @return
	 *//*
	public static boolean isBetweenTwoDateStr(String beginStr, String endStr) {
		Date now = new Date();
		Date beginDate = ZJ_DateUtils.str2date(beginStr);
		Date endDate = ZJ_DateUtils.str2date(endStr);
		if (now.before(endDate) && now.after(beginDate)) {
			return true;
		} else if (now.before(beginDate) && now.after(endDate)) {
			return true;
		} else {
			return false;
		}
	}

	*//**
	 * 现在是否在两个时间之间
	 * 
	 * @param beginDate
	 * @param endDate
	 * @return
	 *//*
	public static boolean isBetweenTwoDate(Date beginDate, Date endDate) {
		Date now = new Date();
		if (now.before(endDate) && now.after(beginDate)) {
			return true;
		} else if (now.before(beginDate) && now.after(endDate)) {
			return true;
		} else {
			return false;
		}
	}
	
	*//**
	 * 求出当前年号 和上个月编号
	 * @return
	 *//*
	public static String getLastDateYYmm(){
		String date = ZJ_DateUtils.getNowDate();
		String year = date.substring(2, 4);
		String month = date.substring(5,7);
		//根据当前月份求出下个月份
		switch(month){
			 case "01":
				 month = "12";
				 break;
			 case "02":
				 month = "01";
				 break;
			 case "03":
				 month = "02";
				 break;
			 case "04":
				 month = "03";
				 break;
			 case "05":
				 month = "04";
				 break;
			 case "06":
				 month = "05";
				 break;
			 case "07":
				 month = "06";
				 break;
			 case "08":
				 month = "07";
				 break;
			 case "09":
				 month = "08";
				 break;
			 case "10":
				 month = "09";
				 break;
			 case "11":
				 month = "10";
				 break;
			 case "12":
				 month = "11";
				 break;
		}
		return year+month;
	}
	
	
	*//**
	 * 求出当前年号  当前这个月编号
	 * @return
	 *//*
	public static String getCurrentDateYYmm(){
		String date = ZJ_DateUtils.getNowDate();
		String year = date.substring(2, 4);
		String month = date.substring(5,7);
		//根据当前月份求出下个月份
		switch(month){
			 case "01":
				 month = "01";
				 break;
			 case "02":
				 month = "02";
				 break;
			 case "03":
				 month = "03";
				 break;
			 case "04":
				 month = "04";
				 break;
			 case "05":
				 month = "05";
				 break;
			 case "06":
				 month = "06";
				 break;
			 case "07":
				 month = "07";
				 break;
			 case "08":
				 month = "08";
				 break;
			 case "09":
				 month = "09";
				 break;
			 case "10":
				 month = "10";
				 break;
			 case "11":
				 month = "11";
				 break;
			 case "12":
				 month = "12";
				 break;
		}
		return year+month;
	}
	
	
	*//**
	 * 求出下个月编号
	 * @return
	 *//*
	public static String getNextDateYYmm(){
		String date = ZJ_DateUtils.getNowDate();
		String year = date.substring(2, 4);
		String month = date.substring(5,7);
		//根据当前月份求出下个月份
		switch(month){
			 case "01":
				 month = "02";
				 break;
			 case "02":
				 month = "03";
				 break;
			 case "03":
				 month = "04";
				 break;
			 case "04":
				 month = "05";
				 break;
			 case "05":
				 month = "06";
				 break;
			 case "06":
				 month = "07";
				 break;
			 case "07":
				 month = "08";
				 break;
			 case "08":
				 month = "09";
				 break;
			 case "09":
				 month = "10";
				 break;
			 case "10":
				 month = "11";
				 break;
			 case "11":
				 month = "12";
				 break;
			 case "12":
				 month = "01";
				 break;
		}
		return year+month;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(ZJ_DateUtils.getCurrentDateYYmm().substring(2, 4));
		
		
		
	}*/
}
