package com.xunfeng.business.personagency.erecord.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.erecord.dao.EArchivesDao;
import com.xunfeng.business.personagency.erecord.interf.EArchivesServiceInterf;
import com.xunfeng.business.personagency.erecord.model.EArchives;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 电子档案表 Service类
* @author:wanghan
* @createDate 2015-08-10 14:59:21 
* @version V1.0   
*/
@Service
public class EarchivesService extends BaseService<EArchives> implements EArchivesServiceInterf
{
	@Resource
	private EArchivesDao dao;
	
	
	
	public EarchivesService()
	{
	}
	
	@Override
	protected IEntityDao<EArchives, Long> getEntityDao() 
	{
		return dao;
	}


	public List<EArchives> getEArchivesList(Long personId,Long catalogId,Long imgStatus){
	   Map param =new HashMap();
		param.put("personId",personId);
		if(catalogId!=null){
			param.put("catalogId",catalogId);
		}
		if(imgStatus!=null){
			param.put("imageStatus",imgStatus);
		}
		return dao.getBySqlKey("getAll",param);
	}
	public  void useEArch(Long[] lAryId){
		if(BeanUtils.isEmpty(lAryId)) return;
		for (Long p : lAryId){
			EArchives eArchives=getById(p);
			eArchives.setImageStatus(1L);
			eArchives.setSortNum(getNextNum(eArchives.getPersonId()));
			update(eArchives);
		}
	}

	public void sortEArchives(Long targetId,Long sourceId,Long personId){
		EArchives targetEArchives=getById(targetId);
		EArchives sourceEArchives=getById(sourceId);
		Map param=new HashMap();
		param.put("personId",personId);
		param.put("sortNum",targetEArchives.getSortNum());
		dao.update("updateByTargeId",param);
		sourceEArchives.setSortNum(targetEArchives.getSortNum());
		update(sourceEArchives);
	}

	public  Long  getNextNum(Long personId){
		Map param=new HashMap();
		param.put("personId",personId);
        Long maxNum= (Long)dao.getOne("getMaxNum", param);
		if(maxNum==null){
			return 0L;
		}
		return maxNum+1;
	}
	public ResultData<EArchives> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<EArchives> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
}
