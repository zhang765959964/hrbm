package com.xunfeng.sys.sendmessage.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 短信模版表 Dao类
* @author:wanghan
* @createDate 2016-04-25 14:56:37 
* @version V1.0   
*/
@Repository
public class MessageTemplatesDao extends BaseDao<MessageTemplates>
{
	@Override
	public Class<?> getEntityClass()
	{
		return MessageTemplates.class;
	}

}