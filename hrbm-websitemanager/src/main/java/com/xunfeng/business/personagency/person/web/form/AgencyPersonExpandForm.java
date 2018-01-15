package com.xunfeng.business.personagency.person.web.form;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.web.form.PersonBaseInfoForm;
import com.xunfeng.business.person.web.form.PersonFamilyForm;
import com.xunfeng.core.model.BaseForm;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 个人基本信息拓展表 Form对象
* @author:wanlupeng
* @createDate 2016-07-06 18:11:28 
* @version V1.0   
*/
public class AgencyPersonExpandForm extends BaseForm<PersonExpand>
{
	
	
	// 个人编号
		protected Long  aac001;
		// 公民身份证号码
		protected String  aac002;
		// 军人证号
		protected String  aac00a;
		// 姓名
		protected String  aac003;
		// 性别
		protected String  aac004;
		// 民族
		protected String  aac005;
		// 出生日期
		protected java.util.Date  aac006;
		// 户口性质
		protected String  aac009;
		// 居住所在地
		protected String  aab301;
//		// 楼院
//		protected String  aac00b;
//		// 单元
//		protected String  aac00c;
//		// 门牌号
//		protected String  aac00d;
		// 户口所在地
		protected String  bab305;
		// 联系电话
		protected String  aae005;
//		// 目前住房情况
//		protected String  aac00e;
		// 文化程度
		protected String  aac011;
		// 毕业学校
		protected String  aac180;
		// 毕业时间
		protected java.util.Date  aac181;
		// 婚姻状况
		protected String  aac017;
		// 政治面貌
		protected String  aac024;
		// 健康状况
		protected String  aac033;
		// 电子信箱
		protected String  aae015;
//		// 姓名拼音码
//		protected String  aac022;
		// 邮编
		protected String  aae007;
//		// 个人英文名称
//		protected String  aac023;
//		// 血型
//		protected String  aac032;
//		// 身高
//		protected Float  aac034;
//		// 体重
//		protected Float  aac035;
//		// 视力
//		protected String  aac036;
		// 祖籍
		protected String  aac025;
		// 备注
		protected String  aae013;
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
//		// 经办机构区划
//		protected String  aae022;
//		// 会员编号
//		protected Long  ccmu01;
//		// 简历完成百分比
//		protected Long  ccmu50;
//		// 求职意向是否完整
//		protected String  ccmu51;
//		// 技能特长是否完整 
//		protected String  ccmu52;
//		// 教育经历是否完整
//		protected String  ccmu53;
//		// 工作经历 是否完整
//		protected String  ccmu54;
//		// 形象照片是否完整
//		protected String  ccmu55;
//		// 头像是否显示
//		protected String  ccmu56;
		// 数据来源（0-未知1-网站2-窗口3-民营机构4-公办机构）其他详见tab_datasources
		protected String  cczy06;
//		// 培训经历是否完整
//		protected String  ccmu57;
//		// 认证标志（0-未认证1-已上传未认证2-网站后台认证3-职介人工认证4-设备认证）
//		protected Long  ccmu58;
//		// 手机认证标志（0-未认证1-已发送未认证2-手机已认证)
//		protected Long  ccmu59;
//		// 邮件认证标志（0-未认证1-已发送未认证2-邮件已认证)
//		protected Long  ccmu60;
//		// 身份证头像
		protected String  ccmu61;
//		// 身份证扫描件
//		protected String  ccmu62;
//		// 最后修改时间
//		protected java.util.Date  ccpr05;
//		// 修改人
//		protected String  ccpr06;
//		// 修改来源
//		protected String  ccpr07;
//		// 是否删除状态（0-否1-是）
//		protected String  ccpr08;
//		// 是否有资格证书
//		protected String  ccmu63;
//		// 最后认证时间
//		protected java.util.Date  ccmu64;
//		// 年龄段标记1-（16-24岁）2-（25-34岁）3-（35-44岁）4-（45岁以上）9-无要求
//		protected String  acb223;
		// 所学专业代码
		protected String  acc01g;
//		// 户籍辖区
//		protected String  aab305;
//		// 所在辖区
//		protected String  bab301;
		// 就业失业登记证号码
		protected String  acc0m1;
//		// 设备编号
//		protected Long  div001;
//		// 个人求职卡号
//		protected String  cahy12;
//		// 个人工作经历描述
//		protected String  aac037;
//		// 个人工作经验编号,tab_workyears
//		protected String  aac038;
//		// 个人基本信息是否完整
//		protected String  ccmu70;
//		/** 就业 **/
//		// 就业失业ID
//		protected Long  acc0m01;
//		// 单位名称
//		protected String  aab004;
//		// 单位性质
//		protected String  aab019;
//		// 产业类别
//		protected String  aab054;
//		// 经济类型
//		protected String  aab020;
//		// 就业形势
//		protected String  accm02;
//		// 就业时间
//		protected java.util.Date  accm03;
//		// 签订劳动合同情况（1是2否）
//		protected String  accm04;
//		// 合同开始时间
//		protected java.util.Date  accm05;
//		// 合同结束时间
//		protected java.util.Date  accm06;
//		// 合同情况（1本县内，2本镇内，3本镇外，4本市外区，5出国务工，6外省市）
//		protected String  accm07;
//		// 出国务工外出时间
//		protected java.util.Date  accm08;
//		// 外省市外出时间
//		protected java.util.Date  accm09;
//		// 外省市工作地点代码
//		protected String  accm10;
//		// 对目前工作是否满意（1是，2否）
//		protected String  accm11;
//		// 对工作不满意的原因
//		protected String  accm12;
//		// 人员类别
//		protected String  acc20t;
//		// 灵活就业类别（1企业零散用工，2弹性就业3家政服务，4自由职业5街头自营，6打零工，7其他）
//		protected String  accm13;
//		/** 不在岗信息  **/
//		// 不在岗ID
//		protected Long  acpost01;
//		// 单位名称
//		protected String  aab004t;
//		// 单位性质
//		protected String  aab019t;
//		// 经济类型
//		protected String  aab020t;
//		// 不在岗原因（1、不安排工作岗位，2、轮岗，3、停薪留职，4、办理内退，5其他形式）
//		protected String  accm14;
//		// 不在岗原因其他形式
//		protected String  accm15;
//		// 不在岗时间
//		protected java.util.Date  accm16;
//		// 是否发放生活费（1是，2否）
//		protected String  accm17;
//		// 生活费标准
//		protected String  accm18;
//		/** 未就业以及失业 **/
//		//未就业以及失业ID
//		protected Long  acemp01;
//		// 单位名称
//		protected String  aab004m;
//		// 单位性质
//		protected String  aab019m;
//		// 经济类型
//		protected String  aab020m;
//		// 未就业及失业人员类别
//		protected String  acc20m;
//		// 未就业原因（1无就业愿望，2家庭原因，3无就业能力，4正在培训，5没有合适的工作，6年龄偏大，7对找工作丧失信心，8其他原因）
//		protected String  accm19;
//		// 失业主要原因
//		protected String  accm20;
//		// 最后一次失业登记时间
//		protected java.util.Date  accm21;
//		// 上一次劳动合同终止或解除时间
//		protected java.util.Date  accm22;
//		// 经劳动部门认定的困难群体
//		protected String  accm23;
//		/** 个人培训经历  **/
//		
//		// 培训经历编号
//		protected Long  acc0b0;
//		// 培训机构名称
//		protected String  acc0b1;
//		// 培训课程
//		protected String  acc0b2;
//		// 培训内容
//		protected String  acc0b3;
//		// 开始时间
//		protected java.util.Date  aae030;
//		// 结束时间
//		protected java.util.Date  aae031;
		/**扩展表字段**/
		// 主键id
		protected Long  expandId;
		// 主键id
		protected Long  expPersonId;
		// 参加工作时间
		protected java.util.Date  expStartJobDate;
//		// 曾用名
//		protected String  expUserName;
//		// 个人编号
//		protected String  expPersonNumber;
//		// 档案编号
//		protected String  expArchivesNumber;
//		// 通用1
//		protected String  expGengral1;
		// 原工作单位
		protected String  expOldCompany;
//		// 社保状态
//		protected Long  expSecStatus;
//		// 备注
//		protected String  expRemarks;
//		// 创建人id
//		protected Long  expOpeartorUserId;
//		// 创建时间
//		protected java.util.Date  expOpeartorDate;
//		// 视同
//		protected String  expEquate;
		// 个人状态(TAB_PSTATUS)
		protected String  expPersonStatus;
		// 联系电话(ac01中AAE005存手机号)
		protected String  expPersonPhone;
		// 户口登记日期
		protected java.util.Date  expHourseDate;
		// 详细地址
		protected String  expAddress;
		// 职务
		protected String  expPost;
		// 国家职业资格等级(TAB_COQ)
		protected String  expLevel;
		// 取得职业资格等级日期
		protected java.util.Date  expLevelDate;
//		// 职业工种资格ID（TAB_CRAFT）
//		protected String  expPositionCode;
		// 职业工种资格名称（TAB_CRAFT）
		protected String  expPositionName;
		// 专业技术职务（TAB_TITLE）
		protected String  expTechnical;
		// 取得专业技术职务资格日期
		protected java.util.Date  expTechnicalDate;
		// 是否零就业家庭（0-否，1-是）
		protected String  expIsFamily;
		// 是否就业困难人员（0-否，1-是）
		protected String  expIsDifficult;
//		// 是否转干部（0-否，1-是）
//		protected String  expIsCadre;
//		// 是否享有再就业优惠证标准（0-否，1-是）
//		protected String  expIsDiscount;
//		// 是否持有就业失业登记证（0-否，1-是）
//		protected String  expIsRegisgration;
//		// 再就业优惠证编号
//		protected String  expRegisgration;
		// 身份证住址
		protected String  expCardNumber;
		// 就业困难人员类别（TAB_EDO）
		protected String  expHardPerson;
//		//社会保障号
//		protected String  expSoctalNumber;
//		//委托单位名称
//		protected String  expEntrustCompany;
		
