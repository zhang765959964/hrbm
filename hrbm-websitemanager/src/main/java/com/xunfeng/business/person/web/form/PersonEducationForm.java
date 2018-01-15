package com.xunfeng.business.person.web.form;
import com.xunfeng.business.person.model.PersonEducation;
import com.xunfeng.core.model.BaseForm;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人教育背景表 Form对象
* @author:wanlupeng
* @createDate 2016-07-14 17:57:20 
* @version V1.0   
*/
public class PersonEducationForm extends BaseForm<PersonEducation>
{
	// 学历信息编号
	protected Long  aac0d0;
	// 个人编号
	protected Long  aac001;
	// 毕业学校
	protected String  aac045;
	// 学校性质
	protected String  aac0d2;
	// 培养方式
	protected String  aac0d3;
	// 开始时间
	protected java.util.Date  aae030;
	// 毕业时间
	protected java.util.Date  aac046;
	// 毕业证书编号
	protected String  aac0d5;
	// 学制
	protected Long  aac0d6;
	// 学历
	protected String  atc011;
	// 学位
	protected String  aac037;
	// 所学专业
	protected String  acc01g;
	// 专业描述
	protected String  aac0d4;
	// 第二专业
	protected String  atc01g;
	// 所学外语
	protected String  aac038;
	// 外语水平
	protected String  aac039;
	// 第二外语
	protected String  aac041;
	// 二外水平
	protected String  aac042;
	// 其它外语
	protected String  aac0d7;
	// 计算机水平
	protected String  aac043;
	// 学习经历
	protected String  aac0d1;
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
	public void setAac0d0(Long aac0d0) 
	{
		this.aac0d0 = aac0d0;
	}
	/**
	 * 返回 学历信息编号
	 * @return
	 */
	public Long getAac0d0() 
	{
		return this.aac0d0;
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
	public void setAac045(String aac045) 
	{
		this.aac045 = aac045;
	}
	/**
	 * 返回 毕业学校
	 * @return
	 */
	public String getAac045() 
	{
		return this.aac045;
	}
	public void setAac0d2(String aac0d2) 
	{
		this.aac0d2 = aac0d2;
	}
	/**
	 * 返回 学校性质
	 * @return
	 */
	public String getAac0d2() 
	{
		return this.aac0d2;
	}
	public void setAac0d3(String aac0d3) 
	{
		this.aac0d3 = aac0d3;
	}
	/**
	 * 返回 培养方式
	 * @return
	 */
	public String getAac0d3() 
	{
		return this.aac0d3;
	}
	public void setAae030(java.util.Date aae030) 
	{
		this.aae030 = aae030;
	}
	/**
	 * 返回 开始时间
	 * @return
	 */
	public java.util.Date getAae030() 
	{
		return this.aae030;
	}
	public void setAac046(java.util.Date aac046) 
	{
		this.aac046 = aac046;
	}
	/**
	 * 返回 毕业时间
	 * @return
	 */
	public java.util.Date getAac046() 
	{
		return this.aac046;
	}
	public void setAac0d5(String aac0d5) 
	{
		this.aac0d5 = aac0d5;
	}
	/**
	 * 返回 毕业证书编号
	 * @return
	 */
	public String getAac0d5() 
	{
		return this.aac0d5;
	}
	public void setAac0d6(Long aac0d6) 
	{
		this.aac0d6 = aac0d6;
	}
	/**
	 * 返回 学制
	 * @return
	 */
	public Long getAac0d6() 
	{
		return this.aac0d6;
	}
	public void setAtc011(String atc011) 
	{
		this.atc011 = atc011;
	}
	/**
	 * 返回 学历
	 * @return
	 */
	public String getAtc011() 
	{
		return this.atc011;
	}
	public void setAac037(String aac037) 
	{
		this.aac037 = aac037;
	}
	/**
	 * 返回 学位
	 * @return
	 */
	public String getAac037() 
	{
		return this.aac037;
	}
	public void setAcc01g(String acc01g) 
	{
		this.acc01g = acc01g;
	}
	/**
	 * 返回 所学专业
	 * @return
	 */
	public String getAcc01g() 
	{
		return this.acc01g;
	}
	public void setAac0d4(String aac0d4) 
	{
		this.aac0d4 = aac0d4;
	}
	/**
	 * 返回 专业描述
	 * @return
	 */
	public String getAac0d4() 
	{
		return this.aac0d4;
	}
	public void setAtc01g(String atc01g) 
	{
		this.atc01g = atc01g;
	}
	/**
	 * 返回 第二专业
	 * @return
	 */
	public String getAtc01g() 
	{
		return this.atc01g;
	}
	public void setAac038(String aac038) 
	{
		this.aac038 = aac038;
	}
	/**
	 * 返回 所学外语
	 * @return
	 */
	public String getAac038() 
	{
		return this.aac038;
	}
	public void setAac039(String aac039) 
	{
		this.aac039 = aac039;
	}
	/**
	 * 返回 外语水平
	 * @return
	 */
	public String getAac039() 
	{
		return this.aac039;
	}
	public void setAac041(String aac041) 
	{
		this.aac041 = aac041;
	}
	/**
	 * 返回 第二外语
	 * @return
	 */
	public String getAac041() 
	{
		return this.aac041;
	}
	public void setAac042(String aac042) 
	{
		this.aac042 = aac042;
	}
	/**
	 * 返回 二外水平
	 * @return
	 */
	public String getAac042() 
	{
		return this.aac042;
	}
	public void setAac0d7(String aac0d7) 
	{
		this.aac0d7 = aac0d7;
	}
	/**
	 * 返回 其它外语
	 * @return
	 */
	public String getAac0d7() 
	{
		return this.aac0d7;
	}
	public void setAac043(String aac043) 
	{
		this.aac043 = aac043;
	}
	/**
	 * 返回 计算机水平
	 * @return
	 */
	public String getAac043() 
	{
		return this.aac043;
	}
	public void setAac0d1(String aac0d1) 
	{
		this.aac0d1 = aac0d1;
	}
	/**
	 * 返回 学习经历
	 * @return
	 */
	public String getAac0d1() 
	{
		return this.aac0d1;
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
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonEducationForm)) 
		{
			return false;
		}
		PersonEducationForm rhs = (PersonEducationForm) object;
		return new EqualsBuilder()
		.append(this.aac0d0, rhs.aac0d0)
		.append(this.aac001, rhs.aac001)
		.append(this.aac045, rhs.aac045)
		.append(this.aac0d2, rhs.aac0d2)
		.append(this.aac0d3, rhs.aac0d3)
		.append(this.aae030, rhs.aae030)
		.append(this.aac046, rhs.aac046)
		.append(this.aac0d5, rhs.aac0d5)
		.append(this.aac0d6, rhs.aac0d6)
		.append(this.atc011, rhs.atc011)
		.append(this.aac037, rhs.aac037)
		.append(this.acc01g, rhs.acc01g)
		.append(this.aac0d4, rhs.aac0d4)
		.append(this.atc01g, rhs.atc01g)
		.append(this.aac038, rhs.aac038)
		.append(this.aac039, rhs.aac039)
		.append(this.aac041, rhs.aac041)
		.append(this.aac042, rhs.aac042)
		.append(this.aac0d7, rhs.aac0d7)
		.append(this.aac043, rhs.aac043)
		.append(this.aac0d1, rhs.aac0d1)
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
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.aac0d0) 
		.append(this.aac001) 
		.append(this.aac045) 
		.append(this.aac0d2) 
		.append(this.aac0d3) 
		.append(this.aae030) 
		.append(this.aac046) 
		.append(this.aac0d5) 
		.append(this.aac0d6) 
		.append(this.atc011) 
		.append(this.aac037) 
		.append(this.acc01g) 
		.append(this.aac0d4) 
		.append(this.atc01g) 
		.append(this.aac038) 
		.append(this.aac039) 
		.append(this.aac041) 
		.append(this.aac042) 
		.append(this.aac0d7) 
		.append(this.aac043) 
		.append(this.aac0d1) 
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
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("aac0d0", this.aac0d0) 
		.append("aac001", this.aac001) 
		.append("aac045", this.aac045) 
		.append("aac0d2", this.aac0d2) 
		.append("aac0d3", this.aac0d3) 
		.append("aae030", this.aae030) 
		.append("aac046", this.aac046) 
		.append("aac0d5", this.aac0d5) 
		.append("aac0d6", this.aac0d6) 
		.append("atc011", this.atc011) 
		.append("aac037", this.aac037) 
		.append("acc01g", this.acc01g) 
		.append("aac0d4", this.aac0d4) 
		.append("atc01g", this.atc01g) 
		.append("aac038", this.aac038) 
		.append("aac039", this.aac039) 
		.append("aac041", this.aac041) 
		.append("aac042", this.aac042) 
		.append("aac0d7", this.aac0d7) 
		.append("aac043", this.aac043) 
		.append("aac0d1", this.aac0d1) 
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