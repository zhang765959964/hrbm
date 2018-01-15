package com.xunfeng.business.person.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 标签明细表 Model对象
* @author:wanghan
* @createDate 2016-04-08 15:36:50 
* @version V1.0   
*/
public class PersonLabel extends BaseModel
{
	// 主键id
	protected Long  id;
	// 用户编号(非会员编号)
	protected Long  userId;
	// 标签编码
	protected String  labelCode;
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
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	// 标签名称
	protected String  labelName;
	// 公司，1 个人，2
	protected String  labelType;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}
	/**
	 * 返回 用户编号(非会员编号)
	 * @return
	 */
	public Long getUserId() 
	{
		return this.userId;
	}
	public void setLabelCode(String labelCode) 
	{
		this.labelCode = labelCode;
	}
	/**
	 * 返回 标签编码
	 * @return
	 */
	public String getLabelCode() 
	{
		return this.labelCode;
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
	public void setLabelName(String labelName) 
	{
		this.labelName = labelName;
	}
	/**
	 * 返回 标签名称
	 * @return
	 */
	public String getLabelName() 
	{
		return this.labelName;
	}
	public void setLabelType(String labelType) 
	{
		this.labelType = labelType;
	}
	/**
	 * 返回 公司，1 个人，2
	 * @return
	 */
	public String getLabelType() 
	{
		return this.labelType;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonLabel)) 
		{
			return false;
		}
		PersonLabel rhs = (PersonLabel) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.userId, rhs.userId)
		.append(this.labelCode, rhs.labelCode)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.cczy06, rhs.cczy06)
		.append(this.labelName, rhs.labelName)
		.append(this.labelType, rhs.labelType)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.userId) 
		.append(this.labelCode) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.ccpr08) 
		.append(this.cczy06) 
		.append(this.labelName) 
		.append(this.labelType) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("userId", this.userId) 
		.append("labelCode", this.labelCode) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("ccpr08", this.ccpr08) 
		.append("cczy06", this.cczy06) 
		.append("labelName", this.labelName) 
		.append("labelType", this.labelType) 
		.toString();
	}
   
  

}