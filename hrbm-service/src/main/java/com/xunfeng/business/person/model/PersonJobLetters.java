package com.xunfeng.business.person.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: PERSON_JOB_LETTERS Model对象
* @author:wanghan
* @createDate 2015-12-03 14:49:46 
* @version V1.0   
*/
public class PersonJobLetters extends BaseModel
{
	// 主键
	protected Long  id;
	// 帐号Id
	protected Long  ccmu01;
	// 求职信标题
	protected String  lettersTitle;
	// 求职信内容
	protected String  lettersContent;
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
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 帐号Id
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setLettersTitle(String lettersTitle) 
	{
		this.lettersTitle = lettersTitle;
	}
	/**
	 * 返回 求职信标题
	 * @return
	 */
	public String getLettersTitle() 
	{
		return this.lettersTitle;
	}
	public void setLettersContent(String lettersContent) 
	{
		this.lettersContent = lettersContent;
	}
	/**
	 * 返回 求职信内容
	 * @return
	 */
	public String getLettersContent() 
	{
		return this.lettersContent;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof PersonJobLetters)) 
		{
			return false;
		}
		PersonJobLetters rhs = (PersonJobLetters) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.lettersTitle, rhs.lettersTitle)
		.append(this.lettersContent, rhs.lettersContent)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id) 
		.append(this.ccmu01) 
		.append(this.lettersTitle) 
		.append(this.lettersContent) 
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id", this.id) 
		.append("ccmu01", this.ccmu01) 
		.append("lettersTitle", this.lettersTitle) 
		.append("lettersContent", this.lettersContent) 
		.toString();
	}
   
  

}