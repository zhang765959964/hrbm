package com.xunfeng.business.personagency.params.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.params.model.ParamsAgentCode;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 劳动代理代码维护 Form对象
* @author:wanghan
* @createDate 2016-09-07 10:24:17 
* @version V1.0   
*/
public class ParamsAgentCodeForm extends BaseForm<ParamsAgentCode>
{
	// 主键
	protected Long  pkId;
	// 代码类别
	protected String  fdTypeCode;
	// 类别名称
	protected String  fdTypeName;
	// 代码名称
	protected String  fdCodeName;
	// 代码值
	protected String  fdCodeValue;
	// 拼音码
	protected String  fdPinyinCode;
	public void setPkId(Long pkId) 
	{
		this.pkId = pkId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getPkId() 
	{
		return this.pkId;
	}
	public void setFdTypeCode(String fdTypeCode) 
	{
		this.fdTypeCode = fdTypeCode;
	}
	/**
	 * 返回 代码类别
	 * @return
	 */
	public String getFdTypeCode() 
	{
		return this.fdTypeCode;
	}
	public void setFdTypeName(String fdTypeName) 
	{
		this.fdTypeName = fdTypeName;
	}
	/**
	 * 返回 类别名称
	 * @return
	 */
	public String getFdTypeName() 
	{
		return this.fdTypeName;
	}
	public void setFdCodeName(String fdCodeName) 
	{
		this.fdCodeName = fdCodeName;
	}
	/**
	 * 返回 代码名称
	 * @return
	 */
	public String getFdCodeName() 
	{
		return this.fdCodeName;
	}
	public void setFdCodeValue(String fdCodeValue) 
	{
		this.fdCodeValue = fdCodeValue;
	}
	/**
	 * 返回 代码值
	 * @return
	 */
	public String getFdCodeValue() 
	{
		return this.fdCodeValue;
	}
	public void setFdPinyinCode(String fdPinyinCode) 
	{
		this.fdPinyinCode = fdPinyinCode;
	}
	/**
	 * 返回 拼音码
	 * @return
	 */
	public String getFdPinyinCode() 
	{
		return this.fdPinyinCode;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ParamsAgentCodeForm)) 
		{
			return false;
		}
		ParamsAgentCodeForm rhs = (ParamsAgentCodeForm) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fdTypeCode, rhs.fdTypeCode)
		.append(this.fdTypeName, rhs.fdTypeName)
		.append(this.fdCodeName, rhs.fdCodeName)
		.append(this.fdCodeValue, rhs.fdCodeValue)
		.append(this.fdPinyinCode, rhs.fdPinyinCode)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fdTypeCode) 
		.append(this.fdTypeName) 
		.append(this.fdCodeName) 
		.append(this.fdCodeValue) 
		.append(this.fdPinyinCode) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fdTypeCode", this.fdTypeCode) 
		.append("fdTypeName", this.fdTypeName) 
		.append("fdCodeName", this.fdCodeName) 
		.append("fdCodeValue", this.fdCodeValue) 
		.append("fdPinyinCode", this.fdPinyinCode) 
		.toString();
	}
   
  

}