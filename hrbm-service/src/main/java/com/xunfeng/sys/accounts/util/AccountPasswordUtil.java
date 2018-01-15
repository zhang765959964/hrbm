package com.xunfeng.sys.accounts.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.ArrayList;
import java.util.List;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 账号和密码生成类 
* @author jiangxin 
* @createDate 2015年5月22日下午4:38:19 
* @version V1.0   
*/
public class AccountPasswordUtil {
	
	/**
	 *  个人账号和密码生成
	 *   
	 * @param value
	 * @return 账号:姓名拼音小写   密码:身份证号后六位（有字母，字母小写）
	 * 				   
	 */
	public static List getPersonalConversion(String name,String card){
		List pList = new ArrayList();
		if(name != null && card !=null){
			String pYName = AccountPasswordUtil.getFullSpell(name);
			String str = card.toString();
			String st = str.substring(str.length()-6, str.length());
			String s = st.toLowerCase();
			String sp = st.toUpperCase();
			String account = pYName+sp;
			pList.add(account);
			pList.add(s);
		}
		
		return pList;
	}
	
	/**
	 * 单位账号和密码生成
	 * 
	 * @param value
	 * @return
	 */
	public static List  getEnterpriseConversion(String phone){
		List eList = new ArrayList();
		//String str = UniqueIdUtil.getGuid();
		String account = String.valueOf(Math.random()).substring(2,8);
		eList.add(account);
		if(phone != null){
			eList.add(phone);
		}
		return eList;
	}
	
	/**
	 *  汉字转拼音方法
	 * 
	 * @param value
	 * @return
	 */
	public static String getFullSpell(String chines) {
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					pinyinName += nameChar[i];
				} catch (NullPointerException e) {
					// 如果是日文，可能抛出该异常
					pinyinName += nameChar[i];
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}
	public static void main(String[] args) {
		System.out.print(Math.random());
		//System.out.println(AccountPasswordUtil.getPersonalConversion("李长","37020519740521351X"));
		//System.out.println(AccountPasswordUtil.getEnterpriseConversion("15988887101"));
		/*System.out.println(UniqueIdUtil.getGuid());
		System.out.println(UniqueIdUtil.genId());
		System.out.println(String.valueOf(Math.random()).substring(2, 8));*/
	}
}
