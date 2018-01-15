package com.xunfeng.sys.config.interf;


import java.util.List;

import org.springframework.stereotype.Service;

import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 系统配置表 接口类
* @author:wanghan
* @createDate 2016-04-09 14:21:20 
* @version V1.0   
*/
@Service
public interface BaseConfigServiceInterf extends GenericServiceInterface<BaseConfig,Long>
{
	public List<BaseConfig> getEmailConfig();
	public BaseConfig getConfigByName(String caos02);
	public BaseConfig getAuthEmailTime();
}
