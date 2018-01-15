package com.xunfeng.sys.component.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xunfeng.core.annotion.Action;
import com.xunfeng.core.excel.Excel;
import com.xunfeng.core.excel.util.ExcelUtil;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.DateFormatUtil;
import com.xunfeng.core.web.ResultMessage;
import com.xunfeng.core.web.controller.BaseController;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.component.service.DataExpService;
import com.xunfeng.sys.component.service.DataImpService;

/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: TODO(用一句话描述该文件做什么) 
* @author wanghan 
* @createDate 2015年4月27日-上午10:57:33 
* @version V1.0   
*/
@Controller
@RequestMapping("/sys/component/data")
public class DataImpExpController extends BaseController
{

	@RequestMapping("export")
	@Action(description = "导出业务数据",detail="导出业务数据")
	public void exportData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		QueryFilter filter =new QueryFilter(request);
		Map dataMap=filter.getFilters();// RequestUtil.getParameterValueMap(request, true, true);
		String serviceId=(String)dataMap.get("serviceId");
		String fileName=(String)dataMap.get("fileName");
		DataExpService expService=(DataExpService)AppUtil.getBean(serviceId);
		HSSFWorkbook wb =expService.exportData(dataMap);
		fileName = fileName+  DateFormatUtil.getNowByString("yyyyMMddHHmmdd");
		ExcelUtil.downloadExcel(wb, fileName, response);
	}
	@RequestMapping("tempDown")
	@Action(description = "下载模版数据",detail="下载模版数据")
	public void tempDown(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*Map dataMap=RequestUtil.getParameterValueMap(request, true, true);
		String tempFileName=(String)dataMap.get("tempFileName");
		Excel excel=new Excel("/template/excel/"+tempFileName);
		String fileName=tempFileName.substring(0,tempFileName.indexOf("."));
		HSSFWorkbook wb =excel.getWorkBook();
		ExcelUtil.downloadExcel(wb, fileName, response);*/
		Map dataMap=RequestUtil.getParameterValueMap(request, true, true);
		String tempFileName=(String)dataMap.get("tempFileName");
		String fileName = tempFileName;  
		response.setContentType("application/x-msdownload");   
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));  
        OutputStream out = response.getOutputStream();  
        String excelPath = "/template/excel/"+tempFileName;  
        InputStream in = request.getClass().getResourceAsStream(excelPath);
        byte [] buffer = new byte[1024];  
        int len = 0;  
        while((len = in.read(buffer)) != -1){  
            out.write(buffer, 0, len);  
        }  
        in.close();  
	

	}
	/**
	 * 导入业务数据模板数据
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("import")
	@Action(description = "导入业务数据模板数据",detail="导入业务数据模板数据")
	public ModelAndView importData(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String serviceId = RequestUtil.getString(request, "serviceId");
		String targetId = RequestUtil.getString(request, "targetId");
		ModelAndView modelAndView=this.getAutoView();
		modelAndView=new ModelAndView("/sys/component/import/dataImport.jsp");
		return modelAndView.addObject("serviceId", serviceId).addObject("targetId", targetId);
		
	}
	
	/**
	 * 导入数据保存
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("importSave")
	@Action(description = "导入数据保存",detail="导入业务数据模板数据")
	public void importSave(MultipartHttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String preUrl= RequestUtil.getPrePage(request);
		MultipartFile file = request.getFile("file");
		ResultMessage message = null;
		try {
			QueryFilter filter =new QueryFilter(request);
			Map dataMap=filter.getFilters();// RequestUtil.getParameterValueMap(request, true, true);
			String serviceId=(String)dataMap.get("serviceId");
			DataImpService expService=(DataImpService)AppUtil.getBean(serviceId);
			expService.importData(file.getInputStream(),dataMap);
			message = new ResultMessage(ResultMessage.Success,"导入成功!");
		} catch (Exception e) {
			e.printStackTrace();
			message = new ResultMessage(ResultMessage.Fail,"导入出错了，请检查导入格式是否正确或者导入的数据是否有问题！");
		}
		//writeResultMessage(response.getWriter(), message);
		addMessage(message, request);
		response.sendRedirect(preUrl);
	}
	
}
