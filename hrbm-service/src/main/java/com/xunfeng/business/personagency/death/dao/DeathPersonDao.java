package com.xunfeng.business.personagency.death.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.death.model.DeathPerson;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 供养直系亲属情况 Dao类
* @author:zhangfan
* @createDate 2016-08-30 10:12:09 
* @version V1.0   
*/
@Repository
public class DeathPersonDao extends BaseDao<DeathPerson>
{
	@Override
	public Class<?> getEntityClass()
	{
		return DeathPerson.class;
	}

	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
		
	}
	
}