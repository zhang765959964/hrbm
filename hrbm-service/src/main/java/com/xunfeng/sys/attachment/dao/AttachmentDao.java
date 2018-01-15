package com.xunfeng.sys.attachment.dao;

import com.xunfeng.core.db.BaseDao;
import com.xunfeng.sys.attachment.dto.CorpAttachmentDto;
import com.xunfeng.sys.attachment.model.Attachment;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* @company:河南讯丰信息技术有限公司
* @Description: 网上认证提交信息表 Dao类
* @author:wxl
* @createDate 2015-08-02 17:37:04 
* @version V1.0   
*/
@Repository
public class AttachmentDao extends BaseDao<Attachment>
{
	@Override
	public Class<?> getEntityClass()
	{
		return Attachment.class;
	}

	/**
	 * 根据ID（caoa01）改变附件的删除状态 ccpr08 是否删除状态（0-否1-是）
	 */
	public void updateDelStatus(String ccpr08,Long caoa01){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("ccpr08",ccpr08);
		params.put("caoa01",caoa01);
		this.update("updateDelStatus",params);
	}

	/**
	 * 根据类型和用户编号获取信息
	 * ccmu01 用户编号
	 * caoa04 证件类型 1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频
	 * ccpr08 0-否1-是
	 */
	public List<Attachment> getByAccountId(Long ccmu01,Long caoa04,String  ccpr08){
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("ccmu01",ccmu01);
		params.put("caoa04",caoa04);
		params.put("ccpr08",ccpr08);
		return this.getListBySqlKey("getByAccountId",params);
	}
	
	//根据ccmu01查询AB01表和CAO04
	public CorpAttachmentDto getCorpAuthByAccountId(Long ccmu01){
		Map params = new HashMap();
		params.put("ccmu01", ccmu01);
		return (CorpAttachmentDto) this.getOne("getCorpAuthByAccountId", params);
	}
	/**
	 *  根据标示获得公司上传的图片 按时间排序
	 *  caoa04 证件类型 1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频
	 *  2016-04-18
	 */
	public List<Map<String,Object>> getCorpImg(Long ccmu01){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ccmu01", ccmu01);
		map.put("caoa04", 6);
		map.put("caoa07", 1);
		return this.getListBySqlKey("getAttachImg", map);
	}
	/**
	 *  根据标示获得公司上传的最新视频
	 *  caoa04 证件类型 1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频
	 *  2016-04-18
	 */
	public Map<String,Object> getLatestCorpVideo(Long ccmu01){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ccmu01", ccmu01);
		map.put("caoa04", 7);
		map.put("caoa07", 1);
		return (Map<String, Object>) this.getOne("getLatestAttachVideo",map);
	}
	/**
	 *  根据标示获得个人上传的图片 按时间排序
	 *  caoa04 证件类型 1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频
	 *  2016-04-23
	 */
	public List<Map<String,Object>> getPersonImg(Long ccmu01){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ccmu01", ccmu01);
		map.put("caoa04", 8);
		map.put("caoa07", 1);
		return this.getListBySqlKey("getAttachImg", map);
	}
	/**
	 *  根据标示获得个人上传的最新视频
	 *  caoa04 证件类型 1-身份证2-军官证3-驾照4-营业执照5-组织机构代码证6-单位图片7-单位视频8-个人图片9-个人视频
	 *  2016-04-23
	 */
	public Map<String,Object> getLatestPersonVideo(Long ccmu01){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ccmu01", ccmu01);
		map.put("caoa04", 9);
		map.put("caoa07", 1);
		return (Map<String, Object>) this.getOne("getLatestAttachVideo",map);
	}
	/**
	 * 根据AccountId,证件类型 和 审核状态 统计总数
	 */
	public Long getTotalCountByAttachState(Long ccmu01,Long credType,Long state){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("ccmu01", ccmu01);
		map.put("caoa04", credType);
		map.put("caoa07", state);
		return (Long) this.getOne("getCountAttach",map);
	}
	
}