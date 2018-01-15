//package com.xunfeng.sys.file.service;
//
//import java.io.InputStream;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.xunfeng.core.db.IEntityDao;
//import com.xunfeng.core.service.BaseService;
//import com.xunfeng.core.util.ContextUtil;
//import com.xunfeng.core.util.FileUtil;
//import com.xunfeng.core.util.StringUtil;
//import com.xunfeng.sys.file.dao.FileManageDao;
//import com.xunfeng.sys.file.model.FileManage;
//import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
//import com.xunfeng.sys.identity.service.UniqueIdUtilService;
//import com.xunfeng.sys.uums.model.SysUser;
//import com.xunfeng.sys.uums.service.SysUserService;
//
///**  
//* @company: 河南讯丰信息技术有限公司 
//* @Description: 文件管理 service类 
//* @author wanghan  
//* @version V1.0   
//*/
//@Service
//public class FileManageService extends BaseService<FileManage> {
//	@Resource
//	private FileUploadService fileUploadService;
//	@Resource
//	private SysUserService sysUserService;
//	
//	@Resource
//	UniqueIdUtilService  UniqueIdUtil;
//
//	@Resource
//	FileManageDao dao;
//
//	@Override
//	protected IEntityDao<FileManage, Long> getEntityDao() {
//		return dao;
//	}
//	
//	/**
//	 * 文件存盘
//	 * 
//	 * @param inputStream
//	 */
//	public String saveFileToDisk(MultipartFile mf) throws Exception {
//		return fileUploadService.saveFileToDisk(mf);
//	}
////
////	/**
////	 * 保存文件信息
////	 * 
////	 * @param m
////	 * @param categoryId
////	 */
////	public void saveToDB(MultipartFile m, FileManage fileManage,
////			String fileRelativePath) {
////		long userId = ContextUtil.getCurrentUserId(); // 获取当前用户的id
////		SysUser appUser = null;
////		if (userId > 0) {
////			appUser = sysUserService.getById(userId);
////		}
////		String oriFileName = m.getOriginalFilename();
////		String extName = FileUtil.getFileExt(oriFileName);
////		Long totalBytes = m.getSize();
////		String fileSize = FileUtil.getSize(totalBytes);
////		fileManage.setFileId(UniqueIdUtil.genId(FileManage.class.getName()));
////		fileManage.setFilePath(fileRelativePath);
////		fileManage.setFileName(oriFileName.substring(0,
////				oriFileName.lastIndexOf('.')));
////		fileManage.setExt(extName);
////		fileManage.setTotalBytes(totalBytes);
////		fileManage.setFileSize(fileSize);
////		fileManage.setCreateTime(new Date());
////		fileManage.setCreatorId(appUser.getAcd230());
////		//fileManage.setCreator(appUser.getUsername());
////		dao.add(fileManage);
////		
////		// 保存选人权限
////		this.saveUserPermis(fileManage.getFileId(),fileManage.getUserPermis());
////		// 保存角色权限
////		this.saveRolePermis(fileManage.getFileId(),fileManage.getRolePermis());
////		// 保存岗位权限
////		this.savePostPermis(fileManage.getFileId(),fileManage.getPostPermis());
////		
////		
////	}
//	
////	/**
////	 * 保存岗位权限
////	 * @param fileId
////	 * @param postPermis
////	 */
////	private void savePostPermis(Long fileId, String postPermis) {
////		dao.delPostById(fileId);
////		if (StringUtil.isNotEmpty(postPermis)) {
////			for(String postId:postPermis.split(",")){
////				dao.savePostPermis(UniqueIdUtil.genId(),fileId,postId);
////			}
////		}
////	}
////
////	/**
////	 * 保存角色权限
////	 * @param fileId
////	 * @param rolePermis
////	 */
////	private void saveRolePermis(Long fileId, String rolePermis) {
////		dao.delRoleById(fileId);
////		if (StringUtil.isNotEmpty(rolePermis)) {
////			for(String roleId:rolePermis.split(",")){
////				dao.saveRolePermis(UniqueIdUtil.genId(),fileId,roleId);
////			}
////		}
////	}
////	
////	/**
////	 * 保存选人权限
////	 * @param fileId
////	 * @param userPermis
////	 */
////	private void saveUserPermis(Long fileId, String userPermis) {
////		dao.delUserById(fileId);
////		if (StringUtil.isNotEmpty(userPermis)) {
////			for(String userId:userPermis.split(",")){
////				dao.saveUserPermis(UniqueIdUtil.genId(),fileId,userId);
////			}
////		}
////	}
//
//	/**
//	 * 根据json字符串获取SysQuerySetting对象
//	 * 
//	 * @param json
//	 * @return
//	 */
////	public FileManage getFileManageByJson(String json) {
////		JSONUtils.getMorpherRegistry().registerMorpher(
////				new DateMorpher((new String[] { "yyyy-MM-dd" })));
////		if (StringUtil.isEmpty(json))
////			return new FileManage();
////		JSONObject obj = JSONObject.fromObject(json);
////		FileManage fileManage = (FileManage) JSONObject.toBean(obj,
////				FileManage.class);
////		return fileManage;
////	}
//
//	/**
//	 * 删除文件
//	 * 
//	 * @param lAryId
//	 */
//	public void delFileByIds(Long[] lAryId) {
//		List<FileManage> list = dao.getAllByIds(lAryId);
//		for (FileManage fileManage : list) {
//			fileUploadService.deleteFile(fileManage.getFilePath());
//		}
//	}
//
//	/**
//	 * 获取文件
//	 * 
//	 * @param fileSavePath
//	 * @return
//	 */
//	public InputStream getFile(String fileSavePath) {
//		return fileUploadService.getFile(fileSavePath);
//	}
//
////	/**
////	 * 保存方法，只更新，
////	 * @param fileManage
////	 */
////	public void update(FileManage fileManage) {
////		dao.update(fileManage);
////		// 保存选人权限
////		this.saveUserPermis(fileManage.getFileId(),fileManage.getUserPermis());
////		// 保存角色权限
////		this.saveRolePermis(fileManage.getFileId(),fileManage.getRolePermis());
////		// 保存岗位权限
////		this.savePostPermis(fileManage.getFileId(),fileManage.getPostPermis());
////	}
//
//}
