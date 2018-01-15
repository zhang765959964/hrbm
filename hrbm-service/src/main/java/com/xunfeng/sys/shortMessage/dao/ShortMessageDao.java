package com.xunfeng.sys.shortMessage.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.shortMessage.model.ShortMessage;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 短信发送内容表 Dao类
* @author:wanlupeng
* @createDate 2016-08-15 15:17:45 
* @version V1.0   
*/
@Repository
public class ShortMessageDao extends BaseDao<ShortMessage>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ShortMessage.class;
	}

}