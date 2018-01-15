package com.xunfeng.business.laborcollection.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.business.laborcollection.model.LaborAcpost;
import com.xunfeng.business.laborcollection.dao.LaborAcpostDao;
import com.xunfeng.business.laborcollection.interf.LaborAcpostServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 不在岗情况信息表 Service类
* @author:wangyanyan
* @createDate 2016-06-24 09:46:09 
* @version V1.0   
*/
@Service
public class LaborAcpostService extends BaseService<LaborAcpost> implements LaborAcpostServiceInterf
{
	@Resource
	private LaborAcpostDao dao;
	
	
	
	public LaborAcpostService()
	{
	}
	
	@Override
	protected IEntityDao<LaborAcpost, Long> getEntityDao() 
	{
		return dao;
	}
	@Override
	public LaborAcpost getByAcpost(Long aac001) {
		// TODO Auto-generated method stub
		return (LaborAcpost) dao.getOne("getByAcpost",aac001);
	}
	/**详情页面查询信息**/
	public LaborAcpost getByAac001(Long aac001) {
		// TODO Auto-generated method stub
		return (LaborAcpost) dao.getOne("getByAac001",aac001);
	}
	
}
