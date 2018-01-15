package com.xunfeng.business.person.dao;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.person.model.MyCollect;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 我的收藏表 Dao类
* @author:wangyanyan
* @createDate 2016-04-08 11:08:18 
* @version V1.0   
*/
@Repository
public class MyCollectDao extends BaseDao<MyCollect>
{
	@Override
	public Class<?> getEntityClass()
	{
		return MyCollect.class;
	}
	
	/**
	 * 获取收藏的企业
	 */
	public ResultData<Map> getAllCollectCompany(QueryFilter filter){
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setDataList(this.getListForm("getCollectCompany",filter));
		resultData.setPageBean(filter.getPageBean());
		return resultData;
	}
	
	/**
	 * 判断用户当前用户是否收藏了企业
	 */
	public boolean isCollectCompany(Long collectUserid,Long beCollectUserid){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("collectUserid", collectUserid);
		map.put("beCollectUserid", beCollectUserid);
		Long totalCount = (Long) this.getOne("getTotalCountCollectCompany", map);
		return totalCount >0l?true:false;
	}
	/**
	 * 通过被收藏和收藏id删除记录
	 */
	public void delByCollectUseridAndBeCollectUserid(Long collectUserid,Long beCollectUserid){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("collectUserid", collectUserid);
		map.put("beCollectUserid", beCollectUserid);
		this.update("delByUserIdAndBeuserId", map);
	}
}