package com.xunfeng.sys.attachment.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xunfeng.business.corp.service.CorpService;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.attachment.dao.AttachmentDao;
import com.xunfeng.sys.attachment.interf.AttachmentServiceInterf;
import com.xunfeng.sys.attachment.model.Attachment;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 网上认证提交信息表 Service类
* @author:wxl
* @createDate 2015-08-02 17:37:04 
* @version V1.0   
*/
@Service
public class AttachmentService extends BaseService<Attachment> implements AttachmentServiceInterf
{
	@Resource
	private AttachmentDao dao;
	@Resource
	private CorpService corpService;
	@Resource
	private BaseConfigService baseConfigService;
	@Value("#{configproperties['attachment.corp.pic.upload']}")
	private String corpPic;
	@Value("#{configproperties['attachment.corp.video.upload']}")
	private String corpVideo;
	@Resource
	UniqueIdUtilService  UniqueIdUtil;
	
	public AttachmentService()
	{
	}


	@Override
	protected IEntityDao<Attachment, Long> getEntityDao()
	{
		return dao;
	}
	/**
	 * 删除附件
	 */
	public void delAttachment(Long id){
		dao.updateDelStatus("1",id);
	}
	/**
	 * 获得个人的上传的个人风采
	 * 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public List<Attachment> getPersonImageStyleList(long ccmu01){		
		Map<String,Object> param =new HashMap<String,Object>();
		param.put("ccmu01", ccmu01);
		param.put("caoa04", 8);		
		return getAttachmentList(param);
	}
	/**
	 * 获得企业的上传的企业风采
	 * 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public List<Attachment> getCorpImageStyleList(long ccmu01){		
		Map<String,Object> param =new HashMap<String,Object>();
		param.put("ccmu01", ccmu01);
		param.put("caoa04", 6);		
		return getAttachmentList(param);
	}
	/**
	 * 获得企业的上传的企业视频（
	 * 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public List<Attachment> getCorpVideoStyleList(long ccmu01){
		Map<String,Object> param =new HashMap<String,Object>();
		param.put("caoa04", 7);
		param.put("ccmu01", ccmu01);
		return getAttachmentList(param);
	}
	/**
	 * 获得个人的上传的企业视频（审核通过）
	 * 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public List<Attachment> getPersonVideoStyleList(long ccmu01){
		Map<String,Object> param =new HashMap<String,Object>();
		param.put("caoa04", 9);
		param.put("ccmu01", ccmu01);
		return getAttachmentList(param);
	}
	private List<Attachment> getAttachmentList(Map<String,Object> param) {
		param.put("ccpr08", 0);
		return dao.getBySqlKey("getAll",param);
	}
	
	/**
	 * 保存企业图片
	 * 保存用户图片风采 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public Long saveCorpImageStyle(String filePath, String imgDesc,Long ccmu01,Long aab001) {
		Long pkId=UniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName());
		Attachment attachment = new Attachment();
		attachment.setCaoa01(pkId);
		attachment.setCcmu01(ccmu01);
		attachment.setCaoa04(6L);   
		attachment.setCaoa05(new Date());
		attachment.setCcpr08("0");
		attachment.setCczy06("1");
		BaseConfig baseConfig = baseConfigService.getConfigByName("audit_dw_tupian");
		if("1".equals(baseConfig.getCaos04())){//是否开启对单位上传的图片自动审核功能1-关闭2-开启
			attachment.setCaoa07(0L);
		}else{
			attachment.setCaoa07(1L);
		}
		attachment.setCaoa03(imgDesc);
		attachment.setCaoa02(filePath);
		attachment.setAab001(aab001);
		dao.add(attachment);
		return pkId;
		
	}
	/**
	 * 保存个人图片
	 * 保存用户图片风采 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public Long savePersonImageStyle(String filePath, String imgDesc,Long ccmu01) {
		Long pkId=UniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName());
		Attachment attachment = new Attachment();
		attachment.setCaoa01(pkId);
		attachment.setCcmu01(ccmu01);
		attachment.setCaoa04(8L);   
		attachment.setCaoa05(new Date());
		attachment.setCcpr08("0");
		attachment.setCczy06("1");
		BaseConfig baseConfig = baseConfigService.getConfigByName("audit_gr_tupian");
		if("1".equals(baseConfig.getCaos04())){//是否开启对个人上传的图片自动审核功能1-关闭2-开启
			attachment.setCaoa07(0L);
		}else{
			attachment.setCaoa07(1L);
		}
		attachment.setCaoa03(imgDesc);
		attachment.setCaoa02(filePath);
		dao.add(attachment);
		return pkId;
		
	}
	/**
	 * 保存企业视频
	 * 保存用户图片风采 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public void saveCorpVideoStyle(String filePath, String imgDesc,Long ccmu01,Long aab001) {
		Attachment attachment = new Attachment();
		attachment.setCaoa01(UniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName()));
		attachment.setCcmu01(ccmu01);
		attachment.setCaoa04(7L);  
		attachment.setCaoa05(new Date());
		attachment.setCcpr08("0");
		attachment.setCczy06("1");
		BaseConfig baseConfig = baseConfigService.getConfigByName("audit_dw_shipin");
		if("1".equals(baseConfig.getCaos04())){//是否开启对单位上传的视频自动审核功能1-关闭2-开启
			attachment.setCaoa07(0L);
		}else{
			attachment.setCaoa07(1L);
		}
		attachment.setCaoa03(imgDesc);
		attachment.setCaoa02(filePath);
		attachment.setAab001(aab001);
		dao.add(attachment);
	}
	/**
	 * 保存个人视频
	 * 保存用户图片风采 证件类型(1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频)
	 */
	public void savePersonVideoStyle(String filePath, String imgDesc,Long ccmu01) {
		Attachment attachment = new Attachment();
		attachment.setCaoa01(UniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName()));
		attachment.setCcmu01(ccmu01);
		attachment.setCaoa04(9L);   
		attachment.setCaoa05(new Date());
		attachment.setCcpr08("0");
		attachment.setCczy06("1");
		BaseConfig baseConfig = baseConfigService.getConfigByName("audit_gr_shipin");
		if("1".equals(baseConfig.getCaos04())){//是否开启对个人上传的视频自动审核功能1-关闭2-开启
			attachment.setCaoa07(0L);
		}else{
			attachment.setCaoa07(1L);
		}
		attachment.setCaoa03(imgDesc);
		attachment.setCaoa02(filePath);
		dao.add(attachment);
	}
	/**
	 *  根据标示获得公司上传的图片 按时间排序(审核通过的)
	 *  2016-04-18
	 */
	public List<Map<String,Object>> getCorpImg(Long ccmu01){
		return dao.getCorpImg(ccmu01);
	}
	/**
	 *  根据标示获得公司上传的最新视频(审核通过的)
	 *  2016-04-18
	 */
	public Map<String,Object> getLatestCorpVideo(Long ccmu01){
		return dao.getLatestCorpVideo(ccmu01);
	}
	/**
	 *  根据标示获得个人上传的图片 按时间排序(审核通过的)
	 *  2016-04-23
	 */
	public List<Map<String,Object>> getPersonImg(Long ccmu01){
		return dao.getPersonImg(ccmu01);
	}
	/**
	 *  根据标示获得个人上传的最新视频(审核通过的)
	 *  2016-04-23
	 */
	public Map<String,Object> getLatestPersonVideo(Long ccmu01){
		return dao.getLatestPersonVideo(ccmu01);
	}
	/**
	 *  获得审核的营业执照
	 *  2016-05-07
	 */
	public Attachment getBusLicense(Long ccmu01){
		List<Attachment> attachmentList = dao.getByAccountId(ccmu01,4l,"0");
		if(attachmentList!=null&&attachmentList.size()>0){
			return attachmentList.get(0);
		}else{
			return null;
		}
	}
	/**
	 *  获得审核的用户身份证图片
	 *  2016-05-07
	 */
	public Attachment getPersonIDCard(Long ccmu01){
		List<Attachment> attachmentList = dao.getByAccountId(ccmu01,1l,"0");
		if(attachmentList!=null&&attachmentList.size()>0){
			return attachmentList.get(0);
		}else{
			return null;
		}
	}
	/**
	 * 获得审核中和审核成功的附件总数
	 * AccountId,证件类型 和 审核状态 统计总数
	 */
	public Long getTotalCountAttachInCheck(Long ccmu01,Long credType){
		Long checkIng = dao.getTotalCountByAttachState(ccmu01, credType, 0l);
		Long checkOk = dao.getTotalCountByAttachState(ccmu01, credType, 1l);
		return (checkIng+checkOk);
	}
	/**
	 * 保存个人注册时上传的身份证扫描件供审核使用
	 */
	public void saveIdScan(String filePath, Long ccmu01) {
		Attachment attachment = this.getPersonIDCard(ccmu01);
		BaseConfig baseConfig = baseConfigService.getConfigByName("auto_audit_sfz");
		if(attachment!=null && !attachment.equals("")){
			attachment.setCaoa05(new Date());
			attachment.setCcpr08("0");
			attachment.setCczy06("1");
			//if("1".equals(baseConfig.getCaos04())){//个人帐号有效性审核操作 1:手动审核(生成无效帐号) 2:自动审核(生成有效帐号) --仅网站适用
				attachment.setCaoa07(0L); //未审核
			/*}else{
				attachment.setCaoa07(1L);//审核已通过
			}*/
			attachment.setCaoa02(filePath);
			dao.update(attachment);
		}else{
			attachment = new Attachment();
			attachment.setCaoa01(UniqueIdUtil.genSeqId(SqeIdName.Attachment.getSeqName()));
			attachment.setCcmu01(ccmu01);
			attachment.setCaoa04(1L);   
			attachment.setCaoa05(new Date());
			attachment.setCcpr08("0");
			attachment.setCczy06("1");
			//if("1".equals(baseConfig.getCaos04())){//个人帐号有效性审核操作 1:手动审核(生成无效帐号) 2:自动审核(生成有效帐号) --仅网站适用
				attachment.setCaoa07(0L); //未审核
			/*}else{
				attachment.setCaoa07(1L);//审核已通过
			}*/
			attachment.setCaoa03("个人注册时上传的身份证扫描件");
			attachment.setCaoa02(filePath);
			dao.add(attachment);
		}
	}
}
