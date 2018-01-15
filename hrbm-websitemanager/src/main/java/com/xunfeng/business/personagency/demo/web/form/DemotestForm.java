package com.xunfeng.business.personagency.demo.web.form;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.business.personagency.demo.model.Demotest;
import com.xunfeng.core.model.BaseForm;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_DEMO Form对象
* @author:zhangfan
* @createDate 2016-07-28 10:46:20 
* @version V1.0   
*/
public class DemotestForm extends BaseForm<Demotest>
{
	// ID
	protected Long  id;
	// NAME
	protected String  name;
	// ADDRESS
	protected String  address;
	// PHONE
	protected String  phone;
	// SEX
	protected String  sex;
	// AGE
	protected Long  age;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 ID
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
	 * 返回 NAME
	 * @return
	 */
	public String getName() 
	{
		return this.name;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	/**
	 * 返回 ADDRESS
	 * @return
	 */
	public String getAddress() 
	{
		return this.address;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}
	/**
	 * 返回 PHONE
	 * @return
	 */
	public String getPhone() 
	{
		return this.phone;
	}
	public void setSex(String sex) 
	{
		this.sex = sex;
	}
	/**
	 * 返回 SEX
	 * @return
	 */
	public String getSex() 
	{
		return this.sex;
	}
	public void setAge(Long age) 
	{
		this.age = age;
	}
	/**
	 * 返回 AGE
	 * @return
	 */
	public Long getAge() 
	{
		return this.age;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof DemotestForm)) 
		{
			return false;
		}
		DemotestForm rhs = (DemotestForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.name, rhs.name)
		.append(this.address, rhs.address)
		.append(this.phone, rhs.phone)
		.append(this.sex, rhs.sex)
		.append(this.age, rhs.age)
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
		.append(this.address) 
		.append(this.phone) 
		.append(this.sex) 
		.append(this.age) 
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
		.append("address", this.address) 
		.append("phone", this.phone) 
		.append("sex", this.sex) 
		.append("age", this.age) 
		.toString();
	}
   
  

}