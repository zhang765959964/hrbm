package com.xunfeng.business.personagency.retired.service;


import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.person.service.PersonBaseInfoService;
import com.xunfeng.business.person.service.PersonExpandService;
import com.xunfeng.business.person.service.PersonWorkExpceService;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.service.ArchivesService;
import com.xunfeng.business.personagency.retired.dao.RetiredDeclareDao;
import com.xunfeng.business.personagency.retired.dto.RetiredAllDto;
import com.xunfeng.business.personagency.retired.dto.RetiredDeclareDto;
import com.xunfeng.business.personagency.retired.dto.RetiredYlDto;
import com.xunfeng.business.personagency.retired.interf.RetiredDeclareServiceInterf;
import com.xunfeng.business.personagency.retired.model.RetiredCard;
import com.xunfeng.business.personagency.retired.model.RetiredDeclare;
import com.xunfeng.business.personagency.retired.model.RetiredSocial;
import com.xunfeng.business.personagency.retired.model.RetiredXh;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ZJ_DateUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.enumeration.SeqType;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 退休人员申报表 Service类
* @author:zhangfan
* @createDate 2016-07-16 11:24:12 
* @version V1.0   
*/
@Service
public class RetiredDeclareService extends BaseService<RetiredDeclare> implements RetiredDeclareServiceInterf
{
	@Resource
	private RetiredDeclareDao dao;
	
	@Resource
	private PersonBaseInfoService personService;	//个人service
	
	@Resource
	private ArchivesService archivesService;	//档案service
	
	@Resource
	private PersonExpandService personExpandService;	//个人信息扩展表Service
	
	@Resource
	private PersonWorkExpceService personWorkExpceService;	//个人工作Service
	
	@Resource
	private YangLaoService yangLaoService;	//养老申诉Service
	
	@Resource
	private RetiredCardService retiredCardService;	//领取退休证service
	
	@Resource
	private RetiredSocialService retiredSocialService;	//领取人员转社会化service
	
	@Resource
	private RetiredXhService retiredXhService;	//退休人员历史记录序号service

	@Resource
	UniqueIdUtilService  uniqueIdUtilService;
	
	@Resource
	WorkExperienceService workExperienceService;
	
	@Resource
	WorkKjService workKjService;
	
	
	
	public RetiredDeclareService()
	{
	}
	
	@Override
	protected IEntityDao<RetiredDeclare, Long> getEntityDao() 
	{
		return dao;
	}

	@Override
	public Map getRetiredByPersonId(Long personId) {

		return dao.getRetiredByPersonId(personId);
	}
	
	
	@Override
	public RetiredDeclare getPeopleId(Long peopleId) {
		
		return dao.getPersonId(peopleId);
	}
	
	
	@Override
	public void updateRetiredStatus(RetiredYlDto retiredYlDto) {
		
		RetiredDeclare retiredDeclare = this.getById(retiredYlDto.getRetiredId());	//获得退休申诉信息
		retiredDeclare.setRetiredDeclareStatus("1");	//更新退休申诉状态
		dao.update(retiredDeclare);
		
		YangLao yangLao = yangLaoService.getByRetiredId(retiredYlDto.getRetiredId());	//获得养老信息
		if(yangLao!=null){
			 yangLao = BeanToBean.copyProperties(retiredYlDto,yangLao ,false);
			 yangLaoService.update(yangLao);
			 
		}else{
			yangLao = BeanToBean.copyProperties(retiredYlDto,yangLao ,false);
			yangLaoService.add(yangLao);
			
		}
		
		
	}
	
