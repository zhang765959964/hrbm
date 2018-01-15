/**   
*  
*/


package com.xunfeng.business.personagency.subsidy.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.payment.dto.PaymentCorpOverDto;
import com.xunfeng.business.personagency.payment.dto.PaymentCorpRecordDto;
import com.xunfeng.business.personagency.payment.dto.PaymentRecordPersonDto;
import com.xunfeng.business.personagency.payment.enumeration.DerateStatus;
import com.xunfeng.business.personagency.payment.interf.PaymentCorpRecordServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentDerateServiceInterf;
import com.xunfeng.business.personagency.payment.interf.PaymentRecordServiceInterf;
import com.xunfeng.business.personagency.subsidy.dto.BatchSocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.dto.SocialSubsidyDto;
import com.xunfeng.business.personagency.subsidy.interf.SocialBatchServiceInterf;
import com.xunfeng.business.personagency.subsidy.interf.SocialParamsServiceInterf;
import com.xunfeng.business.personagency.subsidy.interf.SocialSubsidyServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.SocialBatch;
import com.xunfeng.business.personagency.subsidy.model.SocialParams;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.component.service.DataExpService;

/**  
 * 
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年6月2日-上午8:46:14 
 * @version V1.0   
 */
@Service
public class SocialDataExpServiceImpl extends DataExpService {

	@Resource
	@Qualifier("socialSubsidy")
	private SocialSubsidyServiceInterf socialSubsidyService;	//补贴花名册查询Service

	
	@Resource
	@Qualifier("socialBatch")
	private SocialBatchServiceInterf socialBatchService;	//补贴批次维护Service
	
	@Resource
	@Qualifier("socialParams")
	private SocialParamsServiceInterf socialParamsService;	//补贴参数维护Service
	
	
	@Resource
	@Qualifier("paymentRecord")
	private PaymentRecordServiceInterf paymentRecordService;	//个人费用Service
	
	
	@Resource
	@Qualifier("paymentCorpRecord")
	private PaymentCorpRecordServiceInterf paymentCorpRecordService;	//单位费用Service
	
	@Resource
	@Qualifier("paymentDerate")
	private PaymentDerateServiceInterf paymentDerateService;
	
	
	
	/**
	 * wanghan 模块下所有导出操作
	 * 以h 开头
	 * 
	 */
	@Override
	public List getExpData(Map dataMap) {	
		QueryFilter fiter=new QueryFilter();
		
		String status = dataMap.get("status").toString();	//传值状态
		String ids = (String)dataMap.get("id");	//返回id
		fiter.setFilters(dataMap);
		if(ids!=null){
			fiter.addFilter("ids", ids);
		}
		if(status.equals("h1")){	//银行账号导出
			fiter.setFilters(dataMap);
			String batchId=(String)dataMap.get("batchId");
			if(StringUtil.isEmpty(batchId)){
				return new ArrayList();
			}
			ResultData<BatchSocialSubsidyDto> resultData=socialSubsidyService.getBatchSocialListByBatchId(Long.valueOf(batchId), fiter);
			return resultData.getDataList();
		}else if(status.equals("h2")){		//补贴花名册查询
			ResultData<SocialSubsidyDto> resultData =	socialSubsidyService.getAllSubsidyPersonByFilter(fiter);
			return resultData.getDataList();
		}else if(status.equals("h3")){		//补贴批次维护
			ResultData<SocialBatch> resultData=socialBatchService.getAllByFilter(fiter);
			return resultData.getDataList();
		}else if(status.equals("h4")){		//补贴参数维护
			ResultData<SocialParams> resultData=socialParamsService.getAllByFilter(fiter);	
			return resultData.getDataList();
		}else if(status.equals("h5")){		//个人费用查询
			ResultData<PaymentRecordPersonDto> resultData=paymentRecordService.getPersonRecordByFilter(fiter);
			return resultData.getDataList();
		}else if(status.equals("h51")){		//个人欠费查询
			ResultData<PaymentRecordPersonDto> resultData = paymentRecordService.getOverPersonPayList(fiter);
			return resultData.getDataList();
		}else if(status.equals("h6")){		//单位费用查询
			ResultData<PaymentCorpRecordDto> resultData = paymentCorpRecordService.getAllWithCorpInfoFilter(fiter);
			return resultData.getDataList();
		}else if(status.equals("h61")){		//单位欠费查询
			ResultData<PaymentCorpOverDto> resultData = paymentCorpRecordService.getOverUnitAgreement(fiter);
			return resultData.getDataList();
		}else if(status.equals("h7")){		//个人减免查询
			ResultData<PaymentRecordPersonDto> resultData = paymentDerateService.getPersonDerateList(fiter);
			return resultData.getDataList();
		}else if(status.equals("h71")){		//单位减免查询
			fiter.addFilter("fdDerateStatus", DerateStatus.减免.getCode());
			ResultData<PaymentCorpRecordDto> resultData = paymentCorpRecordService.getAllWithCorpInfoFilter(fiter);
			return resultData.getDataList();
		}
		
	
		
		return null;
		
	}
	
}
