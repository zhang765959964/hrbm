package com.xunfeng.sys.identity.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.advert.model.AdCategory;
import com.xunfeng.business.advert.model.AdCompany;
import com.xunfeng.business.advert.model.AdDelRecord;
import com.xunfeng.business.advert.model.AdWeb;
import com.xunfeng.business.cation.model.Authentication;
import com.xunfeng.business.cms.model.Article;
import com.xunfeng.business.cms.model.ArticleColumn;
import com.xunfeng.business.corp.model.BookPay;
import com.xunfeng.business.corp.model.Corp;
import com.xunfeng.business.corp.model.CorpCollection;
import com.xunfeng.business.corp.model.CorpEnter;
import com.xunfeng.business.corp.model.CorpInterviewComment;
import com.xunfeng.business.corp.model.CorpPosition;
import com.xunfeng.business.corp.model.CorpPositionPublish;
import com.xunfeng.business.corp.model.CorpResumeDownLog;
import com.xunfeng.business.corp.model.CorpTalentFavorites;
import com.xunfeng.business.corp.model.DownloadResume;
import com.xunfeng.business.jobfair.model.BoothBook;
import com.xunfeng.business.jobfair.model.BoothUnsubscribe;
import com.xunfeng.business.jobfair.model.JobFairBooth;
import com.xunfeng.business.jobfair.model.JobFairInfo;
import com.xunfeng.business.jobfair.model.JobFairInfoSite;
import com.xunfeng.business.jobfair.model.JobFairSite;
import com.xunfeng.business.link.model.Link;
//import com.xunfeng.business.ovemp.cooporg.model.OvempCoopOrg;
import com.xunfeng.business.person.model.AccountMailAuth;
import com.xunfeng.business.person.model.AccountPhoneAuth;
import com.xunfeng.business.person.model.CorpBlackList;
import com.xunfeng.business.person.model.JobApply;
import com.xunfeng.business.person.model.JobAuditionInvited;
import com.xunfeng.business.person.model.JobCollect;
import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.business.person.model.PersonEducation;
import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.business.person.model.PersonProject;
import com.xunfeng.business.person.model.PersonQualification;
import com.xunfeng.business.person.model.PersonSkill;
import com.xunfeng.business.person.model.PersonTrain;
import com.xunfeng.business.person.model.PersonWorkExpce;
import com.xunfeng.business.person.model.Personlanguage;
import com.xunfeng.business.train.model.TrainOrg;
import com.xunfeng.business.train.model.TrainSignUp;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.attachment.model.Attachment;
import com.xunfeng.sys.component.model.ReleaseRange;
import com.xunfeng.sys.component.model.UploadAuthenInfo;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.identity.enumeration.SeqType;
import com.xunfeng.sys.identity.interf.UniqueIdUtilInterf;
import com.xunfeng.sys.identity.util.UniqueIdUtilImpl;
import com.xunfeng.sys.message.model.AccountMessage;
import com.xunfeng.sys.recommend.model.JobRecommend;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.uums.model.SysDept;
import com.xunfeng.sys.uums.model.SysOrg;
import com.xunfeng.sys.uums.model.SysUser;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: ID生成器
 * @author wanghan
 * @createDate 2015年4月23日-上午11:22:38
 * @version V1.0
 */
@Service
public class UniqueIdUtilService implements UniqueIdUtilInterf {

	@Resource
	BusinessIdentityService businessIdentityService;

