package com.geekz.app.handler;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class LicenseHandler {

	private String salt = "EXTREAMPOS";
	
	final static Logger logger = Logger.getLogger(LicenseHandler.class);
	
	public static void main(String[] args) {
		logger.info(">	License Validation Starts");
		LicenseHandler license = new LicenseHandler();
		license.checkLicense();
		logger.info(">	License Validation Finished");
	}

	private String getLicense() throws SocketException, UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
		String computername = InetAddress.getLocalHost().getHostName();
		byte[] mac = networkInterface.getHardwareAddress();
		logger.info("Mac Address = " + mac[0] + mac[1] +mac[2] +mac[3] +mac[4] +mac[5]);
		logger.info("Computer Name = "+ computername);
		String machineUnique = mac[0] + mac[1] + salt +mac[2] +mac[3] + salt +mac[4] +mac[5]+ salt +computername;
		return this.encryptionData(machineUnique);
	}

	private String encryptionData(String value) {
		String encryptedText = DigestUtils.sha1Hex(value);
		return encryptedText;
	}
	
	public boolean checkLicense() {
		PropertiesHandler prop = new PropertiesHandler("propertiesFiles/pos.properties");
		String propertyLicense = prop.readFromPropertyFile("pos.license");
		try {
			if(propertyLicense.equals(this.getLicense())) {
				logger.info("License is Acceptable.");
				return true;
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.error(">>>>> Invalid License <<<<<");
		return false;
	}

}
