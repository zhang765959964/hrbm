package com.xunfeng.business.train.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 开班类型表 Model对象
* @author:Wang.CS
* @createDate 2016-05-23 09:29:51 
* @version V1.0   
*/
public class TrainCourseType extends BaseModel
{
	// 开班类型编号
	protected Long  typeId;
	// 开班类型名称
	protected String  name;
	//上级类型名称
 	protected String  pName;
	// 父id
	protected Long  pid;
	// 是否删除，1是 0否
	protected String  isDel;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	public void setTypeId(Long typeId) 
	{
		this.typeId = typeId;
	}
	/**
	 * 返回 开班类型编号
	 * @return
	 */
	public Long getTypeId() 
	{
		return this.typeId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * 返回 开班类型名称
	 * @return
	 */
	public String getName() 
	{
		return this.name;
	}
	
	/**
	 * 返回 上级类型名称
	 * @return
	 */
	public String getpName() {
		return pName;
	}
	
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
	public void setPid(Long pid) 
	{
		this.pid = pid;
	}
	/**
	 * 返回 父id
	 * @return
	 */
	public Long getPid() 
	{
		return this.pid;
	}
	public void setIsDel(String isDel) 
	{
		this.isDel = isDel;
	}
	/**
	 * 返回 是否删除，1是 0否
	 * @return
	 */
	public String getIsDel() 
	{
		return this.isDel;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源0未知1网站2窗口
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof TrainCourseType)) 
		{
			return false;
		}
		TrainCourseType rhs = (TrainCourseType) object;
		return new EqualsBuilder()
		.append(this.typeId, rhs.typeId)
		.append(this.name, rhs.name)
		.append(this.pid, rhs.pid)
		.append(this.isDel, rhs.isDel)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.cczy06, rhs.cczy06)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.typeId) 
		.append(this.name) 
		.append(this.pid) 
		.append(this.isDel) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.cczy06) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("typeId", this.typeId) 
		.append("name", this.name) 
		.append("pid", this.pid) 
		.append("isDel", this.isDel) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("cczy06", this.cczy06) 
		.toString();
	}
   
  

}