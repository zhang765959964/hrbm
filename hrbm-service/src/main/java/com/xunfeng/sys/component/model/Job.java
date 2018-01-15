package com.xunfeng.sys.component.model;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 工种自定义标准 Model对象
* @author:wanghan
* @createDate 2015-09-23 15:34:24 
* @version V1.0   
*/
public class Job extends BaseModel
{
	// 序号
	protected String  id;
	// 名称
	protected String  name;
	// 父序号
	protected String  pid;
	// 部标代码
	protected String  bt;
	// 部标代码
	protected String  btName;
	// 排序
	protected Long  paix;
	// 是否热门职位(0-不是1-是)
	protected Long  hot;
	// 状态(1-使用中2-弃用)
	protected Long  status;
	// 拼音简写(大写)
	protected String  jp;
	protected StringBuffer subJobIds=new StringBuffer();
	List subJobList=new ArrayList();
	
	public List getSubJobList() {
		return subJobList;
	}
	public void setSubJobList(List subJobList) {
		this.subJobList = subJobList;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public String getId() 
	{
		return this.id;
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
	public void setPid(String pid) 
	{
		this.pid = pid;
	}
	/**
	 * 返回 父序号
	 * @return
	 */
	public String getPid() 
	{
		return this.pid;
	}
	public void setBt(String bt) 
	{
		this.bt = bt;
	}
	/**
	 * 返回 部标代码
	 * @return
	 */
	public String getBt() 
	{
		return this.bt;
	}
	public void setPaix(Long paix) 
	{
		this.paix = paix;
	}
	/**
	 * 返回 排序
	 * @return
	 */
	public Long getPaix() 
	{
		return this.paix;
	}
	public void setHot(Long hot) 
	{
		this.hot = hot;
	}
	/**
	 * 返回 是否热门职位(0-不是1-是)
	 * @return
	 */
	public Long getHot() 
	{
		return this.hot;
	}
	public void setStatus(Long status) 
	{
		this.status = status;
	}
	/**
	 * 返回 状态(1-使用中2-弃用)
	 * @return
	 */
	public Long getStatus() 
	{
		return this.status;
	}
	public void setJp(String jp) 
	{
		this.jp = jp;
	}
	/**
	 * 返回 拼音简写(大写)
	 * @return
	 */
	public String getJp() 
	{
		return this.jp;
	}

	public String getBtName() {
		return btName;
	}

	public void setBtName(String btName) {
		this.btName = btName;
	}

	public StringBuffer getSubJobIds() {
		return subJobIds;
	}
	public void setSubJobIds(StringBuffer subJobIds) {
		this.subJobIds = subJobIds;
	}
	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Job)) 
		{
			return false;
		}
		Job rhs = (Job) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.name, rhs.name)
		.append(this.pid, rhs.pid)
		.append(this.bt, rhs.bt)
		.append(this.paix, rhs.paix)
		.append(this.hot, rhs.hot)
		.append(this.status, rhs.status)
		.append(this.jp, rhs.jp)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.name) 
		.append(this.pid) 
		.append(this.bt) 
		.append(this.paix) 
		.append(this.hot) 
		.append(this.status) 
		.append(this.jp) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("name", this.name) 
		.append("pid", this.pid) 
		.append("bt", this.bt) 
		.append("paix", this.paix) 
		.append("hot", this.hot) 
		.append("status", this.status) 
		.append("jp", this.jp) 
		.toString();
	}
   
  

}