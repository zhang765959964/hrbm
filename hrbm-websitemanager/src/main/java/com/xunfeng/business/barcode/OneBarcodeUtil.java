package com.xunfeng.business.barcode;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code128Encoder;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

public class OneBarcodeUtil {

	public static void main(String[] paramArrayOfString) {
		try {
			JBarcode localJBarcode = new JBarcode(Code128Encoder.getInstance(),
					WidthCodedPainter.getInstance(),
					EAN8TextPainter.getInstance());
			String str = "JAR_2219644JAR_2219644";
			BufferedImage localBufferedImage = localJBarcode.createBarcode(str);

			saveToJPEG(localBufferedImage, "CODE128B.jpg");
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}

	static void saveToJPEG(BufferedImage paramBufferedImage, String paramString) {
		saveToFile(paramBufferedImage, paramString, "jpeg");
	}

	static void saveToFile(BufferedImage paramBufferedImage,
			String paramString1, String paramString2) {
		try {
			FileOutputStream localFileOutputStream = new FileOutputStream(
					"C:\\Users\\Administrator\\Desktop/" + paramString1);
			ImageUtil.encodeAndWrite(paramBufferedImage, paramString2,
					localFileOutputStream, 96, 96);
			localFileOutputStream.close();
		} catch (Exception localException) {
			localException.printStackTrace();
		}
	}
}
