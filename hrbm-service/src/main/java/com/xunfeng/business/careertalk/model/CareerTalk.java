package com.xunfeng.business.careertalk.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 宣讲会 Model对象
* @author:zhouhang
* @createDate 2015-09-22 18:18:47 
* @version V1.0   
*/
public class CareerTalk extends BaseModel
{
	private static final long serialVersionUID = 8526637086403433218L;
	// 主键
	protected Long  ctId;
	// 标题
	protected String  ctTitle;
	// 内容
	protected String  ctContent;
	// 状态
	protected Long  ctStatus;
	// 创建人
	protected Long  ctCreateby;
	// 创建时间
	protected java.util.Date  ctCreatetime;
	// 最终修改人
	protected Long  ctUpdateby;
	// 最终修改时间
	protected java.util.Date  ctUpdatetime;
	// 宣讲会教室时间区段表
	protected Long  ctbId;
	// 宣讲会开会具体结束时间
	protected java.util.Date  ctCareerEndtime;
	// 宣讲会开会具体开始时间
	protected java.util.Date  ctCareerStarttime;
	// 审批人
	protected Long  ctApproveUserid;
	// 审批时间
	protected java.util.Date  ctApproveTime;
	// 审批意见
	protected String  ctApproveOpinion;
	// 宣讲室
	protected Long  crId;

	protected String linkMan;
	protected String linkTel;
	protected String linkQq;

	public String getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	public String getLinkTel() {
		return linkTel;
	}

	public void setLinkTel(String linkTel) {
		this.linkTel = linkTel;
	}

	public String getLinkQq() {
		return linkQq;
	}

	public void setLinkQq(String linkQq) {
		this.linkQq = linkQq;
	}

