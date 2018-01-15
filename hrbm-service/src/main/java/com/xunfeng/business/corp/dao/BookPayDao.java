package com.xunfeng.business.corp.dao;

import org.springframework.stereotype.Repository;
import com.xunfeng.core.db.BaseDao;
import com.xunfeng.business.corp.model.BookPay;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 支付记录表 Dao类
* @author:wanghan
* @createDate 2016-04-13 18:02:30 
* @version V1.0   
*/
@Repository
public class BookPayDao extends BaseDao<BookPay>
{
	@Override
	public Class<?> getEntityClass()
	{
		return BookPay.class;
	}

}