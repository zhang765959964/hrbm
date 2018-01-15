package com.xunfeng.business.personagency.subsidy.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidyBatch;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴 Dao类
* @author:wanghan
* @createDate 2016-07-06 11:03:39 
* @version V1.0   
*/
@Repository
public class SocialSubsidyDao extends BaseDao<SocialSubsidy>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SocialSubsidy.class;
	}
	public void batchUpdate(List<SocialSubsidy> socialSubsidyList){
		
		 this.insert("batchUpdate_"+this.getDbType(), socialSubsidyList);
	}
	@Override
	public void add(SocialSubsidy entity) {
		entity.setCreaterNum("1");
		super.add(entity);
	}
	@Override
	public int update(SocialSubsidy entity) {
		Integer oldNUm=StringUtil.isEmpty(entity.getCreaterNum())?0:Integer.valueOf(entity.getCreaterNum());
		oldNUm++;
		entity.setCreaterNum(oldNUm.toString());
		return super.update(entity);
	}
	
	
}