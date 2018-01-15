package com.xunfeng.business.person.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dto.CorpPositionDto;
import com.xunfeng.business.corp.dto.CorpReceivedResumeDto;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.model.CorpCollection;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.business.corp.service.CorpCollectionService;
import com.xunfeng.business.corp.service.CorpPositionPublishService;
import com.xunfeng.business.corp.service.CorpPositionService;
import com.xunfeng.business.corp.service.CorpService;
import com.xunfeng.business.corp.service.DownloadResumeService;
import com.xunfeng.business.person.dao.JobApplyDao;
import com.xunfeng.business.person.interf.JobApplyServiceInterf;
import com.xunfeng.business.person.model.JobApply;
import com.xunfeng.business.person.model.JobAuditionInvited;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.interf.AccountsServiceInter;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.message.interf.AccountMessageServiceInterf;
import com.xunfeng.sys.recommend.model.JobRecommend;
import com.xunfeng.sys.recommend.service.JobRecommendService;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.sendmessage.service.MessageTemplatesService;
import com.xunfeng.sys.sendmessage.service.SenderService;
import com.xunfeng.sys.sendmessage.util.ContentConversion;
import com.xunfeng.sys.sendmessage.util.ContentModel;
import com.xunfeng.sys.setMeal.exception.SetMealException;
import com.xunfeng.sys.setMeal.service.FeeOrderDetailService;

/**
 *<pre>
 * 对象功能:职位申请表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 16:02:05
 *</pre>
 */
@Service
public class JobApplyService extends BaseService<JobApply> implements JobApplyServiceInterf
{
	@Resource
	private JobApplyDao dao;
	@Resource
	private MessageTemplatesService messageTemplatesService;
	@Resource
	private JobRecommendService jobRecommendService;
	@Resource
	private JobAuditionInvitedService jobAuditionInvitedService;
	@Resource
	UniqueIdUtilService  UniqueIdUtil;
	@Resource
	private CorpService corpService;
	@Resource
	private CorpPositionService corpPositionService;
	@Resource
	private CorpPositionPublishService corpPositionPublishService;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	@Resource
	private SenderService senderService;
	@Resource 
	private PersonJobRegistService personJobRegistService;
	@Resource
	private CorpCollectionService corpCollectionService;
	@Resource
	private DownloadResumeService downloadResumeService;
	@Resource
	private AccountMessageServiceInterf accountMessageService;
	@Resource
	private AccountsServiceInter accountsService;
	@Resource
	private FeeOrderDetailService feeOrderDetailService;
	@Resource
	private BaseConfigService baseConfigService;
	public JobApplyService()
	{
	}

	@Override
	protected IEntityDao<JobApply, Long> getEntityDao()
	{
		return dao;
	}

//	/**
//	 *企业收到的简历
//	 */
	public ResultData<CorpReceivedResumeDto> getAllCorpRecevicedResume(QueryFilter filter){
		ResultData<CorpReceivedResumeDto> resultData = new ResultData<CorpReceivedResumeDto>();
		resultData.setPageBean(filter.getPageBean());
		resultData.setDataList(dao.getListForm("getCorpReceivedResume",filter));
		return resultData;
	}
	/**
	 * 获得个人职位申请记录
	 */
	public ResultData<Map>  getJobApplyResultData(QueryFilter queryFilter){
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setDataList(dao.getListForm("getJobApplyList",queryFilter));
		resultData.setPageBean(queryFilter.getPageBean());
		return resultData;	
	}
	
	/**
	 * 判断是否用户申请了职位
	 */
   public boolean isApply(Long acb210,Long aac001){
	   Map<String,Object> map = new HashMap<String, Object>();
	   map.put("acb210", acb210);
	   map.put("aac001", aac001);
	   Long totalCount = (Long) dao.getOne("getTotalCountApply", map);
	   return totalCount>0?true:false;
   }
   
   /**
    * 用户申请职位的总数
    */
   public Long  getTotalCountApplyByAac001(Long aac001){
	   Map<String,Object> map = new HashMap<String, Object>();
	   map.put("aac001", aac001);
	   return  (Long) dao.getOne("getTotalCountApply", map);
   }
   
