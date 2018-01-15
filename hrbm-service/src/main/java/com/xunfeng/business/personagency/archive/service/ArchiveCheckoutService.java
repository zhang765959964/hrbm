package com.xunfeng.business.personagency.archive.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.ehcache.constructs.nonstop.ThrowTimeoutException;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
import com.xunfeng.business.personagency.archive.model.ArchiveCheckout;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.dao.ArchiveCheckoutDao;
import com.xunfeng.business.personagency.archive.dao.ArchivesDao;
import com.xunfeng.business.personagency.archive.dto.ArchiveCheckoutAppDto;
import com.xunfeng.business.personagency.archive.interf.ArchiveCheckoutServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 档案借阅记录表 Service类
* @author:wanghan
* @createDate 2016-07-22 14:56:36 
* @version V1.0   
*/
@Service
public class ArchiveCheckoutService extends BaseService<ArchiveCheckout> implements ArchiveCheckoutServiceInterf
{
	@Resource
	private ArchiveCheckoutDao dao;
	@Resource
	private ArchivesDao archivesDao;
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	public ArchiveCheckoutService()
	{
	}
	
	@Override
	protected IEntityDao<ArchiveCheckout, Long> getEntityDao() 
	{
		return dao;
	}
	
	/**
	 * @param fiter
	 * @return  查询档案借阅
	 */
	public ResultData  getAllArchiveCheckout(QueryFilter fiter){
		return dao.getAllArchiveCheckout( fiter);
	}
	//手机app接口借阅，返还数据接口 2016.11.21
	public ResultData<ArchiveCheckoutAppDto> getAllArchiveCheckoutApp(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ArchiveCheckoutAppDto> dataList= dao.getListForm("getAllArchiveCheckoutApp", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	/**
	 * @param archiveCheckout
	 * 		保存档案借阅登记记录
	 */
	public void saveArchiveCheckout(ArchiveCheckout archiveCheckout){
		Archives archives = archivesDao.getById(archiveCheckout.getArchiveId());
		if(archives!=null){
			if(archives.getArchiveFlowStatus()!=null && archives.getArchiveFlowStatus()==1){
				throw new RuntimeException("已经在其他窗口办理了借阅登记，不能重复办理借阅登记！"); 
			}else{
				archives.setArchiveFlowStatus(1l);
				archivesDao.update(archives);
				// 插入借阅种类-》个人借阅
				archiveCheckout.setCheckoutKinds(2L);
				dao.add(archiveCheckout);
			}
		}
	}
	
	/**
	 * @param lAryId
	 * 删除档案借阅记录
	 */
	public void delRegisterCheckoutByIds(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long pmId : lAryId){
			ArchiveCheckout ac = dao.getById(pmId);
			ac.setCcpr08("1");
			dao.update(ac);
			Archives archives = archivesDao.getById(ac.getArchiveId());
			archives.setArchiveFlowStatus(9l);
			archivesDao.update(archives);
		}
	}
	/**
	 *  @param archiveId
	 *  返回登记
	 */ 
	public void addReturnRegisterCheckout(ArchiveCheckout archiveCheckout){
		archiveCheckout.setCheckoutStatus(3L);
		dao.update(archiveCheckout);
		Archives archives = archivesDao.getById(archiveCheckout.getArchiveId());
		archives.setArchiveFlowStatus(3l);
		archivesDao.update(archives);
	}
	
	//根据档案id和档案状态查询借阅单条数据
	public ArchiveCheckout getArchiveCheckoutByArchiveId(Long archiveId,Long checkoutStatus){
		Map params=new HashMap();
		params.put("archiveId", archiveId);
		params.put("checkoutStatus", checkoutStatus);
		return dao.getUnique("getArchiveCheckoutByArchiveId", params);
	}
	/**
	 *  @param archiveId
	 *  借阅确认
	 */ 	
	public void addRegisterComfirmCheckout(ArchiveCheckout archiveCheckout) {
		// TODO Auto-generated method stub
		archiveCheckout.setCheckoutStatus(2L);
		dao.update(archiveCheckout);
		Archives archives = archivesDao.getById(archiveCheckout.getArchiveId());
		archives.setArchiveFlowStatus(2l);
		archives.setArchiveReceiveStatus(1l);
		archivesDao.update(archives);
	}
	//通用【借阅确认】
	public String addCurrencyRegisterCheckout(Long id,SysUser sysUser,SysOrg sysOrg) {
		// TODO Auto-generated method stub
		String result = "0";
		Map params=new HashMap();
		params.put("id", id);
		ArchiveCheckout archiveCheckout = dao.getUnique("getByIdForUpdate", params);
		if(archiveCheckout!=null){
			if(archiveCheckout.getCheckoutStatus()!=null && archiveCheckout.getCheckoutStatus()==1){
				archiveCheckout.setCheckoutConfirmId(sysUser.getAcd230());
				archiveCheckout.setCheckoutConfirmName(sysUser.getAac003());
				archiveCheckout.setCheckoutConfirmDate(new Date());
				archiveCheckout.setCheckoutConfirmOrgId(sysOrg.getAcd200());
				archiveCheckout.setCheckoutConfirmOrgName(sysOrg.getAcd202());
				archiveCheckout.setCheckoutStatus(2L);
				dao.update(archiveCheckout);
				Archives archives = archivesDao.getById(archiveCheckout.getArchiveId());
				archives.setArchiveFlowStatus(2l);
				archives.setArchiveReceiveStatus(1l);
				archivesDao.update(archives);
				result = "1";
			}else{
				result = "2";
			}
		}else{
			result = "0";
		}
		return result;
	}
	/**
	 *  @param archiveId
	 *  返回确认
	 */ 
	public void addReturnConfirmCheckout(ArchiveCheckout archiveCheckout) {
		// TODO Auto-generated method stub
		archiveCheckout.setCheckoutStatus(4L);
		dao.update(archiveCheckout);
		Archives archives = archivesDao.getById(archiveCheckout.getArchiveId());
		archives.setArchiveFlowStatus(4l);
		archives.setArchiveReceiveStatus(2l);
		archivesDao.update(archives);
	}
	//通用【返还确认】
	public String addCurrencyReturnCheckout(Long id,SysUser sysUser,SysOrg sysOrg) {
		String result = "0";
		Map params=new HashMap();
		params.put("id", id);
		ArchiveCheckout archiveCheckout = dao.getUnique("getByIdForUpdate", params);
		if(archiveCheckout!=null){
			if(archiveCheckout.getCheckoutStatus()!=null && archiveCheckout.getCheckoutStatus()==3){
				archiveCheckout.setCheckinConfirmId(sysUser.getAcd230());
				archiveCheckout.setCheckinConfirmName(sysUser.getAac003());
				archiveCheckout.setCheckinConfirmDate(new Date());
				archiveCheckout.setCheckinConfirmOrgId(sysOrg.getAcd200());
				archiveCheckout.setCheckinConfirmOrgName(sysOrg.getAcd202());
				archiveCheckout.setCheckoutStatus(4L);
				dao.update(archiveCheckout);
				Archives archives = archivesDao.getById(archiveCheckout.getArchiveId());
				archives.setArchiveFlowStatus(4l);
				archives.setArchiveReceiveStatus(2l);
				archivesDao.update(archives);
				result = "1";
			}else{
				result = "2";
			}
		}else{
			result = "0";
		}
		return result;
	}
	
	//批量借阅登记
	public void addBatchCheckOutRegister(ArchiveCheckout archiveCheckout,String archiveIds) {
		String [] archivesIds = archiveIds.split(",");
		for (int i = 0; i < archivesIds.length; i++) {
			archiveCheckout.setId(uniqueIdUtilService.genId(ArchiveCheckout.class.getName()));
			archiveCheckout.setArchiveId(Long.parseLong(archivesIds[i]));
			archiveCheckout.setCheckoutStatus(1L);
			archiveCheckout.setCcpr08("0");
			archiveCheckout.setCheckoutDate(new Date());
			archiveCheckout.setCheckoutKinds(3l);
			dao.add(archiveCheckout);
			Archives archives = archivesDao.getById(Long.parseLong(archivesIds[i]));
			archives.setArchiveFlowStatus(1l);
			archivesDao.update(archives);
		}
	}
	//批量借阅确认
	public void addBatchComfirmCheckout(ArchiveCheckout archiveCheckout,String ids) {
		String [] str = ids.split(",");
		for (int i = 0; i < str.length; i++) {
			ArchiveCheckout ac = dao.getById(Long.parseLong(str[i]));
			ac.setCheckoutConfirmId(archiveCheckout.getCheckoutConfirmId());
			ac.setCheckoutConfirmName(archiveCheckout.getCheckoutConfirmName());
			ac.setCheckoutConfirmDate(archiveCheckout.getCheckoutConfirmDate());
			ac.setCheckoutConfirmOrgId(archiveCheckout.getCheckoutConfirmOrgId());
			ac.setCheckoutConfirmOrgName(archiveCheckout.getCheckoutConfirmOrgName());
			ac.setCheckoutStatus(2L);
			dao.update(ac);
			Archives archives = archivesDao.getById(ac.getArchiveId());
			archives.setArchiveFlowStatus(2l);
			archives.setArchiveReceiveStatus(1l);
			archivesDao.update(archives);
		}
	}
	//批量归还登记
	public void addBatchReturnResgister(ArchiveCheckout archiveCheckout,String ids){
		String [] str = ids.split(",");
		for (int i = 0; i < str.length; i++) {
			ArchiveCheckout ac = dao.getById(Long.parseLong(str[i]));
			ac.setCheckinId(archiveCheckout.getCheckinId());
			ac.setCheckinName(archiveCheckout.getCheckinName());
			ac.setCheckinDate(archiveCheckout.getCheckinDate());
			ac.setCheckinOrgId(archiveCheckout.getCheckinOrgId());
			ac.setCheckinOrgName(archiveCheckout.getCheckinOrgName());
			ac.setCheckoutStatus(3L);
			dao.update(ac);
			Archives archives = archivesDao.getById(ac.getArchiveId());
			archives.setArchiveFlowStatus(3l);
			archivesDao.update(archives);
		}
	}
	//批量归还确认
	public void addBatchReturnComfirm(ArchiveCheckout archiveCheckout,String ids){
		String [] str = ids.split(",");
		for (int i = 0; i < str.length; i++) {
			ArchiveCheckout ac = dao.getById(Long.parseLong(str[i]));
			ac.setCheckinConfirmId(archiveCheckout.getCheckinConfirmId());
			ac.setCheckinConfirmName(archiveCheckout.getCheckinConfirmName());
			ac.setCheckinConfirmDate(archiveCheckout.getCheckinConfirmDate());
			ac.setCheckinConfirmOrgId(archiveCheckout.getCheckinConfirmOrgId());
			ac.setCheckinConfirmOrgName(archiveCheckout.getCheckinConfirmOrgName());
			ac.setCheckoutStatus(4L);
			dao.update(ac);
			Archives archives = archivesDao.getById(ac.getArchiveId());
			archives.setArchiveFlowStatus(4l);
			archives.setArchiveReceiveStatus(2l);
			archivesDao.update(archives);
		}
	}
	//查询所有的批次
	public List  getBatchName(Long checkoutStatus){
		List batchNameList = dao.getBatchName(checkoutStatus);
		return batchNameList;
	}
	//查询批次是不是已经存在
	@Override
	public Long getCheckedByBatchName(String batchName) {
		return dao.getCheckedByBatchName(batchName);
	}
	//根据条件查询条数
	public Long getArchivesCheckoutCount(Long checkoutStatus,String orgIds){
		Map params=new HashMap();
		if(checkoutStatus==1){
			params.put("checkoutRegisterOrgId", orgIds);
		}else{
			params.put("checkinOrgId", orgIds);
		}
		params.put("checkoutStatus", checkoutStatus);
		return (Long)dao.getOne("getArchivesCheckoutCount", params);
	}	
}
