/**   
 *  
 */

package com.xunfeng.sys.component.service;

import com.xunfeng.core.excel.Excel;
import com.xunfeng.core.excel.editor.IFontEditor;
import com.xunfeng.core.excel.reader.ExcelReader;
import com.xunfeng.core.excel.reader.TableEntity;
import com.xunfeng.core.excel.style.Color;
import com.xunfeng.core.excel.style.font.BoldWeight;
import com.xunfeng.core.excel.style.font.Font;
import com.xunfeng.core.util.BeanUtils;
import com.xunfeng.core.web.query.QueryFilter;
import com.xunfeng.sys.component.model.ExpModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @company: 河南讯丰信息技术有限公司
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wanghan
 * @createDate 2015年6月2日-上午8:44:14
 * @version V1.0
 */
public abstract class DataImpExpService {
	
	private int expType=0;

	protected abstract ExpModel getExpData(Map dataMap,QueryFilter fiter);
	
	protected abstract void impData(TableEntity tableEntity);
	
	public int getExpType() {
		return expType;
	}

	public void setExpType(int expType) {
		this.expType = expType;
	}

	public HSSFWorkbook exportData(Map dataMap,QueryFilter fiter) {
		
		String expType=(String)dataMap.get("expType");
		String sheetName=(String)dataMap.get("sheetName");
		
		setExpType(Integer.valueOf(expType));

		ExpModel expModel = getExpData(dataMap,fiter);

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
	
	public void importData(InputStream inputStream) throws Exception {
		ExcelReader excel = new ExcelReader();
		// 读出execl
		TableEntity tableEntity = excel.readFile(inputStream);
		impData(tableEntity);
	}

}
