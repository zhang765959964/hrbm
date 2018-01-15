package com.xunfeng.core.web.tag;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.dictionary.interf.DictionaryServiceInterf;

public class SelectTag extends TagSupport {
	private static Logger logger = LoggerFactory.getLogger(SelectTag.class);

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

	private String id;

	private String name;

	private String hasDefault;

	private String hasDefaultName;
	
	/**
	 * 是否显示Code
	 */
	private String isShowCode;	

	private String valueCon;

	private String pidName;

	private String pidValue;

	/**
	 * class样式
	 */
	private String selectClass;
	/**
	 * 是否没有样式
	 */
	private boolean isNoStyle = false;

	/**
	 * 是否只输出属性选择
	 */
	private boolean isOnlyOptions = false;
	
	private String disabled;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getValueField() {
		return valueField;
	}

	public String getSelectClass() {
		return selectClass;
	}

	public void setSelectClass(String selectClass) {
		this.selectClass = selectClass;
	}

	public String getIsShowCode() {
		return isShowCode;
	}

	public void setIsShowCode(String isShowCode) {
		this.isShowCode = isShowCode;
	}
	
	public String getHasDefaultName() {
		return hasDefaultName;
	}

	public void setHasDefaultName(String hasDefaultName) {
		this.hasDefaultName = hasDefaultName;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getTextField() {
		return textField;
	}

	public String getPidName() {
		return pidName;
	}

	public void setPidName(String pidName) {
		this.pidName = pidName;
	}

	public String getPidValue() {
		return pidValue;
	}

	public void setPidValue(String pidValue) {
		this.pidValue = pidValue;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHasDefault() {
		return hasDefault;
	}

	public void setHasDefault(String hasDefault) {
		this.hasDefault = hasDefault;
	}

	public String getValueCon() {
		return valueCon;
	}

	public void setValueCon(String valueCon) {
		this.valueCon = valueCon;
	}

	public boolean getIsNoStyle() {
		return isNoStyle;
	}

	public void setIsNoStyle(boolean isNoStyle) {
		this.isNoStyle = isNoStyle;
	}

	public boolean getIsOnlyOptions() {
		return isOnlyOptions;
	}

	public void setIsOnlyOptions(boolean isOnlyOptions) {
		this.isOnlyOptions = isOnlyOptions;
	}
	

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		try {

			Object[] valueConParam = null;
			String sqlCondi = "";
			if(StringUtils.isNotBlank(valueCon)){
				 valueConParam=valueCon.split(",");
				String preParamWildcard= StringUtil.getPreParamWildcard(valueCon);
				sqlCondi=valueField+" in "  +"("+valueCon+")";
			 }
			 
			if (StringUtils.isNotBlank(pidName)) {
				if (StringUtils.isNotBlank(valueCon)) {
					sqlCondi += " and ";
				}
				sqlCondi += pidName;
				if (StringUtils.isNotBlank(pidValue)) {
					/*sqlCondi += " = ".concat(pidValue);*/
					sqlCondi += " in " +"("+pidValue+")";
				} else {
					sqlCondi += " is null ";
				}
			}

			DictionaryServiceInterf dictionaryService = (DictionaryServiceInterf) AppUtil
					.getBean("dictionary");

			List<Map<String, Object>> list = dictionaryService.getTabList(
					valueField, textField, tableName, sqlCondi);

			StringBuffer html_sb = new StringBuffer();
			
			
			if (!isOnlyOptions) {
				html_sb.append("<select  ")
						.append(StringUtil.isNotEmpty(selectClass) ? "class='"
								.concat(selectClass).concat("'") : "")
						.append(StringUtil.isNotEmpty(disabled) ? "disabled=\""
								.concat(disabled).concat("\"") : "")
						.append(" id='" + id + "' name='" + name + "'  > ");
				if (StringUtils.isNotBlank(hasDefault)
						&& "0".equals(hasDefault)) {
					html_sb.append(StringUtils.isNotEmpty(hasDefaultName) ? "<option value=''>"
							.concat(hasDefaultName).concat("</option>")
							: "<option value=''>--请选择--</option>");
				}
			}
			for (Map itemMap : list) {
				String itemValue = itemMap.get("valueField").toString();
				String itemText = (String) itemMap.get("textField");
				if (itemValue != null && itemValue.equals(value)) {
					html_sb.append("<option selected='selected' value='"
							+ itemValue + "'> " + itemText + "</option>");
				} else {
					if (StringUtils.isNotBlank(isShowCode)
							&& "true".equals(isShowCode)) {
						html_sb.append("<option value='" + itemValue + "'> "
								+itemValue+ itemText + "</option>");
						
					}else{
						html_sb.append("<option value='" + itemValue + "'> "
								+ itemText + "</option>");
					}
					
					
				}

			}
			if (!isOnlyOptions)
				html_sb.append(" </select> ");
			out.println(html_sb.toString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return EVAL_BODY_INCLUDE; // SKIP_BODY;
	}

}
