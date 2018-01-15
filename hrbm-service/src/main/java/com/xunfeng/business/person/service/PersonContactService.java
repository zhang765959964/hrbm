//package com.xunfeng.business.person.service;
//
//import com.xunfeng.business.person.dao.PersonContactDao;
//import com.xunfeng.business.person.model.PersonBaseInfo;
//import com.xunfeng.business.person.model.PersonEducation;
//import com.xunfeng.core.page.PageBean;
//import com.xunfeng.sys.notice.service.NoticeService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// *<pre>
// * 对象功能:个人教育背景表 Service类
// * 开发公司:河南讯丰信息技术有限公司
// * 开发人员:wanghan
// * 创建时间:2015-07-21 15:58:43
// *</pre>
// */
//@Service
//public class PersonContactService
//{
//	@Resource
//	@Qualifier(value = "jdbcTemplate")
//	private JdbcTemplate jdbcTemplate;
//
//	@Resource
//	PersonEducationService  personEducationService;
//	@Resource
//	PersonBaseInfoService personBaseInfoService;
//	@Resource
//	PersonContactDao  personContactDao;
//	@Resource
//	NoticeService  noticeService;
//
//	public List<Map<String,Object>> getPersonContactList(String contactType,PersonBaseInfo personBaseInfo,PageBean pageBean){
//		Long aac001=personBaseInfo.getAac001();
//		if("0".equals(contactType)){
//			return getDepartmentContactList(aac001, pageBean);
//		}else if("1".equals(contactType)){
//			return getHomeContactList(aac001,personBaseInfo.getCcmu01(),pageBean);
//		}else if("2".equals(contactType)){
//			return getSchoolContactList( aac001,personBaseInfo.getCcmu01(),pageBean);
//		}else if("3".equals(contactType)){
//			return noticeService.getMyNoticeList(personBaseInfo.getCcmu01(), pageBean);
//		}else if("4".equals(contactType)){
//			return noticeService.getMyFansList(personBaseInfo.getCcmu01(), pageBean);
//		}
//		else{
//			return new ArrayList<Map<String,Object>>();
//		}
//
//	}
//
//	private List<Map<String,Object>> getSchoolContactList(Long aac001,Long ccmu01,PageBean pageBean){
//
//
//		List<PersonEducation> personEducationList=personEducationService.getPersonEducationList(aac001);
//		StringBuffer sql=new StringBuffer();
//		sql.append("select Y.*,Z.BE_NOTICE_USER_ID as noticeUserId from (select * from (");
//		sql.append("select a.aac045 as contactName,b.aac003 as personName,b.aac001,b.ccmu01,'1' ccmu17 ,   row_number() over(partition by b.aac001 order by b.aac001) rn from AC0D a ,ac01 b where a.aac001=b.aac001  and ( ");
//
//        boolean flag= false;
//		for(PersonEducation personEducation:personEducationList){
//			if("61".equals(personEducation.getAac037())||"71".equals(personEducation.getAac037())||"81".equals(personEducation.getAac037())){
//				if(flag){
//					sql.append(" or (a.aac037="+personEducation.getAac037()+" and a.aac045 like '%"+personEducation.getAac045()+"%' )");
//				}else{
//					sql.append(" (a.aac037="+personEducation.getAac037()+" and a.aac045 like '%"+personEducation.getAac045()+"%' )");
//					flag=true;
//				}
//			}
//		}
//		sql.append(")   and a.aac001 !=").append(aac001);
//		sql.append(")  where rn = 1) Y left join my_notice Z on Y.CCMU01=Z.BE_NOTICE_USER_ID and Z.NOTICE_USER_ID = "+ccmu01);
//		if(flag){
//			Map param=new HashMap();
//			param.put("sql", sql.toString());
//			return personContactDao.getObjectList("com.xunfeng.business.person.model.PersonContact.getPersonContactList",
//					param, pageBean);
//		}
//		return new ArrayList<Map<String,Object>>();
//	}
//
//	private List<Map<String,Object>> getHomeContactList(Long aac001,Long ccmu01,PageBean pageBean){
//
//		List<PersonEducation> personEducationList=personEducationService.getPersonEducationList(aac001);
////		aac037
//		StringBuffer sql=new StringBuffer();
//		boolean flag= false;
//		PersonBaseInfo personBaseInfo=personBaseInfoService.getById(aac001);
//		sql.append("select Y.*,Z.BE_NOTICE_USER_ID as noticeUserId from ( select M.*,  row_number() over(partition by M.aac001 order by M.aac001) rn  from(");
//		if(StringUtils.isNotBlank(personBaseInfo.getAac028())){
//			sql.append("select t.name as contactName,b.aac003 as personName,b.aac001,b.ccmu01,'1' ccmu17  from ac01 b,TAB_CITY t where t.code=b.aac028 and ").
//					append(" b.aac028='" + personBaseInfo.getAac028()).append("'");
//			sql.append(" and b.aac001 !=").append(aac001);
//			flag= true;
//		}
//		if(StringUtils.isNotBlank(personBaseInfo.getAac027())){
//			if(flag){
//				sql.append(" union  select t.name as contactName,b.aac003 as personName,b.aac001,b.ccmu01,'1' ccmu17  from ac01 b, TAB_CITY t where t.code=b.aac027 and ").
//						append(" b.aac027='" + personBaseInfo.getAac027()).append("'");
//				sql.append(" and b.aac001 !=").append(aac001);
//			}else{
//				sql.append(" select b.aac027 as contactName,b.aac003 as personName,b.aac001,b.ccmu01,'1' ccmu177 from ac01 b where  ").
//						append(" b.aac027='" + personBaseInfo.getAac027()).append("'");
//				sql.append(" and b.aac001 !=").append(aac001);
//			}
//		}
//		sql.append(") M ) Y left join my_notice Z on Y.CCMU01=Z.BE_NOTICE_USER_ID and Z.NOTICE_USER_ID = "+ccmu01);
//		sql.append(" where rn=1");
//		if(flag){
//			Map param=new HashMap();
//			param.put("sql", sql.toString());
//			return personContactDao.getObjectList("com.xunfeng.business.person.model.PersonContact.getPersonContactList",
//					param, pageBean);
//		}
//		return new ArrayList<Map<String,Object>>();
//
//	}
//	private List<Map<String,Object>> getDepartmentContactList(Long aac001,PageBean pageBean){
//
//		List<PersonEducation> personEducationList=personEducationService.getPersonEducationList(aac001);
//		PersonBaseInfo personBaseInfo=personBaseInfoService.getById(aac001);
//		StringBuffer sql=new StringBuffer();
//		sql.append("select A.*,C.BE_NOTICE_USER_ID as noticeUserId from (select b.aac039 as contactName,b.aac003 as personName,b.aac001,b.ccmu01,'1'ccmu17 from ac01 b where  ").
//				append(" b.aac039='"+personBaseInfo.getAac039()).append("'");
//		sql.append(" and b.aac001 !=").append(aac001);
//		sql.append(" ) A left join my_notice C on A.CCMU01=C.BE_NOTICE_USER_ID");
//		Map param=new HashMap();
//		param.put("sql", sql.toString());
//		return personContactDao.getObjectList("com.xunfeng.business.person.model.PersonContact.getPersonContactList",
//				param, pageBean);
//
//	}
//
//
//}
