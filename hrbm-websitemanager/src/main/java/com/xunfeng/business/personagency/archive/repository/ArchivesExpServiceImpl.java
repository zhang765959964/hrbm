package com.xunfeng.business.personagency.archive.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.affair.interf.ExaminationRegisterServiceInterf;
import com.xunfeng.business.personagency.affair.interf.PersonLetterServiceInterf;
import com.xunfeng.business.personagency.affair.interf.TitleDeclarationServiceInterf;
import com.xunfeng.business.personagency.affair.model.PersonLetter;
import com.xunfeng.business.personagency.archive.interf.ArchiveCheckoutServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchiveLendServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.entrust.interf.CommissionChangeServiceInterf;
import com.xunfeng.business.personagency.receive.interf.ProxyManualServiceInterf;
import com.xunfeng.business.personagency.residence.interf.ResidenceMoveOutServiceInterf;
import com.xunfeng.business.personagency.residence.interf.ResidenceReturnServiceInterf;
import com.xunfeng.business.personagency.residence.interf.ResidenceServiceInterf;
import com.xunfeng.business.personagency.residence.model.ResidenceReturn;
import com.xunfeng.business.personagency.social.interf.ChangeReportingServiceInterf;
import com.xunfeng.business.personagency.social.interf.SocialsecTransferServiceInterf;
import com.xunfeng.business.personagency.social.model.ChangeReporting;
import com.xunfeng.business.personagency.social.model.SocialsecTransfer;
import com.xunfeng.business.personagency.storage.interf.SpecialArchivesServiceInterf;
import com.xunfeng.business.personagency.storage.interf.WageStandardServiceInterf;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.component.service.DataExpService;


/**
 * 退休人员导出 Service
 * @date 2016年8月15日14:40:41
 * @author jx
 *
 */
@Service
public class ArchivesExpServiceImpl extends DataExpService {
	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("archiveLend")
	private ArchiveLendServiceInterf archiveLendService;
	@Resource
	@Qualifier("archiveCheckout")
	private ArchiveCheckoutServiceInterf archiveCheckoutService;
	@Resource
	@Qualifier("proxyManual")
	private ProxyManualServiceInterf proxyManualService;
	@Resource
	@Qualifier("specialArchives")
	private SpecialArchivesServiceInterf specialArchivesService;
	@Resource
	@Qualifier("wageStandard")
	private WageStandardServiceInterf wageStandardService;
	@Resource
	@Qualifier("personLetter")
	private PersonLetterServiceInterf personLetterService;
	@Resource
	@Qualifier("titleDeclaration")
	private TitleDeclarationServiceInterf titleDeclarationService;
	@Resource
	@Qualifier("examinationRegister")
	private ExaminationRegisterServiceInterf examinationRegisterService;
	@Resource
	@Qualifier("commissionChange")
	private CommissionChangeServiceInterf commissionChangeService;
	@Resource
	@Qualifier("residence")
	private ResidenceServiceInterf residenceService;
	@Resource
	@Qualifier("socialsecTransfer")
	private SocialsecTransferServiceInterf socialsecTransferService;
	@Resource
	@Qualifier("changeReporting")
	private ChangeReportingServiceInterf changeReportingService;
	@Resource
	@Qualifier("residenceMoveOut")
	private ResidenceMoveOutServiceInterf residenceMoveOutService;
	@Resource
	@Qualifier("residenceReturn")
	private ResidenceReturnServiceInterf residenceReturnService;
	
	@Override
	protected List getExpData(Map dataMap) {
		String menuNumber = dataMap.get("menuNumber").toString();
		HttpServletRequest request = RequestUtil.getHttpServletRequest();
		QueryFilter fiter=new QueryFilter(request);
		fiter.setFilters(dataMap);
		fiter.addFilter("ccpr08", 0);
		if(menuNumber.equals("1")){			//档案信息查询导出
			ResultData resultData =archivesService.getAllArchives(fiter);
			return resultData.getDataList();	
		}else if(menuNumber.equals("2")){   //档案调出综合查询导出
			ResultData  resultData = archiveLendService.getAllArchiveLendSearch(fiter);		
			return resultData.getDataList();
		}else if(menuNumber.equals("3")){   //档案借阅归还综合查询导出
			ResultData  resultData = archiveCheckoutService.getAllArchiveCheckout(fiter);		
			return resultData.getDataList();
		}else if(menuNumber.equals("4")){  	//代理手册综合查询导出
			ResultData  resultData = proxyManualService.getAllProxyManual(fiter);	
			return resultData.getDataList();
		}else if(menuNumber.equals("5")){ 	//特殊类档案查询导出
			ResultData  resultData = specialArchivesService.getAllByFilter(fiter);	
			return resultData.getDataList();
		}else if(menuNumber.equals("6")){  	//工资标准调整查询导出
			ResultData  resultData = wageStandardService.getAllByFilter(fiter);	
			return resultData.getDataList();
		}else if(menuNumber.equals("7")){ 	//人事档案联系函导出	
			ResultData<PersonLetter> resultData=personLetterService.getAllByFilter(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("8")){ 	//职称申报评定导出
			ResultData resultData= titleDeclarationService.getAllTitleDeclaration(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("9")){ 	//考试报名登记导出
			ResultData resultData=examinationRegisterService.getAllExaminationRegister(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("a")){ 	//委托类型变更导出
			ResultData resultData=commissionChangeService.getAllCommissionChange(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("b")){ 	//户口材料信息导出
			ResultData resultData=residenceService.getAllResidence(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("c")){ 	//单位档案接收导出
			ResultData resultData= archivesService.getCorpAllArchive(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("d")){ 	//档案借阅返还登记导出
			ResultData  resultData = archiveLendService.getAllArchiveLend(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("e")){ 	//档案借阅返还登记导出
			fiter.addFilter("archiveStatus", 1);
			fiter.addFilter("archiveFlowStatus", 9);
			fiter.addFilter("archiveReceiveStatus", 1);
			if("0".equals(fiter.getFilters().get("personId"))){
				fiter.getFilters().remove("personId");
			}
			ResultData  resultData = archivesService.getAllArchives(fiter);		
			return resultData.getDataList();
		}else if(menuNumber.equals("f")){ 	//单位档案批量调出导出
			fiter.addFilter("archiveReceiveStatus", 2);
			fiter.addFilter("archiveStatusValue", "1,3");
			fiter.addFilter("archiveFlowStatusValue", "4,6,9");
			ResultData  resultData = archivesService.getCorpAllArchive(fiter);		
			return resultData.getDataList();
		}else if(menuNumber.equals("reporting")){ 	//变更申报信息导出
			ResultData<ChangeReporting> resultData=changeReportingService.getAllByFilter(fiter);	
			return resultData.getDataList();
		}else if(menuNumber.equals("transfer")){ 	//统筹范围内转移信息导出
			ResultData<SocialsecTransfer> resultData=socialsecTransferService.getAllByFilter(fiter);	
			return resultData.getDataList();
		}else if(menuNumber.equals("moveOut")){ 	//户口迁入迁移导出
			ResultData resultData=residenceMoveOutService.getAllResidenceMoveOut(fiter);
			return resultData.getDataList();
		}else if(menuNumber.equals("return")){ 	//户口借用归还导出
			ResultData<ResidenceReturn> resultData=residenceReturnService.getAllByFilter(fiter);	
			return resultData.getDataList();
		}
		return null;
	}
	
	
	
	
}
