package com.xunfeng.business.advert.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.advert.dao.AdCategoryDao;
import com.xunfeng.business.advert.interf.AdCategoryServiceInterf;
import com.xunfeng.business.advert.model.AdCategory;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告类别表 Service类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
@Service
public class AdCategoryService extends BaseService<AdCategory> implements AdCategoryServiceInterf
{
	@Resource
	private AdCategoryDao dao;
	
	
	
	public AdCategoryService()
	{
	}
	
	@Override
	protected IEntityDao<AdCategory, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData getAllByExcept(QueryFilter queryFilter){
    	List<Map> dataList = dao.getListForm("getAllCategoryByExcept",queryFilter);		
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	public List<Map<String,Object>> getNameListByExcept(long caac06){
		return dao.getListBySqlKey("getNameListByExcept", caac06);
	}
	/**
	 * 通过标示获得记录
	 * @param indent
	 * @return
	 */
	public AdCategory getByIndent(String indent){
		return (AdCategory) dao.getOne("getByIndent", indent);
	}
	
}
