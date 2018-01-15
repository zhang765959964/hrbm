package com.xunfeng.business.personagency.archive.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.business.corp.dao.CorpDao;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.dao.PersonBaseInfoDao;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import com.xunfeng.business.personagency.archive.model.ArchiveLendExp;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.dao.ArchiveLendDao;
import com.xunfeng.business.personagency.archive.dao.ArchiveLendExpDao;
import com.xunfeng.business.personagency.archive.dao.ArchivesDao;
import com.xunfeng.business.personagency.archive.dto.ArchiveLendAppDto;
import com.xunfeng.business.personagency.archive.interf.ArchiveLendServiceInterf;
import com.xunfeng.business.personagency.receive.model.CorpPerson;
import com.xunfeng.business.personagency.receive.service.CorpPersonService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案调出表 Service类
* @author:jx
* @createDate 2016-07-12 10:08:55 
* @version V1.0   
*/
@Service
public class ArchiveLendService extends BaseService<ArchiveLend> implements ArchiveLendServiceInterf
{
	@Resource
	private ArchiveLendDao dao;
	@Resource
	private ArchivesDao archivesDao;
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	@Resource
	private CorpPersonService corpPersonService;
	@Resource
	private ArchiveLendExpDao archiveLendExpDao;
	@Resource
	private PersonBaseInfoDao personBaseDao;
	@Resource
	private CorpDao corpDao;
	
	public ArchiveLendService()
	{
	}
	
	@Override
	protected IEntityDao<ArchiveLend, Long> getEntityDao() 
	{
		return dao;
	}
	//根据档案id和调出流转状态查询调出信息
	public ArchiveLend getArchiveLendByArchiveId(Long archivesId,Long lendFlowStatus){
		Map params=new HashMap();
		params.put("archivesId", archivesId);
		params.put("lendFlowStatus", lendFlowStatus);
		ArchiveLend archiveLend = new ArchiveLend();
		List<ArchiveLend> list = dao.getListBySqlKey("getArchiveLendByArchiveId", params);
		if(list.size()>0){
			archiveLend = list.get(0);
		}else{
			archiveLend = null;
		}
		return archiveLend;
	}
	
