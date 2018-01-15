package com.xunfeng.business.personagency.receive.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.service.CorpService;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonEducation;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonEducationService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.person.service.PersonFamilyService;
import com.xunfeng.business.person.service.PersonWorkExpceService;
import com.xunfeng.business.personagency.archive.dao.ArchivesDao;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.business.personagency.receive.dao.CorpPersonDao;
import com.xunfeng.business.personagency.receive.dto.ArchiveTypeDto;
import com.xunfeng.business.personagency.receive.dto.GongZuoDto;
import com.xunfeng.business.personagency.receive.dto.JiaTingDto;
import com.xunfeng.business.personagency.receive.dto.JiaoYuDto;
import com.xunfeng.business.personagency.receive.dto.PersonBaseDto;
import com.xunfeng.business.personagency.receive.dto.ReceiveArchivesPersonDto;
import com.xunfeng.business.personagency.receive.interf.ReceiveArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.model.CorpPerson;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.dictionary.model.Dictionary;
import com.xunfeng.sys.dictionary.service.DictionaryService;
import com.xunfeng.sys.identity.enumeration.SeqType;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 人员档案表 Service类
* @author:jx
* @createDate 2016-07-06 18:19:23 
* @version V1.0   
*/
@Service
public class ReceiveArchivesService implements ReceiveArchivesServiceInterf
{
	@Resource
	private ArchivesService archivesService;
	@Resource
	private PersonBaseInfoService personBaseInfoService;
	@Resource
	private PersonExpandService personExpandService;
	@Resource
	private PersonBaseInfoService baseInfoService;
	@Resource
	private PersonWorkExpceService personWorkExpceService;
	@Resource
	private PersonFamilyService personFamilyService;
	@Resource
	private PersonEducationService personEducationService;
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	@Resource
	private ArchivesDao archivesDao;
	@Resource
	private CorpPersonDao corpPersonDao;
	@Resource
	private DictionaryService dictionaryService;
	@Resource
	private CorpService corpService;
	@Resource
	private CorpPersonService corpPersonService;
	
	
	
	
	@Override
	public void saveReceiveArchives(ReceiveArchivesPersonDto receiveArchivesPersonDto) {
		// TODO Auto-generated method stub
		// 转化成PersonBaseInfo基本信息
		PersonBaseDto personBaseDto = receiveArchivesPersonDto.getPersonBaseDto();
		PersonBaseInfo basePerson=baseInfoService.getById(personBaseDto.getAac001());
	    basePerson= BeanToBean.copyProperties(personBaseDto, basePerson, false);	
	    // 转化成PersonExpand 个人基本信息拓展
	    PersonExpand personExpand = personExpandService.getById(personBaseDto.getExpandId()==null?0l:personBaseDto.getExpandId());
	    if(personExpand==null){
	    	personExpand = new PersonExpand();
	    	personExpand.setExpandId(uniqueIdUtilService.genId(PersonExpand.class.getName()));
	    	personExpand.setExpPersonId(personBaseDto.getAac001());
	    	personExpand.setExpOpeartorUserId(receiveArchivesPersonDto.getArchiveReceiveUserid());
	    	personExpand.setExpOpeartorDate(new Date());
	    }
	    personExpand= BeanToBean.copyProperties(personBaseDto, personExpand, false);
	    //工作经历
	    GongZuoDto gongZuoDto = receiveArchivesPersonDto.getGongZuoDto();
	    personExpand= BeanToBean.copyProperties(gongZuoDto, personExpand, false);
	    PersonWorkExpce personWorkExpce = personWorkExpceService.getById(gongZuoDto.getAac0b0()==null?0l:gongZuoDto.getAac0b0());
	    if(personWorkExpce==null){
	    	if(StringUtil.isEmpty(gongZuoDto.getAac015()) && StringUtil.isEmpty(gongZuoDto.getAac045()) && StringUtil.isEmpty(gongZuoDto.getAae013())){
	    		
	    	}else{
	    		personWorkExpce = new PersonWorkExpce();
		    	personWorkExpce= BeanToBean.copyProperties(gongZuoDto, personWorkExpce, false);
		    	personWorkExpce.setAac0b0(uniqueIdUtilService.genId(PersonWorkExpce.class.getName()));
		    	personWorkExpce.setAac001(basePerson.getAac001());
		    	personWorkExpce.setAae011(receiveArchivesPersonDto.getArchiveReceiveUserid().toString());
		    	personWorkExpce.setAae019(receiveArchivesPersonDto.getArchiveReceiveName());
		    	personWorkExpce.setAae017(receiveArchivesPersonDto.getArchiveReceiveOrgId().toString());
		    	personWorkExpce.setAae020(receiveArchivesPersonDto.getArchiveReceiveOrgName());
		    	personWorkExpce.setAae036(new Date());
		    	personWorkExpce.setCcpr08("0");
		    	if(StringUtil.isEmpty(gongZuoDto.getAac045())){
		    		personWorkExpce.setAac045("未知");
		    	}
	    		personWorkExpceService.add(personWorkExpce);
	    	}
	    }else{
	    	personWorkExpce= BeanToBean.copyProperties(gongZuoDto, personWorkExpce, false);
	    	if(StringUtil.isEmpty(gongZuoDto.getAac045())){
	    		personWorkExpce.setAac045("未知");
	    	}
	    	personWorkExpceService.update(personWorkExpce);
	    }
	    //家庭成员
	    JiaTingDto jiaTingDto = receiveArchivesPersonDto.getJiaTingDto();
	    PersonFamily personFamily = personFamilyService.getById(jiaTingDto.getId()==null?0l:jiaTingDto.getId());
	    if(personFamily==null){
	    	if(StringUtil.isEmpty(jiaTingDto.getFaBirthCondition()) && StringUtil.isEmpty(jiaTingDto.getFaBirthControl()) && StringUtil.isEmpty(jiaTingDto.getFaFamilyBark())
	    			&& StringUtil.isEmpty(jiaTingDto.getFaMarriage()) && StringUtil.isEmpty(jiaTingDto.getFaName())&& StringUtil.isEmpty(jiaTingDto.getFaSpouseCard()) 
	    			&& StringUtil.isEmpty(jiaTingDto.getFaSpouseCompany()) && StringUtil.isEmpty(jiaTingDto.getFaSpouseNational())
	    			&& StringUtil.isEmpty(jiaTingDto.getFaSpousePhone()) && jiaTingDto.getFaMarriageDate() !=null
	    			&& jiaTingDto.getFaSpouseBirth()!=null){
	    		
	    	}else{
	    		personFamily = new PersonFamily();
		    	personFamily= BeanToBean.copyProperties(jiaTingDto, personFamily, false);
		    	personFamily.setId(uniqueIdUtilService.genId(PersonFamily.class.getName()));
		    	personFamily.setFaPersonId(basePerson.getAac001());
		    	personFamily.setCreaterId(receiveArchivesPersonDto.getArchiveReceiveUserid());
		    	personFamily.setCreaterName(receiveArchivesPersonDto.getArchiveReceiveName());
		    	personFamily.setCreaterOrgId(receiveArchivesPersonDto.getArchiveReceiveOrgId());
		    	personFamily.setCreaterOrgName(receiveArchivesPersonDto.getArchiveReceiveOrgName());
		    	personFamily.setCreaterDate(new Date());
	    		personFamilyService.add(personFamily);
	    	}
	    }else{
	    	personFamily= BeanToBean.copyProperties(jiaTingDto, personFamily, false);
	    	personFamilyService.update(personFamily);
	    }
	    //教育经历
	    JiaoYuDto jiaoYuDto = receiveArchivesPersonDto.getJiaoYuDto();
	    PersonEducation personEducation = personEducationService.getById(jiaoYuDto.getAac0d0()==null?0l:jiaoYuDto.getAac0d0());
	    if(personEducation==null){
	    	if(StringUtil.isEmpty(jiaoYuDto.getAac037()) && StringUtil.isEmpty(jiaoYuDto.getAac045()) && StringUtil.isEmpty(jiaoYuDto.getAac046())
	    			&& StringUtil.isEmpty(jiaoYuDto.getAcc01g()) && StringUtil.isEmpty(jiaoYuDto.getAtc011())){
	    		
	    	}else{
	    		personEducation = new PersonEducation();
		    	personEducation = BeanToBean.copyProperties(jiaoYuDto, personEducation, false);
		    	personEducation.setAac0d0(uniqueIdUtilService.genId(PersonEducation.class.getName()));
		    	personEducation.setAac001(basePerson.getAac001());
		    	personEducation.setAae011(receiveArchivesPersonDto.getArchiveReceiveUserid().toString());
		    	personEducation.setAae019(receiveArchivesPersonDto.getArchiveReceiveName());
		    	personEducation.setAae017(receiveArchivesPersonDto.getArchiveReceiveOrgId().toString());
		    	personEducation.setAae020(receiveArchivesPersonDto.getArchiveReceiveOrgName());
		    	personEducation.setAae036(new Date());
		    	personEducation.setCcpr08("0");
		    	if(StringUtil.isEmpty(jiaoYuDto.getAac045())){
		    		personEducation.setAac045("未知");
		    	}
		    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	if(!StringUtil.isEmpty(jiaoYuDto.getAac046())){
		    		try {
						Date aac046 = sdf.parse(jiaoYuDto.getAac046());
						personEducation.setAac046(aac046);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
	    		personEducationService.add(personEducation);
	    	}
	    }else{
	    	personEducation= BeanToBean.copyProperties(jiaoYuDto, personEducation, false);
	    	if(StringUtil.isEmpty(jiaoYuDto.getAac045())){
	    		personEducation.setAac045("未知");
	    	}
	    	personEducationService.update(personEducation);
	    }
	    //档案保存
	    Archives archives = archivesService.getById(receiveArchivesPersonDto.getId()==null?0l:receiveArchivesPersonDto.getId());
	    if(archives==null){
	    	archives = new Archives();
	    	archives = BeanToBean.copyProperties(receiveArchivesPersonDto, archives, false);
	    	archives.setId(uniqueIdUtilService.genId(Archives.class.getName()));
	    	archives.setPersonId(basePerson.getAac001());
	    	archives.setArchiveStatus(1L);
	    	archives.setArchiveFlowStatus(9L);
	    	archives.setArchiveReceiveStatus(1L);
	    	archives.setArchivePrintLabel(0L);
	    	archives.setDataSources("1");
	    	String archiveCode = "";
	    	if(archives.getArchiveType()==1){
	    		archiveCode = "D"+uniqueIdUtilService.getBusniessSeqCode(SeqType.集体代理存档, 7);
	    	}
	    	if(archives.getArchiveType()==2){
	    		archiveCode = "1"+uniqueIdUtilService.getBusniessSeqCode(SeqType.正规档案代理, 7);
	    	}
	    	if(archives.getArchiveType()==3){
	    		archiveCode = "5"+uniqueIdUtilService.getBusniessSeqCode(SeqType.自由人档案代理, 7);
	    	}
	    	if(archives.getArchiveType()==4){
	    		archiveCode = "3"+uniqueIdUtilService.getBusniessSeqCode(SeqType.学生档案代理, 7);
	    	}
	    	archives.setArchiveCode(archiveCode);
	    	String historyArchiveCode = this.valueCovertString(archives.getArchiveType(), archiveCode);
	    	archives.setHistoryArchiveCode(historyArchiveCode);
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getReceiveDate())){
	    		try {
					Date receiveDate=sdf.parse(receiveArchivesPersonDto.getReceiveDate());
					archives.setReceiveDate(receiveDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getArchiveBirthDate())){
	    		try {
					Date archiveBirthDate=sdf.parse(receiveArchivesPersonDto.getArchiveBirthDate());
					archives.setArchiveBirthDate(archiveBirthDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getPlanRetiredDate())){
	    		try {
					Date planRetiredDate=sdf.parse(receiveArchivesPersonDto.getPlanRetiredDate());
					archives.setPlanRetiredDate(planRetiredDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getArchiveReceiveDate())){
	    		try {
					Date archiveReceiveDate=sdf.parse(receiveArchivesPersonDto.getArchiveReceiveDate());
					archives.setArchiveReceiveDate(archiveReceiveDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	archivesService.add(archives);
	    }else{
	    	archives = BeanToBean.copyProperties(receiveArchivesPersonDto, archives, false);
	    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getReceiveDate())){
	    		try {
					Date receiveDate=sdf.parse(receiveArchivesPersonDto.getReceiveDate());
					archives.setReceiveDate(receiveDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getArchiveBirthDate())){
	    		try {
					Date archiveBirthDate=sdf.parse(receiveArchivesPersonDto.getArchiveBirthDate());
					archives.setArchiveBirthDate(archiveBirthDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getPlanRetiredDate())){
	    		try {
					Date planRetiredDate=sdf.parse(receiveArchivesPersonDto.getPlanRetiredDate());
					archives.setPlanRetiredDate(planRetiredDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	if(!StringUtil.isEmpty(receiveArchivesPersonDto.getArchiveReceiveDate())){
	    		try {
					Date archiveReceiveDate=sdf.parse(receiveArchivesPersonDto.getArchiveReceiveDate());
					archives.setArchiveReceiveDate(archiveReceiveDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    	archivesService.update(archives);
	    }
	    personExpand= BeanToBean.copyProperties(receiveArchivesPersonDto, personExpand, false);
	    baseInfoService.update(basePerson);
	    if(receiveArchivesPersonDto.getAab001()!=null && receiveArchivesPersonDto.getAab001()>0){
	    	CorpPerson cp = corpPersonService.getCorpPerson(receiveArchivesPersonDto.getAab001(), basePerson.getAac001());
	    	if(cp==null){
	    		cp = new CorpPerson();
	    		cp.setId(uniqueIdUtilService.genId(CorpPerson.class.getName()));
	    		cp.setCorpId(receiveArchivesPersonDto.getAab001());
	    		cp.setPersonId(basePerson.getAac001());
	    		corpPersonDao.add(cp);
	    	}
	    	Corp corp = corpService.getById(receiveArchivesPersonDto.getAab001());
	    	personExpand.setExpEntrustCompany(corp.getAab004()==null?"":corp.getAab004());
	    }
	    if(personExpand.getExpandId()!=null){
	    	personExpandService.update(personExpand);
	    }else{
	    	personExpand.setExpandId(uniqueIdUtilService.genId(PersonExpand.class.getName()));
	    	personExpandService.add(personExpand);
	    }
	}
	
	
	/**
	 * 根据档案类型，转换为JSONArray字符串，存入数据库
	 */
	public String valueCovertString(Long typeId,String harchiveCode) {
		String str = "";
		if(null!=typeId && StringUtil.isNotEmpty(harchiveCode)){
			List<ArchiveTypeDto> archiveTypeDtos = new ArrayList<ArchiveTypeDto>();
			String sqlCondi = "code = " + typeId;
			List<Map<String ,Object>> dictionarys1 =dictionaryService.getTabList("RSDA_TAB_ARCHIVETYPE", sqlCondi);
			for (Iterator iterator = dictionarys1.iterator(); iterator.hasNext();) {
				Map<String, Object> map = (Map<String, Object>) iterator.next();
				ArchiveTypeDto archiveTypeDto = new ArchiveTypeDto();
				archiveTypeDto.setCode(Long.parseLong(map.get("CODE").toString()));
				archiveTypeDto.setName(map.get("NAME").toString());
				archiveTypeDto.setHarchiveCode(harchiveCode);
				archiveTypeDtos.add(archiveTypeDto);
			}
			str = JSON.toJSONString(archiveTypeDtos);
		}else{
			str = null;
		}
		return str;
	}

	//档案调出后回调档案接收
	@Override
	public void saveLendBackArchives(ReceiveArchivesPersonDto receiveArchivesPersonDto) {
		// TODO Auto-generated method stub
		// 转化成PersonBaseInfo基本信息
		PersonBaseDto personBaseDto = receiveArchivesPersonDto.getPersonBaseDto();
		PersonBaseInfo basePerson = baseInfoService.getById(personBaseDto.getAac001());
	    basePerson= BeanToBean.copyProperties(personBaseDto, basePerson, false);	
	    // 转化成PersonExpand 个人基本信息拓展
	    PersonExpand personExpand = personExpandService.getById(personBaseDto.getExpandId()==null?0l:personBaseDto.getExpandId());
	    if(personExpand==null){
	    	personExpand = new PersonExpand();
	    	personExpand.setExpandId(uniqueIdUtilService.genId(PersonExpand.class.getName()));
	    	personExpand.setExpPersonId(personBaseDto.getAac001());
	    	personExpand.setExpOpeartorUserId(receiveArchivesPersonDto.getArchiveReceiveUserid());
	    	personExpand.setExpOpeartorDate(new Date());
	    }
	    personExpand= BeanToBean.copyProperties(personBaseDto, personExpand, false);
	    //工作经历
	    GongZuoDto gongZuoDto = receiveArchivesPersonDto.getGongZuoDto();
	    personExpand= BeanToBean.copyProperties(gongZuoDto, personExpand, false);
	    PersonWorkExpce personWorkExpce = personWorkExpceService.getById(gongZuoDto.getAac0b0()==null?0l:gongZuoDto.getAac0b0());
	    if(personWorkExpce==null){
	    	if(StringUtil.isEmpty(gongZuoDto.getAac015()) && StringUtil.isEmpty(gongZuoDto.getAac045()) && StringUtil.isEmpty(gongZuoDto.getAae013())){
	    		
	    	}else{
	    		personWorkExpce = new PersonWorkExpce();
		    	personWorkExpce= BeanToBean.copyProperties(gongZuoDto, personWorkExpce, false);
		    	personWorkExpce.setAac0b0(uniqueIdUtilService.genId(PersonWorkExpce.class.getName()));
		    	personWorkExpce.setAac001(basePerson.getAac001());
		    	personWorkExpce.setAae011(receiveArchivesPersonDto.getArchiveReceiveUserid().toString());
		    	personWorkExpce.setAae019(receiveArchivesPersonDto.getArchiveReceiveName());
		    	personWorkExpce.setAae017(receiveArchivesPersonDto.getArchiveReceiveOrgId().toString());
		    	personWorkExpce.setAae020(receiveArchivesPersonDto.getArchiveReceiveOrgName());
		    	personWorkExpce.setAae036(new Date());
		    	personWorkExpce.setCcpr08("0");
		    	personWorkExpce.setAac045(gongZuoDto.getAac045()==null?"未知":gongZuoDto.getAac045());
	    		personWorkExpceService.add(personWorkExpce);
	    	}
	    }else{
	    	personWorkExpce= BeanToBean.copyProperties(gongZuoDto, personWorkExpce, false);
	    	personWorkExpce.setAac045(gongZuoDto.getAac045()==null?"未知":gongZuoDto.getAac045());
	    	personWorkExpceService.update(personWorkExpce);
	    }
	    //家庭成员
	    JiaTingDto jiaTingDto = receiveArchivesPersonDto.getJiaTingDto();
	    PersonFamily personFamily = personFamilyService.getById(jiaTingDto.getId()==null?0l:jiaTingDto.getId());
	    if(personFamily==null){
	    	if(StringUtil.isEmpty(jiaTingDto.getFaBirthCondition()) && StringUtil.isEmpty(jiaTingDto.getFaBirthControl()) && StringUtil.isEmpty(jiaTingDto.getFaFamilyBark())
	    			&& StringUtil.isEmpty(jiaTingDto.getFaMarriage()) && StringUtil.isEmpty(jiaTingDto.getFaName())&& StringUtil.isEmpty(jiaTingDto.getFaSpouseCard()) 
	    			&& StringUtil.isEmpty(jiaTingDto.getFaSpouseCompany()) && StringUtil.isEmpty(jiaTingDto.getFaSpouseNational())
	    			&& StringUtil.isEmpty(jiaTingDto.getFaSpousePhone()) && jiaTingDto.getFaMarriageDate() !=null
	    			&& jiaTingDto.getFaSpouseBirth()!=null){
	    		
	    	}else{
	    		personFamily = new PersonFamily();
		    	personFamily= BeanToBean.copyProperties(jiaTingDto, personFamily, false);
		    	personFamily.setId(uniqueIdUtilService.genId(PersonFamily.class.getName()));
		    	personFamily.setFaPersonId(basePerson.getAac001());
		    	personFamily.setCreaterId(receiveArchivesPersonDto.getArchiveReceiveUserid());
		    	personFamily.setCreaterName(receiveArchivesPersonDto.getArchiveReceiveName());
		    	personFamily.setCreaterOrgId(receiveArchivesPersonDto.getArchiveReceiveOrgId());
		    	personFamily.setCreaterOrgName(receiveArchivesPersonDto.getArchiveReceiveOrgName());
		    	personFamily.setCreaterDate(new Date());
	    		personFamilyService.add(personFamily);
	    	}
	    }else{
	    	personFamily= BeanToBean.copyProperties(jiaTingDto, personFamily, false);
	    	personFamilyService.update(personFamily);
	    }
	    //教育经历
	    JiaoYuDto jiaoYuDto = receiveArchivesPersonDto.getJiaoYuDto();
	    PersonEducation personEducation = personEducationService.getById(jiaoYuDto.getAac0d0()==null?0l:jiaoYuDto.getAac0d0());
	    if(personEducation==null){
	    	if(StringUtil.isEmpty(jiaoYuDto.getAac037()) && StringUtil.isEmpty(jiaoYuDto.getAac045()) && StringUtil.isEmpty(jiaoYuDto.getAac046())
	    			&& StringUtil.isEmpty(jiaoYuDto.getAcc01g()) && StringUtil.isEmpty(jiaoYuDto.getAtc011())){
	    		
	    	}else{
	    		personEducation = new PersonEducation();
		    	personEducation = BeanToBean.copyProperties(jiaoYuDto, personEducation, false);
		    	personEducation.setAac0d0(uniqueIdUtilService.genId(PersonEducation.class.getName()));
		    	personEducation.setAac001(basePerson.getAac001());
		    	personEducation.setAae011(receiveArchivesPersonDto.getArchiveReceiveUserid().toString());
		    	personEducation.setAae019(receiveArchivesPersonDto.getArchiveReceiveName());
		    	personEducation.setAae017(receiveArchivesPersonDto.getArchiveReceiveOrgId().toString());
		    	personEducation.setAae020(receiveArchivesPersonDto.getArchiveReceiveOrgName());
		    	personEducation.setAae036(new Date());
		    	personEducation.setCcpr08("0");
		    	personEducation.setAac045(jiaoYuDto.getAac045()==null?"未知":jiaoYuDto.getAac045());
		    	personEducation.setAac046(this.StringConverDate(jiaoYuDto.getAac046()));
	    		personEducationService.add(personEducation);
	    	}
	    }else{
	    	personEducation= BeanToBean.copyProperties(jiaoYuDto, personEducation, false);
	    	personEducation.setAac045(jiaoYuDto.getAac045()==null?"未知":jiaoYuDto.getAac045());
	    	personEducation.setAac046(this.StringConverDate(jiaoYuDto.getAac046()));
	    	personEducationService.update(personEducation);
	    }
	    //档案保存
	    Archives archives = archivesService.getById(receiveArchivesPersonDto.getId()==null?0l:receiveArchivesPersonDto.getId());
	    if(archives==null){
	    	throw new RuntimeException("当前档案数据存在问题，重新接收档案失败！"); 
	    }else{
	    	archives = BeanToBean.copyProperties(receiveArchivesPersonDto, archives, false);
	    	archives.setReceiveDate(this.StringConverDate(receiveArchivesPersonDto.getReceiveDate()));
	    	archives.setArchiveBirthDate(this.StringConverDate(receiveArchivesPersonDto.getArchiveBirthDate()));
	    	archives.setPlanRetiredDate(this.StringConverDate(receiveArchivesPersonDto.getPlanRetiredDate()));
	    	archives.setArchiveReceiveDate(this.StringConverDate(receiveArchivesPersonDto.getArchiveReceiveDate()));
	    	String historyArchiveCode = archives.getHistoryArchiveCode();
	    	String archiveCode = "";
	    	if(receiveArchivesPersonDto.getArchiveType()==1){
	    		archiveCode = this.parseFromArchiveCode(historyArchiveCode, 1l);
				if("".equals(archiveCode)){
					//历史中没有变更过此种档案编号
					archiveCode = "D"+uniqueIdUtilService.getBusniessSeqCode(SeqType.集体代理存档, 7);
					historyArchiveCode = this.parseFromHarchiveCode(this.getListHarchiveCode(historyArchiveCode), 1l, archiveCode);
				}
	    	}
	    	if(receiveArchivesPersonDto.getArchiveType()==2){
	    		archiveCode = this.parseFromArchiveCode(historyArchiveCode, 2l);
				if("".equals(archiveCode)){
					//历史中没有变更过此种档案编号
					archiveCode = "1"+uniqueIdUtilService.getBusniessSeqCode(SeqType.正规档案代理, 7);
					historyArchiveCode = this.parseFromHarchiveCode(this.getListHarchiveCode(historyArchiveCode), 2l, archiveCode);
				}
	    	}
	    	if(receiveArchivesPersonDto.getArchiveType()==3){
	    		archiveCode = this.parseFromArchiveCode(historyArchiveCode, 3l);
				if("".equals(archiveCode)){
					//历史中没有变更过此种档案编号
					archiveCode = "5"+uniqueIdUtilService.getBusniessSeqCode(SeqType.自由人档案代理, 7);
					historyArchiveCode = this.parseFromHarchiveCode(this.getListHarchiveCode(historyArchiveCode), 3l, archiveCode);
				}
	    	}
	    	if(receiveArchivesPersonDto.getArchiveType()==4){
	    		archiveCode = this.parseFromArchiveCode(historyArchiveCode, 4l);
				if("".equals(archiveCode)){
					//历史中没有变更过此种档案编号
					archiveCode = "3"+uniqueIdUtilService.getBusniessSeqCode(SeqType.学生档案代理, 7);
					historyArchiveCode = this.parseFromHarchiveCode(this.getListHarchiveCode(historyArchiveCode), 4l, archiveCode);
				}
	    	}
	    	archives.setArchiveType(receiveArchivesPersonDto.getArchiveType()==null?2l:receiveArchivesPersonDto.getArchiveType());
	    	archives.setArchiveCode(archiveCode);
	    	archives.setHistoryArchiveCode(historyArchiveCode);
	    	archives.setArchiveStatus(1l);
	    	archives.setArchiveFlowStatus(9l);
	    	archives.setStorageDate(null);
	    	archives.setArchiveStorageDate(null);
	    	archives.setArchiveStorageUserid(null);
	    	archives.setArchiveStorageName(null);
	    	archives.setArchiveStorageOrgId(null);
	    	archives.setArchiveStorageOrgName(null);
	    	archivesService.update(archives);
	    }
	    personExpand= BeanToBean.copyProperties(receiveArchivesPersonDto, personExpand, false);
	    baseInfoService.update(basePerson);
	    if(receiveArchivesPersonDto.getAab001()!=null && receiveArchivesPersonDto.getAab001()>0){
	    	CorpPerson cp = corpPersonService.getCorpPerson(receiveArchivesPersonDto.getAab001(), basePerson.getAac001());
	    	if(cp==null){
	    		cp = new CorpPerson();
	    		cp.setId(uniqueIdUtilService.genId(CorpPerson.class.getName()));
	    		cp.setCorpId(receiveArchivesPersonDto.getAab001());
	    		cp.setPersonId(basePerson.getAac001());
	    		corpPersonDao.add(cp);
	    	}
	    }
	    if(personExpand.getExpandId()!=null){
	    	personExpandService.update(personExpand);
	    }else{
	    	personExpand.setExpandId(uniqueIdUtilService.genId(PersonExpand.class.getName()));
	    	personExpandService.add(personExpand);
	    }
	}
	
	public Date StringConverDate(String dateString){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(!StringUtil.isEmpty(dateString)){
			try {
				date=sdf.parse(dateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{ 
			date = null;
		}
		return date;
	}
	
	//返回历史档案编号集合
	public List<ArchiveTypeDto> getListHarchiveCode(String harchiveCode) {
		List<ArchiveTypeDto> archiveTypeDtos = new ArrayList<ArchiveTypeDto>();
		if (StringUtil.isNotEmpty(harchiveCode)) {
			archiveTypeDtos = JSON.parseArray(harchiveCode, ArchiveTypeDto.class);
		}
		return archiveTypeDtos;
	}
		
	//返回查找后的档案编号
	public String parseFromArchiveCode(String harchiveCode,Long code) {
		String str = "";
		List<ArchiveTypeDto> archiveTypeDtos = new ArrayList<ArchiveTypeDto>();
		if (StringUtil.isNotEmpty(harchiveCode)) {
			archiveTypeDtos = JSON.parseArray(harchiveCode, ArchiveTypeDto.class);
			for (Iterator iterator = archiveTypeDtos.iterator(); iterator.hasNext();) {
				ArchiveTypeDto archiveTypeDto = (ArchiveTypeDto) iterator.next();
				if(code==archiveTypeDto.getCode()){
					str = archiveTypeDto.getHarchiveCode();
					break;
				}
			}
		}
		return str;
	}
	//添加历史档案编号
	public String parseFromHarchiveCode(List<ArchiveTypeDto> archiveTypeDtos,Long code,String archiveCode) {
		String str = "";
		if (StringUtil.isNotEmpty(archiveCode)) {
			String sqlCondi = "code = " + code;
			List<Map<String ,Object>> dictionarys =dictionaryService.getTabList("RSDA_TAB_ARCHIVETYPE", sqlCondi);
			for (Iterator iterator = dictionarys.iterator(); iterator.hasNext();) {
				Map<String, Object> map = (Map<String, Object>) iterator.next();
				ArchiveTypeDto archiveTypeDto = new ArchiveTypeDto();
				archiveTypeDto.setCode(Long.parseLong(map.get("CODE").toString()));
				archiveTypeDto.setName(map.get("NAME").toString());
				archiveTypeDto.setHarchiveCode(archiveCode);
				archiveTypeDtos.add(archiveTypeDto);
			}
			str = JSON.toJSONString(archiveTypeDtos);
		}
		return str;
	}
}
