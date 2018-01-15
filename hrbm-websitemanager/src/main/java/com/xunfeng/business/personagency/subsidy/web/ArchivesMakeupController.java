package com.xunfeng.business.personagency.subsidy.web;

import java.net.URLDecoder;
import java.util.Date;
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

import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.personagency.archive.interf.ArchiveLendServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.ArchiveLend;
import com.xunfeng.business.personagency.archive.model.Archives;
import com.xunfeng.business.personagency.subsidy.dto.ArchivesMakeupDto;
import com.xunfeng.business.personagency.subsidy.interf.ArchivesMakeupServiceInterf;
import com.xunfeng.business.personagency.subsidy.web.form.ArchivesMakeupForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 社保补贴 控制器类
* @author:wanghan
* @createDate 2016-07-06 11:03:39 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/subsidy/makeup/")
public class ArchivesMakeupController extends BaseController
{

	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("archivesMakeup")
	ArchivesMakeupServiceInterf  archivesMakeupService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personService;
	
	@Resource
	@Qualifier("personExpand")
	private PersonExpandServiceInterf personExpandService;
	
	@Resource
	@Qualifier("archiveLend")
	private ArchiveLendServiceInterf archiveLendService;
	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	/**
	 * 添加或更新社保补贴。
	 * @param request
	 * @param response
	 * @param socialSubsidyForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="档案调出社保补录")
	public void save(HttpServletRequest request, HttpServletResponse response,ArchivesMakeupForm archivesMakeupForm) throws Exception
	{
		String resultMsg="保存";	
		ResultMessage message=null;	
		
		try{

			ArchivesMakeupDto archivesMakeupDto=BeanToBean.copyProperties(archivesMakeupForm, new ArchivesMakeupDto(), false);
			SysUser sysUser=ContextUtil.getCurrentUser();
			SysOrg sysOrg=ContextUtil.getCurrentUserOrg();
			archivesMakeupDto.setCreaterId(sysUser.getAcd230());
			archivesMakeupDto.setCreaterName(sysUser.getAac003());		
			archivesMakeupDto.setCreaterDate(new Date()) ;
			archivesMakeupDto.setCreaterOrgId(sysOrg.getAcd200());
			archivesMakeupDto.setCreaterOrgName(sysOrg.getAcd202());
			archivesMakeupService.archivesMakeup(archivesMakeupDto);

			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");

			writeResultMessage(response.getWriter(),message);
		}catch(RuntimeException ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败："+ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(),message);
		}
		
	}
	
	
	/**
	 * 	新增社保补贴
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("index")
	@Action(description="新增社保补贴")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
	
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/archivesMakeupIndex.jsp");
		
		return modelAndView;				
	}
	/**
	 * 	编辑社保补贴
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑社保补贴")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{	
		Long personId=RequestUtil.getLong(request,"personId",0L);
		ArchivesMakeupForm  archivesMakeupForm=new ArchivesMakeupForm();
		//initCreater(archivesMakeupForm);
		if(personId!=0){//查到当前人员
			PersonBaseInfo personBaseInfo=personService.getById(personId);
			BeanToBean.copyProperties(personBaseInfo, archivesMakeupForm, false);
			PersonExpand personExpand=personExpandService.getByExpPersonId(personId);
			Archives archives=archivesService.getArchivesByPId(personId);
			ArchiveLend archiveLend=archiveLendService.getArchiveLendByArchiveId(archives.getId(), 5L);
			
			if(personExpand!=null){
				BeanToBean.copyProperties(personExpand, archivesMakeupForm, false);
			}
			if(archiveLend!=null){
				BeanToBean.copyProperties(archiveLend, archivesMakeupForm, false);
			}
			//应该取转入日期，这里StorageDate的名字定义不对，应该用定义为ReceiveDate。
			archivesMakeupForm.setStorageDate(archives.getReceiveDate());
			archivesMakeupForm.setArchiveStatus(archives.getArchiveStatus());
			archivesMakeupForm.setArchiveType(archives.getArchiveType());
		}	
		ModelAndView modelAndView= new ModelAndView("/business/personagency/subsidy/archivesMakeupEdit.jsp");
		return modelAndView.addObject("archivesMakeupForm",archivesMakeupForm);					
	}

	@RequestMapping("selArcUser")
	@ResponseBody
	public List<Map> selUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		PageBean pageBean=new PageBean();
		pageBean.setCurrentPage(1);
		pageBean.setPagesize(10);
		String searchValue=request.getParameter("searchValue");
		searchValue=URLDecoder.decode(searchValue, "UTF-8");		
		
		ResultData<Map> resultData=archivesMakeupService.getAllArchivesMakeupPersonList(searchValue, pageBean);

		return resultData.getDataList();		
	
	}
}
