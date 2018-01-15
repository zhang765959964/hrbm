package com.xunfeng.sys.accounts.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.dao.CorpDao;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.dao.PersonBaseInfoDao;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.dao.AccountsDao;
import com.xunfeng.sys.accounts.interf.AccountsServiceInter;
import com.xunfeng.sys.accounts.model.AccountBo;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.accounts.util.AccountPasswordUtil;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.message.interf.AccountMessageServiceInterf;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.sendmessage.service.MessageTemplatesService;
import com.xunfeng.sys.sendmessage.service.SenderService;
import com.xunfeng.sys.sendmessage.util.ContentConversion;
import com.xunfeng.sys.sendmessage.util.ContentModel;

/**
 * <pre>
 * 对象功能:用户信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-01 09:24:01
 * </pre>
 */
@Service
public class AccountsService extends BaseService<Accounts> implements AccountsServiceInter {
	@Resource
	private AccountsDao dao;
	@Resource
	private CorpDao corpDao;
	@Resource
	private PersonBaseInfoDao personBaseInfoDao;
	@Resource
	private MessageTemplatesService messageTemplatesService;
	@Resource
	private SenderService senderService;
	@Resource
	UniqueIdUtilService  UniqueIdUtil;
	@Resource
	private AccountMessageServiceInterf accountMessageService;

	public AccountsService() {
	}

	@Override
	protected IEntityDao<Accounts, Long> getEntityDao() {
		return dao;
	}
		
	public Accounts getAccountsByName(String name){
		Map params=new HashMap();
		params.put("ccmu02", name);
		return dao.getUnique("getAccountsByName", params);
		
	}
	
	public Accounts getAccountsByNameAndType(String name,String type){
		Map params=new HashMap();
		params.put("ccmu02", name);
		params.put("ccmu17", type);
		List<Accounts> accountsList = dao.getBySqlKey("getAccountsByName", params);
		if(accountsList!=null && accountsList.size()>0){
			return accountsList.get(0);
		}else{
			return null;
		}
	}

	public void updateEmail(String ccmu08,Long ccmu01){
		Map params=new HashMap();
		params.put("ccmu01",ccmu01);
		params.put("ccmu08",ccmu08);
		updateAccounts(params);

	}
	public void updatePhone(String ccmu09,Long ccmu01){
		Map params=new HashMap();
		params.put("ccmu01",ccmu01);
		params.put("ccmu09",ccmu09);
		updateAccounts(params);

	}

	public void updateAccounts(Map params){

		dao.update("updateAccounts",params);

	}

	/**
	 * 保存帐号信息
	 * 
	 * @param accountBo
	 *            帐号业务对象，如果添加的是企业帐号，不需要传用户名、身份证号信息
	 */
	public void addAccount(AccountBo accountBo) {
		if (accountBo != null) {
			Accounts accounts = new Accounts();
			// 用户类型
			if (accountBo.getAccountType().compareTo(accountBo.ACCOUNT_TYPE_PERSON) == 0) {
				List list = AccountPasswordUtil.getPersonalConversion(accountBo.getUserName(), accountBo.getUnId());
				// 注册表添加用户名
				accounts.setCcmu02(list.get(0).toString());
				// 注册表添加密码
				accounts.setCcmu03(list.get(1).toString());
				// 企业类型
			} else if (accountBo.getAccountType().compareTo(accountBo.ACCOUNT_TYPE_CORP) == 0) {
				List list = AccountPasswordUtil.getEnterpriseConversion(accountBo.getPhone());
				// 注册表添加用户名
				accounts.setCcmu02(list.get(0).toString());
				// 注册表添加密码
				accounts.setCcmu03(list.get(1).toString());
			}
			accounts.setCcmu17(accountBo.getAccountType());
			accounts.setCcmu01(UniqueIdUtil.genSeqId(SqeIdName.Accounts.getSeqName()));
			accounts.setCcmu06(accountBo.getIp());
			accounts.setCcmu07(new Date());
			accounts.setCcmu08(accountBo.getMail());
			accounts.setCcmu09(accountBo.getPhone());
			accounts.setCcmu10(1L);
			accounts.setCcmu12(0L);
			accounts.setCcmu13(0L);
			accounts.setCcmu16(new Date());
			accounts.setCcmu19(0L);
			accounts.setCcmu20(0L);
			accounts.setCcmu21(0L);
			accounts.setCcmu22("1");
			accounts.setCcpr08("0");
			dao.add(accounts);
		}
	}
	
