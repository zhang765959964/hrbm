package com.xunfeng.business.personagency.death.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.death.dao.DeathPersonDao;
import com.xunfeng.business.personagency.death.interf.DeathPersonServiceInterf;
import com.xunfeng.business.personagency.death.model.DeathPerson;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 供养直系亲属情况 Service类
* @author:zhangfan
* @createDate 2016-08-30 10:12:09 
* @version V1.0   
*/
@Service
public class DeathPersonService extends BaseService<DeathPerson> implements DeathPersonServiceInterf
{
	@Resource
	private DeathPersonDao dao;
	
	
	
	public DeathPersonService()
	{
	}
	
	@Override
	protected IEntityDao<DeathPerson, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<DeathPerson> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<DeathPerson> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public void delByPersonId(Long personId) {
		dao.delByPersonId(personId);
	}

	@Override
	public ResultData<DeathPerson> getByvPersonId(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List<DeathPerson> dataList=dao.getBySqlKey("getByvPersonId", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public ResultData getByvDeathPerson(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List<DeathPerson> dataList=dao.getBySqlKey("getByvDeathPerson", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
}
