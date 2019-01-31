package com.posidex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posidex.bean.KotakUser;
import com.posidex.bean.UserModel;
import com.posidex.dao.USerDataDao;
@Service
public class UserDataServiceImpl implements UserDataService{

	@Autowired
	USerDataDao validateUSerDao;
	@Override
	public UserModel getValidUserData(String username) {
		// TODO Auto-generated method stub
		
		UserModel model=validateUSerDao.getValidUserData(username);
		return model;
	}
	@Override
	public KotakUser getKotakUSer(String kotakUsername) {
		// TODO Auto-generated method stub
		KotakUser user= validateUSerDao.getKotakUSer(kotakUsername);
		return user;
	}

}
