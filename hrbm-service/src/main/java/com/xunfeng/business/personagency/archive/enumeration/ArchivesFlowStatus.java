/**   
*  
*/


package com.xunfeng.business.personagency.archive.enumeration;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年5月25日-上午10:37:06 
 * @version V1.0   
 */
public enum ArchivesFlowStatus {
	/** 
	 * "100"代表归档状态，就是一条借阅流程完成
	 */
	
	outregist(0,1), outconfirm (1,3),inconfirm(3,100);

	private  int value ;
	private  int nextStatusValue ;
	
	private ArchivesFlowStatus(int value,int nextStatusValue) {

		this.value = value;
		this.nextStatusValue = nextStatusValue;
	}

	public int getValue() {
		return value;
	}
	public int getNextStatusValue() {
		return nextStatusValue;
	}
}
