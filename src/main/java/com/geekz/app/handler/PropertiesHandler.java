package com.geekz.app.handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesHandler {

	Properties prop = new Properties();
	InputStream input = null;
	OutputStream output = null;

	public String readFromPropertyFile(String file, String key) {
		try {
			input = new FileInputStream(getClass().getClassLoader().getResource(file).toString());
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

	public void writeToPropertyFile(String file, String key, String value) {
		try {
			output = new FileOutputStream(getClass().getClassLoader().getResource(file).toString());
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
