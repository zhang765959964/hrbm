package com.xunfeng.business.personagency.retired.interf;



import java.util.List;

import com.xunfeng.business.personagency.retired.model.WorkKj;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 主要工作扣减情况维护 接口类
* @author:zhangfan
* @createDate 2016-07-23 10:31:59 
* @version V1.0   
*/
public interface WorkKjServiceInterf extends GenericServiceInterface<WorkKj,Long>
{
	
	public void delByPersonId(Long personId);
	
	/**
	 * 保存或更新工作扣减信息
	 * @param workKj
	 */
	public void saveOrUpdate(WorkKj workKj);
	
	
	
	public ResultData<WorkKj> getAllByFilter(QueryFilter fiter);	
	
	
	public List getByPersonId(Long personId);
	
}
