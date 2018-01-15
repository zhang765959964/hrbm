package com.xunfeng.business.personagency.retired.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.core.db.BaseDao;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 养老待遇申请 Dao类
* @author:zhangfan
* @createDate 2016-07-25 16:20:07 
* @version V1.0   
*/
@Repository
public class YangLaoDao extends BaseDao<YangLao>
{
	@Override
	public Class<?> getEntityClass()
	{
		return YangLao.class;
	}
	
	/**
	 * 根据退休申诉id获得 养老待遇申请信息
	 * @return
	 */
	public YangLao getByRetiredId(Long retiredId){
		Map params = new HashMap<String, String>();
		params.put("retiredId",retiredId );
		return (YangLao)this.getOne("getByRetiredId", params);
	}
	
	
	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId){
		this.delBySqlKey("delByPersonId", personId);
		
	}
	
	/**
	 * 根据人员id查询养老信息
	 * @param personId
	 * @return
	 */
	public YangLao getByPersonId(Long personId){
		
		return this.getUnique("getByPersonId", personId);
	}
}