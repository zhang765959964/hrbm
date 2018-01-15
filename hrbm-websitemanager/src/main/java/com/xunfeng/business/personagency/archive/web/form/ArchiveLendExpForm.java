package com.xunfeng.business.personagency.archive.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.archive.model.ArchiveLendExp;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出拓展表 Form对象
* @author:jiangxin
* @createDate 2016-12-26 11:51:40 
* @version V1.0   
*/
public class ArchiveLendExpForm extends BaseForm<ArchiveLendExp>
{
	// 主键id
	protected Long  id;
	// 档案调出表主键id
	protected Long  expLendId;
	// 档案编号
	protected String  archiveCode;
	// 姓名
	protected String  aac003;
	// 身份证号
	protected String  aac002;
	// 性别
	protected String  aac004;
	// 存档类型
	protected Long  archiveType;
	// 档案接收日期(转入)
	protected java.util.Date  receiveDate;
	// 市场位置
	protected String  marketPosition;
	// 档案库号
	protected String  cabinetsLibrary;
	// 档案排号
	protected String  cabinetsCode;
	// 档案层号
	protected String  cabinetsLayer;
	// 档案组号
	protected String  cabinetsLattice;
	// 单位名称
	protected String  aab004;
	public void setId(Long id) 
	{
		this.id = id;
	}
	/**
	 * 返回 主键id
	 * @return
	 */
	public Long getId() 
	{
		return this.id;
	}
	public void setExpLendId(Long expLendId) 
	{
		this.expLendId = expLendId;
	}
	/**
	 * 返回 档案调出表主键id
	 * @return
	 */
	public Long getExpLendId() 
	{
		return this.expLendId;
	}
	public void setArchiveCode(String archiveCode) 
	{
		this.archiveCode = archiveCode;
	}
	/**
	 * 返回 档案编号
	 * @return
	 */
	public String getArchiveCode() 
	{
		return this.archiveCode;
	}
	public void setAac003(String aac003) 
	{
		this.aac003 = aac003;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getAac003() 
	{
		return this.aac003;
	}
	public void setAac002(String aac002) 
	{
		this.aac002 = aac002;
	}
	/**
	 * 返回 身份证号
	 * @return
	 */
	public String getAac002() 
	{
		return this.aac002;
	}
	public void setAac004(String aac004) 
	{
		this.aac004 = aac004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAac004() 
	{
		return this.aac004;
	}
	public void setArchiveType(Long archiveType) 
	{
		this.archiveType = archiveType;
	}
	/**
	 * 返回 存档类型
	 * @return
	 */
	public Long getArchiveType() 
	{
		return this.archiveType;
	}
	public void setReceiveDate(java.util.Date receiveDate) 
	{
		this.receiveDate = receiveDate;
	}
	/**
	 * 返回 档案接收日期(转入)
	 * @return
	 */
	public java.util.Date getReceiveDate() 
	{
		return this.receiveDate;
	}
	public void setMarketPosition(String marketPosition) 
	{
		this.marketPosition = marketPosition;
	}
	/**
	 * 返回 市场位置
	 * @return
	 */
	public String getMarketPosition() 
	{
		return this.marketPosition;
	}
	public void setCabinetsLibrary(String cabinetsLibrary) 
	{
		this.cabinetsLibrary = cabinetsLibrary;
	}
	/**
	 * 返回 档案库号
	 * @return
	 */
	public String getCabinetsLibrary() 
	{
		return this.cabinetsLibrary;
	}
	public void setCabinetsCode(String cabinetsCode) 
	{
		this.cabinetsCode = cabinetsCode;
	}
	/**
	 * 返回 档案排号
	 * @return
	 */
	public String getCabinetsCode() 
	{
		return this.cabinetsCode;
	}
	public void setCabinetsLayer(String cabinetsLayer) 
	{
		this.cabinetsLayer = cabinetsLayer;
	}
	/**
	 * 返回 档案层号
	 * @return
	 */
	public String getCabinetsLayer() 
	{
		return this.cabinetsLayer;
	}
	public void setCabinetsLattice(String cabinetsLattice) 
	{
		this.cabinetsLattice = cabinetsLattice;
	}
	/**
	 * 返回 档案组号
	 * @return
	 */
	public String getCabinetsLattice() 
	{
		return this.cabinetsLattice;
	}
	public void setAab004(String aab004) 
	{
		this.aab004 = aab004;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004() 
	{
		return this.aab004;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ArchiveLendExpForm)) 
		{
			return false;
		}
		ArchiveLendExpForm rhs = (ArchiveLendExpForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.expLendId, rhs.expLendId)
		.append(this.archiveCode, rhs.archiveCode)
		.append(this.aac003, rhs.aac003)
		.append(this.aac002, rhs.aac002)
		.append(this.aac004, rhs.aac004)
		.append(this.archiveType, rhs.archiveType)
		.append(this.receiveDate, rhs.receiveDate)
		.append(this.marketPosition, rhs.marketPosition)
		.append(this.cabinetsLibrary, rhs.cabinetsLibrary)
		.append(this.cabinetsCode, rhs.cabinetsCode)
		.append(this.cabinetsLayer, rhs.cabinetsLayer)
		.append(this.cabinetsLattice, rhs.cabinetsLattice)
		.append(this.aab004, rhs.aab004)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.expLendId) 
		.append(this.archiveCode) 
		.append(this.aac003) 
		.append(this.aac002) 
		.append(this.aac004) 
		.append(this.archiveType) 
		.append(this.receiveDate) 
		.append(this.marketPosition) 
		.append(this.cabinetsLibrary) 
		.append(this.cabinetsCode) 
		.append(this.cabinetsLayer) 
		.append(this.cabinetsLattice) 
		.append(this.aab004) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("expLendId", this.expLendId) 
		.append("archiveCode", this.archiveCode) 
		.append("aac003", this.aac003) 
		.append("aac002", this.aac002) 
		.append("aac004", this.aac004) 
		.append("archiveType", this.archiveType) 
		.append("receiveDate", this.receiveDate) 
		.append("marketPosition", this.marketPosition) 
		.append("cabinetsLibrary", this.cabinetsLibrary) 
		.append("cabinetsCode", this.cabinetsCode) 
		.append("cabinetsLayer", this.cabinetsLayer) 
		.append("cabinetsLattice", this.cabinetsLattice) 
		.append("aab004", this.aab004) 
		.toString();
	}
   
  

}