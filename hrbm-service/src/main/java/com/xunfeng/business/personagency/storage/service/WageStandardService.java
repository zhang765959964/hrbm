package com.xunfeng.business.personagency.storage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.personagency.receive.model.ProxyManual;
import com.xunfeng.business.personagency.storage.model.WageStandard;
import com.xunfeng.business.personagency.storage.dao.WageStandardDao;
import com.xunfeng.business.personagency.storage.interf.WageStandardServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工资标准表 Service类
* @author:jiangxin
* @createDate 2016-08-17 11:06:20 
* @version V1.0   
*/
@Service
public class WageStandardService extends BaseService<WageStandard> implements WageStandardServiceInterf
{
	@Resource
	private WageStandardDao dao;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	@Resource
	private PersonExpandService personExpandService;
	
	public WageStandardService()
	{
	}
	
	@Override
	protected IEntityDao<WageStandard, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<WageStandard> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<WageStandard> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	public Map getWageStandardById(Long id){
		Map params=new HashMap();
		params.put("id", id);
		params.put("ccpr08", 0);
		return (Map)dao.getOne("getWageStandardById", params);
	}
	
	/**
	 * @param lAryId  删除工资标准调整
	 */
	public void delWageStandardByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long pmId : lAryId){
			WageStandard ws = dao.getById(pmId);
			ws.setCcpr08("1");
			dao.update(ws);
		}
	}
	public void addWageStandard(WageStandard wageStandard){
		if(wageStandard!=null){
			dao.add(wageStandard);
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(wageStandard.getPersonId());
			personBaseInfo.setAac006(wageStandard.getAac006());
			personBaseInfo.setAac011(wageStandard.getAac011());
			personBaseInfoService.update(personBaseInfo);
			PersonExpand personExpand = personExpandService.getByExpPersonId(wageStandard.getPersonId());
			personExpand.setExpStartJobDate(wageStandard.getExpStartJobDate());
			personExpandService.update(personExpand);
		}else{
			throw new RuntimeException("添加工资标准调整出现错误，请联系管理员！"); 
		}
	}
	public void updateWageStandard(WageStandard wageStandard){
		if(wageStandard!=null){
			dao.update(wageStandard);
			PersonBaseInfo personBaseInfo = personBaseInfoService.getById(wageStandard.getPersonId());
			personBaseInfo.setAac006(wageStandard.getAac006());
			personBaseInfo.setAac011(wageStandard.getAac011());
			personBaseInfoService.update(personBaseInfo);
			PersonExpand personExpand = personExpandService.getByExpPersonId(wageStandard.getPersonId());
			personExpand.setExpStartJobDate(wageStandard.getExpStartJobDate());
			personExpandService.update(personExpand);
		}else{
			throw new RuntimeException("修改工资标准调整出现错误，请联系管理员！"); 
		}
	}
}
