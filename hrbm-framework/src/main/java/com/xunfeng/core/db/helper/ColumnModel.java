package com.xunfeng.core.db.helper;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月25日-上午11:17:47 
* @version V1.0   
*/
public class ColumnModel {
	
	private boolean pk=false;
	private String propery="";
	private String columnName="";
	private boolean canUpd=true;
	
	
	/**
	 * 取得是否为主键。
	 * @return
	 */
	public boolean getPk() {
		return pk;
	}
	public void setPk(boolean pk) {
		this.pk = pk;
	}
	
	/**
	 * 取得对象的属性。
	 * @return
	 */
	public String getPropery() {
		return propery;
	}
	public void setPropery(String propery) {
		this.propery = propery;
	}
	
	/**
	 * 对应的列名。
	 * @return
	 */
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	/**
	 * 此列是否可以更新。
	 * @return
	 */
	public boolean getCanUpd() {
		return canUpd;
	}
	public void setCanUpd(boolean canUpd) {
		this.canUpd = canUpd;
	}

}
