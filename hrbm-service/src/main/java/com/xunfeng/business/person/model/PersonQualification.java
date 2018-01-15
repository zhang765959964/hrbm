package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 对象功能:个人资格证书表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-07-21 15:59:29
 */
public class PersonQualification extends BaseModel
{
	// 资格证书记录表编号
	protected Long  aac0c1;
	// 个人编号
	protected Long  aac001;
	// 证书字典表对应id
	protected String  aac0c2;
	// 证书上自带编号
	protected String  aac0c3;
	// 获证日期
	protected java.util.Date  aac0c4;
	// 颁发枫树字典表id
	protected String  aac0c5;
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
	// 经办机构名称
	protected String  aae020;
	// 机构行政区划
	protected String  aae022;
	// 数据来源
	protected String  cczy06;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 证书名称
	protected String  bac0c2;
	// 颁发机构
	protected String  bac0c5;
	// 其他技能说明
	protected String  bae013;
	// 获证年份
	protected String  bac0c4;
	// 等级
	protected String  bac0c6;
	// 设备编号
	protected Long  div001;
	public void setAac0c1(Long aac0c1) 
	{
		this.aac0c1 = aac0c1;
	}
	/**
	 * 返回 资格证书记录表编号
	 * @return
	 */
	public Long getAac0c1() 
	{
		return this.aac0c1;
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
	public void setAac0c2(String aac0c2) 
	{
		this.aac0c2 = aac0c2;
	}
	/**
	 * 返回 证书字典表对应id
	 * @return
	 */
	public String getAac0c2() 
	{
		return this.aac0c2;
	}
	public void setAac0c3(String aac0c3) 
	{
		this.aac0c3 = aac0c3;
	}
	/**
	 * 返回 证书上自带编号
	 * @return
	 */
	public String getAac0c3() 
	{
		return this.aac0c3;
	}
	public void setAac0c4(java.util.Date aac0c4) 
	{
		this.aac0c4 = aac0c4;
	}
	/**
	 * 返回 获证日期
	 * @return
	 */
	public java.util.Date getAac0c4() 
	{
		return this.aac0c4;
	}
	public void setAac0c5(String aac0c5) 
	{
		this.aac0c5 = aac0c5;
	}
	/**
	 * 返回 颁发枫树字典表id
	 * @return
	 */
	public String getAac0c5() 
	{
		return this.aac0c5;
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
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源
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
	public void setBac0c2(String bac0c2) 
	{
		this.bac0c2 = bac0c2;
	}
	/**
	 * 返回 证书名称
	 * @return
	 */
	public String getBac0c2() 
	{
		return this.bac0c2;
	}
	public void setBac0c5(String bac0c5) 
	{
		this.bac0c5 = bac0c5;
	}
	/**
	 * 返回 颁发机构
	 * @return
	 */
	public String getBac0c5() 
	{
		return this.bac0c5;
	}
	public void setBae013(String bae013) 
	{
		this.bae013 = bae013;
	}
	/**
	 * 返回 其他技能说明
	 * @return
	 */
	public String getBae013() 
	{
		return this.bae013;
	}
	public void setBac0c4(String bac0c4) 
	{
		this.bac0c4 = bac0c4;
	}
	/**
	 * 返回 获证年份
	 * @return
	 */
	public String getBac0c4() 
	{
		return this.bac0c4;
	}
	public void setBac0c6(String bac0c6) 
	{
		this.bac0c6 = bac0c6;
	}
	/**
	 * 返回 等级
	 * @return
	 */
	public String getBac0c6() 
	{
		return this.bac0c6;
	}
	public void setDiv001(Long div001) 
	{
		this.div001 = div001;
	}
	/**
	 * 返回 设备编号
	 * @return
	 */
	public Long getDiv001() 
	{
		return this.div001;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof PersonQualification))
		{
			return false;
		}
		PersonQualification rhs = (PersonQualification) object;
		return new EqualsBuilder()
		.append(this.aac0c1, rhs.aac0c1)
		.append(this.aac001, rhs.aac001)
		.append(this.aac0c2, rhs.aac0c2)
		.append(this.aac0c3, rhs.aac0c3)
		.append(this.aac0c4, rhs.aac0c4)
		.append(this.aac0c5, rhs.aac0c5)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.cczy06, rhs.cczy06)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.bac0c2, rhs.bac0c2)
		.append(this.bac0c5, rhs.bac0c5)
		.append(this.bae013, rhs.bae013)
		.append(this.bac0c4, rhs.bac0c4)
		.append(this.bac0c6, rhs.bac0c6)
		.append(this.div001, rhs.div001)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.aac0c1)
		.append(this.aac001)
		.append(this.aac0c2)
		.append(this.aac0c3)
		.append(this.aac0c4)
		.append(this.aac0c5)
		.append(this.aae013)
		.append(this.aae011)
		.append(this.aae017)
		.append(this.aae036)
		.append(this.aae019)
		.append(this.aae020)
		.append(this.aae022)
		.append(this.cczy06)
		.append(this.ccpr05)
		.append(this.ccpr06)
		.append(this.ccpr07)
		.append(this.ccpr08)
		.append(this.bac0c2)
		.append(this.bac0c5)
		.append(this.bae013)
		.append(this.bac0c4)
		.append(this.bac0c6)
		.append(this.div001)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("aac0c1", this.aac0c1) 
		.append("aac001", this.aac001) 
		.append("aac0c2", this.aac0c2) 
		.append("aac0c3", this.aac0c3) 
		.append("aac0c4", this.aac0c4) 
		.append("aac0c5", this.aac0c5) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("cczy06", this.cczy06) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("bac0c2", this.bac0c2) 
		.append("bac0c5", this.bac0c5) 
		.append("bae013", this.bae013) 
		.append("bac0c4", this.bac0c4) 
		.append("bac0c6", this.bac0c6) 
		.append("div001", this.div001) 
		.toString();
	}
   
  

}