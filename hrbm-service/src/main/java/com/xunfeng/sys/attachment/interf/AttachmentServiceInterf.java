package com.xunfeng.sys.attachment.interf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.sys.attachment.dto.CorpAttachmentDto;
import com.xunfeng.sys.attachment.model.Attachment;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 网上认证提交信息表 Service类
 * @author:wxl
 * @createDate 2015-08-02 17:37:04
 * @version V1.0
 */

public interface AttachmentServiceInterf extends GenericServiceInterface<Attachment, Long> {


	/**
	 * caoa03 说明文字 caoa04 //类型 6图片 7视频
	 * 
	 * @param file
	 */
	//public void uploadCorpAttachment(MultipartFile file, Long caoa04,String caoa03) throws Exception;

	// 企业 保存图片到数据库中
	//public void saveCorpAttachment(String fileName, Long caoa04, String caoa03,Long aab001) throws Exception;

	/**
	 * 删除附件
	 */
	public void delAttachment(Long id);
	
	/**
	 * 获得个人的上传的个人风采
	 */
	public List<Attachment> getPersonImageStyleList(long ccmu01);
	/**
	 * 获得企业的上传的企业风采
	 */
	public List<Attachment> getCorpImageStyleList(long ccmu01);
	/**
	 * 获得企业的上传的企业视频
	 */
	public List<Attachment> getCorpVideoStyleList(long ccmu01);
	/**
	 * 获得企业的上传的企业视频
	 */
	public List<Attachment> getPersonVideoStyleList(long ccmu01);
	
	/**保存企业图片风采
	 * @param filePath
	 * @param imgDesc
	 * @param ccmu01
	 */
	public Long saveCorpImageStyle(String filePath, String imgDesc,Long ccmu01,Long aab001);
	
	/**保存用户图片风采
	 * @param filePath
	 * @param imgDesc
	 * @param ccmu01
	 */
	public Long savePersonImageStyle(String filePath, String imgDesc,Long ccmu01);
	
	/**保存企业视频风采
	 * @param filePath
	 * @param imgDesc
	 * @param ccmu01
	 */
	public void saveCorpVideoStyle(String filePath, String imgDesc,Long ccmu01,Long aab001);
	/**保存用户视频风采
	 * @param filePath
	 * @param imgDesc
	 * @param ccmu01
	 */
	public void savePersonVideoStyle(String filePath, String imgDesc,Long ccmu01);
	/**
	 *  根据标示获得公司上传的图片 按时间排序
	 *  2016-04-18
	 */
	public List<Map<String,Object>> getCorpImg(Long ccmu01);
	/**
	 *  根据标示获得公司上传的最新视频
	 *  2016-04-18
	 */
	public Map<String,Object> getLatestCorpVideo(Long ccmu01);
	/**
	 *  根据标示获得个人上传的图片 按时间排序
	 *  2016-04-23
	 */
	public List<Map<String,Object>> getPersonImg(Long ccmu01);
	/**
	 *  根据标示获得个人上传的最新视频
	 *  2016-04-18
	 */
	public Map<String,Object> getLatestPersonVideo(Long ccmu01);
	/**
	 *  获得审核的营业执照
	 *  2016-05-07
	 */
	public Attachment getBusLicense(Long ccmu01);
	/**
	 *  获得审核的营业执照
	 *  2016-05-07
	 */
    public Attachment getPersonIDCard(Long ccmu01);
	/**
	 * 获得审核中和审核成功的附件总数
	 * AccountId,证件类型 和 审核状态 统计总数
	 */
	public Long getTotalCountAttachInCheck(Long ccmu01,Long credType);
	/**
	 * 个人注册--保存身份证扫描件
	 * @param filePath
	 * @param ccmu01
	 */
	public void saveIdScan(String filePath, Long ccmu01);
	
}


