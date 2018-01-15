package com.xunfeng.business.personagency.erecord.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.business.cms.util.ServiceUtil;
import com.xunfeng.business.person.interf.PersonBaseInfoServiceInterf;
import com.xunfeng.business.person.interf.PersonExpandServiceInterf;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonExpand;
import com.xunfeng.business.personagency.erecord.interf.EArchivesServiceInterf;
import com.xunfeng.business.personagency.erecord.interf.ErecordCatalogServiceInterf;
import com.xunfeng.business.personagency.erecord.model.EArchives;
import com.xunfeng.business.personagency.erecord.model.ErecordCatalog;
import com.xunfeng.business.personagency.erecord.web.form.EArchivesForm;
import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.ExceptionUtil;
import com.xunfeng.core.util.FileUtil;
import com.xunfeng.core.util.FileWebDavUtil;
import com.xunfeng.core.util.ImageUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;

/**
 * @version V1.0
 * @company:河南讯丰信息技术有限公司
 * @Description: 电子档案表 控制器类
 * @author:wanghan
 * @createDate 2015-08-10 14:59:21
 */
@Controller
@RequestMapping("/business/erecord/eArchives/")
public class EArchivesController extends BaseController {
	@Resource
	@Qualifier("eArchives")
	private EArchivesServiceInterf eArchivesService;

	@Resource
	@Qualifier("person")
	private PersonBaseInfoServiceInterf bsPersonService;
	
	@Resource
	@Qualifier("erecordCatalog")
	private ErecordCatalogServiceInterf erecordCatalogService;
	
	@Resource
	@Qualifier("personExpand")
	private PersonExpandServiceInterf personExpandService;
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;	
    //附件保存路径
    private String attachPath = ServiceUtil.getBasePath().replace("/", "\\");
    //附件保存类型
    private String saveType = ServiceUtil.getSaveType();
    
    
    //判断目录设置是不是已经已经存储照片
    @RequestMapping("checkDel")
	@Action(description="判断是否存在")
	@ResponseBody
    public ResultMessage checkDel(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ResultMessage resultMessage=null;
		try{
			QueryFilter fiter=new QueryFilter(request);
			 List<EArchives> list = eArchivesService.getAll(fiter);	
			if(list!=null&&list.size()>0){
				 resultMessage = new ResultMessage(ResultMessage.Success,"1");
			}else{
				resultMessage = new ResultMessage(ResultMessage.Fail,"0");
			}
		}catch(Exception ex){
			 resultMessage = new ResultMessage(ResultMessage.Success,"1");
			 logger.error(ExceptionUtil.getExceptionMessage(ex));
		}
		return resultMessage;
	}

