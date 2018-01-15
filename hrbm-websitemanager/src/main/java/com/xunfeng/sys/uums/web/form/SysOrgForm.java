package com.xunfeng.sys.uums.web.form;

import com.xunfeng.core.model.BaseForm;
import com.xunfeng.sys.uums.model.SysOrg;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 职介机构表 Form对象
 * @author:liwenhao
 * @createDate 2016-06-16 09:33:17
 * @version V1.0
 */
public class SysOrgForm extends BaseForm<SysOrg> {
	/**
*
*/
	private static final long serialVersionUID = -8026486573533200927L;
	// 职介机构编号
	protected Long acd200;
	// 许可证编号
	protected String acd201;
	// 职介机构名称
	protected String acd202;
	// 场所地址
	protected String aae006;
	// 邮政编码
	protected String aae007;
	// 机构类别
	protected String acd203;
	// 机构性质
	protected String acd204;
	// 许可证经营范围
	protected String acd205;
	// 申请业务范围
	// 经费来源
	protected String acd206;
	// 机构法定负责人
	protected String aab013;
	// 法人公司身份证号码
	protected String aab014;
	// 法人联系电话
	protected String aab015;
	// 住址
	// 场所面积
	protected String acd20b;
	// 设备设施
	protected String acd20c;
	// 人员规模
	protected String aab056;
	// 工作人员数
	protected Long acd20d;
	// 其中持证人员数
	protected Long acd20e;
	// 设立固定招聘场所个数

	protected Long acd20f;
	// 建立人力资源服务网站个数

	protected Long acd20g;
	// 注册资金(万元)
	protected Float aab049;
	// 注册机关
	protected String acd20m;

	// 机构所在行政区划
	protected String aab201;
	// 机构所在行政区划代码
	protected String aab301;
	// 公开服务电话
	protected String acd20a;
	// 联系人
	protected String aae004;
	// 联系电话
	protected String aae005;
	// 有效期
	protected java.util.Date acd20k;
	// 父级机构代码
	protected String aab034;
	// 父级机构名称
	protected String aae044;
	// 信用等级
	protected String acd20u;

	// 乘车路线
	protected String ccmu04;

	// 职介机构别名
	protected String bcd202;
	// 机构对应数据来源
	// 是否应用OA 0:不应用 1:应用
	// 机构分类编号 1:职介中心 2:公办 3:高校
	protected String acd20s;
    //X坐标
	protected String cabq02;
	//Y坐标
	protected String cabq03;
	public Long getAcd200() {
		return acd200;
	}
	public String getCabq02() {
		return cabq02;
	}

	public void setCabq02(String cabq02) {
		this.cabq02 = cabq02;
	}

	public String getCabq03() {
		return cabq03;
	}

	public void setCabq03(String cabq03) {
		this.cabq03 = cabq03;
	}

	public void setAcd200(Long acd200) {
		this.acd200 = acd200;
	}

	public String getAcd201() {
		return acd201;
	}

