package challenge._03;

import java.util.Scanner;

public class DailyChallenge03Easy {
	
	final private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private final static int key = 2;
	
	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Please enter some text to be securityfied.");
		String plainText = kb.nextLine().toLowerCase();
		kb.close(); 
		String cipherText = ceaserCipherEncrypt(key, plainText, alphabet);
		System.out.println(cipherText.toUpperCase());
		System.out.println(ceaserCipherDecrypt(key, cipherText, alphabet));
	}
	
	public static String  ceaserCipherEncrypt(int key, String plainText, char[] alphabet) {

		char[] plain = plainText.toCharArray();
		String cipherText = "";
		
		for (int j = 0; j < plain.length; j++) {
			for (int i = 0; i < alphabet.length; i++) {
				if(plain[j] == alphabet[i]) {
					if(i + key > 25) {
						cipherText += alphabet[(i + key) - 26];
					}else {
						cipherText += alphabet[i + key];	
					}
				}
			}
		}
		return cipherText;
	}
	
	public static String ceaserCipherDecrypt(int key, String cipherText, char[] alphabet) {
		
		char[] cipher = cipherText.toCharArray();
		String plainText = "";
		
		for (int j = 0; j < cipher.length; j++) {
			for (int i = 0; i < alphabet.length; i++) {
				if(cipher[j] == alphabet[i]) {
					if(i - key < 0) {
						plainText += alphabet[(i - key) + 26];
					}else {
						plainText += alphabet[i - key];	
					}
				}
			}
		}
		return plainText;
	}
}
