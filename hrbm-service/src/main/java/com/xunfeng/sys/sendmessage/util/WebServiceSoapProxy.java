package com.xunfeng.sys.sendmessage.util;

public class WebServiceSoapProxy implements WebServiceSoap {
  private String _endpoint = null;
  private WebServiceSoap webServiceSoap = null;
  
  public WebServiceSoapProxy() {
    _initWebServiceSoapProxy();
  }
  
  public WebServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceSoapProxy();
  }
  
  private void _initWebServiceSoapProxy() {
    try {
      webServiceSoap = (new WebServiceLocator()).getWebServiceSoap();
      if (webServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webServiceSoap != null)
      ((javax.xml.rpc.Stub)webServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WebServiceSoap getWebServiceSoap() {
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap;
  }
  
  public java.lang.String sendSMS(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.sendSMS(sn, pwd, mobile, content);
  }
  
  public java.lang.String sendSMS_R(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.sendSMS_R(sn, pwd, mobile, content, rrid);
  }
  
  public java.lang.String sendSMSEx(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String subcode) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.sendSMSEx(sn, pwd, mobile, content, subcode);
  }
  
  public java.lang.String sendSMSEx_R(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String subcode, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.sendSMSEx_R(sn, pwd, mobile, content, subcode, rrid);
  }
  
  public java.lang.String unRegister(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.unRegister(sn, pwd);
  }
  
  public java.lang.String chargUp(java.lang.String sn, java.lang.String pwd, java.lang.String cardno, java.lang.String cardpwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.chargUp(sn, pwd, cardno, cardpwd);
  }
  
  public java.lang.String getBalance(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.getBalance(sn, pwd);
  }
  
  public java.lang.String getStatus(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.getStatus(sn, pwd);
  }
  
  public java.lang.String getCode(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.getCode(sn, pwd);
  }
  
  public java.lang.String UDPPwd(java.lang.String sn, java.lang.String pwd, java.lang.String newpwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.UDPPwd(sn, pwd, newpwd);
  }
  
  public java.lang.String UDPSIGN(java.lang.String sn, java.lang.String pwd, java.lang.String sign) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.UDPSIGN(sn, pwd, sign);
  }
  
  public java.lang.String UDPSIGNEX(java.lang.String sn, java.lang.String pwd, java.lang.String subcode, java.lang.String sign, java.lang.String comName) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.UDPSIGNEX(sn, pwd, subcode, sign, comName);
  }
  
  public MOBody[] RECSMS(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.RECSMS(sn, pwd);
  }
  
  public MOBody[] RECSMSEx(java.lang.String sn, java.lang.String pwd, java.lang.String subcode) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.RECSMSEx(sn, pwd, subcode);
  }
  
  public MOBody[] RECSMS_UTF8(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.RECSMS_UTF8(sn, pwd);
  }
  
  public MOBody[] RECSMSEx_UTF8(java.lang.String sn, java.lang.String pwd, java.lang.String subcode) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.RECSMSEx_UTF8(sn, pwd, subcode);
  }
  
  public java.lang.String register(java.lang.String sn, java.lang.String pwd, java.lang.String province, java.lang.String city, java.lang.String trade, java.lang.String entname, java.lang.String linkman, java.lang.String phone, java.lang.String mobile, java.lang.String email, java.lang.String fax, java.lang.String address, java.lang.String postcode, java.lang.String sign) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.register(sn, pwd, province, city, trade, entname, linkman, phone, mobile, email, fax, address, postcode, sign);
  }
  
  public java.lang.String getFlag(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.getFlag(sn, pwd);
  }
  
  public java.lang.String SMSTest(java.lang.String sn, java.lang.String pwd, java.lang.String mobile) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.SMSTest(sn, pwd, mobile);
  }
  
  public java.lang.String testCode(java.lang.String content, java.lang.String code, java.lang.String type) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.testCode(content, code, type);
  }
  
  public RegistryInfo getAllInfo(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.getAllInfo(sn, pwd);
  }
  
  public RegistryInfo2 getAllInfo2(java.lang.String sn, java.lang.String pwd, java.lang.String ver, java.lang.String oem) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.getAllInfo2(sn, pwd, ver, oem);
  }
  
  public double setGaoDuan(java.lang.String sn, java.lang.String pwd, java.lang.String gd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.setGaoDuan(sn, pwd, gd);
  }
  
  public java.lang.String getGaoDuan(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.getGaoDuan(sn, pwd);
  }
  
  public java.lang.String mt(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mt(sn, pwd, mobile, content, ext, stime, rrid);
  }
  
  public java.lang.String mdSmsSend(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdSmsSend(sn, pwd, mobile, content, ext, stime, rrid);
  }
  
  public java.lang.String mdSmsSend_u(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdSmsSend_u(sn, pwd, mobile, content, ext, stime, rrid);
  }
  
  public java.lang.String mdSmsSend_DES(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdSmsSend_DES(sn, pwd, mobile, content, ext, stime, rrid);
  }
  
  public java.lang.String mdSmsSend_AES(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdSmsSend_AES(sn, pwd, mobile, content, ext, stime, rrid);
  }
  
  public java.lang.String mdSmsSend_g(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdSmsSend_g(sn, pwd, mobile, content, ext, stime, rrid);
  }
  
  public java.lang.String mo(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mo(sn, pwd);
  }
  
  public java.lang.String mo2(java.lang.String sn, java.lang.String pwd, int maxID) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mo2(sn, pwd, maxID);
  }
  
  public java.lang.String report(java.lang.String sn, java.lang.String pwd, long maxid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.report(sn, pwd, maxid);
  }
  
  public java.lang.String report2(java.lang.String sn, java.lang.String pwd, long maxid, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.report2(sn, pwd, maxid, rrid);
  }
  
  public java.lang.String report2DES(java.lang.String sn, java.lang.String pwd, long maxid, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.report2DES(sn, pwd, maxid, rrid);
  }
  
  public java.lang.String msgid(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.msgid(sn, pwd);
  }
  
  public java.lang.String balance(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.balance(sn, pwd);
  }
  
  public java.lang.String gxmt(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.gxmt(sn, pwd, mobile, content, ext, stime, rrid);
  }
  
  public java.lang.String fileMT(java.lang.String sn, java.lang.String pwd, java.lang.String fname, java.lang.String rrid, int sort, int total, int ftype, java.lang.String content) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.fileMT(sn, pwd, fname, rrid, sort, total, ftype, content);
  }
  
  public java.lang.String mmsFileMT(java.lang.String sn, java.lang.String pwd, java.lang.String rrid, java.lang.String content) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mmsFileMT(sn, pwd, rrid, content);
  }
  
  public java.lang.String mdMmsSend(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String stime) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdMmsSend(sn, pwd, title, mobile, content, stime);
  }
  
  public java.lang.String mdMmsSend_ex(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String stime, java.lang.String ext) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdMmsSend_ex(sn, pwd, title, mobile, content, stime, ext);
  }
  
  public java.lang.String mdMmsSend_uex(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String stime, java.lang.String ext) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdMmsSend_uex(sn, pwd, title, mobile, content, stime, ext);
  }
  
  public java.lang.String mdMmsSendF(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String stime) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdMmsSendF(sn, pwd, mobile, content, stime);
  }
  
  public java.lang.String mdAudioSend(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String txt, java.lang.String content, java.lang.String srcnumber, java.lang.String stime) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdAudioSend(sn, pwd, title, mobile, txt, content, srcnumber, stime);
  }
  
  public java.lang.String mdFaxSend(java.lang.String sn, java.lang.String pwd, java.lang.String title, java.lang.String mobile, java.lang.String content, java.lang.String srcnumber, java.lang.String stime) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdFaxSend(sn, pwd, title, mobile, content, srcnumber, stime);
  }
  
  public java.lang.String mdMmsReceive(java.lang.String sn, java.lang.String pwd) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mdMmsReceive(sn, pwd);
  }
  
  public java.lang.String mongateCsSpSendSmsNew(java.lang.String userId, java.lang.String password, java.lang.String pszMobis, java.lang.String pszMsg, int iMobiCount, java.lang.String pszSubPort) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mongateCsSpSendSmsNew(userId, password, pszMobis, pszMsg, iMobiCount, pszSubPort);
  }
  
  public java.lang.String[] mongateCsGetSmsExEx(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mongateCsGetSmsExEx(userId, password);
  }
  
  public java.lang.String[] mongateCsGetStatusReportExEx(java.lang.String userId, java.lang.String password) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.mongateCsGetStatusReportExEx(userId, password);
  }
  
  public java.lang.String bianliang(java.lang.String sn, java.lang.String pwd, java.lang.String mobile, java.lang.String content, java.lang.String ext, java.lang.String stime, java.lang.String rrid, java.lang.String bcode) throws java.rmi.RemoteException{
    if (webServiceSoap == null)
      _initWebServiceSoapProxy();
    return webServiceSoap.bianliang(sn, pwd, mobile, content, ext, stime, rrid, bcode);
  }
  
  
}