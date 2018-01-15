package com.xunfeng.business.advert.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.advert.dao.AdWebDao;
import com.xunfeng.business.advert.interf.AdWebServiceInterf;
import com.xunfeng.business.advert.model.AdWeb;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位内容表 Service类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
@Service
public class AdWebService extends BaseService<AdWeb> implements AdWebServiceInterf
{
	@Resource
	private AdWebDao dao;
	@Resource
	private AdDelRecordService adDelRecordService;
	
	
	public AdWebService()
	{
	}
	
	@Override
	protected IEntityDao<AdWeb, Long> getEntityDao() 
	{
		return dao;
	}
	/**
	 * 网站后台中列表数据
	 */
	public ResultData getAllByExcept(QueryFilter queryFilter){
    	List<Map> dataList = dao.getListForm("getAllWebByExcept",queryFilter);		
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(dataList);
		return resultData;
	}
	 /**
	 * 根据标示获得网站广告(分页)(网站前台使用)
	 * 2016-05-11
	 */
	public ResultData<AdWeb> getadWebPageByIndent(PageBean pageBean,String indent){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("indent", indent);
		params.put("caad06", "1");
		List<AdWeb> adwebList = dao.getList("getadWebByIndent", params, pageBean);
		ResultData<AdWeb> resultData = new ResultData<AdWeb>();
		resultData.setPageBean(pageBean);
		resultData.setDataList(adwebList);
		return resultData;
	}
	/**
	 * 根据标示获得全部网站广告
	 * 2016-05-11
	 */
	public List<AdWeb> getadWebByIndent(String indent){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("indent", indent);
		return dao.getBySqlKey("getadWebByIndent", indent);
	}
	 /**
     * 增加广告点击次数
     * @param caad01 广告主键
     */
    public void updateHitNum(Long caad01){
    	Map<String,Object> map = new HashMap<String, Object>();
    	map.put("CAAD01", caad01);
    	dao.update("updateHitNum", map);
    }
    /**
	 * 栏目版块中列表的排序
	 */
    public void sortOrderNum(Long id,Long orderNum){
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("id", id);
    	map.put("ordernum", orderNum);
    	dao.update("updateOrderNum", map);
    }
    /**
     * 批量保存栏目中列表的排序
     */
    public void sortOrderNumBatch(Long[] lAryId){
    	for(int i=0;i<lAryId.length;i++){
			sortOrderNum(lAryId[i], (long)i);
		}
    }
    /**
     * 删除广告增加删除广告记录表
     * @param lAryId 广告id
     * @param currentUserName 当前操作人
     * 2016-08-03
     */
    
    public void delBathAdByIds(Long[] lAryId,String currentUserName){
 	  for(Long id : lAryId){
 		  delAdById(id,currentUserName);
 	  }
    }
    /**
     * 删除广告增加删除广告记录表
     * @param id 广告id
     * @param currentUserName 当前操作人
     * 2016-08-03
     */
    public void delAdById(Long id,String currentUserName){
    	 adDelRecordService.addRecordWebAdById(id,currentUserName);
    	 this.delById(id);
    }
}
