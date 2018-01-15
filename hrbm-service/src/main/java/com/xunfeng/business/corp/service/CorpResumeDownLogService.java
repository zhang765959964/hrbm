package com.xunfeng.business.corp.service;

import com.xunfeng.business.corp.dao.CorpResumeDownLogDao;
import com.xunfeng.business.corp.dto.CorpResumeDownDto;
import com.xunfeng.business.corp.model.CorpResumeDownLog;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 企业下载简历日志表 Service类
* @author:wxl
* @createDate 2015-07-25 09:33:14 
* @version V1.0   
*/
@Service
public class CorpResumeDownLogService extends BaseService<CorpResumeDownLog>
{
	@Resource
	private CorpResumeDownLogDao dao;
	
	
	
	public CorpResumeDownLogService()
	{
	}
	
	@Override
	protected IEntityDao<CorpResumeDownLog, Long> getEntityDao()
	{
		return dao;
	}
	/**
	 * 获取企业下载简历列表
	 */
	public List<CorpResumeDownDto> getCorpResumeDownDto(QueryFilter filter){
		return dao.getCorpResumeDownDto(filter);
	}
	
}
