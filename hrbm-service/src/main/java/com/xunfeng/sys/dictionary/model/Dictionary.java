package com.xunfeng.sys.dictionary.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 人员类别表 Model对象
* @author:wxl
* @createDate 2015-08-10 16:44:29 
* @version V1.0   
*/
public class Dictionary extends BaseModel
{
	// 编码
	protected String  code;
	// 名称
	protected String  name;
	// 范围
	protected String  rang;
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
	public void setRang(String rang) 
	{
		this.rang = rang;
	}
	/**
	 * 返回 范围
	 * @return
	 */
	public String getRang() 
	{
		return this.rang;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Dictionary))
		{
			return false;
		}
		Dictionary rhs = (Dictionary) object;
		return new EqualsBuilder()
		.append(this.code, rhs.code)
		.append(this.name, rhs.name)
		.append(this.rang, rhs.rang)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.code) 
		.append(this.name) 
		.append(this.rang) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return this.name;
	}
   
  

}