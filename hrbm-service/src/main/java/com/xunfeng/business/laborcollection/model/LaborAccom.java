package com.xunfeng.business.laborcollection.model;
import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 就业情况信息表 Model对象
* @author:wangyanyan
* @createDate 2016-06-08 10:47:45 
* @version V1.0   
*/
public class LaborAccom extends BaseModel
{
	// 就业失业ID
	protected Long  acc0m01;
	// 个人编码
	protected Long  aac001;
	// 就业失业情况
	protected String  acc0m1;
	// 单位名称
	protected String  aab004;
	// 单位性质
	protected String  aab019;
	// 产业类别
	protected String  aab054;
	// 经济类型
	protected String  aab020;
	// 就业形势
	protected String  accm02;
	// 就业时间
	protected java.util.Date  accm03;
	// 签订劳动合同情况（1是2否）
	protected String  accm04;
	// 合同开始时间
	protected java.util.Date  accm05;
	// 合同结束时间
	protected java.util.Date  accm06;
	// 合同情况（1本县内，2本镇内，3本镇外，4本市外区，5出国务工，6外省市）
	protected String  accm07;
	// 出国务工外出时间
	protected java.util.Date  accm08;
	// 外省市外出时间
	protected java.util.Date  accm09;
	// 外省市工作地点代码
	protected String  accm10;
	// 对目前工作是否满意（1是，2否）
	protected String  accm11;
	// 对工作不满意的原因
	protected String  accm12;
	// 人员类别
	protected String  acc20t;
	// 灵活就业类别（1企业零散用工，2弹性就业3家政服务，4自由职业5街头自营，6打零工，7其他）
	protected String  accm13;
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
	public void setAcc0m01(Long acc0m01) 
	{
		this.acc0m01 = acc0m01;
	}
	/**
	 * 返回 就业失业ID
	 * @return
	 */
	public Long getAcc0m01() 
	{
		return this.acc0m01;
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
	 * 返回 就业失业情况
	 * @return
	 */
	public String getAcc0m1() 
	{
		return this.acc0m1;
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
	public void setAab019(String aab019) 
	{
		this.aab019 = aab019;
	}
	/**
	 * 返回 单位性质
	 * @return
	 */
	public String getAab019() 
	{
		return this.aab019;
	}
	public void setAab054(String aab054) 
	{
		this.aab054 = aab054;
	}
	/**
	 * 返回 产业类别
	 * @return
	 */
	public String getAab054() 
	{
		return this.aab054;
	}
	public void setAab020(String aab020) 
	{
		this.aab020 = aab020;
	}
	/**
	 * 返回 经济类型
	 * @return
	 */
	public String getAab020() 
	{
		return this.aab020;
	}
	public void setAccm02(String accm02) 
	{
		this.accm02 = accm02;
	}
	/**
	 * 返回 就业形势
	 * @return
	 */
	public String getAccm02() 
	{
		return this.accm02;
	}
	public void setAccm03(java.util.Date accm03) 
	{
		this.accm03 = accm03;
	}
	/**
	 * 返回 就业时间
	 * @return
	 */
	public java.util.Date getAccm03() 
	{
		return this.accm03;
	}
	public void setAccm04(String accm04) 
	{
		this.accm04 = accm04;
	}
	/**
	 * 返回 签订劳动合同情况（1是2否）
	 * @return
	 */
	public String getAccm04() 
	{
		return this.accm04;
	}
	public void setAccm05(java.util.Date accm05) 
	{
		this.accm05 = accm05;
	}
	/**
	 * 返回 合同开始时间
	 * @return
	 */
	public java.util.Date getAccm05() 
	{
		return this.accm05;
	}
	public void setAccm06(java.util.Date accm06) 
	{
		this.accm06 = accm06;
	}
	/**
	 * 返回 合同结束时间
	 * @return
	 */
	public java.util.Date getAccm06() 
	{
		return this.accm06;
	}
	public void setAccm07(String accm07) 
	{
		this.accm07 = accm07;
	}
	/**
	 * 返回 合同情况（1本县内，2本镇内，3本镇外，4本市外区，5出国务工，6外省市）
	 * @return
	 */
	public String getAccm07() 
	{
		return this.accm07;
	}
	public void setAccm08(java.util.Date accm08) 
	{
		this.accm08 = accm08;
	}
	/**
	 * 返回 出国务工外出时间
	 * @return
	 */
	public java.util.Date getAccm08() 
	{
		return this.accm08;
	}
	public void setAccm09(java.util.Date accm09) 
	{
		this.accm09 = accm09;
	}
	/**
	 * 返回 外省市外出时间
	 * @return
	 */
	public java.util.Date getAccm09() 
	{
		return this.accm09;
	}
	public void setAccm10(String accm10) 
	{
		this.accm10 = accm10;
	}
	/**
	 * 返回 外省市工作地点代码
	 * @return
	 */
	public String getAccm10() 
	{
		return this.accm10;
	}
	public void setAccm11(String accm11) 
	{
		this.accm11 = accm11;
	}
	/**
	 * 返回 对目前工作是否满意（1是，2否）
	 * @return
	 */
	public String getAccm11() 
	{
		return this.accm11;
	}
	public void setAccm12(String accm12) 
	{
		this.accm12 = accm12;
	}
	/**
	 * 返回 对工作不满意的原因
	 * @return
	 */
	public String getAccm12() 
	{
		return this.accm12;
	}
	public void setAcc20t(String acc20t) 
	{
		this.acc20t = acc20t;
	}
	/**
	 * 返回 人员类别
	 * @return
	 */
	public String getAcc20t() 
	{
		return this.acc20t;
	}
	public void setAccm13(String accm13) 
	{
		this.accm13 = accm13;
	}
	/**
	 * 返回 灵活就业类别（1企业零散用工，2弹性就业3家政服务，4自由职业5街头自营，6打零工，7其他）
	 * @return
	 */
	public String getAccm13() 
	{
		return this.accm13;
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
		if (!(object instanceof LaborAccom)) 
		{
			return false;
		}
		LaborAccom rhs = (LaborAccom) object;
		return new EqualsBuilder()
		.append(this.acc0m01, rhs.acc0m01)
		.append(this.aac001, rhs.aac001)
		.append(this.acc0m1, rhs.acc0m1)
		.append(this.aab004, rhs.aab004)
		.append(this.aab019, rhs.aab019)
		.append(this.aab054, rhs.aab054)
		.append(this.aab020, rhs.aab020)
		.append(this.accm02, rhs.accm02)
		.append(this.accm03, rhs.accm03)
		.append(this.accm04, rhs.accm04)
		.append(this.accm05, rhs.accm05)
		.append(this.accm06, rhs.accm06)
		.append(this.accm07, rhs.accm07)
		.append(this.accm08, rhs.accm08)
		.append(this.accm09, rhs.accm09)
		.append(this.accm10, rhs.accm10)
		.append(this.accm11, rhs.accm11)
		.append(this.accm12, rhs.accm12)
		.append(this.acc20t, rhs.acc20t)
		.append(this.accm13, rhs.accm13)
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
		.append(this.acc0m01) 
		.append(this.aac001) 
		.append(this.acc0m1) 
		.append(this.aab004) 
		.append(this.aab019) 
		.append(this.aab054) 
		.append(this.aab020) 
		.append(this.accm02) 
		.append(this.accm03) 
		.append(this.accm04) 
		.append(this.accm05) 
		.append(this.accm06) 
		.append(this.accm07) 
		.append(this.accm08) 
		.append(this.accm09) 
		.append(this.accm10) 
		.append(this.accm11) 
		.append(this.accm12) 
		.append(this.acc20t) 
		.append(this.accm13) 
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
		.append("acc0m01", this.acc0m01) 
		.append("aac001", this.aac001) 
		.append("acc0m1", this.acc0m1) 
		.append("aab004", this.aab004) 
		.append("aab019", this.aab019) 
		.append("aab054", this.aab054) 
		.append("aab020", this.aab020) 
		.append("accm02", this.accm02) 
		.append("accm03", this.accm03) 
		.append("accm04", this.accm04) 
		.append("accm05", this.accm05) 
		.append("accm06", this.accm06) 
		.append("accm07", this.accm07) 
		.append("accm08", this.accm08) 
		.append("accm09", this.accm09) 
		.append("accm10", this.accm10) 
		.append("accm11", this.accm11) 
		.append("accm12", this.accm12) 
		.append("acc20t", this.acc20t) 
		.append("accm13", this.accm13) 
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