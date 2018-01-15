package com.xunfeng.business.personagency.archive.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案借阅记录表 Dao类
* @author:wanghan
* @createDate 2016-07-22 14:56:36 
* @version V1.0   
*/
@Repository
public class ArchiveCheckoutDao extends BaseDao<ArchiveCheckout>
{
	@Override
	public Class<?> getEntityClass()
	{
		return ArchiveCheckout.class;
	}
	public ResultData  getAllArchiveCheckout(QueryFilter fiter){
		List<Map> dataList = this.getListForm("getAllArchiveCheckout",fiter);		
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	public List  getBatchName(Long checkoutStatus){
		Map params=new HashMap();
		params.put("checkoutStatus", checkoutStatus);
		List dataList = this.getListBySqlKey("getBatchName", params);	
		return dataList;
	}
	public Long getCheckedByBatchName(String batchName){
		return (Long)this.getOne("getCheckedByBatchName", batchName);
	}

}