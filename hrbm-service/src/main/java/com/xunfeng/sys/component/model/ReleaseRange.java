package com.xunfeng.sys.component.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 职位与信息方式对应关系表 Model对象
* @author:wanghan
* @createDate 2016-06-12 10:30:25 
* @version V1.0   
*/
public class ReleaseRange extends BaseModel
{
	// 序号seq_sys_xx_zw
	protected Long  id;
	// 岗位编号
	protected Long  acb210;
	// 信息发布方式字典表代码
	protected String  acb20q;
	// 类型1-岗位编号2-个人求职编号
	protected Long  lx;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 序号seq_sys_xx_zw
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setAcb210(Long acb210) 
	{
		this.acb210 = acb210;
	}
	/**
	 * 返回 岗位编号
	 * @return
	 */
	public Long getAcb210() 
	{
		return this.acb210;
	}
	public void setAcb20q(String acb20q) 
	{
		this.acb20q = acb20q;
	}
	/**
	 * 返回 信息发布方式字典表代码
	 * @return
	 */
	public String getAcb20q() 
	{
		return this.acb20q;
	}
	public void setLx(Long lx) 
	{
		this.lx = lx;
	}
	/**
	 * 返回 类型1-岗位编号2-个人求职编号
	 * @return
	 */
	public Long getLx() 
	{
		return this.lx;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ReleaseRange)) 
		{
			return false;
		}
		ReleaseRange rhs = (ReleaseRange) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.acb210, rhs.acb210)
		.append(this.acb20q, rhs.acb20q)
		.append(this.lx, rhs.lx)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.acb210) 
		.append(this.acb20q) 
		.append(this.lx) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("acb210", this.acb210) 
		.append("acb20q", this.acb20q) 
		.append("lx", this.lx) 
		.toString();
	}
   
  

}