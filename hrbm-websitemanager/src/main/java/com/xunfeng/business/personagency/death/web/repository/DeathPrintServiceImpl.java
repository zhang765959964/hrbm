package com.xunfeng.business.personagency.death.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.death.interf.DeathDeclareServiceInterf;
import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.core.web.util.RequestUtil;

/**
 * 死亡打印模块
 * @date 2017年1月4日11:30:58
 * @author zf
 *
 */
@Service
public class DeathPrintServiceImpl implements BindDataService {
	
	
	
	@Resource
	@Qualifier("deathDeclare")
	private DeathDeclareServiceInterf deathDeclareService;
	
	/**
	 * 获得死亡人员打印列表
	 */
	@Override	
	public Map getBindData(Map paramMap) {
		String  personIds = (String)paramMap.get("personIds");
		String [] personId =personIds.split(",");
		Map map = new HashMap();
		List arr = new ArrayList();
		for (String p : personId) {
			map =  deathDeclareService.getPrintDeathList(p);
			arr.add(map);
		}
		Map mapdd=new HashMap();
		mapdd.put("death",arr);
		return mapdd;
	}

}
