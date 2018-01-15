package com.xunfeng.business.personagency.retired.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.retired.dao.RetiredSocialDao;
import com.xunfeng.business.personagency.retired.interf.RetiredSocialServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredSocial;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员转社会化 Service类
* @author:zhangfan
* @createDate 2016-08-09 15:09:43 
* @version V1.0   
*/
@Service
public class RetiredSocialService extends BaseService<RetiredSocial> implements RetiredSocialServiceInterf
{
	@Resource
	private RetiredSocialDao dao;
	
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	
	
	
	public RetiredSocialService()
	{
	}
	
	@Override
	protected IEntityDao<RetiredSocial, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<RetiredSocial> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<RetiredSocial> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public ResultData getRetiredSocialList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList=dao.getBySqlKey("getRetiredSocial", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public RetiredSocial getByRetiredId(Long personId) {
		
		return dao.getByRetiredId(personId);
	}

	@Override
	public ResultData getRetiredSocialListJson(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList=dao.getBySqlKey("getRetiredSocialList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	

	@Override
	public void saveOrUpdate(Long[] arrId, RetiredSocial retiredSocial) {
		RetiredSocial retired;
		for (Long personId : arrId) {
			retired= this.getByRetiredId(personId); 
			if(retired!=null){
				retired.setPersonId(personId);
				retired.setRetiredSocialDate(retiredSocial.getRetiredSocialDate());
				retired.setRetiredSocialNo(retiredSocial.getRetiredSocialNo());
				retired.setRetiredSocialUnit(retiredSocial.getRetiredSocialUnit());
				retired.setRetiredSocialName(retiredSocial.getRetiredSocialName());
				retired.setCreaterId(retiredSocial.getCreaterId());
				retired.setCreaterName(retiredSocial.getCreaterName());
				retired.setCreaterDate(retiredSocial.getCreaterDate());
				retired.setCreaterOrgId(retiredSocial.getCreaterOrgId());
				retired.setCreaterOrgName(retiredSocial.getCreaterOrgName());
				retired.setIsRetiredSocial(1L);
				dao.update(retired);
			}else{
				retired = new RetiredSocial();
				retiredSocial.setPersonId(personId);
				retiredSocial.setId(uniqueIdUtilService.genId(RetiredSocial.class.getName()));
				retiredSocial.setIsRetiredSocial(1L);
				retiredSocial.setCreaterDate(new Date());
				retired.setCreaterId(retiredSocial.getCreaterId());
				retired.setCreaterName(retiredSocial.getCreaterName());
				retired.setCreaterDate(retiredSocial.getCreaterDate());
				retired.setCreaterOrgId(retiredSocial.getCreaterOrgId());
				retired.setCreaterOrgName(retiredSocial.getCreaterOrgName());
				BeanToBean.copyProperties(retiredSocial, retired, false);
				dao.add(retired);
			}
			 
			
			
		}
	}

	@Override
	public void delByPersonId(Long personId) {
		dao.delByPersonId(personId);
	}

	@Override
	public RetiredSocial getByPersonId(Long personId) {
		return dao.getByPersonId(personId);
	}
	
}
