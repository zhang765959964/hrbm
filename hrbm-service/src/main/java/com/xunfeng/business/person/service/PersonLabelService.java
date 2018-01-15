package com.xunfeng.business.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.dao.PersonLabelDao;
import com.xunfeng.business.person.interf.PersonLabelServiceInterf;
import com.xunfeng.business.person.model.PersonLabel;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 标签明细表 Service类
 * @author:wanghan
 * @createDate 2016-03-31 14:57:08
 * @version V1.0
 */
@Service
public class PersonLabelService extends BaseService<PersonLabel> implements PersonLabelServiceInterf {
	@Resource
	private PersonLabelDao dao;

	public PersonLabelService() {
	}

	@Override
	protected IEntityDao<PersonLabel, Long> getEntityDao() {
		return dao;
	}

	public List<PersonLabel> getPersonLabelList(Long userId,String labelType) {

		Map params = new HashMap();
		params.put("userId", userId);
		params.put("labelType", labelType);
		return dao.getListBySqlKey("getAll", params);

	}

	public void savePersonLabelList(Long userId,List<PersonLabel> personLabelList) {
		delPersonLabelList(userId);
		for (PersonLabel personLabel : personLabelList) {
			add(personLabel);
		}

	}
	public void delPersonLabelList(Long userId) {

		 Map params = new HashMap();
		 params.put("userId", userId);
		 dao.delBySqlKey("delByPersonId", params);

	}
}
