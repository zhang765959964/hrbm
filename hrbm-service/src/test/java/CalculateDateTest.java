import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author Administrator
 *
 */
public class CalculateDateTest {  
      
    public static void main(String[] args) { 
    	String str=",河南昌通汽配制造有限公司,,\"企业\",有限责任（公司）,制造业,王晓鹏,4101812100843,\"41,361,184,134,148\",巩义市,,,区县属以下,王晓鹏,410124197407156512,其他,其它,2011/9/27,超级管理员,登记在册,";
    	 		Pattern p=Pattern.compile("\"(.*?)\"");
    			Matcher matcher = p.matcher(str);

    			while (matcher.find()){
				
    				System.out.println(matcher.group());
    				str=str.replaceAll(matcher.group(), matcher.group().replace(",", "xfmatch"))	;		
				}
    			System.out.println(str);
   //        DateCalculate dateCalculate = DateCalculate.calculate("2011/03/17", "2012/02/13");  
//        System.out.println("月差为: " + dateCalculate.getDifferenceOfMonths());  
//        System.out.println("天差为: " + dateCalculate.getDifferenceOfDays());  
//        System.out.println();  
//          
//        dateCalculate = DateCalculate.calculate("2011/03/30", "2011/04/13");  
//        System.out.println("月差为: " + dateCalculate.getDifferenceOfMonths());  
//        System.out.println("天差为: " + dateCalculate.getDifferenceOfDays());  
//        System.out.println();  
//          
//        dateCalculate = DateCalculate.calculate("2011/03/31", "2011/04/13");  
//        System.out.println("月差为: " + dateCalculate.getDifferenceOfMonths());  
//        System.out.println("天差为: " + dateCalculate.getDifferenceOfDays());  
//        System.out.println();  
//          
//        dateCalculate = DateCalculate.calculate("2011/03/17", "2011/04/18");  
//        System.out.println("月差为: " + dateCalculate.getDifferenceOfMonths());  
//        System.out.println("天差为: " + dateCalculate.getDifferenceOfDays());  
//        System.out.println();  
//          
//        dateCalculate = DateCalculate.calculate("2011/03/17", "2012/01/13");  
//        System.out.println("月差为: " + dateCalculate.getDifferenceOfMonths());  
//        System.out.println("天差为: " + dateCalculate.getDifferenceOfDays());  
//        System.out.println();  
//          
//        dateCalculate = DateCalculate.calculate("2011/03/31", "2012/03/13");  
//        System.out.println("月差为: " + dateCalculate.getDifferenceOfMonths());  
//        System.out.println("天差为: " + dateCalculate.getDifferenceOfDays());  
//        System.out.println();  
//          
//        dateCalculate = DateCalculate.calculate("2011/03/31", "2012/05/13");  
//        System.out.println("月差为: " + dateCalculate.getDifferenceOfMonths());  
//        System.out.println("天差为: " + dateCalculate.getDifferenceOfDays());  
//        System.out.println();  
          
    }  
  
}  
  
/** 
 * @author lxbccsu 
 *日期比较差值不包括起始日期,包括最后日期 
 */  
class DateCalculate{  
      
    private long differenceOfMonths;//月份差值  
    private long differenceOfDays;//天数差值  
      
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");  
      
