package com.xunfeng.sys.uums.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.xunfeng.core.model.BaseModel;
import com.xunfeng.core.model.IBaseTree;
import com.xunfeng.core.util.StringUtil;
/**
 * 对象功能:职介机构表 Model对象
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-29 16:03:27
 */
public class SysOrg extends BaseModel implements IBaseTree
{
	/**
	 * sid
	 */
	private static final long serialVersionUID = 5694287515099216153L;
	// 职介机构编号
	protected Long  acd200;
	// 许可证编号
	protected String  acd201;
	// 批办机构名称
	protected String  acd207;
	// 职介机构名称
	protected String  acd202;
	// 场所地址
	protected String  aae006;
	// 邮政编码
	protected String  aae007;
	// 税务登记号
	protected String  aab030;
	// 收费许可证号
	protected String  ahb409;
	// 机构类别
	protected String  acd203;
	// 机构性质
	protected String  acd204;
	// 许可证经营范围
	protected String  acd205;
	// 申请业务范围
	protected String  acd208;
	// 经费来源
	protected String  acd206;
	// 机构法定负责人
	protected String  aab013;
	// 法人公司身份证号码
	protected String  aab014;
	// 性别
	protected String  aac004;
	// 出生日期
	protected java.util.Date  aac006;
	// 文化程度
	protected String  aac011;
	// 法人联系电话
	protected String  aab015;
	// 住址
	protected String  aac026;
	// 场所面积
	protected String  acd20b;
	// 设备设施
	protected String  acd20c;
	// 人员规模
	protected String  aab056;
	// 工作人员数
	protected Long  acd20d;
	// 其中持证人员数
	protected Long  acd20e;
	// 机构类别名
	protected String  acd203Name;
	// 机构Name
	protected String  acd204Name;
	//关键字查询
	protected String findKeyword;
	// 设立固定招聘场所个数
	protected Long  acd20f;
	// 建立人力资源服务网站个数

