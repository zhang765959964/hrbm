package com.xunfeng.core.web.controller;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.web.util.RequestUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 业务处理Controller基类
* @author wanghan 
* @createDate 2015年4月23日-上午11:11:21 
* @version V1.0   
*/
public class BaseController extends GenericController
{
	public static final String Message="message";
	

	/**
	 * 过滤easyui datagrid 分页参数数据
	 * page ---currentPage 当前页
	 * rows---pageSize  页行数
	 * sort--     排序字段
	 * order--    排序方向
	 *多个排序字段用逗号隔开
	 */

	protected PageBean translateToPageInfo(HttpServletRequest request){
		int currentPage =  RequestUtil.getInt(request, "page");
		int pageSize =  RequestUtil.getInt(request, "rows");
		return  new PageBean(currentPage,pageSize);
	}
	
	/**
	 * 把查询数据转换为datagrid能显示的数据类型
	 */
	protected Map<Object,Object> getTableData(long total,List data){
		Map<Object,Object> result = new HashMap<Object,Object>();
		result.put("total", total);
		result.put("rows", data);
		return result;
	}
	
	/**
	 * 把查询数据转换为datagrid能显示的数据类型
	 */
	protected Map<Object,Object> getJqGridData(PageBean pageBean,List data){
		Map<Object,Object> result = new HashMap<Object,Object>();
		result.put("total", pageBean.getTotalPage());
		result.put("page", pageBean.getCurrentPage());
		result.put("records", pageBean.getTotalCount());
		result.put("rows", data);
		return result;
	}
	protected Map<Object,Object> getJqGridData(PageBean pageBean,Long totalCount,Long storeCount,Long checkoutCount,Long returnCount,Long lendCount,List data){
		Map<Object,Object> result = new HashMap<Object,Object>();
		result.put("total", pageBean.getTotalPage());
		result.put("page", pageBean.getCurrentPage());
		result.put("records", pageBean.getTotalCount());
		result.put("totalCount", totalCount);
		result.put("storeCount", storeCount);
		result.put("checkoutCount", checkoutCount);
		result.put("returnCount", returnCount);
		result.put("lendCount", lendCount);
		result.put("rows", data);
		return result;
	}
	public static PageBean WrapPageBean(int limit,int offset){
		PageBean pageBean = new PageBean((offset/limit)+1,limit);
		return pageBean;
	}
}
