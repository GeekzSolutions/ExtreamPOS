package com.geekz.app.handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesHandler {
	
	URL strFilePath = null;
	Properties prop = new Properties();
	InputStream input = null;
	OutputStream output = null;

	final static Logger logger = Logger.getLogger(PropertiesHandler.class);
	
	public PropertiesHandler(String filePath) {
		logger.info("read properties file - " + filePath);
		strFilePath = getClass().getClassLoader().getResource(filePath);
	}
	
	public String readFromPropertyFile(String key) {
		try {
			input = new FileInputStream(strFilePath.getPath());
			prop.load(input);
			logger.info("load the properties file.");
			String value = prop.getProperty(key);
			logger.info("read "+ key + " - " + value);
			return value;
		} catch (IOException ex) {
			logger.error(ex);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
		return null;
	}

	public void writeToPropertyFile(String key, String value) {
		try {
			output = new FileOutputStream(strFilePath.getPath());
			logger.info("load the properties file.");
			prop.setProperty(key,value);
			logger.info("write "+ key + " - " + value);
			prop.store(output, null);
			logger.info("Save the properties file.");

		} catch (IOException io) {
			logger.error(io);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}

		}
	}
	
}
