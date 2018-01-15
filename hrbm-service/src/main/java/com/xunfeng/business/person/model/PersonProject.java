package com.xunfeng.business.person.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 项目经验表 Model对象
* @author:wanghan
* @createDate 2015-07-22 11:18:06 
* @version V1.0   
*/
public class PersonProject extends BaseModel
{
	// 项目流水号
	protected Long  aac0e0;
	// 个人编号
	protected Long  aac001;
	// 公司名称
	protected String  aac0e1;
	// 项目名称
	protected String  aac0e2;
	// 项目开始时间
	protected java.util.Date  aac0e3;
	// 项目结束时间
	protected java.util.Date  aac0e4;
	// 项目描述
	protected String  aac0e5;
	// 开发团队人员数量 数量段 1到5人；6到10人；10到20人；20人以上
	protected String  aac0e6;
	// 项目职位
	protected String  aac0e7;
	// 项目职责
	protected String  aac0e8;
	// 项目业绩
	protected String  aac0e9;
	// 开发工具
	protected String  aac0ea;
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
	public void setAac0e0(Long aac0e0) 
	{
		this.aac0e0 = aac0e0;
	}
	/**
	 * 返回 项目流水号
	 * @return
	 */
	public Long getAac0e0() 
	{
		return this.aac0e0;
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
	public void setAac0e1(String aac0e1) 
	{
		this.aac0e1 = aac0e1;
	}
	/**
	 * 返回 公司名称
	 * @return
	 */
	public String getAac0e1() 
	{
		return this.aac0e1;
	}
	public void setAac0e2(String aac0e2) 
	{
		this.aac0e2 = aac0e2;
	}
	/**
	 * 返回 项目名称
	 * @return
	 */
	public String getAac0e2() 
	{
		return this.aac0e2;
	}
	public void setAac0e3(java.util.Date aac0e3) 
	{
		this.aac0e3 = aac0e3;
	}
	/**
	 * 返回 项目开始时间
	 * @return
	 */
	public java.util.Date getAac0e3() 
	{
		return this.aac0e3;
	}
	public void setAac0e4(java.util.Date aac0e4) 
	{
		this.aac0e4 = aac0e4;
	}
	/**
	 * 返回 项目结束时间
	 * @return
	 */
	public java.util.Date getAac0e4() 
	{
		return this.aac0e4;
	}
	public void setAac0e5(String aac0e5) 
	{
		this.aac0e5 = aac0e5;
	}
	/**
	 * 返回 项目描述
	 * @return
	 */
	public String getAac0e5() 
	{
		return this.aac0e5;
	}
	public void setAac0e6(String aac0e6) 
	{
		this.aac0e6 = aac0e6;
	}
	/**
	 * 返回 开发团队人员数量 数量段 1到5人；6到10人；10到20人；20人以上
	 * @return
	 */
	public String getAac0e6() 
	{
		return this.aac0e6;
	}
	public void setAac0e7(String aac0e7) 
	{
		this.aac0e7 = aac0e7;
	}
	/**
	 * 返回 项目职位
	 * @return
	 */
	public String getAac0e7() 
	{
		return this.aac0e7;
	}
	public void setAac0e8(String aac0e8) 
	{
		this.aac0e8 = aac0e8;
	}
	/**
	 * 返回 项目职责
	 * @return
	 */
	public String getAac0e8() 
	{
		return this.aac0e8;
	}
	public void setAac0e9(String aac0e9) 
	{
		this.aac0e9 = aac0e9;
	}
	/**
	 * 返回 项目业绩
	 * @return
	 */
	public String getAac0e9() 
	{
		return this.aac0e9;
	}
	public void setAac0ea(String aac0ea) 
	{
		this.aac0ea = aac0ea;
	}
	/**
	 * 返回 开发工具
	 * @return
	 */
	public String getAac0ea() 
	{
		return this.aac0ea;
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
		if (!(object instanceof PersonProject))
		{
			return false;
		}
		PersonProject rhs = (PersonProject) object;
		return new EqualsBuilder()
		.append(this.aac0e0, rhs.aac0e0)
		.append(this.aac001, rhs.aac001)
		.append(this.aac0e1, rhs.aac0e1)
		.append(this.aac0e2, rhs.aac0e2)
		.append(this.aac0e3, rhs.aac0e3)
		.append(this.aac0e4, rhs.aac0e4)
		.append(this.aac0e5, rhs.aac0e5)
		.append(this.aac0e6, rhs.aac0e6)
		.append(this.aac0e7, rhs.aac0e7)
		.append(this.aac0e8, rhs.aac0e8)
		.append(this.aac0e9, rhs.aac0e9)
		.append(this.aac0ea, rhs.aac0ea)
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
		.append(this.aac0e0)
		.append(this.aac001)
		.append(this.aac0e1)
		.append(this.aac0e2)
		.append(this.aac0e3)
		.append(this.aac0e4)
		.append(this.aac0e5)
		.append(this.aac0e6)
		.append(this.aac0e7)
		.append(this.aac0e8)
		.append(this.aac0e9)
		.append(this.aac0ea)
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
		.append("aac0e0", this.aac0e0) 
		.append("aac001", this.aac001) 
		.append("aac0e1", this.aac0e1) 
		.append("aac0e2", this.aac0e2) 
		.append("aac0e3", this.aac0e3) 
		.append("aac0e4", this.aac0e4) 
		.append("aac0e5", this.aac0e5) 
		.append("aac0e6", this.aac0e6) 
		.append("aac0e7", this.aac0e7) 
		.append("aac0e8", this.aac0e8) 
		.append("aac0e9", this.aac0e9) 
		.append("aac0ea", this.aac0ea) 
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