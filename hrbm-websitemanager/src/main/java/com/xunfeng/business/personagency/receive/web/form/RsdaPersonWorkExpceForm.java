package com.xunfeng.business.personagency.receive.web.form;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.core.model.BaseForm;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人工作经历表 Form对象
* @author:wanghan
* @createDate 2016-07-26 17:28:38 
* @version V1.0   
*/
public class RsdaPersonWorkExpceForm extends BaseForm<PersonWorkExpce>
{
	// 工作经历编号
	protected Long  aac0b0;
	// 个人编号
	protected Long  aac001;
	// 工作单位
	protected String  aac045;
	// 工作开始日期
	protected java.util.Date  aae030;
	// 工作结束日期
	protected java.util.Date  aae031;
	// 主要工作内容
	protected String  aac0b4;
	// 劳动合同期限
	protected Long  aac217;
	// 专业技术职务
	protected String  aac014;
	// 职称
	protected String  aac0b1;
	// 职业资格等级
	protected String  aac015;
	// 执业资格情况
	protected String  aac0b2;
	// 岗位
	protected String  aac0b3;
	// 成绩及奖惩
	protected String  aac0b5;
	// 见习标志
	protected String  aac0b6;
	// 在职培训情况
	protected String  aac0b7;
	// 离职原因
	protected String  aac0b8;
	// 离职日期
	protected java.util.Date  aac0ba;
	// 备注
	protected String  aae013;
	// 专业技术职务(名字)
	protected String  aac014name;
	// 职称（名字）
	protected String  aac0b1name;
	// 职业资格等级（名字）
	protected String  aac015name;
	// 离职原因(name)
	protected String  aac0b8name;
	
	
	
