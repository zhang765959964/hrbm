package com.xunfeng.core.db;

import java.io.Serializable;
import java.util.List;

import com.xunfeng.core.page.PageBean;

public class ResultData<E> implements Serializable{
	private static final long serialVersionUID = 1792241905841405420L; 
	private PageBean pageBean=null;
	
	private List<E> dataList;

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public List<E> getDataList() {
		return dataList;
	}

	public void setDataList(List<E> dataList) {
		this.dataList = dataList;
	}


	
}
