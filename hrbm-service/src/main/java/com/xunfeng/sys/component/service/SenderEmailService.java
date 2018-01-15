package com.xunfeng.sys.component.service;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.component.interf.SenderEmailServiceInterf;
import com.xunfeng.sys.component.util.EmailHelper;
import com.xunfeng.sys.config.model.BaseConfig;
//import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;


@Service
public class SenderEmailService  implements SenderEmailServiceInterf {
	
	@Resource
	private BaseConfigService baseConfigService;
	@Resource
	@Qualifier("emailHelper")
	private EmailHelper emailHelper;
	
	final Map emailTime = new HashMap();


	@Override
	public boolean sendEamil(Long id, String to, Accounts loginUser,String contextPath) {
		// TODO Auto-generated method stub
		boolean flag = true;
		BaseConfig baseConfig = baseConfigService.getConfigByName("email_interval_time");
		if(baseConfig!=null && !"2".equals(baseConfig.getCaos05())){
			//获取参数值（分钟为单位）
			String time = baseConfig.getCaos04();
			Date oldTime = (Date) emailTime.get(to);
			if(oldTime!=null){
				oldTime.setMinutes(oldTime.getMinutes()+Integer.parseInt(time));
				Date date = new Date();
				long l=date.getTime()-oldTime.getTime();    
				if(l>=0){
					emailHelper.run(id, to, loginUser,contextPath);
					emailTime.put(to, new Date());
				}else{
					flag = false;
				}
			}else{
				emailHelper.run(id, to, loginUser,contextPath);
				emailTime.put(to, new Date());
			}
		}else{
			emailHelper.run(id, to, loginUser,contextPath);
			emailTime.put(to, new Date());
		}
		return flag;
	}
	
	public boolean sendEamilForLookPwd(String to,String contextPath) {
		// TODO Auto-generated method stub
		boolean flag = true;
		BaseConfig baseConfig = baseConfigService.getConfigByName("email_interval_time");
		if(baseConfig!=null && !"2".equals(baseConfig.getCaos05())){
			//获取参数值（分钟为单位）
			String time = baseConfig.getCaos04();
			Date oldTime = (Date) emailTime.get(to);
			if(oldTime!=null){
				oldTime.setMinutes(oldTime.getMinutes()+Integer.parseInt(time));
				Date date = new Date();
				long l=date.getTime()-oldTime.getTime();    
				if(l>=0){
					emailHelper.run(to,contextPath);
					emailTime.put(to, new Date());
				}else{
					flag = false;
				}
			}else{
				emailHelper.run(to,contextPath);
				emailTime.put(to, new Date());
			}
		}else{
			emailHelper.run(to,contextPath);
			emailTime.put(to, new Date());
		}
		return flag;
	}

	@Override
	public Object decrypt(String message) {
		// TODO Auto-generated method stub
		return emailHelper.decrypt(message);
	}

}
