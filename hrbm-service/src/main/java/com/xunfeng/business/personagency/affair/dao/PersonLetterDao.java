package com.xunfeng.business.personagency.affair.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.affair.model.PersonLetter;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人事档案联系函表 Dao类
* @author:jiangxin
* @createDate 2016-09-14 09:32:03 
* @version V1.0   
*/
@Repository
public class PersonLetterDao extends BaseDao<PersonLetter>
{
	@Override
	public Class<?> getEntityClass()
	{
		return PersonLetter.class;
	}

}