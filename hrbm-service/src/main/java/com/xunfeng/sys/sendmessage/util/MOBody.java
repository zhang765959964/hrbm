/**
 * MOBody.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.xunfeng.sys.sendmessage.util;

public class MOBody  implements java.io.Serializable {
    private java.lang.String total_num;

    private java.lang.String this_num;

    private java.lang.String recvtel;

    private java.lang.String sender;

    private java.lang.String content;

    private java.lang.String recdate;

    public MOBody() {
    }

    public MOBody(
           java.lang.String total_num,
           java.lang.String this_num,
           java.lang.String recvtel,
           java.lang.String sender,
           java.lang.String content,
           java.lang.String recdate) {
           this.total_num = total_num;
           this.this_num = this_num;
           this.recvtel = recvtel;
           this.sender = sender;
           this.content = content;
           this.recdate = recdate;
    }


    /**
     * Gets the total_num value for this MOBody.
     * 
     * @return total_num
     */
    public java.lang.String getTotal_num() {
        return total_num;
    }


    /**
     * Sets the total_num value for this MOBody.
     * 
     * @param total_num
     */
    public void setTotal_num(java.lang.String total_num) {
        this.total_num = total_num;
    }


    /**
     * Gets the this_num value for this MOBody.
     * 
     * @return this_num
     */
    public java.lang.String getThis_num() {
        return this_num;
    }


    /**
     * Sets the this_num value for this MOBody.
     * 
     * @param this_num
     */
    public void setThis_num(java.lang.String this_num) {
        this.this_num = this_num;
    }


    /**
     * Gets the recvtel value for this MOBody.
     * 
     * @return recvtel
     */
    public java.lang.String getRecvtel() {
        return recvtel;
    }


    /**
     * Sets the recvtel value for this MOBody.
     * 
     * @param recvtel
     */
    public void setRecvtel(java.lang.String recvtel) {
        this.recvtel = recvtel;
    }


    /**
     * Gets the sender value for this MOBody.
     * 
     * @return sender
     */
    public java.lang.String getSender() {
        return sender;
    }


    /**
     * Sets the sender value for this MOBody.
     * 
     * @param sender
     */
    public void setSender(java.lang.String sender) {
        this.sender = sender;
    }


    /**
     * Gets the content value for this MOBody.
     * 
     * @return content
     */
    public java.lang.String getContent() {
        return content;
    }


    /**
     * Sets the content value for this MOBody.
     * 
     * @param content
     */
    public void setContent(java.lang.String content) {
        this.content = content;
    }


    /**
     * Gets the recdate value for this MOBody.
     * 
     * @return recdate
     */
    public java.lang.String getRecdate() {
        return recdate;
    }


    /**
     * Sets the recdate value for this MOBody.
     * 
     * @param recdate
     */
    public void setRecdate(java.lang.String recdate) {
        this.recdate = recdate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MOBody)) return false;
        MOBody other = (MOBody) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.total_num==null && other.getTotal_num()==null) || 
             (this.total_num!=null &&
              this.total_num.equals(other.getTotal_num()))) &&
            ((this.this_num==null && other.getThis_num()==null) || 
             (this.this_num!=null &&
              this.this_num.equals(other.getThis_num()))) &&
            ((this.recvtel==null && other.getRecvtel()==null) || 
             (this.recvtel!=null &&
              this.recvtel.equals(other.getRecvtel()))) &&
            ((this.sender==null && other.getSender()==null) || 
             (this.sender!=null &&
              this.sender.equals(other.getSender()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              this.content.equals(other.getContent()))) &&
            ((this.recdate==null && other.getRecdate()==null) || 
             (this.recdate!=null &&
              this.recdate.equals(other.getRecdate())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getTotal_num() != null) {
            _hashCode += getTotal_num().hashCode();
        }
        if (getThis_num() != null) {
            _hashCode += getThis_num().hashCode();
        }
        if (getRecvtel() != null) {
            _hashCode += getRecvtel().hashCode();
        }
        if (getSender() != null) {
            _hashCode += getSender().hashCode();
        }
        if (getContent() != null) {
            _hashCode += getContent().hashCode();
        }
        if (getRecdate() != null) {
            _hashCode += getRecdate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MOBody.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "MOBody"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_num");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "total_num"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("this_num");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "this_num"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recvtel");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "recvtel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sender");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sender"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recdate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "recdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
