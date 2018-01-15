package com.xunfeng.business.jobfair.model;
import java.util.Date;

import com.xunfeng.core.model.BaseModel;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 摊位退订表 Model对象
* @author:wanghan
* @createDate 2016-04-26 10:44:30 
* @version V1.0   
*/
public class BoothUnsubscribe extends BaseModel
{
	// 预定状态(1-未安排2-已预占3-预订审核中4-已预订5-招聘中6-已结束)
	public static final Long BOOK_PACKAGE_1=1L;
	// 摊位退订编号 
	protected Long  cczt01;
	// 摊位预订编号
	protected Long  cczy01;
	// 单位编号
	protected Long  aab001;
	// 招聘会编号
	protected Long  acb330;
	// 订单金额
	protected Float  cczy03;
	// 退款经办人代码
	protected String  cczt02;
	// 退款经办人
	protected String  cczt03;
	// 退款经办机构代码
	protected String  cczt04;
	// 退款经办机构
	protected String  cczt05;
	// 退款经办日期
	protected java.util.Date  cczt06=new Date();
	// 应退金额
	protected Float  cczt07;
	// 退款手续费
	protected Float  cczt08;
	// 实退金额
	protected Float  cczt17;
	// 扣款原因
	protected String  cczt18;
	// 退定经办人代码
	protected String  cczt09;
	// 退定经办人
	protected String  cczt10;
	// 退定经办机构代码
	protected String  cczt11;
	// 退定经办机构
	protected String  cczt12;
	// 退定经办日期
	protected java.util.Date  cczt13;
	// 摊位退订状态
	protected String  cczt14;
	// 备注
	protected String  cczt15;
	// 退订申请日期
	protected java.util.Date  cczt16;
	// 支付记录编号（用于橱窗退费）
	protected Long  cczz01;
	// 招聘套餐编号
	protected Long  catc01;
	public void setCczt01(Long cczt01) 
	{
		this.cczt01 = cczt01;
	}
	/**
	 * 返回 摊位退订编号 
	 * @return
	 */
	public Long getCczt01() 
	{
		return this.cczt01;
	}
	public void setCczy01(Long cczy01) 
	{
		this.cczy01 = cczy01;
	}
	/**
	 * 返回 摊位预订编号
	 * @return
	 */
	public Long getCczy01() 
	{
		return this.cczy01;
	}
	public void setAab001(Long aab001) 
	{
		this.aab001 = aab001;
	}
	/**
	 * 返回 单位编号
	 * @return
	 */
	public Long getAab001() 
	{
		return this.aab001;
	}
	public void setAcb330(Long acb330) 
	{
		this.acb330 = acb330;
	}
	/**
	 * 返回 招聘会编号
	 * @return
	 */
	public Long getAcb330() 
	{
		return this.acb330;
	}
	public void setCczy03(Float cczy03) 
	{
		this.cczy03 = cczy03;
	}
	/**
	 * 返回 订单金额
	 * @return
	 */
	public Float getCczy03() 
	{
		return this.cczy03;
	}
	public void setCczt02(String cczt02) 
	{
		this.cczt02 = cczt02;
	}
	/**
	 * 返回 退款经办人代码
	 * @return
	 */
	public String getCczt02() 
	{
		return this.cczt02;
	}
	public void setCczt03(String cczt03) 
	{
		this.cczt03 = cczt03;
	}
	/**
	 * 返回 退款经办人
	 * @return
	 */
	public String getCczt03() 
	{
		return this.cczt03;
	}
	public void setCczt04(String cczt04) 
	{
		this.cczt04 = cczt04;
	}
	/**
	 * 返回 退款经办机构代码
	 * @return
	 */
	public String getCczt04() 
	{
		return this.cczt04;
	}
	public void setCczt05(String cczt05) 
	{
		this.cczt05 = cczt05;
	}
	/**
	 * 返回 退款经办机构
	 * @return
	 */
	public String getCczt05() 
	{
		return this.cczt05;
	}
	public void setCczt06(java.util.Date cczt06) 
	{
		this.cczt06 = cczt06;
	}
	/**
	 * 返回 退款经办日期
	 * @return
	 */
	public java.util.Date getCczt06() 
	{
		return this.cczt06;
	}
	public void setCczt07(Float cczt07) 
	{
		this.cczt07 = cczt07;
	}
	/**
	 * 返回 应退金额
	 * @return
	 */
	public Float getCczt07() 
	{
		return this.cczt07;
	}
	public void setCczt08(Float cczt08) 
	{
		this.cczt08 = cczt08;
	}
	/**
	 * 返回 退款手续费
	 * @return
	 */
	public Float getCczt08() 
	{
		return this.cczt08;
	}
	public void setCczt17(Float cczt17) 
	{
		this.cczt17 = cczt17;
	}
	/**
	 * 返回 实退金额
	 * @return
	 */
	public Float getCczt17() 
	{
		return this.cczt17;
	}
	public void setCczt18(String cczt18) 
	{
		this.cczt18 = cczt18;
	}
	/**
	 * 返回 扣款原因
	 * @return
	 */
	public String getCczt18() 
	{
		return this.cczt18;
	}
	public void setCczt09(String cczt09) 
	{
		this.cczt09 = cczt09;
	}
	/**
	 * 返回 退定经办人代码
	 * @return
	 */
	public String getCczt09() 
	{
		return this.cczt09;
	}
	public void setCczt10(String cczt10) 
	{
		this.cczt10 = cczt10;
	}
	/**
	 * 返回 退定经办人
	 * @return
	 */
	public String getCczt10() 
	{
		return this.cczt10;
	}
	public void setCczt11(String cczt11) 
	{
		this.cczt11 = cczt11;
	}
	/**
	 * 返回 退定经办机构代码
	 * @return
	 */
	public String getCczt11() 
	{
		return this.cczt11;
	}
	public void setCczt12(String cczt12) 
	{
		this.cczt12 = cczt12;
	}
	/**
	 * 返回 退定经办机构
	 * @return
	 */
	public String getCczt12() 
	{
		return this.cczt12;
	}
	public void setCczt13(java.util.Date cczt13) 
	{
		this.cczt13 = cczt13;
	}
	/**
	 * 返回 退定经办日期
	 * @return
	 */
	public java.util.Date getCczt13() 
	{
		return this.cczt13;
	}
	public void setCczt14(String cczt14) 
	{
		this.cczt14 = cczt14;
	}
	/**
	 * 返回 摊位退订状态
	 * @return
	 */
	public String getCczt14() 
	{
		return this.cczt14;
	}
	public void setCczt15(String cczt15) 
	{
		this.cczt15 = cczt15;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getCczt15() 
	{
		return this.cczt15;
	}
	public void setCczt16(java.util.Date cczt16) 
	{
		this.cczt16 = cczt16;
	}
	/**
	 * 返回 退订申请日期
	 * @return
	 */
	public java.util.Date getCczt16() 
	{
		return this.cczt16;
	}
	public void setCczz01(Long cczz01) 
	{
		this.cczz01 = cczz01;
	}
	/**
	 * 返回 支付记录编号（用于橱窗退费）
	 * @return
	 */
	public Long getCczz01() 
	{
		return this.cczz01;
	}
	public void setCatc01(Long catc01) 
	{
		this.catc01 = catc01;
	}
	/**
	 * 返回 招聘套餐编号
	 * @return
	 */
	public Long getCatc01() 
	{
		return this.catc01;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof BoothUnsubscribe)) 
		{
			return false;
		}
		BoothUnsubscribe rhs = (BoothUnsubscribe) object;
		return new EqualsBuilder()
		.append(this.cczt01, rhs.cczt01)
		.append(this.cczy01, rhs.cczy01)
		.append(this.aab001, rhs.aab001)
		.append(this.acb330, rhs.acb330)
		.append(this.cczy03, rhs.cczy03)
		.append(this.cczt02, rhs.cczt02)
		.append(this.cczt03, rhs.cczt03)
		.append(this.cczt04, rhs.cczt04)
		.append(this.cczt05, rhs.cczt05)
		.append(this.cczt06, rhs.cczt06)
		.append(this.cczt07, rhs.cczt07)
		.append(this.cczt08, rhs.cczt08)
		.append(this.cczt17, rhs.cczt17)
		.append(this.cczt18, rhs.cczt18)
		.append(this.cczt09, rhs.cczt09)
		.append(this.cczt10, rhs.cczt10)
		.append(this.cczt11, rhs.cczt11)
		.append(this.cczt12, rhs.cczt12)
		.append(this.cczt13, rhs.cczt13)
		.append(this.cczt14, rhs.cczt14)
		.append(this.cczt15, rhs.cczt15)
		.append(this.cczt16, rhs.cczt16)
		.append(this.cczz01, rhs.cczz01)
		.append(this.catc01, rhs.catc01)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.cczt01) 
		.append(this.cczy01) 
		.append(this.aab001) 
		.append(this.acb330) 
		.append(this.cczy03) 
		.append(this.cczt02) 
		.append(this.cczt03) 
		.append(this.cczt04) 
		.append(this.cczt05) 
		.append(this.cczt06) 
		.append(this.cczt07) 
		.append(this.cczt08) 
		.append(this.cczt17) 
		.append(this.cczt18) 
		.append(this.cczt09) 
		.append(this.cczt10) 
		.append(this.cczt11) 
		.append(this.cczt12) 
		.append(this.cczt13) 
		.append(this.cczt14) 
		.append(this.cczt15) 
		.append(this.cczt16) 
		.append(this.cczz01) 
		.append(this.catc01) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("cczt01", this.cczt01) 
		.append("cczy01", this.cczy01) 
		.append("aab001", this.aab001) 
		.append("acb330", this.acb330) 
		.append("cczy03", this.cczy03) 
		.append("cczt02", this.cczt02) 
		.append("cczt03", this.cczt03) 
		.append("cczt04", this.cczt04) 
		.append("cczt05", this.cczt05) 
		.append("cczt06", this.cczt06) 
		.append("cczt07", this.cczt07) 
		.append("cczt08", this.cczt08) 
		.append("cczt17", this.cczt17) 
		.append("cczt18", this.cczt18) 
		.append("cczt09", this.cczt09) 
		.append("cczt10", this.cczt10) 
		.append("cczt11", this.cczt11) 
		.append("cczt12", this.cczt12) 
		.append("cczt13", this.cczt13) 
		.append("cczt14", this.cczt14) 
		.append("cczt15", this.cczt15) 
		.append("cczt16", this.cczt16) 
		.append("cczz01", this.cczz01) 
		.append("catc01", this.catc01) 
		.toString();
	}
   
  

}