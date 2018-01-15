package com.xunfeng.business.laborcollection.web.form;
import com.xunfeng.core.model.BaseForm;
import com.xunfeng.business.laborcollection.model.LaborAccom;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 就业情况信息表 Form对象
* @author:wangyanyan
* @createDate 2016-06-23 10:29:15 
* @version V1.0   
*/
public class LaborAccomForm extends BaseForm<LaborAccom>
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
	// 就业失业情况（1-就业，2-不在岗，3-未就业及失业，4-服刑，5-出国定居，6-在学）
	protected String  acc0m;
	protected Long  acpost01;
	protected Long  acemp01;
	/** 未就业及失业情况信息表 **/
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
	/**不在岗情况信息表**/
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
	
	public void setAcc0m01(Long acc0m01) 
	{
		this.acc0m01 = acc0m01;
	}
	
	public String getAcc0m() {
		return this.acc0m;
	}

	public void setAcc0m(String acc0m) {
		this.acc0m = acc0m;
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
   	public Long getAcpost01() {
		return this.acpost01;
	}

	public void setAcpost01(Long acpost01) {
		this.acpost01 = acpost01;
	}

	public Long getAcemp01() {
		return this.acemp01;
	}

	public void setAcemp01(Long acemp01) {
		this.acemp01 = acemp01;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof LaborAccomForm)) 
		{
			return false;
		}
		LaborAccomForm rhs = (LaborAccomForm) object;
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
		.append(this.aab004m, rhs.aab004m)
		.append(this.aab019m, rhs.aab019m)
		.append(this.aab020m, rhs.aab020m)
		.append(this.acc20m, rhs.acc20m)
		.append(this.accm19, rhs.accm19)
		.append(this.accm20, rhs.accm20)
		.append(this.accm21, rhs.accm21)
		.append(this.accm22, rhs.accm22)
		.append(this.accm23, rhs.accm23)
		.append(this.aab004t, rhs.aab004t)
		.append(this.aab019t, rhs.aab019t)
		.append(this.aab020t, rhs.aab020t)
		.append(this.accm14, rhs.accm14)
		.append(this.accm15, rhs.accm15)
		.append(this.accm16, rhs.accm16)
		.append(this.accm17, rhs.accm17)
		.append(this.accm18, rhs.accm18)
		.append(this.acc0m, rhs.acc0m)
		.append(this.acemp01, rhs.acemp01)
		.append(this.acpost01, rhs.acpost01)
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
		.append(this.aab004t) 
		.append(this.aab019t) 
		.append(this.aab020t) 
		.append(this.accm14) 
		.append(this.accm15) 
		.append(this.accm16) 
		.append(this.accm17) 
		.append(this.accm18)
		.append(this.aab004m) 
		.append(this.aab019m) 
		.append(this.aab020m) 
		.append(this.acc20m) 
		.append(this.accm19) 
		.append(this.accm20) 
		.append(this.accm21) 
		.append(this.accm22) 
		.append(this.accm23) 
		.append(this.acc0m)
		.append(this.acemp01)
		.append(this.acpost01)
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
		.append("aab004t", this.aab004t) 
		.append("aab019t", this.aab019t) 
		.append("aab020t", this.aab020t) 
		.append("accm14", this.accm14) 
		.append("accm15", this.accm15) 
		.append("accm16", this.accm16) 
		.append("accm17", this.accm17) 
		.append("accm18", this.accm18)
		.append("aab004m", this.aab004m) 
		.append("aab019m", this.aab019m) 
		.append("aab020m", this.aab020m) 
		.append("acc20m", this.acc20m) 
		.append("accm19", this.accm19) 
		.append("accm20", this.accm20) 
		.append("accm21", this.accm21) 
		.append("accm22", this.accm22) 
		.append("accm23", this.accm23) 
		.append("acc0m", this.acc0m) 
		.append("acemp01", this.acemp01) 
		.append("acpost01", this.acpost01) 
		.toString();
	}
   
  

}