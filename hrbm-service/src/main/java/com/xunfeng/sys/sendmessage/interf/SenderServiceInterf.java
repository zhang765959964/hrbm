package com.xunfeng.sys.sendmessage.interf;

import java.util.Map;

import com.xunfeng.sys.setMeal.exception.SetMealException;




/**
 * 短信接口
 * @author jx
 * 2016.04.25
 */
public interface SenderServiceInterf {
	public void sendVerificationCode(String phone,String context);
	//获取余额
	public String getMoney();
	/**
     * 短信扣费
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param phone 手机号
	 * @param context 短信内容
     * @throws SetMealException 套餐不足整个事物回滚 
     */
	public void sendVerificationCode(Map<String,Object> map) throws SetMealException;
}
