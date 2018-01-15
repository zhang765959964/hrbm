package com.xunfeng.business.ovemp.common.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.CommonQueryEnum;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.ovemp.common.dao.CommonModelDao;
import com.xunfeng.business.ovemp.common.interf.CommonServiceInterf;
import com.xunfeng.business.ovemp.common.model.CommonModel;
import com.xunfeng.business.ovemp.cooporg.model.OvempCoopOrg;
import com.xunfeng.business.ovemp.cooporg.dao.OvempCoopOrgDao;
import com.xunfeng.business.ovemp.cooporg.interf.OvempCoopOrgServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: JW_COOP_ORG Service类
* @author:wanghan
* @createDate 2016-09-12 11:06:38 
* @version V1.0   
*/
@Service
public class CommonService extends BaseService<CommonModel> implements CommonServiceInterf
{
	
	@Resource
	private CommonModelDao dao;
	
	public CommonService()
	{
	}
	
	@Override
	protected IEntityDao<CommonModel, Long> getEntityDao() 
	{
		return dao;
	}
	
	@Override
	public ResultData<Map<String, Object>> getCommonViewList(CommonQueryEnum commonQueryEnum,
			QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> dataList=(List<Map<String, Object>>)dao.getListForm(commonQueryEnum.getQueryKey(),queryFilter);
		ResultData<Map<String, Object>> resultData = new ResultData<Map<String, Object>>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	
}
