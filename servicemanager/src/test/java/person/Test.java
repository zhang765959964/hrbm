//package person;
//
//import com.xunfeng.core.enumeration.BaseEnum;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * Created by Administrator on 2015/8/7.
// */
//public class Test {
//
//    public static void main(String[] arg)throws Exception{
//
//        System.out.println(parseEnum("com.xunfeng.business.person.enumeration.LanguageEnum"));
//
//    }
//    public static Map<String, String> parseEnum(String clazz)
//            throws Exception {
//
//
//        Class<?> ref = forName(clazz) ;
//
//        if(null == ref){
//            throw new ClassNotFoundException(String.format("%s class not fond ", clazz));
//        }
//
//
//        Map<String, String> map = new LinkedHashMap<String, String>();
//        if (ref.isEnum()) {
//            Object[] ts = ref.getEnumConstants();
//            for (Object t : ts) {
//                BaseEnum e = (BaseEnum) t;
//                map.put(e.getCode(), e.getName());
//            }
//        }
//        return map;
//    }
//
//    static Class<?> forName(String className) throws Exception{
//        String[]packageNames = className.split("\\.") ;
//        String tempClassName = "" ;
//        Class<?> returnClazz = null ;
//        for(String packageName : packageNames){
//            tempClassName += packageName ;
//            if(fristCharIsUpper(packageName)){
//                if( null == returnClazz){
//                    try{
//                        returnClazz = Class.forName( tempClassName);
//                    }catch(Exception e){}
//                }else {
//                    Class<?> classes[]=returnClazz.getDeclaredClasses();
//                    for(Class<?> tempClazz : classes){
//                        if(tempClazz.getSimpleName().equals(packageName)){
//                            returnClazz = tempClazz ;
//                        }
//                    }
//                }
//            }
//            tempClassName += "." ;
//        }
//        return returnClazz ;
//    }
//
//    static boolean fristCharIsUpper(String name){
//        if(null != name && name.length() >0){
//            char[]chars = name.toCharArray() ;
//            int intChar = (int)chars[0] ;
//            return  intChar <= 90 && intChar >= 65 ;
//        }
//        return false ;
//    }
//}
