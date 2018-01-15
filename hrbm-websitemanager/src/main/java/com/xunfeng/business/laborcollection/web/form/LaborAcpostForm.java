package com.xunfeng.business.laborcollection.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.laborcollection.model.LaborAcpost;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 不在岗情况信息表 Form对象
* @author:wangyanyan
* @createDate 2016-06-24 09:46:09 
* @version V1.0   
*/
public class LaborAcpostForm extends BaseForm<LaborAcpost>
{
	// 就业失业ID
	protected Long  acpost01;
	// 个人编码
	protected Long  aac001;
	// 就业失业登记证号码
	protected String  acc0m1;
	// 单位名称
	protected String  aab004t;
	// 单位性质
	protected String  aab019t;
	// 经济类型
	protected String  aab020t;
	// 不在岗原因（1、不安排工作岗位，2、轮岗，3、停薪留职，4、办理内退，5其他形式）
	protected String  accm14;
	// 不在岗原因其他形式
	protected String  accm15;
	// 不在岗时间
	protected java.util.Date  accm16;
	// 是否发放生活费（1是，2否）
	protected String  accm17;
	// 生活费标准
	protected String  accm18;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 数据来源0未知1网站2窗口
	protected String  cczy06;
	public void setAcpost01(Long acpost01) 
	{
		this.acpost01 = acpost01;
	}
	/**
	 * 返回 就业失业ID
	 * @return
	 */
	public Long getAcpost01() 
	{
		return this.acpost01;
	}
	public void setAac001(Long aac001) 
	{
		this.aac001 = aac001;
	}
	/**
	 * 返回 个人编码
	 * @return
	 */
	public Long getAac001() 
	{
		return this.aac001;
	}
	public void setAcc0m1(String acc0m1) 
	{
		this.acc0m1 = acc0m1;
	}
	/**
	 * 返回 就业失业登记证号码
	 * @return
	 */
	public String getAcc0m1() 
	{
		return this.acc0m1;
	}
	public void setAab004t(String aab004t) 
	{
		this.aab004t = aab004t;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004t() 
	{
		return this.aab004t;
	}
	public void setAab019t(String aab019t) 
	{
		this.aab019t = aab019t;
	}
	/**
	 * 返回 单位性质
	 * @return
	 */
	public String getAab019t() 
	{
		return this.aab019t;
	}
	public void setAab020t(String aab020t) 
	{
		this.aab020t = aab020t;
	}
	/**
	 * 返回 经济类型
	 * @return
	 */
	public String getAab020t() 
	{
		return this.aab020t;
	}
	public void setAccm14(String accm14) 
	{
		this.accm14 = accm14;
	}
	/**
	 * 返回 不在岗原因（1、不安排工作岗位，2、轮岗，3、停薪留职，4、办理内退，5其他形式）
	 * @return
	 */
	public String getAccm14() 
	{
		return this.accm14;
	}
	public void setAccm15(String accm15) 
	{
		this.accm15 = accm15;
	}
	/**
	 * 返回 不在岗原因其他形式
	 * @return
	 */
	public String getAccm15() 
	{
		return this.accm15;
	}
	public void setAccm16(java.util.Date accm16) 
	{
		this.accm16 = accm16;
	}
	/**
	 * 返回 不在岗时间
	 * @return
	 */
	public java.util.Date getAccm16() 
	{
		return this.accm16;
	}
	public void setAccm17(String accm17) 
	{
		this.accm17 = accm17;
	}
	/**
	 * 返回 是否发放生活费（1是，2否）
	 * @return
	 */
	public String getAccm17() 
	{
		return this.accm17;
	}
	public void setAccm18(String accm18) 
	{
		this.accm18 = accm18;
	}
	/**
	 * 返回 生活费标准
	 * @return
	 */
	public String getAccm18() 
	{
		return this.accm18;
	}
	public void setAae011(String aae011) 
	{
		this.aae011 = aae011;
	}
	/**
	 * 返回 经办人代码
	 * @return
	 */
	public String getAae011() 
	{
		return this.aae011;
	}
	public void setAae017(String aae017) 
	{
		this.aae017 = aae017;
	}
	/**
	 * 返回 经办机构代码
	 * @return
	 */
	public String getAae017() 
	{
		return this.aae017;
	}
	public void setAae036(java.util.Date aae036) 
	{
		this.aae036 = aae036;
	}
	/**
	 * 返回 经办日期
	 * @return
	 */
	public java.util.Date getAae036() 
	{
		return this.aae036;
	}
	public void setAae019(String aae019) 
	{
		this.aae019 = aae019;
	}
	/**
	 * 返回 经办人
	 * @return
	 */
	public String getAae019() 
	{
		return this.aae019;
	}
	public void setAae020(String aae020) 
	{
		this.aae020 = aae020;
	}
	/**
	 * 返回 经办机构
	 * @return
	 */
	public String getAae020() 
	{
		return this.aae020;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 是否删除状态（0-否1-是）
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 数据来源0未知1网站2窗口
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof LaborAcpostForm)) 
		{
			return false;
		}
		LaborAcpostForm rhs = (LaborAcpostForm) object;
		return new EqualsBuilder()
		.append(this.acpost01, rhs.acpost01)
		.append(this.aac001, rhs.aac001)
		.append(this.acc0m1, rhs.acc0m1)
		.append(this.aab004t, rhs.aab004t)
		.append(this.aab019t, rhs.aab019t)
		.append(this.aab020t, rhs.aab020t)
		.append(this.accm14, rhs.accm14)
		.append(this.accm15, rhs.accm15)
		.append(this.accm16, rhs.accm16)
		.append(this.accm17, rhs.accm17)
		.append(this.accm18, rhs.accm18)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.cczy06, rhs.cczy06)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acpost01) 
		.append(this.aac001) 
		.append(this.acc0m1) 
		.append(this.aab004t) 
		.append(this.aab019t) 
		.append(this.aab020t) 
		.append(this.accm14) 
		.append(this.accm15) 
		.append(this.accm16) 
		.append(this.accm17) 
		.append(this.accm18) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.ccpr08) 
		.append(this.cczy06) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acpost01", this.acpost01) 
		.append("aac001", this.aac001) 
		.append("acc0m1", this.acc0m1) 
		.append("aab004t", this.aab004t) 
		.append("aab019t", this.aab019t) 
		.append("aab020t", this.aab020t) 
		.append("accm14", this.accm14) 
		.append("accm15", this.accm15) 
		.append("accm16", this.accm16) 
		.append("accm17", this.accm17) 
		.append("accm18", this.accm18) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("ccpr08", this.ccpr08) 
		.append("cczy06", this.cczy06) 
		.toString();
	}
   
  

}