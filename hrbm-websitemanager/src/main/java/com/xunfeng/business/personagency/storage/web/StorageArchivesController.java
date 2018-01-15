package com.xunfeng.business.personagency.storage.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonEducationServiceInterf;
import com.xunfeng.business.person.interf.PersonFamilyServiceInterf;
import com.xunfeng.business.person.interf.PersonWorkExpceServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.archive.web.form.ArchivesForm;
import com.xunfeng.business.personagency.receive.dto.GongZuoDto;
import com.xunfeng.business.personagency.receive.dto.JiaTingDto;
import com.xunfeng.business.personagency.receive.dto.JiaoYuDto;
import com.xunfeng.business.personagency.receive.dto.PersonBaseDto;
import com.xunfeng.business.personagency.receive.dto.ReceiveArchivesPersonDto;
import com.xunfeng.business.personagency.receive.interf.ReceiveArchivesServiceInterf;
import com.xunfeng.business.personagency.receive.web.form.GongZuoForm;
import com.xunfeng.business.personagency.receive.web.form.JiaTingForm;
import com.xunfeng.business.personagency.receive.web.form.JiaoYuForm;
import com.xunfeng.business.personagency.receive.web.form.PersonBaseForm;
import com.xunfeng.business.personagency.receive.web.form.ReceiveArchivesPersonForm;
import com.xunfeng.business.personagency.retired.model.YangLao;
import com.xunfeng.business.personagency.retired.web.form.RetiredYangLaoForm;
import com.xunfeng.business.personagency.retired.web.form.YangLaoForm;
import com.xunfeng.business.personagency.storage.web.form.StorageArchivesPersonForm;
import com.xunfeng.business.personagency.storage.web.form.StorageArchivesSaveForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jx
* @createDate 2016年7月14日
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/storage/storage/")
public class StorageArchivesController extends BaseController
{
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	
	/**
	 * 取得人员档案表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/storage/searchStorageArchives.jsp");
		return mv;
	}
	/**
	 * @param request
	 * @return 返回个人档案移库的界面
	 * @throws Exception
	 */
	@RequestMapping("resultList")
	@Action(description="档案移库页面")
	public ModelAndView resultList(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		StorageArchivesPersonForm storageArchivesPersonForm = new StorageArchivesPersonForm();
		Map archivesMap = new HashMap();
		if(personId!=0){
			archivesMap = archivesService.getStorageArchivesByPersonId(personId);
		}	
		storageArchivesPersonForm = (StorageArchivesPersonForm) BeanUtils.populateEntity(archivesMap, storageArchivesPersonForm);
		
		Archives archives = archivesService.getArchivesByPId(personId);
		StorageArchivesSaveForm storageArchivesSaveForm = new StorageArchivesSaveForm();
		if(archives!=null){
			storageArchivesSaveForm = BeanToBean.copyProperties(archives, storageArchivesSaveForm, false);
		}
		//赋值经办信息
		SysUser sysUser=ContextUtil.getCurrentUser();
		storageArchivesSaveForm.setArchiveStorageUserid(sysUser.getAcd230());
		storageArchivesSaveForm.setArchiveStorageName(sysUser.getAac003());
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		storageArchivesSaveForm.setArchiveStorageOrgId(sysOrg.getAcd200());
		storageArchivesSaveForm.setArchiveStorageOrgName(sysOrg.getAcd202());
		storageArchivesSaveForm.setArchiveStorageDate(new Date());
		
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/resultStorageArchives.jsp");
		modelAndView.addObject("storageArchivesPersonForm", storageArchivesPersonForm).addObject("storageArchivesSaveForm",storageArchivesSaveForm)
					.addObject("personId",personId).addObject("archiveId", storageArchivesSaveForm.getId()==null?0l:storageArchivesSaveForm.getId());
		return modelAndView;					
	}
	/**
	 * @param request
	 * @param response
	 * @param archivesForm  档案移库保存
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="档案移库保存")
	public void save(HttpServletRequest request, HttpServletResponse response,StorageArchivesSaveForm  storageArchivesSaveForm) throws Exception
	{
		String resultMsg = "档案移库";
		ResultMessage message=null;	
		try{
			Archives archives = archivesService.getById(storageArchivesSaveForm.getId());
			archives = BeanToBean.copyProperties(storageArchivesSaveForm, archives, false);
			archives.setArchiveReceiveStatus(2l);
			archives.setStorageDate(new Date());
			archivesService.update(archives);
			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
	}
	//normalStorage
	@RequestMapping("normalList")
	public ModelAndView normalList(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/storage/normalSearchStorageArchives.jsp");
		return mv;
	}
	
	@RequestMapping("normalResultList")
	@Action(description="档案入库页面")
	public ModelAndView normalResultList(HttpServletRequest request) throws Exception
	{
		Long personId=RequestUtil.getLong(request,"personId",0L);
		StorageArchivesPersonForm storageArchivesPersonForm = new StorageArchivesPersonForm();
		Map archivesMap = new HashMap();
		if(personId!=0){
			archivesMap = archivesService.getStorageArchivesByPersonId(personId);
		}	
		storageArchivesPersonForm = (StorageArchivesPersonForm) BeanUtils.populateEntity(archivesMap, storageArchivesPersonForm);
		//赋值经办信息
		SysUser sysUser=ContextUtil.getCurrentUser();
		SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
		String archiveStorageDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		ModelAndView modelAndView= new ModelAndView("/business/personagency/storage/normalResultStorageArchives.jsp");
		modelAndView.addObject("storageArchivesPersonForm", storageArchivesPersonForm).addObject("personId",personId)
					.addObject("archiveId", storageArchivesPersonForm.getId()==null?0l:storageArchivesPersonForm.getId())
					.addObject("archiveStorageDate",archiveStorageDate).addObject("archiveStorageName",sysUser.getAac003())
					.addObject("archiveStorageOrgName",sysOrg.getAcd202());
		return modelAndView;					
	}
	
	
	@RequestMapping("listJson")
	@Action(description="查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter fiter=new QueryFilter(request);
		fiter.addFilter("archiveStatus", 1);
		fiter.addFilter("archiveFlowStatus", 9);
		fiter.addFilter("archiveReceiveStatus", 1);
		if("0".equals(fiter.getFilters().get("personId"))){
			fiter.getFilters().remove("personId");
		}
		ResultData  resultData = archivesService.getAllArchives(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	
	@RequestMapping("normalArchiveDiv")
	@Action(description="查询养老待遇申请信息")
	public ModelAndView normalArchiveDiv(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		Long personId=RequestUtil.getLong(request,"personId",0L);
		StorageArchivesPersonForm storageArchivesPersonForm = new StorageArchivesPersonForm();
		Map archivesMap = new HashMap();
		if(personId!=0){
			archivesMap = archivesService.getStorageArchivesByPersonId(personId);
		}	
		storageArchivesPersonForm = (StorageArchivesPersonForm) BeanUtils.populateEntity(archivesMap, storageArchivesPersonForm);
		ModelAndView mv = new ModelAndView("/business/personagency/storage/normalArchiveDiv.jsp");
					 mv.addObject("storageArchivesPersonForm", storageArchivesPersonForm);
		return mv;
		
	}
	
	@RequestMapping("storeConfirm")
	@Action(description="档案入库")
	@ResponseBody
	public ResultMessage storeConfirm(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "Ids");
			Archives archives = new Archives ();
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			archives.setStorageDate(new Date());
			archives.setArchiveStorageDate(new Date());
			archives.setArchiveStorageUserid(sysUser.getAcd230());
			archives.setArchiveStorageName(sysUser.getAac003());
			archives.setArchiveStorageOrgId(sysOrg.getAcd200());
			archives.setArchiveStorageOrgName(sysOrg.getAcd202());
			archivesService.addStoreConfirm(lAryId,archives);
			message=new ResultMessage(ResultMessage.Success, "档案入库确认成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "档案入库确认失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
}