	/**
	 *  根据用户编号修改用户密码
	 */
	
	public void updatePassword(Long accountId,String password){
		dao.updatePassword(accountId, password);
	}
	/**
	 * 根据用户编号验证密码
	 */
	public boolean validatePassword(Long accountId,String oldPassword){
		Accounts account = dao.getById(accountId);
		if(null!=account&& account.getCcmu03().equals(oldPassword)){
			return true;
		}
		return false;

	}

	/**
	 * 根据用户编号 激活手机  1激活
	 */
	public void activateTelephone(Long accountId){
		dao.updateTelephoneStatus(accountId, 1L);
	}
	
	/**
	 * 根据用户编号 激活邮箱  1激活
	 * 1.首先查看查询是否已经激活
	 * 2.
	 */
	public boolean activateEmail(Long accountId){
		boolean flag = true;
		Accounts account = dao.getById(accountId);
		Long emailStatus = account.getCcmu12();
		if(null!=emailStatus&&emailStatus.equals(1L)){
			//已经激活
			flag = false;
			//throw new RuntimeException("该邮箱已经激活！");
		}else{
			dao.updateEmailStatus(accountId, 1L);
		}
		return flag;
	}
	
	
	/**
	 *   保存学生注册信息
	 *   @param accountBo
	 *   帐号业务对象，如果添加的是企业帐号，不需要传用户名、身份证号信息
	 */
	public void addStudentAccount(Accounts accounts) {
		if (accounts != null) {
			accounts.setCcmu17(1L);
			accounts.setCcmu07(new Date());
			accounts.setCcmu10(1L);
			accounts.setCcmu12(0L);
			accounts.setCcmu13(0L);
			accounts.setCcmu16(new Date());
			accounts.setCcmu19(0L);
			accounts.setCcmu20(0L);
			accounts.setCcmu21(0L);
			accounts.setCcmu22("1");
			accounts.setCcpr08("0");
			dao.add(accounts);
		}
	}
	
	/**
	 *   保存企业注册信息
	 *   帐号业务
	 */
	public void addCorpAccount(Accounts accounts) {
		
		if (accounts != null) {
			accounts.setCcmu17(2L);
			accounts.setCcmu07(new Date());
			accounts.setCcmu10(1L);
			accounts.setCcmu12(0L);
			accounts.setCcmu13(0L);
			accounts.setCcmu16(new Date());
			accounts.setCcmu19(0L);
			accounts.setCcmu20(0L);
			accounts.setCcmu21(0L);
			accounts.setCcmu22("1");
			accounts.setCcpr08("0");
			dao.add(accounts);
		}
		
	}
	
	/**
	 * 保存企业注册账号信息
	 * 发送短信 发送站内信
	 */
	public void AddRegisterCorpAccount(Corp corp,Accounts account){
		corpDao.add(corp);
		dao.add(account);
		//发送短信
		MessageTemplates  messageTemplates = messageTemplatesService.getById(12l);
		ContentModel cm = new ContentModel();
		cm.setCorpAccount(account.getCcmu02());
		cm.setCorpPwd(account.getCcmu03());
		String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
		senderService.sendVerificationCode(corp.getAae139(), content);
		//发送站内信
		//参数 1.发件人编号2.标题3.内容4.收件人编号（编号是：aab001,或aac001）
		accountMessageService.addAccountMessage(0l,"企业注册审核成功","可以发布职位或预订招聘会",corp.getCcmu01());
	}
	
