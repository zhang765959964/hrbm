package com.xunfeng.business.personagency.receive.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.personagency.receive.model.CorpPerson;
import com.xunfeng.business.personagency.receive.dao.CorpPersonDao;
import com.xunfeng.business.personagency.receive.interf.CorpPersonServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位人员关系表 Service类
* @author:wanghan
* @createDate 2016-08-09 09:11:37 
* @version V1.0   
*/
@Service
public class CorpPersonService extends BaseService<CorpPerson> implements CorpPersonServiceInterf
{
	@Resource
	private CorpPersonDao dao;
	
	
	
	public CorpPersonService()
	{
	}
	
	@Override
	protected IEntityDao<CorpPerson, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<CorpPerson> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<CorpPerson> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public CorpPerson getCorpPerson(Long corpId ,Long personId){
		Map params=new HashMap();
		params.put("corpId", corpId);
		params.put("personId", personId);
		CorpPerson corpPerson = dao.getUnique("getCorpPerson", params);
		return corpPerson;
	}
	//获取条数数据
	public Long getArchivesCountByCorpId(String corpId){
		Map params=new HashMap();
		params.put("corpId", corpId);
		return (Long)dao.getOne("getArchivesCountByCorpId", params);
	}
}
