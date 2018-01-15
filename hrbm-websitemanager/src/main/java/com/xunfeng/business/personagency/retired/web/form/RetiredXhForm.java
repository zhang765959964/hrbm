package com.xunfeng.business.personagency.retired.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.personagency.retired.model.RetiredXh;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休序号历史记录表 Form对象
* @author:zhangfan
* @createDate 2016-11-29 17:11:56 
* @version V1.0   
*/
public class RetiredXhForm extends BaseForm<RetiredXh>
{
	// 主键id
	protected Long  id;
	// 类型
	protected String  type;
	// 序号
	protected String  xh;
	// 退休个人编码
	protected String  bm;
	// 标识状态
	protected Long  flag;
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
	public void setType(String type) 
	{
		this.type = type;
	}
	/**
	 * 返回 类型
	 * @return
	 */
	public String getType() 
	{
		return this.type;
	}
	public void setXh(String xh) 
	{
		this.xh = xh;
	}
	/**
	 * 返回 序号
	 * @return
	 */
	public String getXh() 
	{
		return this.xh;
	}
	public void setBm(String bm) 
	{
		this.bm = bm;
	}
	/**
	 * 返回 退休个人编码
	 * @return
	 */
	public String getBm() 
	{
		return this.bm;
	}
	public void setFlag(Long flag) 
	{
		this.flag = flag;
	}
	/**
	 * 返回 标识状态
	 * @return
	 */
	public Long getFlag() 
	{
		return this.flag;
	}

   
  

}