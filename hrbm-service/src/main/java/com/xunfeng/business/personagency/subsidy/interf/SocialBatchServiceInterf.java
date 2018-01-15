package com.xunfeng.business.personagency.subsidy.interf;


import com.xunfeng.business.personagency.subsidy.dto.SocialBatchSumDto;
import com.xunfeng.business.personagency.subsidy.model.SocialBatch;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_BATCH 接口类
* @author:wanghan
* @createDate 2016-07-07 09:12:59 
* @version V1.0   
*/
public interface SocialBatchServiceInterf extends GenericServiceInterface<SocialBatch,Long>
{
	public ResultData<SocialBatch> getAllByFilter(QueryFilter fiter);
	/**获取社保批次中最新的批次
	 * @return  取社保批次对象
	 */
	public SocialBatch  getNewestSocialBatch();
	
	public SocialBatchSumDto  getSocialBatchSum(Long batchId);
	
	public void delBatchPerson(Long batchId,Long subsidyId);
	
	public void addBatchPerson(Long batchId,Long subsidyId);
	
	public boolean isBatchNameExist(String batchName,Long noId);
}
