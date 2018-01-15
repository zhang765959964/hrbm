package com.xunfeng.sys.sendmessage.util;

public class SendContext {
	
	
	/**
	 *  个人基本信息表  AC01 AAC003 个人姓名
	 */
	protected String personName;
	
	protected String personPhone;
	
	/**
	 *  单位基本信息表 AB01 AAB004  单位名称
	 */
	protected String corpName;
	
	protected String corpPhone;
	
	/**
	 *   注册表 CCM01
	 */
	// 个人账号（单位账号） CCMU02
	protected String  accountNumber;
	// 个人密码 （单位密码）CCMU03
	protected String password;
	
	/**
	 * RSDA_BS_PERSON_RETIRE_LOG  INTER_STATUS 内审字段  35正常内审通过，36正常内审不通过
	 * @return
	 */
	// 退休内审（审批结果）
	protected Long interStatus;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getInterStatus() {
		return interStatus;
	}

	public void setInterStatus(Long interStatus) {
		this.interStatus = interStatus;
	}

	public String getCorpPhone() {
		return corpPhone;
	}

	public void setCorpPhone(String corpPhone) {
		this.corpPhone = corpPhone;
	}
	
	
	
}
