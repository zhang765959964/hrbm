package com.xunfeng.sys.identity.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @文件名：GeneratorUtils.java
 * @作用：
 */
public class GeneratorUtils {
	private static int i = 0;

	/**
	 * 主键生成器
	 * 
	 * @return
	 */
	public static String idGenerator() {
		String str = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
		str = Long.toString(Long.valueOf(str), 36);
		String upNumStr = Long.toString(i, 36);
		if (upNumStr.length() == 1) {
			upNumStr = "0" + upNumStr;
		}
		str += upNumStr;
		i = i < 1295 ? ++i : 0;
		return str.toUpperCase();
	}

	/**
	 * 数字主键生成器
	 * 
	 * @return
	 */
	public static String idNumGenerator() {
		String str = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
		String upNumStr = i + "";
		if (upNumStr.length() == 1) {
			upNumStr = "00" + upNumStr;
		} else if (upNumStr.length() == 2) {
			upNumStr = "0" + upNumStr;
		}
		str += upNumStr;
		i = i < 1000 ? ++i : 0;
		return str;
	}

	/**
	 * UUID生成器
	 * 
	 * @return
	 */
	public static String uuid() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "").toUpperCase();
		return uuid;
	}

	/**
	 * 数字转定长字符串
	 * 
	 * @param num
	 * @param length
	 * @return
	 */
	public static String num2string(int num, int length) {
		return String.format("%0" + length + "d", num);
	}

	/**
	 * 生成随机定长字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 生成随机定长数字字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomNumString(int length) {
		String base = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * length表示生成数字的位数
	 * 
	 * @param length
	 * @return
	 */
	public static Long getRandomNum(int length) {
		return (long) (Math.pow(10, length - 1) + 9 * Math.random() * Math.pow(10, length - 1));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomNumString(7));
		}
	}

}
