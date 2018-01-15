package com.xunfeng.business.corp.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.CorpPositionPublishDao;
import com.xunfeng.business.corp.interf.CorpPositionPublishServiceInterf;
import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.console.service.SystemConst;

/**
 *<pre>
 * 对象功能:单位招聘信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-22 17:34:19
 *</pre>
 */
@Service
public class CorpPositionPublishService extends BaseService<CorpPositionPublish> implements CorpPositionPublishServiceInterf
{
	@Resource
	private CorpPositionPublishDao dao;
	
	
	
	public CorpPositionPublishService()
	{
	}
	
	@Override
	protected IEntityDao<CorpPositionPublish, Long> getEntityDao()
	{
		return dao;
	}

	@Override
	public void freezeCorpPublicPosition(Long[] corpPositionIds,
			Map<String, Object> map) {
		//冻结标志
		map.put("acb208", "1");
		//冻结日期
		map.put("acb20e", new Date());
		for (Long long1 : corpPositionIds) {
			map.put("acb200", long1);
			dao.update("updateRecruitment", map);
        }
		updateCorpPostionByAcd(corpPositionIds, map);
	}

	@Override
	public void unfreezeCorpPublicPosition(Long[] corpPositionIds,
			Map<String, Object> map) {
		//解冻标志
		map.put("acb208", "0");
		map.put("acb20e", new Date());
		//冻结原因空
		map.put("acb20l", "");
		for (Long long1 : corpPositionIds) {
			map.put("acb200", long1);
		    dao.update("updateRecruitment", map);
		 }
		updateCorpPostionByAcd(corpPositionIds, map);
	}
	
	/**
	 * 冻结职位
	 * @param corpPositionIds
	 * @param map
	 */
	public void updateCorpPostionByAcd(Long[] corpPositionIds,Map<String, Object> map){
		for (Long long1 : corpPositionIds) {
			map.put("acb200", long1);
			dao.update("updatePositionRecruitment", map);
		}
	}
	
	
}
