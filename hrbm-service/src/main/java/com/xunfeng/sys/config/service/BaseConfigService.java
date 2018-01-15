package com.xunfeng.sys.config.service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.config.dao.BaseConfigDao;
import com.xunfeng.sys.config.interf.BaseConfigServiceInterf;
import com.xunfeng.sys.config.model.BaseConfig;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 系统配置表 Service类
* @author:wxl
* @createDate 2015-08-07 17:39:43 
* @version V1.0   
*/
@Service
public class BaseConfigService extends BaseService<BaseConfig> implements BaseConfigServiceInterf
{
	@Resource
	private BaseConfigDao dao;
	
	
	
	public BaseConfigService()
	{
	}
	
	@Override
	protected IEntityDao<BaseConfig, Long> getEntityDao()
	{
		return dao;
	}

	/**
	 * 获取有关发送邮件的配置参数
	 * @return
	 */
	public List<BaseConfig> getEmailConfig(){
		return dao.getModelConfig(1L,"email_set");
	}
	/**
	 * 根据配置参数的名称获取配置项
	 */
	public BaseConfig getConfigByName(String caos02){
		return dao.getConfigByName(caos02);
	}
	/**
	 * 获取邮箱验证过期时间
	 */
	public BaseConfig getAuthEmailTime(){
		return dao.getConfigByName("auth_email_time");
	}

}
