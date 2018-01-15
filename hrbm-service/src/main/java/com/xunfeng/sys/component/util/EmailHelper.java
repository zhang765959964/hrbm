package com.xunfeng.sys.component.util;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import com.xunfeng.core.encrypt.EncryptUtil;
import com.xunfeng.core.util.TimeUtil;
import com.xunfeng.core.web.util.RequestUtil;
import com.xunfeng.sys.accounts.model.Accounts;
import com.xunfeng.sys.accounts.service.AccountsService;
import com.xunfeng.sys.config.model.BaseConfig;
import com.xunfeng.sys.config.service.BaseConfigService;


public class EmailHelper {
	@Resource
	private AccountsService accountsService;
	@Resource
    private BaseConfigService baseConfigService;
	@Resource
    private Properties configproperties;
    //SMTP服务器地址
    private String smtp_servers;
    //发信人邮件地址
    private String smtp_from;
    //SMTP服务帐户名
    private String smtp_username;
   // SMTP服务密码
    private String smtp_password;
    //SMTP 端口
    private String smtp_port;
    //邮件发送方式
    private String smtp_method;
    //邮箱认证过期时间,以小时为单位
    private String auth_email_time;
    //网站标题
    private String websiteTitle;


    public void init(){
        List<BaseConfig> configs = baseConfigService.getEmailConfig();
        for(BaseConfig config:configs){
            String value =   config.getCaos04();
            if(config.getCaos02().equals("smtp_servers")){
                smtp_servers=value;
            }else if(config.getCaos02().equals("smtp_from")) {
                smtp_from=value;
            }else if(config.getCaos02().equals("smtp_username")) {
                smtp_username=value;
            }else if(config.getCaos02().equals("smtp_password")) {
                smtp_password=value;
            }else if(config.getCaos02().equals("smtp_port")) {
                smtp_port=value;
            }else if(config.getCaos02().equals("smtp_method")) {
                smtp_method=value;
            }
        }
    }
    public void initAuthEmailTime(){
        BaseConfig authEmailTime = baseConfigService.getAuthEmailTime();
        auth_email_time = authEmailTime.getCaos04();
        BaseConfig bs = baseConfigService.getConfigByName("website_title");
        websiteTitle = bs.getCaos04();
    }

    /**
     * 发送邮件
     * @param id
     * @param to
     */
     public void run(Long id,String to,Accounts loginUser,String contextPath) {
         init();
         initAuthEmailTime();
         //同时把邮箱是否已经激活的标示制成0
         loginUser.setCcmu08(to);
         loginUser.setCcmu12(0l);
         accountsService.update(loginUser);
        try{
            Properties prop = new Properties();
            prop.setProperty("mail.host", smtp_servers);
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");

            MyAuthenticator auther = new MyAuthenticator(smtp_username, smtp_password);
            Session session = Session.getDefaultInstance(prop, auther);
            Transport ts = session.getTransport();
            Message message = createEmail(session,id,to,contextPath);
            Transport.send(message);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 建立邮件
     */
    public Message createEmail(Session session,Long id,String to,String contextPath) throws Exception{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(smtp_from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(websiteTitle+"邮件认证");
        String info =  getInfo(id,contextPath);
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
    }
    /**
     *   要发送的信息
     *   此处可以定义一个模板信息，从数据库中进行读取
     */

    public String getInfo(Long id,String contextPath) throws Exception{
    	HttpServletRequest	request = RequestUtil.getHttpServletRequest();
    	//String contextPath="http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath();
        String url = contextPath+"/email/pr/activate-validate?code="+generateValidate(id);
        String info = websiteTitle + "<br/>亲爱的用户："
        		+ "<br/>请在"+auth_email_time+"小时内，点击下面的链接完成邮箱验证："
        		+"<br/> <a href=\""+url+"\">"+url+"</a>";
        return info;
    }


    /**
     * 生成验证规则：时间|额外信息|账号ID
     *
     */
    public String generateValidate(Long id) throws Exception{
        String time = TimeUtil.getDateTimeString(new Date(), "yyyy-MM-dd HH:mm:ss");
        String salt = "xf";
        String result = EncryptUtil.encrypt(time + "|" + salt + "|" + id);
        return result;
    }

    /**
     * 解析验证规则
     */
    public  Object decrypt (String message){
        initAuthEmailTime();
        String result = null;
        Calendar now = null;
        Calendar before =null;
        String[] results = null;
        Object resultSet = 0L;
        try{
            result = EncryptUtil.decrypt(message);
            results=  result.split("\\|");
            now= Calendar.getInstance();
            now.add(Calendar.HOUR_OF_DAY,-Integer.parseInt(auth_email_time));
            before = Calendar.getInstance();
            before.setTime(TimeUtil.convertString(results[0], "yyyy-MM-dd HH:mm:ss"));
        }catch (Exception e){
            throw new RuntimeException("验证码有误");
        }
        if(now.after(before)){
            //throw new RuntimeException("验证已经过期");
        	resultSet = 0L;
        }else{
        	resultSet = results[2];
        }
        return resultSet;
    }
    /**
     * 发送邮件 找回密码 
     * 2016-08-27
     * @param to 
     * @param contextPath 
     */
     public void run(String to,String contextPath) {
    	 init();
         initAuthEmailTime();
        try{
            Properties prop = new Properties();
            prop.setProperty("mail.host", smtp_servers);
            prop.setProperty("mail.transport.protocol", "smtp");
            prop.setProperty("mail.smtp.auth", "true");

            MyAuthenticator auther = new MyAuthenticator(smtp_username, smtp_password);
            Session session = Session.getDefaultInstance(prop, auther);
            Transport ts = session.getTransport();
            Message message = createEmail(session,to,contextPath);
            Transport.send(message);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
     }
     /**
      * 建立邮件(找回密码)
      * 2016-08-27
      */
     public Message createEmail(Session session,String to,String contextPath) throws Exception{
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(smtp_from));
         message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
         message.setSubject(websiteTitle+"找回密码");
         String info =  getInfo(to,contextPath);
         message.setContent(info, "text/html;charset=UTF-8");
         message.saveChanges();
         return message;
     }
     /**
      * 要发送的信息(找回密码)
      * 2016-08-27
      */

     public String getInfo(String to,String contextPath) throws Exception{
         String url = contextPath+"/web/guest/lookforpwd?code="+generateValidate(to);
         String info = websiteTitle + "<br/>亲爱的用户："
         		+ "<br/>请在"+auth_email_time+"小时内，点击下面的链接完成找回密码操作："
         		+"<br/> <a href=\""+url+"\">"+url+"</a>";
         return info;
     }
     /**
      * 生成验证规则：时间|额外信息|账号ID
      *
      */
     public String generateValidate(String id) throws Exception{
         String time = TimeUtil.getDateTimeString(new Date(), "yyyy-MM-dd HH:mm:ss");
         String salt = "xf";
         String result = EncryptUtil.encrypt(time + "|" + salt + "|" + id);
         return result;
     }
    public static void main(String[] args)throws Exception{
       /*  Calendar now = Calendar.getInstance();
        System.out.println( TimeUtil.getDateTimeString(now.getTime(), "yyyy-MM-dd HH:mm:ss"));
        now.add(Calendar.HOUR_OF_DAY,-25);
        System.out.println( TimeUtil.getDateTimeString(now.getTime(), "yyyy-MM-dd HH:mm:ss"));
       Calendar before =Calendar.getInstance();
        before.setTime(TimeUtil.convertString("2015-08-06 16:30:39","yyyy-MM-dd HH:mm:ss"));
        System.out.println(now.after(before));*/


    }
}
