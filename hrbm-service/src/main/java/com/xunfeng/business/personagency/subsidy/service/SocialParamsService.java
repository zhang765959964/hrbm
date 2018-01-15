package com.xunfeng.business.personagency.subsidy.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.payment.model.PaymentMain;
import com.xunfeng.business.personagency.subsidy.dao.SocialParamsDao;
import com.xunfeng.business.personagency.subsidy.interf.SocialParamsServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴参数 Service类
* @author:wanghan
* @createDate 2016-07-07 10:26:13 
* @version V1.0   
*/
@Service
public class SocialParamsService extends BaseService<SocialParams> implements SocialParamsServiceInterf
{
	@Resource
	private SocialParamsDao dao;
	
	public ResultData<SocialParams> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<SocialParams> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	@Override
	public void add(SocialParams entity) {
		String paramsCode=entity.getParamsCode();
		SocialParams socialParams=null;
		if("1".equals(paramsCode)){
			 socialParams=getPensionSocialParams(entity.getStartDate());
			if(socialParams==null){
				socialParams=getPensionSocialParams(entity.getEndDate());
			}

		}else{
			 socialParams=getMedicalSocialParams(entity.getStartDate());
			if(socialParams==null){
				socialParams=getMedicalSocialParams(entity.getEndDate());
			}
			
		}
		if(socialParams!=null){
			
			throw new RuntimeException("日期设置重复");
		}
		super.add(entity);
	}
	@Override
	public void update(SocialParams entity) {
		String paramsCode=entity.getParamsCode();
		SocialParams socialParams=null;
		if("1".equals(paramsCode)){
			 socialParams=getPensionSocialParams(entity.getStartDate());
			if(socialParams==null){
				socialParams=getPensionSocialParams(entity.getEndDate());
			}

		}else{
			 socialParams=getMedicalSocialParams(entity.getStartDate());
			if(socialParams==null){
				socialParams=getMedicalSocialParams(entity.getEndDate());
			}
			
		}
		if(socialParams!=null&&entity.getId().compareTo(socialParams.getId())!=0){
			
			throw new RuntimeException("日期设置重复");
		}
		super.update(entity);
	}

	public SocialParamsService()
	{
	}
	
	@Override
	protected IEntityDao<SocialParams, Long> getEntityDao() 
	{
		return dao;
	}
	
	public SocialParams getPensionSocialParams(Date currentDate){
		
		return getPensionSocialParams(DateUtil.getformatterDate(currentDate,"yyyy-MM"));
		
	}
	
	public SocialParams getMedicalSocialParams(Date currentDate){
		return getMedicalSocialParams(DateUtil.getformatterDate(currentDate,"yyyy-MM"));
	}
	
	private SocialParams getPensionSocialParams(String currentDate){
		
		Map paramMap=new HashMap();
		paramMap.put("paramsCode", "1");
		paramMap.put("currentDate", currentDate);
		return dao.getUnique("getAll", paramMap);
		
	}
	
	private SocialParams getMedicalSocialParams(String currentDate){
		Map paramMap=new HashMap();
		paramMap.put("paramsCode", "2");
		paramMap.put("currentDate", currentDate);
		return dao.getUnique("getAll", paramMap);
	}
}
