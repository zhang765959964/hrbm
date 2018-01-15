package com.xunfeng.business.personagency.archive.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.archive.dao.ArchivesDao;
import com.xunfeng.business.personagency.archive.dto.ArchiveAppDto;
import com.xunfeng.business.personagency.archive.dto.ArchivesStatisticsAppDto;
import com.xunfeng.business.personagency.archive.dto.ArchivesStatisticsDetailAppDto;
import com.xunfeng.business.personagency.archive.dto.StorageArchiveAppDto;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Service类
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
@Service
public class ArchivesService extends BaseService<Archives> implements ArchivesServiceInterf
{
	@Resource
	private ArchivesDao dao;
	
	
	
	public ArchivesService()
	{
	}
	
	@Override
	protected IEntityDao<Archives, Long> getEntityDao() 
	{
		return dao;
	}
	/**
	 * @param fiter 档案查询
	 * @return
	 */
	public ResultData  getAllArchives(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getListCustomPage("getAllArchives_customPage", "getAllArchives_customPage_count", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//根据personId 获取个人详细信息
	public Map getPersonBaseinfoByPersonId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		return (Map)dao.getOne("getAllArchives", params);
	}
	
	//手机app接口调出数据接口 2016.11.22
	public ResultData<StorageArchiveAppDto> getAllArchivesApp(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<StorageArchiveAppDto> dataList= dao.getListForm("getAllArchivesApp", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//根据档案编号或者主键获取档案信息
	public ArchiveAppDto getArchivesAppBy(String id,String archiveCode){
		Map params=new HashMap();
		params.put("id", id);
		params.put("tarchiveCode", archiveCode);
		return (ArchiveAppDto)dao.getOne("getArchivesAppBy", params);
	}
	
	//查询个人信息和档案信息，以人员表为主表
	public ResultData  getAllPersonArchives(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllPersonArchives( fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	/**
	 * @param personId  根据个人id查询档案信息
	 * @return 
	 */
	public Map getArchivesByPersonId(Long personId){
		return dao.getArchivesByPersonId(personId);
	}
	/**
	 * @param personId
	 * @return 根据个人id查询接收档案信息
	 */
	public Map getReceiveArchivesByPersonId(Long personId){
		return dao.getReceiveArchivesByPersonId(personId);
	}
	public ResultData<Map>  getArchivesPersonList(String searchValue,PageBean pageBean,boolean hasArch){
		ResultData<Map> resultData=new ResultData<Map>();
		QueryFilter queryFilter=new QueryFilter();
		queryFilter.addFilter("searchValue", "%"+searchValue+"%");
		queryFilter.setPageBean(pageBean);
		List<Map> dataList=null;
		if(hasArch){
			 dataList= dao.getListForm("getArchivesPersonList", queryFilter) ;
		}else{
			 dataList= dao.getListForm("getNoArchivesPersonList", queryFilter) ;
		}
        resultData.setDataList(dataList);
        resultData.setPageBean(pageBean);
        return resultData;
	}
	
	public ResultData<Map>  getAllArchivesPersonList(String searchValue,PageBean pageBean){
		ResultData<Map> resultData=new ResultData<Map>();
		QueryFilter queryFilter=new QueryFilter();
		queryFilter.addFilter("searchValue", "%"+searchValue+"%");
		queryFilter.setPageBean(pageBean);
		List<Map> dataList= dao.getListForm("getAllArchivesPersonList", queryFilter) ;

        resultData.setDataList(dataList);
        resultData.setPageBean(pageBean);
        return resultData;
	}
	
	
	/**
	 * @param personId
	 * @return 根据个人id查询档案入库信息
	 */
	public Map getStorageArchivesByPersonId(Long personId){
		return dao.getStorageArchivesByPersonId(personId);
	}
	//根据id获取单条档案信息
	public Archives getArchivesByPId(Long personId){
		return dao.getArchivesByPId(personId);
	}
	//社保关系管理模块下  根据id查询档案和个人数据映射
	public Map getArchivesPersonByArchivesId(Long archivesId){
		return dao.getArchivesPersonByArchivesId(archivesId);
	}
	/**
	 * @param fiter
	 * @return 查询所有企业下的档案信息
	 */
	@Override
	public ResultData<Map>  getCorpAllArchive(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getCorpAllArchive(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	public ResultData<Map>  getCorpAllArchive(PageBean pageBean,Long aab001){
		QueryFilter queryFilter=new QueryFilter();
		queryFilter.addFilter("aab001", aab001);
		queryFilter.setPageBean(pageBean);
		return getCorpAllArchive(queryFilter);
	}
	//取得单位下所有可以办理档案调出的数据
	public ResultData<Map>  getBatchCorpArchive(PageBean pageBean,Long aab001){
		QueryFilter queryFilter=new QueryFilter();
		queryFilter.addFilter("aab001", aab001);
		queryFilter.setPageBean(pageBean);
		queryFilter.addFilter("archiveReceiveStatus", 2);
		queryFilter.addFilter("archiveStatusValue", "1,3");
		queryFilter.addFilter("archiveFlowStatusValue", "4,6,9");
		return getCorpAllArchive(queryFilter);
	}
	
	//入库确认
	public void addStoreConfirm(Long[] lAryId,Archives archives){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long id : lAryId){
			Archives av = dao.getById(id);
			av.setArchiveReceiveStatus(2l);
			av.setStorageDate(archives.getStorageDate());
			av.setArchiveStorageDate(archives.getArchiveStorageDate());
			av.setArchiveStorageUserid(archives.getArchiveStorageUserid());
			av.setArchiveStorageName(archives.getArchiveStorageName());
			av.setArchiveStorageOrgId(archives.getArchiveStorageOrgId());
			av.setArchiveStorageOrgName(archives.getArchiveStorageOrgName());
			dao.update(av);
		}
	}
	//通用【入库确认】
	public String addCurrencyStoreConfirm(Long id,SysUser sysUser,SysOrg sysOrg) {
		// TODO Auto-generated method stub
		String result = "0";
		Map params=new HashMap();
		params.put("id", id);
		Archives archives = dao.getUnique("getByIdForUpdate", params);
		if(archives!=null){
			if(archives.getArchiveReceiveStatus()!=null && archives.getArchiveReceiveStatus()==1){
				archives.setStorageDate(new Date());
				archives.setArchiveStorageDate(new Date());
				archives.setArchiveStorageUserid(sysUser.getAcd230());
				archives.setArchiveStorageName(sysUser.getAac003());
				archives.setArchiveStorageOrgId(sysOrg.getAcd200());
				archives.setArchiveStorageOrgName(sysOrg.getAcd202());
				archives.setArchiveReceiveStatus(2l);
				dao.update(archives);
				result = "1";
			}else{
				result = "2";
			}
		}else{
			result = "0";
		}
		return result;
	}
	//查找所有可以批量借阅归还的数据(不带条件)
	public ResultData  getArchivesCheckoutNot(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllArchivesCheckoutR(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	//查找所有可以批量借阅归还的数据(带条件)
	public ResultData  getAllArchivesCheckoutR(QueryFilter fiter){
		ResultData resultData=new ResultData();
		fiter.addFilter("archiveReceiveStatus", 2);
		fiter.addFilter("archiveStatusValue", "1,3");
		fiter.addFilter("archiveFlowStatusValue", "4,9");
		List<Map> dataList= dao.getAllArchivesCheckoutR(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//根据条件查询条数
	public Long getArchivesCount(Long archiveStatus,Long archiveFlowStatus,Long archiveReceiveStatus,String orgIds){
		Map params=new HashMap();
		params.put("archiveStatus", archiveStatus);
		params.put("archiveFlowStatus", archiveFlowStatus);
		params.put("archiveReceiveStatus", archiveReceiveStatus);
		params.put("archiveReceiveOrgId", orgIds);
		return (Long)dao.getOne("getArchivesCount", params);
	}	
	//获取今日完成接口
	public ResultData<ArchivesStatisticsAppDto> getFinshTotalApp(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ArchivesStatisticsAppDto> dataList= dao.getListForm("getFinshTotalApp", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//获取条数数据
	public Long getFinshTotalAppCount(String userid,String type,String dataString){
		Map params=new HashMap();
		params.put("userid", userid);
		params.put("type", type);
		params.put("beginCreaterDate", dataString);
		params.put("endCreaterDate", dataString);
		return (Long)dao.getOne("getFinshTotalAppCount", params);
	}
	//获取今日完成详情接口
	public ResultData<ArchivesStatisticsDetailAppDto> getFinshTotalDetailApp(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ArchivesStatisticsDetailAppDto> dataList= dao.getListForm("getFinshTotalDetailApp", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//获取详情中窗口经办人入库、借阅、返还、调出数据条数
	public Long getFinshTotalAppCount(String userid,String type,String dataString,String windowCreateName){
		Map params=new HashMap();
		params.put("userid", userid);
		params.put("type", type);
		params.put("windowCreateName", windowCreateName);
		params.put("beginCreaterDate", dataString);
		params.put("endCreaterDate", dataString);
		return (Long)dao.getOne("getFinshTotalAppCount", params);
	}
	
	public Archives getMakeupArchivesByPId(Long personId){
		Map params=new HashMap();
		params.put("personId", personId);
		params.put("dataSources", 2);		
		return dao.getUnique("getAll", params);
	}
	//获取打印的数据
	public Map getArchivesByArchivesId(Long archivesId){
		Map params=new HashMap();
		params.put("id", archivesId);
		return (Map)dao.getOne("getArchivesByArchivesId", params);
	}
	//获取打印企业下人员名单
	public List<Map> getPersonArchives(String aab001){
		Map params=new HashMap();
		params.put("aab001", aab001);
		return dao.getListBySqlKey("getPersonArchives", params);
	}
}
