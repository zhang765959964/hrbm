package com.xunfeng.business.personagency.retired.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休序号历史记录表 Model对象
* @author:zhangfan
* @createDate 2016-11-29 17:11:56 
* @version V1.0   
*/
public class RetiredXh extends BaseModel
{
	// 主键id
	protected Long  id;
	// 类型
	protected String  type;
	// 序号
	protected String  xh;
	// 退休个人编码
	protected String  bm;
	// 标识状态
	protected Long  flag;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	/**
	 * 返回 类型
	 * @return
	 */
	public String getType() 
	{
		return this.type;
	}
	public void setXh(String xh) 
	{
		this.xh = xh;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public String getXh() 
	{
		return this.xh;
	}
	public void setBm(String bm) 
	{
		this.bm = bm;
	}
	/**
	 * 返回 退休个人编码
	 * @return
	 */
	public String getBm() 
	{
		return this.bm;
	}
	public void setFlag(Long flag) 
	{
		this.flag = flag;
	}
	/**
	 * 返回 标识状态
	 * @return
	 */
	public Long getFlag() 
	{
		return this.flag;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof RetiredXh)) 
		{
			return false;
		}
		RetiredXh rhs = (RetiredXh) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.type, rhs.type)
		.append(this.xh, rhs.xh)
		.append(this.bm, rhs.bm)
		.append(this.flag, rhs.flag)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.type) 
		.append(this.xh) 
		.append(this.bm) 
		.append(this.flag) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("type", this.type) 
		.append("xh", this.xh) 
		.append("bm", this.bm) 
		.append("flag", this.flag) 
		.toString();
	}
   
  

}