package com.xunfeng.business.train.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.train.model.TrainCourseType;
import com.xunfeng.business.train.model.TrainOrgType;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班类型表 接口类
* @author:Wang.CS
* @createDate 2016-05-23 09:29:51 
* @version V1.0   
*/
public interface TrainCourseTypeServiceInterf extends GenericServiceInterface<TrainCourseType,Long>
{
	/**
	 * 实现分页显示数据
	 * @author QINKUI
	 */
	public ResultData<TrainCourseType> getAllTrainCourseType(QueryFilter fiter);
	
	/**
	 * 批量更新开班类别的删除标志
	 */
	public int updateBatchDel(Map<String,Object> map);
	
	/**
	 * 根据typeId查询该开班类别下的子类别数
	 * @author QINKUI
	 */
	public Integer getCountByPId(Long typeId);
	
	/**
	 *  根据开班类别名称获取开班类别
	 */
	public TrainCourseType getCourseTypeByName(String courseTypeName);
	
	 /**
	  * 根据课程类别Id 获取所有的子类别包括本身 
	  */
	public List<TrainCourseType> getSubTypeById(Long typeId);
}
