package com.posidex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.posidex.bean.DedupeInputBean;
import com.posidex.bean.DropDownBean;
import com.posidex.bean.UrlRequest;
import com.posidex.bean.UserRole;
import com.posidex.dao.IValidateUserDao;

@Service
public class ServiceImpl implements IValidateService{

	@Autowired
	IValidateUserDao dao;
	@Override
	public UserRole validate(UrlRequest request) {
		// TODO Auto-generated method stub
		 UserRole userData=dao.validate(request);
		return userData;
	}
	@Override
	public DedupeInputBean getData(String id) {
		// TODO Auto-generated method stub
		DedupeInputBean list=dao.getData(id);
		return list;
	}
	@Override
	public DropDownBean getDropDownList(String Propsal_ID) {
		// TODO Auto-generated method stub
		DropDownBean dropDList=dao.getDropDownList(Propsal_ID);
		return dropDList;
	}
	@Override
	public String checkVerifiedColumn(String id) {
		// TODO Auto-generated method stub
		String status=dao.checkVerifiedColumn(id);
		
		
		
		return status;
	}

}
