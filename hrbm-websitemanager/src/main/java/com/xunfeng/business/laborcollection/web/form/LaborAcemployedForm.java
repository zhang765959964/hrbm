package com.xunfeng.business.laborcollection.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.laborcollection.model.LaborAcemployed;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 未就业及失业情况信息表 Form对象
* @author:wangyanyan
* @createDate 2016-06-24 11:56:58 
* @version V1.0   
*/
public class LaborAcemployedForm extends BaseForm<LaborAcemployed>
{
	// 就业失业ID
	protected Long  acemp01;
	// 个人编码
	protected Long  aac001;
	// 就业失业登记证号码
	protected String  acc0m1;
	// 单位名称
	protected String  aab004m;
	// 单位性质
	protected String  aab019m;
	// 经济类型
	protected String  aab020m;
	// 未就业及失业人员类别
	protected String  acc20m;
	// 未就业原因（1无就业愿望，2家庭原因，3无就业能力，4正在培训，5没有合适的工作，6年龄偏大，7对找工作丧失信心，8其他原因）
	protected String  accm19;
	// 失业主要原因
	protected String  accm20;
	// 最后一次失业登记时间
	protected java.util.Date  accm21;
	// 上一次劳动合同终止或解除时间
	protected java.util.Date  accm22;
	// 经劳动部门认定的困难群体
	protected String  accm23;
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
	public void setAcemp01(Long acemp01) 
	{
		this.acemp01 = acemp01;
	}
	/**
	 * 返回 就业失业ID
	 * @return
	 */
	public Long getAcemp01() 
	{
		return this.acemp01;
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
	public void setAab004m(String aab004m) 
	{
		this.aab004m = aab004m;
	}
	/**
	 * 返回 单位名称
	 * @return
	 */
	public String getAab004m() 
	{
		return this.aab004m;
	}
	public void setAab019m(String aab019m) 
	{
		this.aab019m = aab019m;
	}
	/**
	 * 返回 单位性质
	 * @return
	 */
	public String getAab019m() 
	{
		return this.aab019m;
	}
	public void setAab020m(String aab020m) 
	{
		this.aab020m = aab020m;
	}
	/**
	 * 返回 经济类型
	 * @return
	 */
	public String getAab020m() 
	{
		return this.aab020m;
	}
	public void setAcc20m(String acc20m) 
	{
		this.acc20m = acc20m;
	}
	/**
	 * 返回 未就业及失业人员类别
	 * @return
	 */
	public String getAcc20m() 
	{
		return this.acc20m;
	}
	public void setAccm19(String accm19) 
	{
		this.accm19 = accm19;
	}
	/**
	 * 返回 未就业原因（1无就业愿望，2家庭原因，3无就业能力，4正在培训，5没有合适的工作，6年龄偏大，7对找工作丧失信心，8其他原因）
	 * @return
	 */
	public String getAccm19() 
	{
		return this.accm19;
	}
	public void setAccm20(String accm20) 
	{
		this.accm20 = accm20;
	}
	/**
	 * 返回 失业主要原因
	 * @return
	 */
	public String getAccm20() 
	{
		return this.accm20;
	}
	public void setAccm21(java.util.Date accm21) 
	{
		this.accm21 = accm21;
	}
	/**
	 * 返回 最后一次失业登记时间
	 * @return
	 */
	public java.util.Date getAccm21() 
	{
		return this.accm21;
	}
	public void setAccm22(java.util.Date accm22) 
	{
		this.accm22 = accm22;
	}
	/**
	 * 返回 上一次劳动合同终止或解除时间
	 * @return
	 */
	public java.util.Date getAccm22() 
	{
		return this.accm22;
	}
	public void setAccm23(String accm23) 
	{
		this.accm23 = accm23;
	}
	/**
	 * 返回 经劳动部门认定的困难群体
	 * @return
	 */
	public String getAccm23() 
	{
		return this.accm23;
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
		if (!(object instanceof LaborAcemployedForm)) 
		{
			return false;
		}
		LaborAcemployedForm rhs = (LaborAcemployedForm) object;
		return new EqualsBuilder()
		.append(this.acemp01, rhs.acemp01)
		.append(this.aac001, rhs.aac001)
		.append(this.acc0m1, rhs.acc0m1)
		.append(this.aab004m, rhs.aab004m)
		.append(this.aab019m, rhs.aab019m)
		.append(this.aab020m, rhs.aab020m)
		.append(this.acc20m, rhs.acc20m)
		.append(this.accm19, rhs.accm19)
		.append(this.accm20, rhs.accm20)
		.append(this.accm21, rhs.accm21)
		.append(this.accm22, rhs.accm22)
		.append(this.accm23, rhs.accm23)
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
		.append(this.acemp01) 
		.append(this.aac001) 
		.append(this.acc0m1) 
		.append(this.aab004m) 
		.append(this.aab019m) 
		.append(this.aab020m) 
		.append(this.acc20m) 
		.append(this.accm19) 
		.append(this.accm20) 
		.append(this.accm21) 
		.append(this.accm22) 
		.append(this.accm23) 
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
		.append("acemp01", this.acemp01) 
		.append("aac001", this.aac001) 
		.append("acc0m1", this.acc0m1) 
		.append("aab004m", this.aab004m) 
		.append("aab019m", this.aab019m) 
		.append("aab020m", this.aab020m) 
		.append("acc20m", this.acc20m) 
		.append("accm19", this.accm19) 
		.append("accm20", this.accm20) 
		.append("accm21", this.accm21) 
		.append("accm22", this.accm22) 
		.append("accm23", this.accm23) 
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