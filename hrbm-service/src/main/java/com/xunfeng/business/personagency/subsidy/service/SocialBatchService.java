package com.xunfeng.business.personagency.subsidy.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.subsidy.dao.SocialBatchDao;
import com.xunfeng.business.personagency.subsidy.dto.SocialBatchSumDto;
import com.xunfeng.business.personagency.subsidy.interf.SocialBatchServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialBatch;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidy;
import com.xunfeng.business.personagency.subsidy.model.SocialSubsidyBatch;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_SOCIAL_BATCH Service类
 * @author:wanghan
 * @createDate 2016-07-07 09:12:59
 * @version V1.0
 */
@Service
public class SocialBatchService extends BaseService<SocialBatch> implements SocialBatchServiceInterf {
	@Resource
	private SocialBatchDao dao;
	@Resource
	SocialSubsidyBatchService socialSubsidyBatchService;
	@Resource
	SocialSubsidyService socialSubsidyService;
	@Resource
	SocialCorpDeclareService socialCorpDeclareService;

	@Resource
	UniqueIdUtilService uniqueIdUtilService;

	public SocialBatchService() {
	}

	@Override
	protected IEntityDao<SocialBatch, Long> getEntityDao() {
		return dao;
	}

	public ResultData<SocialBatch> getAllByFilter(QueryFilter fiter) {
		ResultData resultData = new ResultData();
		List<SocialBatch> dataList = dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;

	}

	@Override
	public void add(SocialBatch entity) {

		List socialBatchList = getSocialBatchByDate(entity.getBatchStartdate(),null);
		if (socialBatchList != null && socialBatchList.size() > 0) {
			throw new RuntimeException("区间段选择重复，请检查后重新选择");
		}
		socialBatchList = getSocialBatchByDate(entity.getBatchEnddate(),null);
		if (socialBatchList != null && socialBatchList.size() > 0) {
			throw new RuntimeException("区间段选择重复，请检查后重新选择");
		}
		List<SocialSubsidy> socialSubsidyList = socialSubsidyService.getSubsidyListByDate(entity.getBatchStartdate(),
				entity.getBatchEnddate());
		List<SocialSubsidyBatch> batchList = new ArrayList();
		for (SocialSubsidy socialSubsidy : socialSubsidyList) {
			SocialSubsidyBatch aocialSubsidyBatch = new SocialSubsidyBatch();
			aocialSubsidyBatch.setId(uniqueIdUtilService.genId(SocialSubsidyBatch.class.getName()));
			aocialSubsidyBatch.setBatchId(entity.getId());
			aocialSubsidyBatch.setSubsidyId(socialSubsidy.getId());
			batchList.add(aocialSubsidyBatch);
		}
		super.add(entity);

		socialSubsidyBatchService.batchAdd(batchList);

	}

	@Override
	public void update(SocialBatch entity) {
		List socialBatchList = getSocialBatchByDate(entity.getBatchStartdate(),entity.getId());
		if (socialBatchList != null && socialBatchList.size() > 0) {
			throw new RuntimeException("区间段选择有重复，请检查后重新选择");
		}
		socialBatchList = getSocialBatchByDate(entity.getBatchEnddate(),entity.getId());
		if (socialBatchList != null && socialBatchList.size() > 0) {
			throw new RuntimeException("区间段选择有重复，请检查后重新选择");
		}
		List<SocialSubsidy> socialSubsidyList = socialSubsidyService.getSubsidyListByDate(entity.getBatchStartdate(),
				entity.getBatchEnddate());
		socialSubsidyBatchService.delByBatchId(entity.getId());
		List<SocialSubsidyBatch> batchList = new ArrayList();
		for (SocialSubsidy socialSubsidy : socialSubsidyList) {
			SocialSubsidyBatch aocialSubsidyBatch = new SocialSubsidyBatch();
			aocialSubsidyBatch.setId(uniqueIdUtilService.genId(SocialSubsidyBatch.class.getName()));
			aocialSubsidyBatch.setBatchId(entity.getId());
			aocialSubsidyBatch.setSubsidyId(socialSubsidy.getId());
			batchList.add(aocialSubsidyBatch);
		}
		super.update(entity);
		socialSubsidyBatchService.batchAdd(batchList);
	}

	public SocialBatch getNewestSocialBatch() {
		QueryFilter queryFilter = new QueryFilter();
		queryFilter.addFilter("orderField", "CREATER_DATE");
		queryFilter.addFilter("orderSeq", "desc");
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(1);
		List<SocialBatch> socialBatchList = dao.getAll(queryFilter);
		if (socialBatchList != null && socialBatchList.size() > 0) {
			return socialBatchList.get(0);
		}
		return null;
	}

	public SocialBatchSumDto getSocialBatchSum(Long batchId) {

		Map params = new HashMap();
		params.put("batchId", batchId);
		return (SocialBatchSumDto) dao.getOne("getSocialBatchSum", params);

	}

