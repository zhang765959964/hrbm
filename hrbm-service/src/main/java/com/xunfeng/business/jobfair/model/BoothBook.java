package com.xunfeng.business.jobfair.model;

import com.xunfeng.core.model.BaseModel;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 摊位预定表 Model对象
* @author:wanghan
* @createDate 2015-09-12 15:43:12 
* @version V1.0   
*/
public class BoothBook extends BaseModel
{
	// 预定状态(1-未安排2-已预占3-预订审核中4-已预订5-招聘中6-已结束)
	public static final String BOOK_STATUS_1="1";
	public static final String BOOK_STATUS_2="2";
	public static final String BOOK_STATUS_3="3";
	public static final String BOOK_STATUS_4="4";
	public static final String BOOK_STATUS_5="5";
	public static final String BOOK_STATUS_6="6";
	// 摊位预定编号
	protected Long  cczy01;
	// 摊位编号
	protected Long  ace200;
	// 摊位号码
	protected String  ace201;
	// IP地址
	protected String  ace209;
	// 场地编号
	protected Long  acd250;
	// 招聘会编号
	protected Long  acb330;
	// 基数
	protected Long  cczy02;
	// 价格
	protected Float  cczy03;
	// 权限
	protected Long  cczy04;
	// 单位编号
	protected Long  aab001;
	// 预定状态(1-未安排2-已预占3-预订审核中4-已预订5-招聘中6-已结束)
	protected String  cczy05;
	// 来源(0-默认1-网站2-窗口3-二级机构)
	protected String  cczy06;
	// 摊位使用时间
	protected java.util.Date  cczy07;
	// 是否预留0-不预留1-预留
	protected String  cczy08;
	// 定时器对其是否有效1-有效0-无效
	protected String  cczy09;
	// 民营职介编号，用于承办
	protected Long  acd200;
	// 发布编号
	protected Long  cczy10;
	// 发布状态
	protected Long  cczy11;
	// 备注
	protected String  cczy12;
	// 最后修改时间
	protected java.util.Date  ccpr05;
	// 修改人
	protected String  ccpr06;
	// 修改来源
	protected String  ccpr07;
	// 是否删除状态（0-否1-是）
	protected String  ccpr08;
	// 招聘信息编号
	protected Long  acb200;
	// 验证码(摊位订单号)
	protected String  cczy13;
	// 岗位描述是否变更（0-否1-是）
	protected Long  cczy14;
	// 是否被占用0-未占用1-占用中
	protected String  cczy15;
	public void setCczy01(Long cczy01) 
	{
		this.cczy01 = cczy01;
	}
	/**
	 * 返回 摊位预定编号
	 * @return
	 */
	public Long getCczy01() 
	{
		return this.cczy01;
	}
	public void setAce200(Long ace200) 
	{
		this.ace200 = ace200;
	}
	/**
	 * 返回 摊位编号
	 * @return
	 */
	public Long getAce200() 
	{
		return this.ace200;
	}
	public void setAce201(String ace201) 
	{
		this.ace201 = ace201;
	}
	/**
	 * 返回 摊位号码
	 * @return
	 */
	public String getAce201() 
	{
		return this.ace201;
	}
	public void setAce209(String ace209) 
	{
		this.ace209 = ace209;
	}
	/**
	 * 返回 IP地址
	 * @return
	 */
	public String getAce209() 
	{
		return this.ace209;
	}
	public void setAcd250(Long acd250) 
	{
		this.acd250 = acd250;
	}
	/**
	 * 返回 场地编号
	 * @return
	 */
	public Long getAcd250() 
	{
		return this.acd250;
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
	public void setCczy02(Long cczy02) 
	{
		this.cczy02 = cczy02;
	}
	/**
	 * 返回 基数
	 * @return
	 */
	public Long getCczy02() 
	{
		return this.cczy02;
	}
	public void setCczy03(Float cczy03) 
	{
		this.cczy03 = cczy03;
	}
	/**
	 * 返回 价格
	 * @return
	 */
	public Float getCczy03() 
	{
		return this.cczy03;
	}
	public void setCczy04(Long cczy04) 
	{
		this.cczy04 = cczy04;
	}
	/**
	 * 返回 权限
	 * @return
	 */
	public Long getCczy04() 
	{
		return this.cczy04;
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
	public void setCczy05(String cczy05) 
	{
		this.cczy05 = cczy05;
	}
	/**
	 * 返回 预定状态(1-未安排2-已预占3-预订审核中4-已预订5-招聘中6-已结束)
	 * @return
	 */
	public String getCczy05() 
	{
		return this.cczy05;
	}
	public void setCczy06(String cczy06) 
	{
		this.cczy06 = cczy06;
	}
	/**
	 * 返回 来源(0-默认1-网站2-窗口3-二级机构)
	 * @return
	 */
	public String getCczy06() 
	{
		return this.cczy06;
	}
	public void setCczy07(java.util.Date cczy07) 
	{
		this.cczy07 = cczy07;
	}
	/**
	 * 返回 摊位使用时间
	 * @return
	 */
	public java.util.Date getCczy07() 
	{
		return this.cczy07;
	}
	public void setCczy08(String cczy08) 
	{
		this.cczy08 = cczy08;
	}
	/**
	 * 返回 是否预留0-不预留1-预留
	 * @return
	 */
	public String getCczy08() 
	{
		return this.cczy08;
	}
	public void setCczy09(String cczy09) 
	{
		this.cczy09 = cczy09;
	}
	/**
	 * 返回 定时器对其是否有效1-有效0-无效
	 * @return
	 */
	public String getCczy09() 
	{
		return this.cczy09;
	}
	public void setAcd200(Long acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 民营职介编号，用于承办
	 * @return
	 */
	public Long getAcd200() 
	{
		return this.acd200;
	}
	public void setCczy10(Long cczy10) 
	{
		this.cczy10 = cczy10;
	}
	/**
	 * 返回 发布编号
	 * @return
	 */
	public Long getCczy10() 
	{
		return this.cczy10;
	}
	public void setCczy11(Long cczy11) 
	{
		this.cczy11 = cczy11;
	}
	/**
	 * 返回 发布状态
	 * @return
	 */
	public Long getCczy11() 
	{
		return this.cczy11;
	}
	public void setCczy12(String cczy12) 
	{
		this.cczy12 = cczy12;
	}
	/**
	 * 返回 备注
	 * @return
	 */
	public String getCczy12() 
	{
		return this.cczy12;
	}
	public void setCcpr05(java.util.Date ccpr05) 
	{
		this.ccpr05 = ccpr05;
	}
	/**
	 * 返回 最后修改时间
	 * @return
	 */
	public java.util.Date getCcpr05() 
	{
		return this.ccpr05;
	}
	public void setCcpr06(String ccpr06) 
	{
		this.ccpr06 = ccpr06;
	}
	/**
	 * 返回 修改人
	 * @return
	 */
	public String getCcpr06() 
	{
		return this.ccpr06;
	}
	public void setCcpr07(String ccpr07) 
	{
		this.ccpr07 = ccpr07;
	}
	/**
	 * 返回 修改来源
	 * @return
	 */
	public String getCcpr07() 
	{
		return this.ccpr07;
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
	public void setAcb200(Long acb200) 
	{
		this.acb200 = acb200;
	}
	/**
	 * 返回 招聘信息编号
	 * @return
	 */
	public Long getAcb200() 
	{
		return this.acb200;
	}
	public void setCczy13(String cczy13) 
	{
		this.cczy13 = cczy13;
	}
	/**
	 * 返回 验证码(摊位订单号)
	 * @return
	 */
	public String getCczy13() 
	{
		return this.cczy13;
	}
	public void setCczy14(Long cczy14) 
	{
		this.cczy14 = cczy14;
	}
	/**
	 * 返回 岗位描述是否变更（0-否1-是）
	 * @return
	 */
	public Long getCczy14() 
	{
		return this.cczy14;
	}
	public void setCczy15(String cczy15) 
	{
		this.cczy15 = cczy15;
	}
	/**
	 * 返回 是否被占用0-未占用1-占用中
	 * @return
	 */
	public String getCczy15() 
	{
		return this.cczy15;
	}

   	/**
	 * @see Object#equals(Object)
	 */
	public boolean equals(Object object)
	{
		if (!(object instanceof BoothBook))
		{
			return false;
		}
		BoothBook rhs = (BoothBook) object;
		return new EqualsBuilder()
		.append(this.cczy01, rhs.cczy01)
		.append(this.ace200, rhs.ace200)
		.append(this.ace201, rhs.ace201)
		.append(this.ace209, rhs.ace209)
		.append(this.acd250, rhs.acd250)
		.append(this.acb330, rhs.acb330)
		.append(this.cczy02, rhs.cczy02)
		.append(this.cczy03, rhs.cczy03)
		.append(this.cczy04, rhs.cczy04)
		.append(this.aab001, rhs.aab001)
		.append(this.cczy05, rhs.cczy05)
		.append(this.cczy06, rhs.cczy06)
		.append(this.cczy07, rhs.cczy07)
		.append(this.cczy08, rhs.cczy08)
		.append(this.cczy09, rhs.cczy09)
		.append(this.acd200, rhs.acd200)
		.append(this.cczy10, rhs.cczy10)
		.append(this.cczy11, rhs.cczy11)
		.append(this.cczy12, rhs.cczy12)
		.append(this.ccpr05, rhs.ccpr05)
		.append(this.ccpr06, rhs.ccpr06)
		.append(this.ccpr07, rhs.ccpr07)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.acb200, rhs.acb200)
		.append(this.cczy13, rhs.cczy13)
		.append(this.cczy14, rhs.cczy14)
		.append(this.cczy15, rhs.cczy15)
		.isEquals();
	}

	/**
	 * @see Object#hashCode()
	 */
	public int hashCode()
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.cczy01)
		.append(this.ace200)
		.append(this.ace201)
		.append(this.ace209)
		.append(this.acd250)
		.append(this.acb330)
		.append(this.cczy02)
		.append(this.cczy03)
		.append(this.cczy04)
		.append(this.aab001)
		.append(this.cczy05)
		.append(this.cczy06)
		.append(this.cczy07)
		.append(this.cczy08)
		.append(this.cczy09)
		.append(this.acd200)
		.append(this.cczy10)
		.append(this.cczy11)
		.append(this.cczy12)
		.append(this.ccpr05)
		.append(this.ccpr06)
		.append(this.ccpr07)
		.append(this.ccpr08)
		.append(this.acb200)
		.append(this.cczy13)
		.append(this.cczy14)
		.append(this.cczy15)
		.toHashCode();
	}

	/**
	 * @see Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("cczy01", this.cczy01) 
		.append("ace200", this.ace200) 
		.append("ace201", this.ace201) 
		.append("ace209", this.ace209) 
		.append("acd250", this.acd250) 
		.append("acb330", this.acb330) 
		.append("cczy02", this.cczy02) 
		.append("cczy03", this.cczy03) 
		.append("cczy04", this.cczy04) 
		.append("aab001", this.aab001) 
		.append("cczy05", this.cczy05) 
		.append("cczy06", this.cczy06) 
		.append("cczy07", this.cczy07) 
		.append("cczy08", this.cczy08) 
		.append("cczy09", this.cczy09) 
		.append("acd200", this.acd200) 
		.append("cczy10", this.cczy10) 
		.append("cczy11", this.cczy11) 
		.append("cczy12", this.cczy12) 
		.append("ccpr05", this.ccpr05) 
		.append("ccpr06", this.ccpr06) 
		.append("ccpr07", this.ccpr07) 
		.append("ccpr08", this.ccpr08) 
		.append("acb200", this.acb200) 
		.append("cczy13", this.cczy13) 
		.append("cczy14", this.cczy14) 
		.append("cczy15", this.cczy15) 
		.toString();
	}
   
  

}