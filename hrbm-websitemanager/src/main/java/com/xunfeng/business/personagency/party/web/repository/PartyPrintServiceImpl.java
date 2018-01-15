package com.xunfeng.business.personagency.party.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.party.interf.PartyPayServiceInterf;
import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * 党员打印信息
 * @date 2017年1月5日14:50:09
 * @author zf
 *
 */
@Service
public class PartyPrintServiceImpl implements BindDataService {

	@Resource
	@Qualifier("partyPay")
	private PartyPayServiceInterf partyPayService;
	
	@Override
	public Map getBindData(Map paramMap) {
		
		String personIds = paramMap.get("personIds").toString();
		String [] person = personIds.split(",");
		Map mapDate = new HashMap();
		List listStr = new ArrayList();
		for (String pId : person) {
			QueryFilter filter = new QueryFilter();
			filter.addFilter("id", pId);
			ResultData data  = partyPayService.getPartyPayResultList(filter);
			listStr.addAll(data.getDataList());
		}
		mapDate.put("partyList",listStr);
		return mapDate;
	}

}
