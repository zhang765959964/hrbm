package com.xunfeng.sys.uums.model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import com.xunfeng.core.model.BaseModel;
import com.xunfeng.core.util.AppConfigUtil;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.console.service.SystemConst;
import com.xunfeng.sys.role.interf.SysRoleServiceInterf;
import com.xunfeng.sys.role.model.SysRole;
import com.xunfeng.sys.role.service.SysRoleService;
/**
 * 对象功能:从业人员信息表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-27 16:40:20
 */
public class SysUser extends BaseModel implements UserDetails
{
	private static ThreadLocal<Collection<GrantedAuthority>> roleList=new ThreadLocal<Collection<GrantedAuthority>>();

	// 从业人员编号
	protected Long  acd230;
	// 职介机构编号
	protected Long  acd200=0L;
	// 个人编号
	protected Long  aac001;
	// 公司身份证号码
	protected String  aac002;
	// 姓名
	protected String  aac003;
	// 性别
	protected String  aac004;
	// 文化程度
	protected String  aac011;
	// 出生日期
	protected java.util.Date  aac006;
	// 户口性质
	protected String  aac009;
	// 联系电话
	protected String  aae005;
	// 担任职务
	protected String  acd231;
	// 国家职业资格等级
	protected String  aac015;
	// 资格证书号码
	protected String  acc02i;
	// 资格证书类别
	protected String  acd232;
	// 人员身份
	protected String  acd233;
	// 家庭住址
	protected String  aac026;
	// 月收入
	protected Float  acd234;
	// 备注
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 经办机构代码
	protected String  aae017;
	// 经办日期
	protected java.util.Date  aae036;
	// 账户名
	protected String  cczh01;
	// 密码
	protected String  cczh02;
	// 权限类别编号
	protected String  cczh03;
	// 使用范围(1-网站2-窗口3-民营职介机构4-适用于所有5-公办机构)
	protected String  cczh04;
	// 是否是部门负责人(0-不是1-是)
	protected String  cczh05;
	// 手机号码
	protected String  cczh06;
	// 部门编号
	protected Long  ctzb01;
	// 版本号
	protected String  cczh07;
	// 类型，只用于导数据
	protected String  cczh08;
	// 角色编号
	protected Long  rol001;
	// 科室编号
	protected Long  dep001;
	// email地址
	protected String  email;
	// 有效标记 0:有效 1:无效
	protected String  ccpr08;
	// 皮肤设置
	protected String  theme;
	// 人员职位排序
	protected Long  cczh09;
	// 可否使用职介通 0:是 1:否
	protected Long  acd235;
	//新密码
	protected String newCczh02; 
	//所属机构名称
	protected String acd202;
	//所属部门名称
	protected String dep002;
	//关键字查询
	protected String findKeyword;
	
	public String getFindKeyword() {
		return findKeyword;
	}
	public void setFindKeyword(String findKeyword) {
		this.findKeyword = findKeyword;
	}
	public void setAcd230(Long acd230) 
	{
		this.acd230 = acd230;
	}
	/**
	 * 返回 从业人员编号
	 * @return
	 */
	public Long getAcd230() 
	{
		return this.acd230;
	}
	public void setAcd200(Long acd200) 
	{
		this.acd200 = acd200;
	}
	/**
	 * 返回 职介机构编号
	 * @return
	 */
	public Long getAcd200() 
	{
		return this.acd200;
	}
	public void setAac001(Long aac001) 
	{
		this.aac001 = aac001;
	}
	
