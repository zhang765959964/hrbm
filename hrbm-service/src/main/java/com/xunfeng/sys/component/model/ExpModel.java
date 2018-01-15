/**   
*  
*/


package com.xunfeng.sys.component.model;

import java.util.ArrayList;
import java.util.List;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年6月1日-下午6:27:22 
 * @version V1.0   
 */
public class ExpModel {

//	private String sheetName;
	
	private List<String> titleList=new ArrayList();
	
	private List<List<Object>> valueList=new ArrayList();

//	public String getSheetName() {
//		return sheetName;
//	}
//
//	public void setSheetName(String sheetName) {
//		this.sheetName = sheetName;
//	}

	public List<String> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}

	public List<List<Object>> getValueList() {
		return valueList;
	}

	public void setValueList(List<List<Object>> valueList) {
		this.valueList = valueList;
	}

	
}
