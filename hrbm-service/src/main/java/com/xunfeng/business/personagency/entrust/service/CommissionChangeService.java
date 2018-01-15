package com.xunfeng.business.personagency.entrust.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.dictionary.service.DictionaryService;
import com.xunfeng.sys.identity.enumeration.SeqType;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.personagency.archive.dao.ArchivesDao;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.entrust.model.CommissionChange;
import com.xunfeng.business.personagency.entrust.dao.CommissionChangeDao;
import com.xunfeng.business.personagency.entrust.dto.CommissionChangeDto;
import com.xunfeng.business.personagency.entrust.interf.CommissionChangeServiceInterf;
import com.xunfeng.business.personagency.receive.dto.ArchiveTypeDto;
import com.xunfeng.business.personagency.receive.model.CorpPerson;
import com.xunfeng.business.personagency.receive.service.CorpPersonService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 委托类型变更 Service类
* @author:jiangxin
* @createDate 2016-08-22 14:48:20 
* @version V1.0   
*/
@Service
public class CommissionChangeService extends BaseService<CommissionChange> implements CommissionChangeServiceInterf
{
	@Resource
	private CommissionChangeDao dao;
	@Resource
	private ArchivesDao archivesDao;
	@Resource
	private DictionaryService dictionaryService;
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	@Resource
	private CorpPersonService corpPersonService; 
	@Resource
	private PersonExpandService personExpandService;
	
	public CommissionChangeService()
	{
	}
	
	@Override
	protected IEntityDao<CommissionChange, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<CommissionChange> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<CommissionChange> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	//查询所有类型变更数据
	public ResultData getAllCommissionChange(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<Map> dataList= dao.getAllCommissionChange(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}
	
	//保存委托变更
	public void addCommissionChange(CommissionChangeDto commissionChangeDto){
		if(commissionChangeDto!=null){
			Archives archives = archivesDao.getById(commissionChangeDto.getArchivesId());
			String historyArchiveCode = archives.getHistoryArchiveCode();
			Long archiveType = archives.getArchiveType();
			String archiveCode = "";
			if(("1,6,8").indexOf(commissionChangeDto.getCommissionType())!=-1){
				//转正规
				archiveCode = this.parseFromArchiveCode(historyArchiveCode, 2l);
				if("".equals(archiveCode)){
					//历史中没有变更过此种档案编号
					archiveCode = "1"+uniqueIdUtilService.getBusniessSeqCode(SeqType.正规档案代理, 7);
					historyArchiveCode = this.parseFromHarchiveCode(this.getListHarchiveCode(historyArchiveCode), 2l, archiveCode);
				}
				archiveType = 2l;
			}else if(("3,5").indexOf(commissionChangeDto.getCommissionType())!=-1){
				//转自由人
				archiveCode = this.parseFromArchiveCode(historyArchiveCode, 3l);
				if("".equals(archiveCode)){
					//历史中没有变更过此种档案编号
					archiveCode = "5"+uniqueIdUtilService.getBusniessSeqCode(SeqType.自由人档案代理, 7);
					historyArchiveCode = this.parseFromHarchiveCode(this.getListHarchiveCode(historyArchiveCode), 3l, archiveCode);
				}
				archiveType = 3l;
			}else if(("4,7,9").indexOf(commissionChangeDto.getCommissionType())!=-1){
				//转集体
				archiveCode = this.parseFromArchiveCode(historyArchiveCode, 1l);
				if("".equals(archiveCode)){
					//历史中没有变更过此种档案编号
					archiveCode = "D"+uniqueIdUtilService.getBusniessSeqCode(SeqType.集体代理存档, 7);
					historyArchiveCode = this.parseFromHarchiveCode(this.getListHarchiveCode(historyArchiveCode), 1l, archiveCode);
				}
				archiveType = 1l;
			}else{
				//委托单位变更
				archiveCode = archives.getArchiveCode();
				
			}
	    	archives.setArchiveCode(archiveCode);
	    	archives.setArchiveType(archiveType);
	    	archives.setHistoryArchiveCode(historyArchiveCode);
	    	archivesDao.update(archives);
	    	commissionChangeDto.setArchiveCodeAfter(archiveCode);
	    	dao.add(commissionChangeDto);
	    	if(("2,4,7,9").indexOf(commissionChangeDto.getCommissionType())!=-1){
	    		//都是转集体的数据
	    		if(commissionChangeDto.getAab001not()!=null){
	    			CorpPerson corpPerson = corpPersonService.getCorpPerson(null, commissionChangeDto.getPersonId());
	    			if(corpPerson!=null){
	    				corpPersonService.delById(corpPerson.getId());
	    			}
	    			CorpPerson corpP = new CorpPerson();
	    			corpP.setId(uniqueIdUtilService.genId(CorpPerson.class.getName()));
	    			corpP.setCorpId(commissionChangeDto.getAab001not());
	    			corpP.setPersonId(commissionChangeDto.getPersonId());
	    			corpPersonService.add(corpP);
	    			PersonExpand  personExpand = personExpandService.getByExpPersonId(commissionChangeDto.getPersonId());
	    			personExpand.setExpEntrustCompany(commissionChangeDto.getCommissionCorpName());
	    			personExpandService.update(personExpand);
				}
	    	}
	    	if(("1,3").indexOf(commissionChangeDto.getCommissionType())!=-1){
	    		//集体转出去的数据
    			CorpPerson corpPerson = corpPersonService.getCorpPerson(null, commissionChangeDto.getPersonId());
    			if(corpPerson!=null){
    				corpPersonService.delById(corpPerson.getId());
    			}
    			PersonExpand  personExpand = personExpandService.getByExpPersonId(commissionChangeDto.getPersonId());
    			personExpand.setExpEntrustCompany(null);
    			personExpandService.update(personExpand);
	    	}
	    	
		}
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