	/**
	 * 根据退休依据返回个人编码数据
	 * @param typeId
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getByRetiredType(String typeId){
		String grbh ="";
		RetiredXh retiredXh =  retiredXhService.getByRetiredType(typeId);	//获得最小的序号历史记录
		if(retiredXh!=null){	//如何历史记录有值 的话，就用历史记录中的数据 
			grbh =retiredXh.getBm();	
			retiredXhService.delByBm(grbh);			//用玩之后再删除
		}
		return grbh;
	}
	
	
	
	@SuppressWarnings("unused")
	private String getRetiredTypeId(String typeId){
		
		if(typeId.equals("2")){		//特殊工种
			typeId = "2";
		}else if(typeId.equals("3")){	//病退
			typeId = "3";
		}else if (typeId.equals("7")){	//超龄退休
			typeId = "7";
		}else{	//工人正常退休
			typeId = "1";
		}
		return typeId;
		
	}
	
	
	
	/**
	 * 自动生成退休编码
	 * @param typeId	退休类别
	 * @param retiredType	申报分类
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getReiterdBh(String typeId,String retiredType){
		String grbh ="";
			RetiredXh retiredXh =null;
			if(retiredType.equals("0")){	//正常申报
//				grbh = ZJ_DateUtils.getNextDateYYmm();\
				grbh = "";
				typeId = this.getRetiredTypeId(typeId);
				retiredXh =  retiredXhService.getByRetiredTypeOrBm(typeId, grbh);
				if(retiredXh!=null){
					grbh =retiredXh.getBm();	
					retiredXhService.delByBm(grbh);			//用玩之后再删除
					return grbh;
				}
				Long xh = 0l;	//初始化个人编号
				if(typeId.equals("1")){
					SeqType tx=SeqType.正常退休;
					tx.setCode(grbh+SeqType.正常退休);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//从 0001 开始
				}else if(typeId.equals("2")){	
					xh+=9000;
					SeqType tx = SeqType.特殊工种;
					tx.setCode(grbh+SeqType.特殊工种);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//从9001 开始
					Long aa = Long.parseLong(grbh);
					aa +=xh;
					grbh = aa.toString();
				}else if(typeId.equals("7")){
					xh+=7000;
					SeqType tx = SeqType.超龄退休;
					tx.setCode(grbh+SeqType.超龄退休);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//7001开始
					Long aa = Long.parseLong(grbh);
					aa +=xh;
					grbh = aa.toString();
				}else if(typeId.equals("3")){
					xh+=8000;
					SeqType tx = SeqType.病退;
					tx.setCode(grbh+SeqType.病退);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);		//从8001开始
					Long aa = Long.parseLong(grbh);
					aa +=xh;
					grbh = aa.toString();
				}else{
					SeqType tx=SeqType.正常退休;
					tx.setCode(grbh+SeqType.正常退休);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//就是正常退休吧
					
				}
			}else{
				retiredXh =  retiredXhService.getByRetiredTypeOrBm(typeId, grbh);
				if(retiredXh!=null){
					grbh =retiredXh.getBm();	
					retiredXhService.delByBm(grbh);			//用玩之后再删除
					return grbh;
				}
				Long xh = 0l;	//初始化个人编号
				if(typeId.equals("1")){
					SeqType tx=SeqType.正常退休;
					tx.setCode(grbh+SeqType.正常退休);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//从 0001 开始
				}else if(typeId.equals("2")){
					xh+=9000;
					SeqType tx = SeqType.特殊工种;
					tx.setCode(grbh+SeqType.特殊工种);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//从9001 开始
					Long aa = Long.parseLong(grbh);
					aa +=xh;
					grbh = aa.toString();
				}else if(typeId.equals("7")){
					xh+=7000;
					SeqType tx = SeqType.超龄退休;
					tx.setCode(grbh+SeqType.超龄退休);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//7001开始
					Long aa = Long.parseLong(grbh);
					aa +=xh;
					grbh = aa.toString();
				}else if(typeId.equals("3")){
					xh+=8000;
					SeqType tx = SeqType.病退;
					tx.setCode(grbh+SeqType.病退);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);		//从8001开始
					Long aa = Long.parseLong(grbh);
					aa +=xh;
					grbh = aa.toString();
				}else{
					SeqType tx=SeqType.正常退休;
					tx.setCode(grbh+SeqType.正常退休);
					grbh += uniqueIdUtilService.getBusniessSeqCode(tx,4);	//就是正常退休吧
				}
			}
		return grbh;
	}
	
	
	@Override
	public boolean saveOrUpdateRetired(RetiredDeclareDto retiredDeclareDto) {
		boolean flag =false;
		String nationId=null;	//民族
		Date expStartJobDate;	//参加工作时间变量
		String expPersonNumber=null;	//个人编号
		try {	
			RetiredDeclareDto rdDto = new RetiredDeclareDto();
			Map rdMap = this.getRetiredByPersonId(retiredDeclareDto.getRetiredDto().getPersonId());
			rdDto = (RetiredDeclareDto) BeanUtils.populateEntity(rdMap, rdDto);
			rdDto = BeanToBean.copyProperties(retiredDeclareDto, rdDto, false);
			expStartJobDate = retiredDeclareDto.getCreateWorkDate();	//参加工作时间
			expPersonNumber = retiredDeclareDto.getRetiredPeopleNo();	//个人编号
			PersonBaseInfo personBaseInfo = personService.getById(rdDto.getRetiredDto().getPersonId()); 	//获得人员id
			if(personBaseInfo!=null){
					nationId = retiredDeclareDto.getNationalId();
					personBaseInfo.setAac001(rdDto.getRetiredDto().getPersonId());
			    	personBaseInfo.setAae005(rdDto.getRetiredDto().getMobilePhone());
			    	personBaseInfo.setAab301(rdDto.getRetiredDto().getAddre());
			    	personBaseInfo.setAac005(nationId);
			    	personService.update(personBaseInfo);   //更新单位基本表信息
			}
			if(rdDto.getRetiredDto().getExpandId()!=null){		//个人档案不为null
		    PersonExpand personExpand = personExpandService.getById(rdDto.getRetiredDto().getExpandId());
		    	if(personExpand != null){	// 个人信息扩展表
		    		personExpand.setExpandId(rdDto.getRetiredDto().getExpandId());
		    		personExpand.setExpSoctalNumber(rdDto.getRetiredDto().getShbzh());
		    		personExpand.setExpOldCompany(rdDto.getRetiredDto().getOldCompany());
//		    		personExpand.setExpAddress(rdDto.getRetiredDto().getAddre());
		    		personExpand.setExpPersonPhone(rdDto.getRetiredDto().getPhone());
		    		personExpand.setExpCardNumber(rdDto.getRetiredDto().getCardAddre());
		    		if(retiredDeclareDto.getCreateWorkDate()!=null){
		    			personExpand.setExpStartJobDate(expStartJobDate);
		    		}
		    		if(retiredDeclareDto.getRetiredPeopleNo()!=null){
		    			personExpand.setExpPersonNumber(retiredDeclareDto.getRetiredPeopleNo());
		    		}
		    		personExpandService.update(personExpand);
		    	}
			}
			if(rdDto.getRetiredDto().getArchivesId()!=null){		//档案表不为null
					Archives archives = archivesService.getById(rdDto.getRetiredDto().getArchivesId());
					archives.setId(rdDto.getRetiredDto().getArchivesId());
			    	archives.setArchiveBirthDate(rdDto.getRetiredDto().getBirthDate());
			    	archivesService.update(archives);
			}   
			RetiredDeclare retiredDeclare = this.getPeopleId(rdDto.getRetiredDto().getPersonId());		//获得退休申诉id
			if(retiredDeclare!=null){
				retiredDeclare = BeanToBean.copyProperties(retiredDeclareDto,retiredDeclare, false);
				retiredDeclare.setNationalId(nationId);
				if(retiredDeclare.getRetiredDeclareStatus().equals("待申报")){
					retiredDeclare.setRetiredDeclareStatus("1");
				}
				if(retiredDeclare.getRetiredDeclareStatus().equals("申报中")){
					retiredDeclare.setRetiredDeclareStatus("2");
				}
				if(retiredDeclare.getRetiredDeclareStatus().equals("申报完毕")){
					retiredDeclare.setRetiredDeclareStatus("3");
				}
				this.update(retiredDeclare);	//更新
				flag =false;
			}else{
				retiredDeclare = new RetiredDeclare();	//DECLARE_TYPE 0 正常申报  1 追加申报
				retiredDeclare= BeanToBean.copyProperties(retiredDeclareDto, retiredDeclare, false);
				if(retiredDeclare.getRetiredDeclareStatus().equals("待申报")){
					retiredDeclare.setRetiredDeclareStatus("1");
				}
				if(retiredDeclare.getRetiredDeclareStatus().equals("申报中")){
					retiredDeclare.setRetiredDeclareStatus("2");
				}
				if(retiredDeclare.getRetiredDeclareStatus().equals("申报完毕")){
					retiredDeclare.setRetiredDeclareStatus("3");
				}
				retiredDeclare.setId(uniqueIdUtilService.genId(RetiredDeclare.class.getName()));
				retiredDeclare.setPeopleId(rdDto.getRetiredDto().getPersonId());
				retiredDeclare.setArchiveId(rdDto.getRetiredDto().getArchivesId());
				String bh = this.getReiterdBh(retiredDeclare.getRetiredTypeId(),retiredDeclare.getDeclareType());
				retiredDeclare.setXh(bh.substring(4, 8));	
				retiredDeclare.setRetiredPeopleBm(bh);	//获得自动成功的退休编号
				retiredDeclare.setRetiredStatus(0L);
				retiredDeclare.setNationalId(nationId);
				this.add(retiredDeclare);
				
				RetiredCard card = new RetiredCard();	//是否领取退休证
				card.setId(uniqueIdUtilService.genId(RetiredCard.class.getName()));
				card.setIsRetiredCard(0L);	//默认为否
				card.setPersonId(rdDto.getRetiredDto().getPersonId());
				retiredCardService.add(card);
				
				RetiredSocial rs = new RetiredSocial();	//转社会化
				rs.setId(uniqueIdUtilService.genId(RetiredSocial.class.getName()));
				rs.setPersonId(rdDto.getRetiredDto().getPersonId());
				rs.setIsRetiredSocial(0L);	
				retiredSocialService.add(rs);
				flag =true;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return flag;
	}


	@Override
	public void updateReitedAll(RetiredAllDto retiredAllDto) {
		
		RetiredDeclare retiredDeclare = this.getById(retiredAllDto.getId());	//退休申诉
		YangLao yangLao =null;
		RetiredSocial retiredSocial =null;
		RetiredCard retiredCard = null;
		if(retiredDeclare!=null){
			retiredAllDto.setPersonId(retiredDeclare.getPeopleId());
			retiredDeclare = BeanToBean.copyProperties(retiredAllDto, retiredDeclare, false);
			this.update(retiredDeclare);
			if(retiredDeclare.getPeopleId()!=null){
				yangLao = yangLaoService.getByPersonId(retiredDeclare.getPeopleId());
				if(yangLao!=null){
					yangLao = BeanToBean.copyProperties(retiredAllDto, yangLao, false);
					yangLaoService.update(yangLao);
				}
				retiredSocial = retiredSocialService.getByPersonId(retiredDeclare.getPeopleId());
				if(retiredSocial!=null){
					retiredSocial = BeanToBean.copyProperties(retiredAllDto, retiredSocial,false);
					retiredSocialService.update(retiredSocial);
				}
				retiredCard = retiredCardService.getByPersonId(retiredDeclare.getPeopleId());
				if(retiredCard!=null){
					retiredCard = BeanToBean.copyProperties(retiredAllDto, retiredCard, false);
					retiredCardService.update(retiredCard);
				}
			}
			
		}
		
		
	}
	
	
	
	@Override
	public RetiredDeclare getByPersonId(Long peopleId) {
		
		Map params=new HashMap();
		params.put("peopleId", peopleId);
		return dao.getUnique("getAll", params);
	}

	@Override
	public ResultData<RetiredDeclare> getRetiredList(QueryFilter fiter) {
		ResultData<RetiredDeclare> resultData=new ResultData<RetiredDeclare>();
		List<RetiredDeclare> dataList =dao.getBySqlKey("getRetiredList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Map getRetiredById(Long id) {
		
		return this.dao.getRetiredById(id);
	}

	



	@Override
	public void review(Long[] ids, String retiredStatus,String retiredDeclareStatus) {
		
		Map map=new HashMap();
		for(Long id:ids){
			map.put("id", id);
			map.put("retiredStatus",retiredStatus);
			map.put("retiredDeclareStatus",retiredDeclareStatus);
			dao.update("updateForReview", map);
		}
	}

	@Override
	public ResultData getRetiredBhList(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList =dao.getBySqlKey("getRetiredBhList", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public void updateRetiredBh(Long id, String xh, String retiredPeopleBm,
			String declareNote) {
		Map map=new HashMap();
		map.put("id", id);
		map.put("xh",xh );
		map.put("retiredPeopleBm",retiredPeopleBm);
		map.put("declareNote",declareNote );
		dao.update("updateRetiredBh", map);
	}

	@Override
	public void delByPersonId(Long personId) {
		if(personId!=null){
			RetiredDeclare retiredDeclare =	this.getPeopleId(personId);	//先获得退休的老编号 
			
			if(retiredDeclare!=null){
				RetiredXh retiredXh = new RetiredXh();
				retiredXh.setId(uniqueIdUtilService.genId(RetiredXh.class.getName()));	
				retiredXh.setXh(retiredDeclare.getXh());	//删除的序号
				//先判断状态是否符合自动生成的几个状态，符合的填写当前状态，不符合的状态填写为工人正常退休状态
				if(retiredDeclare.getRetiredTypeId().equals("2")){		//特殊工种
					retiredXh.setType("2"); 
				}else if(retiredDeclare.getRetiredTypeId().equals("7")){	//超龄退休
					retiredXh.setType("7"); 
				}else if(retiredDeclare.getRetiredTypeId().equals("3")){	//病退
					retiredXh.setType("3");
				}else{	//工人正常退休状态返回为1
					retiredXh.setType("1");
				}
				retiredXh.setBm(retiredDeclare.getRetiredPeopleBm()); //退休个人编码
				
				retiredXhService.add(retiredXh);
				dao.delByPersonId(personId);
				workExperienceService.delByPersonId(personId);
				workKjService.delByPersonId(personId);
				yangLaoService.delByPersonId(personId);
				retiredCardService.delByPersonId(personId);
				retiredSocialService.delByPersonId(personId);
			}
			
		
		}
	}

	@Override
	public ResultData getRetiredAll(QueryFilter fiter) {
		ResultData resultData=new ResultData();
		List dataList =dao.getBySqlKey("getRetiredAll", fiter);
		resultData.setDataList(dataList);
		resultData.setPageBean(fiter.getPageBean());
		return resultData;
	}

	@Override
	public Long getByRetiredBm(String retiredBm) {
		return dao.getByRetiredBm(retiredBm);
	}

	@Override
	public List<RetiredDeclare> getByExitBm(QueryFilter fiter) {
		return dao.getBySqlKey("getAll",fiter);
	}

	@Override
	public Map getPrintByPersonId(Long personId) {
		
		return dao.getPrintByPersonId(personId);
	}
	
}
