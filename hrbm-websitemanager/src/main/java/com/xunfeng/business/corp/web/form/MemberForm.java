package com.xunfeng.business.corp.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.corp.model.Corp;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 单位基本信息表 Form对象
* @author:wanghan
* @createDate 2015-11-03 14:28:56 
* @version V1.0   
*/
public class MemberForm extends BaseForm<Corp>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 会员名
	protected String  CCMU02;
	// 认证状态
	protected String  CABQ08N;
	// 来源
	protected String  ECZY06;
	// 会员卡号
	protected String  CAHY02;
	// 会员卡号类型
	protected String  CAHY05;
	// 人才币
	protected String  CCMU19;
	
	
	public String getCCMU02() {
		return this.CCMU02;
	}

	public void setCCMU02(String cCMU02) {
		CCMU02 = cCMU02;
	}

	public String getCABQ08N() {
		return this.CABQ08N;
	}

	public void setCABQ08N(String cABQ08N) {
		CABQ08N = cABQ08N;
	}

	public String getECZY06() {
		return this.ECZY06;
	}

	public void setECZY06(String eCZY06) {
		ECZY06 = eCZY06;
	}

	public String getCAHY02() {
		return this.CAHY02;
	}

	public void setCAHY02(String cAHY02) {
		CAHY02 = cAHY02;
	}

	public String getCAHY05() {
		return this.CAHY05;
	}

	public void setCAHY05(String cAHY05) {
		CAHY05 = cAHY05;
	}

	public String getCCMU19() {
		return this.CCMU19;
	}

	public void setCCMU19(String cCMU19) {
		CCMU19 = cCMU19;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof MemberForm)) 
		{
			return false;
		}
		MemberForm rhs = (MemberForm) object;
		return new EqualsBuilder()
		.append(this.CCMU19, rhs.CCMU19)
		.append(this.CAHY05, rhs.CAHY05)
		.append(this.CAHY02, rhs.CAHY02)
		.append(this.ECZY06, rhs.ECZY06)
		.append(this.CCMU02, rhs.CCMU02)
		.append(this.CABQ08N, rhs.CABQ08N)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.CCMU19)
		.append(this.CAHY05)
		.append(this.CAHY02)
		.append(this.ECZY06)
		.append(this.CCMU02)
		.append(this.CABQ08N)
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("CCMU19", this.CCMU19)
		.append("CAHY05", this.CAHY05)
		.append("CAHY02", this.CAHY02)
		.append("ECZY06", this.ECZY06)
		.append("CCMU02", this.CCMU02)
		.append("CABQ08N", this.CABQ08N)
		.toString();
	}
   
  

}