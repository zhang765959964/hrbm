package com.xunfeng.business.train.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.train.model.TrainCourse;
import com.xunfeng.business.train.model.TrainSignUp;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训报名表 接口类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:31 
* @version V1.0   
*/
public interface TrainSignUpServiceInterf extends GenericServiceInterface<TrainSignUp,Long>
{
	public Map getCountByCourseId(Long id);
	
	public Map getCountByUserId(Long userId,Long courseId);
	
	/**
	 * @author QINKUI
	 * 获取所有的个人报名管理信息
	 */
	public List<Object> getTrainSignUpList(Map<String,Object> paramMap);
	
	/**
	 * 实现分页显示数据
	 * @author QINKUI
	 */
	public ResultData<TrainSignUp> getAllTrainSignUpData(QueryFilter fiter);
	
	/**
	 * 实现分页显示数据
	 * @author QINKUI
	 */
	public List<Map<String,Object>> getAllDataSourses();
	
	/**
	 * 批量更新个人报名状态
	 * @author QINKUI
	 */
	public int updateBatchTrainSignUp(Map<String,Object> paramMap);
	/**
	 * 初始化查看状态
	 * @author QINKUI
	 */
	public int updateIsCheck();
	/**
	 * 初始化联系状态
	 * @author QINKUI
	 */
	public int updateIsContact();
}
