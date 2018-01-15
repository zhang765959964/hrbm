package com.xunfeng.business.personagency.retired.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.business.personagency.retired.dao.WorkKjDao;
import com.xunfeng.business.personagency.retired.interf.WorkKjServiceInterf;
import com.xunfeng.business.personagency.retired.model.WorkKj;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作扣减情况维护 Service类
* @author:zhangfan
* @createDate 2016-07-23 10:31:59 
* @version V1.0   
*/
@Service
public class WorkKjService extends BaseService<WorkKj> implements WorkKjServiceInterf
{
	@Resource
	private WorkKjDao dao;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	public WorkKjService()
	{
	}
	
	@Override
	protected IEntityDao<WorkKj, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public void delByPersonId(Long personId) {
		dao.delByPersonId(personId);
	}

	@Override
	public void saveOrUpdate(WorkKj workKj) {
		
		WorkKj kj = dao.getById(workKj.getId());
		if(kj!=null){
			kj.setCreateTime(workKj.getCreateTime());
			kj.setEndTime(workKj.getEndTime());
			kj.setReason(workKj.getReason());
			kj.setKjTime(workKj.getKjTime());
			kj.setKjNum(workKj.getKjNum());
			dao.update(kj);
		}else{
			kj = new WorkKj();
			kj = BeanToBean.copyProperties(workKj,kj, false);
			uniqueIdUtilService.genId(WorkKj.class.getName());
			dao.add(kj);
		}
		
	}

	@Override
	public ResultData<WorkKj> getAllByFilter(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List<WorkKj> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public List getByPersonId(Long personId) {
		
		return dao.getByPersonId(personId);
	}




	
	
}
