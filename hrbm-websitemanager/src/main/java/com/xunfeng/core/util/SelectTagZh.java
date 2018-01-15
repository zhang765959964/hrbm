package com.xunfeng.core.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectTagZh extends SimpleTagSupport{
	private String selectName;
	private String id;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jw = this.getJspContext().getOut();
		PageContext pc = (PageContext) (this.getJspContext());
		HttpServletRequest req = (HttpServletRequest) pc.getRequest();
		String urlpath = req.getContextPath()+"/business/careertalk/zhSysDictionary/listJson.xf?sdSelectName="+selectName;
		StringBuilder sb = new StringBuilder();
		sb.append("<select id='"+id+"' style='width:205px' panelheight='100px' name='"+selectName+"' class='easyui-combobox' data-options=\"valueField:'sdValue',textField:'sdText',url:'"+urlpath+"'\">");
		sb.append("</select>");
		jw.write(sb.toString());
	}

	public String getSelectName() {
		return selectName;
	}

	public void setSelectName(String selectName) {
		this.selectName = selectName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