		/**家庭关系字段**/
		// 主键ID
		protected Long  id;
		// 配偶姓名
		protected String  faName;
		// 婚姻状况
		protected String  faMarriage;
		// 结婚时间
		protected java.util.Date  faMarriageDate;
		// 配偶身份证号
		protected String  faSpouseCard;
//		// 人员ID
//		protected Long  faPersonId;
		// 配偶出生日期
		protected java.util.Date  faSpouseBirth;
		// 配偶民族
		protected String  faSpouseNational;
		// 配偶单位
		protected String  faSpouseCompany;
		// 配偶电话
		protected String  faSpousePhone;
		// 计生情况（TAB_CONDITION）
		protected String  faBirthCondition;
		// 节育措施（TAB_BIRTHCONTROL）
		protected String  faBirthControl;
		// 家庭情况备注
		protected String  faFamilyBark;
//		//就业失业情况（1-就业，2-不在岗，3-未就业及失业，4-服刑，5-出国定居，6-在学）
//		protected String  expacc0m;
//		//标记（1-劳动力系统，0-其他系统）
//		protected String  sign;
//		//是否发送短信标志
//		protected String  nodeLogs;
		public Long getAac001() {
			return aac001;
		}
		public void setAac001(Long aac001) {
			this.aac001 = aac001;
		}
		public String getAac002() {
			return aac002;
		}
		public void setAac002(String aac002) {
			this.aac002 = aac002;
		}
		public String getAac00a() {
			return aac00a;
		}
		public void setAac00a(String aac00a) {
			this.aac00a = aac00a;
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
		public String getAac005() {
			return aac005;
		}
		public void setAac005(String aac005) {
			this.aac005 = aac005;
		}
		public java.util.Date getAac006() {
			return aac006;
		}
		public void setAac006(java.util.Date aac006) {
			this.aac006 = aac006;
		}
		public String getAac009() {
			return aac009;
		}
		public void setAac009(String aac009) {
			this.aac009 = aac009;
		}
		public String getAab301() {
			return aab301;
		}
		public void setAab301(String aab301) {
			this.aab301 = aab301;
		}
		public String getBab305() {
			return bab305;
		}
		public void setBab305(String bab305) {
			this.bab305 = bab305;
		}
		public String getAae005() {
			return aae005;
		}
		public void setAae005(String aae005) {
			this.aae005 = aae005;
		}
		public String getAac011() {
			return aac011;
		}
		public void setAac011(String aac011) {
			this.aac011 = aac011;
		}
		public String getAac180() {
			return aac180;
		}
		public void setAac180(String aac180) {
			this.aac180 = aac180;
		}
		public java.util.Date getAac181() {
			return aac181;
		}
		public void setAac181(java.util.Date aac181) {
			this.aac181 = aac181;
		}
		public String getAac017() {
			return aac017;
		}
		public void setAac017(String aac017) {
			this.aac017 = aac017;
		}
		public String getAac024() {
			return aac024;
		}
		public void setAac024(String aac024) {
			this.aac024 = aac024;
		}
		public String getAac033() {
			return aac033;
		}
		public void setAac033(String aac033) {
			this.aac033 = aac033;
		}
		public String getAae015() {
			return aae015;
		}
		public void setAae015(String aae015) {
			this.aae015 = aae015;
		}
		public String getAae007() {
			return aae007;
		}
		public void setAae007(String aae007) {
			this.aae007 = aae007;
		}
		public String getAac025() {
			return aac025;
		}
		public void setAac025(String aac025) {
			this.aac025 = aac025;
		}
		public String getAae013() {
			return aae013;
		}
		public void setAae013(String aae013) {
			this.aae013 = aae013;
		}
		public String getAae011() {
			return aae011;
		}
		public void setAae011(String aae011) {
			this.aae011 = aae011;
		}
		public String getAae017() {
			return aae017;
		}
		public void setAae017(String aae017) {
			this.aae017 = aae017;
		}
		public java.util.Date getAae036() {
			return aae036;
		}
		public void setAae036(java.util.Date aae036) {
			this.aae036 = aae036;
		}
		public String getAae019() {
			return aae019;
		}
		public void setAae019(String aae019) {
			this.aae019 = aae019;
		}
		public String getAae020() {
			return aae020;
		}
		public void setAae020(String aae020) {
			this.aae020 = aae020;
		}
		public String getAcc01g() {
			return acc01g;
		}
		public void setAcc01g(String acc01g) {
			this.acc01g = acc01g;
		}
		public String getAcc0m1() {
			return acc0m1;
		}
		public void setAcc0m1(String acc0m1) {
			this.acc0m1 = acc0m1;
		}
		public Long getExpandId() {
			return expandId;
		}
		public void setExpandId(Long expandId) {
			this.expandId = expandId;
		}
		public Long getExpPersonId() {
			return expPersonId;
		}
		public void setExpPersonId(Long expPersonId) {
			this.expPersonId = expPersonId;
		}
		public java.util.Date getExpStartJobDate() {
			return expStartJobDate;
		}
		public void setExpStartJobDate(java.util.Date expStartJobDate) {
			this.expStartJobDate = expStartJobDate;
		}
		public String getExpOldCompany() {
			return expOldCompany;
		}
		public void setExpOldCompany(String expOldCompany) {
			this.expOldCompany = expOldCompany;
		}
		public java.util.Date getExpHourseDate() {
			return expHourseDate;
		}
		public void setExpHourseDate(java.util.Date expHourseDate) {
			this.expHourseDate = expHourseDate;
		}
		public String getExpAddress() {
			return expAddress;
		}
		public void setExpAddress(String expAddress) {
			this.expAddress = expAddress;
		}
		public String getExpPost() {
			return expPost;
		}
		public void setExpPost(String expPost) {
			this.expPost = expPost;
		}
		public String getExpLevel() {
			return expLevel;
		}
		public void setExpLevel(String expLevel) {
			this.expLevel = expLevel;
		}
		public java.util.Date getExpLevelDate() {
			return expLevelDate;
		}
		public void setExpLevelDate(java.util.Date expLevelDate) {
			this.expLevelDate = expLevelDate;
		}
		public String getExpPositionName() {
			return expPositionName;
		}
		public void setExpPositionName(String expPositionName) {
			this.expPositionName = expPositionName;
		}
		public String getExpTechnical() {
			return expTechnical;
		}
		public void setExpTechnical(String expTechnical) {
			this.expTechnical = expTechnical;
		}
		public java.util.Date getExpTechnicalDate() {
			return expTechnicalDate;
		}
		public void setExpTechnicalDate(java.util.Date expTechnicalDate) {
			this.expTechnicalDate = expTechnicalDate;
		}
		public String getExpIsFamily() {
			return expIsFamily;
		}
		public void setExpIsFamily(String expIsFamily) {
			this.expIsFamily = expIsFamily;
		}
		public String getExpIsDifficult() {
			return expIsDifficult;
		}
		public void setExpIsDifficult(String expIsDifficult) {
			this.expIsDifficult = expIsDifficult;
		}
		public String getExpHardPerson() {
			return expHardPerson;
		}
		public void setExpHardPerson(String expHardPerson) {
			this.expHardPerson = expHardPerson;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFaName() {
			return faName;
		}
		public void setFaName(String faName) {
			this.faName = faName;
		}
		public String getFaMarriage() {
			return faMarriage;
		}
		public void setFaMarriage(String faMarriage) {
			this.faMarriage = faMarriage;
		}
		public java.util.Date getFaMarriageDate() {
			return faMarriageDate;
		}
		public void setFaMarriageDate(java.util.Date faMarriageDate) {
			this.faMarriageDate = faMarriageDate;
		}
		public String getFaSpouseCard() {
			return faSpouseCard;
		}
		public void setFaSpouseCard(String faSpouseCard) {
			this.faSpouseCard = faSpouseCard;
		}
		public java.util.Date getFaSpouseBirth() {
			return faSpouseBirth;
		}
		public void setFaSpouseBirth(java.util.Date faSpouseBirth) {
			this.faSpouseBirth = faSpouseBirth;
		}
		public String getFaSpouseNational() {
			return faSpouseNational;
		}
		public void setFaSpouseNational(String faSpouseNational) {
			this.faSpouseNational = faSpouseNational;
		}
		public String getFaSpouseCompany() {
			return faSpouseCompany;
		}
		public void setFaSpouseCompany(String faSpouseCompany) {
			this.faSpouseCompany = faSpouseCompany;
		}
		public String getFaSpousePhone() {
			return faSpousePhone;
		}
		public void setFaSpousePhone(String faSpousePhone) {
			this.faSpousePhone = faSpousePhone;
		}
		public String getFaBirthCondition() {
			return faBirthCondition;
		}
		public void setFaBirthCondition(String faBirthCondition) {
			this.faBirthCondition = faBirthCondition;
		}
		public String getFaBirthControl() {
			return faBirthControl;
		}
		public void setFaBirthControl(String faBirthControl) {
			this.faBirthControl = faBirthControl;
		}
		public String getFaFamilyBark() {
			return faFamilyBark;
		}
		public void setFaFamilyBark(String faFamilyBark) {
			this.faFamilyBark = faFamilyBark;
		}
		public String getExpPersonStatus() {
			return expPersonStatus;
		}
		public void setExpPersonStatus(String expPersonStatus) {
			this.expPersonStatus = expPersonStatus;
		}
		public String getCczy06() {
			return cczy06;
		}
		public void setCczy06(String cczy06) {
			this.cczy06 = cczy06;
		}
		public String getExpPersonPhone() {
			return expPersonPhone;
		}
		public void setExpPersonPhone(String expPersonPhone) {
			this.expPersonPhone = expPersonPhone;
		}
		public String getExpCardNumber() {
			return expCardNumber;
		}
		public void setExpCardNumber(String expCardNumber) {
			this.expCardNumber = expCardNumber;
		}
		public String getCcmu61() {
			return ccmu61;
		}
		public void setCcmu61(String ccmu61) {
			this.ccmu61 = ccmu61;
		}
		
}