   /**
    * 根据企业编号 和状态 获得企业简历数量
    */
   public Long  getTotalCorpResumeByState(Long aab001,int state){
	   Map<String,Object> map = new HashMap<String, Object>();
	   map.put("aab001", aab001);
	   map.put("ccpj03", state);
	   return  (Long) dao.getOne("getTotalCorpResumeByState", map);
   }
   //收到的简历页面下-批量邀请面试
   public void receiveBatchInterviewInvitation(Long[] corpResumeIds,Long aab001) throws SetMealException{
	   Corp corp = corpService.getById(aab001);
	   for(Long CCPJ01:corpResumeIds){
		   JobApply jobApply = dao.getById(CCPJ01);
		   //验证当前下是不是已经发送过面试邀请
		   JobRecommend jobRecommend = jobRecommendService.getJobRecommendByZhuJian(jobApply.getCcmu01(), aab001, jobApply.getAcb210());
		   if(jobRecommend!=null&&jobRecommend.getCcps01().equals("1")){
			   //当前企业已经邀请职位下的个人
		   }else{
			   CorpPositionDto cpd = corpPositionService.getStudentCorpPositionDto(jobApply.getAcb210());
			   if("1".equals(cpd.getAcb201())){
				   this.saveInterviewInvitation(aab001, jobApply.getCcmu01(), jobApply.getAcb210(), corp,"17","");
			   }else{
				   this.saveInterviewInvitation(aab001, jobApply.getCcmu01(), jobApply.getAcb210(), corp,"5","");
			   }
			   jobApply.setCcpj03(1l);
			   dao.update(jobApply);
		   }
	   }
   }
   //企业人才库页面下-批量邀请面试
   public void talentsInterviewInvitation(Long[] corpResumeIds,Long aab001,Long acb210,String ccps03) throws SetMealException{
	   Corp corp = corpService.getById(aab001);
	   for(Long CCPG01:corpResumeIds){
		   CorpCollection corpCollection = corpCollectionService.getById(CCPG01);
		   //验证当前下是不是已经发送过面试邀请
		   JobRecommend jobRecommend = jobRecommendService.getJobRecommendByZhuJian(corpCollection.getCcmp01(), aab001, acb210);
		   if(jobRecommend!=null&&jobRecommend.getCcps01().equals("1")){
			   //当前企业已经邀请职位下的个人
		   }else{
			   this.saveInterviewInvitation(aab001, corpCollection.getCcmp01(), corpCollection.getAcb210(), corp,"6",ccps03);
		   }
	   }
   }
   //组件发送面试邀请
   public boolean commonInterviewInvitation(Long[] personIds,Long aab001,Long acb210,String ccps03) throws SetMealException{
	   boolean flag = true;
	   Corp corp = corpService.getById(aab001);
	   for(Long aac001:personIds){
		   //验证当前下是不是已经发送过面试邀请
		   JobRecommend jobRecommend = jobRecommendService.getJobRecommendByZhuJian(aac001, aab001, acb210);
		   if(jobRecommend!=null&&jobRecommend.getCcps01().equals("1")){
			   //当前企业已经邀请职位下的个人
			   flag = false;
		   }else{
			   this.saveInterviewInvitation(aab001, aac001, acb210, corp,"6",ccps03);
		   }
	   }
	   return flag;
   }
   
