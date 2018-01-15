//package com.xunfeng.sys.attachment.web;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Calendar;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.xunfeng.business.cms.util.ServiceUtil;
//import com.xunfeng.core.annotion.Action;
//import com.xunfeng.core.util.ContextUtil;
//import com.xunfeng.core.util.ExceptionUtil;
//import com.xunfeng.core.util.FileUtil;
//import com.xunfeng.core.util.StringUtil;
//import com.xunfeng.core.web.ResultMessage;
//import com.xunfeng.core.web.controller.BaseController;
//import com.xunfeng.core.web.query.QueryFilter;
//import com.xunfeng.core.web.util.RequestUtil;
//import com.xunfeng.sys.attachment.interf.AttachmentServiceInterf;
//import com.xunfeng.sys.attachment.model.Attachment;
//import com.xunfeng.sys.attachment.web.form.AttachmentForm;
//import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
// /** 
//* @company:河南讯丰信息技术有限公司
//* @Description: 网上认证提交信息表 控制器类
//* @author:jiangxin
//* @createDate 2015-11-26 14:17:23 
//* @version V1.0   
//*/
//@Controller
//@RequestMapping("/sys/attachment/attachment/")
//public class AttachmentController extends BaseController
//{
//	@Resource
//	@Qualifier("attachment")
//	private AttachmentServiceInterf attachmentService;
//	@Resource
//	@Qualifier("uniqueId")
//	private UniqueIdUtilInterf UniqueIdUtil;	
//	
//	/**
//	 * 添加或更新网上认证提交信息表。
//	 * @param request
//	 * @param response
//	 * @param attachment 添加或更新的实体
//	 * @param bindResult
//	 * @param viewName
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("save")
//	@Action(description="添加或更新网上认证提交信息表")
//	public void save(HttpServletRequest request, HttpServletResponse response,AttachmentForm attachmentForm) throws Exception
//	{
//		String resultMsg=null;	
//		ResultMessage message=null;	
//		
//		try{
//		    Long caoa01=RequestUtil.getLong(request,"caoa01");
//		    Attachment attachment = attachmentService.getById(caoa01);
//			attachment=attachmentForm.getModel(attachment);
//			if(attachmentForm.isMvcAdd()){
//				resultMsg="添加网上认证提交信息表";
//				attachment.setCaoa01(UniqueIdUtil.genId());
//				attachmentService.add(attachment);
//				
//			}else{
//				resultMsg="更新网上认证提交信息表";
//			    attachmentService.update(attachment);
//				
//			}
//			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
//
//			writeResultMessage(response.getWriter(),message);
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//			writeResultMessage(response.getWriter(),message);
//		}
//	}
//	//保存校园风采图片
//	@RequestMapping("savePicture")
//	@Action(description="添加或更新网上认证提交信息表")
//	public void savePicture(HttpServletRequest request, HttpServletResponse response,AttachmentForm attachmentForm) throws Exception
//	{
//		String resultMsg=null;	
//		ResultMessage message=null;	
//		try{
//		    String caoa02 = RequestUtil.getString(request, "caoa02");
//		    String caoa03 = RequestUtil.getString(request, "caoa03");
//			resultMsg="添加网上认证提交信息表";
//			attachmentService.saveAttachment(caoa02, caoa03, 9L);
//			message=new ResultMessage(ResultMessage.Success, resultMsg+"成功");
//			writeResultMessage(response.getWriter(),message);
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, resultMsg+"失败");
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//			writeResultMessage(response.getWriter(),message);
//		}
//	}
//	
//	
//	/**
//	 * 取得网上认证提交信息表分页列表
//	 * @param request
//	 * @param response
//	 * @param page
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("list")
//	public ModelAndView list(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		ModelAndView mv=this.getAutoView();
//		
//		return mv;
//	}
//	/**
//	 * 取得网上认证提交信息表分页列表
//	 * @param request
//	 * @param response
//	 * @param page
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("listJson")
//	@Action(description="查看从业人员信息表分页列表")
//	@ResponseBody
//	public Map<Object,Object> listJson(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{	
//		QueryFilter fiter=new QueryFilter(request);
//		List<Attachment> list=attachmentService.getAll(fiter);		
//		return getTableData(fiter.getPageBean().getTotalCount(), list);
//	}
//	/**
//	 * 删除网上认证提交信息表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("del")
//	@Action(description="删除网上认证提交信息表")
//	@ResponseBody
//	public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//
//		ResultMessage message=null;
//		try{
//			Long[] lAryId =RequestUtil.getLongAryByStr(request, "caoa01");
//			attachmentService.delByIds(lAryId);
//			message=new ResultMessage(ResultMessage.Success, "删除网上认证提交信息表成功!");
//		}catch(Exception ex){
//			message=new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
//			logger.error(ExceptionUtil.getExceptionMessage(ex));
//		}
//        return message;
//	}
//		/**
//	 * 	新增网上认证提交信息表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("add")
//	@Action(description="新增网上认证提交信息表")
//	public ModelAndView add(HttpServletRequest request) throws Exception
//	{
//		AttachmentForm  attachmentForm=new AttachmentForm();
//		attachmentForm.putModel(null);
//		ModelAndView modelAndView= new ModelAndView("/sys/attachment/attachmentEdit.jsp");
//		
//		return modelAndView.addObject("attachmentForm",attachmentForm);					
//	}
//	/**
//	 * 	编辑网上认证提交信息表
//	 * @param request
//	 * @param response
//	 * @throws Exception
//	 */
//	@RequestMapping("edit")
//	@Action(description="编辑网上认证提交信息表")
//	public ModelAndView edit(HttpServletRequest request) throws Exception
//	{
//		Long caoa01=RequestUtil.getLong(request,"caoa01",0L);
//		Attachment attachment=attachmentService.getById(caoa01);
//		AttachmentForm  attachmentForm=new AttachmentForm();
//		attachmentForm.putModel(attachment);
//		
//		return getAutoView().addObject("attachmentForm",attachmentForm);					
//	}
//
//	/**
//	 * 取得网上认证提交信息表明细
//	 * @param request   
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping("get")
//	@Action(description="查看网上认证提交信息表明细")
//	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception
//	{
//		Long caoa01=RequestUtil.getLong(request,"caoa01");
//		Attachment attachment = attachmentService.getById(caoa01);	
//		return getAutoView().addObject("attachment", attachment);
//	}
//	
//	
//	@RequestMapping("fileUpload")
//	@ResponseBody
//    public void fileUpload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
//        PrintWriter writer = response.getWriter();
//        try {
//            long userId = ContextUtil.getCurrentUserId(); // 获取当前用户的id
//            boolean mark = true;
//            // 附件保存路径
//            String attachPath = ServiceUtil.getBasePath();
//            Map<String, MultipartFile> files = request.getFileMap();
//            Iterator<MultipartFile> it = files.values().iterator();
//            while (it.hasNext()) {
//                Long fileId = UniqueIdUtil.genId();
//                MultipartFile f = it.next();
//                String oriFileName = f.getOriginalFilename();
//                String extName = FileUtil.getFileExt(oriFileName);
//                if (mark) {
//                    String fileName = fileId + "." + extName;
//                    // 开始写入物理文件
//                    String filePath = "";
//                    filePath = createFilePath(attachPath + File.separator + userId, fileName);
//                    FileUtil.writeByte(filePath, f.getBytes());
//                    String strFileName = filePath.replace(attachPath + File.separator, "");
//                    writer.println(filePath.replace(attachPath + File.separator, ""));
//                    //attachmentService.saveAttachment(strFileName,9L);
//                } else {
//                    logger.error("文件格式不符合要求！");
//                    writer.println("");
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            writer.println("");
//        }
//    }
//    /**
//     * 根据文件id取得附件数据。
//     *
//     * @param request
//     * @param response
//     * @throws IOException
//     */
//    @RequestMapping("getImageById")
//    @Action(description = "根据文件id取得附件数据", exectype = "管理日志", detail = "根据文件id取得附件数据")
//    public void getFileById(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String filePath = RequestUtil.getString(request, "filePath");
//        String attachPath = ServiceUtil.getBasePath();
//        // 附件保存路径
//        String fullPath = StringUtil.trimSufffix(attachPath, File.separator) + File.separator + filePath.replace("/", File.separator);
//        byte[] bytes = FileUtil.readByte(fullPath);
//        response.getOutputStream().write(bytes);
//    }
//    private String createFilePath(String tempPath, String fileName) {
//        File one = new File(tempPath);
//        Calendar cal = Calendar.getInstance();
//        Integer year = cal.get(Calendar.YEAR); // 当前年份
//        Integer month = cal.get(Calendar.MONTH) + 1; // 当前月份
//        one = new File(tempPath + File.separator + year + File.separator + month);
//        if (!one.exists()) {
//            one.mkdirs();
//        }
//        return one.getPath() + File.separator + fileName;
//    }
//
//    @RequestMapping("alreadyColl")
//    public ModelAndView alreadyColl(HttpServletRequest request) throws Exception {
//        String returnUrl=RequestUtil.getPrePage(request);
//        QueryFilter fiter=new QueryFilter(request);
//        fiter.addFilter("caoa04",9L);
//        List<Attachment> attachmentList = attachmentService.getAll(fiter);
//        ModelAndView mv = this.getAutoView();
//        return mv.addObject("attachmentList", attachmentList).
//                addObject("totalCount", fiter.getPageBean().getTotalCount()).
//                addObject("totalPage", fiter.getPageBean().getTotalPage()).
//                addObject("isHasPreviousPage", fiter.getPageBean().isHasPreviousPage()).
//                addObject("isHasNextPage", fiter.getPageBean().isHasNextPage()).
//                addObject("currentPage", fiter.getPageBean().getCurrentPage()).addObject("returnUrl",returnUrl);
//
//    }
//    @RequestMapping("imageShow")
//    @Action(description = "图片展示")
//    public ModelAndView pictureShow(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        ModelAndView result = getAutoView();
//        String id = RequestUtil.getString(request, "caoa01");
//        Attachment attachment =  attachmentService.getById(Long.parseLong(id));
//        result.addObject("caoa02", attachment.getCaoa02());
//        return result;
//    }
//}
