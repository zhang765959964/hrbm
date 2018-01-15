package com.xunfeng.business.personagency.subsidy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.service.ArchiveLendService;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.business.personagency.subsidy.dao.ArchivesMakeupDao;
import com.xunfeng.business.personagency.subsidy.dto.ArchivesMakeupDto;
import com.xunfeng.business.personagency.subsidy.interf.ArchivesMakeupServiceInterf;
import com.xunfeng.business.personagency.subsidy.model.ArchivesMakeup;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 社保补贴 Service类
 * @author:wanghan
 * @createDate 2016-07-06 11:03:39
 * @version V1.0
 */
@Service
public class ArchivesMakeupService extends BaseService<ArchivesMakeup> implements ArchivesMakeupServiceInterf {
	@Resource
	private PersonBaseInfoService baseInfoService;
	@Resource
	private PersonExpandService personExpandService;
	@Resource
	UniqueIdUtilService uniqueIdUtilService;
	@Resource
	ArchiveLendService archiveLendService;
	@Resource
	ArchivesService archivesService;
	@Resource
	private ArchivesMakeupDao dao;
	
	
	
	public ArchivesMakeupService()
	{
	}
	
	@Override
	protected IEntityDao<ArchivesMakeup, Long> getEntityDao() 
	{
		return dao;
	}
	public ResultData<ArchivesMakeup> getAllByFilter(QueryFilter fiter){
		ResultData resultData=new ResultData();
		List<ArchivesMakeup> dataList=dao.getAll(fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
		
	}
	public void archivesMakeup(ArchivesMakeupDto archivesMakeupDto) {
		Archives archives=archivesService.getArchivesByPId(archivesMakeupDto.getAac001());
		if(archives==null){
			throw new RuntimeException("无档案信息不能补录"); 
		}
		ArchivesMakeup archivesMakeup=this.getArchivesMakeupByPersonId(archivesMakeupDto.getAac001());
		if(archivesMakeup!=null){
			throw new RuntimeException("该人员已调出补录，无需补录"); 
		}
        //更新人员基本信息
		PersonBaseInfo basePerson = baseInfoService.getById(archivesMakeupDto.getAac001());		
		basePerson = BeanToBean.copyProperties(archivesMakeupDto, basePerson, false);
		PersonExpand personExpand=personExpandService.getByExpPersonId(archivesMakeupDto.getAac001());
		if(personExpand==null){
			personExpand=new PersonExpand();
			personExpand=BeanToBean.copyProperties(archivesMakeupDto, personExpand, false);
			personExpand.setExpandId(uniqueIdUtilService.genId(PersonExpand.class.getName()));
			personExpandService.add(personExpand);
		}else{
			personExpand=BeanToBean.copyProperties(archivesMakeupDto, personExpand, false);
			personExpandService.update(personExpand);
		}	
		//增加档案信息
		archivesMakeup=new ArchivesMakeup();
		archivesMakeup=BeanToBean.copyProperties(archivesMakeupDto, archivesMakeup, false);
		archivesMakeup.setId(uniqueIdUtilService.genId(ArchivesMakeup.class.getName()));
		archivesMakeup.setArchiveCode(archivesMakeupDto.getArchiveCode());
		archivesMakeup.setPersonId(archivesMakeupDto.getAac001());
		archivesMakeup.setArchiveId(archives.getId());

		baseInfoService.update(basePerson);
		this.add(archivesMakeup);

		
	}
	
	public ArchivesMakeup getArchivesMakeupByPersonId(Long personId){
		
		Map params=new HashMap();
		params.put("personId", personId);
		
		return dao.getUnique("getAll", params);
	} 
	public ResultData<Map>  getAllArchivesMakeupPersonList(String searchValue,PageBean pageBean){
		ResultData<Map> resultData=new ResultData<Map>();
		QueryFilter queryFilter=new QueryFilter();
		queryFilter.addFilter("searchValue", "%"+searchValue+"%");
		queryFilter.setPageBean(pageBean);
		List<Map> dataList= dao.getListForm("getAllArchivesMakeupPersonList", queryFilter) ;

        resultData.setDataList(dataList);
        resultData.setPageBean(pageBean);
        return resultData;
	}
	

}
