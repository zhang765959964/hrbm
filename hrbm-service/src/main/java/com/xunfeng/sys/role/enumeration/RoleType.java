/**   
*  
*/


package com.xunfeng.sys.role.enumeration;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年5月25日-上午10:36:50 
 * @version V1.0   
 */
public enum RoleType {
	
     SUPERADMIN("超级管理员","0"),ORGADMIN ("单位管理员","1"), NORMAL ("一般员工","2");
	
	private  String value ;
	private  String name ;
	
	private RoleType( String name,String value) {
		
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}



	
}
