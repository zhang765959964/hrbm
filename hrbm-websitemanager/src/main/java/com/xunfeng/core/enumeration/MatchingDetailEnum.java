package com.xunfeng.core.enumeration;

import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * 匹配详情枚举
 * 
 * @author Administrator
 *
 */
public enum MatchingDetailEnum {
	intentionalwork("意向工种符合", "1", "AAB019", "AAB019"), treatmentrequirements(
			"待遇要求符合", "2", "AAB020", "AAB020"), professionalskills("专业技能符合",
			"3", "AAB022", "AAB022"), industrycategories("自身条件符合", "4",
			"AAB054", "AAB054");
	private String name;
	private String value;
	private String tableColumn;
	private String tableColumnName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTableColumnName() {
		return tableColumnName;
	}

	public void setTableColumnName(String tableColumnName) {
		this.tableColumnName = tableColumnName;
	}

	private MatchingDetailEnum(String name, String value, String tableColumn,
			String tableColumnName) {
		this.name = name;
		this.value = value;
		this.tableColumn = tableColumn;
		this.tableColumnName = tableColumnName;
	}

	public String getTableColumn() {
		return tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}

	public static MatchingDetailEnum getValue(String value) {
		MatchingDetailEnum personStaEnum = null;
		switch (value) {
		case "":
			break;
		case "1":
			personStaEnum = intentionalwork;
			break;
		case "2":
			personStaEnum = treatmentrequirements;
			break;
		case "3":
			personStaEnum = professionalskills;
			break;
		case "4":
			personStaEnum = industrycategories;
			break;
		default:
			break;
		}
		return personStaEnum;
	}

	/**
	 * 根据匹配条件生成匹配sql
	 * 
	 * @param queryobjs
	 * @param personJobRegist
	 * @return
	 */
	public static StringBuilder getMatchSqlWhere(String queryobjs,
			PersonJobRegist personJobRegist, QueryFilter filter) {
		StringBuilder ret = new StringBuilder();
		String[] qobjs = queryobjs.split(",");
		for (String value : qobjs) {
			ret.append(getEnumMatchValue(value, personJobRegist, filter));
		}
		return ret.append(" AND ACB201='2' AND ACB208='未冻结' ");
	}

