package com.xunfeng.business.personagency.storage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.enumeration.SeqType;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.business.personagency.archive.dto.ArchiveAppDto;
import com.xunfeng.business.personagency.receive.model.ProxyManual;
import com.xunfeng.business.personagency.storage.model.SpecialArchives;
import com.xunfeng.business.personagency.storage.dao.SpecialArchivesDao;
import com.xunfeng.business.personagency.storage.interf.SpecialArchivesServiceInterf;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 特殊档案表 Service类
* @author:jiangxin
* @createDate 2016-08-15 14:27:06 
* @version V1.0   
*/
@Service
public class SpecialArchivesService extends BaseService<SpecialArchives> implements SpecialArchivesServiceInterf
{
	@Resource
	private SpecialArchivesDao dao;
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	
	public SpecialArchivesService()
	{
	}
	
	@Override
	protected IEntityDao<SpecialArchives, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<SpecialArchives> getAllByFilter(QueryFilter fiter){
		ResultData<SpecialArchives> resultData=new ResultData<SpecialArchives>();
		List<SpecialArchives> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public void addSpecialArchives(SpecialArchives specialArchives){
    	String specialNumber = "";
    	if(specialArchives!=null){
    		if("1".equals(specialArchives.getSpecialType())){
    			specialNumber = "JX"+uniqueIdUtilService.getBusniessSeqCode(SeqType.技校生, 6);
    		}
    		if("2".equals(specialArchives.getSpecialType())){
    			specialNumber = "TW"+uniqueIdUtilService.getBusniessSeqCode(SeqType.退伍, 6);
    		}
    		if("3".equals(specialArchives.getSpecialType())){
    			specialNumber = "DW"+uniqueIdUtilService.getBusniessSeqCode(SeqType.单位转入, 6);
    		}
    		if("4".equals(specialArchives.getSpecialType())){
    			specialNumber = "SW"+uniqueIdUtilService.getBusniessSeqCode(SeqType.死亡, 6);
    		}
    		if("5".equals(specialArchives.getSpecialType())){
    			specialNumber = "QT"+uniqueIdUtilService.getBusniessSeqCode(SeqType.其他, 6);
    		}
    	}
    	specialArchives.setSpecialNumber(specialNumber);
    	dao.add(specialArchives);
	}
	//删除特殊类档案
	public void deleteSpecialArchives(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long pmId : lAryId){
			SpecialArchives specialArchives = dao.getById(pmId);
			specialArchives.setCcpr08("1");
			dao.update(specialArchives);
		}
	}
	
	public SpecialArchives getSpecialArchivesByUnidAndId(Long id,String aac002){
		Map params=new HashMap();
		if(id!=0l){
			params.put("idnot", id);
		}
		params.put("aac002", aac002);
		params.put("ccpr08", 0);
		return (SpecialArchives)dao.getOne("getSpecialArchivesByUnidAndId", params);
	}
	//特殊类档案数据导入
	public void addBatchSpecialArchives(List list){
    	if(list.size()>0){
    		for (int i = 0; i < list.size(); i++) {
    			SpecialArchives specialArchives = (SpecialArchives)list.get(i);
    			this.addSpecialArchives(specialArchives);
			}
    	}
	}
	
}
