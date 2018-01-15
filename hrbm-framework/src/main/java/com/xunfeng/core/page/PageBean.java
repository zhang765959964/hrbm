package com.xunfeng.core.page;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.util.RequestUtil;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 分页信息
* @author wanghan 
* @createDate 2015年4月23日-下午12:03:26 
* @version V1.0   
*/
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class PageBean implements Serializable
{
	/**
	 * 显示页数
	 */
	public static Integer SHOW_PAGES=6;
	/**
	 * 缺省的页大小
	 */
	public static final Integer DEFAULT_PAGE_SIZE=20;

	private int pageSize=DEFAULT_PAGE_SIZE;
	//当前页数
	private int currentPage=1;
	//总条数
	private int totalCount = 0;
	//总页数
	private int totalPage = 0;
	//为了支持一个页面多个分页DEFAULT_PAGE_SIZE
	private String pageName = "page";
	private String pageSizeName = "pageSize";
	
	/*是否显示总页数，当记录数比较大是，查询总记录数是会比较耗时的，
	 * 所以有时为了提高查询性能，会把这记录去掉
	 */
	private boolean showTotal=true;
	
	private boolean isHasPreviousPage=true;
	private boolean isHasNextPage=true;

	public PageBean()
	{

	}

	public PageBean(int currentPage,int pageSize)
	{
		this.currentPage=currentPage;
		this.pageSize=pageSize;
	}
	
	public PageBean(HttpServletRequest request)
	{
		int page=RequestUtil.getInt(request, "page");
		int pageSize=RequestUtil.getInt(request,"rows",PageBean.DEFAULT_PAGE_SIZE);
		this.currentPage=page;
		this.pageSize=pageSize;
	}

	/**
	 * 设置当前页
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage)
	{
		this.currentPage=currentPage;
	}
	
	public void setPagesize(int pageSize)
	{
		this.pageSize=pageSize;
	}
	
	public void setPageName(String pageName)
	{
		this.pageName=pageName;
	}

	public String getPageName()
	{
		if(StringUtil.isEmpty(this.pageName))
			return "page";
		return this.pageName;
	}

	public String getPageSizeName()
	{
		if(StringUtil.isEmpty(this.pageSizeName))
			return "pageSize";
		return this.pageSizeName;
	}

	/**
	 * 是否是首页（第一页），第一页页码为1
	 * @return 首页标识
	 */
	public boolean isFirstPage()
	{
		return getCurrentPage() == 1;
	}

	/**
	 * 是否是最后一页
	 * @return 末页标识
	 */
	public boolean isLastPage()
	{
		return getCurrentPage() >= getLastPage();
	}

	/**
	 * 是否有下一页
	 * @return 下一页标识
	 */
	public boolean isHasNextPage()
	{
		return getLastPage() > getCurrentPage();
	}

	/**
	 * 是否有上一页
	 * @return 上一页标识
	 */
	public boolean isHasPreviousPage()
	{
		return getCurrentPage() > 1;
	}

	/**
	 * 获取最后一页页码，也就是总页数
	 * @return 最后一页页码
	 */
	public int getLastPage()
	{
		return PageUtils.getTotalPage(totalCount, pageSize);
	}

	/**
	 * 总的数据条目数量，0表示没有数据
	 * @return 总数量
	 */
	public int getTotalCount()
	{
		return totalCount;
	}

	/**
	 * 设置总的记录数
	 * @param count
	 */
	public void setTotalCount(int count)
	{
		this.totalCount = count;
		this.totalPage=getTotalPage();
		this.isHasPreviousPage=isHasPreviousPage();
		this.isHasNextPage=isHasNextPage();
		
	}

	/**
	 * 取得总的页数
	 * @return
	 */
	public int getTotalPage()
	{
		int page = this.totalCount / this.pageSize;
		int tmp = this.totalCount % this.pageSize;
		return page + ((tmp == 0) ? 0 : 1);
	}

	/**
	 * 获取当前页的首条数据的行编码
	 * @return 当前页的首条数据的行编码
	 */
	public int getThisPageFirstElementNumber()
	{
		return (getCurrentPage() - 1) * getPageSize() + 1;
	}

	/**
	 * 获取当前页的末条数据的行编码
	 * @return 当前页的末条数据的行编码
	 */
	public int getThisPageLastElementNumber()
	{
		int fullPage = getThisPageFirstElementNumber() + getPageSize() - 1;
		return getTotalCount() < fullPage ? getTotalCount() : fullPage;
	}

	/**
	 * 获取下一页编码
	 * @return 下一页编码
	 */
	public int getNextPage()
	{
		return getCurrentPage() + 1;
	}

	/**
	 * 获取上一页编码
	 * @return 上一页编码
	 */
	public int getPreviousPage()
	{
		return getCurrentPage() - 1;
	}

	/**
	 * 每一页显示的条目数
	 * @return 每一页显示的条目数
	 */
	public int getPageSize()
	{
		return pageSize;
	}

	public boolean isShowTotal() {
		return showTotal;
	}

	public void setShowTotal(boolean showTotal) {
		this.showTotal = showTotal;
	}

	/**
	 * 当前页的页码
	 * @return 当前页的页码
	 */
	public int getCurrentPage()
	{
		return currentPage;
	}

	/**
	 * 得到用于多页跳转的页码
	 * @return
	 */
	public List<Integer> getLinkPageNumbers()
	{
		return PageUtils.getPageNumbers(getCurrentPage(), getLastPage(), 10);
	}

	/**
	 * 得到当前页的数据库的第一条记录号
	 * @return
	 */
	public int getFirst()
	{
		return PageUtils.getFirstNumber(currentPage, pageSize);
	}
	/**
	 * 取得当前页的数据库的最后条记录号
	 * @return
	 */
	public int getLast()
	{
		return PageUtils.getLastNumber(currentPage,pageSize,totalCount);
	}
	
	/**
	 * 获取显示的页数的记录数组
	 * @return
	 */
	public Integer[] getPageArr(){
		int totalPages=getTotalPage();
		int minPage=1;
		int maxPage=totalPages;
		if(currentPage==1){
			maxPage=SHOW_PAGES;
		}else{
			minPage=currentPage-(SHOW_PAGES/2+ SHOW_PAGES%2);
			if(minPage<=0){
				minPage=1;
			}
			maxPage=minPage+SHOW_PAGES-1;
		}
		if(maxPage>totalPages){
			maxPage=totalPages;
		}
		Integer[]arrs=new Integer[maxPage-minPage+1];
		for(int i=0;i<arrs.length;i++){
			arrs[i]=minPage+i;
		}
		return arrs;
	}
	
	
}
