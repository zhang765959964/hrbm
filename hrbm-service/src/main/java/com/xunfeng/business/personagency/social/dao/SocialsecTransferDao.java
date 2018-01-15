package com.xunfeng.business.personagency.social.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.personagency.social.model.SocialsecTransfer;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人社保统筹范围内转移表 Dao类
* @author:jiangxin
* @createDate 2016-08-12 15:39:20 
* @version V1.0   
*/
@Repository
public class SocialsecTransferDao extends BaseDao<SocialsecTransfer>
{
	@Override
	public Class<?> getEntityClass()
	{
		return SocialsecTransfer.class;
	}

}