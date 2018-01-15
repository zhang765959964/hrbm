package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 语言能力表 Model对象
* @author:wanghan
* @createDate 2015-07-22 11:17:52 
* @version V1.0   
*/
public class Personlanguage extends BaseModel
{
	// 语言流水号
	protected Long  aac0f0;
	// 个人编号
	protected Long  aac001;
	// 语言名称
	protected String  aac0f1;
	// 熟练度 一般；熟练；精通
	protected String  aac0f2;
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
	// 设备编号
	protected Long  div001;
	public void setAac0f0(Long aac0f0) 
	{
		this.aac0f0 = aac0f0;
	}
	/**
	 * 返回 语言流水号
	 * @return
	 */
	public Long getAac0f0() 
	{
		return this.aac0f0;
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
	public void setAac0f1(String aac0f1) 
	{
		this.aac0f1 = aac0f1;
	}
	/**
	 * 返回 语言名称
	 * @return
	 */
	public String getAac0f1() 
	{
		return this.aac0f1;
	}
	public void setAac0f2(String aac0f2) 
	{
		this.aac0f2 = aac0f2;
	}
	/**
	 * 返回 熟练度 一般；熟练；精通
	 * @return
	 */
	public String getAac0f2() 
	{
		return this.aac0f2;
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
		if (!(object instanceof Personlanguage))
		{
			return false;
		}
		Personlanguage rhs = (Personlanguage) object;
		return new EqualsBuilder()
		.append(this.aac0f0, rhs.aac0f0)
		.append(this.aac001, rhs.aac001)
		.append(this.aac0f1, rhs.aac0f1)
		.append(this.aac0f2, rhs.aac0f2)
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
		.append(this.div001, rhs.div001)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.aac0f0)
		.append(this.aac001)
		.append(this.aac0f1)
		.append(this.aac0f2)
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
		.append(this.div001)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("aac0f0", this.aac0f0) 
		.append("aac001", this.aac001) 
		.append("aac0f1", this.aac0f1) 
		.append("aac0f2", this.aac0f2) 
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
		.append("div001", this.div001) 
		.toString();
	}
   
  

}