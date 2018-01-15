package com.xunfeng.business.personagency.retired.interf;


import com.xunfeng.business.personagency.retired.dto.RetiredYlDto;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.core.service.GenericServiceInterface;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 养老待遇申请 接口类
* @author:zhangfan
* @createDate 2016-07-25 16:20:07 
* @version V1.0   
*/
public interface YangLaoServiceInterf extends GenericServiceInterface<YangLao,Long>
{
	
	/**
	 * 根据退休人员id判断  是否添加或者更新
	 * @param retiredId
	 */
	public void saveOrUpdate(RetiredYlDto retiredYlDto);
		
		
	/**
	 * 根据退休id获得 养老信息
	 * @param retiredId
	 * @return
	 */
	public YangLao getByRetiredId(Long retiredId);
	
	/**
	 * 批量增加 更新养老申请
	 * @param arrId
	 * @param yangLao
	 */
	public void saveOrUpdatePl(Long [] arrId,YangLao yangLao);
	
	
	/**
	 * 批量增加  更新养老申请
	 * @param arrId
	 * @param retiredYlDto
	 */
	public void saveOrRetiredPl(Long [] arrId,RetiredYlDto retiredYlDto);
	
	/**
	 * 根据人员id删除信息
	 * @param personId
	 */
	public void delByPersonId(Long personId);
	
	/**
	 * 根据人员id查询养老信息
	 * @param personId
	 * @return
	 */
	public YangLao getByPersonId(Long personId);
	
}
