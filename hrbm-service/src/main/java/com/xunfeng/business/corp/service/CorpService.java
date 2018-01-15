package com.xunfeng.business.corp.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xunfeng.business.cation.model.Authentication;
import com.xunfeng.business.cation.service.AuthenticationService;
import com.xunfeng.business.corp.dao.CorpDao;
import com.xunfeng.business.corp.dto.CorpDto;
import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.interf.PersonLabelServiceInterf;
import com.xunfeng.business.person.model.PersonLabel;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.AccountBo;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.accounts.service.AccountsService;
import com.xunfeng.sys.attachment.model.Attachment;
import com.xunfeng.sys.attachment.service.AttachmentService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.node.model.Node;
import com.xunfeng.sys.node.service.NodeService;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.sendmessage.service.MessageTemplatesService;
import com.xunfeng.sys.sendmessage.service.SenderService;
import com.xunfeng.sys.sendmessage.util.ContentConversion;
import com.xunfeng.sys.sendmessage.util.ContentModel;
import com.xunfeng.sys.shortMessage.model.ShortMessage;
import com.xunfeng.sys.shortMessage.service.ShortMessageService;

/**
 *<pre>
 * 对象功能:单位基本信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-01 09:51:36
 *</pre>
 */
@Service
public class CorpService extends BaseService<Corp> implements CorpServiceInter
{
	@Resource
	private CorpDao dao;
	
	@Resource
	private AccountsService accountsService;
	@Value("#{configproperties['corp.logo.upload']}")
	private String corpLogoUpload;
	@Resource
	CorpPositionPublishService corpPositionPublishService;
	@Resource
	CorpPositionService corpPositionService;
	@Resource
	private NodeService nodeService;
	@Resource
	private SenderService senderService;
	@Resource
	private AuthenticationService authenticationService;
	@Resource
	private ShortMessageService shortMessageService;
	@Resource
	private AttachmentService attachmentService;
	@Resource
	private MessageTemplatesService messageTemplatesService;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtil;
	@Resource
	@Qualifier("personLabel")
	private PersonLabelServiceInterf personLabelService;


	public CorpService()
	{
	}
	
	@Override
	protected IEntityDao<Corp, Long> getEntityDao()
	{
		return dao;
	}
//	/**
//	 * 添加对象
//	 */
//	public void add(Corp corp,String Ip)
//	{		
//		dao.add(corp);
//		AccountBo accountBo=new AccountBo();
//		accountBo.setAccountType(AccountBo.ACCOUNT_TYPE_PERSON);
//		accountBo.setIp(Ip);
//		accountBo.setPhone(corp.getAae139());
//		accountsService.addAccount(accountBo);		
//	}
	/**
	 * 通过 用户编号 ccmu01 获取企业的基本信息 
	 */
	public Corp getCorpByAccountId(Long accountId){
		return dao.getCorpByAccountId(accountId);
	}
	
	/**
	 * 根据单位编号 开通电子地图
	 * status:开通状态 1
	 * x:横坐标
	 * y：竖坐标
	 * zoomScale：缩放比例
	 */
	public void  openMap(Float x,Float y,Long zoomScale,Corp corp){
		corp.setCabq01(1L);
		corp.setCabq02(x);
		corp.setCabq03(y);
		corp.setCabq04(zoomScale);
		corp.setCcpr05(new Date());
		dao.update(corp);
	}
//   @Override
//   public List<Corp> getAll(QueryFilter queryFilter){
//	   Map<String,Object>
//	   queryFilter.setFilters(map);
//	   return null;
//   }
	/**
	 * 保存企业LOGO
	 */
//	public void saveCorpLogo(MultipartFile file)throws IOException{
//		String filePath = corpLogoUpload;
//		String fileName =""; //AttachmentService.getFileName(file.getOriginalFilename());
//		Accounts loginUser = ContextUtil.getCurrentUser();
//		loginUser.setCcmu15(fileName);
//		file.transferTo(new File(filePath+"/"+fileName));
//		accountsService.update(loginUser);
//		ContextUtil.setCurrentUser(loginUser);
//	}


	public CorpDto getCorpInfoById(Long aab001){
        Map map=new HashMap();
		map.put("aab001",aab001);
        return (CorpDto)dao.getOne("getCorpInfoById",map);
	}
	/**
	 * 单位注册
	 */
	public void addCorpRegister(Corp corp,Accounts account)
	{		
		dao.add(corp);
		accountsService.addCorpAccount(account);
	}
	
