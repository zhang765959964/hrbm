package com.xunfeng.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.googlecode.sardine.Sardine;
import com.googlecode.sardine.SardineFactory;
import com.xunfeng.sys.attachment.interf.AttachmentParamsServiceInterf;
import com.xunfeng.sys.attachment.model.AttachmentParams;

public class FileWebDavUtil {

	private  static String webDavDirectory ="";

	static{
		Properties configproperties=(Properties)AppUtil.getBean("configproperties");
		 webDavDirectory = configproperties.getProperty("webdav.directory");
	}

	/**上传文件
	 * @param fileRootDirecoty，文件根目录，例如/company/
	 * @param format，目录规则，例如pic/{y}-{m}
	 * @param fileName，文件名称，例如20168541254.jpg
	 * @param fis，文件流
	 * @return
	 */
	public static String uploadFile(String fileRootDirecoty, String format, String fileName, InputStream fis) {
		Sardine sardine = SardineFactory.begin();
		try {
			format = parseFormat(format);
			String fileDirecoty = webDavDirectory + fileRootDirecoty + format + "/";
			if (sardine.exists(fileDirecoty)) {
				sardine.put(webDavDirectory + fileRootDirecoty + format +"/"+ fileName, fis);
			} else {
				createDirectory(sardine,fileDirecoty);
				sardine.put(webDavDirectory + fileRootDirecoty + format +"/"+ fileName, fis);
			}

			return fileRootDirecoty.replaceFirst("/", "") + format +"/"+ fileName;

		} catch (IOException e) {

			throw new RuntimeException(e);
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**上传文件
	 * @param type，文件上传路径规则ID,见表Pic_upload
	 * @param fileName，文件名称，例如20168541254.jpg
	 * @param fis，文件流
	 * @return
	 */
	public static String uploadFile(Long type, String fileName, InputStream fis) {
		
		AttachmentParamsServiceInterf attachmentParamsService=(AttachmentParamsServiceInterf)AppUtil.getBean("attachmentParams");
		AttachmentParams attachmentParams=attachmentParamsService.getById(type);
		String fileRootDirecoty=attachmentParams.getP002(),  format=attachmentParams.getP003();
		Sardine sardine = SardineFactory.begin();
		try {
			format = parseFormat(format);
			String fileDirecoty = webDavDirectory + fileRootDirecoty + format + "/";
			if (sardine.exists(fileDirecoty)) {
				sardine.put(webDavDirectory + fileRootDirecoty + format +"/"+ fileName, fis);
			} else {
				createDirectory(sardine,fileDirecoty);
				sardine.put(webDavDirectory + fileRootDirecoty + format +"/"+ fileName, fis);
			}

			return fileRootDirecoty.replaceFirst("/", "") + format +"/"+ fileName;

		} catch (IOException e) {

			throw new RuntimeException(e);
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void createDirectory(Sardine sardine,String fileDirecoty) throws IOException{
		List<String> url_array=new ArrayList();
		String[] direcoty_array=fileDirecoty.replace(webDavDirectory, "").split("/");
		StringBuffer url_sb=new StringBuffer();
		
		for(String url:direcoty_array){
			url_sb.append(url).append("/");
			url_array.add(url_sb.toString());
		}
		
		for(String parentUrl:url_array){
			if (!sardine.exists(webDavDirectory+parentUrl)) {
				sardine.createDirectory(webDavDirectory+parentUrl);
			}
		}
		
	}
	
	private static String parseFormat(String format) {

		String y = new SimpleDateFormat("yyyy").format(new Date());
		String m = new SimpleDateFormat("MM").format(new Date());
		format = format.replaceAll("\\{y\\}", y).replaceAll("\\{m\\}", m);
		return format;
	}

//	public static void main(String[] args) throws IOException {
//
//		Sardine sardine = SardineFactory.begin();
//
//		if (sardine.exists("http://127.0.0.1:333/webdav/dam/")) {
//			System.out.println("/content/dam folder exists");
//		}
//
//        
//		InputStream fis = new FileInputStream(new File("D://20150629113725.jpg"));
//		uploadFile("/henan/xinyang/","gs/{y}-{m}" , "20150629113725.jpg", fis); 
//		List<DavResource> resources = sardine.getResources("http://127.0.0.1:333/webdav/dam/testfolder/");
//		for (DavResource res : resources) {
//			System.out.println(res); // calls the .toString() method.
//		}
//	}

}