   //邀请面试公用方法 
   public void saveInterviewInvitation(Long aab001,Long aac001,Long acb210,Corp corp,String ccpr09,String ccps03) {
	   //获取面试邀请模板  中部就业网提醒您：{#企业名称#}邀请您面试{#企业岗位#}岗位，联系人手机号：{#联系人手机号#}，联系地址：{#联系地址#}。【职介中心】
	   MessageTemplates  messageTemplates = messageTemplatesService.getById(19L);
	   JobAuditionInvited jobInvited = new JobAuditionInvited();
	   jobInvited.setCcps01(UniqueIdUtil.genId(JobAuditionInvited.class.getName()));
	   jobInvited.setCcmc01(aab001);
	   jobInvited.setCcmp01(aac001);
	   jobInvited.setAcb210(acb210);
	   jobInvited.setCcps02(new Date());
	   if(!"".equals(ccps03)){
		   jobInvited.setCcps03(ccps03);//面试日期及内容
	   }
	   jobInvited.setCcps04(0L);
	   jobInvited.setCcps06("1");//数据来源  网站
	   jobInvited.setCcpr08("0");
	   jobInvited.setAcb330(0l); //招聘会编号
	   jobInvited.setIsaccept(0L);             //是否接受邀请 (0-未处理1-拒绝2-接受)
	   jobAuditionInvitedService.add(jobInvited);
	   
	   JobRecommend jobRecommend2 = new JobRecommend();
	   jobRecommend2.setAcc220(UniqueIdUtil.genId(JobRecommend.class.getName()));
	   Long acc221 = jobRecommendService.getTotalCount()+1;
	   jobRecommend2.setAcc221(acc221.toString());   //介绍信编号
	   CorpPosition corpPosition = corpPositionService.getById(acb210);
	   CorpPositionPublish CorpPositionPublish = corpPositionPublishService.getById(corpPosition.getAcb200());
	   BeanToBean.copyProperties(corp, jobRecommend2, false);
	   BeanToBean.copyProperties(corpPosition, jobRecommend2, false);
	   BeanToBean.copyProperties(CorpPositionPublish, jobRecommend2, false);
	   PersonBaseInfo personBaseInfo = personBaseInfoService.getById(aac001);
	   Map map = personJobRegistService.getValidJobRegistByPersonId(aac001);
	   Object acc200 = (Object)map.get("ACC200");
	   jobRecommend2.setAcc200(Long.parseLong(acc200.toString()));
	   SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy");
	   String age1 = dateFormater.format(new Date());
	   String age2 = dateFormater.format(personBaseInfo.getAac006());
	   long age = Integer.parseInt(age1)-Integer.parseInt(age2);
	   BeanToBean.copyProperties(personBaseInfo, jobRecommend2, false);
	   jobRecommend2.setBac006(age);
	   jobRecommend2.setCcps01("1");
	   jobRecommend2.setBcc229("1");
	   jobRecommend2.setAae036(new Date());
	   jobRecommend2.setCcpr09(ccpr09);
	   jobRecommendService.add(jobRecommend2);
	   //发送信息
	   ContentModel cm = new ContentModel();
	   cm.setCorpName(corp.getAab004());
	   cm.setCorpPosition(corpPosition.getBca112());
	   cm.setCorpPhoneNumber(CorpPositionPublish.getAae005());
	   cm.setCorpAddress(CorpPositionPublish.getAcb204());
	   String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
	   //短信扣费如果短息发送失败 且需要收费 下面的处理如果不捕获异常则会影响到正常的事务处理 
	    Map<String,Object> payMap = new HashMap<String, Object>();
	    payMap.put("aab001", corp.getAab001());
	    payMap.put("aab004", corp.getAab004());
	    payMap.put("phone", personBaseInfo.getAae005());
	    payMap.put("context", content);
	    try{
	    	senderService.sendVerificationCode(payMap);
	    }catch(SetMealException e){
	    	//套餐不足 不能发送短信 但是能够进行正常的面试邀请
	    	e.printStackTrace();
	    }
	   //发送站内信
	   String ccmc03 = "【"+corp.getAab004()+"】 邀请您面试【"+corpPosition.getBca112()+"】岗位";
	   accountMessageService.addAccountMessage(corp.getCcmu01(), "面试邀请", ccmc03, personBaseInfoService.getById(aac001).getCcmu01());
	   
   }
   
   //批量设置简历状态
   public boolean batchResetResumeStatus(Long[] corpResumeIds,Long aab001,Long status){
	   boolean flag = true;
	   for(Long CCPJ01:corpResumeIds){
		   JobApply jobApply = dao.getById(CCPJ01);
		   //验证当前下是不是已经发送过面试邀请
		   JobRecommend jobRecommend = jobRecommendService.getJobRecommendByZhuJian(jobApply.getCcmu01(), aab001, jobApply.getAcb210());
		   if(jobRecommend!=null&&jobRecommend.getCcps01().equals("1")){
			   //当前企业已经邀请职位下的个人
		   }else{
			   flag = false;
			   break;
		   }
	   }
	   if(flag){
		   for(Long CCPJ01:corpResumeIds){
			   JobApply jobApply = dao.getById(CCPJ01);
			   jobApply.setCcpj03(status);
			   dao.update(jobApply);
		   }
	   }
	   return flag;
   }
   /**
    * 保存求职意向
    * 发送站内信
    */
   @Override
	public void add(JobApply jobApply){
	   
		dao.add(jobApply);
		
		PersonBaseInfo personBaseInfo = personBaseInfoService.getById(jobApply.getCcmu01());
		Long personAccountId = personBaseInfo.getCcmu01();
		CorpPosition corpPosition = corpPositionService.getById(jobApply.getAcb210());
		Corp corp = corpService.getById(corpPosition.getAab001());
		
		Long corpAccountId = corp.getCcmu01();
		Long PersonId = personBaseInfo.getAac001();
		String personName = personBaseInfo.getAac003();
		String positionName = corpPosition.getCca113();
		//发送站内信
		accountMessageService.addAccountMessage(personAccountId,"职位申请","【"+personName+"】投递了贵单位【"+positionName+"】岗位，<a href='currentContextPath/person/pu/resume/"+PersonId+"' ><strong>查看详情</strong></a>",corpAccountId);
	}
  
}
