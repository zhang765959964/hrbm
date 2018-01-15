package com.xunfeng.business.jobfair.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.jobfair.model.JobFairSite;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 场地表 Form对象
* @author:wanghan
* @createDate 2015-09-12 11:18:57 
* @version V1.0   
*/
public class JobFairSiteForm extends BaseForm<JobFairSite>
{
	// 场地编号
	protected Long  acd250;
	// 职介机构编号
	protected Long  acd200;
	// 场地权属
	protected String  acd251;
	// 场地代码
	protected String  acd252;
	// 场地名称
	protected String  acd253;
	// 摊位面积
	protected Float  acd257;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 经办机构代码
	protected String  aae017;
	// 经办机构行政区划
	protected String  aae022;
	// 经办日期
	protected java.util.Date  aae036;
	// 摊位数
	protected Long  cczc001;
	// 是否临时场地(0-临时1-固定)
	protected Long  cczc003;
	// 场地地址
	protected String  cczc004;
	// 乘车路线
	protected String  cczc005;
	// 联系电话
	protected String  cczc006;

	public void setAcd250(Long acd250) 
	{
		this.acd250 = acd250;
	}
	/**
	 * 返回 场地编号
	 * @return
	 */
	public Long getAcd250() 
	{
		return this.acd250;
	}
	public void setAcd200(Long acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 职介机构编号
	 * @return
	 */
	public Long getAcd200() 
	{
		return this.acd200;
	}
	public void setAcd251(String acd251) 
	{
		this.acd251 = acd251;
	}
	/**
	 * 返回 场地权属
	 * @return
	 */
	public String getAcd251() 
	{
		return this.acd251;
	}
	public void setAcd252(String acd252) 
	{
		this.acd252 = acd252;
	}
	/**
	 * 返回 场地代码
	 * @return
	 */
	public String getAcd252() 
	{
		return this.acd252;
	}
	public void setAcd253(String acd253) 
	{
		this.acd253 = acd253;
	}
	/**
	 * 返回 场地名称
	 * @return
	 */
	public String getAcd253() 
	{
		return this.acd253;
	}
	public void setAcd257(Float acd257) 
	{
		this.acd257 = acd257;
	}
	/**
	 * 返回 摊位面积
	 * @return
	 */
	public Float getAcd257() 
	{
		return this.acd257;
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
	public void setAae022(String aae022) 
	{
		this.aae022 = aae022;
	}
	/**
	 * 返回 经办机构行政区划
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

	public void setCczc003(Long cczc003) 
	{
		this.cczc003 = cczc003;
	}
	/**
	 * 返回 是否临时场地(0-临时1-固定)
	 * @return
	 */
	public Long getCczc003() 
	{
		return this.cczc003;
	}
	public void setCczc004(String cczc004) 
	{
		this.cczc004 = cczc004;
	}
	/**
	 * 返回 场地地址
	 * @return
	 */
	public String getCczc004() 
	{
		return this.cczc004;
	}
	public void setCczc005(String cczc005) 
	{
		this.cczc005 = cczc005;
	}
	/**
	 * 返回 乘车路线
	 * @return
	 */
	public String getCczc005() 
	{
		return this.cczc005;
	}
	public void setCczc006(String cczc006) 
	{
		this.cczc006 = cczc006;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getCczc006() 
	{
		return this.cczc006;
	}

	public Long getCczc001() {
		return cczc001;
	}

	public void setCczc001(Long cczc001) {
		this.cczc001 = cczc001;
	}

	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof JobFairSiteForm)) 
		{
			return false;
		}
		JobFairSiteForm rhs = (JobFairSiteForm) object;
		return new EqualsBuilder()
		.append(this.acd250, rhs.acd250)
		.append(this.acd200, rhs.acd200)
		.append(this.acd251, rhs.acd251)
		.append(this.acd252, rhs.acd252)
		.append(this.acd253, rhs.acd253)
		.append(this.acd257, rhs.acd257)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae017, rhs.aae017)
		.append(this.aae022, rhs.aae022)
		.append(this.aae036, rhs.aae036)

		.append(this.cczc003, rhs.cczc003)
		.append(this.cczc004, rhs.cczc004)
		.append(this.cczc005, rhs.cczc005)
		.append(this.cczc006, rhs.cczc006)

		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acd250) 
		.append(this.acd200) 
		.append(this.acd251) 
		.append(this.acd252) 
		.append(this.acd253) 
		.append(this.acd257) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae017) 
		.append(this.aae022) 
		.append(this.aae036) 

		.append(this.cczc003) 
		.append(this.cczc004) 
		.append(this.cczc005) 
		.append(this.cczc006) 

		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acd250", this.acd250) 
		.append("acd200", this.acd200) 
		.append("acd251", this.acd251) 
		.append("acd252", this.acd252) 
		.append("acd253", this.acd253) 
		.append("acd257", this.acd257) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae017", this.aae017) 
		.append("aae022", this.aae022) 
		.append("aae036", this.aae036)
		.append("cczc003", this.cczc003) 
		.append("cczc004", this.cczc004) 
		.append("cczc005", this.cczc005) 
		.append("cczc006", this.cczc006) 

		.toString();
	}
   
  

}