package com.xunfeng.business.personagency.subsidy.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.subsidy.dao.SocialSubsidyBatchDao;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidyBatch;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_SUBSIDY_BATCH Service类
* @author:wanghan
* @createDate 2016-07-15 14:28:38 
* @version V1.0   
*/
@Service
public class SocialSubsidyBatchService extends BaseService<SocialSubsidyBatch>
{
	@Resource
	private SocialSubsidyBatchDao dao;
	
	
	
	public SocialSubsidyBatchService()
	{
	}
	
	@Override
	protected IEntityDao<SocialSubsidyBatch, Long> getEntityDao() 
	{
		return dao;
	}

	public void delByBatchId(Long batchId) {
		
		dao.delBySqlKey("delByBatchId", batchId);
	}
	
	public void delByBatchSubsidyId(Long batchId,Long subsidyId) {
		Map map =new HashedMap();
		map.put("batchId", batchId);
		map.put("subsidyId", subsidyId);
		dao.delBySqlKey("delByBatchSubsidyId", map);
	}
	
	public void batchAdd(List<SocialSubsidyBatch> batchList){
		if(batchList==null||batchList.size()<=0){
			throw new RuntimeException("该时间段没有补贴申报人员信息"); 
		}
		dao.batchAdd(batchList);
	}
	
	
}
