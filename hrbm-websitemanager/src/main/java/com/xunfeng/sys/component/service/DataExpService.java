/**   
 *  
 */

package com.xunfeng.sys.component.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xunfeng.core.excel.Excel;
import com.xunfeng.core.excel.editor.IFontEditor;
import com.xunfeng.core.excel.style.Color;
import com.xunfeng.core.excel.style.font.BoldWeight;
import com.xunfeng.core.excel.style.font.Font;
import com.xunfeng.core.util.BeanToBean;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.util.JSonUtils;
import com.xunfeng.sys.component.model.ExpModel;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wanghan
 * @createDate 2015年6月2日-上午8:44:14
 * @version V1.0
 */
public abstract class DataExpService {
	
	private int expType=0;

	protected abstract List<Object> getExpData(Map dataMap);
	
	
	public int getExpType() {
		return expType;
	}

	public void setExpType(int expType) {
		this.expType = expType;
	}

	public HSSFWorkbook exportData(Map dataMap) {
		
		String expType=(String)dataMap.get("expType");
		String sheetName=(String)dataMap.get("sheetName");
		
		setExpType(Integer.valueOf(expType));

		ExpModel expModel = getExpModelData(dataMap);

		Excel excel = new Excel();

		List<String> list = expModel.getTitleList();

		excel.sheet().sheetName(sheetName);// 重命名当前处于工作状态的表的名称

		// 第一行标题 加粗
		excel.row(0, 0).value(list.toArray()).font(new IFontEditor() {
			// 设置字体
			@Override
			public void updateFont(Font font) {
				font.boldweight(BoldWeight.BOLD);// 粗体
			}
		}).bgColor(Color.GREY_25_PERCENT);
		// 取得表的数据
		List<List<Object>> dataList = expModel.getValueList();

		if (BeanUtils.isNotEmpty(dataList)) {
			// 从第2行写入数据
			for (int i = 0; i < dataList.size(); i++) {
				List<Object> objectList = dataList.get(i);
				excel.row(i + 1).value(objectList.toArray()).dataFormat("@");
			}
		}

		return excel.getWorkBook();
	}
	
	private ExpModel getExpModelData(Map paramMap) {
		String columns=(String)paramMap.get("columns");
		List<Map> list=JSonUtils.readValue(columns, List.class);
		
		List archivesList=getExpData( paramMap);
		 Map<String,String>  dataCol_key=new LinkedHashMap();
		for(Map map: list){
			 Object flag = (Object)map.get("hidden");	//取得hidden 的属性， 取得key的属性    展示数据为 hidden！=true  key!=true的数据
			 String fg = flag.toString();
			 Object key = (Object)map.get("key");
			 if(key!=null){		
				 String k = key.toString();		
				 if(!fg.equals("true")&&!k.equals("true")){
					 dataCol_key.put((String)map.get("name"), (String)map.get("label"));
				 }
			 }else{
				 if(!fg.equals("true")){
					 dataCol_key.put((String)map.get("name"), (String)map.get("label"));
				 }
			 }
			
		}

		ExpModel expModel=new ExpModel();
		List titleList=new ArrayList();
		 for (Map.Entry<String, String> entry : dataCol_key.entrySet()) {  			 	         
	         titleList.add(entry.getValue());
		 }
		expModel.setTitleList(titleList);
		List valueList=new ArrayList();
       
		for(Object archives: archivesList){
			List rowList=new ArrayList();
			for (Map.Entry<String, String> entry : dataCol_key.entrySet()) { 			 	         
                 try{ 
		         Object value=BeanToBean.getProperty(archives, entry.getKey());
		         rowList.add(value);
		         }catch(Exception e){
		        	 //找不到字段的时候加一个空字符串，防止标题和内容错位
		        	 rowList.add(""); 
		         }
		         
			 }
			valueList.add(rowList);
		}
		expModel.setValueList(valueList);
		
		return expModel;
				
	}

}
