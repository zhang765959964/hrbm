package com.xunfeng.core.valid;

import java.util.ArrayList;
import java.util.List;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description:  验证表单类
* @author wanghan 
* @createDate 2015年4月23日-上午11:14:21 
* @version V1.0   
*/
public class ValidForm {
	
	/**
	 * 表单名称
	 */
	private String formName="";
	
	/**
	 * 表单字段
	 */
	private List<ValidField> listField=new ArrayList<ValidField>();

	
	
	
	public String getFormName() {
		return formName;
	}
	
	/**
	 * 表单名称。
	 * @param formName
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}

	public List<ValidField> getListField() {
		return listField;
	}

	public void setListField(List<ValidField> listField) {
		this.listField = listField;
	}
	
	/**
	 * 添加字段。
	 * @param field
	 */
	public void addField(ValidField field)
	{
		this.listField.add(field);
	}
	
	
}
