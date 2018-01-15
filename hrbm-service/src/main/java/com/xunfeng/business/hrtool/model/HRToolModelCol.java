package com.xunfeng.business.hrtool.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工具箱模板栏目表 Model对象
* @author:wanghan
* @createDate 2016-03-09 10:48:16 
* @version V1.0   
*/
public class HRToolModelCol extends BaseModel
{
	// 主键
	protected Long  id;
	// 名称
	protected String  name;
	// 代码
	protected String  code;
	// 排序
	protected Long  sortNum;
	// 描述
	protected String  description;
	// 创建时间
	protected java.util.Date  createDate;
	// 创建人
	protected Long  createUserId;
	// 最后修改时间
	protected java.util.Date  updateDate;
	// 最后修改人
	protected Long  updateUserId;
	// 父Id
	protected Long  parentColId;
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
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * 返回 名称
	 * @return
	 */
	public String getName() 
	{
		return this.name;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	/**
	 * 返回 代码
	 * @return
	 */
	public String getCode() 
	{
		return this.code;
	}
	public void setSortNum(Long sortNum) 
	{
		this.sortNum = sortNum;
	}
	/**
	 * 返回 排序
	 * @return
	 */
	public Long getSortNum() 
	{
		return this.sortNum;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	/**
	 * 返回 描述
	 * @return
	 */
	public String getDescription() 
	{
		return this.description;
	}
	public void setCreateDate(java.util.Date createDate) 
	{
		this.createDate = createDate;
	}
	/**
	 * 返回 创建时间
	 * @return
	 */
	public java.util.Date getCreateDate() 
	{
		return this.createDate;
	}
	public void setCreateUserId(Long createUserId) 
	{
		this.createUserId = createUserId;
	}
	/**
	 * 返回 创建人
	 * @return
	 */
	public Long getCreateUserId() 
	{
		return this.createUserId;
	}
	public void setUpdateDate(java.util.Date updateDate) 
	{
		this.updateDate = updateDate;
	}
	/**
	 * 返回 最后修改时间
	 * @return
	 */
	public java.util.Date getUpdateDate() 
	{
		return this.updateDate;
	}
	public void setUpdateUserId(Long updateUserId) 
	{
		this.updateUserId = updateUserId;
	}
	/**
	 * 返回 最后修改人
	 * @return
	 */
	public Long getUpdateUserId() 
	{
		return this.updateUserId;
	}
	public void setParentColId(Long parentColId) 
	{
		this.parentColId = parentColId;
	}
	/**
	 * 返回 父Id
	 * @return
	 */
	public Long getParentColId() 
	{
		return this.parentColId;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof HRToolModelCol)) 
		{
			return false;
		}
		HRToolModelCol rhs = (HRToolModelCol) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.name, rhs.name)
		.append(this.code, rhs.code)
		.append(this.sortNum, rhs.sortNum)
		.append(this.description, rhs.description)
		.append(this.createDate, rhs.createDate)
		.append(this.createUserId, rhs.createUserId)
		.append(this.updateDate, rhs.updateDate)
		.append(this.updateUserId, rhs.updateUserId)
		.append(this.parentColId, rhs.parentColId)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.name) 
		.append(this.code) 
		.append(this.sortNum) 
		.append(this.description) 
		.append(this.createDate) 
		.append(this.createUserId) 
		.append(this.updateDate) 
		.append(this.updateUserId) 
		.append(this.parentColId) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("name", this.name) 
		.append("code", this.code) 
		.append("sortNum", this.sortNum) 
		.append("description", this.description) 
		.append("createDate", this.createDate) 
		.append("createUserId", this.createUserId) 
		.append("updateDate", this.updateDate) 
		.append("updateUserId", this.updateUserId) 
		.append("parentColId", this.parentColId) 
		.toString();
	}
   
  

}