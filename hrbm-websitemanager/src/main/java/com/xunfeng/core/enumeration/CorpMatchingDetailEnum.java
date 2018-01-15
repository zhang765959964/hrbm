package com.xunfeng.core.enumeration;

import java.util.Map;

import com.xunfeng.business.person.model.PersonJobRegist;
import com.xunfeng.core.util.StringUtil;
import com.xunfeng.core.web.query.QueryFilter;

/**
 * 单位匹配详情枚举
 * 
 * @author Administrator
 *
 */
public enum CorpMatchingDetailEnum {
	intentionalwork("意向工种符合", "1", "AAB019", "AAB019"), treatmentrequirements(
			"待遇要求符合", "2", "AAB020", "AAB020"), mainconditions("主要条件符合", "3",
			"AAB020", "AAB020"), otherconditions("其余条件符合", "4", "AAB020",
			"AAB020"), ageconditions("年龄段符合", "5", "AAB020", "AAB020");

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

	private CorpMatchingDetailEnum(String name, String value,
			String tableColumn, String tableColumnName) {
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

	public static CorpMatchingDetailEnum getValue(String value) {
		CorpMatchingDetailEnum personStaEnum = null;
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
			personStaEnum = mainconditions;
			break;
		case "4":
			personStaEnum = otherconditions;
			break;
		case "5":
			personStaEnum = ageconditions;
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
			Map<String, Object> corpPostion, QueryFilter filter) {
		StringBuilder ret = new StringBuilder();
		String[] qobjs = queryobjs.split(",");
		for (String value : qobjs) {
			ret.append(getEnumMatchValue(value, corpPostion, filter));
		}
		return ret.append(" AND ACB208='未冻结' ");
	}

	/**
	 * 向filter中添加检索条件
	 * 
	 * @param corpPostion
	 *            检索条件值
	 * @param filter
	 *            检索条件容器
	 * @param key
	 *            key值
	 */
	public static void addCodetions(Map<String, Object> corpPostion,
			QueryFilter filter, String key) {
		filter.addFilter("OBJS_".concat(key),
				StringUtil.isEmpty(String.valueOf(corpPostion.get(key))) ? ""
						: String.valueOf(corpPostion.get(key)));
	}

	public static String getEnumMatchValue(String value,
			Map<String, Object> corpPostion, QueryFilter filter) {
		StringBuilder matchSql = new StringBuilder();
		switch (value) {
		case "":
			break;
		case "1":
			// 意向工种匹配条件
			matchSql.append(" AND ( BCA112 = #{OBJS_ACA112} or BCC20C =#{OBJS_CCA113} )");
			addCodetions(corpPostion, filter, "CCA113");// 工种名称
			addCodetions(corpPostion, filter, "ACA112");// 工种说明
			break;
		case "2":
			// 待遇符合匹配条件
			matchSql.append(" AND ( ACC034 = #{OBJS_ACC034} OR ACC214 =#{OBJS_ACC214} OR ACB228 =#{OBJS_ACB228} OR AAB019 =#{OBJS_AAB019N} OR AAB020 =#{OBJS_AAB020N} OR ACC20T =#{OBJS_ACC20T})");
			addCodetions(corpPostion, filter, "ACC034");// 月工资
			addCodetions(corpPostion, filter, "ACC214");// 福利待遇
			addCodetions(corpPostion, filter, "ACB228");// 食宿要求
			addCodetions(corpPostion, filter, "AAB019N");// 单位性质
			addCodetions(corpPostion, filter, "AAB020N");// 经济类型
			addCodetions(corpPostion, filter, "ACC20T");// 招聘对象
			break;
		case "3":
			// 主要条件符合
			matchSql.append(" AND ( AAC038 = #{OBJS_AAC038} OR bcc20x =#{OBJS_BCC20XN} )");
			addCodetions(corpPostion, filter, "AAC038");// 外语语种
			addCodetions(corpPostion, filter, "BCC20XN");// 普通话水平
			break;
		case "4":
			// 其余条件符合
			matchSql.append(" AND ( AAC004 = #{OBJS_AAD004} OR AAC011 =#{OBJS_AAC011} OR AAC009 =#{OBJS_AAC009} OR AAC017 =#{OBJS_AAC017} OR AAC024 =#{OBJS_AAC024} OR AAC005 =#{OBJS_AAC005} OR AAC033 =#{OBJS_AAC033})");
			addCodetions(corpPostion, filter, "AAD004");// 性别
			addCodetions(corpPostion, filter, "AAC011");// 文化程度
			addCodetions(corpPostion, filter, "AAC009");// 户口性质
			addCodetions(corpPostion, filter, "AAC017");// 婚姻状况
			addCodetions(corpPostion, filter, "AAC024");// 政治面貌
			addCodetions(corpPostion, filter, "AAC005");// 民族
			addCodetions(corpPostion, filter, "AAC033");// 健康状况
			break;
		case "5":
			// 年龄段条件符合
			boolean acb221Flag = StringUtil.isEmpty(String.valueOf(corpPostion
					.get("ACB221")));
			boolean acb222Flag = StringUtil.isEmpty(String.valueOf(corpPostion
					.get("ACB222")));
			if (acb221Flag || acb222Flag) {
				matchSql.append(" AND ( ");
				if (acb221Flag) {
					matchSql.append(" AGE >= #{OBJS_ACB221}");
					addCodetions(corpPostion, filter, "ACB221");// 最低年龄
				}
				if (acb222Flag) {
					matchSql.append(" AGE <= #{OBJS_ACB222}");
					addCodetions(corpPostion, filter, "ACB222");// 最高年龄
				}
				matchSql.append(" ) ");
			}
			break;
		default:
			break;
		}
		return matchSql.toString();
	}

	public static CorpMatchingDetailEnum getName(String value) {
		CorpMatchingDetailEnum personStaEnum = null;
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
			personStaEnum = mainconditions;
			break;
		case "4":
			personStaEnum = otherconditions;
			break;
		case "5":
			personStaEnum = ageconditions;
			break;
		default:
			break;
		}
		return personStaEnum;
	}
}