	protected Long  acd20g;
	// 注册资金(万元)
	protected Float  aab049;
	// 注册机关
	protected String  acd20m;
	// 缴纳备用金
	protected Float  acd20n;
	// 组织机构代码
	protected String  aab003;
	// 工商登记执照号码
	protected String  aab007;
	// 银行行号
	protected String  aae008;
	// 银行账号
	protected String  aae010;
	// 机构所在行政区划代码
	protected String  aab301;
	// 机构所在行政区划
	protected String  aab201;
	// 传真
	protected String  aae014;
	// 电子信箱
	protected String  aae015;
	// 网址
	protected String  aae016;
	// 公开服务电话
	protected String  acd20a;
	// 联系人
	protected String  aae004;
	// 联系电话
	protected String  aae005;
	// 有效期
	protected java.util.Date  acd20k;
	// 父级机构代码
	protected String  aab034;
	// 父级机构名称
	protected String  aae044;
	// 有效标记
	protected String  aae100;
	// 审批状态
	protected String  aae097;
	// 审批标记
	protected String  aae098;
	// 审批意见
	protected String  aae013;
	// 经办人代码
	protected String  aae011;
	// 经办机构代码
	protected String  aae017;
	// 经办人
	protected String  aae019;
	// 经办机构
	protected String  aae020;
	// 经办日期
	protected java.util.Date  aae036;
	// 经办机构行政区划代码
	protected String  aae022;
	// 申请标记
	protected String  aaea98;
	// 申请意见
	protected String  aaea13;
	// 申请经办人代码
	protected String  aaea11;
	// 申请经办机构代码
	protected String  aaea17;
	// 申请经办日期
	protected java.util.Date  aaea36;
	// 申请经办人
	protected String  aaea19;
	// 申请经办机构
	protected String  aaea20;
	// 申请经办机构代码
	protected String  aaea22;
	// 审核标记
	protected String  aaeb98;
	// 审核意见
	protected String  aaeb13;
	// 审核经办人代码
	protected String  aaeb11;
	// 审核经办机构代码
	protected String  aaeb17;
	// 审核经办日期
	protected java.util.Date  aaeb36;
	// 审核经办人
	protected String  aaeb19;
	// 审核经办机构
	protected String  aaeb20;
	// 审核经办行政区划代码
	protected String  aaeb22;
	// 打证标记
	protected String  acd20h;
	// 打证经办人代码
	protected String  aaee11;
	// 打证经办机构代码
	protected String  aaee17;
	// 打证经办日期
	protected java.util.Date  aaee36;
	// 打证经办人
	protected String  aaee19;
	// 打证经办机构
	protected String  aaee20;
	// 打证经办机构行政区划
	protected String  aaee22;
	// 领证人
	protected String  acd20p;
	// 发放标记
	protected String  acd20j;
	// 发证经办人代码
	protected String  aaef11;
	// 发证经办机构代码
	protected String  aaef17;
	// 发证经办日期
	protected java.util.Date  aaef36;
	// 发证经办人
	protected String  aaef19;
	// 发证经办机构
	protected String  aaef20;
	// 发证经办机构行政区划
	protected String  aaef22;
	// 注销原因
	protected String  acd20q;
	// 注销经办人代码
	protected String  aaeg11;
	// 注销经办机构代码
	protected String  aaeg17;
	// 注销经办日期
	protected java.util.Date  aaeg36;
	// 注销经办人
	protected String  aaeg19;
	// 注销经办机构
	protected String  aaeg20;
	// 注销经办机构行政区划
	protected String  aaeg22;
	// 恢复原因
	protected String  acd20t;
	// 恢复经办人代码
	protected String  aaeh11;
	// 恢复经办机构代码
	protected String  aaeh17;
	// 恢复经办日期
	protected java.util.Date  aaeh36;
	// 恢复经办人
	protected String  aaeh19;
	// 恢复经办机构
	protected String  aaeh20;
	// 恢复经办机构行政区划
	protected String  aaeh22;
	// 信用等级
	protected String  acd20u;
	// 登录编号
	protected Long  ccmu01;
	// 是否能看到其它民营职介信息(0-不能1-能)
	protected Long  ccmu02;
	// 是否能看到其它职介中心信息(0-不能1-能)
	protected Long  ccmu03;
	// 乘车路线
	protected String  ccmu04;
	// 机构级别1-顶级机构，2-下级机构
	protected Long  ccmu05;
	// 简称
	protected String  acd20v;
	// 是否开通地图
	protected Long  cabq01;
	// X坐标
	protected Float  cabq02;
	// Y坐标
	protected Float  cabq03;
	// 缩放比例
	protected Long  cabq04;
	// 职介机构别名
	protected String  bcd202;
	// 机构对应数据来源
	protected String  aczy06;
	// 是否应用OA 0:不应用 1:应用
	protected String  acd20w;
	// 机构分类编号 1:职介中心 2:公办 3:高校
	protected String  acd20s;
	
//	protected String  id;
//	protected String  pId;
//	protected String  name;
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
	public void setAcd201(String acd201) 
	{
		this.acd201 = acd201;
	}
	/**
	 * 返回 许可证编号
	 * @return
	 */
	public String getAcd201() 
	{
		return this.acd201;
	}
	public void setAcd207(String acd207) 
	{
		this.acd207 = acd207;
	}
	/**
	 * 返回 批办机构名称
	 * @return
	 */
	public String getAcd207() 
	{
		return this.acd207;
	}
	public void setAcd202(String acd202) 
	{
		this.acd202 = acd202;
	}
	/**
	 * 返回 职介机构名称
	 * @return
	 */
	public String getAcd202() 
	{
		return this.acd202;
	}
	public void setAae006(String aae006) 
	{
		this.aae006 = aae006;
	}
	/**
	 * 返回 场所地址
	 * @return
	 */
	public String getAae006() 
	{
		return this.aae006;
	}
	public void setAae007(String aae007) 
	{
		this.aae007 = aae007;
	}
	/**
	 * 返回 邮政编码
	 * @return
	 */
	public String getAae007() 
	{
		return this.aae007;
	}
	public void setAab030(String aab030) 
	{
		this.aab030 = aab030;
	}
	/**
	 * 返回 税务登记号
	 * @return
	 */
	public String getAab030() 
	{
		return this.aab030;
	}
	public void setAhb409(String ahb409) 
	{
		this.ahb409 = ahb409;
	}
	/**
	 * 返回 收费许可证号
	 * @return
	 */
	public String getAhb409() 
	{
		return this.ahb409;
	}
	public void setAcd203(String acd203) 
	{
		this.acd203 = acd203;
	}
	/**
	 * 返回 机构类别
	 * @return
	 */
	public String getAcd203() 
	{
		return this.acd203;
	}
	public void setAcd204(String acd204) 
	{
		this.acd204 = acd204;
	}
	/**
	 * 返回 机构性质
	 * @return
	 */
	public String getAcd204() 
	{
		return this.acd204;
	}
	public void setAcd205(String acd205) 
	{
		this.acd205 = acd205;
	}
	/**
	 * 返回 许可证经营范围
	 * @return
	 */
	public String getAcd205() 
	{
		return this.acd205;
	}
	public void setAcd208(String acd208) 
	{
		this.acd208 = acd208;
	}
	/**
	 * 返回 申请业务范围
	 * @return
	 */
	public String getAcd208() 
	{
		return this.acd208;
	}
	public void setAcd206(String acd206) 
	{
		this.acd206 = acd206;
	}
	/**
	 * 返回 经费来源
	 * @return
	 */
	public String getAcd206() 
	{
		return this.acd206;
	}
	public void setAab013(String aab013) 
	{
		this.aab013 = aab013;
	}
	/**
	 * 返回 机构法定负责人
	 * @return
	 */
	public String getAab013() 
	{
		return this.aab013;
	}
	public void setAab014(String aab014) 
	{
		this.aab014 = aab014;
	}
	/**
	 * 返回 法人公司身份证号码
	 * @return
	 */
	public String getAab014() 
	{
		return this.aab014;
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
	public void setAab015(String aab015) 
	{
		this.aab015 = aab015;
	}
	/**
	 * 返回 法人联系电话
	 * @return
	 */
	public String getAab015() 
	{
		return this.aab015;
	}
	public void setAac026(String aac026) 
	{
		this.aac026 = aac026;
	}
	/**
	 * 返回 住址
	 * @return
	 */
	public String getAac026() 
	{
		return this.aac026;
	}
	public void setAcd20b(String acd20b) 
	{
		this.acd20b = acd20b;
	}
	/**
	 * 返回 场所面积
	 * @return
	 */
	public String getAcd20b() 
	{
		return this.acd20b;
	}
	public void setAcd20c(String acd20c) 
	{
		this.acd20c = acd20c;
	}
	/**
	 * 返回 设备设施
	 * @return
	 */
	public String getAcd20c() 
	{
		return this.acd20c;
	}
	public void setAab056(String aab056) 
	{
		this.aab056 = aab056;
	}
	/**
	 * 返回 人员规模
	 * @return
	 */
	public String getAab056() 
	{
		return this.aab056;
	}
	public void setAcd20d(Long acd20d) 
	{
		this.acd20d = acd20d;
	}
	/**
	 * 返回 工作人员数
	 * @return
	 */
	public Long getAcd20d() 
	{
		return this.acd20d;
	}
	public void setAcd20e(Long acd20e) 
	{
		this.acd20e = acd20e;
	}
	/**
	 * 返回 其中持证人员数
	 * @return
	 */
	public Long getAcd20e() 
	{
		return this.acd20e;
	}
	public void setAcd20f(Long acd20f) 
	{
		this.acd20f = acd20f;
	}
	/**
	 * 返回 设立固定招聘场所个数

	 * @return
	 */
	public Long getAcd20f() 
	{
		return this.acd20f;
	}
	public void setAcd20g(Long acd20g) 
	{
		this.acd20g = acd20g;
	}
	/**
	 * 返回 建立人力资源服务网站个数

	 * @return
	 */
	public Long getAcd20g() 
	{
		return this.acd20g;
	}
	public void setAab049(Float aab049) 
	{
		this.aab049 = aab049;
	}
	/**
	 * 返回 注册资金(万元)
	 * @return
	 */
	public Float getAab049() 
	{
		return this.aab049;
	}
	public void setAcd20m(String acd20m) 
	{
		this.acd20m = acd20m;
	}
	/**
	 * 返回 注册机关
	 * @return
	 */
	public String getAcd20m() 
	{
		return this.acd20m;
	}
	public void setAcd20n(Float acd20n) 
	{
		this.acd20n = acd20n;
	}
	/**
	 * 返回 缴纳备用金
	 * @return
	 */
	public Float getAcd20n() 
	{
		return this.acd20n;
	}
	public void setAab003(String aab003) 
	{
		this.aab003 = aab003;
	}
	/**
	 * 返回 组织机构代码
	 * @return
	 */
	public String getAab003() 
	{
		return this.aab003;
	}
	public void setAab007(String aab007) 
	{
		this.aab007 = aab007;
	}
	/**
	 * 返回 工商登记执照号码
	 * @return
	 */
	public String getAab007() 
	{
		return this.aab007;
	}
	public void setAae008(String aae008) 
	{
		this.aae008 = aae008;
	}
	/**
	 * 返回 银行行号
	 * @return
	 */
	public String getAae008() 
	{
		return this.aae008;
	}
	public void setAae010(String aae010) 
	{
		this.aae010 = aae010;
	}
	/**
	 * 返回 银行账号
	 * @return
	 */
	public String getAae010() 
	{
		return this.aae010;
	}
	public void setAab301(String aab301) 
	{
		this.aab301 = aab301;
	}
	/**
	 * 返回 机构所在行政区划代码
	 * @return
	 */
	public String getAab301() 
	{
		return this.aab301;
	}
	public void setAab201(String aab201) 
	{
		this.aab201 = aab201;
	}
	/**
	 * 返回 机构所在行政区划
	 * @return
	 */
	public String getAab201() 
	{
		return this.aab201;
	}
	public void setAae014(String aae014) 
	{
		this.aae014 = aae014;
	}
	/**
	 * 返回 传真
	 * @return
	 */
	public String getAae014() 
	{
		return this.aae014;
	}
	public void setAae015(String aae015) 
	{
		this.aae015 = aae015;
	}
	/**
	 * 返回 电子信箱
	 * @return
	 */
	public String getAae015() 
	{
		return this.aae015;
	}
	public void setAae016(String aae016) 
	{
		this.aae016 = aae016;
	}
	/**
	 * 返回 网址
	 * @return
	 */
	public String getAae016() 
	{
		return this.aae016;
	}
	public void setAcd20a(String acd20a) 
	{
		this.acd20a = acd20a;
	}
	/**
	 * 返回 公开服务电话
	 * @return
	 */
	public String getAcd20a() 
	{
		return this.acd20a;
	}
	public void setAae004(String aae004) 
	{
		this.aae004 = aae004;
	}
	/**
	 * 返回 联系人
	 * @return
	 */
	public String getAae004() 
	{
		return this.aae004;
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
	public void setAcd20k(java.util.Date acd20k) 
	{
		this.acd20k = acd20k;
	}
	/**
	 * 返回 有效期
	 * @return
	 */
	public java.util.Date getAcd20k() 
	{
		return this.acd20k;
	}
	public void setAab034(String aab034) 
	{
		this.aab034 = aab034;
	}
	/**
	 * 返回 父级机构代码
	 * @return
	 */
	public String getAab034() 
	{
		return this.aab034;
	}
	public void setAae044(String aae044) 
	{
		this.aae044 = aae044;
	}
	/**
	 * 返回 父级机构名称
	 * @return
	 */
	public String getAae044() 
	{
		return this.aae044;
	}
	public void setAae100(String aae100) 
	{
		this.aae100 = aae100;
	}
	/**
	 * 返回 有效标记
	 * @return
	 */
	public String getAae100() 
	{
		return this.aae100;
	}
	public void setAae097(String aae097) 
	{
		this.aae097 = aae097;
	}
	/**
	 * 返回 审批状态
	 * @return
	 */
	public String getAae097() 
	{
		return this.aae097;
	}
	public void setAae098(String aae098) 
	{
		this.aae098 = aae098;
	}
	/**
	 * 返回 审批标记
	 * @return
	 */
	public String getAae098() 
	{
		return this.aae098;
	}
	public void setAae013(String aae013) 
	{
		this.aae013 = aae013;
	}
	/**
	 * 返回 审批意见
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
	public void setAae022(String aae022) 
	{
		this.aae022 = aae022;
	}
	/**
	 * 返回 经办机构行政区划代码
	 * @return
	 */
	public String getAae022() 
	{
		return this.aae022;
	}
	public void setAaea98(String aaea98) 
	{
		this.aaea98 = aaea98;
	}
	/**
	 * 返回 申请标记
	 * @return
	 */
	public String getAaea98() 
	{
		return this.aaea98;
	}
	public void setAaea13(String aaea13) 
	{
		this.aaea13 = aaea13;
	}
	/**
	 * 返回 申请意见
	 * @return
	 */
	public String getAaea13() 
	{
		return this.aaea13;
	}
	public void setAaea11(String aaea11) 
	{
		this.aaea11 = aaea11;
	}
	/**
	 * 返回 申请经办人代码
	 * @return
	 */
	public String getAaea11() 
	{
		return this.aaea11;
	}
	public void setAaea17(String aaea17) 
	{
		this.aaea17 = aaea17;
	}
	/**
	 * 返回 申请经办机构代码
	 * @return
	 */
	public String getAaea17() 
	{
		return this.aaea17;
	}
	public void setAaea36(java.util.Date aaea36) 
	{
		this.aaea36 = aaea36;
	}
	/**
	 * 返回 申请经办日期
	 * @return
	 */
	public java.util.Date getAaea36() 
	{
		return this.aaea36;
	}
	public void setAaea19(String aaea19) 
	{
		this.aaea19 = aaea19;
	}
	/**
	 * 返回 申请经办人
	 * @return
	 */
	public String getAaea19() 
	{
		return this.aaea19;
	}
	public void setAaea20(String aaea20) 
	{
		this.aaea20 = aaea20;
	}
	/**
	 * 返回 申请经办机构
	 * @return
	 */
	public String getAaea20() 
	{
		return this.aaea20;
	}
	public void setAaea22(String aaea22) 
	{
		this.aaea22 = aaea22;
	}
	/**
	 * 返回 申请经办机构代码
	 * @return
	 */
	public String getAaea22() 
	{
		return this.aaea22;
	}
	public void setAaeb98(String aaeb98) 
	{
		this.aaeb98 = aaeb98;
	}
	/**
	 * 返回 审核标记
	 * @return
	 */
	public String getAaeb98() 
	{
		return this.aaeb98;
	}
	public void setAaeb13(String aaeb13) 
	{
		this.aaeb13 = aaeb13;
	}
	/**
	 * 返回 审核意见
	 * @return
	 */
	public String getAaeb13() 
	{
		return this.aaeb13;
	}
	public void setAaeb11(String aaeb11) 
	{
		this.aaeb11 = aaeb11;
	}
	/**
	 * 返回 审核经办人代码
	 * @return
	 */
	public String getAaeb11() 
	{
		return this.aaeb11;
	}
	public void setAaeb17(String aaeb17) 
	{
		this.aaeb17 = aaeb17;
	}
	/**
	 * 返回 审核经办机构代码
	 * @return
	 */
	public String getAaeb17() 
	{
		return this.aaeb17;
	}
	public void setAaeb36(java.util.Date aaeb36) 
	{
		this.aaeb36 = aaeb36;
	}
	/**
	 * 返回 审核经办日期
	 * @return
	 */
	public java.util.Date getAaeb36() 
	{
		return this.aaeb36;
	}
	public void setAaeb19(String aaeb19) 
	{
		this.aaeb19 = aaeb19;
	}
	/**
	 * 返回 审核经办人
	 * @return
	 */
	public String getAaeb19() 
	{
		return this.aaeb19;
	}
	public void setAaeb20(String aaeb20) 
	{
		this.aaeb20 = aaeb20;
	}
	/**
	 * 返回 审核经办机构
	 * @return
	 */
	public String getAaeb20() 
	{
		return this.aaeb20;
	}
	public void setAaeb22(String aaeb22) 
	{
		this.aaeb22 = aaeb22;
	}
	/**
	 * 返回 审核经办行政区划代码
	 * @return
	 */
	public String getAaeb22() 
	{
		return this.aaeb22;
	}
	public void setAcd20h(String acd20h) 
	{
		this.acd20h = acd20h;
	}
	/**
	 * 返回 打证标记
	 * @return
	 */
	public String getAcd20h() 
	{
		return this.acd20h;
	}
	public void setAaee11(String aaee11) 
	{
		this.aaee11 = aaee11;
	}
	/**
	 * 返回 打证经办人代码
	 * @return
	 */
	public String getAaee11() 
	{
		return this.aaee11;
	}
	public void setAaee17(String aaee17) 
	{
		this.aaee17 = aaee17;
	}
	/**
	 * 返回 打证经办机构代码
	 * @return
	 */
	public String getAaee17() 
	{
		return this.aaee17;
	}
	public void setAaee36(java.util.Date aaee36) 
	{
		this.aaee36 = aaee36;
	}
	/**
	 * 返回 打证经办日期
	 * @return
	 */
	public java.util.Date getAaee36() 
	{
		return this.aaee36;
	}
	public void setAaee19(String aaee19) 
	{
		this.aaee19 = aaee19;
	}
	/**
	 * 返回 打证经办人
	 * @return
	 */
	public String getAaee19() 
	{
		return this.aaee19;
	}
	public void setAaee20(String aaee20) 
	{
		this.aaee20 = aaee20;
	}
	/**
	 * 返回 打证经办机构
	 * @return
	 */
	public String getAaee20() 
	{
		return this.aaee20;
	}
	public void setAaee22(String aaee22) 
	{
		this.aaee22 = aaee22;
	}
	/**
	 * 返回 打证经办机构行政区划
	 * @return
	 */
	public String getAaee22() 
	{
		return this.aaee22;
	}
	public void setAcd20p(String acd20p) 
	{
		this.acd20p = acd20p;
	}
	/**
	 * 返回 领证人
	 * @return
	 */
	public String getAcd20p() 
	{
		return this.acd20p;
	}
	public void setAcd20j(String acd20j) 
	{
		this.acd20j = acd20j;
	}
	/**
	 * 返回 发放标记
	 * @return
	 */
	public String getAcd20j() 
	{
		return this.acd20j;
	}
	public void setAaef11(String aaef11) 
	{
		this.aaef11 = aaef11;
	}
	/**
	 * 返回 发证经办人代码
	 * @return
	 */
	public String getAaef11() 
	{
		return this.aaef11;
	}
	public void setAaef17(String aaef17) 
	{
		this.aaef17 = aaef17;
	}
	/**
	 * 返回 发证经办机构代码
	 * @return
	 */
	public String getAaef17() 
	{
		return this.aaef17;
	}
	public void setAaef36(java.util.Date aaef36) 
	{
		this.aaef36 = aaef36;
	}
	/**
	 * 返回 发证经办日期
	 * @return
	 */
	public java.util.Date getAaef36() 
	{
		return this.aaef36;
	}
	public void setAaef19(String aaef19) 
	{
		this.aaef19 = aaef19;
	}
	/**
	 * 返回 发证经办人
	 * @return
	 */
	public String getAaef19() 
	{
		return this.aaef19;
	}
	public void setAaef20(String aaef20) 
	{
		this.aaef20 = aaef20;
	}
	/**
	 * 返回 发证经办机构
	 * @return
	 */
	public String getAaef20() 
	{
		return this.aaef20;
	}
	public void setAaef22(String aaef22) 
	{
		this.aaef22 = aaef22;
	}
	/**
	 * 返回 发证经办机构行政区划
	 * @return
	 */
	public String getAaef22() 
	{
		return this.aaef22;
	}
	public void setAcd20q(String acd20q) 
	{
		this.acd20q = acd20q;
	}
	/**
	 * 返回 注销原因
	 * @return
	 */
	public String getAcd20q() 
	{
		return this.acd20q;
	}
	public void setAaeg11(String aaeg11) 
	{
		this.aaeg11 = aaeg11;
	}
	/**
	 * 返回 注销经办人代码
	 * @return
	 */
	public String getAaeg11() 
	{
		return this.aaeg11;
	}
	public void setAaeg17(String aaeg17) 
	{
		this.aaeg17 = aaeg17;
	}
	/**
	 * 返回 注销经办机构代码
	 * @return
	 */
	public String getAaeg17() 
	{
		return this.aaeg17;
	}
	public void setAaeg36(java.util.Date aaeg36) 
	{
		this.aaeg36 = aaeg36;
	}
	/**
	 * 返回 注销经办日期
	 * @return
	 */
	public java.util.Date getAaeg36() 
	{
		return this.aaeg36;
	}
	public void setAaeg19(String aaeg19) 
	{
		this.aaeg19 = aaeg19;
	}
	/**
	 * 返回 注销经办人
	 * @return
	 */
	public String getAaeg19() 
	{
		return this.aaeg19;
	}
	public void setAaeg20(String aaeg20) 
	{
		this.aaeg20 = aaeg20;
	}
	/**
	 * 返回 注销经办机构
	 * @return
	 */
	public String getAaeg20() 
	{
		return this.aaeg20;
	}
	public void setAaeg22(String aaeg22) 
	{
		this.aaeg22 = aaeg22;
	}
	/**
	 * 返回 注销经办机构行政区划
	 * @return
	 */
	public String getAaeg22() 
	{
		return this.aaeg22;
	}
	public void setAcd20t(String acd20t) 
	{
		this.acd20t = acd20t;
	}
	/**
	 * 返回 恢复原因
	 * @return
	 */
	public String getAcd20t() 
	{
		return this.acd20t;
	}
	public void setAaeh11(String aaeh11) 
	{
		this.aaeh11 = aaeh11;
	}
	/**
	 * 返回 恢复经办人代码
	 * @return
	 */
	public String getAaeh11() 
	{
		return this.aaeh11;
	}
	public void setAaeh17(String aaeh17) 
	{
		this.aaeh17 = aaeh17;
	}
	/**
	 * 返回 恢复经办机构代码
	 * @return
	 */
	public String getAaeh17() 
	{
		return this.aaeh17;
	}
	public void setAaeh36(java.util.Date aaeh36) 
	{
		this.aaeh36 = aaeh36;
	}
	/**
	 * 返回 恢复经办日期
	 * @return
	 */
	public java.util.Date getAaeh36() 
	{
		return this.aaeh36;
	}
	public void setAaeh19(String aaeh19) 
	{
		this.aaeh19 = aaeh19;
	}
	/**
	 * 返回 恢复经办人
	 * @return
	 */
	public String getAaeh19() 
	{
		return this.aaeh19;
	}
	public void setAaeh20(String aaeh20) 
	{
		this.aaeh20 = aaeh20;
	}
	/**
	 * 返回 恢复经办机构
	 * @return
	 */
	public String getAaeh20() 
	{
		return this.aaeh20;
	}
	public void setAaeh22(String aaeh22) 
	{
		this.aaeh22 = aaeh22;
	}
	/**
	 * 返回 恢复经办机构行政区划
	 * @return
	 */
	public String getAaeh22() 
	{
		return this.aaeh22;
	}
	public void setAcd20u(String acd20u) 
	{
		this.acd20u = acd20u;
	}
	/**
	 * 返回 信用等级
	 * @return
	 */
	public String getAcd20u() 
	{
		return this.acd20u;
	}
	public void setCcmu01(Long ccmu01) 
	{
		this.ccmu01 = ccmu01;
	}
	/**
	 * 返回 登录编号
	 * @return
	 */
	public Long getCcmu01() 
	{
		return this.ccmu01;
	}
	public void setCcmu02(Long ccmu02) 
	{
		this.ccmu02 = ccmu02;
	}
	/**
	 * 返回 是否能看到其它民营职介信息(0-不能1-能)
	 * @return
	 */
	public Long getCcmu02() 
	{
		return this.ccmu02;
	}
	public void setCcmu03(Long ccmu03) 
	{
		this.ccmu03 = ccmu03;
	}
	/**
	 * 返回 是否能看到其它职介中心信息(0-不能1-能)
	 * @return
	 */
	public Long getCcmu03() 
	{
		return this.ccmu03;
	}
	public void setCcmu04(String ccmu04) 
	{
		this.ccmu04 = ccmu04;
	}
	/**
	 * 返回 乘车路线
	 * @return
	 */
	public String getCcmu04() 
	{
		return this.ccmu04;
	}
	public void setCcmu05(Long ccmu05) 
	{
		this.ccmu05 = ccmu05;
	}
	/**
	 * 返回 机构级别1-顶级机构，2-下级机构
	 * @return
	 */
	public Long getCcmu05() 
	{
		return this.ccmu05;
	}
	public void setAcd20v(String acd20v) 
	{
		this.acd20v = acd20v;
	}
	/**
	 * 返回 简称
	 * @return
	 */
	public String getAcd20v() 
	{
		return this.acd20v;
	}
	public void setCabq01(Long cabq01) 
	{
		this.cabq01 = cabq01;
	}
	/**
	 * 返回 是否开通地图
	 * @return
	 */
	public Long getCabq01() 
	{
		return this.cabq01;
	}
	public void setCabq02(Float cabq02) 
	{
		this.cabq02 = cabq02;
	}
	/**
	 * 返回 X坐标
	 * @return
	 */
	public Float getCabq02() 
	{
		return this.cabq02;
	}
	public void setCabq03(Float cabq03) 
	{
		this.cabq03 = cabq03;
	}
	/**
	 * 返回 Y坐标
	 * @return
	 */
	public Float getCabq03() 
	{
		return this.cabq03;
	}
	public void setCabq04(Long cabq04) 
	{
		this.cabq04 = cabq04;
	}
	/**
	 * 返回 缩放比例
	 * @return
	 */
	public Long getCabq04() 
	{
		return this.cabq04;
	}
	public void setBcd202(String bcd202) 
	{
		this.bcd202 = bcd202;
	}
	/**
	 * 返回 职介机构别名
	 * @return
	 */
	public String getBcd202() 
	{
		return this.bcd202;
	}
	public void setAczy06(String aczy06) 
	{
		this.aczy06 = aczy06;
	}
	/**
	 * 返回 机构对应数据来源
	 * @return
	 */
	public String getAczy06() 
	{
		return this.aczy06;
	}
	public void setAcd20w(String acd20w) 
	{
		this.acd20w = acd20w;
	}
	/**
	 * 返回 是否应用OA 0:不应用 1:应用
	 * @return
	 */
	public String getAcd20w() 
	{
		return this.acd20w;
	}
	public void setAcd20s(String acd20s) 
	{
		this.acd20s = acd20s;
	}
	/**
	 * 返回 机构分类编号 1:职介中心 2:公办 3:高校
	 * @return
	 */
	public String getAcd20s() 
	{
		return this.acd20s;
	}

   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof SysOrg)) 
		{
			return false;
		}
		SysOrg rhs = (SysOrg) object;
		return new EqualsBuilder()
		.append(this.acd200, rhs.acd200)
		.append(this.acd201, rhs.acd201)
		.append(this.acd207, rhs.acd207)
		.append(this.acd202, rhs.acd202)
		.append(this.aae006, rhs.aae006)
		.append(this.aae007, rhs.aae007)
		.append(this.aab030, rhs.aab030)
		.append(this.ahb409, rhs.ahb409)
		.append(this.acd203, rhs.acd203)
		.append(this.acd204, rhs.acd204)
		.append(this.acd205, rhs.acd205)
		.append(this.acd208, rhs.acd208)
		.append(this.acd206, rhs.acd206)
		.append(this.aab013, rhs.aab013)
		.append(this.aab014, rhs.aab014)
		.append(this.aac004, rhs.aac004)
		.append(this.aac006, rhs.aac006)
		.append(this.aac011, rhs.aac011)
		.append(this.aab015, rhs.aab015)
		.append(this.aac026, rhs.aac026)
		.append(this.acd20b, rhs.acd20b)
		.append(this.acd20c, rhs.acd20c)
		.append(this.aab056, rhs.aab056)
		.append(this.acd20d, rhs.acd20d)
		.append(this.acd20e, rhs.acd20e)
		.append(this.acd20f, rhs.acd20f)
		.append(this.acd20g, rhs.acd20g)
		.append(this.aab049, rhs.aab049)
		.append(this.acd20m, rhs.acd20m)
		.append(this.acd20n, rhs.acd20n)
		.append(this.aab003, rhs.aab003)
		.append(this.aab007, rhs.aab007)
		.append(this.aae008, rhs.aae008)
		.append(this.aae010, rhs.aae010)
		.append(this.aab301, rhs.aab301)
		.append(this.aab201, rhs.aab201)
		.append(this.aae014, rhs.aae014)
		.append(this.aae015, rhs.aae015)
		.append(this.aae016, rhs.aae016)
		.append(this.acd20a, rhs.acd20a)
		.append(this.aae004, rhs.aae004)
		.append(this.aae005, rhs.aae005)
		.append(this.acd20k, rhs.acd20k)
		.append(this.aab034, rhs.aab034)
		.append(this.aae044, rhs.aae044)
		.append(this.aae100, rhs.aae100)
		.append(this.aae097, rhs.aae097)
		.append(this.aae098, rhs.aae098)
		.append(this.aae013, rhs.aae013)
		.append(this.aae011, rhs.aae011)
		.append(this.aae017, rhs.aae017)
		.append(this.aae019, rhs.aae019)
		.append(this.aae020, rhs.aae020)
		.append(this.aae036, rhs.aae036)
		.append(this.aae022, rhs.aae022)
		.append(this.aaea98, rhs.aaea98)
		.append(this.aaea13, rhs.aaea13)
		.append(this.aaea11, rhs.aaea11)
		.append(this.aaea17, rhs.aaea17)
		.append(this.aaea36, rhs.aaea36)
		.append(this.aaea19, rhs.aaea19)
		.append(this.aaea20, rhs.aaea20)
		.append(this.aaea22, rhs.aaea22)
		.append(this.aaeb98, rhs.aaeb98)
		.append(this.aaeb13, rhs.aaeb13)
		.append(this.aaeb11, rhs.aaeb11)
		.append(this.aaeb17, rhs.aaeb17)
		.append(this.aaeb36, rhs.aaeb36)
		.append(this.aaeb19, rhs.aaeb19)
		.append(this.aaeb20, rhs.aaeb20)
		.append(this.aaeb22, rhs.aaeb22)
		.append(this.acd20h, rhs.acd20h)
		.append(this.aaee11, rhs.aaee11)
		.append(this.aaee17, rhs.aaee17)
		.append(this.aaee36, rhs.aaee36)
		.append(this.aaee19, rhs.aaee19)
		.append(this.aaee20, rhs.aaee20)
		.append(this.aaee22, rhs.aaee22)
		.append(this.acd20p, rhs.acd20p)
		.append(this.acd20j, rhs.acd20j)
		.append(this.aaef11, rhs.aaef11)
		.append(this.aaef17, rhs.aaef17)
		.append(this.aaef36, rhs.aaef36)
		.append(this.aaef19, rhs.aaef19)
		.append(this.aaef20, rhs.aaef20)
		.append(this.aaef22, rhs.aaef22)
		.append(this.acd20q, rhs.acd20q)
		.append(this.aaeg11, rhs.aaeg11)
		.append(this.aaeg17, rhs.aaeg17)
		.append(this.aaeg36, rhs.aaeg36)
		.append(this.aaeg19, rhs.aaeg19)
		.append(this.aaeg20, rhs.aaeg20)
		.append(this.aaeg22, rhs.aaeg22)
		.append(this.acd20t, rhs.acd20t)
		.append(this.aaeh11, rhs.aaeh11)
		.append(this.aaeh17, rhs.aaeh17)
		.append(this.aaeh36, rhs.aaeh36)
		.append(this.aaeh19, rhs.aaeh19)
		.append(this.aaeh20, rhs.aaeh20)
		.append(this.aaeh22, rhs.aaeh22)
		.append(this.acd20u, rhs.acd20u)
		.append(this.ccmu01, rhs.ccmu01)
		.append(this.ccmu02, rhs.ccmu02)
		.append(this.ccmu03, rhs.ccmu03)
		.append(this.ccmu04, rhs.ccmu04)
		.append(this.ccmu05, rhs.ccmu05)
		.append(this.acd20v, rhs.acd20v)
		.append(this.cabq01, rhs.cabq01)
		.append(this.cabq02, rhs.cabq02)
		.append(this.cabq03, rhs.cabq03)
		.append(this.cabq04, rhs.cabq04)
		.append(this.bcd202, rhs.bcd202)
		.append(this.aczy06, rhs.aczy06)
		.append(this.acd20w, rhs.acd20w)
		.append(this.acd20s, rhs.acd20s)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.acd200) 
		.append(this.acd201) 
		.append(this.acd207) 
		.append(this.acd202) 
		.append(this.aae006) 
		.append(this.aae007) 
		.append(this.aab030) 
		.append(this.ahb409) 
		.append(this.acd203) 
		.append(this.acd204) 
		.append(this.acd205) 
		.append(this.acd208) 
		.append(this.acd206) 
		.append(this.aab013) 
		.append(this.aab014) 
		.append(this.aac004) 
		.append(this.aac006) 
		.append(this.aac011) 
		.append(this.aab015) 
		.append(this.aac026) 
		.append(this.acd20b) 
		.append(this.acd20c) 
		.append(this.aab056) 
		.append(this.acd20d) 
		.append(this.acd20e) 
		.append(this.acd20f) 
		.append(this.acd20g) 
		.append(this.aab049) 
		.append(this.acd20m) 
		.append(this.acd20n) 
		.append(this.aab003) 
		.append(this.aab007) 
		.append(this.aae008) 
		.append(this.aae010) 
		.append(this.aab301) 
		.append(this.aab201) 
		.append(this.aae014) 
		.append(this.aae015) 
		.append(this.aae016) 
		.append(this.acd20a) 
		.append(this.aae004) 
		.append(this.aae005) 
		.append(this.acd20k) 
		.append(this.aab034) 
		.append(this.aae044) 
		.append(this.aae100) 
		.append(this.aae097) 
		.append(this.aae098) 
		.append(this.aae013) 
		.append(this.aae011) 
		.append(this.aae017) 
		.append(this.aae019) 
		.append(this.aae020) 
		.append(this.aae036) 
		.append(this.aae022) 
		.append(this.aaea98) 
		.append(this.aaea13) 
		.append(this.aaea11) 
		.append(this.aaea17) 
		.append(this.aaea36) 
		.append(this.aaea19) 
		.append(this.aaea20) 
		.append(this.aaea22) 
		.append(this.aaeb98) 
		.append(this.aaeb13) 
		.append(this.aaeb11) 
		.append(this.aaeb17) 
		.append(this.aaeb36) 
		.append(this.aaeb19) 
		.append(this.aaeb20) 
		.append(this.aaeb22) 
		.append(this.acd20h) 
		.append(this.aaee11) 
		.append(this.aaee17) 
		.append(this.aaee36) 
		.append(this.aaee19) 
		.append(this.aaee20) 
		.append(this.aaee22) 
		.append(this.acd20p) 
		.append(this.acd20j) 
		.append(this.aaef11) 
		.append(this.aaef17) 
		.append(this.aaef36) 
		.append(this.aaef19) 
		.append(this.aaef20) 
		.append(this.aaef22) 
		.append(this.acd20q) 
		.append(this.aaeg11) 
		.append(this.aaeg17) 
		.append(this.aaeg36) 
		.append(this.aaeg19) 
		.append(this.aaeg20) 
		.append(this.aaeg22) 
		.append(this.acd20t) 
		.append(this.aaeh11) 
		.append(this.aaeh17) 
		.append(this.aaeh36) 
		.append(this.aaeh19) 
		.append(this.aaeh20) 
		.append(this.aaeh22) 
		.append(this.acd20u) 
		.append(this.ccmu01) 
		.append(this.ccmu02) 
		.append(this.ccmu03) 
		.append(this.ccmu04) 
		.append(this.ccmu05) 
		.append(this.acd20v) 
		.append(this.cabq01) 
		.append(this.cabq02) 
		.append(this.cabq03) 
		.append(this.cabq04) 
		.append(this.bcd202) 
		.append(this.aczy06) 
		.append(this.acd20w) 
		.append(this.acd20s) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("acd200", this.acd200) 
		.append("acd201", this.acd201) 
		.append("acd207", this.acd207) 
		.append("acd202", this.acd202) 
		.append("aae006", this.aae006) 
		.append("aae007", this.aae007) 
		.append("aab030", this.aab030) 
		.append("ahb409", this.ahb409) 
		.append("acd203", this.acd203) 
		.append("acd204", this.acd204) 
		.append("acd205", this.acd205) 
		.append("acd208", this.acd208) 
		.append("acd206", this.acd206) 
		.append("aab013", this.aab013) 
		.append("aab014", this.aab014) 
		.append("aac004", this.aac004) 
		.append("aac006", this.aac006) 
		.append("aac011", this.aac011) 
		.append("aab015", this.aab015) 
		.append("aac026", this.aac026) 
		.append("acd20b", this.acd20b) 
		.append("acd20c", this.acd20c) 
		.append("aab056", this.aab056) 
		.append("acd20d", this.acd20d) 
		.append("acd20e", this.acd20e) 
		.append("acd20f", this.acd20f) 
		.append("acd20g", this.acd20g) 
		.append("aab049", this.aab049) 
		.append("acd20m", this.acd20m) 
		.append("acd20n", this.acd20n) 
		.append("aab003", this.aab003) 
		.append("aab007", this.aab007) 
		.append("aae008", this.aae008) 
		.append("aae010", this.aae010) 
		.append("aab301", this.aab301) 
		.append("aab201", this.aab201) 
		.append("aae014", this.aae014) 
		.append("aae015", this.aae015) 
		.append("aae016", this.aae016) 
		.append("acd20a", this.acd20a) 
		.append("aae004", this.aae004) 
		.append("aae005", this.aae005) 
		.append("acd20k", this.acd20k) 
		.append("aab034", this.aab034) 
		.append("aae044", this.aae044) 
		.append("aae100", this.aae100) 
		.append("aae097", this.aae097) 
		.append("aae098", this.aae098) 
		.append("aae013", this.aae013) 
		.append("aae011", this.aae011) 
		.append("aae017", this.aae017) 
		.append("aae019", this.aae019) 
		.append("aae020", this.aae020) 
		.append("aae036", this.aae036) 
		.append("aae022", this.aae022) 
		.append("aaea98", this.aaea98) 
		.append("aaea13", this.aaea13) 
		.append("aaea11", this.aaea11) 
		.append("aaea17", this.aaea17) 
		.append("aaea36", this.aaea36) 
		.append("aaea19", this.aaea19) 
		.append("aaea20", this.aaea20) 
		.append("aaea22", this.aaea22) 
		.append("aaeb98", this.aaeb98) 
		.append("aaeb13", this.aaeb13) 
		.append("aaeb11", this.aaeb11) 
		.append("aaeb17", this.aaeb17) 
		.append("aaeb36", this.aaeb36) 
		.append("aaeb19", this.aaeb19) 
		.append("aaeb20", this.aaeb20) 
		.append("aaeb22", this.aaeb22) 
		.append("acd20h", this.acd20h) 
		.append("aaee11", this.aaee11) 
		.append("aaee17", this.aaee17) 
		.append("aaee36", this.aaee36) 
		.append("aaee19", this.aaee19) 
		.append("aaee20", this.aaee20) 
		.append("aaee22", this.aaee22) 
		.append("acd20p", this.acd20p) 
		.append("acd20j", this.acd20j) 
		.append("aaef11", this.aaef11) 
		.append("aaef17", this.aaef17) 
		.append("aaef36", this.aaef36) 
		.append("aaef19", this.aaef19) 
		.append("aaef20", this.aaef20) 
		.append("aaef22", this.aaef22) 
		.append("acd20q", this.acd20q) 
		.append("aaeg11", this.aaeg11) 
		.append("aaeg17", this.aaeg17) 
		.append("aaeg36", this.aaeg36) 
		.append("aaeg19", this.aaeg19) 
		.append("aaeg20", this.aaeg20) 
		.append("aaeg22", this.aaeg22) 
		.append("acd20t", this.acd20t) 
		.append("aaeh11", this.aaeh11) 
		.append("aaeh17", this.aaeh17) 
		.append("aaeh36", this.aaeh36) 
		.append("aaeh19", this.aaeh19) 
		.append("aaeh20", this.aaeh20) 
		.append("aaeh22", this.aaeh22) 
		.append("acd20u", this.acd20u) 
		.append("ccmu01", this.ccmu01) 
		.append("ccmu02", this.ccmu02) 
		.append("ccmu03", this.ccmu03) 
		.append("ccmu04", this.ccmu04) 
		.append("ccmu05", this.ccmu05) 
		.append("acd20v", this.acd20v) 
		.append("cabq01", this.cabq01) 
		.append("cabq02", this.cabq02) 
		.append("cabq03", this.cabq03) 
		.append("cabq04", this.cabq04) 
		.append("bcd202", this.bcd202) 
		.append("aczy06", this.aczy06) 
		.append("acd20w", this.acd20w) 
		.append("acd20s", this.acd20s) 
		.toString();
	}
	
	public String getAcd203Name() {
		return acd203Name;
	}
	public void setAcd203Name(String acd203Name) {
		this.acd203Name = acd203Name;
	}
	public String getAcd204Name() {
		return acd204Name;
	}
	public void setAcd204Name(String acd204Name) {
		this.acd204Name = acd204Name;
	}
	public String getFindKeyword() {
		return findKeyword;
	}
	public void setFindKeyword(String findKeyword) {
		this.findKeyword = findKeyword;
	}
	public String getName() {
		return acd202;
	}
	public String getId() {
		return String.valueOf(acd200);
	}
	public String getpId() {
		return  StringUtil.isEmpty(aab034)?"0":aab034;
	}
	
	@Override
	public String getNodeType() {
		return "org";
	}
}