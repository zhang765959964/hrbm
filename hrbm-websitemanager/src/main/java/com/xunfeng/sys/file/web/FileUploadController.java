package com.xunfeng.sys.file.web;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.xunfeng.business.cms.util.ServiceUtil;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.FileUtil;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;

@Controller
@RequestMapping("/sys/upload")
public abstract class FileUploadController extends BaseController {
	@Resource
	@Qualifier("uniqueId")
	private UniqueIdUtilInterf uniqueIdUtil;

	@RequestMapping("upload")
	@ResponseBody
	public void fileUpload(MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {


		PrintWriter writer = response.getWriter();
		try {
			
			String uploadType = RequestUtil.getString(request, "uploadType"); // 控件的类型
			String fileFormates = RequestUtil.getString(request, "fileFormates"); // 格式要求
			String flag = RequestUtil.getString(request, "flag"); // 格式要求

			boolean mark = true;

			String attachPath = ServiceUtil.getBasePath();
			Map<String, MultipartFile> files = request.getFileMap();
			Iterator<MultipartFile> it = files.values().iterator();

			while (it.hasNext()) {
				Long fileId = uniqueIdUtil.genId("");
				MultipartFile f = it.next();
				String oriFileName = f.getOriginalFilename();
				String extName = FileUtil.getFileExt(oriFileName);
				if (StringUtil.isNotEmpty(fileFormates)) { // 文件格式要求
					if (!(fileFormates.contains("*." + extName))) { // 不符合文件格式要求的就标志为false
						mark = false;
					}
				}
				if (mark) {
					String fileName = fileId + "." + extName;
					// 开始写入物理文件
				
					String filePath=uploadFile( fileName, f.getInputStream());
					
					writer.println(filePath);
				} else {
					logger.error("文件格式不符合要求！");
					writer.println("");
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			writer.println("");
		}
	}
	protected abstract String uploadFile(String fileName, InputStream fis);

	protected String createFilePath(String tempPath, String fileName) {
		tempPath=tempPath+File.separator+getPrefixFilePath();
		
		Calendar cal = Calendar.getInstance();
		Integer year = cal.get(Calendar.YEAR); // 当前年份
		Integer month = cal.get(Calendar.MONTH) + 1; // 当前月份
		File one = new File(tempPath + File.separator + year + File.separator
				+ month);
		if (!one.exists()) {
			one.mkdirs();
		}
		return one.getPath() + File.separator + fileName;
	}
	
	protected String getPrefixFilePath() {
		long userId = ContextUtil.getCurrentUserId(); // 获取当前用户的id
		return ""+userId;
	}

	protected String getName(String fileName) {
		String[] fileNameArray=fileName.split("\\\\");
		fileName=fileNameArray[fileNameArray.length-1];
//		int pos = fileName.lastIndexOf(".");
//		if (pos > -1) {
//			return fileName.substring(0,pos );
//		}
		return fileName;
	}

	/**
	 * 下载
	 *
	 * @return
	 */
	@RequestMapping("download")
	public void downloadFile(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String filePath = RequestUtil.getString(request, "filePath");

			String attachPath = ServiceUtil.getBasePath();

			// 附件保存路径
			String fullPath = StringUtil
					.trimSufffix(attachPath, File.separator)
					+ File.separator
					+ filePath.replace("/", File.separator);

			byte[] fileBytes = FileUtil.readByte(fullPath);

			// 为了解决中文名称乱码问题
			String fileName = URLEncoder.encode(getName(filePath), "UTF-8");
			String userAgent = request.getHeader("User-Agent");
			if (userAgent != null) {
				userAgent = userAgent.toLowerCase();
				// IE浏览器，只能采用URLEncoder编码
				if (userAgent.indexOf("msie") != -1) {
					fileName = "filename=\"" + fileName + "\"";
				}
				// Opera浏览器只能采用filename*
				else if (userAgent.indexOf("opera") != -1) {
					fileName = "filename*=UTF-8''" + fileName;
				}
				// Safari浏览器，只能采用ISO编码的中文输出
				else if (userAgent.indexOf("safari") != -1) {
					fileName = "filename=\""
							+ new String(fileName.getBytes("UTF-8"),
									"ISO8859-1") + "\"";
				}
				// Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出
				else if (userAgent.indexOf("applewebkit") != -1) {
					fileName = MimeUtility.encodeText(getName(filePath),
							"UTF8", "B");
					fileName = "filename=\"" + fileName + "\"";
				}
				// FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出
				else if (userAgent.indexOf("mozilla") != -1) {
					fileName = "filename*=UTF-8''" + fileName;
				}
			}
			response.setContentType(FileUtil.getFileExt(filePath));
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment; " + fileName
					+ "");
			IOUtils.copy(new ByteArrayInputStream(fileBytes),
					response.getOutputStream());
			response.setContentType(MediaType.TEXT_HTML_VALUE);
			response.setCharacterEncoding("UTF-8");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			try {
				response.setContentType(MediaType.TEXT_HTML_VALUE);
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("下载出错");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