	public void add(Corp corp,String ip)
	{		
		Long ccmu01 = uniqueIdUtil.genSeqId(SqeIdName.Accounts.getSeqName());
		corp.setCabq05(0L);
		corp.setCabq08(0L);//窗口验证是否通过(0-未通过1-手工认证2-设备认证3-公办认证)
		corp.setAab01d("0");
		corp.setCcmu01(ccmu01);
		corp.setCabq13("F");
		corp.setCabq14("0");
		corp.setCabq16(new Date());
		corp.setCcpr08("0");
		corp.setCcpr09("0");
		corp.setCcpr14("0");
		corp.setCcpr15("1");
		corp.setCcpr16("0");
		corp.setCcpr18("0");
		corp.setCcpr19("0");
		corp.setCcpr20("0");
		corp.setCcpr21("0");
		corp.setCcpr22("0");
		corp.setCcpr23("0");
		corp.setCcpr24("0");
		corp.setAae119("1");
		corp.setCabq14("0");
		corp.setCabq17(0L);
		String ccmu02 = getRandomId();
		Accounts accountsByNameAndType =  accountsService.getAccountsByNameAndType(ccmu02,"2");
		//判断随机生成的账号是否在数据库中存在 如果存在重新生成，暂时判断一次 因为重复概率比较小
		if(accountsByNameAndType!=null){
			ccmu02 = getRandomId();
		}

		
	    dao.add(corp);
	    //人士档案暂不生成就业网账号
//		Accounts accounts =new Accounts();
//		accounts.setCcmu01(ccmu01);
//		accounts.setCcmu02(ccmu02);//用户名
//		accounts.setCcmu03(corp.getAae139());//	密码
//		accounts.setCcmu06(ip);//注册IP
//		accounts.setCcmu09(corp.getAae139());//手机
//		accounts.setCcmu10(1l);//账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用) 个人:仅1,2 单位:1,2,4,5
//		accounts.setCcmu12(0l);//邮箱激活状态(0-未激活1-已激活)
//		accounts.setCcmu13(0l);//手机激活状态(0-未激活1-已激活)
//		accounts.setCcmu16(new Date());//注册日期
//		accounts.setCcmu17(2l);//账号类型(1-个人用户2-企业用户3-民营职介机构4-公办职介机构5-财政局查询)
//		accounts.setCcmu19(0l);//用户人才币余额
//		accounts.setCcmu20(0l);//企业今天已经的下载简历数
//		accounts.setCcmu21(0l);//用户名修改次数,大于1则不能再次修改用户名
//		accounts.setCcmu22(corp.getCczy06());//数据来源0未知1网站2窗口3-民营机构
//		accounts.setCcpr08("0");//是否删除状态（0-否1-是）
//	    accountsService.addCorpAccount(accounts);
//		//发送短信
//		ContentModel cm = new ContentModel();
//		cm.setCorpName(corp.getAab004());
//		cm.setCorpAccount(accounts.getCcmu02());
//		cm.setCorpPwd(accounts.getCcmu03());
//		cm.setAae011(corp.getAae011());
//		cm.setAae017(corp.getAae017());
//		messageTemplatesService.sendAccountMessage(12L, corp.getAae139(), cm);

	}
	//随机生成六位数
	private String getRandomId(){
		String randomId=null;
		for(int i=0;i<99;i++){
			randomId =  String.valueOf(new Random().nextInt(999999));
			if(randomId.length() == 6){
				break;
			}
		}
		return randomId;
	}
	/**
	 * 后台添加单位信息
	 */
	public void addRegister(Corp corp,Accounts account,Attachment attachment)
	{		
		//发送短信
		MessageTemplates  messageTemplates = messageTemplatesService.getById(12L);
		   Node node=nodeService.getByTemplates(messageTemplates.getComm01());//根据短信模板编码查询出节点编码
		   if("T".equals(node.getComn05())){
			   ContentModel cm = new ContentModel();
			   ShortMessage shortMessage = new ShortMessage();
			   cm.setCorpName(corp.getAab004());
			   cm.setCorpAccount(account.getCcmu02());
			   cm.setCorpPwd(account.getCcmu03());
			   String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
			   senderService.sendVerificationCode(corp.getAae139(),content);
			   //保存发送信息
			   shortMessage.setComc01(uniqueIdUtil.genSeqId(SqeIdName.ShortMessage.getSeqName()));
			   shortMessage.setComc02(corp.getAae139());
			   shortMessage.setComc03(content);
			   shortMessage.setComc04(1L);
			   shortMessage.setComc05(1L);
			   shortMessage.setAae011(corp.getAae011());
			   shortMessage.setAae017(corp.getAae017());
			   shortMessage.setAae036(new Date());
			   shortMessage.setComn01(node.getComn01());
			   shortMessage.setComc06(0L);
			   shortMessageService.add(shortMessage);
		   }
	   dao.add(corp);
	   attachmentService.add(attachment);
	   accountsService.addCorpAccount(account);
	}
	/**
	 * 根据会员编号获取对象
	 * @return
	 */
	public Corp getByCcmu01(Long ccmu01)
	{
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("ccmu01", ccmu01);
		return dao.getUnique("getAll", params);
	}

