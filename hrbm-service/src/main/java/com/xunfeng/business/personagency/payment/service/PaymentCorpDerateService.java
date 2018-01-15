package com.xunfeng.business.personagency.payment.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.business.personagency.params.model.ParamsPayment;
import com.xunfeng.business.personagency.params.service.ParamsPaymentService;
import com.xunfeng.business.personagency.payment.dao.PaymentCorpRecordDao;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpRecordDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentStatus;
import com.xunfeng.business.personagency.payment.enumeration.PaymentType;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpDerateServiceInterf;
import com.xunfeng.business.personagency.payment.model.PaymentCorpRecord;
import com.xunfeng.business.personagency.payment.model.PaymentRecord;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: RSDA_BS_PAYMENT_CORP_RECORD Service类
 * @author:wanghan
 * @createDate 2016-08-20 14:57:53
 * @version V1.0
 */
@Service
public class PaymentCorpDerateService implements PaymentCorpDerateServiceInterf {
	@Resource
	private PaymentCorpRecordDao dao;
	@Resource
	PaymentRecordService paymentRecordService;

	@Resource
	UniqueIdUtilService uniqueIdUtilService;
	
	@Resource
	PaymentCorpRecordService paymentCorpRecordService;
	@Resource
	ArchivesService archivesService;
	@Resource
	ParamsPaymentService paramsPaymentService;
	
	@Resource
	PaymentMainService paymentMainService;
	


	public PaymentCorpDerateService() {
	}

	@Override
	public void addPaymentCorpDerate(PaymentCorpRecord entity) {
		
		entity.setFdDerateStatus(DerateStatus.减免);
		entity.setFdPaymentStatus(PaymentStatus.未缴);
		dao.add(entity);
	}

	public void allCorpDerate(PaymentRecord entity,int type) {
		entity.setFdPaymentStatus(PaymentStatus.未缴);
		entity.setFdPaymentType(PaymentType.单位缴费);
		entity.setFdDerateStatus(DerateStatus.减免);
		entity.setFdPaymentStandard("0");//单位减免按0计算
		PaymentCorpRecord paymentCorpRecord=paymentCorpRecordService.getById(entity.getFkCorpRecordId());
		if(paymentCorpRecord==null){
			throw new RuntimeException("当前缴费记录不存在或已被删除");
		}
		if(PaymentStatus.已缴.getCode().equals(paymentCorpRecord.getFdPaymentStatus().getCode())){
			throw new RuntimeException("不能选择已缴费记录，请刷新单位缴费记录后重试");
		}
		ResultData<Map> resultData = archivesService.getCorpAllArchive(null, paymentCorpRecord.getFkCorpId() );
		Long[] personIds=new Long[resultData.getDataList().size()]; 
		int i=0;
		for(Map map:resultData.getDataList()){
			personIds[i]=Long.valueOf(map.get("aac001").toString());
			i++;
		}
		paymentCorpRecordService.mutiCorpPayment(entity, personIds, type);
	}
	
	public void mutiCorpDerate(PaymentRecord entity,Long[] personIds,int type) {		
		entity.setFdPaymentStatus(PaymentStatus.未缴);
		entity.setFdPaymentType(PaymentType.单位缴费);
		entity.setFdDerateStatus(DerateStatus.减免);
		entity.setFdPaymentStandard("0");//单位减免按0计算
		PaymentCorpRecord paymentCorpRecord=paymentCorpRecordService.getById(entity.getFkCorpRecordId());
		if(paymentCorpRecord==null){
			throw new RuntimeException("当前缴费记录不存在或已被删除");
		}
		if(PaymentStatus.已缴.getCode().equals(paymentCorpRecord.getFdPaymentStatus().getCode())){
			throw new RuntimeException("不能选择已缴费记录，请刷新单位缴费记录后重试");
		}
		paymentCorpRecordService.mutiCorpPayment(entity, personIds, type);
	}


	@Override
	public ResultData<PaymentCorpRecordDto> getCorpDerateList(QueryFilter fiter) {
//		fiter.addFilter("fdDerateStatus", DerateStatus.减免.getCode());
		ResultData resultData = new ResultData();
		List<PaymentCorpRecord> dataList = dao.getListForm("getAllWithCorpInfo", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;

	}

}
