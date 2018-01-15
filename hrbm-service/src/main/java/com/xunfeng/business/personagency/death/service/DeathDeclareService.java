package com.xunfeng.business.personagency.death.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.death.dao.DeathDeclareDao;
import com.xunfeng.business.personagency.death.dto.DeathDeclareDto;
import com.xunfeng.business.personagency.death.interf.DeathDeclareServiceInterf;
import com.xunfeng.business.personagency.death.model.DeathDeclare;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 死亡待遇申报 Service类
* @author:zhangfan
* @createDate 2016-08-26 16:25:11 
* @version V1.0   
*/
@Service
public class DeathDeclareService extends BaseService<DeathDeclare> implements DeathDeclareServiceInterf
{
	@Resource
	private DeathDeclareDao dao;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	@Resource
	DeathPersonService deathPersonService;
	
	
	public DeathDeclareService()
	{
	}
	
	@Override
	protected IEntityDao<DeathDeclare, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<DeathDeclare> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<DeathDeclare> dataList=dao.getBySqlKey("deathDeclareList",  fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public Map getByPersonId(Long personId) {
		return  (Map)dao.getOne("getByPersonId", personId);
		
	}

	@Override
	public void saveOrUpdate(DeathDeclare deathDeclare) {
		
			DeathDeclare death = dao.getById(deathDeclare.getId());
			deathDeclare = BeanToBean.copyProperties(deathDeclare, death, false);
			if(deathDeclare!=null){
				dao.update(death);
			}else{
				death = new DeathDeclare();
				death.setId(uniqueIdUtilService.genId(DeathDeclare.class.getName()));
				death.setPersonId(deathDeclare.getPersonId());
				dao.add(death);
			}
	}

	@Override
	public DeathDeclare getByDeathPersonId(Long personId) {
	
		return dao.getUnique("getByDeathPersonId", personId);
	}

	@Override
	public  ResultData getByPersonIdOraAchiveCode(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List<DeathDeclare> dataList=dao.getBySqlKey("deathDeclareList",  fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	@Override
	public void delByPersonId(Long personId) {
		if(personId!=null){
			dao.delByPersonId(personId);
			deathPersonService.delByPersonId(personId);
		}
	}
	@Override
	public ResultData getByvPersonId(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList=dao.getBySqlKey("getByvPersonId",fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Map getPrintDeathList(String personIds) {
		return dao.getPrintDeathList(personIds);
	}
	
}
