package com.xunfeng.business.jobfair.dao;

import com.xunfeng.business.jobfair.model.BoothBook;
import com.xunfeng.core.db.BaseDao;

import org.springframework.stereotype.Repository;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位预定表 Dao类
* @author:wanghan
* @createDate 2015-09-12 15:43:12 
* @version V1.0   
*/
@Repository
public class BoothBookDao extends BaseDao<BoothBook>
{
	@Override
	public Class<?> getEntityClass()
	{
		return BoothBook.class;
	}

	public BoothBook getByIdForUpdate(Long primaryKey) {
		
		return super.getUnique("getByIdForUpdate", primaryKey);
	}
	
	

}