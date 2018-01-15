package com.xunfeng.sys.component.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 举办城市代码表 Model对象
* @author:wxl
* @createDate 2015-07-31 14:48:55 
* @version V1.0   
*/
public class City extends BaseModel
{
	// 序号
	protected Long  id;
	// 编码
	protected String  code;
	// 名称
	protected String  name;
	// 父类id
	protected Long  pid;
	// 排序字段
	protected Long  px;
	// 邮编
	protected String  yb;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setCode(String code) 
	{
		this.code = code;
	}
	/**
	 * 返回 编码
	 * @return
	 */
	public String getCode() 
	{
		return this.code;
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
	public void setPid(Long pid) 
	{
		this.pid = pid;
	}
	/**
	 * 返回 父类id
	 * @return
	 */
	public Long getPid() 
	{
		return this.pid;
	}
	public void setPx(Long px) 
	{
		this.px = px;
	}
	/**
	 * 返回 排序字段
	 * @return
	 */
	public Long getPx() 
	{
		return this.px;
	}
	public void setYb(String yb) 
	{
		this.yb = yb;
	}
	/**
	 * 返回 邮编
	 * @return
	 */
	public String getYb() 
	{
		return this.yb;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof City))
		{
			return false;
		}
		City rhs = (City) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.code, rhs.code)
		.append(this.name, rhs.name)
		.append(this.pid, rhs.pid)
		.append(this.px, rhs.px)
		.append(this.yb, rhs.yb)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.code) 
		.append(this.name) 
		.append(this.pid) 
		.append(this.px) 
		.append(this.yb) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("code", this.code) 
		.append("name", this.name) 
		.append("pid", this.pid) 
		.append("px", this.px) 
		.append("yb", this.yb) 
		.toString();
	}
   
  

}