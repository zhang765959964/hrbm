package com.xunfeng.business.personagency.retired.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.graphbuilder.curve.LagrangeCurve;
import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;

/**
 * 退休人员花名册 打印
 * @date 2017年1月4日17:08:03
 * @author zf
 *
 */

@Service
public class RetiredSocialPrintServiceImpl implements BindDataService {

	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;
	
	@Override
	public Map getBindData(Map paramMap) {
		
		String personIds = (String)paramMap.get("personIds");
		String[] personId = personIds.split(",");
		List list = new ArrayList();
		for (String p : personId) {
			Long pId =  Long.valueOf(p);
			Map map = retiredDeclareService.getPrintByPersonId(pId);
			list.add(map);
		}
		Map mapDate = new HashMap();
		mapDate.put("retiredSocial",list);
		return mapDate;
	}

}
