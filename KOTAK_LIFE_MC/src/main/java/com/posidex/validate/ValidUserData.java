package com.posidex.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.posidex.bean.KotakUser;
import com.posidex.bean.UserModel;
import com.posidex.exception.PosidexException;
import com.posidex.service.UserDataService;

@Component
public class ValidUserData {
	
	@Autowired 
	UserDataService validteUSerData;
	
	@Autowired
	EncryptDecryptExample decrypt;

	public UserModel getValidUserData(String username,String pwd) throws PosidexException
	{
		UserModel userModel=validteUSerData.getValidUserData(username);
   	 	final String secretKey = "P14p#445po@!gtAs";
   	 	if(userModel!=null) {
		String password=decrypt.decrypt(userModel.getPassword(), secretKey);
		if(password!=null) {
		System.out.println("Password decrypted here");
	//	System.out.println(password+"=================");
		System.out.println();
		System.out.println(userModel.getUserType()+" "+userModel.getPassword());
	
		
		if(userModel.getUserType().equals("A") && (pwd.equals(password)))
		{
			System.out.println("inside if condition***");
			return userModel;
		}
		else
			return null;
		}	
		else
			return null;
			
   	 	}
   	 	else return null;
	}
	
	public KotakUser getkotakUser(String username)
	{
		KotakUser user=validteUSerData.getKotakUSer(username);
		return user;
	}
	
}