	public String getAcd202() {
		return acd202;
	}
	public void setAcd202(String acd202) {
		this.acd202 = acd202;
	}
	public String getDep002() {
		return dep002;
	}
	public void setDep002(String dep002) {
		this.dep002 = dep002;
	}
	/**
	 * 返回 个人编号
	 * @return
	 */
	public Long getAac001() 
	{
		return this.aac001;
	}
	public void setAac002(String aac002) 
	{
		this.aac002 = aac002;
	}
	/**
	 * 返回 公司身份证号码
	 * @return
	 */
	public String getAac002() 
	{
		return this.aac002;
	}
	public void setAac003(String aac003) 
	{
		this.aac003 = aac003;
	}
	/**
	 * 返回 姓名
	 * @return
	 */
	public String getAac003() 
	{
		return this.aac003;
	}
	public void setAac004(String aac004) 
	{
		this.aac004 = aac004;
	}
	/**
	 * 返回 性别
	 * @return
	 */
	public String getAac004() 
	{
		return this.aac004;
	}
	public void setAac011(String aac011) 
	{
		this.aac011 = aac011;
	}
	/**
	 * 返回 文化程度
	 * @return
	 */
	public String getAac011() 
	{
		return this.aac011;
	}
	public void setAac006(java.util.Date aac006) 
	{
		this.aac006 = aac006;
	}
	/**
	 * 返回 出生日期
	 * @return
	 */
	public java.util.Date getAac006() 
	{
		return this.aac006;
	}
	public void setAac009(String aac009) 
	{
		this.aac009 = aac009;
	}
	/**
	 * 返回 户口性质
	 * @return
	 */
	public String getAac009() 
	{
		return this.aac009;
	}
	public void setAae005(String aae005) 
	{
		this.aae005 = aae005;
	}
	/**
	 * 返回 联系电话
	 * @return
	 */
	public String getAae005() 
	{
		return this.aae005;
	}
	public void setAcd231(String acd231) 
	{
		this.acd231 = acd231;
	}
	/**
	 * 返回 担任职务
	 * @return
	 */
	public String getAcd231() 
	{
		return this.acd231;
	}
	public void setAac015(String aac015) 
	{
		this.aac015 = aac015;
	}
	/**
	 * 返回 国家职业资格等级
	 * @return
	 */
	public String getAac015() 
	{
		return this.aac015;
	}
	public void setAcc02i(String acc02i) 
	{
		this.acc02i = acc02i;
	}
	/**
	 * 返回 资格证书号码
	 * @return
	 */
	public String getAcc02i() 
	{
		return this.acc02i;
	}
	public void setAcd232(String acd232) 
	{
		this.acd232 = acd232;
	}
	/**
	 * 返回 资格证书类别
	 * @return
	 */
	public String getAcd232() 
	{
		return this.acd232;
	}
	public void setAcd233(String acd233) 
	{
		this.acd233 = acd233;
	}
	/**
	 * 返回 人员身份
	 * @return
	 */
	public String getAcd233() 
	{
		return this.acd233;
	}
	public void setAac026(String aac026) 
	{
		this.aac026 = aac026;
	}
	/**
	 * 返回 家庭住址
	 * @return
	 */
	public String getAac026() 
	{
		return this.aac026;
	}
	public void setAcd234(Float acd234) 
	{
		this.acd234 = acd234;
	}
	/**
	 * 返回 月收入
	 * @return
	 */
	public Float getAcd234() 
	{
		return this.acd234;
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
	public void setCczh01(String cczh01) 
	{
		this.cczh01 = cczh01;
	}
	/**
	 * 返回 账户名
	 * @return
	 */
	public String getCczh01() 
	{
		return this.cczh01;
	}
	public void setCczh02(String cczh02) 
	{
		this.cczh02 = cczh02;
	}
	/**
	 * 返回 密码
	 * @return
	 */
	public String getCczh02() 
	{
		return this.cczh02;
	}
	public void setCczh03(String cczh03) 
	{
		this.cczh03 = cczh03;
	}
	/**
	 * 返回 权限类别编号
	 * @return
	 */
	public String getCczh03() 
	{
		return this.cczh03;
	}
	public void setCczh04(String cczh04) 
	{
		this.cczh04 = cczh04;
	}
	/**
	 * 返回 使用范围(1-网站2-窗口3-民营职介机构4-适用于所有5-公办机构)
	 * @return
	 */
	public String getCczh04() 
	{
		return this.cczh04;
	}
	public void setCczh05(String cczh05) 
	{
		this.cczh05 = cczh05;
	}
	/**
	 * 返回 是否是部门负责人(0-不是1-是)
	 * @return
	 */
	public String getCczh05() 
	{
		return this.cczh05;
	}
	public void setCczh06(String cczh06) 
	{
		this.cczh06 = cczh06;
	}
	/**
	 * 返回 手机号码
	 * @return
	 */
	public String getCczh06() 
	{
		return this.cczh06;
	}
	public void setCtzb01(Long ctzb01) 
	{
		this.ctzb01 = ctzb01;
	}
	/**
	 * 返回 部门编号
	 * @return
	 */
	public Long getCtzb01() 
	{
		return this.ctzb01;
	}
	public void setCczh07(String cczh07) 
	{
		this.cczh07 = cczh07;
	}
	/**
	 * 返回 版本号
	 * @return
	 */
	public String getCczh07() 
	{
		return this.cczh07;
	}
	public void setCczh08(String cczh08) 
	{
		this.cczh08 = cczh08;
	}
	/**
	 * 返回 类型，只用于导数据
	 * @return
	 */
	public String getCczh08() 
	{
		return this.cczh08;
	}
	public void setRol001(Long rol001) 
	{
		this.rol001 = rol001;
	}
	/**
	 * 返回 角色编号
	 * @return
	 */
	public Long getRol001() 
	{
		return this.rol001;
	}
	public void setDep001(Long dep001) 
	{
		this.dep001 = dep001;
	}
	/**
	 * 返回 科室编号
	 * @return
	 */
	public Long getDep001() 
	{
		return this.dep001;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	/**
	 * 返回 email地址
	 * @return
	 */
	public String getEmail() 
	{
		return this.email;
	}
	public void setCcpr08(String ccpr08) 
	{
		this.ccpr08 = ccpr08;
	}
	/**
	 * 返回 有效标记 0:有效 1:无效
	 * @return
	 */
	public String getCcpr08() 
	{
		return this.ccpr08;
	}
	public void setTheme(String theme) 
	{
		this.theme = theme;
	}
	/**
	 * 返回 皮肤设置
	 * @return
	 */
	public String getTheme() 
	{
		return this.theme;
	}
	public void setCczh09(Long cczh09) 
	{
		this.cczh09 = cczh09;
	}
	/**
	 * 返回 人员职位排序
	 * @return
	 */
	public Long getCczh09() 
	{
		return this.cczh09;
	}
	public void setAcd235(Long acd235) 
	{
		this.acd235 = acd235;
	}
	/**
	 * 返回 可否使用职介通 0:是 1:否
	 * @return
	 */
	public Long getAcd235() 
	{
		return this.acd235;
	}
	
	/**
	 * 取得管理员帐号。
	 * @return
	 */
	public static String getAdminAccount(){
		
		String admin=AppConfigUtil.get("account");
		if(StringUtil.isEmpty(admin)){
			admin=SystemConst.KEY_MANAGER;
		}
		return admin;
	}
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		//if(roleList.get()!=null) return roleList.get();
		Collection<GrantedAuthority> rtnList= new ArrayList<GrantedAuthority>();
		SysRoleServiceInterf sysRoleService = (SysRoleServiceInterf) AppUtil.getBean("sysRole");
		List<SysRole> roleList_db= sysRoleService.getUserRole(acd230);
		for(SysRole role:roleList_db){
			rtnList.add(new GrantedAuthorityImpl(role.getRolename()));
		}
		String admin=SysUser.getAdminAccount();
		// 添加超级管理员角色。
		if (admin.equals(this.cczh01)) {
			rtnList.add(SystemConst.ROLE_GRANT_SUPER);
		}
		roleList.set(rtnList);
		return rtnList;
	}


	@Override
	public String getUsername() {
		return this.cczh01;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
			return true;
		
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;

	}
	
	/**
	 * 返回 密码
	 * 
	 * @return
	 */
	@Override
	public String getPassword() {
		return this.cczh02;
	}

	
   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysUser)) 
		{
			return false;
		}
		SysUser rhs = (SysUser) object;
		return new EqualsBuilder()
		.append(this.acd230, rhs.acd230)
		.append(this.acd200, rhs.acd200)
		.append(this.aac001, rhs.aac001)
		.append(this.aac002, rhs.aac002)
		.append(this.aac003, rhs.aac003)
		.append(this.aac004, rhs.aac004)
		.append(this.aac011, rhs.aac011)
		.append(this.aac006, rhs.aac006)
		.append(this.aac009, rhs.aac009)
		.append(this.aae005, rhs.aae005)
		.append(this.acd231, rhs.acd231)
		.append(this.aac015, rhs.aac015)
		.append(this.acc02i, rhs.acc02i)
		.append(this.acd232, rhs.acd232)
		.append(this.acd233, rhs.acd233)
		.append(this.aac026, rhs.aac026)
		.append(this.acd234, rhs.acd234)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae017, rhs.aae017)
		.append(this.aae036, rhs.aae036)
		.append(this.cczh01, rhs.cczh01)
		.append(this.cczh02, rhs.cczh02)
		.append(this.cczh03, rhs.cczh03)
		.append(this.cczh04, rhs.cczh04)
		.append(this.cczh05, rhs.cczh05)
		.append(this.cczh06, rhs.cczh06)
		.append(this.ctzb01, rhs.ctzb01)
		.append(this.cczh07, rhs.cczh07)
		.append(this.cczh08, rhs.cczh08)
		.append(this.rol001, rhs.rol001)
		.append(this.dep001, rhs.dep001)
		.append(this.email, rhs.email)
		.append(this.ccpr08, rhs.ccpr08)
		.append(this.theme, rhs.theme)
		.append(this.cczh09, rhs.cczh09)
		.append(this.acd235, rhs.acd235)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acd230) 
		.append(this.acd200) 
		.append(this.aac001) 
		.append(this.aac002) 
		.append(this.aac003) 
		.append(this.aac004) 
		.append(this.aac011) 
		.append(this.aac006) 
		.append(this.aac009) 
		.append(this.aae005) 
		.append(this.acd231) 
		.append(this.aac015) 
		.append(this.acc02i) 
		.append(this.acd232) 
		.append(this.acd233) 
		.append(this.aac026) 
		.append(this.acd234) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae017) 
		.append(this.aae036) 
		.append(this.cczh01) 
		.append(this.cczh02) 
		.append(this.cczh03) 
		.append(this.cczh04) 
		.append(this.cczh05) 
		.append(this.cczh06) 
		.append(this.ctzb01) 
		.append(this.cczh07) 
		.append(this.cczh08) 
		.append(this.rol001) 
		.append(this.dep001) 
		.append(this.email) 
		.append(this.ccpr08) 
		.append(this.theme) 
		.append(this.cczh09) 
		.append(this.acd235) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acd230", this.acd230) 
		.append("acd200", this.acd200) 
		.append("aac001", this.aac001) 
		.append("aac002", this.aac002) 
		.append("aac003", this.aac003) 
		.append("aac004", this.aac004) 
		.append("aac011", this.aac011) 
		.append("aac006", this.aac006) 
		.append("aac009", this.aac009) 
		.append("aae005", this.aae005) 
		.append("acd231", this.acd231) 
		.append("aac015", this.aac015) 
		.append("acc02i", this.acc02i) 
		.append("acd232", this.acd232) 
		.append("acd233", this.acd233) 
		.append("aac026", this.aac026) 
		.append("acd234", this.acd234) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae017", this.aae017) 
		.append("aae036", this.aae036) 
		.append("cczh01", this.cczh01) 
		.append("cczh02", this.cczh02) 
		.append("cczh03", this.cczh03) 
		.append("cczh04", this.cczh04) 
		.append("cczh05", this.cczh05) 
		.append("cczh06", this.cczh06) 
		.append("ctzb01", this.ctzb01) 
		.append("cczh07", this.cczh07) 
		.append("cczh08", this.cczh08) 
		.append("rol001", this.rol001) 
		.append("dep001", this.dep001) 
		.append("email", this.email) 
		.append("ccpr08", this.ccpr08) 
		.append("theme", this.theme) 
		.append("cczh09", this.cczh09) 
		.append("acd235", this.acd235) 
		.toString();
	}
	public String getNewCczh02() {
		return newCczh02;
	}
	public void setNewCczh02(String newCczh02) {
		this.newCczh02 = newCczh02;
	}
   
  

}