package com.geekz.app.handler;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.codec.digest.DigestUtils;

public class LicenseHandler {

	private String salt = "EXTREAMPOS";
	
	public static void main(String[] args) {
		LicenseHandler license = new LicenseHandler();
		license.checkLicense();
	}

	private String getLicense() throws SocketException, UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
		String computername = InetAddress.getLocalHost().getHostName();
		byte[] mac = networkInterface.getHardwareAddress();
		System.out.println("Mac - " + mac[0] + mac[1] +mac[2] +mac[3] +mac[4] +mac[5]);
		System.out.println("computerName = "+ computername);
		String machineUnique = mac[0] + mac[1] + salt +mac[2] +mac[3] + salt +mac[4] +mac[5]+ salt +computername;
		return this.encryptionData(machineUnique);
	}

	private String encryptionData(String value) {
		String encryptedText = DigestUtils.sha1Hex(value);
		System.out.println(encryptedText);
		return encryptedText;
	}
	
	public boolean checkLicense() {
		PropertiesHandler prop = new PropertiesHandler("propertiesFiles/pos.properties");
		String propertyLicense = prop.readFromPropertyFile("pos.license");
		try {
			if(propertyLicense.equals(this.getLicense())) {
				System.out.println("License is Acceptable.......");
				return true;
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Invalid License.");
		return false;
	}

}
