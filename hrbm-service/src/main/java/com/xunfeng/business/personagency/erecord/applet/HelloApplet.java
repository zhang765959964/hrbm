package com.xunfeng.business.personagency.erecord.applet;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Administrator on 2015/8/14.
 */
public class HelloApplet extends JApplet {
    Image myImage;
    public void init() {
        try {
            this.setSize(new Dimension(1000, 1000));
            //setBackground(Color.red);
            String filePath="file:/D:/test1/";//getParameter("filePath");
            String fileName="Img1439541673000.bmp";//getParameter("fileName");
            URL ffff=new URL(filePath);
             myImage=getImage(ffff,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void paint(Graphics g) {
        URL ds=this.getDocumentBase();
        //g.drawString("Hello,Defonds!"+ffff, 800, 800);
        g.drawImage(myImage, 10, 10,800,800, this);
    }
}
