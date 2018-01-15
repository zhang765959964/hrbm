package com.xunfeng.sys.console.service;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 系统标识常量
* @author wanghan 
* @createDate 2015年4月23日-上午9:54:51 
* @version V1.0   
*/
public class SystemConst {
	/**ISysRole const**/
	private final static String ROLE_SUPER  = "ROLE_SUPER";//超级
	private final static String ROLE_PUBLIC  = "ROLE_PUBLIC";//公共角色
	private final static String ROLE_ANONYMOUS  = "ROLE_ANONYMOUS";//匿名级
	private final static String ROLE_NOROLE="ROLE_NOROLE";//没有角色
	
	public final static GrantedAuthority ROLE_GRANT_SUPER=new GrantedAuthorityImpl(SystemConst.ROLE_SUPER);
	public final static ConfigAttribute  ROLE_CONFIG_PUBLIC=new SecurityConfig(SystemConst.ROLE_PUBLIC);
	public final static ConfigAttribute  ROLE_CONFIG_ANONYMOUS=new SecurityConfig(SystemConst.ROLE_ANONYMOUS);
	public final static ConfigAttribute  ROLE_CONFIG_NOROLE=new SecurityConfig(SystemConst.ROLE_NOROLE);
	/**ISysOrg const**/
	private static final long serialVersionUID = 1L;
	public final static Long BEGIN_DEMID=1L;//默认维度
	public final static Long BEGIN_ORGID=1L;//默认组织ID
	public final static Integer BEGIN_DEPTH=0;//默认深度
	public final static String BEGIN_PATH="1";//默认路径
	public final static Short BEGIN_TYPE=1;//默认组织类型
	public final static Long BEGIN_ORGSUPID=-1L;//默认组织父ID
	public final static Short BEGIN_SN=1;//默认sn
	public final static Short BEGIN_FROMTYPE=0;//默认组织类型
	
	/**ISysUser const**/
	public final static String SEARCH_BY_ROL = "1";// 从角色
	public final static String SEARCH_BY_ORG = "2";// 从组织
	public final static String SEARCH_BY_POS = "3";// 从岗位
	public final static String SEARCH_BY_ONL = "4";// 从在线
	
	/**
	 * 账号未锁定
	 */
	public final static Short UN_LOCKED = 0;
	/**
	 * 账号被锁定
	 */
	public final static Short LOCKED = 1;

	/**
	 * 账号未期
	 */
	public final static Short UN_EXPIRED = 0;

	/**
	 * 账号过期
	 */
	public final static Short EXPIRED = 1;

	/**
	 * 账号激活
	 */
	public final static Short STATUS_OK = 1;

	/**
	 * 账号禁用
	 */
	public final static Short STATUS_NO = 0;
	/**
	 * 账号删除
	 */
	public final static Short STATUS_Del = -1;
	
	/**
	 * 数据来自系统添加
	 */
	public final static Short FROMTYPE_DB=0;
	/**
	 * 数据来自AD同步,并在系统中未被设置
	 */
	public final static Short FROMTYPE_AD=1;
	/**
	 * 数据来自AD同步,并在系统中被设置过
	 */
	public final static Short FROMTYPE_AD_SET=2;
	/**
	 * 系统用户ID(任务到期时，系统自动处理任务时使用)
	 */
	public final static Long SYSTEMUSERID = 0L;
	/**
	 * 系统用户名(任务到期时，系统自动处理任务时使用)
	 */	
	public final static String SYSTEMUSERNAME = "系统";
	/**
	 * cglib转换json为对象时，需要在json的key前面添加的前缀
	 */
	public final static String CGLIB_PREFIX = "$cglib_prop_";
	
	/**
	 * 
	 */
	public final static String fileDirectory = "fileDirectory";
	
	/**
	 * 数据来源BS  2016.04.15
	 */
	public final static String DATA_SOURCE_BS = "18";//数据来源
	
	/**
	 * 发布范围TAB
	 */
	public final static String TAB_INFOPUBPAT = "TAB_INFOPUBPAT";
	/**
	 * 是否是超级用户
	 */
	public static final String KEY_MANAGER = "xfmanager";
	/**
	 * 是否查看子级机构标志KEY
	 */
	public static final String KEY_SYS_VIEW_SUB = "sys_view_sub";

	/**
	 * 可操作查看平台数据编号KEY
	 */
	public static final String KEY_VIEW_SYS_DEFUALT_PLANT = "sys_defualt_plant";

	/**
	 * 是否展示子级数据值
	 */
	public static final String VIEW_SUB_VALUE = "1";

	/**
	 * 是否开启对企业从网站发布委托招聘信息自动审核功能0-开启1-关闭
	 */
	public static final String KEY_JOB_IS_AUDIT = "audit_gb_wtzp";

	/**
	 * 0
	 */
	public static final String STATIC_VALUE_ZERO = "0";

	/**
	 * 1
	 */
	public static final String STATIC_VALUE_ONE = "1";
	
	/**
	 * 2
	 */
	public static final String STATIC_VALUE_TWO = "2";
	
	/**
	* 是否查看子级培训机构标志KEY,"0":不可以，"1":可以
	*/
	public static final String KEY_PX_VIEW_SUB = "px_view_sub";

	/**
	* 新增的培训机构是否需要审核 ,"0":不需要，"1":需要
	*/
	public static final String KEY_PX_ORG_IS_AUDIT = "px_org_is_audit";

	/**
	* 新增的培开班是否需要审核 ,"0":不需要，"1":需要
	*/
	public static final String KEY_PX_COURSE_IS_AUDIT = "px_course_is_audit";
	
	/**
	 * 类型BS
	 */
	public static final String BS_TYPE = "BS";
	/**
	 * 类型CS
	 */
	public static final String CS_TYPE = "CS";
}
