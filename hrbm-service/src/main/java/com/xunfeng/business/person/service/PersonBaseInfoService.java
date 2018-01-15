package com.xunfeng.business.person.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.PersonBaseInfoDao;
import com.xunfeng.business.person.dto.PersonBaseAddDto;
import com.xunfeng.business.person.dto.PersonBaseInfoDto;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.Pinyin4jUtil;
import com.xunfeng.core.util.PinyinUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.AccountBo;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.accounts.service.AccountsService;
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
import com.xunfeng.sys.uums.model.SysUser;

/**
 *<pre>
 * 对象功能:个人基本信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:58:15
 *</pre>
 */
@Service
public class PersonBaseInfoService extends BaseService<PersonBaseInfo> implements PersonBaseInfoServiceInterf
{
	@Resource
	private PersonBaseInfoDao dao;
	@Resource
	@Qualifier("accounts")
	private AccountsService accountsService;
	@Resource
	private PersonExpandService personExpandService;
	@Resource
	private PersonFamilyService personFamilyService;
	@Resource
	private PersonJobRegistService personJobRegistService;
	@Resource
	private NodeService nodeService;
	@Resource
	private SenderService senderService;
	@Resource
	private ShortMessageService shortMessageService;
	@Resource
	private MessageTemplatesService messageTemplatesService;

	@Resource
	UniqueIdUtilService  uniqueIdUtil;
	public PersonBaseInfoService()
	{
	}
	
	@Override
	protected IEntityDao<PersonBaseInfo, Long> getEntityDao()
	{
		return dao;
	}
	
	
	@Override
	public void add(PersonBaseInfo personBaseInfo) {
		dao.add(personBaseInfo);
	}

	/**
	 * 修改个人基本信息 
	 */
	@Override
	public void update(PersonBaseInfo personBaseInfo){
		//修改求职意向中的学历信息
//		Map<String,Object> map = personJobRegistService.getJobRegistByPersonId(personBaseInfo.getAac001());
//		if(map !=null && map.size()>0&&StringUtil.isNotEmpty(personBaseInfo.getAac011())){
//			personJobRegistService.updateJobRegist(Long.valueOf(personBaseInfo.getAac011()),Long.valueOf(map.get("ACC200").toString()));
//		}
		//如果六个基本信息存在 增加简历完整度
		if(personBaseInfo.getCcmu70()==null || personBaseInfo.getCcmu70().equals("0")){
			if(StringUtil.isNotEmpty(personBaseInfo.getAac011())//文化程度
			 &&personBaseInfo.getAac006()!=null//出生年月
			 &&StringUtil.isNotEmpty(personBaseInfo.getAac005())//民族
			 &&StringUtil.isNotEmpty(personBaseInfo.getAac017())//婚姻状态
			 &&StringUtil.isNotEmpty(personBaseInfo.getAae005())//手机号
			 &&StringUtil.isNotEmpty(personBaseInfo.getAab301())//通讯地址
			 ){
				Long resumePercent = personBaseInfo.getCcmu50()==null?0: personBaseInfo.getCcmu50();
				personBaseInfo.setCcmu50(resumePercent+40);
				personBaseInfo.setCcmu70("1");//教育经历简历完整
				personBaseInfo.setCcpr05(new Date());//最后修改时间
				personBaseInfo.setCcpr07("1");//修改来源网站
			}
			
		}
		//增加简历完成度
//		if(personBaseInfo.getCcmu70().equals("0")){//增加简历完整度
//			Long resumePercent = personBaseInfo.getCcmu50()==null?0: personBaseInfo.getCcmu50();
//			personBaseInfo.setCcmu50(resumePercent+40);
//			personBaseInfo.setCcmu70("1");//教育经历简历完整
//			personBaseInfo.setCcpr05(new Date());//最后修改时间
//			personBaseInfo.setCcpr07("1");//修改来源网站
//		}
		String pinyin=PinyinUtil.getPinyin(personBaseInfo.getAac003());
		personBaseInfo.setAac022(pinyin);
		dao.update(personBaseInfo);
	}
	/**
	 * 添加对象
	 */
	public void add(PersonBaseInfo personBaseInfo,String Ip)
	{
		
		dao.add(personBaseInfo);
		AccountBo accountBo=new AccountBo();
		accountBo.setAccountType(AccountBo.ACCOUNT_TYPE_PERSON);
		accountBo.setIp(Ip);
		accountBo.setMail(personBaseInfo.getAae015());
		accountBo.setPhone(personBaseInfo.getAae005());
		accountBo.setUnId(personBaseInfo.getAac002());
		accountBo.setUserName(personBaseInfo.getAac003());
		accountsService.addAccount(accountBo);
		
	}
	
