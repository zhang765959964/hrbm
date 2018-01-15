package com.xunfeng.business.personagency.print.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xunfeng.business.personagency.archive.interf.ArchivesServiceInterf;
import com.xunfeng.core.util.AppUtil;
import com.xunfeng.core.util.ContextUtil;
import com.xunfeng.core.util.DateUtil;
import com.xunfeng.sys.uums.model.SysUser;

public class TemplateUtil {

	private static Map personProMap=new LinkedHashMap();
	protected static Logger logger = LoggerFactory.getLogger(TemplateUtil.class);
	static{
		personProMap.put("AAA001", "社会保障号码");
		personProMap.put("AAB004", "就业单位名称");
		personProMap.put("AAC002", "身份证号");
		personProMap.put("AAC003", "姓名");
		personProMap.put("AAC004", "性别");
		personProMap.put("AAC005", "民族");
		personProMap.put("AAC006", "出生日期");
		personProMap.put("AAC007", "参加工作日期");
		personProMap.put("AAC011", "文化程度");
		personProMap.put("AAC017", "婚姻状况");
		personProMap.put("AAC024", "政治面貌");
		personProMap.put("AAE005", "联系电话");
		personProMap.put("AAE036", "经办日期");
		personProMap.put("ACC702", "配偶姓名");
		personProMap.put("ACC702", "是否军转干部");
		personProMap.put("ACC704", "代理类型");
		personProMap.put("ACC705", "档案出生日期");
		personProMap.put("ACC706", "档案姓名");
		personProMap.put("ACC707", "退休年数");
		personProMap.put("ACC708", "退休参考日期");
		personProMap.put("ACC709", "档案转入日期");
		personProMap.put("ACC70A", "档案状态");
		personProMap.put("ACC70B", "原单位名称");
		personProMap.put("ACC70L", "职务");
		personProMap.put("ACC740", "档案编号");
		personProMap.put("BAE019", "证明开具经办人");
		personProMap.put("BAE036", "证明开具日期");
		
	}
	public static Map getPersonProMap() {
		return personProMap;
	}