	public String getAac014name() {
		return aac014name;
	}
	public void setAac014name(String aac014name) {
		this.aac014name = aac014name;
	}
	public String getAac0b1name() {
		return aac0b1name;
	}
	public void setAac0b1name(String aac0b1name) {
		this.aac0b1name = aac0b1name;
	}
	public String getAac015name() {
		return aac015name;
	}
	public void setAac015name(String aac015name) {
		this.aac015name = aac015name;
	}
	public String getAac0b8name() {
		return aac0b8name;
	}
	public void setAac0b8name(String aac0b8name) {
		this.aac0b8name = aac0b8name;
	}
	public void setAac0b0(Long aac0b0) 
	{
		this.aac0b0 = aac0b0;
	}
	/**
	 * 返回 工作经历编号
	 * @return
	 */
	public Long getAac0b0() 
	{
		return this.aac0b0;
	}
	public void setAac001(Long aac001) 
	{
		this.aac001 = aac001;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public Long getAac001() 
	{
		return this.aac001;
	}
	public void setAac045(String aac045) 
	{
		this.aac045 = aac045;
	}
	/**
	 * 返回 工作单位
	 * @return
	 */
	public String getAac045() 
	{
		return this.aac045;
	}
	public void setAae030(java.util.Date aae030) 
	{
		this.aae030 = aae030;
	}
	/**
	 * 返回 工作开始日期
	 * @return
	 */
	public java.util.Date getAae030() 
	{
		return this.aae030;
	}
	public void setAae031(java.util.Date aae031) 
	{
		this.aae031 = aae031;
	}
	/**
	 * 返回 工作结束日期
	 * @return
	 */
	public java.util.Date getAae031() 
	{
		return this.aae031;
	}
	public void setAac0b4(String aac0b4) 
	{
		this.aac0b4 = aac0b4;
	}
	/**
	 * 返回 主要工作内容
	 * @return
	 */
	public String getAac0b4() 
	{
		return this.aac0b4;
	}
	public void setAac217(Long aac217) 
	{
		this.aac217 = aac217;
	}
	/**
	 * 返回 劳动合同期限
	 * @return
	 */
	public Long getAac217() 
	{
		return this.aac217;
	}
	public void setAac014(String aac014) 
	{
		this.aac014 = aac014;
	}
	/**
	 * 返回 专业技术职务
	 * @return
	 */
	public String getAac014() 
	{
		return this.aac014;
	}
	public void setAac0b1(String aac0b1) 
	{
		this.aac0b1 = aac0b1;
	}
	/**
	 * 返回 职称
	 * @return
	 */
	public String getAac0b1() 
	{
		return this.aac0b1;
	}
	public void setAac015(String aac015) 
	{
		this.aac015 = aac015;
	}
	/**
	 * 返回 职业资格等级
	 * @return
	 */
	public String getAac015() 
	{
		return this.aac015;
	}
	public void setAac0b2(String aac0b2) 
	{
		this.aac0b2 = aac0b2;
	}
	/**
	 * 返回 执业资格情况
	 * @return
	 */
	public String getAac0b2() 
	{
		return this.aac0b2;
	}
	public void setAac0b3(String aac0b3) 
	{
		this.aac0b3 = aac0b3;
	}
	/**
	 * 返回 岗位
	 * @return
	 */
	public String getAac0b3() 
	{
		return this.aac0b3;
	}
	public void setAac0b5(String aac0b5) 
	{
		this.aac0b5 = aac0b5;
	}
	/**
	 * 返回 成绩及奖惩
	 * @return
	 */
	public String getAac0b5() 
	{
		return this.aac0b5;
	}
	public void setAac0b6(String aac0b6) 
	{
		this.aac0b6 = aac0b6;
	}
	/**
	 * 返回 见习标志
	 * @return
	 */
	public String getAac0b6() 
	{
		return this.aac0b6;
	}
	public void setAac0b7(String aac0b7) 
	{
		this.aac0b7 = aac0b7;
	}
	/**
	 * 返回 在职培训情况
	 * @return
	 */
	public String getAac0b7() 
	{
		return this.aac0b7;
	}
	public void setAac0b8(String aac0b8) 
	{
		this.aac0b8 = aac0b8;
	}
	/**
	 * 返回 离职原因
	 * @return
	 */
	public String getAac0b8() 
	{
		return this.aac0b8;
	}
	public void setAac0ba(java.util.Date aac0ba) 
	{
		this.aac0ba = aac0ba;
	}
	/**
	 * 返回 离职日期
	 * @return
	 */
	public java.util.Date getAac0ba() 
	{
		return this.aac0ba;
	}
	public void setAae013(String aae013) 
	{
		this.aae013 = aae013;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getAae013() 
	{
		return this.aae013;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof RsdaPersonWorkExpceForm)) 
		{
			return false;
		}
		RsdaPersonWorkExpceForm rhs = (RsdaPersonWorkExpceForm) object;
		return new EqualsBuilder()
		.append(this.aac0b0, rhs.aac0b0)
		.append(this.aac001, rhs.aac001)
		.append(this.aac045, rhs.aac045)
		.append(this.aae030, rhs.aae030)
		.append(this.aae031, rhs.aae031)
		.append(this.aac0b4, rhs.aac0b4)
		.append(this.aac217, rhs.aac217)
		.append(this.aac014, rhs.aac014)
		.append(this.aac0b1, rhs.aac0b1)
		.append(this.aac015, rhs.aac015)
		.append(this.aac0b2, rhs.aac0b2)
		.append(this.aac0b3, rhs.aac0b3)
		.append(this.aac0b5, rhs.aac0b5)
		.append(this.aac0b6, rhs.aac0b6)
		.append(this.aac0b7, rhs.aac0b7)
		.append(this.aac0b8, rhs.aac0b8)
		.append(this.aac0ba, rhs.aac0ba)
		.append(this.aae013, rhs.aae013)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.aac0b0) 
		.append(this.aac001) 
		.append(this.aac045) 
		.append(this.aae030) 
		.append(this.aae031) 
		.append(this.aac0b4) 
		.append(this.aac217) 
		.append(this.aac014) 
		.append(this.aac0b1) 
		.append(this.aac015) 
		.append(this.aac0b2) 
		.append(this.aac0b3) 
		.append(this.aac0b5) 
		.append(this.aac0b6) 
		.append(this.aac0b7) 
		.append(this.aac0b8) 
		.append(this.aac0ba) 
		.append(this.aae013) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("aac0b0", this.aac0b0) 
		.append("aac001", this.aac001) 
		.append("aac045", this.aac045) 
		.append("aae030", this.aae030) 
		.append("aae031", this.aae031) 
		.append("aac0b4", this.aac0b4) 
		.append("aac217", this.aac217) 
		.append("aac014", this.aac014) 
		.append("aac0b1", this.aac0b1) 
		.append("aac015", this.aac015) 
		.append("aac0b2", this.aac0b2) 
		.append("aac0b3", this.aac0b3) 
		.append("aac0b5", this.aac0b5) 
		.append("aac0b6", this.aac0b6) 
		.append("aac0b7", this.aac0b7) 
		.append("aac0b8", this.aac0b8) 
		.append("aac0ba", this.aac0ba) 
		.append("aae013", this.aae013) 
		.toString();
	}
   
  

}