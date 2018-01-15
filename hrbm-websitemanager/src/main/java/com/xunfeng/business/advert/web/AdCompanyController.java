package com.xunfeng.business.advert.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.advert.interf.AdCategoryServiceInterf;
import com.xunfeng.business.advert.interf.AdCompanyServiceInterf;
import com.xunfeng.business.advert.model.AdCategory;
import com.xunfeng.business.advert.model.AdCompany;
import com.xunfeng.business.advert.web.form.AdCompanyForm;
import com.xunfeng.business.cms.util.ServiceUtil;
import com.xunfeng.business.corp.interf.CorpServiceInter;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
import com.xunfeng.core.page.PageBean;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.FileUtil;
import com.xunfeng.core.util.FileWebDavUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.setMeal.interf.FeeOrderDetailServiceInterf;
import com.xunfeng.sys.setMeal.web.emunMeal.MealTypeEmun;
import com.xunfeng.sys.setMeal.web.util.MealResultConst;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 广告位放置表 控制器类
 * @author:wangyanyan
 * @createDate 2016-03-25 11:33:37
 * @version V1.0
 */
@Controller
@RequestMapping("/business/advert/adCompany/")
public class AdCompanyController extends BaseController {
	@Resource
	@Qualifier("corp")
	private CorpServiceInter corpService;
	@Resource
	@Qualifier("adCompany")
	private AdCompanyServiceInterf adCompanyService;
	@Resource
	@Qualifier("adCategory")
	private AdCategoryServiceInterf adCategoryService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;
	@Resource
	@Qualifier("feeOrderDetail")
	private FeeOrderDetailServiceInterf feeOrderDetailService;

	/**
	 * 添加或更新广告位放置表。
	 * @param request
	 * @param response
	 * @param adCompanyForm添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description = "添加或更新广告位放置表")
	public void save(HttpServletRequest request, HttpServletResponse response,
			AdCompanyForm adCompanyForm) throws Exception {
		String resultMsg = null;
		ResultMessage message = null;
		try {
				SysUser sysUser = ContextUtil.getCurrentUser();
				Long caae01 = RequestUtil.getLong(request, "caae01");
				AdCompany adCompany = adCompanyService.getById(caae01);
				adCompany = adCompanyForm.getModel(adCompany);
				adCompany.setCaae10(1l);//状态1正常显示2隐藏 4结束 5审核中 6审核不通过
				adCompany.setAae036(new Date());// 经办日期
				adCompany.setAae019(sysUser.getAac003());// 经办人
				
				adCompany.setAae011(String.valueOf(sysUser.getAac001()));// 经办人代码
				adCompany.setAae017(sysUser.getAae017());// 经办机构代码
				adCompany.setAae020(sysUser.getAae020());// 经办机构
				adCompany.setCczy06("1");//数据来源0未知1网站后台2网站
				if (adCompanyForm.isMvcAdd()) {
					resultMsg = "添加广告位放置表";
					adCompany.setCaae01(uniqueIdUtil.genId(AdCompany.class.getName()));
					Map <String,Object> map = new HashMap<String, Object>();
					map.put("aab001", adCompany.getAab001());
					map.put("aab004", adCompanyForm.getAab004());
					map.put("adCompany", adCompany);
					String isSuc = adCompanyService.addPayOper(map);
					if(MealResultConst.SUC.equals(isSuc)){
						resultMsg = "增加广告位放置表成功";
					}else{
						resultMsg = "套餐不足";
					}
				} else {
					resultMsg = "更新广告位放置表成功";
					adCompanyService.update(adCompany);
				}
			message = new ResultMessage(ResultMessage.Success, resultMsg);
			writeResultMessage(response.getWriter(), message);
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
			logger.error(ExceptionUtil.getExceptionMessage(ex));
			writeResultMessage(response.getWriter(), message);
		}
	}

	/**
	 * 取得广告位放置表分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mv = this.getAutoView();
		return mv;
	}

	/**
	 * 取得广告位放置表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
	    int limit = RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		List<AdCompany> list = adCompanyService.getAll(fiter);
		return getTableData(fiter.getPageBean().getTotalCount(), list);
	}

	/**
	 * 删除广告位放置表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description = "删除广告位放置表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ResultMessage message = null;
		try {
			Long[] lAryId = RequestUtil.getLongAryByStr(request, "caae01");
			SysUser sysUser = ContextUtil.getCurrentUser();
			//adCompanyService.delByIds(lAryId);
			adCompanyService.delBathAdByIds(lAryId,sysUser.getAac003());
			message = new ResultMessage(ResultMessage.Success, "删除广告位放置表成功!");
		} catch (Exception ex) {
			message = new ResultMessage(ResultMessage.Fail, "删除失败"
					+ ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return message;
	}

	/**
	 * 新增广告位放置表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description = "新增广告位放置表")
	public ModelAndView add(HttpServletRequest request) throws Exception {
		Long caid = RequestUtil.getLong(request, "caid");
		Long comid = RequestUtil.getLong(request, "comid");
		String caname = RequestUtil.getString(request, "caname");
		String comname = RequestUtil.getString(request, "comname");
		AdCompanyForm adCompanyForm = new AdCompanyForm();
		adCompanyForm.setCaac01(caid);
		adCompanyForm.setCaac02(java.net.URLDecoder.decode(caname, "utf-8"));
		adCompanyForm.setAab001(comid);
		adCompanyForm.setAab004(java.net.URLDecoder.decode(comname, "utf-8"));
		ModelAndView modelAndView = new ModelAndView(
				"/business/advert/adCompanyEdit.jsp");
		return modelAndView.addObject("adCompanyForm", adCompanyForm);
	}

	/**
	 * 编辑广告位放置表
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description = "编辑广告位放置表")
	public ModelAndView edit(HttpServletRequest request) throws Exception {
		Long caae01 = RequestUtil.getLong(request, "caae01", 0L);
		String caname = RequestUtil.getString(request, "caname");
		String comname = RequestUtil.getString(request, "comname");
		AdCompany adCompany = adCompanyService.getById(caae01);
		AdCompanyForm adCompanyForm = new AdCompanyForm();
		adCompanyForm.setCaac02(java.net.URLDecoder.decode(caname, "utf-8"));
		adCompanyForm.setAab004(java.net.URLDecoder.decode(comname, "utf-8"));
		adCompanyForm.putModel(adCompany);
		return getAutoView().addObject("adCompanyForm", adCompanyForm);
	}

	/**
	 * 取得广告位放置表明细
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description = "查看广告位放置表明细")
	public ModelAndView get(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Long caae01 = RequestUtil.getLong(request, "caae01");
		AdCompany adCompany = adCompanyService.getById(caae01);
		return getAutoView().addObject("adCompany", adCompany);
	}

	/**
	 * 取得企业广告位放置表中数据
	 * @param indent 广告分类标示
	 */
	@RequestMapping("listAdCompany")
	@Action(description = "取得企业广告位放置表中数据")
	@ResponseBody
	public List<Map<String, Object>> listJsonNoPage(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		 String indent = RequestUtil.getString(request, "indent");
		 return  adCompanyService.getadCompanyByIndent(indent);
	}

