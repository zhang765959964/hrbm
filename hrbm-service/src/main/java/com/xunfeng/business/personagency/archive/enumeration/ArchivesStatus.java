/**   
*  
*/


package com.xunfeng.business.personagency.archive.enumeration;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年5月25日-上午10:36:50 
 * @version V1.0   
 */
public enum ArchivesStatus {
	
     noStorage("",0), storage ("",1),checkOut ("",2),callOut("",3),;
	
	private  int value ;
	private  String name ;
	
	private ArchivesStatus( String name,int value) {
		
		this.name = name;
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
}
