//package com.xunfeng.business.person.service;
//
//import com.xunfeng.business.person.dao.PersonlanguageDao;
//import com.xunfeng.business.person.model.Personlanguage;
//import com.xunfeng.business.person.web.form.PersonlanguageForm;
//import com.xunfeng.core.db.IEntityDao;
//import com.xunfeng.core.enumeration.SqeIdName;
//import com.xunfeng.core.service.BaseService;
//import com.xunfeng.core.util.UniqueIdUtil;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
//* @company:河南讯丰信息技术有限公司
//* @Description: 语言能力表 Service类
//* @author:wanghan
//* @createDate 2015-07-22 11:17:52 
//* @version V1.0   
//*/
//@Service
//public class PersonLanguageService extends BaseService<Personlanguage>
//{
//	@Resource
//	private PersonlanguageDao dao;
//	
//	
//	
//	public PersonLanguageService()
//	{
//	}
//	
//	@Override
//	protected IEntityDao<Personlanguage, Long> getEntityDao()
//	{
//		return dao;
//	}
//	
//	public  List<Personlanguage> getPersonlanguageList(Long aac001){
//		
//		Map params=new HashMap();
//		params.put("aac001", aac001);
//		return dao.getListBySqlKey("getAll",params);
//		
//	}
//
//	public void add(PersonlanguageForm personlanguageForm){
//		deleteByPersonId(personlanguageForm.getAac001());
//		String languageCode=personlanguageForm.getLanguageCode();
//		String[] code_array=languageCode.split(",");
//		for (String code:code_array){
//			Personlanguage personlanguage=personlanguageForm.getModel(null);
//			personlanguage.setAac0f1(code);
//			personlanguage.setAac0f0(UniqueIdUtil.genSeqId(SqeIdName.Personlanguage.getSeqName()));
//			dao.add(personlanguage);
//		}
//	}
//	public void  deleteByPersonId(Long aac001){
//		Map param=new HashMap();
//		param.put("aac001",aac001);
//        dao.delBySqlKey("deleteByPersonId",param);
//	}
//
//}
