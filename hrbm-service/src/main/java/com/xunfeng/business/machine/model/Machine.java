package com.xunfeng.business.machine.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 查询机管理表 Model对象
* @author:wanghan
* @createDate 2015-12-22 16:19:53 
* @version V1.0   
*/
public class Machine extends BaseModel
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
	// x坐标
	protected Float  gprsX;
	// y坐标
	protected Float  gprsY;
	// 缩放比例
	protected Long  zoom;
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
	public void setGprsX(Float gprsX) 
	{
		this.gprsX = gprsX;
	}
	/**
	 * 返回 x坐标
	 * @return
	 */
	public Float getGprsX() 
	{
		return this.gprsX;
	}
	public void setGprsY(Float gprsY) 
	{
		this.gprsY = gprsY;
	}
	/**
	 * 返回 y坐标
	 * @return
	 */
	public Float getGprsY() 
	{
		return this.gprsY;
	}
	public void setZoom(Long zoom) 
	{
		this.zoom = zoom;
	}
	/**
	 * 返回 缩放比例
	 * @return
	 */
	public Long getZoom() 
	{
		return this.zoom;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Machine)) 
		{
			return false;
		}
		Machine rhs = (Machine) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.machineName, rhs.machineName)
		.append(this.machineAddress, rhs.machineAddress)
		.append(this.machineIp, rhs.machineIp)
		.append(this.machineCode, rhs.machineCode)
		.append(this.gprsX, rhs.gprsX)
		.append(this.gprsY, rhs.gprsY)
		.append(this.zoom, rhs.zoom)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.machineName) 
		.append(this.machineAddress) 
		.append(this.machineIp) 
		.append(this.machineCode) 
		.append(this.gprsX) 
		.append(this.gprsY) 
		.append(this.zoom) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("machineName", this.machineName) 
		.append("machineAddress", this.machineAddress) 
		.append("machineIp", this.machineIp) 
		.append("machineCode", this.machineCode) 
		.append("gprsX", this.gprsX) 
		.append("gprsY", this.gprsY) 
		.append("zoom", this.zoom) 
		.toString();
	}
   
  

}