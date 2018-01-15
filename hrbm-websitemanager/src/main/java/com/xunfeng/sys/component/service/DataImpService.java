/**   
 *  
 */

package com.xunfeng.sys.component.service;

import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xunfeng.core.excel.Excel;
import com.xunfeng.core.excel.editor.IFontEditor;
import com.xunfeng.core.excel.reader.ExcelReader;
import com.xunfeng.core.excel.reader.TableEntity;
import com.xunfeng.core.excel.style.Color;
import com.xunfeng.core.excel.style.font.BoldWeight;
import com.xunfeng.core.excel.style.font.Font;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.JSonUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.component.model.ExpModel;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wanghan
 * @createDate 2015年6月2日-上午8:44:14
 * @version V1.0
 */
public abstract class DataImpService {
	

	
	protected abstract void impData(TableEntity tableEntity,Map paramMap);
	


	public void importData(InputStream inputStream,Map paramMap) throws Exception {
		ExcelReader excel = new ExcelReader();
		// 读出execl
		TableEntity tableEntity = excel.readFile(inputStream);
		String columns=(String)paramMap.get("columns");
		List<Map> list=JSonUtils.readValue(columns, List.class);
		
		Map<String,String>  dataCol_key=new LinkedHashMap();
		for(Map map: list){
			dataCol_key.put((String)map.get("label"),(String)map.get("name"));
		}
		impData(tableEntity,dataCol_key);
	}

}
