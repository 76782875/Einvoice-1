package com.park.einvoice.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamTools {
	
	public static String File2String(String fileUrl){
		String fileString = null;
		try {
			@SuppressWarnings("resource")
			InputStream inStream = new FileInputStream(new File(fileUrl));
			int len = 0;
			StringBuffer sBuffer = new StringBuffer();
			while((len = inStream.read()) != -1){
				sBuffer.append((char)len);
			}
			fileString = sBuffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileString;
	}
	
}
