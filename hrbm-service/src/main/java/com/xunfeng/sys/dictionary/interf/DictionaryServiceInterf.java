package com.xunfeng.sys.dictionary.interf;

import java.util.List;
import java.util.Map;

import com.xunfeng.core.service.GenericServiceInterface;
import com.xunfeng.sys.dictionary.model.Dictionary;

/**
* @company:河南讯丰信息技术有限公司
* @Description: 人员类别表 Service类
* @author:wxl
* @createDate 2015-08-10 16:44:29 
* @version V1.0   
*/
public interface DictionaryServiceInterf   extends GenericServiceInterface<Dictionary,Long>
{
	public List<Map<String ,Object>> getTabList(String tableName,String  sqlCondi);
	
	public List<Map<String ,Object>> getTabList(String valueField,String textField,String tableName,String  sqlCondi);

	/**
	 *查询所有的行业信息（TAB_INDUSTRY）
	 */
	public List<Dictionary> getIndustry();
}
