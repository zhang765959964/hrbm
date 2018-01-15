package com.xunfeng.business.cms.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 栏目板块管理 比如快速栏目中的前十个信息名称 Model对象
* @author:wanghan
* @createDate 2016-03-22 16:46:24 
* @version V1.0   
*/
public class CmsBannerManage extends BaseModel
{
	// 主键ID
	protected Long  id;
	// 信息ID
	protected Long  cmsid;
	// 排序
	protected Long  ordernum;
	// 所有类别 fc
	protected String  indent;
	// 新闻名称
	protected String  cmsname;
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
	public void setCmsid(Long cmsid) 
	{
		this.cmsid = cmsid;
	}
	/**
	 * 返回 信息ID
	 * @return
	 */
	public Long getCmsid() 
	{
		return this.cmsid;
	}
	public void setOrdernum(Long ordernum) 
	{
		this.ordernum = ordernum;
	}
	/**
	 * 返回 排序
	 * @return
	 */
	public Long getOrdernum() 
	{
		return this.ordernum;
	}
	public void setIndent(String indent) 
	{
		this.indent = indent;
	}
	/**
	 * 返回 所有类别 fc
	 * @return
	 */
	public String getIndent() 
	{
		return this.indent;
	}
	public void setCmsname(String cmsname) 
	{
		this.cmsname = cmsname;
	}
	/**
	 * 返回 新闻名称
	 * @return
	 */
	public String getCmsname() 
	{
		return this.cmsname;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof CmsBannerManage)) 
		{
			return false;
		}
		CmsBannerManage rhs = (CmsBannerManage) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.cmsid, rhs.cmsid)
		.append(this.ordernum, rhs.ordernum)
		.append(this.indent, rhs.indent)
		.append(this.cmsname, rhs.cmsname)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.cmsid) 
		.append(this.ordernum) 
		.append(this.indent) 
		.append(this.cmsname) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("cmsid", this.cmsid) 
		.append("ordernum", this.ordernum) 
		.append("indent", this.indent) 
		.append("cmsname", this.cmsname) 
		.toString();
	}
   
  

}