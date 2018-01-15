package com.xunfeng.business.advert.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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
import com.xunfeng.business.advert.interf.AdWebServiceInterf;
import com.xunfeng.business.advert.model.AdCategory;
import com.xunfeng.business.advert.model.AdWeb;
import com.xunfeng.business.advert.web.form.AdWebForm;
import com.xunfeng.business.cms.util.ServiceUtil;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.db.ResultData;
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
import com.xunfeng.sys.uums.model.SysUser;
 /** 
* @company:河南讯丰信息技术有限公司
* @Description: 广告位内容表 控制器类
* @author:wangyanyan
* @createDate 2016-03-25 11:33:37 
* @version V1.0   
*/
@Controller
@RequestMapping("/business/advert/adWeb/")
public class AdWebController extends BaseController
{
	@Resource
	@Qualifier("adCategory")
	private AdCategoryServiceInterf adCategoryService;
	@Resource
	@Qualifier("adWeb")
	private AdWebServiceInterf adWebService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
	
	
	
	/**
	 * 添加或更新网站广告位内容。
	 * @param request
	 * @param response
	 * @param adWebForm 添加或更新的实体
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("save")
	@Action(description="添加或更新广告位内容表")
	public void save(HttpServletRequest request, HttpServletResponse response,AdWebForm adWebForm) throws Exception
	{
		String resultMsg=null;	
		ResultMessage message=null;	
		
		try{
		    Long caad01=RequestUtil.getLong(request,"caad01");
		    AdWeb adWeb = adWebService.getById(caad01);
			adWeb=adWebForm.getModel(adWeb);
			if(adWebForm.isMvcAdd()){
				resultMsg="添加广告位内容表";
				adWeb.setCaad01(uniqueIdUtil.genId(AdWeb.class.getName()));
				adWeb.setCaad16(new Date());
				adWebService.add(adWeb);
			}else{
				resultMsg="更新广告位内容表";
			    adWebService.update(adWeb);
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
	 * 取得广告位内容表分页列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		ModelAndView mv=this.getAutoView();
		return mv;
	}
	/**
	 * 取得广告位内容表分页列表
	 * @param request
	 * @param response
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("listJson")
	@Action(description="查看网站广告分页列表")
	@ResponseBody
	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
	{	
		QueryFilter filter=new QueryFilter(request);
		ResultData  resultData = adWebService.getAllByExcept(filter);
		return getTableData(resultData.getPageBean().getTotalCount(), resultData.getDataList());
	}
	/**
	 * 删除广告位内容表
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("del")
	@Action(description="删除广告位内容表")
	@ResponseBody
	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage message=null;
		try{
			Long[] lAryId = RequestUtil.getLongAryByStr(request, "caad01");
			//adWebService.delByIds(lAryId);
			SysUser sysUser = ContextUtil.getCurrentUser();
			adWebService.delBathAdByIds(lAryId,sysUser.getAac003());
			message=new ResultMessage(ResultMessage.Success, "删除广告位内容表成功!");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	
	/**
	 * 	新增广告位内容表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("add")
	@Action(description="新增广告位内容表")
	public ModelAndView add(HttpServletRequest request) throws Exception
	{  
		Long caac01 = RequestUtil.getLong(request, "caac01");
		AdCategory adCategory = adCategoryService.getById(caac01);
		AdWebForm  adWebForm=new AdWebForm();
		adWebForm.setCaac01(caac01);
		adWebForm.setCaad13(adCategory.getIndent());
		adWebForm.setCaac02(adCategory.getCaac02());
		ModelAndView modelAndView= new ModelAndView("/business/advert/adWebEdit.jsp");
		
		return modelAndView.addObject("adWebForm",adWebForm);					
	}
	/**
	 * 	编辑广告位内容表
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("edit")
	@Action(description="编辑广告位内容表")
	public ModelAndView edit(HttpServletRequest request) throws Exception
	{
		Long caad01=RequestUtil.getLong(request,"caad01",0L);
		String caac02 = RequestUtil.getString(request,"caac02");
		AdWeb adWeb=adWebService.getById(caad01);
		AdWebForm  adWebForm=new AdWebForm();
		adWebForm.setCaac02(java.net.URLDecoder.decode(caac02,"utf-8"));
		adWebForm.putModel(adWeb);
		
		return getAutoView().addObject("adWebForm",adWebForm);					
	}

	/**
	 * 取得广告位内容表明细
	 * @param request   
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("get")
	@Action(description="查看广告位内容表明细")
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Long caad01=RequestUtil.getLong(request,"caad01");
		AdWeb adWeb = adWebService.getById(caad01);	
		return getAutoView().addObject("adWeb", adWeb);
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
			adWebService.sortOrderNumBatch(lAryId);
			message=new ResultMessage(ResultMessage.Success, "排序成功");
		}catch(Exception ex){
			message=new ResultMessage(ResultMessage.Fail, "排序失败" + ex.getMessage());
			logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
        return message;
	}
	@RequestMapping("fileUpload")
	@ResponseBody
	public void fileUpload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
	        
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
	            writer.println("");
	        }
	    }
	
	 /**
     * 根据文件id取得附件数据。
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("getImageById")
    @Action(description = "根据文件id取得附件数据", exectype = "管理图片", detail = "根据文件id取得图片")
    public void getFileById(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String filePath = RequestUtil.getString(request, "filePath");

        String attachPath = ServiceUtil.getBasePath();

        // 附件保存路径
        String fullPath = StringUtil.trimSufffix(attachPath, File.separator) + File.separator + filePath.replace("/", File.separator);

        byte[] bytes = FileUtil.readByte(fullPath);
        response.getOutputStream().write(bytes);
    }
	private String createFilePath(String tempPath, String fileName) {
        File one = new File(tempPath);
        Calendar cal = Calendar.getInstance();
        Integer year = cal.get(Calendar.YEAR); // 当前年份
        Integer month = cal.get(Calendar.MONTH) + 1; // 当前月份
        one = new File(tempPath + File.separator + year + File.separator + month);
        if (!one.exists()) {
            one.mkdirs();
        }
        return one.getPath() + File.separator + fileName;
    }
}
