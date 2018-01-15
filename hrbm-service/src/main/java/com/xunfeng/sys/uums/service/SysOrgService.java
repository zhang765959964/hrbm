package com.xunfeng.sys.uums.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.MapBeanCopyUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.dictionary.service.DictionaryService;
import com.xunfeng.sys.uums.dao.SysOrgDao;
import com.xunfeng.sys.uums.interf.SysOrgServiceInterf;
import com.xunfeng.sys.uums.model.SysOrg;

/**
 *<pre>
 * 对象功能:职介机构表 Service类
 * 开发公司:河南讯丰信息技术有限公司
 * 开发人员:wanghan
 * 创建时间:2015-04-29 16:03:27
 *</pre>
 */
@Service
public class SysOrgService extends BaseService<SysOrg> implements SysOrgServiceInterf
{
	@Resource
	private SysOrgDao dao;
	
	@Resource
	private DictionaryService dictionaryService;
	
	public SysOrgService()
	{
	}
	
	@Override
	protected IEntityDao<SysOrg, Long> getEntityDao() 
	{
		return dao;
	}
	public void update(Map dataMap,SysOrg sysOrg)
	{
		SysOrg old_SysOrg=dao.getById(sysOrg.getAcd200());
		SysOrg new_SysOrg=MapBeanCopyUtil.MapToBean(dataMap, old_SysOrg);
		dao.update(new_SysOrg);
	}
	
	@Override
	public List<SysOrg> getAll() {
		List<SysOrg> SysOrgs = super.getAll();
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		for (SysOrg SysOrg : SysOrgs) {
			SysOrg.setAcd203Name(String.valueOf(orgsorts.get(SysOrg.getAcd203())));
			SysOrg.setAcd204Name(String.valueOf(orgnatures.get(SysOrg.getAcd204())));
		}
		return SysOrgs;
	}
	
	@Override
	public List<SysOrg> getAll(QueryFilter queryFilter) {
		List<SysOrg> SysOrgs = super.getAll(queryFilter);
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		
		for (SysOrg SysOrg : SysOrgs) {
			SysOrg.setAcd203Name(String.valueOf(orgsorts.get(SysOrg.getAcd203())));
			SysOrg.setAcd204Name(String.valueOf(orgnatures.get(SysOrg.getAcd204())));
		}
		return SysOrgs;
	}
	
	@Override
	public ResultData<SysOrg> getPageList(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<SysOrg> SysOrgs = dao.getListForm("getAll", queryFilter);
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		
		for (SysOrg SysOrg : SysOrgs) {
			SysOrg.setAcd203Name(String.valueOf(orgsorts.get(SysOrg.getAcd203())));
			SysOrg.setAcd204Name(String.valueOf(orgnatures.get(SysOrg.getAcd204())));
		}
		ResultData<SysOrg> resultData = new ResultData<SysOrg>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(SysOrgs);
		return resultData;
	}
	
	@Override
	public List<SysOrg> getList(String statatementName, PageBean pb) {
		List<SysOrg> SysOrgs = super.getList(statatementName, pb);
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		
		for (SysOrg SysOrg : SysOrgs) {
			SysOrg.setAcd203Name(String.valueOf(orgsorts.get(SysOrg.getAcd203())));
			SysOrg.setAcd204Name(String.valueOf(orgnatures.get(SysOrg.getAcd204())));
		}
		return SysOrgs;
	}
	
	/**
	 * 查询机构下所有子节点
	 * @param acd200 机构编码
	 * @return 机构列表
	 */
	public List<SysOrg> getSubOrgans(Long acd200) {
		return dao.getSubOrgans(acd200);
	}
	
	/**
	 * 查询机构下的一级节点
	 * @param acd200 机构编码
	 * @return 机构列表
	 */
	public List<SysOrg> getSubOrgList(Long acd200) {
		Map map =new HashMap();
		map.put("aab034", acd200);
		return dao.getBySqlKey("getAll", map);
	}
	/**
	 * 递归查询子级机构
	 * @param parentNodes 父级机构
	 * @return
	 */
	private List<SysOrg> getSubList(List<SysOrg> SysOrgs,String parentNodes){
		List<SysOrg> subs = new ArrayList<SysOrg>();
		for (SysOrg SysOrg : subs) {
			
		}
		return SysOrgs;
	}
	/**
	 * 查询服务结构
	 * @return
	 */
	public  ResultData<Map> getSysOrgByExcept(PageBean pageBean,Map<String,String> param){
		QueryFilter qfilter = new QueryFilter();
		qfilter.setPageBean(pageBean);
		QueryFilter fiter=new QueryFilter();
		fiter.setPageBean(pageBean);
		String servicekey = param.get("servicekey");
		String localCity = param.get("localCity");
		if (StringUtil.isNotEmpty(servicekey) && !servicekey.equals("0")){
			fiter.addFilter("servicekey","%"+servicekey+"%");
		}
		if(StringUtil.isNotEmpty(localCity) && !localCity.equals("0")){
			fiter.addFilter("localCity",localCity);
		}
		List<Map> dataList = (List<Map>)dao.getListForm("getSysOrgByExcept",fiter);
		ResultData<Map> resultData = new ResultData<Map>();
		resultData.setPageBean(fiter.getPageBean());
		resultData.setDataList(dataList);
		return  resultData;
	}
	
}
