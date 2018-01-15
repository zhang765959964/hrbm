package com.xunfeng.business.advert.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.business.advert.model.AdCategory;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告类别表 接口类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public interface AdCategoryServiceInterf extends GenericServiceInterface<AdCategory,Long>
{
	/**
	 * 取得公告分类页面的数据
	 **/
	public ResultData getAllByExcept(QueryFilter queryFilter);
	

	/**
	 * 取得网站，公司，职位 页面公告分类的数据
	 **/
	public List<Map<String,Object>> getNameListByExcept(long flag);
	
	/**
	 * 通过标示获得记录
	 * @param indent
	 * @return
	 */
	public AdCategory getByIndent(String indent);
}
