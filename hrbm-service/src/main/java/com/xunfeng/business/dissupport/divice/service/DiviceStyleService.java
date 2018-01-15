package com.xunfeng.business.dissupport.divice.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.dissupport.divice.model.DiviceStyle;
import com.xunfeng.business.dissupport.divice.dao.DiviceStyleDao;
import com.xunfeng.business.dissupport.divice.interf.DiviceStyleServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 样式表 Service类
* @author:wanghan
* @createDate 2016-07-27 17:06:34 
* @version V1.0   
*/
@Service
public class DiviceStyleService extends BaseService<DiviceStyle> implements DiviceStyleServiceInterf
{
	@Resource
	private DiviceStyleDao dao;
	
	
	
	public DiviceStyleService()
	{
	}
	
	@Override
	protected IEntityDao<DiviceStyle, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