	private Long ParseLong(Object inte){

		return Long.parseLong(inte.toString());

	}
	private String parseEmployeeLanguage(Integer LanguageId){
		if(LanguageId==null){
			return  "zh";
		}
		if(LanguageId==1003){
			return  "en";
		}else if(LanguageId==1001){
			return  "zh";
		}else if(LanguageId==1005){
			return  "ru";
		}else if(LanguageId==1007){
			return  "de";
		}else{
			return  "zh";
		}
	}

	private String parseEmployeeCount(Integer employeeCount){
		if(employeeCount==null){
			return  "7";
		}
		if(employeeCount<10){
			return  "1";
		}else if(employeeCount>=10&&employeeCount<100){
			return  "2";
		}else if(employeeCount>=100&&employeeCount<500){
			return  "3";
		}else if(employeeCount>=500&&employeeCount<1000){
			return  "4";
		}else if(employeeCount>=1000&&employeeCount<3000){
			return 	 "5";
		}else if(employeeCount>=3000){
			return  "6";
		}else{
			return  "7";
		}
	}
	private String parseEmployeeSalary(Integer salary){
		if(salary==null){
			return  "9";
		}
		if(salary==0){
			return  "9";
		}else if(salary>=1400&&salary<1999){
			return  "2";
		}else if(salary>=2000&&salary<2999){
			return  "3";
		}else if(salary>=3000&&salary<3999){
			return  "4";
		}else if(salary>=4000&&salary<4999){
			return 	 "5";
		}else if(salary>=5000&&salary<6999){
			return  "6";
		}else if(salary>=7000&&salary<9999){
			return 	 "7";
		}else if(salary>=10000){
			return  "8";
		}else{
			return  "9";
		}
	}
	private String parseStudedEst(Integer est){
		//学历，1001初中,1002高中,1003中技,1004中专,1005大专,1006本科,1007硕士,1008博士,1009博士后
		//	11	博士研究生;14	硕士研究生;21	大学本科;31	大学专科;41	中等专科;44	职业高中;47	技工学校;61	普通高中;71	初中;81	小学;90	其他
		if(est==null){
			return  "90";
		}
		if(est==1001){
			return  "81";
		}else if(est==1002){
			return  "71";
		}else if(est==1003){
			return  "61";
		}else if(est==1004){
			return  "41";
		}else if(est==1005){
			return 	 "31";
		}else if(est==1006){
			return  "21";
		}else if(est==1007){
			return 	 "14";
		}else if(est==1008){
			return  "11";
		}else if(est==1009){
			return  "11";
		}else{
			return  "90";
		}
	}
	private String parseWorkExper(Integer workExper){
		//工作经验,1001应届生,1002一年,1003二年,1004三年,1005三年-五年,1006五年-十年,1007十年以上
		//	1	在读学生 2	应届毕业生 3	1-2年 4	2-3年 5	3-5年 6	5-8年 7	8-10年 8 10年以上 9	不限
		if(workExper==null){
			return  "9";
		}
		if(workExper==1001){
			return  "2";
		}else if(workExper==1002){
			return  "3";
		}else if(workExper==1003){
			return  "4";
		}else if(workExper==1004){
			return  "5";
		}else if(workExper==1005){
			return 	 "5";
		}else if(workExper==1006){
			return  "6";
		}else if(workExper==1007){
			return 	 "8";
		}else{
			return  "9";
		}
	}
	private void synchInvite(){

	}
	