	public ResultData<ArchiveLend> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ArchiveLend> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	/**
	 * @param 调出确认查询列表
	 * @return
	 */
	public ResultData  getAllArchiveLend(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllArchiveLend( fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//档案调出综合查询
	public ResultData  getAllArchiveLendSearch(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllArchiveLendSearch( fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//手机app接口调出数据接口 2016.11.22
	public ResultData<ArchiveLendAppDto> getAllArchiveLendApp(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ArchiveLendAppDto> dataList= dao.getListForm("getAllArchiveLendApp", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//调出登记
	public void addLendRegister(ArchiveLend archiveLend) {
		dao.add(archiveLend);
		Archives archives = archivesDao.getById(archiveLend.getArchivesId());
		archives.setArchiveFlowStatus(5L);
		archivesDao.update(archives);
	}
	//调出确认
	public void addLendComfirm(ArchiveLend archiveLend,Long[] lAryId) {
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long lendId : lAryId){
			ArchiveLend al = dao.getById(lendId);
			al.setLendConfirmDate(archiveLend.getLendConfirmDate());
			al.setLendConfirmId(archiveLend.getLendConfirmId());
			al.setLendConfirmName(archiveLend.getLendConfirmName());
			al.setLendConfirmOrgId(archiveLend.getLendConfirmOrgId());
			al.setLendConfirmOrgName(archiveLend.getLendConfirmOrgName());
			al.setLendFlowStatus(5l);
			dao.update(al);
			Archives archives = archivesDao.getById(al.getArchivesId());
			archives.setArchiveStatus(2L);
			archives.setArchiveReceiveStatus(1l);
			archives.setArchiveFlowStatus(6L);
			archivesDao.update(archives);
			//插入调出记录拓展表，为了查询调出记录
			ArchiveLendExp archiveLendExp = new ArchiveLendExp();
			archiveLendExp= BeanToBean.copyProperties(archives, archiveLendExp, false);
			PersonBaseInfo personBase = personBaseDao.getById(archives.getPersonId()==null?0l:archives.getPersonId());
			archiveLendExp= BeanToBean.copyProperties(personBase, archiveLendExp, false);
			archiveLendExp.setId(uniqueIdUtilService.genId(ArchiveLendExp.class.getName()));
			archiveLendExp.setExpLendId(lendId);
			CorpPerson cp = corpPersonService.getCorpPerson(null, archives.getPersonId());
			if(cp!=null){
				Corp corp = corpDao.getById(cp.getCorpId());
				if(corp!=null){
					archiveLendExp.setAab004(corp.getAab004());
				}
				corpPersonService.delById(cp.getId());
			}
			archiveLendExpDao.add(archiveLendExp);
			
		}
	}
	//通用【调出确认】
	public String addCurrencyLendComfirm(Long lendId,SysUser sysUser,SysOrg sysOrg){
		String result = "0";
		Map params=new HashMap();
		params.put("lendId", lendId);
		ArchiveLend archiveLend = dao.getUnique("getByIdForUpdate", params);
		if(archiveLend!=null){
			if(archiveLend.getLendFlowStatus()!=null && archiveLend.getLendFlowStatus()==4){
				archiveLend.setLendConfirmDate(new Date());
				archiveLend.setLendConfirmId(sysUser.getAcd230());
				archiveLend.setLendConfirmName(sysUser.getAac003());
				archiveLend.setLendConfirmOrgId(sysOrg.getAcd200());
				archiveLend.setLendConfirmOrgName(sysOrg.getAcd202());
				archiveLend.setLendFlowStatus(5l);
				dao.update(archiveLend);
				Archives archives = archivesDao.getById(archiveLend.getArchivesId());
				archives.setArchiveStatus(2L);
				archives.setArchiveReceiveStatus(1l);
				archives.setArchiveFlowStatus(6L);
				archivesDao.update(archives);
				//插入调出记录拓展表，为了查询调出记录
				ArchiveLendExp archiveLendExp = new ArchiveLendExp();
				archiveLendExp= BeanToBean.copyProperties(archives, archiveLendExp, false);
				PersonBaseInfo personBase = personBaseDao.getById(archives.getPersonId()==null?0l:archives.getPersonId());
				archiveLendExp= BeanToBean.copyProperties(personBase, archiveLendExp, false);
				archiveLendExp.setId(uniqueIdUtilService.genId(ArchiveLendExp.class.getName()));
				archiveLendExp.setExpLendId(lendId);
				CorpPerson cp = corpPersonService.getCorpPerson(null, archives.getPersonId());
				if(cp!=null){
					Corp corp = corpDao.getById(cp.getCorpId());
					if(corp!=null){
						archiveLendExp.setAab004(corp.getAab004());
					}
					corpPersonService.delById(cp.getId());
				}
				archiveLendExpDao.add(archiveLendExp);
				result = "1";
			}else{
				result = "2";
			}
		}else{
			result = "0";
		}
		return result;
	}
	//调出取消
	public void delArchiveLend(Long lendId) {
		ArchiveLend archiveLend = dao.getById(lendId);
		Archives archives = archivesDao.getById(archiveLend.getArchivesId());
		archives.setArchiveFlowStatus(9L);
		archivesDao.update(archives);
		dao.delById(lendId);
	}
	//单位档案批量调出登记
	public void addBatchLendRegister(ArchiveLend archiveLend,String archiveIds) {
		String [] archivesIds = archiveIds.split(",");
		for (int i = 0; i < archivesIds.length; i++) {
			archiveLend.setLendId(uniqueIdUtilService.genId(ArchiveLend.class.getName()));
			archiveLend.setArchivesId(Long.parseLong(archivesIds[i]));
			archiveLend.setLendFlowStatus(4l);
			dao.add(archiveLend);
			Archives archives = archivesDao.getById(Long.parseLong(archivesIds[i]));
			archives.setArchiveFlowStatus(5L);
			archivesDao.update(archives);
		}
	}
	//根据条件查询条数
	public Long getArchivesLendCount(Long lendFlowStatus,String orgIds){
		Map params=new HashMap();
		params.put("lendFlowStatus", lendFlowStatus);
		params.put("lendCreaterOrgId", orgIds);
		return (Long)dao.getOne("getArchivesLendCount", params);
	}	
}
