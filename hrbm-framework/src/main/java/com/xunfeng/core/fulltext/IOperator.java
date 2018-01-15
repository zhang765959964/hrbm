package com.xunfeng.core.fulltext;


import org.apache.lucene.index.IndexWriter;


/**  
* @company: 河南讯丰信息技术有限公司 
* @Description: 全文检索接口 
* @author wanghan 
* @createDate 2015年4月23日-下午2:11:57 
* @version V1.0   
*/
public interface IOperator {
	
	/**
	 * 添加索引文档。
	 * <pre>
	 * 	抽象方法，需要在子类中实现。
	 * 	Document doc=new Document();
	 *	doc.add(field)
	 *	ramWrite.addDocument(doc);
	 *</pre>
	 * @param writer
	 */
	public void addDocument(IndexWriter writer);
	
	/**
	 * 获取需要查询的字段名称，为数组。
	 * {'Title','Content'}
	 * @return
	 */
	public String[] getFields();

}
