package com.geekz.app.handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesHandler {
	
	URL strFilePath = null;
	Properties prop = new Properties();
	InputStream input = null;
	OutputStream output = null;

	public PropertiesHandler(String filePath) {
		strFilePath = getClass().getClassLoader().getResource(filePath);
	}
	
	public String readFromPropertyFile(String key) {
		try {
			input = new FileInputStream(strFilePath.getPath());
			prop.load(input);
			return prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public void writeToPropertyFile(String key, String value) {
		try {
			output = new FileOutputStream(strFilePath.getPath());
			prop.setProperty(key,value);
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}
	
}
