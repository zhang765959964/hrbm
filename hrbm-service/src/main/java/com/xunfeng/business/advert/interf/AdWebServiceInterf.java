package com.xunfeng.business.advert.interf;


import java.util.List;

import com.xunfeng.business.advert.model.AdWeb;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.core.web.query.QueryFilter;


/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位内容表 接口类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
public interface AdWebServiceInterf extends GenericServiceInterface<AdWeb,Long>
{  
	/**
	 * 获得所有的网站广告
	 */
	public ResultData getAllByExcept(QueryFilter queryFilter);
	
	 /**
	 * 根据标示获得网站广告(分页)
	 * 2016-05-11
	 */
	public ResultData<AdWeb> getadWebPageByIndent(PageBean pageBean,String indent);
	/**
	 * 根据标示获得全部网站广告
	 * 2016-05-11
	 */
	public List<AdWeb> getadWebByIndent(String indent);
	/**
     * 增加广告点击次数
     * @param caad01 广告主键
     */
    public void updateHitNum(Long caad01);
    /**
	 * 栏目版块中列表的排序
	 */
    public void sortOrderNum(Long id,Long orderNum);
    /**
     * 批量保存栏目中列表的排序
     */
    public void sortOrderNumBatch(Long[] lAryId);
    /**
     * 删除广告增加删除广告记录表
     * @param lAryId 广告id
     * @param currentUserName 当前操作人
     * 2016-08-03
     */
    public void delBathAdByIds(Long[] lAryId,String currentUserName);
 	  
    /**
     * 删除广告增加删除广告记录表
     * @param id 广告id
     * @param currentUserName 当前操作人
     * 2016-08-03
     */
    public void delAdById(Long id,String currentUserName);
	
}
