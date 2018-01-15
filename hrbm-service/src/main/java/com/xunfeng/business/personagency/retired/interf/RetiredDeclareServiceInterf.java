package com.xunfeng.business.personagency.retired.interf;


import java.util.List;
import java.util.Map;

import com.xunfeng.business.personagency.retired.dto.RetiredAllDto;
import com.xunfeng.business.personagency.retired.dto.RetiredDeclareDto;
import com.xunfeng.business.personagency.retired.dto.RetiredYlDto;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员申报表 接口类
* @author:zhangfan
* @createDate 2016-07-16 11:24:12 
* @version V1.0   
*/
public interface RetiredDeclareServiceInterf extends GenericServiceInterface<RetiredDeclare,Long>
{
	
	/**
	 * @param personId
	 * @return 根据个人id查询个人和档案信息
	 * getRetiredByPersonId
	 */
	public Map getRetiredByPersonId(Long personId);
	
	
	/**
	 * 根据id获得养老待遇申请信息
	 * @param id
	 * @return
	 */
	public Map getRetiredById(Long id);
	
	

	
	/**
	 * 查看申报信息
	 * @param personId
	 * @return
	 */
	public RetiredDeclare getByPersonId(Long peopleId);
	
	
	
	/**
	 * 更新个人基本信息，保存退休申诉信息
	 */
	public boolean saveOrUpdateRetired(RetiredDeclareDto retiredDeclareDto);
	
	
	/**
	 * 更新代理退休信息
	 */
	public void updateReitedAll(RetiredAllDto retiredAllDto);
	
	
	/**
	 * 更新退休申报状态
	 */
	public void updateRetiredStatus(RetiredYlDto retiredYlDto);
	
	
	
	
	/**
	 * 返回退休申报主键id
	 * @param peopleId
	 * @return
	 */
	public RetiredDeclare getPeopleId(Long peopleId);
	
	
	
	/**
	 * 查询退休申诉列表信息
	 * @param fiter
	 * @return
	 */
	public ResultData<RetiredDeclare> getRetiredList(QueryFilter fiter);
	
	
	
	/**
	 * 批量更新确定退休信息
	 * @param ids
	 * @param retiredStatus 退休状态
	 * @param retiredDeclareStatus	申报状态
	 */
	public void review(Long[] ids,String retiredStatus,String retiredDeclareStatus);
	
	
	/**
	 * 更新退休编号
	 * @param id
	 * @param xh
	 * @param retiredBm
	 * @param retiredNote
	 */
	public void updateRetiredBh(Long id,String xh,String retiredPeopleBm,String declareNote);

	/**
	 * 退休编号列表查询信息
	 * @param fiter
	 * @return
	 */
	public ResultData getRetiredBhList(QueryFilter fiter);
	
	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId);
	
	
	
	/**
	 * 获得退休人员信息
	 * @param fiter
	 * @return
	 */
	public ResultData getRetiredAll(QueryFilter fiter);
	
	
	/**
	 * 验证退休个人编码是否重复
	 * @param retiredBm
	 * @return
	 */
	public Long getByRetiredBm(String retiredBm);
	
	
	/**
	 * 验证退休个人编码是否重复
	 * @param fiter
	 * @return
	 */
	public List<RetiredDeclare> getByExitBm(QueryFilter fiter);
	
	
	/**
	 * 根据人员id获得退休模板打印信息
	 * @param personId
	 * @return
	 */
	public Map getPrintByPersonId(Long personId);
	
}
