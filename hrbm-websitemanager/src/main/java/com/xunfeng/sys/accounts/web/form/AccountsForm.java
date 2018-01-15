package com.xunfeng.sys.accounts.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.sys.accounts.model.Accounts;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 用户信息表 Form对象
* @author:wanlupeng
* @createDate 2016-08-18 14:32:33 
* @version V1.0   
*/
public class AccountsForm extends BaseForm<Accounts>
{
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
	// 账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用，在基本信息维护中填完信息,没有去完善)
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
	// 公民身份证号码
	protected String  aac002;
	// 军人证号
	protected String  aac00a;
	// 姓名
	protected String  aac003;
	// 性别
	protected String  aac004;
	// 民族
	protected String  aac005;
	// 出生日期
	protected java.util.Date  aac006;
	// 户口性质
	protected String  aac009;
	// 居住所在地
	protected String  aab301;
	// 楼院
	protected String  aac00b;
	// 单元
	protected String  aac00c;
	// 门牌号
	protected String  aac00d;
	// 户口所在地
	protected String  bab305;
	// 联系电话
	protected String  aae005;
	// 目前住房情况
	protected String  aac00e;
	// 文化程度
	protected String  aac011;
	// 毕业学校
	protected String  aac180;
	// 毕业时间
	protected java.util.Date  aac181;
	// 婚姻状况
	protected String  aac017;
	// 政治面貌
	protected String  aac024;
	// 健康状况
	protected String  aac033;
	// 电子信箱
	protected String  aae015;
	// 姓名拼音码
	protected String  aac022;
	// 邮编
	protected String  aae007;
	// 个人英文名称
	protected String  aac023;
	// 血型
	protected String  aac032;
	// 身高
	protected Float  aac034;
	// 体重
	protected Float  aac035;
	// 视力
	protected String  aac036;
	// 祖籍
	protected String  aac025;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 账号名
	protected String  cczh01;
	// （从业人员编号）经办人代码
	protected Long  acd230;
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
	 * 返回 账号状态(1-有效账号2-无效账号3-已审验未完善4-禁止登陆5-仅职介中心市场可用，在基本信息维护中填完信息,没有去完善)
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
	public void setAac002(String aac002) 
	{
		this.aac002 = aac002;
	}
	/**
	 * 返回 公民身份证号码
	 * @return
	 */
	public String getAac002() 
	{
		return this.aac002;
	}
	public void setAac00a(String aac00a) 
	{
		this.aac00a = aac00a;
	}
	/**
	 * 返回 军人证号
	 * @return
	 */
	public String getAac00a() 
	{
		return this.aac00a;
	}
	public void setAac003(String aac003) 
	{
		this.aac003 = aac003;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getAac003() 
	{
		return this.aac003;
	}
	public void setAac004(String aac004) 
	{
		this.aac004 = aac004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAac004() 
	{
		return this.aac004;
	}
	public void setAac005(String aac005) 
	{
		this.aac005 = aac005;
	}
	/**
	 * 返回 民族
	 * @return
	 */
	public String getAac005() 
	{
		return this.aac005;
	}
	public void setAac006(java.util.Date aac006) 
	{
		this.aac006 = aac006;
	}
	/**
	 * 返回 出生日期
	 * @return
	 */
	public java.util.Date getAac006() 
	{
		return this.aac006;
	}
	public void setAac009(String aac009) 
	{
		this.aac009 = aac009;
	}
	/**
	 * 返回 户口性质
	 * @return
	 */
	public String getAac009() 
	{
		return this.aac009;
	}
	public void setAab301(String aab301) 
	{
		this.aab301 = aab301;
	}
	/**
	 * 返回 居住所在地
	 * @return
	 */
	public String getAab301() 
	{
		return this.aab301;
	}
	public void setAac00b(String aac00b) 
	{
		this.aac00b = aac00b;
	}
	/**
	 * 返回 楼院
	 * @return
	 */
	public String getAac00b() 
	{
		return this.aac00b;
	}
	public void setAac00c(String aac00c) 
	{
		this.aac00c = aac00c;
	}
	/**
	 * 返回 单元
	 * @return
	 */
	public String getAac00c() 
	{
		return this.aac00c;
	}
	public void setAac00d(String aac00d) 
	{
		this.aac00d = aac00d;
	}
	/**
	 * 返回 门牌号
	 * @return
	 */
	public String getAac00d() 
	{
		return this.aac00d;
	}
	public void setBab305(String bab305) 
	{
		this.bab305 = bab305;
	}
	/**
	 * 返回 户口所在地
	 * @return
	 */
	public String getBab305() 
	{
		return this.bab305;
	}
	public void setAae005(String aae005) 
	{
		this.aae005 = aae005;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getAae005() 
	{
		return this.aae005;
	}
	public void setAac00e(String aac00e) 
	{
		this.aac00e = aac00e;
	}
	/**
	 * 返回 目前住房情况
	 * @return
	 */
	public String getAac00e() 
	{
		return this.aac00e;
	}
	public void setAac011(String aac011) 
	{
		this.aac011 = aac011;
	}
	/**
	 * 返回 文化程度
	 * @return
	 */
	public String getAac011() 
	{
		return this.aac011;
	}
	public void setAac180(String aac180) 
	{
		this.aac180 = aac180;
	}
	/**
	 * 返回 毕业学校
	 * @return
	 */
	public String getAac180() 
	{
		return this.aac180;
	}
	public void setAac181(java.util.Date aac181) 
	{
		this.aac181 = aac181;
	}
	/**
	 * 返回 毕业时间
	 * @return
	 */
	public java.util.Date getAac181() 
	{
		return this.aac181;
	}
	public void setAac017(String aac017) 
	{
		this.aac017 = aac017;
	}
	/**
	 * 返回 婚姻状况
	 * @return
	 */
	public String getAac017() 
	{
		return this.aac017;
	}
	public void setAac024(String aac024) 
	{
		this.aac024 = aac024;
	}
	/**
	 * 返回 政治面貌
	 * @return
	 */
	public String getAac024() 
	{
		return this.aac024;
	}
	public void setAac033(String aac033) 
	{
		this.aac033 = aac033;
	}
	/**
	 * 返回 健康状况
	 * @return
	 */
	public String getAac033() 
	{
		return this.aac033;
	}
	public void setAae015(String aae015) 
	{
		this.aae015 = aae015;
	}
	/**
	 * 返回 电子信箱
	 * @return
	 */
	public String getAae015() 
	{
		return this.aae015;
	}
	public void setAac022(String aac022) 
	{
		this.aac022 = aac022;
	}
	/**
	 * 返回 姓名拼音码
	 * @return
	 */
	public String getAac022() 
	{
		return this.aac022;
	}
	public void setAae007(String aae007) 
	{
		this.aae007 = aae007;
	}
	/**
	 * 返回 邮编
	 * @return
	 */
	public String getAae007() 
	{
		return this.aae007;
	}
	public void setAac023(String aac023) 
	{
		this.aac023 = aac023;
	}
	/**
	 * 返回 个人英文名称
	 * @return
	 */
	public String getAac023() 
	{
		return this.aac023;
	}
	public void setAac032(String aac032) 
	{
		this.aac032 = aac032;
	}
	/**
	 * 返回 血型
	 * @return
	 */
	public String getAac032() 
	{
		return this.aac032;
	}
	public void setAac034(Float aac034) 
	{
		this.aac034 = aac034;
	}
	/**
	 * 返回 身高
	 * @return
	 */
	public Float getAac034() 
	{
		return this.aac034;
	}
	public void setAac035(Float aac035) 
	{
		this.aac035 = aac035;
	}
	/**
	 * 返回 体重
	 * @return
	 */
	public Float getAac035() 
	{
		return this.aac035;
	}
	public void setAac036(String aac036) 
	{
		this.aac036 = aac036;
	}
	/**
	 * 返回 视力
	 * @return
	 */
	public String getAac036() 
	{
		return this.aac036;
	}
	public void setAac025(String aac025) 
	{
		this.aac025 = aac025;
	}
	/**
	 * 返回 祖籍
	 * @return
	 */
	public String getAac025() 
	{
		return this.aac025;
	}
	public void setAae013(String aae013) 
	{
		this.aae013 = aae013;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getAae013() 
	{
		return this.aae013;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
   	
	public void setCczh01(String cczh01) {
		this.cczh01 = cczh01;
	}
	public String getCczh01() {
		return this.cczh01;
	}
	public void setAcd230(Long acd230) {
		this.acd230 = acd230;
	}
	public Long getAcd230() {
		return this.acd230;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof AccountsForm)) 
		{
			return false;
		}
		AccountsForm rhs = (AccountsForm) object;
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
		.append(this.aac002, rhs.aac002)
		.append(this.aac00a, rhs.aac00a)
		.append(this.aac003, rhs.aac003)
		.append(this.aac004, rhs.aac004)
		.append(this.aac005, rhs.aac005)
		.append(this.aac006, rhs.aac006)
		.append(this.aac009, rhs.aac009)
		.append(this.aab301, rhs.aab301)
		.append(this.aac00b, rhs.aac00b)
		.append(this.aac00c, rhs.aac00c)
		.append(this.aac00d, rhs.aac00d)
		.append(this.bab305, rhs.bab305)
		.append(this.aae005, rhs.aae005)
		.append(this.aac00e, rhs.aac00e)
		.append(this.aac011, rhs.aac011)
		.append(this.aac180, rhs.aac180)
		.append(this.aac181, rhs.aac181)
		.append(this.aac017, rhs.aac017)
		.append(this.aac024, rhs.aac024)
		.append(this.aac033, rhs.aac033)
		.append(this.aae015, rhs.aae015)
		.append(this.aac022, rhs.aac022)
		.append(this.aae007, rhs.aae007)
		.append(this.aac023, rhs.aac023)
		.append(this.aac032, rhs.aac032)
		.append(this.aac034, rhs.aac034)
		.append(this.aac035, rhs.aac035)
		.append(this.aac036, rhs.aac036)
		.append(this.aac025, rhs.aac025)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.cczh01, rhs.cczh01)
		.append(this.acd230, rhs.acd230)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
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
		.append(this.aac002)
		.append(this.aac00a)
		.append(this.aac003)
		.append(this.aac004)
		.append(this.aac005)
		.append(this.aac006)
		.append(this.aac009)
		.append(this.aab301)
		.append(this.aac00b)
		.append(this.aac00c)
		.append(this.aac00d)
		.append(this.bab305)
		.append(this.aae005)
		.append(this.aac00e)
		.append(this.aac011)
		.append(this.aac180)
		.append(this.aac181)
		.append(this.aac017)
		.append(this.aac024)
		.append(this.aac033)
		.append(this.aae015)
		.append(this.aac022)
		.append(this.aae007)
		.append(this.aac023)
		.append(this.aac032)
		.append(this.aac034)
		.append(this.aac035)
		.append(this.aac036)
		.append(this.aac025)
		.append(this.aae013)
		.append(this.aae011)
		.append(this.aae017)
		.append(this.aae036)
		.append(this.aae019)
		.append(this.cczh01)
		.append(this.acd230)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
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
		.append("aac002", this.aac002) 
		.append("aac00a", this.aac00a) 
		.append("aac003", this.aac003) 
		.append("aac004", this.aac004) 
		.append("aac005", this.aac005) 
		.append("aac006", this.aac006) 
		.append("aac009", this.aac009) 
		.append("aab301", this.aab301) 
		.append("aac00b", this.aac00b) 
		.append("aac00c", this.aac00c) 
		.append("aac00d", this.aac00d) 
		.append("bab305", this.bab305) 
		.append("aae005", this.aae005) 
		.append("aac00e", this.aac00e) 
		.append("aac011", this.aac011) 
		.append("aac180", this.aac180) 
		.append("aac181", this.aac181) 
		.append("aac017", this.aac017) 
		.append("aac024", this.aac024) 
		.append("aac033", this.aac033) 
		.append("aae015", this.aae015) 
		.append("aac022", this.aac022) 
		.append("aae007", this.aae007) 
		.append("aac023", this.aac023) 
		.append("aac032", this.aac032) 
		.append("aac034", this.aac034) 
		.append("aac035", this.aac035) 
		.append("aac036", this.aac036) 
		.append("aac025", this.aac025) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019)
		.append("cczh01", this.cczh01)
		.append("acd230", this.acd230)
		.toString();
	}
   
  

}