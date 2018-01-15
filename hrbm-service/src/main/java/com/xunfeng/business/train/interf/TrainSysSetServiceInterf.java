package com.xunfeng.business.train.interf;


import com.xunfeng.business.train.model.TrainSysSet;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训系统设置表 接口类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:57 
* @version V1.0   
*/
public interface TrainSysSetServiceInterf extends GenericServiceInterface<TrainSysSet,Long>
{
	/**
	 * 实现分页显示数据
	 * @author QINKUI
	 */
	public ResultData<TrainSysSet> getAllTrainSysSet(QueryFilter fiter);
	public TrainSysSet getByCaos02(String caos02);
	
}
