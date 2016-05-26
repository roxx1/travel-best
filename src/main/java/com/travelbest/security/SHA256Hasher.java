package com.travelbest.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Hasher {

	private static String byteArrayToString(final byte[] array) {
		StringBuilder result = new StringBuilder();
		for (byte b : array)
			result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));

		return result.toString();
	}

	public static String hash(final String text) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(text.getBytes());

		return byteArrayToString(md.digest());
	}

	public static boolean verify(final String text, final String hash) {
		return hash(text).equals(hash);
	}

}
