package com.xunfeng.business.advert.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位放置表 Model对象
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public class AdCompany extends BaseModel
{
	// 广告位放置表自动编号
	protected Long  caae01;
	// 广告类编号
	protected Long  caac01;
	// 广告描述

	protected String  caae02;
	// 单位基本信息编号
	protected Long  aab001;
	// 上传图片或Flash地址

	protected String  caae03;
	// 指向地址

	protected String  caae04;
	// 广告位宽度

	protected Long  caae05;
	// 广告位高度

	protected Long  caae06;
	// 扣除企业人才币数量

	protected Long  caae07;
	// 开始时间

	protected java.util.Date  caae08;
	// 结束时间

	protected java.util.Date  caae09;
	// 状态1正常显示2隐藏 4结束

	protected Long  caae10;
	// 类型1文字2图片3flash

	protected Long  caae11;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 经办机构区划
	protected String  aae022;
	// 排序
	protected Long  caae12;
	// 点击次数
	protected Long  caad14;
	// 职位编号
	protected Long  jobid;
	// 数据来源
	protected String cczy06;
	
	public void setCaae01(Long caae01) 
	{
		this.caae01 = caae01;
	}
	/**
	 * 返回 广告位放置表自动编号
	 * @return
	 */
	public Long getCaae01() 
	{
		return this.caae01;
	}
	public void setCaac01(Long caac01) 
	{
		this.caac01 = caac01;
	}
	/**
	 * 返回 广告类编号
	 * @return
	 */
	public Long getCaac01() 
	{
		return this.caac01;
	}
	public void setCaae02(String caae02) 
	{
		this.caae02 = caae02;
	}
	/**
	 * 返回 广告描述

	 * @return
	 */
	public String getCaae02() 
	{
		return this.caae02;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位基本信息编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setCaae03(String caae03) 
	{
		this.caae03 = caae03;
	}
	/**
	 * 返回 上传图片或Flash地址

	 * @return
	 */
	public String getCaae03() 
	{
		return this.caae03;
	}
	public void setCaae04(String caae04) 
	{
		this.caae04 = caae04;
	}
	/**
	 * 返回 指向地址

	 * @return
	 */
	public String getCaae04() 
	{
		return this.caae04;
	}
	public void setCaae05(Long caae05) 
	{
		this.caae05 = caae05;
	}
	/**
	 * 返回 广告位宽度

	 * @return
	 */
	public Long getCaae05() 
	{
		return this.caae05;
	}
	public void setCaae06(Long caae06) 
	{
		this.caae06 = caae06;
	}
	/**
	 * 返回 广告位高度

	 * @return
	 */
	public Long getCaae06() 
	{
		return this.caae06;
	}
	public void setCaae07(Long caae07) 
	{
		this.caae07 = caae07;
	}
	/**
	 * 返回 扣除企业人才币数量

	 * @return
	 */
	public Long getCaae07() 
	{
		return this.caae07;
	}
	public void setCaae08(java.util.Date caae08) 
	{
		this.caae08 = caae08;
	}
	/**
	 * 返回 开始时间

	 * @return
	 */
	public java.util.Date getCaae08() 
	{
		return this.caae08;
	}
	public void setCaae09(java.util.Date caae09) 
	{
		this.caae09 = caae09;
	}
	/**
	 * 返回 结束时间

	 * @return
	 */
	public java.util.Date getCaae09() 
	{
		return this.caae09;
	}
	public void setCaae10(Long caae10) 
	{
		this.caae10 = caae10;
	}
	/**
	 * 返回 状态1正常显示2隐藏 4结束

	 * @return
	 */
	public Long getCaae10() 
	{
		return this.caae10;
	}
	public void setCaae11(Long caae11) 
	{
		this.caae11 = caae11;
	}
	/**
	 * 返回 类型1文字2图片3flash

	 * @return
	 */
	public Long getCaae11() 
	{
		return this.caae11;
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
	 * 返回 经办机构
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
	 * 返回 经办机构区划
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
	}
	public void setCaae12(Long caae12) 
	{
		this.caae12 = caae12;
	}
	/**
	 * 返回 排序
	 * @return
	 */
	public Long getCaae12() 
	{
		return this.caae12;
	}
	public void setJobid(Long jobid) 
	{
		this.jobid = jobid;
	}
	/**
	 * 返回 职位编号
	 * @return
	 */
	public Long getJobid() 
	{
		return this.jobid;
	}
	/**
	 * 设置 数据来源
	 * @return
	 */
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

   	public Long getCaad14() {
		return caad14;
	}
	public void setCaad14(Long caad14) {
		this.caad14 = caad14;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof AdCompany)) 
		{
			return false;
		}
		AdCompany rhs = (AdCompany) object;
		return new EqualsBuilder()
		.append(this.caae01, rhs.caae01)
		.append(this.caac01, rhs.caac01)
		.append(this.caae02, rhs.caae02)
		.append(this.aab001, rhs.aab001)
		.append(this.caae03, rhs.caae03)
		.append(this.caae04, rhs.caae04)
		.append(this.caae05, rhs.caae05)
		.append(this.caae06, rhs.caae06)
		.append(this.caae07, rhs.caae07)
		.append(this.caae08, rhs.caae08)
		.append(this.caae09, rhs.caae09)
		.append(this.caae10, rhs.caae10)
		.append(this.caae11, rhs.caae11)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae022, rhs.aae022)
		.append(this.caae12, rhs.caae12)
		.append(this.jobid, rhs.jobid)
		.append(this.cczy06, rhs.cczy06)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.caae01) 
		.append(this.caac01) 
		.append(this.caae02) 
		.append(this.aab001) 
		.append(this.caae03) 
		.append(this.caae04) 
		.append(this.caae05) 
		.append(this.caae06) 
		.append(this.caae07) 
		.append(this.caae08) 
		.append(this.caae09) 
		.append(this.caae10) 
		.append(this.caae11) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae022) 
		.append(this.caae12) 
		.append(this.jobid) 
		.append(this.cczy06) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("caae01", this.caae01) 
		.append("caac01", this.caac01) 
		.append("caae02", this.caae02) 
		.append("aab001", this.aab001) 
		.append("caae03", this.caae03) 
		.append("caae04", this.caae04) 
		.append("caae05", this.caae05) 
		.append("caae06", this.caae06) 
		.append("caae07", this.caae07) 
		.append("caae08", this.caae08) 
		.append("caae09", this.caae09) 
		.append("caae10", this.caae10) 
		.append("caae11", this.caae11) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae022", this.aae022) 
		.append("caae12", this.caae12) 
		.append("jobid", this.jobid) 
		.append("cczy06", this.cczy06) 
		.toString();
	}
   
}