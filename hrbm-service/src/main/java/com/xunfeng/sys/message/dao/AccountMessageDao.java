package com.xunfeng.sys.message.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.message.model.AccountMessage;

/**
 *<pre>
 * 对象功能:站内信表 Dao类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:03:04
 *</pre>
 */
@Repository
public class AccountMessageDao extends BaseDao<AccountMessage>
{
	@Override
	public Class<?> getEntityClass()
	{
		return AccountMessage.class;
	}
//	/**
//	 * 根据收件人会员号，获取统计信息
//	 * 返回信息包含：totalCount:总个数   unreadCount未读个数
//	 */
//	public AccountMessageStatisticsDto getStatisticsInfo(Long ccmr01){
//		List results =  this.getListBySqlKey("getStatsticsInfo",ccmr01);
//		return (AccountMessageStatisticsDto)results.get(0);
//	}
//
//	public void updateMessageStatus(Long ccmc01,String ccmc05){
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("ccmc01",ccmc01);
//		params.put("ccmc05",ccmc05);
//		this.update("updateMessageStatus",params);
//	}
	
	/**
	 * 获得站内信列表
	 * 2016-04-08
	 */
	public List<Map> getAllMessageMap(QueryFilter filter){
		return this.getListForm("getAllMessageMap",filter);
	}
	
	/**
	 * 通过账户id获得站内信总条数
	 * @return
	 */
	public Long getTotalCountMessageByCcmu01(Long ccmu01){
		return (Long) this.getOne("getTotalCountMessageByCcmu01", ccmu01);
	}
	
	
}