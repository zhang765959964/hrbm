package com.xunfeng.business.personagency.storage.repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;












import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.affair.interf.PersonLetterServiceInterf;
import com.xunfeng.business.personagency.affair.model.PersonLetter;
import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.business.personagency.storage.interf.WageStandardServiceInterf;
import com.xunfeng.business.personagency.storage.model.WageStandard;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.core.web.util.RequestUtil;
/** 
* @company:河南讯丰信息技术有限公司
* @Description: RSDA_BS_PRINT_MODEL Service类
* @author:wanghan
* @createDate 2016-10-20 15:19:40 
* @version V1.0   
*/
@Service
public class StorePrintServiceImpl implements BindDataService  
{
	@Resource
	@Qualifier("wageStandard")
	private WageStandardServiceInterf wageStandardService;
	@Resource
	@Qualifier("personLetter")
	private PersonLetterServiceInterf personLetterService;
	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;
	
	
	@Override
	public Map getBindData(Map paramMap) {
		// TODO Auto-generated method stub
		String type = (String)paramMap.get("type");
		String id = (String)paramMap.get("id");
		Map<String, Object> returnMap=new HashMap();
		if("1".equals(type)){
			//企业基本工资标准调整表
			returnMap  = wageStandardService.getWageStandardById(Long.parseLong(id));
		}else if("2".equals(type)){
			//代管人事（关系）档案联系函
			returnMap  = personLetterService.getPersonLetterById(Long.parseLong(id));
		}else if("3".equals(type)){
			//档案条形码标签
			returnMap  = archivesService.getArchivesByArchivesId(Long.parseLong(id));
			StringBuffer barCode = new StringBuffer();
			barCode.append(RequestUtil.getHttpServletRequest().getContextPath());
			barCode.append("/CreateBarCode?code=");
			barCode.append(returnMap.get("archiveCode"));
			barCode.append("&barType=CODE128&checkCharacter=n&checkCharacterInText=n");
			returnMap.put("barCode", barCode.toString());
		}else if("corpPerson".equals(type)){
			List<Map> list = archivesService.getPersonArchives(id);
			returnMap.put("cpList", list);
			returnMap.put("aab004", list.get(0).get("aab004"));
		}
		return returnMap;
	}
	
}
