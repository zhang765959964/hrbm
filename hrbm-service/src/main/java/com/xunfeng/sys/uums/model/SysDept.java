package com.xunfeng.sys.uums.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
import com.xunfeng.core.model.IBaseTree;
import com.xunfeng.core.util.DateUtil;
/**
 * 对象功能:科室表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-30 09:51:03
 */
/**
 * 对象功能:科室表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-30 09:51:03
 */
public class SysDept extends BaseModel implements IBaseTree
{
	/**
	 * sid
	 */
	private static final long serialVersionUID = -2465538543654667315L;
	// 编号
	protected Long  dep001;
	// 科室名称
	protected String  dep002;
	// 科室描述
	protected String  dep003;
	// 科室排序序号
	protected Long  dep004;
	// 科室所属机构
	protected Long  acd200;
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
	// 经办日期
	protected String aae036Format;
	// 所属机构名称
	protected String  acd202;
	//关键字查询
	protected String findKeyword;
	
	public void setDep001(Long dep001) 
	{
		this.dep001 = dep001;
	}
	/**
	 * 返回 编号
	 * @return
	 */
	public Long getDep001() 
	{
		return this.dep001;
	}
	public void setDep002(String dep002) 
	{
		this.dep002 = dep002;
	}
	/**
	 * 返回 科室名称
	 * @return
	 */
	public String getDep002() 
	{
		return this.dep002;
	}
	public void setDep003(String dep003) 
	{
		this.dep003 = dep003;
	}
	/**
	 * 返回 科室描述
	 * @return
	 */
	public String getDep003() 
	{
		return this.dep003;
	}
	public void setDep004(Long dep004) 
	{
		this.dep004 = dep004;
	}
	/**
	 * 返回 科室排序序号
	 * @return
	 */
	public Long getDep004() 
	{
		return this.dep004;
	}
	public void setAcd200(Long acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 科室所属机构
	 * @return
	 */
	public Long getAcd200() 
	{
		return this.acd200;
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
		if(aae036!=null){
			this.aae036Format = DateUtil.getformatterDate(aae036, "yyyy-MM-dd");
		}
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

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysDept)) 
		{
			return false;
		}
		SysDept rhs = (SysDept) object;
		return new EqualsBuilder()
		.append(this.dep001, rhs.dep001)
		.append(this.dep002, rhs.dep002)
		.append(this.dep003, rhs.dep003)
		.append(this.dep004, rhs.dep004)
		.append(this.acd200, rhs.acd200)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.dep001) 
		.append(this.dep002) 
		.append(this.dep003) 
		.append(this.dep004) 
		.append(this.acd200) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("dep001", this.dep001) 
		.append("dep002", this.dep002) 
		.append("dep003", this.dep003) 
		.append("dep004", this.dep004) 
		.append("acd200", this.acd200) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.toString();
	}
	/* (non-Javadoc)
	 * @see com.xunfeng.core.model.IBaseTree#getId()
	 */
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return "dept_"+dep001;
	}
	/* (non-Javadoc)
	 * @see com.xunfeng.core.model.IBaseTree#getPId()
	 */
	@Override
	public String getpId() {
		// TODO Auto-generated method stub
		return "org_"+acd200;
	}
	/* (non-Javadoc)
	 * @see com.xunfeng.core.model.IBaseTree#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return dep002;
	}
	/* (non-Javadoc)
	 * @see com.xunfeng.core.model.IBaseTree#getNodeType()
	 */
	@Override
	public String getNodeType() {
		// TODO Auto-generated method stub
		return "dept";
	}
	public String getAae036Format() {
		return aae036Format;
	}
	public void setAae036Format(String aae036Format) {
		this.aae036Format = aae036Format;
	}
	public String getAcd202() {
		return acd202;
	}
	public void setAcd202(String acd202) {
		this.acd202 = acd202;
	}
	public String getFindKeyword() {
		return findKeyword;
	}
	public void setFindKeyword(String findKeyword) {
		this.findKeyword = findKeyword;
	}

}