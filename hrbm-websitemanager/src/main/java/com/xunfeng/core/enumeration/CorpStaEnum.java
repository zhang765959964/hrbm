package com.xunfeng.core.enumeration;

/**
 * 单位信息统计细类表
 * 
 * @author Administrator
 *
 */
public enum CorpStaEnum {
	all("无", "", "",""), 
	nature("单位性质", "1", "AAB019","AAB019"), 
	economytype("经济类型", "2","AAB020","AAB020"), 
	industrytype("行业类型", "3", "AAB022","AAB022"),
	industrycategories( "产业类别", "4", "AAB054","AAB054"), 
	personnelsize("人员规模", "5", "AAB056","AAB056");

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

	private CorpStaEnum(String name, String value, String tableColumn,String tableColumnName) {
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

	public static CorpStaEnum getValue(String value) {
		CorpStaEnum personStaEnum = null;
		switch (value) {
		case "":
			personStaEnum = all;
			break;
		case "1":
			personStaEnum = nature;
			break;
		case "2":
			personStaEnum = economytype;
			break;
		case "3":
			personStaEnum = industrytype;
			break;
		case "4":
			personStaEnum = industrycategories;
			break;
		case "5":
			personStaEnum = personnelsize;
			break;
		default:
			personStaEnum = all;
			break;
		}
		return personStaEnum;
	}

	public static CorpStaEnum getName(String value) {
		CorpStaEnum personStaEnum = null;
		switch (value) {
		case "":
			personStaEnum = all;
			break;
		case "1":
			personStaEnum = nature;
			break;
		case "2":
			personStaEnum = economytype;
			break;
		case "3":
			personStaEnum = industrytype;
			break;
		case "4":
			personStaEnum = industrycategories;
			break;
		case "5":
			personStaEnum = personnelsize;
			break;
		default:
			personStaEnum = all;
			break;
		}
		return personStaEnum;
	}
}
