package com.xunfeng.sys.sendmessage.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xunfeng.business.person.model.PersonBaseInfo;
import com.xunfeng.core.db.IEntityDao;
import com.xunfeng.core.enumeration.SqeIdName;
import com.xunfeng.core.service.BaseService;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.identity.service.UniqueIdUtilService;
import com.xunfeng.sys.node.model.Node;
import com.xunfeng.sys.node.service.NodeService;
import com.xunfeng.sys.sendmessage.dao.MessageTemplatesDao;
import com.xunfeng.sys.sendmessage.interf.MessageTemplatesServiceInterf;
import com.xunfeng.sys.sendmessage.model.MessageTemplates;
import com.xunfeng.sys.sendmessage.util.ContentConversion;
import com.xunfeng.sys.sendmessage.util.ContentModel;
import com.xunfeng.sys.shortMessage.model.ShortMessage;
import com.xunfeng.sys.shortMessage.service.ShortMessageService;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: 短信模版表 Service类
* @author:wanghan
* @createDate 2016-04-25 14:56:37 
* @version V1.0   
*/
@Service
public class MessageTemplatesService extends BaseService<MessageTemplates> implements MessageTemplatesServiceInterf
{
	@Resource
	private MessageTemplatesDao dao;
	
	@Resource
	private NodeService nodeService;
	
	@Resource
	private ShortMessageService shortMessageService;
	
	@Resource
	private SenderService senderService;
	
	@Resource
	UniqueIdUtilService  uniqueIdUtil;
	
	public MessageTemplatesService()
	{
	}
	
	@Override
	protected IEntityDao<MessageTemplates, Long> getEntityDao() 
	{
		return dao;
	}
	
	public void sendAccountMessage(Long tempId,String phone,ContentModel cm ){
		
		  MessageTemplates  messageTemplates = this.getById(tempId);
		   Node node=nodeService.getByTemplates(messageTemplates.getComm01());//根据短信模板编码查询出节点编码
		   if("T".equals(node.getComn05())){
			   ShortMessage shortMessage = new ShortMessage();
			   String content = ContentConversion.modelConversionContent(cm, messageTemplates.getComm04());
			   senderService.sendVerificationCode(phone,content);
			   //保存发送信息
			   shortMessage.setComc01(uniqueIdUtil.genSeqId(SqeIdName.ShortMessage.getSeqName()));
			   shortMessage.setComc02(phone);
			   shortMessage.setComc03(content);
			   shortMessage.setComc04(1L);
			   shortMessage.setComc05(1L);
			   shortMessage.setAae011(cm.getAae011());
			   shortMessage.setAae017(cm.getAae017());
			   shortMessage.setAae036(new Date());
			   shortMessage.setComn01(node.getComn01());
			   shortMessage.setComc06(0L);
			   shortMessageService.add(shortMessage);
	}
 }
}
