package com.xunfeng.business.train.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.business.train.model.TrainOrgType;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 培训机构类型表 接口类
* @author:Wang.CS
* @createDate 2016-05-23 09:31:02 
* @version V1.0   
*/
public interface TrainOrgTypeServiceInterf extends GenericServiceInterface<TrainOrgType,Long>
{
	/**
	 * 获取所有培训机构类型
	 * @author QINKUI
	 */
	public List<TrainOrgType> getAllTrainOrgType();
	
	/**
	 * 分页获取数据
	 */
	public ResultData<TrainOrgType> getTrainOrgTypeData(QueryFilter fiter);
	
	/**
	 * 批量更新培训机构类别的删除标志
	 */
	public int updateBatchDel(Map<String,Object> map);
	
	/**
	 * 根据typeId查询该机构类别下的子类别数
	 * @author QINKUI
	 */
	public Integer getCountByPId(Long typeId);
	
	/**
	 *  根据机构类别名称获取机构类别
	 */
	public TrainOrgType getOrgTypeByName(String orgTypeName);
	
	/**
	 * -根据机构类别Id 获取所有的子类别包括本身 
	 */
	public List<TrainOrgType> getSubTypeById(Long typeId);
	
}
