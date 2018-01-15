package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:个人技能表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:54
 */
public class PersonSkill extends BaseModel
{
	// 技能编号

	protected Long  acc0d0;
	// 个人编号
	protected Long  aac001;
	// 技能或特长
	protected String  acc0d1;
	// 获取证书日期
	protected java.util.Date  acc041;
	// 国家职业资格等级
	protected String  aac015;
	// 从业工种代码
	protected String  aca111;
	// 从业工种名称
	protected String  aca112;
	// 证书号码
	protected String  acc0d5;
	// 从事年限
	protected String  acc0d6;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办人
	protected String  aae019;
	// 经办机构代码
	protected String  aae017;
	// 经办机构名称
	protected String  aae020;
	// 机构行政区划
	protected String  aae022;
	// 经办日期
	protected java.util.Date  aae036;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	public void setAcc0d0(Long acc0d0) 
	{
		this.acc0d0 = acc0d0;
	}
	/**
	 * 返回 技能编号

	 * @return
	 */
	public Long getAcc0d0() 
	{
		return this.acc0d0;
	}
	public void setAac001(Long aac001) 
	{
		this.aac001 = aac001;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public Long getAac001() 
	{
		return this.aac001;
	}
	public void setAcc0d1(String acc0d1) 
	{
		this.acc0d1 = acc0d1;
	}
	/**
	 * 返回 技能或特长
	 * @return
	 */
	public String getAcc0d1() 
	{
		return this.acc0d1;
	}
	public void setAcc041(java.util.Date acc041) 
	{
		this.acc041 = acc041;
	}
	/**
	 * 返回 获取证书日期
	 * @return
	 */
	public java.util.Date getAcc041() 
	{
		return this.acc041;
	}
	public void setAac015(String aac015) 
	{
		this.aac015 = aac015;
	}
	/**
	 * 返回 国家职业资格等级
	 * @return
	 */
	public String getAac015() 
	{
		return this.aac015;
	}
	public void setAca111(String aca111) 
	{
		this.aca111 = aca111;
	}
	/**
	 * 返回 从业工种代码
	 * @return
	 */
	public String getAca111() 
	{
		return this.aca111;
	}
	public void setAca112(String aca112) 
	{
		this.aca112 = aca112;
	}
	/**
	 * 返回 从业工种名称
	 * @return
	 */
	public String getAca112() 
	{
		return this.aca112;
	}
	public void setAcc0d5(String acc0d5) 
	{
		this.acc0d5 = acc0d5;
	}
	/**
	 * 返回 证书号码
	 * @return
	 */
	public String getAcc0d5() 
	{
		return this.acc0d5;
	}
	public void setAcc0d6(String acc0d6) 
	{
		this.acc0d6 = acc0d6;
	}
	/**
	 * 返回 从事年限
	 * @return
	 */
	public String getAcc0d6() 
	{
		return this.acc0d6;
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
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构名称
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setAae022(String aae022) 
	{
		this.aae022 = aae022;
	}
	/**
	 * 返回 机构行政区划
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
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
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源0未知1网站2窗口
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCcpr05(java.util.Date ccpr05) 
	{
		this.ccpr05 = ccpr05;
	}
	/**
	 * 返回 最后修改时间
	 * @return
	 */
	public java.util.Date getCcpr05() 
	{
		return this.ccpr05;
	}
	public void setCcpr06(String ccpr06) 
	{
		this.ccpr06 = ccpr06;
	}
	/**
	 * 返回 修改人
	 * @return
	 */
	public String getCcpr06() 
	{
		return this.ccpr06;
	}
	public void setCcpr07(String ccpr07) 
	{
		this.ccpr07 = ccpr07;
	}
	/**
	 * 返回 修改来源
	 * @return
	 */
	public String getCcpr07() 
	{
		return this.ccpr07;
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
		if (!(object instanceof PersonSkill))
		{
			return false;
		}
		PersonSkill rhs = (PersonSkill) object;
		return new EqualsBuilder()
		.append(this.acc0d0, rhs.acc0d0)
		.append(this.aac001, rhs.aac001)
		.append(this.acc0d1, rhs.acc0d1)
		.append(this.acc041, rhs.acc041)
		.append(this.aac015, rhs.aac015)
		.append(this.aca111, rhs.aca111)
		.append(this.aca112, rhs.aca112)
		.append(this.acc0d5, rhs.acc0d5)
		.append(this.acc0d6, rhs.acc0d6)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae017, rhs.aae017)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.aae036, rhs.aae036)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acc0d0)
		.append(this.aac001)
		.append(this.acc0d1)
		.append(this.acc041)
		.append(this.aac015)
		.append(this.aca111)
		.append(this.aca112)
		.append(this.acc0d5)
		.append(this.acc0d6)
		.append(this.aae013)
		.append(this.aae011)
		.append(this.aae019)
		.append(this.aae017)
		.append(this.aae020)
		.append(this.aae022)
		.append(this.aae036)
		.append(this.cczy06)
		.append(this.ccpr05)
		.append(this.ccpr06)
		.append(this.ccpr07)
		.append(this.ccpr08)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acc0d0", this.acc0d0) 
		.append("aac001", this.aac001) 
		.append("acc0d1", this.acc0d1) 
		.append("acc041", this.acc041) 
		.append("aac015", this.aac015) 
		.append("aca111", this.aca111) 
		.append("aca112", this.aca112) 
		.append("acc0d5", this.acc0d5) 
		.append("acc0d6", this.acc0d6) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae017", this.aae017) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("aae036", this.aae036) 
		.append("cczy06", this.cczy06) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.toString();
	}
   
  

}