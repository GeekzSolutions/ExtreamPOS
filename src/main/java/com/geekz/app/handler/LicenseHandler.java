package com.geekz.app.handler;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.apache.commons.codec.digest.DigestUtils;

public class LicenseHandler {

	public static void main(String[] args) {
		try {
			
			LicenseHandler license = new LicenseHandler();
			license.getLicense();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getLicense() throws SocketException, UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
		String computername = InetAddress.getLocalHost().getHostName();
		byte[] mac = networkInterface.getHardwareAddress();
		System.out.println("Mac - " + mac[0] + mac[1] +mac[2] +mac[3] +mac[4] +mac[5]);
		System.out.println("comuterName = "+ computername);
		String machineUnique = mac[0] + mac[1] +mac[2] +mac[3] +mac[4] +mac[5]+computername;
		this.encryptionData(machineUnique);
	}

	public void encryptionData(String value) {
		String encryptedText = DigestUtils.sha1Hex(value);
		System.out.println(encryptedText);
	}

}