	public String getAab301() {
		return aab301;
	}

	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}

	public void setAcd201(String acd201) {
		this.acd201 = acd201;
	}

	public String getAcd202() {
		return acd202;
	}

	public void setAcd202(String acd202) {
		this.acd202 = acd202;
	}

	public String getAae006() {
		return aae006;
	}

	public void setAae006(String aae006) {
		this.aae006 = aae006;
	}

	public String getAae007() {
		return aae007;
	}

	public void setAae007(String aae007) {
		this.aae007 = aae007;
	}

	public String getAcd203() {
		return acd203;
	}

	public void setAcd203(String acd203) {
		this.acd203 = acd203;
	}

	public String getAcd204() {
		return acd204;
	}

	public void setAcd204(String acd204) {
		this.acd204 = acd204;
	}

	public String getAcd205() {
		return acd205;
	}

	public void setAcd205(String acd205) {
		this.acd205 = acd205;
	}

	public String getAcd206() {
		return acd206;
	}

	public void setAcd206(String acd206) {
		this.acd206 = acd206;
	}

	public String getAab013() {
		return aab013;
	}

	public void setAab013(String aab013) {
		this.aab013 = aab013;
	}

	public String getAab014() {
		return aab014;
	}

	public void setAab014(String aab014) {
		this.aab014 = aab014;
	}

	public String getAab015() {
		return aab015;
	}

	public void setAab015(String aab015) {
		this.aab015 = aab015;
	}

	public String getAcd20b() {
		return acd20b;
	}

	public void setAcd20b(String acd20b) {
		this.acd20b = acd20b;
	}

	public String getAcd20c() {
		return acd20c;
	}

	public void setAcd20c(String acd20c) {
		this.acd20c = acd20c;
	}

	public String getAab056() {
		return aab056;
	}

	public void setAab056(String aab056) {
		this.aab056 = aab056;
	}

	public Long getAcd20d() {
		return acd20d;
	}

	public void setAcd20d(Long acd20d) {
		this.acd20d = acd20d;
	}

	public Long getAcd20e() {
		return acd20e;
	}

	public void setAcd20e(Long acd20e) {
		this.acd20e = acd20e;
	}

	public Long getAcd20f() {
		return acd20f;
	}

	public void setAcd20f(Long acd20f) {
		this.acd20f = acd20f;
	}

	public Long getAcd20g() {
		return acd20g;
	}

	public void setAcd20g(Long acd20g) {
		this.acd20g = acd20g;
	}

	public Float getAab049() {
		return aab049;
	}

	public void setAab049(Float aab049) {
		this.aab049 = aab049;
	}

	public String getAcd20m() {
		return acd20m;
	}

	public void setAcd20m(String acd20m) {
		this.acd20m = acd20m;
	}

	public String getAab201() {
		return aab201;
	}

	public void setAab201(String aab201) {
		this.aab201 = aab201;
	}

	public String getAcd20a() {
		return acd20a;
	}

	public void setAcd20a(String acd20a) {
		this.acd20a = acd20a;
	}

	public String getAae004() {
		return aae004;
	}

	public void setAae004(String aae004) {
		this.aae004 = aae004;
	}

	public String getAae005() {
		return aae005;
	}

	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}

	public java.util.Date getAcd20k() {
		return acd20k;
	}

	public void setAcd20k(java.util.Date acd20k) {
		this.acd20k = acd20k;
	}

	public String getAab034() {
		return aab034;
	}

	public void setAab034(String aab034) {
		this.aab034 = aab034;
	}

	public String getAae044() {
		return aae044;
	}

	public void setAae044(String aae044) {
		this.aae044 = aae044;
	}

	public String getAcd20u() {
		return acd20u;
	}

	public void setAcd20u(String acd20u) {
		this.acd20u = acd20u;
	}

	public String getCcmu04() {
		return ccmu04;
	}

	public void setCcmu04(String ccmu04) {
		this.ccmu04 = ccmu04;
	}

	public String getBcd202() {
		return bcd202;
	}

	public void setBcd202(String bcd202) {
		this.bcd202 = bcd202;
	}

	public String getAcd20s() {
		return acd20s;
	}

	public void setAcd20s(String acd20s) {
		this.acd20s = acd20s;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SysOrgForm)) {
			return false;
		}
		SysOrgForm rhs = (SysOrgForm) object;
		return new EqualsBuilder().append(this.acd200, rhs.acd200)
				.append(this.acd201, rhs.acd201)
				.append(this.acd202, rhs.acd202)
				.append(this.aae006, rhs.aae006)
				.append(this.aae007, rhs.aae007)
				.append(this.acd203, rhs.acd203)
				.append(this.acd204, rhs.acd204)
				.append(this.acd205, rhs.acd205)
				.append(this.acd206, rhs.acd206)
				.append(this.aab013, rhs.aab013)
				.append(this.aab014, rhs.aab014)
				.append(this.aab015, rhs.aab015)
				.append(this.acd20b, rhs.acd20b)
				.append(this.acd20c, rhs.acd20c)
				.append(this.aab056, rhs.aab056)
				.append(this.acd20d, rhs.acd20d)
				.append(this.acd20e, rhs.acd20e)
				.append(this.acd20f, rhs.acd20f)
				.append(this.acd20g, rhs.acd20g)
				.append(this.aab049, rhs.aab049)
				.append(this.acd20m, rhs.acd20m)
				.append(this.aab201, rhs.aab201)
				.append(this.acd20a, rhs.acd20a)
				.append(this.aae004, rhs.aae004)
				.append(this.aae005, rhs.aae005)
				.append(this.acd20k, rhs.acd20k)
				.append(this.aab034, rhs.aab034)
				.append(this.aae044, rhs.aae044)
				.append(this.acd20u, rhs.acd20u)
				.append(this.ccmu04, rhs.ccmu04)
				.append(this.bcd202, rhs.bcd202)
				.append(this.acd20s, rhs.acd20s).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.acd200)
				.append(this.acd201).append(this.acd202).append(this.aae006)
				.append(this.aae007).append(this.acd203).append(this.acd204)
				.append(this.acd205).append(this.acd206).append(this.aab013)
				.append(this.aab014).append(this.aab015).append(this.acd20b)
				.append(this.acd20c).append(this.aab056).append(this.acd20d)
				.append(this.acd20e).append(this.acd20f).append(this.acd20g)
				.append(this.aab049).append(this.acd20m).append(this.aab201)
				.append(this.acd20a).append(this.aae004).append(this.aae005)
				.append(this.acd20k).append(this.aab034).append(this.aae044)
				.append(this.acd20u).append(this.ccmu04).append(this.bcd202)
				.append(this.acd20s).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("acd200", this.acd200)
				.append("acd201", this.acd201).append("acd202", this.acd202)
				.append("aae006", this.aae006).append("aae007", this.aae007)
				.append("acd203", this.acd203).append("acd204", this.acd204)
				.append("acd205", this.acd205).append("acd206", this.acd206)
				.append("aab013", this.aab013).append("aab014", this.aab014)
				.append("aab015", this.aab015).append("acd20b", this.acd20b)
				.append("acd20c", this.acd20c).append("aab056", this.aab056)
				.append("acd20d", this.acd20d).append("acd20e", this.acd20e)
				.append("acd20f", this.acd20f).append("acd20g", this.acd20g)
				.append("aab049", this.aab049).append("acd20m", this.acd20m)
				.append("aab201", this.aab201).append("acd20a", this.acd20a)
				.append("aae004", this.aae004).append("aae005", this.aae005)
				.append("acd20k", this.acd20k).append("aab034", this.aab034)
				.append("aae044", this.aae044).append("acd20u", this.acd20u)
				.append("ccmu04", this.ccmu04).append("bcd202", this.bcd202)
				.append("acd20s", this.acd20s).toString();
	}

}