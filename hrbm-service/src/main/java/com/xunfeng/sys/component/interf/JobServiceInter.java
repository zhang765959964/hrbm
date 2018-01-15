package com.xunfeng.sys.component.interf;

import java.util.List;

import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.sys.component.model.Job;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 工种自定义标准 Service类
* @author:wanghan
* @createDate 2015-09-23 15:34:24 
* @version V1.0   
*/
public interface JobServiceInter extends  GenericServiceInterface<Job,Long>
{


	public List<Job> getJobList(Long pId);
}
