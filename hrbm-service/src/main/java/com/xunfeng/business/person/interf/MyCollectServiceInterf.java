package com.xunfeng.business.person.interf;


import java.util.Map;

import com.xunfeng.business.person.model.MyCollect;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 我的关注表 接口类
* @author:wangyanyan
* @createDate 2016-04-06 15:59:59 
* @version V1.0   
*/
public interface MyCollectServiceInterf extends GenericServiceInterface<MyCollect,Long>
{
	/**
	 * 获取收藏的企业
	 */
	public ResultData<Map> getAllCorpInterestTalent(QueryFilter filter);
	/**
	 * 判断用户当前用户是否收藏了企业
	 */
	public boolean isCollectCompany(Long collectUserid,Long beCollectUserid);
	/**
	 * 通过被收藏和收藏id删除记录
	 */
	public void delByCollectUseridAndBeCollectUserid(Long collectUserid,Long beCollectUserid);
}
