package com.xunfeng.business.person.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 我的收藏表 Model对象
* @author:wangyanyan
* @createDate 2016-04-08 11:08:18 
* @version V1.0   
*/
public class MyCollect extends BaseModel
{
	// 主键
	protected Long  id;
	// 收藏人Id（登录表Id）
	protected Long  collectUserId;
	// 被收藏人Id（登录表Id）
	protected Long  beCollectUserId;
	// 收藏时间
	protected java.util.Date  collectDate;
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
	public void setCollectUserId(Long collectUserId) 
	{
		this.collectUserId = collectUserId;
	}
	/**
	 * 返回 收藏人Id（登录表Id）
	 * @return
	 */
	public Long getCollectUserId() 
	{
		return this.collectUserId;
	}
	public void setBeCollectUserId(Long beCollectUserId) 
	{
		this.beCollectUserId = beCollectUserId;
	}
	/**
	 * 返回 被收藏人Id（登录表Id）
	 * @return
	 */
	public Long getBeCollectUserId() 
	{
		return this.beCollectUserId;
	}
	public void setCollectDate(java.util.Date collectDate) 
	{
		this.collectDate = collectDate;
	}
	/**
	 * 返回 收藏时间
	 * @return
	 */
	public java.util.Date getCollectDate() 
	{
		return this.collectDate;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof MyCollect)) 
		{
			return false;
		}
		MyCollect rhs = (MyCollect) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.collectUserId, rhs.collectUserId)
		.append(this.beCollectUserId, rhs.beCollectUserId)
		.append(this.collectDate, rhs.collectDate)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.collectUserId) 
		.append(this.beCollectUserId) 
		.append(this.collectDate) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("collectUserId", this.collectUserId) 
		.append("beCollectUserId", this.beCollectUserId) 
		.append("collectDate", this.collectDate) 
		.toString();
	}
   
  

}