    public static DateCalculate calculate(String startdate, String endDate){  
        try {  
            return calculate(dateFormat.parse(startdate),dateFormat.parse(endDate));  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    /** 
     * 计算差值,注意 endDate > startDate 
     * @param startDate 
     * @param endDate 
     * @return 
     */  
    public static DateCalculate calculate(Date startDate, Date endDate){  
        if(startDate.after(endDate)) return null;  
        System.out.println("开始日：" + dateFormat.format(startDate) + ", 结束日: "+ dateFormat.format(endDate));  
        DateCalculate dataCalculate = new DateCalculate();  
          
        Calendar firstDay = Calendar.getInstance();  
        Calendar lastDay = Calendar.getInstance();  
        firstDay.setTime(startDate);  
        lastDay.setTime(endDate);  
          
        //算出天数总差值  
        long allDays = ((lastDay.getTimeInMillis()) - (firstDay.getTimeInMillis()))/(1000*24*60*60);  
  
        Calendar loopEndDay = calculateLoopEndOfDate(firstDay,lastDay);  
        System.out.println("循环终止日期 : " + dateFormat.format(loopEndDay.getTime()));  
          
        dataCalculate.setDifferenceOfDays(0);  
        dataCalculate.setDifferenceOfMonths(0);  
          
        int month = firstDay.get(Calendar.MONTH);  
        while(!firstDay.equals(loopEndDay)){  
            firstDay.add(Calendar.DAY_OF_MONTH, 1);  
            allDays--;  
            if(month != firstDay.get(Calendar.MONTH)){  
                month = firstDay.get(Calendar.MONTH);  
                dataCalculate.setDifferenceOfMonths(dataCalculate.getDifferenceOfMonths()+1);  
            }  
        }  
        dataCalculate.setDifferenceOfDays(allDays);  
        return dataCalculate;  
          
    }  
  
    /** 
     * 计算循环终止日期 
     * 例如:开始日：2011/03/17    结束日 2012/02/13 ,循环终止日期 2012/01/17; 
     * @param startDate 
     * @param endDate 
     * @return 
     */  
    private static Calendar calculateLoopEndOfDate(Calendar startDate, Calendar endDate) {  
        int year = endDate.get(Calendar.YEAR);  
        int month = endDate.get(Calendar.MONTH);  
        int day = startDate.get(Calendar.DAY_OF_MONTH);  
        int maxDaysInMonth = getMaxDaysOfMonth(new GregorianCalendar(year,month,1));  
          
        if(year > startDate.get(Calendar.YEAR)){  
            if(month == Calendar.JANUARY){  
                year -= 1;  
                month = Calendar.DECEMBER;  
            }else{  
                if(day > maxDaysInMonth){  
                    month -= 1;  
                    endDate.set(year, month, 1);  
                    day = getMaxDaysOfMonth(new GregorianCalendar(year,month,1));  
                }else{  
                    if(day > endDate.get(Calendar.DAY_OF_MONTH)){  
                        month -= 1;  
                        endDate.set(year, month, 1);  
                        maxDaysInMonth = getMaxDaysOfMonth(new GregorianCalendar(year,month,1));;  
                        if(day > maxDaysInMonth){  
                            day = maxDaysInMonth;  
                        }  
                    }  
                }  
            }  
        }else{  
            if(day > maxDaysInMonth){  
                month -= 1;  
                endDate.set(year, month, 1);  
                day = getMaxDaysOfMonth(new GregorianCalendar(year,month,1));  
            }else{  
                if(day > endDate.get(Calendar.DAY_OF_MONTH)){  
                    month -= 1;  
                    endDate.set(year, month, 1);  
                    maxDaysInMonth = getMaxDaysOfMonth(new GregorianCalendar(year,month,1));  
                    if(day > maxDaysInMonth){  
                        day = maxDaysInMonth;  
                    }  
                }  
            }  
        }  
          
        return new GregorianCalendar(year, month, day);  
    }  
  
    /** 
     * 获取一月最大天数,考虑年份是否为润年 
     * (对API中的 getMaximum(int field)不了解, date.getMaximum(Calendar.DAY_OF_MONTH)却不是月份的最大天数) 
     * @param date 
     * @return 
     */  
    private static int getMaxDaysOfMonth(GregorianCalendar date) {  
        int month = date.get(Calendar.MONTH);  
        int maxDays  = 0;  
        switch(month){  
            case Calendar.JANUARY:  
            case Calendar.MARCH:  
            case Calendar.MAY:  
            case Calendar.JULY:  
            case Calendar.AUGUST:  
            case Calendar.OCTOBER:  
            case Calendar.DECEMBER:  
            maxDays = 31;  
            break;  
            case Calendar.APRIL:  
            case Calendar.JUNE:  
            case Calendar.SEPTEMBER:  
            case Calendar.NOVEMBER:  
            maxDays = 30;  
            break;  
            case Calendar.FEBRUARY:  
            if(date.isLeapYear(date.get(Calendar.YEAR))){  
                maxDays = 29;  
            }else{  
                maxDays = 28;  
            }  
            break;  
        }  
        return maxDays;  
    }  
  
    public long getDifferenceOfMonths() {  
        return differenceOfMonths;  
    }  
  
    public void setDifferenceOfMonths(long differenceOfmonths) {  
        this.differenceOfMonths = differenceOfmonths;  
    }  
  
    public long getDifferenceOfDays() {  
        return differenceOfDays;  
    }  
  
    public void setDifferenceOfDays(long differenceOfDays) {  
        this.differenceOfDays = differenceOfDays;  
    }  
}  
