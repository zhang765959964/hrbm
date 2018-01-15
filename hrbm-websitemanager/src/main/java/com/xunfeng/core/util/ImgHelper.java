/**
 * 
 */
package com.xunfeng.core.util;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageOutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * Description：用此类将图片转换为字符串，以便将图片封装为JSON进行传输
 * @author 河伯
 * @Date 2014-05-27
 * @version 1.0
 * */
public class ImgHelper {
    
    /**
     * TODO:将byte数组以Base64方式编码为字符串
     * @param bytes 待编码的byte数组
     * @return 编码后的字符串
     * */
    public static String encode(byte[] bytes){
        return new BASE64Encoder().encode(bytes);
    }
    
    /**
     * TODO:将以Base64方式编码的字符串解码为byte数组
     * @param encodeStr 待解码的字符串
     * @return 解码后的byte数组
     * @throws IOException 
     * */
    public static byte[] decode(String encodeStr) throws IOException{
        byte[] bt = null;  
        BASE64Decoder decoder = new BASE64Decoder();  
        bt = decoder.decodeBuffer(encodeStr);
        return bt;
    }
    
    /**
     * TODO:将以Base64方式编码的字符串解码为byte数组
     * @param encodeStr 待解码的字符串
     * @return 解码后的byte数组
     * @throws IOException 
     * */
    public static InputStream decodeIo(String encodeStr) throws IOException{
        byte[] bt = null;  
        BASE64Decoder decoder = new BASE64Decoder();  
        bt = decoder.decodeBuffer(encodeStr);
        InputStream sbs = new ByteArrayInputStream(bt);
        return sbs;
    }
    
    /**
     * TODO:将两个byte数组连接起来后，返回连接后的Byte数组
     * @param front 拼接后在前面的数组
     * @param after 拼接后在后面的数组
     * @return 拼接后的数组
     * */
    public static byte[] connectBytes(byte[] front, byte[] after){
        byte[] result = new byte[front.length + after.length];
        System.arraycopy(front, 0, result, 0, after.length);
        System.arraycopy(after, 0, result, front.length, after.length);
        return result;
    }
    
