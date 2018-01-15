package com.xunfeng.business.personagency.retired.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.retired.dao.YangLaoDao;
import com.xunfeng.business.personagency.retired.dto.RetiredYlDto;
import com.xunfeng.business.personagency.retired.interf.YangLaoServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 养老待遇申请 Service类
* @author:zhangfan
* @createDate 2016-07-25 16:20:07 
* @version V1.0   
*/
@Service
public class YangLaoService extends BaseService<YangLao> implements YangLaoServiceInterf
{
	@Resource
	private YangLaoDao dao;
	
	@Resource
	private RetiredDeclareService retiredDeclareService;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	 
	public YangLaoService()
	{
	}
	
	@Override
	protected IEntityDao<YangLao, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public void saveOrUpdate(RetiredYlDto retiredYlDto) {
		RetiredDeclare retiredDeclare = retiredDeclareService.getPeopleId(retiredYlDto.getRetiredId());	//获得养老申诉id	
		YangLao yangLao = this.getByPersonId(retiredYlDto.getRetiredId());	//获得养老信息
		if(yangLao!=null){
			
			if(retiredDeclare.getRetiredDeclareStatus().equals("3")){	//判断申诉状态是否为申诉完毕
				retiredDeclare.setRetiredDeclareStatus("3");
			}else{
				retiredDeclare.setRetiredDeclareStatus("2");
			}
			retiredDeclareService.update(retiredDeclare);
			yangLao = BeanToBean.copyProperties(retiredYlDto, yangLao, false);
			yangLao.setPersonId(retiredDeclare.getPeopleId());
			this.update(yangLao);
		}else{
			yangLao = new YangLao();
			yangLao = BeanToBean.copyProperties(retiredYlDto,yangLao, false);
		
			if(retiredDeclare.getRetiredDeclareStatus().equals("3")){	//判断申诉状态是否为申诉完毕
				retiredDeclare.setRetiredDeclareStatus("3");
			}else{
				retiredDeclare.setRetiredDeclareStatus("2");
			}
		
			retiredDeclareService.update(retiredDeclare);
			yangLao.setId(uniqueIdUtilService.genId(YangLao.class.getName()));
			yangLao.setRetiredId(retiredYlDto.getRetiredId());
			yangLao.setPersonId(retiredDeclare.getPeopleId());
			this.add(yangLao);
		}
	}
	
	@Override
	public void saveOrRetiredPl(Long[] arrId, RetiredYlDto retiredYlDto) {
		for(Long retiredId : arrId){
			RetiredDeclare retiredDeclare = retiredDeclareService.getByPersonId(retiredId);
			YangLao yangLao = this.getByRetiredId(retiredId);	//获得养老信息
			Long id;
			if(yangLao!=null){
				if(retiredDeclare.getRetiredDeclareStatus().equals("3")){	//判断申诉状态是否为申诉完毕
					retiredDeclare.setRetiredDeclareStatus("3");
				}else{
					retiredDeclare.setRetiredDeclareStatus("2");
				}
				retiredDeclareService.update(retiredDeclare);
				id = yangLao.getId();
				yangLao = BeanToBean.copyProperties(retiredYlDto, yangLao, false);
				yangLao.setRetiredId(retiredId);
				yangLao.setPersonId(retiredDeclare.getPeopleId());
				yangLao.setId(id);
				this.update(yangLao);
			}else{
				yangLao = new YangLao();
				yangLao = BeanToBean.copyProperties(retiredYlDto,yangLao, false);
				if(retiredDeclare.getRetiredDeclareStatus().equals("3")){	//判断申诉状态是否为申诉完毕
					retiredDeclare.setRetiredDeclareStatus("3");
				}else{
					retiredDeclare.setRetiredDeclareStatus("2");
				}
				retiredDeclareService.update(retiredDeclare);
				yangLao.setId(uniqueIdUtilService.genId(YangLao.class.getName()));
				yangLao.setRetiredId(retiredId);
				yangLao.setPersonId(retiredDeclare.getPeopleId());
				this.add(yangLao);
			}
		}
		
	}
	
	
	@Override
	public void saveOrUpdatePl(Long[] arrId,YangLao yangLao) {
		
		YangLao retired;
		for (Long retiredId : arrId) {
			retired= this.getByRetiredId(retiredId); 
			if(retired!=null){
				retired.setId(uniqueIdUtilService.genId(YangLao.class.getName()));
				retired.setPayDate(yangLao.getPayDate());
				retired.setRetiredDate(yangLao.getRetiredDate());
				retired.setRetiredId(retiredId);
				dao.update(retired);
			}else{
				retired = new YangLao();
				yangLao.setPayDate(yangLao.getPayDate());
				yangLao.setRetiredDate(yangLao.getRetiredDate());
				yangLao.setId(uniqueIdUtilService.genId(YangLao.class.getName()));
				yangLao.setRetiredId(retiredId);
				BeanToBean.copyProperties(yangLao, retired, false);
				dao.add(retired);
			}
		}
		
	}
	
	@Override
	public YangLao getByRetiredId(Long retiredId) {
		return dao.getByRetiredId(retiredId);
	}

	@Override
	public void delByPersonId(Long personId) {
		dao.delByPersonId(personId);
		
	}

	@Override
	public YangLao getByPersonId(Long personId) {
		return dao.getByPersonId(personId);
	}
	
	
}
