package com.xunfeng.core.util;

/**
 * Created by Administrator on 2015/12/23.
 */
public class PassWordUtil {

    public static int getPassWordStrongLevel(String passWord){


        boolean strongRegex=passWord.matches("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$");
        boolean mediumRegex=passWord.matches("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$");
        if(strongRegex){
            return 2;
        }else if(mediumRegex){
            return 1;
        }else{
            return 0;
        }
    }
}
