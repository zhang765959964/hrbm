package com.xunfeng.business.personagency.receive.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位人员关系表 Model对象
* @author:wanghan
* @createDate 2016-08-09 09:11:37 
* @version V1.0   
*/
public class CorpPerson extends BaseModel
{
	// 主键ID
	protected Long  id;
	// 单位ID
	protected Long  corpId;
	// 人员ID
	protected Long  personId;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键ID
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setCorpId(Long corpId) 
	{
		this.corpId = corpId;
	}
	/**
	 * 返回 单位ID
	 * @return
	 */
	public Long getCorpId() 
	{
		return this.corpId;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员ID
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof CorpPerson)) 
		{
			return false;
		}
		CorpPerson rhs = (CorpPerson) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.corpId, rhs.corpId)
		.append(this.personId, rhs.personId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.corpId) 
		.append(this.personId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("corpId", this.corpId) 
		.append("personId", this.personId) 
		.toString();
	}
   
  

}