package com.xunfeng.business.personagency.agent.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.death.interf.DeathDeclareServiceInterf;
import com.xunfeng.business.personagency.death.interf.DeathPersonServiceInterf;
import com.xunfeng.business.personagency.party.interf.PartyPayServiceInterf;
import com.xunfeng.business.personagency.party.interf.PartyServiceInterf;
import com.xunfeng.business.personagency.party.model.PartyPay;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.component.service.DataExpService;


/**
 * 代理删除 和 综合查询导出数据
 * @date 2017年1月13日
 * @author zf
 * @version 1.0
 */
@Service
public class AgrentExpServiceImpl extends DataExpService{

	
	/**
	 * 退休模块中service
	 */
	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	
	
	
	/**
	 * 死亡待遇service
	 */
	@Resource
	@Qualifier("deathDeclare")
	private DeathDeclareServiceInterf deathDeclareService;
	
	/**
	 * 死亡亲属service
	 */
	@Resource
	@Qualifier("deathPerson")
	private DeathPersonServiceInterf deathPersonService;
	
	
	/**
	 * 党员service
	 */
	@Resource
	@Qualifier("party")
	private PartyServiceInterf partyService;
	
	/**
	 * 党费缴纳service
	 */
	@Resource
	@Qualifier("partyPay")
	private PartyPayServiceInterf partyPayService;
	
	
	
	
	@Override
	protected List getExpData(Map dataMap) {
		
		QueryFilter fiter  = new QueryFilter();
		//状态 
		String status =  dataMap.get("status").toString();
		String ids = dataMap.get("id").toString();	//返回id结果集
		
		if(ids!=null){
			if(ids.equals("-1")){
				fiter.addFilter("ids", "");
			}else{
				fiter.addFilter("ids", ids);
			}
		}
		//退休删除导出 和 代理综合查询导出
		if(status.equals("z1")){
			ResultData  resultData = retiredDeclareService.getRetiredAll(fiter);
			return  resultData.getDataList();
		}else if (status.equals("z2")){		//党组织关系信息
			ResultData  resultData = partyService.getPartyList(fiter);
			return resultData.getDataList();
		}else if(status.equals("z21")){		//党费缴纳信息
			ResultData<PartyPay> resultData=partyPayService.getAllByFilter(fiter);
			return resultData.getDataList();
		}else if(status.equals("z3")){		//死亡待遇信息
			ResultData resultData = deathDeclareService.getByvPersonId(fiter);
			return resultData.getDataList();
		}else if(status.equals("z31")){		//死亡待遇申报
			ResultData resultData = deathPersonService.getByvPersonId(fiter);
			return resultData.getDataList();
			
		}
		return null;
	}

}
