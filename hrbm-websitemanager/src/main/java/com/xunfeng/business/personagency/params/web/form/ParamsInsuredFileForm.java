package com.xunfeng.business.personagency.params.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.params.model.ParamsInsuredFile;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 参保文件 Form对象
* @author:wanghan
* @createDate 2016-09-07 10:23:40 
* @version V1.0   
*/
public class ParamsInsuredFileForm extends BaseForm<ParamsInsuredFile>
{
	// 主键
	protected Long  pkId;
	// 文件名称
	protected String  fdFileName;
	// 文件编号
	protected String  fdFileNumber;
	public void setPkId(Long pkId) 
	{
		this.pkId = pkId;
	}
	/**
	 * 返回 主键
	 * @return
	 */
	public Long getPkId() 
	{
		return this.pkId;
	}
	public void setFdFileName(String fdFileName) 
	{
		this.fdFileName = fdFileName;
	}
	/**
	 * 返回 文件名称
	 * @return
	 */
	public String getFdFileName() 
	{
		return this.fdFileName;
	}
	public void setFdFileNumber(String fdFileNumber) 
	{
		this.fdFileNumber = fdFileNumber;
	}
	/**
	 * 返回 文件编号
	 * @return
	 */
	public String getFdFileNumber() 
	{
		return this.fdFileNumber;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof ParamsInsuredFileForm)) 
		{
			return false;
		}
		ParamsInsuredFileForm rhs = (ParamsInsuredFileForm) object;
		return new EqualsBuilder()
		.append(this.pkId, rhs.pkId)
		.append(this.fdFileName, rhs.fdFileName)
		.append(this.fdFileNumber, rhs.fdFileNumber)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.pkId) 
		.append(this.fdFileName) 
		.append(this.fdFileNumber) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("pkId", this.pkId) 
		.append("fdFileName", this.fdFileName) 
		.append("fdFileNumber", this.fdFileNumber) 
		.toString();
	}
   
  

}