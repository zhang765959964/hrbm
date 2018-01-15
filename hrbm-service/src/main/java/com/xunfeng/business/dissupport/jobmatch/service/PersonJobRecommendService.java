package com.xunfeng.business.dissupport.jobmatch.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.node.model.Node;
import com.xunfeng.sys.node.service.NodeService;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.sendmessage.service.MessageTemplatesService;
import com.xunfeng.sys.sendmessage.service.SenderService;
import com.xunfeng.sys.sendmessage.util.ContentConversion;
import com.xunfeng.sys.sendmessage.util.ContentModel;
import com.xunfeng.sys.shortMessage.model.ShortMessage;
import com.xunfeng.sys.shortMessage.service.ShortMessageService;
import com.xunfeng.business.dissupport.jobmatch.model.PersonJobRecommend;
import com.xunfeng.business.dissupport.jobmatch.dao.PersonJobRecommendDao;
import com.xunfeng.business.dissupport.jobmatch.interf.PersonJobRecommendServiceInterf;

/**
 * @company:河南讯丰信息技术有限公司
 * @Description: 求职推荐匹配表 Service类
 * @author:wanghan
 * @createDate 2016-08-15 20:00:42
 * @version V1.0
 */
@Service
public class PersonJobRecommendService extends BaseService<PersonJobRecommend>
		implements PersonJobRecommendServiceInterf {
	@Resource
	private PersonJobRecommendDao dao;

	@Resource
	private SenderService senderService;
	@Resource
	private ShortMessageService shortMessageService;
	@Resource
	private MessageTemplatesService messageTemplatesService;
	@Resource
	UniqueIdUtilService UniqueIdUtil;
	@Resource
	private NodeService nodeService;

	public PersonJobRecommendService() {
	}

	@Override
	protected IEntityDao<PersonJobRecommend, Long> getEntityDao() {
		return dao;
	}

	@Override
	public void add(PersonJobRecommend entity) {
		
		try {
			if(StringUtil.isNotEmpty(entity.getIsmessge())){
			//-------向求职人发送短信
			ContentModel cm = new ContentModel();
			// 企业名称
			cm.setCorpName(entity.getAab004());
			// 岗位名称
			cm.setCorpPosition(entity.getBca112());
			// 企业联系人
			cm.setCorpPerson(entity.getAae004());
			// 企业手机号()
			cm.setCorpPhone(entity.getAae139());
			if(StringUtil.isNotEmpty(entity.getAce139())){
			sendCommMessage(cm, 24L, entity.getAce139(), entity.getAae011(),entity.getAae017());}
			
			//-------向单位发送信息
			ContentModel cmCorp = new ContentModel();
			// 岗位名称
			cmCorp.setCorpPosition(entity.getBca112());
			// 个人
			cmCorp.setPersonName(entity.getAac003());
			if(StringUtil.isNotEmpty(entity.getAae139())){
			sendCommMessage(cmCorp, 21L, entity.getAae139(), entity.getAae011(),entity.getAae017());}}
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.add(entity);
	}
    public Long getMaxId(){
		Long count = (Long) dao.getOne("getMaxId",null);
		return count ;
    }
	/**
	 * 短信发送
	 * 
	 * @param cm
	 *            短信模板实体(依据实体生成短信内容)
	 * @param messageType
	 *            短信节点ID
	 * @param phone
	 *            发送手机号
	 * @param aae011
	 *            经办人代码
	 * @param aae017
	 *            经办机构代码
	 */
	private void sendCommMessage(ContentModel cm, Long messageType,
			String phone, String aae011, String aae017) {
		// 向个人发送短信
		MessageTemplates messageTemplates = messageTemplatesService
				.getById(messageType);
		Node node = nodeService.getByTemplates(messageTemplates.getComm01());
		// 根据短信模板编码查询出节点编码
		if ("T".equals(node.getComn05())) {

			String content = ContentConversion.modelConversionContent(cm,
					messageTemplates.getComm04());
			// 接受短信手机号设置
			senderService.sendVerificationCode(phone, content);
			saveShortMessage(phone, aae011, aae017, content, node.getComn01());
		}
	}

	/**
	 * 发送短信记录保存
	 * 
	 * @param phone
	 *            发送手机号
	 * @param aae011
	 *            经办人
	 * @param aae017
	 *            经办机构
	 * @param content
	 *            发送内容
	 * @param code
	 *            节点编号
	 */
	private void saveShortMessage(String phone, String aae011, String aae017,
			String content, Long code) {
		ShortMessage shortMessage = new ShortMessage();
		// 保存发送信息
		shortMessage.setComc01(UniqueIdUtil.genId(ShortMessage.class.getName()));
		shortMessage.setComc02(phone);
		shortMessage.setComc03(content);
		shortMessage.setComc04(1L);
		shortMessage.setComc05(1L);
		shortMessage.setAae011(aae011);
		shortMessage.setAae017(aae017);
		shortMessage.setAae036(new Date());
		shortMessage.setComn01(code);
		shortMessage.setComc06(0L);
		shortMessageService.add(shortMessage);
	}

	@Override
	public boolean isExists(Long acb210, Long acc200) {
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("acb210", acb210);
		params.put("acc200", acc200);
		Long count = (Long) dao.getOne("isExists", params);
		return count > 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getCorpPostionView(QueryFilter queryFilter) {
		return (Map<String, Object>) dao.getOne("getCorpPostionView", queryFilter.getFilters());
	}

}
