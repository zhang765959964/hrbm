package com.xunfeng.business.personagency.person.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.model.PersonFamily;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.person.service.PersonFamilyService;
import com.xunfeng.business.personagency.person.dto.AgencyPersonExpandDto;
import com.xunfeng.business.personagency.person.interf.AgencyPersonExpandServiceInterf;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PAYMENT_YEARDETAIL Service类
* @author:user
* @createDate 2016-11-09 10:49:09 
* @version V1.0   
*/
@Service
public class AgencyPersonExpandService  implements AgencyPersonExpandServiceInterf
{
	@Resource
	private PersonBaseInfoService personBaseInfoService;

	@Resource
	private PersonExpandService personExpandService;
	@Resource
	private PersonFamilyService personFamilyService;
	@Resource
	UniqueIdUtilService  uniqueIdUtil;
	public AgencyPersonExpandDto  getPersonExpandById(Long aac001){
		PersonBaseInfo personBaseInfo=personBaseInfoService.getById(aac001);
		if(personBaseInfo==null){
			return null;
		}
		AgencyPersonExpandDto agencyPersonExpandDto=new AgencyPersonExpandDto();
		agencyPersonExpandDto=BeanToBean.copyProperties(personBaseInfo, agencyPersonExpandDto);
		
		PersonExpand personExpand=personExpandService.getByExpPersonId(personBaseInfo.getAac001());
		PersonFamily personFamily=personFamilyService.getByFaPersonId(personBaseInfo.getAac001());
		if(personExpand!=null){
			agencyPersonExpandDto=BeanToBean.copyProperties(personExpand, agencyPersonExpandDto);
		}
		if(agencyPersonExpandDto!=null){
			agencyPersonExpandDto=BeanToBean.copyProperties(personFamily, agencyPersonExpandDto);
		}
      
		return agencyPersonExpandDto;
	} 
	
	public void  addPersonExpand(AgencyPersonExpandDto expandDto){
		expandDto.setCczy06("16");
		PersonBaseInfo personBaseInfo=new PersonBaseInfo();
		PersonExpand personExpand=new PersonExpand();
		PersonFamily personFamily=new PersonFamily();
		
				
		personBaseInfo=BeanToBean.copyProperties(expandDto, personBaseInfo);
		
		personExpand=BeanToBean.copyProperties(expandDto, personExpand);
		personExpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));		
		personExpand.setExpPersonId(personBaseInfo.getAac001());
		
		personFamily=BeanToBean.copyProperties(expandDto, personFamily);
		personFamily.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));				
		personFamily.setFaPersonId(personBaseInfo.getAac001());
		
		personBaseInfoService.add(personBaseInfo);
		personExpandService.add(personExpand);
		personFamilyService.add(personFamily);
		
		
	}
	public void  updatePersonExpand(AgencyPersonExpandDto expandDto){
		PersonBaseInfo personBaseInfo=personBaseInfoService.getById(expandDto.getAac001());
		PersonExpand personExpand=personExpandService.getByExpPersonId(expandDto.getAac001());
		PersonFamily personFamily=personFamilyService.getByFaPersonId(expandDto.getAac001());
		expandDto.setCczy06("16");	
		personBaseInfo=BeanToBean.copyProperties(expandDto, personBaseInfo);
		personBaseInfoService.update(personBaseInfo);
		
		if(personExpand==null){
			 personExpand=new PersonExpand();
			 personExpand.setExpandId(uniqueIdUtil.genId(PersonExpand.class.getName()));
			 personExpand=BeanToBean.copyProperties(expandDto, personExpand);
			 personExpand.setExpPersonId(personBaseInfo.getAac001());
			 personExpandService.add(personExpand);
		}else{
			personExpand=BeanToBean.copyProperties(expandDto, personExpand);
			personExpand.setExpPersonId(personBaseInfo.getAac001());
			personExpandService.update(personExpand);
		}
			
        if(personFamily==null){
        	personFamily=new PersonFamily();
    		personFamily.setId(uniqueIdUtil.genId(PersonFamily.class.getName()));		
    		personFamily=BeanToBean.copyProperties(expandDto, personFamily);
    		personFamily.setFaPersonId(personBaseInfo.getAac001());
    		personFamilyService.add(personFamily);
        }else{
        	personFamily=BeanToBean.copyProperties(expandDto, personFamily);
    		personFamily.setFaPersonId(personBaseInfo.getAac001());
    		personFamilyService.update(personFamily);
        }
		
	}
}
