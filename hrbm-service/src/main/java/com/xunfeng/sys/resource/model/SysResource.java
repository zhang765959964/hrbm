package com.xunfeng.sys.resource.model;
import java.util.ArrayList;
import java.util.List;

import com.xunfeng.core.model.BaseModel;
import com.xunfeng.core.model.IBaseTree;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 功能模块表 Model对象
* @author:wanghan
* @createDate 2016-06-07 11:39:04 
* @version V1.0   
*/
public class SysResource extends BaseModel implements IBaseTree
{
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
	//是否拥有该权限
	protected boolean checked;
	// 功能备注
	protected String  fundemo;
	// 功能模块是否可用 0:是 1:否
	protected Long  funuse;
	// 菜单图标
	protected String  funmenu;
	// 排序字段
	protected Long  funsort;
	
	private List<SysResource> subSysResourceList=new ArrayList();
	
	public void setFunsort(Long funsort) 
	{
		this.funsort = funsort;
	}
	/**
	 * 返回 排序字段
	 * @return
	 */
	public Long getFunsort() 
	{
		return this.funsort;
	}
	public void setFunid(Long funid) 
	{
		this.funid = funid;
	}
	
	public String getFunmenu() {
		return funmenu;
	}

	public void setFunmenu(String funmenu) {
		this.funmenu = funmenu;
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
		if (!(object instanceof SysResource)) 
		{
			return false;
		}
		SysResource rhs = (SysResource) object;
		return new EqualsBuilder()
		.append(this.funid, rhs.funid)
		.append(this.funplat, rhs.funplat)
		.append(this.funpid, rhs.funpid)
		.append(this.funname, rhs.funname)
		.append(this.funmapping, rhs.funmapping)
		.append(this.funuse, rhs.funuse)
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
		.append(this.funuse) 
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
		.append("funsort", this.funsort) 
		.toString();
	}
	public List<SysResource> getSubSysResourceList() {
		return subSysResourceList;
	}
	public void setSubSysResourceList(List<SysResource> subSysResourceList) {
		this.subSysResourceList = subSysResourceList;
	}
	@Override
	public String getId() {
		return String.valueOf(funid);
	}
	@Override
	public String getName() {
		return funname;
	}
	@Override
	public String getNodeType() {
		return "menu";
	}
	@Override
	public String getpId() {
		return String.valueOf(funpid);
	}
	public boolean getChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
    
}