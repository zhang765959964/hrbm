package com.xunfeng.business.personagency.subsidy.interf;


import java.util.List;

import com.xunfeng.business.personagency.subsidy.dto.BatchSocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.dto.SocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴 接口类
* @author:wanghan
* @createDate 2016-07-06 11:03:39 
* @version V1.0   
*/
public interface SocialSubsidyServiceInterf extends GenericServiceInterface<SocialSubsidy,Long>
{
	public SocialSubsidy getByArchiveCode(String archiveCode);
	/**根据人员Id获取该人员对应的补贴信息对象
	 * @param personId
	 * @return
	 */
	public SocialSubsidy getByPersonId(Long personId);
	/**根据Id判断进行保存或则更新社保补贴信息
	 * @param socialSubsidyDto
	 */
	public void saveOrUpdate(SocialSubsidyDto socialSubsidyDto);
	/**根据批次Id ，获取该批次Id下的人员列表
	 * @param batchId
	 * @return
	 */
	public List<SocialSubsidy>  getListByBatchId(Long batchId);
	/**根据批次Id ，获取该批次Id下的人员列表
	 * @param batchId 
	 * @param pageBean
	 * @return
	 */
	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,PageBean pageBean );
	
	/**根据批次Id、人员信息 ，获取该批次Id下的人员列表
	 * @param batchId
	 * @param searchValue 人员信息 （身份证号、姓名 档案等）
	 * @param pageBean
	 * @return
	 */
	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,String searchValue,PageBean pageBean );
	
	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,String searchValue,Long personId,PageBean pageBean );
	
	public ResultData<BatchSocialSubsidyDto>   getBatchSocialListByBatchId(Long batchId,QueryFilter queryFilter);
	/**审核补贴身申报人员
	 * @param id
	 * @param checkState
	 */
	public void review(Long[] ids,String checkState);
	
	/**
	 * @param id
	 * @param subsidyNum
	 */
	public void updateNum(Long id,String subsidyNum,String createrNum);
	
	/**根据相关条件，变更单位申报的补贴标准
	 * @param id  单位申报Id
	 * @param batchId  批次Id
	 * @param pensionStandard 养老标准
	 * @param medicalStandard 医疗标准 
	 */
	public void batchUpdate(Long id,Long batchId,String pensionStandard,String medicalStandard);
	
	/**根据查询条件获取社保补贴对象列表
	 * @param fiter
	 * @return
	 */
	public ResultData<SocialSubsidy> getAllByFilter(QueryFilter fiter);
	/**根据查询条件获取社保补贴对象列表,带部分用户基本信息
	 * @param fiter
	 * @return
	 */
	public ResultData<SocialSubsidyDto> getAllSubsidyPersonByFilter(QueryFilter fiter);
	
	public List<SocialSubsidy>  getListBySubsidyNum(Long id,String subsidyNum);
}
