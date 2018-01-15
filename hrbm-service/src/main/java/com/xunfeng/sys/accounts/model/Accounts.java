package com.xunfeng.sys.accounts.model;


import com.xunfeng.core.json.JsonDateSerializer;
import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * 对象功能:用户信息表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-01 09:24:01
 */
public class Accounts extends BaseModel
{
	
	public static final String SESSION_ACCOUNT="SESSION_ACCOUNT";
	// 用户信息表自动编号
	protected Long  ccmu01;
	// 用户名
	protected String  ccmu02;
	// 密码
	protected String  ccmu03;
	// 密码问题
	protected String  ccmu04;
	// 密码答案
	protected String  ccmu05;
	// 注册IP
	protected String  ccmu06;
	// 最后登录时间
	protected java.util.Date  ccmu07;
	// 邮箱
	protected String  ccmu08;
	// 手机
	protected String  ccmu09;
	// 账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用) 个人:仅1,2 单位:1,2,4,5
	protected Long  ccmu10;
	// 最后更新简历时间
	protected java.util.Date  ccmu11;
	// 邮箱激活状态(0-未激活1-已激活)
	protected Long  ccmu12;
	// 手机激活状态(0-未激活1-已激活)
	protected Long  ccmu13;
	// QQ号码
	protected String  ccmu14;
	// 头像(链接地址)
	protected String  ccmu15;
	// 注册日期
	protected java.util.Date  ccmu16;
	// 账号类型(1-个人用户2-企业用户3-民营职介机构4-公办职介机构5-财政局查询)
	protected Long  ccmu17;
	// QQ互联key值
	protected String  ccmu18;
	// 用户人才币余额
	protected Long  ccmu19;
	// 企业今天已经的下载简历数
	protected Long  ccmu20;
	// 用户名修改次数,大于1则不能再次修改用户名
	protected Long  ccmu21;
	// 数据来源0未知1网站2窗口3-民营机构
	protected String  ccmu22;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	//用户名  不需要映射
	protected String userName;
	
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 用户信息表自动编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setCcmu02(String ccmu02) 
	{
		this.ccmu02 = ccmu02;
	}
	/**
	 * 返回 用户名
	 * @return
	 */
	public String getCcmu02() 
	{
		return this.ccmu02;
	}
	public void setCcmu03(String ccmu03) 
	{
		this.ccmu03 = ccmu03;
	}
	/**
	 * 返回 密码
	 * @return
	 */
	public String getCcmu03() 
	{
		return this.ccmu03;
	}
	public void setCcmu04(String ccmu04) 
	{
		this.ccmu04 = ccmu04;
	}
	/**
	 * 返回 密码问题
	 * @return
	 */
	public String getCcmu04() 
	{
		return this.ccmu04;
	}
	public void setCcmu05(String ccmu05) 
	{
		this.ccmu05 = ccmu05;
	}
	/**
	 * 返回 密码答案
	 * @return
	 */
	public String getCcmu05() 
	{
		return this.ccmu05;
	}
	public void setCcmu06(String ccmu06) 
	{
		this.ccmu06 = ccmu06;
	}
	/**
	 * 返回 注册IP
	 * @return
	 */
	public String getCcmu06() 
	{
		return this.ccmu06;
	}
	public void setCcmu07(java.util.Date ccmu07) 
	{
		this.ccmu07 = ccmu07;
	}
	/**
	 * 返回 最后登录时间
	 * @return
	 */
	@JsonSerialize(using = JsonDateSerializer.class)
	public java.util.Date getCcmu07() 
	{
		return this.ccmu07;
	}
	public void setCcmu08(String ccmu08) 
	{
		this.ccmu08 = ccmu08;
	}
	/**
	 * 返回 邮箱
	 * @return
	 */
	public String getCcmu08() 
	{
		return this.ccmu08;
	}
	public void setCcmu09(String ccmu09) 
	{
		this.ccmu09 = ccmu09;
	}
	/**
	 * 返回 手机
	 * @return
	 */
	public String getCcmu09() 
	{
		return this.ccmu09;
	}
	public void setCcmu10(Long ccmu10) 
	{
		this.ccmu10 = ccmu10;
	}
	/**
	 * 返回 账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用) 个人:仅1,2 单位:1,2,4,5
	 * @return
	 */
	public Long getCcmu10() 
	{
		return this.ccmu10;
	}
	public void setCcmu11(java.util.Date ccmu11) 
	{
		this.ccmu11 = ccmu11;
	}
	/**
	 * 返回 最后更新简历时间
	 * @return
	 */
	public java.util.Date getCcmu11() 
	{
		return this.ccmu11;
	}
	public void setCcmu12(Long ccmu12) 
	{
		this.ccmu12 = ccmu12;
	}
	/**
	 * 返回 邮箱激活状态(0-未激活1-已激活)
	 * @return
	 */
	public Long getCcmu12() 
	{
		return this.ccmu12;
	}
	public void setCcmu13(Long ccmu13) 
	{
		this.ccmu13 = ccmu13;
	}
	/**
	 * 返回 手机激活状态(0-未激活1-已激活)
	 * @return
	 */
	public Long getCcmu13() 
	{
		return this.ccmu13;
	}
	public void setCcmu14(String ccmu14) 
	{
		this.ccmu14 = ccmu14;
	}
	/**
	 * 返回 QQ号码
	 * @return
	 */
	public String getCcmu14() 
	{
		return this.ccmu14;
	}
	public void setCcmu15(String ccmu15) 
	{
		this.ccmu15 = ccmu15;
	}
	/**
	 * 返回 头像(链接地址)
	 * @return
	 */
	public String getCcmu15() 
	{
		return this.ccmu15;
	}
	public void setCcmu16(java.util.Date ccmu16) 
	{
		this.ccmu16 = ccmu16;
	}
	/**
	 * 返回 注册日期
	 * @return
	 */
	public java.util.Date getCcmu16() 
	{
		return this.ccmu16;
	}
	public void setCcmu17(Long ccmu17) 
	{
		this.ccmu17 = ccmu17;
	}
	/**
	 * 返回 账号类型(1-个人用户2-企业用户3-民营职介机构4-公办职介机构5-财政局查询)
	 * @return
	 */
	public Long getCcmu17() 
	{
		return this.ccmu17;
	}
	public void setCcmu18(String ccmu18) 
	{
		this.ccmu18 = ccmu18;
	}
	/**
	 * 返回 QQ互联key值
	 * @return
	 */
	public String getCcmu18() 
	{
		return this.ccmu18;
	}
	public void setCcmu19(Long ccmu19) 
	{
		this.ccmu19 = ccmu19;
	}
	/**
	 * 返回 用户人才币余额
	 * @return
	 */
	public Long getCcmu19() 
	{
		return this.ccmu19;
	}
	public void setCcmu20(Long ccmu20) 
	{
		this.ccmu20 = ccmu20;
	}
	/**
	 * 返回 企业今天已经的下载简历数
	 * @return
	 */
	public Long getCcmu20() 
	{
		return this.ccmu20;
	}
	public void setCcmu21(Long ccmu21) 
	{
		this.ccmu21 = ccmu21;
	}
	/**
	 * 返回 用户名修改次数,大于1则不能再次修改用户名
	 * @return
	 */
	public Long getCcmu21() 
	{
		return this.ccmu21;
	}
	public void setCcmu22(String ccmu22) 
	{
		this.ccmu22 = ccmu22;
	}
	/**
	 * 返回 数据来源0未知1网站2窗口3-民营机构
	 * @return
	 */
	public String getCcmu22() 
	{
		return this.ccmu22;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof Accounts))
		{
			return false;
		}
		Accounts rhs = (Accounts) object;
		return new EqualsBuilder()
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.ccmu02, rhs.ccmu02)
		.append(this.ccmu03, rhs.ccmu03)
		.append(this.ccmu04, rhs.ccmu04)
		.append(this.ccmu05, rhs.ccmu05)
		.append(this.ccmu06, rhs.ccmu06)
		.append(this.ccmu07, rhs.ccmu07)
		.append(this.ccmu08, rhs.ccmu08)
		.append(this.ccmu09, rhs.ccmu09)
		.append(this.ccmu10, rhs.ccmu10)
		.append(this.ccmu11, rhs.ccmu11)
		.append(this.ccmu12, rhs.ccmu12)
		.append(this.ccmu13, rhs.ccmu13)
		.append(this.ccmu14, rhs.ccmu14)
		.append(this.ccmu15, rhs.ccmu15)
		.append(this.ccmu16, rhs.ccmu16)
		.append(this.ccmu17, rhs.ccmu17)
		.append(this.ccmu18, rhs.ccmu18)
		.append(this.ccmu19, rhs.ccmu19)
		.append(this.ccmu20, rhs.ccmu20)
		.append(this.ccmu21, rhs.ccmu21)
		.append(this.ccmu22, rhs.ccmu22)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ccmu01)
		.append(this.ccmu02)
		.append(this.ccmu03)
		.append(this.ccmu04)
		.append(this.ccmu05)
		.append(this.ccmu06)
		.append(this.ccmu07)
		.append(this.ccmu08)
		.append(this.ccmu09)
		.append(this.ccmu10)
		.append(this.ccmu11)
		.append(this.ccmu12)
		.append(this.ccmu13)
		.append(this.ccmu14)
		.append(this.ccmu15)
		.append(this.ccmu16)
		.append(this.ccmu17)
		.append(this.ccmu18)
		.append(this.ccmu19)
		.append(this.ccmu20)
		.append(this.ccmu21)
		.append(this.ccmu22)
		.append(this.ccpr08)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ccmu01", this.ccmu01) 
		.append("ccmu02", this.ccmu02) 
		.append("ccmu03", this.ccmu03) 
		.append("ccmu04", this.ccmu04) 
		.append("ccmu05", this.ccmu05) 
		.append("ccmu06", this.ccmu06) 
		.append("ccmu07", this.ccmu07) 
		.append("ccmu08", this.ccmu08) 
		.append("ccmu09", this.ccmu09) 
		.append("ccmu10", this.ccmu10) 
		.append("ccmu11", this.ccmu11) 
		.append("ccmu12", this.ccmu12) 
		.append("ccmu13", this.ccmu13) 
		.append("ccmu14", this.ccmu14) 
		.append("ccmu15", this.ccmu15) 
		.append("ccmu16", this.ccmu16) 
		.append("ccmu17", this.ccmu17) 
		.append("ccmu18", this.ccmu18) 
		.append("ccmu19", this.ccmu19) 
		.append("ccmu20", this.ccmu20) 
		.append("ccmu21", this.ccmu21) 
		.append("ccmu22", this.ccmu22) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
  

}