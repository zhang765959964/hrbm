package com.xunfeng.sys.notice.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 我的关注表 Model对象
* @author:wanghan
* @createDate 2015-12-13 10:21:33 
* @version V1.0   
*/
public class Notice extends BaseModel
{
	// 主键
	protected Long  id;
	// 关注人Id（登录表Id）
	protected Long  noticeUserId;
	// 被关注人Id（登录表Id）
	protected Long  beNoticeUserId;
	// 关注时间
	protected java.util.Date  noticeDate;
	// 关注人类型 1用户 2企业
	protected Long  noticeUserType;
	// 被关注人类型 1用户 2企业
	protected Long  beNoticeUserType;
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
	public void setNoticeUserId(Long noticeUserId) 
	{
		this.noticeUserId = noticeUserId;
	}
	/**
	 * 返回 关注人Id（登录表Id）
	 * @return
	 */
	public Long getNoticeUserId() 
	{
		return this.noticeUserId;
	}
	public void setBeNoticeUserId(Long beNoticeUserId) 
	{
		this.beNoticeUserId = beNoticeUserId;
	}
	/**
	 * 返回 被关注人Id（登录表Id）
	 * @return
	 */
	public Long getBeNoticeUserId() 
	{
		return this.beNoticeUserId;
	}
	public void setNoticeDate(java.util.Date noticeDate) 
	{
		this.noticeDate = noticeDate;
	}
	/**
	 * 返回 关注时间
	 * @return
	 */
	public java.util.Date getNoticeDate() 
	{
		return this.noticeDate;
	}
	public void setNoticeUserType(Long noticeUserType) 
	{
		this.noticeUserType = noticeUserType;
	}
	/**
	 * 返回 关注人类型 1用户 2企业
	 * @return
	 */
	public Long getNoticeUserType() 
	{
		return this.noticeUserType;
	}
	public void setBeNoticeUserType(Long beNoticeUserType) 
	{
		this.beNoticeUserType = beNoticeUserType;
	}
	/**
	 * 返回 被关注人类型 1用户 2企业
	 * @return
	 */
	public Long getBeNoticeUserType() 
	{
		return this.beNoticeUserType;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Notice)) 
		{
			return false;
		}
		Notice rhs = (Notice) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.noticeUserId, rhs.noticeUserId)
		.append(this.beNoticeUserId, rhs.beNoticeUserId)
		.append(this.noticeDate, rhs.noticeDate)
		.append(this.noticeUserType, rhs.noticeUserType)
		.append(this.beNoticeUserType, rhs.beNoticeUserType)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.noticeUserId) 
		.append(this.beNoticeUserId) 
		.append(this.noticeDate) 
		.append(this.noticeUserType) 
		.append(this.beNoticeUserType) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("noticeUserId", this.noticeUserId) 
		.append("beNoticeUserId", this.beNoticeUserId) 
		.append("noticeDate", this.noticeDate) 
		.append("noticeUserType", this.noticeUserType) 
		.append("beNoticeUserType", this.beNoticeUserType) 
		.toString();
	}
   
  

}