	public void setCtId(Long ctId)
	{
		this.ctId = ctId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getCtId() 
	{
		return this.ctId;
	}
	public void setCtTitle(String ctTitle) 
	{
		this.ctTitle = ctTitle;
	}
	/**
	 * 返回 标题
	 * @return
	 */
	public String getCtTitle() 
	{
		return this.ctTitle;
	}
	public void setCtContent(String ctContent) 
	{
		this.ctContent = ctContent;
	}
	/**
	 * 返回 内容
	 * @return
	 */
	public String getCtContent() 
	{
		return this.ctContent;
	}
	public void setCtStatus(Long ctStatus) 
	{
		this.ctStatus = ctStatus;
	}
	/**
	 * 返回 状态
	 * @return
	 */
	public Long getCtStatus() 
	{
		return this.ctStatus;
	}
	public void setCtCreateby(Long ctCreateby) 
	{
		this.ctCreateby = ctCreateby;
	}
	/**
	 * 返回 创建人
	 * @return
	 */
	public Long getCtCreateby() 
	{
		return this.ctCreateby;
	}
	public void setCtCreatetime(java.util.Date ctCreatetime) 
	{
		this.ctCreatetime = ctCreatetime;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	public java.util.Date getCtCreatetime() 
	{
		return this.ctCreatetime;
	}
	public void setCtUpdateby(Long ctUpdateby) 
	{
		this.ctUpdateby = ctUpdateby;
	}
	/**
	 * 返回 最终修改人
	 * @return
	 */
	public Long getCtUpdateby() 
	{
		return this.ctUpdateby;
	}
	public void setCtUpdatetime(java.util.Date ctUpdatetime) 
	{
		this.ctUpdatetime = ctUpdatetime;
	}
	/**
	 * 返回 最终修改时间
	 * @return
	 */
	public java.util.Date getCtUpdatetime() 
	{
		return this.ctUpdatetime;
	}
	public void setCtbId(Long ctbId) 
	{
		this.ctbId = ctbId;
	}
	/**
	 * 返回 宣讲会教室时间区段表
	 * @return
	 */
	public Long getCtbId() 
	{
		return this.ctbId;
	}
	public void setCtCareerEndtime(java.util.Date ctCareerEndtime) 
	{
		this.ctCareerEndtime = ctCareerEndtime;
	}
	/**
	 * 返回 宣讲会开会具体结束时间
	 * @return
	 */
	public java.util.Date getCtCareerEndtime() 
	{
		return this.ctCareerEndtime;
	}
	public void setCtCareerStarttime(java.util.Date ctCareerStarttime) 
	{
		this.ctCareerStarttime = ctCareerStarttime;
	}
	/**
	 * 返回 宣讲会开会具体开始时间
	 * @return
	 */
	public java.util.Date getCtCareerStarttime() 
	{
		return this.ctCareerStarttime;
	}
	public void setCtApproveUserid(Long ctApproveUserid) 
	{
		this.ctApproveUserid = ctApproveUserid;
	}
	/**
	 * 返回 审批人
	 * @return
	 */
	public Long getCtApproveUserid() 
	{
		return this.ctApproveUserid;
	}
	public void setCtApproveTime(java.util.Date ctApproveTime) 
	{
		this.ctApproveTime = ctApproveTime;
	}
	/**
	 * 返回 审批时间
	 * @return
	 */
	public java.util.Date getCtApproveTime() 
	{
		return this.ctApproveTime;
	}
	public void setCtApproveOpinion(String ctApproveOpinion) 
	{
		this.ctApproveOpinion = ctApproveOpinion;
	}
	/**
	 * 返回 审批意见
	 * @return
	 */
	public String getCtApproveOpinion() 
	{
		return this.ctApproveOpinion;
	}
	public void setCrId(Long crId) 
	{
		this.crId = crId;
	}
	/**
	 * 返回 宣讲室
	 * @return
	 */
	public Long getCrId() 
	{
		return this.crId;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof CareerTalk))
		{
			return false;
		}
		CareerTalk rhs = (CareerTalk) object;
		return new EqualsBuilder()
		.append(this.ctId, rhs.ctId)
		.append(this.ctTitle, rhs.ctTitle)
		.append(this.ctContent, rhs.ctContent)
		.append(this.ctStatus, rhs.ctStatus)
		.append(this.ctCreateby, rhs.ctCreateby)
		.append(this.ctCreatetime, rhs.ctCreatetime)
		.append(this.ctUpdateby, rhs.ctUpdateby)
		.append(this.ctUpdatetime, rhs.ctUpdatetime)
		.append(this.ctbId, rhs.ctbId)
		.append(this.ctCareerEndtime, rhs.ctCareerEndtime)
		.append(this.ctCareerStarttime, rhs.ctCareerStarttime)
		.append(this.ctApproveUserid, rhs.ctApproveUserid)
		.append(this.ctApproveTime, rhs.ctApproveTime)
		.append(this.ctApproveOpinion, rhs.ctApproveOpinion)
		.append(this.crId, rhs.crId)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.ctId) 
		.append(this.ctTitle) 
		.append(this.ctContent) 
		.append(this.ctStatus) 
		.append(this.ctCreateby) 
		.append(this.ctCreatetime) 
		.append(this.ctUpdateby) 
		.append(this.ctUpdatetime) 
		.append(this.ctbId) 
		.append(this.ctCareerEndtime) 
		.append(this.ctCareerStarttime) 
		.append(this.ctApproveUserid) 
		.append(this.ctApproveTime) 
		.append(this.ctApproveOpinion) 
		.append(this.crId) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("ctId", this.ctId) 
		.append("ctTitle", this.ctTitle) 
		.append("ctContent", this.ctContent) 
		.append("ctStatus", this.ctStatus) 
		.append("ctCreateby", this.ctCreateby) 
		.append("ctCreatetime", this.ctCreatetime) 
		.append("ctUpdateby", this.ctUpdateby) 
		.append("ctUpdatetime", this.ctUpdatetime) 
		.append("ctbId", this.ctbId) 
		.append("ctCareerEndtime", this.ctCareerEndtime) 
		.append("ctCareerStarttime", this.ctCareerStarttime) 
		.append("ctApproveUserid", this.ctApproveUserid) 
		.append("ctApproveTime", this.ctApproveTime) 
		.append("ctApproveOpinion", this.ctApproveOpinion) 
		.append("crId", this.crId) 
		.toString();
	}
   
  

}