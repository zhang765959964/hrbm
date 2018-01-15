package com.xunfeng.sys.sendmessage.service;


import java.rmi.RemoteException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.sendmessage.interf.SenderServiceInterf;
import com.xunfeng.sys.sendmessage.util.WebServiceSoapProxy;
import com.xunfeng.sys.setMeal.exception.SetMealException;
import com.xunfeng.sys.setMeal.service.FeeOrderDetailService;
import com.xunfeng.sys.setMeal.util.MealResultConst;
import com.xunfeng.sys.setMeal.util.MealTypeEmun;


@Service
public class SenderService  implements SenderServiceInterf {
	@Resource
	private BaseConfigService baseConfigService;
	@Resource
	private FeeOrderDetailService feeOrderDetailService;
	
	public void sendVerificationCode(String phone,String context){
		if(StringUtil.isNotEmpty(phone)&&StringUtil.isNotEmpty(context)){
			BaseConfig baseConfig = baseConfigService.getConfigByName("sms_open");
			if("1".equals(baseConfig.getCaos04())){//1代表发送短信
				this.sendRecord(phone, context);
			}
		}
	}
	
	//统一调用接口
	private void sendRecord(String phone,String context){
		String endpoint = "http://sdk2.entinfo.cn:8060/webservice.asmx?WSDL";
		WebServiceSoapProxy umsp = new WebServiceSoapProxy(endpoint);
		try {
			BaseConfig baseConfigUserName = baseConfigService.getConfigByName("sms_username");
			BaseConfig baseConfigPassword = baseConfigService.getConfigByName("sms_password");
			String userName  = baseConfigUserName.getCaos04();
			String password  = baseConfigPassword.getCaos04();
			String resultStr = umsp.sendSMS(userName, password, phone,context);
			System.out.println(resultStr);
		} catch (Exception e) {
			System.out.println("异常");
			e.printStackTrace();
		}
	}
	
	//获取余额
	public String getMoney(){
		String str = "";
		String endpoint = "http://sdk2.entinfo.cn:8060/webservice.asmx?WSDL";
		WebServiceSoapProxy umsp = new WebServiceSoapProxy(endpoint);
		try {
			BaseConfig baseConfigUserName = baseConfigService.getConfigByName("sms_username");
			BaseConfig baseConfigPassword = baseConfigService.getConfigByName("sms_password");
			String userName  = baseConfigUserName.getCaos04();
			String password  = baseConfigPassword.getCaos04();
			str = umsp.getBalance(userName, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	/**
     * 短信扣费
     * 扣除套餐数量（注释的参数为必须参数,如有改动请判断参数在进行转化）
     * @param aab001 企业编号
	 * @param aab004 企业名称
	 * @param phone 手机号
	 * @param context 短信内容
     * @throws SetMealException 套餐不足整个事物回滚 
     */
	public void sendVerificationCode(Map<String,Object> map) throws SetMealException{
		String phone = map.get("phone").toString();
		String context = map.get("context").toString();
		String flag = MealResultConst.SUC;
		if(StringUtil.isNotEmpty(phone)&&StringUtil.isNotEmpty(context)){
			BaseConfig baseConfig = baseConfigService.getConfigByName("sms_open");
			if("1".equals(baseConfig.getCaos04())){//1代表发送短信
				if(isNeedFee()){
					Long aab001 = Long.valueOf(map.get("aab001").toString());
					String aab004 = map.get("aab004").toString();
					flag =  feeOrderDetailService.updateFeeOrderCount(aab001,aab004,MealTypeEmun.MESSAGE.getCode(),1);
					if(flag.equals(MealResultConst.SUC)){
						this.sendRecord(phone, context);
					}else{
						throw new SetMealException("短信套餐不足");
					}
				}
			}
		}
	}
	/**
     * 节点是否收费
     * @param categoryIndent 广告的分类Id
     * @return boolean true :扣费 false:免费
     */
    private boolean isNeedFee(){
    	BaseConfig baseConfig = baseConfigService.getConfigByName("member_IsPay");
    	String caos04 = baseConfig.getCaos04();
    	if(caos04.equals("1")){//收费
    		baseConfig = baseConfigService.getConfigByName("member_IsPay_message");
    		caos04 = baseConfig.getCaos04();
    	}
    	return caos04.equals("1")?true:false;
    }
	
}
