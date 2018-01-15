package com.xunfeng.sys.accounts.model;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wanghan
 * @createDate 2015年7月1日-上午11:23:37
 * @version V1.0
 */
public class AccountBo {

	
	public static final Long ACCOUNT_TYPE_PERSON=1L;
	public static final Long ACCOUNT_TYPE_CORP=2L;
	// 注册Ip
	private String ip;
	// 用户名
	private String userName;
	// 身份证号
	private String unId;
	// 手机
	private String phone;
	// 邮件
	private String mail;
	// 账户类型
	private Long accountType;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUnId() {
		return unId;
	}

	public void setUnId(String unId) {
		this.unId = unId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getAccountType() {
		return accountType;
	}

	public void setAccountType(Long accountType) {
		this.accountType = accountType;
	}

}
