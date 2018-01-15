package com.xunfeng.core.web.tag;

import com.xunfeng.core.db.datasource.DataSourceUtil;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutTag extends TagSupport {
	private static Logger logger=LoggerFactory.getLogger(OutTag.class);
	
	/**
	 * 表格名称
	 */
	private String tableName;
	/**
	 * 下拉框值字段
	 */
	private String valueField;
	/**
	 * 下拉框显示值字段
	 */
	private String textField;
	
	private String value;
	


	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getValueField() {
		return valueField;
	}



	public void setValueField(String valueField) {
		this.valueField = valueField;
	}



	public String getTextField() {
		return textField;
	}



	public void setTextField(String textField) {
		this.textField = textField;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}



	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int doStartTag() throws JspException {	
	 JspWriter out=pageContext.getOut();
	 HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
	 try{
			DictionaryServiceInterf dictionaryService = (DictionaryServiceInterf) AppUtil
					.getBean("dictionary");

			List<Map<String, Object>> list = dictionaryService.getTabList(
					valueField, textField, tableName, "");
		 
		 StringBuffer html_sb=new StringBuffer();

		 Map valueMap=new HashMap();
		 if(StringUtil.isNotEmpty(this.getValue())){
			 String[] value_array= this.getValue().split(",");
			 for(String value :value_array){
				 valueMap.put(value,value);
			 }
		 }
         boolean flag=false;
		 for(Map itemMap: list){
			 String itemValue=itemMap.get("valueField").toString();			 
			 String itemText=(String)itemMap.get("textField");			
			 if(valueMap.get(itemValue)!=null){
				 if(flag){
					 html_sb.append(","+itemText);
				 }else{
					 html_sb.append(itemText);
					 flag=true;
				 }

			 }
			 			 
		 }
		 out.println(html_sb.toString());
		 
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }
	 return EVAL_BODY_INCLUDE;  //SKIP_BODY;
	}
	
}
