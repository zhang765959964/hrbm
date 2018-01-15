package com.xunfeng.business.machine.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.machine.model.Machine;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 查询机管理表 Form对象
* @author:wanghan
* @createDate 2015-11-23 10:15:36 
* @version V1.0   
*/
public class MachineForm extends BaseForm<Machine>
{
	// 主键
	protected Long  id;
	// 查询机名称
	protected String  machineName;
	// 查询机位置
	protected String  machineAddress;
	// 查询机Ip地址
	protected String  machineIp;
	// 查询机编号
	protected String  machineCode;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setMachineName(String machineName) 
	{
		this.machineName = machineName;
	}
	/**
	 * 返回 查询机名称
	 * @return
	 */
	public String getMachineName() 
	{
		return this.machineName;
	}
	public void setMachineAddress(String machineAddress) 
	{
		this.machineAddress = machineAddress;
	}
	/**
	 * 返回 查询机位置
	 * @return
	 */
	public String getMachineAddress() 
	{
		return this.machineAddress;
	}
	public void setMachineIp(String machineIp) 
	{
		this.machineIp = machineIp;
	}
	/**
	 * 返回 查询机Ip地址
	 * @return
	 */
	public String getMachineIp() 
	{
		return this.machineIp;
	}
	public void setMachineCode(String machineCode) 
	{
		this.machineCode = machineCode;
	}
	/**
	 * 返回 查询机编号
	 * @return
	 */
	public String getMachineCode() 
	{
		return this.machineCode;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof MachineForm)) 
		{
			return false;
		}
		MachineForm rhs = (MachineForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.machineName, rhs.machineName)
		.append(this.machineAddress, rhs.machineAddress)
		.append(this.machineIp, rhs.machineIp)
		.append(this.machineCode, rhs.machineCode)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.machineName) 
		.append(this.machineAddress) 
		.append(this.machineIp) 
		.append(this.machineCode) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("machineName", this.machineName) 
		.append("machineAddress", this.machineAddress) 
		.append("machineIp", this.machineIp) 
		.append("machineCode", this.machineCode) 
		.toString();
	}
   
  

}