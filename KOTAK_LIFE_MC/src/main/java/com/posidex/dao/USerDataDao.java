package com.posidex.dao;


import com.posidex.bean.KotakUser;
import com.posidex.bean.UserModel;

public interface USerDataDao {
	
public UserModel getValidUserData(String username);
public KotakUser getKotakUSer(String kotakUsername);

}
