package com.xunfeng.business.personagency.subsidy.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_SOCIAL_SUBSIDY_BATCH Model对象
* @author:wanghan
* @createDate 2016-07-15 14:28:38 
* @version V1.0   
*/
public class SocialSubsidyBatch extends BaseModel
{
	// 主键
	protected Long  id;
	// 社保补贴ID
	protected Long  subsidyId;
	// 批次ID
	protected Long  batchId;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setSubsidyId(Long subsidyId) 
	{
		this.subsidyId = subsidyId;
	}
	/**
	 * 返回 社保补贴ID
	 * @return
	 */
	public Long getSubsidyId() 
	{
		return this.subsidyId;
	}
	public void setBatchId(Long batchId) 
	{
		this.batchId = batchId;
	}
	/**
	 * 返回 批次ID
	 * @return
	 */
	public Long getBatchId() 
	{
		return this.batchId;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SocialSubsidyBatch)) 
		{
			return false;
		}
		SocialSubsidyBatch rhs = (SocialSubsidyBatch) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.subsidyId, rhs.subsidyId)
		.append(this.batchId, rhs.batchId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.subsidyId) 
		.append(this.batchId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("subsidyId", this.subsidyId) 
		.append("batchId", this.batchId) 
		.toString();
	}
   
  

}