    /**
     * 添加或更新电子档案表。
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("save")
    @Action(description = "添加或更新电子档案表")
    public void save(HttpServletRequest request, HttpServletResponse response, EArchivesForm eArchivesForm) throws Exception {
        String resultMsg = null;
        ResultMessage message = null;

        try {
            Long id = RequestUtil.getLong(request, "id");
            EArchives eArchives = eArchivesService.getById(id);
            eArchives = eArchivesForm.getModel(eArchives);
            if (eArchivesForm.isMvcAdd()) {
                resultMsg = "添加电子档案表";
                eArchives.setId(uniqueIdUtil.genId(EArchives.class.getName()));
                eArchivesService.add(eArchives);

            } else {
                resultMsg = "更新电子档案表";
                eArchivesService.update(eArchives);

            }
            message = new ResultMessage(ResultMessage.Success, resultMsg + "成功");

            writeResultMessage(response.getWriter(), message);
        } catch (Exception ex) {
            message = new ResultMessage(ResultMessage.Fail, resultMsg + "失败");
            logger.error(ExceptionUtil.getExceptionMessage(ex));
            writeResultMessage(response.getWriter(), message);
        }
    }


    /**
     * 取得电子档案表分页列表
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesList.jsp");
        Long type= RequestUtil.getLong(request, "type", 0L);
        return modelAndView.addObject("type",type);
    }

    /**
     * 取得电子档案表分页列表
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("listJson")
    @Action(description = "查看从业人员信息表分页列表")
    @ResponseBody
    public Map<Object, Object> listJson(HttpServletRequest request, HttpServletResponse response) throws Exception {
        QueryFilter fiter = new QueryFilter(request);
        List<EArchives> list = eArchivesService.getAll(fiter);
        return getTableData(fiter.getPageBean().getTotalCount(), list);
    }

    /**
     * 删除电子档案表
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("del")
    @Action(description = "删除电子档案表")
    @ResponseBody
    public ResultMessage del(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ResultMessage message = null;
        try {
            Long[] lAryId = RequestUtil.getLongAryByStr(request, "id");
            eArchivesService.delByIds(lAryId);
            message = new ResultMessage(ResultMessage.Success, "删除电子档案表成功!");
        } catch (Exception ex) {
            message = new ResultMessage(ResultMessage.Fail, "删除失败" + ex.getMessage());
            logger.error(ExceptionUtil.getExceptionMessage(ex));
        }
        return message;
    }

    @RequestMapping("useEArch")
    @ResponseBody
    public ResultMessage useEArch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ResultMessage message = null;
        try {
            Long[] lAryId = RequestUtil.getLongAryByStr(request, "id");
            eArchivesService.useEArch(lAryId);
            message = new ResultMessage(ResultMessage.Success, "采用成功");
        } catch (Exception ex) {
            message = new ResultMessage(ResultMessage.Fail, "采用失败" + ex.getMessage());
            logger.error(ExceptionUtil.getExceptionMessage(ex));
        }
        return message;
    }


    @RequestMapping("sortImage")
    @ResponseBody
    public ResultMessage sortImage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ResultMessage message = null;
        try {
            Long targetId=RequestUtil.getLong(request,"targetId");
            Long sourceId=RequestUtil.getLong(request,"sourceId");
            Long personId=RequestUtil.getLong(request,"personId");
            eArchivesService.sortEArchives(targetId, sourceId, personId);
            message = new ResultMessage(ResultMessage.Success, "排序成功");
        } catch (Exception ex) {
            message = new ResultMessage(ResultMessage.Fail, "排序失败" + ex.getMessage());
            logger.error(ExceptionUtil.getExceptionMessage(ex));
        }
        return message;
    }
    /**
     * 新增电子档案表
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("add")
    @Action(description = "新增电子档案表")
    public ModelAndView add(HttpServletRequest request) throws Exception {
        Long personId = RequestUtil.getLong(request, "personId", 0L);
        List<ErecordCatalog> erecordCatalogList = erecordCatalogService.getAll();
//        QueryFilter fiter=new QueryFilter(request);
//        fiter.addFilter("imageStatus",1L);
//        List<EArchives> eArchivesList = eArchivesService.getAll(fiter);;
        PersonExpand personExpand=personExpandService.getByExpPersonId(personId);
        PersonBaseInfo personBaseInfo=bsPersonService.getById(personId);
        EArchivesForm eArchivesForm = new EArchivesForm();
        eArchivesForm.putModel(null);
        eArchivesForm.setPersonId(personId);
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesEdit.jsp");
//        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/index.jsp");
        return modelAndView.addObject("eArchivesForm", eArchivesForm).addObject("erecordCatalogList", erecordCatalogList)
                .addObject("personExpand",personExpand).addObject("personBaseInfo", personBaseInfo);
    }
    @RequestMapping("search")
    public ModelAndView search(HttpServletRequest request) throws Exception {
        Long personId = RequestUtil.getLong(request, "personId", 0L);
        List<ErecordCatalog> erecordCatalogList = erecordCatalogService.getAll();

        EArchivesForm eArchivesForm = new EArchivesForm();
        eArchivesForm.putModel(null);
        eArchivesForm.setPersonId(personId);
        
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesSearch.jsp");
        return modelAndView.addObject("eArchivesForm", eArchivesForm).addObject("erecordCatalogList", erecordCatalogList);
    }
    @RequestMapping("alreadyColl")
    public ModelAndView alreadyColl(HttpServletRequest request) throws Exception {
        Long personId = RequestUtil.getLong(request, "personId", 0L);
        Long catalogId = RequestUtil.getLong(request, "catalogId", null);
        String returnUrl=RequestUtil.getPrePage(request);
        QueryFilter fiter=new QueryFilter(request);
        fiter.addFilter("imageStatus",1L);
        List<EArchives> eArchivesList = eArchivesService.getAll(fiter);
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesAlreadyColl.jsp");
        return modelAndView.addObject("eArchivesList", eArchivesList).
                addObject("totalCount", fiter.getPageBean().getTotalCount()).
                addObject("totalPage", fiter.getPageBean().getTotalPage()).
                addObject("isHasPreviousPage", fiter.getPageBean().isHasPreviousPage()).
                addObject("isHasNextPage", fiter.getPageBean().isHasNextPage()).
                addObject("currentPage", fiter.getPageBean().getCurrentPage()).addObject("returnUrl",returnUrl);

    }
    @RequestMapping("imageView")
    public ModelAndView imageView(HttpServletRequest request) throws Exception {
        Long personId = RequestUtil.getLong(request, "personId", 0L);
        Long catalogId = RequestUtil.getLong(request, "catalogId", null);
        List<EArchives> eArchivesList = eArchivesService.getEArchivesList(personId, catalogId,1L);
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesImageView.jsp");

        return modelAndView.addObject("eArchivesList", eArchivesList);
    }
    @RequestMapping("processColl")
    public ModelAndView processColl(HttpServletRequest request) throws Exception {
        Long personId = RequestUtil.getLong(request, "personId", 0L);
        Long catalogId = RequestUtil.getLong(request, "catalogId", null);
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesProcessColl.jsp");
        if(catalogId==null){
            return modelAndView.addObject("eArchivesList", new ArrayList());
        }

        List<EArchives> eArchivesList = eArchivesService.getEArchivesList(personId, catalogId,0L);
       

        return modelAndView.addObject("eArchivesList", eArchivesList);
    }
    /**
     * 编辑电子档案表
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("edit")
    @Action(description = "编辑电子档案表")
    public ModelAndView edit(HttpServletRequest request) throws Exception {
        Long id = RequestUtil.getLong(request, "id", 0L);
        EArchives eArchives = eArchivesService.getById(id);
        EArchivesForm eArchivesForm = new EArchivesForm();
        eArchivesForm.putModel(eArchives);
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesEdit.jsp");

        return modelAndView.addObject("eArchivesForm", eArchivesForm);
    }

    /**
     * 取得电子档案表明细
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("get")
    @Action(description = "查看电子档案表明细")
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Long id = RequestUtil.getLong(request, "id");
        EArchives eArchives = eArchivesService.getById(id);
        return getAutoView().addObject("eArchives", eArchives);
    }


	 @RequestMapping("fileUpload")
	    public void fileUpload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
	        

	        PrintWriter writer = response.getWriter();
	        try {
	            Long personId = RequestUtil.getLong(request, "personId", 0L);
	            Long catalogId = RequestUtil.getLong(request, "catalogId", 0L);
	            PersonBaseInfo bsPerson = bsPersonService.getById(personId);
	            long userId = ContextUtil.getCurrentUserId(); // 获取当前用户的id
	            String fileFormates = RequestUtil.getString(request, "fileFormates");         //格式要求

	            boolean mark = true;

	            Map<String, MultipartFile> files = request.getFileMap();
	            Iterator<MultipartFile> it = files.values().iterator();

	            while (it.hasNext()) {
	                Long fileId =uniqueIdUtil.genId("");
	                MultipartFile f = it.next();
	                String oriFileName = f.getOriginalFilename();
	                String extName = FileUtil.getFileExt(oriFileName);

	                if (StringUtil.isNotEmpty(fileFormates)) {            //文件格式要求
	                    if (!(fileFormates.contains("*." + extName))) {       //不符合文件格式要求的就标志为false
	                        mark = false;
	                    }
	                }

	                if (mark) {
	                    String fileName = fileId + "." + extName;
	                    String filePath=FileWebDavUtil.uploadFile(10L, fileName, f.getInputStream());
//	                    ImageUtil.doCompressByByte(f.getBytes(), compressPath,150, 150,1.0f,  true);
	                    EArchives earchives = new EArchives();
	                    earchives.setPersonId(personId);
	                    earchives.setId(uniqueIdUtil.genId(EArchives.class.getName()));
	                    earchives.setCatalogId(catalogId);
	                    earchives.setCreatDate(new Date());
	                    earchives.setCreaterId(userId);
	                    earchives.setImagePath(filePath);
	                    earchives.setImageCompressPath(filePath);
	                    earchives.setImageStatus(0L);
	                    earchives.setImageSize(f.getSize());
	                    eArchivesService.add(earchives);

	                } else {
	                    logger.error("文件格式不符合要求！");
	                    writer.println("");
	                }

	            }

	        } catch (Exception e) {
	            logger.error("上传出错", e);
	            writer.println("");
	        }
	    }
//	@RequestMapping("fileUpload")
//	@ResponseBody
//	public Object fileUpload(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		 String uploadPath = "D:\\temp"; // 上传文件的目录
//		 String tempPath = "d:\\temp\\buffer\\"; // 临时文件目录
//		File tempPathFile;
//		Map<String, Object> map = new HashMap<String, Object>();
//		String returnId="";
//		String returnFilePath="";
//		map.put("status", "success");
//		map.put("msg", "成功");
//		map.put("timestamp", new Date().getTime());
//		try {
//			// Create a factory for disk-based file items
//			DiskFileItemFactory factory = new DiskFileItemFactory();
//
//			// Set factory constraints
//			factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
//			//factory.setRepository(tempPathFile);// 设置缓冲区目录
//
//			// Create a new file upload handler
//			ServletFileUpload upload = new ServletFileUpload(factory);
//
//			// Set overall request size constraint
//			//upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB
//
//			List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
//			Iterator<FileItem> i = items.iterator();
//			while (i.hasNext()) {
//				FileItem fi = (FileItem) i.next();
//				String fileName = fi.getName();
//				if (fileName != null) {
//					File fullFile = new File(fi.getName());
//					File savedFile = new File(uploadPath, fullFile.getName());
//					fi.write(savedFile);
//				}
//			}
//			System.out.print("upload succeed");
//			String oriFileName =request.getParameter("fileName");;
//			String encodeStr=request.getParameter("fileStr");
//			byte[] fileByte= ImgHelper.decode(encodeStr);
//			long userId = ContextUtil.getCurrentUserId(); // 获取当前用户的id
//			long typeId = RequestUtil.getLong(request, "typeId");
//			String uploadType = RequestUtil.getString(request, "uploadType");               //控件的类型
//			String fileFormates = RequestUtil.getString(request, "fileFormates");         //格式要求
//			boolean mark = true;
//			SysUser appUser = null;
//			// 附件保存路径
//			//String attachPath = configproperties.getProperty("file.upload");
//			String attachPath=ServiceUtil.getBasePath();
//
//
//
//			Long fileId = UniqueIdUtil.genId();
//
//			String extName = FileUtil.getFileExt(oriFileName);
//
//			if(StringUtil.isNotEmpty(fileFormates)){            //文件格式要求
//				if( !( fileFormates.contains("*."+extName) ) ){       //不符合文件格式要求的就标志为false
//					mark = false;
//				}
//			}
//
//			if(mark){
//				String fileName = fileId + "." + extName;
//				// 开始写入物理文件
//				String filePath = "";
//
//				if("pictureShow".equals(uploadType)){            //pictureShow控件要的文件路径要有一点不同
//					filePath = createFilePath(attachPath  + File.separator + userId+ File.separator +"pictureShow", fileName);
//				}else{
//					filePath = createFilePath(attachPath + File.separator + userId, fileName);
//				}
//
//					FileUtil.writeByte(filePath,fileByte);
//			}else{
//				logger.error("文件格式不符合要求！");
//
//			}
//
//
//
//			map.put("id", returnId);
//			map.put("filePath", returnFilePath.replace(attachPath + File.separator,""));
//			return  map;
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			map.put("status","false");
//			map.put("msg","");
//			return map;
//
//		}
//	}

    /**
     * 根据文件id取得附件数据。
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("getImageById")
    @Action(description = "根据文件id取得附件数据", exectype = "管理日志", detail = "根据文件id取得附件数据")
    public void getFileById(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String filePath = RequestUtil.getString(request, "filePath");

        String type = RequestUtil.getString(request, "type");

        if (StringUtils.isBlank(filePath)) {

            long id = RequestUtil.getLong(request, "id", 0);
            EArchives eArchives = eArchivesService.getById(id);
            if("compress".equalsIgnoreCase(type)){
                filePath = eArchives.getImageCompressPath();
            }else{
                filePath = eArchives.getImagePath();
            }
            if(StringUtils.isBlank(filePath)){
                filePath = eArchives.getImagePath();
            }
        }
        // 附件保存路径
        String fullPath = StringUtil.trimSufffix(attachPath, File.separator) + File.separator + filePath.replace("/", File.separator);

        byte[] bytes = FileUtil.readByte(fullPath);
        response.getOutputStream().write(bytes);

    }
    /**
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("imageShow")
    @Action(description = "图片展示")
    public ModelAndView pictureShow(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/business/personagency/erecord/eArchivesImageShow.jsp");
        String id = RequestUtil.getString(request, "id");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    /**
     * 新增电子档案表
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("applet")
    @Action(description = "新增电子档案表")
    public ModelAndView applet(HttpServletRequest request) throws Exception {
        Long personId = RequestUtil.getLong(request, "personId", 0L);

        ModelAndView modelAndView = new ModelAndView("/applet/eArchivesApplet.jsp");
        return modelAndView.addObject("personId", personId);
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
