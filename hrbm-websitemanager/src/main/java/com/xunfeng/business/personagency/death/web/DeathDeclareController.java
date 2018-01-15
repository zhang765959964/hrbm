package com.xunfeng.business.personagency.death.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.death.interf.DeathDeclareServiceInterf;
import com.xunfeng.business.personagency.death.model.DeathDeclare;
import com.xunfeng.business.personagency.death.web.form.DeathDeclareForm;
import com.xunfeng.business.personagency.death.web.form.DeathPeopleForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 死亡待遇申报 控制器类
* @author:zhangfan
* @createDate 2016-08-26 16:25:11 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/death/")
public class DeathDeclareController extends BaseController
{
	@Resource
	@Qualifier("deathDeclare")
	private DeathDeclareServiceInterf deathDeclareService;
	@Resource
	@Qualifier("archives")
	private  ArchivesServiceInterf archivesService;
	
	@Resource
	@Qualifier("personExpand")
	private PersonExpandServiceInterf personExpandService;	//个人信息扩展表Service
	
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	/**
	 * 添加或更新死亡待遇申报。
	 * @param request
	 * @param response
	 * @param deathDeclareForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新死亡待遇申报")
	public void save(HttpServletRequest request, HttpServletResponse response,DeathDeclareForm deathDeclareForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    DeathDeclare deathDeclare = deathDeclareService.getById(id);
		    float fjMoney =  deathDeclareForm.getMonthFjMoney()!=null?deathDeclareForm.getMonthFjMoney():0;
		    float flMoney =	deathDeclareForm.getMonthFlMoney()!=null?deathDeclareForm.getMonthFlMoney():0;
	        deathDeclareForm.setMonthSumMoney(fjMoney+flMoney);
	        float sfMoney = deathDeclareForm.getSfMoney()!=null? deathDeclareForm.getSfMoney():0;
	        float oneMoney = deathDeclareForm.getOneMoney()!=null?deathDeclareForm.getOneMoney():0;
	        deathDeclareForm.setOneSumMoney(sfMoney+oneMoney);
			deathDeclare=deathDeclareForm.getModel(deathDeclare);
			Archives archives = archivesService.getArchivesByPId(deathDeclareForm.getDeathPeopleForm().getPersonId());
			PersonExpand personExpand =  personExpandService.getByExpPersonId(deathDeclareForm.getDeathPeopleForm().getPersonId());
			if(personExpand!=null){
				if(deathDeclareForm.getDeathNo()!=null){
					personExpand.setExpPersonNumber(deathDeclareForm.getDeathNo());
				}
				personExpandService.update(personExpand);
			}
			if(deathDeclareForm.isMvcAdd()){
				resultMsg="添加死亡待遇申报";
				
				deathDeclare.setId(uniqueIdUtil.genId(DeathDeclare.class.getName()));
				deathDeclare.setPersonId(deathDeclareForm.getDeathPeopleForm().getPersonId());
				deathDeclareService.add(deathDeclare);
				if(archives!=null){
					archives.setArchiveStatus(3L);
					archivesService.update(archives);
				}
			}else{
				resultMsg="更新死亡待遇申报";
				deathDeclare.setPersonId(deathDeclareForm.getDeathPeopleForm().getPersonId());
			    deathDeclareService.update(deathDeclare);
			    if(archives!=null){
					archives.setArchiveStatus(3L);
					archivesService.update(archives);
				}
			}
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	
	
	/**
	 * 取得死亡待遇申报分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/death/deathDeclareList.jsp");
		return mv;
	}
	
	
	
	/**
	 * 初始化进入死亡待遇页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("search")
	public ModelAndView load(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mv = new ModelAndView("/business/personagency/death/searchDeath.jsp");
		return mv;
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchList")
	@Action(description="查询死亡待遇申报")
	public ModelAndView searchList(HttpServletRequest request,HttpServletResponse response) throws Exception{
 		Long personId = RequestUtil.getLong(request, "personId",0L);
 		Long deathId =0l;
 	
 		
 		Map deathMap = new HashMap<String,Object>();	//退休map
 		DeathDeclareForm deathDeclareForm = new DeathDeclareForm();
 		DeathPeopleForm deathPersonForm = new DeathPeopleForm();
 		if(personId!=0L){ 
 			deathMap=	deathDeclareService.getByPersonId(personId);
 			BeanUtils.populateEntity(deathMap, deathPersonForm);
 			DeathDeclare deathDeclare = deathDeclareService.getByDeathPersonId(personId);
 			if(deathDeclare!=null){
 				deathId = deathDeclare.getId();
 				BeanToBean.copyProperties(deathDeclare,deathDeclareForm,false);
 			}else{
 				initCreater(deathDeclareForm);
 			}
 			deathDeclareForm.setDeathPeopleForm(deathPersonForm);
 		}else{
 			initCreater(deathDeclareForm);
 		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/death/searchDeathList.jsp");
		return modelAndView.addObject("deathDeclareForm",deathDeclareForm).
				addObject("deathPersonForm", deathPersonForm).addObject("personId", personId).
				addObject("deathId",deathId);
	} 
	
	
	/**
	 * 取得死亡待遇申报分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		ResultData resultData=deathDeclareService.getAllByFilter(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	/**
	 * 取得死亡待遇申报列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public List searchListJson(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		ResultData  resultData = deathDeclareService.getByPersonIdOraAchiveCode(fiter);
 		return resultData.getDataList();
	}
	
	/**
	 * 根据人员信息删除死亡申报信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("delByPersonId")
	@Action(description="删除死亡待遇申报")
	@ResponseBody
	public ResultMessage delByPersonId(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long personId  =RequestUtil.getLong(request, "personId");
			Archives archive = archivesService.getArchivesByPId(personId);	
			archive.setArchiveStatus(1L);
			archivesService.update(archive);	//更新档案状态为在档	
			deathDeclareService.delByPersonId(personId);
			message=new ResultMessage(ResultMessage.Success, "删除死亡待遇申报成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	/**
	 * 删除死亡待遇申报
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除死亡待遇申报")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			deathDeclareService.delByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除死亡待遇申报成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增死亡待遇申报
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增死亡待遇申报")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		DeathDeclareForm  deathDeclareForm=new DeathDeclareForm();
		deathDeclareForm.putModel(null);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/death/deathDeclareEdit.jsp");
		return modelAndView.addObject("deathDeclareForm",deathDeclareForm);					
	}
	/**
	 * 	编辑死亡待遇申报
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑死亡待遇申报")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		DeathDeclare deathDeclare=deathDeclareService.getById(id);
		DeathDeclareForm  deathDeclareForm=new DeathDeclareForm();
		ModelAndView modelAndView= new ModelAndView("/business/personagency/death/deathDeclareEdit.jsp");
		return modelAndView.addObject("deathDeclareForm",deathDeclareForm);					
	}

	
	
	/**
	 * 适用于综合查询代理详细查询 
	 * 死亡待遇申报列表信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deathDeclarevListJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> getByvPersonId(HttpServletRequest request,HttpServletResponse response) throws Exception{
		QueryFilter fiter=new QueryFilter(request);
		Long personId = RequestUtil.getLong(request, "personId");
		fiter.addFilter("personId", personId);
		ResultData resultData= deathDeclareService.getByvPersonId(fiter);
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	
}
