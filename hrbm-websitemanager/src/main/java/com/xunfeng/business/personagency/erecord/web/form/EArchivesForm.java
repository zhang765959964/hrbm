package com.xunfeng.business.personagency.erecord.web.form;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.business.personagency.erecord.model.EArchives;
import com.xunfeng.core.model.BaseForm;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 电子档案表 Form对象
* @author:wanghan
* @createDate 2015-08-10 14:59:21 
* @version V1.0   
*/
public class EArchivesForm extends BaseForm<EArchives>
{
	// 主键
	protected Long  id;
	// 目录Id
	protected Long  catalogId;
	// 人员Id
	protected Long  personId;
	// 档案Id
	protected Long  archivesId;
	// 图片大小
	protected Long  imageSize;
	// 图片路径
	protected String  imagePath;
	// 排序号
	protected Long  sortNum;
	// 经办人
	protected Long  createrId;
	// 经办人名称
	protected String  createrName;
	// 经办时间
	protected java.util.Date  creatDate;
	// 图片状态，“0”代表上传状态，“1”代表确认状态
	protected Long  imageStatus;
	// 压缩图片路径
	protected String  imageCompressPath;
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
	public void setCatalogId(Long catalogId) 
	{
		this.catalogId = catalogId;
	}
	/**
	 * 返回 目录Id
	 * @return
	 */
	public Long getCatalogId() 
	{
		return this.catalogId;
	}
	public void setPersonId(Long personId) 
	{
		this.personId = personId;
	}
	/**
	 * 返回 人员Id
	 * @return
	 */
	public Long getPersonId() 
	{
		return this.personId;
	}
	public void setArchivesId(Long archivesId) 
	{
		this.archivesId = archivesId;
	}
	/**
	 * 返回 档案Id
	 * @return
	 */
	public Long getArchivesId() 
	{
		return this.archivesId;
	}
	public void setImageSize(Long imageSize) 
	{
		this.imageSize = imageSize;
	}
	/**
	 * 返回 图片大小
	 * @return
	 */
	public Long getImageSize() 
	{
		return this.imageSize;
	}
	public void setImagePath(String imagePath) 
	{
		this.imagePath = imagePath;
	}
	/**
	 * 返回 图片路径
	 * @return
	 */
	public String getImagePath() 
	{
		return this.imagePath;
	}
	public void setSortNum(Long sortNum) 
	{
		this.sortNum = sortNum;
	}
	/**
	 * 返回 排序号
	 * @return
	 */
	public Long getSortNum() 
	{
		return this.sortNum;
	}
	public void setCreaterId(Long createrId) 
	{
		this.createrId = createrId;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public Long getCreaterId() 
	{
		return this.createrId;
	}
	public void setCreaterName(String createrName) 
	{
		this.createrName = createrName;
	}
	/**
	 * 返回 经办人名称
	 * @return
	 */
	public String getCreaterName() 
	{
		return this.createrName;
	}
	public void setCreatDate(java.util.Date creatDate) 
	{
		this.creatDate = creatDate;
	}
	/**
	 * 返回 经办时间
	 * @return
	 */
	public java.util.Date getCreatDate() 
	{
		return this.creatDate;
	}
	public void setImageStatus(Long imageStatus) 
	{
		this.imageStatus = imageStatus;
	}
	/**
	 * 返回 图片状态，“0”代表上传状态，“1”代表确认状态
	 * @return
	 */
	public Long getImageStatus() 
	{
		return this.imageStatus;
	}
	public void setImageCompressPath(String imageCompressPath) 
	{
		this.imageCompressPath = imageCompressPath;
	}
	/**
	 * 返回 压缩图片路径
	 * @return
	 */
	public String getImageCompressPath() 
	{
		return this.imageCompressPath;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof EArchivesForm)) 
		{
			return false;
		}
		EArchivesForm rhs = (EArchivesForm) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.catalogId, rhs.catalogId)
		.append(this.personId, rhs.personId)
		.append(this.archivesId, rhs.archivesId)
		.append(this.imageSize, rhs.imageSize)
		.append(this.imagePath, rhs.imagePath)
		.append(this.sortNum, rhs.sortNum)
		.append(this.createrId, rhs.createrId)
		.append(this.createrName, rhs.createrName)
		.append(this.creatDate, rhs.creatDate)
		.append(this.imageStatus, rhs.imageStatus)
		.append(this.imageCompressPath, rhs.imageCompressPath)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.catalogId) 
		.append(this.personId) 
		.append(this.archivesId) 
		.append(this.imageSize) 
		.append(this.imagePath) 
		.append(this.sortNum) 
		.append(this.createrId) 
		.append(this.createrName) 
		.append(this.creatDate) 
		.append(this.imageStatus) 
		.append(this.imageCompressPath) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("catalogId", this.catalogId) 
		.append("personId", this.personId) 
		.append("archivesId", this.archivesId) 
		.append("imageSize", this.imageSize) 
		.append("imagePath", this.imagePath) 
		.append("sortNum", this.sortNum) 
		.append("createrId", this.createrId) 
		.append("createrName", this.createrName) 
		.append("creatDate", this.creatDate) 
		.append("imageStatus", this.imageStatus) 
		.append("imageCompressPath", this.imageCompressPath) 
		.toString();
	}
   
  

}