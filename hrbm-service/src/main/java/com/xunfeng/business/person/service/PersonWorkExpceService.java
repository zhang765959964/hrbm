package com.xunfeng.business.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.PersonWorkExpceDao;
import com.xunfeng.business.person.interf.PersonWorkExpceServiceInterf;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.business.personagency.receive.model.ProxyManual;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;

/**
 *<pre>
 * 对象功能:个人工作经历表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:00:45
 *</pre>
 */
@Service
public class PersonWorkExpceService extends BaseService<PersonWorkExpce> implements PersonWorkExpceServiceInterf
{
	@Resource
	private PersonWorkExpceDao dao;
	
	
	
	public PersonWorkExpceService()
	{
	}
	
	@Override
	protected IEntityDao<PersonWorkExpce, Long> getEntityDao()
	{
		return dao;
	}
	/**
	 * 获得个人工作经历（简历）信息分页（公办系统）
	 */
	public ResultData<PersonWorkExpce> getAllWorkExpce(QueryFilter fiter){
		
		ResultData<PersonWorkExpce> resultData=new ResultData<PersonWorkExpce>();
		List<PersonWorkExpce> dataList =dao.getBySqlKey("getAllWorkExpce", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	public  List<PersonWorkExpce> getPersonWorkExpceList(Long aac001){
		
		Map params=new HashMap();
		params.put("aac001", aac001);
		params.put("ccpr08", "0");
		return dao.getListBySqlKey("getAll",params);
		
	}
	/**
	 * @param personId
	 * @return 根据个人id查询个人工作情况
	 */
	public Map getPersonWorkExpceByPersonId(Long personId){
		Map params=new HashMap();
		params.put("AAC001", personId);
		params.put("CCPR08", "0");
		return (Map)dao.getOne("getPersonWorkExpceByPersonId", params);
	}
	public ResultData<PersonWorkExpce> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PersonWorkExpce> dataList =dao.getBySqlKey("getAllWorkExpce", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	/**
	 * @param lAryId  删除个人工作经历
	 */
	public void deletePersonWorkExpceByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long aac0b0 : lAryId){
			PersonWorkExpce pe = dao.getById(aac0b0);
			if(pe!=null){
				pe.setCcpr08("1");
				dao.update(pe);
			}
		}
	}
	
	//查询工作经历
	public List<PersonWorkExpce> getByExist(QueryFilter fiter){
		return dao.getBySqlKey("getByExist",fiter);
	};
	
	
}
