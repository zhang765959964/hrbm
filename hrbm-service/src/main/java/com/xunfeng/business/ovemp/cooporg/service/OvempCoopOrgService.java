package com.xunfeng.business.ovemp.cooporg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.MapBeanCopyUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.dictionary.service.DictionaryService;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.business.ovemp.cooporg.model.OvempCoopOrg;
import com.xunfeng.business.ovemp.cooporg.dao.OvempCoopOrgDao;
import com.xunfeng.business.ovemp.cooporg.interf.OvempCoopOrgServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: JW_COOP_ORG Service类
* @author:wanghan
* @createDate 2016-09-12 14:54:09 
* @version V1.0   
*/
@Service
public class OvempCoopOrgService extends BaseService<OvempCoopOrg> implements OvempCoopOrgServiceInterf
{
	@Resource
	private OvempCoopOrgDao dao;
	
	@Resource
	private DictionaryService dictionaryService;
	
	public OvempCoopOrgService()
	{
	}
	
	@Override
	protected IEntityDao<OvempCoopOrg, Long> getEntityDao() 
	{
		return dao;
	}
 
	public void update(Map dataMap,OvempCoopOrg sysOrg)
	{
		OvempCoopOrg old_SysOrg=dao.getById(sysOrg.getAcd200());
		OvempCoopOrg new_SysOrg=MapBeanCopyUtil.MapToBean(dataMap, old_SysOrg);
		dao.update(new_SysOrg);
	}
	
	/**
	 * 禁用 解禁按钮
	 * @param params
	 */
	public void updateStauts(Map<String, Object> params){
		dao.update("updateStauts", params);
	}
	
	@Override
	public List<OvempCoopOrg> getAll() {
		List<OvempCoopOrg> SysOrgs = super.getAll();
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		for (OvempCoopOrg SysOrg : SysOrgs) {
			SysOrg.setAcd203Name(String.valueOf(orgsorts.get(SysOrg.getAcd203())));
			SysOrg.setAcd204Name(String.valueOf(orgnatures.get(SysOrg.getAcd204())));
		}
		return SysOrgs;
	}
	
	@Override
	public List<OvempCoopOrg> getAll(QueryFilter queryFilter) {
		List<OvempCoopOrg> SysOrgs = super.getAll(queryFilter);
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		
		for (OvempCoopOrg SysOrg : SysOrgs) {
			SysOrg.setAcd203Name(String.valueOf(orgsorts.get(SysOrg.getAcd203())));
			SysOrg.setAcd204Name(String.valueOf(orgnatures.get(SysOrg.getAcd204())));
		}
		return SysOrgs;
	}
	
	@Override
	public ResultData<OvempCoopOrg> getPageList(QueryFilter queryFilter) {
		@SuppressWarnings("unchecked")
		List<OvempCoopOrg> SysOrgs = dao.getListForm("getAll", queryFilter);
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		
		for (OvempCoopOrg SysOrg : SysOrgs) {
			SysOrg.setAcd203Name(String.valueOf(orgsorts.get(SysOrg.getAcd203())));
			SysOrg.setAcd204Name(String.valueOf(orgnatures.get(SysOrg.getAcd204())));
		}
		ResultData<OvempCoopOrg> resultData = new ResultData<OvempCoopOrg>();
		resultData.setPageBean(queryFilter.getPageBean());
		resultData.setDataList(SysOrgs);
		return resultData;
	}
	
	@Override
	public List<OvempCoopOrg> getList(String statatementName, PageBean pb) {
		List<OvempCoopOrg> SysOrgs = super.getList(statatementName, pb);
		//机构类别字典值
		Map<String,Object> orgsorts = dictionaryService.getCacheTabMap("TAB_ORGSORT");
		//机构性质
		Map<String,Object> orgnatures = dictionaryService.getCacheTabMap("TAB_ORGNATURE");
		
		for (OvempCoopOrg SysOrg : SysOrgs) {
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
	public List<OvempCoopOrg> getSubOrgans(Long acd200) {
		return dao.getSubOrgans(acd200);
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
