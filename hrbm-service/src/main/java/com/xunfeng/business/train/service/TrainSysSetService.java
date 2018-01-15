package com.xunfeng.business.train.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.train.dao.TrainSysSetDao;
import com.xunfeng.business.train.interf.TrainSysSetServiceInterf;
import com.xunfeng.business.train.model.TrainSysSet;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训系统设置表 Service类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:57 
* @version V1.0   
*/
@Service
public class TrainSysSetService extends BaseService<TrainSysSet> implements TrainSysSetServiceInterf
{
	@Resource
	private TrainSysSetDao dao;
	
	
	
	public TrainSysSetService()
	{
	}
	
	@Override
	protected IEntityDao<TrainSysSet, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public ResultData<TrainSysSet> getAllTrainSysSet(QueryFilter fiter) {
		
		ResultData<TrainSysSet> resultData=new ResultData<TrainSysSet>();
		List<TrainSysSet> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	public TrainSysSet getByCaos02(String caos02){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("caos02", caos02);
		List<TrainSysSet> list=dao.getBySqlKey("getByCaos02", map);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
}