	/**
	 * 企业获得获得推荐人才
	 * 2016-03-31
	 */
	public ResultData getRecommendPerson(QueryFilter queryFilter){
		/*List<Map> recommendList = dao.getRecommendPerson(queryFilter);
		if(queryFilter.getPageBean().getTotalCount()==0){
			recommendList = dao.getRecommendBlackPerson(queryFilter);
		}
		ResultData<Map> resultData = new ResultData<Map>();
		if((recommendList.size()==0)&&(queryFilter.getPageBean().getTotalCount()>0 && queryFilter.getPageBean().getCurrentPage()>1)){
			queryFilter.getPageBean().setCurrentPage(1);
			recommendList = dao.getRecommendPerson(queryFilter);
		}
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(recommendList);
		return resultData;*/
		List<Map> recommendList = dao.getRecommendPersonMerge(queryFilter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(recommendList);
		return resultData;
	}
	
	public List<Map> getRecommendBlackPerson(QueryFilter queryFilter){
		return dao.getRecommendBlackPerson(queryFilter);
	}
	
	public ResultData<Map> getResultDataRecommendBlackPerson(QueryFilter queryFilter){		
		List<Map> dataList = dao.getRecommendPerson(queryFilter);
		if(dataList.size()<1){
			 dataList=dao.getRecommendBlackPerson(queryFilter);
		}		
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
		
	}
	//修改保存企业基本信息和标签
	public void updateCorpAndLabel(Corp corp,List<PersonLabel> personLabelList) {
		dao.update(corp);
		personLabelService.delPersonLabelList(corp.getAab001());
		for (PersonLabel personLabel : personLabelList) {
			personLabelService.add(personLabel);
		}

	}
	public void approve(Long caoa01,Long aab001, Long approveFlag) {
		
		Corp cp = getById(aab001);
		Authentication authenti = authenticationService.getById(caoa01);
			if (approveFlag == 0) {
				cp.setCabq08((long)1);
				authenti.setCaoa07((long)1);
			} else if (approveFlag == 1) {
				cp.setCabq08((long)4);
				authenti.setCaoa07((long)2);
			}
			update(cp);
			authenticationService.update(authenti);

	}
	
	/**
	 * 通过职位id获得公司详情
	 * 2016-04-13
	 */
	public ResultData getCorpInfoByJobId(QueryFilter queryFilter){
		List<Map> CorpInfoInfo = dao.getCorpInfoByJobId(queryFilter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setDataList(CorpInfoInfo);
		return resultData;
	}
	
	/**
	 * 通过CorpId获得公司详情
	 * 2016-04-13 
	 */
	public Map<String,Object> getCorpInfoByCorpId(Long aab001){
		return dao.getCorpInfoByCorpId(aab001);
	}
	/**
	 * 通过CorpId获得公司简介
	 * 2016-04-13 
	 */
	public String getCorpDescByCorpId(Long aab001){
		return dao.getCorpDescByCorpId(aab001);
	}
	/**
	 * 根据企业名称获得公司信息
	 * 2016-05-05
	 */
	public Corp getCorpByCorpName(String corpName){
		return dao.getCorpByCorpName(corpName);
	}
	/**
	 * 根据企业营业执照获得公司信息
	 * 2016-05-05
	 */
	public Corp getCorpByBusCardNum(String cardNum){
		return dao.getCorpByBusCardNum(cardNum);
	}
	
	/**
	 * 获得审核通过的企业
	 */
	public List<Corp> getAllValidCorp(QueryFilter queryFilter){		
		List<Corp> dataList = dao.getListForm("getAllValidCorp", queryFilter);
		return dataList;
		
	}
	
	/**
	 * 通过公办平台获得单位信息
	 */
	public ResultData<Corp> getAllCorp(QueryFilter fiter){
		
		ResultData<Corp> resultData=new ResultData<Corp>();
		List<Corp> dataList =dao.getBySqlKey("getAllCorp",fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	/**
	 * 查看单位信息详情
	 */
	public Corp getCorpDetails(Long aab001){
		return (Corp) dao.getOne("getCorpDetails", aab001);
	}

	/* 
	 * 企业信息统计
	 * (non-Javadoc)
	 * @see com.xunfeng.business.corp.interf.CorpServiceInter#getCorpStatistics(com.xunfeng.core.web.query.QueryFilter)
	 */
	@Override
	public ResultData<Map<String, Object>> getCorpStatistics(
			QueryFilter queryFilter) {
    	ResultData<Map<String, Object>> resultData = dao.getCorpStatistics(queryFilter);
    	Integer total = getCorpStatisticsCount(queryFilter);
    	if(resultData!=null&&resultData.getDataList()!=null){
    		for (Map<String, Object> dataMap : resultData.getDataList()) {
				//设置总数 计算数据
    			dataMap.put("TOTAL_NUM", total);
    			//百分比
    			dataMap.put("PERCENT", new BigDecimal(Integer.valueOf(dataMap.get("CORPNUM").toString())).divide(new BigDecimal(total),2,BigDecimal.ROUND_HALF_UP));
			}
    	}
    	return resultData;
	}
    
    /**
     * 企业总数查询
     * @param queryFilter 检索条件
     * @return 结果返回
     */
    public Integer getCorpStatisticsCount(QueryFilter queryFilter){
    	return dao.getCorpStatisticsCount(queryFilter);
    }

	@Override
	public List<Map<String, Object>> getCorpStatisticsEcharts(
			QueryFilter queryFilter) {
		return dao.getCorpStatisticsEcharts(queryFilter);
	}

	 /**
     * 通过单位名称或者工商营业执照号码确定所新增的企业是否已存在
     * @param fiter 检索条件(aab004和aab007)
     * 2016/08/02
     * @return 
     */
	public List<Corp> getByNameNumber(QueryFilter fiter) {
		// TODO Auto-generated method stub
		return dao.getBySqlKey("getByNameNumber", fiter);
	}


	/**
	 * 人事档案根据aab001 查询企业信息和签订信息
	 * @param aab001
	 * @serialData 2016/08/06
	 * @author jx
	 * @return
	 */
	public Map getCorpUnitAgreement(Long aab001){
		return dao.getCorpUnitAgreement(aab001);
	}
	/**
	 * 公办系统通过视图 查询企业信息
	 * @param aab001
	 * @serialData 2016/08/27
	 * @author wlp
	 * @return
	 */
	public Map getByCorpView(Long aab001){
		Map params=new HashMap();
		params.put("aab001", aab001);
		return (Map)dao.getOne("getByCorpView", params);
	}
	@Override
	public void updateRegister(Corp corp,Accounts account,String nodeLogs,Attachment attachment) {
		// TODO Auto-generated method stub
		Attachment attach=attachmentService.getBusLicense(corp.getCcmu01()==null?0L:corp.getCcmu01());
		if("1".equals(nodeLogs)){
			if(account!=null){
				//发送短信
				MessageTemplates  messageTemplates = messageTemplatesService.getById(12L);
				   Node node=nodeService.getByTemplates(messageTemplates.getComm01());//根据短信模板编码查询出节点编码
				   if("T".equals(node.getComn05())){
					   ContentModel cm = new ContentModel();
					   ShortMessage shortMessage = new ShortMessage();
					   cm.setCorpName(corp.getAab004());
					   cm.setCorpAccount(account.getCcmu02());
					   cm.setCorpPwd(account.getCcmu03());
					   String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
					   senderService.sendVerificationCode(corp.getAae139(),content);
					   //保存发送信息
					   shortMessage.setComc01(uniqueIdUtil.genSeqId(SqeIdName.ShortMessage.getSeqName()));
					   shortMessage.setComc02(corp.getAae139());
					   shortMessage.setComc03(content);
					   shortMessage.setComc04(1L);
					   shortMessage.setComc05(1L);
					   shortMessage.setAae011(corp.getAae011());
					   shortMessage.setAae017(corp.getAae017());
					   shortMessage.setAae036(new Date());
					   shortMessage.setComn01(node.getComn01());
					   shortMessage.setComc06(0L);
					   shortMessageService.add(shortMessage);
				   }
			}
			dao.update(corp);
		}else{
			dao.update(corp);
		}
		if(attach==null){
			attachmentService.add(attachment);
		}else{
			attachmentService.update(attachment);
		}
				   
	}
	
	public Long getNoPermissionCount(String aab001s,Long opOrgId){
		Map params=new HashMap();
		params.put("aab001s", aab001s);
		params.put("opOrgId", opOrgId);
		return (Long)dao.getOne("getNoPermissionCount", params);
	}
}