	static Map<String, String> map = new HashMap<String, String>();
	static {
		map.put(Accounts.class.getName(), "seq_wz_yhid"); // 用户信息表
		map.put(PersonBaseInfo.class.getName(), "seq_gr_xxid"); // 個人基本信息
		map.put(PersonEducation.class.getName(), "seq_gr_jyid"); // 教育经历
		map.put(PersonJobRegist.class.getName(), "seq_gr_qzid"); // 求职登记
		map.put(PersonQualification.class.getName(), "seq_gr_zhengs"); // 个人资格证书
		map.put(PersonSkill.class.getName(), "seq_gr_jnbh"); // 技能
		map.put(PersonTrain.class.getName(), "seq_gr_pxbh"); // 培训经历
		map.put(PersonWorkExpce.class.getName(), "seq_gr_jyid"); // 工作经历
		map.put(Personlanguage.class.getName(), "SEQ_AC0F"); // 语言能力
		map.put(PersonProject.class.getName(), "SEQ_AC0E"); // 项目经验表
		map.put(JobCollect.class.getName(), "seq_wz_zwsc"); // 个人职位收藏夹
		map.put(JobAuditionInvited.class.getName(), "seq_wz_msyq"); // 面试邀请表
		map.put(JobApply.class.getName(), "seq_wz_zwsq"); // 职位申请表
		map.put(AccountMailAuth.class.getName(), "seq_wz_yjrz"); // 邮件认证
		map.put(AccountPhoneAuth.class.getName(), "seq_wz_sjrz"); // 手机认证
		map.put(AccountMessage.class.getName(), "seq_znx_bh"); // 站内信
		map.put(CorpBlackList.class.getName(), "seq_ac0g"); // 黑名单
		map.put(SysDept.class.getName(), "seq_oa_dep");
		map.put(SysUser.class.getName(), "seq_zp_cyry");
		map.put(SysOrg.class.getName(), "seq_zp_zjbh");
		map.put(Corp.class.getName(), "seq_dw_xxbh"); // 企业基本信息表
		map.put(CorpPositionPublish.class.getName(), "seq_dw_zpxx"); // 单位招聘信息表
		map.put(CorpPosition.class.getName(), "seq_dw_kwxx"); // 单位招聘岗位表
		map.put(CorpTalentFavorites.class.getName(), "seq_wz_rcsc"); // 企业人才收藏夹
		map.put(CorpResumeDownLog.class.getName(), "seq_wz_jlxz"); // 企业下载日志记录表
		map.put(CorpInterviewComment.class.getName(), "seq_ccp12"); // 企业面试评语
		map.put(JobFairInfo.class.getName(), "seq_zp_dhxx"); // 招聘会信息表
		// map.put(RecruitCorpEnter.class.getName(), "seq_zp_dwjc"); //单位进场招聘表
		map.put(JobRecommend.class.getName(), "seq_gr_tjid"); // 求职推荐匹配表
		map.put(Attachment.class.getName(), "seq_xt_rztj"); // 网上认证提交信息表 上传信息表
		// map.put(Interview.class.getName(), "seq_cb36"); //面试会表 CB36
		map.put(BoothBook.class.getName(), "seq_zp_twyd"); // 摊位预定表
		map.put(BoothUnsubscribe.class.getName(), "seq_zp_twcd"); // 摊位退订表
		map.put(JobFairBooth.class.getName(), "seq_zp_twbh"); // 摊位初始化表
																// JobFairSite
		map.put(JobFairSite.class.getName(), "seq_zp_cdbh"); // 场地表
		// InterviewApplySignLog("CB37","seq_cb37","面试会报名签到记录表"),
		// BoothForegift("CCZ02","seq_zp_yj","摊位押金表"),
		map.put(AdCategory.class.getName(), "seq_xw_gglb");
		map.put(AdCompany.class.getName(), "seq_xw_gggm");
		map.put(AdWeb.class.getName(), "seq_xw_ggnr");
		map.put(AdDelRecord.class.getName(), "seq_ad_del_record");
		map.put(Authentication.class.getName(), "seq_xt_rztj");
		map.put(Article.class.getName(), "seq_xw_nr");
		map.put(ArticleColumn.class.getName(), "seq_xw_lb");
		map.put(BookPay.class.getName(), "seq_zp_zfjl");
		map.put(CorpCollection.class.getName(), "seq_wz_rcsc");
		map.put(CorpEnter.class.getName(), "seq_zp_dwjc");
		map.put(DownloadResume.class.getName(), "seq_wz_jlxz");
		map.put(JobFairInfoSite.class.getName(), "seq_zp_cdcsh");
		map.put(Link.class.getName(), "seq_ccm08");
		map.put(UploadAuthenInfo.class.getName(), "seq_xt_rztj");
		map.put(BaseConfig.class.getName(), "seq_xt_pz");
		map.put(MessageTemplates.class.getName(), "seq_com_tem");
		map.put(ReleaseRange.class.getName(), "seq_sys_xx_zw");
		// 培训
		map.put(TrainSignUp.class.getName(), "seq_px_sign_up");
		map.put(ReleaseRange.class.getName(), "seq_sys_xx_zw");
		map.put(TrainOrg.class.getName(), "seq_px_org");
		// 境外就业
		// map.put(OvempCoopOrg.class.getName(), "seq_jw_coop_org");
	}

	public long genId(String modelName) {
		String seqName = map.get(modelName);
		Long idValue;
		if (StringUtil.isNotEmpty(seqName)) {
			idValue = UniqueIdUtilImpl.genSeqId(seqName);// 找到序列号
		} else {
			idValue = UniqueIdUtilImpl.genId();// 找不到序列号
		}
		return idValue;
	}

	@Deprecated
	public long genSeqId(String seqName) {
		return UniqueIdUtilImpl.genSeqId(seqName);
	}

	public String getGuid() {
		return UniqueIdUtilImpl.getGuid();
	}

	public synchronized String getBusniessSeqCode(SeqType SeqType, int point) {
		Long newIdentity = businessIdentityService.getNewBusinessIdentity(SeqType);
		StringBuffer add_str = new StringBuffer();
		String identity_str = newIdentity.toString();
		int length = identity_str.length();
		if (length < point) {
			int add_Int = point - length;
			for (int i = 0; i < add_Int; i++) {
				add_str.append("0");
			}
		}
		add_str.append(identity_str);
		return add_str.toString();
	}

}