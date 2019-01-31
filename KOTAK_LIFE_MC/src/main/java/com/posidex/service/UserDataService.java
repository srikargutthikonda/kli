package com.posidex.service;

import com.posidex.bean.KotakUser;
import com.posidex.bean.UserModel;

public interface UserDataService {

public UserModel getValidUserData(String username);
public KotakUser getKotakUSer(String kotakUsername);


	
}
