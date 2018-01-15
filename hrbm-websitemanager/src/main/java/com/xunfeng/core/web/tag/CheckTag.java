package com.xunfeng.core.web.tag;

import com.xunfeng.core.util.EnumUtil;
import com.xunfeng.core.util.StringUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import java.util.Map;

public class CheckTag extends TagSupport {
	private static Logger logger=LoggerFactory.getLogger(CheckTag.class);
	/**
	 * 表格名称
	 */
	private String enumName;

	private String value;
	
	private String id;
	
	private String name;


	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int doStartTag() throws JspException {	
	 JspWriter out=pageContext.getOut();
	 HttpServletRequest request=(HttpServletRequest)pageContext.getRequest();
	 try{
		 Map<String,String> map= EnumUtil.parseEnum(this.enumName);
		 StringBuffer html_sb=new StringBuffer();
		 html_sb.append("<div class=\"checkbox\">");
		 for(Map.Entry<String, String> entry : map.entrySet()) {
			 String key=entry.getKey();
			 String value=entry.getValue();
			 String checked=contains(this.value,key)?"checked":"";
			 html_sb.append("<input name=\""+name+"\"  "+checked+" type=\"checkbox\" value=\""+key+"\">"+"<span class=\"monthNum\"> "+value+"</span>"+ "");
		 }
		 html_sb.append("</div>");
		 out.println(html_sb.toString());
		 
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }
	 return EVAL_BODY_INCLUDE;  //SKIP_BODY;
	}
	
	private boolean contains(String value,String key){
		if(StringUtil.isEmpty(value)){
			return false;
		}
		boolean flag=false;
		String[]   value_array=value.split(",");
		
		for(String oneValue:value_array){
			if(oneValue.equals(key)){
				flag=true;
				break;
			}
			
		}
		
		return flag;
	}
	
	
}