	/**
	 * 根据会员编号获取对象
	 * @return
	 */
	public PersonBaseInfo getByCcmu01(Long ccmu01)
	{
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("ccmu01", ccmu01);
		return dao.getUnique("getAll", params);
	}
	/**
	 * 根据个人编号获取对象
	 * @return
	 */
	public PersonBaseInfoDto getPersonDtoById(Long aac001)
	{
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("aac001", aac001);
		return (PersonBaseInfoDto)dao.getOne("getPersonDtoById", params);
	}
	
	/**
	 * 根据个人编号获取对象
	 * @return
	 */
	public Map<String,Object> getPresonInfoMapByPersonId(Long aac001)
	{
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("aac001", aac001);
		return (Map<String, Object>) dao.getUnique("getpresonInfoMap", params);
	}
	/**
	 * 学生注册
	 */
	public void addPersonRegister(PersonBaseInfo personBaseInfo,Accounts accounts)
	{
		dao.add(personBaseInfo);
		accountsService.addStudentAccount(accounts);
		
	}

	public void updateEmail(String ccmu08,Long ccmu01){
		Map params=new HashMap();
		params.put("ccmu01",ccmu01);
		params.put("aae015",ccmu08);
		updateAccounts(params);
		accountsService.updateEmail( ccmu08, ccmu01);
	}
	public void updatePhone(String ccmu09,Long ccmu01){
		Map params=new HashMap();
		params.put("ccmu01",ccmu01);
		params.put("aae005",ccmu09);
		updateAccounts(params);
		accountsService.updateEmail( ccmu09, ccmu01);
	}

	public void updateAccounts(Map params){

		dao.update("updateAccounts",params);

	}
	/**
	 * 查询身份证号和真实姓名是否已存在数据库中
	 */
	public PersonBaseInfo getByIdcardAndRealName(String idCard){
		return dao.getByIdcardAndRealName(idCard);
	}
	/**
	 * 添加用户的基本信息：身份证号，真实姓名，电话号码
	 */
	public void addPersonBaseInfo(PersonBaseInfo personBaseInfo){
		dao.add(personBaseInfo);
	}
	