    /**
     * TODO:将图片以Base64方式编码为字符串
     * @param imgUrl 图片的绝对路径（例如：D:\\jsontest\\abc.jpg）
     * @return 编码后的字符串
     * @throws IOException 
     * */
    public static String encodeImage(String imgUrl) throws IOException{
        FileInputStream fis = new FileInputStream(imgUrl);
        byte[] rs = new byte[fis.available()];
        fis.read(rs);
        fis.close();
        return encode(rs);
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str="/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAB+AGYDASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD36iiigAorI17XotDthI6F3YHaO1ebat8VRdRNbG3aEkYJRiCD9apRbIlNI9KvvEul6dOYbm4CuOoAzWDefEbSor6K3jkIVm2tIRx04/XFeCazq891csxupCBwCTnNYkt88i7HckZzVqCM3UbPoqH4n6dPdfZ0k+cSbDleDx1/UV0Vt4otJI7h5crHA21peMMfavlBboJKXVsEnOa6ibxhcf2Lb2UT7VC/OQepyafKgU2j6Ni8UaPKMi9jUH+8cVqQzxXEYkhkV1PQqc18gf2jM758w/XNdv4L8fXug3SxyES2rEBwzHp7e9S4di1U7n0ZRWbo2t2euWK3No4IP3kJ5U+9aVZmgUUUUAFMmlWCF5XOFQZJp9cN8UteudF8MGO2j+a7JiMn93jPHv8A5+rSuxN2VzjfGPiw38zbpAIlPyIW6fUV5Zqmp/aJGIwMnPArOuLuaeQlySTUBU1skczGyXDtxULlupqYgAZNQyMzfSgm5EXIoWU4prA03igLlqOZs4rRtpBnOM1lQ7c89KuowU5U8UDTPWvhlqBt9VhigYxySEKyL0ce/wBK96r5P8Oa4+nX8M8fEsZyp/p9K+o9J1GDVtMgvLd96SKMnGOe9ZzN6b6F2iiioNArk/iPCJvBl0MDIKkE11lYHjOFbjwxdRt93gmmtyZfCz5KkIDkik3/AC5p+o7RfypF9wNhc+lOEG5BitjmWpUd9xxQUfaNo61qR6WGCtjqa17bRka6VGX5dp7d6lysaxpXORMDkDjnvTGtnHUV28WiKxmUryjDPHr/APqp0/h/Jban8BYcVPtEU6D6HDpFhgGHWrwiAXArRutJMTL8vOOKrFWUHPUVakmZypuO5NpoC3cK99w/nX1P4Ptja+GrVT/GC/5818yeGLc6h4jtbUIHeRsKCO/rX1fYW32LT4LYEny0C5NTPYqlvcs0UUVmbBVXU4km0u6jkUMrRNkEexq1UdxGZbaWMdXQqPxFAHxlf/8AH/L/ALLsv5HFXdPTzVJPaotQhzrl9b7SGS5dCCPRiK6XTdFdVRUUZI5zWk5WMqcXJk2m2nnKFI6V0+n6M0kqyFOnIpmn+GpuT9qaIn+6RXRadZ3lhhZLh5sH+IiuaUjthDUrjQlR5G28yHLcelQy6eqfeHAUr+BrpZppSp2xgDHBzXOXmn6zdP5kdwixn+AnFZ7mzVjCvNNhmmz1xx0rh/EFq1leFFGEbkV6Dd2l/anEiruPXDZrnPFFm0tkk7D514rSm2pWZhVhzRuT/Bu2jvPH0DOP9TC8in3GP8a+lK8C+BltAniW+kkDGb7P+5I6Dn5v6V77W89zlhGyCiiipLCiiigD5v8AiB4aGk+ObiaL5YpnEoGf7x/xzWxaqvkcff7Vs/FOFJdUjkX5iVTkc/dNZOkhZXU1lNts6aMEloD2OpXECtBcSo+4ZUOVGO/Qiukh821swZJHfAUAt16Y/XrWhbQoIwBVDXJ9ipCD1/xrNvQ35bMnS8YwLk1n61FqUkBawndGJG3B4xUqRv8AZAcdK1NNkFxbKG/h4pLQbVzlY4NSiSFLqVp3K5kZuNp9qzPEkK/2fKOw5rv76GPy8+lcdqkccxMbjKntilze9cUoe7Y6X4P+Hhpuiz6g64kuXwPYDivSqqaXbxWumW0MIwixjH5VbrrPPStoFFFFAHmNz471J4Xw8ceTxsTBH51zq+LLiOZ2lu5nYg5zIetc5fagzJwecZrmbjUCJizNg5oRDZ2F9rbXiq07EKoxU2kXW0KVPXpXnt1qM0sbvvPlqcYz1966Hw5eiWziJbJA5pVI6XNqFT3rHrmm3JkjGTWdraSyXYeJQxXpk1U028IjGDVmbUoUbbI+GrmSuejux/2rUH01Y47aPzuN+WIHvzWhpJZYTvQIx5wKoR6tCyBRJxViK9Rj8rZPtRJWG1YfqN2UDDNcjd6gkNyrO2D2rY1S4BJya8t8Xam4vY4YZCCAckeuaqlHmZz1qlonrOm+PL61VIkdJIgc7XXJx6A12+i+MLXVH8qZPs8vbJ+VvpXzl4d1oRxt9qJYqcbjXaaPrlu1zkvkBsc10NNHCpJnvvWiuX07xPaLDh5zIvbPailcZ8+zybVBJ5xXN3QZ2fIPXjitq5DSfxHjtVQYPyvWyjY53K5nTAR6SEP3mINW/DU7RLIOwYVU1COR3QKPkUYrS8PWyszIehOabjdWCEuWVzvtJvNygA1oTW6XEu4xq5965dPOsJgUU7Pauk07VrZ8F3Kn3GK4pRcWepSq31JfsqAbfsoB9gant4zbglVAq6dWsQuDLzWTe6qjMUt9zMenHFZu73NXO5R1e+wWGecGvKdYeV9Tld+pOR9CM16PfwObcvKMTHpXBa3ERqG0j7qgH6gCumgrK5wYiWtgs1D6XIT97cCal0+6aCQHJyTyO1V7GUJJ5Tf6tjzWvLDbx8RAE+uK3auc0XY7PTbnzbbcNo/GiuWs55Y4cbyvtRU8hXORyBuoqo6AnJ+9WttDLVea3TG7vWpkZwAb5X6EVf0VEhuOe5qjd/u/LI7ipI5GVA4OCDkUCseiLZiaJSR8xFV30SPd8y8/SoPDmrz3ARJAGOPvE11MqA4fvWFVaXOyh2MGPQ4e4/Sr8VpBaRZHUdOKmaRhUyRK9s8j8kKSAa54LndjrnaMbmDqPEbXEpJOMIjdPrXmmquXu3ctliec16DqNw9xb/Oc7IzivMbqZpJWY9Sa74wSieXOpzzHwxF1VgRncOM1uJDn5sVhWK5uFNdMgwlJAxgBoqSiqIP/2Q==";
        try {
        	byte[] bt = decode(str);
        	String newFilename="E:\\1.png";
        	FileImageOutputStream imgout=new FileImageOutputStream(new File(newFilename));
        	imgout.write(bt,0,bt.length);
        	imgout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}