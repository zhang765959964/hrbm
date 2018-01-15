/**
 * WebServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xunfeng.sys.sendmessage.util;

public interface WebServiceSoap extends java.rmi.Remote {

    /**
     * 发送短信：sn软件序列号;pwd序列号密码;mobile手机号列表，以逗号,隔开;content发送内容
     */
    public java.lang.String sendSMS(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content) throws java.rmi.RemoteException;

    /**
     * 发送短信：sn软件序列号;pwd序列号密码;mobile手机号列表，以逗号,隔开;content发送内容;rrid唯一标识,全数字
     */
    public java.lang.String sendSMS_R(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 发送短信（可扩展）：sn软件序列号;pwd序列号密码;mobile手机号列表，以逗号,隔开;content发送内容;subcode最长9位数字扩展码
     */
    public java.lang.String sendSMSEx(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String subcode) throws java.rmi.RemoteException;

    /**
     * 发送短信（可扩展）：sn软件序列号;pwd序列号密码;mobile手机号列表，以逗号,隔开;content发送内容;subcode最长9位数字扩展码;rrid唯一标识,全数字
     */
    public java.lang.String sendSMSEx_R(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String subcode, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 注销：sn软件序列号;pwd序列号密码
     */
    public java.lang.String unRegister(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 充值：sn软件序列号;pwd序列号密码;cardno充值卡号;cardpwd充值卡密码
     */
    public java.lang.String chargUp(java.lang.String sn, java.lang.String pwd, java.lang.String cardno, java.lang.String cardpwd) throws java.rmi.RemoteException;

    /**
     * 获取余额：sn软件序列号;pwd序列号密码
     */
    public java.lang.String getBalance(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 获取软件序列号状态：sn软件序列号;pwd序列号密码
     */
    public java.lang.String getStatus(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 获取特服号：sn软件序列号;pwd序列号密码
     */
    public java.lang.String getCode(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 更改密码：sn软件序列号;pwd序列号密码;newpwd新密码
     */
    public java.lang.String UDPPwd(java.lang.String sn, java.lang.String pwd, java.lang.String newpwd) throws java.rmi.RemoteException;

    /**
     * 更改签名：sn软件序列号;pwd序列号密码;sign企业签名(2-15个字符)
     */
    public java.lang.String UDPSIGN(java.lang.String sn, java.lang.String pwd, java.lang.String sign) throws java.rmi.RemoteException;

    /**
     * 更改签名（网络版）：sn软件序列号;pwd序列号密码;sign企业签名(2-15个字符);subcode最长9位数字扩展码;comName企业全称
     */
    public java.lang.String UDPSIGNEX(java.lang.String sn, java.lang.String pwd, java.lang.String subcode, java.lang.String sign, java.lang.String comName) throws java.rmi.RemoteException;

    /**
     * 接收短信：sn软件序列号;pwd序列号密码。total_num为负数，表示操作失败
     */
    public MOBody[] RECSMS(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 网络版接收短信：sn软件序列号;pwd序列号密码;subcode子号码。total_num为负数，表示操作失败
     */
    public MOBody[] RECSMSEx(java.lang.String sn, java.lang.String pwd, java.lang.String subcode) throws java.rmi.RemoteException;

    /**
     * 接收短信utf-8编码：sn软件序列号;pwd序列号密码。total_num为负数，表示操作失败
     */
    public MOBody[] RECSMS_UTF8(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 网络版接收短信utf-8编码：sn软件序列号;pwd序列号密码;subcode子号码。total_num为负数，表示操作失败
     */
    public MOBody[] RECSMSEx_UTF8(java.lang.String sn, java.lang.String pwd, java.lang.String subcode) throws java.rmi.RemoteException;

    /**
     * 软件序列号注册：sn软件序列号;pwd序列号密码;province省;city城市;trade行业;entname企业名称;linkman联系人;phone联系电话;mobile移动电话;email邮件地址;fax传真;address地址;postcode邮政编码
     */
    public java.lang.String register(java.lang.String sn, java.lang.String pwd, java.lang.String province, java.lang.String city, java.lang.String trade, java.lang.String entname, java.lang.String linkman, java.lang.String phone, java.lang.String mobile, java.lang.String email, java.lang.String fax, java.lang.String address, java.lang.String postcode, java.lang.String sign) throws java.rmi.RemoteException;

    /**
     * 获取软件序列号子号码长度：sn软件序列号;pwd序列号密码
     */
    public java.lang.String getFlag(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 通道测试：sn软件序列号;pwd序列号密码;mobile手机号列表，最多20个，以逗号,隔开
     */
    public java.lang.String SMSTest(java.lang.String sn, java.lang.String pwd, java.lang.String mobile) throws java.rmi.RemoteException;

    /**
     * 编解码：content中文内容;code编解码类型;type，0编码1解码
     */
    public java.lang.String testCode(java.lang.String content, java.lang.String code, java.lang.String type) throws java.rmi.RemoteException;

    /**
     * 获取软件序列号参数：sn软件序列号;pwd序列号密码;
     */
    public RegistryInfo getAllInfo(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 获取软件序列号2参数：sn软件序列号;pwd序列号密码;
     */
    public RegistryInfo2 getAllInfo2(java.lang.String sn, java.lang.String pwd, java.lang.String ver, java.lang.String oem) throws java.rmi.RemoteException;

    /**
     * 设置高端发送：sn软件序列号;pwd序列号密码;gd参数1普通通道2高端通道;
     */
    public double setGaoDuan(java.lang.String sn, java.lang.String pwd, java.lang.String gd) throws java.rmi.RemoteException;

    /**
     * 获取高端发送：sn软件序列号;pwd序列号密码;
     */
    public java.lang.String getGaoDuan(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 发送短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字.返回:唯一标识
     */
    public java.lang.String mt(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 发送短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字.返回:唯一标识
     */
    public java.lang.String mdSmsSend(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 发送短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容utf-8编码;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字.返回:唯一标识
     */
    public java.lang.String mdSmsSend_u(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 发送短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容utf-8编码;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字.返回:唯一标识
     */
    public java.lang.String mdSmsSend_DES(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 发送短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容utf-8编码;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字.返回:唯一标识
     */
    public java.lang.String mdSmsSend_AES(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 发送短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字.返回:唯一标识
     */
    public java.lang.String mdSmsSend_g(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 接收短信：sn软件序列号;pwd加密密码md5(sn+password).[优先使用本接口]
     */
    public java.lang.String mo(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 接收短信：sn软件序列号;pwd加密密码md5(sn+password);maxID：上次接收最大id
     */
    public java.lang.String mo2(java.lang.String sn, java.lang.String pwd, int maxID) throws java.rmi.RemoteException;

    /**
     * 回执：sn软件序列号;pwd加密密码md5(sn+password);maxid最大id
     */
    public java.lang.String report(java.lang.String sn, java.lang.String pwd, long maxid) throws java.rmi.RemoteException;

    /**
     * 回执：sn软件序列号;pwd加密密码md5(sn+password);maxid最大id
     */
    public java.lang.String report2(java.lang.String sn, java.lang.String pwd, long maxid, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 回执：sn软件序列号;pwd加密密码md5(sn+password);maxid最大id
     */
    public java.lang.String report2DES(java.lang.String sn, java.lang.String pwd, long maxid, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 获取信息ID：sn软件序列号;pwd加密密码md5(sn+password)
     */
    public java.lang.String msgid(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 查询余额：sn软件序列号;pwd加密密码md5(sn+password)
     */
    public java.lang.String balance(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 个性短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容,GB2312编码,以逗号,隔开;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字.返回:唯一标识
     */
    public java.lang.String gxmt(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException;

    /**
     * 文件传输：sn软件序列号;pwd加密密码md5(sn+password);fname增值文件名;rrid第一个接口返回id;sort批次;total总次数;ftype类别1短信2彩信3语音4传真5邮件;content内容,base64编码.返回:rrid
     */
    public java.lang.String fileMT(java.lang.String sn, java.lang.String pwd, java.lang.String fname, java.lang.String rrid, int sort, int total, int ftype, java.lang.String content) throws java.rmi.RemoteException;

    /**
     * 彩信文件传输：sn软件序列号;pwd加密密码md5(sn+password);rrid第一个接口返回id;content内容,base64编码.返回:rrid
     */
    public java.lang.String mmsFileMT(java.lang.String sn, java.lang.String pwd, java.lang.String rrid, java.lang.String content) throws java.rmi.RemoteException;

    /**
     * 彩信发送：sn软件序列号;pwd加密密码md5(sn+password);title彩信主题;mobile手机号码,以英文逗号隔开;content内容,base64编码(文件名1,文件base64编码串;文件名2,文件base64编码串);stime定时时间2010-07-05
     * 17:37:00.返回:rrid
     */
    public java.lang.String mdMmsSend(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String stime) throws java.rmi.RemoteException;

    /**
     * 彩信发送：sn软件序列号;pwd加密密码md5(sn+password);title彩信主题;mobile手机号码,以英文逗号隔开;content内容,base64编码(文件名1,文件base64编码串;文件名2,文件base64编码串);stime定时时间2010-07-05
     * 17:37:00.返回:rrid
     */
    public java.lang.String mdMmsSend_ex(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String stime, java.lang.String ext) throws java.rmi.RemoteException;

    /**
     * 彩信发送：sn软件序列号;pwd加密密码md5(sn+password);title彩信主题;mobile手机号码,以英文逗号隔开;content内容,base64编码(文件名1,文件base64编码串utf8;文件名2,文件base64编码串utf8);stime定时时间2010-07-05
     * 17:37:00.返回:rrid
     */
    public java.lang.String mdMmsSend_uex(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String stime, java.lang.String ext) throws java.rmi.RemoteException;

    /**
     * 彩信发送：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号码,以英文逗号隔开;content内容,base64编码(zip文件base64编码串);stime定时时间2010-07-05
     * 17:37:00.返回:rrid
     */
    public java.lang.String mdMmsSendF(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String stime) throws java.rmi.RemoteException;

    /**
     * 语音发送：sn软件序列号;pwd加密密码md5(sn+password);title语音主题;mobile手机号码,以英文逗号隔开,为空表示语音合成请求;txt文本内容;content文件内容,base64编码(wav文件名,文件base64编码串);srcnumber源号码;stime定时时间2010-07-05
     * 17:37:00.返回:rrid
     */
    public java.lang.String mdAudioSend(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String txt, java.lang.String content, java.lang.String srcnumber, java.lang.String stime) throws java.rmi.RemoteException;

    /**
     * 传真发送：sn软件序列号;pwd加密密码md5(sn+password);title传真主题;mobile接收号码,以英文逗号隔开;content文件内容,base64编码(wav文件名,文件base64编码串);srcnumber发送号码;stime定时时间2010-07-05
     * 17:37:00.返回:rrid
     */
    public java.lang.String mdFaxSend(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String srcnumber, java.lang.String stime) throws java.rmi.RemoteException;

    /**
     * 彩信接收：sn软件序列号;pwd加密密码md5(sn+password).返回:彩信内容
     */
    public java.lang.String mdMmsReceive(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException;

    /**
     * 发送短信：userId软件序列号;password加密密码md5(sn+password);pszMobis手机号列表，以逗号,隔开;pszMsg发送内容utf-8编码;iMobiCount手机号数量;pszSubPort扩展子号.返回:唯一标识
     */
    public java.lang.String mongateCsSpSendSmsNew(java.lang.String userId, java.lang.String password, java.lang.String pszMobis, java.lang.String pszMsg, int iMobiCount, java.lang.String pszSubPort) throws java.rmi.RemoteException;

    /**
     * 接收短信：sn软件序列号;password加密密码md5(sn+password).
     */
    public java.lang.String[] mongateCsGetSmsExEx(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * 回执：sn软件序列号;password加密密码md5(sn+password)
     */
    public java.lang.String[] mongateCsGetStatusReportExEx(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * 发送变量短信：sn软件序列号;pwd加密密码md5(sn+password);mobile手机号列表，以逗号,隔开;content发送内容utf-8编码;ext扩展子号;stime定时时间,格式如2009-09-01
     * 18:21:00;rrid唯一标识,全数字;bcode变量编码.返回:唯一标识
     */
    public java.lang.String bianliang(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid, java.lang.String bcode) throws java.rmi.RemoteException;
}