	public static Map getPersonValueMap(Long personId){
        Map map=new HashMap();
        ArchivesServiceInterf archivesService=(ArchivesServiceInterf)AppUtil.getBean("archives");
        map= archivesService.getPersonBaseinfoByPersonId(personId);
        SysUser sysUser=ContextUtil.getCurrentUser();
		map.put("AAA001", map.get("EXPSOCTALNUMBER"));
		map.put("AAB004", map.get("AAB004"));
//		map.put("AAC002", "身份证号");
//		map.put("AAC003", "姓名");
		map.put("AAC004", map.get("GENDERNAME"));
		map.put("AAC005", map.get("NATIONNAME"));
//		map.put("AAC006", "出生日期");
		map.put("AAC007", map.get("EXPSTARTJOBDATE"));
//		map.put("AAC011", "文化程度");
		map.put("AAC017", map.get("MARITALSTATUSNAME"));
		map.put("AAC024", map.get("POLITICALLANDSCAPE"));
//		map.put("AAE005", "联系电话");
		map.put("AAE036", map.get("ARCHIVERECEIVEDATE"));
		map.put("ACC702", map.get("FANAME"));
//		map.put("ACC702", "是否军转干部");
		map.put("ACC704", map.get("ARCHIVETYPENAME"));
		map.put("ACC705", map.get("ARCHIVEBIRTHDATE"));
		map.put("ACC706", map.get("ARCHIVENAME"));
//		map.put("ACC707", "退休年数");
		map.put("ACC708", map.get("PLANRETIREDDATE"));
		map.put("ACC709", map.get("ARCHIVERECEIVEDATE"));
		map.put("ACC70A", map.get("ARCHIVESTATUSNAME"));
		map.put("ACC70B", map.get("EXPOLDCOMPANY"));
		map.put("ACC70L", map.get("EXPPOST"));
		map.put("ACC740", map.get("ARCHIVECODE"));
        map.put("BAE019", sysUser.getAac003());
        map.put("BAE036", DateUtil.getformatterCurrentDate("yyyy-MM-dd"));  
        return map;
	}
	public static String getDefalutHtml(){
		return "<style>span{line-height:2.0;}</style>"
              +"<table align=\"center\" width=\"603px\">"
				   +" <tbody>"
				       + "<tr class=\"firstRow\">"
				         +   "<td valign=\"top\" style=\"word-break: break-all; border-color: rgb(221, 221, 221);\" align=\"center\">"    
				          +  "</td>"
				       +" </tr>"
				       +"<tr>"
				       +"  <td valign=\"top\" style=\"word-break: break-all; border-color: rgb(221, 221, 221);\">"
				       +" <p><span style=\"letter-spacing: 0;font-size: 24px\"><span style=\"font-family:sans-serif\">&nbsp; &nbsp;特此证明</span></span></p>"
				       +"</td>"
				       +" </tr>"
				   + "</tbody>"
				+"</table>";
	}
	public static String htmlToTemplate(String html){
		
		Document doc= Jsoup.parseBodyFragment(html);
		parseSubTable(doc);
		Elements mainFields=doc.select("[external]");
		
		for(Iterator<Element> it= mainFields.iterator();it.hasNext();){
			Element el=it.next();
			String nodeName=el.nodeName();
			if("table".equalsIgnoreCase(nodeName)){

				continue;
			}
			String external=el.attr("external").replace("&#39;", "\"").replace("&quot;","\"");
			//移除external属性。
			el.removeAttr("external");
			JSONObject jsonObject=null;
			try{
				jsonObject=JSONObject.fromObject(external);
			}
			catch(Exception ex){
				logger.error(ex.getMessage());
				ex.printStackTrace();
				return null;
			}
			String key=jsonObject.getString("key");
			String name=jsonObject.getString("name");
			String type=jsonObject.getString("type");
			String text=el.text().replace("["+name+"]", "${"+key+"}");
			
			if("img".equals(type)){
				String imgHtml="<img src=\"${"+key+"}\"></img>";
				el.text(imgHtml);
			}else{
				el.text(text);
			}
			
			//removeWrap(el);
		}
		
		String template=doc.body().html();
		template=template.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "'");
		template = "<#setting number_format=\"#\">\r\n" + template;
		return template;
		
	}
	
	/**处理子表模型
	 * @param doc
	 */
	private static void parseSubTable(Document doc){
		
		Elements mainFields=doc.select("table[external]");
		for(Iterator<Element> it= mainFields.iterator();it.hasNext();){
			Element el=it.next();
			String external=el.attr("external").replace("&#39;", "\"").replace("&quot;","\"");
			//移除external属性。
			el.removeAttr("external");
			JSONObject jsonObject=null;
			try{
				jsonObject=JSONObject.fromObject(external);
			}
			catch(Exception ex){
				logger.error(ex.getMessage());
				ex.printStackTrace();
			}
			String tableName=jsonObject.getString("key");
			String rowNum=jsonObject.getString("rowNum");
			
			//新行
			Elements rows=el.select("tr[formtype=datarow]");
			Element row=rows.get(0);
			Element newRow=row.clone();
			row.after(newRow);
			row.before(" &lt;#list "+tableName+" as table&gt;");
			row.after("&lt;/#list>");
			newRow.before("&lt;#if ("+tableName+"?size < "+rowNum+") &gt; &lt;#list 1.."+rowNum+"-"+tableName+"?size as i&gt;");
			newRow.after("&lt;/#list>&lt;/#if>");
			removeSubTableField(newRow);
			parseSubTableField(row);
		}
	}
	
	private static void removeSubTableField(Element newRow){
		
		Elements mainFields=newRow.select("[external]");
		for(Iterator<Element> it= mainFields.iterator();it.hasNext();){
			Element el=it.next();
			el.remove();

			
		}
		
	}
	private static void parseSubTableField(Element newRow){
		
		Elements mainFields=newRow.select("[external]");
		for(Iterator<Element> it= mainFields.iterator();it.hasNext();){
			Element el=it.next();
			String external=el.attr("external").replace("&#39;", "\"").replace("&quot;","\"");
			//移除external属性。
			el.removeAttr("external");
			JSONObject jsonObject=null;
			try{
				jsonObject=JSONObject.fromObject(external);
			}
			catch(Exception ex){
				logger.error(ex.getMessage());
				ex.printStackTrace();
			}
			String key=jsonObject.getString("key");
			String name=jsonObject.getString("name");
			String type=jsonObject.getString("type");
			String text=el.text().replace("["+name+"]", "${table."+key+"}");
			
			if("img".equals(type)){
				String imgHtml="<img src=\"${table."+key+"}\"></img>";
				el.text(imgHtml);
			}else{
				el.text(text);
			}
			
			
		}
		
	}
	
	private static void removeWrap(Element parentEl){
		
		for(Iterator< Element> it=parentEl.children().iterator();it.hasNext();){
			Node elClone=it.next();
			parentEl.before(elClone);
		}
		parentEl.remove();
		
	}

}
