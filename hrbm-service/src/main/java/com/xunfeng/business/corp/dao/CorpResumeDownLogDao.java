package com.xunfeng.business.corp.dao;

import com.xunfeng.business.corp.dto.CorpResumeDownDto;
import com.xunfeng.business.corp.model.CorpResumeDownLog;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业下载简历日志表 Dao类
* @author:wxl
* @createDate 2015-07-25 09:33:14 
* @version V1.0   
*/
@Repository
public class CorpResumeDownLogDao extends BaseDao<CorpResumeDownLog>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpResumeDownLog.class;
	}

	/**
	 * 获取企业下载简历列表
	 */
	public List<CorpResumeDownDto> getCorpResumeDownDto(QueryFilter filter){
		return this.getListForm("getCorpResumeDownDto",filter);
	}
}