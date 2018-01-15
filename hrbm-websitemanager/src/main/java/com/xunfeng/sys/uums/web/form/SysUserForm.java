package com.xunfeng.sys.uums.web.form;

import com.xunfeng.core.model.BaseForm;
import com.xunfeng.sys.uums.model.SysUser;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 从业人员信息表 Form对象
 * @author:liwenhao
 * @createDate 2016-06-30 08:53:45
 * @version V1.0
 */
public class SysUserForm extends BaseForm<SysUser> {
	// 从业人员编号
	protected Long acd230;
	// 职介机构编号
	protected Long acd200;
	// 个人编号
	// 公司身份证号码
	protected String aac002;
	// 姓名
	protected String aac003;
	// 性别
	protected String aac004;
	// 文化程度
	protected String aac011;
	// 出生日期
	protected java.util.Date aac006;
	// 户口性质
	// 联系电话
	protected String aae005;
	// 担任职务
	protected String acd231;
	// 国家职业资格等级
	protected String aac015;
	// 资格证书号码
	protected String acc02i;
	// 资格证书类别
	protected String acd232;
	// 人员身份
	protected String acd233;
	// 家庭住址
	protected String aac026;
	// 月收入
	// 备注
	// 经办人代码
	// 经办人
	// 经办机构
	// 经办机构代码
	// 经办日期
	// 账户名
	protected String cczh01;
	// 密码
	protected String cczh02;
	// 权限类别编号
	// 使用范围(1-网站2-窗口3-民营职介机构4-适用于所有5-公办机构)
	// 是否是部门负责人(0-不是1-是)
	// 手机号码
	// 部门编号
	// 版本号
	// 类型，只用于导数据
	// 角色编号
	// 科室编号
	protected Long dep001;

	public Long getAcd230() {
		return acd230;
	}

	public void setAcd230(Long acd230) {
		this.acd230 = acd230;
	}

	public Long getAcd200() {
		return acd200;
	}

	public void setAcd200(Long acd200) {
		this.acd200 = acd200;
	}

	public String getAac002() {
		return aac002;
	}

	public void setAac002(String aac002) {
		this.aac002 = aac002;
	}

	public String getAac003() {
		return aac003;
	}

	public void setAac003(String aac003) {
		this.aac003 = aac003;
	}

	public String getAac004() {
		return aac004;
	}

	public void setAac004(String aac004) {
		this.aac004 = aac004;
	}

	public String getAac011() {
		return aac011;
	}

	public void setAac011(String aac011) {
		this.aac011 = aac011;
	}

	public java.util.Date getAac006() {
		return aac006;
	}

	public void setAac006(java.util.Date aac006) {
		this.aac006 = aac006;
	}

	public String getAae005() {
		return aae005;
	}

	public void setAae005(String aae005) {
		this.aae005 = aae005;
	}

	public String getAcd231() {
		return acd231;
	}

	public void setAcd231(String acd231) {
		this.acd231 = acd231;
	}

	public String getAac015() {
		return aac015;
	}

	public void setAac015(String aac015) {
		this.aac015 = aac015;
	}

	public String getAcc02i() {
		return acc02i;
	}

	public void setAcc02i(String acc02i) {
		this.acc02i = acc02i;
	}

	public String getAcd232() {
		return acd232;
	}

	public void setAcd232(String acd232) {
		this.acd232 = acd232;
	}

	public String getAcd233() {
		return acd233;
	}

	public void setAcd233(String acd233) {
		this.acd233 = acd233;
	}

	public String getAac026() {
		return aac026;
	}

	public void setAac026(String aac026) {
		this.aac026 = aac026;
	}

	public String getCczh01() {
		return cczh01;
	}

	public void setCczh01(String cczh01) {
		this.cczh01 = cczh01;
	}

	public String getCczh02() {
		return cczh02;
	}

	public void setCczh02(String cczh02) {
		this.cczh02 = cczh02;
	}

	public Long getDep001() {
		return dep001;
	}

	public void setDep001(Long dep001) {
		this.dep001 = dep001;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof SysUserForm)) {
			return false;
		}
		SysUserForm rhs = (SysUserForm) object;
		return new EqualsBuilder().append(this.acd230, rhs.acd230)
				.append(this.acd200, rhs.acd200)
				.append(this.aac002, rhs.aac002)
				.append(this.aac003, rhs.aac003)
				.append(this.aac004, rhs.aac004)
				.append(this.aac011, rhs.aac011)
				.append(this.aac006, rhs.aac006)
				.append(this.aae005, rhs.aae005)
				.append(this.acd231, rhs.acd231)
				.append(this.aac015, rhs.aac015)
				.append(this.acc02i, rhs.acc02i)
				.append(this.acd232, rhs.acd232)
				.append(this.acd233, rhs.acd233)
				.append(this.aac026, rhs.aac026)
				.append(this.cczh01, rhs.cczh01)
				.append(this.cczh02, rhs.cczh02)
				.append(this.dep001, rhs.dep001).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-82280557, -700257973).append(this.acd230)
				.append(this.acd200).append(this.aac002).append(this.aac003)
				.append(this.aac004).append(this.aac011).append(this.aac006)
				.append(this.aae005).append(this.acd231).append(this.aac015)
				.append(this.acc02i).append(this.acd232).append(this.acd233)
				.append(this.aac026).append(this.cczh01).append(this.cczh02)
				.append(this.dep001).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("acd230", this.acd230)
				.append("acd200", this.acd200).append("aac002", this.aac002)
				.append("aac003", this.aac003).append("aac004", this.aac004)
				.append("aac011", this.aac011).append("aac006", this.aac006)
				.append("aae005", this.aae005).append("acd231", this.acd231)
				.append("aac015", this.aac015).append("acc02i", this.acc02i)
				.append("acd232", this.acd232).append("acd233", this.acd233)
				.append("aac026", this.aac026).append("cczh01", this.cczh01)
				.append("cczh02", this.cczh02).append("dep001", this.dep001)
				.toString();
	}

}