	public static String getEnumMatchValue(String value,
			PersonJobRegist personJobRegist, QueryFilter filter) {
		StringBuilder matchSql = new StringBuilder();
		switch (value) {
		case "":
			break;
		case "1":
			// 意向工种匹配条件 bcaa12
			matchSql.append(" AND ( BCA112 = #{OBJS_ACA112} ");
			// or BCA112 = #{OBJS_ACA1122}
			if(StringUtil.isNotEmpty(personJobRegist.getBcaa12())){
				matchSql.append(" or BCA112 = #{OBJS_ACA1121} ");
				filter.addFilter("OBJS_ACA1121",personJobRegist.getBcaa12());
			}
			if(StringUtil.isNotEmpty(personJobRegist.getBcab12())){
				matchSql.append(" or BCA112 = #{OBJS_ACA1122} ");
				filter.addFilter("OBJS_ACA1122",personJobRegist.getBcab12());
			}
			matchSql.append(" or CCA113 =#{OBJS_BCC20C} ) ");
			filter.addFilter("OBJS_ACA112", StringUtil.isEmpty(personJobRegist
					.getBca112()) ? "" : personJobRegist.getBca112());
			filter.addFilter("OBJS_BCC20C", StringUtil.isEmpty(personJobRegist
					.getBcc20c()) ? "" : personJobRegist.getBcc20c());
			break;
		case "2":
//			if (StringUtil.isNotEmpty(personJobRegist.getAcc214())) {
//				String[] values = personJobRegist.getAcc214().split(",");
//				for (int i = 0; i < values.length; i++) {
//					matchSqlAcc214.append(" or instr(ACC214N," + values[i] + " )>0 ");
//				}
//			}
			matchSql.append(" AND ( ACC034 = #{OBJS_ACC034}  or ACC214 = #{OBJS_ACC214N} or ACB228 =#{OBJS_ACB228} or AAB019N =#{OBJS_AAB019N} or AAB020N =#{OBJS_AAB020N} or ACC20T =#{OBJS_ACC20T})");
			filter.addFilter("OBJS_ACC034", StringUtil.isEmpty(personJobRegist.getSalay()) ? "" : personJobRegist.getSalay());
			filter.addFilter("OBJS_ACB228", StringUtil.isEmpty(personJobRegist
					.getAcb228()) ? "" : personJobRegist.getAcb228());
			filter.addFilter("OBJS_ACC214N", StringUtil.isEmpty(personJobRegist
					.getAcc214n()) ? "" : personJobRegist.getAcc214n());
			filter.addFilter("OBJS_AAB019N", StringUtil.isEmpty(personJobRegist
					.getAab019()) ? "" : personJobRegist.getAab019());
			filter.addFilter("OBJS_AAB020N", StringUtil.isEmpty(personJobRegist
					.getAab020()) ? "" : personJobRegist.getAab020());
			filter.addFilter("OBJS_ACC20T", StringUtil.isEmpty(personJobRegist
					.getAcc20tName()) ? "" : personJobRegist.getAcc20tName());
			break;
		case "3":
			matchSql.append(" AND (BCC20X = #{OBJS_BCC20X} OR AAC038 = #{OBJS_AAC038})");
			filter.addFilter("OBJS_BCC20X", StringUtil.isEmpty(personJobRegist
					.getBcc20x()) ? "" : personJobRegist.getBcc20x());
			filter.addFilter("OBJS_AAC038", StringUtil.isEmpty(personJobRegist
					.getAac038Name()) ? "" : personJobRegist.getAac038Name());
			break;
		case "4":
			//自身条件
			matchSql.append(" and ( AAD004=#{OBJS_AAD004} or AAC011=#{OBJS_AAC011} or AAC009=#{OBJS_AAC009} or AAC017=#{OBJS_AAC017} or AAC024=#{OBJS_AAC024} or AAC005=#{OBJS_AAC005} or AAC033=#{OBJS_AAC033})");
			filter.addFilter("OBJS_AAD004", StringUtil.isEmpty(personJobRegist
					.getAac004()) ? "" : personJobRegist.getAac004());
			filter.addFilter("OBJS_AAC011", StringUtil.isEmpty(personJobRegist
					.getAac011()) ? "" : personJobRegist.getAac011());
			filter.addFilter("OBJS_AAC009", StringUtil.isEmpty(personJobRegist
					.getAac009()) ? "" : personJobRegist.getAac009());
			filter.addFilter("OBJS_AAC017", StringUtil.isEmpty(personJobRegist
					.getAac017()) ? "" : personJobRegist.getAac017());
			filter.addFilter("OBJS_AAC024", StringUtil.isEmpty(personJobRegist
					.getAac024()) ? "" : personJobRegist.getAac024());
			filter.addFilter("OBJS_AAC005", StringUtil.isEmpty(personJobRegist
					.getAac005()) ? "" : personJobRegist.getAac005());
			filter.addFilter("OBJS_AAC033", StringUtil.isEmpty(personJobRegist
					.getAac033()) ? "" : personJobRegist.getAac033());
			break;
		default:
			break;
		}
		// 设置套餐编号
		return matchSql.toString();
	}

	public static MatchingDetailEnum getName(String value) {
		MatchingDetailEnum personStaEnum = null;
		switch (value) {
		case "":
			break;
		case "1":
			personStaEnum = intentionalwork;
			break;
		case "2":
			personStaEnum = treatmentrequirements;
			break;
		case "3":
			personStaEnum = professionalskills;
			break;
		case "4":
			personStaEnum = industrycategories;
			break;
		default:
			break;
		}
		return personStaEnum;
	}
}