	/**
	 * 保存个人账号信息并发送短信
	 */
	public void registerPerAccount(PersonBaseInfo personBaseInfo,Accounts account){
		PersonBaseInfo temp = personBaseInfoDao.getByIdcardAndRealName(personBaseInfo.getAac002());
		if(temp != null){
			personBaseInfoDao.update(personBaseInfo);
		}else{
			personBaseInfoDao.add(personBaseInfo);
		}
		dao.add(account);
		//发送短信
		MessageTemplates  messageTemplates = messageTemplatesService.getById(1l);
		ContentModel cm = new ContentModel();
		cm.setPerAccount(account.getCcmu02());
		cm.setPerPwd(account.getCcmu03());
		String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
		senderService.sendVerificationCode(personBaseInfo.getAae005(), content);
		//个人发送站内信
		String zncontent = "您已成为该网站会员<br>会员账号为："+account.getCcmu02()+"<br>会员密码为："+account.getCcmu03()+"<br>建议登录后修改初始密码。";
		accountMessageService.addAccountMessage(0l,"欢迎成为该网站会员",zncontent,personBaseInfo.getCcmu01());
	}
	/**
	 * 找回密码 密保找回
	 * @param userName
	 * @param pwdProCode
	 * @param pwdProResult
	 * @return
	 */
	public Long checkPwdPro(String userName,String pwdProTitle,String pwdProResult){
		Map<String, String> map= new HashMap<String, String>();
		map.put("ccmu02", userName);
		map.put("ccmu04", pwdProTitle);
		map.put("ccmu05", pwdProResult);
		return (Long) dao.getOne("getTotalByValidate", map);
	}
	/**
	 * 修改密码 密保找回
	 * @param userName
	 * @param pwdProCode
	 * @param pwdProResult
	 * @param pwd
	 * @return
	 */
	public void updatePwdByPwdPro(String userName,String pwdProTitle,String pwdProResult,String pwd){
		Map<String, String> map= new HashMap<String, String>();
		map.put("ccmu02", userName);
		map.put("ccmu03", pwd);
		map.put("ccmu04", pwdProTitle);
		map.put("ccmu05", pwdProResult);
		dao.update("updatePwd", map);
	}
	
	/**
	 * 找回密码 手机验证
	 * @param userName
	 * @param pwdProCode
	 * @param pwdProResult
	 * @return
	 */
	public Long checkPhone(String phone){
		Map<String, String> map= new HashMap<String, String>();
		map.put("ccmu09", phone);
		map.put("ccmu13", "1");
		return (Long) dao.getOne("getTotalByValidate", map);
	}
	/**
	 * 修改密码 手机验证
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public void updatePwdByPhone(String phone,String pwd){
		Map<String, String> map= new HashMap<String, String>();
		map.put("ccmu09", phone);
		map.put("ccmu03", pwd);
		dao.update("updatePwd", map);
	}
	/**
	 * 找回密码 邮箱验证
	 * @param userName
	 * @param pwdProCode
	 * @param pwdProResult
	 * @return
	 */
	public Long checkEmail(String emailPath){
		Map<String, String> map= new HashMap<String, String>();
		map.put("ccmu08", emailPath);
		map.put("ccmu12", "1");
		return (Long) dao.getOne("getTotalByValidate", map);
	}
	/**
	 * 修改密码 邮箱验证
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public void updatePwdByEmail(String email,String pwd){
		Map<String, String> map= new HashMap<String, String>();
		map.put("ccmu08", email);
		map.put("ccmu03", pwd);
		dao.update("updatePwd", map);
	}
	/**
	/**
	 * 账号维护，查询信息（个人）
	 * @param 
	 * @return
	 */
	public ResultData<Map>  getAllByFilter(QueryFilter filter){
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(filter.getPageBean());
		resultData.setDataList(dao.getListForm("getAllByFilter",filter));
		return resultData;

	}
	/**
	 * 账号维护，查询信息（单位）
	 * @param 
	 * @return
	 */
	public ResultData<Map>  getAllByCorp(QueryFilter filter){
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(filter.getPageBean());
		resultData.setDataList(dao.getListForm("getAllByCorp",filter));
		return resultData;
		
	}
	/**
	 *上传个人头像简历增加分数(只有个人上传头像才能增加简历完整度的分数)
	 */
	public void updatePersonPic(Long aac001,String filePath){
		PersonBaseInfo personBaseInfo = personBaseInfoDao.getById(aac001);
		Accounts accounts = dao.getById(personBaseInfo.getCcmu01());
		if(accounts.getCcmu15()==null||accounts.getCcmu15().equals("")){
			//个人头像上传简历完整度增加5分
			//修改个人信息表
			Long resumePercent = personBaseInfo.getCcmu50()==null?0: personBaseInfo.getCcmu50();
			personBaseInfo.setCcmu50(resumePercent+5);
			personBaseInfo.setCcmu55("1");//个人头像完整
			personBaseInfoDao.update(personBaseInfo);
		}
		accounts.setCcmu15(filePath);
		dao.update(accounts);
	}
}
