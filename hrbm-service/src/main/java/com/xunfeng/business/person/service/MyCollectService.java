package com.xunfeng.business.person.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.MyCollectDao;
import com.xunfeng.business.person.interf.MyCollectServiceInterf;
import com.xunfeng.business.person.model.MyCollect;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 我的关注表 Service类
* @author:wangyanyan
* @createDate 2016-04-06 15:59:59 
* @version V1.0   
*/
@Service
public class MyCollectService extends BaseService<MyCollect> implements MyCollectServiceInterf
{
	@Resource
	private MyCollectDao dao;
	
	
	
	public MyCollectService()
	{
	}
	
	@Override
	protected IEntityDao<MyCollect, Long> getEntityDao() 
	{
		return dao;
	}
	
	/**
	 * 获取收藏的企业
	 */
	public ResultData<Map> getAllCorpInterestTalent(QueryFilter filter){
		return dao.getAllCollectCompany(filter);
	}
	/**
	 * 判断用户当前用户是否收藏了企业
	 */
	public boolean isCollectCompany(Long collectUserid,Long beCollectUserid){
		return dao.isCollectCompany(collectUserid, beCollectUserid);
	}
	/**
	 * 通过被收藏和收藏id删除记录
	 */
	public void delByCollectUseridAndBeCollectUserid(Long collectUserid,Long beCollectUserid){
		dao.delByCollectUseridAndBeCollectUserid(collectUserid, beCollectUserid);
	}
}
