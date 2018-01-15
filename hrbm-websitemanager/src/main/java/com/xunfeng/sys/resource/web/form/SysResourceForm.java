package com.xunfeng.sys.resource.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.sys.resource.model.SysResource;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 功能模块表 Form对象
* @author:liwenhao
* @createDate 2016-06-27 14:23:53 
* @version V1.0   
*/
public class SysResourceForm extends BaseForm<SysResource>
{
	/**
	 * sid
	 */
	private static final long serialVersionUID = 7340353459079287066L;
	// 功能编号
	protected Long  funid;
	// 功能平台
	protected Long  funplat;
	// 功能父编号
	protected Long  funpid;
	// 功能名称
	protected String  funname;
	// 功能映射地址
	protected String  funmapping;
	// 功能备注
	protected String  fundemo;
	// 功能模块是否可用 0:是 1:否
	protected Long  funuse;
	// 菜单图标
	protected String  funmenu;
	// 排序字段
	protected Long  funsort;
	
	public void setFunid(Long funid) 
	{
		this.funid = funid;
	}
	/**
	 * 返回 功能编号
	 * @return
	 */
	public Long getFunid() 
	{
		return this.funid;
	}
	public void setFunplat(Long funplat) 
	{
		this.funplat = funplat;
	}
	/**
	 * 返回 功能平台
	 * @return
	 */
	public Long getFunplat() 
	{
		return this.funplat;
	}
	public void setFunpid(Long funpid) 
	{
		this.funpid = funpid;
	}
	/**
	 * 返回 功能父编号
	 * @return
	 */
	public Long getFunpid() 
	{
		return this.funpid;
	}
	public void setFunname(String funname) 
	{
		this.funname = funname;
	}
	/**
	 * 返回 功能名称
	 * @return
	 */
	public String getFunname() 
	{
		return this.funname;
	}
	public void setFunmapping(String funmapping) 
	{
		this.funmapping = funmapping;
	}
	/**
	 * 返回 功能映射地址
	 * @return
	 */
	public String getFunmapping() 
	{
		return this.funmapping;
	}
	public void setFundemo(String fundemo) 
	{
		this.fundemo = fundemo;
	}
	/**
	 * 返回 功能备注
	 * @return
	 */
	public String getFundemo() 
	{
		return this.fundemo;
	}
	public void setFunuse(Long funuse) 
	{
		this.funuse = funuse;
	}
	/**
	 * 返回 功能模块是否可用 0:是 1:否
	 * @return
	 */
	public Long getFunuse() 
	{
		return this.funuse;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysResourceForm)) 
		{
			return false;
		}
		SysResourceForm rhs = (SysResourceForm) object;
		return new EqualsBuilder()
		.append(this.funid, rhs.funid)
		.append(this.funplat, rhs.funplat)
		.append(this.funpid, rhs.funpid)
		.append(this.funname, rhs.funname)
		.append(this.funmapping, rhs.funmapping)
		.append(this.fundemo, rhs.fundemo)
		.append(this.funuse, rhs.funuse)
		.append(this.funmenu, rhs.funmenu)
		.append(this.funsort, rhs.funsort)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.funid) 
		.append(this.funplat) 
		.append(this.funpid) 
		.append(this.funname) 
		.append(this.funmapping) 
		.append(this.fundemo) 
		.append(this.funuse) 
		.append(this.funmenu) 
		.append(this.funsort) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("funid", this.funid) 
		.append("funplat", this.funplat) 
		.append("funpid", this.funpid) 
		.append("funname", this.funname) 
		.append("funmapping", this.funmapping) 
		.append("fundemo", this.fundemo) 
		.append("funuse", this.funuse) 
		.append("funmenu", this.funmenu) 
		.append("funsort", this.funsort) 
		.toString();
	}
	public String getFunmenu() {
		return funmenu;
	}
	public void setFunmenu(String funmenu) {
		this.funmenu = funmenu;
	}
	public Long getFunsort() {
		return funsort;
	}
	public void setFunsort(Long funsort) {
		this.funsort = funsort;
	}
	
}