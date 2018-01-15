
/**   
*  
*/


package com.xunfeng.business.personagency.print.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.business.personagency.print.service.BindDataService;
import com.xunfeng.business.personagency.print.util.TemplateUtil;

/**  
 * @company: 河南讯丰信息技术有限公司 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author wanghan 
 * @createDate 2015年6月2日-上午8:46:14 
 * @version V1.0   
 */
@Service
public class PrintBindDataServiceImpl implements BindDataService {

	@Resource
	@Qualifier("archives")
	private ArchivesServiceInterf archivesService;

	
	public  Map getBindData(Map paramMap){
		Long personId=65776L;
		Map<String, Object> map=TemplateUtil.getPersonValueMap(personId);// archivesService.getArchivesByPersonId(personId);
		Map<String, Object> returnMap=new HashMap();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			returnMap.put(entry.getKey().toLowerCase(), entry.getValue());
		}
		Map newMap=new HashMap();
		List newList=new ArrayList();
		for(int i=0;i<5;i++){
			newList.add(returnMap);
		}
		
		newMap.put("fff", newList);
		return newMap;
	}
}