	public void delBatchPerson(Long batchId, Long subsidyId) {

		// 删除批次下人员
		socialSubsidyBatchService.delByBatchSubsidyId(batchId, subsidyId);
		// 重新计算
		// SocialSubsidy socialSubsidy=socialSubsidyService.getById(subsidyId);
		// String
		// pensionAmount=StringUtil.isEmpty(socialSubsidy.getPensionAmount())?"0":socialSubsidy.getPensionAmount();
		// String
		// medicalAmount=StringUtil.isEmpty(socialSubsidy.getMedicalAmount())?"0":socialSubsidy.getMedicalAmount();
		// SocialCorpDeclare
		// socialCorpDeclare=socialCorpDeclareService.getByBatchId(batchId);
		// 审批情况

		// if(socialCorpDeclare!=null){
		// // 总额
		// Float
		// newTotalSubsidyAmount=Float.valueOf(socialCorpDeclare.getTotalSubsidyAmount())-Float.valueOf(pensionAmount)-Float.valueOf(medicalAmount);
		// socialCorpDeclare.setTotalSubsidyAmount(newTotalSubsidyAmount.toString());
		// socialCorpDeclare.setTotalSubsidyNum(socialCorpDeclare.getTotalSubsidyNum()-1);
		// // 医疗
		// if(!medicalAmount.equals("0")){
		// Float
		// newMedicalAmount=Float.valueOf(socialCorpDeclare.getMedicalSubsidyAmount())-Float.valueOf(medicalAmount);
		// socialCorpDeclare.setMedicalSubsidyAmount(newMedicalAmount.toString());
		// socialCorpDeclare.setMedicalSubsidyNum(socialCorpDeclare.getMedicalSubsidyNum()-1);
		// }
		// // 养老
		// if(!pensionAmount.equals("0")){
		// Float
		// newPensionAmount=Float.valueOf(socialCorpDeclare.getPensionSubsidyAmount())-Float.valueOf(pensionAmount);
		// socialCorpDeclare.setPensionSubsidyAmount(newPensionAmount.toString());
		// socialCorpDeclare.setPensionSubsidyNum(socialCorpDeclare.getPensionSubsidyNum()-1);
		// }
		// socialCorpDeclareService.update(socialCorpDeclare);
		// }

	}

	public void addBatchPerson(Long batchId, Long subsidyId) {
		// 添加批次下人员
		SocialSubsidyBatch socialSubsidyBatch = new SocialSubsidyBatch();
		socialSubsidyBatch.setBatchId(batchId);
		socialSubsidyBatch.setId(uniqueIdUtilService.genId(SocialSubsidyBatch.class.getName()));
		socialSubsidyBatch.setSubsidyId(subsidyId);
		socialSubsidyBatchService.add(socialSubsidyBatch);
		// 重新计算
		// SocialSubsidy socialSubsidy=socialSubsidyService.getById(subsidyId);
		// String
		// pensionAmount=StringUtil.isEmpty(socialSubsidy.getPensionAmount())?"0":socialSubsidy.getPensionAmount();
		// String
		// medicalAmount=StringUtil.isEmpty(socialSubsidy.getMedicalAmount())?"0":socialSubsidy.getMedicalAmount();
		// SocialCorpDeclare
		// socialCorpDeclare=socialCorpDeclareService.getByBatchId(batchId);

		// if(socialCorpDeclare!=null){
		// // 总额
		// Float
		// newTotalSubsidyAmount=Float.valueOf(socialCorpDeclare.getTotalSubsidyAmount())+Float.valueOf(pensionAmount)+Float.valueOf(medicalAmount);
		// socialCorpDeclare.setTotalSubsidyAmount(newTotalSubsidyAmount.toString());
		// socialCorpDeclare.setTotalSubsidyNum(socialCorpDeclare.getTotalSubsidyNum()+1);
		// // 医疗
		// if(!medicalAmount.equals("0")){
		// Float
		// newMedicalAmount=Float.valueOf(StringUtil.isEmpty(socialCorpDeclare.getMedicalSubsidyAmount())?"0":socialCorpDeclare.getMedicalSubsidyAmount())+Float.valueOf(medicalAmount);
		// socialCorpDeclare.setMedicalSubsidyAmount(newMedicalAmount.toString());
		// socialCorpDeclare.setMedicalSubsidyNum(socialCorpDeclare.getMedicalSubsidyNum()+1);
		// }
		// // 养老
		// if(!pensionAmount.equals("0")){
		// Float
		// newPensionAmount=Float.valueOf(StringUtil.isEmpty(socialCorpDeclare.getPensionSubsidyAmount())?"0":socialCorpDeclare.getPensionSubsidyAmount())+Float.valueOf(pensionAmount);
		// socialCorpDeclare.setPensionSubsidyAmount(newPensionAmount.toString());
		// socialCorpDeclare.setPensionSubsidyNum(socialCorpDeclare.getPensionSubsidyNum()+1);
		// }
		// socialCorpDeclareService.update(socialCorpDeclare);
		// }
	}

	public boolean isBatchNameExist(String batchName, Long noId) {
		Map param = new HashMap();
		param.put("batchName", batchName);
		param.put("noId", noId);
		List socialBatchList = dao.getBySqlKey("getAll", param);
		if (socialBatchList != null && socialBatchList.size() > 0) {
			return true;
		}
		return false;

	}

	private List<SocialBatch> getSocialBatchByDate(Date sectionDate,Long noId) {
		Map param = new HashMap();
		param.put("sectionDate", sectionDate);
		if(noId!=null){
			param.put("noId", noId);
		}
		List socialBatchList = dao.getBySqlKey("getAll", param);
		return socialBatchList;
	}

}
