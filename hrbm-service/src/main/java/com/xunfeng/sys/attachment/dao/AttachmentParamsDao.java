package com.xunfeng.sys.attachment.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.attachment.model.AttachmentParams;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: PIC_UPLOAD Dao类
* @author:wanghan
* @createDate 2016-04-18 16:53:33 
* @version V1.0   
*/
@Repository
public class AttachmentParamsDao extends BaseDao<AttachmentParams>
{
	@Override
	public Class<?> getEntityClass()
	{
		return AttachmentParams.class;
	}

}