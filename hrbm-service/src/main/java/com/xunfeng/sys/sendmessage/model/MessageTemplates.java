package com.xunfeng.sys.sendmessage.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 短信模版表 Model对象
* @author:wanghan
* @createDate 2016-04-25 14:56:37 
* @version V1.0   
*/
public class MessageTemplates extends BaseModel
{
	// 短信模版编号seq_com_tem
	protected Long  comm01;
	// 模版名称
	protected String  comm02;
	// 模版类型（1-节点发送2-定时发送3-自由模版）
	protected Long  comm03;
	// 模版内容
	protected String  comm04;
	public void setComm01(Long comm01) 
	{
		this.comm01 = comm01;
	}
	/**
	 * 返回 短信模版编号seq_com_tem
	 * @return
	 */
	public Long getComm01() 
	{
		return this.comm01;
	}
	public void setComm02(String comm02) 
	{
		this.comm02 = comm02;
	}
	/**
	 * 返回 模版名称
	 * @return
	 */
	public String getComm02() 
	{
		return this.comm02;
	}
	public void setComm03(Long comm03) 
	{
		this.comm03 = comm03;
	}
	/**
	 * 返回 模版类型（1-节点发送2-定时发送3-自由模版）
	 * @return
	 */
	public Long getComm03() 
	{
		return this.comm03;
	}
	public void setComm04(String comm04) 
	{
		this.comm04 = comm04;
	}
	/**
	 * 返回 模版内容
	 * @return
	 */
	public String getComm04() 
	{
		return this.comm04;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof MessageTemplates)) 
		{
			return false;
		}
		MessageTemplates rhs = (MessageTemplates) object;
		return new EqualsBuilder()
		.append(this.comm01, rhs.comm01)
		.append(this.comm02, rhs.comm02)
		.append(this.comm03, rhs.comm03)
		.append(this.comm04, rhs.comm04)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.comm01) 
		.append(this.comm02) 
		.append(this.comm03) 
		.append(this.comm04) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("comm01", this.comm01) 
		.append("comm02", this.comm02) 
		.append("comm03", this.comm03) 
		.append("comm04", this.comm04) 
		.toString();
	}
   
  

}