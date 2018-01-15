package com.xunfeng.business.advert.model;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告删除记录表 Model对象
* @author:
* @createDate 2016-08-03 10:35:28 
* @version V1.0   
*/
public class AdDelRecord extends BaseModel
{
	// 记录id
	protected Long  id;
	// 广告类编号
	protected Long  caac01;
	// 广告主键
	protected Long  adid;
	// 企业主键
	protected Long  aab001;
	// 上传图片或Flash地址
	protected String  caae03;
	// 指向地址
	protected String  caae04;
	// 企业主键
	protected Long  jobid;
	// 点击次数
	protected Long  caad14;
	// 经办时间
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 删除时间
	protected java.util.Date  deltime;
	// 删除人
	protected String  deluser;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 记录id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
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
	public void setAdid(Long adid) 
	{
		this.adid = adid;
	}
	/**
	 * 返回 广告主键
	 * @return
	 */
	public Long getAdid() 
	{
		return this.adid;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 企业主键
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
	public void setJobid(Long jobid) 
	{
		this.jobid = jobid;
	}
	/**
	 * 返回 企业主键
	 * @return
	 */
	public Long getJobid() 
	{
		return this.jobid;
	}
	public void setCaad14(Long caad14) 
	{
		this.caad14 = caad14;
	}
	/**
	 * 返回 点击次数
	 * @return
	 */
	public Long getCaad14() 
	{
		return this.caad14;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办时间
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
	public void setDeltime(java.util.Date deltime) 
	{
		this.deltime = deltime;
	}
	/**
	 * 返回 删除时间
	 * @return
	 */
	public java.util.Date getDeltime() 
	{
		return this.deltime;
	}
	public void setDeluser(String deluser) 
	{
		this.deluser = deluser;
	}
	/**
	 * 返回 删除人
	 * @return
	 */
	public String getDeluser() 
	{
		return this.deluser;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof AdDelRecord)) 
		{
			return false;
		}
		AdDelRecord rhs = (AdDelRecord) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.caac01, rhs.caac01)
		.append(this.adid, rhs.adid)
		.append(this.aab001, rhs.aab001)
		.append(this.caae03, rhs.caae03)
		.append(this.caae04, rhs.caae04)
		.append(this.jobid, rhs.jobid)
		.append(this.caad14, rhs.caad14)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.deltime, rhs.deltime)
		.append(this.deluser, rhs.deluser)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.caac01) 
		.append(this.adid) 
		.append(this.aab001) 
		.append(this.caae03) 
		.append(this.caae04) 
		.append(this.jobid) 
		.append(this.caad14) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.deltime) 
		.append(this.deluser) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("caac01", this.caac01) 
		.append("adid", this.adid) 
		.append("aab001", this.aab001) 
		.append("caae03", this.caae03) 
		.append("caae04", this.caae04) 
		.append("jobid", this.jobid) 
		.append("caad14", this.caad14) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("deltime", this.deltime) 
		.append("deluser", this.deluser) 
		.toString();
	}
   
  

}