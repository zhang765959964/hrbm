package com.xunfeng.sys.shortMessage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.shortMessage.model.ShortMessage;
import com.xunfeng.sys.shortMessage.dao.ShortMessageDao;
import com.xunfeng.sys.shortMessage.interf.ShortMessageServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 短信发送内容表 Service类
* @author:wanlupeng
* @createDate 2016-08-15 15:17:45 
* @version V1.0   
*/
@Service
public class ShortMessageService extends BaseService<ShortMessage> implements ShortMessageServiceInterf
{
	@Resource
	private ShortMessageDao dao;
	
	
	
	public ShortMessageService()
	{
	}
	
	@Override
	protected IEntityDao<ShortMessage, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ShortMessage> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ShortMessage> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	
}
