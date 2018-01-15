package com.xunfeng.business.personagency.retired.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.personagency.death.interf.DeathDeclareServiceInterf;
import com.xunfeng.business.personagency.death.interf.DeathPersonServiceInterf;
import com.xunfeng.business.personagency.party.interf.PartyPayServiceInterf;
import com.xunfeng.business.personagency.party.interf.PartyServiceInterf;
import com.xunfeng.business.personagency.retired.interf.RetiredCardServiceInterf;
import com.xunfeng.business.personagency.retired.interf.RetiredCareServiceInterf;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.business.personagency.retired.interf.RetiredPersonServiceInterf;
import com.xunfeng.business.personagency.retired.interf.RetiredSocialServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.unitagreement.interf.UnitAgreementServiceInterf;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.component.service.DataExpService;


/**
 * 导出全部service zf模块下
 * @date 2016年8月15日14:40:41
 * @author zf
 *
 */
@Service
public class RetiredDeclareExpServiceImpl extends DataExpService {
	
	
	
	
	/**
	 * 退休申诉service
	 */
	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	
	/**
	 * 退休人员登记Service
	 */
	@Resource
	@Qualifier("retiredPerson")
	private RetiredPersonServiceInterf retiredPersonService;
	
	/**
	 * 退休人员领取退休证Service
	 */
	@Resource
	@Qualifier("retiredCard")
	private RetiredCardServiceInterf retiredCardService;
	
	/**
	 * 退休人员转社会化查询
	 */
	@Resource
	@Qualifier("retiredSocial")
	private RetiredSocialServiceInterf retiredSocialService;
	
	/**
	 * 退休大病医保service
	 */
	@Resource
	@Qualifier("retiredCare")
	private RetiredCareServiceInterf retiredCareService;
	
	/**
	 * 单位协议Service
	 */
	@Resource
	@Qualifier("unitAgreement")
	private UnitAgreementServiceInterf unitAgreementService;
	
	
	/**
	 * 死亡待遇service
	 */
	@Resource
	@Qualifier("deathDeclare")
	private DeathDeclareServiceInterf deathDeclareService;
		
	/**
	 * 死亡供养直系亲属service
	 */
	@Resource
	@Qualifier("deathPerson")
	private DeathPersonServiceInterf deathPersonService;
	
	@Resource
	@Qualifier("party")
	private PartyServiceInterf partyService;
	
	@Resource
	@Qualifier("partyPay")
	private PartyPayServiceInterf partyPayService;
	
	
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	
	/**
	 * 退休模块导出 
	 */
	@Override
	protected List getExpData(Map dataMap) {

		QueryFilter fiter=new QueryFilter();
		String retiredStatus = dataMap.get("level").toString();	//退休状态
		fiter.setFilters(dataMap);
		String ids = (String)dataMap.get("id");	//返回id
		
		if(ids!=null){
			fiter.addFilter("ids", ids);
		}
		if(retiredStatus.equals("0")){			//退休人员登记信息
			fiter.addFilter("id", ids);
			ResultData resultData =retiredPersonService.getAllByFilter(fiter);
			return resultData.getDataList();	
		}else if(retiredStatus.equals("1")){	//退休人员查询信息
			ResultData resultData =retiredCardService.getRetiredPersonList(fiter);
			return resultData.getDataList();	
		}else if(retiredStatus.equals("2")){ 	//退休人员审批表打印
			ResultData resultData = retiredCardService.getRetiredReportList(fiter);
			return resultData.getDataList();	
		}else if(retiredStatus.equals("3")){	//养老待遇信息
			ResultData<RetiredDeclare> resultData = retiredDeclareService.getRetiredList(fiter);
			return resultData.getDataList();	
		}else if(retiredStatus.equals("4")){	//退休人员转社会化列表信息
			ResultData resultData = retiredSocialService.getRetiredSocialList(fiter);
			return resultData.getDataList();	
			
		}else if(retiredStatus.equals("5")){	//退休转社会化查询
			ResultData resultData = retiredSocialService.getRetiredSocialListJson(fiter);
			return resultData.getDataList();
			
		}else if(retiredStatus.equals("6")){	//退休编号查询
			ResultData resultData = retiredDeclareService.getRetiredBhList(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("7")){	//退休大病医保信息
			ResultData resultData = retiredCareService.getRetiredCareList(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("8")){	//单位协议信息
			ResultData resultData =unitAgreementService.getUnitAgreementList(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("a")){	//死亡信息
			ResultData resultData =deathDeclareService.getAllByFilter(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("a1")){	//死亡直系亲属信息
			ResultData resultData =deathPersonService.getByvDeathPerson(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("b")){	//党组织关系查询
			ResultData resultData =partyService.getPartyList(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("c")){	//党员交纳统计
			ResultData resultData =partyPayService.getPartyPayResultList(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("c1")){	//党费信息
			ResultData resultData = partyPayService.getAllByFilter(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("p")){	//
			ResultData resultData = personBaseInfoService.getPersonList(fiter);
			return resultData.getDataList();
		}else if(retiredStatus.equals("z")){
			ResultData<Corp> resultData=corpService.getAllCorp(fiter);
			return resultData.getDataList();
		}
		return null;

	}
	
	
	
	
}
