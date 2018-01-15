package com.xunfeng.sys.accounts.interf;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.accounts.model.Accounts;

/**
 * <pre>
 * 对象功能:用户信息表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-01 09:24:01
 * </pre>
 */
@Service
public interface AccountsServiceInter extends GenericServiceInterface<Accounts,Long> {

		
	public Accounts getAccountsByName(String name);

	public Accounts getAccountsByNameAndType(String name,String type);
	
	public void updatePassword(Long accountId,String password);
	public boolean validatePassword(Long accountId,String oldPassword);
	public boolean activateEmail(Long accountId);
	/**
	 * 保存企业注册账号信息
	 */
	public void AddRegisterCorpAccount(Corp corp,Accounts account);
	/**
	 * 保存个人信息并发送短信
	 * @param personBaseInfo
	 * @param account
	 */
	public void registerPerAccount(PersonBaseInfo personBaseInfo,Accounts account);
	/**
	 * 找回密码 密保找回
	 * @param userName
	 * @param pwdProTitle
	 * @param pwdProResult
	 * @return
	 */
	public Long checkPwdPro(String userName,String pwdProTitle,String pwdProResult);
	/**
	 * 修改密码 密保找回
	 * @param userName
	 * @param pwdProCode
	 * @param pwdProResult
	 * @param pwd
	 * @return
	 */
	public void updatePwdByPwdPro(String userName,String pwdProTitle,String pwdProResult,String pwd);
	/**
	 * 找回密码 手机验证
	 * @param userName
	 * @param pwdProCode
	 * @param pwdProResult
	 * @return
	 */
	public Long checkPhone(String phone);
	/**
	 * 修改密码 手机验证
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public void updatePwdByPhone(String phone,String pwd);
	/**
	 * 找回密码 邮箱验证
	 * @param userName
	 * @param pwdProCode
	 * @param pwdProResult
	 * @return
	 */
	public Long checkEmail(String emailPath);
	/**
	 * 修改密码 邮箱验证
	 * @param userName
	 * @param pwd
	 * @return
	 */
	public void updatePwdByEmail(String email,String pwd);
	/**
	 * 个人账号维护
	 * @param 
	 * @param 
	 * @return
	 */
	public ResultData<Map>  getAllByFilter(QueryFilter filter);
	/**
	 * 个人账号维护
	 * @param 
	 * @param 
	 * @return
	 */
	public ResultData<Map>  getAllByCorp(QueryFilter filter);
	/**
	 *上传个人头像简历增加分数(只有个人上传头像才能增加简历完整度的分数)
	 */
	public void updatePersonPic(Long aac001,String filePath);
}
