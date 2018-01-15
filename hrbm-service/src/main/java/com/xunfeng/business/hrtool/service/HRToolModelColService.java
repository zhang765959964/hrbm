package com.xunfeng.business.hrtool.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.hrtool.dao.HRToolModelColDao;
import com.xunfeng.business.hrtool.interf.HRToolModelColServiceInterf;
import com.xunfeng.business.hrtool.model.HRToolModel;
import com.xunfeng.business.hrtool.model.HRToolModelCol;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工具箱模板栏目表 Service类
* @author:wanghan
* @createDate 2016-03-08 14:20:33 
* @version V1.0   
*/
@Service
public class HRToolModelColService extends BaseService<HRToolModelCol> implements HRToolModelColServiceInterf
{
	@Resource
	private HRToolModelColDao dao;
	
	
	
	public HRToolModelColService()
	{
	}
	
	@Override
	protected IEntityDao<HRToolModelCol, Long> getEntityDao() 
	{
		return dao;
	}

	
}
