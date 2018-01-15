package com.xunfeng.business.personagency.retired.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;

/**
 * 退休基本养老保险待遇申请表
 * @date 2017年1月4日17:55:35
 * @author zf
 *
 */

@Service
public class RetiredYlPrintServiceImpl implements BindDataService {
	
	@Resource
	@Qualifier("retiredDeclare")
	private RetiredDeclareServiceInterf retiredDeclareService;

	@Override
	public Map getBindData(Map paramMap) {
		Map<String,Object> mapDate=new HashMap();;
		String personIds = (String)paramMap.get("personIds");
		if(personIds!=null){
			String[] personId = personIds.split(",");
			List list = new ArrayList();
			for (String p : personId) {
				Long pId =  Long.valueOf(p);	//personId 
				RetiredDeclare retiredDeclare = retiredDeclareService.getByPersonId(pId);
				String retiredYjName = this.getRetiredYjName(retiredDeclare.getRetiredYjId());
				Map map = retiredDeclareService.getPrintByPersonId(pId);
				map.put("retiredYjName",retiredYjName);
				list.add(map);
			}
			mapDate.put("retiredYl",list);
		}
		return mapDate;
	}
	
	
	@SuppressWarnings("unused")
	private String getRetiredYjName(String retiredYjId){
		String name = "";
		switch (retiredYjId) {
		case "01":
			name =  "一条一项";
			break;
		case "02":
			name =  "一条二项";
			break;
		case "03":
			name =  "四条一项";
			break;
		case "04":
			name =  "一条三项";
			break;
		case "05":
			name =  "五条";
			break;
		case "06":
			name =  "豫政29号";
			break;
		default:
			name = "";
			break;
		}
		return name;
		
	}
	
}
