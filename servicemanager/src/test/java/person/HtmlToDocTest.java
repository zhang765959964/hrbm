//package person;
//
//import org.apache.poi.poifs.filesystem.DirectoryEntry;
//import org.apache.poi.poifs.filesystem.DocumentEntry;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//
//import java.io.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
///**
// * Created by Administrator on 2015/12/11.
// */
//public class HtmlToDocTest {
//
//    /**
//     * ��ȡhtml�ļ���word
//     * @param filepath html�ļ���·��
//     * @return
//     * @throws Exception
//     */
//    public boolean writeWordFile(String filepath) throws Exception {
//        boolean flag = false;
//        ByteArrayInputStream bais = null;
//        FileOutputStream fos = null;
//        String path = "D:/test";  //����ʵ�����д·��
//        try {
//            if (!"".equals(path)) {
//                File fileDir = new File(path);
//                if (fileDir.exists()) {
//                    String content = readFile(filepath);
//                    byte b[] = content.getBytes();
//                    bais = new ByteArrayInputStream(b);
//                    POIFSFileSystem poifs = new POIFSFileSystem();
//                    DirectoryEntry directory = poifs.getRoot();
//                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
//                    fos = new FileOutputStream(path + "temp.doc");
//                    poifs.writeFilesystem(fos);
//                    bais.close();
//                    fos.close();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(fos != null) fos.close();
//            if(bais != null) bais.close();
//        }
//        return flag;
//    }
//
//    /**
//     * ��ȡhtml�ļ����ַ���
//     * @param filename
//     * @return
//     * @throws Exception
//     */
//    public String readFile(String filename) throws Exception {
//        StringBuffer buffer = new StringBuffer("");
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(filename));
//            buffer = new StringBuffer();
//            while (br.ready())
//                buffer.append((char) br.read());
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(br!=null) br.close();
//        }
//        return buffer.toString();
//    }
//
//    public static void main(String[] args) throws Exception {
//
////        new HtmlToDocTest().writeWordFile("E:/project/colleges_employment/zzweb/my resume.html");
//
////       Date startDate= TimeUtil.getDate(2015, 12, 28, 8, 30, 0);
////        Date endDate= TimeUtil.getDate(2015, 12, 28, 10, 30, 10);
////        Long dsds=endDate.getTime()-startDate.getTime();
////        Long ddsds=dsds/60/30/1000;
////        String ssds="";
////          String password="/person/dff/fgf/gfg/gf";
////          boolean sds=password.matches("/person/([a-zA-Z0-9\\&%_\\./-~-]*)?");
////          String sdsd="";
//
//
//        String s=new String("所得税<p>ss大苏打333<span>asd</span></p>");//用GBK编码
//        String sdsds=removeHtmlTag(s);
//        String sdsdsdsd="";
//    }
//    public static String removeHtmlTag(String content) {
//        Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>");
//        Matcher m = p.matcher(content);
//        if (m.find()) {
//            content = content.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
//            content = removeHtmlTag(content);
//        }
//        return content;
//    }
//
//}
