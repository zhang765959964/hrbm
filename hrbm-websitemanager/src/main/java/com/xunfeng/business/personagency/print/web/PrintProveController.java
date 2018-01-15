package com.xunfeng.business.personagency.print.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.payment.web.form.ArchivesPersonBaseForm;
import com.xunfeng.business.personagency.print.interf.PrintTemplateServiceInterf;
import com.xunfeng.business.personagency.print.model.PrintTemplate;
import com.xunfeng.business.personagency.print.util.TemplateUtil;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.engine.FreemarkEngine;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.uums.model.SysUser;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 打印模版 控制器类
* @author:wanghan
* @createDate 2016-10-20 15:19:41 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/personagency/print/printProve/")
public class PrintProveController extends BaseController
{
	@Resource
	@Qualifier("printTemplate")
	private PrintTemplateServiceInterf printTemplateService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	@Resource
	private FreemarkEngine freemarkEngine;

	
	@RequestMapping("list")
	public ModelAndView list1(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Long personId = RequestUtil.getLong(request, "personId", 0L);
		
		Map personMap = new HashMap();
		ArchivesPersonBaseForm archivesPersonForm = new ArchivesPersonBaseForm();
		if (personId != 0) {
			personMap = archivesService.getArchivesByPersonId(personId);
			archivesPersonForm = (ArchivesPersonBaseForm) BeanUtils.populateEntity(personMap, archivesPersonForm);
		}
		ModelAndView mv = new ModelAndView("/business/personagency/print/prove/printProveList.jsp");
		return mv.addObject("archivesPersonForm", archivesPersonForm).addObject("personId", personId);

	}
	/**
	 * 取得打印模版分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv= new ModelAndView("/business/personagency/print/prove/printProveIndex.jsp");		
		return mv;
	}
	@RequestMapping("print")
	@Action(description="编辑打印模版")
	public ModelAndView printProve(HttpServletRequest request) throws Exception
	{
		Long pkId=RequestUtil.getLong(request,"pkId",0L);
		Long personId=RequestUtil.getLong(request,"personId",0L);
		PrintTemplate printTemplate=printTemplateService.getById(pkId);
        String template=printTemplate.getFdModelTemplate();
        Map map=TemplateUtil.getPersonValueMap(personId);
        
		String html = freemarkEngine.parseByStringTemplate(map, template);
		ModelAndView modelAndView= new ModelAndView("/business/personagency/print/prove/printProvePreview.jsp");
		return modelAndView.addObject("html",html);					
	}
}
