package com.xunfeng.business.corp.model;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 支付记录表 Model对象
* @author:wanghan
* @createDate 2016-04-13 18:02:30 
* @version V1.0   
*/
public class BookPay extends BaseModel
{
	// 支付记录编号 
	protected Long  cczz01;
	// 摊位预订编号
	protected Long  cczy01;
	// 单位编号
	protected Long  aab001;
	// 支付类型编号
	protected Long  cczl01;
	// 金额
	protected Float  cczy03;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办人
	protected String  aae019;
	// 经办机构代码
	protected String  aae017;
	// 经办机构
	protected String  aae020;
	// 经办日期
	protected java.util.Date  aae036=new Date();
	// 支付状态(1-未支付2-已支付3-已退订)
	protected String  cczz04;
	// 支付日期
	protected java.util.Date  cczz02;
	// 机构行政区划代码
	protected String  aae022;
	// 实收金额
	protected Float  cczz03;
	// 招聘编号
	protected Long  acb200;
	// 招聘信息的结束日期
	protected java.util.Date  aae031;
	// 是否续费0-否1-是
	protected String  cczz05;
	// 收费人代码
	protected String  bae011;
	// 收费人
	protected String  bae019;
	// 收费机构代码
	protected String  bae017;
	// 收费机构
	protected String  bae020;
	// 机构行政区划代码
	protected String  bae022;
	// 招聘套餐编号
	protected Long  catc01;
	public void setCczz01(Long cczz01) 
	{
		this.cczz01 = cczz01;
	}
	/**
	 * 返回 支付记录编号 
	 * @return
	 */
	public Long getCczz01() 
	{
		return this.cczz01;
	}
	public void setCczy01(Long cczy01) 
	{
		this.cczy01 = cczy01;
	}
	/**
	 * 返回 摊位预订编号
	 * @return
	 */
	public Long getCczy01() 
	{
		return this.cczy01;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setCczl01(Long cczl01) 
	{
		this.cczl01 = cczl01;
	}
	/**
	 * 返回 支付类型编号
	 * @return
	 */
	public Long getCczl01() 
	{
		return this.cczl01;
	}
	public void setCczy03(Float cczy03) 
	{
		this.cczy03 = cczy03;
	}
	/**
	 * 返回 金额
	 * @return
	 */
	public Float getCczy03() 
	{
		return this.cczy03;
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
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
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
	public void setCczz04(String cczz04) 
	{
		this.cczz04 = cczz04;
	}
	/**
	 * 返回 支付状态(1-未支付2-已支付3-已退订)
	 * @return
	 */
	public String getCczz04() 
	{
		return this.cczz04;
	}
	public void setCczz02(java.util.Date cczz02) 
	{
		this.cczz02 = cczz02;
	}
	/**
	 * 返回 支付日期
	 * @return
	 */
	public java.util.Date getCczz02() 
	{
		return this.cczz02;
	}
	public void setAae022(String aae022) 
	{
		this.aae022 = aae022;
	}
	/**
	 * 返回 机构行政区划代码
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
	}
	public void setCczz03(Float cczz03) 
	{
		this.cczz03 = cczz03;
	}
	/**
	 * 返回 实收金额
	 * @return
	 */
	public Float getCczz03() 
	{
		return this.cczz03;
	}
	public void setAcb200(Long acb200) 
	{
		this.acb200 = acb200;
	}
	/**
	 * 返回 招聘编号
	 * @return
	 */
	public Long getAcb200() 
	{
		return this.acb200;
	}
	public void setAae031(java.util.Date aae031) 
	{
		this.aae031 = aae031;
	}
	/**
	 * 返回 招聘信息的结束日期
	 * @return
	 */
	public java.util.Date getAae031() 
	{
		return this.aae031;
	}
	public void setCczz05(String cczz05) 
	{
		this.cczz05 = cczz05;
	}
	/**
	 * 返回 是否续费0-否1-是
	 * @return
	 */
	public String getCczz05() 
	{
		return this.cczz05;
	}
	public void setBae011(String bae011) 
	{
		this.bae011 = bae011;
	}
	/**
	 * 返回 收费人代码
	 * @return
	 */
	public String getBae011() 
	{
		return this.bae011;
	}
	public void setBae019(String bae019) 
	{
		this.bae019 = bae019;
	}
	/**
	 * 返回 收费人
	 * @return
	 */
	public String getBae019() 
	{
		return this.bae019;
	}
	public void setBae017(String bae017) 
	{
		this.bae017 = bae017;
	}
	/**
	 * 返回 收费机构代码
	 * @return
	 */
	public String getBae017() 
	{
		return this.bae017;
	}
	public void setBae020(String bae020) 
	{
		this.bae020 = bae020;
	}
	/**
	 * 返回 收费机构
	 * @return
	 */
	public String getBae020() 
	{
		return this.bae020;
	}
	public void setBae022(String bae022) 
	{
		this.bae022 = bae022;
	}
	/**
	 * 返回 机构行政区划代码
	 * @return
	 */
	public String getBae022() 
	{
		return this.bae022;
	}
	public void setCatc01(Long catc01) 
	{
		this.catc01 = catc01;
	}
	/**
	 * 返回 招聘套餐编号
	 * @return
	 */
	public Long getCatc01() 
	{
		return this.catc01;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof BookPay)) 
		{
			return false;
		}
		BookPay rhs = (BookPay) object;
		return new EqualsBuilder()
		.append(this.cczz01, rhs.cczz01)
		.append(this.cczy01, rhs.cczy01)
		.append(this.aab001, rhs.aab001)
		.append(this.cczl01, rhs.cczl01)
		.append(this.cczy03, rhs.cczy03)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae017, rhs.aae017)
		.append(this.aae020, rhs.aae020)
		.append(this.aae036, rhs.aae036)
		.append(this.cczz04, rhs.cczz04)
		.append(this.cczz02, rhs.cczz02)
		.append(this.aae022, rhs.aae022)
		.append(this.cczz03, rhs.cczz03)
		.append(this.acb200, rhs.acb200)
		.append(this.aae031, rhs.aae031)
		.append(this.cczz05, rhs.cczz05)
		.append(this.bae011, rhs.bae011)
		.append(this.bae019, rhs.bae019)
		.append(this.bae017, rhs.bae017)
		.append(this.bae020, rhs.bae020)
		.append(this.bae022, rhs.bae022)
		.append(this.catc01, rhs.catc01)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.cczz01) 
		.append(this.cczy01) 
		.append(this.aab001) 
		.append(this.cczl01) 
		.append(this.cczy03) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae017) 
		.append(this.aae020) 
		.append(this.aae036) 
		.append(this.cczz04) 
		.append(this.cczz02) 
		.append(this.aae022) 
		.append(this.cczz03) 
		.append(this.acb200) 
		.append(this.aae031) 
		.append(this.cczz05) 
		.append(this.bae011) 
		.append(this.bae019) 
		.append(this.bae017) 
		.append(this.bae020) 
		.append(this.bae022) 
		.append(this.catc01) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("cczz01", this.cczz01) 
		.append("cczy01", this.cczy01) 
		.append("aab001", this.aab001) 
		.append("cczl01", this.cczl01) 
		.append("cczy03", this.cczy03) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae017", this.aae017) 
		.append("aae020", this.aae020) 
		.append("aae036", this.aae036) 
		.append("cczz04", this.cczz04) 
		.append("cczz02", this.cczz02) 
		.append("aae022", this.aae022) 
		.append("cczz03", this.cczz03) 
		.append("acb200", this.acb200) 
		.append("aae031", this.aae031) 
		.append("cczz05", this.cczz05) 
		.append("bae011", this.bae011) 
		.append("bae019", this.bae019) 
		.append("bae017", this.bae017) 
		.append("bae020", this.bae020) 
		.append("bae022", this.bae022) 
		.append("catc01", this.catc01) 
		.toString();
	}
   
  

}