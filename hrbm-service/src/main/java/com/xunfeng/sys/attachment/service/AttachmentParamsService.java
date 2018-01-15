package com.xunfeng.sys.attachment.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.attachment.model.AttachmentParams;
import com.xunfeng.sys.attachment.dao.AttachmentParamsDao;
import com.xunfeng.sys.attachment.interf.AttachmentParamsServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: PIC_UPLOAD Service类
* @author:wanghan
* @createDate 2016-04-18 16:53:33 
* @version V1.0   
*/
@Service
public class AttachmentParamsService extends BaseService<AttachmentParams> implements AttachmentParamsServiceInterf
{
	@Resource
	private AttachmentParamsDao dao;
	
	
	
	public AttachmentParamsService()
	{
	}
	
	@Override
	protected IEntityDao<AttachmentParams, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
