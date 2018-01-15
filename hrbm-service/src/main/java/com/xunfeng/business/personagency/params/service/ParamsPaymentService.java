package com.xunfeng.business.personagency.params.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.params.dao.ParamsPaymentDao;
import com.xunfeng.business.personagency.params.interf.ParamsPaymentServiceInterf;
import com.xunfeng.business.personagency.params.model.ParamsPayment;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PARAMS_PAYMENT Service类
* @author:wanghan
* @createDate 2016-09-05 09:47:42 
* @version V1.0   
*/
@Service
public class ParamsPaymentService extends BaseService<ParamsPayment> implements ParamsPaymentServiceInterf
{
	@Resource
	private ParamsPaymentDao dao;
	
	
	
	public ParamsPaymentService()
	{
	}
	
	@Override
	protected IEntityDao<ParamsPayment, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ParamsPayment> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ParamsPayment> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public ParamsPayment getParamsPayment(Date currentDate){
		
		Map paramMap=new HashMap();
		paramMap.put("currentDate", DateUtil.getformatterDate(currentDate,"yyyy-MM"));
		return dao.getUnique("getAll", paramMap);
		
	}
	
//   public ParamsPayment getAvailableParamsList(String startDate){
//		
//		Map paramMap=new HashMap();
//		paramMap.put("currentDate", DateUtil.getformatterDate(currentDate,"yyyy-MM"));
//		return dao.getUnique("getAll", paramMap);
//		
//	}
	
}
