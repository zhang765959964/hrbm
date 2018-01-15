package com.xunfeng.business.personagency.affair.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.personagency.affair.model.TitleDeclaration;
import com.xunfeng.business.personagency.affair.web.form.TitleDeclarationForm;
import com.xunfeng.business.personagency.affair.interf.TitleDeclarationServiceInterf;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.archive.model.Archives;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 职称申报评定表 控制器类
* @author:jiangxin
* @createDate 2016-09-18 15:38:08 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/affair/titleDeclaration/")
public class TitleDeclarationController extends BaseController
{
	@Resource
	@Qualifier("titleDeclaration")
	private TitleDeclarationServiceInterf titleDeclarationService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf personBaseInfoService;
	
	/**
	 * 添加或更新职称申报评定表。
	 * @param request
	 * @param response
	 * @param titleDeclarationForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新职称申报评定表")
	public void save(HttpServletRequest request, HttpServletResponse response,TitleDeclarationForm titleDeclarationForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long id=RequestUtil.getLong(request,"id");
		    TitleDeclaration titleDeclaration = titleDeclarationService.getById(id);
			titleDeclaration=titleDeclarationForm.getModel(titleDeclaration);
			if(titleDeclarationForm.isMvcAdd()){
				resultMsg="添加职称申报评定";
				titleDeclaration.setId(uniqueIdUtil.genId(TitleDeclaration.class.getName()));
				titleDeclarationService.add(titleDeclaration);
			}else{
				resultMsg="修改职称申报评定";
			    titleDeclarationService.update(titleDeclaration);
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
	 * 取得职称申报评定表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/affair/titleDeclarationList.jsp");
		return mv;
	}
	//职称申报查询
	@RequestMapping("search")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/affair/titleDeclarationSearch.jsp");
		return mv;
	}
	
	/**
	 * 取得职称申报评定表分页列表
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
		if("9".equals(fiter.getFilters().get("aac004"))){
			fiter.getFilters().remove("aac004");
		}
		//ResultData<TitleDeclaration> resultData=titleDeclarationService.getAllByFilter(fiter);	
		ResultData resultData= titleDeclarationService.getAllTitleDeclaration(fiter);		
		return getJqGridData(resultData.getPageBean(), resultData.getDataList());
	}
	/**
	 * 删除职称申报评定表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除职称申报评定表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			titleDeclarationService.deleteTitleDeclarationByIds(lAryId);
			message=new ResultMessage(ResultMessage.Success, "删除职称申报评定信息成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
		/**
	 * 	新增职称申报评定表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增职称申报评定表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{
		TitleDeclarationForm  titleDeclarationForm = new TitleDeclarationForm();
		titleDeclarationForm.putModel(null);
		Long archivesId=RequestUtil.getLong(request,"archivesId",0L);
		Archives archives = archivesService.getById(archivesId);
		if(archives!=null){
			titleDeclarationForm.setPersonId(archives.getPersonId());
			titleDeclarationForm.setArchiveCode(archives.getArchiveCode());
			titleDeclarationForm.setAac002(personBaseInfoService.getById(archives.getPersonId()).getAac002());
			titleDeclarationForm.setAac003(personBaseInfoService.getById(archives.getPersonId()).getAac003());
		}
		titleDeclarationForm.setCczy06("16");
		titleDeclarationForm.setCcpr08("0");
		titleDeclarationForm.setArchivesId(archivesId);
		initCreater(titleDeclarationForm);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/affair/titleDeclarationEdit.jsp");
		return modelAndView.addObject("titleDeclarationForm",titleDeclarationForm);					
	}
	/**
	 * 	编辑职称申报评定表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑职称申报评定表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id",0L);
		TitleDeclaration titleDeclaration=titleDeclarationService.getById(id);
		TitleDeclarationForm  titleDeclarationForm=new TitleDeclarationForm();
		titleDeclarationForm.putModel(titleDeclaration);
		Archives archives = archivesService.getById(titleDeclaration.getArchivesId());
		if(archives!=null){
			titleDeclarationForm.setArchiveCode(archives.getArchiveCode());
			titleDeclarationForm.setAac002(personBaseInfoService.getById(archives.getPersonId()).getAac002());
			titleDeclarationForm.setAac003(personBaseInfoService.getById(archives.getPersonId()).getAac003());
		}
		ModelAndView modelAndView= new ModelAndView("/business/personagency/affair/titleDeclarationEdit.jsp");
		return modelAndView.addObject("titleDeclarationForm",titleDeclarationForm);					
	}

	/**
	 * 取得职称申报评定表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看职称申报评定表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long id=RequestUtil.getLong(request,"id");
		TitleDeclaration titleDeclaration = titleDeclarationService.getById(id);	
		return getAutoView().addObject("titleDeclaration", titleDeclaration);
	}
	
}
