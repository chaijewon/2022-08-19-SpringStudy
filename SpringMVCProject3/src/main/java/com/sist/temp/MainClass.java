package com.sist.temp;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class MainClass {

	public static void main(String[] args) {
		//알고리즘
		String alg = "AES/CBC/PKCS5Padding";
		//키
		String aesKey = "abcdefghabcdefghabcdefghabcdefgh"; //32byte

		String aesIv = "0123456789abcdef"; //16byte

		//암호화 할 유저 아이디
		String userId ="abc123";
		
		//암호화된 유저 아이디
		String encId="";

		
		//알고리즘 aes-256 **********[암호화]**********
		try {

			Cipher cipher = Cipher.getInstance(alg);

			//키로 비밀키 생성
			SecretKeySpec keySpec = new SecretKeySpec(aesKey.getBytes(), "AES");
			//iv 로 spec 생성
			IvParameterSpec ivParamSpec = new IvParameterSpec(aesIv.getBytes());
			//암호화 적용
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

			//암호화 실행
			byte[] encrypted1 = cipher.doFinal(userId.getBytes("UTF-8")); // ID 암호화(인코딩 설정)
			encId = Base64.getEncoder().encodeToString(encrypted1); // 암호화 인코딩 후 저장

			System.out.println("암호화된 유저 아이디 -> " + encId);

		}catch (Exception e) {
			System.out.println("암호화 중 오류 발생 ");
			e.printStackTrace();
		}
		//---------------------------------------------------------------------------


		
		
		
		
		
		
		//----암호화 해석 코드 **********[복호화]**********
		try {
			Cipher cipher = Cipher.getInstance(alg);

			SecretKeySpec keySpec = new SecretKeySpec(aesKey.getBytes(), "AES");
			IvParameterSpec ivParamSpec = new IvParameterSpec(aesIv.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);
			
				//암호 해석
				byte[] decodedBytes = Base64.getDecoder().decode(encId);
				byte[] decrypted = cipher.doFinal(decodedBytes);
				String result = new String(decrypted);
				
				
				System.out.println("복호화한 유저 아이디 -> " + result);

		}catch (Exception e) {
			e.printStackTrace();
		}
		//---------------------------------------------------------------------------

	}


}
