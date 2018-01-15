package com.xunfeng.sys.setMeal.emunMeal;

public enum MealTypeEmun {
	/*1	101	现场招聘会(场)	100	1	30	1	1	超级管理员	2015/6/29 18:34:44	1	人力资源市场	
	2	102	短信通知(条)	0.5	1	50	1	1	超级管理员	2015/6/29 18:36:24	1	人力资源市场	
	3	103	职位刷新(次)	30	1	30	1	1	超级管理员	2015/6/29 18:37:24	1	人力资源市场	
	4	104	职位置顶(次)	50	1	30	1	1	超级管理员	2015/6/29 18:37:50	1	人力资源市场	
	5	105	热点招聘栏(天)	150	1	30	0	1	超级管理员	2015/6/29 18:38:25	1	人力资源市场	
	6	106	简历数(份)	5	1	30	0	1	超级管理员	2015/6/29 18:39:11	1	人力资源市场	
	7	107	人才库(条)	3	1	30	0	1	超级管理员	2015/6/29 18:39:49	1	人力资源市场	
	8	108	发布职位数(次)	50	1	30	0	1	超级管理员	2015/6/29 18:40:40	1	人力资源市场	
	9	109	首页广告位(328*60)	200	1	30	1	1	超级管理员	2015/6/29 18:41:32	1	人力资源市场	
	10	110	首页广告位(245*69)	300	1	30	1	1	超级管理员	2015/6/29 18:42:07	1	人力资源市场	
	11	111	二级广告位(247*72)	150	1	30	1	1	超级管理员	2015/6/29 18:42:37	1	人力资源市场	*/
	/*12	112	急聘职位(247*72)	150	1	30	1	1	超级管理员	2015/6/29 18:42:37	1	人力资源市场	
	12	113	推荐企业(247*72)	150	1	30	1	1	超级管理员	2015/6/29 18:42:37	1	人力资源市场	
	12	114	品牌企业(247*72)	150	1	30	1	1	超级管理员	2015/6/29 18:42:37	1	人力资源市场	*/
	
	FAIRSITE("现场招聘会", "101"), MESSAGE("短信通知", "102"), REFRESHJOB("职位刷新", "103"), 
	HOTJOB("热点招聘栏", "105"),	RESUME("简历数", "106"), TALENTPEOPLE("人才库", "107"), 
	POSITION("发布职位数", "108"),INDEXADONE("首页广告位(328*60)", "109"), 
	INDEXADTHREE("首页广告位(245*69)", "110"),  SENDAD("二级广告位(247*72)", "111"),
	SENIORJOB("急聘职位", "112"),  RECCORP("推荐企业", "113"), 
	BRANDCORP("品牌企业", "114"),CENTERAD("首页中部广告", "115");
    // 成员变量
    private String name;
    private String code;

    // 构造方法
    private MealTypeEmun(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // 普通方法
    public static String getName(String code) {
        for (MealTypeEmun c : MealTypeEmun.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }
    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
