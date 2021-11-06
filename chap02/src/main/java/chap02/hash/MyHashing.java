package chap02.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyHashing {
	
	public static String hash(String password) {

		try {
			MessageDigest  sha256 = MessageDigest.getInstance("SHA-256");
			StringBuilder hashValue = new StringBuilder();
			
			for (byte b : sha256.digest(password.getBytes())) {
				hashValue.append(String.format("02%x", b));
			}
			
			System.out.println("SHA-256 °á°ú : " + hashValue);
			return hashValue.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		MyHashing.hash("1234");
	}

}
