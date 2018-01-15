package com.xunfeng.core.enumeration;

/**
 * 个人信息统计人员细类表
 * 
 * @author Administrator
 *
 */
public enum PersonStaEnum {
	all("全部", "", "",""), sex("性别", "1", "AAC004","AAC004"), nation("民族", "2",
			"AAC005","AAC005"), education("文化程度", "3", "AAC011","AAC011"), residence(
			"户口性质", "4", "AAC009","AAC009"), political("政治面貌", "5", "AAC024","AAC024"), marriage(
			"婚姻状况", "6", "AAC017","AAC017");

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

	private PersonStaEnum(String name, String value, String tableColumn,String tableColumnName) {
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

	public static PersonStaEnum getValue(String value) {
		PersonStaEnum personStaEnum = null;
		switch (value) {
		case "":
			personStaEnum = all;
			break;
		case "1":
			personStaEnum = sex;
			break;
		case "2":
			personStaEnum = nation;
			break;
		case "3":
			personStaEnum = education;
			break;
		case "4":
			personStaEnum = residence;
			break;
		case "5":
			personStaEnum = political;
			break;
		case "6":
			personStaEnum = marriage;
			break;
		default:
			personStaEnum = all;
			break;
		}
		return personStaEnum;
	}

	public static PersonStaEnum getName(String value) {
		PersonStaEnum personStaEnum = null;
		switch (value) {
		case "":
			personStaEnum = all;
			break;
		case "1":
			personStaEnum = sex;
			break;
		case "2":
			personStaEnum = nation;
			break;
		case "3":
			personStaEnum = education;
			break;
		case "4":
			personStaEnum = residence;
			break;
		case "5":
			personStaEnum = political;
			break;
		case "6":
			personStaEnum = marriage;
			break;
		default:
			personStaEnum = all;
			break;
		}
		return personStaEnum;
	}
}
