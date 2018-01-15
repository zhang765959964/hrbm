package com.xunfeng.business.person.interf;


import java.util.Map;

import com.xunfeng.business.corp.dto.CorpReceivedResumeDto;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.model.JobApply;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.setMeal.exception.SetMealException;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: hr工具箱模板表 接口类
* @author:wanghan
* @createDate 2016-04-05 15:47:33 
* @version V1.0   
*/
public interface JobApplyServiceInterf extends GenericServiceInterface<JobApply,Long>
{
	/**
	 *企业收到的简历
	 */
	public ResultData<CorpReceivedResumeDto> getAllCorpRecevicedResume(QueryFilter filter);
	/**
	 * 个人申请职位列表
	 * @param filter
	 * @return
	 */
	public ResultData<Map> getJobApplyResultData(QueryFilter filter);
	/**
	 * 个人是否投递了此职位
	 * @param acb210
	 * @param ccmu01
	 * @return
	 */
	public boolean isApply(Long acb210,Long ccmu01);
	/**
    * 用户申请职位的总数
    */
   public Long getTotalCountApplyByAac001(Long aac001);
   
   /**
    * 根据企业编号 和状态 获得企业简历数量
    * 是否已查看0-未查看1-已查看，2-已电话，3已面试，4已入职，5面试缺席，6入职未到岗，7落选
    */
   public Long  getTotalCorpResumeByState(Long aab001,int state);
   //收到的简历页面下-批量邀请面试
   public void receiveBatchInterviewInvitation(Long[] corpResumeIds,Long aab001) throws SetMealException;
   //批量设置简历状态
   public boolean batchResetResumeStatus(Long[] corpResumeIds,Long aab001,Long status);
   //邀请面试公用方法 
   public void saveInterviewInvitation(Long aab001,Long aac001,Long acb210,Corp corp,String ccpr09,String ccps03) throws SetMealException;
   //组件发送面试邀请
   public boolean commonInterviewInvitation(Long[] personIds,Long aab001,Long acb210,String ccps03) throws SetMealException;
}
