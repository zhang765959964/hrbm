package com.xunfeng.business.personagency.archive.dto;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 借阅记录表appDTO
* @author:jiangxin
* @createDate 2016-11-28 09:36:03 
* @version V1.0   
*/
public class ArchivesStatisticsDetailAppDto
{
	//窗口经办人
	protected String  windowCreateName;
	//入库总数
	protected Long storeDetailCount;
	//借阅总数
	protected Long checkoutDetailCount;
	//返还总数
	protected Long returnDetailCount;
	//调出总数
	protected Long lendDetailCount;
	
	
	public String getWindowCreateName() {
		return windowCreateName;
	}
	public void setWindowCreateName(String windowCreateName) {
		this.windowCreateName = windowCreateName;
	}
	public Long getStoreDetailCount() {
		return storeDetailCount;
	}
	public void setStoreDetailCount(Long storeDetailCount) {
		this.storeDetailCount = storeDetailCount;
	}
	public Long getCheckoutDetailCount() {
		return checkoutDetailCount;
	}
	public void setCheckoutDetailCount(Long checkoutDetailCount) {
		this.checkoutDetailCount = checkoutDetailCount;
	}
	public Long getReturnDetailCount() {
		return returnDetailCount;
	}
	public void setReturnDetailCount(Long returnDetailCount) {
		this.returnDetailCount = returnDetailCount;
	}
	public Long getLendDetailCount() {
		return lendDetailCount;
	}
	public void setLendDetailCount(Long lendDetailCount) {
		this.lendDetailCount = lendDetailCount;
	}
	
	
}