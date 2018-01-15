package com.xunfeng.business.corp.dao;

import com.xunfeng.business.corp.dto.CorpInterestTalentDto;
import com.xunfeng.business.corp.dto.CorpTalentFavoritesDto;
import com.xunfeng.business.corp.model.CorpTalentFavorites;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 企业人才收藏夹 Dao类
* @author:wxl
* @createDate 2015-07-25 09:38:50 
* @version V1.0   
*/
@Repository
public class CorpTalentFavoritesDao extends BaseDao<CorpTalentFavorites>
{
	@Override
	public Class<?> getEntityClass()
	{
		return CorpTalentFavorites.class;
	}
	/**
	 * 获取企业人才库
	 */
	public List<CorpTalentFavoritesDto> getAllCorpTalentFavorites(QueryFilter filter){
		return this.getListForm("getAllCorpTalentFavorites",filter);
	}


	/**
	 * 获取企业感兴趣的人才
	 */
	public List<CorpInterestTalentDto> getAllCorpInterestTalent(QueryFilter filter){
		return this.getListForm("getAllCorpInterestTalent",filter);
	}
	/**
	 * 删除企业人才库中的人才
	 */
	public void delCorpTalentFavorites(Long ccpg01){
		this.update("delCorpTalentFavorites",ccpg01);
	}


}