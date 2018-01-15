package com.xunfeng.business.corp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.BookPayDao;
import com.xunfeng.business.corp.model.BookPay;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 支付记录表 Service类
* @author:wanghan
* @createDate 2016-04-13 18:02:30 
* @version V1.0   
*/
@Service
public class BookPayService extends BaseService<BookPay> 
{
	@Resource
	private BookPayDao dao;
	
	
	
	public BookPayService()
	{
	}
	
	@Override
	protected IEntityDao<BookPay, Long> getEntityDao() 
	{
		return dao;
	}
	
	
}
