package com.xunfeng.sys.node.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.xunfeng.core.json.JsonDateSerializer;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 节点表 Model对象
* @author:wanlupeng
* @createDate 2016-08-15 18:10:17 
* @version V1.0   
*/
public class Node extends BaseModel
{
	// 节点编号seq_com_node
	protected Long  comn01;
	// 节点名称
	protected String  comn02;
	// 节点所在平台参见tab_datasource
	protected String  comn03;
	// 节点所属功能模块
	protected String  comn04;
	// 是否允许此节点发送短信T-允许F-不允许
	protected String  comn05;
	// 模版编号
	protected Long  comm01;
	// 节点所属功能模块类别1-个人2-单位
	protected String  comn06;
	public void setComn01(Long comn01) 
	{
		this.comn01 = comn01;
	}
	/**
	 * 返回 节点编号seq_com_node
	 * @return
	 */
	public Long getComn01() 
	{
		return this.comn01;
	}
	public void setComn02(String comn02) 
	{
		this.comn02 = comn02;
	}
	/**
	 * 返回 节点名称
	 * @return
	 */
	public String getComn02() 
	{
		return this.comn02;
	}
	public void setComn03(String comn03) 
	{
		this.comn03 = comn03;
	}
	/**
	 * 返回 节点所在平台参见tab_datasource
	 * @return
	 */
	public String getComn03() 
	{
		return this.comn03;
	}
	public void setComn04(String comn04) 
	{
		this.comn04 = comn04;
	}
	/**
	 * 返回 节点所属功能模块
	 * @return
	 */
	public String getComn04() 
	{
		return this.comn04;
	}
	public void setComn05(String comn05) 
	{
		this.comn05 = comn05;
	}
	/**
	 * 返回 是否允许此节点发送短信T-允许F-不允许
	 * @return
	 */
	public String getComn05() 
	{
		return this.comn05;
	}
	public void setComm01(Long comm01) 
	{
		this.comm01 = comm01;
	}
	/**
	 * 返回 模版编号
	 * @return
	 */
	public Long getComm01() 
	{
		return this.comm01;
	}
	public void setComn06(String comn06) 
	{
		this.comn06 = comn06;
	}
	/**
	 * 返回 节点所属功能模块类别1-个人2-单位
	 * @return
	 */
	public String getComn06() 
	{
		return this.comn06;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Node)) 
		{
			return false;
		}
		Node rhs = (Node) object;
		return new EqualsBuilder()
		.append(this.comn01, rhs.comn01)
		.append(this.comn02, rhs.comn02)
		.append(this.comn03, rhs.comn03)
		.append(this.comn04, rhs.comn04)
		.append(this.comn05, rhs.comn05)
		.append(this.comm01, rhs.comm01)
		.append(this.comn06, rhs.comn06)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.comn01) 
		.append(this.comn02) 
		.append(this.comn03) 
		.append(this.comn04) 
		.append(this.comn05) 
		.append(this.comm01) 
		.append(this.comn06) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("comn01", this.comn01) 
		.append("comn02", this.comn02) 
		.append("comn03", this.comn03) 
		.append("comn04", this.comn04) 
		.append("comn05", this.comn05) 
		.append("comm01", this.comm01) 
		.append("comn06", this.comn06) 
		.toString();
	}
   
  

}