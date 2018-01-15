package com.xunfeng.business.ovemp.corp.interf;


import java.util.Map;

import com.xunfeng.business.ovemp.corp.model.OvempCorpCourseType;
import com.xunfeng.business.ovemp.corp.model.OvempCorpType;
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
public interface OvempCorpCourseTypeServiceInterf extends GenericServiceInterface<OvempCorpCourseType,Long>
{
	/**
	 * 实现分页显示数据
	 * @author QINKUI
	 */
	public ResultData<OvempCorpCourseType> getAllTrainCourseType(QueryFilter fiter);
	
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
	public OvempCorpCourseType getCourseTypeByName(String courseTypeName);
}
