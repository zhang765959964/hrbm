package com.xunfeng.business.personagency.affair.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.affair.model.PersonLetter;
import com.xunfeng.business.personagency.affair.dao.PersonLetterDao;
import com.xunfeng.business.personagency.affair.interf.PersonLetterServiceInterf;
import com.xunfeng.business.personagency.receive.model.ProxyManual;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人事档案联系函表 Service类
* @author:jiangxin
* @createDate 2016-09-14 09:32:03 
* @version V1.0   
*/
@Service
public class PersonLetterService extends BaseService<PersonLetter> implements PersonLetterServiceInterf
{
	@Resource
	private PersonLetterDao dao;
	
	
	
	public PersonLetterService()
	{
	}
	
	@Override
	protected IEntityDao<PersonLetter, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<PersonLetter> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<PersonLetter> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	//删除人事档案联系函
	public void deletePersonLetterByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long id : lAryId){
			PersonLetter personLetter = dao.getById(id);
			personLetter.setCcpr08("1");
			dao.update(personLetter);
		}
	}
	//取得打印数据
	public Map getPersonLetterById(Long id){
		Map params=new HashMap();
		params.put("id", id);
		params.put("ccpr08", 0);
		return (Map)dao.getOne("getPersonLetterById", params);
	}
	
}
