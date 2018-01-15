package com.xunfeng.sys.component.util;

import javax.mail.PasswordAuthentication;

/**
 * Created by wxl on 2015/7/24.
 */
public class MyAuthenticator extends javax.mail.Authenticator {
    String userName=null;
    String password=null;

    public MyAuthenticator(){
    }
    public MyAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }
    protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(userName, password);
    }
}