	/**
	 * 取得企业基本信息表分页列表(没有做广告的企业)
	 * @param indent 广告分类标示
	 */
	@RequestMapping("listNoAdCompany")
	@Action(description = "取得企业基本信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listNoAd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		String aab004 = RequestUtil.getString(request, "aab004");
	    int limit = RequestUtil.getInt(request, "limit");
	    int offset = RequestUtil.getInt(request, "offset");
	    PageBean pageBean =WrapPageBean(limit, offset);
	    fiter.setPageBean(pageBean);
		ResultData resultData = adCompanyService.getNoAdCompanyByExcept(fiter,aab004);
		Map<Object, Object> data = getTableData(resultData.getPageBean()
				.getTotalCount(), resultData.getDataList());
		return data;
	}
	/**
	 * 栏目板块排序
	 */
	@RequestMapping("sortOrderNum")
	@Action(description="栏目板块排序")
	@ResponseBody
	public ResultMessage sortOrderNum(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId =RequestUtil.getLongAryByStr(request, "id");
			adCompanyService.sortOrderNumBatch(lAryId);
			message=new ResultMessage(ResultMessage.Success, "排序成功");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "排序失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	
	/****************************************job************************************************/
	/**
	 * 取得广告位放置表分页列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJob")
	@Action
	public ModelAndView listJob(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView(
				"/business/advert/adJobList.jsp");
		return modelAndView;
	}

	/**
	 * 取得职位广告中做广告的位置right
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listAdJob")
	@Action(description = "查看从业人员信息表分页列表")
	@ResponseBody
	public List<Map<String, Object>> listAdJob(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		 String indent = RequestUtil.getString(request, "indent");
		 QueryFilter filter = new QueryFilter(request);
		 filter.addFilter("indent", indent);
		 return  adCompanyService.getadJobByExcept(filter);
	}

	/**
	 * 取得职位left
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listNoAdJob")
	@Action(description = "查看单位基本信息表分页列表")
	@ResponseBody
	public Map<Object, Object> listNoAdJob(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		QueryFilter fiter = new QueryFilter(request);
		int limit = RequestUtil.getInt(request, "limit");
		 int offset = RequestUtil.getInt(request, "offset");
		 PageBean pageBean =WrapPageBean(limit, offset);
		 fiter.setPageBean(pageBean);
		ResultData resultData = adCompanyService.getJobByExcept(fiter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 职位新增广告位放置
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("addJob")
	@Action(description = "职位新增广告位放置")
	public ModelAndView addJob(HttpServletRequest request) throws Exception {
		Long caid = RequestUtil.getLong(request, "caid");
		Long comid = RequestUtil.getLong(request, "comid");
		Long jobid = RequestUtil.getLong(request, "jobid");
		String caname = RequestUtil.getString(request, "caname");
		String comname = RequestUtil.getString(request, "comname");
		String jobname = RequestUtil.getString(request, "jobname");
		AdCompanyForm adCompanyForm = new AdCompanyForm();
		adCompanyForm.setCaac01(caid);
		adCompanyForm.setCaac02(java.net.URLDecoder.decode(caname, "utf-8"));
		adCompanyForm.setAab001(comid);
		adCompanyForm.setAab004(java.net.URLDecoder.decode(comname, "utf-8"));
		adCompanyForm.setJobid(jobid);
		adCompanyForm.setCca113(java.net.URLDecoder.decode(jobname, "utf-8"));
		ModelAndView modelAndView = new ModelAndView(
				"/business/advert/adJobEdit.jsp");
		return modelAndView.addObject("adCompanyForm", adCompanyForm);
	}

	/**
	 * 职位编辑广告位放置
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("editJob")
	@Action(description = "职位编辑广告位放置表")
	public ModelAndView editJob(HttpServletRequest request) throws Exception {
		Long caae01 = RequestUtil.getLong(request, "caae01", 0L);
		String caname = RequestUtil.getString(request, "caname");
		String comname = RequestUtil.getString(request, "comname");
		String jobname = RequestUtil.getString(request, "jobname");
		AdCompany adCompany = adCompanyService.getById(caae01);
		AdCompanyForm adCompanyForm = new AdCompanyForm();
		adCompanyForm.setCaac02(java.net.URLDecoder.decode(caname, "utf-8"));
		adCompanyForm.setAab004(java.net.URLDecoder.decode(comname, "utf-8"));
		adCompanyForm.setCca113(java.net.URLDecoder.decode(jobname, "utf-8"));
		adCompanyForm.setAab001(adCompany.getAab001());
		adCompanyForm.putModel(adCompany);
		ModelAndView modelAndView = new ModelAndView(
				"/business/advert/adJobEdit.jsp");
		return modelAndView.addObject("adCompanyForm", adCompanyForm);
	}

	/******************************jobend**********************************************/
	@RequestMapping("fileUpload")
	@ResponseBody
	public void fileUpload(MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter writer = response.getWriter();
		try {
			String limitUploadType = RequestUtil.getString(request, "uploadType"); // 图片格式
			String limitFileSize = RequestUtil.getString(request, "fileSize"); // 格式要求
			Long limitFileSizeLong = 1*1024l;
			if(StringUtil.isNotEmpty(limitFileSize) && StringUtil.isNumberic(limitFileSize)){
				limitFileSizeLong = Long.valueOf(limitFileSize)*1024;
			}
			// 附件保存路径
			Map<String, MultipartFile> files = request.getFileMap();
			Iterator<MultipartFile> it = files.values().iterator();
			while (it.hasNext()) {
				Long fileId = uniqueIdUtil.genId("");
				MultipartFile f = it.next();
				Long fileSize = f.getSize()/1024;//装换成kb为单位
				String oriFileName = f.getOriginalFilename();
				String extName = FileUtil.getFileExt(oriFileName);
				if (!(limitUploadType.toUpperCase().contains(extName.toUpperCase()))) { // 图片格式
					writer.println("请上传"+limitUploadType+"格式的图片");
				}else if(limitFileSizeLong < fileSize){// 图片大小
					writer.println( "请选择"+(limitFileSizeLong/1024)+"M之内的图片" );
				}else{
					String fileName = fileId + "." + extName;
					// 开始写入物理文件
					String filePath=FileWebDavUtil.uploadFile(7L, fileName, f.getInputStream());
					writer.println(filePath);
			   }
			}
		} catch (Exception e) {
			e.printStackTrace();
			writer.println("上传图片出错了");
		}
	}
	/**
	 * 根据文件id取得附件数据。
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("getImageById")
	@Action(description = "根据文件id取得附件数据", exectype = "管理图片", detail = "根据文件id取得图片")
	public void getFileById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String filePath = RequestUtil.getString(request, "filePath");

		String attachPath = ServiceUtil.getBasePath();

		// 附件保存路径
		String fullPath = StringUtil.trimSufffix(attachPath, File.separator)
				+ File.separator + filePath.replace("/", File.separator);

		byte[] bytes = FileUtil.readByte(fullPath);
		response.getOutputStream().write(bytes);

	}

	private String createFilePath(String tempPath, String fileName) {
		File one = new File(tempPath);
		Calendar cal = Calendar.getInstance();
		Integer year = cal.get(Calendar.YEAR); // 当前年份
		Integer month = cal.get(Calendar.MONTH) + 1; // 当前月份
		one = new File(tempPath + File.separator + year + File.separator
				+ month);
		if (!one.exists()) {
			one.mkdirs();
		}
		return one.getPath() + File.separator + fileName;
	}
}
