/**   
 *  
 */

package com.xunfeng.business.personagency.erecord.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyFrame extends Applet {
	boolean isStandalone = false;
	TextField fileNameField;
	TextArea fileArea;

	// Get a parameter value
	public String getParameter(String key, String def) {
		return isStandalone ? System.getProperty(key, def) : (getParameter(key) != null ? getParameter(key) : def);
	}

	// Construct the applet
	public MyFrame() {
	}

	// Initialize the applet
	public void init() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Component initialization
	private void jbInit() throws Exception {
		this.setSize(new Dimension(1000, 1000));
		this.setLayout(new BorderLayout());
		Panel panel = new Panel();
		Label label = new Label("File Name");
		panel.add(label);
		fileNameField = new TextField(25);
		panel.add(fileNameField);
		JButton b = new JButton("Open File");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFile(fileNameField.getText());
			}
		});
		panel.add(b);
		this.add(panel, BorderLayout.NORTH);
		fileArea = new TextArea();
		this.add(fileArea, BorderLayout.CENTER);
	}

	public void loadFile(String fileName) {
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			String context = new String();
			while ((context = reader.readLine()) != null) {
				fileArea.append(context + "/n");
			}
			reader.close();
		} catch (IOException ie) {
			fileArea.append(ie.getMessage());
		} catch (SecurityException se) {
			fileArea.append("because of security constraint ,it can not do that!");
		}
	}

	// Get Applet information
	public String getAppletInfo() {
		return "This is an applet can read and write the local file system";
	}
}