	/**
	 * 获得个人基本信息分页
	 */
	public ResultData<PersonBaseInfo> getAllPerson(QueryFilter fiter){
		
		ResultData<PersonBaseInfo> resultData=new ResultData<PersonBaseInfo>();
		List<PersonBaseInfo> dataList =dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	
	/**
	 * 公办平台获得个人基本信息分页
	 */
	public ResultData<PersonBaseInfo> getPersonList(QueryFilter fiter){
		
		ResultData<PersonBaseInfo> resultData=new ResultData<PersonBaseInfo>();
		List<PersonBaseInfo> dataList =dao.getBySqlKey("getPersonList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	/**
	 * 通过视图V_AC01查询数据
	 */
	public PersonBaseInfo getByIds(Long  aac001){
		return (PersonBaseInfo) dao.getOne("getByIds", aac001);
	}
	
    /**
     * 个人统计信息查询
     * @param queryFilter 检索条件
     * @return 结果返回
     */
    public ResultData<Map<String, Object>> getPersonStatistics(QueryFilter queryFilter){
    	ResultData<Map<String, Object>> resultData = dao.getPersonStatistics(queryFilter);
    	Integer total = getPersonStatisticsCount(queryFilter);
    	if(resultData!=null&&resultData.getDataList()!=null){
    		for (Map<String, Object> dataMap : resultData.getDataList()) {
				//设置总数 计算数据
    			dataMap.put("TOTAL_NUM", total);
    			//百分比
    			dataMap.put("PERCENT", new BigDecimal(Integer.valueOf(dataMap.get("PERNUM").toString())).divide(new BigDecimal(total),2,BigDecimal.ROUND_HALF_UP));
			}
    	}
    	return resultData;
    }
    
    /**
     * 个人统计信息查询
     * @param queryFilter 检索条件
     * @return 结果返回
     */
    public Integer getPersonStatisticsCount(QueryFilter queryFilter){
    	return dao.getPersonStatisticsCount(queryFilter);
    }

	@Override
	public List<Map<String, Object>> getPersonStatisticsEcharts(
			QueryFilter queryFilter) {
		return dao.getPersonStatisticsEcharts(queryFilter);
	}
	
	/**
	 * @param personId
	 * @return 根据personId获取个人基本信息
	 */
	public Map getReceivePersonByPersonId(Long personId){
		return dao.getReceivePersonByPersonId(personId);
	}
	/**
	 * 查看身份证号查询是否有该人员信息
	 * @param aac002
	 * @return 根据aac002获取个人基本信息
	 */
	public PersonBaseInfo getByAac002(String aac002){
		return (PersonBaseInfo) dao.getOne("getByAac002", aac002);
	}
	/**
	 * aac002和编码查询身份证号是否已存在
	 * @param
	 * @return 
	 */
	public List<PersonBaseInfo> getPersonExist(QueryFilter fiter){
		return dao.getBySqlKey("getPersonExist", fiter);
	}
//	/**
//	 * 保存个人基本信息
//	 * @param 
//	 * @return 
//	 */
//	@Override
//	public void addAll(PersonBaseAddDto  personBaseInfo,SysUser sysUser) {
//		dao.add(personBaseInfo);
//		PersonExpand   personexpand=personBaseInfo.getPersonExpand();
//		
//		PersonFamily personFamily=personBaseInfo.getPersonFamily();
//		if(personexpand!=null){
//			personexpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));
//			personexpand.setExpPersonId(personBaseInfo.getAac001());
//			personexpand.setExpOpeartorUserId(sysUser.getAcd230());
//			personexpand.setExpPensionDate(new Date());
//			personExpandService.add(personexpand);
//		}
//		if(personFamily!=null){
//			personFamily.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));
//			personFamily.setFaPersonId(personBaseInfo.getAac001());
//			personFamily.setCreaterId(sysUser.getAcd230());
////			personFamily.setCreaterOrgId(ContextUtil.getCurrentUserDept()==null?0L:ContextUtil.getCurrentUserDept().getDep001());
//			personFamily.setCreaterOrgName(personBaseInfo.getAae020());
//			personFamily.setCreaterDate(personBaseInfo.getAae036());
//			personFamilyService.add(personFamily);
//		}		
//		//生成有效账号
//		Accounts     accounts     = new Accounts();
//        Long   accountId = uniqueIdUtil.genId(Accounts.class.getName());
//		String username = Pinyin4jUtil.converterToSpell(personBaseInfo.getAac003().replace("u:", "v"))
//                + personBaseInfo.getAac002().substring(personBaseInfo.getAac002().length() - 6);
//		String userpwd = personBaseInfo.getAac002().substring(personBaseInfo.getAac002().length() - 6);
//		//ccum17
//		accounts.setCcmu01(accountId);
//		accounts.setCcmu02(username);
//		accounts.setCcmu03(userpwd);
//		accounts.setCcmu07(new Date());// 最后登录时间
//		accounts.setCcmu11(new Date());// 最后更新简历时间
//		accounts.setCcmu12(0L);// 邮箱激活状态(0-未激活1-已激活)
//		accounts.setCcmu13(0L);// 手机激活状态(0-未激活1-已激活)
//		accounts.setCcmu16(new Date());// 注册日期
//		accounts.setCcmu19(0L);// 用户人才币余额
//		accounts.setCcmu20(0L);// 企业今天已经的下载简历数
//		accounts.setCcmu21(0L);// 用户名修改次数,大于1则不能再次修改用户名
//		accounts.setCcmu22(personBaseInfo.getCczy06());// 数据来源0未知1网站2窗口3-民营机构
//		accounts.setCcpr08("0");// 是否删除状态（0-否1-是）
//		accounts.setCcmu17(1L);// 账号类型(1-个人用户2-企业用户3-民营职介机构4-公办职介机构5-财政局查询)
//		accounts.setCcmu10(1L);// 账号有效性
//        personBaseInfo.setCcmu01(accountId);// 会员编号
//		accountsService.add(accounts);		
//		messageTemplatesService.sendAccountMessage(1L, personBaseInfo.getAae005(), accounts, personBaseInfo);
//		return;
//	}
	/**
	 * 保存个人基本信息
	 * @param 
	 * @return 
	 */
	@Override
	public void addAll(String faName,String faSpouseCard,String expPersonStatus,PersonBaseInfo personBaseInfo,PersonExpand personexpand, 
			PersonExpand personExpand,PersonFamily personFamily,Accounts accounts,String nodelogs) {
		//个人扩展表信息保存
		if(expPersonStatus.isEmpty()){}else{
			PersonExpand   expand   = personExpandService.getByExpPersonId(personBaseInfo.getAac001());
			if(expand==null){
				personExpandService.add(personexpand);
			}else{
				personExpandService.update(personExpand);
			}
		}
		//个人家庭背景保存
		if(faName.isEmpty()){}else {
			if(faSpouseCard.isEmpty()){}else{
				PersonFamily fa=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
				if(fa==null){
					personFamilyService.add(personFamily);
				}else{
					personFamilyService.update(personFamily);
				}
			}}
		dao.add(personBaseInfo);
		//发送信息
	if("1".equals(nodelogs)){
	   MessageTemplates  messageTemplates = messageTemplatesService.getById(1L);
	   Node node=nodeService.getByTemplates(messageTemplates.getComm01());//根据短信模板编码查询出节点编码
	   if("T".equals(node.getComn05())){
		   ContentModel cm = new ContentModel();
		   ShortMessage shortMessage = new ShortMessage();
		   cm.setPerAccount(accounts.getCcmu02());
		   cm.setPerPwd(accounts.getCcmu03());
		   String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
		   senderService.sendVerificationCode(personBaseInfo.getAae005(),content);
		   //保存发送信息
		   shortMessage.setComc01(uniqueIdUtil.genSeqId(SqeIdName.ShortMessage.getSeqName()));
		   shortMessage.setComc02(personBaseInfo.getAae005());
		   shortMessage.setComc03(content);
		   shortMessage.setComc04(1L);
		   shortMessage.setComc05(1L);
		   shortMessage.setAae011(personBaseInfo.getAae011());
		   shortMessage.setAae017(personBaseInfo.getAae017());
		   shortMessage.setAae036(new Date());
		   shortMessage.setComn01(node.getComn01());
		   shortMessage.setComc06(0L);
		   shortMessageService.add(shortMessage);
	   }}
		//生成有效账号
		accountsService.add(accounts);
		return;
	}
	/**
	 * 编辑个人基本信息
	 * @param 
	 * @return 
	 */
	@Override
	public void updateAll(String faName,String faSpouseCard,Long sign, PersonBaseInfo personBaseInfo,PersonExpand personExpand, PersonExpand expand,
			PersonExpand personexpand, PersonFamily familyperson,Accounts account,String nodeLogs) {
			if(expand!=null){
				if(sign!=1){
					personExpandService.update(personExpand);
				}else{
					personExpandService.update(expand);
				}
			}else{
				if(sign!=1){
					personExpandService.add(personexpand);
				}
			}
			if(sign!=1){
				PersonFamily family=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
				if(family==null){
					if(faName.isEmpty()){}else {
						if(faSpouseCard.isEmpty()){}else{
							personFamilyService.add(familyperson);
						}
					} 
				}else{
					personFamilyService.update(familyperson);
				}
			}
			   //发送信息
			if(account!=null){
				if("1".equals(nodeLogs)){
					MessageTemplates  messageTemplates = messageTemplatesService.getById(1L);
					   Node node=nodeService.getByTemplates(messageTemplates.getComm01());//根据短信模板编码查询出节点编码
					   if("T".equals(node.getComn05())){
						   ContentModel cm = new ContentModel();
						   ShortMessage shortMessage = new ShortMessage();
						   cm.setPerAccount(account.getCcmu02());
						   cm.setPerPwd(account.getCcmu03());
						   String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
						   senderService.sendVerificationCode(personBaseInfo.getAae005(),content);
						   //保存发送信息
						   shortMessage.setComc01(uniqueIdUtil.genSeqId(SqeIdName.ShortMessage.getSeqName()));
						   shortMessage.setComc02(personBaseInfo.getAae005());
						   shortMessage.setComc03(content);
						   shortMessage.setComc04(1L);
						   shortMessage.setComc05(1L);
						   shortMessage.setAae011(personBaseInfo.getAae011());
						   shortMessage.setAae017(personBaseInfo.getAae017());
						   shortMessage.setAae036(new Date());
						   shortMessage.setComn01(node.getComn01());
						   shortMessage.setComc06(0L);
						   shortMessageService.add(shortMessage);
					   }
				} 
			}
			 
			
			dao.update(personBaseInfo);
			return;
		
	}

	/* (non-Javadoc)
	 * @see com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf#getCommPersonList(com.xunfeng.core.web.query.QueryFilter)
	 */
	@Override
	public ResultData<Map<String, Object>> getCommPersonList(QueryFilter fiter) {
		ResultData<Map<String, Object>> resultData=new ResultData<Map<String, Object>>();
		List<Map<String, Object>> dataList =dao.getListForm("getCommPersonList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	/* (non-Javadoc)
	 * @see com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf#getCommPersonList(com.xunfeng.core.web.query.QueryFilter)
	 */
	@Override
	public ResultData<Map<String, Object>> getCommBasePersonList(QueryFilter fiter) {
		ResultData<Map<String, Object>> resultData=new ResultData<Map<String, Object>>();
		List<Map<String, Object>> dataList =dao.getListForm("getCommBasePersonList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	
	public ResultData<Map>  getMapPersonList(String searchValue,PageBean pageBean){
		ResultData<Map> resultData=new ResultData<Map>();
		QueryFilter queryFilter=new QueryFilter();
		queryFilter.addFilter("searchValue", "%"+searchValue+"%");
		queryFilter.setPageBean(pageBean);
        List<Map> dataList= dao.getListForm("getMapPersonList", queryFilter) ;
        resultData.setDataList(dataList);
        resultData.setPageBean(pageBean);
        return resultData;
	}
	public Long getNoPermissionCount(String aac001s,Long opOrgId){
		Map params=new HashMap();
		params.put("aac001s", aac001s);
		params.put("opOrgId", opOrgId);
		return (Long)dao.getOne("getNoPermissionCount", params);
	}
}
