package com.xunfeng.business.personagency.retired.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.retired.dao.RetiredXhDao;
import com.xunfeng.business.personagency.retired.interf.RetiredXhServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredXh;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休序号历史记录表 Service类
* @author:zhangfan
* @createDate 2016-11-29 17:11:56 
* @version V1.0   
*/
@Service
public class RetiredXhService extends BaseService<RetiredXh> implements RetiredXhServiceInterf
{
	@Resource
	private RetiredXhDao dao;
	
	
	
	public RetiredXhService()
	{
	}
	
	@Override
	protected IEntityDao<RetiredXh, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<RetiredXh> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<RetiredXh> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}

	@Override
	public RetiredXh getByRetiredType(String type) {
		return this.dao.getByRetiredType(type);
	}

	@Override
	public void delByBm(String bm) {
		this.dao.delByBm(bm);
		
	}

	@Override
	public RetiredXh getByRetiredTypeOrBm(String type, String bm) {
		
		return this.dao.getByRetiredTypeOrBm(type, bm);
	}
	
}
