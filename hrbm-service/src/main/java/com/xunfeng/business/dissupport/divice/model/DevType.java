package com.xunfeng.business.dissupport.divice.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 设备类别表 Model对象
* @author:wanghan
* @createDate 2016-07-28 11:19:04 
* @version V1.0   
*/
public class DevType extends BaseModel
{
	// 设备类别ID
	protected Long  typeId;
	// 设备类别父ID
	protected Long  typePid;
	// 设备类别名称
	protected String  typeName;
	// 设备类别描述
	protected String  typeDesc;
	// 设备类别状态 0:禁用 1:正常
	protected String  isEnable;
	// 设备简拼
	protected String  typeSpl;
	// 设备使用范围 0:默认值 1:现场招聘会
	protected String  typeRange;
	public void setTypeId(Long typeId) 
	{
		this.typeId = typeId;
	}
	/**
	 * 返回 设备类别ID
	 * @return
	 */
	public Long getTypeId() 
	{
		return this.typeId;
	}
	public void setTypePid(Long typePid) 
	{
		this.typePid = typePid;
	}
	/**
	 * 返回 设备类别父ID
	 * @return
	 */
	public Long getTypePid() 
	{
		return this.typePid;
	}
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}
	/**
	 * 返回 设备类别名称
	 * @return
	 */
	public String getTypeName() 
	{
		return this.typeName;
	}
	public void setTypeDesc(String typeDesc) 
	{
		this.typeDesc = typeDesc;
	}
	/**
	 * 返回 设备类别描述
	 * @return
	 */
	public String getTypeDesc() 
	{
		return this.typeDesc;
	}
	public void setIsEnable(String isEnable) 
	{
		this.isEnable = isEnable;
	}
	/**
	 * 返回 设备类别状态 0:禁用 1:正常
	 * @return
	 */
	public String getIsEnable() 
	{
		return this.isEnable;
	}
	public void setTypeSpl(String typeSpl) 
	{
		this.typeSpl = typeSpl;
	}
	/**
	 * 返回 设备简拼
	 * @return
	 */
	public String getTypeSpl() 
	{
		return this.typeSpl;
	}
	public void setTypeRange(String typeRange) 
	{
		this.typeRange = typeRange;
	}
	/**
	 * 返回 设备使用范围 0:默认值 1:现场招聘会
	 * @return
	 */
	public String getTypeRange() 
	{
		return this.typeRange;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof DevType)) 
		{
			return false;
		}
		DevType rhs = (DevType) object;
		return new EqualsBuilder()
		.append(this.typeId, rhs.typeId)
		.append(this.typePid, rhs.typePid)
		.append(this.typeName, rhs.typeName)
		.append(this.typeDesc, rhs.typeDesc)
		.append(this.isEnable, rhs.isEnable)
		.append(this.typeSpl, rhs.typeSpl)
		.append(this.typeRange, rhs.typeRange)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.typeId) 
		.append(this.typePid) 
		.append(this.typeName) 
		.append(this.typeDesc) 
		.append(this.isEnable) 
		.append(this.typeSpl) 
		.append(this.typeRange) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("typeId", this.typeId) 
		.append("typePid", this.typePid) 
		.append("typeName", this.typeName) 
		.append("typeDesc", this.typeDesc) 
		.append("isEnable", this.isEnable) 
		.append("typeSpl", this.typeSpl) 
		.append("typeRange", this.typeRange) 
		.toString();
	}
   
  

}