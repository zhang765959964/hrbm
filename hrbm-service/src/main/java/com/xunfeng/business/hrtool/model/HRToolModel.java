package com.xunfeng.business.hrtool.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: hr工具箱模板表 Model对象
* @author:wanghan
* @createDate 2016-03-11 09:14:46 
* @version V1.0   
*/
public class HRToolModel extends BaseModel
{
	// 主键
	protected Long  id;
	// 名称
	protected String  name;
	// 代码
	protected String  code;
	// 模版栏目Id
	protected Long  colId;
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
	// 模板文件路径
	protected String  filePath;
	// 下载次数
	protected Long  downNum=0L;
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
	public void setColId(Long colId) 
	{
		this.colId = colId;
	}
	/**
	 * 返回 模版栏目Id
	 * @return
	 */
	public Long getColId() 
	{
		return this.colId;
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
	public void setFilePath(String filePath) 
	{
		this.filePath = filePath;
	}
	/**
	 * 返回 模板文件路径
	 * @return
	 */
	public String getFilePath() 
	{
		return this.filePath;
	}
	public void setDownNum(Long downNum) 
	{
		this.downNum = downNum;
	}
	/**
	 * 返回 下载次数
	 * @return
	 */
	public Long getDownNum() 
	{
		return this.downNum;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof HRToolModel)) 
		{
			return false;
		}
		HRToolModel rhs = (HRToolModel) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.name, rhs.name)
		.append(this.code, rhs.code)
		.append(this.colId, rhs.colId)
		.append(this.sortNum, rhs.sortNum)
		.append(this.description, rhs.description)
		.append(this.createDate, rhs.createDate)
		.append(this.createUserId, rhs.createUserId)
		.append(this.updateDate, rhs.updateDate)
		.append(this.updateUserId, rhs.updateUserId)
		.append(this.filePath, rhs.filePath)
		.append(this.downNum, rhs.downNum)
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
		.append(this.colId) 
		.append(this.sortNum) 
		.append(this.description) 
		.append(this.createDate) 
		.append(this.createUserId) 
		.append(this.updateDate) 
		.append(this.updateUserId) 
		.append(this.filePath) 
		.append(this.downNum) 
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
		.append("colId", this.colId) 
		.append("sortNum", this.sortNum) 
		.append("description", this.description) 
		.append("createDate", this.createDate) 
		.append("createUserId", this.createUserId) 
		.append("updateDate", this.updateDate) 
		.append("updateUserId", this.updateUserId) 
		.append("filePath", this.filePath) 
		.append("downNum", this.downNum) 
		.toString();
	}
   
  

}