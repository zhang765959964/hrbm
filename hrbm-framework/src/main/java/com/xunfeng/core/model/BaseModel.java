package com.xunfeng.core.model;

import java.io.Serializable;
import java.util.Date;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 实体类基类 
* @author wanghan 
* @createDate 2015年4月23日-下午2:08:31 
* @version V1.0   
*/
public class BaseModel implements Serializable
{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	public BaseModel()
	{

	}

	/**
	 * 创建人ID
	 */
	protected Long createBy;
	/**
	 * 创建时间
	 */
	protected Date createtime;
	/**
	 * 更新时间
	 */
	protected Date updatetime;
	/**
	 * 更新人ID
	 */
	protected Long updateBy;

	public Long getCreateBy()
	{
		return createBy;
	}

	public void setCreateBy(Long createBy)
	{
		this.createBy = createBy;
	}

	public Date getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}

	public Date getUpdatetime()
	{
		return updatetime;
	}

	public void setUpdatetime(Date updatetime)
	{
		this.updatetime = updatetime;
	}

	public Long getUpdateBy()
	{
		return updateBy;
	}

	public void setUpdateBy(Long updateBy)
	{
		this.updateBy = updateBy;
	}

}
